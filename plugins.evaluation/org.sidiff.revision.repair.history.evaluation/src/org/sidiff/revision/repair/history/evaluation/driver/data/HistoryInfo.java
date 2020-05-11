package org.sidiff.revision.repair.history.evaluation.driver.data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.sidiff.history.analysis.tracing.InconsistencyTrace;
import org.sidiff.history.analysis.util.HistoryAnalysisUtil;
import org.sidiff.historymodel.History;
import org.sidiff.historymodel.Problem;
import org.sidiff.historymodel.Version;
import org.sidiff.revision.repair.history.evaluation.util.EvaluationUtil;
import org.sidiff.validation.constraint.api.ValidationFacade;
import org.sidiff.validation.constraint.interpreter.IConstraint;

public class HistoryInfo {

	protected History history;
	
	protected List<Problem> allUniqueInconsistencies;
	
	protected List<Problem> introducedAndResolvedUniqueInconsistencies;
	
	protected List<Problem> supportedIntroducedAndResolvedUniqueInconsistencies;
	
	protected List<IConstraint> supportedConsistencyRules;
	
	protected List<InconsistencyTrace> repairedInconsistencies;
	
	protected Map<String, List<EAnnotation>> inconsistencyAnnotations;

	protected int historyModelElements = -1;
	
	protected int versionsWithInconsistencies = -1;
	
	public HistoryInfo(History history) {
		this.history = history;
		EvaluationUtil.createEmptyModelVersion(history);
	}
	
	public History getHistory() {
		return history;
	}
	
	public List<Problem> getAllUniqueInconsistencies() {
		
		if (allUniqueInconsistencies == null) {
			allUniqueInconsistencies = HistoryAnalysisUtil.getAllUniqueValidations(history);
		}
		
		return allUniqueInconsistencies;
	}

	public List<Problem> getIntroducedAndResolvedUniqueInconsistencies() {
		
		if (introducedAndResolvedUniqueInconsistencies == null) {
			introducedAndResolvedUniqueInconsistencies = HistoryAnalysisUtil
					.getResolvedUniqueValidations(history);
		}
		
		return introducedAndResolvedUniqueInconsistencies;
	}
	
	public List<Problem> getSupportedIntroducedAndResolvedUniqueInconsistencies() {
		
		if (supportedIntroducedAndResolvedUniqueInconsistencies == null) {
			Set<Problem> supported = HistoryAnalysisUtil.getSupportedValidations(
					getIntroducedAndResolvedUniqueInconsistencies(), getSupportedConsistencyRules());
			
			// Preserve ordering:
			supportedIntroducedAndResolvedUniqueInconsistencies = new ArrayList<>();
			
			for (Problem validationError : getIntroducedAndResolvedUniqueInconsistencies()) {
				if (supported.contains(validationError)) {
					supportedIntroducedAndResolvedUniqueInconsistencies.add(validationError);
				}
			}
		}
		
		return supportedIntroducedAndResolvedUniqueInconsistencies;
	}
	
	public List<IConstraint> getSupportedConsistencyRules() {
		
		if (supportedConsistencyRules == null) {
			if (!history.getVersions().isEmpty()) {
				Version latestVersion = history.getVersions().get(history.getVersions().size() - 1);
				supportedConsistencyRules = ValidationFacade.getConstraints(latestVersion.getModel());
			} else {
				supportedConsistencyRules = Collections.emptyList();
			}
		}
		
		return supportedConsistencyRules;
	}
	
	public List<InconsistencyTrace> getRepairedInconsistencies() {
		
		if (repairedInconsistencies == null) {
			repairedInconsistencies = new ArrayList<>();
			
			for (Problem introducedProblem : getSupportedIntroducedAndResolvedUniqueInconsistencies()) {
				InconsistencyTrace repaired = InconsistencyTrace
						.createRepairedInconsistency(introducedProblem, true);
				
				if (repaired != null) {
					repairedInconsistencies.add(repaired);
				} else {
					System.err.println("Dropped Problem: " + introducedProblem);
				}
			}
			return repairedInconsistencies;
		}
		
		return repairedInconsistencies;
	}
	
	/**
	 * NOTE: Considers only inconsistent versions.
	 */
	public int getHistoryModelElements() {
		
		if (historyModelElements == -1) {
			analyzeHistory();
		}
		
		return historyModelElements;
	}
	
	public int getVersionsWithInconsistencies() {
		
		if (versionsWithInconsistencies == -1) {
			analyzeHistory();
		}
		
		return versionsWithInconsistencies;
	}
	
	public Map<String, List<EAnnotation>> getInconsistencyAnnotations() {
		
		if (inconsistencyAnnotations == null) {
			analyzeHistory();
		}
		
		return inconsistencyAnnotations;
	}
	
	public List<EAnnotation> getUndoAnnotations() {
		return getInconsistencyAnnotations().getOrDefault("VALIDATION: Undo", Collections.emptyList());
	}
	
	public List<EAnnotation> getSingleChangeAnnotations() {
		return getInconsistencyAnnotations().getOrDefault("VALIDATION: SingleChange", Collections.emptyList());
	}
	
	public List<EAnnotation> getComplexChangeAnnotations() {
		return getInconsistencyAnnotations().getOrDefault("VALIDATION: ComplexChange", Collections.emptyList());
	}
	
	private void analyzeHistory() {
		inconsistencyAnnotations = new HashMap<>();
		historyModelElements = 0;
		versionsWithInconsistencies = 0;
		
		for (Version version : history.getVersions()) {
			if (version.getProblems().size() > 0) {
				++versionsWithInconsistencies;
				
				for (Iterator<EObject> iterator = version.getModel().getAllContents(); iterator.hasNext();) {
					EObject element = iterator.next();
					++historyModelElements;
					
					if (element instanceof EAnnotation) {
						EAnnotation annotation = (EAnnotation) element;
						
						if ((annotation.getSource() != null) && annotation.getSource().startsWith("VALIDATION")) {
							List<EAnnotation> contextElements = inconsistencyAnnotations.getOrDefault(
									annotation.getSource(), new ArrayList<>());
							inconsistencyAnnotations.put(annotation.getSource(), contextElements);
							contextElements.add(annotation);
						}
					}
				}
			}
		}
	}
}
