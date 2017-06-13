package org.sidiff.repair.history.evaluation.data;

import java.io.Serializable;
import java.util.Collection;

/**
 *	RQ3 per validation: complement rule -> repaired as observed.
 */
public class ResearchQuestion04 implements Serializable {

	private static final long serialVersionUID = 1L;

	public String historyURI = "N/A";
	
	public String repairedModelURI = "N/A";
	
	public String elementURI = "N/A";
	
	public String validationID = "N/A";
	
	public String editRuleName = "N/A";
	
	public int countOfRepairs = 0;
	
	public int positionOfComplement = 0;
	
	public int countOfHistoricChanges = 0;
	
	public int countOfComplementingChanges = 0;
	
	public int getPositionOfComplement() {
		// return positionOfComplementMin + ((positionOfComplementMax - positionOfComplementMin) / 2)
		return positionOfComplement;
	}
	
	public static int getAVGPositionOfComplement(Collection<ResearchQuestion04> allRQ04) {
		int positionOfComplement = 0;
		int count = 0;
		
		for (ResearchQuestion04 researchQuestion04 : allRQ04) {
			positionOfComplement += researchQuestion04.getPositionOfComplement();
			++count;
		}
		
		return (int) RepairEvaluation.ratio(positionOfComplement, count);
	}
	
	public static int getAVGCountOfRepairs(Collection<ResearchQuestion04> allRQ04) {
		int countOfRepairs = 0;
		int count = 0;
		
		for (ResearchQuestion04 researchQuestion04 : allRQ04) {
			countOfRepairs += researchQuestion04.countOfRepairs;
			++count;
		}
		
		return (int) RepairEvaluation.ratio(countOfRepairs, count);
	}
}
