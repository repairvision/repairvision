package org.sidiff.revision.api;

/**
 * Setup for the complementation calculation.
 * 
 * @author Manuel Ohrndorf
 */
public interface ComplementationSettings {

	boolean isSaveDifference();
	
	void setSaveDifference(boolean saveDifference);
	
	boolean isValidateDifference();
	
	void setValidateDifference(boolean validateDifference);
	
}
