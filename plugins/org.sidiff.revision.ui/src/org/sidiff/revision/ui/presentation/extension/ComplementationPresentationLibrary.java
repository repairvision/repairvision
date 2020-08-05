package org.sidiff.revision.ui.presentation.extension;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.sidiff.revision.api.ComplementationFacade;
import org.sidiff.revision.ui.presentation.ComplementationUI;

/**
 * Convenience functions to manage {@link ComplementationUI} extensions.
 * 
 * @author Manuel Ohrndorf
 */
public class ComplementationPresentationLibrary {
	
	/**
	 * The {@link ComplementationUI} extension point identifier.
	 */
	public static final String EXTENSION_POINT_ID = ExtensionPointIDs.COMPLEMENTATION_PRESENTATION;
	
	/**
	 * {@link ComplementationUI} extension cache.
	 */
	private static Map<String, ComplementationPresentationEntry> library = readExtensionPoints();
	
	/**
	 * @return All registered {@link ComplementationUI} extensions.
	 */
	private static Map<String, ComplementationPresentationEntry> readExtensionPoints() {
		
		Map<String, ComplementationPresentationEntry> library = new LinkedHashMap<>();
		
		for (IConfigurationElement configurationElement : Platform.getExtensionRegistry()
				.getConfigurationElementsFor(EXTENSION_POINT_ID)) {

			ComplementationPresentationEntry inputProviderEntry = new ComplementationPresentationEntry(configurationElement);
			library.put(inputProviderEntry.getID(), inputProviderEntry);
		}
		
		return library;
	}
	
	/**
	 * @return All {@link ComplementationUI} extensions.
	 */
	public static Collection<ComplementationPresentationEntry> getEntries() {
		return Collections.unmodifiableCollection(library.values());
	}

	/**
	 * @param id
	 *            The unique identifier of the {@link ComplementationFacade}.
	 * @return The corresponding {@link ComplementationUI} extensions or <code>null</code>.
	 */
	public static ComplementationPresentationEntry getEntry(String id) {
		return library.get(id);
	}
}
