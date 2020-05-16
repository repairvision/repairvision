package org.sidiff.revision.difference.matcher.util;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.sidiff.common.utilities.emf.DocumentType;
import org.sidiff.revision.difference.Difference;
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

	public static void createUnmatchedB(Difference difference, Collection<Resource> resources) {
		for (Resource resource : resources) {
			for (EObject element : (Iterable<EObject>) () -> resource.getAllContents()) {
				if (difference.isUnmatchedB(element)) {
					difference.getUnmatchedB().add(element);
				}
			}
		}
	}
	
	public static void createUnmatchedA(Difference difference, Collection<Resource> resources) {
		for (Resource resource : resources) {
			for (EObject element : (Iterable<EObject>) () -> resource.getAllContents()) {
				if (difference.isUnmatchedA(element)) {
					difference.getUnmatchedA().add(element);
				}
			}
		}
	}
}
