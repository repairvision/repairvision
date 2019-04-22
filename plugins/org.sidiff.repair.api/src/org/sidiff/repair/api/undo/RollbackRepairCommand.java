package org.sidiff.repair.api.undo;

import org.sidiff.history.revision.IRevision;
import org.sidiff.repair.api.IRepairPlan;
import org.sidiff.repair.rollback.RollbackHistoricalChanges;

public class RollbackRepairCommand implements IRepairCommand {
	
	private RollbackHistoricalChanges rollbackRepair;
	
	// FIXME: It is not very efficient to store the revision history on the stack!
	// TODO: Store basic EMF commands for undo!
	public RollbackRepairCommand(IRepairPlan repair, IRevision revision) {
		rollbackRepair = new RollbackHistoricalChanges(repair.getRecognizedChangeSet(), revision);
	}

	@Override
	public boolean apply() {
		try {
			rollbackRepair.rollback();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean undo() {
		try {
			rollbackRepair.undoRollback();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}