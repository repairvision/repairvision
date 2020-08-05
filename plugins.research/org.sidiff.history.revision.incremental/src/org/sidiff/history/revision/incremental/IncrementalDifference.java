package org.sidiff.history.revision.incremental;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.sidiff.revision.common.emf.document.DocumentType;
import org.sidiff.revision.difference.AddObject;
import org.sidiff.revision.difference.AddReference;
import org.sidiff.revision.difference.AttributeValueChange;
import org.sidiff.revision.difference.Change;
import org.sidiff.revision.difference.Correspondence;
import org.sidiff.revision.difference.RemoveObject;
import org.sidiff.revision.difference.RemoveReference;
import org.sidiff.revision.difference.api.DifferenceFacade;
import org.sidiff.revision.difference.Difference;
import org.sidiff.revision.difference.DifferenceFactory;

public class IncrementalDifference {
	
	protected boolean CREATE_ATTRIBUTE_INITIALIZATIONS = true;

	protected XMIResource resourceA;

	private Set<EObject> elementsA;
	
	private Map<EObject, List<Change>> unresolvedChangesB = new HashMap<>();

	protected XMIResource resourceB;

	private Set<EObject> elementsB;

	private Map<EObject, List<Change>> unresolvedChangesA = new HashMap<>();
	
	protected Difference difference;

	public IncrementalDifference(XMIResource resourceA, XMIResource resourceB) {
		this.resourceA = resourceA;
		this.resourceB = resourceB;

		this.elementsA = new HashSet<>();
		this.elementsB = new HashSet<>();

		this.difference = DifferenceFacade.create(resourceA, resourceB); 
	}
	
	public Difference getSymmetricDifference() {
		return difference;
	}

	public boolean selectElementA(EObject elementA) {
		assert (elementA.eResource() == resourceA);
		boolean isNewElement = elementsA.add(elementA);
		
		if (isNewElement) {
			addElementA(elementA);
			checkUnresolvedChangesA(elementA);
		}
		
		return isNewElement;
	}

	public boolean deselectElementA(EObject elementA) {
		assert (elementA.eResource() == resourceA);
		boolean isRemoved =  elementsA.remove(elementA);
		
		if (isRemoved) {
			removeElementA(elementA);
		}
		
		return isRemoved;
	}

	public boolean selectElementB(EObject elementB) {
		assert (elementB.eResource() == resourceB);
		boolean isNewElement =  elementsB.add(elementB);
		
		if (isNewElement) {
			addElementB(elementB);
			checkUnresolvedChangesB(elementB);
		}
		
		return isNewElement;
	}

	public boolean deselectElementB(EObject elementB) {
		assert (elementB.eResource() == resourceB);
		boolean isRemoved = elementsB.remove(elementB);
		
		if (isRemoved) {
			removeElementB(elementB);
		}
		
		return isRemoved;
	}

	private void addElementA(EObject elementA) {

		if (isConsideredType(elementA.eClass())) {

			if (!createCorrspondence(elementA, null)) {
				
				List<Change> changes = difference.getChanges();
				
				// Removed object:
				RemoveObject removeObject = DifferenceFactory.eINSTANCE.createRemoveObject();
				removeObject.setObj(elementA);

				changes.add(removeObject);

				// Remove reference:
				for (EReference reference : elementA.eClass().getEAllReferences()) {
					if (isConsiderFeature(reference)) {
						if (reference.isMany()) {
							@SuppressWarnings("unchecked")
							List<EObject> targetElementsA = (List<EObject>) elementA.eGet(reference);
							
							for (EObject targetElementA : targetElementsA) {
								createRemoveReference(elementA, targetElementA, reference);
							}
						} else {
							EObject targetElementA = (EObject) elementA.eGet(reference);
							createRemoveReference(elementA, targetElementA, reference);
						}
					}
				}
			}
		}
	}
	
	private void addElementB(EObject elementB) {
		
		if (isConsideredType(elementB.eClass())) {

			if (!createCorrspondence(null, elementB)) {
				
				List<Change> changes = difference.getChanges();
				
				// Add-Object:
				AddObject addObject = DifferenceFactory.eINSTANCE.createAddObject();
				addObject.setObj(elementB);

				changes.add(addObject);

				// Add-References:
				for (EReference reference : elementB.eClass().getEAllReferences()) {
					if (isConsiderFeature(reference)) {
						if (reference.isMany()) {
							@SuppressWarnings("unchecked")
							List<EObject> targetElementsB = (List<EObject>) elementB.eGet(reference);

							for (EObject targetElementB : targetElementsB) {
								createAddReference(elementB, targetElementB, reference);
							}
						} else {
							EObject targetElementB = (EObject) elementB.eGet(reference);
							createAddReference(elementB, targetElementB, reference);
						}
					}
				}
				
				// Attribute-Initializations:
				if (CREATE_ATTRIBUTE_INITIALIZATIONS) {
					for (EAttribute attribute : elementB.eClass().getEAllAttributes()) {
						AttributeValueChange avc = DifferenceFactory.eINSTANCE.createAttributeValueChange();
						avc.setObjB(elementB);
						avc.setType(attribute);
						
						changes.add(avc);
					}
				}
			}
		}
	}
	
	private boolean createCorrspondence(EObject elementA, EObject elementB) {
		String idA = getIDModelA(elementA);
		String idB = getIDModelB(elementB);
		
		if ((elementA == null) && (idB != null)) {
			elementA = resourceA.getEObject(idB);
			idA = idB;
		}
		if ((elementB == null) && (idA != null)) {
			elementB = resourceB.getEObject(idA);
			idB = idA;
		}
		
		if (isCorresponding(elementA, idA, elementB, idB)) {
			List<Change> changes = difference.getChanges();
			List<Correspondence> correspondences = difference.getCorrespondences();
			
			// Correspondence:
			Correspondence correspondence = DifferenceFactory.eINSTANCE.createCorrespondence();
			correspondence.setMatchedA(elementA);
			correspondence.setMatchedB(elementB);

			correspondences.add(correspondence);
			
			
			// Update selected elements:
			// TODO: return new correspondences/changes -> add in selectElementX()
			elementsA.add(elementA);
			elementsB.add(elementB);

			// Change-Reference:
			for (EReference reference : elementA.eClass().getEAllReferences()) {
				if (isConsiderFeature(reference)) {
					if (reference.isMany()) {
						@SuppressWarnings("unchecked")
						List<EObject> targetElementsA = (List<EObject>) elementA.eGet(reference);
						@SuppressWarnings("unchecked")
						List<EObject> targetElementsB = (List<EObject>) elementB.eGet(reference);
						
						// Remove-References:
						for (EObject targetElementA : targetElementsA) {
							boolean hasCorresponding = false;

							for (EObject targetElementB : targetElementsB) {
								if (isCorresponding(targetElementA, getIDModelA(targetElementA), targetElementB, getIDModelB(targetElementB))) {
									hasCorresponding = true;
									break;
								}
							}

							if (!hasCorresponding) {
								createRemoveReference(elementA, targetElementA, reference);
							}
						}
						
						// Add-References:
						for (EObject targetElementB : targetElementsB) {
							boolean hasCorresponding = false;

							for (EObject targetElementA : targetElementsA) {
								if (isCorresponding(targetElementA, getIDModelA(targetElementA), targetElementB, getIDModelB(targetElementB))) {
									hasCorresponding = true;
									break;
								}
							}

							if (!hasCorresponding) {
								createAddReference(elementB, targetElementB, reference);
							}
						}
					} else {
						EObject targetElementA = (EObject) elementA.eGet(reference);
						EObject targetElementB = (EObject) elementB.eGet(reference);

						if (!isCorresponding(targetElementA, getIDModelA(targetElementA), targetElementB, getIDModelB(targetElementB))) {
							if (targetElementA != null) {
								createRemoveReference(elementA, targetElementA, reference);
							}
							if (targetElementB != null) {
								createAddReference(elementB, targetElementB, reference);
							}
						}
					}
				}
			}

			// Attribute-Value-Changes:
			for (EAttribute attribute : elementA.eClass().getEAllAttributes()) {
				if (isConsiderFeature(attribute)) {
					Object elementAValue = elementA.eGet(attribute);
					Object elementBValue = elementB.eGet(attribute);

					if (!isEqualValue(elementAValue, elementBValue)) {
						AttributeValueChange avc = DifferenceFactory.eINSTANCE.createAttributeValueChange();
						avc.setObjA(elementA);
						avc.setObjB(elementB);
						avc.setType(attribute);

						changes.add(avc);
					}
				}
			}
			return true;
		}
		return false;
	}

	private void createRemoveReference(EObject sourceA, EObject targetA, EReference type) {
		
		RemoveReference removeReference = DifferenceFactory.eINSTANCE.createRemoveReference();
		removeReference.setSrc(sourceA);
		removeReference.setTgt(targetA);
		removeReference.setType(type);
		
		if (elementsB.contains(targetA)) {
			difference.getChanges().add(removeReference);
		} else {
			List<Change> unresolvedElement = unresolvedChangesA.getOrDefault(targetA, new ArrayList<>());
			unresolvedElement.add(removeReference);
			unresolvedChangesA.put(targetA, unresolvedElement);
		}
	}
	
	private void createAddReference(EObject sourceB, EObject targetB, EReference type) {
		
		AddReference addReference = DifferenceFactory.eINSTANCE.createAddReference();
		addReference.setSrc(sourceB);
		addReference.setTgt(targetB);
		addReference.setType(type);
		
		if (elementsB.contains(targetB)) {
			difference.getChanges().add(addReference);
		} else {
			List<Change> unresolvedElement = unresolvedChangesB.getOrDefault(targetB, new ArrayList<>());
			unresolvedElement.add(addReference);
			unresolvedChangesB.put(targetB, unresolvedElement);
		}
	}
	
	protected String getIDModelA(EObject elementA) {
		if (elementA != null) {
			String id = resourceA.getID(elementA);
			
			if (id != null) {
				return id;
			} else {
				return resourceA.getURIFragment(elementA);
			}
		}
		return null;
	}
	
	protected String getIDModelB(EObject elementB) {
		if (elementB != null) {
			String id = resourceB.getID(elementB);
			
			if (id != null) {
				return id;
			} else {
				return resourceB.getURIFragment(elementB);
			}
		}
		return null;
	}

	protected boolean isCorresponding(EObject elementA, String idA, EObject elementB, String idB) {
		
		if ((elementA != null) && (elementB != null)) {
			if (elementA == elementB) {
				return true;
			} 
			if (elementA.equals(elementB)) {
				return true;
			}
			if ((idA != null) && (idB != null)) {
				if (idA.equals(idB)) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	protected boolean isEqualValue(Object elementAValue, Object elementBValue) {
		
		if (elementAValue == elementBValue) {
			return true;
		}
		
		if ((elementAValue != null) && (elementBValue != null)) {
			if (elementAValue.equals(elementBValue)) {
				return true;
			}
		}
		
		return false;
	}
	
	private void checkUnresolvedChangesA(EObject newElementA) {
		List<Change> resolvedChanges = unresolvedChangesA.getOrDefault(newElementA, Collections.emptyList());
		difference.getChanges().addAll(resolvedChanges);
		unresolvedChangesA.remove(newElementA);
	}
	
	private void checkUnresolvedChangesB(EObject newElementB) {
		List<Change> resolvedChanges = unresolvedChangesB.getOrDefault(newElementB, Collections.emptyList());
		difference.getChanges().addAll(resolvedChanges);
		unresolvedChangesB.remove(newElementB);
	}

	private void removeElementA(EObject elementA) {
		
		for (Iterator<Correspondence> iterator = difference.getCorrespondences().iterator(); iterator.hasNext();) {
			Correspondence correspondece = iterator.next();
			
			if (correspondece.getMatchedA() == elementA) {
				iterator.remove();
			}
		}
		
		for (Iterator<Change> iterator = difference.getChanges().iterator(); iterator.hasNext();) {
			Change change = iterator.next();
			
			if (isOutgoingChangeA(elementA, change)) {
				iterator.remove();
			}
		}
		
		for (List<Change> unresolvedChanges : unresolvedChangesA.values()) {
			for (Iterator<Change> iterator = unresolvedChanges.iterator(); iterator.hasNext();) {
				Change change = iterator.next();
				
				if (isOutgoingChangeA(elementA, change)) {
					iterator.remove();
				}
			}
		}
		
		for (Iterator<Change> iterator = difference.getChanges().iterator(); iterator.hasNext();) {
			Change change = iterator.next();
			
			if (isIncomingChangeA(elementA, change)) {
				iterator.remove();

				List<Change> unresolvedElement = unresolvedChangesA.getOrDefault(elementA, new ArrayList<>());
				unresolvedElement.add(change);
				unresolvedChangesA.put(elementA, unresolvedElement);
			}
		}
	}
	
	private boolean isOutgoingChangeA(EObject elementA, Change change) {
		
		if (change instanceof RemoveObject) {
			RemoveObject removeObject = (RemoveObject) change;
			
			if (removeObject.getObj() == elementA) {
				return true;
			}
		}
		
		else if (change instanceof RemoveReference) {
			RemoveReference removeReference = (RemoveReference) change;
			
			if (removeReference.getSrc() == elementA) {
				return true;
			}
		}
		
		else if (change instanceof AttributeValueChange) {
			AttributeValueChange avc = (AttributeValueChange) change;
		
			if (avc.getObjA() == elementA) {
				return true;
			}
		}
		
		return false;
	}
	
	private boolean isIncomingChangeA(EObject elementA, Change change) {
		
		if (change instanceof RemoveReference) {
			RemoveReference removeReference = (RemoveReference) change;
			
			if (removeReference.getTgt() == elementA) {
				return true;
			}
		}
		return false;
	}
	
	private void removeElementB(EObject elementB) {
		
		for (Iterator<Correspondence> iterator = difference.getCorrespondences().iterator(); iterator.hasNext();) {
			Correspondence correspondece = iterator.next();
			
			if (correspondece.getMatchedB() == elementB) {
				iterator.remove();
			}
		}
		
		for (Iterator<Change> iterator = difference.getChanges().iterator(); iterator.hasNext();) {
			Change change = iterator.next();
			
			if (isOutgoingChangeB(elementB, change)) {
				iterator.remove();
			}
		}
		
		for (List<Change> unresolvedChanges : unresolvedChangesB.values()) {
			for (Iterator<Change> iterator = unresolvedChanges.iterator(); iterator.hasNext();) {
				Change change = iterator.next();
				
				if (isOutgoingChangeB(elementB, change)) {
					iterator.remove();
				}
			}
		}
		
		for (Iterator<Change> iterator = difference.getChanges().iterator(); iterator.hasNext();) {
			Change change = iterator.next();
			
			if (isIncomingChangeB(elementB, change)) {
				iterator.remove();

				List<Change> unresolvedElement = unresolvedChangesB.getOrDefault(elementB, new ArrayList<>());
				unresolvedElement.add(change);
				unresolvedChangesB.put(elementB, unresolvedElement);
			}
		}
	}
	
	private boolean isOutgoingChangeB(EObject elementB, Change change) {
		
		if (change instanceof AddObject) {
			AddObject addObject = (AddObject) change;
			
			if (addObject.getObj() == elementB) {
				return true;
			}
		}
		
		else if (change instanceof AddReference) {
			AddReference addReference = (AddReference) change;
			
			if (addReference.getSrc() == elementB) {
				return true;
			}
		}
		
		else if (change instanceof AttributeValueChange) {
			AttributeValueChange avc = (AttributeValueChange) change;
		
			if (avc.getObjB() == elementB) {
				return true;
			}
		}
		return false;
	}
	
	private boolean isIncomingChangeB(EObject elementB, Change change) {
		
		if (change instanceof AddReference) {
			AddReference addReference = (AddReference) change;
			
			if (addReference.getTgt() == elementB) {
				return true;
			}
		}
		return false;
	}
	
	public void addOutgoingChanges() {
		for (EObject unresolvedA : new ArrayList<>(unresolvedChangesA.keySet())) {
			selectElementA(unresolvedA);
		}
		for (EObject unresolvedB : new ArrayList<>(unresolvedChangesB.keySet())) {
			selectElementB(unresolvedB);
		}
	}
	
	protected boolean isConsideredType(EClass type) {
		return true;
	}
	
	protected boolean isConsiderFeature(EStructuralFeature featureType) {
		return !DocumentType.isUnconsideredStructualFeature(featureType);
	}
}
