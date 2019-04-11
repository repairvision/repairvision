package org.sidiff.repair.history.evolution.difference;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
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
import org.sidiff.difference.technical.api.TechnicalDifferenceFacade;
import org.sidiff.difference.technical.api.settings.DifferenceSettings;
import org.sidiff.history.revision.IRevision;
import org.sidiff.matcher.IMatcher;

public class SymmetricDifferenceUtil {

	public static class DifferenceCalculationException extends Exception {

		private static final long serialVersionUID = 1L;

		public DifferenceCalculationException(String message) {
			super(message);
		}
	}

	public static SymmetricDifference calculateDifference(Resource modelA, Resource modelB, IMatcher matcher)
			throws DifferenceCalculationException {

		DifferenceSettings settings = new DifferenceSettings();
		settings.setMergeImports(false);
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

		settings.setMergeImports(false);

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
