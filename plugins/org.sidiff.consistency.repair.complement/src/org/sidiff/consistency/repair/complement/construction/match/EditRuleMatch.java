package org.sidiff.consistency.repair.complement.construction.match;

import org.eclipse.emf.henshin.model.Action.Type;

public abstract class EditRuleMatch {

	protected Type action;
	
	public EditRuleMatch(Type action) {
		this.action = action;
	}

	public Type getAction() {
		return action;
	}

	public void setAction(Type action) {
		this.action = action;
	}
}
