package org.sidiff.revision.editrules.rollback;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.sidiff.history.revision.IRevision;
import org.sidiff.history.revision.difference.executor.DifferenceUndo;
import org.sidiff.history.revision.util.SymmetricDifferenceUtil;
import org.sidiff.revision.difference.Change;

public class RollbackHistoricalChanges {
	
	private Collection<Change> inducingChanges;
	
	private IRevision revision;
	
	private DifferenceUndo undo;
	
	public RollbackHistoricalChanges(Collection<Change> inducingChanges, IRevision revision) {
		this.inducingChanges = inducingChanges;
		this.revision = revision;
	}
	
	public void rollback() {
		
		// calculate dependent changes:
		Set<Change> undoChangeSet = new HashSet<>(inducingChanges); 
		
		for (Change change : undoChangeSet) {
			undoChangeSet.addAll(SymmetricDifferenceUtil.getSubsequentChanges(revision, change));
		}
		
		// undo all changes from model B:
		undo = new DifferenceUndo(revision.getDifference().getSymmetricDifference(), undoChangeSet);
		undo.undo();
	}
	
	public void undoRollback() {
		undo.revert();
	}
	
	public Collection<Change> getInducingChanges() {
		return inducingChanges;
	}
	
	public IRevision getRevision() {
		return revision;
	}
}
