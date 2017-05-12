package org.sidiff.repair.ui.peo.evaluation.data;

import java.io.Serializable;
import java.util.Iterator;

import org.sidiff.repair.historymodel.History;
import org.sidiff.repair.historymodel.Version;

/**
 *	RQ1 per history.
 */
public class ResearchQuestion01 implements Serializable {

	private static final long serialVersionUID = 1L;

	public String historyURI = "N/A";
	
	public int revisionsAll = 0;
	
	public int avgElements = 0;
	
	public int countOfInconsistenciesAll = 0;
	
	public int countOfInconsistenciesConfigured = 0;
	
	public int atLeastOnRepairRE = 0;
	
	public int atLeastOnFixingRepairRE = 0;
	
	public int atLeastOnRepairOPK = 0;
	
	public int atLeastOnFixingRepairOPK = 0;
	
	public double getRatioAtLeastOnRepair() {
		return RepairEvaluation.ratio(atLeastOnRepairOPK, atLeastOnRepairRE);
	}
	
	public double getRatioAtLeastOnFixedRepair() {
		return RepairEvaluation.ratio(atLeastOnFixingRepairOPK, atLeastOnFixingRepairRE);
	}
	
	public static int getAVGElements(History history) {
		return (countElementsOfVersion(history.getVersions().get(0))
				+ countElementsOfVersion(history.getVersions().get(history.getVersions().size() - 1))) / 2;
	}
	
	public static int countElementsOfVersion(Version version) {
		int count = 0;
		
		for (Iterator<?> iterator = version.getModel().getAllContents(); iterator.hasNext();) {
			iterator.next();
			++count; 
		}
		
		return count;
	}
}
