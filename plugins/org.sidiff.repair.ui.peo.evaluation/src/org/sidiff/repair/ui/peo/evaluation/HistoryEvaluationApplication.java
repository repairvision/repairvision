package org.sidiff.repair.ui.peo.evaluation;

import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.henshin.interpreter.Match;
import org.eclipse.emf.henshin.model.Rule;
import org.sidiff.common.ui.WorkbenchUtil;
import org.sidiff.difference.symmetric.SymmetricDifference;
import org.sidiff.graphpattern.EObjectList;
import org.sidiff.graphpattern.GraphpatternFactory;
import org.sidiff.repair.api.IRepair;
import org.sidiff.repair.api.peo.PEORepairJob;
import org.sidiff.repair.evaluation.oracle.DeveloperIntentionOracle;
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
				int count = 0;
				
				for (Rule complementRule : repairJob.getRepairs().keySet()) {
					for (IRepair repair : repairJob.getRepairs().get(complementRule)) {
						
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
	}
}
