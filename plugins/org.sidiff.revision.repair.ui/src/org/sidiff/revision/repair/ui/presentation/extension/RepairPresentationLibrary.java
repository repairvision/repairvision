package org.sidiff.revision.repair.ui.presentation.extension;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.sidiff.revision.repair.api.IRepairFacade;
import org.sidiff.revision.repair.ui.controls.IRepairUI;

/**
 * Convenience functions to manage {@link IRepairUI} extensions.
 * 
 * @author Manuel Ohrndorf
 */
public class RepairPresentationLibrary {
	
	/**
	 * The {@link IRepairUI} extension point identifier.
	 */
	public static final String EXTENSION_POINT_ID = ExtensionPointIDs.REPAIR_PRESENTATION;
	
	/**
	 * {@link IRepairUI} extension cache.
	 */
	private static Map<String, RepairPresentationEntry> library = readExtensionPoints();
	
	/**
	 * @return All registered {@link IRepairUI} extensions.
	 */
	private static Map<String, RepairPresentationEntry> readExtensionPoints() {
		
		Map<String, RepairPresentationEntry> library = new LinkedHashMap<>();
		
		for (IConfigurationElement configurationElement : Platform.getExtensionRegistry()
				.getConfigurationElementsFor(EXTENSION_POINT_ID)) {

			RepairPresentationEntry repairInputProviderEntry = new RepairPresentationEntry(configurationElement);
			library.put(repairInputProviderEntry.getID(), repairInputProviderEntry);
		}
		
		return library;
	}
	
	/**
	 * @return All {@link IRepairUI} extensions.
	 */
	public static Collection<RepairPresentationEntry> getEntries() {
		return Collections.unmodifiableCollection(library.values());
	}

	/**
	 * @param id
	 *            The unique identifier of the {@link IRepairFacade}.
	 * @return The corresponding {@link IRepairUI} extensions or <code>null</code>.
	 */
	public static RepairPresentationEntry getEntry(String id) {
		return library.get(id);
	}
}
