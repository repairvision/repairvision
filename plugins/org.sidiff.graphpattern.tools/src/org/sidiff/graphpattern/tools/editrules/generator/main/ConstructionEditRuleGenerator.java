package org.sidiff.graphpattern.tools.editrules.generator.main;

import java.util.Collections;
import java.util.Iterator;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.sidiff.graphpattern.GraphPattern;
import org.sidiff.graphpattern.GraphpatternPackage;
import org.sidiff.graphpattern.NodePattern;
import org.sidiff.graphpattern.Parameter;
import org.sidiff.graphpattern.Pattern;
import org.sidiff.graphpattern.tools.editrules.generator.GraphPatternEditRuleGenerator;
import org.sidiff.graphpattern.tools.editrules.generator.conditions.UnfulfillableConditions;
import org.sidiff.graphpattern.tools.editrules.generator.util.EditRuleCollector;

public class ConstructionEditRuleGenerator {

	private static EClass pseudoResourceClass = GraphpatternPackage.eINSTANCE.getResource();
	
	public static void generateCreationRules(Pattern pattern, EditRuleCollector editRules, boolean checkDangling) {
		
		// Generate edit rules:
		for (GraphPattern graphPattern : pattern.getGraphs()) {
			
//			if (graphPattern.getName().contains("Class with Bound Generic Type Parameter")) {
//				System.out.println(graphPattern.getName());
//			}
			
			GraphPatternEditRuleGenerator generator = new GraphPatternEditRuleGenerator(null, graphPattern, Collections.emptyMap());
			generator.generate(Collections.emptyList(), graphPattern.getNodes());
			generator.setName("Create: " + graphPattern.getName());
			
			Pattern editOperation = generator.getEditOperation();
			GraphPattern editRule = generator.getEditRule();
			
			// Add context and conditions:
			removePseudoResourceNode(editRule);
			
			// Add new edit rule for graph pattern:
			if (UnfulfillableConditions.check(editRule, checkDangling)) {
				editRules.add(graphPattern, editOperation);
			} else {
				System.err.println("WARNING: Unfulfillable condition found: " + editRule.getName());
			}
		}
		
		// Generate sub-patterns:
		for (Pattern subPattern : pattern.getSubpatterns()) {
			generateCreationRules(subPattern, editRules, checkDangling);
		}
	}

	public static void generateDeletionRules(Pattern pattern, EditRuleCollector editRules, boolean checkDangling) {
		
		// Generate edit rules:
		for (GraphPattern graphPattern : pattern.getGraphs()) {
			
//			if (graphPattern.getName().contains("Containment-Container and Containment Reference")) {
//				System.out.println(graphPattern.getName());
//			}
			
			GraphPatternEditRuleGenerator generator = new GraphPatternEditRuleGenerator(graphPattern, null, Collections.emptyMap());
			generator.generate(graphPattern.getNodes(), Collections.emptyList());
			generator.setName("Delete: " + graphPattern.getName());
			
			Pattern editOperation = generator.getEditOperation();
			GraphPattern editRule = generator.getEditRule();
			
			// Add context and conditions:
			removePseudoResourceNode(editRule);
			
			// Add new edit rule for graph pattern:
			if (UnfulfillableConditions.check(editRule, checkDangling)) {
				editRules.add(graphPattern, editOperation);
			} else {
				System.err.println("WARNING: Unfulfillable condition found: " + editRule.getName());
			}
		}
		
		// Generate sub-patterns:
		for (Pattern subPattern : pattern.getSubpatterns()) {
			generateDeletionRules(subPattern, editRules, checkDangling);
		}
	}
	
	protected static void removePseudoResourceNode(GraphPattern editRule) {
		
		// Remove (pseudo) resource node:
		for (Iterator<NodePattern> iterator = editRule.getNodes().iterator(); iterator.hasNext();) {
			NodePattern node = iterator.next();
			
			if (node.getType().equals(pseudoResourceClass)) {
				Parameter parameter = editRule.getPattern().getParameter(node.getName());
				
				if (parameter != null) {
					EcoreUtil.remove(parameter);
				}
				
				node.removeIncident();
				iterator.remove();
			}
		}
	}
}
