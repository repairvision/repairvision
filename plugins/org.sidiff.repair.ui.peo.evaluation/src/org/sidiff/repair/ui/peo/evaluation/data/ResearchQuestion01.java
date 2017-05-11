package org.sidiff.repair.ui.peo.evaluation.data;

import java.io.Serializable;

/**
 *	RQ1 per history.
 */
public class ResearchQuestion01 implements Serializable {

	private static final long serialVersionUID = 1L;

	public String historyURI = "N/A";
	
	public int revisionsAll = -1;
	
	public int avgElements = -1;
	
	public int countOfInconsistenciesAll = -1;
	
	public int countOfInconsistenciesConfigured = -1;
	
	public int atLeastOnRepairRE = -1;
	
	public int atLeastOnFixingRepairRE = -1;
	
	public int atLeastOnRepairOPK = -1;
	
	public int atLeastOnFixingRepairOPK = -1;
	
	public double getRatioAtLeastOnRepair() {
		return atLeastOnRepairOPK / atLeastOnRepairRE;
	}
	
	public double getRatioAtLeastOnFixedRepair() {
		return atLeastOnFixingRepairOPK / atLeastOnFixingRepairRE;
	}
}
