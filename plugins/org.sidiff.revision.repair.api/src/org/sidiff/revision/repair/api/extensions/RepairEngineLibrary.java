package org.sidiff.revision.repair.api.extensions;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.sidiff.revision.repair.api.IRepairFacade;

/**
 * Convenience functions to manage {@link IRepairFacade} extensions.
 * 
 * @author Manuel Ohrndorf
 */
public class RepairEngineLibrary {
	
	/**
	 * The {@link IRepairFacade} extension point identifier.
	 */
	public static final String EXTENSION_POINT_ID = ExtensionPointIDs.REPAIR_ENGINE;
	
	/**
	 * {@link IRepairFacade} extension cache.
	 */
	private static Map<String, RepairEngineEntry> library = readExtensionPoints();
	
	/**
	 * @return All registered {@link IRepairFacade} extensions.
	 */
	private static Map<String, RepairEngineEntry> readExtensionPoints() {
		
		Map<String, RepairEngineEntry> library = new LinkedHashMap<>();
		
		for (IConfigurationElement configurationElement : Platform.getExtensionRegistry()
				.getConfigurationElementsFor(EXTENSION_POINT_ID)) {

			RepairEngineEntry repairEngineEntry = new RepairEngineEntry(configurationElement);
			library.put(repairEngineEntry.getID(), repairEngineEntry);
		}
		
		return library;
	}
	
	/**
	 * @return All {@link IRepairFacade} extensions.
	 */
	public static Collection<RepairEngineEntry> getEntries() {
		return Collections.unmodifiableCollection(library.values());
	}

	/**
	 * @param id
	 *            The unique identifier of the {@link IRepairFacade}.
	 * @return The corresponding {@link IRepairFacade} extensions or <code>null</code>.
	 */
	public static RepairEngineEntry getEntry(String id) {
		return library.get(id);
	}
}
