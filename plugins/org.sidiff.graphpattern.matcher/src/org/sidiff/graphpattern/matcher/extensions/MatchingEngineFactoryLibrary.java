package org.sidiff.graphpattern.matcher.extensions;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.sidiff.graphpattern.matcher.IPatternMatchingEngineFactory;

/**
 * Convenience functions to manage {@link IPatternMatchingEngineFactoryFactory} extensions.
 * 
 * @author Manuel Ohrndorf
 */
public class MatchingEngineFactoryLibrary {
	
	/**
	 * The {@link IPatternMatchingEngineFactoryFactory} extension point identifier.
	 */
	public static final String EXTENSION_POINT_ID = ExtensionPointIDs.MATCHER_FACTORY;
	
	/**
	 * {@link IPatternMatchingEngineFactory} extension cache.
	 */
	private static Map<String, MatchingEngineFactoryEntry> library = readExtensionPoints();
	
	/**
	 * @return All registered {@link IPatternMatchingEngineFactory} extensions.
	 */
	private static Map<String, MatchingEngineFactoryEntry> readExtensionPoints() {
		
		Map<String, MatchingEngineFactoryEntry> library = new HashMap<String, MatchingEngineFactoryEntry>();
		
		for (IConfigurationElement configurationElement : Platform.getExtensionRegistry()
				.getConfigurationElementsFor(EXTENSION_POINT_ID)) {

			MatchingEngineFactoryEntry pipelineEntry = new MatchingEngineFactoryEntry(configurationElement);
			library.put(pipelineEntry.getID(), pipelineEntry);
		}
		
		return library;
	}
	
	/**
	 * @return All {@link IPatternMatchingEngineFactory} extensions.
	 */
	public static Collection<MatchingEngineFactoryEntry> getEntries() {
		return Collections.unmodifiableCollection(library.values());
	}

	/**
	 * @param id
	 *            The unique identifier of the {@link IPatternMatchingEngineFactory}.
	 * @return The corresponding {@link IPatternMatchingEngineFactory}  extensions or <code>null</code>.
	 */
	public static MatchingEngineFactoryEntry getEntry(String id) {
		return library.get(id);
	}
}
