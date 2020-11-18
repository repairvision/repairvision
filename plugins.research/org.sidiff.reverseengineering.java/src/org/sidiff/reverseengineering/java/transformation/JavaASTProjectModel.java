package org.sidiff.reverseengineering.java.transformation;

import java.io.IOException;
import java.util.NoSuchElementException;

import org.eclipse.core.resources.IProject;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.jdt.core.dom.IPackageBinding;

import com.google.inject.Inject;
import com.google.inject.assistedinject.Assisted;

/**
 * The model representing a Java project
 * 
 * @author Manuel Ohrndorf
 */
public abstract class JavaASTProjectModel {

	/**
	 * The model representing a Java project.
	 */
	protected XMLResource projectModel;
	
	/**
	 * The corresponding workspace project.
	 */
	protected IProject project;
	
	/**
	 * Creates bindings for the model.
	 */
	protected JavaASTBindingTranslator bindingTranslator;
	
	/**
	 * @param projectModel      The model representing a Java project
	 * @param project           The corresponding workspace project.
	 * @param bindingTranslator Helper to translate bindings.
	 */
	@Inject
	public JavaASTProjectModel(
			@Assisted XMLResource projectModel, 
			@Assisted IProject project,
			JavaASTBindingTranslator bindingTranslator) {
		this.projectModel = projectModel;
		this.project = project;
		this.bindingTranslator = bindingTranslator;
	}

	/**
	 * @param project The presented project.
	 * @param binding A binding of a Java package.
	 * @param packageFragment A Java package.
	 * @param modelElement The contained model element.
	 */
	public abstract void addPackagedElement(IPackageBinding binding, EObject modelElement);
	
	/**
	 * Matches the given project path to the qualified type names and removes the
	 * given type from the project model.
	 * 
	 * @param project     A workspace project.
	 * @param projectPath A project relative path by folder segments.
	 * @param typeName    The name of the Java type.
	 * @return {Container, Removed Element}
	 */
	public abstract EObject[] removePackagedElement(String[] projectPath, String typeName) throws NoSuchElementException;

	/**
	 * @param bindingKey A binding in of this project.
	 * @return The corresponding model element.
	 */
	@SuppressWarnings("unchecked")
	public <E extends EObject> E getModelElement(String bindingKey) {
		return (E) projectModel.getEObject(bindingKey);
	}

	/**
	 * @param bindingKey The unique binding key.
	 * @param element    A new model element.
	 */
	public void bindModelElement(String bindingKey, EObject element) {
		projectModel.setID(element, bindingKey);
	}
	
	/**
	 * @param project The presented project.
	 * @return The binding key.
	 */
	protected String getBindingKey(IProject project) {
		return bindingTranslator.getBindingKey("project", project.toString());
	}

	/**
	 * @param bindinKey A local binding key.
	 * @return The library binding key.
	 */
	protected String getBindingKey(IProject project, String bindingKey) {
		return bindingTranslator.getBindingKey(project.getName(), bindingKey);
	}
	
	/**
	 * @return The model representing a Java project
	 */
	public XMLResource getProjectModel() {
		return projectModel;
	}
	
	/**
	 * @return The corresponding workspace project.
	 */
	public IProject getProject() {
		return project;
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
