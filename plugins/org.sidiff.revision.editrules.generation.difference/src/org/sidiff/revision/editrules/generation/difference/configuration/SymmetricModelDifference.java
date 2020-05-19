package org.sidiff.revision.editrules.generation.difference.configuration;

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.sidiff.revision.difference.AddObject;
import org.sidiff.revision.difference.AddReference;
import org.sidiff.revision.difference.AttributeValueChange;
import org.sidiff.revision.difference.Change;
import org.sidiff.revision.difference.Correspondence;
import org.sidiff.revision.difference.Difference;
import org.sidiff.revision.difference.RemoveObject;
import org.sidiff.revision.difference.RemoveReference;

public class SymmetricModelDifference {
	
	private Difference difference;

	private Collection<Correspondence> correspondences;
	
	private Collection<Change> changes;
	
	/**
	 * @param difference A model difference
	 * @param correspondences The correspondences (subset) of the difference.
	 * @param changes The changes (subset) of the difference.
	 */
	public SymmetricModelDifference(Difference difference, 
			Collection<Correspondence> correspondences,
			Collection<Change> changes) {
		
		this.difference = difference;
		this.correspondences = correspondences;
		this.changes = changes;
	}

	public SymmetricModelDifference(Difference difference) {
		this(difference, difference.getCorrespondences(), difference.getChanges());
	}
	
	public Collection<Correspondence> getCorrespondences() {
		return correspondences;
	}

	public void setCorrespondences(Collection<Correspondence> correspondences) {
		this.correspondences = correspondences;
	}

	public Collection<Change> getChanges() {
		return changes;
	}

	public void setChanges(Collection<Change> changes) {
		this.changes = changes;
	}
	
	public Iterable<AddObject> getChangesAddObject() {
		return (Iterable<AddObject>) changes.stream()
				.filter(AddObject.class::isInstance)
				.map(AddObject.class::cast)::iterator;
	}
	
	public Iterable<AddReference> getChangesAddReference() {
		return (Iterable<AddReference>) changes.stream()
				.filter(AddReference.class::isInstance)
				.map(AddReference.class::cast)::iterator;
	}
	
	public Iterable<RemoveObject> getChangesRemoveObject() {
		return (Iterable<RemoveObject>) changes.stream()
				.filter(RemoveObject.class::isInstance)
				.map(RemoveObject.class::cast)::iterator;
	}
	
	public Iterable<RemoveReference> getChangesRemoveReference() {
		return (Iterable<RemoveReference>) changes.stream()
				.filter(RemoveReference.class::isInstance)
				.map(RemoveReference.class::cast)::iterator;
	}
	
	public Iterable<AttributeValueChange> getChangesAttributeValueChange() {
		return (Iterable<AttributeValueChange>) changes.stream()
				.filter(AttributeValueChange.class::isInstance)
				.map(AttributeValueChange.class::cast)::iterator;
	}
	
	public Correspondence getCorrespondenceOfModelA(EObject modelElementInA) {
		return difference.getCorrespondenceOfModelA(modelElementInA);
	}
	
	public Correspondence getCorrespondenceByModelB(EObject modelElementInB) {
		return difference.getCorrespondenceOfModelB(modelElementInB);
	}
}
