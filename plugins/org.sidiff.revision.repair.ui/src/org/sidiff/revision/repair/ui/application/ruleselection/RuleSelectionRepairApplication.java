package org.sidiff.revision.repair.ui.application.ruleselection;

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
import org.sidiff.revision.api.ComplementationFacade;
import org.sidiff.revision.api.ComplementationPlan;
import org.sidiff.revision.common.ui.workbench.WorkbenchUtil;
import org.sidiff.revision.difference.api.settings.DifferenceSettings;
import org.sidiff.revision.editrules.project.registry.util.RulebaseUtil;
import org.sidiff.revision.repair.api.RepairCalculationEngineDebugger;
import org.sidiff.revision.repair.api.RepairJob;
import org.sidiff.revision.repair.api.configuration.RepairSettings;
import org.sidiff.revision.repair.ui.applications.basic.EclipseResourceRepairApplication;
import org.sidiff.revision.repair.ui.debugger.EditRuleMatcherDebugger;
import org.sidiff.validation.constraint.api.ValidationFacade;
import org.sidiff.validation.constraint.api.util.RepairValidation;
import org.sidiff.validation.constraint.api.util.Validation;

public class RuleSelectionRepairApplication extends EclipseResourceRepairApplication<RepairJob, RepairSettings> {

	private boolean debugging = false;
	
	private Job modelValidation;
	
	private Job repairCalculation;
	
	private ComplementationFacade<RepairJob, RepairSettings> complementationFacade;

	private Collection<IResource> editRuleFiles = new ArrayList<>();
	
	private DifferenceSettings settings;
	
	private Collection<Rule> editRules;
	
	private Validation inconsistency;
	
	private List<Validation> validations;
	
	private RepairJob repairJob;
	
	private RepairSettings repairSettings;
	
	@Override
	public void initialize(ComplementationFacade<RepairJob, RepairSettings> repairFacade) {
		this.complementationFacade = repairFacade;
	}
	
	@Override
	public void validation() {
		
		// Clear old repair job:
		inconsistency = null;
		validations = null;
		
		// TODO: Manage repair stack by the application not the repair job!
		if ((repairJob != null) && getModelB() != repairJob.getRevision().getVersionB().getTargetResource()) {
			repairJob = null;
		} else {
			if (repairJob != null) {
				repairJob.setComplementationPlans(new ArrayList<>());
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
				validations = ValidationFacade.validate(
						getModelB().getAllContents(),
						ValidationFacade.getConstraints(getModelB()));
				
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
	public void calculateComplementations() {
		
		repairCalculation = new Job("Calculate Repairs") {
			
			@Override
			protected IStatus run(IProgressMonitor monitor) {
				RepairJob lastRepairJob = repairJob;
				
				// Matching-Settings:
				settings = getMatchingSettings();
				
				// Load edit-rules:
				editRules = RulebaseUtil.loadEditRules(editRuleFiles, true, false);
				
				// Calculate repairs:
				repairCalculation.setName("Calculate Repairs");
				
				repairSettings = new RepairSettings(
						Collections.singletonList(inconsistency.getContext()), editRules, settings);
				repairSettings.setConsistencyRules(Collections.singletonList(inconsistency.getRule()));
				repairSettings.setSaveDifference(true);
				
				if (debugging) {
					RepairCalculationEngineDebugger debugger = new RepairCalculationEngineDebugger(repairSettings, getModelA(), getModelB()); 
					
					IViewPart debuggingView = WorkbenchUtil.showView("org.sidiff.revision.repair.ui.debugger.EditRuleMatcherDebugger");
					
					if (debuggingView instanceof EditRuleMatcherDebugger) {
						((EditRuleMatcherDebugger) debuggingView).setDebugger(debugger);
					}
					
					repairJob = debugger.getRepairs();
				} else {
					repairJob = complementationFacade.getComplementations(getModelA(), getModelB(), repairSettings);
				}
				
				// Copy undo history:
				if (lastRepairJob != null) {
					repairJob.copyHistory(lastRepairJob);
				}
				
				// Update UI:
				Display.getDefault().syncExec(() -> {
					
					// Clean up repair-trees:
					validations = new ArrayList<>(repairJob.getValidations());
					
					for (Validation validation : repairJob.getValidations()) {
						if (validation instanceof RepairValidation) {
							((RepairValidation) validation).cleanUpRepairTree();
						}
					}
					
					// Show repairs:
					fireResultChangeListener();
					
					if (repairJob.getComplementationPlans().isEmpty()) {
						WorkbenchUtil.showMessage("No repairs found!");
					}
				});
				
				return Status.OK_STATUS;
			}
		};
		
		repairCalculation.schedule();
	}
	
	@Override
	public void recalculateComplementations() {
		
		repairCalculation = new Job("Recalculate Repairs") {
			
			@Override
			protected IStatus run(IProgressMonitor monitor) {
				if (inconsistency.getContext().eContainer() != null) {
					RepairJob lastRepairJob = repairJob;
					
					// Calculate repairs:
					repairJob = complementationFacade.getComplementations(
							repairJob.getRevision().getVersionA().getTargetResource(), 
							repairJob.getRevision().getVersionB().getTargetResource(),
							repairSettings);
					
					// Copy undo history:
					if (lastRepairJob != null) {
						repairJob.copyHistory(lastRepairJob);
					}
					
					// Update UI:
					Display.getDefault().syncExec(() -> {
						
						// Clean up repair-trees:
						for (Validation validation : repairJob.getValidations()) {
							if (validation instanceof RepairValidation) {
								((RepairValidation) validation).cleanUpRepairTree();
							}
						}
						
						// Show repairs:
						fireResultChangeListener();
						
						if (repairJob.getComplementationPlans().isEmpty()) {
							WorkbenchUtil.showMessage("No repairs found!");
						}
					});
				}
				
				return Status.OK_STATUS;
			}
		};
		
		repairCalculation.schedule();
	}
	
	public RepairSettings getRepairSettings() {
		return repairSettings;
	}
	
	public IResource addEditRule(IResource element) {
		element = RulebaseUtil.getEditRule(element);
		
		if ((element != null) && !editRuleFiles.contains(element)) {
			editRuleFiles.add(element);
			return element;
		}

		return null;
	}
	
	@Override
	public boolean applyComplementation(ComplementationPlan repair, Match match) {
		return repairJob.applyComplement(repair, match, true);
	}
	
	@Override
	public boolean undoComplementation() {
		
		if (repairJob == null) {
			WorkbenchUtil.showMessage("Please start the repair calculation!");
			return false;
		}
		
		if (repairCalculation.getState() == Job.RUNNING) {
			WorkbenchUtil.showMessage("Please wait for the repair calculation!");
			return false;
		}
		
		return repairJob.undoLast(true);
	}
	
	@Override
	public boolean rollbackIncomplete(ComplementationPlan repair) {
		return repairJob.rollbackIncomplete(repair, true);
	}

	public IResource removeEditRule(IResource selection) {
		editRuleFiles.remove(selection);
		return selection;
	}

	@Override
	public RepairJob getComplementationJob() {
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
