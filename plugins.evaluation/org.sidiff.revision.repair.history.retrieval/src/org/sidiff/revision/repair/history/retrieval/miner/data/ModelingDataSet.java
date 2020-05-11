package org.sidiff.revision.repair.history.retrieval.miner.data;

import java.util.ArrayList;
import java.util.List;

import org.sidiff.revision.repair.history.retrieval.miner.connectors.IRepositoryMiner;

public class ModelingDataSet {
	
	private List<ModelingProject> projects = new ArrayList<>();
	
	private List<IRepositoryMiner> miners = new ArrayList<>();
	
	public void mine(boolean updateHistory, boolean loadFiles) {
		for (ModelingProject modelingProject : projects) {
//			new Thread(() -> {
				System.out.println("STARTING: " + modelingProject.getRepository());
				modelingProject.mine(getMiner(modelingProject.getRepository()), updateHistory, loadFiles);
				System.out.println("FINISHED: " + modelingProject.getRepository());
//			}).start();
		}
	}
	
	public IRepositoryMiner getMiner(String repositoryURL) {
		for (IRepositoryMiner repositoryMiner : miners) {
			if (repositoryMiner.supports(repositoryURL)) {
				return repositoryMiner;
			}
		}
		
		throw new RuntimeException("Unsupported Repository: " + repositoryURL);
	}
	
	public void addProject(String localPath, String name, String repository, String info, String... files) {
		projects.add(new ModelingProject(localPath, name, repository, info, files));
	}
	
	public List<ModelingProject> getProjects() {
		return projects;
	}
	
	public void setProjects(List<ModelingProject> projects) {
		this.projects = projects;
	}
	
	public void addMiners(IRepositoryMiner... miners) {
		for (IRepositoryMiner repositoryMiner : miners) {
			this.miners.add(repositoryMiner);
		}
	}
	
	public List<IRepositoryMiner> getMiners() {
		return miners;
	}
	
	public void setMiners(List<IRepositoryMiner> miners) {
		this.miners = miners;
	}
}
