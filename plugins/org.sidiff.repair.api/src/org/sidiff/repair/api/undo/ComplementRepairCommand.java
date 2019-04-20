package org.sidiff.repair.api.undo;

import org.eclipse.emf.henshin.interpreter.RuleApplication;

public class ComplementRepairCommand implements IRepairCommand {

	private RuleApplication application;
	
	// FIXME: It is not very efficient to store the working graph in the undo stack!
	// TODO: Store basic EMF commands for undo!
	public ComplementRepairCommand(RuleApplication application) {
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
