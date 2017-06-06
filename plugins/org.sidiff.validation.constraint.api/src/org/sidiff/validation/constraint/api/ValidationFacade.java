package org.sidiff.validation.constraint.api;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.resource.Resource;
import org.sidiff.consistency.common.emf.DocumentType;
import org.sidiff.repair.validation.IConstraint;
import org.sidiff.repair.validation.IScopeRecorder;
import org.sidiff.repair.validation.ScopeRecorder;
import org.sidiff.validation.constraint.api.util.BatchValidationIterator;
import org.sidiff.validation.constraint.api.util.Validation;
import org.sidiff.validation.constraint.api.library.ConstraintLibraryRegistry;
import org.sidiff.validation.constraint.api.library.util.ConstraintLibraryUtil;

public class ValidationFacade {

	/**
	 * @param model
	 *            The model to validate.
	 * @return All found inconsistencies.
	 */
	public static List<Validation> validate(Resource model) {
		List<IConstraint> consistencyRules = ConstraintLibraryUtil.getConsistencyRules(
				ConstraintLibraryRegistry.getLibraries(DocumentType.getDocumentType(model)));

		BatchValidationIterator validationIterator = new BatchValidationIterator(
				model, consistencyRules, false, true, false);

		// Collect all validations:
		List<Validation> inconsistencies = new ArrayList<>();
		
		validationIterator.forEachRemaining(validation -> {
			if (!validation.getResult()) {
				inconsistencies.add(validation);
			}
		});
		
		return inconsistencies;
	}
	
	/**
	 * @param validations
	 *            The validation to record. The recorded scope will be written
	 *            to the validation.
	 */
	public static void recordScope(List<Validation> validations) {
		for (Validation validation : validations) {
			IScopeRecorder scope = new ScopeRecorder();
			validation.getRule().evaluate(validation.getContext(), scope);
			validation.setScope(scope);
		}
	}
}
