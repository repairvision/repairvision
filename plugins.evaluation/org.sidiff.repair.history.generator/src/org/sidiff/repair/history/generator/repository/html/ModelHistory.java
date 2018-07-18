package org.sidiff.repair.history.generator.repository.html;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ModelHistory {
	
	private ModelingProject modelingProject;
	
	private String file;
	
	private List<ModelVersion> versions;
	
	public ModelHistory(ModelingProject modelingProject, String file) {
		this.modelingProject = modelingProject;
		this.file = file;
	}
	
	public void mine() {
		HTMLRepositoryMiner miner = new HTMLRepositoryMiner(modelingProject.getRepository(), file);
		this.versions = miner.mine();
		
	}
	
	public void mine(List<ModelVersion> otherModels) {
		Set<String> commits = versions.stream().map(ModelVersion::getCommit).collect(Collectors.toSet());
		
		for (ModelVersion otherModel : otherModels) {
			if (!commits.contains(otherModel.getCommit())) {
				ModelVersion otherModelVersion = new ModelVersion(file, otherModel);
				
				HTMLRepositoryMiner miner = new HTMLRepositoryMiner(modelingProject.getRepository(), file);
				miner.mine(otherModel);
				
				versions.add(otherModelVersion);
			}
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
