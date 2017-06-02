package org.sidiff.repair.ui.peo.evaluation.recording;

import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.sidiff.difference.symmetric.AddObject;
import org.sidiff.difference.symmetric.AddReference;
import org.sidiff.difference.symmetric.Change;
import org.sidiff.difference.symmetric.RemoveObject;
import org.sidiff.difference.symmetric.RemoveReference;
import org.sidiff.matching.model.Correspondence;

public class DifferenceSlicer {

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

	public void sliceDifferenceModelA(Set<EObject> elementsA) {
		for (EObject elementA : elementsA) {
			addCorrespondence(navigation.getCorrespondenceOfModelA(elementA));
			
			for (Change change : navigation.getLocalChanges(elementA)) {
				addChange(change);
				
				if (change instanceof RemoveReference) {
					RemoveReference removeReference = (RemoveReference) change;
					
					if (removeReference.getSrc() == elementA) {
						// Check for target:
						addCorrespondence(navigation.getCorrespondenceOfModelA(removeReference.getTgt()));
						addChange(getChangeObject(removeReference.getTgt()));
					} else {
						// Check for source:
						addCorrespondence(navigation.getCorrespondenceOfModelA(removeReference.getSrc()));
						addChange(getChangeObject(removeReference.getSrc()));
					}
				}
			}
		}
	}
	
	public void sliceDifferenceModelB(Set<EObject> elementsB) {
		for (EObject elementB : elementsB) {
			addCorrespondence(navigation.getCorrespondenceOfModelB(elementB));

			for (Change change : navigation.getLocalChanges(elementB)) {
				addChange(change);
				
				if (change instanceof AddReference) {
					AddReference removeReference = (AddReference) change;
					
					if (removeReference.getSrc() == elementB) {
						// Check for target:
						addCorrespondence(navigation.getCorrespondenceOfModelA(removeReference.getTgt()));
						addChange(getChangeObject(removeReference.getTgt()));
					} else {
						// Check for source:
						addCorrespondence(navigation.getCorrespondenceOfModelA(removeReference.getSrc()));
						addChange(getChangeObject(removeReference.getSrc()));
					}
				}
			}
		}
	}
	
	private void addCorrespondence(Correspondence correspondence) {
		if (correspondence != null) {
			slice.addCorrespondence(correspondence);
		}
	}
	
	private void addChange(Change change) {
		if (change != null) {
			slice.addChange(change);
		}
	}
	
	private Change getChangeObject(EObject modelElement) {
		for (Change change : navigation.getLocalChanges(modelElement)) {
			if (change instanceof RemoveObject) {
				return change;
			} else  if (change instanceof AddObject) {
				return change;
			}
		}
		return null;
	}
}
