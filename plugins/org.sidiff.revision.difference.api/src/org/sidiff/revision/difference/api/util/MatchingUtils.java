package org.sidiff.revision.difference.api.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.resource.Resource;
import org.sidiff.common.utilities.emf.DocumentType;
import org.sidiff.revision.difference.matcher.IMatcher;
import org.sidiff.revision.difference.matcher.util.MatcherUtil;

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
	 * Returns all registered matchers matching the document types of the given
	 * models.
	 * 
	 * @param models
	 *            the model {@link Resource} of the comparison.
	 * @return all registered {@link IMatcher}s matching the document types of the given
	 *         models
	 */
	public static List<IMatcher> getAvailableMatchers(Collection<Resource> models) {
		List<IMatcher> matchingServices = new ArrayList<IMatcher>();
		
		for(IMatcher matcher : getAllAvailableMatchers()){
			if(MatcherUtil.canHandleModels(matcher, models)){
				matchingServices.add(matcher);	
			}
		}
		
		return matchingServices;
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
		List<IMatcher> matchingServices = new ArrayList<IMatcher>();
		
		for(IMatcher matcher : getAllAvailableMatchers()){
			if(MatcherUtil.canHandleDocTypes(matcher, documentTypes)){
				matchingServices.add(matcher);	
			}
		}
		
		return matchingServices;
	}
	
	/**
	 * Find all registered matchers.
	 * 			
	 * @return all registered {@link IMatcher}s
	 */
	public static List<IMatcher> getAllAvailableMatchers() {
		List<IMatcher> availableMatchers = new ArrayList<IMatcher>();
		
		for (IConfigurationElement configurationElement : Platform.getExtensionRegistry().getConfigurationElementsFor(
				IMatcher.EXTENSION_POINT_ID)) {
			try {
				IMatcher matcher = (IMatcher) configurationElement.createExecutableExtension("class");
				
				if (!availableMatchers.contains(matcher)) {
					availableMatchers.add(matcher);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		availableMatchers.sort(new Comparator<IMatcher>() {

			@Override
			public int compare(IMatcher t1, IMatcher t2) {
				return t1.getName().compareTo(t2.getName());
			}
		});
		
		return availableMatchers;
	}
	
	/**
	 * Returns all generic matchers.
	 * 
	 * @return all generic {@link IMatcher}s
	 */
	public static List<IMatcher> getGenericMatchers() {
		List<IMatcher> matchingServices = new ArrayList<IMatcher>();
		
		for(IMatcher matcher : getAllAvailableMatchers()){
			if(matcher.getDocumentTypes().contains(DocumentType.GENERIC_DOCUMENT_TYPE)){
				matchingServices.add(matcher);	
			}
		}
		
		return matchingServices;
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
		IMatcher matchingService = null;
		
		for(IMatcher matcher : getAllAvailableMatchers()){
			if(matcher.getKey().equals(key)){
				matchingService = matcher;
				break;
			}
		}
		
		return matchingService;
	}
}
