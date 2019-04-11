package org.sidiff.repair.history.evaluation.driver.data;

import java.util.List;

import org.eclipse.emf.ecore.resource.Resource;
import org.sidiff.history.analysis.util.HistoryAnalysisUtil;
import org.sidiff.historymodel.Problem;
import org.sidiff.historymodel.Version;
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
	
	private Problem validationErrorIntroducedModel;
	
	/**
	 * The current model.
	 */
	private Version modelVersionCurrent;
	
	private Problem validationErrorCurrentModel;
	
	/**
	 * Model where the inconsistency were resolved.
	 */
	private Version modelVersionResolved;
	
	public static InconsistencyTrace createRepairedInconsistency(
			Problem introducedProblem, boolean completeOnly) {
		
		InconsistencyTrace trace = new InconsistencyTrace();
		trace.setProblemInIntroducedModel(introducedProblem);
		
		Version versionIntroduced = introducedProblem.getIntroducedIn();
		trace.setModelVersionIntroduced(versionIntroduced);
		
		if (trace.getModelIntroduced() != null) {
			Version versionHistorical = versionIntroduced.getPredecessor();
			trace.setModelVersionHistorical(versionHistorical);
			
			if (versionHistorical != null) {
				Version versionResolved = introducedProblem.getResolvedIn();
				trace.setModelVersionResolved(versionResolved);
				
				if (versionResolved != null) {
					Version versionCurrent = versionResolved.getPredecessor();
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
	
	public String getName() {
		return HistoryAnalysisUtil.getValidationID(validationErrorIntroducedModel);
	}
	
	public IConstraint getConsistencyRule(List<IConstraint> consistencyRules) {
		return HistoryAnalysisUtil.getConsistencyRule(validationErrorIntroducedModel, consistencyRules);
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
	
	public Problem getProblemInIntroducedModel() {
		return validationErrorIntroducedModel;
	}
	
	public void setProblemInIntroducedModel(Problem validationErrorIntroducedModel) {
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
		this.validationErrorCurrentModel = HistoryAnalysisUtil.getEqualValidation(
				modelVersionCurrent.getProblems(), validationErrorIntroducedModel);
	}
	
	public Problem getProblemCurrentModel() {
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
	
	@Override
	public String toString() {
		StringBuilder toString = new StringBuilder();
		
		toString.append("Historical Version ");
		toString.append(getModelVersionHistorical().getIndex());
		toString.append(": ");
		toString.append(getModelVersionHistorical().getName());
		toString.append("\n");
		
		toString.append("Introduced Version ");
		toString.append(getModelVersionIntroduced().getIndex());
		toString.append(": ");
		toString.append(getModelVersionIntroduced().getName());
		toString.append("\n");
		
		toString.append("Current Version ");
		toString.append(getModelVersionCurrent().getIndex());
		toString.append(": ");
		toString.append(getModelVersionCurrent().getName());
		toString.append("\n");
		
		toString.append("Resolved Version ");
		toString.append(getModelVersionResolved().getIndex());
		toString.append(": ");
		toString.append(getModelVersionResolved().getName());
		toString.append("\n");
		
		toString.insert(0, super.toString() + ":\n");
		
		return  toString.toString();
	}
}
