package org.sidiff.repair.ui.peo.evaluation.data;

import java.io.Serializable;

/**
 *	RQ2 per history.
 */
public class ResearchQuestion02 implements Serializable {

	private static final long serialVersionUID = 1L;

	public String historyURI = "N/A";
	
	public int historicallyObservableInconsistenciesAll = -1;
	
	public int historicallyObservableInconsistenciesConfigured = -1;
	
	public int repairAsObservedRE = -1;
	
	public int repairAsObservedOPK = -1;
	
	public double getRatioRepairAsObserved() {
		return repairAsObservedRE / repairAsObservedOPK;
	}
}
