package org.sidiff.matcher;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.resource.Resource;
import org.sidiff.common.emf.access.EMFModelAccess;

/**
 * 
 * @author cpietsch
 *
 */
public class MatcherUtil {
	

	/**
	 * Returns the available matchers for the given document types.
	 * 
	 * @param documentTypes
	 * @return
	 */
	public static List<IMatcher> getAvailableMatchers(Set<String> documentTypes) {
		List<IMatcher> matchingServices = new ArrayList<IMatcher>();
		
		for(IMatcher matcher : getAllAvailableMatchers()){
			if(matcher.canHandleDocTypes(documentTypes)){
				matchingServices.add(matcher);	
			}
		}
		
		return matchingServices;
	}

	/**
	 * Returns the available matchers for the document types of the given models.
	 * 
	 * @param models
	 * @return
	 */
	public static List<IMatcher> getAvailableMatchers(Collection<Resource> models) {
		List<IMatcher> matchingServices = new ArrayList<IMatcher>();
		
		for(IMatcher matcher : getAllAvailableMatchers()){
			if(matcher.canHandleModels(models)){
				matchingServices.add(matcher);	
			}
		}
		
		return matchingServices;
	}
	
	/**
	 * Returns all available generic matchers.
	 *
	 * @return
	 */
	public static List<IMatcher> getGenericMatchers() {
		List<IMatcher> matchingServices = new ArrayList<IMatcher>();
		
		for(IMatcher matcher : getAllAvailableMatchers()){
			if(matcher.getDocumentTypes().contains(EMFModelAccess.GENERIC_DOCUMENT_TYPE)){
				matchingServices.add(matcher);	
			}
		}
		
		return matchingServices;
	}

	/**
	 * Returns the default matcher for the document types.
	 * (not finished yet)
	 * 
	 * @param documentTypes
	 * @return
	 */
	public static IMatcher getDefaultMatcher(Set<String> documentTypes){
		return getAvailableMatchers(documentTypes).get(0);
	}
	
	/**
	 * Returns the default matcher for the document types of the given models.
	 * (not finished yet)
	 * 
	 * @param models
	 * @return
	 */
	public static IMatcher getDefaultMatcher(Collection<Resource> models){
		return getAvailableMatchers(models).get(0);
	}
	
	/**
	 * Returns the matcher identified by the given key.
	 * 
	 * @param key
	 * @return
	 */
	public static IMatcher getMatcher(String key) {
		IMatcher matchingService = null;
		
		for(IMatcher matcher : getAllAvailableMatchers()){
			if(matcher.getKey().equals(key)){
				matchingService = matcher;
				break;
			}
		}
		
		return matchingService;
	}
	
	/**
	 * Get all matchers from the extension registry.
	 * 
	 * @return
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
	
}
