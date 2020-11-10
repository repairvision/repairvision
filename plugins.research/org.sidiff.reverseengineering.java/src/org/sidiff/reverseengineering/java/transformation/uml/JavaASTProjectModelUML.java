package org.sidiff.reverseengineering.java.transformation.uml;

import org.eclipse.core.resources.IProject;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.UMLFactory;
import org.sidiff.reverseengineering.java.transformation.JavaASTProjectModel;

/**
 * The UML model representing a Java project
 * 
 * @author Manuel Ohrndorf
 */
public class JavaASTProjectModelUML extends JavaASTProjectModel {
	
	private UMLFactory umlFactory = UMLFactory.eINSTANCE;

	/**
	 * @param projectModel The model representing a Java project
	 */
	public JavaASTProjectModelUML(XMLResource projectModel) {
		super(projectModel);
	}
	
	@Override
	protected EObject createProject(IProject project, EObject childModelElement) {
		Model umlProjectModel = umlFactory.createModel();
		umlProjectModel.setName(project.getName());
		getProjectModel().getContents().add(umlProjectModel);
		
		if (childModelElement instanceof PackageableElement) {
			umlProjectModel.getPackagedElements().add((PackageableElement) childModelElement);
		}
		
		return umlProjectModel;
	}
	
	@Override
	protected void addToProject(EObject projectModelElement, EObject childModelElement) {
		if (childModelElement instanceof PackageableElement) {
			if (projectModelElement instanceof Package) {
				((Package) projectModelElement).getPackagedElements().add((PackageableElement) childModelElement);
			}
		}
	}

	@Override
	protected EObject createPackage(IPackageFragment parentPackage, EObject childModelElement) {
		Package umlPackage = umlFactory.createPackage();
		umlPackage.setName(parentPackage.getElementName());
		
		if (childModelElement instanceof PackageableElement) {
			umlPackage.getPackagedElements().add((PackageableElement) childModelElement);
		}
		
		return umlPackage;
	}
	
	@Override
	protected void addToPackage(EObject packageModelElement, EObject childModelElement) {
		if (childModelElement instanceof PackageableElement) {
			if (packageModelElement instanceof Package) {
				((Package) packageModelElement).getPackagedElements().add((PackageableElement) childModelElement);
			}
		}
	}

}
