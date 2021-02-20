package org.sidiff.reverseengineering.dataset.model;

import java.nio.file.Path;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import org.sidiff.reverseengineering.dataset.history.model.History;

public class DataSet {

	private String name;

	private String repositoryHost;

	private String repositoryPath;

	private String timestamp;

	private Path systemModel;

	private History history;

	public DataSet() {
	}

	public DataSet(String repositoryHost, String repositoryPath) {
		this.repositoryHost = repositoryHost;
		this.repositoryPath = repositoryPath;

		// cut '.git' from last URL path segment:
		this.name = repositoryPath.substring(repositoryPath.lastIndexOf("/") + 1, repositoryPath.lastIndexOf("."));
	}

	public String createTimestamp() {
		DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("yyyyMMddHHmmss").withZone(ZoneId.systemDefault());
		this.timestamp = timeFormat.format(Instant.now());
		return timestamp;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRepositoryHost() {
		return repositoryHost;
	}

	public void setRepositoryHost(String repositoryHost) {
		this.repositoryHost = repositoryHost;
	}

	public String getRepositoryPath() {
		return repositoryPath;
	}

	public void setRepositoryPath(String repositoryPath) {
		this.repositoryPath = repositoryPath;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public boolean hasSystemModel() {
		return systemModel != null;
	}

	public Path getSystemModel() {
		return systemModel;
	}

	public void setSystemModel(Path systemModel) {
		this.systemModel = systemModel;
	}

	public History getHistory() {
		return history;
	}

	public void setHistory(History history) {
		this.history = history;
	}

	@Override
	public String toString() {
		return "DataSet [name=" + name + ", repositoryHost=" + repositoryHost + ", repositoryPath=" + repositoryPath
				+ ", timestamp=" + timestamp + ", systemModel=" + systemModel + ", history=" + history + "]";
	}

}
