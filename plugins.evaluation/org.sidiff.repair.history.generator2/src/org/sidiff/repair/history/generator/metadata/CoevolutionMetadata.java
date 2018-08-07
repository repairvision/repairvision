package org.sidiff.repair.history.generator.metadata;

public class CoevolutionMetadata extends VersionMetadata {

	private static final String key_coevolutionDate = "coevolutionDate";
	
	public CoevolutionMetadata(HistoryMetadata history) {
		super(history);
	}
	
	public boolean hasCoevolutionDate() {
		return getJSON().has(key_coevolutionDate);
	}

	public String getCoevolutionDate() {
		return getJSON().getString(key_coevolutionDate);
	}
	
	public void setCoevolutionDate(String date) {
		getJSON().put(key_coevolutionDate, date);
	}
}
