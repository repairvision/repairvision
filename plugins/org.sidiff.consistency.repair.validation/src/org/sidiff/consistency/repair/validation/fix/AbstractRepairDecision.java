package org.sidiff.consistency.repair.validation.fix;

import java.util.LinkedList;
import java.util.List;

public class AbstractRepairDecision implements IRepairDecision {
	
	protected List<IRepairDecision> repairs = new LinkedList<>();

	@Override
	public void appendChildDecisions(IRepairDecision... repairs) {
		for (IRepairDecision repair : repairs) {
			this.repairs.add(repair);
		}
	}
	
	@Override
	public void removeChildDecision(IRepairDecision repair) {
		repairs.remove(repair);
	}

	@Override
	public List<IRepairDecision> getChildDecisions() {
		return repairs;
	}
}
