package org.sidiff.repair.history.editrules.generator;

import org.eclipse.emf.henshin.model.Module;

public class EditRule {

	protected Module editRule;

	public EditRule(Module editRule) {
		this.editRule = editRule;
	}
	
	public Module getEditRule() {
		return editRule;
	}
	
	public void setEditRule(Module editRule) {
		this.editRule = editRule;
	}
}
