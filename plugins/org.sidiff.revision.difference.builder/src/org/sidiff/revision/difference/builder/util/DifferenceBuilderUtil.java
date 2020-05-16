package org.sidiff.revision.difference.builder.util;

import java.util.Set;

import org.eclipse.emf.ecore.resource.Resource;
import org.sidiff.common.utilities.emf.DocumentType;
import org.sidiff.common.utilities.emf.Scope;
import org.sidiff.revision.difference.builder.IDifferenceBuilderProvider;

public class DifferenceBuilderUtil {

	public static  boolean canHandleDocTypes(IDifferenceBuilderProvider differenceBuilderProvider, Set<String> documentTypes) {
		return differenceBuilderProvider.getDocumentTypes().contains(DocumentType.GENERIC_DOCUMENT_TYPE) ||
				differenceBuilderProvider.getDocumentTypes().containsAll(documentTypes);
	}

	public static boolean canHandleModels(IDifferenceBuilderProvider differenceBuilderProvider, Resource modelA, Resource modelB) {
		Set<String> docTypes = DocumentType.getDocumentTypes(modelA, Scope.RESOURCE_SET);
		docTypes.addAll(DocumentType.getDocumentTypes(modelB, Scope.RESOURCE_SET));
	
		return canHandleDocTypes(differenceBuilderProvider, docTypes);
	}

}
