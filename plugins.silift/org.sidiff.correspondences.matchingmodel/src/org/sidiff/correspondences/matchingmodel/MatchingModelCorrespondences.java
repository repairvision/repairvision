package org.sidiff.correspondences.matchingmodel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.sidiff.common.collections.DefaultComparators;
import org.sidiff.common.exceptions.SiDiffRuntimeException;
import org.sidiff.correspondences.ICorrespondences;
import org.sidiff.matching.model.Correspondence;
import org.sidiff.matching.model.Matching;
import org.sidiff.matching.model.MatchingModelFactory;

public class MatchingModelCorrespondences implements ICorrespondences {

	public static final String SERVICE_ID = "MatchingModelCorrespondences";
	/**
	 * Index that holds the Correspondence for a model element (if there exists
	 * a correspondence)
	 */
	private Map<EObject, Correspondence> correspondenceIndex = new HashMap<EObject, Correspondence>();


	/**
	 * The underlaying Matching-Model-Instance of the Service.
	 */
	private Matching matching = null;

	public Matching getMatching() {
		return matching;
	}		

	public Correspondence getCorrespondence(EObject element) {
		return correspondenceIndex.get(element);
	}

	@Override
	public boolean hasCorrespondences(EObject element) {
		return correspondenceIndex.get(element) != null;
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
		Correspondence correspondence = MatchingModelFactory.eINSTANCE.createCorrespondence();
		correspondence.setMatchedA(elementA);
		correspondence.setMatchedB(elementB);
		matching.getCorrespondences().add(correspondence);

		// remove elementA and elementB from unmatchedA and unmatchedB,
		// respectively
		matching.getUnmatchedA().remove(elementA);
		matching.getUnmatchedB().remove(elementB);

		// set container correspondence (if existing)
		if (elementA.eContainer() != null && elementB.eContainer() != null) {
			if (correspondenceIndex.get(elementA.eContainer()) != null
					&& correspondenceIndex.get(elementA.eContainer()).getMatchedB() == elementB.eContainer()) {
				correspondence.setContainerCorrespondence(correspondenceIndex.get(elementA.eContainer()));
			}
		}

		// set containment correspondence (if existing)
		for (EObject childA : elementA.eContents()) {
			if (correspondenceIndex.containsKey(childA)
					&& elementB.eContents().contains(correspondenceIndex.get(childA).getMatchedB())
					&& !correspondence.getContainmentCorrespondences().contains(correspondenceIndex.get(childA))) {
				correspondence.getContainmentCorrespondences().add(correspondenceIndex.get(childA));
			}
		}

		// update index
		correspondenceIndex.put(elementA, correspondence);
		correspondenceIndex.put(elementB, correspondence);

	}


	public void removeCorrespondences(EObject element) {
		Correspondence correspondence = correspondenceIndex.get(element);

		// update matching
		correspondence.setContainerCorrespondence(null);
		matching.getCorrespondences().remove(correspondence);
		matching.getUnmatchedA().add(correspondence.getMatchedA());
		matching.getUnmatchedB().add(correspondence.getMatchedB());

		// update index
		correspondenceIndex.remove(correspondence.getMatchedA());
		correspondenceIndex.remove(correspondence.getMatchedB());
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
		if (model == getMatching().getEResourceA()) {
			for (Correspondence correspondence : getMatching().getCorrespondences()) {
				result.add(correspondence.getMatchedA());
			}
		} else if (model == getMatching().getEResourceB()) {
			for (Correspondence correspondence : getMatching().getCorrespondences()) {
				result.add(correspondence.getMatchedB());
			}
		}

		return result;
	}

	@Override
	public Collection<EObject> getElementsWithoutCorrespondences(Resource model) {
		ArrayList<EObject> result = new ArrayList<EObject>();

		if (model == getMatching().getEResourceA()) {
			result.addAll(getMatching().getUnmatchedA());
		} else if (model == getMatching().getEResourceB()) {
			result.addAll(getMatching().getUnmatchedB());
		}

		return result;
	}

	public void removeCorrespondence(EObject element) {
		Correspondence correspondence = correspondenceIndex.get(element);

		// update matching
		correspondence.setContainerCorrespondence(null);
		matching.getCorrespondences().remove(correspondence);
		matching.getUnmatchedA().add(correspondence.getMatchedA());
		matching.getUnmatchedB().add(correspondence.getMatchedB());

		// update index
		correspondenceIndex.remove(correspondence.getMatchedA());
		correspondenceIndex.remove(correspondence.getMatchedB());	}



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
		createMatching(modelA,  modelB);

		// init unmatched
		initUnmatched( modelA,  modelB);

		// init index
		initCorrespondenceIndex();
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
						"MatchingModelService cannot be re-initialized with different models.");
			}
			return;
		}


		// create matching
		createMatching(resourceA, resourceB);

		// init unmatched
		initUnmatched(resourceA, resourceB);

		// init index
		initCorrespondenceIndex();

		// set correspondences
		for (EObject matchedA : service.getElementsWithCorrespondences(resourceA)) {
			// we assume exactly one corresponding element
			EObject matchedB = service.getCorrespondences(matchedA).iterator().next();
			addCorrespondence(matchedA, matchedB);
		}
	}

	public void init(Matching matching) {

		// initialization correct?
		if (this.matching != null) {
			if (this.matching.getEResourceA() != matching.getEResourceA()
					|| this.matching.getEResourceB() != matching.getEResourceB()) {
				throw new SiDiffRuntimeException(
						"MatchingModelService cannot be re-initialized with different models.");
			}
			return;
		}
		// set matching
		this.matching = matching;

		// init index
		initCorrespondenceIndex();

		// set correspondences
		for (Correspondence c : matching.getCorrespondences()) {
			correspondenceIndex.put(c.getMatchedA(), c);
			correspondenceIndex.put(c.getMatchedB(), c);
		}
	}

	private void createMatching(Resource resourceA, Resource resourceB) {
		this.matching = MatchingModelFactory.eINSTANCE.createMatching();
		this.matching.setUriA(resourceA.getURI().toString());
		this.matching.setEResourceA(resourceA);
		this.matching.setUriB(resourceB.getURI().toString());		
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

	private void initCorrespondenceIndex() {
		correspondenceIndex = new TreeMap<EObject, Correspondence>(DefaultComparators.getHashComparator(EObject.class));
	}

	@Override
	public void reset() {
		this.correspondenceIndex.clear();
		this.matching = null;
	}

	@Override
	public String getDescription() {
		return "This is an `MatchingModel` implementation of the CorrespondenceService. ";
	}

	@Override
	public boolean canHandle(Collection<Resource> models) {
		if(models.size() > 2)
			return false;
		return true;
	}


}
