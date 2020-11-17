package org.sidiff.reverseengineering.java.transformation.uml;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.UMLFactory;
import org.sidiff.reverseengineering.java.transformation.JavaASTWorkspaceModel;

import com.google.inject.Inject;
import com.google.inject.assistedinject.Assisted;

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
	 * @see {@link JavaASTWorkspaceModel#JavaASTWorkspaceModel(XMLResource, String)}
	 */
	@Inject
	public JavaASTWorkspaceModelUML(
			@Assisted XMLResource workspaceModel, 
			String name) {
		super(workspaceModel, name);
		
		if (workspaceModel.getContents().isEmpty() || !(workspaceModel.getContents().get(0) instanceof Model)) {
			this.workspaceModelRoot = umlFactory.createModel();
			this.workspaceModelRoot.setName(name);
			getWorkspaceModel().getContents().add(workspaceModelRoot);
			getWorkspaceModel().setID(workspaceModelRoot, "workspace::" + name);
		} else {
			this.workspaceModelRoot = (Model) workspaceModel.getContents().get(0);
		}
	}

	@Override
	public void addToWorkspace(EObject projectModel) {
		if (projectModel instanceof PackageableElement) {
			workspaceModelRoot.getPackagedElements().add((PackageableElement) projectModel);
		}
	}

}
