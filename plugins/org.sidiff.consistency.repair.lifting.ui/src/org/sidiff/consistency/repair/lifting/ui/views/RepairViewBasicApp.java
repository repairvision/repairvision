package org.sidiff.consistency.repair.lifting.ui.views;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
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
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;
import org.sidiff.common.emf.access.EMFModelAccess;
import org.sidiff.common.henshin.HenshinUnitAnalysis;
import org.sidiff.common.henshin.exceptions.NoMainUnitFoundException;
import org.sidiff.consistency.repair.lifting.api.Repair;
import org.sidiff.difference.technical.api.settings.DifferenceSettings;
import org.sidiff.editrule.consistency.validation.Activator;
import org.sidiff.editrule.consistency.validation.EditRuleValidation;
import org.sidiff.editrule.consistency.validation.EditRuleValidator;
import org.sidiff.matcher.IMatcher;
import org.sidiff.matcher.MatcherUtil;

public abstract class RepairViewBasicApp {

	protected TreeViewer viewer_repairs;
	
	protected IResource modelAFile;
	
	protected IResource modelBFile;
	
	protected String documentType;
	
	public RepairViewBasicApp(TreeViewer viewer_repairs) {
		this.viewer_repairs = viewer_repairs;
	}
	
	public abstract void calculateRepairs();
	
	public abstract void applyRepair(Repair repair);
	
	public IResource removeModelA(IResource selection) {
		modelAFile = null;
		showAvailableMatchers();
		return selection;
	}

	public IResource addModelA(IResource element) {
		modelAFile = element;
		showAvailableMatchers();
		return element;
	}

	public IResource removeModelB(IResource selection) {
		modelBFile = null;
		showAvailableMatchers();
		return selection;
	}

	public IResource addModelB(IResource element) {
		modelBFile = element;
		showAvailableMatchers();
		return element;
	}
	
	private void showAvailableMatchers() {
		if ((modelAFile != null) && (modelBFile != null))  {
			
			// FIXME: We need a parser which only reads the document-type in the header...
			ResourceSet differenceRSS = new ResourceSetImpl();
			Resource modelARes = differenceRSS.getResource(ModelDropWidget.getURI(modelAFile), true);
			Resource modelBRes = differenceRSS.getResource(ModelDropWidget.getURI(modelBFile), true);
			
			documentType = EMFModelAccess.getDocumentType(modelARes);
			
			Set<IMatcher> matchers = MatcherUtil.getAvailableMatchers(Arrays.asList(modelARes, modelBRes));
			RepairPreferencePage.setAvailableMatcher(matchers);
		} else {
			RepairPreferencePage.setAvailableMatcher(null);
			documentType = null;
		}
	}
	
	protected Rule getEditRule(Resource editRuleResource) {
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
	
	protected Collection<Rule> loadEditRules(Collection<IResource> editRuleFiles) {
		
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
	
	protected DifferenceSettings getMatchingSettings() {

		// Matching-Settings:
		if (documentType != null) {
			DifferenceSettings settings = new DifferenceSettings() {};
			settings.setMatcher(RepairPreferencePage.getSelectedMatcher());
			return settings;
		}
		
		return null;
	}
}
