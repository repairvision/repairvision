package org.sidiff.revision.api;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;

/**
 * Search for partially executed edit-operation to be complemented.
 * 
 * @author Manuel Ohrndorf
 *
 * @param <J>
 *            The kind of {@link ComplementationJob} as container for all complementations.
 * @param <S>
 *            The kind of {@link ComplementationSettings}.
 */
public interface ComplementationFacade<J extends ComplementationJob<?>, S extends ComplementationSettings> {
	
	/**
	 * Search for partially executed edit-operation to be complemented.
	 * 
	 * @param uriModelA
	 *            The historic model.
	 * @param uriModelB
	 *            The actual model.
	 * @param settings
	 *            The settings for the complement calculation.
	 * @return All found complementations.
	 */
	J getComplementations(URI uriModelA, URI uriModelB, S settings);
	
	/**
	 * Search for partially executed edit-operation to be complemented.
	 * 
	 * @param modelA
	 *            The historic model.
	 * @param modelB
	 *            The actual model.
	 * @param settings
	 *            The settings for the complement calculation.
	 * @return All found complementations.
	 */
	J getComplementations(Resource modelA, Resource modelB, S settings);
}
