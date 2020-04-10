package org.sidiff.revision.repair.ui.presentation.extension;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.sidiff.revision.repair.ui.presentation.IRepairPresentation;

/**
 * Wraps a {@link IRepairPresentation} extension.
 * 
 * @author Manuel Ohrndorf
 */
public class RepairPresentationEntry {
	
	/**
	 * The {@link IRepairPresentation} extension point identifier.
	 */
	public static final String EXTENSION_POINT_ID = ExtensionPointIDs.REPAIR_PRESENTATION;
	
	/**
	 * The registered eclipse extension.
	 */
	private IConfigurationElement extension;
	
	/**
	 * Initializes a new {@link IRepairPresentation} extension wrapper.
	 * 
	 * @param extension
	 *            The {@link IRepairPresentation} extension to wrap.
	 */
	public RepairPresentationEntry(IConfigurationElement extension) {
		this.extension = extension;
	}
	
	/**
	 * @return The name of the repair presentation.
	 */
	public String getName() {
		return extension.getAttribute("name");
	}
	
	/**
	 * @return The unique ID of the repair presentation
	 */
	public String getID() {
		return extension.getAttribute("id");
	}
	
	/**
	 * @return An instance of the repair presentation.
	 */
	public IRepairPresentation getPresentationInstance() {
		try {
			return (IRepairPresentation) extension.createExecutableExtension("presentation");
		} catch (CoreException e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
