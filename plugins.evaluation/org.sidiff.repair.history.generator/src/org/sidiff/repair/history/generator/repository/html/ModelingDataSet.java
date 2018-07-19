package org.sidiff.repair.history.generator.repository.html;

import java.util.ArrayList;
import java.util.List;

public class ModelingDataSet {
	
	private List<ModelingProject> projects = new ArrayList<>();
	
	public static void main(String[] args) {
		String localPateh = "C:\\evaluation\\";
		ModelingDataSet dataSet = new ModelingDataSet();
		
		dataSet.addProject(localPateh, "emf-store", "http://git.eclipse.org/c/emf-store/org.eclipse.emf.emfstore.core.git",
				"/bundles/org.eclipse.emf.emfstore.client/model/client.ecore",
				"/bundles/org.eclipse.emf.emfstore.common.model/model/common.ecore",
				"/bundles/org.eclipse.emf.emfstore.fuzzy.emf/model/config.ecore",
				"/bundles/org.eclipse.emf.emfstore.server.model/model/server.ecore");
		
		dataSet.mine();
	}
	
	public void mine() {
		for (ModelingProject modelingProject : projects) {
			new Thread(() -> {
				modelingProject.mine();
			}).start();
		}
	}
	
	public void addProject(String localPath, String name, String repository, String... files) {
		projects.add(new ModelingProject(localPath, name, repository, files));
	}
	
	public List<ModelingProject> getProjects() {
		return projects;
	}
	
	public void setProjects(List<ModelingProject> projects) {
		this.projects = projects;
	}
}
