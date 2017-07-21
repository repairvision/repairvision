package org.sidiff.repair.history.editrules.generator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.henshin.model.Module;
import org.sidiff.difference.symmetric.AddObject;
import org.sidiff.difference.symmetric.AddReference;
import org.sidiff.difference.symmetric.AttributeValueChange;
import org.sidiff.difference.symmetric.Change;
import org.sidiff.difference.symmetric.RemoveObject;
import org.sidiff.difference.symmetric.RemoveReference;
import org.sidiff.matching.model.Correspondence;
import org.sidiff.matching.model.MatchingModelFactory;
import org.sidiff.repair.history.editrules.learning.DifferenceSlice;
import org.sidiff.repair.history.editrules.learning.LearnEditRule;

public class EditRule {

	protected String name;
	
	protected Module editRule;
	
	protected DifferenceSlice differenceSlice;
	
	public EditRule(String name, DifferenceSlice differenceSlice) {
		this.name = name;
		this.differenceSlice = differenceSlice;
		
		// TODO: Correct/Remember context during slicing!?
		correctContext(differenceSlice);
	}
	
	private static void correctContext(DifferenceSlice differenceSlice) {
		
		// Search for missing context nodes:
		List<Change> convertToContext = new ArrayList<>(5);
		
		for (Change change : differenceSlice.getChanges()) {
			if (convertToContext(change, differenceSlice.getChanges(), differenceSlice.getCorrespondences())) {
				convertToContext.add(change);
			}
		}
		
		// Create pseudo correspondence
		differenceSlice.getChanges().removeAll(convertToContext);
		
		for (Change change : convertToContext) {
			Correspondence correspondence = MatchingModelFactory.eINSTANCE.createCorrespondence();
			correspondence.setMatchedA(getChangedObject(change));
			correspondence.setMatchedB(getChangedObject(change));
			differenceSlice.getCorrespondences().add(correspondence);
		}
	}
	
	private static boolean convertToContext(Change change, 
			Collection<Change> changes, Collection<Correspondence> preserved) {
		
		if ((change instanceof AddObject) || (change instanceof RemoveObject)) {
			if (!isContainedChange(change, changes, preserved)) {
				return true;
			}
		}
		return false;
	}
	
	private static boolean isContainedChange(Change change, 
			Collection<Change> changes, Collection<Correspondence> preserved) {

		EObject container = getChangedObject(change).eContainer();

		for (Change otherChange : changes) {
			if (getChangedObject(otherChange) == container) {
				return true;
			}
		}

		for (Correspondence correspondence : preserved) {
			if ((correspondence.getMatchedA() == container) || (correspondence.getMatchedB() == container)) {
				return true;
			}
		}
		return false;
	}
	
	private static EObject getChangedObject(Change change) {
		if (change instanceof AddObject) {
			return ((AddObject) change).getObj();
		} else if (change instanceof RemoveObject) {
			return ((RemoveObject) change).getObj();
		}
		return null;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		
		if (editRule != null) {
			editRule.setName(name);
		}
		
		this.name = name;
	}
	
	public DifferenceSlice getDifferenceSlice() {
		return differenceSlice;
	}
	
	public Module getEditRule() {
		
		if (editRule == null) {
			editRule = LearnEditRule.generateEditRule(name, differenceSlice);
		}
		
		return editRule;
	}
	
	public boolean isChangeEqual(EditRule otherEditRule) {
		Set<Change> changeSetA = this.getDifferenceSlice().getChanges();
		Set<Change> changeSetB = otherEditRule.getDifferenceSlice().getChanges(); 
		
		if (changeSetA.size() == changeSetB.size()) {
			Set<Change> mappedChangesB = new HashSet<>();
			
			for (Change changeA : changeSetA) {

				// TODO: minimal rule -> check Structure
				// TODO: check if changes are type assignable -> integrate rules
				if (getEqualChange(changeA, changeSetB, mappedChangesB) == null) {
					return false;
				}
			}
			
			return true;
		}
		
		return false;
	}
	
	private Change getEqualChange(Change changeA, Set<Change> changeSetB, Set<Change> mappedChangesB) {
		
		for (Change changeB : changeSetB) {
			if (!mappedChangesB.contains(changeB)) {
				if (isEqualChange(changeA, changeB)) {
					mappedChangesB.add(changeB);
					return changeB;
				}
			}
		}
		return null;
	}
	
	private boolean isEqualChange(Change changeA, Change changeB) {
		
		if (changeA.getClass() == changeB.getClass()) {
			
			if (changeA instanceof RemoveObject) {
				if (((RemoveObject) changeA).getObj().eClass() == ((RemoveObject) changeB).getObj().eClass()) {
					return true;
				}
			}
			
			else if (changeA instanceof RemoveReference) {
				if (((RemoveReference) changeA).getType().eClass() == ((RemoveReference) changeB).getType().eClass()) {
					if (((RemoveReference) changeA).getSrc().eClass() == ((RemoveReference) changeB).getSrc().eClass()) {
						if (((RemoveReference) changeA).getTgt().eClass() == ((RemoveReference) changeB).getTgt().eClass()) {
							return true;
						}
					}
				}
			}
			
			else if (changeA instanceof AddObject) {
				if (((AddObject) changeA).getObj().eClass() == ((AddObject) changeB).getObj().eClass()) {
					return true;
				}
			}
			
			else if (changeA instanceof AddReference) {
				if (((AddReference) changeA).getType().eClass() == ((AddReference) changeB).getType().eClass()) {
					if (((AddReference) changeA).getSrc().eClass() == ((AddReference) changeB).getSrc().eClass()) {
						if (((AddReference) changeA).getTgt().eClass() == ((AddReference) changeB).getTgt().eClass()) {
							return true;
						}
					}
				}
			}
			
			else if (changeA instanceof AttributeValueChange) {
				if (((AttributeValueChange) changeA).getType().eClass() == ((AttributeValueChange) changeB).getType().eClass()) {
					if (((AttributeValueChange) changeA).getObjA().eClass() == ((AttributeValueChange) changeB).getObjA().eClass()) {
						if (((AttributeValueChange) changeA).getObjB().eClass() == ((AttributeValueChange) changeB).getObjB().eClass()) {
							return true;
						}
					}
				}
			}
		}
		
		return false;
	}
	
	public void saveEditRule(URI uri) {
		LearnEditRule.saveEditRule(getEditRule(), uri, true, false);
	}
}
