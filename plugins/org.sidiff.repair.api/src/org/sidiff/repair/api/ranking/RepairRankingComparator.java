package org.sidiff.repair.api.ranking;

import java.util.Comparator;

import org.sidiff.repair.api.IRepairPlan;
import org.sidiff.repair.api.RepairJob;
import org.sidiff.repair.api.util.RepairAPIUtil;

public class RepairRankingComparator implements Comparator<Object> {

	protected RepairJob<? extends IRepairPlan> repairJob;
	
	public RepairRankingComparator(RepairJob<? extends IRepairPlan> repairJob) {
		super();
		this.repairJob = repairJob;
	}

	@Override
	public int compare(Object o1, Object o2) {
		
		if ((o1 instanceof IRepairPlan) && (o2 instanceof IRepairPlan)) {
			compare((IRepairPlan) o1, (IRepairPlan) o2);
		} 
		
		return 0;
	}
	
	protected int compare(IRepairPlan repairA, IRepairPlan repairB) {
		double ratioA = (double) repairA.getRecognizedChanges().size() / repairA.getComplementingChanges().size();
		double ratioB = (double) repairB.getRecognizedChanges().size() / repairB.getComplementingChanges().size();
		double diff = (ratioA - ratioB);

		if (diff != 0) {
			if (diff < 0) {
				// Ratio of B is greater then A -> B on the top:
				return 1;
			} else {
				// Ratio of A is greater then B -> A on the top:
				return -1;
			}
		} else {
			
			// Ratio A equals Ratio B:
			int countOfNodeDeleteChangesA = RepairAPIUtil.countOfNodeDeleteChanges(repairA.getComplementingChanges()); 
			int countOfNodeDeleteChangesB = RepairAPIUtil.countOfNodeDeleteChanges(repairB.getComplementingChanges());
			
			int countOfEdgeDeleteChangesA = RepairAPIUtil.countOfEdgeDeleteChanges(repairA.getComplementingChanges()); 
			int countOfEdgeDeleteChangesB = RepairAPIUtil.countOfEdgeDeleteChanges(repairB.getComplementingChanges());
			
			int morePreserving = 
					(2 * countOfNodeDeleteChangesA + countOfEdgeDeleteChangesA)
					- (2 * countOfNodeDeleteChangesB + countOfEdgeDeleteChangesB);
			
			if (morePreserving != 0) {
				if (morePreserving > 0) {
					// A deletes more then B -> B on the top::
					return 1;
				} else {
					// B deletes more then A -> A on the top:
					return -1;
				}
			}
		}
		
		return 0;
	}
}
