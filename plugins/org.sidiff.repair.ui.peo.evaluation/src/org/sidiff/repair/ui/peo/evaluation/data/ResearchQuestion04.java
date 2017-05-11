package org.sidiff.repair.ui.peo.evaluation.data;

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
	
	public int countOfRepairs = -1;
	
	public int positionOfComplement = -1;
	
	public int countOfHistoricChanges = -1;
	
	public int countOfComplementingChanges = -1;
	
	public static int getAVGPositionOfComplement(Collection<ResearchQuestion04> allRQ04) {
		int positionOfComplement = 0;
		int count = 0;
		
		for (ResearchQuestion04 researchQuestion04 : allRQ04) {
			positionOfComplement += researchQuestion04.positionOfComplement;
			++count;
		}
		
		return positionOfComplement / count;
	}
	
	public static int getAVGCountOfRepairs(Collection<ResearchQuestion04> allRQ04) {
		int countOfRepairs = 0;
		int count = 0;
		
		for (ResearchQuestion04 researchQuestion04 : allRQ04) {
			countOfRepairs += researchQuestion04.countOfRepairs;
			++count;
		}
		
		return countOfRepairs / count;
	}
}
