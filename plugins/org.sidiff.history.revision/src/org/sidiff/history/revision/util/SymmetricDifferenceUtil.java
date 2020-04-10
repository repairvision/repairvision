package org.sidiff.history.revision.util;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.sidiff.common.emf.exceptions.InvalidModelException;
import org.sidiff.common.emf.exceptions.NoCorrespondencesException;
import org.sidiff.difference.symmetric.AddObject;
import org.sidiff.difference.symmetric.AddReference;
import org.sidiff.difference.symmetric.AttributeValueChange;
import org.sidiff.difference.symmetric.Change;
import org.sidiff.difference.symmetric.RemoveObject;
import org.sidiff.difference.symmetric.RemoveReference;
import org.sidiff.difference.symmetric.SymmetricDifference;
import org.sidiff.difference.symmetric.SymmetricFactory;
import org.sidiff.difference.symmetric.SymmetricPackage;
import org.sidiff.history.revision.IRevision;
import org.sidiff.matcher.IMatcher;
import org.sidiff.revision.difference.derivation.api.TechnicalDifferenceFacade;
import org.sidiff.revision.difference.derivation.api.settings.DifferenceSettings;

public class SymmetricDifferenceUtil {

	private static final SymmetricPackage SYMMETRIC_PACKAGE = SymmetricPackage.eINSTANCE;
	
	public static class DifferenceCalculationException extends Exception {

		private static final long serialVersionUID = 1L;

		public DifferenceCalculationException(String message) {
			super(message);
		}
	}

	public static SymmetricDifference calculateDifference(Resource modelA, Resource modelB, IMatcher matcher)
			throws DifferenceCalculationException {

		DifferenceSettings settings = new DifferenceSettings();
		settings.setMatcher(matcher);

		try {
			return TechnicalDifferenceFacade.deriveTechnicalDifference(modelA, modelB, settings);
		} catch (InvalidModelException | NoCorrespondencesException e) {
			e.printStackTrace();
		}

		throw new DifferenceCalculationException("Difference could not be calculated.");
	}

	public static SymmetricDifference calculateDifference(Resource modelA, Resource modelB, DifferenceSettings settings)
			throws DifferenceCalculationException {

		try {
			return TechnicalDifferenceFacade.deriveTechnicalDifference(modelA, modelB, settings);
		} catch (InvalidModelException | NoCorrespondencesException e) {
			e.printStackTrace();
		}

		throw new DifferenceCalculationException("Difference could not be calculated.");
	}

	public static void saveDifference(SymmetricDifference difference) {
		try {
			URI modelA = difference.getModelA().getURI();
			URI modelB = difference.getModelB().getURI();
			URI differenceURI = modelA.trimSegments(1)
					.appendSegment(extractModelName(modelA.segment(modelA.segmentCount() - 1)) + "_x_"
							+ extractModelName(modelB.segment(modelA.segmentCount() - 1)))
					.appendFileExtension("symmetric");

			ResourceSet rss = difference.getModelA().getResourceSet();
			rss.createResource(differenceURI).getContents().add(difference);
			difference.eResource().save(Collections.EMPTY_MAP);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Cut of the file extension.
	 * 
	 * @param filename
	 *            The file name with extension.
	 * @return The file name without extension.
	 */
	private static String extractModelName(String filename) {
		String fName = new File(filename).getName();
		return fName.substring(0, fName.lastIndexOf('.'));
	}
	
	public static URI getDifferenceURI(URI modelA, URI modelB) {
		return URI.createURI(
				modelA.trimFileExtension().toString() + "_to_" +
				modelB.trimFileExtension().appendFileExtension(".symmetric").lastSegment());
	}
	
	public static boolean validateChange(Change change) {
		
		if (change instanceof AddObject) {
			return isResolvable(((AddObject) change).getObj());
		} else if (change instanceof RemoveObject) {
			return isResolvable(((RemoveObject) change).getObj());
		} else if (change instanceof AddReference) {
			return isResolvable(((AddReference) change).getSrc()) && isResolvable(((AddReference) change).getTgt());
		} else if (change instanceof RemoveReference) {
			return isResolvable(((RemoveReference) change).getSrc()) && isResolvable(((RemoveReference) change).getTgt());
		} else if (change instanceof AttributeValueChange) {
			return isResolvable(((AttributeValueChange) change).getObjA()) && isResolvable(((AttributeValueChange) change).getObjB());
		}
		
		return true;
	}
	
	private static boolean isResolvable(EObject obj) {
		if (obj.eIsProxy()) {
			if ((obj.eResource() != null) && (obj.eResource().getResourceSet() != null)) {
				if (obj != EcoreUtil.resolve(obj, obj.eResource().getResourceSet())) {
					return true;
				}
			}
			return false;
		}
		return true;
	}
	
	public static boolean isChangeType(EClass type) {
		
		if ((type == SYMMETRIC_PACKAGE.getAddObject())
				|| (type == SYMMETRIC_PACKAGE.getRemoveObject())
				|| (type == SYMMETRIC_PACKAGE.getAddReference())
				|| (type == SYMMETRIC_PACKAGE.getRemoveReference())
				|| (type == SYMMETRIC_PACKAGE.getAttributeValueChange())) {
			return true;
		}
		
		return false;
	}
	
	public static boolean isChangeReference(EReference type) {
		
		if ((type == SYMMETRIC_PACKAGE.getAddObject_Obj())
				|| (type == SYMMETRIC_PACKAGE.getRemoveObject_Obj())
				|| (type == SYMMETRIC_PACKAGE.getAddReference_Src())
				|| (type == SYMMETRIC_PACKAGE.getAddReference_Tgt())
				|| (type == SYMMETRIC_PACKAGE.getRemoveReference_Src())
				|| (type == SYMMETRIC_PACKAGE.getRemoveReference_Tgt())
				|| (type == SYMMETRIC_PACKAGE.getAttributeValueChange_ObjA())
				|| (type == SYMMETRIC_PACKAGE.getAttributeValueChange_ObjB())) {
			return true;
		}
		
		return false;
	}
	
	public static boolean isChangeTypeReference(EReference type) {
		
		if ((type == SYMMETRIC_PACKAGE.getAddReference_Type())
				|| (type == SYMMETRIC_PACKAGE.getRemoveReference_Type())
				|| (type == SYMMETRIC_PACKAGE.getAttributeValueChange_Type())) {
			return true;
		}
		
		return false;
	}
	
	public boolean isChangeEqual(Set<Change> changeSetA, Set<Change> changeSetB) {

		if (changeSetA.size() == changeSetB.size()) {
			Set<Change> mappedChangesB = new HashSet<>();
			
			for (Change changeA : changeSetA) {
				if (getEqualChange(changeA, changeSetB, mappedChangesB) == null) {
					return false;
				}
			}
			
			return true;
		}
		
		return false;
	}
	
	private static Change getEqualChange(Change changeA, Set<Change> changeSetB, Set<Change> mappedChangesB) {
		
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
	
	public static boolean isEqualChange(Change changeA, Change changeB) {
		
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

	/**
	 * Copies a change of a symmetric difference.
	 * 
	 * @param change
	 *            A change of a symmetric difference.
	 * @return A copy of the change object.
	 */
	public static Change copyChange(Change change) {

		if (change instanceof AddObject) {
			AddObject addObject = (AddObject) change;
			AddObject newAddObject = SymmetricFactory.eINSTANCE.createAddObject();
			newAddObject.setObj(addObject.getObj());
			return newAddObject;
		}

		else if (change instanceof AddReference) {
			AddReference addReference = (AddReference) change;
			AddReference newAddReference = SymmetricFactory.eINSTANCE.createAddReference();
			newAddReference.setSrc(addReference.getSrc());
			newAddReference.setTgt(addReference.getTgt());
			newAddReference.setType(addReference.getType());
			return newAddReference;
		}

		else if (change instanceof RemoveObject) {
			RemoveObject removeObject = (RemoveObject) change;
			RemoveObject newRemoveObject = SymmetricFactory.eINSTANCE.createRemoveObject();
			newRemoveObject.setObj(removeObject.getObj());
			return newRemoveObject;
		}

		else if (change instanceof RemoveReference) {
			RemoveReference removeReference = (RemoveReference) change;
			RemoveReference newRemoveReference = SymmetricFactory.eINSTANCE.createRemoveReference();
			newRemoveReference.setSrc(removeReference.getSrc());
			newRemoveReference.setTgt(removeReference.getTgt());
			newRemoveReference.setType(removeReference.getType());
			return newRemoveReference;
		}

		else if (change instanceof AttributeValueChange) {
			AttributeValueChange avc = (AttributeValueChange) change;
			AttributeValueChange newAVC = SymmetricFactory.eINSTANCE.createAttributeValueChange();
			newAVC.setObjA(avc.getObjA());
			newAVC.setObjB(avc.getObjB());
			newAVC.setType(avc.getType());
			return newAVC;
		}

		return null;
	}

	/**
	 * Inverts a change of a symmetric difference.
	 * 
	 * @param change
	 *            A change of a symmetric difference.
	 * @return An inverted copy of the change object.
	 */
	public static Change invertChange(Change change) {

		if (change instanceof AddObject) {
			AddObject addObject = (AddObject) change;

			RemoveObject newRemoveObject = SymmetricFactory.eINSTANCE.createRemoveObject();
			newRemoveObject.setObj(addObject.getObj());
			return newRemoveObject;
		}

		else if (change instanceof AddReference) {
			AddReference addReference = (AddReference) change;

			RemoveReference newRemoveReference = SymmetricFactory.eINSTANCE.createRemoveReference();
			newRemoveReference.setSrc(addReference.getSrc());
			newRemoveReference.setTgt(addReference.getTgt());
			newRemoveReference.setType(addReference.getType());
			return newRemoveReference;
		}

		else if (change instanceof RemoveObject) {
			RemoveObject removeObject = (RemoveObject) change;

			AddObject newAddObject = SymmetricFactory.eINSTANCE.createAddObject();
			newAddObject.setObj(removeObject.getObj());
			return newAddObject;
		}

		else if (change instanceof RemoveReference) {
			RemoveReference removeReference = (RemoveReference) change;

			AddReference newAddReference = SymmetricFactory.eINSTANCE.createAddReference();
			newAddReference.setSrc(removeReference.getSrc());
			newAddReference.setTgt(removeReference.getTgt());
			newAddReference.setType(removeReference.getType());
			return newAddReference;
		}

		else if (change instanceof AttributeValueChange) {
			AttributeValueChange avc = (AttributeValueChange) change;

			AttributeValueChange newAVC = SymmetricFactory.eINSTANCE.createAttributeValueChange();
			newAVC.setObjA(avc.getObjB());
			newAVC.setObjB(avc.getObjA());
			newAVC.setType(avc.getType());
			return newAVC;
		}

		return null;
	}

	/**
	 * Calculates all subsequent/depended changes of a given change.
	 * 
	 * @param allChanges
	 *            All relevant changes.
	 * @param change
	 *            A change of a symmetric difference.
	 * @return All subsequent/depended changes of the given change. Excluding the
	 *         given change.
	 */
	public static Set<Change> getSubsequentChanges(IRevision revision, Change change) {
		Set<Change> subsequentChanges = new HashSet<>();
		EObject localRoot = getContained(change);
		
		// Tree creations/deletions:
		if (localRoot != null) {
			subsequentChanges.addAll(revision.getDifference().getLocalChanges(localRoot));
			
			localRoot.eAllContents().forEachRemaining(e -> {
				subsequentChanges.addAll(revision.getDifference().getLocalChanges(e));
			});
		}
		
		// Opposite change:
		Change opposite = getOppositeChange(revision, change);
		
		if (opposite != null) {
			subsequentChanges.add(opposite);
		}
		
		return subsequentChanges;
	}
	
	private static EObject getContained(Change change) {
		
		if (change instanceof RemoveReference) {
			RemoveReference removeReference = (RemoveReference) change;
			
			if (removeReference.getType().isContainment()) {
				return removeReference.getTgt();
			}
		}
		
		else if (change instanceof AddReference) {
			AddReference addReference = (AddReference) change;
			
			if (addReference.getType().isContainment()) {
				return addReference.getTgt();
			}
		}
		
		else if (change instanceof AddObject) {
			AddObject addObject = (AddObject) change;
			return addObject.getObj();
		}
		
		else if (change instanceof RemoveObject) {
			RemoveObject removeObject = (RemoveObject) change;
			return removeObject.getObj();
		}
		
		return null;
	}

	/**
	 * Supplements bidirectional reference changes.
	 * 
	 * @param allChanges
	 *            All relevant changes.
	 * @param changeSet
	 *            The changes which should be supplemented.
	 */
	public static void addOppositeChanges(IRevision revision, Collection<Change> changeSet) {
		
		for (Change change : changeSet.toArray(new Change[0])) {
			Change opposite = getOppositeChange(revision, change);
			
			if ((opposite != null) && !changeSet.contains(opposite)) {
				changeSet.add(opposite);
			}
		}
	}
	
	/**
	 * Returns a bidirectional reference change.
	 * 
	 * @param allChanges
	 *            All relevant changes.
	 * @param change
	 *            A change of a symmetric difference.
	 * @return The opposite change or <code>null</code>.
	 */
	public static Change getOppositeChange(IRevision revision, Change change) {
		
		if (change instanceof RemoveReference) {
			RemoveReference removeReference = (RemoveReference) change;
			
			if (removeReference.getType().getEOpposite() != null) {
				Iterator<RemoveReference> localChanges = revision.getDifference().getLocalChanges(
						removeReference.getTgt(),
						SymmetricPackage.eINSTANCE.getRemoveReference_Src(), 
						RemoveReference.class);
				
				while (localChanges.hasNext()) {
					RemoveReference ref = localChanges.next();
					
					if (ref.getTgt() == removeReference.getSrc()) {
						if (ref.getType() == removeReference.getType().getEOpposite()) {
							return ref;
						}
					}
				}
			}
		}
		
		else if (change instanceof AddReference) {
			AddReference addReference = (AddReference) change;
			
			if (addReference.getType().getEOpposite() != null) {
				Iterator<AddReference> localChanges = revision.getDifference().getLocalChanges(
						addReference.getTgt(),
						SymmetricPackage.eINSTANCE.getAddReference_Src(), 
						AddReference.class);
				
				while (localChanges.hasNext()) {
					AddReference ref = localChanges.next();
					
					if (ref.getTgt() == addReference.getSrc()) {
						if (ref.getType() == addReference.getType().getEOpposite()) {
							return ref;
						}
					}
				}
			}
		}
		
		return null;
	}
}
