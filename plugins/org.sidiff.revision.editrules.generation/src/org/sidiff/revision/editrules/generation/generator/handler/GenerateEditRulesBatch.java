package org.sidiff.revision.editrules.generation.generator.handler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.viewers.LabelProvider;
import org.sidiff.common.emf.modelstorage.EMFHandlerUtil;
import org.sidiff.consistency.common.ui.util.WorkbenchUtil;
import org.sidiff.graphpattern.Bundle;
import org.sidiff.graphpattern.Pattern;
import org.sidiff.graphpattern.profile.henshin.HenshinStereotypes;
import org.sidiff.revision.editrules.generation.constructors.CreationEditRuleConstructor;
import org.sidiff.revision.editrules.generation.constructors.DeletionEditRuleConstructor;
import org.sidiff.revision.editrules.generation.constructors.IEditRuleConstructor;
import org.sidiff.revision.editrules.generation.constructors.RelocationEditRuleConstructor;
import org.sidiff.revision.editrules.generation.constructors.TransformationEditRuleConstructor;
import org.sidiff.revision.editrules.generation.constructors.util.EditRuleCollector;
import org.sidiff.revision.editrules.generation.filter.EditRuleDuplicationFilter;
import org.sidiff.revision.editrules.generation.filter.IEditRuleFilter;
import org.sidiff.revision.editrules.generation.filter.UnfulfillableConditionsFilter;

public class GenerateEditRulesBatch extends AbstractHandler {
	
	private boolean checkDangling = true;
	
	/**
	 * FIXME: The injective matching should be derived for transformations and
	 * relocations. See rule 'move_message' which moves a message between two
	 * lifelines, e.g., to a new receiver and the sender to the old receiver.
	 */
	private boolean injectiveMatching = true;
	
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		
		// Select generators:
		@SuppressWarnings("unchecked")
		Class<IEditRuleConstructor>[] generators = new Class[] {
				CreationEditRuleConstructor.class,
				DeletionEditRuleConstructor.class,
				TransformationEditRuleConstructor.class,
				RelocationEditRuleConstructor.class};
		
		List<Class<IEditRuleConstructor>> selection = WorkbenchUtil.showSelections("Select Edit Rule Generators:", 
				Arrays.asList(generators), Arrays.asList(generators) , new LabelProvider() {
			
			@Override
			public String getText(Object element) {
				
				if (element == CreationEditRuleConstructor.class) {
					return "Creation Edit Rules";
				}
				
				if (element == DeletionEditRuleConstructor.class) {
					return "Deletion Edit Rules";
				}
				
				if (element == TransformationEditRuleConstructor.class) {
					return "Transformation Edit Rules";
				}
				
				if (element == RelocationEditRuleConstructor.class) {
					return "Relocation Edit Rules";
				}
				
				return super.getText(element);
			}
		});
		
		// Cancel -> Selection empty
		if (selection.isEmpty()) {
			return null;
		}
		
		// Load patterns:
		Bundle patternBundle = EMFHandlerUtil.getSelection(event, Bundle.class);
		
		if (patternBundle != null) {
			URI originalURI = patternBundle.eResource().getURI();
			URI editRulesURI = URI.createURI(originalURI.trimFileExtension() + "_editrules").appendFileExtension("graphpattern");
			
			generateEditRules(selection, patternBundle, editRulesURI);
		}
		
		return null;
	}

	public Bundle generateEditRules(List<Class<IEditRuleConstructor>> generators, Bundle patternBundle, URI editRulesURI) {
		
		// Setup edit rule profile:
		patternBundle.getProfiles().add(HenshinStereotypes.profile_model);
		
		// Relocation Rules Generator
		RelocationEditRuleConstructor relocationEditRuleGenerator = new RelocationEditRuleConstructor(patternBundle);
		
		// Initialize Relocation Edges?
		if ((generators.contains(RelocationEditRuleConstructor.class)) && (relocationEditRuleGenerator.getRelocationEdges() == null)) {
			if (WorkbenchUtil.showQuestion("Initialize Relocation Edges?")) {
				RelocationEditRuleConstructor.initializeRelocationEdges(patternBundle);
				
				// Read new relocation edges from bundle:
				relocationEditRuleGenerator = new RelocationEditRuleConstructor(patternBundle);

				try {
					patternBundle.eResource().save(Collections.emptyMap());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		// Generate edit rules:
		EditRuleCollector editOperations = new EditRuleCollector();
		List<IEditRuleFilter> editRuleFilter = getFilter();
		
		for (Pattern pattern : patternBundle.getPatterns()) {
			
			// NOTE: The relocation edges are just configuration.
			if (pattern != relocationEditRuleGenerator.getRelocationEdges()) {
				
				// Creation Rules Generator
				if (generators.contains(CreationEditRuleConstructor.class)) {
					new CreationEditRuleConstructor().construct(pattern, editRuleFilter, editOperations);
				}
				
				// Deletion Rules Generator
				if (generators.contains(DeletionEditRuleConstructor.class)) {
					new DeletionEditRuleConstructor().construct(pattern, editRuleFilter, editOperations);
				}
				
				// Transformation Rules Generator
				if (generators.contains(TransformationEditRuleConstructor.class)) {
					new TransformationEditRuleConstructor().construct(pattern, editRuleFilter, editOperations);
				}
				
				// Relocation Rules Generator
				if (generators.contains(RelocationEditRuleConstructor.class)) {
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
		patternBundle.eResource().setURI(editRulesURI);
		
		try {
			patternBundle.eResource().save(Collections.emptyMap());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return patternBundle;
	}

	private List<IEditRuleFilter> getFilter() {
		List<IEditRuleFilter> editRuleFilter = new ArrayList<>();
		editRuleFilter.add(new UnfulfillableConditionsFilter(checkDangling, injectiveMatching));
		editRuleFilter.add(new EditRuleDuplicationFilter());
		return editRuleFilter;
	}
}
