package org.sidiff.revision.impact.analysis;

import java.util.Set;

import org.eclipse.emf.ecore.EObject;

/**
 * Interface to get all elements that are in the impact scope.
 * 
 * @author Manuel Ohrndorf
 */
public interface ImpactScope {
	
	/**
	 * @return All elements that are in the impact scope.
	 */
	Set<EObject> getScope();
	
}
