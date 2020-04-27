package org.sidiff.validation.constraint.project.library;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;

/**
 * Convenience functions to manage {@link IConstaintLibrary} extensions.
 * 
 * @author Manuel Ohrndorf
 */
public class ConstraintLibraryRegistry {
	
	/**
	 * The {@link IConstaintLibrary} extension point identifier.
	 */
	public static final String EXTENSION_POINT_ID = "org.sidiff.validation.constraint.project.library";
	
	/**
	 * {@link IConstaintLibrary} extension cache.
	 */
	private static Map<String, List<IConstraintLibrary>> libraries = readExtensionPoints();
	
	/**
	 * @return All registered {@link IConstaintLibrary} extensions.
	 */
	private static Map<String, List<IConstraintLibrary>> readExtensionPoints() {
		
		Map<String, List<IConstraintLibrary>> librarys = new LinkedHashMap<>();
		
		for (IConfigurationElement configurationElement : Platform.getExtensionRegistry()
				.getConfigurationElementsFor(EXTENSION_POINT_ID)) {

			try {
				IConstraintLibrary library = (IConstraintLibrary) configurationElement.createExecutableExtension("library");
				
				for (String documentType : library.getDocumentTypes()) {
					List<IConstraintLibrary> domain = librarys.getOrDefault(documentType, new ArrayList<>());
					domain.add(library);
					librarys.put(documentType, domain);
				}
			} catch (CoreException e) {
				e.printStackTrace();
			}
		}
		
		return librarys;
	}
	
	public static Map<String, List<IConstraintLibrary>> getLibraries() {
		return libraries;
	}
	
	/**
	 * @param documentType
	 *            The document type of the required constraint library.
	 * 
	 * @return All {@link IConstaintLibrary} extensions for the given document type.
	 */
	public static List<IConstraintLibrary> getLibraries(String documentType) {

		if (getLibraries().containsKey(documentType)) {
			return Collections.unmodifiableList(getLibraries().get(documentType));
		} else {
			return Collections.emptyList();
		}
	}
}
