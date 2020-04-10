package org.sidiff.revision.repair.history.retrieval.metadata;

import java.io.File;
import java.text.ParseException;
import java.util.Date;

import org.sidiff.revision.repair.history.retrieval.ecore.EcoreHistorySettings;
import org.sidiff.revision.repair.history.retrieval.json.JSONObject;

public class VersionMetadata implements Comparable<VersionMetadata> {
	
	private static final String key_date = "date";
	
	private static final String key_commit = "commit";
	
	private static final String key_author = "author";
	
	private static final String key_message = "message";
	
	private static final String key_exists = "exists";
	
	private static final String key_remoteFilePath = "remoteFilePath";
	
	private static final String key_localFilePath = "localFilePath";
	
	private JSONObject version = new JSONObject();
	
	private Date parsedDate;
	
	private HistoryMetadata history;
	
	public VersionMetadata(HistoryMetadata history) {
		this.history = history;
	}
	
	public VersionMetadata(HistoryMetadata history, VersionMetadata original) {
		this(history);
		setAuthor(original.getAuthor());
		setCommit(original.getCommit());
		setDate(original.getDate());
		setExists(original.getExists());
		setLocalFilePath(original.getLocalFilePath());
		setMessage(original.getMessage());
		setRemoteFilePath(original.getRemoteFilePath());
	}
	
	public String getDate() {
		return version.getString(key_date);
	}
	
	public void setDate(String date) {
		version.put(key_date, date);
	}
	
	public Date getParsedDate() {
		if (parsedDate == null) {
			try {
				this.parsedDate = EcoreHistorySettings.DATE_ISO8601.parse(getDate());
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return parsedDate;
	}
	
	public String getPathCompatibleDate() {
		return getDate().replace(":", "-");
	}

	public String getCommit() {
		return version.getString(key_commit);
	}
	
	public void setCommit(String commit) {
		version.put(key_commit, commit);
	}

	public String getAuthor() {
		return version.getString(key_author);
	}
	
	public void setAuthor(String author) {
		version.put(key_author, author);
	}

	public String getMessage() {
		return version.getString(key_message);
	}
	
	public void setMessage(String message) {
		version.put(key_message, message);
	}
	
	public boolean getExists() {
		return version.getBoolean(key_exists);
	}
	
	public void setExists(boolean exists) {
		version.put(key_exists, exists);
	}

	public String getRemoteFilePath() {
		return version.getString(key_remoteFilePath);
	}
	
	public void setRemoteFilePath(String remoteFilePath) {
		version.put(key_remoteFilePath, remoteFilePath);
	}

	public String getLocalFilePath() {
		return version.getString(key_localFilePath);
	}
	
	public void setLocalFilePath(String localFilePath) {
		version.put(key_localFilePath, localFilePath);
	}
	
	public File getLocalFile() {
		return new File(history.getDatafile().getParent() + File.separator + getLocalFilePath());
	}
	
	public String getFileName() {
		return new File(getRemoteFilePath()).getName();
	}
	
	public HistoryMetadata getHistory() {
		return history;
	}
	
	public void setHistory(HistoryMetadata history) {
		this.history = history;
	}

	protected JSONObject getJSON() {
		return version;
	}
	
	protected void setJSON(JSONObject version) {
		this.version = version;
	}

	@Override
	public int compareTo(VersionMetadata otherVersion) {
		return otherVersion.getParsedDate().compareTo(getParsedDate());
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof VersionMetadata) {
			VersionMetadata otherVersion = (VersionMetadata) obj;
			
			return super.equals(obj) 
					|| (otherVersion.getDate().equals(getDate())
					&& otherVersion.getCommit().equals(getCommit()));
		}
		return false;
	}
	
	@Override
	public String toString() {
		return super.toString() + "(Date: " + getDate() + ", Commit: " + getCommit() + ")";
	}
}
