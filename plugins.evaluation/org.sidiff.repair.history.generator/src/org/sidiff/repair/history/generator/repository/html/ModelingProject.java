package org.sidiff.repair.history.generator.repository.html;

import java.util.ArrayList;
import java.util.List;

public class ModelingProject {
	
	private String name;
	
	private String repository;
	
	private List<ModelHistory> modelHistories = new ArrayList<>();
	
	public ModelingProject(String name, List<ModelHistory> modelHistories) {
		this.name = name;
		this.modelHistories = modelHistories;
	}
	
	public ModelingProject(String name, String repository, String... files) {
		this.name = name;
		this.repository = repository;
		
		for (String file : files) {
			this.modelHistories.add(new ModelHistory(this, file));
		}
	}
	
	public void mine() {
		
		// mine model revisions:
		for (ModelHistory modelHistory : modelHistories) {
			modelHistory.mine();
		}
		
		// mine revisions relative to other models:
		for (ModelHistory modelHistory : modelHistories) {
			for (ModelHistory otherModelHistory : modelHistories) {
				otherModelHistory.mine(modelHistory.getVersions());
			}
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
}
