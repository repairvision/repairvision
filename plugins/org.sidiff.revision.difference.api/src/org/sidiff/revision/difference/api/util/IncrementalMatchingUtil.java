package org.sidiff.revision.difference.api.util;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.resource.Resource;
import org.sidiff.revision.common.emf.document.Scope;
import org.sidiff.revision.difference.Correspondence;
import org.sidiff.revision.difference.Difference;
import org.sidiff.revision.difference.api.DifferenceFacade;
import org.sidiff.revision.difference.api.settings.MatchingSettings;
import org.sidiff.revision.difference.matcher.IMatcherProvider;

public class IncrementalMatchingUtil {

	public static Difference match(Resource modelA, Resource modelB, Scope scope, List<IMatcherProvider> matcherProviders) {
		IMatcherProvider matcherProvider = matcherProviders.get(0);
		Difference difference = createMatching(modelA, modelB, scope, matcherProvider);
		
		for (IMatcherProvider subsequentMatcher : matcherProviders.subList(1, matcherProviders.size())) {
			Difference subsequentMatching = createMatching(modelA, modelB, scope, subsequentMatcher);
			iterativeMatching(difference, subsequentMatching);
		}
		return difference;
	}

	private static Difference createMatching(Resource modelA, Resource modelB, Scope scope, IMatcherProvider matcherProvider) {
		return DifferenceFacade.match(modelA, modelB, new MatchingSettings(scope, matcherProvider));
	}
	
	private static void iterativeMatching(Difference base, Difference subsequent) {
		List<Correspondence> newCorrespondences = new ArrayList<>();
		
		for (Correspondence subsequentCorrespondence : subsequent.getCorrespondences()) {
			if (!containsCorrespondence(base, subsequentCorrespondence)) {
				newCorrespondences.add(subsequentCorrespondence);
			}
		}
		
		for (Correspondence correspondence : newCorrespondences) {
			base.getCorrespondences().add(correspondence);
		}
	}
	
	private static boolean containsCorrespondence(Difference matching, Correspondence correspondence) {
		for (Correspondence otherCorrespondence : matching.getCorrespondences()) {
			if ((otherCorrespondence.getMatchedA() == correspondence.getMatchedA())
					|| (otherCorrespondence.getMatchedB() == correspondence.getMatchedB())) {
				return true;
			}
		}
		return false;
	}
}
