package org.sidiff.graphpattern.profile.extensions;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.sidiff.graphpattern.profile.IGraphPatternProfile;

/**
 * Wraps a {@link IRepairFacade} extension.
 * 
 * @author Manuel Ohrndorf
 */
public class GraphPatternProfileEntry {
	
	/**
	 * The {@link IRepairFacade} extension point identifier.
	 */
	public static final String EXTENSION_POINT_ID = ExtensionPointIDs.GRAPHPATTERN_PROFILE;
	
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
	public GraphPatternProfileEntry(IConfigurationElement extension) {
		this.extension = extension;
	}
	
	/**
	 * @return The unique identifier of this repair engine.
	 */
	public String getID() {
		return extension.getAttribute("id");
	}
	
	/**
	 * @return An instance of the repair facade.
	 */
	public IGraphPatternProfile getProfile() {
		try {
			return (IGraphPatternProfile) extension.createExecutableExtension("definition");
		} catch (CoreException e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
