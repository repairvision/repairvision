package org.sidiff.generic.matcher.adapter.sidiff;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IConfigurationElement;
import org.sidiff.matcher.IMatcher;
import org.sidiff.revision.difference.matcher.IMatcherProvider;
import org.sidiff.revision.difference.matcher.IMatcherProviderBundle;

public class SiDiffMatcherProviderAdapterBundle implements IMatcherProviderBundle {

	@Override
	public List<IMatcherProvider> getProviderBundle() {
		List<IMatcherProvider> revisionMatcherProvider = new ArrayList<>();
		Iterator<IConfigurationElement> matcherExtensions = IMatcher.DESCRIPTION.getRegisteredExtensions().iterator();
		
		while (matcherExtensions.hasNext()) {
			revisionMatcherProvider.add(new SiDiffMatcherProviderAdapter(matcherExtensions.next()));
		}
		
		return revisionMatcherProvider;
	}

}
