package org.sidiff.repair.api.ranking;

import java.util.Comparator;

import org.eclipse.emf.henshin.model.Rule;
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
		
		if ((o1 instanceof Rule) && (o2 instanceof Rule)) {
			compare((Rule) o1, (Rule) o2);
		}
		
		else if ((o1 instanceof IRepairPlan) && (o2 instanceof IRepairPlan)) {
			compare((IRepairPlan) o1, (IRepairPlan) o2);
		} 
		
		return 0;
	}
	
	protected int compare(IRepairPlan repairA, IRepairPlan repairB) {
		double ratioA = (double) repairA.getHistoricChanges().size() / repairA.getComplementingChanges().size();
		double ratioB = (double) repairB.getHistoricChanges().size() / repairB.getComplementingChanges().size();
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
	
	protected int compare(Rule complementA, Rule complementB) {
		
		// Show the element with the greater ratio on top of the viewer:
		IRepairPlan repairA = repairJob.getRepairs().get(complementA).get(0);
		IRepairPlan repairB = repairJob.getRepairs().get(complementB).get(0);
		
		int repairRating = compare(repairA, repairB);
		
		if (repairRating == 0) {
			// By count of repair alternatives:
			return repairJob.getRepairs().get(complementA).size() - repairJob.getRepairs().get(complementB).size();
		} else {
			return repairRating;
		}
	}
}
