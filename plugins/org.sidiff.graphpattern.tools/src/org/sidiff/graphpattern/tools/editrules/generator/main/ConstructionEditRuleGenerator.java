package org.sidiff.graphpattern.tools.editrules.generator.main;

import static org.sidiff.graphpattern.profile.constraints.ConstraintStereotypes.not;
import static org.sidiff.graphpattern.profile.henshin.HenshinStereotypes.create;
import static org.sidiff.graphpattern.profile.henshin.HenshinStereotypes.delete;
import static org.sidiff.graphpattern.profile.henshin.HenshinStereotypes.preserve;
import static org.sidiff.graphpattern.profile.henshin.HenshinStereotypes.rule;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.sidiff.consistency.common.emf.ModelingUtil;
import org.sidiff.graphpattern.AttributePattern;
import org.sidiff.graphpattern.EdgePattern;
import org.sidiff.graphpattern.GraphElement;
import org.sidiff.graphpattern.GraphPattern;
import org.sidiff.graphpattern.GraphpatternFactory;
import org.sidiff.graphpattern.GraphpatternPackage;
import org.sidiff.graphpattern.NodePattern;
import org.sidiff.graphpattern.Pattern;
import org.sidiff.graphpattern.Stereotype;
import org.sidiff.graphpattern.profile.constraints.util.ConstraintProfileUtil;
import org.sidiff.graphpattern.profile.henshin.util.HenshinProfileUtil;
import org.sidiff.graphpattern.tools.editrules.generator.util.GraphPatternGeneratorUtil;

// TODO: Generalize as by TransformationEditRuleGenerator
public class ConstructionEditRuleGenerator {

	private static EClass pseudoResourceClass = GraphpatternPackage.eINSTANCE.getResource();
	
	public static void generateCreationRules(Pattern pattern, Map<GraphPattern, List<Pattern>> editRules) {
		
		// Generate edit rules:
		for (GraphPattern graphPattern : pattern.getGraphs()) {
			List<Pattern> creationRules = new ArrayList<>();
			
//			if (graphPattern.getName().contains("Class with Bound Generic Type Parameter")) {
//				System.out.println(graphPattern.getName());
//			}
			
			// Copy graph constraints:
			String name = "Create: " + graphPattern.getName();
			
			GraphPattern editRule = (GraphPattern) ModelingUtil.deepCopy(graphPattern).get(graphPattern);
			editRule.setName(name);
			editRule.getStereotypes().add(rule);
			
			Pattern editOperation = GraphpatternFactory.eINSTANCE.createPattern();
			editOperation.setName(name);
			editOperation.getGraphs().add(editRule);
			
			creationRules.add(editOperation);
			
			// Set edit rule actions:
			setConstructionAction(editRule, create);
			
			// Remove negative graph postcondition constraints:
			// (NAC incident to create node.)
			if (HenshinProfileUtil.hasPostCondition(editRule)) {
				ConstraintProfileUtil.removeNAC(editRule);
			}
			
//			// Generate rules with connected fragments:
//			generateFragmentRules(create, graphPattern, editRule, editRules);
			
			// Generate parameters:
			GraphPatternGeneratorUtil.generateParameters(editOperation);
			
			// Add new edit rule for graph pattern:
			editRules.merge(graphPattern, creationRules, (v1, v2) -> {v1.addAll(v2); return v1;});
		}
		
		// Generate sub-patterns:
		for (Pattern subPattern : pattern.getSubpatterns()) {
			generateCreationRules(subPattern, editRules);
		}
	}

	public static void generateDeletionRules(Pattern pattern, Map<GraphPattern, List<Pattern>> editRules) {
		
		// Generate edit rules:
		for (GraphPattern graphPattern : pattern.getGraphs()) {
			List<Pattern> deletionRules = new ArrayList<>();
			
//			if (graphPattern.getName().contains("Containment-Container and Containment Reference")) {
//				System.out.println(graphPattern.getName());
//			}
			
			// Copy graph constraints:
			String name = "Delete: " + graphPattern.getName();
			
			GraphPattern editRule = (GraphPattern) ModelingUtil.deepCopy(graphPattern).get(graphPattern);
			editRule.setName(name);
			editRule.getStereotypes().add(rule);
			
			Pattern editOperation = GraphpatternFactory.eINSTANCE.createPattern();
			editOperation.setName(name);
			editOperation.getGraphs().add(editRule);
			
			deletionRules.add(editOperation);
			
			// Remove negative graph constraints:
			ConstraintProfileUtil.removeNAC(editRule);
			
			// Set edit rule actions:
			setConstructionAction(editRule, delete);
			
//			// Generate rules with connected fragments:
//			generateFragmentRules(delete, graphPattern, editRule, editRules);
			
			// Generate parameters:
			GraphPatternGeneratorUtil.generateParameters(editOperation);
			
			// Add new edit rule for graph pattern:
			editRules.merge(graphPattern, deletionRules, (v1, v2) -> {v1.addAll(v2); return v1;});
		}
		
		// Generate sub-patterns:
		for (Pattern subPattern : pattern.getSubpatterns()) {
			generateDeletionRules(subPattern, editRules);
		}
	}
	
	protected static void generateFragmentRules(Stereotype action, GraphPattern graphPattern, GraphPattern editRule, Map<GraphPattern, List<Pattern>> editRules) {

		// Get all changed graph elements:
		Stack<GraphElement> allChanges = new Stack<>();
		
		for (GraphElement graphElement : editRule.getGraphElements()) {
			if (graphElement.getStereotypes().contains(action)) {
				allChanges.add(graphElement);
			}
		}
		
		// Search fragments:
		List<List<GraphElement>> fragments = new ArrayList<>(); 
		findFragments(action, fragments, allChanges);
		
		// No fragments?
		if (fragments.size() == 1) {
			return;
		}
		
		// Generate fragments:
		List<Pattern> fragmentRules = new ArrayList<>();
		
		for (int i = 0; i < fragments.size(); i++) {
			String name = editRule.getName() + " (" + (i + 1) + ")";
			
			Map<EObject, EObject> copyTrace = ModelingUtil.deepCopy(editRule);
			GraphPattern fragmentEditRule = (GraphPattern) copyTrace.get(editRule);
			fragmentEditRule.setName(name);
			fragmentEditRule.getStereotypes().add(rule);
			
			Pattern fragmentEditOperation = GraphpatternFactory.eINSTANCE.createPattern();
			fragmentEditOperation.setName(name);
			fragmentEditOperation.getGraphs().add(fragmentEditRule);
			
			fragmentRules.add(fragmentEditOperation);
			
			// Remove action that are not included in the fragment:
			List<GraphElement> fragment = fragments.get(i);
			
			for (GraphElement graphElement : fragmentEditRule.getGraphElements()) {
				if (graphElement.getStereotypes().contains(action) && !isContainedInFragment(fragment, graphElement, copyTrace)) {
					graphElement.getStereotypes().remove(action);
					graphElement.getStereotypes().add(preserve);
				}
			}
			
			// Generate parameters:
			GraphPatternGeneratorUtil.generateParameters(fragmentEditOperation);
		}
		
		// Add new edit rule for graph pattern:
		editRules.merge(graphPattern, fragmentRules, (v1, v2) -> {v1.addAll(v2); return v1;});
	}
	
	protected static boolean isContainedInFragment(List<GraphElement> fragment,  GraphElement element, Map<EObject, EObject> copyTrace) {
		for (GraphElement fragmentElement : fragment) {
			if (copyTrace.get(fragmentElement) == element) {
				return true;
			}
		}
		return false;
	}
	
	protected static void findFragments(Stereotype action, List<List<GraphElement>> fragments, Stack<GraphElement> remainingChanges) {
		
		while (!remainingChanges.isEmpty()) {
			GraphElement firstElement = remainingChanges.pop();
			List<GraphElement> fragment = new ArrayList<>();
			firstElement.getClosure(e -> e.getStereotypes().contains(action)).forEach(fragment::add);
			remainingChanges.removeAll(fragment);
			fragments.add(fragment);
		}
	}

	protected static void setConstructionAction(GraphPattern editRule, Stereotype constructionST) {
		
		// Set node actions:
		for (NodePattern node : editRule.getNodes()) {
			
			// Filter negative application conditions:
			if (!node.getStereotypes().contains(not)) {
				
				// Is contained node?
				if (node.getIncomings().stream().anyMatch(e -> e.getType().isContainment())) {
					node.getStereotypes().add(constructionST);
					
					// Set attribute actions:
					for (AttributePattern attribute : node.getAttributes()) {
						attribute.getStereotypes().add(constructionST);
					}
				} else {
					
					// Context element:
					node.getStereotypes().add(preserve);
					
					// Set attribute actions:
					for (AttributePattern attribute : node.getAttributes()) {
						attribute.getStereotypes().add(preserve);
					}
				}
			}
		}
		
		// Set edge actions:
		for (NodePattern node : editRule.getNodes()) {
			
			// Filter negative application conditions:
			if (!node.getStereotypes().contains(not)) {
				
				// Set edge actions:
				for (EdgePattern edge : node.getOutgoings()) {
					
					// Edge between context nodes?
					// FIXME: Other solution!?
					if (edge.getSource().getStereotypes().contains(preserve)
							&& edge.getTarget().getStereotypes().contains(preserve)) {
						edge.getStereotypes().add(preserve);
					} else {
						edge.getStereotypes().add(constructionST);
					}
				}
			}
		}
		
		// Remove (pseudo) resource node:
		for (Iterator<NodePattern> iterator = editRule.getNodes().iterator(); iterator.hasNext();) {
			NodePattern node = iterator.next();
			
			if (node.getType().equals(pseudoResourceClass)) {
				node.removeIncident();
				iterator.remove();
			}
		}
	}
}
