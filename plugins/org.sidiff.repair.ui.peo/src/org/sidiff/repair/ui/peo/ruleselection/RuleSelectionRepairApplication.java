package org.sidiff.repair.ui.peo.ruleselection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.henshin.interpreter.Match;
import org.eclipse.emf.henshin.model.Rule;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IViewPart;
import org.sidiff.consistency.common.ui.util.WorkbenchUtil;
import org.sidiff.difference.technical.api.settings.DifferenceSettings;
import org.sidiff.repair.api.IRepairFacade;
import org.sidiff.repair.api.IRepairPlan;
import org.sidiff.repair.api.peo.PEORepairCalculationEngineDebugger;
import org.sidiff.repair.api.peo.PEORepairJob;
import org.sidiff.repair.api.peo.PEORepairSettings;
import org.sidiff.repair.ui.app.impl.EclipseResourceRepairApplication;
import org.sidiff.repair.ui.peo.debugger.EditRuleMatcherDebugger;
import org.sidiff.repair.ui.util.EditRuleUtil;
import org.sidiff.validation.constraint.api.ValidationFacade;
import org.sidiff.validation.constraint.api.util.RepairValidation;
import org.sidiff.validation.constraint.api.util.Validation;

public class RuleSelectionRepairApplication extends EclipseResourceRepairApplication<PEORepairJob, PEORepairSettings> {

	private boolean debugging = false;
	
	private Job modelValidation;
	
	private Job repairCalculation;
	
	private IRepairFacade<PEORepairJob, PEORepairSettings> repairFacade;

	private Collection<IResource> editRuleFiles = new ArrayList<>();
	
	private DifferenceSettings settings;
	
	private Collection<Rule> editRules;
	
	private Validation inconsistency;
	
	private List<Validation> validations;
	
	private PEORepairJob repairJob;
	
	private PEORepairSettings repairSettings;
	
	@Override
	public void initialize(IRepairFacade<PEORepairJob, PEORepairSettings> repairFacade) {
		this.repairFacade = repairFacade;
	}
	
	@Override
	public void validation() {
		
		// Clear old repair job:
		inconsistency = null;
		validations = null;
		
		// TODO: Manage repair stack by the application not the repair job!
		if ((repairJob != null) && getModelB() != repairJob.getModelB()) {
			repairJob = null;
		} else {
			if (repairJob != null) {
				repairJob.setRepairs(new ArrayList<>());
			}
		}
		
		// Model validation:
		modelValidation();
	}
	
	private void modelValidation() {
		
		// Model validation:
		modelValidation = new Job("Model Validation") {
			
			@Override
			protected IStatus run(IProgressMonitor monitor) {
				
				// Search inconsistencies:
				validations = ValidationFacade.validate(getModelB());
				
				// Update UI:
				Display.getDefault().syncExec(() -> {
					fireResultChangeListener();
				});
				
				return Status.OK_STATUS;
			}
		};
		
		modelValidation.schedule();
	}
	
	@Override
	public void calculateRepairs() {
		
		repairCalculation = new Job("Calculate Repairs") {
			
			@Override
			protected IStatus run(IProgressMonitor monitor) {
				PEORepairJob lastRepairJob = repairJob;
				
				// Matching-Settings:
				settings = getMatchingSettings();
				
				// Load edit-rules:
				editRules = EditRuleUtil.loadEditRules(editRuleFiles, true, false);
				
				// Calculate repairs:
				repairCalculation.setName("Calculate Repairs");
				
				repairSettings = new PEORepairSettings(editRules, settings);
				repairSettings.setSaveRecognitionRules(debugging);
				repairSettings.setupValidationFilter(
						Collections.singletonList(inconsistency.getContext()),
						Collections.singletonList(inconsistency.getRule()));
				repairSettings.setSaveDifference(true);
				
				if (debugging) {
					PEORepairCalculationEngineDebugger debugger = new PEORepairCalculationEngineDebugger(repairSettings, getModelA(), getModelB()); 
					
					IViewPart debuggingView = WorkbenchUtil.showView("org.sidiff.repair.ui.peo.debugger.EditRuleMatcherDebugger");
					
					if (debuggingView instanceof EditRuleMatcherDebugger) {
						((EditRuleMatcherDebugger) debuggingView).setDebugger(debugger);
					}
					
					repairJob = debugger.getRepairs();
				} else {
					repairJob = repairFacade.getRepairs(getModelA(), getModelB(), repairSettings);
				}
				
				// Copy undo history:
				if (lastRepairJob != null) {
					repairJob.copyHistory(lastRepairJob);
				}
				
				// Update UI:
				Display.getDefault().syncExec(() -> {
					
					// Clean up repair-trees:
					validations = new ArrayList<>(repairJob.getValidations());
					
					for (RepairValidation validation : repairJob.getValidations()) {
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
				if (lastRepairJob != null) {
					repairJob.copyHistory(lastRepairJob);
				}
				
				// Update UI:
				Display.getDefault().syncExec(() -> {
					
					// Clean up repair-trees:
					for (RepairValidation validation : repairJob.getValidations()) {
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
	
	public PEORepairSettings getRepairSettings() {
		return repairSettings;
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
	public boolean applyRepair(IRepairPlan repair, Match match) {
		return repairJob.applyRepair(repair, match, true);
	}
	
	@Override
	public boolean undoRepair() {
		
		if (repairJob == null) {
			WorkbenchUtil.showMessage("Please start the repair calculation!");
			return false;
		}
		
		if (repairCalculation.getState() == Job.RUNNING) {
			WorkbenchUtil.showMessage("Please wait for the repair calculation!");
			return false;
		}
		
		return repairJob.undoRepair(true);
	}

	public IResource removeEditRule(IResource selection) {
		editRuleFiles.remove(selection);
		return selection;
	}

	@Override
	public PEORepairJob getRepairJob() {
		return repairJob;
	}
	
	public Validation getInconsistency() {
		return inconsistency;
	}
	
	public void setInconsistency(Validation inconsistency) {
		this.inconsistency = inconsistency;
	}
	
	public List<Validation> getValidations() {
		return validations;
	}
	
	public boolean isDebugging() {
		return debugging;
	}
	
	public void setDebugging(boolean debugging) {
		this.debugging = debugging;
	}
	
	@Override
	public void clear() {
		super.clear();
		debugging = false;
		editRuleFiles.clear();
		modelValidation = null;
		repairCalculation = null;
		repairJob = null;
		settings = null;
		editRules = null;
		inconsistency = null;
		validations = null;
	}
}
