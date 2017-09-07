package org.sidiff.repair.history.evaluation.driver.data;

import java.util.List;

import org.eclipse.emf.ecore.resource.Resource;
import org.sidiff.consistency.common.ui.util.InfoConsole;
import org.sidiff.repair.history.evaluation.util.EvaluationUtil;
import org.sidiff.repair.historymodel.ValidationError;
import org.sidiff.repair.historymodel.Version;
import org.sidiff.validation.constraint.interpreter.IConstraint;

public class RepairedInconsistency {
	
	/**
	 * The "original" EMF diagnostic validation error.
	 */
	private ValidationError validationErrorCurrentModel;
	
	/**
	 * Consistent historic model.
	 */
	private Version modelVersionHistorical;
	
	/**
	 * Model where the inconsistency were introduced.
	 */
	private Version modelVersionIntroduced;
	
	/**
	 * The current model.
	 */
	private Version modelVersionCurrent;
	
	/**
	 * Model where the inconsistency were resolved.
	 */
	private Version modelVersionResolved;
	
	public static RepairedInconsistency createRepairedInconsistency(ValidationError introducedValidationError) {
		
		RepairedInconsistency repaired = new RepairedInconsistency();
		
		Version versionIntroduced = introducedValidationError.getIntroducedIn();
		repaired.setModelVersionIntroduced(versionIntroduced);
		
		if (repaired.getModelIntroduced() != null) {
			Version versionHistorical = EvaluationUtil.getPrecessorRevision(versionIntroduced);
			repaired.setModelVersionHistorical(versionHistorical);
			
			if (versionHistorical != null) {
				Version versionResolved = introducedValidationError.getResolvedIn();
				repaired.setModelVersionResolved(versionResolved);
				
				if (versionResolved != null) {
					Version versionCurrent = EvaluationUtil.getPrecessorRevision(versionResolved);
					repaired.setModelVersionActual(versionCurrent);
					
					ValidationError actualValidationError = EvaluationUtil.getCorrespondingValidationError(introducedValidationError, versionCurrent);
					repaired.setValidationErrorCurrentModel(actualValidationError);
					
					if (actualValidationError != null) {
						return repaired;
					}
				}
			}
		}
		
		return null;
	}
	
	public void printModels() {
		InfoConsole.printInfo("Historical: " + modelVersionHistorical.getName());
		InfoConsole.printInfo("Introduced: "  + modelVersionIntroduced.getName());
		InfoConsole.printInfo("Current: "  + modelVersionCurrent.getName());
		InfoConsole.printInfo("Resolved: " + modelVersionResolved.getName());
	}
	
	public String getName() {
		return EvaluationUtil.getValidationID(validationErrorCurrentModel);
	}
	
	public IConstraint getConsistencyRule(List<IConstraint> consistencyRules) {
		return EvaluationUtil.getConsistencyRule(validationErrorCurrentModel, consistencyRules);
	}

	public ValidationError getValidationErrorCurrentModel() {
		return validationErrorCurrentModel;
	}

	public void setValidationErrorCurrentModel(ValidationError validationErrorCurrentModel) {
		this.validationErrorCurrentModel = validationErrorCurrentModel;
	}
	
	public Resource getModelHistorical() {
		return modelVersionHistorical.getModel();
	}

	public Resource getModelIntroduced() {
		return modelVersionIntroduced.getModel();
	}

	public Resource getModelCurrent() {
		return modelVersionCurrent.getModel();
	}

	public Resource getModelResolved() {
		return modelVersionResolved.getModel();
	}

	public Version getModelVersionHistorical() {
		return modelVersionHistorical;
	}

	public void setModelVersionHistorical(Version modelVersionHistorical) {
		this.modelVersionHistorical = modelVersionHistorical;
	}

	public Version getModelVersionIntroduced() {
		return modelVersionIntroduced;
	}

	public void setModelVersionIntroduced(Version modelVersionIntroduced) {
		this.modelVersionIntroduced = modelVersionIntroduced;
	}

	public Version getModelVersionActual() {
		return modelVersionCurrent;
	}

	public void setModelVersionActual(Version modelVersionActual) {
		this.modelVersionCurrent = modelVersionActual;
	}

	public Version getModelVersionResolved() {
		return modelVersionResolved;
	}

	public void setModelVersionResolved(Version modelVersionResolved) {
		this.modelVersionResolved = modelVersionResolved;
	}
}
