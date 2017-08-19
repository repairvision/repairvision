package org.sidiff.repair.history.evaluation.ui;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.henshin.interpreter.RuleApplication;
import org.eclipse.emf.henshin.model.Rule;
import org.eclipse.swt.widgets.Display;
import org.sidiff.consistency.common.storage.UUIDMatcher;
import org.sidiff.consistency.common.ui.util.WorkbenchUtil;
import org.sidiff.difference.technical.api.settings.DifferenceSettings;
import org.sidiff.difference.technical.util.TechnicalDifferenceBuilderUtil;
import org.sidiff.repair.api.IRepairFacade;
import org.sidiff.repair.api.IRepairPlan;
import org.sidiff.repair.api.peo.PEORepairJob;
import org.sidiff.repair.api.peo.PEORepairSettings;
import org.sidiff.repair.history.evaluation.driver.HistoryEvaluationDriver;
import org.sidiff.repair.history.evaluation.driver.InconsistencyEvaluationDriver;
import org.sidiff.repair.history.evaluation.driver.LearnEditRuleDriver;
import org.sidiff.repair.history.evaluation.driver.PrintHistoryInfoDriver;
import org.sidiff.repair.history.evaluation.driver.data.HistoryInfo;
import org.sidiff.repair.history.evaluation.driver.data.RepairedInconsistency;
import org.sidiff.repair.history.evaluation.util.EvaluationUtil;
import org.sidiff.repair.historymodel.History;
import org.sidiff.repair.historymodel.ValidationError;
import org.sidiff.repair.ui.app.IRepairApplication;
import org.sidiff.repair.ui.app.IResultChangedListener;
import org.sidiff.repair.ui.config.RepairPreferencePage;
import org.sidiff.repair.ui.util.EditRuleUtil;

public class HistoryRepairApplication implements IRepairApplication<PEORepairJob, PEORepairSettings> {

	protected IRepairFacade<PEORepairJob, PEORepairSettings> repairFacade;
	
	protected List<IResultChangedListener<PEORepairJob>> listeners = new ArrayList<>();

	protected Collection<IResource> editRuleFiles = new ArrayList<>();
	
	protected Job calculation;
	
	protected HistoryInfo history;
	
	
	protected PEORepairJob repairJob;
	
	public void setHistory(History history) {
		this.history = new HistoryInfo(history);
		PrintHistoryInfoDriver.printHistoryInfo(this.history);
	}
	
	public Object getValidations() {
		return EvaluationUtil.toEObjectList(history
				.getSupportedIntroducedAndResolvedUniqueInconsistencies(), "History");
	}
	
	@Override
	public void initialize(IRepairFacade<PEORepairJob, PEORepairSettings> repairFacade) {
		this.repairFacade = repairFacade;
	}
	
	@Override
	public void addResultChangedListener(IResultChangedListener<PEORepairJob> listener) {
		listeners.add(listener);
	}
	
	@Override
	public void removeResultChangeListener(IResultChangedListener<PEORepairJob> listener) {
		listeners.remove(listener);
	}
	
	protected void fireResultChangeListener() {
		listeners.forEach(l -> l.resultChanged(getRepairJob()));
	}
	
	@Override
	public void clearResultChangeListener() {
		listeners.clear();
	}
	
	@Override
	public void calculateRepairs() {
		
		calculation = new Job("Evaluate History") {
			
			@Override
			protected IStatus run(IProgressMonitor monitor) {
				HistoryEvaluationDriver.calculateRepairs(repairFacade, history, getEditRules(), getMatchingSettings());
				return Status.OK_STATUS;
			}
		};
		
		calculation.schedule();
	}
	
	@Override
	public void recalculateRepairs() {
		
		calculation = new Job("Recalculate Repairs") {
			
			@Override
			protected IStatus run(IProgressMonitor monitor) {
				PEORepairJob lastRepairJob = repairJob;
				
				// Calculate repairs:
				repairJob = repairFacade.getRepairs(
						repairJob.getModelA(), repairJob.getModelB(),
						new PEORepairSettings(getEditRules(), getMatchingSettings()));
				
				// Copy undo history:
				repairJob.copyHistory(lastRepairJob);
				
				// Update UI:
				Display.getDefault().syncExec(() -> {
					
					// Show repairs:
					fireResultChangeListener();
					
					if (repairJob.getRepairs().isEmpty()) {
						WorkbenchUtil.showMessage("No repairs found!");
					}
				});
				
				return Status.OK_STATUS;
			}
		};
		
		calculation.schedule();
	}
	
	public void repairInconsistency(ValidationError selection) {
		
		calculation = new Job("Calculate Repairs") {

			@Override
			protected IStatus run(IProgressMonitor monitor) {

				// Initialize:
				RepairedInconsistency repaired = RepairedInconsistency.createRepairedInconsistency(selection);

				// Calculate repairs:
				repairJob = InconsistencyEvaluationDriver.calculateRepairs(
						true, history, repairFacade, repaired, 
						getEditRules(), getMatchingSettings());

				// Update UI:
				Display.getDefault().syncExec(() -> {
					
					// Show results:
					fireResultChangeListener();

					if (repairJob.getRepairs().isEmpty()) {
						WorkbenchUtil.showMessage("No repairs found!");
					}
				});

				return Status.OK_STATUS;
			}
		};
		
		calculation.schedule();
	}
	
	public void learnEditRule(ValidationError selection) {
		
		calculation = new Job("Learn Edit Rule") {
			
			@Override
			protected IStatus run(IProgressMonitor monitor) {
				RepairedInconsistency repaired = RepairedInconsistency.createRepairedInconsistency(selection);
				LearnEditRuleDriver.learnEditRule(history, getMatchingSettings(), repaired);
				return Status.OK_STATUS;
			}
		};
		
		calculation.schedule();
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
		
		if (calculation.getState() == Job.RUNNING) {
			WorkbenchUtil.showMessage("Please wait for the repair calculation!");
			return null;
		}
		
		return repairJob.undoLastRepairs();
	}

	public IResource removeEditRule(IResource selection) {
		editRuleFiles.remove(selection);
		return selection;
	}
	
	public Collection<Rule> getEditRules() {
		return EditRuleUtil.loadEditRules(editRuleFiles, false);
	}

	@Override
	public PEORepairJob getRepairJob() {
		return repairJob;
	}
	
	public void populateSettings(Resource modelA, Resource modelB) {
		RepairPreferencePage.populateSettings(modelA, modelB);
	}
	
	public DifferenceSettings getMatchingSettings() {
		DifferenceSettings settings = RepairPreferencePage.getMatchingSettings();
		settings.setMatcher(new UUIDMatcher());
		settings.setTechBuilder(TechnicalDifferenceBuilderUtil.getGenericTechnicalDifferenceBuilder());
		
		return settings;
	}
	
	public String getDoumentType() {
		return RepairPreferencePage.getDoumentType();
	}
	
	@Override
	public void clear() {
		editRuleFiles.clear();
		calculation = null;
		history = null;
		repairJob = null;
	}
}
