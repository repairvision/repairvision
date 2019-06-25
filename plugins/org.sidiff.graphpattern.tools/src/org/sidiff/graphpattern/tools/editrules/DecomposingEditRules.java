package org.sidiff.graphpattern.tools.editrules;

import static org.sidiff.graphpattern.profile.henshin.HenshinStereotypes.create;
import static org.sidiff.graphpattern.profile.henshin.HenshinStereotypes.delete;
import static org.sidiff.graphpattern.profile.henshin.HenshinStereotypes.preserve;
import static org.sidiff.graphpattern.profile.henshin.HenshinStereotypes.rule;
import static org.sidiff.graphpattern.tools.editrules.DecomposingEditRulesUtil.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IResource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;
import org.sidiff.common.emf.modelstorage.EMFHandlerUtil;
import org.sidiff.consistency.common.ui.util.WorkbenchUtil;
import org.sidiff.csp.solver.ICSPSolver;
import org.sidiff.csp.solver.IConstraintSatisfactionProblem;
import org.sidiff.csp.solver.impl.CSPSolver;
import org.sidiff.csp.solver.impl.ConstraintSatisfactionProblem;
import org.sidiff.csp.solver.impl.Variable;
import org.sidiff.graphpattern.Bundle;
import org.sidiff.graphpattern.EdgePattern;
import org.sidiff.graphpattern.GraphElement;
import org.sidiff.graphpattern.GraphPattern;
import org.sidiff.graphpattern.GraphpatternFactory;
import org.sidiff.graphpattern.NodePattern;
import org.sidiff.graphpattern.Pattern;
import org.sidiff.graphpattern.SubGraph;
import org.sidiff.graphpattern.profile.henshin.util.HenshinProfileUtil;
import org.sidiff.graphpattern.tools.csp.GraphPatternMatch;
import org.sidiff.graphpattern.tools.csp.GraphPatternMatchings;
import org.sidiff.graphpattern.tools.csp.NodePatternVariable;
import org.sidiff.graphpattern.tools.editrules.csp.EditNodePatternDomain;

public class DecomposingEditRules extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IStructuredSelection selection = HandlerUtil.getCurrentStructuredSelection(event);
		Bundle complexEditRulesBundle = null;
		Bundle basicEditRulesBundle = null;
		
		try {
			if (selection.size() == 2) {
				for (Object selected : selection.toList()) {
					if (selected instanceof IResource) {
						Bundle bundle = EMFHandlerUtil.loadResource((IResource) selected, Bundle.class, new ResourceSetImpl());
						
						if (bundle.eResource().getURI().lastSegment().matches(".*?\\.basic.*?\\.graphpattern")) {
							basicEditRulesBundle = bundle;
						} else {
							complexEditRulesBundle = bundle;
						}
					}
				}
			} 
			
			if ((complexEditRulesBundle == null) || (basicEditRulesBundle == null)) {
				throw new ExecutionException("Missing Bundle");
			} else {
				// Clean up existing sub graphs:
				if (WorkbenchUtil.showQuestion("Clear existing decompositions from bundle?")) {
					for (Pattern complexEditRulePattern : complexEditRulesBundle.getPatterns()) {
						complexEditRulePattern.getAllGraphPatterns().forEach(graph -> {
							graph.getSubgraphs().forEach(DecomposingEditRulesUtil::clearSubGraphElements);
							graph.getSubgraphs().clear();
						});
					}
				}
				
				// Calculate decomposition:
				decompose(complexEditRulesBundle, basicEditRulesBundle);
				
				// Save decomposition in complex edit rule bundle:
				complexEditRulesBundle.eResource().save(Collections.emptyMap());
			}
			
			return null;
		} catch (Exception e) {
			WorkbenchUtil.showErrorWithException(
					"Select a bundle with complex and basic (*.basic.graphpattern) edit rules"
					+ " to decompose the complex into the basic rules.",
					this, e);
			throw new ExecutionException(e.getMessage(), e);
		}
	}

	private void decompose(Bundle complexEditRulesBundle, Bundle basicEditRulesBundle) {
		List<GraphPattern> basicEditRuleGraphs = basicEditRulesBundle.getPatterns()
				.stream().flatMap(p-> p.getAllGraphPatterns().stream()).collect(Collectors.toList()); 
		
		for (Pattern complexEditRulePattern : complexEditRulesBundle.getPatterns()) {
			decompose(complexEditRulePattern, basicEditRuleGraphs);
		}
	}
	
	private void decompose(Pattern complexEditRulePattern, List<GraphPattern> basicEditRuleGraphs) {
		for (Pattern complexEditRuleSubPattern : complexEditRulePattern.getSubpatterns()) {
			decompose(complexEditRuleSubPattern, basicEditRuleGraphs);
		}
		
		for (GraphPattern complexEditRuleGraph : complexEditRulePattern.getGraphs()) {
			for (GraphPattern basicEditRuleGraph : basicEditRuleGraphs) {
				decompose(complexEditRuleGraph, basicEditRuleGraph);
			}
		}
	}
	
	private void decompose(GraphPattern complexEditRuleGraph, GraphPattern basicEditRuleGraph) {
		
		// Compares only rules
		if (!complexEditRuleGraph.getStereotypes().contains(rule) || !basicEditRuleGraph.getStereotypes().contains(rule)) {
			return;
		}
		
		// Match basic rule into complex rule:
		int complexRuleSize = complexEditRuleGraph.getNodes().size();
		int basicRuleSize = basicEditRuleGraph.getNodes().size();
		
		if (complexRuleSize > basicRuleSize) {
			IConstraintSatisfactionProblem<NodePattern, NodePattern> problem = new ConstraintSatisfactionProblem<>(basicRuleSize);
			problem.setMinimumSolutionSize(basicRuleSize);
			problem.setMaximumSolutionSize(basicRuleSize);
			problem.setSearchMaximumSolutions(true);
			problem.setSearchInjectiveSolutions(true);
			
			for (NodePattern basicEditRuleNode : basicEditRuleGraph.getNodes()) {
				EditNodePatternDomain domain = new EditNodePatternDomain(basicEditRuleNode, complexEditRuleGraph.getNodes(), true, false);
				
				// NOTE: Optimization:
				if (domain.isEmpty()) {
					return;
				}
				
				Variable<NodePattern, NodePattern> variable = new NodePatternVariable(basicEditRuleNode, domain, false);
				problem.addVariable(variable);
			}
			
			GraphPatternMatchings matchings = new GraphPatternMatchings(basicEditRuleGraph, complexEditRuleGraph);
			ICSPSolver<NodePattern, NodePattern> solver = new CSPSolver<>(problem, matchings);
			solver.run();
			
			for (GraphPatternMatch match : matchings.getMatches()) {
				decompose(complexEditRuleGraph, basicEditRuleGraph, match.getMatch());
			}
		}
	}
	
	private void decompose(GraphPattern complexEditRuleGraph, GraphPattern basicEditRuleGraph, Map<NodePattern, NodePattern> basicToComplexMatch) {
		assert (new HashSet<>(basicToComplexMatch.values()).size() == basicToComplexMatch.values().size()); // injective matching
		
		// Maximize change sets of decomposition:
		List<SubGraph> containedSubGraphs = findContainedChangeSets(complexEditRuleGraph, basicToComplexMatch);

		// Create new sub graph if new sub graph has no other conflicting overlappings:
		if (!hasOverlappingChanges(complexEditRuleGraph, basicToComplexMatch, containedSubGraphs)) {
			
			// Remove contained sub graphs:
			for (SubGraph containedSubGraph : containedSubGraphs) {
				clearSubGraphElements(containedSubGraph);
				complexEditRuleGraph.getSubgraphs().remove(containedSubGraph);
			}
			
			// Insert new sub graph:
			SubGraph subGraph = GraphpatternFactory.eINSTANCE.createSubGraph();
			subGraph.setName(DecomposingEditRulesUtil.generateHierarchicalName(basicEditRuleGraph));
			complexEditRuleGraph.getSubgraphs().add(subGraph);
			
			SubGraph contextSubGraph = GraphpatternFactory.eINSTANCE.createSubGraph();
			contextSubGraph.setName("context");
			contextSubGraph.getStereotypes().add(preserve);
			subGraph.getSubgraphs().add(contextSubGraph);
			
			SubGraph changesSubGraph = GraphpatternFactory.eINSTANCE.createSubGraph();
			changesSubGraph.setName("changes");
			changesSubGraph.getStereotypes().add(create);
			changesSubGraph.getStereotypes().add(delete);
			subGraph.getSubgraphs().add(changesSubGraph);
			
			for (NodePattern basicSubGraphNode : basicToComplexMatch.keySet()) {
				NodePattern complexSubGraphNode = basicToComplexMatch.get(basicSubGraphNode);
				
				// Store nodes:
				if (HenshinProfileUtil.isChange(basicSubGraphNode)) {
					changesSubGraph.getElements().add(complexSubGraphNode);
				} else {
					contextSubGraph.getElements().add(complexSubGraphNode);
				}
				
				// Store edges:
				for (EdgePattern basicSubGraphEdge : basicSubGraphNode.getOutgoings()) {
					EdgePattern complexSubGraphEdge = getComplexEdgeMatch(basicSubGraphEdge, basicToComplexMatch);

					if (HenshinProfileUtil.isChange(complexSubGraphEdge)) {
						changesSubGraph.getElements().add(complexSubGraphEdge);
					} else {
						contextSubGraph.getElements().add(complexSubGraphEdge);
					}
				}
			}
		}
	}

	private List<SubGraph> findContainedChangeSets(GraphPattern complexEditRuleGraph, Map<NodePattern, NodePattern> basicToComplexMatch) {
		List<SubGraph> matchingSubGraphs = new ArrayList<>(1); 
		int[] changeAndContextSize = getChangeAndContextSize(basicToComplexMatch);
		
		for (SubGraph subGraph : complexEditRuleGraph.getSubgraphs()) {
			if (getSubGraphChanges(subGraph).size() <= changeAndContextSize[0]) {
				
				// For equal sized sub graph change sets (to be replaced), prefer ro keep the one with the smaller context:
				if (!(getSubGraphChanges(subGraph).size() == changeAndContextSize[0]) 
						|| (changeAndContextSize[1] < getSubGraphContext(subGraph).size())) {
					
					if (isContainedOrEqualChangeSet(subGraph, basicToComplexMatch)) {
						matchingSubGraphs.add(subGraph);
					}
				}
			}
		}
		
		return matchingSubGraphs;
	}
	
	private int[] getChangeAndContextSize(Map<NodePattern, NodePattern> basicToComplexMatch) {
		int changeSize = 0;
		int contextSize = 0;
		
		for (NodePattern basicNode : basicToComplexMatch.keySet()) {
			if (HenshinProfileUtil.isChange(basicNode)) {
				++changeSize;
			} else if (HenshinProfileUtil.isContext(basicNode)) {
				++contextSize;
			}
			
			for (EdgePattern basicEdge : basicNode.getOutgoings()) {
				if (HenshinProfileUtil.isChange(basicEdge)) {
					++changeSize;
				} else if (HenshinProfileUtil.isContext(basicEdge)) {
					++contextSize;
				}
			}
		}
		
		return new int[] {changeSize, contextSize};
	}
	
	private boolean isContainedOrEqualChangeSet(SubGraph complexSubGraph, Map<NodePattern, NodePattern> basicToComplexMatch) {
		
		// containedComplexSubGraph <= basicToComplexMatch
		for (GraphElement complexChange : getSubGraphChanges(complexSubGraph)) {
			if (complexChange instanceof NodePattern) {
				
				// complex sub graph node exist in basic rule?
				if (!basicToComplexMatch.values().contains(complexChange)) {
					return false;
				}
			} else if (complexChange instanceof EdgePattern) {
				
				// complex sub graph edge exist in basic rule?
				if (getBasicEdgeMatch((EdgePattern) complexChange, basicToComplexMatch) == null) {
					return false;
				}
			}
		}
		return true;
	}
	
	private boolean hasOverlappingChanges(GraphPattern editRuleGraph, Map<NodePattern, NodePattern> basicToComplexMatch, List<SubGraph> ignoredSubGraphs) {
		
		for (NodePattern basicSubGraphNode : basicToComplexMatch.keySet()) {
			
			// Check change nodes of basic sub graph:
			if (HenshinProfileUtil.isChange(basicSubGraphNode)) {
				for (SubGraph complexSubGraph : editRuleGraph.getSubgraphs()) {
					if (!ignoredSubGraphs.contains(complexSubGraph)) {
						NodePattern complexSubGraphNode = basicToComplexMatch.get(basicSubGraphNode);
						
						if (getSubGraphChanges(complexSubGraph).contains(complexSubGraphNode)) {
							return true;
						}
					}
				}
			}
			
			// Check change edges of basic sub graph:
			for (EdgePattern basicSubGraphEdge : basicSubGraphNode.getOutgoings()) {
				if (HenshinProfileUtil.isChange(basicSubGraphEdge)) {
					for (SubGraph complexSubGraph : editRuleGraph.getSubgraphs()) {
						if (!ignoredSubGraphs.contains(complexSubGraph)) {
							EdgePattern complexSubGraphEdge = getComplexEdgeMatch(basicSubGraphEdge, basicToComplexMatch);
							
							if (getSubGraphChanges(complexSubGraph).contains(complexSubGraphEdge)) {
								return true;
							}
						}
					}
				}
			}
		}
		
		return false;
	}
	
	private EdgePattern getComplexEdgeMatch(EdgePattern basicEdge, Map<NodePattern, NodePattern> basicToComplexMatch) {
		NodePattern complexSubGraphSourceNode = basicToComplexMatch.get(basicEdge.getSource());
		NodePattern complexSubGraphTargetNode = basicToComplexMatch.get(basicEdge.getTarget());
		
		for (EdgePattern complexSubGraphEdge : complexSubGraphSourceNode.getOutgoings(basicEdge.getType())) {
			if (complexSubGraphEdge.getTarget() == complexSubGraphTargetNode) {
				return complexSubGraphEdge;
			}
		}
		
		return null;
	}
	
	private EdgePattern getBasicEdgeMatch(EdgePattern complexEdge, Map<NodePattern, NodePattern> basicToComplexMatch) {
		Map.Entry<NodePattern, NodePattern> sourceMatch = null;
		Map.Entry<NodePattern, NodePattern> targetMatch = null;
		
		for (Entry<NodePattern, NodePattern> match : basicToComplexMatch.entrySet()) {
			if (complexEdge.getSource() == match.getValue()) {
				sourceMatch = match;
			}
			if (complexEdge.getTarget() == match.getValue()) {
				targetMatch = match;
			}
		}
		
		if ((sourceMatch != null) && (targetMatch != null)) {
			for (EdgePattern outgoingBasicEdge : sourceMatch.getKey().getOutgoings(complexEdge.getType())) {
				if (outgoingBasicEdge.getTarget() == targetMatch.getKey()) {
					return outgoingBasicEdge;
				}
			}
		}
		
		return null;
	}
}
