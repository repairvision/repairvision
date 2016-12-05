package org.sidiff.repair.api;

public class BasicRepairSettings implements IRepairSettings {

	private boolean saveDifference = true;

	@Override
	public boolean saveDifference() {
		return saveDifference;
	}

	@Override
	public void setSaveDifference(boolean saveDifference) {
		this.saveDifference = saveDifference;
	}
}
