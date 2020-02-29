package org.sidiff.repair.editrules.library;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.henshin.model.Module;
import org.eclipse.emf.henshin.model.Rule;
import org.eclipse.emf.henshin.model.Unit;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;
import org.sidiff.common.henshin.HenshinUnitAnalysis;
import org.sidiff.common.henshin.exceptions.NoMainUnitFoundException;
import org.sidiff.consistency.common.ui.util.WorkbenchUtil;
import org.sidiff.editrule.consistency.validation.Activator;
import org.sidiff.editrule.consistency.validation.EditRuleValidation;
import org.sidiff.editrule.consistency.validation.EditRuleValidator;

public class RulebaseUtil {

	public static Collection<Rule> loadEditRules(Collection<IResource> editRuleFiles, boolean validate, boolean onlyValid) {
		
		// Load edit-rules:
		Collection<Rule> editRules = new ArrayList<>();
		ResourceSet editRulesRSS = new ResourceSetImpl();
		
		for (IResource editRuleFile : editRuleFiles) {
			URI uriEditRule = WorkbenchUtil.getURI(editRuleFile);
			Resource editRuleRes = editRulesRSS.getResource(uriEditRule, true);
			
			boolean isValid = validate ? editRuleValidation(editRuleFile.getLocation().toFile().toString(), editRuleRes) : true;
			
			if (!onlyValid || isValid) {
				Rule editRule = getEditRule(editRuleRes);
				
				if (editRule != null) {
					editRules.add(editRule);
				}
			}
		}
		
		return editRules;
	}
	
	public static List<Rule> eLoadEditRules(Collection<URI> editRuleFiles, boolean validate) {
		
		// Load edit-rules:
		List<Rule> editRules = new ArrayList<>();
		ResourceSet editRulesRSS = new ResourceSetImpl();
		
		for (URI editRuleURI : editRuleFiles) {
			Resource editRuleRes = editRulesRSS.getResource(editRuleURI, true);
			
			if (!validate || editRuleValidation(editRuleURI.toFileString(), editRuleRes)) {
				Rule editRule = getEditRule(editRuleRes);
				
				if (editRule != null) {
					editRules.add(editRule);
				}
			}
		}
		
		return editRules;
	}
	
	public static boolean editRuleValidation(String editRuleFile, Resource editRuleRes) {
		try {
			List<EditRuleValidation> validation = EditRuleValidator.calculateEditRuleValidations(
					(Module) editRuleRes.getContents().get(0));
			
			if (validation.isEmpty()) {
				return true;
			} else {
				MultiStatus info = new MultiStatus(Activator.ID, 1, "Edit-Rule Validation Failed:\n\n" 
						+ editRuleFile, null);
				
				for (EditRuleValidation editRuleValidation : validation) {
					info.add(new Status(IStatus.ERROR, Activator.ID, 1, editRuleValidation.infoMessage, null));
				}
				
				Display.getDefault().asyncExec(() -> {
					ErrorDialog.openError(
							Display.getDefault().getActiveShell(), 
							PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActivePart().getTitle(), 
							null, info);
				});
				
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static Rule getEditRule(Resource editRuleResource) {
		EObject root = editRuleResource.getContents().get(0);
		
		if (root instanceof Module) {
			try {
				Unit executeMainUnit = HenshinUnitAnalysis.findExecuteMainUnit((Module) root);
				
				if (!executeMainUnit.getSubUnits(false).isEmpty()) {
					if (executeMainUnit.getSubUnits(false).get(0) instanceof Rule) {
						Rule editRule = (Rule) executeMainUnit.getSubUnits(false).get(0);
						return editRule;
					}
				}
				
				throw new NoMainUnitFoundException((Module) root);
			} catch (NoMainUnitFoundException e) {
				e.printStackTrace();
			}
		}
		
		return null;
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
