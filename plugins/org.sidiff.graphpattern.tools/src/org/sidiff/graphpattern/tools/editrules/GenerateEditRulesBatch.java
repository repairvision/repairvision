package org.sidiff.graphpattern.tools.editrules;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.common.util.URI;
import org.sidiff.common.emf.modelstorage.EMFHandlerUtil;
import org.sidiff.consistency.common.emf.ModelingUtil;
import org.sidiff.graphpattern.AttributePattern;
import org.sidiff.graphpattern.Bundle;
import org.sidiff.graphpattern.EdgePattern;
import org.sidiff.graphpattern.GraphPattern;
import org.sidiff.graphpattern.NodePattern;
import org.sidiff.graphpattern.Pattern;
import org.sidiff.graphpattern.Profile;
import org.sidiff.graphpattern.Stereotype;
import org.sidiff.graphpattern.profile.extensions.GraphPatternProfileLibrary;

public class GenerateEditRulesBatch extends AbstractHandler {

	private static Profile editRuleProfile = GraphPatternProfileLibrary.getEntry("org.sidiff.graphpattern.profile.henshin").getProfile().getProfile();
	
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
		Stereotype createST = editRuleProfile.getStereotype("create");
		Stereotype preserveST = editRuleProfile.getStereotype("preserve");
		
		// Generate edit rules:
		for (GraphPattern graphPattern : pattern.getGraphs()) {
			List<GraphPattern> creationRules = new ArrayList<>(1);
			
			GraphPattern editRule = (GraphPattern) ModelingUtil.deepCopy(graphPattern).get(graphPattern);
			editRule.setName("create - " + graphPattern.getName());
			creationRules.add(editRule);
			
			// set node actions:
			for (NodePattern node : editRule.getNodes()) {
				
				// is contained node?
				// TODO: create root element!
				if (node.getIncomings().stream().anyMatch(e -> e.getType().isContainment())) {
					node.getStereotypes().add(createST);
					
					// set attribute actions:
					for (AttributePattern attribute : node.getAttributes()) {
						attribute.getStereotypes().add(createST);
					}
				} else {
					node.getStereotypes().add(preserveST);
					
					// set attribute actions:
					for (AttributePattern attribute : node.getAttributes()) {
						attribute.getStereotypes().add(preserveST);
					}
				}
				
				// set edge actions:
				for (EdgePattern edge : node.getOutgoings()) {
					edge.getStereotypes().add(createST);
				}
			}
			
			editRules.merge(graphPattern, creationRules, (v1, v2) -> {v1.addAll(v2); return v1;});
		}
		
		// Generate sub-patterns:
		for (Pattern subPattern : pattern.getSubpatterns()) {
			generateCreationRules(subPattern, editRules);
		}
	}
	
	public static void generateDeletionRules(Pattern pattern, Map<GraphPattern, List<GraphPattern>> editRules) {
		Stereotype deleteST = editRuleProfile.getStereotype("delete");
		Stereotype preserveST = editRuleProfile.getStereotype("preserve");
		
		// Generate edit rules:
		for (GraphPattern graphPattern : pattern.getGraphs()) {
			List<GraphPattern> deletionRules = new ArrayList<>(1);
			
			GraphPattern editRule = (GraphPattern) ModelingUtil.deepCopy(graphPattern).get(graphPattern);
			editRule.setName("delete - " + graphPattern.getName());
			deletionRules.add(editRule);
			
			// set node actions:
			for (NodePattern node : editRule.getNodes()) {
				
				// is contained node?
				// TODO: create root element!
				if (node.getIncomings().stream().anyMatch(e -> e.getType().isContainment())) {
					node.getStereotypes().add(deleteST);
					
					// set attribute actions:
					for (AttributePattern attribute : node.getAttributes()) {
						attribute.getStereotypes().add(deleteST);
					}
				} else {
					node.getStereotypes().add(preserveST);
					
					// set attribute actions:
					for (AttributePattern attribute : node.getAttributes()) {
						attribute.getStereotypes().add(preserveST);
					}
				}
				
				
				// set edge actions:
				for (EdgePattern edge : node.getOutgoings()) {
					edge.getStereotypes().add(deleteST);
				}
			}
			
			editRules.merge(graphPattern, deletionRules, (v1, v2) -> {v1.addAll(v2); return v1;});
		}
		
		// Generate sub-patterns:
		for (Pattern subPattern : pattern.getSubpatterns()) {
			generateDeletionRules(subPattern, editRules);
		}
	}
	
	public static void generateStructuralTransformationRules(Pattern pattern, Map<GraphPattern, List<GraphPattern>> editRules) {
	}
}
