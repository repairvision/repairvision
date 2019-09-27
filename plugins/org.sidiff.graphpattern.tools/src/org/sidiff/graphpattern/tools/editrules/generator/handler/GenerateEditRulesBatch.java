package org.sidiff.graphpattern.tools.editrules.generator.handler;

import java.io.IOException;
import java.util.ArrayList;
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
import org.sidiff.graphpattern.tools.editrules.constructors.CreationEditRuleConstructor;
import org.sidiff.graphpattern.tools.editrules.constructors.DeletionEditRuleConstructor;
import org.sidiff.graphpattern.tools.editrules.constructors.RelocationEditRuleConstructor;
import org.sidiff.graphpattern.tools.editrules.constructors.TransformationEditRuleConstructor;
import org.sidiff.graphpattern.tools.editrules.constructors.util.EditRuleCollector;
import org.sidiff.graphpattern.tools.editrules.filter.EditRuleDuplicationFilter;
import org.sidiff.graphpattern.tools.editrules.filter.IEditRuleFilter;
import org.sidiff.graphpattern.tools.editrules.filter.UnfulfillableConditionsFilter;

public class GenerateEditRulesBatch extends AbstractHandler {
	
	private boolean checkDangling = true;
	
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		
		// Select generators:
		String[] generators = new String[] {
				"Creation Rules Generator",
				"Deletion Rules Generator",
				"Transformation Rules Generator",
				"Relocation Rules Generator"};
		
		List<String> selection = WorkbenchUtil.showSelections("Select Edit Rule Generators:", 
				Arrays.asList(generators), Arrays.asList(generators) , WorkbenchUtil.getEMFLabelProvider());
		
		// Cancel -> Selection empty
		if (selection.isEmpty()) {
			return null;
		}
		
		// Load patterns:
		Bundle patternBundle = EMFHandlerUtil.getSelection(event, Bundle.class);
		
		if (patternBundle != null) {
			
			// Setup edit rule profile:
			patternBundle.getProfiles().add(HenshinStereotypes.profile_model);
			
			
			// Relocation Rules Generator
			RelocationEditRuleConstructor relocationEditRuleGenerator = new RelocationEditRuleConstructor(patternBundle);
			
			// Initialize Relocation Edges?
			if ((selection.contains(generators[3])) && (relocationEditRuleGenerator.getRelocationEdges() == null)) {
				if (WorkbenchUtil.showQuestion("Initialize Relocation Edges?")) {
					RelocationEditRuleConstructor.initializeRelocationEdges(patternBundle);

					try {
						patternBundle.eResource().save(Collections.emptyMap());
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
			
			// Generate edit rules:
			EditRuleCollector editOperations = new EditRuleCollector();
			List<IEditRuleFilter> editRuleFilter = new ArrayList<>();
			editRuleFilter.add(new UnfulfillableConditionsFilter(checkDangling));
			editRuleFilter.add(new EditRuleDuplicationFilter());
			
			for (Pattern pattern : patternBundle.getPatterns()) {
				
				// NOTE: The relocation edges are just configuration.
				if (pattern != relocationEditRuleGenerator.getRelocationEdges()) {
					
					// Creation Rules Generator
					if (selection.contains(generators[0])) {
						new CreationEditRuleConstructor().construct(pattern, editRuleFilter, editOperations);
					}
					
					// Deletion Rules Generator
					if (selection.contains(generators[1])) {
						new DeletionEditRuleConstructor().construct(pattern, editRuleFilter, editOperations);
					}
					
					// Transformation Rules Generator
					if (selection.contains(generators[2])) {
						new TransformationEditRuleConstructor().construct(pattern, editRuleFilter, editOperations);
					}
					
					// Relocation Rules Generator
					if (selection.contains(generators[3])) {
						relocationEditRuleGenerator.construct(pattern, editRuleFilter, editOperations);
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
