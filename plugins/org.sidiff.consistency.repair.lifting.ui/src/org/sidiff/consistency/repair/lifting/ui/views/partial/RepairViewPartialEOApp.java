package org.sidiff.consistency.repair.lifting.ui.views.partial;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.core.resources.IResource;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.henshin.model.Rule;
import org.eclipse.jface.viewers.TreeViewer;
import org.sidiff.consistency.repair.lifting.api.Repair;
import org.sidiff.consistency.repair.lifting.api.RepairFacade;
import org.sidiff.consistency.repair.lifting.api.RepairJob;
import org.sidiff.consistency.repair.lifting.ui.views.ModelDropWidget;
import org.sidiff.consistency.repair.lifting.ui.views.RepairViewBasicApp;
import org.sidiff.consistency.repair.validation.util.BatchValidationIterator.Validation;
import org.sidiff.difference.technical.api.settings.DifferenceSettings;

public class RepairViewPartialEOApp extends RepairViewBasicApp {

	private TreeViewer viewer_validation;
	
	private Collection<IResource> editRuleFiles = new ArrayList<>();
	
	private RepairJob repairJob;
	
	public RepairViewPartialEOApp(TreeViewer viewer_repairs) {
		super(viewer_repairs);
	}
	
	public void setValidationViewer(TreeViewer viewer_validation) {
		this.viewer_validation = viewer_validation;
	}
	
	@Override
	public void calculateRepairs() {
		
		// Matching-Settings:
		DifferenceSettings settings = getMatchingSettings();
		
		// Load edit-rules:
		Collection<Rule> editRules = loadEditRules(editRuleFiles);
		
		// Calculate repairs:
		URI uriModelA = ModelDropWidget.getURI(modelAFile);
		URI uriModelB = ModelDropWidget.getURI(modelBFile);
		repairJob = RepairFacade.getRepairs(uriModelA, uriModelB, editRules, settings);
		
		// Show repairs:
		viewer_repairs.setInput(repairJob.getRepairs());
		
		// Clean up repair-trees:
		for (Validation validation : repairJob.getValidations()) {
			validation.cleanUpRepairTree();
		}
		
		// Show validations:
		viewer_validation.setInput(repairJob.getValidations());
	}
	
	@Override
	public void applyRepair(Repair repair) {
		
		// Apply repair:
		repair.apply();
		
		// Save model
		try {
			repairJob.getModelB().save(null);
		} catch (IOException e) {
			e.printStackTrace();
		}
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
}
