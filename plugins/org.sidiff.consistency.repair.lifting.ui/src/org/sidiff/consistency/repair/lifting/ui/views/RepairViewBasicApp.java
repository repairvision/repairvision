package org.sidiff.consistency.repair.lifting.ui.views;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Set;

import org.eclipse.core.resources.IResource;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.henshin.model.Module;
import org.eclipse.emf.henshin.model.Rule;
import org.eclipse.emf.henshin.model.Unit;
import org.eclipse.jface.viewers.TreeViewer;
import org.sidiff.common.emf.access.EMFModelAccess;
import org.sidiff.common.henshin.HenshinUnitAnalysis;
import org.sidiff.common.henshin.exceptions.NoMainUnitFoundException;
import org.sidiff.consistency.repair.lifting.api.Repair;
import org.sidiff.difference.technical.api.settings.DifferenceSettings;
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
	
	public boolean removeModelA(IResource selection) {
		modelAFile = null;
		showAvailableMatchers();
		return true;
	}

	public boolean addModelA(IResource element) {
		modelAFile = element;
		showAvailableMatchers();
		return true;
	}

	public boolean removeModelB(IResource selection) {
		modelBFile = null;
		showAvailableMatchers();
		return true;
	}

	public boolean addModelB(IResource element) {
		modelBFile = element;
		showAvailableMatchers();
		return true;
	}
	
	private void showAvailableMatchers() {
		if ((modelAFile != null) && (modelBFile != null))  {
			
			// FIXME: We need a parser which only reads the document-type in the header...
			ResourceSet differenceRSS = new ResourceSetImpl();
			Resource modelARes = differenceRSS.getResource(ModelDropWidget.getURI(modelAFile), true);
			Resource modelBRes = differenceRSS.getResource(ModelDropWidget.getURI(modelBFile), true);
			
			documentType = EMFModelAccess.getCharacteristicDocumentType(modelARes);
			
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
			editRules.add(getEditRule(editRuleRes));
		}
		
		return editRules;
	}
	
	protected DifferenceSettings getMatchingSettings() {

		// Matching-Settings:
		if (documentType != null) {
			DifferenceSettings settings = new DifferenceSettings(documentType) {};
			settings.setMatcher(RepairPreferencePage.getSelectedMatcher());
		}
		
		return null;
	}
}
