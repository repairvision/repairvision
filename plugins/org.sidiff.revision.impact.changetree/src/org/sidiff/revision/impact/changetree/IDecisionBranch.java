package org.sidiff.revision.impact.changetree;

import java.util.List;

public interface IDecisionBranch extends IDecisionNode {

	void appendChildDecisions(IDecisionNode... children);
	
	void removeChildDecision(IDecisionNode child);
	
	List<IDecisionNode> getChildDecisions();
}
