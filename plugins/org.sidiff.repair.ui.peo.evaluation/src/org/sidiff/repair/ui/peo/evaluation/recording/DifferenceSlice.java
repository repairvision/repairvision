package org.sidiff.repair.ui.peo.evaluation.recording;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.sidiff.difference.symmetric.Change;
import org.sidiff.difference.symmetric.SymmetricDifference;
import org.sidiff.matching.model.Correspondence;

public class DifferenceSlice {
	
	protected SymmetricDifference difference;

	// difference slice //
	
	protected Set<Correspondence> correspondences;
	
	protected Set<Change> changes;

	public DifferenceSlice(SymmetricDifference difference) {
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
			if (changes.add(change)) {
				changed = true;
			}
		}
		
		return changed;
	}
	
	public SymmetricDifference getDifference() {
		return difference;
	}

	public void setDifference(SymmetricDifference difference) {
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
