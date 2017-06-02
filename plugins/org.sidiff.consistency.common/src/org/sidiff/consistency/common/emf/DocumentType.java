package org.sidiff.consistency.common.emf;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;

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
	
	public static String getDocumentType(Resource resource) {
		if (!resource.getContents().isEmpty()) {
			return getDocumentType(resource.getContents().get(0));
		}
		
		return null;
	}
}
