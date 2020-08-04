package org.sidiff.revision.api.extensions;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.sidiff.revision.api.IComplementationFacade;

/**
 * Convenience functions to manage {@link IComplementationFacade} extensions.
 * 
 * @author Manuel Ohrndorf
 */
public class ComplementationEngineLibrary {
	
	/**
	 * The {@link IComplementationFacade} extension point identifier.
	 */
	public static final String EXTENSION_POINT_ID = ExtensionPointIDs.COMPLEMENTATION_ENGINE;
	
	/**
	 * {@link IComplementationFacade} extension cache.
	 */
	private static Map<String, ComplementationEngineEntry> library = readExtensionPoints();
	
	/**
	 * @return All registered {@link IComplementationFacade} extensions.
	 */
	private static Map<String, ComplementationEngineEntry> readExtensionPoints() {
		
		Map<String, ComplementationEngineEntry> library = new LinkedHashMap<>();
		
		for (IConfigurationElement configurationElement : Platform.getExtensionRegistry()
				.getConfigurationElementsFor(EXTENSION_POINT_ID)) {

			ComplementationEngineEntry complementationEngineEntry = new ComplementationEngineEntry(configurationElement);
			library.put(complementationEngineEntry.getID(), complementationEngineEntry);
		}
		
		return library;
	}
	
	/**
	 * @return All {@link IComplementationFacade} extensions.
	 */
	public static Collection<ComplementationEngineEntry> getEntries() {
		return Collections.unmodifiableCollection(library.values());
	}

	/**
	 * @param id
	 *            The unique identifier of the {@link IComplementationFacade}.
	 * @return The corresponding {@link IComplementationFacade} extensions or <code>null</code>.
	 */
	public static ComplementationEngineEntry getEntry(String id) {
		return library.get(id);
	}
}
