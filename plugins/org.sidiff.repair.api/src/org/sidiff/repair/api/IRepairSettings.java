package org.sidiff.repair.api;

/**
 * Setup for the repair calculation.
 * 
 * @author Manuel Ohrndorf
 */
public interface IRepairSettings {

	boolean saveDifference();
	
	void setSaveDifference(boolean saveDifference);
	
	boolean validateDifference();
	
	void setValidateDifference(boolean validateDifference);
	
}
