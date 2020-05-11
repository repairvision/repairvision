package org.sidiff.validation.constraint.project.registry;

import java.util.Set;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.sidiff.validation.constraint.project.ConstraintPlugin;

public class ConstraintLibraryExtension {

	private IConfigurationElement configurationElement;
	
	private String name;
	
	private Set<String> domains;
	
	private Set<String> documentTypes;

	public ConstraintLibraryExtension(IConfigurationElement configurationElement) {
		this.configurationElement = configurationElement;
		
		IConstraintLibrary library = getConstraintLibrary(); // TODO: Store in extension point!
		this.name = library.getName();
		this.domains = library.getDomains();
		this.documentTypes = library.getDocumentTypes();
	}
	
	public IConstraintLibrary getConstraintLibrary() {
		
		try {
			return (IConstraintLibrary) configurationElement
					.createExecutableExtension(ConstraintPlugin.EXTENSION_POINT_ATTRIBUTE_LIBRARY_LIBRARY);
		} catch (CoreException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public String getName() {
		return name;
	}
	
	public Set<String> getDomains() {
		return domains;
	}

	public Set<String> getDocumentTypes() {
		return documentTypes;
	}
	
	
}
