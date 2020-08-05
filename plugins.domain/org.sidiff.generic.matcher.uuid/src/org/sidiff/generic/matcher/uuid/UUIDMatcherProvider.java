package org.sidiff.generic.matcher.uuid;

import java.util.Collections;
import java.util.Set;

import org.sidiff.revision.common.emf.document.DocumentType;
import org.sidiff.revision.difference.matcher.IMatcher;
import org.sidiff.revision.difference.matcher.IMatcherProvider;

public class UUIDMatcherProvider implements IMatcherProvider {

	@Override
	public String getKey() {
		return getName();
	}

	@Override
	public String getName() {
		return "UUID Resource Matcher";
	}

	@Override
	public Set<String> getDocumentTypes() {
		return Collections.singleton(DocumentType.GENERIC_DOCUMENT_TYPE);
	}

	@Override
	public IMatcher createMatcher() {
		return new UUIDMatcher();
	}

}
