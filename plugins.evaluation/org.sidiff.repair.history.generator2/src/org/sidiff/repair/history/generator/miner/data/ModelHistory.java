package org.sidiff.repair.history.generator.miner.data;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.jsoup.HttpStatusException;
import org.sidiff.repair.history.generator.metadata.HistoryMetadata;
import org.sidiff.repair.history.generator.metadata.VersionMetadata;
import org.sidiff.repair.history.generator.miner.connectors.IRepositoryMiner;

public class ModelHistory {
	
	private ModelingProject modelingProject;
	
	private String file;
	
	private List<ModelVersion> versions;
	
	private List<ModelVersion> additionalVersions = new ArrayList<>();
	
	public ModelHistory(ModelingProject modelingProject, String file) {
		this.modelingProject = modelingProject;
		this.file = file;
	}
	
	public void writeMetadate() {
		
		// write meta data per model:
		File metafile = new File(modelingProject.getLocalPath() + "/" +  getFileName() + ".json");
		
		HistoryMetadata history = new HistoryMetadata(metafile);
		history.setProjectName(modelingProject.getName());
		history.setRepositoryURL(modelingProject.getRepository());
		history.setInfo(modelingProject.getInfo());
		
		for (ModelVersion modelVersion : versions) {
			VersionMetadata version = new VersionMetadata();
			version.setDate(modelVersion.getDate());
			version.setCommit(modelVersion.getCommit());
			version.setAuthor(modelVersion.getAuthor());
			version.setMessage(modelVersion.getMessage());
			version.setRemoteFilePath(modelVersion.getFile());
			version.setLocalFilePath(modelVersion.getLocalPath() + modelVersion.getFileName());
			
			history.getVersions().add(version);
		}
		
		history.write();
	}
	
	public void mineVersions(IRepositoryMiner miner) {
		this.versions = miner.mineHistory(modelingProject.getRepository(), file);
		
	}
	
	public void addVersionsFromOtherModel(List<ModelVersion> otherModels) {
		Set<String> commits = versions.stream().map(ModelVersion::getCommit).collect(Collectors.toSet());
		
		for (ModelVersion otherModel : otherModels) {
			if (!commits.contains(otherModel.getCommit())) {
				ModelVersion otherModelVersion = new ModelVersion(file, otherModel);
				versions.add(otherModelVersion);
				additionalVersions.add(otherModelVersion);
			}
		}
	}
	
	public void mineVersionFiles(IRepositoryMiner miner) {
		FileWriter writer = null;
		
		for (ModelVersion modelVersion : versions) {
			String fileContent =  null;
			
			try {
				fileContent = miner.mineVersion(modelingProject.getRepository(), modelVersion);
			} catch (HttpStatusException hse) {
				if (!additionalVersions.contains(modelVersion)) {
					if (hse.getStatusCode() == 500) {
						System.err.print("(Error! ) ");
					} else if (hse.getStatusCode() == 404) {
						System.err.print("(Warning! ) ");
					}
					System.err.println("Http Status Exception: " + hse.getStatusCode() + ", URL=" + hse.getUrl());
				}
			}
			
			if (fileContent != null) {
				try {
					File outputPath = new File(modelingProject.getLocalPath() + modelVersion.getLocalPath());
					outputPath.mkdirs();
					
					writer = new FileWriter(new File(outputPath + "/" + modelVersion.getFileName()));
					writer.write(fileContent);
					writer.close();
				} catch(IOException e) {
					e.printStackTrace();
				} finally {
					if (writer != null) {
						try {
							writer.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
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
