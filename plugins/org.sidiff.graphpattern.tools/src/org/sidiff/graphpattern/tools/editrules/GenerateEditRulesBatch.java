package org.sidiff.graphpattern.tools.editrules;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.sidiff.common.emf.modelstorage.EMFHandlerUtil;
import org.sidiff.consistency.common.emf.ModelingUtil;
import org.sidiff.csp.solver.CSPSolver;
import org.sidiff.csp.solver.ConstraintSatisfactionProblem;
import org.sidiff.csp.solver.Domain;
import org.sidiff.csp.solver.Variable;
import org.sidiff.csp.solver.impl.CSPSolverImpl;
import org.sidiff.csp.solver.impl.ConstraintSatisfactionProblemImpl;
import org.sidiff.csp.solver.impl.VariableImpl;
import org.sidiff.csp.solver.impl.solution.SolutionsList;
import org.sidiff.graphpattern.AttributePattern;
import org.sidiff.graphpattern.Bundle;
import org.sidiff.graphpattern.EdgePattern;
import org.sidiff.graphpattern.GraphPattern;
import org.sidiff.graphpattern.GraphpatternPackage;
import org.sidiff.graphpattern.NodePattern;
import org.sidiff.graphpattern.Pattern;
import org.sidiff.graphpattern.Profile;
import org.sidiff.graphpattern.Stereotype;
import org.sidiff.graphpattern.profile.extensions.GraphPatternProfileLibrary;

public class GenerateEditRulesBatch extends AbstractHandler {

	private static Profile editRuleProfile = GraphPatternProfileLibrary.getEntry("org.sidiff.graphpattern.profile.henshin").getProfile().getProfile();
	
	private static Profile constraintsProfile = GraphPatternProfileLibrary.getEntry("org.sidiff.graphpattern.profile.constraints").getProfile().getProfile();
	
	private static Stereotype preserveST = editRuleProfile.getStereotype("preserve");
	
	private static Stereotype createST = editRuleProfile.getStereotype("create");
	
	private static Stereotype deleteST = editRuleProfile.getStereotype("delete");
	
	private static Stereotype notST = constraintsProfile.getStereotype("not");
	
	private static EClass pseudoResourceClass = GraphpatternPackage.eINSTANCE.getResource();
	
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		Bundle patternBundle = EMFHandlerUtil.getSelection(event, Bundle.class);
		
		if (patternBundle != null) {
			
			// Setup edit rule profile:
			patternBundle.getProfiles().add(editRuleProfile);
			
			// Generate edit rules:
			Map<GraphPattern, List<GraphPattern>> editRules = new HashMap<>();
			
			for (Pattern pattern : patternBundle.getPatterns()) {
				generateCreationRules(pattern, editRules);
				generateDeletionRules(pattern, editRules);
				generateStructuralTransformationRules(pattern, editRules);
			}
			
			editRules.forEach((pattern, rules) -> pattern.getPattern().getGraphs().addAll(rules));
			
			// Save edit rules:
			URI originalURI = patternBundle.eResource().getURI();
			URI editRulesURI = URI.createURI(originalURI.trimFileExtension() + "_editrules").appendFileExtension("graphpattern");
			patternBundle.eResource().setURI(editRulesURI);
			
			try {
				patternBundle.eResource().save(Collections.emptyMap());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return null;
	}
	
	public static void generateCreationRules(Pattern pattern, Map<GraphPattern, List<GraphPattern>> editRules) {
		
		// Generate edit rules:
		for (GraphPattern graphPattern : pattern.getGraphs()) {
			List<GraphPattern> creationRules = new ArrayList<>(1);
			
			// Copy graph constraints:
			GraphPattern editRule = (GraphPattern) ModelingUtil.deepCopy(graphPattern).get(graphPattern);
			editRule.setName("create: " + graphPattern.getName());
			creationRules.add(editRule);
			
			// Set edit rule actions:
			setConstructionAction(editRule, createST);
			
			// Add new edit rule for graph pattern:
			editRules.merge(graphPattern, creationRules, (v1, v2) -> {v1.addAll(v2); return v1;});
		}
		
		// Generate sub-patterns:
		for (Pattern subPattern : pattern.getSubpatterns()) {
			generateCreationRules(subPattern, editRules);
		}
	}
	
	public static void generateDeletionRules(Pattern pattern, Map<GraphPattern, List<GraphPattern>> editRules) {
		
		// Generate edit rules:
		for (GraphPattern graphPattern : pattern.getGraphs()) {
			List<GraphPattern> deletionRules = new ArrayList<>(1);
			
			// Copy graph constraints:
			GraphPattern editRule = (GraphPattern) ModelingUtil.deepCopy(graphPattern).get(graphPattern);
			editRule.setName("delete: " + graphPattern.getName());
			deletionRules.add(editRule);
			
			// Remove negative graph constraints:
			for (Iterator<NodePattern> iterator = editRule.getNodes().iterator(); iterator.hasNext();) {
				NodePattern node = iterator.next();
				
				if (!node.getStereotypes().isEmpty()) {
					if (node.getStereotypes().contains(notST)) {
						node.removeIncident();
						iterator.remove();
					}
				}
			}
			
			// Set edit rule actions:
			setConstructionAction(editRule, deleteST);
			
			// Add new edit rule for graph pattern:
			editRules.merge(graphPattern, deletionRules, (v1, v2) -> {v1.addAll(v2); return v1;});
		}
		
		// Generate sub-patterns:
		for (Pattern subPattern : pattern.getSubpatterns()) {
			generateDeletionRules(subPattern, editRules);
		}
	}

	protected static void setConstructionAction(GraphPattern editRule, Stereotype constructionST) {
		
		// Set node actions:
		for (NodePattern node : editRule.getNodes()) {
			
			// Filter negative application conditions:
			if (!node.getStereotypes().contains(notST)) {
				
				// Is contained node?
				if (node.getIncomings().stream().anyMatch(e -> e.getType().isContainment())) {
					node.getStereotypes().add(constructionST);
					
					// Set attribute actions:
					for (AttributePattern attribute : node.getAttributes()) {
						attribute.getStereotypes().add(constructionST);
					}
				} else {
					
					// Context element:
					node.getStereotypes().add(preserveST);
					
					// Set attribute actions:
					for (AttributePattern attribute : node.getAttributes()) {
						attribute.getStereotypes().add(preserveST);
					}
				}
				
				
				// Set edge actions:
				for (EdgePattern edge : node.getOutgoings()) {
					
					// Edge between context nodes?
					if (edge.getSource().getStereotypes().contains(preserveST)
							&& edge.getTarget().getStereotypes().contains(preserveST)) {
						edge.getStereotypes().add(preserveST);
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
	
	public static void generateStructuralTransformationRules(Pattern pattern, Map<GraphPattern, List<GraphPattern>> editRules) {
		List<GraphPattern> allGraphPatterns = pattern.getAllGraphPatterns();
		
		// Generate edit rules:
		// Consider cross-product of all graph patterns:
		for (GraphPattern fromPattern : allGraphPatterns) {
			
//			if (fromPattern.getName().contains("Two Containment Self-References")) {
//				System.out.println(fromPattern.getName());
//			} else {
//				continue;
//			}
			
			for (GraphPattern toPattern : allGraphPatterns) {
				if (fromPattern != toPattern) {
					
//					if (toPattern.getName().contains("Two Containment-Container Self-References")) {
//						System.out.println(toPattern.getName());
//					} else {
//						continue;
//					}
					
					// Check if there is a (full) node matching between the graph patterns:
					// Compare the nodes by their assigned class types:
					if (EditRuleGeneratorUtil.isTypeEqual(fromPattern.getNodes(), toPattern.getNodes())) {
						ConstraintSatisfactionProblem<NodePattern> problem = new ConstraintSatisfactionProblemImpl<>(fromPattern.getNodes().size());
						problem.setMinimumSolutionSize(fromPattern.getNodes().size());
						problem.setMaximumSolutionSize(fromPattern.getNodes().size());
						problem.setSearchMaximumSolutions(true);
						
						for (NodePattern fromNode : fromPattern.getNodes()) {
							Domain<NodePattern> domain = EditRuleGeneratorUtil.getDomain(fromNode, toPattern.getNodes());
							Variable<NodePattern> variable = new VariableImpl<NodePattern>(domain);
							problem.addVariable(variable);
						}
						
						SolutionsList<NodePattern> solutions = new SolutionsList<>();
						CSPSolver<NodePattern> solver = new CSPSolverImpl<>(problem, solutions);
						solver.run();
						
						System.out.println("transform (structural only, same negative constraints)["
								+ solutions.getSolutions().size() + "]: " + fromPattern.getName() + " - to - "
								+ toPattern.getName());

//						for (Solution<NodePattern> solution : solutions.getSolutions()) {
//							
//						}
					}
				}
			}
		}
	}
}
