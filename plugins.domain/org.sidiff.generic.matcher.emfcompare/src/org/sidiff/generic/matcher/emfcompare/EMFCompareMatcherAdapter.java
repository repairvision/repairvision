package org.sidiff.generic.matcher.emfcompare;

import org.eclipse.emf.compare.Comparison;
import org.eclipse.emf.compare.EMFCompare;
import org.eclipse.emf.compare.Match;
import org.eclipse.emf.compare.scope.DefaultComparisonScope;
import org.eclipse.emf.compare.scope.IComparisonScope;
import org.eclipse.emf.ecore.resource.Resource;
import org.sidiff.revision.common.emf.document.Scope;
import org.sidiff.revision.difference.Difference;
import org.sidiff.revision.difference.matcher.IMatcher;

/**
 * Concrete matcher that delegates to EMFCompare matching engine.
 */
public class EMFCompareMatcherAdapter implements IMatcher {

	@Override
	public void startMatching(Difference difference, Resource modelA, Resource modelB, Scope scope) {
		IComparisonScope emfScope = null;

		if (scope == Scope.RESOURCE_SET) {
			emfScope = new DefaultComparisonScope(modelA.getResourceSet(), modelB.getResourceSet(), null);
		} else {
			emfScope = new DefaultComparisonScope(modelA, modelB, null);
		}

		// Compare and get all matches
		Comparison comparison = EMFCompare.builder().build().compare(emfScope);

		// Convert to our own representation of correspondences
		comparison.getMatches().forEach(match -> convertCorrespondence(difference, match));
	}

	private void convertCorrespondence(Difference difference, Match match) {

		if (match.getLeft() != null && match.getRight() != null) {
			difference.addCorrespondence(match.getLeft(), match.getRight());
		}
		
		match.getSubmatches().forEach(subMatch -> convertCorrespondence(difference, subMatch));
	}

}
