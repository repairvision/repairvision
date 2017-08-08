package org.sidiff.repair.api.matching;

import org.eclipse.emf.henshin.model.Action.Type;
import org.eclipse.emf.henshin.model.GraphElement;

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
	
	public abstract GraphElement getGraphElement();
}
