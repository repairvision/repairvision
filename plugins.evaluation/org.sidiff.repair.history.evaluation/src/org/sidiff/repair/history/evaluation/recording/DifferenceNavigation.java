package org.sidiff.repair.history.evaluation.recording;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.sidiff.difference.symmetric.AddObject;
import org.sidiff.difference.symmetric.AddReference;
import org.sidiff.difference.symmetric.AttributeValueChange;
import org.sidiff.difference.symmetric.Change;
import org.sidiff.difference.symmetric.RemoveObject;
import org.sidiff.difference.symmetric.RemoveReference;
import org.sidiff.difference.symmetric.SymmetricDifference;
import org.sidiff.editrule.partialmatcher.util.IndexedCrossReferencer;
import org.sidiff.editrule.partialmatcher.util.LiftingGraphIndex;
import org.sidiff.matching.model.Correspondence;

public class DifferenceNavigation {
	
	protected SymmetricDifference difference;

	protected LiftingGraphIndex changeIndex;
	
	protected IndexedCrossReferencer crossReferencer;

	public DifferenceNavigation(SymmetricDifference difference) {
		this.difference = difference;
		
		// Create difference navigation:
		this.changeIndex = new LiftingGraphIndex(difference);
		this.changeIndex.initialize();

		// Create matching helper:
		this.crossReferencer = new IndexedCrossReferencer();
		this.crossReferencer.addResource(difference.getModelA());
		this.crossReferencer.addResource(difference.getModelB());
	}
	
	public SymmetricDifference getDifference() {
		return difference;
	}
	
	public Correspondence getCorrespondenceOfModelA(EObject objectInA) {
		return changeIndex.getDifference().getCorrespondenceOfModelA(objectInA);
	}
	
	public Correspondence getCorrespondenceOfModelB(EObject objectInB) {
		return changeIndex.getDifference().getCorrespondenceOfModelB(objectInB);
	}
	
	public Correspondence getCorrespondence(EObject obj) {
		Correspondence correspondence = getCorrespondenceOfModelA(obj);
		
		if (correspondence != null) {
			return correspondence;
		} else {
			return getCorrespondenceOfModelB(obj);
		}
	}
	
	public Collection<Change> getLocalChanges(EObject element)  {
		return changeIndex.getLocalChanges(element);
	}
	
	public Change getChangeObject(EObject modelElement) {
		for (Change change : getLocalChanges(modelElement)) {
			if (change instanceof RemoveObject) {
				return change;
			} else  if (change instanceof AddObject) {
				return change;
			}
		}
		return null;
	}
	
	public Change getContainerReferenceChange(Change change) {
		EObject element = getChangeSource(change);
		
		for (Change localChange : getLocalChanges(element)) {
			if (localChange instanceof AddReference) {
				if (((AddReference) localChange).getSrc() == element) {
					if (((AddReference) localChange).getType().isContainer()) {
						return localChange;
					}
				}
			}
		}
		
		return null;
	}
	
	public Change getContainmentReferenceChange(Change change) {
		EObject element = getChangeSource(change);
		
		for (Change localChange : getLocalChanges(element)) {
			if (localChange instanceof AddReference) {
				if (((AddReference) localChange).getTgt() == element) {
					if (((AddReference) localChange).getType().isContainment()) {
						return localChange;
					}
				}
			}
		}
		
		return null;
	}

	/**
	 * @param object
	 *            The source object.
	 * @param type
	 *            The type of the source object.
	 * @return An unmodifiable list of target objects.
	 */
	@SuppressWarnings("unchecked")
	public Iterator<? extends EObject> getTargets(EObject object, EReference type, boolean inverse) {
		
		if (inverse) {
			return crossReferencer.getInverse(object, type);
		} else {
			
			// Create reference list:
			List<EObject> targets;
			
			if (type.isMany()) {
				targets = ( List<EObject>) object.eGet(type, true);
			} else {
				EObject value = (EObject) object.eGet(type, true);
				
				if (value != null) {
					targets = Collections.singletonList(value);
				} else {
					targets = Collections.emptyList();
				}
			}
			
			return targets.iterator();
		}
	}
	
	public LiftingGraphIndex getChangeIndex() {
		return changeIndex;
	}

	public void setChangeIndex(LiftingGraphIndex changeIndex) {
		this.changeIndex = changeIndex;
	}

	public IndexedCrossReferencer getCrossReferencer() {
		return crossReferencer;
	}

	public void setCrossReferencer(IndexedCrossReferencer crossReferencer) {
		this.crossReferencer = crossReferencer;
	}
	
	public static EObject getChangeSource(Change change) {
		if (change instanceof RemoveReference) {
			return ((RemoveReference) change).getSrc();
		} else if (change instanceof AddReference) {
			return ((AddReference) change).getSrc();
		} else if (change instanceof AttributeValueChange) {
			return ((AttributeValueChange) change).getObjA();
		} else  if (change instanceof AddObject) {
			return ((AddObject) change).getObj();
		} else if (change instanceof RemoveObject) {
			return ((RemoveObject) change).getObj();
		}
		return null;
	}
	
	public static EObject getChangeTarget(Change change) {
		if (change instanceof RemoveReference) {
			return ((RemoveReference) change).getTgt();
		} else if (change instanceof AddReference) {
			return ((AddReference) change).getTgt();
		} else if (change instanceof AttributeValueChange) {
			return ((AttributeValueChange) change).getObjB();
		} else  if (change instanceof AddObject) {
			return ((AddObject) change).getObj();
		} else if (change instanceof RemoveObject) {
			return ((RemoveObject) change).getObj();
		}
		return null;
	}
}
