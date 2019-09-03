package org.sidiff.graphpattern.tools.editrules;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.common.util.URI;
import org.sidiff.common.emf.modelstorage.EMFHandlerUtil;
import org.sidiff.consistency.common.ui.util.WorkbenchUtil;
import org.sidiff.graphpattern.Bundle;
import org.sidiff.graphpattern.Pattern;
import org.sidiff.graphpattern.profile.henshin.HenshinStereotypes;
import org.sidiff.graphpattern.tools.editrules.generator.main.ConstructionEditRuleGenerator;
import org.sidiff.graphpattern.tools.editrules.generator.main.RelocationEditRuleGenerator;
import org.sidiff.graphpattern.tools.editrules.generator.main.TransformationEditRuleGenerator;
import org.sidiff.graphpattern.tools.editrules.generator.util.EditRuleCollector;

public class GenerateEditRulesBatch extends AbstractHandler {
	
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		Bundle patternBundle = EMFHandlerUtil.getSelection(event, Bundle.class);
		
		if (patternBundle != null) {
			
			// Setup edit rule profile:
			patternBundle.getProfiles().add(HenshinStereotypes.profile_model);
			
			String[] generators = new String[] {
					"Creation Rules Generator",
					"Deletion Rules Generator",
					"Transformation Rules Generator",
					"Relocation Rules Generator"};
			
			List<String> selection = WorkbenchUtil.showSelections("Select Edit Rule Generators:", 
					Arrays.asList(generators), Arrays.asList(generators) , WorkbenchUtil.getEMFLabelProvider());
			
			// Relocation Rules Generator
			RelocationEditRuleGenerator relocationEditRuleGenerator = new RelocationEditRuleGenerator(patternBundle);
			
			// Initialize Relocation Edges?
			if ((selection.contains(generators[3])) && (relocationEditRuleGenerator.getRelocationEdges() == null)) {
				if (WorkbenchUtil.showQuestion("Initialize Relocation Edges?")) {
					RelocationEditRuleGenerator.initializeRelocationEdges(patternBundle);

					try {
						patternBundle.eResource().save(Collections.emptyMap());
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
			
			// Generate edit rules:
			EditRuleCollector editOperations = new EditRuleCollector();
			
			for (Pattern pattern : patternBundle.getPatterns()) {
				
				// NOTE: The relocation edges are just configuration.
				if (pattern != relocationEditRuleGenerator.getRelocationEdges()) {
					
					// Creation Rules Generator
					if (selection.contains(generators[0])) {
						ConstructionEditRuleGenerator.generateCreationRules(pattern, editOperations);
					}
					
					// Deletion Rules Generator
					if (selection.contains(generators[1])) {
						ConstructionEditRuleGenerator.generateDeletionRules(pattern, editOperations);
					}
					
					// Transformation Rules Generator
					if (selection.contains(generators[2])) {
						TransformationEditRuleGenerator.generateStructuralTransformationRules(pattern, editOperations);
					}
					
					// Relocation Rules Generator
					if (selection.contains(generators[3])) {
						relocationEditRuleGenerator.generateRelocationRules(pattern, editOperations);
					}
				}
				
			}
			
//			System.out.println("Edit Operations: " + editOperations.values().stream().mapToInt(List::size).sum());
			
			editOperations.getEditRules().forEach((preConstraint, operations) -> {
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
