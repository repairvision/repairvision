package org.sidiff.repair.history.generator.repository.html;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.jsoup.HttpStatusException;
import org.sidiff.repair.history.generator.repository.git.json.JSONObject;

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
		JSONObject history = new JSONObject();
		history.put("project", modelingProject.getName());
		history.put("repository", modelingProject.getRepository());
		
		for (ModelVersion modelVersion : versions) {
			JSONObject version = new JSONObject();
			version.put("data", modelVersion.getDate());
			version.put("commit", modelVersion.getCommit());
			version.put("author", modelVersion.getAuthor());
			version.put("message", modelVersion.getMessage());
			version.put("gitFileName", modelVersion.getFile());
			version.put("localFileName", modelVersion.getLocalPath() + modelVersion.getFileName());
			
			history.append("commits", version);
		}
		
		FileWriter fileWriter = null;
		
		try {
			File metafilePath = new File(modelingProject.getLocalPath());
			metafilePath.mkdirs();
			
			File metafile = new File(metafilePath.getAbsolutePath() + "/" +  getFileName() + ".json");
			metafile.createNewFile();
			
			fileWriter = new FileWriter(metafile);
			fileWriter.write(history.toString(4));
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fileWriter != null) {
				try {
					fileWriter.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public void mineVersions() {
		HTMLRepositoryMiner miner = new HTMLRepositoryMiner(modelingProject.getRepository(), file);
		this.versions = miner.mine();
		
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
	
	public void mineVersionFiles() {
		HTMLRepositoryMiner miner = new HTMLRepositoryMiner(modelingProject.getRepository(), file);
		FileWriter writer = null;
		
		for (ModelVersion modelVersion : versions) {
			String fileContent =  null;
			
			try {
				fileContent = miner.mine(modelVersion);
			} catch (HttpStatusException hse) {
				if (!additionalVersions.contains(modelVersion)) {
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
		return new File(file).getName();
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
