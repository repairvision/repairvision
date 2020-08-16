package org.sidiff.generic.matcher.adapter.sidiff;

import java.util.Arrays;
import java.util.Collection;

import org.eclipse.emf.ecore.resource.Resource;
import org.sidiff.revision.common.emf.document.Scope;
import org.sidiff.revision.difference.Difference;
import org.sidiff.revision.difference.matcher.IMatcher;

public class SiDiffMatcherAdapter implements IMatcher {

	private org.sidiff.matcher.IMatcher sidiffMatcher;
	
	public SiDiffMatcherAdapter(org.sidiff.matcher.IMatcher sidiffMatcher) {
		this.sidiffMatcher = sidiffMatcher;
	}

	@Override
	public void startMatching(Difference difference, Resource modelA, Resource modelB, Scope scope) {
		sidiffMatcher.reset();
		sidiffMatcher.setCorrespondencesService(new ReVisionDifferenceModelCorrespondences(difference, scope));
		
		Collection<Resource> models = Arrays.asList(new Resource[] {modelA, modelB});
		
		if (scope == Scope.RESOURCE)  {
			sidiffMatcher.startMatching(models, org.sidiff.common.emf.access.Scope.RESOURCE);
		} else {
			assert scope == Scope.RESOURCE_SET;
			sidiffMatcher.startMatching(models, org.sidiff.common.emf.access.Scope.RESOURCE_SET);
		}
	}

}
