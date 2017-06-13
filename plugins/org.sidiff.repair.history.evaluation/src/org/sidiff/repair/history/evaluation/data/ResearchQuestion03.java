package org.sidiff.repair.history.evaluation.data;

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
	
	public int repairActionsRE = 0;
	
	public int repairTreePathsRE = 0;
	
	public int complementsAllOPK = 0;
	
	public List<Integer> repairsPerComplementOPK = new ArrayList<>();
	
	public long msTimePartialMatching;
	
	public long msTimeComplementMatching;
	
	public void addRepairsPerComplement(int repairs) {
		repairsPerComplementOPK.add(repairs);
		++complementsAllOPK;
	}
	
	public int getRepairsAllOPK() {
		int count = 0;
		
		for (Integer repairsPerComplement : repairsPerComplementOPK) {
			count += repairsPerComplement;
		}
		
		return count;
	}
	
	public double getRatio() {
		return RepairEvaluation.ratio(repairTreePathsRE, getRepairsAllOPK());
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
		
		return (int) RepairEvaluation.ratio(repairsAllOPK, count);
	}
	
	public static int getAVGComplementsAllOPK(Collection<ResearchQuestion03> allRQ03) {
		int complementsAllOPK = 0;
		int count = 0;
		
		for (ResearchQuestion03 researchQuestion03 : allRQ03) {
			complementsAllOPK += researchQuestion03.complementsAllOPK;
			++count;
		}
		
		return (int) RepairEvaluation.ratio(complementsAllOPK, count);
	}
}
