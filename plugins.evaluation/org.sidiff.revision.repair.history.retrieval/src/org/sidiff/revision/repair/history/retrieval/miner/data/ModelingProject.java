package org.sidiff.revision.repair.history.retrieval.miner.data;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.sidiff.revision.repair.history.retrieval.ecore.EcoreHistorySettings;
import org.sidiff.revision.repair.history.retrieval.miner.connectors.IRepositoryMiner;

public class ModelingProject {
	
	private boolean mineModelFiles = true;
	
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
	
	public boolean isMineModelFiles() {
		return mineModelFiles;
	}
	
	public void setMineModelFiles(boolean mineModelFiles) {
		this.mineModelFiles = mineModelFiles;
	}
	
	public void mine(IRepositoryMiner miner, boolean updateHistory, boolean loadFiles) {
		
		// mine model revisions:
		for (ModelHistory modelHistory : modelHistories) {
			modelHistory.mineVersions(miner);
//			modelHistory.writeMetadate();
		}
		
		// mine model files:
		if (mineModelFiles) {

			// mine files:
			for (ModelHistory modelHistory : modelHistories) {
				modelHistory.mineVersionFiles(miner, updateHistory, loadFiles);
			}
		}
		
		// write meta date per model version:
		Set<String> historyNames = new HashSet<>();
		
		for (ModelHistory modelHistory : modelHistories) {
			String historyName = EcoreHistorySettings.getInstance().generateHistoryName(modelHistory.getFile());
			
			String uniqueHistoryName = historyName;
			
			while(historyNames.contains(uniqueHistoryName.toLowerCase())) {
				uniqueHistoryName = uniqueHistoryName + "_";
			}
			
			historyNames.add(uniqueHistoryName);
			
			File datafile = new File(getLocalPath() + "/" + uniqueHistoryName  + ".json");
			modelHistory.writeMetadate(datafile);
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
