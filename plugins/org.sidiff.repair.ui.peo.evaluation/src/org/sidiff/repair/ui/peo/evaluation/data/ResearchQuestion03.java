package org.sidiff.repair.ui.peo.evaluation.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *	RQ3 per validation.
 */
public class ResearchQuestion03 implements Serializable {

	private static final long serialVersionUID = 1L;

	public String historyURI = "N/A";
	
	public String repairedModelURI = "N/A";
	
	public String elementURI = "N/A";
	
	public String validationID = "N/A";
	
	public int repairActionsRE = -1;
	
	public int repairTreePathsRE = -1;
	
	public List<int[]> complementsRulesAndRepairs = new ArrayList<>();
	
	public long msTimePartialMatching;
	
	public long msTimeComplementMatching;
	
	public void addComplementsAndRepairs(int complements, int repairs) {
		complementsRulesAndRepairs.add(new int[] {complements, repairs});
	}
	
	public int getComplementsAllOPK() {
		int count = 0;
		
		for (int[] complementRulesAndRepairs : complementsRulesAndRepairs) {
			count += complementRulesAndRepairs[0];
		}
		
		return count;
	}
	
	public int getRepairsAllOPK() {
		int count = 0;
		
		for (int[] complementRulesAndRepairs : complementsRulesAndRepairs) {
			count += complementRulesAndRepairs[1];
		}
		
		return count;
	}
	
	public double getRatio() {
		return repairTreePathsRE / getRepairsAllOPK();
	}
	
	public static int getRepairActionsRE(Collection<ResearchQuestion03> allRQ03) {
		int repairActionsRE = 0;
		
		for (ResearchQuestion03 researchQuestion03 : allRQ03) {
			repairActionsRE += researchQuestion03.repairActionsRE;
		}
		
		return repairActionsRE;
	}
	
	public static int getRepairTreePathsRE(Collection<ResearchQuestion03> allRQ03) {
		int repairTreePathsRE = 0;
		
		for (ResearchQuestion03 researchQuestion03 : allRQ03) {
			repairTreePathsRE += researchQuestion03.repairTreePathsRE;
		}
		
		return repairTreePathsRE;
	}
	
	public static int getRepairsAllOPK(Collection<ResearchQuestion03> allRQ03) {
		int repairsAllOPK = 0;
		
		for (ResearchQuestion03 researchQuestion03 : allRQ03) {
			repairsAllOPK += researchQuestion03.getRepairsAllOPK();
		}
		
		return repairsAllOPK;
	}
	
	public static int getAVGRepairsAllOPK(Collection<ResearchQuestion03> allRQ03) {
		int repairsAllOPK = 0;
		int count = 0;
		
		for (ResearchQuestion03 researchQuestion03 : allRQ03) {
			repairsAllOPK += researchQuestion03.getRepairsAllOPK();
			++count;
		}
		
		return repairsAllOPK / count;
	}
	
	public static int getAVGComplementsAllOPK(Collection<ResearchQuestion03> allRQ03) {
		int complementsAllOPK = 0;
		int count = 0;
		
		for (ResearchQuestion03 researchQuestion03 : allRQ03) {
			complementsAllOPK += researchQuestion03.getComplementsAllOPK();
			++count;
		}
		
		return complementsAllOPK / count;
	}
}
