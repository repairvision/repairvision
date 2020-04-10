package org.sidiff.revision.repair.history.retrieval.metadata.coevolution;

import java.text.ParseException;
import java.util.Date;

import org.sidiff.revision.repair.history.retrieval.ecore.EcoreHistorySettings;
import org.sidiff.revision.repair.history.retrieval.metadata.HistoryMetadata;
import org.sidiff.revision.repair.history.retrieval.metadata.VersionMetadata;

public class CoevolutionVersionMetadata extends VersionMetadata {

	private static final String key_coevolutionDate = "coevolutionDate";
	
	private Date parsedCoevolutionDate;
	
	public CoevolutionVersionMetadata(HistoryMetadata history) {
		super(history);
	}
	
	public CoevolutionVersionMetadata(HistoryMetadata history, VersionMetadata original) {
		super(history, original);
	}
	
	public CoevolutionVersionMetadata(HistoryMetadata history, CoevolutionVersionMetadata original) {
		super(history, original);
		setCoevolutionDate(original.getCoevolutionDate());
	}
	
	public boolean hasCoevolutionDate() {
		return getJSON().has(key_coevolutionDate);
	}
	
	public Date getParsedCoevolutionDate() {
		if (hasCoevolutionDate() && (parsedCoevolutionDate == null)) {
			try {
				this.parsedCoevolutionDate = EcoreHistorySettings.DATE_ISO8601.parse(getCoevolutionDate());
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return parsedCoevolutionDate;
	}

	public String getCoevolutionDate() {
		if (hasCoevolutionDate()) {
			return getJSON().getString(key_coevolutionDate);
		}
		return null;
	}
	
	public void setCoevolutionDate(String date) {
		getJSON().put(key_coevolutionDate, date);
	}
	
	public Date getWorkspaceDate() {
		return hasCoevolutionDate() ? getParsedCoevolutionDate() : getParsedDate();
	}
	
	@Override
	public int compareTo(VersionMetadata otherVersion) {
		int versionCompare = super.compareTo(otherVersion);
		
		if ((versionCompare == 0) && (otherVersion instanceof CoevolutionVersionMetadata)) {
			CoevolutionVersionMetadata otherCoevolutionVersion = (CoevolutionVersionMetadata) otherVersion;
			versionCompare = otherCoevolutionVersion.getWorkspaceDate().compareTo(getWorkspaceDate());
		}
		
		return versionCompare;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof CoevolutionVersionMetadata) {
			CoevolutionVersionMetadata otherCoevolutionVersion = (CoevolutionVersionMetadata) obj;
			return super.equals(obj) && otherCoevolutionVersion.getWorkspaceDate().equals(getWorkspaceDate());
		}
		return false;
	}
}
