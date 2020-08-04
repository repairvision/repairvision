package org.sidiff.revision.api.undo;

import org.eclipse.emf.henshin.interpreter.RuleApplication;

public class ComplementCommand implements IEditCommand {

	private RuleApplication application;
	
	// FIXME: It is not very efficient to store the working graph in the undo stack!
	// TODO: Store basic EMF commands for undo!
	public ComplementCommand(RuleApplication application) {
		this.application = application;
	}
	
	@Override
	public boolean apply() {
		return application.execute(null);
	}

	@Override
	public boolean undo() {
		return application.undo(null);
	}

}
