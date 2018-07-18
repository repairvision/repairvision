package org.sidiff.repair.history.generator.repository.html;

import java.util.ArrayList;
import java.util.List;

public class ModelHistory {
	
	private String htmlURL;
	
	private String gitURL;
	
	private List<ModelVersion> versions = new ArrayList<>();
	
	public ModelHistory(String htmlURL) {
		this.htmlURL = htmlURL;
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
	
	public List<ModelVersion> getVersions() {
		return versions;
	}
	
	public void setVersions(List<ModelVersion> versions) {
		this.versions = versions;
	}
	
}
