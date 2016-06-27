package org.sidiff.consistency.repair.lifting.ui.views;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.resources.IResource;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.henshin.model.Module;
import org.eclipse.emf.henshin.model.Rule;
import org.eclipse.emf.henshin.model.Unit;
import org.eclipse.jface.viewers.StructuredSelection;
import org.sidiff.common.henshin.HenshinUnitAnalysis;
import org.sidiff.common.henshin.exceptions.NoMainUnitFoundException;
import org.sidiff.consistency.repair.lifting.api.Repair;
import org.sidiff.consistency.repair.lifting.api.RepairFacade;
import org.sidiff.difference.technical.api.settings.DifferenceSettings;
import org.sidiff.matcher.IMatcher;
import org.sidiff.matcher.MatcherUtil;
import org.sidiff.matching.input.InputModels;

public class RepairViewApp {

	private RepairView repairView;
	
	private ResourceSet resourceSet = new ResourceSetImpl();
	
	private Resource modelA;
	
	private Resource modelB;
	
	private Collection<Rule> editRules = new ArrayList<>();
	
	public RepairViewApp(RepairView repairView) {
		this.repairView = repairView;
	}
	
	public void calculateRepairs() {
		
		// Matching-Settings:
		InputModels inputModels = new InputModels(new Resource[]{modelA, modelB});
		DifferenceSettings settings = new DifferenceSettings(inputModels.getCharacteristicDocumentType()) {};
		settings.setMatcher(getMatcher());
		
		// Calculate repairs:
		Map<Rule, List<Repair>> repairs = RepairFacade.getRepairs(modelA, modelB, editRules, settings);
		repairView.viewer_repairs.setInput(repairs.values());
	}
	
	private IMatcher getMatcher() {
		return (IMatcher) ((StructuredSelection) repairView.viewer_matching.getSelection()).getFirstElement();
	}

	public boolean removeModelA(Resource selection) {
		resourceSet.getResources().remove(selection);
		modelA = null;
		showAvailableMatchers();
		return true;
	}

	public Resource addModelA(IResource element) {
		modelA = ModelDropWidget.loadModel(resourceSet, element);
		showAvailableMatchers();
		return modelA;
	}

	public boolean removeModelB(Resource selection) {
		resourceSet.getResources().remove(selection);
		modelB = null;
		showAvailableMatchers();
		return true;
	}

	public Resource addModelB(IResource element) {
		modelB = ModelDropWidget.loadModel(resourceSet, element);
		showAvailableMatchers();
		return modelB;
	}

	public boolean removeEditRule(Resource selection) {
		resourceSet.getResources().remove(selection);
		editRules.remove(selection);
		showAvailableMatchers();
		return true;
	}

	public Resource addEditRule(IResource element) {
		Resource editRule = ModelDropWidget.loadModel(resourceSet, element);
		EObject root = editRule.getContents().get(0);
		
		if (root instanceof Module) {
			try {
				Unit executeMainUnit = HenshinUnitAnalysis.findExecuteMainUnit((Module) root);
				
				if (!executeMainUnit.getSubUnits(false).isEmpty()) {
					if (executeMainUnit.getSubUnits(false).get(0) instanceof Rule) {
						editRules.add((Rule) executeMainUnit.getSubUnits(false).get(0));
						return editRule;
					}
				}
			} catch (NoMainUnitFoundException e) {
				e.printStackTrace();
			}
		}
		
		resourceSet.getResources().remove(editRule);
		return null;
	}
	
	private void showAvailableMatchers() {
		if ((modelA != null) && (modelB != null))  {
			Set<IMatcher> matchers = MatcherUtil.getAvailableMatchers(Arrays.asList(modelA,modelB));
			repairView.viewer_matching.setInput(matchers);
		} else {
			repairView.viewer_matching.setInput(null);
		}
	}
}
