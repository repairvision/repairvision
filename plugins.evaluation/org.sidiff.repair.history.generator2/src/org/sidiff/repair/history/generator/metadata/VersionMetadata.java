package org.sidiff.repair.history.generator.metadata;

import java.text.ParseException;
import java.util.Date;

import org.sidiff.repair.history.generator.json.JSONObject;

public class VersionMetadata {
	
	private static final String key_date = "date";
	
	private static final String key_commit = "commit";
	
	private static final String key_author = "author";
	
	private static final String key_message = "message";
	
	private static final String key_remoteFilePath = "remoteFilePath";
	
	private static final String key_localFilePath = "localFilePath";
	
	private JSONObject version = new JSONObject();

	public String getDate() {
		return version.getString(key_date);
	}
	
	public Date getParsedDate() {
		try {
			return HistoryMetadata.DATE_ISO8601.parse(getDate());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void setDate(String date) {
		version.put(key_date, date);
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

	protected JSONObject getJSON() {
		return version;
	}
	
	protected void setJSON(JSONObject version) {
		this.version = version;
	}
}
