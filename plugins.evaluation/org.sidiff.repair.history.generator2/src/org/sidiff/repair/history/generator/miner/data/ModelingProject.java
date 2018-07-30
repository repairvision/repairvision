package org.sidiff.repair.history.generator.miner.data;

import java.util.ArrayList;
import java.util.List;

import org.sidiff.repair.history.generator.miner.connectors.IRepositoryMiner;

public class ModelingProject {
	
	private static final boolean MINE_MODEL_FILES = true;
	
	private String localPath;
	
	private String name;
	
	private String repository;
	
	private String info;
	
	private List<ModelHistory> modelHistories = new ArrayList<>();
	
	public ModelingProject(String localPath, String name, String repository, String info, List<ModelHistory> modelHistories) {
		this.localPath = localPath;
		this.name = name;
		this.repository = repository;
		this.info = info;
		this.modelHistories = modelHistories;
	}
	
	public ModelingProject(String localPath, String name, String repository, String info, String... files) {
		this.localPath = localPath + name + "/";
		this.name = name;
		this.repository = repository;
		this.info = info;
		
		for (String file : files) {
			this.modelHistories.add(new ModelHistory(this, file));
		}
	}
	
	public void mine(IRepositoryMiner miner) {
		
		// mine model revisions:
		for (ModelHistory modelHistory : modelHistories) {
			modelHistory.mineVersions(miner);
			
			// write meta date per model version:
			modelHistory.writeMetadate();
		}
		
		// mine model files:
		if (MINE_MODEL_FILES) {
			
			// mine revisions relative to other models:
			for (ModelHistory modelHistory : modelHistories) {
				for (ModelHistory otherModelHistory : modelHistories) {
					otherModelHistory.addVersionsFromOtherModel(modelHistory.getVersions());
				}
			}
			
			// mine files:
			for (ModelHistory modelHistory : modelHistories) {
				modelHistory.mineVersionFiles(miner);
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
	
	public String getInfo() {
		return info;
	}
	
	public void setInfo(String info) {
		this.info = info;
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
