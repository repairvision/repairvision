package org.sidiff.graphpattern.profile.extensions;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.sidiff.graphpattern.profile.IGraphPatternProfile;

/**
 * Convenience functions to manage {@link IGraphPatternProfile} extensions.
 * 
 * @author Manuel Ohrndorf
 */
public class GraphPatternProfileLibrary {
	
	/**
	 * The {@link IGraphPatternProfile} extension point identifier.
	 */
	public static final String EXTENSION_POINT_ID = ExtensionPointIDs.GRAPHPATTERN_PROFILE;
	
	/**
	 * {@link IGraphPatternProfile} extension cache.
	 */
	private static Map<String, GraphPatternProfileEntry> library = readExtensionPoints();
	
	/**
	 * @return All registered {@link IGraphPatternProfile} extensions.
	 */
	private static Map<String, GraphPatternProfileEntry> readExtensionPoints() {
		
		Map<String, GraphPatternProfileEntry> library = new LinkedHashMap<>();
		
		for (IConfigurationElement configurationElement : Platform.getExtensionRegistry()
				.getConfigurationElementsFor(EXTENSION_POINT_ID)) {

			GraphPatternProfileEntry profileEntry = new GraphPatternProfileEntry(configurationElement);
			library.put(profileEntry.getID(), profileEntry);
		}
		
		return library;
	}
	
	/**
	 * @return All {@link IGraphPatternProfile} extensions.
	 */
	public static List<GraphPatternProfileEntry> getEntries() {
		return new ArrayList<>(library.values());
	}

	/**
	 * @param id
	 *            The unique identifier of the {@link IGraphPatternProfile}.
	 * @return The corresponding {@link IGraphPatternProfile} extensions or <code>null</code>.
	 */
	public static GraphPatternProfileEntry getEntry(String id) {
		return library.get(id);
	}
}
