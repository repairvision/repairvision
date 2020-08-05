package org.sidiff.revision.difference.api.registry;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.resource.Resource;
import org.sidiff.revision.common.emf.document.DocumentType;
import org.sidiff.revision.difference.matcher.IMatcherProvider;
import org.sidiff.revision.difference.matcher.IMatcherProviderBundle;
import org.sidiff.revision.difference.matcher.util.MatcherUtil;

/**
 * Access to the registered matchers.
 */
public class MatcherRegistry {
	
	/**
	 * Returns all registered matchers matching the document types of the given
	 * models.
	 * 
	 * @param models
	 *            the model {@link Resource} of the comparison.
	 * @return all registered {@link IMatcherProvider}s matching the document types of the given
	 *         models
	 */
	public static List<IMatcherProvider> getAvailableMatchers(Collection<Resource> models) {
		List<IMatcherProvider> matchingServices = new ArrayList<IMatcherProvider>();
		
		for(IMatcherProvider matcherProvider : getAllAvailableMatchers()){
			if(MatcherUtil.canHandleModels(matcherProvider, models)){
				matchingServices.add(matcherProvider);	
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
	 * @return all registered {@link IMatcherProvider}s matching the given document types.
	 */
	public static List<IMatcherProvider> getAvailableMatchers(Set<String> documentTypes) {
		List<IMatcherProvider> matchingServices = new ArrayList<IMatcherProvider>();
		
		for(IMatcherProvider matcherProvider : getAllAvailableMatchers()){
			if(MatcherUtil.canHandleDocTypes(matcherProvider, documentTypes)){
				matchingServices.add(matcherProvider);	
			}
		}
		
		return matchingServices;
	}
	
	/**
	 * Find all registered matchers.
	 * 			
	 * @return all registered {@link IMatcherProvider}s
	 */
	public static List<IMatcherProvider> getAllAvailableMatchers() {
		List<IMatcherProvider> availableMatchers = new ArrayList<IMatcherProvider>();
		
		for (IConfigurationElement configurationElement : Platform.getExtensionRegistry().getConfigurationElementsFor(IMatcherProvider.EXTENSION_POINT_ID)) {
			if (configurationElement.getName().equals(IMatcherProvider.EXTENSION_POINT_ELEMENT)){
				try {
					IMatcherProvider matcherProvider = (IMatcherProvider) configurationElement.createExecutableExtension("class");
					
					if (!availableMatchers.contains(matcherProvider)) {
						availableMatchers.add(matcherProvider);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		for (IConfigurationElement configurationElement : Platform.getExtensionRegistry().getConfigurationElementsFor(IMatcherProviderBundle.EXTENSION_POINT_ID)) {
			if (configurationElement.getName().equals(IMatcherProviderBundle.EXTENSION_POINT_ELEMENT)){
				try {
					IMatcherProviderBundle matcherProviderBundle = (IMatcherProviderBundle) configurationElement.createExecutableExtension("class");
					
					for (IMatcherProvider matcherProvider : matcherProviderBundle.getProviderBundle()) {
						if (!availableMatchers.contains(matcherProvider)) {
							availableMatchers.add(matcherProvider);
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		availableMatchers.sort(new Comparator<IMatcherProvider>() {

			@Override
			public int compare(IMatcherProvider t1, IMatcherProvider t2) {
				return t1.getName().compareTo(t2.getName());
			}
		});
		
		return availableMatchers;
	}
	
	/**
	 * Returns all generic matchers.
	 * 
	 * @return all generic {@link IMatcherProvider}s
	 */
	public static List<IMatcherProvider> getGenericMatchers() {
		List<IMatcherProvider> matchingServices = new ArrayList<IMatcherProvider>();
		
		for(IMatcherProvider matcherProvider : getAllAvailableMatchers()){
			if(matcherProvider.getDocumentTypes().contains(DocumentType.GENERIC_DOCUMENT_TYPE)){
				matchingServices.add(matcherProvider);	
			}
		}
		
		return matchingServices;
	}
	
	/**
	 * Returns the matcher identified by its key.
	 * 
	 * @param key
	 *            The key of the {@link IMatcherProvider}.
	 * @return the {@link IMatcherProvider} with the key; null otherwise.
	 * @see IMatcherProvider#getKey()
	 */
	public static IMatcherProvider getMatcherByKey(String key) {
		IMatcherProvider matchingService = null;
		
		for(IMatcherProvider matcherProvider : getAllAvailableMatchers()){
			if(matcherProvider.getKey().equals(key)){
				matchingService = matcherProvider;
				break;
			}
		}
		
		return matchingService;
	}
}
