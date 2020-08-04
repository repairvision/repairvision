package org.sidiff.revision.repair.ui.peo.ruleselection;

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
import org.sidiff.common.utilities.ui.util.WorkbenchUtil;
import org.sidiff.revision.api.IComplementationFacade;
import org.sidiff.revision.api.IComplementationPlan;
import org.sidiff.revision.difference.api.settings.DifferenceSettings;
import org.sidiff.revision.editrules.project.registry.util.RulebaseUtil;
import org.sidiff.revision.repair.api.peo.PEORepairCalculationEngineDebugger;
import org.sidiff.revision.repair.api.peo.PEORepairJob;
import org.sidiff.revision.repair.api.peo.configuration.PEORepairSettings;
import org.sidiff.revision.repair.ui.app.impl.EclipseResourceRepairApplication;
import org.sidiff.revision.repair.ui.peo.debugger.EditRuleMatcherDebugger;
import org.sidiff.validation.constraint.api.ValidationFacade;
import org.sidiff.validation.constraint.api.util.RepairValidation;
import org.sidiff.validation.constraint.api.util.Validation;

public class RuleSelectionRepairApplication extends EclipseResourceRepairApplication<PEORepairJob, PEORepairSettings> {

	private boolean debugging = false;
	
	private Job modelValidation;
	
	private Job repairCalculation;
	
	private IComplementationFacade<PEORepairJob, PEORepairSettings> complementationFacade;

	private Collection<IResource> editRuleFiles = new ArrayList<>();
	
	private DifferenceSettings settings;
	
	private Collection<Rule> editRules;
	
	private Validation inconsistency;
	
	private List<Validation> validations;
	
	private PEORepairJob repairJob;
	
	private PEORepairSettings repairSettings;
	
	@Override
	public void initialize(IComplementationFacade<PEORepairJob, PEORepairSettings> repairFacade) {
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
	public void calculateRepairs() {
		
		repairCalculation = new Job("Calculate Repairs") {
			
			@Override
			protected IStatus run(IProgressMonitor monitor) {
				PEORepairJob lastRepairJob = repairJob;
				
				// Matching-Settings:
				settings = getMatchingSettings();
				
				// Load edit-rules:
				editRules = RulebaseUtil.loadEditRules(editRuleFiles, true, false);
				
				// Calculate repairs:
				repairCalculation.setName("Calculate Repairs");
				
				repairSettings = new PEORepairSettings(
						Collections.singletonList(inconsistency.getContext()), editRules, settings);
				repairSettings.setConsistencyRules(Collections.singletonList(inconsistency.getRule()));
				repairSettings.setSaveDifference(true);
				
				if (debugging) {
					PEORepairCalculationEngineDebugger debugger = new PEORepairCalculationEngineDebugger(repairSettings, getModelA(), getModelB()); 
					
					IViewPart debuggingView = WorkbenchUtil.showView("org.sidiff.revision.repair.ui.peo.debugger.EditRuleMatcherDebugger");
					
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
	public void recalculateRepairs() {
		
		repairCalculation = new Job("Recalculate Repairs") {
			
			@Override
			protected IStatus run(IProgressMonitor monitor) {
				if (inconsistency.getContext().eContainer() != null) {
					PEORepairJob lastRepairJob = repairJob;
					
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
	
	public PEORepairSettings getRepairSettings() {
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
	public boolean applyRepair(IComplementationPlan repair, Match match) {
		return repairJob.applyComplement(repair, match, true);
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
		
		return repairJob.undoUncomplete(true);
	}
	
	@Override
	public boolean rollbackInconsistencyInducingChanges(IComplementationPlan repair) {
		return repairJob.rollbackInconsistencyInducingChanges(repair, true);
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
