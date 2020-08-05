package org.sidiff.revision.difference.matcher.util;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.resource.Resource;
import org.sidiff.revision.common.emf.document.DocumentType;
import org.sidiff.revision.common.emf.document.Scope;
import org.sidiff.revision.difference.matcher.IMatcherProvider;

public class MatcherUtil {

	public static boolean canHandleDocTypes(IMatcherProvider matcherProvider, Set<String> documentTypes) {
		return matcherProvider.getDocumentTypes().contains(DocumentType.GENERIC_DOCUMENT_TYPE) 
				|| matcherProvider.getDocumentTypes().containsAll(documentTypes);
	}
	
	public static boolean canHandleModels(IMatcherProvider matcherProvider, Collection<Resource> models) {
		Set<String> documentTypes = models.stream().map(model -> DocumentType.getDocumentType(model)).collect(Collectors.toSet());
		return canHandleDocTypes(matcherProvider, documentTypes);
	}
	
	public static List<Resource> getResourceScope(Resource resource, Scope scope) {
		List<Resource> resourceSet;
		
		if (scope.equals(Scope.RESOURCE_SET)) {
			resourceSet = resource.getResourceSet().getResources();
		} else {
			resourceSet = Collections.singletonList(resource);
		}
		
		return resourceSet;
	}
}
