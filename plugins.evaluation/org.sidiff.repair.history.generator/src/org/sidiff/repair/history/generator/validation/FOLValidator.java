package org.sidiff.repair.history.generator.validation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.resource.Resource;
import org.sidiff.repair.historymodel.HistoryModelFactory;
import org.sidiff.repair.historymodel.ValidationError;
import org.sidiff.repair.historymodel.ValidationSeverity;
import org.sidiff.validation.constraint.api.ValidationFacade;

public class FOLValidator extends BasicValidation {

	@Override
	public Collection<ValidationError> validate(Resource resource) {
		List<ValidationError> inconsistencies = new ArrayList<>();

		// Collect all abstract repair actions:
		ValidationFacade.validate(resource).forEach(validation -> {
			if (!validation.getResult()) {
				ValidationError inconsistency = HistoryModelFactory.eINSTANCE.createValidationError();
				inconsistency.setName(validation.getRule().getName());
				inconsistency.setMessage(validation.getRule().getMessage());
				inconsistency.setSeverity(ValidationSeverity.ERROR);
				inconsistency.getInvalidElement().add(validation.getContext());
				inconsistency.setContext(getContextElement(inconsistency));
				
				inconsistencies.add(inconsistency);
			}
		});
		
		return inconsistencies;
	}

}
