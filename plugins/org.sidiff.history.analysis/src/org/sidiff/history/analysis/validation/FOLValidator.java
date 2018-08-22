package org.sidiff.history.analysis.validation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.resource.Resource;
import org.sidiff.historymodel.HistoryModelFactory;
import org.sidiff.historymodel.Problem;
import org.sidiff.historymodel.ProblemSeverity;
import org.sidiff.validation.constraint.api.ValidationFacade;

public class FOLValidator extends BasicValidation {

	@Override
	public Collection<Problem> validate(Resource resource) {
		List<Problem> inconsistencies = new ArrayList<>();

		// Collect all abstract repair actions:
		ValidationFacade.validate(resource).forEach(validation -> {
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
		
		return inconsistencies;
	}

}
