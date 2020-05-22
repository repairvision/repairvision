package org.sidiff.revision.repair.api;

/**
 * Setup for the repair calculation.
 * 
 * @author Manuel Ohrndorf
 */
public interface IRepairSettings {

	boolean isSaveDifference();
	
	void setSaveDifference(boolean saveDifference);
	
	boolean isValidateDifference();
	
	void setValidateDifference(boolean validateDifference);
	
}
