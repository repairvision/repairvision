package org.sidiff.consistency.repair.ui.util;

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
import org.sidiff.consistency.repair.ui.controls.impl.ModelDropWidget;
import org.sidiff.editrule.consistency.validation.Activator;
import org.sidiff.editrule.consistency.validation.EditRuleValidation;
import org.sidiff.editrule.consistency.validation.EditRuleValidator;

public class EditRuleUtil {

	public static Collection<Rule> loadEditRules(Collection<IResource> editRuleFiles) {
		
		// Load edit-rules:
		Collection<Rule> editRules = new ArrayList<>();
		ResourceSet editRulesRSS = new ResourceSetImpl();
		
		for (IResource editRuleFile : editRuleFiles) {
			URI uriEditRule = ModelDropWidget.getURI(editRuleFile);
			Resource editRuleRes = editRulesRSS.getResource(uriEditRule, true);
			
			List<EditRuleValidation> validation = EditRuleValidator.calculateEditRuleValidations(
					(Module) editRuleRes.getContents().get(0));
			
			if (validation.isEmpty()) {
				editRules.add(getEditRule(editRuleRes));
			} else {
				MultiStatus info = new MultiStatus(Activator.ID, 1, "Edit-Rule Validation Failed:\n\n" 
						+ editRuleFile.getLocation().toFile(), null);
				
				for (EditRuleValidation editRuleValidation : validation) {
					info.add(new Status(IStatus.ERROR, Activator.ID, 1, editRuleValidation.infoMessage, null));
				}
				
				Display.getDefault().asyncExec(() -> {
					ErrorDialog.openError(
							Display.getDefault().getActiveShell(), 
							PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActivePart().getTitle(), 
							null, info);
				});
			}
		}
		
		return editRules;
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
