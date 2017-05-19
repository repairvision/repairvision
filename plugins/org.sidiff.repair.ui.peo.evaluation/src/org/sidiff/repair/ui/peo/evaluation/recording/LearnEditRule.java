package org.sidiff.repair.ui.peo.evaluation.recording;

import static org.sidiff.difference.technical.api.TechnicalDifferenceFacade.deriveTechnicalDifference;

import org.eclipse.emf.ecore.resource.Resource;
import org.sidiff.common.emf.exceptions.InvalidModelException;
import org.sidiff.common.emf.exceptions.NoCorrespondencesException;
import org.sidiff.difference.symmetric.SymmetricDifference;
import org.sidiff.difference.technical.api.settings.DifferenceSettings;
import org.sidiff.editrule.partialmatcher.util.IndexedCrossReferencer;
import org.sidiff.editrule.partialmatcher.util.LiftingGraphDomainMap;
import org.sidiff.editrule.partialmatcher.util.LiftingGraphIndex;
import org.sidiff.editrule.partialmatcher.util.MatchingHelper;

public class LearnEditRule {
	
	protected DifferenceSlice slice;
	
	protected DifferenceSlicingCriterion slicingCriterion;
	
	protected DifferenceNavigation navigation;
	
	public LearnEditRule(DifferenceSettings settings,
			Resource modelHistorical, 
			Resource modelIntroduced, 
			Resource modelResolved) {
		
		// Initialize slicing criterion:
		this.slicingCriterion = new DifferenceSlicingCriterion();
		
		// Calculate difference:
		SymmetricDifference difference = null;
		
		try {
			difference = deriveTechnicalDifference(modelHistorical, modelResolved, settings);
		} catch (InvalidModelException | NoCorrespondencesException e) {
			e.printStackTrace();
		}
		
		this.slice = new DifferenceSlice(difference);
		
		// Create difference navigation:
		LiftingGraphDomainMap changeDomainMap = new LiftingGraphDomainMap(difference);
		LiftingGraphIndex changeIndex = new LiftingGraphIndex(difference);

		// Create matching helper:
		IndexedCrossReferencer crossReferencer = new IndexedCrossReferencer();
		crossReferencer.addResource(difference.getModelA());
		crossReferencer.addResource(difference.getModelB());

		MatchingHelper matchingHelper = new MatchingHelper(crossReferencer);
		
		this.navigation = new DifferenceNavigation(changeIndex, changeDomainMap, matchingHelper);
	}
	
	public SymmetricDifference getDifference() {
		return slice.getDifference();
	}

	public DifferenceSlice getSlice() {
		return slice;
	}

	public void setSlice(DifferenceSlice slice) {
		this.slice = slice;
	}

	public DifferenceSlicingCriterion getSlicingCriterion() {
		return slicingCriterion;
	}

	public void setSlicingCriterion(DifferenceSlicingCriterion slicingCriterion) {
		this.slicingCriterion = slicingCriterion;
	}

	public DifferenceNavigation getNavigation() {
		return navigation;
	}

	public void setNavigation(DifferenceNavigation navigation) {
		this.navigation = navigation;
	}
}
