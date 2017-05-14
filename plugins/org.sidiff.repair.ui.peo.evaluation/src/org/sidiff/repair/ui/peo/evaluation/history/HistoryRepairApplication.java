package org.sidiff.repair.ui.peo.evaluation.history;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.henshin.interpreter.RuleApplication;
import org.eclipse.emf.henshin.model.Rule;
import org.eclipse.swt.widgets.Display;
import org.sidiff.common.ui.WorkbenchUtil;
import org.sidiff.difference.technical.api.settings.DifferenceSettings;
import org.sidiff.repair.api.IRepairPlan;
import org.sidiff.repair.api.IRepairFacade;
import org.sidiff.repair.api.peo.PEORepairJob;
import org.sidiff.repair.api.peo.PEORepairSettings;
import org.sidiff.repair.ui.app.impl.EMFResourceRepairApplication;
import org.sidiff.repair.ui.util.EditRuleUtil;
import org.sidiff.repair.validation.util.Validation;

public abstract class HistoryRepairApplication extends EMFResourceRepairApplication<PEORepairJob, PEORepairSettings> {

	protected IRepairFacade<PEORepairJob, PEORepairSettings> repairFacade;

	protected Collection<IResource> editRuleFiles = new ArrayList<>();
	
	protected Job repairCalculation;
	
	protected PEORepairJob repairJob;
	
	protected DifferenceSettings settings;
	
	protected Collection<Rule> editRules;
	
	@Override
	public void initialize(IRepairFacade<PEORepairJob, PEORepairSettings> repairFacade) {
		this.repairFacade = repairFacade;
	}
	
	public void calculateRepairsForInconsistency() {
		
		repairCalculation = new Job("Calculate Repairs") {
			
			@Override
			protected IStatus run(IProgressMonitor monitor) {
				
				// Matching-Settings:
				settings = getMatchingSettings();
				
				// Load edit-rules:
				editRules = EditRuleUtil.loadEditRules(editRuleFiles, false);
				
				// Calculate repairs:
				repairJob = repairFacade.getRepairs(modelA, modelB,
						new PEORepairSettings(editRules, settings));
				
				// Update UI:
				Display.getDefault().syncExec(() -> {
					
					// Clean up repair-trees:
					for (Validation validation : repairJob.getValidations()) {
						validation.cleanUpRepairTree();
					}
					
					// Show repairs:
					fireResultChangeListener();
					
					if (repairJob.getRepairs().isEmpty()) {
						WorkbenchUtil.showMessage("No repairs found!");
					}
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
				PEORepairJob lastRepairJob = repairJob;
				
				// Calculate repairs:
				repairJob = repairFacade.getRepairs(
						repairJob.getModelA(), repairJob.getModelB(),
						new PEORepairSettings(editRules, settings));
				
				// Copy undo history:
				repairJob.copyHistory(lastRepairJob);
				
				// Update UI:
				Display.getDefault().syncExec(() -> {
					
					// Clean up repair-trees:
					for (Validation validation : repairJob.getValidations()) {
						validation.cleanUpRepairTree();
					}
					
					// Show repairs:
					fireResultChangeListener();
					
					if (repairJob.getRepairs().isEmpty()) {
						WorkbenchUtil.showMessage("No repairs found!");
					}
				});
				
				return Status.OK_STATUS;
			}
		};
		
		repairCalculation.schedule();
	}
	
	public IResource addEditRule(IResource element) {
		element = EditRuleUtil.getEditRule(element);
		
		if ((element != null) && !editRuleFiles.contains(element)) {
			editRuleFiles.add(element);
			return element;
		}

		return null;
	}
	
	@Override
	public boolean applyRepairs(List<IRepairPlan> repair) {
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

	public IResource removeEditRule(IResource selection) {
		editRuleFiles.remove(selection);
		return selection;
	}

	@Override
	public PEORepairJob getRepairJob() {
		return repairJob;
	}
	
	@Override
	public void clear() {
		super.clear();
		editRuleFiles.clear();
		repairCalculation = null;
		repairJob = null;
		settings = null;
		editRules = null;
	}
}
