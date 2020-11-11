package org.sidiff.reverseengineering.java.transformation;

import java.io.IOException;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.jdt.core.dom.IBinding;

/**
 * Manages the creation of library model elements.
 * 
 * @author Manuel Ohrndorf
 */
public class JavaASTLibraryModel {

	/**
	 * The library model.
	 */
	private XMLResource libraryModel;
	
	/**
	 * Creates bindings for the model.
	 */
	private JavaASTBindingTranslator bindingTranslator;
	
	/**
	 * @param libraryModel The library model.
	 */
	public JavaASTLibraryModel(XMLResource libraryModel, JavaASTBindingTranslator bindingTranslator) {
		this.libraryModel = libraryModel;
		this.bindingTranslator = bindingTranslator;
	}

	/**
	 * Returns or creates a library model element. This function is intended to be
	 * sub-classed by clients for specific modeling languages.
	 * 
	 * @param uniqueBindingKey The binding key as model element ID.
	 * @param externalBinding  The Java AST binding.
	 * @param isTypeOf         The minimal type of the library model element.
	 * @return The library model element.
	 */
	@SuppressWarnings("unchecked")
	public <E extends EObject> E getLibraryModelElement(IBinding externalBinding, EClass isTypeOf) {
		return (E) libraryModel.getEObject(getBindingKey(externalBinding));
	}
	
	/**
	 * @param bindingKey A unique binding key.
	 * @return The corresponding model element.
	 */
	@SuppressWarnings("unchecked")
	public <E extends EObject> E getLibraryModelElement(String bindingKey) {
		return (E) libraryModel.getEObject(bindingKey);
	}
	
	/**
	 * @param binding      The Java AST binding.
	 * @param modelElement The corresponding library model element.
	 */
	public void bindModelElement(IBinding binding, EObject modelElement) {
		libraryModel.setID(modelElement, getBindingKey(binding));
	}
	
	/**
	 * @param bindinKey      A unique binding key.
	 * @param modelElement The corresponding library model element.
	 */
	public void bindModelElement(String bindinKey, EObject modelElement) {
		libraryModel.setID(modelElement, bindinKey);
	}
	
	/**
	 * @param binding The Java AST binding.
	 * @return The library binding key.
	 */
	protected String getBindingKey(IBinding binding) {
		return bindingTranslator.getBindingKey("library", binding);
	}
	
	/**
	 * @param bindinKey A local binding key.
	 * @return The library binding key.
	 */
	protected String getBindingKey(String bindingKey) {
		return "library" + "/" + bindingKey;
	}

	/**
	 * @return The library model.
	 */
	public XMLResource getLibraryModel() {
		return libraryModel;
	}
	
	/**
	 * Save with default options.
	 */
	public void save() {
		try {
			libraryModel.save(null);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
