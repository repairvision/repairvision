package org.sidiff.repair.history.generator.miner.data;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

import org.sidiff.repair.history.generator.ecore.EcoreHistorySettings;
import org.sidiff.repair.history.generator.metadata.HistoryMetadata;
import org.sidiff.repair.history.generator.metadata.VersionMetadata;
import org.sidiff.repair.history.generator.miner.connectors.IRepositoryMiner;

public class ModelHistory {
	
	private boolean update = true;
	
	private ModelingProject modelingProject;
	
	private String file;
	
	private List<ModelVersion> versions;
	
	public ModelHistory(ModelingProject modelingProject, String file) {
		this.modelingProject = modelingProject;
		this.file = file;
	}
	
	public boolean isUpdate() {
		return update;
	}
	
	public void setUpdate(boolean update) {
		this.update = update;
	}
	
	public void writeMetadate() {
		
		// write meta data per model:
		HistoryMetadata history = new HistoryMetadata();
		history.setProjectName(modelingProject.getName());
		history.setRepositoryURL(modelingProject.getRepository());
		history.setInfo(modelingProject.getInfo());
		
		for (ModelVersion modelVersion : versions) {
			VersionMetadata version = new VersionMetadata(history);
			version.setDate(modelVersion.getDate());
			version.setCommit(modelVersion.getCommit());
			version.setAuthor(modelVersion.getAuthor());
			version.setMessage(modelVersion.getMessage());
			version.setExists(modelVersion.isExists());
			version.setRemoteFilePath(modelVersion.getRemotePath());
			version.setLocalFilePath(modelVersion.getLocalPath() + modelVersion.getFileName());
			
			history.getVersions().add(version);
		}
		
		File metafile = new File(modelingProject.getLocalPath() + "/" +  EcoreHistorySettings.getInstance().generateHistoryName(file) + ".json");
		history.setDatafile(metafile);
		history.write();
	}
	
	public void mineVersions(IRepositoryMiner miner) {
		this.versions = miner.mineHistory(modelingProject.getRepository(), file);
		
	}
	
	public void mineVersionFiles(IRepositoryMiner miner) {
		for (ModelVersion modelVersion : versions) {
			File outputFolder = new File(modelingProject.getLocalPath() + modelVersion.getLocalPath());
			File outputFile = new File(outputFolder + "/" + modelVersion.getFileName());
			
			if (!update || !outputFile.exists()) {
				modelVersion.setExists(false);
				
				try {
					miner.mineVersion(
							modelingProject.getRepository(), 
							modelVersion.getRemotePath(), 
							modelVersion.getCommit(), 
							outputFile.getAbsolutePath());
					modelVersion.setExists(true);
				} catch (FileNotFoundException fnfe) {
					System.err.println("(Warning!) File not found: " + miner.getVersionURL(
							modelingProject.getRepository(), 
							modelVersion.getRemotePath(), 
							modelVersion.getCommit()));
				} catch(Exception e) {
					System.err.println("Exception: " +miner.getVersionURL(
							modelingProject.getRepository(), 
							modelVersion.getRemotePath(), 
							modelVersion.getCommit()));
					e.printStackTrace();
				}
			}
		}
	}
	
	public String getFileName() {
		int parameters = file.lastIndexOf("?");
		
		if (parameters == -1) {
			return new File(file).getName();
		} else {
			return new File(file.substring(0, parameters)).getName();
		}
			
	}
	
	public String getFile() {
		return file;
	}
	
	public void setFile(String file) {
		this.file = file;
	}
	
	public List<ModelVersion> getVersions() {
		return versions;
	}
	
	public void setVersions(List<ModelVersion> versions) {
		this.versions = versions;
	}
}
