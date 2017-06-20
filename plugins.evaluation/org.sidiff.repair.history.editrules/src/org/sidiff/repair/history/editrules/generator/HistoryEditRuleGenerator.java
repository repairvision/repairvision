package org.sidiff.repair.history.editrules.generator;

import java.util.ArrayList;
import java.util.List;

import org.sidiff.repair.historymodel.History;
import org.sidiff.repair.historymodel.Version;
import org.sidiff.validation.constraint.api.util.Validation;

public class HistoryEditRuleGenerator {

	protected History history;
	
	protected List<EditRule> rulebase;
	
	public HistoryEditRuleGenerator(History history) {
		this.history = history;
	}
	
	public void analyzeHistory() {
		for (int i = 0; i < history.getVersions().size(); i++) {
			Version vA = history.getVersions().get(i);
			Version vB = history.getVersions().get(i + 1);
			
			List<Validation[]> validationPairs = findValidationPairs();
			
			for (Validation[] validationPair : validationPairs) {
				List<EditRule> editRules = calculateEditRules(vA, vB, validationPair);
				
				for (EditRule editRule : editRules) {
					integrateIntoRulebase(editRule );
				}
			}
		}
	}
	
	protected List<Validation[]> findValidationPairs() {
		
		// Calculate all validation scopes:
		
		// Calculate difference:
				
		// Find history validation pairs:
		
		// Ignore scopes with no changes:
		
		return null;
	}
	
	protected List<EditRule> calculateEditRules(Version vA, Version vB, Validation[] validationPair) {
		List<EditRule> editRules = new ArrayList<>();
		
		// Create change-sets:
// (?)	// > Reduce/Split change-sets to minimal consistent changes.
		
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
