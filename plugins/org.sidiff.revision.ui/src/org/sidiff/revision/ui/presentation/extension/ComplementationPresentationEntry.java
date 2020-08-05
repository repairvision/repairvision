package org.sidiff.revision.ui.presentation.extension;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.sidiff.revision.ui.presentation.ComplementationPresentation;

/**
 * Wraps a {@link ComplementationPresentation} extension.
 * 
 * @author Manuel Ohrndorf
 */
public class ComplementationPresentationEntry {
	
	/**
	 * The {@link ComplementationPresentation} extension point identifier.
	 */
	public static final String EXTENSION_POINT_ID = ExtensionPointIDs.COMPLEMENTATION_PRESENTATION;
	
	/**
	 * The registered eclipse extension.
	 */
	private IConfigurationElement extension;
	
	/**
	 * Initializes a new {@link ComplementationPresentation} extension wrapper.
	 * 
	 * @param extension
	 *            The {@link ComplementationPresentation} extension to wrap.
	 */
	public ComplementationPresentationEntry(IConfigurationElement extension) {
		this.extension = extension;
	}
	
	/**
	 * @return The name of the complementation presentation.
	 */
	public String getName() {
		return extension.getAttribute("name");
	}
	
	/**
	 * @return The unique ID of the complementation presentation
	 */
	public String getID() {
		return extension.getAttribute("id");
	}
	
	/**
	 * @return An instance of the complementation presentation.
	 */
	public ComplementationPresentation getPresentationInstance() {
		try {
			return (ComplementationPresentation) extension.createExecutableExtension("presentation");
		} catch (CoreException e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
