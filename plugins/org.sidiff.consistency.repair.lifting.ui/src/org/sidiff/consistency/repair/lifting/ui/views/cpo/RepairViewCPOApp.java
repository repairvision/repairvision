package org.sidiff.consistency.repair.lifting.ui.views.cpo;

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
import org.sidiff.consistency.repair.lifting.api.RepairJob;
import org.sidiff.consistency.repair.lifting.cpo.CPORepairFacade;
import org.sidiff.consistency.repair.lifting.ui.views.ModelDropWidget;
import org.sidiff.consistency.repair.lifting.ui.views.RepairViewBasicApp;
import org.sidiff.difference.technical.api.settings.DifferenceSettings;

public class RepairViewCPOApp extends RepairViewBasicApp {
	
	private Collection<IResource> subEditRuleFiles = new ArrayList<>();

	private Collection<IResource> cpEditRuleFiles = new ArrayList<>();
	
	private Job repairCalculation;
	
	private RepairJob repairJob;
	
	private DifferenceSettings settings;
	
	private Collection<Rule> subEditRules;
	
	private Collection<Rule> cpEditRules;
	
	public RepairViewCPOApp(TreeViewer viewer_repairs) {
		super(viewer_repairs);
	}

	@Override
	public void calculateRepairs() {
		
		repairCalculation = new Job("Calculate Repairs") {
			
			@Override
			protected IStatus run(IProgressMonitor monitor) {
				
				// Matching-Settings:
				settings = getMatchingSettings();
				
				// Load edit-rules:
				subEditRules = loadEditRules(subEditRuleFiles);
				cpEditRules = loadEditRules(cpEditRuleFiles);
				
				// Calculate repairs:
				if (!subEditRules.isEmpty() && !cpEditRules.isEmpty()) {
					URI uriModelA = ModelDropWidget.getURI(modelAFile);
					URI uriModelB = ModelDropWidget.getURI(modelBFile);
					
					repairJob = CPORepairFacade.getRepairs(
							uriModelA, uriModelB, 
							subEditRules, cpEditRules, 
							documentType, settings);
					
					// Update UI:
					Display.getDefault().syncExec(() -> {

						// Show repairs:
						if (repairJob.getRepairs().isEmpty()) {
							WorkbenchUtil.showMessage("No repairs found!");
							viewer_repairs.setInput(null);
						} else {
							viewer_repairs.setInput(repairJob.getRepairs());
						}
					});
				}
				
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
				
				// Calculate repairs:
				if (!subEditRules.isEmpty() && !cpEditRules.isEmpty()) {
					RepairJob lastRepairJob = repairJob;
					
					repairJob = CPORepairFacade.getRepairs(
							repairJob.getModelA(), repairJob.getModelB(), 
							subEditRules, cpEditRules, 
							documentType, settings);
					
					// Copy undo history:
					repairJob.copyHistory(lastRepairJob);
					
					// Update UI:
					Display.getDefault().syncExec(() -> {

						// Show repairs:
						if (repairJob.getRepairs().isEmpty()) {
							WorkbenchUtil.showMessage("No further repairs found!");
							viewer_repairs.setInput(null);
						} else {
							viewer_repairs.setInput(repairJob.getRepairs());
						}
					});
				}
				
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

	public IResource removeSubEditRule(IResource selection) {
		subEditRuleFiles.remove(selection);
		return selection;
	}

	public IResource addSubEditRule(IResource element) {
		
		if ((element != null) && !subEditRuleFiles.contains(element)) {
			
			if (element.getFileExtension().equalsIgnoreCase("henshin")) {
				subEditRuleFiles.add(element);
				return element;
			} 
			
			else if (element.getFileExtension().equalsIgnoreCase("henshin_diagram")) {
				int extension = element.getLocationURI().getPath().lastIndexOf(".");
				IPath rulePath = Path.fromOSString(element.getLocationURI().getPath().substring(0, extension) + ".henshin");
				
				IResource rule = ResourcesPlugin.getWorkspace().getRoot().getFileForLocation(rulePath);
				return addSubEditRule(rule);
			}
		}

		return null;
	}
	
	public IResource removeCPEditRule(IResource selection) {
		cpEditRuleFiles.remove(selection);
		return selection;
	}

	public IResource addCPEditRule(IResource element) {
		
		if ((element != null) && !cpEditRuleFiles.contains(element)) {
			
			if (element.getFileExtension().equalsIgnoreCase("henshin")) {
				cpEditRuleFiles.add(element);
				return element;
			} 
			
			else if (element.getFileExtension().equalsIgnoreCase("henshin_diagram")) {
				int extension = element.getLocationURI().getPath().lastIndexOf(".");
				IPath rulePath = Path.fromOSString(element.getLocationURI().getPath().substring(0, extension) + ".henshin");
				
				IResource rule = ResourcesPlugin.getWorkspace().getRoot().getFileForLocation(rulePath);
				return addCPEditRule(rule);
			}
		}

		return null;
	}
	
	@Override
	public void clear() {
		super.clear();
		subEditRuleFiles.clear();
		cpEditRuleFiles.clear();
		repairJob = null;
	}
}
