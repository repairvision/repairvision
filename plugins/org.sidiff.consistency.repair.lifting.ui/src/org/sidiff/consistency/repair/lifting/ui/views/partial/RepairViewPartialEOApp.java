package org.sidiff.consistency.repair.lifting.ui.views.partial;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.henshin.interpreter.RuleApplication;
import org.eclipse.emf.henshin.model.Rule;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.widgets.Display;
import org.sidiff.consistency.common.ui.WorkbenchUtil;
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
	
	private Job repairCalculation;
	
	private RepairJob repairJob;
	
	private DifferenceSettings settings;
	
	private Collection<Rule> editRules;
	
	public RepairViewPartialEOApp(TreeViewer viewer_repairs) {
		super(viewer_repairs);
	}
	
	public void setValidationViewer(TreeViewer viewer_validation) {
		this.viewer_validation = viewer_validation;
	}
	
	@Override
	public void calculateRepairs() {
		
		repairCalculation = new Job("Calculate Repairs") {
			
			@Override
			protected IStatus run(IProgressMonitor monitor) {
				
				// Matching-Settings:
				settings = getMatchingSettings();
				
				// Load edit-rules:
				editRules = loadEditRules(editRuleFiles);
				
				// Calculate repairs:
				URI uriModelA = ModelDropWidget.getURI(modelAFile);
				URI uriModelB = ModelDropWidget.getURI(modelBFile);
				repairJob = RepairFacade.getRepairs(uriModelA, uriModelB, editRules, settings);
				
				// Update UI:
				Display.getDefault().syncExec(() -> {
					
					// Show repairs:
					if (repairJob.getRepairs().isEmpty()) {
						WorkbenchUtil.showMessage("No repairs found!");
						viewer_repairs.setInput(null);
					} else {
						viewer_repairs.setInput(repairJob.getRepairs());
					}

					// Show repairs:
					viewer_repairs.setInput(repairJob.getRepairs());
					
					// Clean up repair-trees:
					for (Validation validation : repairJob.getValidations()) {
						validation.cleanUpRepairTree();
					}
					
					// Show validations:
					viewer_validation.setInput(repairJob.getValidations());
				});
				
				return Status.OK_STATUS;
			}
		};
		
		repairCalculation.schedule();
	}
	
	@Override
	public void recalculateRepairs() {
		
		repairCalculation = new Job("Recalculate Repairs") {
			
			@Override
			protected IStatus run(IProgressMonitor monitor) {
				RepairJob lastRepairJob = repairJob;
				
				// Calculate repairs:
				repairJob = RepairFacade.getRepairs(
						repairJob.getModelA(), repairJob.getModelB(),
						editRules, settings);
				
				// Copy undo history:
				repairJob.copyHistory(lastRepairJob);
				
				// Update UI:
				Display.getDefault().syncExec(() -> {
					
					// Show repairs:
					if (repairJob.getRepairs().isEmpty()) {
						WorkbenchUtil.showMessage("No repairs found!");
						viewer_repairs.setInput(null);
					} else {
						viewer_repairs.setInput(repairJob.getRepairs());
					}

					// Show repairs:
					viewer_repairs.setInput(repairJob.getRepairs());
					
					// Clean up repair-trees:
					for (Validation validation : repairJob.getValidations()) {
						validation.cleanUpRepairTree();
					}
					
					// Show validations:
					viewer_validation.setInput(repairJob.getValidations());
				});
				
				return Status.OK_STATUS;
			}
		};
		
		repairCalculation.schedule();
	}
	
	@Override
	public boolean applyRepair(Repair repair) {
		return (repairJob.applyRepair(repair) != null);
	}
	
	@Override
	public RuleApplication undoLastRepair() {
		
		if (repairCalculation == null) {
			WorkbenchUtil.showMessage("Please start the repair calculation!");
			return null;
		}
		
		if (repairCalculation.getState() == Job.RUNNING) {
			WorkbenchUtil.showMessage("Please wait for the repair calculation!");
			return null;
		}
		
		return repairJob.undoLastRepair();
	}

	public IResource removeEditRule(IResource selection) {
		editRuleFiles.remove(selection);
		return selection;
	}

	public IResource addEditRule(IResource element) {
		
		if ((element != null) && !editRuleFiles.contains(element)) {
			
			if (element.getFileExtension().equalsIgnoreCase("henshin")) {
				editRuleFiles.add(element);
				return element;
			} 
			
			else if (element.getFileExtension().equalsIgnoreCase("henshin_diagram")) {
				int extension = element.getLocationURI().getPath().lastIndexOf(".");
				IPath rulePath = Path.fromOSString(element.getLocationURI().getPath().substring(0, extension) + ".henshin");
				
				IResource rule = ResourcesPlugin.getWorkspace().getRoot().getFileForLocation(rulePath);
				return addEditRule(rule);
			}
		}

		return null;
	}
	
	@Override
	public void clear() {
		super.clear();
		editRuleFiles.clear();
		repairJob = null;
	}
}
