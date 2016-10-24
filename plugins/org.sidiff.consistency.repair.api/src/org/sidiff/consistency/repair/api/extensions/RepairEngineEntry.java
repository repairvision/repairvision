package org.sidiff.consistency.repair.api.extensions;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.sidiff.consistency.repair.api.IRepair;
import org.sidiff.consistency.repair.api.IRepairFacade;
import org.sidiff.consistency.repair.api.IRepairSettings;
import org.sidiff.consistency.repair.api.RepairJob;

/**
 * Wraps a {@link IRepairFacade} extension.
 * 
 * @author Manuel Ohrndorf
 */
public class RepairEngineEntry {
	
	/**
	 * The {@link IRepairFacade} extension point identifier.
	 */
	public static final String EXTENSION_POINT_ID = ExtensionPointIDs.REPAIR_ENGINE;
	
	/**
	 * The registered eclipse extension.
	 */
	private IConfigurationElement extension;
	
	/**
	 * Initializes a new {@link IRepairFacade} extension wrapper.
	 * 
	 * @param extension
	 *            The {@link IRepairFacade} extension to wrap.
	 */
	public RepairEngineEntry(IConfigurationElement extension) {
		this.extension = extension;
	}
	
	/**
	 * Initializes a new {@link IRepairFacade} extension wrapper.
	 * 
	 * @param id
	 *            The unique identifier of the repair engine.
	 */
	public RepairEngineEntry(String id) {
		resolveExtensionPoint(id);
	}
	
	/**
	 * @return The unique identifier of this repair engine.
	 */
	public String getID() {
		return extension.getAttribute("id");
	}
	
	/**
	 * @return The name of this repair engine.
	 */
	public String getName() {
		return extension.getAttribute("name");
	}
	
	/**
	 * @return An instance of the repair facade.
	 */
	@SuppressWarnings("unchecked")
	public IRepairFacade<RepairJob<? extends IRepair>, IRepairSettings> getRepairFacade() {
		try {
			return (IRepairFacade<RepairJob<? extends IRepair>, IRepairSettings>) extension.createExecutableExtension("facade");
		} catch (CoreException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	/**
	 * Resolves the diagram by its id.
	 */
	private void resolveExtensionPoint(String id) {
		
		for (IConfigurationElement configurationElement : Platform.getExtensionRegistry()
				.getConfigurationElementsFor(EXTENSION_POINT_ID)) {

			try {
				if (configurationElement.getAttribute("id").equals(id)) {
					extension = configurationElement;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
