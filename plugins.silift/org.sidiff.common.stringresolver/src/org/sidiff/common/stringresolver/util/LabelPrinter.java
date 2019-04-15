package org.sidiff.common.stringresolver.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.sidiff.common.emf.access.EMFModelAccess;
import org.sidiff.common.stringresolver.IStringResolver;

public class LabelPrinter {

	private IStringResolver resolver;
	
	public LabelPrinter(Resource model) {
		String docType = EMFModelAccess.getCharacteristicDocumentType(model);
		resolver = StringResolverUtil.getAvailableStringResolver(docType);
	}
	
	public String getLabel(Object object){
		if (object != null) {
			return resolver.resolve((EObject) object);
		} else {
			return "null";
		}
	}
	
	public String getToolTipLabel(Object object){
		if (object != null) {
			return resolver.resolveQualified((EObject) object);
		} else {
			return "null";
		}
	}
}
