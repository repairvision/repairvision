package org.sidiff.revision.difference.matcher.util;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.sidiff.common.utilities.emf.DocumentType;
import org.sidiff.revision.difference.Difference;
import org.sidiff.revision.difference.matcher.IMatcher;

public class MatcherUtil {

	public static boolean canHandleDocTypes(IMatcher matcher, Set<String> documentTypes) {
		return matcher.getDocumentTypes().contains(DocumentType.GENERIC_DOCUMENT_TYPE) 
				|| matcher.getDocumentTypes().containsAll(documentTypes);
	}
	
	public static boolean canHandleModels(IMatcher matcher, Collection<Resource> models) {
		Set<String> documentTypes = models.stream().map(model -> DocumentType.getDocumentType(model)).collect(Collectors.toSet());
		return canHandleDocTypes(matcher, documentTypes);
	}

	public static void createUnmatched(Difference difference, Collection<Resource> resources) {
		for (Resource resource : resources) {
			for (EObject element : (Iterable<EObject>) () -> resource.getAllContents()) {
				if (difference.isUnmatchedB(element)) {
					difference.getUnmatchedB().add(element);
				}
			}
		}
	}


	

	
}
