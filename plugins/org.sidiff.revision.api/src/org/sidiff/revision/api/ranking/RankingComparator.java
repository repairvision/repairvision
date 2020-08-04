package org.sidiff.revision.api.ranking;

import java.util.Comparator;

import org.sidiff.revision.api.ComplementationJob;
import org.sidiff.revision.api.IComplementationPlan;
import org.sidiff.revision.api.util.ComplementationAPIUtil;

public class RankingComparator implements Comparator<Object> {

	protected ComplementationJob<? extends IComplementationPlan> complementationJob;
	
	public RankingComparator(ComplementationJob<? extends IComplementationPlan> complementJob) {
		super();
		this.complementationJob = complementJob;
	}

	@Override
	public int compare(Object o1, Object o2) {
		
		// -1: first complement has higher ranking to the second  -> preferred complement
		// 0 : first complement ranking is equal to the second    -> ambiguous ranking
		// 1 : first complement has lower ranking than the second
		if ((o1 instanceof IComplementationPlan) && (o2 instanceof IComplementationPlan)) {
			return compare((IComplementationPlan) o1, (IComplementationPlan) o2);
		} 
		
		return 0;
	}
	
	protected int compareChangeRatio(IComplementationPlan complementA, IComplementationPlan complementB) {
		double ratioA = (double) complementA.getRecognizedChanges().size() / complementA.getComplementingChanges().size();
		double ratioB = (double) complementB.getRecognizedChanges().size() / complementB.getComplementingChanges().size();
		return (int) Math.signum(ratioB - ratioA);
	}
	
	protected int compareSubRule(IComplementationPlan complementA, IComplementationPlan complementB) {
		int subA = complementA.getRecognizedChanges().size();
		int subB = complementB.getRecognizedChanges().size();
		return subB - subA;
	}
	
	protected int compareComplementRule(IComplementationPlan complementA, IComplementationPlan complementB) {
		int subA = complementA.getComplementingChanges().size();
		int subB = complementB.getComplementingChanges().size();
		return subA - subB;
	}
	
	protected int compareParameters(IComplementationPlan complementA, IComplementationPlan complementB) {
		int unboundA = ComplementationAPIUtil.countUnboundParameters(complementA);
		int unboundB = ComplementationAPIUtil.countUnboundParameters(complementB);
		return unboundA - unboundB;
	}
	
	protected int compareCreations(IComplementationPlan complementA, IComplementationPlan complementB) {
		// TODO: Consider attribute value changes!?
		
		int countOfNodeCreateChangesA = ComplementationAPIUtil.countOfNodeCreateChanges(complementA.getComplementingChanges()); 
		int countOfEdgeCreateChangesA = ComplementationAPIUtil.countOfEdgeCreateChanges(complementA.getComplementingChanges()); 
		int countOfNodeDeleteChangesA = ComplementationAPIUtil.countOfNodeDeleteChanges(complementA.getComplementingChanges()); 
		int countOfEdgeDeleteChangesA = ComplementationAPIUtil.countOfEdgeDeleteChanges(complementA.getComplementingChanges());
		int creationsA = (countOfNodeCreateChangesA + countOfEdgeCreateChangesA) - (countOfNodeDeleteChangesA + countOfEdgeDeleteChangesA);
		
		int countOfNodeCreateChangesB = ComplementationAPIUtil.countOfNodeCreateChanges(complementB.getComplementingChanges()); 
		int countOfEdgeCreateChangesB = ComplementationAPIUtil.countOfEdgeCreateChanges(complementB.getComplementingChanges()); 
		int countOfNodeDeleteChangesB = ComplementationAPIUtil.countOfNodeDeleteChanges(complementB.getComplementingChanges());
		int countOfEdgeDeleteChangesB = ComplementationAPIUtil.countOfEdgeDeleteChanges(complementB.getComplementingChanges());
		int creationsB = (countOfNodeCreateChangesB + countOfEdgeCreateChangesB) - (countOfNodeDeleteChangesB + countOfEdgeDeleteChangesB);
		
		return creationsB - creationsA;
	}
	
	protected int compareNames(IComplementationPlan complementA, IComplementationPlan complementB) {
		return complementA.getRecognizedEditRule().getName().compareTo(complementB.getRecognizedEditRule().getName());
	}
	
	protected int compare(IComplementationPlan complementA, IComplementationPlan complementB) {
		int result = compareChangeRatio(complementA, complementB);
		
		if (result == 0) {
			result = compareSubRule(complementA, complementB);
			
			if (result == 0) {
				result = compareComplementRule(complementA, complementB);
				
				if (result == 0) {
					result = compareParameters(complementA, complementB);
					
					if (result == 0) {
						result = compareCreations(complementA, complementB);
						
						if (result == 0) {
							result = compareNames(complementA, complementB);
						}
					}
				}
			}
		}
		
		return result;
	}
}
