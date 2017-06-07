package org.sidiff.consistency.common.storage;

import java.util.Collections;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.sidiff.common.emf.access.EMFModelAccess;
import org.sidiff.matcher.LocalSignatureMatcher;

public class UUIDMatcher extends LocalSignatureMatcher {

	@Override
	public String getName() {
		return "UUID Resource Matcher";
	}

	@Override
	public Set<String> getDocumentTypes() {
		return Collections.singleton(EMFModelAccess.GENERIC_DOCUMENT_TYPE);
	}

	@Override
	public String getDescription() {
		return "UUID Resource Matcher";
	}

	@Override
	protected String getElementSignature(EObject element) {
		Resource resource = element.eResource();
		
		if (!UUIDResource.isDynamic(element)) {
			if (resource instanceof XMLResource) {
				return ((XMLResource) resource).getID(element);
			}
		} else {
			return EcoreUtil.getURI(element).fragment();
		}
		
		return null;
	}

	@Override
	protected boolean considerCandidatesOnly() {
		//We try to match all elements
		return false;
	}
}
