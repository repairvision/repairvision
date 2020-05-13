package org.sidiff.history.revision.difference.executor;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.sidiff.history.revision.util.EcoreMergeUtil;
import org.sidiff.revision.difference.AddObject;
import org.sidiff.revision.difference.AddReference;
import org.sidiff.revision.difference.AttributeValueChange;
import org.sidiff.revision.difference.Change;
import org.sidiff.revision.difference.Difference;
import org.sidiff.revision.difference.RemoveObject;
import org.sidiff.revision.difference.RemoveReference;

/**
 * Undos the changes of the difference between model A and B from model B. Thus,
 * model A and model B are equal. (The order of references are not considered
 * yet.)
 * 
 * @author Manuel Ohrndorf
 */
public class DifferenceUndo implements Runnable {

	/**
	 * The difference between model A and B.
	 */
	private Difference difference;
	
	/**
	 * The change to be executed. 
	 */
	private Collection<Change> changes;

	/**
	 * model A -> created model B
	 */
	private Map<EObject, EObject> addedObjects = new HashMap<>();
	
	/**
	 * attribute value change -> old value model B
	 */
	private Map<AttributeValueChange, Object> setValues = new HashMap<>();

	/**
	 * Initializes the {@link DifferenceUndo}.
	 * 
	 * @param difference
	 *            The difference to execute.
	 */
	public DifferenceUndo(Difference difference) {
		this.difference = difference;
		this.changes = difference.getChanges();
	}
	
	/**
	 * Initializes the {@link DifferenceUndo}.
	 * 
	 * @param difference
	 *            The difference between model A and B.
	 * @param changes
	 *            The changes to execute.
	 */
	public DifferenceUndo(Difference difference, Collection<Change> changes) {
		this.difference = difference;
		this.changes = changes;
	}

	@Override
	public void run() {
		undo();
	}
	
	public void undo() {
		
		// NOTE: To support "moves" we need to execute RemoveReferences before AddReferences!
		// NOTE: AddObjects before AddReferences!
		// NOTE: RemoveReferences before RemoveObjects!
		
		undoAddReferences();				// remove reference from B
		undoAddObjects();					// remove object from B
		undoRemoveObjects();				// add object to B
		undoRemoveReferences();				// add reference to B
		undoAttributeValueChange();			// set value on B
	}
	
	public void revert() {
		
		// NOTE: Inverse to execute()!
		
		revertUndoAttributeValueChange();	// reset value on B
		revertUndoRemoveReferences();		// remove reference from B
		revertUndoRemoveObjects();			// remove object from B
		revertUndoAddObjects();				// add object to B
		revertUndoAddReferences();			// add reference to B
	}

	/**
	 * Saves model B.
	 */
	public void save() {
		try {
			difference.getModelB().save(Collections.emptyMap());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param feature
	 *            A meta-model feature.
	 * @return <code>true</code> if the feature should be processed;
	 *         <code>false</code> otherwise.
	 */
	protected boolean isConsideredFeature(EClass type, EStructuralFeature feature) {
		return feature.isChangeable() 
				&& !feature.isDerived() 
				&& !feature.isTransient()
				&& type.getEAllStructuralFeatures().contains(feature);
	}

	/**
	 * Removes all added objects from model B.
	 */
	private void undoAddObjects() {

		for (Change change : changes) {
			if (change instanceof AddObject) {
				EObject objB = ((AddObject) change).getObj();
				EcoreUtil.remove(objB);
			}
		}
	}
	
	private void revertUndoAddObjects() {
		// nothing to do... reverted by removed containment reference of this object
	}

	/**
	 * Removes all added references from model B.
	 */
	@SuppressWarnings({ "rawtypes" })
	private void undoAddReferences() {

		for (Change change : changes) {
			if (change instanceof AddReference) {
				EReference typeB = (EReference) ((AddReference) change).getType();
				EObject srcB = ((AddReference) change).getSrc();
				EObject tgtB = ((AddReference) change).getTgt();

				if (isConsideredFeature(srcB.eClass(), typeB)) {
					if (typeB.isMany()) {
						List referencesB = (List) srcB.eGet(typeB);
						referencesB.remove(tgtB);
					} else {
						srcB.eSet(typeB, null);
					}
				}
			}
		}
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void revertUndoAddReferences() {

		for (Change change : changes) {
			if (change instanceof AddReference) {
				EReference typeB = (EReference) ((AddReference) change).getType();
				EObject srcB = ((AddReference) change).getSrc();
				EObject tgtB = ((AddReference) change).getTgt();

				if (isConsideredFeature(srcB.eClass(), typeB)) {
					
					// TODO: Support reference ordering!
					if (typeB.isMany()) {
						List referencesB = (List) srcB.eGet(typeB);
						referencesB.add(tgtB);
					} else {
						srcB.eSet(typeB, tgtB);
					}
				}
			}
		}
	}

	/**
	 * Adds all removed objects to model B.
	 */
	private void undoRemoveObjects() {

		for (Change change : changes) {
			if (change instanceof RemoveObject) {
				EObject objA = ((RemoveObject) change).getObj();
				EObject objB = EcoreMergeUtil.copyWithoutReferences(objA);
				addedObjects.put(objA, objB);
			}
		}
	}
	
	private void revertUndoRemoveObjects() {
		
		// nothing to do... reverted by added containment reference of this object
		
		addedObjects.clear();
	}

	/**
	 * Adds all removed references to model B.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void undoRemoveReferences() {

		for (Change change : changes) {
			if (change instanceof RemoveReference) {
				EReference typeA = (EReference) ((RemoveReference) change).getType();
				EObject srcA = ((RemoveReference) change).getSrc();
				EObject tgtA = ((RemoveReference) change).getTgt();

				if (isConsideredFeature(srcA.eClass(), typeA)) {
					EObject srcB = getCorrespondingObjectInB(srcA);
					EObject tgtB = getCorrespondingObjectInB(tgtA);

					// TODO: Support reference ordering!
					if (typeA.isMany()) {
						List referencesB = (List) srcB.eGet(typeA);
						referencesB.add(tgtB);
					} else {
						srcB.eSet(typeA, tgtB);
					}
				}
			}
		}
	}
	
	@SuppressWarnings({ "rawtypes" })
	private void revertUndoRemoveReferences() {

		for (Change change : changes) {
			if (change instanceof RemoveReference) {
				EReference typeA = (EReference) ((RemoveReference) change).getType();
				EObject srcA = ((RemoveReference) change).getSrc();
				EObject tgtA = ((RemoveReference) change).getTgt();

				if (isConsideredFeature(srcA.eClass(), typeA)) {
					EObject srcB = getCorrespondingObjectInB(srcA);
					EObject tgtB = getCorrespondingObjectInB(tgtA);

					if (typeA.isMany()) {
						List referencesB = (List) srcB.eGet(typeA);
						referencesB.remove(tgtB);
					} else {
						srcB.eSet(typeA, null);
					}
				}
			}
		}
	}

	/**
	 * Copy's all attribute value change attributes from model A to model B.
	 */
	private void undoAttributeValueChange() {

		for (Change change : changes) {
			if (change instanceof AttributeValueChange) {
				EObject objA = ((AttributeValueChange) change).getObjA();
				EObject objB = ((AttributeValueChange) change).getObjB();

				EAttribute type = ((AttributeValueChange) change).getType();

				setValues.put((AttributeValueChange) change, objB.eGet(type));
				EcoreMergeUtil.copyAttribute(type, objA, objB);
			}
		}
	}
	
	private void revertUndoAttributeValueChange() {

		for (Entry<AttributeValueChange, Object> avc : setValues.entrySet()) {
			EObject objB = avc.getKey().getObjB();
			EAttribute typeB = avc.getKey().getType();
			Object valueB = avc.getValue();
			
			objB.eSet(typeB, valueB);
		}
		setValues.clear();
	}

	/**
	 * @return The difference between model A and model B.
	 */
	public Difference getDifference() {
		return difference;
	}

	/**
	 * @param objB
	 *            An Object of model B.
	 * @return The corresponding object in Model A.
	 */
	public EObject getCorrespondingObjectInA(EObject objB) {

		// Corresponds in the difference?
		EObject objA = difference.getCorrespondingObjectInA(objB);

		if (objA != null) {
			return objA;
		}

		// Imported resource, e.g. library model?
		if ((objB.eResource() != null) && (objB.eResource() != difference.getModelB())) {
			return objB;
		}

		return null;
	}

	/**
	 * @param objA
	 *            An Object of model A.
	 * @return The corresponding object in Model B.
	 */
	public EObject getCorrespondingObjectInB(EObject objA) {

		// New object in B?
		EObject objB = addedObjects.get(objA);

		if (objB != null) {
			return objB;
		}
		
		// Corresponds in the difference?
		objB = difference.getCorrespondingObjectInB(objA);

		if (objB != null) {
			return objB;
		}

		// Imported resource, e.g. library model?
		if (objA.eResource() != difference.getModelA()) {
			return objA;
		}

		return null;
	}
}
