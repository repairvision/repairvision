package org.sidiff.history.revision.difference.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.sidiff.revision.common.utilities.string.StringPrinter;
import org.sidiff.revision.difference.AddObject;
import org.sidiff.revision.difference.AddReference;
import org.sidiff.revision.difference.AttributeValueChange;
import org.sidiff.revision.difference.Change;
import org.sidiff.revision.difference.Correspondence;
import org.sidiff.revision.difference.Difference;
import org.sidiff.revision.difference.RemoveObject;
import org.sidiff.revision.difference.RemoveReference;
import org.sidiff.revision.difference.DifferencePackage;

public class LiftingGraphIndex {

	private static final DifferencePackage MATCHING_PACKAGE = DifferencePackage.eINSTANCE;
	
	private Difference difference;
	
	private Map<EObject, Collection<Change>> localChanges;
	
	/**
	 * Creates a new {@link LiftingGraphIndex}.
	 * 
	 * @param difference
	 *            The difference containing the changes.
	 */
	public LiftingGraphIndex(Difference difference) {
		this.difference = difference;
		this.localChanges = new HashMap<EObject, Collection<Change>>();
	}
	
	public Difference getDifference() {
		return difference;
	}
	
	public void initialize() {
		indexCorrespondences();
		createChangeIndexMap(difference);
	}
	
	// FIXME: This should be done by SiLift!
	private void indexCorrespondences() {
		for (Correspondence correspondence : difference.getCorrespondences()) {
			difference.addCorrespondence(correspondence);
		}
	}
	
	/**
	 * Creates the change domain map.
	 * 
	 * @param difference
	 *            The difference containing the changes.
	 */
	private void createChangeIndexMap(Difference difference) {
		
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
	 * @param change
	 *            A reference change.
	 * @return The opposite change or <code>null</code>.
	 */
	public Change getOppositeChange(Change change) {
		
		if (change instanceof RemoveReference) {
			RemoveReference removeReference = (RemoveReference) change;
			EReference oppositeType = removeReference.getType().getEOpposite();
			
			if (oppositeType != null) {
				Iterator<RemoveReference> oppositeChanges = getLocalChanges(removeReference.getTgt(), 
						DifferencePackage.eINSTANCE.getRemoveReference_Src(), RemoveReference.class);
				
				while (oppositeChanges.hasNext()) {
					RemoveReference oppositeChange = oppositeChanges.next();
					
					if (oppositeChange.getType() == oppositeType) {
						if (oppositeChange.getTgt() == removeReference.getSrc()) {
							return oppositeChange;
						}
					}
				}
			}
		}
		
		else if (change instanceof AddReference) {
			AddReference addReference = (AddReference) change;
			EReference oppositeType = addReference.getType().getEOpposite();
			
			if (oppositeType != null) {
				Iterator<AddReference> oppositeChanges = getLocalChanges(addReference.getTgt(), 
						DifferencePackage.eINSTANCE.getAddReference_Src(), AddReference.class);
				
				while (oppositeChanges.hasNext()) {
					AddReference oppositeChange = oppositeChanges.next();
					
					if (oppositeChange.getType() == oppositeType) {
						if (oppositeChange.getTgt() == addReference.getSrc()) {
							return oppositeChange;
						}
					}
				}
			}
		}
		
		return null;
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
	 * @param element
	 *            An element of the model.
	 * @return The add/remove object annotation or <code>null</code>.
	 */
	public Change getObjectChange(EObject element) {
		Collection<Change> changes = localChanges.get(element);
		
		if (changes != null) {
			for (Change localChange : changes) {
				if ((localChange instanceof AddObject) || (localChange instanceof RemoveObject)) {
					return localChange;
				}
			}
		}
		
		return null;
	}

	/**
	 * @param element
	 *            An element of the model.
	 * @param attributeType
	 *            The type of the attribute.
	 * @return The attribute value change annotation or <code>null</code>.
	 */
	public AttributeValueChange getAttributeChange(EObject element, EAttribute attributeType) {
		Collection<Change> changes = localChanges.get(element);
		
		if (changes != null) {
			for (Change localChange : changes) {
				if (localChange instanceof AttributeValueChange) {
					if (attributeType == ((AttributeValueChange) localChange).getType()) {
						return (AttributeValueChange) localChange;
					}
				}
			}
		}
		
		return null;
	}

	/**
	 * @param element
	 *            An element of the model.
	 * @param referenceType The type of the reference.
	 * @return All add/remove reference annotation or <code>null</code>.
	 */
	public <C extends Change> Iterator<C> getReferenceChanges(EObject element, EReference referenceType) {
		
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
						if (nextLocalChange instanceof RemoveReference) {
							if (((RemoveReference) nextLocalChange).getType() == referenceType) {
								if (nextLocalChange.eGet(DifferencePackage.eINSTANCE.getRemoveReference_Src()) == element) {
									next = (C) nextLocalChange;
									return true;
								}
							}
						} else if (nextLocalChange instanceof AddReference) {
							if (((AddReference) nextLocalChange).getType() == referenceType) {
								if (nextLocalChange.eGet(DifferencePackage.eINSTANCE.getAddReference_Src()) == element) {
									next = (C) nextLocalChange;
									return true;
								}
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
	 *            {@link DifferencePackage.eINSTANCE.getCorrespondence_MatchedA())} /
	 *            Model B:
	 *            {@link DifferencePackage.eINSTANCE.getCorrespondence_MatchedA()}.
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
	
	/**
	 * @param modelElement
	 *            The element of model A.
	 * @return The correspondence of the model A/B object or <code>null</code>.
	 */
	public Correspondence getCorrespondenceA(EObject modelElement) {
		return difference.getCorrespondenceOfModelA(modelElement);
	}
	
	/**
	 * @param modelElement
	 *            The element of model B.
	 * @return The correspondence of the model A/B object or <code>null</code>.
	 */
	public Correspondence getCorrespondenceB(EObject modelElement) {
		return difference.getCorrespondenceOfModelB(modelElement);
	}
	
	@Override
	public String toString() {
		StringPrinter toString = new StringPrinter();
		
		for (EObject modelElement : localChanges.keySet()) {
			toString.println(modelElement);
			
			for (Change change : localChanges.get(modelElement)) {
				toString.println(2, change);
			}
		}
		
		return toString.toString();
	}
}
