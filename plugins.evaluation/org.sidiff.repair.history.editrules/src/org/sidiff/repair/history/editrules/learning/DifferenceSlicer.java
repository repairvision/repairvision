package org.sidiff.repair.history.editrules.learning;

import java.util.Iterator;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.sidiff.consistency.common.emf.ModelingUtil;
import org.sidiff.difference.symmetric.AddObject;
import org.sidiff.difference.symmetric.AddReference;
import org.sidiff.difference.symmetric.AttributeValueChange;
import org.sidiff.difference.symmetric.Change;
import org.sidiff.difference.symmetric.RemoveObject;
import org.sidiff.difference.symmetric.RemoveReference;
import org.sidiff.editrule.recorder.util.IAttributeFilter;
import org.sidiff.editrule.recorder.util.IReferenceFilter;
import org.sidiff.matching.model.Correspondence;

public class DifferenceSlicer {

	/**
	 * Adds the container of all changes until the root element of the model.
	 */
	protected boolean addContextContainers = false;
	
	/**
	 * Difference navigation: historical, resolved
	 */
	protected DifferenceNavigation navigation;
	
	/**
	 * Difference slice: historical, resolved
	 */
	protected DifferenceSlice slice;
	
	public DifferenceSlicer(DifferenceNavigation navigation) {
		this.navigation = navigation;
		this.slice = new DifferenceSlice(navigation.getDifference());
	}
	
	public DifferenceSlice getSlice() {
		return slice;
	}

	public void sliceDifferenceModelA(Set<EObject> elementsA,
			IReferenceFilter referenceFilter, IAttributeFilter attributeFilter) {
		
		for (EObject elementA : elementsA) {
			addCorrespondence(navigation.getCorrespondenceOfModelA(elementA));
			
			// Remove Object/Reference:
			for (Change change : navigation.getLocalChanges(elementA)) {
				if (!filterModelA(change, referenceFilter, attributeFilter)) {
					addChange(change, elementA);
				}
			}
		}
	}
	
	private boolean filterModelA(Change change, IReferenceFilter referenceFilter, IAttributeFilter attributeFilter) {
		
		if (change instanceof RemoveReference) {
			RemoveReference removeReference = (RemoveReference) change;
			return referenceFilter.filter(removeReference.getSrc(), removeReference.getTgt(), removeReference.getType());
		}
		
		else if (change instanceof AttributeValueChange) {
			AttributeValueChange avc = (AttributeValueChange) change;
			return attributeFilter.filter(avc.getObjA(), avc.getObjA().eGet(avc.getType()), avc.getType());
		}
		
		return false;
	}
	
	public void sliceDifferenceModelB(Set<EObject> elementsB, 
			IReferenceFilter referenceFilter, IAttributeFilter attributeFilter) {
		
		for (EObject elementB : elementsB) {
			addCorrespondence(navigation.getCorrespondenceOfModelB(elementB));

			// Add Object/Reference:
			for (Change change : navigation.getLocalChanges(elementB)) {
				if (!filterModelB(change, referenceFilter, attributeFilter)) {
					addChange(change, elementB);
				}
			}
		}
	}
	
	private boolean filterModelB(Change change, IReferenceFilter referenceFilter, IAttributeFilter attributeFilter) {
		
		if (change instanceof AddReference) {
			AddReference addReference = (AddReference) change;
			return referenceFilter.filter(addReference.getSrc(), addReference.getTgt(), addReference.getType());
		}

		else if (change instanceof AttributeValueChange) {
			AttributeValueChange avc = (AttributeValueChange) change;
			return attributeFilter.filter(avc.getObjB(), avc.getObjB().eGet(avc.getType()), avc.getType());
		}
		
		return false;
	}
	
	private void addCorrespondence(Correspondence correspondence) {
		if (correspondence != null) {
			slice.addCorrespondence(correspondence);
		}
	}
	
	private void addChange(Change change, EObject source) {
		if (change != null) {
			slice.addChange(change);
			
			if (source != null) {
				if ((change instanceof AddReference) || (change instanceof RemoveReference)) {
					EObject target = null;
					
					if (DifferenceNavigation.getChangeSource(change) == source) {
						// Check for target:
						target = DifferenceNavigation.getChangeTarget(change);
					} else {
						// Check for source:
						target = DifferenceNavigation.getChangeSource(change);
					}
					
					addCorrespondence(navigation.getCorrespondence(target));
					addChange(navigation.getChangeObject(target), target);
				} else if ((change instanceof AddObject) || (change instanceof RemoveObject)) {
					Iterator<EObject> rootPathIterator = ModelingUtil.getRootPath(source);
					
					while (rootPathIterator.hasNext()) {
						EObject container = rootPathIterator.next();
						Change containerChange = navigation.getChangeObject(container);
						
						// Containment:
						addChange(navigation.getContainerReferenceChange(change), null);
						addChange(navigation.getContainmentReferenceChange(change), null);
						
						// Container node:
						if (containerChange != null) {
							addChange(containerChange, container);
						} else {
							addCorrespondence(navigation.getCorrespondence(container));
							
							if (!addContextContainers) {
								break;
							}
						}
					} 
				}
			}
		}
	}
}
