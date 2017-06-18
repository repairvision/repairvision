package org.sidiff.repair.history.editrules.generator;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.henshin.model.Module;
import org.sidiff.repair.historymodel.History;
import org.sidiff.repair.historymodel.Version;

public class HistoryEditRuleGenerator {

	protected History history;
	
	protected List<Module> rulebase;
	
	public HistoryEditRuleGenerator(History history) {
		this.history = history;
	}
	
	public void analyzeHistory() {
		for (int i = 0; i < history.getVersions().size(); i++) {
			Version vA = history.getVersions().get(i);
			Version vB = history.getVersions().get(i + 1);
			List<Module> editRules = calculateEditRules(vA, vB);
			integrateIntoRulebase(editRules);
		}
	}
	
	protected List<Module> calculateEditRules(Version vA, Version vB) {
		List<Module> editRules = new ArrayList<>();
		
		// Calculate all validation scopes:
		
		// Calculate difference:
		
		// Find validation pairs:
		
		// Ignore scopes with no changes:
		
		// Create change-sets:
		// > Find nested scopes by changes.
		// > Sum nested and parent scopes.
		
		// "Record" edit-rules:
		
		return editRules;
	}
	
	protected void integrateIntoRulebase(List<Module> editRules) {
		
		// Find similar/nested edit-rules:
		// > Make rules as abstract as possible.
		// > reduce to minimal context.
		
		// Merge matched (as concrete as possible) edit-rules:
		
		rulebase.addAll(editRules);
	}
	
	protected void storeRulebas() {
		
	}
	
	@Override
	public String toString() {
		return super.toString();
	}
}
