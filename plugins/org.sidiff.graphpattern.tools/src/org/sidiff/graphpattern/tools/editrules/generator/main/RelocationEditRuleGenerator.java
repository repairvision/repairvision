package org.sidiff.graphpattern.tools.editrules.generator.main;

import static org.sidiff.graphpattern.profile.constraints.ConstraintStereotypes.not;
import static org.sidiff.graphpattern.profile.constraints.ConstraintStereotypes.require;

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
import org.sidiff.graphpattern.Bundle;
import org.sidiff.graphpattern.EdgePattern;
import org.sidiff.graphpattern.GraphPattern;
import org.sidiff.graphpattern.GraphpatternFactory;
import org.sidiff.graphpattern.NodePattern;
import org.sidiff.graphpattern.Pattern;
import org.sidiff.graphpattern.edit.util.LabelServices;
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
		
		// NOTE: Generate only rules that synchronize two relocations:
		if (relocatableEdges.size() >= 2) {
			
			// Context nodes:
			List<NodePattern> contextNodes = new ArrayList<>();
			
			// Content nodes:
			List<NodePattern> contentNodes = new ArrayList<>();
			
			for (NodePattern node : graphPattern.getNodes()) {
				
				// Is not conditional node?
				if (!node.getStereotypes().contains(not) && !node.getStereotypes().contains(require)) {
					
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
		
		// TODO: Setup matching problem: 
		// - graph pattern with itself
		// - full matching of content -> partial pre-match
		// - partial matching of context
		System.out.println(graphPattern.getName());
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

	public List<EdgePattern> getMatches(List<NodePattern> nodes) {
		List<EdgePattern> matches = new ArrayList<>();
		
		for (NodePattern node : nodes) {
			for (EdgePattern edge : node.getOutgoings()) {
				if (match(edge)) {
					matches.add(edge);
				}
			}
		}
		
		return matches;
	}
	
	public boolean match(EdgePattern toBeMatched) {
		List<EdgePattern> potentialMatches = getRelocationEdgesIndex().get(toBeMatched.getType());
		
		if (potentialMatches != null) {
			for (EdgePattern potentialMatch : potentialMatches) {
				boolean sourceMatch = potentialMatch.getSource().getType() == toBeMatched.getSource().getType();
				boolean targetMatch = potentialMatch.getTarget().getType() == toBeMatched.getTarget().getType();
					
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
