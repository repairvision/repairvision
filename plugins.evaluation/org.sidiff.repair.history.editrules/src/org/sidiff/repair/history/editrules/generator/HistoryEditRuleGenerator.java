package org.sidiff.repair.history.editrules.generator;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.resource.Resource;
import org.sidiff.repair.historymodel.History;
import org.sidiff.repair.historymodel.Version;
import org.sidiff.validation.constraint.api.ValidationFacade;
import org.sidiff.validation.constraint.api.util.RepairValidation;
import org.sidiff.validation.constraint.api.util.RequiredValidation;

public class HistoryEditRuleGenerator {

	protected History history;
	
	protected List<EditRule> rulebase;
	
	public HistoryEditRuleGenerator(History history) {
		this.history = history;
	}
	
	public void analyzeHistory() {
		for (int i = 0; i < history.getVersions().size() - 1; i++) {
			Version vA = history.getVersions().get(i);
			Version vB = history.getVersions().get(i + 1);
			
			List<RepairValidation[]> validationPairs = findValidationPairs(vA.getModel(), vB.getModel());
			
			for (RepairValidation[] validationPair : validationPairs) {
				List<EditRule> editRules = calculateEditRules(vA, vB, validationPair);
				
				for (EditRule editRule : editRules) {
					integrateIntoRulebase(editRule );
				}
				
				// TODO: Just for testing!
				break;
			}
		}
	}
	
	protected List<RepairValidation[]> findValidationPairs(Resource vA, Resource vB) {
		
		System.out.println("================================================================================");
		System.out.println("================================== RepairValidation ==================================");
		System.out.println("================================================================================");
		System.out.println("Model A: " + vA.getURI());
		System.out.println("Model B: " + vB.getURI());
		
		// Calculate difference:
		
		
		// Calculate all validation scopes:
		List<RequiredValidation> consistencyVA = ValidationFacade.analyzeRequirements(vA);
		List<RequiredValidation> consistencyVB = ValidationFacade.analyzeRequirements(vB);
		
		for (RequiredValidation requiredValidation : consistencyVA) {
			System.out.println();
			System.out.println("## " + requiredValidation.getRule().getName() + " ##");
			System.out.println(requiredValidation.getRequiredTree());
		}
		
		for (RequiredValidation requiredValidation : consistencyVB) {
			System.out.println();
			System.out.println("## " + requiredValidation.getRule().getName() + " ##");
			System.out.println(requiredValidation.getRequiredTree());
		}
				
		// Find history validation pairs:
		List<RepairValidation[]> validations = new ArrayList<>();
		
		// Ignore scopes with no changes:
		
		return validations;
	}
	
	protected List<EditRule> calculateEditRules(Version vA, Version vB, RepairValidation[] validationPair) {
		List<EditRule> editRules = new ArrayList<>();
		
		// Create change-sets:
		// > Reduce/Split change-sets to minimal consistent changes.
		// > > Alternativen bei der Validierung ermitteln!?
		// > > > Nur positiv validierte Anteile
		// > > > Validierungszweige protokollieren
		// (Optimization:)
		// > Atomic lifting (with dependencies).
		
		// => Consistency-Tree:
		
		
		// "Record" edit-rules:
		
		return editRules;
	}
	
	protected void integrateIntoRulebase(EditRule editRule) {
		
		// Find similar/nested edit-rules:
		// > Make rules as abstract as possible.
		// > reduce to minimal context -> compare change-based.
		
		// Merge matched edit-rules (as concrete as possible):
		// > PACs/Context as alternatives (OR).
		
		rulebase.add(editRule);
	}
	
	protected void storeRulebas(String project, String folder) {
		
		// Create new project:
		
	}
	
	@Override
	public String toString() {
		return super.toString();
	}
}
