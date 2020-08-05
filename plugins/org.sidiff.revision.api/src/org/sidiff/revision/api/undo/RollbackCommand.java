package org.sidiff.revision.api.undo;

import org.sidiff.history.revision.IRevision;
import org.sidiff.revision.api.ComplementationPlan;
import org.sidiff.revision.editrules.rollback.RollbackHistoricalChanges;

public class RollbackCommand implements IEditCommand {
	
	private RollbackHistoricalChanges rollback;
	
	// FIXME: It is not very efficient to store the revision history on the stack!
	// TODO: Store basic EMF commands for undo!
	public RollbackCommand(ComplementationPlan complementationPlan, IRevision revision) {
		rollback = new RollbackHistoricalChanges(complementationPlan.getRecognizedChangeSet(), revision);
	}

	@Override
	public boolean apply() {
		try {
			rollback.rollback();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean undo() {
		try {
			rollback.undoRollback();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
