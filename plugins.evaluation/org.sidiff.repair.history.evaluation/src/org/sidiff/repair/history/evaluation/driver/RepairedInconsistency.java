package org.sidiff.repair.history.evaluation.driver;

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
	private Resource modelHistorical;
	
	/**
	 * Model where the inconsistency were introduced.
	 */
	private Resource modelIntroduced;
	
	/**
	 * The actual model.
	 */
	private Resource modelActual;
	
	/**
	 * Model where the inconsistency were resolved.
	 */
	private Resource modelResolved;
	
	public static RepairedInconsistency createRepairedInconsistency(ValidationError introducedValidationError) {
		
		RepairedInconsistency repaired = new RepairedInconsistency();
		
		Version versionIntroduced = introducedValidationError.getIntroducedIn();
		repaired.setModelIntroduced(versionIntroduced.getModel());
		
		if (repaired.getModelIntroduced() != null) {
			Version versionHistorical = EvaluationUtil.getPrecessorRevision(versionIntroduced);
			repaired.setModelHistorical(versionHistorical.getModel());
			
			if (versionHistorical != null) {
				Version versionResolved = introducedValidationError.getResolvedIn();
				repaired.setModelResolved(versionResolved.getModel());
				
				if (versionResolved != null) {
					Version versionActual = EvaluationUtil.getPrecessorRevision(versionResolved);
					repaired.setModelActual(versionActual.getModel());
					
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
		InfoConsole.printInfo("Historical: " + modelHistorical);
		InfoConsole.printInfo("Introduced: "  + modelIntroduced);
		InfoConsole.printInfo("Actual: "  + modelActual);
		InfoConsole.printInfo("Resolved: " + modelResolved);
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
		return modelHistorical;
	}

	public void setModelHistorical(Resource modelHistorical) {
		this.modelHistorical = modelHistorical;
	}

	public Resource getModelIntroduced() {
		return modelIntroduced;
	}

	public void setModelIntroduced(Resource modelIntroduced) {
		this.modelIntroduced = modelIntroduced;
	}

	public Resource getModelActual() {
		return modelActual;
	}

	public void setModelActual(Resource modelActual) {
		this.modelActual = modelActual;
	}

	public Resource getModelResolved() {
		return modelResolved;
	}

	public void setModelResolved(Resource modelResolved) {
		this.modelResolved = modelResolved;
	}
}
