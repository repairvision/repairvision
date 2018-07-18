package org.sidiff.repair.history.generator.repository.html;

public class ModelVersion {
	
	private String gitPath;
	
	private String commit;
	
	private String date;
	
	private String message;
	
	private String author;
	
	public ModelVersion(String gitPath, String commit, String date, String message, String author) {
		this.gitPath = gitPath;
		this.commit = commit;
		this.date = date;
		this.message = message;
		this.author = author;
	}
	
	public ModelVersion(String gitPath, ModelVersion otherVersion) {
		this.gitPath = gitPath;
		this.commit = otherVersion.commit;
		this.date = otherVersion.date;
		this.message = otherVersion.message;
		this.author = otherVersion.author;
	}
	
	public String getGitPath() {
		return gitPath;
	}
	
	public void setGitPath(String gitPath) {
		this.gitPath = gitPath;
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
	
	@Override
	public String toString() {
		return date + " : " + commit + " : " + message + " : " + author + " : " + gitPath;
	}
}
