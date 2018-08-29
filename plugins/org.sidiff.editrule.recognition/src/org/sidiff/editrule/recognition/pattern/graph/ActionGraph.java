package org.sidiff.editrule.recognition.pattern.graph;

import org.eclipse.emf.henshin.model.Rule;
import org.sidiff.editrule.recognition.util.MatchingHelper;
import org.sidiff.history.revision.IRevision;

public class ActionGraph {
	
	protected Rule editRule;

	protected MatchingHelper matchingHelper;
	
	public ActionGraph(Rule editRule) {
		this.editRule = editRule;
	}
	
	public void initialize(MatchingHelper matchingHelper) {
		this.matchingHelper = matchingHelper;
	}

	public Rule getEditRule() {
		return editRule;
	}

	public MatchingHelper getMatchingHelper() {
		return matchingHelper;
	}
	
	public IRevision getRevision() {
		return matchingHelper.getRevision();
	}
}
