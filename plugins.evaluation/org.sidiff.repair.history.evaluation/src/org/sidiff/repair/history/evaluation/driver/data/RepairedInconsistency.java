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
	private ValidationError validationErrorActualModel;
	
	/**
	 * Consistent historic model.
	 */
	private Version modelVersionHistorical;
	
	/**
	 * Model where the inconsistency were introduced.
	 */
	private Version modelVersionIntroduced;
	
	/**
	 * The actual model.
	 */
	private Version modelVersionActual;
	
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
					Version versionActual = EvaluationUtil.getPrecessorRevision(versionResolved);
					repaired.setModelVersionActual(versionActual);
					
					ValidationError actualValidationError = EvaluationUtil.getCorrespondingValidationError(introducedValidationError, versionActual);
					repaired.setValidationErrorActualModel(actualValidationError);
					
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
		InfoConsole.printInfo("Actual: "  + modelVersionActual.getName());
		InfoConsole.printInfo("Resolved: " + modelVersionResolved.getName());
	}
	
	public String getName() {
		return EvaluationUtil.getValidationID(validationErrorActualModel);
	}
	
	public IConstraint getConsistencyRule(List<IConstraint> consistencyRules) {
		return EvaluationUtil.getConsistencyRule(validationErrorActualModel, consistencyRules);
	}

	public ValidationError getValidationErrorActualModel() {
		return validationErrorActualModel;
	}

	public void setValidationErrorActualModel(ValidationError validationErrorActualModel) {
		this.validationErrorActualModel = validationErrorActualModel;
	}
	
	public Resource getModelHistorical() {
		return modelVersionHistorical.getModel();
	}

	public Resource getModelIntroduced() {
		return modelVersionIntroduced.getModel();
	}

	public Resource getModelActual() {
		return modelVersionActual.getModel();
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
		return modelVersionActual;
	}

	public void setModelVersionActual(Version modelVersionActual) {
		this.modelVersionActual = modelVersionActual;
	}

	public Version getModelVersionResolved() {
		return modelVersionResolved;
	}

	public void setModelVersionResolved(Version modelVersionResolved) {
		this.modelVersionResolved = modelVersionResolved;
	}
}
