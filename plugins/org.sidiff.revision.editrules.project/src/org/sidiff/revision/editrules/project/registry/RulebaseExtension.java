package org.sidiff.revision.editrules.project.registry;

import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.osgi.framework.Bundle;

public class RulebaseExtension {

	private String projectName;
	
	private String name;
	
	private String documentType;
	
	private String folder;

	public RulebaseExtension(String projectName, String name, String documentType, String folder) {
		this.projectName = projectName;
		this.name = name;
		this.documentType = documentType;
		this.folder = folder;
	}
	
	public String getProjectName() {
		return projectName;
	}

	public String getName() {
		return name;
	}

	public String getDocumentType() {
		return documentType;
	}

	public String getFolder() {
		return folder;
	}
	
	public List<URI> getEditRules() {
		List<URI> editRules = new ArrayList<>();
		Bundle bundle = Platform.getBundle(projectName);
		
		Enumeration<URL> urls = bundle.findEntries("/" + getFolder(), "*", false);
		
		if (urls != null) {
			while(urls.hasMoreElements()) {
				URL url = urls.nextElement();
				String localFilePath = url.getFile();
				
				if (localFilePath.toLowerCase().endsWith(".henshin")) {
					editRules.add(URI.createPlatformPluginURI(projectName + localFilePath, true));
				}
			}
		}
		
		return editRules;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((documentType == null) ? 0 : documentType.hashCode());
		result = prime * result + ((folder == null) ? 0 : folder.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((projectName == null) ? 0 : projectName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RulebaseExtension other = (RulebaseExtension) obj;
		if (documentType == null) {
			if (other.documentType != null)
				return false;
		} else if (!documentType.equals(other.documentType))
			return false;
		if (folder == null) {
			if (other.folder != null)
				return false;
		} else if (!folder.equals(other.folder))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (projectName == null) {
			if (other.projectName != null)
				return false;
		} else if (!projectName.equals(other.projectName))
			return false;
		return true;
	}
}
