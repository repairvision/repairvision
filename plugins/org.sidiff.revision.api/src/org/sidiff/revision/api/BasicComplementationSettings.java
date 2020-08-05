package org.sidiff.revision.api;

public class BasicComplementationSettings implements ComplementationSettings {

	/**
	 * Save the calculated model difference.
	 */
	private boolean saveDifference = true;
	
	/**
	 * Validate the calculated model difference.
	 */
	private boolean validateDifference = false;

	@Override
	public boolean isSaveDifference() {
		return saveDifference;
	}

	@Override
	public void setSaveDifference(boolean saveDifference) {
		this.saveDifference = saveDifference;
	}

	@Override
	public boolean isValidateDifference() {
		return validateDifference;
	}

	@Override
	public void setValidateDifference(boolean validateDifference) {
		this.validateDifference = validateDifference;
	}
}
