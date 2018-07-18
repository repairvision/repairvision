package org.sidiff.repair.history.generator.repository.html;

import java.util.ArrayList;
import java.util.List;

public class ModelingDataSet {
	
	private List<ModelingProject> projects = new ArrayList<>();
	
	public ModelingDataSet() {
		
		addProject("emf-store",
				"http://git.eclipse.org/c/emf-store/org.eclipse.emf.emfstore.core.git/log/bundles/org.eclipse.emf.emfstore.client/model/client.ecore",
				"http://git.eclipse.org/c/emf-store/org.eclipse.emf.emfstore.core.git/log/bundles/org.eclipse.emf.emfstore.client/model/client.ecore",
				"http://git.eclipse.org/c/emf-store/org.eclipse.emf.emfstore.core.git/log/bundles/org.eclipse.emf.emfstore.common.model/model/common.ecore",
				"http://git.eclipse.org/c/emf-store/org.eclipse.emf.emfstore.core.git/log/bundles/org.eclipse.emf.emfstore.fuzzy.emf/model/config.ecore",
				"http://git.eclipse.org/c/emf-store/org.eclipse.emf.emfstore.core.git/log/bundles/org.eclipse.emf.emfstore.server.model/model/server.ecore");
		
	}
	
	public void mine() {
		for (ModelingProject modelingProject : projects) {
			modelingProject.mine();
		}
	}
	
	public void addProject(String name, String... htmlURLs) {
		projects.add(new ModelingProject(name, htmlURLs));
	}
	
	public List<ModelingProject> getProjects() {
		return projects;
	}
	
	public void setProjects(List<ModelingProject> projects) {
		this.projects = projects;
	}
}
