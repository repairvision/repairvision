package org.sidiff.repair.history.evaluation.driver.data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.sidiff.repair.history.evaluation.util.EvaluationUtil;
import org.sidiff.repair.historymodel.History;
import org.sidiff.repair.historymodel.ValidationError;
import org.sidiff.repair.historymodel.Version;
import org.sidiff.validation.constraint.api.ValidationFacade;
import org.sidiff.validation.constraint.interpreter.IConstraint;

public class HistoryInfo {

	protected History history;
	
	protected List<ValidationError> allUniqueInconsistencies;
	
	protected List<ValidationError> introducedAndResolvedUniqueInconsistencies;
	
	protected List<ValidationError> supportedIntroducedAndResolvedUniqueInconsistencies;
	
	protected List<IConstraint> supportedConsistencyRules;
	
	protected List<InconsistencyTrace> repairedInconsistencies;
	
	protected Map<String, List<EAnnotation>> inconsistencyAnnotations;

	protected int historyModelElements = -1;
	
	protected int versionsWithInconsistencies = -1;
	
	public HistoryInfo(History history) {
		this.history = history;
	}
	
	public History getHistory() {
		return history;
	}

	public List<ValidationError> getAllUniqueInconsistencies() {
		
		if (allUniqueInconsistencies == null) {
			allUniqueInconsistencies = EvaluationUtil.getAllUniqueValidations(history);
		}
		
		return allUniqueInconsistencies;
	}

	public List<ValidationError> getIntroducedAndResolvedUniqueInconsistencies() {
		
		if (introducedAndResolvedUniqueInconsistencies == null) {
			introducedAndResolvedUniqueInconsistencies = EvaluationUtil
					.getIntroducedAndResolvedUniqueValidations(history);
		}
		
		return introducedAndResolvedUniqueInconsistencies;
	}
	
	public List<ValidationError> getSupportedIntroducedAndResolvedUniqueInconsistencies() {
		
		if (supportedIntroducedAndResolvedUniqueInconsistencies == null) {
			Set<ValidationError> supported = EvaluationUtil.getSupportedValidations(
					getIntroducedAndResolvedUniqueInconsistencies(), getSupportedConsistencyRules());
			
			// Preserve ordering:
			supportedIntroducedAndResolvedUniqueInconsistencies = new ArrayList<>();
			
			for (ValidationError validationError : getIntroducedAndResolvedUniqueInconsistencies()) {
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
				supportedConsistencyRules = ValidationFacade.getConstraints(history.getVersions().get(0).getModel());
			} else {
				supportedConsistencyRules = Collections.emptyList();
			}
		}
		
		return supportedConsistencyRules;
	}
	
	public List<InconsistencyTrace> getRepairedInconsistencies() {
		
		if (repairedInconsistencies == null) {
			repairedInconsistencies = new ArrayList<>();
			
			for (ValidationError introducedValidationError : getSupportedIntroducedAndResolvedUniqueInconsistencies()) {
				InconsistencyTrace repaired = InconsistencyTrace
						.createRepairedInconsistency(introducedValidationError, true);
				repairedInconsistencies.add(repaired);
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
			if (version.getValidationErrors().size() > 0) {
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
