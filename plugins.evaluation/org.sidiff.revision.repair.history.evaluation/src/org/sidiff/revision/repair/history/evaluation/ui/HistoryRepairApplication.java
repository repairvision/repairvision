package org.sidiff.revision.repair.history.evaluation.ui;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.henshin.interpreter.Match;
import org.eclipse.emf.henshin.model.Rule;
import org.eclipse.swt.widgets.Display;
import org.sidiff.generic.matcher.uuid.UUIDMatcherProvider;
import org.sidiff.history.analysis.tracing.InconsistencyTrace;
import org.sidiff.historymodel.History;
import org.sidiff.historymodel.Problem;
import org.sidiff.revision.api.ComplementationFacade;
import org.sidiff.revision.api.ComplementationPlan;
import org.sidiff.revision.common.logging.table.LogTable;
import org.sidiff.revision.common.ui.workbench.WorkbenchUtil;
import org.sidiff.revision.difference.api.registry.DifferenceBuilderRegistry;
import org.sidiff.revision.difference.api.settings.DifferenceSettings;
import org.sidiff.revision.editrules.project.registry.util.RulebaseUtil;
import org.sidiff.revision.repair.api.RepairJob;
import org.sidiff.revision.repair.api.configuration.RepairSettings;
import org.sidiff.revision.repair.history.evaluation.driver.HistoryEvaluationDriver;
import org.sidiff.revision.repair.history.evaluation.driver.InconsistencyEvaluationDriver;
import org.sidiff.revision.repair.history.evaluation.driver.PrintHistoryInfoDriver;
import org.sidiff.revision.repair.history.evaluation.driver.data.HistoryInfo;
import org.sidiff.revision.repair.history.evaluation.util.EvaluationUtil;
import org.sidiff.revision.ui.application.ComplementationApplication;
import org.sidiff.revision.ui.application.ResultChangedListener;
import org.sidiff.revision.ui.configuration.page.ComplementationPreferencePage;

public class HistoryRepairApplication implements ComplementationApplication<RepairJob, RepairSettings> {

	protected ComplementationFacade<RepairJob, RepairSettings> complementationFacade;
	
	protected List<ResultChangedListener<RepairJob>> listeners = new ArrayList<>();

	protected Collection<IResource> editRuleFiles = new ArrayList<>();
	
	protected Job calculation;
	
	protected HistoryInfo history;
	
	protected RepairJob repairJob;
	
	public void setHistory(History history) {
		this.history = new HistoryInfo(history);
		PrintHistoryInfoDriver.printHistoryInfo(this.history);
	}
	
	public Object getValidations() {
		return EvaluationUtil.toEObjectList(history
				.getSupportedIntroducedAndResolvedUniqueInconsistencies(), "History");
	}
	
	@Override
	public void initialize(ComplementationFacade<RepairJob, RepairSettings> repairFacade) {
		this.complementationFacade = repairFacade;
	}
	
	@Override
	public void addResultChangedListener(ResultChangedListener<RepairJob> listener) {
		listeners.add(listener);
	}
	
	@Override
	public void removeResultChangeListener(ResultChangedListener<RepairJob> listener) {
		listeners.remove(listener);
	}
	
	protected void fireResultChangeListener() {
		listeners.forEach(l -> l.resultChanged(getComplementationJob()));
	}
	
	@Override
	public void clearResultChangeListener() {
		listeners.clear();
	}
	
	@Override
	public void validation() {
		
		calculation = new Job("Evaluate History") {
			
			@Override
			protected IStatus run(IProgressMonitor monitor) {
				HistoryEvaluationDriver.calculateRepairs(complementationFacade, history, getEditRules(), getMatchingSettings());
				return Status.OK_STATUS;
			}
		};
		
		calculation.schedule();
	}
	
	@Override
	public void calculateComplementations() {
	}
	
	@Override
	public void recalculateComplementations() {
	}
	
	public void repairInconsistency(Problem selection) {
		
		calculation = new Job("Calculate Repairs") {

			@Override
			protected IStatus run(IProgressMonitor monitor) {

				// Initialize:
				InconsistencyTrace repaired = InconsistencyTrace.createRepairedInconsistency(selection, true);
				
				LogTable inconsistenciesLog = new LogTable();
				LogTable runtimeComplexityLog = new LogTable();

				// Calculate repairs:
				repairJob = InconsistencyEvaluationDriver.calculateRepairs(
						true, true, false, history, complementationFacade, repaired, 
						getEditRules(), getMatchingSettings(),
						inconsistenciesLog, runtimeComplexityLog);
				
				// Save CSV logs:
				String timestamp = EvaluationUtil.getTimestamp();
				
				EvaluationUtil.saveLog(history, inconsistenciesLog, 
						timestamp, "inconsistency_" + repaired.getName());
				EvaluationUtil.saveLog(history, runtimeComplexityLog, 
						timestamp, "runtime_" + repaired.getName());
				EvaluationUtil.updateProject(history);

				// Update UI:
				Display.getDefault().syncExec(() -> {
					
					// Show results:
					fireResultChangeListener();

					if (repairJob.getComplementationPlans().isEmpty()) {
						WorkbenchUtil.showMessage("No repairs found!");
					}
				});

				return Status.OK_STATUS;
			}
		};
		
		calculation.schedule();
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
			return true;
		}
		
		if (calculation.getState() == Job.RUNNING) {
			WorkbenchUtil.showMessage("Please wait for the repair calculation!");
			return true;
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
	
	public Collection<Rule> getEditRules() {
		return RulebaseUtil.loadEditRules(editRuleFiles, false, false);
	}

	@Override
	public RepairJob getComplementationJob() {
		return repairJob;
	}
	
	public void populateSettings(Resource modelA, Resource modelB) {
		ComplementationPreferencePage.populateSettings(modelB);
	}
	
	public DifferenceSettings getMatchingSettings() {
		DifferenceSettings settings = ComplementationPreferencePage.getMatchingSettings();
		settings.setMatcher(new UUIDMatcherProvider());
		settings.setTechBuilder(DifferenceBuilderRegistry.getGenericTechnicalDifferenceBuilder());
		
		return settings;
	}
	
	public String getDoumentType() {
		return ComplementationPreferencePage.getDoumentType();
	}
	
	@Override
	public void clear() {
		editRuleFiles.clear();
		clearCalculation();
	}
	
	public void clearCalculation() {
		calculation = null;
		history = null;
		repairJob = null;
	}
}
