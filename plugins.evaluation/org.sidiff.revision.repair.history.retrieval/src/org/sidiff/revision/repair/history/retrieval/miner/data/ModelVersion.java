package org.sidiff.revision.repair.history.retrieval.miner.data;

import java.io.File;
import java.text.ParseException;

import org.sidiff.revision.repair.history.retrieval.ecore.EcoreHistorySettings;

public class ModelVersion {
	
	private String file;
	
	private String commit;
	
	private String date;
	
	private String message;
	
	private String author;
	
	private boolean exists = true;
	
	public ModelVersion(String gitPath, String commit, String date, String message, String author) {
		this.file = gitPath;
		this.commit = commit;
		this.date = date;
		this.message = message;
		this.author = author;
	}
	
	public ModelVersion(String gitPath, ModelVersion otherVersion) {
		this.file = gitPath;
		this.commit = otherVersion.commit;
		this.date = otherVersion.date;
		this.message = otherVersion.message;
		this.author = otherVersion.author;
	}
	
	public String getLocalPath() {
		try {
			return "/" + EcoreHistorySettings.getInstance().generateVersionName(
					EcoreHistorySettings.DATE_ISO8601.parse(date), commit) 
					+ "/" + new File(file).getParent().replace("\\", "/") + "/";
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String getFileName() {
		return new File(file).getName();
	}
	
	public String getRemotePath() {
		return file;
	}
	
	public void setGitPath(String gitPath) {
		this.file = gitPath;
	}
	
	public String getCommit() {
		return commit;
	}
	
	public void setCommit(String commit) {
		this.commit = commit;
	}
	
	public String getDate() {
		return date;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String autor) {
		this.author = autor;
	}
	
	public boolean isExists() {
		return exists;
	}
	
	public void setExists(boolean exists) {
		this.exists = exists;
	}
	
	@Override
	public String toString() {
		return date + " : " + commit + " : " + message + " : " + author + " : " + file;
	}
}
