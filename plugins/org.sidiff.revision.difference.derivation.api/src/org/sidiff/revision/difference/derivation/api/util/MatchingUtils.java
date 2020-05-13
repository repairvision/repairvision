package org.sidiff.revision.difference.derivation.api.util;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.resource.Resource;
import org.sidiff.common.emf.modelstorage.EMFStorage;
import org.sidiff.matcher.IMatcher;
import org.sidiff.matcher.MatcherUtil;

/**
 * Utility functions which are made publicly available to any clients using the
 * SiDiff framework. UI components of the SiDiff IDE should, if required, also
 * use these utility functions, and not the internal functions of the respective
 * engines.
 * 
 * @author kehrer, mohrndorf, cpietsch
 */
public class MatchingUtils {
	
	/**
	 * Loads an EMF resource.
	 * 
	 * @param path
	 *            The EMF-file path.
	 * @return the loaded EMF {@link Resource}
	 */
	public static Resource loadModel(String path) {
		return EMFStorage.eLoad(EMFStorage.pathToUri(path)).eResource();
	}
	
	/**
	 * Returns all registered matchers matching the document types of the given
	 * models.
	 * 
	 * @param modelA
	 *            the {@link Resource} of model A of the comparison.
	 * @param modelB
	 *            the {@link Resource} of model B of the comparison.
	 * @return all registered {@link IMatcher}s matching the document types of the given
	 *         models
	 */
	public static List<IMatcher> getAvailableMatchers(Resource modelA, Resource modelB) {
		return MatcherUtil.getAvailableMatchers(Arrays.asList(modelA,modelB));
	}
	
	/**
	 * Returns all registered matchers matching the given document types.
	 * 
	 * @param documentTypes
	 *            The document types, i.e. the package namespace URI of a model.
	 *            There can be more than one.
	 * 
	 * @return all registered {@link IMatcher}s matching the given document types.
	 */
	public static List<IMatcher> getAvailableMatchers(Set<String> documentTypes) {
		return MatcherUtil.getAvailableMatchers(documentTypes);
	}
	
	/**
	 * Find all registered matchers.
	 * 			
	 * @return all registered {@link IMatcher}s
	 */
	public static List<IMatcher> getAllAvailableMatchers() {
		return MatcherUtil.getAllAvailableMatchers();
	}
	
	/**
	 * Returns all generic matchers.
	 * 
	 * @return all generic {@link IMatcher}s
	 */
	public static List<IMatcher> getGenericMatchers() {
		return MatcherUtil.getGenericMatchers();
	}
	
	/**
	 * Returns the matcher identified by its key.
	 * 
	 * @param key
	 *            The key of the {@link IMatcher}.
	 * @return the {@link IMatcher} with the key; null otherwise.
	 * @see IMatcher#getKey()
	 */
	public static IMatcher getMatcherByKey(String key) {
		return MatcherUtil.getMatcher(key);
	}
}
