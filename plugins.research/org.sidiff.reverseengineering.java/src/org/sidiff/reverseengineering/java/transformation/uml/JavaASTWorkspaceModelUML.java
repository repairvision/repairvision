package org.sidiff.reverseengineering.java.transformation.uml;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.UMLFactory;
import org.sidiff.reverseengineering.java.transformation.JavaASTWorkspaceModel;

/**
 * UML model which contains all projects of the workspace.
 * 
 * @author Manuel Ohrndorf
 */
public class JavaASTWorkspaceModelUML extends JavaASTWorkspaceModel {

	private UMLFactory umlFactory = UMLFactory.eINSTANCE;
	
	/**
	 * The root element of the workspace model.
	 */
	private Model workspaceModelRoot;
	
	/**
	 * @param workspaceModel The model representing a Java workspace.
	 */
	public JavaASTWorkspaceModelUML(XMLResource workspaceModel, String name) {
		super(workspaceModel, name);
		this.workspaceModelRoot = umlFactory.createModel();
		this.workspaceModelRoot.setName(name);
		getWorkspaceModel().getContents().add(workspaceModelRoot);
		getWorkspaceModel().setID(workspaceModelRoot, "workspace::" + name);
	}

	@Override
	public void addToWorkspace(EObject projectModel) {
		if (projectModel instanceof PackageableElement) {
			workspaceModelRoot.getPackagedElements().add((PackageableElement) projectModel);
		}
	}

}
