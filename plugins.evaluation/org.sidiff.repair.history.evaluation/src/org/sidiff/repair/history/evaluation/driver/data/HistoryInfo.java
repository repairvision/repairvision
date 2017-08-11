package org.sidiff.repair.history.evaluation.driver.data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.sidiff.repair.history.evaluation.util.EvaluationUtil;
import org.sidiff.repair.historymodel.History;
import org.sidiff.repair.historymodel.ValidationError;
import org.sidiff.validation.constraint.api.ValidationFacade;
import org.sidiff.validation.constraint.interpreter.IConstraint;

public class HistoryInfo {

	protected History history;
	
	protected List<ValidationError> allUniqueInconsistencies;
	
	protected List<ValidationError> introducedAndResolvedUniqueInconsistencies;
	
	protected List<ValidationError> supportedIntroducedAndResolvedUniqueInconsistencies;
	
	protected List<IConstraint> supportedConsistencyRules;
	
	protected List<RepairedInconsistency> repairedInconsistencies;

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
	
	public List<RepairedInconsistency> getRepairedInconsistencies() {
		
		if (repairedInconsistencies == null) {
			repairedInconsistencies = new ArrayList<>();
			
			for (ValidationError introducedValidationError : getSupportedIntroducedAndResolvedUniqueInconsistencies()) {
				RepairedInconsistency repaired = RepairedInconsistency
						.createRepairedInconsistency(introducedValidationError);
				repairedInconsistencies.add(repaired);
			}
			return repairedInconsistencies;
		}
		
		return repairedInconsistencies;
	}
}
