package org.sidiff.ecore.repair.history.matcher;

import java.util.Collections;
import java.util.Set;

import org.eclipse.emf.ecore.EcorePackage;
import org.sidiff.revision.difference.matcher.IMatcher;
import org.sidiff.revision.difference.matcher.IMatcherProvider;

public class EcoreSignatureMatcherProvider implements IMatcherProvider {

	@Override
	public String getKey() {
		return EcoreSignatureMatcher.class.getName();
	}
	
	@Override
	public String getName() {
		return "Ecore Signature Matcher";
	}
	
	@Override
	public Set<String> getDocumentTypes() {
		return Collections.singleton(EcorePackage.eNS_URI);
	}

	@Override
	public IMatcher createMatcher() {
		return new EcoreSignatureMatcher();
	}
}
