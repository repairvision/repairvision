package org.sidiff.validation.constraint.api;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.sidiff.revision.common.emf.document.DocumentType;
import org.sidiff.revision.impact.changetree.IDecisionNode;
import org.sidiff.revision.impact.changetree.scope.IScopeRecorder;
import org.sidiff.revision.impact.changetree.scope.ScopeRecorder;
import org.sidiff.validation.constraint.api.util.RepairValidation;
import org.sidiff.validation.constraint.api.util.RepairValidationIterator;
import org.sidiff.validation.constraint.api.util.RequiredValidation;
import org.sidiff.validation.constraint.api.util.RequiredValidationIterator;
import org.sidiff.validation.constraint.api.util.ScopeValidation;
import org.sidiff.validation.constraint.api.util.ScopeValidationIterator;
import org.sidiff.validation.constraint.api.util.Validation;
import org.sidiff.validation.constraint.api.util.ValidationIterator;
import org.sidiff.validation.constraint.interpreter.IConstraint;
import org.sidiff.validation.constraint.project.registry.ConstraintLibraryRegistry;
import org.sidiff.validation.constraint.project.registry.util.ConstraintLibraryUtil;

/**
 * Access to the constraint validation.
 * 
 * @author Manuel Ohrndorf
 */
public class ValidationFacade {

	/**
	 * @param model
	 *            The model to be validated.
	 * @param constraints
	 *            The constraints to be checked.
	 *
	 * @return All found inconsistencies.
	 */
	public static List<Validation> validate(Iterator<? extends EObject> model, List<IConstraint> constraints) {

		ValidationIterator validationIterator = new ValidationIterator(
				model, constraints, false, true);

		// Collect all validations:
		List<Validation> inconsistencies = new ArrayList<>();
		validationIterator.forEachRemaining(inconsistencies::add);

		return inconsistencies;
	}
	
	/**
	 * @param model
	 *            The model to be validated.
	 * @param constraints
	 *            The constraints to be checked.
	 * @param validationFilter
	 *            Filters the validations by the consistency rule and the
	 *            context element.
	 * @param positiveResults
	 *            Analyze successfully validated constraints.
	 * @param negativeResults
	 *            Analyze inconsistencies.
	 *
	 * @return All found inconsistencies.
	 */
	public static List<Validation> validate(
			Iterator<? extends EObject> model, List<IConstraint> constraints, 
			boolean positiveResults, boolean negativeResults) {

		ValidationIterator validationIterator = new ValidationIterator(
				model, constraints, positiveResults, negativeResults);

		// Collect all validations:
		List<Validation> inconsistencies = new ArrayList<>();
		validationIterator.forEachRemaining(inconsistencies::add);

		return inconsistencies;
	}
	
	/**
	 * @param model
	 *            The model to be validated.
	 * @param constraints
	 *            The constraints to be checked.
	 * @param validationFilter
	 *            Filters the validations by the consistency rule and the
	 *            context element.
	 * @param positiveResults
	 *            Analyze successfully validated constraints.
	 * @param negativeResults
	 *            Analyze inconsistencies.
	 * @return The scopes of all analyzed validations.
	 */
	public static List<ScopeValidation> analyzeScope(
			Iterator<? extends EObject> model, List<IConstraint> constraints,
			boolean positiveResults, boolean negativeResults) {

		ScopeValidationIterator validationIterator = new ScopeValidationIterator(
				model, constraints, positiveResults, negativeResults);

		// Collect all validations:
		List<ScopeValidation> analyzedConstraints = new ArrayList<>();
		validationIterator.forEachRemaining(validation -> {
			analyzedConstraints.add((ScopeValidation) validation);
		});

		return analyzedConstraints;
	}
	
	/**
	 * @param validations
	 *            The validation to be recorded.
	 * @return The recorded scopes.
	 */
	public static List<ScopeValidation> analyzeScope(List<Validation> validations) {
		List<ScopeValidation> scopes = new ArrayList<ScopeValidation>();
		
		for (Validation validation : validations) {
			IScopeRecorder scope = new ScopeRecorder();
			validation.getRule().evaluate(validation.getContext(), scope);
			
			ScopeValidation scopeValidation = new ScopeValidation(
					validation.getRule(), validation.getResult(), 
					validation.getContextType(), validation.getContext(), 
					scope);
			scopes.add(scopeValidation);
		}
		
		return scopes;
	}
	
	/**
	 * @param model
	 *            The model to be validated.
	 * @param constraints
	 *            The constraints to be checked.
	 * @param validationFilter
	 *            Filters the validations by the consistency rule and the
	 *            context element.
	 * @return A tree with elements that are required by the validated
	 *         constraints.
	 */
	public static List<RequiredValidation> analyzeRequirements(Iterator<? extends EObject> model, List<IConstraint> constraints) {

		RequiredValidationIterator validationIterator = new RequiredValidationIterator(
				model, constraints, true);

		// Collect all validations:
		List<RequiredValidation> analyzedConstraints = new ArrayList<>();
		validationIterator.forEachRemaining(validation -> {
			analyzedConstraints.add((RequiredValidation) validation);
		});

		return analyzedConstraints;
	}
	
	/**
	 * @param validations
	 *            The validation to be analyzed.
	 * @return The requirement trees of the given validations.
	 */
	public static List<RequiredValidation> analyzeRequirements(List<Validation> validations) {
		List<RequiredValidation> scopes = new ArrayList<RequiredValidation>();
		
		for (Validation validation : validations) {
			IDecisionNode required = validation.getRule().required();
			
			RequiredValidation scopeValidation = new RequiredValidation(
					validation.getRule(), validation.getResult(), 
					validation.getContextType(), validation.getContext(), 
					required);
			scopes.add(scopeValidation);
		}
		
		return scopes;
	}
	
	/**
	 * @param model
	 *            The model to be validated.
	 * @param constraints
	 *            The constraints to be checked.
	 * @param validationFilter
	 *            Filters the validations by the consistency rule and the
	 *            context element.
	 * @return All found inconsistencies.
	 */
	public static List<RepairValidation> repair(Iterator<? extends EObject> model, List<IConstraint> constraints) {

		RepairValidationIterator validationIterator = new RepairValidationIterator(
				model, constraints, true);

		// Collect all validations:
		List<RepairValidation> inconsistencies = new ArrayList<>();
		validationIterator.forEachRemaining(validation -> {
			inconsistencies.add((RepairValidation) validation);
		});

		return inconsistencies;
	}
	
	/**
	 * @param validations
	 *            The validation to be repaired.
	 * @return The requirement trees of the given validations.
	 */
	public static List<RepairValidation> repair(List<Validation> validations) {
		List<RepairValidation> scopes = new ArrayList<RepairValidation>();
		
		for (Validation validation : validations) {
			IDecisionNode required = validation.getRule().repair();
			
			RepairValidation scopeValidation = new RepairValidation(
					validation.getRule(), validation.getResult(), 
					validation.getContextType(), validation.getContext(), 
					required);
			scopes.add(scopeValidation);
		}
		
		return scopes;
	}

	/**
	 * @param model
	 *            The model to be validated.
	 * @return All registered constraint for the document type of the given
	 *         model.
	 */
	public static List<IConstraint> getConstraints(Resource model) {
		return ConstraintLibraryUtil
				.getConsistencyRules(ConstraintLibraryRegistry.getLibraries(DocumentType.getDocumentType(model)));
	}
}
