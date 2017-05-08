package org.sidiff.repair.ui.peo.evaluation;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.sidiff.common.ui.WorkbenchUtil;
import org.sidiff.graphpattern.EObjectList;
import org.sidiff.graphpattern.GraphpatternFactory;
import org.sidiff.repair.api.peo.PEORepairJob;
import org.sidiff.repair.historymodel.History;
import org.sidiff.repair.historymodel.ValidationError;
import org.sidiff.repair.historymodel.Version;
import org.sidiff.repair.ui.app.IResultChangedListener;
import org.sidiff.repair.ui.peo.evaluation.history.HistoryRepairApplication;

public class HistoryEvaluationApplication extends HistoryRepairApplication {
	
	/**
	 * The history resource.
	 */
	private History history;
	
	/**
	 * The actual selected validation error.
	 */
	private ValidationError validationError;
	
	public void startEvaluation() {
		System.out.println("#################### Evaluation Startet ####################");
		System.out.println("Model A: " + modelA);
		System.out.println("Model B: " + modelB);
		
		setModelA(modelA);
		setModelB(modelB);
		calculateRepairs();
		
		addResultChangedListener(new IResultChangedListener<PEORepairJob>() {
			
			@Override
			public void resultChanged(PEORepairJob repairJob) {
				System.out.println(repairJob);
//				System.out.println("Repairs Found: " repairJob.getRepairs());
				System.out.println("#################### Evaluation Finished ####################");
			}
		});
	}
	
	// TODO: Validation Container!
	public EObjectList getValidations() {
		EObjectList validations = GraphpatternFactory.eINSTANCE.createEObjectList();
		validations.setLabel("History (all versions)");
		
		for (Version version : history.getVersions()) {
			for (ValidationError validation : version.getValidationErrors()) {
				// Is new validation error?
				if (!contains(validations.getContent(), validation)) {
					validations.getContent().add(validation);
				}
			}
		}
		
		return validations;
	}
	
	public boolean contains(List<EObject> validations, ValidationError validation) {
		for (EObject containedValidation : validations) {
			if (equals((ValidationError) containedValidation, validation)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean equals(ValidationError validationA, ValidationError validationB) {
		if (validationA.getIntroducedIn() == validationB.getIntroducedIn()) {
			if (validationA.getResolvedIn() == validationB.getResolvedIn()) {
				// TODO: Identifier for ValidationError.
				if (validationA.getMessage().equals(validationB.getMessage())) {
					return true;
				}
			}
		}
		return false;
	}
	
	public Version getPrecessorRevision(Version version) {
		int index = history.getVersions().indexOf(version);

		if ((index - 1) >= 0) {
			return history.getVersions().get(index);
		}
		
		return null;
	}

	public Version getSuccessorRevision(Version version) {
		int index = history.getVersions().indexOf(version);

		if ((index + 1) < history.getVersions().size()) {
			return history.getVersions().get(index);
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
					Version V_actual = getSuccessorRevision(V_resolved);
					
					setModelA(V_tminus1.getModel());
					setModelB(V_actual.getModel());
					setValidationError(validationError);
				} else {
					WorkbenchUtil.showMessage(
							"There is no version in which the inconsistency has been resolved! "
							+ "The last version in the history will be used as actual model!");
					
					Version V_actual = history.getVersions().get(history.getVersions().size() - 1);
					
					setModelA(V_tminus1.getModel());
					setModelB(V_actual.getModel());
					setValidationError(validationError);
				}
			} else {
				WorkbenchUtil.showError("There is no previous consistent version available!");
			}
		} else {
			WorkbenchUtil.showError("The version in which the inconsistency was introduced is missing!");
		}
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
	}
}
