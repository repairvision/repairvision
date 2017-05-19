package org.sidiff.repair.ui.peo.evaluation.recording;

import org.sidiff.editrule.partialmatcher.util.LiftingGraphDomainMap;
import org.sidiff.editrule.partialmatcher.util.LiftingGraphIndex;
import org.sidiff.editrule.partialmatcher.util.MatchingHelper;

public class DifferenceNavigation {

	protected LiftingGraphIndex changeIndex;
	
	protected LiftingGraphDomainMap changeDomainMap;
	
	protected MatchingHelper matchingHelper;

	public DifferenceNavigation(
			LiftingGraphIndex changeIndex, 
			LiftingGraphDomainMap changeDomainMap,
			MatchingHelper matchingHelper) {
		super();
		this.changeIndex = changeIndex;
		this.changeDomainMap = changeDomainMap;
		this.matchingHelper = matchingHelper;
	}

	public LiftingGraphIndex getChangeIndex() {
		return changeIndex;
	}

	public void setChangeIndex(LiftingGraphIndex changeIndex) {
		this.changeIndex = changeIndex;
	}

	public LiftingGraphDomainMap getChangeDomainMap() {
		return changeDomainMap;
	}

	public void setChangeDomainMap(LiftingGraphDomainMap changeDomainMap) {
		this.changeDomainMap = changeDomainMap;
	}

	public MatchingHelper getMatchingHelper() {
		return matchingHelper;
	}

	public void setMatchingHelper(MatchingHelper matchingHelper) {
		this.matchingHelper = matchingHelper;
	}
}
