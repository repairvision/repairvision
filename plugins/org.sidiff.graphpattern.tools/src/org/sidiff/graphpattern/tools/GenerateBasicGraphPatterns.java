package org.sidiff.graphpattern.tools;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.amalgam.explorer.activity.ui.api.editor.pages.helper.StringHelper;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IResource;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;
import org.sidiff.common.emf.EMFUtil;
import org.sidiff.common.emf.modelstorage.EMFHandlerUtil;
import org.sidiff.consistency.common.ui.util.WorkbenchUtil;
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
import org.sidiff.graphpattern.tools.editrules.generator.util.GraphPatternGeneratorUtil;

public class GenerateBasicGraphPatterns extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IStructuredSelection selection = HandlerUtil.getCurrentStructuredSelection(event);
		Bundle complexPatternsBundle = null;
		Bundle basicPatternsBundle = null;
		
		try {
			if (selection.size() == 1) {
				complexPatternsBundle = EMFHandlerUtil.getSelection(event, Bundle.class);

				basicPatternsBundle = GraphpatternFactory.eINSTANCE.createBundle();
				basicPatternsBundle.setName(complexPatternsBundle.getName());
				basicPatternsBundle.getDomains().addAll(complexPatternsBundle.getDomains());
			} else if (selection.size() == 2) {
				for (Object selected : selection.toList()) {
					if (selected instanceof IResource) {
						Bundle bundle = EMFHandlerUtil.loadResource((IResource) selected, Bundle.class, new ResourceSetImpl());
						
						if (bundle.eResource().getURI().lastSegment().matches(".*?\\.basic.*?\\.graphpattern")) {
							basicPatternsBundle = bundle;
							
							if (WorkbenchUtil.showQuestion("Clear basic pattern bundle?")) {
								basicPatternsBundle.getPatterns().clear();
							}
						} else {
							complexPatternsBundle = bundle;
						}
					}
				}
			} 
			
			if ((complexPatternsBundle == null) || (basicPatternsBundle == null)) {
				throw new ExecutionException("Missing Bundle");
			}
		} catch (Exception e) {
			WorkbenchUtil.showErrorWithException(
					"Select a bundle with complex pattern to generate a new basic pattern bundle."
					+ " Select a basic (*.basic.graphpattern) and complex pattern bundle to update the basic bundle.",
					this, e);
			throw new ExecutionException(e.getMessage(), e);
		}
		
		for (Pattern pattern : complexPatternsBundle.getPatterns()) {
			findNewBasicPatterns(complexPatternsBundle, basicPatternsBundle, pattern);
		}
		
		URI complexPatternsBundleURI = complexPatternsBundle.eResource().getURI();
		String basicPatternsBundleFileName = complexPatternsBundleURI.trimFileExtension().lastSegment() + ".basic." + complexPatternsBundleURI.fileExtension();
		URI basicPatternsBundleURI = complexPatternsBundleURI.trimSegments(1).appendSegment(basicPatternsBundleFileName);
		
		GraphPatternGeneratorUtil.saveBundle(basicPatternsBundleURI, basicPatternsBundle);
		return null;
	}

	private void findNewBasicPatterns(Bundle complexPatternsBundle, Bundle basicPatternsBundle, Pattern pattern) {
		
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
			Pattern defaultPattern = getPattern(basicBundle, "generated.fragments");
			
			for (Pattern basicPattern : basicPatterns) {
				if (!graphPatternExist(basicBundle, basicPattern)) {
					GraphPattern basicGraphPattern = basicPattern.getGraphs().get(0); 
					
					// Generate name:
					String basicGraphPatternName = generateName(basicBundle, basicGraphPattern);
					basicPattern.setName(basicGraphPatternName);
					basicPattern.setDescription("Derived from: " + fullGraphPattern.getName());
					basicGraphPattern.setName(basicGraphPatternName);
					basicGraphPattern.setDescription("Derived from: " + fullGraphPattern.getName());
					
					defaultPattern.getSubpatterns().add(basicPattern);
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
			
			// TODO: Search only for first match:
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
		List<Set<NodePattern>> existingSubGraphs = new ArrayList<>();
		
		for (NodePattern nodePattern : contentNodes) {
				Set<NodePattern> basicGraphPatternNodes = extractRequiredSubGraph(nodePattern);
				
				// Filter already processed sub graphs:
				if (!existingSubGraphs.contains(basicGraphPatternNodes)) {
					Pattern basicPattern = generateMinimalParameterizedPattern(
							pattern, graphPattern, basicGraphPatternNodes);
					basicPatterns.add(basicPattern);
				}
				
				existingSubGraphs.add(basicGraphPatternNodes);
		}
		
		return basicPatterns;
	}
	
	protected Pattern generateMinimalParameterizedPattern(Pattern fullPattern, GraphPattern fullGraphPattern, Set<NodePattern> basicGraphContentNodes) {
		
		// Find context nodes:
		List<NodePattern> basicGraphContextNodes = new ArrayList<>();
		
		// Context - containment -> Content:
		for (NodePattern fullGraphNode : fullGraphPattern.getNodes()) {
			for (EdgePattern outgoing : fullGraphNode.getOutgoings()) {
				if (outgoing.getType().isContainment()) {
					if (basicGraphContentNodes.contains(outgoing.getTarget())) {
						basicGraphContextNodes.add(fullGraphNode);
					}
				}
			}
		}
		
		// Copy self-contained sub graph:
		GraphPattern basicGraphPattern = GraphpatternFactory.eINSTANCE.createGraphPattern();
		
		List<NodePattern> basicGraphNodes = new ArrayList<>(basicGraphContentNodes.size() + basicGraphContextNodes.size());
		basicGraphNodes.addAll(basicGraphContextNodes);
		basicGraphNodes.addAll(basicGraphContentNodes);
		Map<EObject, EObject> subGraphCopy = EMFUtil.copyAll(basicGraphNodes);
		
		for (EObject subGraphElement : subGraphCopy.values()) {
			if (subGraphElement instanceof NodePattern) {
				NodePattern subGraphNode = (NodePattern) subGraphElement;
				basicGraphPattern.getNodes().add(subGraphNode);
				
				// Remove dangling edges:
				List<EdgePattern> danglings = new ArrayList<>();
				
				for (EdgePattern outgoing : subGraphNode.getOutgoings()) {
					if (outgoing.getTarget() == null) {
						danglings.add(outgoing);
					}
				}
				
				for (EdgePattern dangling : danglings) {
					EcoreUtil.remove(dangling);
				}
			}
		}
		
		// Find and copy parameter sub-set:
		Pattern basicPattern = GraphpatternFactory.eINSTANCE.createPattern();
		basicPattern.getGraphs().add(basicGraphPattern);
		
		GraphPatternGeneratorUtil.generateParameters(basicPattern);
		
		return basicPattern;
	}
	
	protected String generateName(Bundle bundle, GraphPattern graphPattern) {
		if (!graphPattern.getNodes().isEmpty()) {
			
			// Collect node type names:
			List<String> contentTypeNames = new ArrayList<>();
			List<String> contextTypeNames = new ArrayList<>();
			
			for (NodePattern node : graphPattern.getNodes()) {
				if (GraphPatternGeneratorUtil.isContext(node)) {
					if (GraphPatternGeneratorUtil.hasContent(node)) {
						contextTypeNames.add(StringHelper.toUpperFirst(node.getType().getName()));
					}
				} else {
					contentTypeNames.add(StringHelper.toUpperFirst(node.getType().getName()));
				}
			}
			
			Collections.sort(contentTypeNames);
			Collections.sort(contextTypeNames);
			
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
			
			if (!contextTypeNames.isEmpty()) {
				name.append("In");
				
				for (String typeName : contextTypeNames) {
					name.append(typeName);
					
					if (typeName != contextTypeNames.get(contextTypeNames.size() - 1)) {
						name.append(connector);
					}
				}
			}
			
			// Check if name is unique:
			String nameString = name.toString();
			String nameWithCounter = nameString; 
			int counter = 0;
			
			for (TreeIterator<EObject> iterator = bundle.eAllContents(); iterator.hasNext();) {
				EObject element = iterator.next();
				
				if (element instanceof GraphPattern) {
					if (((GraphPattern) element).getName().equals(nameWithCounter)) {
						++counter;
						nameWithCounter = nameString + counter;
					}
					iterator.prune();
				}
			}
			
			return nameWithCounter;
		} else {
			return "N/A";
		}
	}
	
	protected Set<NodePattern> extractRequiredSubGraph(NodePattern node) {
		Set<NodePattern> includedNodes = new HashSet<>();
		includedNodes.add(node);
		
		// Collect all required nodes by transitively following outgoing edges:
		List<NodePattern> nextNodes = Collections.singletonList(node);
		
		while (!nextNodes.isEmpty()) {
			List<NodePattern> currentNodes = nextNodes;
			nextNodes = new ArrayList<>();
			
			for (NodePattern currentNode : currentNodes) {
				for (EdgePattern outgoing : currentNode.getOutgoings()) {
					if (outgoing.getType().isRequired()) {
						NodePattern targetNode = outgoing.getTarget();
						
						if (!includedNodes.contains(targetNode)) {
							includedNodes.add(targetNode);
							nextNodes.add(targetNode);
						}
					}
				}
			}
		}
		
		return includedNodes;
	}
}
