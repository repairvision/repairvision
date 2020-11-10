package org.sidiff.reverseengineering.java.transformation;

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
	 * @param libraryModel The library model.
	 */
	public JavaASTLibraryModel(XMLResource libraryModel) {
		this.libraryModel = libraryModel;
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
		return (E) libraryModel.getEObject(externalBinding.getKey());
	}

	/**
	 * @return The library model.
	 */
	public XMLResource getLibraryModel() {
		return libraryModel;
	}
}
