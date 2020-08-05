package org.sidiff.revision.api.extensions;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.sidiff.revision.api.ComplementationJob;
import org.sidiff.revision.api.ComplementationFacade;
import org.sidiff.revision.api.ComplementationPlan;
import org.sidiff.revision.api.ComplementationSettings;

/**
 * Wraps a {@link ComplementationFacade} extension.
 * 
 * @author Manuel Ohrndorf
 */
public class ComplementationEngineEntry {
	
	/**
	 * The {@link ComplementationFacade} extension point identifier.
	 */
	public static final String EXTENSION_POINT_ID = ExtensionPointIDs.COMPLEMENTATION_ENGINE;
	
	/**
	 * The registered eclipse extension.
	 */
	private IConfigurationElement extension;
	
	/**
	 * Initializes a new {@link ComplementationFacade} extension wrapper.
	 * 
	 * @param extension
	 *            The {@link ComplementationFacade} extension to wrap.
	 */
	public ComplementationEngineEntry(IConfigurationElement extension) {
		this.extension = extension;
	}
	
	/**
	 * Initializes a new {@link ComplementationFacade} extension wrapper.
	 * 
	 * @param id
	 *            The unique identifier of the complementation engine.
	 */
	public ComplementationEngineEntry(String id) {
		resolveExtensionPoint(id);
	}
	
	/**
	 * @return The unique identifier of this complementation engine.
	 */
	public String getID() {
		return extension.getAttribute("id");
	}
	
	/**
	 * @return The name of this complementation engine.
	 */
	public String getName() {
		return extension.getAttribute("name");
	}
	
	/**
	 * @return An instance of the complementation facade.
	 */
	@SuppressWarnings("unchecked")
	public ComplementationFacade<ComplementationJob<? extends ComplementationPlan>, ComplementationSettings> getComplementationFacade() {
		try {
			return (ComplementationFacade<ComplementationJob<? extends ComplementationPlan>, ComplementationSettings>) extension.createExecutableExtension("facade");
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
