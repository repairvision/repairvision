package org.sidiff.revision.editrules.project.registry.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.henshin.model.Module;
import org.eclipse.emf.henshin.model.Rule;
import org.eclipse.emf.henshin.model.Unit;
import org.sidiff.revision.common.ui.workbench.WorkbenchUtil;

public class RulebaseUtil {

	public static Collection<Rule> loadEditRules(Collection<IResource> editRuleFiles, boolean validate, boolean onlyValid) {
		
		// Load edit-rules:
		Collection<Rule> editRules = new ArrayList<>();
		ResourceSet editRulesRSS = new ResourceSetImpl();
		
		for (IResource editRuleFile : editRuleFiles) {
			URI uriEditRule = WorkbenchUtil.getURI(editRuleFile);
			Resource editRuleRes = editRulesRSS.getResource(uriEditRule, true);
			editRules.addAll(getEditRules(editRuleRes));
		}
		
		return editRules;
	}
	
	public static List<Rule> eLoadEditRules(Collection<URI> editRuleFiles, boolean validate) {
		
		// Load edit-rules:
		List<Rule> editRules = new ArrayList<>();
		ResourceSet editRulesRSS = new ResourceSetImpl();
		
		for (URI editRuleURI : editRuleFiles) {
			Resource editRuleRes = editRulesRSS.getResource(editRuleURI, true);
			editRules.addAll(getEditRules(editRuleRes));
		}
		
		return editRules;
	}
	
	public static List<Rule> getEditRules(Resource editRuleResource) {
		List<Rule> rules = new ArrayList<>();
		EObject root = editRuleResource.getContents().get(0);
		
		if (root instanceof Module) {
			for (Unit unit : ((Module) root).getUnits()) {
				if (unit instanceof Rule) {
					rules.add((Rule) unit);
				}
				
			}
		}
		
		return rules;
	}
	
	public static IResource getEditRule(IResource element) {
		
		if (element != null) {
			
			if (element.getFileExtension().equalsIgnoreCase("henshin")) {
				return element;
			} 
			
			else if (element.getFileExtension().equalsIgnoreCase("henshin_diagram")) {
				int extension = element.getLocationURI().getPath().lastIndexOf(".");
				IPath rulePath = Path.fromOSString(element.getLocationURI().getPath().substring(0, extension) + ".henshin");
				
				IResource rule = ResourcesPlugin.getWorkspace().getRoot().getFileForLocation(rulePath);
				return getEditRule(rule);
			}
		}

		return null;
	}
}
