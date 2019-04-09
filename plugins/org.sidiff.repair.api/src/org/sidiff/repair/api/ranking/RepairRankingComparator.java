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
		
		// -1: first repair has higher ranking to the second  -> preferred repair
		// 0 : first repair ranking is equal to the second    -> ambiguous ranking
		// 1 : first repair has lower ranking than the second
		if ((o1 instanceof IRepairPlan) && (o2 instanceof IRepairPlan)) {
			return compare((IRepairPlan) o1, (IRepairPlan) o2);
		} 
		
		return 0;
	}
	
	protected int compareChangeRatio(IRepairPlan repairA, IRepairPlan repairB) {
		double ratioA = (double) repairA.getRecognizedChanges().size() / repairA.getComplementingChanges().size();
		double ratioB = (double) repairB.getRecognizedChanges().size() / repairB.getComplementingChanges().size();
		return (int) Math.signum(ratioB - ratioA);
	}
	
	protected int compareSubRule(IRepairPlan repairA, IRepairPlan repairB) {
		int subA = repairA.getRecognizedChanges().size();
		int subB = repairB.getRecognizedChanges().size();
		return subB - subA;
	}
	
	protected int compareComplementRule(IRepairPlan repairA, IRepairPlan repairB) {
		int subA = repairA.getComplementingChanges().size();
		int subB = repairB.getComplementingChanges().size();
		return subA - subB;
	}
	
	protected int compareParameters(IRepairPlan repairA, IRepairPlan repairB) {
		int unboundA = RepairAPIUtil.countUnboundParameters(repairA);
		int unboundB = RepairAPIUtil.countUnboundParameters(repairB);
		return unboundA - unboundB;
	}
	
	protected int compareCreations(IRepairPlan repairA, IRepairPlan repairB) {
		// TODO: Consider attribute value changes!?
		
		int countOfNodeCreateChangesA = RepairAPIUtil.countOfNodeCreateChanges(repairA.getComplementingChanges()); 
		int countOfEdgeCreateChangesA = RepairAPIUtil.countOfEdgeCreateChanges(repairA.getComplementingChanges()); 
		int countOfNodeDeleteChangesA = RepairAPIUtil.countOfNodeDeleteChanges(repairA.getComplementingChanges()); 
		int countOfEdgeDeleteChangesA = RepairAPIUtil.countOfEdgeDeleteChanges(repairA.getComplementingChanges());
		int creationsA = (countOfNodeCreateChangesA + countOfEdgeCreateChangesA) - (countOfNodeDeleteChangesA + countOfEdgeDeleteChangesA);
		
		int countOfNodeCreateChangesB = RepairAPIUtil.countOfNodeCreateChanges(repairB.getComplementingChanges()); 
		int countOfEdgeCreateChangesB = RepairAPIUtil.countOfEdgeCreateChanges(repairB.getComplementingChanges()); 
		int countOfNodeDeleteChangesB = RepairAPIUtil.countOfNodeDeleteChanges(repairB.getComplementingChanges());
		int countOfEdgeDeleteChangesB = RepairAPIUtil.countOfEdgeDeleteChanges(repairB.getComplementingChanges());
		int creationsB = (countOfNodeCreateChangesB + countOfEdgeCreateChangesB) - (countOfNodeDeleteChangesB + countOfEdgeDeleteChangesB);
		
		return creationsB - creationsA;
	}
	
	protected int compareNames(IRepairPlan repairA, IRepairPlan repairB) {
		return repairA.getRecognizedEditRule().getName().compareTo(repairB.getRecognizedEditRule().getName());
	}
	
	protected int compare(IRepairPlan repairA, IRepairPlan repairB) {
		int result = compareChangeRatio(repairA, repairB);
		
		if (result == 0) {
			result = compareSubRule(repairA, repairB);
			
			if (result == 0) {
				result = compareComplementRule(repairA, repairB);
				
				if (result == 0) {
					result = compareParameters(repairA, repairB);
					
					if (result == 0) {
						result = compareCreations(repairA, repairB);
						
						if (result == 0) {
							result = compareNames(repairA, repairB);
						}
					}
				}
			}
		}
		
		return result;
	}
}
