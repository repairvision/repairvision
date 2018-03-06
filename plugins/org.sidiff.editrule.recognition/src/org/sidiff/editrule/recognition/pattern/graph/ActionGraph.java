package org.sidiff.editrule.recognition.pattern.graph;

import org.eclipse.emf.henshin.model.Rule;
import org.sidiff.editrule.recognition.util.LiftingGraphIndex;
import org.sidiff.editrule.recognition.util.MatchingHelper;

public class ActionGraph {
	
	protected Rule editRule;

	protected MatchingHelper matchingHelper;
	
	protected LiftingGraphIndex changeIndex;
	
	public ActionGraph(Rule editRule) {
		this.editRule = editRule;
	}
	
	public void initialize(MatchingHelper matchingHelper, LiftingGraphIndex changeIndex) {
		this.matchingHelper = matchingHelper;
		this.changeIndex = changeIndex;
	}

	public Rule getEditRule() {
		return editRule;
	}

	public MatchingHelper getMatchingHelper() {
		return matchingHelper;
	}

	public LiftingGraphIndex getChangeIndex() {
		return changeIndex;
	}
}
