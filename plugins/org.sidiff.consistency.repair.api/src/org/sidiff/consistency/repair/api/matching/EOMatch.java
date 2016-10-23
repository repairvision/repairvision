package org.sidiff.consistency.repair.api.matching;

import org.eclipse.emf.henshin.model.Action.Type;

public abstract class EOMatch {

	protected Type action;
	
	public EOMatch(Type action) {
		this.action = action;
	}

	public Type getAction() {
		return action;
	}

	public void setAction(Type action) {
		this.action = action;
	}
}
