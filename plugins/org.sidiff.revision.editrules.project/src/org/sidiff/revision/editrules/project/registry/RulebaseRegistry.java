package org.sidiff.revision.editrules.project.registry;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.sidiff.revision.editrules.project.RuleBasePlugin;

/**
 * Access to the registered rulebases.
 * 
 * @author Manuel Ohrndorf
 */
public class RulebaseRegistry {
	
	public static List<RulebaseExtension> getRulebases() {
		List<RulebaseExtension> editRules = new ArrayList<>();
		
		for (IConfigurationElement configurationElement : Platform.getExtensionRegistry()
				.getConfigurationElementsFor(RuleBasePlugin.EXTENSION_POINT_ID)) {
			
			String projectName = configurationElement.getContributor().getName();
			String name = configurationElement.getAttribute(RuleBasePlugin.EXTENSION_POINT_ATTRIBUTE_RULEBASE_NAME);
			String folder = configurationElement.getAttribute(RuleBasePlugin.EXTENSION_POINT_ATTRIBUTE_RULEBASE_FOLDER);
			String documentType = configurationElement.getAttribute(RuleBasePlugin.EXTENSION_POINT_ATTRIBUTE_RULEBASE_DOCUMENT_TYPE);
			
			editRules.add(new RulebaseExtension(projectName, name, documentType, folder));
		}
		
		return editRules;
	}
	
	public static List<URI> getRulebase(String rulebaseName) {
		return getRulebase(rulebaseName, getRulebases());
	}
	
	public static List<URI> getRulebase(String rulebaseName, List<RulebaseExtension> rulebases) {
		List<URI> editRules = new ArrayList<>();
		
		for (RulebaseExtension rulebase : rulebases) {
			if ((rulebase.getName() != null) && rulebase.getName().equals(rulebaseName)) {
				editRules.addAll(rulebase.getEditRules());
			}
		}
		
		return editRules;
	}
	
	public static List<URI> getRulebases(String rulebaseNameRegex, String documentType) {
		return getRulebases(rulebaseNameRegex, documentType, getRulebases());
	}
	
	public static List<URI> getRulebases(String rulebaseNameRegex, String documentType, List<RulebaseExtension> rulebases) {
		List<URI> editRules = new ArrayList<>();
		
		for (RulebaseExtension rulebase : rulebases) {
			if ((rulebase.getName() != null) && rulebase.getName().matches(rulebaseNameRegex)) {
				if (rulebase.getDocumentType().equals(documentType)) {
					editRules.addAll(rulebase.getEditRules());
				}
			}
		}
		
		return editRules;
	}
	
	public static List<URI> getEditRules(String documentType) {
		return getEditRules(documentType, getRulebases());
	}
	
	public static List<URI> getEditRules(String documentType, List<RulebaseExtension> rulebases) {
		List<URI> editRules = new ArrayList<>();
		
		for (RulebaseExtension rulebase : rulebases) {
			if (rulebase.getDocumentType().equals(documentType)) {
				editRules.addAll(rulebase.getEditRules());
			}
		}
		
		return editRules;
	}
}
