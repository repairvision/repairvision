package org.sidiff.repair.ui.peo.evaluation.data;

import java.io.Serializable;

/**
 *	RQ2 per history.
 */
public class ResearchQuestion02 implements Serializable {

	private static final long serialVersionUID = 1L;

	public String historyURI = "N/A";
	
	public int historicallyObservableInconsistenciesAll = 0;
	
	public int historicallyObservableInconsistenciesConfigured = 0;
	
	public int repairAsObservedRE = 0;
	
	public int repairAsObservedOPK = 0;
	
	public double getRatioRepairAsObserved() {
		return RepairEvaluation.ratio(repairAsObservedRE, repairAsObservedOPK);
	}
}
