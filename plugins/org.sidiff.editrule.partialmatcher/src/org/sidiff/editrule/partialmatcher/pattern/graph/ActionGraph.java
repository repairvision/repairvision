package org.sidiff.editrule.partialmatcher.pattern.graph;

import org.eclipse.emf.henshin.model.Rule;
import org.sidiff.editrule.partialmatcher.util.LiftingGraphIndex;
import org.sidiff.editrule.partialmatcher.util.MatchingHelper;

public class ActionGraph {
	
	protected Rule editRule;

	protected MatchingHelper matchingHelper;
	
	protected LiftingGraphIndex changeIndex;
	
	public ActionGraph(Rule editRule, MatchingHelper matchingHelper, LiftingGraphIndex changeIndex) {
		this.editRule = editRule;
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
