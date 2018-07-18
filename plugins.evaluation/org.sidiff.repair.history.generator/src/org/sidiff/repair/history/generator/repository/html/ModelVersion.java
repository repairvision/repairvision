package org.sidiff.repair.history.generator.repository.html;

public class ModelVersion {
	
	private String htmlURL;
	
	private String gitURL;
	
	private String commit;
	
	private String date;
	
	private String message;
	
	private String autor;
	
	public ModelVersion(String htmlURL, String gitURL, String commit, String date, String message, String autor) {
		this.htmlURL = htmlURL;
		this.gitURL = gitURL;
		this.commit = commit;
		this.date = date;
		this.message = message;
		this.autor = autor;
	}

	public String getHtmlURL() {
		return htmlURL;
	}
	
	public void setHtmlURL(String htmlURL) {
		this.htmlURL = htmlURL;
	}
	
	public String getGitURL() {
		return gitURL;
	}
	
	public void setGitURL(String gitURL) {
		this.gitURL = gitURL;
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
	
	public String getAutor() {
		return autor;
	}
	
	public void setAutor(String autor) {
		this.autor = autor;
	}
}
