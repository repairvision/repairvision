package org.sidiff.matcher.adapter.emfcompare;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.compare.Comparison;
import org.eclipse.emf.compare.EMFCompare;
import org.eclipse.emf.compare.Match;
import org.eclipse.emf.compare.scope.DefaultComparisonScope;
import org.eclipse.emf.compare.scope.IComparisonScope;
import org.eclipse.emf.ecore.resource.Resource;
import org.sidiff.common.emf.access.EMFModelAccess;
import org.sidiff.common.emf.access.Scope;
import org.sidiff.matcher.BaseMatcher;

/**
 * Concrete matcher that delegates to EMFCompare matching engine.
 * 
 * @author kehrer / reuling
 */
public class EMFCompareMatcherAdapter extends BaseMatcher{

	/**
	 * Initialize
	 */
	public EMFCompareMatcherAdapter() {
		super();
	}

	@Override
	protected void match() {		
		
		Resource modelA = null;
		Resource modelB = null;
		Resource modelOrigin = null;

		Iterator<Resource> it = getModels().iterator();
		modelA = it.next();
		modelB = it.next();
		//Origin Model if available
		if(it.hasNext())
			modelOrigin = it.next();
		

		// TODO(DR): consider scope for EMF compare options (compare resource or
		// compare resource set)

		// Specify options
		/*
		 * Map<String, Object> matchOptions = new HashMap<String, Object>();
		 * matchOptions.put(MatchOptions.OPTION_IGNORE_ID, false);
		 * matchOptions.put(MatchOptions.OPTION_IGNORE_XMI_ID, false);
		 * matchOptions.put(MatchOptions.OPTION_SEARCH_WINDOW, 100);
		 */

		assert (!modelA.getContents().isEmpty()) : "modelA is empty!";
		assert (!modelB.getContents().isEmpty()) : "modelB is empty!";

		EList<Match> matches = null;
		IComparisonScope emfScope = null;

		// Two cases of scopes
		if (scope == Scope.RESOURCE_SET) {
			if(modelOrigin==null)
				emfScope = new DefaultComparisonScope(modelA.getResourceSet(), modelB.getResourceSet(),null);
			else
				emfScope = new DefaultComparisonScope(modelA.getResourceSet(), modelB.getResourceSet(),modelOrigin.getResourceSet());

		} else {
				emfScope = new DefaultComparisonScope(modelA, modelB, modelOrigin);			
		}

		// Compare and get all matches
		Comparison comparison = EMFCompare.builder().build().compare(emfScope);
		matches = comparison.getMatches();

		// Convert to our own representation of correspondences
		populateCorrespondences(matches);
	}

	private void populateCorrespondences(EList<Match> matches) {
		for (Iterator<Match> it = matches.iterator(); it.hasNext();) {
			Match match = it.next();
			populateCorrespondence(match);
		}
	}

	private void populateCorrespondence(Match match) {

		if (match.getLeft() != null && match.getRight() != null) {
			if(match.getOrigin() != null)
				this.getCorrespondencesService().addCorrespondence(match.getLeft(), match.getRight(), match.getOrigin());
			else
				this.getCorrespondencesService().addCorrespondence(match.getLeft(), match.getRight());

		}
		for (Match subMatch : match.getSubmatches()) {
			populateCorrespondence(subMatch);
		}
	}

	@Override
	public String getName() {
		return "EMFCompare Generic Matcher";
	}

	@Override
	public boolean isResourceSetCapable() {
		// EMFC is resourceSetCapable if called properly
		return true;
	}	
	

	@Override
	public String getDescription() {
		return "This matcher adapter allows for using EMFCompare in SiDiff.";
	}

	@Override
	public Set<String> getDocumentTypes() {
		Set<String> docTypes = new HashSet<String>();
		docTypes.add(EMFModelAccess.GENERIC_DOCUMENT_TYPE);
		return docTypes;
	}
}
