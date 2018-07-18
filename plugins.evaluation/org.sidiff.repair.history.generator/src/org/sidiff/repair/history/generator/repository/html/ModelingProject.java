package org.sidiff.repair.history.generator.repository.html;

import java.util.ArrayList;
import java.util.List;

public class ModelingProject {
	
	private String name;
	
	private List<ModelHistory> modelHistories = new ArrayList<>();
	
	public ModelingProject(String name, List<ModelHistory> modelHistories) {
		this.name = name;
		this.modelHistories = modelHistories;
	}
	
	public void mine() {
		for (ModelHistory modelHistory : modelHistories) {
			new Thread(() -> {
			    new HTMLRepositoryMiner().mine(modelHistory);
			}).start();
		}
	}
	
	public ModelingProject(String name, String... htmlURLs) {
		this.name = name;
		
		for (String htmlURL : htmlURLs) {
			this.modelHistories.add(new ModelHistory(htmlURL));
		}
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public List<ModelHistory> getModelHistories() {
		return modelHistories;
	}
	
	public void setModelHistories(List<ModelHistory> modelHistories) {
		this.modelHistories = modelHistories;
	}
}
