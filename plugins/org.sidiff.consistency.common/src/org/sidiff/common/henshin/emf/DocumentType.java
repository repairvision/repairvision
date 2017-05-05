package org.sidiff.common.henshin.emf;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

public class DocumentType {

	/**
	 * Returns the document type (i.e. the package namespace URI) of the model
	 * of the given element.
	 * 
	 * @param eObject
	 * @return
	 */
	public static String getDocumentType(EObject object) {
		EPackage pkg = object.eClass().getEPackage();
		
		while (pkg != null && pkg.getESuperPackage() != null) {
			pkg = pkg.getESuperPackage();
		}
		
		return pkg.getNsURI();
	}
}
