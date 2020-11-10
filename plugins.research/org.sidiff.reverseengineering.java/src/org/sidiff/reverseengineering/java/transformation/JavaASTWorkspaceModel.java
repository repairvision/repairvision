package org.sidiff.reverseengineering.java.transformation;

import java.io.IOException;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.xmi.XMLResource;

/**
 * Model which contains all projects of the workspace.
 * 
 * @author Manuel Ohrndorf
 */
public abstract class JavaASTWorkspaceModel {

	/**
	 * The model representing a Java workspace.
	 */
	private XMLResource workspaceModel;
	
	/**
	 * Name of the workspace model.
	 */
	private String name;

	/**
	 * @param workspaceModel The model representing a Java workspace.
	 */
	public JavaASTWorkspaceModel(XMLResource workspaceModel, String name) {
		this.workspaceModel = workspaceModel;
		this.name = name;
	}

	/**
	 * @param projectModel The model element representing the project's root.
	 */
	public abstract void addToWorkspace(EObject projectModel);
	
	/**
	 * @return The model representing a Java workspace.
	 */
	public XMLResource getWorkspaceModel() {
		return workspaceModel;
	}
	
	/**
	 * @return Name of the workspace model.
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Save with default options.
	 */
	public void save() {
		try {
			workspaceModel.save(null);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
