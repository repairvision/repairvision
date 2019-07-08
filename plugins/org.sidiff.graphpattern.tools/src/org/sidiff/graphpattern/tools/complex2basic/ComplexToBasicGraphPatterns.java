package org.sidiff.graphpattern.tools.complex2basic;

import static org.sidiff.graphpattern.profile.constraints.ConstraintStereotypes.require;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.sidiff.common.emf.EMFUtil;
import org.sidiff.consistency.common.java.StringUtil;
import org.sidiff.csp.solver.ICSPSolver;
import org.sidiff.csp.solver.IConstraintSatisfactionProblem;
import org.sidiff.csp.solver.impl.CSPSolver;
import org.sidiff.csp.solver.impl.ConstraintSatisfactionProblem;
import org.sidiff.csp.solver.impl.Variable;
import org.sidiff.graphpattern.Bundle;
import org.sidiff.graphpattern.EdgePattern;
import org.sidiff.graphpattern.GraphPattern;
import org.sidiff.graphpattern.GraphpatternFactory;
import org.sidiff.graphpattern.NodePattern;
import org.sidiff.graphpattern.Pattern;
import org.sidiff.graphpattern.tools.csp.GraphPatternMatchings;
import org.sidiff.graphpattern.tools.csp.NodePatternDomain;
import org.sidiff.graphpattern.tools.csp.NodePatternVariable;
import org.sidiff.graphpattern.tools.editrules.decompose.DecomposingEditRulesUtil;
import org.sidiff.graphpattern.tools.editrules.generator.util.GraphPatternGeneratorUtil;

public class ComplexToBasicGraphPatterns {
	
	public static final String DEFAULT_PATTERN = "generated.fragments";

	public void findNewBasicPatterns(Bundle complexPatternsBundle, Bundle basicPatternsBundle, Pattern pattern) {
		
		// Search pattern tree:
		for (Pattern subPattern : pattern.getSubpatterns()) {
			findNewBasicPatterns(complexPatternsBundle, basicPatternsBundle, subPattern);
		}
		
		// Process graph patterns:
		for (GraphPattern graphPattern : pattern.getGraphs()) {
			findNewBasicGraphPatterns(complexPatternsBundle, basicPatternsBundle, pattern, graphPattern);
		}
	}

	private void findNewBasicGraphPatterns(Bundle fullBundle, Bundle basicBundle,  Pattern fullPattern, GraphPattern fullGraphPattern) {
		List<Pattern> basicPatterns = generateMinimalGraphPatterns(fullPattern, fullGraphPattern);
		
		if (!basicPatterns.isEmpty()) {
			Pattern defaultPattern = getPattern(basicBundle, DEFAULT_PATTERN);
			
			for (Pattern basicPattern : basicPatterns) {
				if (!graphPatternExist(basicBundle, basicPattern)) {
					GraphPattern basicGraphPattern = basicPattern.getGraphs().get(0); 
					
					// Search/Create containing pattern:
					Pattern containerPattern = getContainerPattern(basicBundle, defaultPattern, basicGraphPattern);
					
					// Generate name:
					String basicGraphPatternName = generateGraphPatternName(basicBundle, containerPattern, basicGraphPattern);
					basicPattern.setName(basicGraphPatternName);
					basicPattern.setDescription("Derived from: " + fullGraphPattern.getName());
					basicGraphPattern.setName(basicGraphPatternName);
					basicGraphPattern.setDescription("Derived from: " + fullGraphPattern.getName());
					
					containerPattern.getSubpatterns().add(basicPattern);
				}
			}
		}
	}
	
	private Pattern getPattern(Bundle basicPatternsBundle, String name) {
		String defaultPatternName = name;
		
		// Find:
		for (Pattern pattern : basicPatternsBundle.getPatterns()) {
			if (pattern.getName().equals(name)) {
				return pattern;
			}
		}
		
		// Create new:
		Pattern defaultPattern = GraphpatternFactory.eINSTANCE.createPattern();
		defaultPattern.setName(defaultPatternName);
		basicPatternsBundle.getPatterns().add(defaultPattern);
		
		return defaultPattern;
	}

	private boolean graphPatternExist(Bundle basicPatternsBundle, Pattern basicPattern) {
		assert basicPattern.getGraphs().size() == 1;
		
		for (Pattern otherBasicPattern : basicPatternsBundle.getPatterns()) {
			if (graphPatternExist(otherBasicPattern, basicPattern)) {
				return true;
			}
		}
		
		return false;
	}
	
	private boolean graphPatternExist(Pattern otherBasicPatterns, Pattern basicPattern) {
		assert basicPattern.getGraphs().size() == 1;
		GraphPattern basicGraphPattern = basicPattern.getGraphs().get(0);
		
		for (GraphPattern otherBasicGraphPatter : otherBasicPatterns.getGraphs()) {
			if (matchGraphPatternsByStructure(otherBasicGraphPatter, basicGraphPattern)) {
				return true;
			}
		}
		
		for (Pattern subPatterns : otherBasicPatterns.getSubpatterns()) {
			if (graphPatternExist(subPatterns, basicPattern)) {
				return true;
			}
		}
		
		return false;
	}
	
	private boolean matchGraphPatternsByStructure(GraphPattern otherBasicGraphPatter, GraphPattern basicGraphPattern) {

		if (getGraphPatternSize(otherBasicGraphPatter) ==  getGraphPatternSize(basicGraphPattern)) {
			int size = basicGraphPattern.getNodes().size();
			
			IConstraintSatisfactionProblem<NodePattern, NodePattern> problem = new ConstraintSatisfactionProblem<>(size);
			problem.setMinimumSolutionSize(size);
			problem.setMaximumSolutionSize(size);
			problem.setSearchMaximumSolutions(true);
			problem.setSearchInjectiveSolutions(true);
			
			for (NodePattern basicGraphPatternNode : basicGraphPattern.getNodes()) {
				NodePatternDomain domain = new NodePatternDomain(basicGraphPatternNode, otherBasicGraphPatter.getNodes(), true, true);
				
				// NOTE: Optimization:
				if (domain.isEmpty()) {
					return false;
				}
				
				Variable<NodePattern, NodePattern> variable = new NodePatternVariable(basicGraphPatternNode, domain, false);
				problem.addVariable(variable);
			}
			
			// TODO[Optimization]: Search only for first match:
			GraphPatternMatchings matchings = new GraphPatternMatchings(basicGraphPattern, otherBasicGraphPatter);
			ICSPSolver<NodePattern, NodePattern> solver = new CSPSolver<>(problem, matchings);
			solver.run();
			
			return !matchings.getMatches().isEmpty();
		}
		
		return false;
	}

	private int getGraphPatternSize(GraphPattern graphPattern) {
		int size = graphPattern.getNodes().size();
		
		for (NodePattern node : graphPattern.getNodes()) {
			size += node.getOutgoings().size();
		}
		
		return size;
	}

	protected List<Pattern> generateMinimalGraphPatterns(Pattern pattern, GraphPattern graphPattern) {
		List<Pattern> basicPatterns = new ArrayList<>();
		
		// Find all content (none context) nodes:
		List<NodePattern> contentNodes = new ArrayList<>();
		
		for (NodePattern node : graphPattern.getNodes()) {
			// Is contained node?
			if (!GraphPatternGeneratorUtil.isContext(node)) {
				contentNodes.add(node);
			}
		}
		
		// Find a partitioning for all content nodes of the given graph pattern:
		List<RequiredSubGraph> existingSubGraphs = new ArrayList<>();
		
		for (NodePattern nodePattern : contentNodes) {
				RequiredSubGraph basicGraphPatternNodes = extractRequiredSubGraph(nodePattern);
				
				// Filter already processed sub graphs:
				if (!containRequiredSubGraph(existingSubGraphs, basicGraphPatternNodes)) {
					Pattern basicPattern = generateMinimalParameterizedPattern(
							pattern, graphPattern, basicGraphPatternNodes);
					basicPatterns.add(basicPattern);
					existingSubGraphs.add(basicGraphPatternNodes);
				}
		}
		
		return basicPatterns;
	}
	
	protected Pattern generateMinimalParameterizedPattern(Pattern fullPattern, GraphPattern fullGraphPattern, RequiredSubGraph subGraph) {
		
		// Find context nodes:
		List<NodePattern> basicGraphContextNodes = new ArrayList<>();
		
		// Context - containment -> Content:
		List<EdgePattern> containmentEdges = new ArrayList<>();
		
		for (NodePattern fullGraphNode : fullGraphPattern.getNodes()) {
			List<EdgePattern> containmentEdgesOfNode = getContextEdges(subGraph.contentNodes, fullGraphNode);
			
			if (!containmentEdgesOfNode.isEmpty()) {
				containmentEdges.addAll(containmentEdgesOfNode);
				basicGraphContextNodes.add(fullGraphNode);
			}
		}
		
		// Copy self-contained sub graph:
		GraphPattern basicGraphPattern = GraphpatternFactory.eINSTANCE.createGraphPattern();
		
		List<NodePattern> basicGraphNodes = new ArrayList<>();
		basicGraphNodes.addAll(basicGraphContextNodes);
		basicGraphNodes.addAll(subGraph.contentNodes);
		basicGraphNodes.addAll(subGraph.contextNodes);
		Map<EObject, EObject> subGraphCopy = EMFUtil.copyAll(basicGraphNodes);	// original -> copy
		
		// Clean-up edges:
		for (Entry<EObject, EObject> elementCopy : subGraphCopy.entrySet()) {
			if (elementCopy.getValue() instanceof NodePattern) {
				NodePattern subGraphNode = (NodePattern) elementCopy.getValue();
				basicGraphPattern.getNodes().add(subGraphNode);
				
				// Only containment edges: context -> content.
				NodePattern originalGraphNode = (NodePattern) elementCopy.getKey();
				
				if (!subGraph.contains(originalGraphNode)) {
					List<EdgePattern> toBeRemoved = new ArrayList<>(subGraphNode.getOutgoings());
					
					// preserve containment edges
					for (EdgePattern containmentEdge : containmentEdges) {
						toBeRemoved.remove(subGraphCopy.get(containmentEdge));
					}
					
					removeEdges(toBeRemoved);
				} else {
					
					// Remove dangling edge (content -> not contained):
					removeDanglingEdge(subGraphNode);
				}
			}
		}
		
		// Mark context as required:
		for (NodePattern contextNode : subGraph.contextNodes) {
			((NodePattern) subGraphCopy.get(contextNode)).getStereotypes().add(require);
		}
		
		for (NodePattern contextNode : basicGraphContextNodes) {
			((NodePattern) subGraphCopy.get(contextNode)).getStereotypes().add(require);
		}
		
		// Find and copy parameter sub-set:
		Pattern basicPattern = GraphpatternFactory.eINSTANCE.createPattern();
		basicPattern.getGraphs().add(basicGraphPattern);
		
		GraphPatternGeneratorUtil.generateINParameters(basicPattern);
		
		return basicPattern;
	}

	private List<EdgePattern> getContextEdges(Set<NodePattern> basicGraphContentNodes, NodePattern fullGraphNode) {
		List<EdgePattern> containments = new ArrayList<>();
		
		// Is context node?
		if (!basicGraphContentNodes.contains(fullGraphNode)) {
			
			// Has edge that contains a content node?
			for (EdgePattern outgoing : fullGraphNode.getOutgoings()) {
				if (outgoing.getType().isContainment() && basicGraphContentNodes.contains(outgoing.getTarget())) {
					containments.add(outgoing);
				}
			}
		}
		
		return containments;
	}
	
	private void removeEdges(List<EdgePattern> toBeRemoved) {
		for (EdgePattern removeEdge : toBeRemoved) {
			EcoreUtil.remove(removeEdge);
			
			if (removeEdge.getTarget() != null) {
				removeEdge.getTarget().getIncomings().remove(removeEdge);
			}
		}
	}
	
	private void removeDanglingEdge(NodePattern node) {
		List<EdgePattern> toBeRemoved = new ArrayList<>();
		
		for (EdgePattern outgoing : node.getOutgoings()) {
			if (outgoing.getTarget() == null) {
				toBeRemoved.add(outgoing);
			}
		}
		
		removeEdges(toBeRemoved);
	}
	
	private boolean containRequiredSubGraph(List<RequiredSubGraph> graphs, RequiredSubGraph graph) {
		
		for (RequiredSubGraph otherGraph : graphs) {
			if (otherGraph.contentNodes.equals(graph.contentNodes) && otherGraph.contextNodes.equals(graph.contextNodes)) {
				return true;
			}
		}
		
		return false;
	}

	// FIXME: Child elements of content elements are always also content elements!
	
	protected RequiredSubGraph extractRequiredSubGraph(NodePattern startNode) {
		Set<NodePattern> contentNodes = new HashSet<>();
		contentNodes.add(startNode);
		
		Set<NodePattern> contextNodes = new HashSet<>();
		
		// Collect all required nodes by transitively following outgoing edges:
		List<NodePattern> nextNodes = Collections.singletonList(startNode);
		
		while (!nextNodes.isEmpty()) {
			List<NodePattern> currentNodes = nextNodes;
			nextNodes = new ArrayList<>();
			
			for (NodePattern currentNode : currentNodes) {
				for (EdgePattern outgoing : currentNode.getOutgoings()) {
					
					// NOTE: An element needs a container anyway and the container will be added as context later.
					if (outgoing.getType().isRequired() && !outgoing.getType().isContainer()) {
						NodePattern targetNode = outgoing.getTarget();
						
						// Already added?
						if (!contentNodes.contains(targetNode) && !contextNodes.contains(targetNode)) {
							nextNodes.add(targetNode);
							
							// NOTE: (1) Consider only as content if the node has a transitive required path to the start node.
							if (isContentNode(targetNode, contentNodes)) {
								contentNodes.add(targetNode);
								
								// NOTE: Since we did not predict transitive paths we have to re-check (1).
								findContentNodes(targetNode, contentNodes, contextNodes);
							} else {
								contextNodes.add(targetNode);
							}
						}
					}
				}
			}
		}
		
		RequiredSubGraph subGraph = new RequiredSubGraph();
		subGraph.contentNodes = contentNodes;
		subGraph.contextNodes = contextNodes;
		
		return subGraph;
	}
	
	private class RequiredSubGraph {
		Set<NodePattern> contentNodes;
		Set<NodePattern> contextNodes;
		
		boolean contains(NodePattern node) {
			return contentNodes.contains(node) || contextNodes.contains(node);
		}
	}
	
	private boolean isContentNode(NodePattern node, Set<NodePattern> contentNodes) {
		
		// Consider as content if the node has a required edge to other content edges:
		for (EdgePattern outgoing : node.getOutgoings()) {
			if (contentNodes.contains(outgoing.getTarget())) {
				return true;
			}
		}
		
		return false;
	}
	
	private void findContentNodes(NodePattern contentNode, Set<NodePattern> contentNodes, Set<NodePattern> contextNodes) {
		
		// Find context nodes which reference the (new) given context node: 
		List<NodePattern> foundContentNodes = new ArrayList<>();
		
		for (NodePattern contextNode : contextNodes) {
			if (isContentNode(contextNode, contentNodes)) {
				foundContentNodes.add(contextNode);
			}
		}
		
		// Move context to content nodes:
		contextNodes.removeAll(foundContentNodes);
		contentNodes.addAll(foundContentNodes);
		
		// Transitively check for new content nodes:
		for (NodePattern foundContentNode : foundContentNodes) {
			findContentNodes(foundContentNode, contentNodes, contextNodes);
		}
	}
	
	protected Pattern getContainerPattern(Bundle bundle, Pattern defaultPattern, GraphPattern graphPattern) {
		
		// Generate pattern name:
		List<String> containerElementNames = new ArrayList<>();
		
		// NOTE: Search for outer context that contains the content:
		for (NodePattern node : graphPattern.getNodes()) {
			if (containsContent(node))  {
				containerElementNames.add(node.getType().getName());
			}
		}
		
		String containerName = generatePatternName(containerElementNames);
		
		// Search for pattern:
		for (Pattern containerPattern : bundle.getPatterns()) {
			if (containerPattern.getName().equals(containerName)) {
				return containerPattern;
			}
		}
		
		for (Pattern containerPattern : defaultPattern.getSubpatterns()) {
			if (containerPattern.getName().equals(containerName)) {
				return containerPattern;
			}
		}
		
		// If pattern not found, create new pattern:
		Pattern containerPattern = GraphpatternFactory.eINSTANCE.createPattern();
		containerPattern.setName(containerName);
		defaultPattern.getSubpatterns().add(containerPattern);
		
		return containerPattern;
	}
	
	protected String generatePatternName(List<String> containerElementNames) {
		Collections.sort(containerElementNames);
		
		StringBuilder buildContainerName = new StringBuilder();
		buildContainerName.append(DecomposingEditRulesUtil.HIERARCHICAL_NAME_PLACEHOLDER + "In");
		
		for (String containerElementName : containerElementNames) {
			buildContainerName.append(StringUtil.toUpperFirst(containerElementName));
			
			if (containerElementNames.get(containerElementNames.size() - 1) != containerElementName) {
				buildContainerName.append("And");
			}
		}
		
		return buildContainerName.toString();
	}

	protected String generateGraphPatternName(Bundle bundle, Pattern containerPattern, GraphPattern graphPattern) {
		if (!graphPattern.getNodes().isEmpty()) {
			
			// Collect node type names:
			List<String> contentTypeNames = new ArrayList<>();
			
			for (NodePattern node : graphPattern.getNodes()) {
				if (isContent(node)) {
					contentTypeNames.add(StringUtil.toUpperFirst(node.getType().getName()));
				}
			}
			
			Collections.sort(contentTypeNames);
			
			// Construct name:
			StringBuffer name = new StringBuffer();
			String connector = "And";
			
			if (!contentTypeNames.isEmpty()) {
				for (String typeName : contentTypeNames) {
					name.append(typeName);
					
					if (typeName != contentTypeNames.get(contentTypeNames.size() - 1)) {
						name.append(connector);
					}
				}
			}
			
			// Check if name is unique:
			String nameString = name.toString();
			String nameWithCounter = nameString; 
			int counter = 0;
			
			// NOTE: We expect hierarchical pattern names, so we just check pattern in the same sub-pattern: 
			for (Pattern siblingPatterns : containerPattern.getSubpatterns()) {
				if (siblingPatterns.getName().equals(nameWithCounter)) {
					++counter;
					nameWithCounter = nameString + counter;
				}
			}
			
			return nameWithCounter;
		} else {
			return "N/A";
		}
	}
	
	protected boolean containsContent(NodePattern node) {
		if (node.getStereotypes().contains(require))  {
			for (EdgePattern outgoing : node.getOutgoings()) {
				if (outgoing.getType().isContainment()) {
					if (!outgoing.getTarget().getStereotypes().contains(require)) {
						return true;
					}
				}
			}
		}
		return false;
	}
	
	protected boolean isContent(NodePattern node) {
		return !node.getStereotypes().contains(require);
	}
}
