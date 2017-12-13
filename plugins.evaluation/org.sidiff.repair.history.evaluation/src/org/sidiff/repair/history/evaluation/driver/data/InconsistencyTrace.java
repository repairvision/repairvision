package org.sidiff.repair.history.evaluation.driver.data;

import java.util.List;

import org.eclipse.emf.ecore.resource.Resource;
import org.sidiff.consistency.common.ui.util.InfoConsole;
import org.sidiff.historymodel.ValidationError;
import org.sidiff.historymodel.Version;
import org.sidiff.repair.history.evaluation.util.EvaluationUtil;
import org.sidiff.validation.constraint.interpreter.IConstraint;

public class InconsistencyTrace {
	
	/**
	 * Consistent historic model.
	 */
	private Version modelVersionHistorical;
	
	/**
	 * Model where the inconsistency were introduced.
	 */
	private Version modelVersionIntroduced;
	
	private ValidationError validationErrorIntroducedModel;
	
	/**
	 * The current model.
	 */
	private Version modelVersionCurrent;
	
	private ValidationError validationErrorCurrentModel;
	
	/**
	 * Model where the inconsistency were resolved.
	 */
	private Version modelVersionResolved;
	
	public static InconsistencyTrace createRepairedInconsistency(
			ValidationError introducedValidationError, boolean completeOnly) {
		
		InconsistencyTrace trace = new InconsistencyTrace();
		trace.setValidationErrorIntroducedModel(introducedValidationError);
		
		Version versionIntroduced = introducedValidationError.getIntroducedIn();
		trace.setModelVersionIntroduced(versionIntroduced);
		
		if (trace.getModelIntroduced() != null) {
			Version versionHistorical = EvaluationUtil.getPrecessorRevision(versionIntroduced);
			trace.setModelVersionHistorical(versionHistorical);
			
			if (versionHistorical != null) {
				Version versionResolved = introducedValidationError.getResolvedIn();
				trace.setModelVersionResolved(versionResolved);
				
				if (versionResolved != null) {
					Version versionCurrent = EvaluationUtil.getPrecessorRevision(versionResolved);
					trace.setModelVersionCurrent(versionCurrent);
				}
			}
		}
		
		if (!completeOnly || ((trace.getModelHistorical() != null) 
				&& (trace.getModelIntroduced() != null)
				&& (trace.getModelCurrent() != null)
				&& (trace.getModelResolved() != null))) {
			return trace;
		} else {
			return null;
		}
	}
	
	public void printModels() {
		InfoConsole.printInfo("Historical: " + modelVersionHistorical.getName());
		InfoConsole.printInfo("Introduced: "  + modelVersionIntroduced.getName());
		InfoConsole.printInfo("Current: "  + modelVersionCurrent.getName());
		InfoConsole.printInfo("Resolved: " + modelVersionResolved.getName());
	}
	
	public String getName() {
		return EvaluationUtil.getValidationID(validationErrorIntroducedModel);
	}
	
	public IConstraint getConsistencyRule(List<IConstraint> consistencyRules) {
		return EvaluationUtil.getConsistencyRule(validationErrorIntroducedModel, consistencyRules);
	}
	
	// historical:

	public Resource getModelHistorical() {
		if (modelVersionHistorical != null) {
			return modelVersionHistorical.getModel();
		}
		return null;
	}
	
	public Version getModelVersionHistorical() {
		return modelVersionHistorical;
	}
	
	public void setModelVersionHistorical(Version modelVersionHistorical) {
		this.modelVersionHistorical = modelVersionHistorical;
	}
	
	// introduced:
	
	public Resource getModelIntroduced() {
		if (modelVersionIntroduced != null) {
			return modelVersionIntroduced.getModel();
		}
		return null;
	}
	
	public Version getModelVersionIntroduced() {
		return modelVersionIntroduced;
	}
	
	public void setModelVersionIntroduced(Version modelVersionIntroduced) {
		this.modelVersionIntroduced = modelVersionIntroduced;
	}
	
	public ValidationError getValidationErrorIntroducedModel() {
		return validationErrorIntroducedModel;
	}
	
	public void setValidationErrorIntroducedModel(ValidationError validationErrorIntroducedModel) {
		this.validationErrorIntroducedModel = validationErrorIntroducedModel;
	}
	
	// current:
	
	public Resource getModelCurrent() {
		if (modelVersionCurrent != null) {
			return modelVersionCurrent.getModel();
		}
		return null;
	}
	
	public Version getModelVersionCurrent() {
		return modelVersionCurrent;
	}
	
	public void setModelVersionCurrent(Version modelVersionCurrent) {
		this.modelVersionCurrent = modelVersionCurrent;
		this.validationErrorCurrentModel = EvaluationUtil.getEqualValidation(
				modelVersionCurrent.getValidationErrors(), validationErrorIntroducedModel);
	}
	
	public ValidationError getValidationErrorCurrentModel() {
		return validationErrorCurrentModel;
	}
	
	// resolved:
	
	public Resource getModelResolved() {
		if (modelVersionResolved != null) {
			return modelVersionResolved.getModel();
		}
		return null;
	}

	public Version getModelVersionResolved() {
		return modelVersionResolved;
	}

	public void setModelVersionResolved(Version modelVersionResolved) {
		this.modelVersionResolved = modelVersionResolved;
	}
}
