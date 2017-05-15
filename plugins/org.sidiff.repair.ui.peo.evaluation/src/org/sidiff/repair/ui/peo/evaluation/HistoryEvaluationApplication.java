package org.sidiff.repair.ui.peo.evaluation;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.henshin.interpreter.Match;
import org.eclipse.emf.henshin.model.Rule;
import org.sidiff.common.ui.WorkbenchUtil;
import org.sidiff.difference.symmetric.SymmetricDifference;
import org.sidiff.repair.api.IRepairPlan;
import org.sidiff.repair.api.peo.PEORepairJob;
import org.sidiff.repair.api.peo.PEORepairSettings;
import org.sidiff.repair.evaluation.oracle.DeveloperIntentionOracle;
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
import org.sidiff.repair.ui.peo.evaluation.util.EvaluationUtil;
import org.sidiff.repair.ui.util.EditRuleUtil;
import org.sidiff.repair.validation.util.Validation;
import org.sidiff.validation.constraint.library.ConstraintLibraryRegistry;

public class HistoryEvaluationApplication extends HistoryRepairApplication {
	
	/**
	 * The history resource.
	 */
	private History history;
	
	/**
	 * The actual selected validation error.
	 */
	private ValidationError validationError;
	
	private RepairEvaluation evaluation;
	
	@Override
	public void calculateRepairs() {
		
		System.out.println("#################### Evaluation Startet ####################");
		
		// Load edit-rules:
		editRules = EditRuleUtil.loadEditRules(editRuleFiles, false);
		
		// Find inconsistencies:
		List<ValidationError> inconsistenciesAll = EvaluationUtil.getValidations(history);
		Set<ValidationError> inconsistenciesConfigured = EvaluationUtil.getSupportedValidations(
				inconsistenciesAll, ConstraintLibraryRegistry.getLibraries());
		
		evaluation = new RepairEvaluation();
		ResearchQuestions rq = evaluation.createNewResearchQuestion(history);
		
		rq.getResearchQuestion01().countOfInconsistenciesAll = inconsistenciesAll.size();
		rq.getResearchQuestion01().countOfInconsistenciesConfigured = inconsistenciesConfigured.size();
		rq.getResearchQuestion01().revisionsAll = history.getVersions().size();
		rq.getResearchQuestion01().avgElements = ResearchQuestion01.getAVGElements(history);
		
		ResourceSet rss = new ResourceSetImpl();
		
//		repairCalculation = new Job("Calculate Repairs") {
//			
//			@Override
//			protected IStatus run(IProgressMonitor monitor) {
				
				// Evaluate all inconsistencies of the actual history:
				for (ValidationError inconsistency : inconsistenciesConfigured) {
					System.out.println("#################### " + inconsistency.getName() + " ####################");
					
					Resource modelA = rss.getResource(
							URI.createURI(getPrecessorRevision(inconsistency.getIntroducedIn()).getModelURI()), true);
					Resource modelB = rss.getResource(
							URI.createURI(getPrecessorRevision(inconsistency.getResolvedIn()).getModelURI()), true);
					
					setModelA(modelA);
					setModelB(modelB);
					
					// Matching-Settings:
					settings = getMatchingSettings();
					
					// Calculate repairs:
					repairJob = repairFacade.getRepairs(modelA, modelB,
							new PEORepairSettings(editRules, settings));
					
					
//					addResultChangedListener(new IResultChangedListener<PEORepairJob>() {
//						
//						@Override
//						public void resultChanged(PEORepairJob repairJob) {
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
							List<IRepairPlan> observable = EvaluationUtil.historicallyObservable(repairJob);
							
							if (!observable.isEmpty()) {
								rq.getResearchQuestion02().repairAsObservedOPK++;
							}
							
							// RQ 03:
							ResearchQuestion03 rq03 = rq.createNewRQ03(inconsistency);
							
							Validation validationForInconsistency = EvaluationUtil.getRepairTree(
									repairJob.getValidations(), inconsistency);
							
							// FIXME ?
							if (validationForInconsistency != null) {
								int[] counter = new int[2];
								EvaluationUtil.getPathCountOfRepairTree(validationForInconsistency.getRepair(), counter);
								
								rq03.repairActionsRE = counter[0];
								rq03.repairTreePathsRE = counter[1];
								
								for (Rule complement : repairJob.getRepairs().keySet()) {
									rq03.addRepairsPerComplement(repairJob.getRepairs().get(complement).size());
								}
							}
							
							// RQ 04:
							
							ResearchQuestion04 rq04 = rq.createNewRQ04(inconsistency);
							List<Rule> complements = new LinkedList<>(repairJob.getRepairs().keySet());

							// Calculate Ranking:
							complements.sort(new Comparator<Rule>() {

								@Override
								public int compare(Rule complementA, Rule complementB) {
									
									// Show the element with the greater ratio on top of the viewer:
									IRepairPlan repairA = repairJob.getRepairs().get(complementA).get(0);
									IRepairPlan repairB = repairJob.getRepairs().get(complementB).get(0);
									
									double ratioA = (double) repairA.getHistoricChanges().size() / repairA.getComplementingChanges().size();
									double ratioB = (double) repairB.getHistoricChanges().size() / repairB.getComplementingChanges().size();
									double diff = (ratioA - ratioB);

									if (diff != 0) {
										if (diff < 0) {
											// Ratio of B is greater then A -> B on the top:
											return 1;
										} else {
											// Ratio of A is greater then B -> A on the top:
											return -1;
										}
									} else {
										// Ratio A equals Ratio B:
										int countOfNodeDeleteChangesA = EvaluationUtil.countOfNodeDeleteChanges(repairA.getComplementingChanges()); 
										int countOfNodeDeleteChangesB = EvaluationUtil.countOfNodeDeleteChanges(repairB.getComplementingChanges());
										
										int countOfEdgeDeleteChangesA = EvaluationUtil.countOfEdgeDeleteChanges(repairA.getComplementingChanges()); 
										int countOfEdgeDeleteChangesB = EvaluationUtil.countOfEdgeDeleteChanges(repairB.getComplementingChanges());
										
										int morePreserving = 
												(2 * countOfNodeDeleteChangesA + countOfEdgeDeleteChangesA)
												- (2 * countOfNodeDeleteChangesB + countOfEdgeDeleteChangesB);
										
										if (morePreserving != 0) {
											if (morePreserving > 0) {
												// A deletes more then B -> B on the top::
												return 1;
											} else {
												// B deletes more then A -> A on the top:
												return -1;
											}
										}
									}
									
									return 0;
								}
							});
							
							// Find best observable:
							int position = Integer.MAX_VALUE;
							Rule bestObservableComplement =  null;
							IRepairPlan bestObservableRepair = null;
							
							for (IRepairPlan observableRepair : observable) {
								Rule observableComplement = EvaluationUtil.getComplement(repairJob, observableRepair);
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
							
						}
				// Store Evaluation:
				evaluation.store(rq);
				
				System.out.println("#################### Evaluation Result ####################");
				
				evaluation.dump();
				
				System.out.println("#################### Evaluation Finished ####################");
//					});
//				}
				
//				return Status.OK_STATUS;
//			}
//		};
//		
//		repairCalculation.schedule();
	}
	
	public void startEvaluationForInconsistency() {
		System.out.println("#################### Evaluation Startet ####################");
		System.out.println("Model A: " + modelA);
		System.out.println("Model B: " + modelB);
		
		setModelA(modelA);
		setModelB(modelB);
		
		// Start calculation:
		calculateRepairsForInconsistency();
		
		addResultChangedListener(new IResultChangedListener<PEORepairJob>() {
			
			@Override
			public void resultChanged(PEORepairJob repairJob) {
				System.out.println(repairJob);
				int count = 0;
				
				for (Rule complementRule : repairJob.getRepairs().keySet()) {
					for (IRepairPlan repair : repairJob.getRepairs().get(complementRule)) {
						
						// The preMatch turning the complement rule into a repair operation.
						Match preMatch = repair.getRepairPreMatch().getMatch();
						
						// The evolutionStep in which inconsistency has been resolved historically
						SymmetricDifference evolutionStep = (SymmetricDifference) repairJob
								.getDifference().getContents().get(0);
						
						// Mode
						boolean strict = false;
						
						DeveloperIntentionOracle oracle = new DeveloperIntentionOracle();
						
						if (oracle.isHistoricallyObservable(preMatch, evolutionStep, strict)) {
							count++;
						}
					}
				}
				
				WorkbenchUtil.showMessage(count + " Historically Observable Repair(s) Found!");
				
//				System.out.println("Repairs Found: " repairJob.getRepairs());
				System.out.println("#################### Evaluation Finished ####################");
			}
		});
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
	
	public void selectValidationError(ValidationError validationError) {
		Version V_t = validationError.getIntroducedIn();
		
		if (V_t != null) {
			Version V_tminus1 = getPrecessorRevision(V_t);
			
			if (V_tminus1 != null) {
				Version V_resolved = validationError.getResolvedIn();
				
				if (V_resolved != null) {
					Version V_actual = getPrecessorRevision(V_resolved);
					loadModels(validationError, V_tminus1, V_actual);
				} else {
					WorkbenchUtil.showMessage(
							"There is no version in which the inconsistency has been resolved! "
							+ "The last version in the history will be used as actual model!");
					
					Version V_actual = history.getVersions().get(history.getVersions().size() - 1);
					loadModels(validationError, V_tminus1, V_actual);
				}
			} else {
				WorkbenchUtil.showError("There is no previous consistent version available!");
			}
		} else {
			WorkbenchUtil.showError("The version in which the inconsistency was introduced is missing!");
		}
	}
	
	private void loadModels(ValidationError validationError, Version vA, Version vB) {
		ResourceSet rss = new ResourceSetImpl();
		Resource modelA = rss.getResource(URI.createURI(vA.getModelURI()), true);
		Resource modelB = rss.getResource(URI.createURI(vB.getModelURI()), true);
		
		setModelA(modelA);
		setModelB(modelB);
		setValidationError(validationError);
	}
	
	public History getHistory() {
		return history;
	}
	
	public void setHistory(History history) {
		this.history = history;
	}
	
	public ValidationError getValidationError() {
		return validationError;
	}
	
	public void setValidationError(ValidationError validationError) {
		this.validationError = validationError;
	}
	
	@Override
	public void clear() {
		super.clear();
		history = null;
		validationError = null;
		evaluation = null;
	}

	public EObject getValidations() {
		return EvaluationUtil.toEObjectList(EvaluationUtil.getValidations(history), "History");
	}
}
