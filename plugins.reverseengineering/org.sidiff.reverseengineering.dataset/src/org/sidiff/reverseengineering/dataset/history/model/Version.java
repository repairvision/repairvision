package org.sidiff.reverseengineering.dataset.history.model;

import java.time.Instant;
import java.util.Collections;
import java.util.List;

import org.sidiff.reverseengineering.dataset.history.repository.filter.VersionFilter;
import org.sidiff.reverseengineering.dataset.workspace.model.Workspace;

public class Version {
	
	/**
	 * Creates a binary view on the history, e.g., filtered versions ({@link VersionFilter}).
	 */
	private boolean visible = true;

	/**
	 * The identification, e.g., version number of hash value, of the version in the repository.
	 */
	private String identification;
	
	/**
	 * A trace to another repository, if this a derived version.
	 */
	private String identificationTrace;
	
	/**
	 * The date on which this version was commmitted to the repository.
	 */
	private Instant date;
	
	/**
	 * The author of the committed version.
	 */
	private String author;
	
	/**
	 * The message of the committed version. 
	 */
	private String commitMessage;
	
	/**
	 * The files changes between this and the last version in this history.
	 */
	private List<FileChange> fileChanges;
	
	/**
	 * All projects that are contained in this version of the workspace.
	 */
	private Workspace workspace;
	
	public Version(String url, Instant date, String author, String commitMessage) {
		this.identification = url;
		this.date = date;
		this.author = author;
		this.commitMessage = commitMessage;
	}
	
	public boolean isVisible() {
		return visible;
	}
	
	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public String getIdentification() {
		return identification;
	}

	public void setIdentification(String identification) {
		this.identification = identification;
	}
	
	public String getIdentificationTrace() {
		return identificationTrace;
	}
	
	public void setIdentificationTrace(String identificationTrace) {
		this.identificationTrace = identificationTrace;
	}

	public Instant getDate() {
		return date;
	}

	public void setDate(Instant date) {
		this.date = date;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getCommitMessage() {
		return commitMessage;
	}

	public void setCommitMessage(String commitMessage) {
		this.commitMessage = commitMessage;
	}
	
	public List<FileChange> getFileChanges() {
		
		if (fileChanges == null) {
			return Collections.emptyList();
		}
		
		return fileChanges;
	}
	
	public void setFileChanges(List<FileChange> fileChanges) {
		this.fileChanges = fileChanges;
	}

	public Workspace getWorkspace() {
		return workspace;
	}

	public void setWorkspace(Workspace workspace) {
		this.workspace = workspace;
	}

	@Override
	public String toString() {
		StringBuilder text = new StringBuilder();
		
		text.append("Version [");
		text.append("visible=");
		text.append(visible);
		text.append(", ID=");
		text.append(identification);
		text.append(", ID-Trace=");
		text.append(identificationTrace);
		text.append(", date=");
		text.append(date);
		text.append(", workspace(size) = ");
		text.append((workspace != null) ? workspace.getProjects().size() : "n.a.");
		text.append(", author=");
		text.append(author);
		text.append(", commitMessage=");
		text.append(commitMessage.replace("\n", "").replace("\r", ""));
		text.append("]");
		
		return text.toString();
	}
	
	
}
