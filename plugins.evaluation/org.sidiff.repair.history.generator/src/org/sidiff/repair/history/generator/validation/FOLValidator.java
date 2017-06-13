package org.sidiff.repair.history.generator.validation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.resource.Resource;
import org.sidiff.consistency.common.emf.DocumentType;
import org.sidiff.repair.historymodel.HistoryModelFactory;
import org.sidiff.repair.historymodel.ValidationError;
import org.sidiff.repair.historymodel.ValidationSeverity;
import org.sidiff.repair.validation.IConstraint;
import org.sidiff.validation.constraint.api.library.ConstraintLibraryRegistry;
import org.sidiff.validation.constraint.api.library.util.ConstraintLibraryUtil;
import org.sidiff.validation.constraint.api.util.BatchValidationIterator;

public class FOLValidator implements IValidator {

	@Override
	public Collection<ValidationError> validate(Resource resource) {
		List<IConstraint> consistencyRules = ConstraintLibraryUtil.getConsistencyRules(
				ConstraintLibraryRegistry.getLibraries(DocumentType.getDocumentType(resource)));

		BatchValidationIterator validationIterator = new BatchValidationIterator(
				resource, consistencyRules, false, true, false);
		
		List<ValidationError> inconsistencies = new ArrayList<>();

		// Collect all abstract repair actions:
		validationIterator.forEachRemaining(validation -> {
			if (!validation.getResult()) {
				ValidationError inconsistency = HistoryModelFactory.eINSTANCE.createValidationError();
				inconsistency.setName(validation.getRule().getName());
				inconsistency.setMessage(validation.getRule().getMessage());
				inconsistency.setSeverity(ValidationSeverity.ERROR);
				inconsistency.getInvalidElement().add(validation.getContext());
				
				inconsistencies.add(inconsistency);
			}
		});
		
		return inconsistencies;
	}

}
