package org.sidiff.revision.compare;

/**
 * Checks if a match already exists for a model element from a specific model version.
 * 
 * @author Manuel Ohrndorf
 */
@FunctionalInterface
public interface MatchExists {

	/**
	 * @param element A model element.
	 * @return <code>true</code> if the element is already matched;
	 *         <code>false</code> otherwise.
	 */
	boolean exists(Object element);
}
