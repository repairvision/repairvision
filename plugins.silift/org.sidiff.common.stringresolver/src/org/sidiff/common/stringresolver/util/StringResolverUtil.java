package org.sidiff.common.stringresolver.util;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.sidiff.common.stringresolver.GenericStringResolver;
import org.sidiff.common.stringresolver.IStringResolver;

/**
 * 
 * @author cpietsch
 *
 */
public class StringResolverUtil {

	/**
	 * Resolver index:
	 */
	private static Map<String, IStringResolver> resolver;
	
	/**
	 * Returns an available string resolver for the given document type. If no
	 * convenient resolver is found, <code>null</code> will be returned.
	 * 
	 * @param documentType
	 * @return an {@link IStringResolver} which is able to handle the given
	 *         document type, <code>null</code> otherwise.
	 */
	public static IStringResolver getAvailableStringResolver(String documentType){
		
		if (resolver == null) {
			resolver = new HashMap<String, IStringResolver>();
					
			for (IConfigurationElement configurationElement : Platform.getExtensionRegistry().getConfigurationElementsFor(IStringResolver.extensionPointID)) {
				try {
					IStringResolver stringResolverExtension = (IStringResolver) configurationElement.createExecutableExtension("string_resolver");
					resolver.put(stringResolverExtension.getDocType(), stringResolverExtension);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

		IStringResolver stringResolver = resolver.get(documentType);
		
		if(stringResolver == null){
			stringResolver = new GenericStringResolver();
		}
		
		return stringResolver;
	}
}
