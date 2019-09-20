package org.sidiff.graphpattern.tools.editrules.generator.main;

import static org.sidiff.graphpattern.profile.henshin.HenshinStereotypes.create;
import static org.sidiff.graphpattern.profile.henshin.HenshinStereotypes.delete;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.BooleanSupplier;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.sidiff.common.emf.access.EMFMetaAccess;
import org.sidiff.csp.solver.ICSPSolver;
import org.sidiff.csp.solver.IConstraintSatisfactionProblem;
import org.sidiff.csp.solver.impl.CSPSolver;
import org.sidiff.csp.solver.impl.ConstraintSatisfactionProblem;
import org.sidiff.csp.solver.impl.Variable;
import org.sidiff.graphpattern.AttributePattern;
import org.sidiff.graphpattern.Bundle;
import org.sidiff.graphpattern.EdgePattern;
import org.sidiff.graphpattern.GraphPattern;
import org.sidiff.graphpattern.GraphpatternFactory;
import org.sidiff.graphpattern.NodePattern;
import org.sidiff.graphpattern.Pattern;
import org.sidiff.graphpattern.edit.util.LabelServices;
import org.sidiff.graphpattern.tools.csp.GraphPatternMatch;
import org.sidiff.graphpattern.tools.csp.GraphPatternMatchings;
import org.sidiff.graphpattern.tools.csp.NodePatternDomain;
import org.sidiff.graphpattern.tools.csp.NodePatternDomain.EdgeMatching;
import org.sidiff.graphpattern.tools.csp.NodePatternVariable;
import org.sidiff.graphpattern.tools.editrules.generator.GraphPatternEditRuleGenerator;
import org.sidiff.graphpattern.tools.editrules.generator.util.EditRuleCollector;
import org.sidiff.graphpattern.tools.editrules.generator.util.GraphPatternGeneratorUtil;

public class RelocationEditRuleGenerator {
	
	public static final String RELOCATION_EDGES_PATTERN_NAME = "RELOCATION_EDGES";
	
	private Pattern relocationEdges;
	
	private Map<EReference, List<EdgePattern>> relocationEdgesIndex;
	
	public RelocationEditRuleGenerator(Bundle patternBundle) {
		this.relocationEdges = getRelocationEdges(patternBundle);
	}
	
	public void generateRelocationRules(Pattern pattern, EditRuleCollector editOperations) {
		
		// Compare each graph pattern with itself:
		for (GraphPattern graphPattern : pattern.getAllGraphPatterns()) {
			generateRelocationRules(graphPattern, editOperations);
		}
	}
	
	private void generateRelocationRules(GraphPattern graphPattern, EditRuleCollector editOperations) {
		List<EdgePattern> relocatableEdges = getMatches(graphPattern.getNodes());
		
//		if (graphPattern.getName().contains("Multiplicity-Many Bidirectional Reference")) {
//			System.out.println(graphPattern.getName());
//		}
		
		// NOTE: Generate only rules that synchronize two relocations:
		if (relocatableEdges.size() >= 2) {
			
			// Context nodes:
			List<NodePattern> contextNodes = new ArrayList<>();
			
			// Content nodes:
			List<NodePattern> contentNodes = new ArrayList<>();
			
			for (NodePattern node : graphPattern.getNodes()) {
				
				// Is not conditional node?
				if (!GraphPatternGeneratorUtil.isCondition(node) ) {
					
					// Is contained node?
					if (GraphPatternGeneratorUtil.isContext(node)) {
						contextNodes.add(node);
					} else {
						contentNodes.add(node);
					}
				}
			}
			
			// NOTE[Filter]: Keep content structure, i.e. relocations only between content and context.
			for (Iterator<EdgePattern> iterator = relocatableEdges.iterator(); iterator.hasNext();) {
				EdgePattern relocatableEdge = iterator.next();
				
				BooleanSupplier contextToContent = () -> contextNodes.contains(relocatableEdge.getSource()) 
						&& contentNodes.contains(relocatableEdge.getTarget());
				BooleanSupplier contentToContext = () -> contentNodes.contains(relocatableEdge.getSource()) 
						&& contextNodes.contains(relocatableEdge.getTarget()); 
				
				if (!(contextToContent.getAsBoolean() || contentToContext.getAsBoolean())) {
					iterator.remove();
				}
			}
			
			if (relocatableEdges.size() >= 2) {
				generateRelocationRules(graphPattern, relocatableEdges, contextNodes, contentNodes, editOperations);
			}
		}
	}
	
	private void generateRelocationRules(
			GraphPattern graphPattern, 
			List<EdgePattern> relocatableEdges, 
			List<NodePattern> contextNodes, 
			List<NodePattern> contentNodes,
			EditRuleCollector editOperations) {
		
		// Setup matching problem (graph pattern with itself): 
		int size = contextNodes.size() + contentNodes.size();
		
		IConstraintSatisfactionProblem<NodePattern, NodePattern> problem = new ConstraintSatisfactionProblem<>(size);
		problem.setMinimumSolutionSize(contentNodes.size());
		problem.setMaximumSolutionSize(size);
		problem.setSearchMaximumSolutions(false);
		problem.setSearchInjectiveSolutions(true);
		
		// TOTAL_BIJECTIVE without relocatable edges!
		
		// Partial matching of context:
		for (NodePattern contextNode : contextNodes) {
			NodePatternDomain domain = new NodePatternDomain(
					contextNode, contextNodes, 
					EdgeMatching.TOTAL_BIJECTIVE, EdgeMatching.TOTAL_BIJECTIVE, 
					(edge) -> relocatableEdges.contains(edge));
			Variable<NodePattern, NodePattern> variable = new NodePatternVariable(
					contextNode, domain, true, false);
			problem.addVariable(variable);
		}
		
		// Full matching of content:
		for (NodePattern contentNode : contentNodes) {
			NodePatternDomain domain = new NodePatternDomain(
					contentNode, contentNodes, 
					EdgeMatching.TOTAL_BIJECTIVE, EdgeMatching.TOTAL_BIJECTIVE,
					(edge) -> relocatableEdges.contains(edge));	
			Variable<NodePattern, NodePattern> variable = new NodePatternVariable(
					contentNode, domain, false, false);
			problem.addVariable(variable);
		}
		
		GraphPatternMatchings matchings = new GraphPatternMatchings(graphPattern, graphPattern);
		ICSPSolver<NodePattern, NodePattern> solver = new CSPSolver<>(problem, matchings);
		solver.run();
		
		// Generate edit rules:
		List<GraphPatternEditRuleGenerator> relocationEditOperations = new ArrayList<>();

		for (GraphPatternMatch match : matchings.getMatches()) {
			GraphPatternEditRuleGenerator editRuleGenerator = new GraphPatternEditRuleGenerator(
					matchings.getSubjectGraph(), 
					matchings.getValueGraph(),
					match.getMatch());
			editRuleGenerator.generate(
					matchings.getSubjectGraph().getNodes(), 
					matchings.getValueGraph().getNodes());

			Pattern editOperation = editRuleGenerator.getEditOperation();

			if (checkRelocationEditRule(editOperation, 
					editRuleGenerator.getTracePreGraph2EditGraph(), 
					editRuleGenerator.getTracePostGraph2EditGraph())) {
				relocationEditOperations.add(editRuleGenerator);
			}
		}
		
		// Add new edit rules:
		String name = "Relocation: " + graphPattern.getName();
		int counter = 0;
		
		for (GraphPatternEditRuleGenerator generated : relocationEditOperations) {
			
			if (relocationEditOperations.size() > 1) {
				generated.setName(name + " (" + ++counter + ")");
			} else {
				generated.setName(name);
			}
			
			editOperations.add(graphPattern, generated.getEditOperation());
		}
	}

	private boolean checkRelocationEditRule(Pattern editOperation, 
			Map<NodePattern, NodePattern> tracePreGraph2EditRule, 
			Map<NodePattern, NodePattern> tracePostGraph2EditRule) {
		
		// Contains at least two relocatable edges?
		int relocatableEdgesCount = 0;
		
		// Contains only changes on relocatable edges?
		for (GraphPattern graph : editOperation.getGraphs()) {
			for (NodePattern node : graph.getNodes()) {
				if (node.getStereotypes().contains(delete) || node.getStereotypes().contains(create)) {
					return false;
				}
				for (EdgePattern edge : node.getOutgoings()) {
					if (edge.getStereotypes().contains(delete) || edge.getStereotypes().contains(create)) {
						if (isRelocation(edge, tracePreGraph2EditRule, tracePostGraph2EditRule)) {
							
							// NOTE: Counting without opposites:
							if (isRelocatableReference(edge.getSource().getType(), edge.getType(), edge.getTarget().getType()) ) {
								++relocatableEdgesCount;
							}
						} else {
							return false;
						}
					}
				}
				for (AttributePattern attribute : node.getAttributes()) {
					if (attribute.getStereotypes().contains(delete) || attribute.getStereotypes().contains(create)) {
						return false;
					}
				}
			}
		}
		
		// Need at least two relocations for synchronization edit rule!
		// NOTE: We need at least two relocatable (none opposite) edges for one relocation (remove, create). 
		return relocatableEdgesCount >= 4;
	}
	
	protected boolean isRelocation(EdgePattern editRuleEdge, 
			Map<NodePattern, NodePattern> tracePreGraph2EditRule,
			Map<NodePattern, NodePattern> tracePostGraph2EditRule) {
		
		// NOTE: A relocation happens only between a mapped node 
		//       and a none mapped node of the pre- and post-graph!
		if (isRelocatableEdge(editRuleEdge)) {
			NodePattern editRuleSource = editRuleEdge.getSource();
			NodePattern editRuleTarget = editRuleEdge.getTarget();
			
			boolean editRuleSourceMapped = 
					tracePreGraph2EditRule.containsValue(editRuleSource) &&
					tracePostGraph2EditRule.containsValue(editRuleSource);
			
			boolean editRuleTargetMapped = 
					tracePreGraph2EditRule.containsValue(editRuleTarget) &&
					tracePostGraph2EditRule.containsValue(editRuleTarget);
			
			if ((editRuleSourceMapped && !editRuleTargetMapped)
					|| (!editRuleSourceMapped && editRuleTargetMapped)) {
				return true;
			}
		}
		
		return false;
	}

	public Pattern getRelocationEdges() {
		return relocationEdges;
	}
	
	public Map<EReference, List<EdgePattern>> getRelocationEdgesIndex() {
		
		if (relocationEdgesIndex == null) {
			this.relocationEdgesIndex = getRelocationEdgesIndex(relocationEdges);
		}
		
		return relocationEdgesIndex;
	}

	private List<EdgePattern> getMatches(List<NodePattern> nodes) {
		List<EdgePattern> matches = new ArrayList<>();
		
		for (NodePattern node : nodes) {
			for (EdgePattern edge : node.getOutgoings()) {
				if (isRelocatableEdge(edge)) {
					matches.add(edge);
				}
			}
		}
		
		return matches;
	}
	
	private boolean isRelocatableEdge(EdgePattern toBeMatched) {
		
		if (toBeMatched != null) {
			
			// Edge is relocatable...
			if (isRelocatableReference(
					toBeMatched.getSource().getType(),
					toBeMatched.getType(),
					toBeMatched.getTarget().getType())) {
				return true;
			}
			
			// ...or its opposite:
			if (isRelocatableReference(
					toBeMatched.getTarget().getType(),
					toBeMatched.getType().getEOpposite(),
					toBeMatched.getSource().getType())) {
				return true;
			}
		}
		
		return false;
	}
	
	private boolean isRelocatableReference(EClass source, EReference reference, EClass target) {
		List<EdgePattern> potentialMatches = getRelocationEdgesIndex().get(reference);
		
		if (potentialMatches != null) {
			for (EdgePattern potentialMatch : potentialMatches) {
				boolean sourceMatch = EMFMetaAccess.isAssignableTo(source, potentialMatch.getSource().getType());
				boolean targetMatch = EMFMetaAccess.isAssignableTo(target, potentialMatch.getTarget().getType());
				
				if (sourceMatch && targetMatch) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	private static Map<EReference, List<EdgePattern>> getRelocationEdgesIndex(Pattern relocationEdges) {
		Map<EReference, List<EdgePattern>> relocationEdgesIndex = new HashMap<>();
		
		for (GraphPattern graphPattern : relocationEdges.getAllGraphPatterns()) {
			EdgePattern relocationEdge = null;
			
			// NOTE: Assert exactly one edge per graph pattern:
			for (NodePattern node : graphPattern.getNodes()) {
				if (!node.getOutgoings().isEmpty()) {
					relocationEdge = node.getOutgoings().get(0);
				}
			}
			
			List<EdgePattern> relocationGraphPatterns = relocationEdgesIndex.get(relocationEdge.getType());
			
			if (relocationGraphPatterns == null) {
				relocationGraphPatterns = new ArrayList<>(1);
				relocationEdgesIndex.put(relocationEdge.getType(), relocationGraphPatterns);
			}
			
			relocationGraphPatterns.add(relocationEdge);
		}
		
		return relocationEdgesIndex;
	}
	
	private static Pattern getRelocationEdges(Bundle editRuleBundle) {
		return editRuleBundle.getPattern(RELOCATION_EDGES_PATTERN_NAME);
	}

	public static Pattern initializeRelocationEdges(Bundle editRuleBundle) {
		
		// Initialize new relocation edges pattern container:
		Pattern relocationEdgesPattern = GraphpatternFactory.eINSTANCE.createPattern();
		relocationEdgesPattern.setName(RELOCATION_EDGES_PATTERN_NAME);
		editRuleBundle.getPatterns().add(relocationEdgesPattern);
		
		// Search all EReferences in the meta-mode(s):
		for (EPackage ePackage : editRuleBundle.getDomains()) {
			for(EClassifier eClassifier : ePackage.getEClassifiers()) {
				if (eClassifier instanceof EClass) {
					EClass eClass = (EClass) eClassifier;
					
					for (EReference eReference : eClass.getEReferences()) {
						if (!EMFMetaAccess.isUnconsideredStructualFeature(eReference)) {
							
							// Create new relocation edge pattern:
							GraphPattern relocationEdge = GraphpatternFactory.eINSTANCE.createGraphPattern();
							
							// Source
							NodePattern source = GraphpatternFactory.eINSTANCE.createNodePattern();
							source.setType(eClass);
							relocationEdge.getNodes().add(source);
							
							// Target
							NodePattern target = GraphpatternFactory.eINSTANCE.createNodePattern();
							target.setType((EClass) eReference.getEType());
							relocationEdge.getNodes().add(target);
							
							// Edge
							EdgePattern edge = GraphpatternFactory.eINSTANCE.createEdgePattern();
							edge.setType(eReference);
							edge.setSource(source);
							edge.setTarget(target);
							
							// Add to collection:
							relocationEdge.setName(LabelServices.getLabel(edge));
							relocationEdgesPattern.getGraphs().add(relocationEdge);
						}
					}
				}
			}
		}
		
		return relocationEdgesPattern;
	}
}
