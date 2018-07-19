package org.sidiff.repair.history.generator.repository.html;

import java.util.ArrayList;
import java.util.List;

public class ModelingProject {
	
	private String localPath;
	
	private String name;
	
	private String repository;
	
	private List<ModelHistory> modelHistories = new ArrayList<>();
	
	public ModelingProject(String localPath, String name, String repository, List<ModelHistory> modelHistories) {
		this.localPath = localPath;
		this.name = name;
		this.repository = repository;
		this.modelHistories = modelHistories;
	}
	
	public ModelingProject(String localPath, String name, String repository, String... files) {
		this.localPath = localPath + name + "/";
		this.name = name;
		this.repository = repository;
		
		for (String file : files) {
			this.modelHistories.add(new ModelHistory(this, file));
		}
	}
	
	public void mine() {
		
		// mine model revisions:
		for (ModelHistory modelHistory : modelHistories) {
			modelHistory.mineVersions();
			
			// write meta date per model version:
			modelHistory.writeMetadate();
		}
		
		// mine revisions relative to other models:
		for (ModelHistory modelHistory : modelHistories) {
			for (ModelHistory otherModelHistory : modelHistories) {
				otherModelHistory.addVersionsFromOtherModel(modelHistory.getVersions());
			}
		}
		
		// mine files:
		for (ModelHistory modelHistory : modelHistories) {
			modelHistory.mineVersionFiles();
		}
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getRepository() {
		return repository;
	}
	
	public void setRepository(String repository) {
		this.repository = repository;
	}
	
	public List<ModelHistory> getModelHistories() {
		return modelHistories;
	}
	
	public void setModelHistories(List<ModelHistory> modelHistories) {
		this.modelHistories = modelHistories;
	}
	
	public String getLocalPath() {
		return localPath;
	}
	
	public void setLocalPath(String localPath) {
		this.localPath = localPath;
	}
}
