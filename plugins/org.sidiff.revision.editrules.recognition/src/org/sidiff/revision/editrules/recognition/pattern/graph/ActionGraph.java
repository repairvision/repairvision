package org.sidiff.revision.editrules.recognition.pattern.graph;

import org.eclipse.emf.henshin.model.Rule;
import org.sidiff.history.revision.IRevision;
import org.sidiff.revision.editrules.recognition.revision.RevisionGraph;

public class ActionGraph {
	
	protected Rule editRule;

	protected RevisionGraph matchingHelper;
	
	public ActionGraph(Rule editRule) {
		this.editRule = editRule;
	}
	
	public void initialize(RevisionGraph matchingHelper) {
		this.matchingHelper = matchingHelper;
	}

	public Rule getEditRule() {
		return editRule;
	}

	public RevisionGraph getMatchingHelper() {
		return matchingHelper;
	}
	
	public IRevision getRevision() {
		return matchingHelper.getRevision();
	}
}
