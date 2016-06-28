package org.sidiff.consistency.repair.lifting.ui.views;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
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
import org.eclipse.jface.viewers.StructuredSelection;
import org.sidiff.common.emf.access.EMFModelAccess;
import org.sidiff.common.henshin.HenshinUnitAnalysis;
import org.sidiff.common.henshin.exceptions.NoMainUnitFoundException;
import org.sidiff.consistency.repair.lifting.api.Repair;
import org.sidiff.consistency.repair.lifting.api.RepairFacade;
import org.sidiff.difference.technical.api.settings.DifferenceSettings;
import org.sidiff.matcher.IMatcher;
import org.sidiff.matcher.MatcherUtil;

public class RepairViewApp {

	private RepairView repairView;
	
	private IResource modelAFile;
	
	private IResource modelBFile;
	
	private Collection<IResource> editRuleFiles = new ArrayList<>();
	
	private String documentType;
	
	public RepairViewApp(RepairView repairView) {
		this.repairView = repairView;
	}
	
	public void calculateRepairs() {
		
		// Matching-Settings:
		DifferenceSettings settings = new DifferenceSettings(documentType) {};
		settings.setMatcher(getMatcher());
		
		// Load edit-rules:
		Collection<Rule> editRules = new ArrayList<>();
		ResourceSet editRulesRSS = new ResourceSetImpl();
		
		for (IResource editRuleFile : editRuleFiles) {
			URI uriEditRule = ModelDropWidget.getURI(editRuleFile);
			Resource editRuleRes = editRulesRSS.getResource(uriEditRule, true);
			editRules.add(getEditRule(editRuleRes));
		}
		
		// Calculate repairs:
		URI uriModelA = ModelDropWidget.getURI(modelAFile);
		URI uriModelB = ModelDropWidget.getURI(modelBFile);
		Map<Rule, List<Repair>> repairs = RepairFacade.getRepairs(uriModelA, uriModelB, editRules, settings);
		
		// Show repairs:
		repairView.viewer_repairs.setInput(repairs);
	}
	
	private IMatcher getMatcher() {
		return (IMatcher) ((StructuredSelection) repairView.viewer_matching.getSelection()).getFirstElement();
	}

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

	public boolean removeEditRule(IResource selection) {
		editRuleFiles.remove(selection);
		return true;
	}

	public boolean addEditRule(IResource element) {
		if (element.getFileExtension().equalsIgnoreCase("henshin")) {
			editRuleFiles.add(element);
			return true;
		} else {
			return false;
		}
	}
	
	private Rule getEditRule(Resource editRuleResource) {
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
	
	private void showAvailableMatchers() {
		if ((modelAFile != null) && (modelBFile != null))  {
			
			// FIXME: We need a parser which only reads the document-type in the header...
			ResourceSet differenceRSS = new ResourceSetImpl();
			Resource modelARes = differenceRSS.getResource(ModelDropWidget.getURI(modelAFile), true);
			Resource modelBRes = differenceRSS.getResource(ModelDropWidget.getURI(modelBFile), true);
			
			documentType = EMFModelAccess.getCharacteristicDocumentType(modelARes);
			
			Set<IMatcher> matchers = MatcherUtil.getAvailableMatchers(Arrays.asList(modelARes, modelBRes));
			repairView.viewer_matching.setInput(matchers);
		} else {
			repairView.viewer_matching.setInput(null);
			documentType = null;
		}
	}
}
