package org.sidiff.revision.editrules.recognition.match;

import org.eclipse.emf.henshin.model.Action.Type;
import org.eclipse.emf.henshin.model.GraphElement;

public abstract class RecognitionActionMatch extends RecognitionMatch {

	protected Type action;
	
	public RecognitionActionMatch(Type action) {
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
