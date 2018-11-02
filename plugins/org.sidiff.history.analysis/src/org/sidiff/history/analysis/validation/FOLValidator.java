package org.sidiff.history.analysis.validation;

import java.util.ArrayList;
import java.util.List;

import org.sidiff.historymodel.HistoryModelFactory;
import org.sidiff.historymodel.Problem;
import org.sidiff.historymodel.ProblemSeverity;
import org.sidiff.historymodel.Version;
import org.sidiff.validation.constraint.api.ValidationFacade;

public class FOLValidator extends BasicValidation {

	@Override
	public void validate(Version version) {
		List<Problem> inconsistencies = new ArrayList<>();

		// Collect all abstract repair actions:
		ValidationFacade.validate(version.getModel().getAllContents(), ValidationFacade.getConstraints(version.getModel())).forEach(validation -> {
			if (!validation.getResult()) {
				Problem inconsistency = HistoryModelFactory.eINSTANCE.createProblem();
				inconsistency.setName(validation.getRule().getName());
				inconsistency.setMessage(validation.getRule().getMessage());
				inconsistency.setSeverity(ProblemSeverity.ERROR);
				inconsistency.getInvalidElements().add(validation.getContext());
				inconsistency.setContextElement(getContextElement(inconsistency));
				
				inconsistencies.add(inconsistency);
			}
		});
	}

}
