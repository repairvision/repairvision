package org.sidiff.revision.editrules.project.library;

import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.osgi.framework.Bundle;
import org.sidiff.revision.editrules.project.RuleBasePlugin;

/**
 * Access to the registered rulebases.
 * 
 * @author Manuel Ohrndorf
 */
public class RulebaseLibrary {

	public static List<URI> getRulebase(String rulebaseName) {
		List<URI> editRules = new ArrayList<>();
		
		for (IConfigurationElement configurationElement : Platform.getExtensionRegistry()
				.getConfigurationElementsFor(RuleBasePlugin.EXTENSION_POINT_ID)) {

			String name = configurationElement.getAttribute("name");
			
			if ((name != null) && name.equals(rulebaseName)) {
				collectEditRules(editRules, configurationElement);
			}
		}
		
		return editRules;
	}
	
	public static List<URI> getRulebases(String rulebaseNameRegex, String documentType) {
		List<URI> editRules = new ArrayList<>();
		
		for (IConfigurationElement configurationElement : Platform.getExtensionRegistry()
				.getConfigurationElementsFor(RuleBasePlugin.EXTENSION_POINT_ID)) {

			String name = configurationElement.getAttribute("name");
			
			if ((name != null) && name.matches(rulebaseNameRegex)) {
				String documentTypeValue = configurationElement.getAttribute("document-type");
				
				if (documentTypeValue.equals(documentType)) {
					collectEditRules(editRules, configurationElement);
				}
			}
		}
		
		return editRules;
	}
	
	public static List<URI> getEditRules(String documentType) {
		List<URI> editRules = new ArrayList<>();
		
		for (IConfigurationElement configurationElement : Platform.getExtensionRegistry()
				.getConfigurationElementsFor(RuleBasePlugin.EXTENSION_POINT_ID)) {

			String documentTypeValue = configurationElement.getAttribute("document-type");
			
			if (documentTypeValue.equals(documentType)) {
				collectEditRules(editRules, configurationElement);
			}
		}
		
		return editRules;
	}

	private static void collectEditRules(List<URI> editRules, IConfigurationElement configurationElement) {
		String folderValue = configurationElement.getAttribute( "folder");
		
		String projectName = configurationElement.getContributor().getName();
		Bundle bundle = Platform.getBundle(projectName);
		
		Enumeration<URL> urls = bundle.findEntries("/" + folderValue, "*", false);
		
		while(urls.hasMoreElements()) {
			URL url = urls.nextElement();
			String localFilePath = url.getFile();

			if (localFilePath.endsWith(".henshin")) {
				editRules.add(URI.createPlatformPluginURI(projectName + localFilePath, true));
			}
		}
	}
	
}
