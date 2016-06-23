package org.sidiff.consistency.repair.lifting.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.sidiff.difference.symmetric.AddObject;
import org.sidiff.difference.symmetric.AddReference;
import org.sidiff.difference.symmetric.AttributeValueChange;
import org.sidiff.difference.symmetric.Change;
import org.sidiff.difference.symmetric.RemoveObject;
import org.sidiff.difference.symmetric.RemoveReference;
import org.sidiff.difference.symmetric.SymmetricDifference;
import org.sidiff.matching.model.Correspondence;
import org.sidiff.matching.model.MatchingModelPackage;

public class LiftingGraphIndex {

	private static final MatchingModelPackage MATCHING_PACKAGE = MatchingModelPackage.eINSTANCE;
	
	private SymmetricDifference difference;
	
	private Map<EObject, Collection<Change>> localChanges;
	
	/**
	 * Creates a new {@link LiftingGraphIndex}.
	 * 
	 * @param difference
	 *            The difference containing the changes.
	 */
	public LiftingGraphIndex(SymmetricDifference difference) {
		this.difference = difference;
		this.localChanges = new HashMap<EObject, Collection<Change>>();
		
		createChangeIndexMap(difference);
	}
	
	/**
	 * Creates the change domain map.
	 * 
	 * @param difference
	 *            The difference containing the changes.
	 */
	private void createChangeIndexMap(SymmetricDifference difference) {
		
		for (Change change : difference.getChanges()) {
			
			if (change instanceof AddObject) {
				EObject target = ((AddObject) change).getObj();
				getLocalChanges(target).add(change);
			}

			else if (change instanceof RemoveObject) {
				EObject target = ((RemoveObject) change).getObj();
				getLocalChanges(target).add(change);
			}

			else if (change instanceof AddReference) {
				EObject targetSrc = ((AddReference) change).getSrc();
				getLocalChanges(targetSrc).add(change);
				
				EObject targetTgt = ((AddReference) change).getTgt();
				getLocalChanges(targetTgt).add(change);
			}

			else if (change instanceof RemoveReference) {
				EObject targetSrc = ((RemoveReference) change).getSrc();
				getLocalChanges(targetSrc).add(change);
				
				EObject targetTgt = ((RemoveReference) change).getTgt();
				getLocalChanges(targetTgt).add(change);
			}

			else if (change instanceof AttributeValueChange) {
				EObject targetA = ((AttributeValueChange) change).getObjA();
				getLocalChanges(targetA).add(change);
				
				EObject targetB = ((AttributeValueChange) change).getObjB();
				getLocalChanges(targetB).add(change);
			}
		}
	}
	
	/**
	 * @param element
	 *            An element of the model.
	 * @return All adjacent local changes to this model element.
	 */
	public Collection<Change> getLocalChanges(EObject element) {
		Collection<Change> changes = localChanges.get(element);
				
		if (changes == null) {
			changes = new ArrayList<Change>(5);
			localChanges.put(element, changes);
		}
				
		return changes;
	}
	
	/**
	 * @param element
	 *            An element of the model.
	 * @param reference
	 *            Type of the incident (model <-> change) edge.
	 * @param changeType
	 *            The class type of the change.
	 * @return All adjacent local changes to this model element which are
	 *         incident with the given edge.
	 */
	public <C extends Change> Iterator<C> getLocalChanges(EObject element, EReference reference, Class<C> changeType) {
		
		return new Iterator<C>() {

			private Iterator<Change> localChanges = getLocalChanges(element).iterator();
			
			private C next = null;
			
			@SuppressWarnings("unchecked")
			@Override
			public boolean hasNext() {
				
				if (next != null) {
					return true;
				} else {
					// Get next change:
					while (localChanges.hasNext()) {
						Change nextLocalChange = localChanges.next();
						
						// Check type:
						if (changeType.isInstance(nextLocalChange)) {
							// Check incoming reference (e.g. src or tgt of AddReference):
							if (nextLocalChange.eGet(reference) == element) {
								next = (C) nextLocalChange;
								return true;
							}
						}
					}
				}
				
				return false;
			}

			@Override
			public C next() {
				if (hasNext()) {
					// Consume next:
					C tmp_next = next;
					next = null;
					return tmp_next;
				} else {
					throw new NoSuchElementException();
				}
			}
		};
	}
	
	/**
	 * @param modelElement
	 *            The element of model A or model B.
	 * @param correspondenceReference
	 *            Model A:
	 *            {@link SymmetricPackage.eINSTANCE.getCorrespondence_MatchedA())} /
	 *            Model B:
	 *            {@link SymmetricPackage.eINSTANCE.getCorrespondence_MatchedA()}.
	 * @return The correspondence of the model A/B object or <code>null</code>.
	 */
	public Correspondence getCorrespondence(EObject modelElement, EReference correspondenceReference) {
		if (MATCHING_PACKAGE.getCorrespondence_MatchedA() == correspondenceReference) {
			return difference.getCorrespondenceOfModelA(modelElement);
		}
		
		else if (MATCHING_PACKAGE.getCorrespondence_MatchedB() == correspondenceReference) {
			return difference.getCorrespondenceOfModelB(modelElement);
		}
		
		return null;
	}
}
