package org.sidiff.repair.ui.cpo.ruleselection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.henshin.interpreter.RuleApplication;
import org.eclipse.emf.henshin.model.Rule;
import org.eclipse.swt.widgets.Display;
import org.sidiff.common.ui.WorkbenchUtil;
import org.sidiff.difference.technical.api.settings.DifferenceSettings;
import org.sidiff.repair.api.IRepair;
import org.sidiff.repair.api.IRepairFacade;
import org.sidiff.repair.api.cpo.CPORepairJob;
import org.sidiff.repair.api.cpo.CPORepairSettings;
import org.sidiff.repair.ui.app.impl.BasicRepairApplication;
import org.sidiff.repair.ui.controls.impl.ModelDropWidget;
import org.sidiff.repair.ui.util.EditRuleUtil;

public class CPORepairApplication extends BasicRepairApplication<CPORepairJob, CPORepairSettings> {
	
	private IRepairFacade<CPORepairJob, CPORepairSettings> repairFacade;
	
	private Collection<IResource> subEditRuleFiles = new ArrayList<>();

	private Collection<IResource> cpEditRuleFiles = new ArrayList<>();
	
	private Job repairCalculation;
	
	private CPORepairJob repairJob;
	
	private DifferenceSettings settings;
	
	private Collection<Rule> subEditRules;
	
	private Collection<Rule> cpEditRules;
	
	@Override
	public void initialize(IRepairFacade<CPORepairJob, CPORepairSettings> repairFacade) {
		this.repairFacade = repairFacade;
	}

	@Override
	public void calculateRepairs() {
		
		repairCalculation = new Job("Calculate Repairs") {
			
			@Override
			protected IStatus run(IProgressMonitor monitor) {
				
				// Matching-Settings:
				settings = getMatchingSettings();
				
				// Load edit-rules:
				subEditRules = EditRuleUtil.loadEditRules(subEditRuleFiles, true);
				cpEditRules = EditRuleUtil.loadEditRules(cpEditRuleFiles, true);
				
				// Calculate repairs:
				if (!subEditRules.isEmpty() && !cpEditRules.isEmpty()) {
					URI uriModelA = ModelDropWidget.getURI(modelAFile);
					URI uriModelB = ModelDropWidget.getURI(modelBFile);
					
					repairJob = repairFacade.getRepairs(uriModelA, uriModelB, 
							new CPORepairSettings(subEditRules, cpEditRules, documentType, settings));
					
					// Update UI:
					Display.getDefault().syncExec(() -> {

						// Show repairs:
						fireResultChangeListener();
						
						if (repairJob.getRepairs().isEmpty()) {
							WorkbenchUtil.showMessage("No repairs found!");
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
					CPORepairJob lastRepairJob = repairJob;
					
					repairJob = repairFacade.getRepairs(repairJob.getModelA(), repairJob.getModelB(),
							new CPORepairSettings(subEditRules, cpEditRules, documentType, settings));
					
					// Copy undo history:
					repairJob.copyHistory(lastRepairJob);
					
					// Update UI:
					Display.getDefault().syncExec(() -> {

						// Show repairs:
						fireResultChangeListener();
						
						if (repairJob.getRepairs().isEmpty()) {
							WorkbenchUtil.showMessage("No further repairs found!");
						}
					});
				}
				
				return Status.OK_STATUS;
			}
		};
		
		repairCalculation.schedule();
	}

	@Override
	public boolean applyRepairs(List<IRepair> repair) {
		return (repairJob.applyRepairs(repair) != null);
	}
	
	@Override
	public List<RuleApplication> undoLastRepairs() {
		
		if (repairJob == null) {
			WorkbenchUtil.showMessage("Please start the repair calculation!");
			return null;
		}
		
		if (repairCalculation.getState() == Job.RUNNING) {
			WorkbenchUtil.showMessage("Please wait for the repair calculation!");
			return null;
		}
		
		return repairJob.undoLastRepairs();
	}

	public IResource removeSubEditRule(IResource selection) {
		subEditRuleFiles.remove(selection);
		return selection;
	}

	public IResource addSubEditRule(IResource element) {
		element = EditRuleUtil.getEditRule(element);
		
		if ((element != null) && !subEditRuleFiles.contains(element)) {
			subEditRuleFiles.add(element);
			return element;
		}

		return null;
	}
	
	public IResource removeCPEditRule(IResource selection) {
		cpEditRuleFiles.remove(selection);
		return selection;
	}

	public IResource addCPEditRule(IResource element) {
		element = EditRuleUtil.getEditRule(element);
		
		if ((element != null) && !cpEditRuleFiles.contains(element)) {
			cpEditRuleFiles.add(element);
			return element;
		}

		return null;
	}
	
	@Override
	public CPORepairJob getRepairJob() {
		return repairJob;
	}
	
	@Override
	public void clear() {
		super.clear();
		subEditRuleFiles.clear();
		cpEditRuleFiles.clear();
		repairCalculation = null;
		repairJob = null;
		settings = null;
		subEditRules = null;
		cpEditRules = null; 
	}
}
