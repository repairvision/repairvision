package org.sidiff.repair.ui.peo.ruleselection;

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
import org.sidiff.repair.api.peo.PEORepairJob;
import org.sidiff.repair.api.peo.PEORepairSettings;
import org.sidiff.common.ui.WorkbenchUtil;
import org.sidiff.difference.technical.api.settings.DifferenceSettings;
import org.sidiff.repair.api.IRepair;
import org.sidiff.repair.api.IRepairFacade;
import org.sidiff.repair.ui.app.impl.BasicRepairApplication;
import org.sidiff.repair.ui.controls.impl.ModelDropWidget;
import org.sidiff.repair.ui.util.EditRuleUtil;
import org.sidiff.repair.validation.util.Validation;

public class PEORepairApplication extends BasicRepairApplication<PEORepairJob, PEORepairSettings> {

	private IRepairFacade<PEORepairJob, PEORepairSettings> repairFacade;

	private Collection<IResource> editRuleFiles = new ArrayList<>();
	
	private Job repairCalculation;
	
	private PEORepairJob repairJob;
	
	private DifferenceSettings settings;
	
	private Collection<Rule> editRules;
	
	@Override
	public void initialize(IRepairFacade<PEORepairJob, PEORepairSettings> repairFacade) {
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
				editRules = EditRuleUtil.loadEditRules(editRuleFiles);
				
				// Calculate repairs:
				URI uriModelA = ModelDropWidget.getURI(modelAFile);
				URI uriModelB = ModelDropWidget.getURI(modelBFile);
				repairJob = repairFacade.getRepairs(uriModelA, uriModelB,
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
