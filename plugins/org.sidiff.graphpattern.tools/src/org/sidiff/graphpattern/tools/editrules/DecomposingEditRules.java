package org.sidiff.graphpattern.tools.editrules;

import static org.sidiff.graphpattern.profile.henshin.HenshinStereotypes.preserve;
import static org.sidiff.graphpattern.profile.henshin.HenshinStereotypes.rule;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
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
import org.sidiff.graphpattern.GraphElement;
import org.sidiff.graphpattern.GraphPattern;
import org.sidiff.graphpattern.GraphpatternFactory;
import org.sidiff.graphpattern.NodePattern;
import org.sidiff.graphpattern.Pattern;
import org.sidiff.graphpattern.SubGraph;
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
							graph.getSubgraphs().forEach(this::clearSubGraphElements);
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
		List<SubGraph> containedSubGraphs = findContainedSubGraphs(complexEditRuleGraph, basicToComplexMatch);

		// Create new sub graph if new sub graph has no other conflicting overlappings:
		if (!hasOverlappingChanges(complexEditRuleGraph, basicToComplexMatch, containedSubGraphs)) {
			
			// Remove contained sub graphs:
			for (SubGraph containedSubGraph : containedSubGraphs) {
				clearSubGraphElements(containedSubGraph);
				complexEditRuleGraph.getSubgraphs().remove(containedSubGraph);
			}
			
			// Insert new sub graph:
			SubGraph subGraph = GraphpatternFactory.eINSTANCE.createSubGraph();
			subGraph.setName(basicEditRuleGraph.getName());
			complexEditRuleGraph.getSubgraphs().add(subGraph);
			
			SubGraph contextSubGraph = GraphpatternFactory.eINSTANCE.createSubGraph();
			contextSubGraph.setName(basicEditRuleGraph.getName());
			contextSubGraph.getStereotypes().add(preserve);
			subGraph.getSubgraphs().add(contextSubGraph);
			
			SubGraph contentSubGraph = GraphpatternFactory.eINSTANCE.createSubGraph();
			contentSubGraph.setName(basicEditRuleGraph.getName());
			subGraph.getSubgraphs().add(contentSubGraph);
			
			for (NodePattern basicSubGraphNode : basicToComplexMatch.keySet()) {
				if (basicSubGraphNode.getStereotypes().get(0).equals(preserve)) {
					contextSubGraph.getElements().add(basicToComplexMatch.get(basicSubGraphNode));
				} else {
					contentSubGraph.getElements().add(basicToComplexMatch.get(basicSubGraphNode));
				}
			}
		}
	}

	private List<SubGraph> findContainedSubGraphs(GraphPattern complexEditRuleGraph, Map<NodePattern, NodePattern> basicToComplexMatch) {
		List<SubGraph> matchingSubGraphs = new ArrayList<>(1); 
		
		for (SubGraph subGraph : complexEditRuleGraph.getSubgraphs()) {
			if (isContainedSubGraph(subGraph, basicToComplexMatch)) {
				matchingSubGraphs.add(subGraph);
			}
		}
		
		return matchingSubGraphs;
	}
	
	private boolean isContainedSubGraph(SubGraph subGraph, Map<NodePattern, NodePattern> basicToComplexMatch) {
		for (NodePattern basicSubGraphNode : basicToComplexMatch.keySet()) {
			
			// Check only change nodes of basic sub graph:
			if (!basicSubGraphNode.getStereotypes().get(0).equals(preserve)) {
				NodePattern complexSubGraphNode = basicToComplexMatch.get(basicSubGraphNode);

				for (GraphElement subGraphChange : getSubGraphChanges(subGraph)) {
					if (subGraphChange != complexSubGraphNode) {
						return false;
					}
				}
			}
		}
		return true;
	}
	
	private boolean hasOverlappingChanges(GraphPattern editRuleGraph, Map<NodePattern, NodePattern> basicToComplexMatch, List<SubGraph> ignoredSubGraphs) {
		
		for (NodePattern basicSubGraphNode : basicToComplexMatch.keySet()) {
			
			// Check only change nodes of basic sub graph:
			if (!basicSubGraphNode.getStereotypes().get(0).equals(preserve)) {
				for (SubGraph subGraph : editRuleGraph.getSubgraphs()) {
					if (!ignoredSubGraphs.contains(subGraph)) {
						NodePattern complexSubGraphNode = basicToComplexMatch.get(basicSubGraphNode);
						
						for (GraphElement subGraphChange : getSubGraphChanges(subGraph)) {
							if (subGraphChange == complexSubGraphNode) {
								return true;
							}
						}
					}
				}
			}
		}
		
		return false;
	}
	
	private List<GraphElement> getSubGraphChanges(SubGraph subGraph) {
		for (SubGraph annotatedSubGraph : subGraph.getSubgraphs()) {
			if (annotatedSubGraph.getStereotypes().isEmpty()  || !annotatedSubGraph.getStereotypes().get(0).equals(preserve)) {
				return annotatedSubGraph.getElements();
			}
		}
		return Collections.emptyList();
	}
	
	private void clearSubGraphElements(SubGraph subGraph) {
		
		for (SubGraph subSubGraph : subGraph.getSubgraphs()) {
			clearSubGraphElements(subSubGraph);
		}
		
		subGraph.getElements().clear();
	}
}
