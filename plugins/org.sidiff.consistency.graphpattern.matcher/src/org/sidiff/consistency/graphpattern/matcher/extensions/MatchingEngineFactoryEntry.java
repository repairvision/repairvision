package org.sidiff.consistency.graphpattern.matcher.extensions;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.sidiff.consistency.graphpattern.matcher.IPatternMatchingEngineFactory;

/**
 * Wraps a {@link IPatternMatchingEngineFactory} extension.
 * 
 * @author Manuel Ohrndorf
 */
public class MatchingEngineFactoryEntry {
	
	/**
	 * The {@link IPatternMatchingEngineFactoryFactory} extension point identifier.
	 */
	public static final String EXTENSION_POINT_ID = ExtensionPointIDs.MATCHER_FACTORY;
	
	private IConfigurationElement extension;
	
	/**
	 * Initializes a new {@link IPatternMatchingEngineFactory} extension wrapper.
	 * 
	 * @param extension
	 *            The {@link IPatternMatchingEngineFactory} extension to wrap.
	 */
	public MatchingEngineFactoryEntry(IConfigurationElement extension) {
		this.extension = extension;
	}
	
	/**
	 * Initializes a new {@link IPatternMatchingEngineFactory} extension wrapper.
	 * 
	 * @param id
	 *            The unique identifier of the pattern matching engine (factory).
	 */
	public MatchingEngineFactoryEntry(String id) {
		resolveExtensionPoint(id);
	}
	
	/**
	 * @return The unique identifier of this pattern matching engine (factory).
	 */
	public String getID() {
		return extension.getAttribute("id");
	}
	
	/**
	 * @return The name of this pattern matching engine (factory).
	 */
	public String getName() {
		return extension.getAttribute("name");
	}
	
	/**
	 * @return The description of this pattern matching engine (factory).
	 */
	public String getDescription() {
		return extension.getAttribute("description");
	}
	
	/**
	 * @return An instance of the pattern matching engine (factory).
	 */
	public IPatternMatchingEngineFactory<?> getInstance() {
		
		try {
			return (IPatternMatchingEngineFactory<?>) extension.createExecutableExtension("class");
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
