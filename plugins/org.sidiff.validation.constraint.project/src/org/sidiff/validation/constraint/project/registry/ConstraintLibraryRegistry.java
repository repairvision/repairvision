package org.sidiff.validation.constraint.project.registry;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.sidiff.validation.constraint.interpreter.IConstraint;
import org.sidiff.validation.constraint.project.ConstraintPlugin;

/**
 * Convenience functions to manage {@link IConstaintLibrary} extensions.
 * 
 * @author Manuel Ohrndorf
 */
public class ConstraintLibraryRegistry {
	
	public static List<ConstraintLibraryExtension> getConstraintLibraries() {
		List<ConstraintLibraryExtension> librarys = new ArrayList<>();
		
		for (IConfigurationElement configurationElement : Platform.getExtensionRegistry()
				.getConfigurationElementsFor(ConstraintPlugin.EXTENSION_POINT_ID)) {

			librarys.add(new ConstraintLibraryExtension(configurationElement));
		}
		
		return librarys;
	}
	
	public static List<IConstraintLibrary> getLibraries(String documentType) {
		return getLibraries(documentType, getConstraintLibraries());
	}
	
	public static List<IConstraintLibrary> getLibraries(String documentType, List<ConstraintLibraryExtension> libraries) {
		List<IConstraintLibrary> docTypeLibraries = new ArrayList<>();
		
		for (ConstraintLibraryExtension library : libraries) {
			if (library.getDocumentTypes().contains(documentType)) {
				docTypeLibraries.add(library.getConstraintLibrary());
			}
		}
		
		return docTypeLibraries;
	}
	
	public static List<IConstraint> getConstraints(String documentType) {
		return getConstraints(documentType, getConstraintLibraries());
	}
	
	public static List<IConstraint> getConstraints(String documentType, List<ConstraintLibraryExtension> libraries) {
		List<IConstraint> docTypeConstraints = new ArrayList<>();
		
		for (ConstraintLibraryExtension library : libraries) {
			if (library.getDocumentTypes().contains(documentType)) {
				docTypeConstraints.addAll(library.getConstraintLibrary().getConstraints());
			}
		}
		
		return docTypeConstraints;
	}
}
