package org.sidiff.repair.ui.peo.evaluation;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.henshin.model.Rule;
import org.sidiff.common.ui.WorkbenchUtil;
import org.sidiff.graphpattern.EObjectList;
import org.sidiff.repair.api.IRepairPlan;
import org.sidiff.repair.api.peo.PEORepairJob;
import org.sidiff.repair.api.peo.PEORepairSettings;
import org.sidiff.repair.api.util.RepairAPIUtil;
import org.sidiff.repair.historymodel.History;
import org.sidiff.repair.historymodel.ValidationError;
import org.sidiff.repair.historymodel.Version;
import org.sidiff.repair.ui.app.IResultChangedListener;
import org.sidiff.repair.ui.peo.evaluation.data.RepairEvaluation;
import org.sidiff.repair.ui.peo.evaluation.data.ResearchQuestion01;
import org.sidiff.repair.ui.peo.evaluation.data.ResearchQuestion03;
import org.sidiff.repair.ui.peo.evaluation.data.ResearchQuestion04;
import org.sidiff.repair.ui.peo.evaluation.data.ResearchQuestions;
import org.sidiff.repair.ui.peo.evaluation.history.HistoryRepairApplication;
import org.sidiff.repair.ui.peo.evaluation.recording.LearnEditRule;
import org.sidiff.repair.ui.peo.evaluation.util.EvaluationUtil;
import org.sidiff.repair.ui.util.EditRuleUtil;
import org.sidiff.repair.validation.IConstraint;
import org.sidiff.repair.validation.util.Validation;
import org.sidiff.validation.constraint.library.ConstraintLibraryRegistry;

public class HistoryEvaluationApplication extends HistoryRepairApplication {
	
	/**
	 * Evaluation data container.
	 */
	private RepairEvaluation evaluation;
	
	/**
	 * The history resource.
	 */
	private History history;
	
	/**
	 * The actual selected validation error.
	 */
	private ValidationError inconsistency;
	
	/**
	 * Model where the inconsistency were resolved.
	 */
	private Resource modelC;
	
	/**
	 * Actual evaluation result listener.
	 */
	private IResultChangedListener<PEORepairJob> resultListener;
	
	@Override
	public void calculateRepairs() {
		
		System.out.println("#################### Evaluation Startet ####################");
		
		// Load edit-rules:
		editRules = EditRuleUtil.loadEditRules(editRuleFiles, false);
		
		// Find inconsistencies:
		List<ValidationError> inconsistenciesAll = EvaluationUtil.getValidations(history);
		Set<ValidationError> inconsistenciesConfigured = EvaluationUtil.getSupportedValidations(
				inconsistenciesAll, ConstraintLibraryRegistry.getLibraries());
		
		// Setup evaluation:
		evaluation = new RepairEvaluation();
		ResearchQuestions rq = evaluation.createNewResearchQuestion(history);
		
		rq.getResearchQuestion01().countOfInconsistenciesAll = inconsistenciesAll.size();
		rq.getResearchQuestion01().countOfInconsistenciesConfigured = inconsistenciesConfigured.size();
		rq.getResearchQuestion01().revisionsAll = history.getVersions().size();
		rq.getResearchQuestion01().avgElements = ResearchQuestion01.getAVGElements(history);
		
		// Wait for results...
		removeResultChangeListener(resultListener);
		
		resultListener = new IResultChangedListener<PEORepairJob>() {
			
			@Override
			public void resultChanged(PEORepairJob repairJob) {
				evaluate(rq);
			}
		};
		
		addResultChangedListener(resultListener);
		
		// Calculate repairs:
		repairCalculation = new Job("Calculate Repairs") {

			@Override
			protected IStatus run(IProgressMonitor monitor) {
				
				// Evaluate all inconsistencies of the actual history:
				for (ValidationError inconsistency : inconsistenciesConfigured) {
					
					System.out.println("#################### " + inconsistency.getName() + " ####################");
					
					if (setInconsistency(inconsistency)) {
						
						// Matching-Settings:
						settings = getMatchingSettings();
						
						// Calculate repairs:
						repairJob = repairFacade.getRepairs(getModelA(), getModelB(),
								new PEORepairSettings(editRules, settings));
					} else {
						System.out.println("#################### " + "FAILED" + " ####################");
					}
				}
				
				return Status.OK_STATUS;
			}
			
		};
		
		repairCalculation.schedule();
	}
	
	private void evaluate(ResearchQuestions rq) {
		System.out.println("Repairs Found: " + repairJob.getRepairs());
		
		// RQ 01:
		if (!repairJob.getValidations().isEmpty()) {
			rq.getResearchQuestion01().atLeastOnRepairRE++;
		}
		if (!repairJob.getRepairs().isEmpty()) {
			rq.getResearchQuestion01().atLeastOnRepairOPK++;
		}
		
		// RQ 02:
		// TODO: Oracle for Repair-Trees:
		List<IRepairPlan> observable = EvaluationUtil.historicallyObservable(
				repairJob, getMatchingSettings(), getModelB(), getModelC());
		
		if (!observable.isEmpty()) {
			rq.getResearchQuestion02().repairAsObservedOPK++;
		}
		
		// RQ 03:
		ResearchQuestion03 rq03 = rq.createNewRQ03(inconsistency);
		
		Validation validationForInconsistency = EvaluationUtil.getRepairTree(
				repairJob.getValidations(), inconsistency);

		int[] counter = new int[2];
		EvaluationUtil.getPathCountOfRepairTree(validationForInconsistency.getRepair(), counter);

		rq03.repairActionsRE = counter[0];
		rq03.repairTreePathsRE = counter[1];

		for (Rule complement : repairJob.getRepairs().keySet()) {
			rq03.addRepairsPerComplement(repairJob.getRepairs().get(complement).size());
		}
		
		// RQ 04:
		ResearchQuestion04 rq04 = rq.createNewRQ04(inconsistency);
		List<Rule> complements = new LinkedList<>(repairJob.getRepairs().keySet());

		// Calculate Ranking:
		complements.sort(repairJob.getRanking());
		
		// Find best observable:
		int position = Integer.MAX_VALUE;
		Rule bestObservableComplement =  null;
		IRepairPlan bestObservableRepair = null;
		
		for (IRepairPlan observableRepair : observable) {
			Rule observableComplement = RepairAPIUtil.getComplement(repairJob, observableRepair);
			int positionOfObservable = complements.indexOf(observableComplement);
			
			if (positionOfObservable < position) {
				position = positionOfObservable;
				bestObservableComplement = observableComplement;
				bestObservableRepair = observableRepair;
			}
		}
		
		if (bestObservableComplement != null) {
			rq04.positionOfComplement = position;
			rq04.countOfRepairs = repairJob.getRepairs().get(bestObservableComplement).size();
			rq04.countOfHistoricChanges = bestObservableRepair.getHistoricChanges().size();
			rq04.countOfComplementingChanges = bestObservableRepair.getComplementingChanges().size();
		}
		
		// Store Evaluation:
		evaluation.store(rq);

		System.out.println("#################### Evaluation Result ####################");

		evaluation.dump();

		System.out.println("#################### Evaluation Finished ####################");
	}
	
	public void startEvaluationForInconsistency() {
		
		System.out.println("#################### Evaluation Startet ####################");
		System.out.println("Model A: " + modelA);
		System.out.println("Model B: " + modelB);
		
		setModelA(modelA);
		setModelB(modelB);
		
		// Wait for results...
		removeResultChangeListener(resultListener);
		
		resultListener = new IResultChangedListener<PEORepairJob>() {
			
			@Override
			public void resultChanged(PEORepairJob repairJob) {
				
				List<IRepairPlan> observable = EvaluationUtil.historicallyObservable(
						repairJob, getMatchingSettings(), getModelB(), getModelC());
				
				WorkbenchUtil.showMessage(observable.size() + " Historically Observable Repair(s) Found!");
				
				System.out.println("Repairs Found: " + repairJob.getRepairs().size());
				System.out.println("#################### Evaluation Finished ####################");
			}
		};
		
		addResultChangedListener(resultListener);
		
		// Start calculation:
		calculateRepairsForInconsistency();
	}
	
	public Version getPrecessorRevision(Version version) {
		int index = history.getVersions().indexOf(version);

		if ((index - 1) >= 0) {
			return history.getVersions().get(index - 1);
		}
		
		return null;
	}

	public Version getSuccessorRevision(Version version) {
		int index = history.getVersions().indexOf(version);

		if ((index + 1) < history.getVersions().size()) {
			return history.getVersions().get(index + 1);
		}
		
		return null;
	}
	
	private void loadModels(Version vA, Version vB, Version vC) {
		setModelA(vA.getModel());
		setModelB(vB.getModel());
		
		if (vC != null) {
			setModelC(vC.getModel());
		}
	}
	
	public void learnEditRule() {
		LearnEditRule learnEditRule = new LearnEditRule(getMatchingSettings(), getModelA(), getModelB(), getModelC());
		IConstraint consistencyRule = EvaluationUtil.getRepairTree(repairJob.getValidations(), getInconsistency()).getRule();
		
 		learnEditRule.learn(getInconsistency().getInvalidElement().get(0), consistencyRule);
	}
	
	public History getHistory() {
		return history;
	}
	
	public void setHistory(History history) {
		this.history = history;
	}
	
	public ValidationError getInconsistency() {
		return inconsistency;
	}
	
	public boolean setInconsistency(ValidationError inconsistency) {
		Version V_introduced = inconsistency.getIntroducedIn();
		
		if (V_introduced != null) {
			Version V_historical = getPrecessorRevision(V_introduced);
			
			if (V_historical != null) {
				Version V_resolved = inconsistency.getResolvedIn();
				
				if (V_resolved != null) {
					Version V_actual = getPrecessorRevision(V_resolved);
					
					loadModels(V_historical, V_actual, V_resolved);
					this.inconsistency = EvaluationUtil.getCorrespondingValidationError(inconsistency, V_actual);
					
					return true;
				}
			}
		}
		
		return false;
	}
	
	public void selectInconsistency(ValidationError inconsistency) {
		Version V_introduced = inconsistency.getIntroducedIn();
		
		if (V_introduced != null) {
			Version V_historical = getPrecessorRevision(V_introduced);
			
			if (V_historical != null) {
				Version V_resolved = inconsistency.getResolvedIn();
				
				if (V_resolved != null) {
					Version V_actual = getPrecessorRevision(V_resolved);
					
					loadModels(V_historical, V_actual, V_resolved);
					this.inconsistency = EvaluationUtil.getCorrespondingValidationError(inconsistency, V_actual);
				} else {
					WorkbenchUtil.showMessage(
							"There is no version in which the inconsistency has been resolved! "
							+ "The last version in the history will be used as actual model!");
					
					Version V_actual = history.getVersions().get(history.getVersions().size() - 1);
					loadModels(V_historical, V_actual, null);
				}
			} else {
				WorkbenchUtil.showError("There is no previous consistent version available!");
			}
		} else {
			WorkbenchUtil.showError("The version in which the inconsistency was introduced is missing!");
		}
	}
	
	public Resource getModelC() {
		return modelC;
	}
	
	public void setModelC(Resource modelC) {
		this.modelC = modelC;
	}
	
	public EObjectList getValidations() {
		return EvaluationUtil.toEObjectList(EvaluationUtil.getValidations(history), "History");
	}
	
	@Override
	public void clear() {
		super.clear();
		history = null;
		inconsistency = null;
		evaluation = null;
	}
}
