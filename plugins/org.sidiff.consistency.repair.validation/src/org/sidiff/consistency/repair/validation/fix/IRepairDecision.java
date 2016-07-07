package org.sidiff.consistency.repair.validation.fix;

import java.util.List;

public interface IRepairDecision {

	void appendChildDecisions(IRepairDecision... repairs);
	
	void removeChildDecision(IRepairDecision repair);
	
	List<IRepairDecision> getChildDecisions();
}
