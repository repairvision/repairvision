package org.sidiff.reverseengineering.java.transformation;

import java.io.IOException;

import org.eclipse.core.resources.IProject;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.dom.IPackageBinding;

/**
 * The model representing a Java project
 * 
 * @author Manuel Ohrndorf
 */
public abstract class JavaASTProjectModel {

	/**
	 * The model representing a Java project.
	 */
	private XMLResource projectModel;

	/**
	 * @param projectModel The model representing a Java project
	 */
	public JavaASTProjectModel(XMLResource projectModel) {
		this.projectModel = projectModel;
	}

	/**
	 * @param project The presented project.
	 * @param binding A binding of a Java package.
	 * @param packageFragment A Java package.
	 * @param modelElement The contained model element.
	 */
	public void addPackagedElement(IProject project, IPackageBinding binding, IPackageFragment packageFragment, EObject modelElement) {
		EObject currentModelElement = modelElement;
		String curentModelElementID;
		
		// Containing package as Java name binding:
		if (packageFragment != null) { // default package?
			curentModelElementID = getBindingKey(project, binding);
			EObject existingModelElement = projectModel.getEObject(curentModelElementID);
			
			if (existingModelElement == null) {
				currentModelElement = createPackage(packageFragment, modelElement);
				projectModel.setID(currentModelElement, curentModelElementID);
			} else {
				addToPackage(existingModelElement, currentModelElement);
				currentModelElement = existingModelElement;
			}
			
			if (packageFragment.getParent() instanceof IPackageFragment) {
				packageFragment = (IPackageFragment) packageFragment.getParent();
			} else {
				packageFragment = null;
			}
		}
		
		// Upper packages - source folder?
		while ((packageFragment != null)  && !(packageFragment instanceof IPackageFragmentRoot)) {
			curentModelElementID = getBindingKey(project, packageFragment);
			EObject existingModelElement = projectModel.getEObject(curentModelElementID);
			
			if (existingModelElement == null) {
				currentModelElement = createPackage(packageFragment, currentModelElement);
				projectModel.setID(currentModelElement, curentModelElementID);
			} else {
				addToPackage(existingModelElement, currentModelElement);
				currentModelElement = existingModelElement;
			}

			if (packageFragment.getParent() instanceof IPackageFragment) {
				packageFragment = (IPackageFragment) packageFragment.getParent();
			} else {
				packageFragment = null;
			}
		}
		
		// Add to root:
		curentModelElementID = getBindingKey(project);
		EObject existingModelElement = projectModel.getEObject(curentModelElementID);
		
		if (existingModelElement == null) {
			currentModelElement = createProject(project, currentModelElement);
			projectModel.setID(currentModelElement, curentModelElementID);
		}  else {
			addToProject(existingModelElement, currentModelElement);
			currentModelElement = existingModelElement;
		}
	}
	
	/**
	 * @param project The presented project.
	 * @return The binding key.
	 */
	protected String getBindingKey(IProject project) {
		return project.toString() + "/";
	}

	/**
	 * @param project The presented project.
	 * @param binding A binding of a Java package.
	 * @return The binding key.
	 */
	protected String getBindingKey(IProject project, IPackageBinding binding) {
		return project + "/" + binding.getKey();
	}
	
	/**
	 * @param project The presented project.
	 * @param packageFragment A Java package.
	 * @return The binding key.
	 */
	protected String getBindingKey(IProject project, IPackageFragment packageFragment) {
		return project + "/" + packageFragment.getPath();
	}
	
	/**
	 * @param project           The presented project.
	 * @param childModelElement A child package or model element.
	 * @return The created model package.
	 */
	protected abstract EObject createProject(IProject project, EObject childModelElement);
	
	/**
	 * @param projectModelElement The presented project.
	 * @param childModelElement   A child package or model element.
	 * @return The created model package.
	 */
	protected abstract void addToProject(EObject projectModelElement, EObject childModelElement);

	/**
	 * @param parentPackage     The corresponding Java package.
	 * @param childModelElement A child package or model element.
	 * @return The created model package.
	 */
	protected abstract EObject createPackage(IPackageFragment parentPackage, EObject childModelElement);
	
	/**
	 * @param packageModelElement The parent model package.
	 * @param childModelElement   A child package or model element.
	 * @return The created model package.
	 */
	protected abstract void addToPackage(EObject packageModelElement, EObject childModelElement);
	
	/**
	 * @return The model representing a Java project
	 */
	public XMLResource getProjectModel() {
		return projectModel;
	}
	
	/**
	 * Save with default options.
	 */
	public void save() {
		try {
			projectModel.save(null);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
