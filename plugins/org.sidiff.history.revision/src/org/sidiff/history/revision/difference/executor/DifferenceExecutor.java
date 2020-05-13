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
 * Applies the difference between model A and B on model A. Thus, model A and
 * model B are equal. (The order of references are not considered yet.)
 * 
 * @author Manuel Ohrndorf
 */
public class DifferenceExecutor implements Runnable {

	/**
	 * The difference between model A and B.
	 */
	private Difference difference;
	
	/**
	 * The change to be executed. 
	 */
	private Collection<Change> changes;

	/**
	 * model B -> created model A
	 */
	private Map<EObject, EObject> addedObjects = new HashMap<>();
	
	/**
	 * attribute value change -> old value model A
	 */
	private Map<AttributeValueChange, Object> setValues = new HashMap<>();

	/**
	 * Initializes the {@link DifferenceExecutor}.
	 * 
	 * @param difference
	 *            The difference to execute.
	 */
	public DifferenceExecutor(Difference difference) {
		this.difference = difference;
		this.changes = difference.getChanges();
	}
	
	/**
	 * Initializes the {@link DifferenceExecutor}.
	 * 
	 * @param difference
	 *            The difference between model A and B.
	 * @param changes
	 *            The changes to execute.
	 */
	public DifferenceExecutor(Difference difference, Collection<Change> changes) {
		this.difference = difference;
		this.changes = changes;
	}

	@Override
	public void run() {
		execute();
	}
	
	public void execute() {
		
		// NOTE: To support "moves" we need to execute RemoveReferences before AddReferences!
		// NOTE: AddObjects before AddReferences!
		// NOTE: RemoveReferences before RemoveObjects!
		
		executeRemoveReferences();
		executeRemoveObjects();
		executeAddObjects();
		executeAddReferences();
		executeAttributeValueChange();
	}
	
	public void revert() {
		
		// NOTE: Inverse to execute()!
		
		revertExecuteAttributeValueChange();
		revertExecuteAddReferences();
		revertExecuteAddObjects();
		revertExecuteRemoveObjects();
		revertExecuteRemoveReferences();
	}

	/**
	 * Saves model A.
	 */
	public void save() {
		try {
			difference.getModelA().save(Collections.emptyMap());
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
	 * Creates all AddObjects in model A.
	 */
	private void executeAddObjects() {

		for (Change change : changes) {
			if (change instanceof AddObject) {
				EObject objB = ((AddObject) change).getObj();
				EObject objA = EcoreMergeUtil.copyWithoutReferences(objB);
				addedObjects.put(objB, objA);
			}
		}
	}
	
	/**
	 * Removes all AddObjects in model A.
	 */
	private void revertExecuteAddObjects() {
		
		// nothing to do... undo add containment
		
		addedObjects.clear();
	}

	/**
	 * Creates all AddReferences in model A.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void executeAddReferences() {

		for (Change change : changes) {
			if (change instanceof AddReference) {
				EReference typeB = (EReference) ((AddReference) change).getType();
				EObject srcB = ((AddReference) change).getSrc();
				EObject tgtB = ((AddReference) change).getTgt();

				if (isConsideredFeature(srcB.eClass(), typeB)) {
					EObject srcA = getCorrespondingObjectInA(srcB);
					EObject tgtA = getCorrespondingObjectInA(tgtB);

					// TODO: Support reference ordering!
					if (typeB.isMany()) {
						List referencesA = (List) srcA.eGet(typeB);
						referencesA.add(tgtA);
					} else {
						srcA.eSet(typeB, tgtA);
					}
				}
			}
		}
	}
	
	/**
	 * Removes all AddReferences in model A.
	 */
	@SuppressWarnings({ "rawtypes" })
	private void revertExecuteAddReferences() {

		for (Change change : changes) {
			if (change instanceof AddReference) {
				EReference typeB = (EReference) ((AddReference) change).getType();
				EObject srcB = ((AddReference) change).getSrc();
				EObject tgtB = ((AddReference) change).getTgt();

				if (isConsideredFeature(srcB.eClass(), typeB)) {
					EObject srcA = getCorrespondingObjectInA(srcB);
					EObject tgtA = getCorrespondingObjectInA(tgtB);

					if (typeB.isMany()) {
						List referencesA = (List) srcA.eGet(typeB);
						referencesA.remove(tgtA);
					} else {
						srcA.eSet(typeB, null);
					}
				}
			}
		}
	}

	/**
	 * Removes all RemoveObjects from model A.
	 */
	private void executeRemoveObjects() {

		for (Change change : changes) {
			if (change instanceof RemoveObject) {
				EObject objA = ((RemoveObject) change).getObj();
				EcoreUtil.remove(objA);
			}
		}
	}
	
	/**
	 * Creates all RemoveObjects in model A.
	 */
	private void revertExecuteRemoveObjects() {
		// nothing to do... undo remove containment
	}

	/**
	 * Removes all RemoveReferences in model A.
	 */
	@SuppressWarnings({ "rawtypes" })
	private void executeRemoveReferences() {

		for (Change change : changes) {
			if (change instanceof RemoveReference) {
				EReference typeA = (EReference) ((RemoveReference) change).getType();
				EObject srcA = ((RemoveReference) change).getSrc();
				EObject tgtA = ((RemoveReference) change).getTgt();

				if (isConsideredFeature(srcA.eClass(), typeA)) {
					if (typeA.isMany()) {
						List referencesA = (List) srcA.eGet(typeA);
						referencesA.remove(tgtA);
					} else {
						srcA.eSet(typeA, null);
					}
				}
			}
		}
	}
	
	/**
	 * Creates all RemoveReferences in model A.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void revertExecuteRemoveReferences() {

		for (Change change : changes) {
			if (change instanceof RemoveReference) {
				EReference typeA = (EReference) ((RemoveReference) change).getType();
				EObject srcA = ((RemoveReference) change).getSrc();
				EObject tgtA = ((RemoveReference) change).getTgt();

				if (isConsideredFeature(srcA.eClass(), typeA)) {
					
					// TODO: Support reference ordering!
					if (typeA.isMany()) {
						List referencesA = (List) srcA.eGet(typeA);
						referencesA.add(tgtA);
					} else {
						srcA.eSet(typeA, tgtA);
					}
				}
			}
		}
	}

	/**
	 * Copy's all attribute value change attributes from model B to model A.
	 */
	private void executeAttributeValueChange() {

		for (Change change : changes) {
			if (change instanceof AttributeValueChange) {
				EObject objA = ((AttributeValueChange) change).getObjA();
				EObject objB = ((AttributeValueChange) change).getObjB();

				EAttribute type = ((AttributeValueChange) change).getType();

				setValues.put((AttributeValueChange) change, objA.eGet(type));
				EcoreMergeUtil.copyAttribute(type, objB, objA);
			}
		}
	}
	
	/**
	 * Resets all attribute value change attributes of model A.
	 */
	private void revertExecuteAttributeValueChange() {

		for (Entry<AttributeValueChange, Object> avc : setValues.entrySet()) {
			EObject objA = avc.getKey().getObjA();
			EAttribute typeA = avc.getKey().getType();
			Object valueA = avc.getValue();
			
			objA.eSet(typeA, valueA);
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

		// New object in A?
		EObject objA = addedObjects.get(objB);

		if (objA != null) {
			return objA;
		}

		// Corresponds in the difference?
		objA = difference.getCorrespondingObjectInA(objB);

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

		// Corresponds in the difference?
		EObject objB = difference.getCorrespondingObjectInB(objA);

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
