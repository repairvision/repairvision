package org.sidiff.generic.matcher.emfcompare;

import java.util.Collections;
import java.util.Set;

import org.sidiff.revision.common.emf.document.DocumentType;
import org.sidiff.revision.difference.matcher.IMatcher;
import org.sidiff.revision.difference.matcher.IMatcherProvider;

public class EMFCompareMatcherAdapterProvider implements IMatcherProvider {

	@Override
	public String getKey() {
		return getClass().getSimpleName();
	}
	
	@Override
	public String getName() {
		return "EMFCompare Generic Matcher";
	}

	@Override
	public Set<String> getDocumentTypes() {
		return Collections.singleton(DocumentType.GENERIC_DOCUMENT_TYPE);
	}

	@Override
	public IMatcher createMatcher() {
		return new EMFCompareMatcherAdapter();
	}

}
