package org.sidiff.validation.constraint.interpreter.decisiontree;

import java.util.List;

public interface IDecisionNode {

	void appendChildDecisions(IDecisionNode... children);
	
	void removeChildDecision(IDecisionNode child);
	
	List<IDecisionNode> getChildDecisions();
}
