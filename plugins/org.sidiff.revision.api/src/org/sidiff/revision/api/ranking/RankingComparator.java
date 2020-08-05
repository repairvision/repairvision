package org.sidiff.revision.api.ranking;

import java.util.Comparator;

import org.sidiff.revision.api.ComplementationJob;
import org.sidiff.revision.api.ComplementationPlan;
import org.sidiff.revision.api.util.ComplementationAPIUtil;

public class RankingComparator implements Comparator<Object> {

	protected ComplementationJob<? extends ComplementationPlan> complementationJob;
	
	public RankingComparator(ComplementationJob<? extends ComplementationPlan> complementJob) {
		super();
		this.complementationJob = complementJob;
	}

	@Override
	public int compare(Object o1, Object o2) {
		
		// -1: first complement has higher ranking to the second  -> preferred complement
		// 0 : first complement ranking is equal to the second    -> ambiguous ranking
		// 1 : first complement has lower ranking than the second
		if ((o1 instanceof ComplementationPlan) && (o2 instanceof ComplementationPlan)) {
			return compare((ComplementationPlan) o1, (ComplementationPlan) o2);
		} 
		
		return 0;
	}
	
	protected int compareChangeRatio(ComplementationPlan complementA, ComplementationPlan complementB) {
		double ratioA = (double) complementA.getRecognizedChanges().size() / complementA.getComplementingChanges().size();
		double ratioB = (double) complementB.getRecognizedChanges().size() / complementB.getComplementingChanges().size();
		return (int) Math.signum(ratioB - ratioA);
	}
	
	protected int compareSubRule(ComplementationPlan complementA, ComplementationPlan complementB) {
		int subA = complementA.getRecognizedChanges().size();
		int subB = complementB.getRecognizedChanges().size();
		return subB - subA;
	}
	
	protected int compareComplementRule(ComplementationPlan complementA, ComplementationPlan complementB) {
		int subA = complementA.getComplementingChanges().size();
		int subB = complementB.getComplementingChanges().size();
		return subA - subB;
	}
	
	protected int compareParameters(ComplementationPlan complementA, ComplementationPlan complementB) {
		int unboundA = ComplementationAPIUtil.countUnboundParameters(complementA);
		int unboundB = ComplementationAPIUtil.countUnboundParameters(complementB);
		return unboundA - unboundB;
	}
	
	protected int compareCreations(ComplementationPlan complementA, ComplementationPlan complementB) {
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
	
	protected int compareNames(ComplementationPlan complementA, ComplementationPlan complementB) {
		return complementA.getRecognizedEditRule().getName().compareTo(complementB.getRecognizedEditRule().getName());
	}
	
	protected int compare(ComplementationPlan complementA, ComplementationPlan complementB) {
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
