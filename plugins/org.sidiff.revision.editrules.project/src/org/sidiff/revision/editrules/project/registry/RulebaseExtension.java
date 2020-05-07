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
				
				if (localFilePath.endsWith(".henshin")) {
					editRules.add(URI.createPlatformPluginURI(projectName + localFilePath, true));
				}
			}
		}
		
		return editRules;
	}
}
