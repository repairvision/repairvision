package org.sidiff.revision.editrules.generation.generator.api;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.URI;
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

public class EditRuleGenerator {

	private boolean checkDangling = true;
	
	/**
	 * FIXME: The injective matching should be derived for transformations and
	 * relocations. See rule 'move_message' which moves a message between two
	 * lifelines, e.g., to a new receiver and the sender to the old receiver.
	 */
	private boolean injectiveMatching = true;
	
	private boolean initRelocationEdges = true;
	
	public EditRuleGenerator() {
	}
	
	public EditRuleGenerator(boolean initRelocationEdges) {
		this.initRelocationEdges = initRelocationEdges;
	}
	
	public EditRuleGenerator(boolean checkDangling, boolean injectiveMatching, boolean initRelocationEdges) {
		this.checkDangling = checkDangling;
		this.injectiveMatching = injectiveMatching;
		this.initRelocationEdges = initRelocationEdges;
	}
	
	public static boolean hasRelocationEdge(Bundle patternBundle) {
		return RelocationEditRuleConstructor.getRelocationEdges(patternBundle) != null;
	}
	
	public static void initializeRelocationEdge(Bundle patternBundle) {
		RelocationEditRuleConstructor.initializeRelocationEdges(patternBundle);
	}

	public Bundle generateEditRules(List<Class<IEditRuleConstructor>> generators, Bundle patternBundle, URI editRulesURI) {
		
		// Setup edit rule profile:
		patternBundle.getProfiles().add(HenshinStereotypes.profile_model);
		
		// Relocation Rules Generator
		RelocationEditRuleConstructor relocationEditRuleGenerator = new RelocationEditRuleConstructor(patternBundle);
		
		// Initialize Relocation Edges?
		if ((generators.contains(RelocationEditRuleConstructor.class)) && (relocationEditRuleGenerator.getRelocationEdges() == null)) {
			if (initRelocationEdges) {
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
				preConstraint.getPattern().getPatterns().add(editOperation);
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

	protected List<IEditRuleFilter> getFilter() {
		List<IEditRuleFilter> editRuleFilter = new ArrayList<>();
		editRuleFilter.add(new UnfulfillableConditionsFilter(checkDangling, injectiveMatching));
		editRuleFilter.add(new EditRuleDuplicationFilter());
		return editRuleFilter;
	}
}
