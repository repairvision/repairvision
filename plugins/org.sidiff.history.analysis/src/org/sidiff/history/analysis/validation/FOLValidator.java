package org.sidiff.history.analysis.validation;

import org.sidiff.historymodel.HistoryModelFactory;
import org.sidiff.historymodel.Problem;
import org.sidiff.historymodel.ProblemSeverity;
import org.sidiff.historymodel.Version;
import org.sidiff.validation.constraint.api.ValidationFacade;
import org.sidiff.validation.constraint.api.util.Validation;

public class FOLValidator extends BasicValidation {

	@Override
	public void validate(Version version) {

		// Collect all abstract repair actions:
		for (Validation validation : ValidationFacade.validate(version.getModel().getAllContents(), ValidationFacade.getConstraints(version.getModel()))) {
			if (!validation.getResult()) {
				Problem inconsistency = HistoryModelFactory.eINSTANCE.createProblem();
				inconsistency.setName(validation.getRule().getName());
				inconsistency.setMessage(validation.getRule().getMessage());
				inconsistency.setSeverity(ProblemSeverity.ERROR);
				inconsistency.getInvalidElements().add(validation.getContext());
				inconsistency.setContextElement(getContextElement(inconsistency));
				
				version.getProblems().add(inconsistency);
			}
		}
	}

}
