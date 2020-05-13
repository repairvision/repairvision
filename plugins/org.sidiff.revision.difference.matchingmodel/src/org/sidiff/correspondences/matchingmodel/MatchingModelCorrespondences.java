package org.sidiff.correspondences.matchingmodel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.sidiff.common.exceptions.SiDiffRuntimeException;
import org.sidiff.correspondences.ICorrespondences;
import org.sidiff.revision.difference.Correspondence;
import org.sidiff.revision.difference.Difference;
import org.sidiff.revision.difference.DifferenceFactory;

public class MatchingModelCorrespondences implements ICorrespondences {

	public static final String SERVICE_ID = "SymmetricDifferencCorrespondences";

	/**
	 * The underlaying Difference-Model-Instance of the Service.
	 */
	private Difference matching = null;

	public Difference getDifference() {
		return matching;
	}		

	public Correspondence getCorrespondence(EObject element) {
		Correspondence correspondence = matching.getCorrespondenceOfModelA(element);
		
		if (correspondence == null) {
			return matching.getCorrespondenceOfModelB(element);
		}
		
		return null;
	}

	@Override
	public boolean hasCorrespondences(EObject element) {
		return getCorrespondence(element) != null;
	}

	@Override
	public void addCorrespondence(EObject... elements) {
		if (elements.length != 2) {
			throw new UnsupportedOperationException("Only pairwise matches allowed: Size " + elements.length);
		}

		addCorrespondence(elements[0], elements[1]);

	}
	public void addCorrespondence(EObject elementA, EObject elementB) {

		// add correspondence to matching
		Correspondence correspondence = DifferenceFactory.eINSTANCE.createCorrespondence();
		correspondence.setMatchedA(elementA);
		correspondence.setMatchedB(elementB);
		matching.addCorrespondence(correspondence);

		// remove elementA and elementB from unmatchedA and unmatchedB,
		// respectively
		matching.getUnmatchedA().remove(elementA);
		matching.getUnmatchedB().remove(elementB);
	}


	public void removeCorrespondences(EObject element) {
		Correspondence correspondence = getCorrespondence(element);

		// update matching
		matching.removeCorrespondence(correspondence);
		matching.getUnmatchedA().add(correspondence.getMatchedA());
		matching.getUnmatchedB().add(correspondence.getMatchedB());
	}

	@Override
	public Collection<EObject> getCorrespondences(EObject element) {
		ArrayList<EObject> correspondences = new ArrayList<EObject>();
		Correspondence correspondence = getCorrespondence(element);
		if (correspondence != null) {
			correspondences.add(correspondence.getMatchedA() == element ? correspondence.getMatchedB()
					: correspondence.getMatchedA());
		}

		return correspondences;
	}

	public EObject getCorrespondingElement(EObject element) {
		return getCorrespondences(element).iterator().next();
	}
	@Override
	public boolean isCorresponding(EObject... elements) {
		if (elements.length != 2) {
			throw new UnsupportedOperationException(); // only pairwise matches
			// allowed
		}		

		return isCorresponding(elements[0], elements[1]);


	}
	public boolean isCorresponding(EObject elementA, EObject elementB) {
		// correspondence between elementA and elementB
		return getCorrespondence(elementA) != null && getCorrespondence(elementA).getMatchedB() == elementB;
	}

	@Override
	public Collection<EObject> getElementsWithCorrespondences(Resource model) {
		ArrayList<EObject> result = new ArrayList<EObject>();
		if (model == getDifference().getEResourceA()) {
			for (Correspondence correspondence : getDifference().getCorrespondences()) {
				result.add(correspondence.getMatchedA());
			}
		} else if (model == getDifference().getEResourceB()) {
			for (Correspondence correspondence : getDifference().getCorrespondences()) {
				result.add(correspondence.getMatchedB());
			}
		}

		return result;
	}

	@Override
	public Collection<EObject> getElementsWithoutCorrespondences(Resource model) {
		ArrayList<EObject> result = new ArrayList<EObject>();

		if (model == getDifference().getEResourceA()) {
			result.addAll(getDifference().getUnmatchedA());
		} else if (model == getDifference().getEResourceB()) {
			result.addAll(getDifference().getUnmatchedB());
		}

		return result;
	}

	@Override
	public void removeCorrespondence(EObject... elements) {
		for (EObject element : elements) {
			removeCorrespondences(element);
		}
	}

	@Override
	public void removeFromCorrespondence(EObject element) {
		//As we only support pairwise correspondences, we remove the whole correspondence itself
		removeCorrespondence(element);
	}

	@Override
	public void init(Collection<Resource> models) {


		if (!canHandle(models)) {
			throw new UnsupportedOperationException(); // only pairwise matches
			// allowed
		}	

		Iterator<Resource> it = models.iterator();
		Resource modelA = it.next();
		Resource modelB = it.next();


		// create matching
		createSymmetricDifference(modelA,  modelB);

		// init unmatched
		initUnmatched( modelA,  modelB);
	}

	@Override
	public String getServiceID() {
		return SERVICE_ID;
	}

	public void init(ICorrespondences service, Resource resourceA, Resource resourceB) {

		// initialization correct?
		if (this.matching != null) {
			if (this.matching.getEResourceA() != resourceA || this.matching.getEResourceB() != resourceB) {
				throw new SiDiffRuntimeException(
						"SymmetricDifferenceModelService cannot be re-initialized with different models.");
			}
			return;
		}


		// create matching
		createSymmetricDifference(resourceA, resourceB);

		// init unmatched
		initUnmatched(resourceA, resourceB);

		// set correspondences
		for (EObject matchedA : service.getElementsWithCorrespondences(resourceA)) {
			// we assume exactly one corresponding element
			EObject matchedB = service.getCorrespondences(matchedA).iterator().next();
			addCorrespondence(matchedA, matchedB);
		}
	}

	public void init(Difference difference) {

		// initialization correct?
		if (this.matching != null) {
			if (this.matching.getEResourceA() != difference.getEResourceA()
					|| this.matching.getEResourceB() != difference.getEResourceB()) {
				throw new SiDiffRuntimeException(
						"SymmetricDifferenceModelService cannot be re-initialized with different models.");
			}
			return;
		}
		
		this.matching = difference;
	}

	private void createSymmetricDifference(Resource resourceA, Resource resourceB) {
		this.matching = DifferenceFactory.eINSTANCE.createDifference();
		this.matching.setUriModelA(resourceA.getURI().toString());
		this.matching.setEResourceA(resourceA);
		this.matching.setUriModelB(resourceB.getURI().toString());		
		this.matching.setEResourceB(resourceB);
	}

	private void initUnmatched(Resource resourceA, Resource resourceB) {
		// add unmatchedA
		for (Iterator<EObject> iterator = resourceA.getAllContents(); iterator.hasNext();) {
			EObject obj = iterator.next();
			matching.getUnmatchedA().add(obj);
		}

		// add unmatchedB
		for (Iterator<EObject> iterator = resourceB.getAllContents(); iterator.hasNext();) {
			EObject obj = iterator.next();
			matching.getUnmatchedB().add(obj);
		}
	}

	@Override
	public void reset() {
		this.matching = null;
	}

	@Override
	public String getDescription() {
		return "This is an `Difference` implementation of the CorrespondenceService. ";
	}

	@Override
	public boolean canHandle(Collection<Resource> models) {
		if(models.size() > 2)
			return false;
		return true;
	}


}
