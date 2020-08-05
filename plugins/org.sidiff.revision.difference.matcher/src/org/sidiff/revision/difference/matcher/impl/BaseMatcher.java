package org.sidiff.revision.difference.matcher.impl;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.sidiff.revision.common.emf.document.Scope;
import org.sidiff.revision.difference.Difference;
import org.sidiff.revision.difference.matcher.IMatcher;

/**
 * This is the simple matcher base implementation.
 */
public abstract class BaseMatcher implements IMatcher {

	@Override
	public void startMatching(Difference difference, Resource modelA, Resource modelB, Scope scope) {
		List<Resource> resourcesA = scope == Scope.RESOURCE ? Collections.singletonList(modelA) : modelA.getResourceSet().getResources();
		List<Resource> resourcesB = scope == Scope.RESOURCE ? Collections.singletonList(modelB) : modelB.getResourceSet().getResources();
		
		for (Resource resourceA : resourcesA) {
			for (Resource resourceB : resourcesB) {
				if (matches(difference, resourceA, resourceB)) {
					Set<EObject> unmatchedB = new LinkedHashSet<>();
					resourceB.getAllContents().forEachRemaining(unmatchedB::add);
					
					for (EObject elementA : (Iterable<EObject>) () -> resourceA.getAllContents()) {
						EObject elementB = matchB(difference, unmatchedB, elementA);
						
						if (elementB != null) {
							unmatchedB.remove(elementB);
							difference.addCorrespondence(elementA, elementB);
						}
					}
				}
			}
		}
	}

	private EObject matchB(Difference difference, Set<EObject> unmatchedB, EObject elementA) {
		for (EObject elementB : unmatchedB) {
			if (matches(difference, elementA, elementB)) {
				return elementB;
			}
		}
		return null;
	}
	
	/**
	 * @return <code>true</code> if the resources match; <code>false</code> otherwise.
	 */
	protected boolean matches(Difference difference, Resource resourceA, Resource resourceB) {
		if (!resourceA.getContents().isEmpty() && !resourceB.getContents().isEmpty()) {
			if (matches(difference, resourceA.getContents().get(0), resourceB.getContents().get(0))) {
				return true;
			}
		}
		return false;
	}

	/**
	 * @return <code>true</code> if the resources match; <code>false</code> otherwise.
	 */
	protected abstract boolean matches(Difference difference, EObject elementA, EObject elementB);
}
