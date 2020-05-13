package org.sidiff.repair.history.editrules.learn.scope;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.sidiff.revision.difference.Change;
import org.sidiff.revision.difference.Correspondence;
import org.sidiff.revision.difference.Difference;

public class DifferenceSlice {
	
	protected Difference difference;

	// difference slice //
	
	protected Set<Correspondence> correspondences;
	
	protected Set<Change> changes;

	public DifferenceSlice(Difference difference) {
		this.difference = difference;
		this.correspondences = new HashSet<>();
		this.changes = new HashSet<>();
	}
	
	public boolean addCorrespondence(Correspondence correspondence) {
		return correspondences.add(correspondence);
	}
	
	public boolean addCorrespondences(Collection<Correspondence> correspondences) {
		boolean changed = false;
		
		for (Correspondence correspondence : correspondences) {
			if (correspondences.add(correspondence)) {
				changed = true;
			}
		}
		
		return changed;
	}
	
	public boolean addChange(Change change) {
		return changes.add(change);
	}
	
	public boolean addChanges(Collection<Change> changes) {
		boolean changed = false;
		
		for (Change change : changes) {
			if (this.changes.add(change)) {
				changed = true;
			}
		}
		
		return changed;
	}
	
	public Difference getDifference() {
		return difference;
	}

	public void setDifference(Difference difference) {
		this.difference = difference;
	}

	public Set<Correspondence> getCorrespondences() {
		return correspondences;
	}

	public void setCorrespondences(Set<Correspondence> correspondences) {
		this.correspondences = correspondences;
	}

	public Set<Change> getChanges() {
		return changes;
	}

	public void setChanges(Set<Change> changes) {
		this.changes = changes;
	}
}
