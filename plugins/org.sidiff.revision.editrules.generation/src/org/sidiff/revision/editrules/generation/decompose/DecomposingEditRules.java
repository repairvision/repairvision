package org.sidiff.revision.editrules.generation.decompose;

import static org.sidiff.graphpattern.profile.henshin.HenshinStereotypes.create;
import static org.sidiff.graphpattern.profile.henshin.HenshinStereotypes.delete;
import static org.sidiff.graphpattern.profile.henshin.HenshinStereotypes.preserve;
import static org.sidiff.graphpattern.profile.henshin.HenshinStereotypes.rule;
import static org.sidiff.revision.editrules.generation.decompose.DecomposingEditRulesUtil.clearSubGraphElements;
import static org.sidiff.revision.editrules.generation.decompose.DecomposingEditRulesUtil.getSubGraphChanges;
import static org.sidiff.revision.editrules.generation.decompose.DecomposingEditRulesUtil.getSubGraphContext;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.sidiff.graphpattern.Bundle;
import org.sidiff.graphpattern.EdgePattern;
import org.sidiff.graphpattern.GraphElement;
import org.sidiff.graphpattern.GraphPattern;
import org.sidiff.graphpattern.GraphpatternFactory;
import org.sidiff.graphpattern.NodePattern;
import org.sidiff.graphpattern.Pattern;
import org.sidiff.graphpattern.Stereotype;
import org.sidiff.graphpattern.SubGraph;
import org.sidiff.graphpattern.csp.generic.ICSPSolver;
import org.sidiff.graphpattern.csp.generic.IConstraintSatisfactionProblem;
import org.sidiff.graphpattern.csp.generic.impl.CSPSolver;
import org.sidiff.graphpattern.csp.generic.impl.ConstraintSatisfactionProblem;
import org.sidiff.graphpattern.csp.generic.impl.Variable;
import org.sidiff.graphpattern.profile.henshin.util.HenshinProfileUtil;
import org.sidiff.graphpattern.tools.csp.GraphPatternMatch;
import org.sidiff.graphpattern.tools.csp.GraphPatternMatchings;
import org.sidiff.graphpattern.tools.csp.NodePatternDomain;
import org.sidiff.graphpattern.tools.csp.NodePatternDomain.EdgeMatching;
import org.sidiff.graphpattern.tools.csp.NodePatternVariable;
import org.sidiff.revision.editrules.generation.decompose.dependencies.Dependency;
import org.sidiff.revision.editrules.generation.decompose.dependencies.DependencyNode;
import org.sidiff.revision.editrules.generation.decompose.dependencies.DependencyOrdering;

public class DecomposingEditRules {

	public void decompose(Bundle complexEditRulesBundle, Bundle basicEditRulesBundle) {
		
		// (1) Decompose complex edit rules into basic edit rules:
		List<GraphPattern> basicEditRuleGraphs = basicEditRulesBundle.getPatterns()
				.stream().flatMap(p-> p.getAllGraphPatterns().stream()).collect(Collectors.toList()); 
		
		for (Pattern complexEditRulePattern : complexEditRulesBundle.getPatterns()) {
			decompose(complexEditRulePattern, basicEditRuleGraphs);
		}
		
		// (2) Sort decomposition of basic edit rules by their dependencies (create/use, use/delete):
		sortByDependencies(complexEditRulesBundle);
	}
	
	private void decompose(Pattern complexEditRulePattern, List<GraphPattern> basicEditRuleGraphs) {
		for (Pattern complexEditRuleSubPattern : complexEditRulePattern.getPatterns()) {
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
			problem.setSearchInjectiveSolutions(true);
			
			for (NodePattern basicEditRuleNode : basicEditRuleGraph.getNodes()) {
				NodePatternDomain domain = new NodePatternDomain(
						basicEditRuleNode, complexEditRuleGraph.getNodes(), 
						EdgeMatching.TOTAL_INJECTIVE, EdgeMatching.TOTAL_INJECTIVE) {
					
					@Override
					protected boolean checkStereotypes(NodePattern basicEditRuleNode, NodePattern complexEditRuleNode) {

						// Stereotype compatibility of nodes:
						Stereotype subEditRule = basicEditRuleNode.getStereotypes().get(0);
						Stereotype fullEditRule = complexEditRuleNode.getStereotypes().get(0);

						return (subEditRule.equals(preserve) && fullEditRule.equals(create))			// create->use
								||	(subEditRule.equals(preserve) && fullEditRule.equals(delete))		// use->delete
								||	(subEditRule.equals(preserve) && fullEditRule.equals(preserve))
								||	(subEditRule.equals(delete) && fullEditRule.equals(delete))
								||	(subEditRule.equals(create) && fullEditRule.equals(create));
					}
				};

				// NOTE: Optimization:
				if (domain.isEmpty()) {
					return;
				}
				
				Variable<NodePattern, NodePattern> variable = new NodePatternVariable(basicEditRuleNode, domain, false, true, true) {
					
					@Override
					protected boolean checkStereotypes(List<Stereotype> basicEditRuleEdge, List<Stereotype> complexEditRuleEdge) {
						
						// Stereotype compatibility of edges:
						Stereotype subEditRule = basicEditRuleEdge.get(0);
						Stereotype fullEditRule = complexEditRuleEdge.get(0);

						return (subEditRule.equals(preserve) && fullEditRule.equals(create))			// create->use
								||	(subEditRule.equals(preserve) && fullEditRule.equals(delete))		// use->delete
								||	(subEditRule.equals(preserve) && fullEditRule.equals(preserve))
								||	(subEditRule.equals(delete) && fullEditRule.equals(delete))
								||	(subEditRule.equals(create) && fullEditRule.equals(create));
					}
				};
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
			} else if (HenshinProfileUtil.isPreserve(basicNode)) {
				++contextSize;
			}
			
			for (EdgePattern basicEdge : basicNode.getOutgoings()) {
				if (HenshinProfileUtil.isChange(basicEdge)) {
					++changeSize;
				} else if (HenshinProfileUtil.isPreserve(basicEdge)) {
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
	
	private void sortByDependencies(Bundle complexEditRulesBundle) {
		for (Pattern pattern: complexEditRulesBundle.getPatterns()) {
			for (GraphPattern graphPattern : pattern.getAllGraphPatterns()) {
				if (graphPattern.getStereotypes().contains(rule)) {
					sortBasicRulesByDependencies(graphPattern);
				}
			}
		}
	}
	
	private void sortBasicRulesByDependencies(GraphPattern complexRule) {
		List<DependencyNode<SubGraph>> dependingSubGraphs = new ArrayList<>();
		List<Dependency<SubGraph>> dependencies = new ArrayList<>();
		
		// Create list of dependency nodes:
		for (SubGraph basicRule : complexRule.getSubgraphs()) {
			DependencyNode<SubGraph> dependingSubGraph = new DependencyNode<SubGraph>(basicRule) {
				
				@Override
				public String getName() {
					return getTarget().getName();
				}
			};
			dependingSubGraphs.add(dependingSubGraph);
		}
		
		// Create list of dependencies:
		for (NodePattern complexRuleNode : complexRule.getNodes()) {
			if (!complexRuleNode.getStereotypes().contains(preserve)) {
				SubGraph changing = null;
				SubGraph using = null;
				
				for (SubGraph basicRuleNodes : complexRuleNode.getSubgraphs()) {
					if (HenshinProfileUtil.isPreserve(basicRuleNodes)) {
						using = (SubGraph) basicRuleNodes.eContainer();
					} else if (HenshinProfileUtil.isChange(basicRuleNodes)) {
						changing = (SubGraph) basicRuleNodes.eContainer();
					}
				}
				
				if ((changing != null) && (using != null)) {
					
					// Recognized a use/delete dependency:
					if (complexRuleNode.getStereotypes().contains(delete)) {
						addDependencyIfNotPresent(dependencies, dependingSubGraphs, using, changing);
					}
					
					// Recognized a create/use dependency:
					else if (complexRuleNode.getStereotypes().contains(create)) {
						addDependencyIfNotPresent(dependencies, dependingSubGraphs, changing, using);
					}
				}
			}
		}
		
		// Sort by dependencies:
		new DependencyOrdering<SubGraph>().deterministicOrdering(dependingSubGraphs, dependencies);
		
//		System.out.println("#########################################################################");
//		new DependencyOrdering<SubGraph>().printDeterministicOrdering(dependingSubGraphs, dependencies);
//		System.out.println("#########################################################################");
		
		// Apply the ordering of the DependencyNodes to the complex rule SubGraphs:
		for (int newPosition = 0; newPosition < dependingSubGraphs.size(); newPosition++) {
			DependencyNode<SubGraph> dependingSubGraph = dependingSubGraphs.get(newPosition);
			complexRule.getSubgraphs().move(newPosition, dependingSubGraph.getTarget());
		}
	}

	private void addDependencyIfNotPresent(
			List<Dependency<SubGraph>> dependencies, 
			List<DependencyNode<SubGraph>> dependingSubGraphs,
			SubGraph predecessor, SubGraph successor) {
		
		// Search list of dependencies if the dependency already exists:
		for (Dependency<SubGraph> dependency : dependencies) {
			if ((dependency.getPredecessor() == predecessor) && (dependency.getSuccessor() == successor)) {
				return;
			}
		}
		
		// Else: Create new dependency:
		Dependency<SubGraph> newDependency = new Dependency<SubGraph>();
		
		// Find DependencyNode wrapper for SubGraph:
		for (DependencyNode<SubGraph> dependencyNode : dependingSubGraphs) {
			if (dependencyNode.getTarget() == predecessor) {
				newDependency.setPredecessor(dependencyNode);
			} else if (dependencyNode.getTarget() == successor) {
				newDependency.setSuccessor(dependencyNode);
			}
		}
		
		dependencies.add(newDependency);
	}
}
