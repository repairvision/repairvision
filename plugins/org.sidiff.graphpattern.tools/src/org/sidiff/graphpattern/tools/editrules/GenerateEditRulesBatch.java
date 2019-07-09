package org.sidiff.graphpattern.tools.editrules;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.common.util.URI;
import org.sidiff.common.emf.modelstorage.EMFHandlerUtil;
import org.sidiff.consistency.common.ui.util.WorkbenchUtil;
import org.sidiff.graphpattern.Bundle;
import org.sidiff.graphpattern.GraphPattern;
import org.sidiff.graphpattern.Pattern;
import org.sidiff.graphpattern.profile.henshin.HenshinStereotypes;
import org.sidiff.graphpattern.tools.editrules.generator.main.ConstructionEditRuleGenerator;
import org.sidiff.graphpattern.tools.editrules.generator.main.TransformationEditRuleGenerator;

public class GenerateEditRulesBatch extends AbstractHandler {
	
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		Bundle patternBundle = EMFHandlerUtil.getSelection(event, Bundle.class);
		
		if (patternBundle != null) {
			
			// Setup edit rule profile:
			patternBundle.getProfiles().add(HenshinStereotypes.profile_model);
			
			// Generate edit rules:
			Map<GraphPattern, List<Pattern>> editOperations = new HashMap<>();
			
			for (Pattern pattern : patternBundle.getPatterns()) {
				String[] generators = new String[] {
						"Creation Rules Generator",
						"Deletion Rules Generator",
						"Transformation Rules Generator"};
				
				List<String> selection = WorkbenchUtil.showSelections("Select Edit Rule Generators:", 
						Arrays.asList(generators), Arrays.asList(generators), WorkbenchUtil.getEMFLabelProvider());
				
				if (selection.contains(generators[0])) {
					ConstructionEditRuleGenerator.generateCreationRules(pattern, editOperations);
				}
				
				if (selection.contains(generators[1])) {
					ConstructionEditRuleGenerator.generateDeletionRules(pattern, editOperations);
				}
				
				if (selection.contains(generators[2])) {
					TransformationEditRuleGenerator.generateStructuralTransformationRules(pattern, editOperations);
				}
			}
			
//			System.out.println("Edit Operations: " + editOperations.values().stream().mapToInt(List::size).sum());
			
			editOperations.forEach((preConstraint, operations) -> {
				for (Pattern editOperation : operations) {
					preConstraint.getPattern().getSubpatterns().add(editOperation);
				}
			});
			
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
}
