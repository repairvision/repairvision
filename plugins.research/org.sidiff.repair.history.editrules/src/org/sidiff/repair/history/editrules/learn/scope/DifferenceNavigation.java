package org.sidiff.repair.history.editrules.learn.scope;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.sidiff.history.revision.IRevision;
import org.sidiff.history.revision.impl.Revision;
import org.sidiff.revision.difference.AddObject;
import org.sidiff.revision.difference.AddReference;
import org.sidiff.revision.difference.AttributeValueChange;
import org.sidiff.revision.difference.Change;
import org.sidiff.revision.difference.Correspondence;
import org.sidiff.revision.difference.Difference;
import org.sidiff.revision.difference.RemoveObject;
import org.sidiff.revision.difference.RemoveReference;

public class DifferenceNavigation {
	
	protected IRevision revision;

	public DifferenceNavigation(Difference difference) {
		this.revision = new Revision(difference);
	}
	
	public IRevision getRevision() {
		return revision;
	}
	
	public Correspondence getCorrespondenceOfModelA(EObject objectInA) {
		return revision.getDifference().getCorrespondenceA(objectInA);
	}
	
	public Correspondence getCorrespondenceOfModelB(EObject objectInB) {
		return revision.getDifference().getCorrespondenceB(objectInB);
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
		return revision.getDifference().getLocalChanges(element);
	}
	
	public Change getChangeObject(EObject modelElement) {
		for (Change change : getLocalChanges(modelElement)) {
			if (change instanceof RemoveObject) {
				return change;
			} else if (change instanceof AddObject) {
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
			} else if (localChange instanceof RemoveReference) {
				if (((RemoveReference) localChange).getSrc() == element) {
					if (((RemoveReference) localChange).getType().isContainer()) {
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
			} else if (localChange instanceof RemoveReference) {
				if (((RemoveReference) localChange).getTgt() == element) {
					if (((RemoveReference) localChange).getType().isContainment()) {
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
	public List<? extends EObject> getTargets(EObject object, EReference type, boolean inverse) {
		 List<EObject> targets = new ArrayList<>();
		
		if (inverse) {
			revision.getVersionA().getSource(object, type).forEachRemaining(targets::add);
			revision.getVersionB().getSource(object, type).forEachRemaining(targets::add);
		} else {
			revision.getVersionA().getTarget(object, type).forEachRemaining(targets::add);
			revision.getVersionB().getTarget(object, type).forEachRemaining(targets::add);
		}
		
		return targets;
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
