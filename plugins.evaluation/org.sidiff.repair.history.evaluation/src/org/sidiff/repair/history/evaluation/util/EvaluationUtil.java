package org.sidiff.repair.history.evaluation.util;

import static org.sidiff.difference.technical.api.TechnicalDifferenceFacade.deriveTechnicalDifference;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.henshin.interpreter.Match;
import org.eclipse.emf.henshin.model.Rule;
import org.sidiff.common.emf.exceptions.InvalidModelException;
import org.sidiff.common.emf.exceptions.NoCorrespondencesException;
import org.sidiff.difference.symmetric.SymmetricDifference;
import org.sidiff.difference.technical.api.settings.DifferenceSettings;
import org.sidiff.graphpattern.EObjectList;
import org.sidiff.graphpattern.GraphpatternFactory;
import org.sidiff.repair.api.IRepairPlan;
import org.sidiff.repair.api.peo.PEORepairJob;
import org.sidiff.repair.history.evaluation.oracle.DeveloperIntentionOracle;
import org.sidiff.repair.historymodel.History;
import org.sidiff.repair.historymodel.ValidationError;
import org.sidiff.repair.historymodel.Version;
import org.sidiff.repair.validation.IConstraint;
import org.sidiff.repair.validation.fix.IRepairDecision;
import org.sidiff.repair.validation.fix.RepairAction;
import org.sidiff.validation.constraint.api.library.IConstraintLibrary;
import org.sidiff.validation.constraint.api.library.util.ConstraintLibraryUtil;
import org.sidiff.validation.constraint.api.util.Validation;

public class EvaluationUtil {
	
	public static EObjectList toEObjectList(List<? extends EObject> list, String label) {
		EObjectList eObjectList = GraphpatternFactory.eINSTANCE.createEObjectList();
		eObjectList.setLabel(label);
		eObjectList.getContent().addAll(list);
		return eObjectList;
	}
	
	public static ValidationError getCorrespondingValidationError(ValidationError validationError, Version model) {
		
		for(ValidationError nextValidationError : model.getValidationErrors()) {
			if (equals(validationError, nextValidationError)) {
				return nextValidationError;
			}
		}
		
		return null;
	}
	
	public static List<IRepairPlan> historicallyObservable(PEORepairJob repairJob,
			DifferenceSettings settings, Resource modelActual, Resource modelResolved) {
		
		List<IRepairPlan> observable = new ArrayList<>();
		
		// The evolutionStep in which inconsistency has been resolved historically
		try {
			SymmetricDifference actualToResolved = deriveTechnicalDifference(modelActual, modelResolved, settings);
			
			for (Rule complementRule : repairJob.getRepairs().keySet()) {
				for (IRepairPlan repair : repairJob.getRepairs().get(complementRule)) {
					
					// The preMatch turning the complement rule into a repair operation.
					Match preMatch = repair.getRepairPreMatch().getMatch();
					
					// Mode
					boolean strict = false;
					
					DeveloperIntentionOracle oracle = new DeveloperIntentionOracle();
					
					if (oracle.isHistoricallyObservable(preMatch, actualToResolved, strict)) {
						observable.add(repair);
					}
				}
			}
		} catch (InvalidModelException | NoCorrespondencesException e) {
			e.printStackTrace();
		}
		
		return observable;
	}
	
	public static Validation getValidation(Collection<Validation> validations, ValidationError inconsistency) {
		for (Validation validation : validations) {
			if (equals(validation, inconsistency)) {
				return validation;
			}
		}
		return null;
	}
	
	// repairs / paths
	public static void getPathCountOfRepairTree(IRepairDecision node, int[] counter) {
		if (node instanceof RepairAction) {
			counter[0]++;
		}
		
		if (node.getChildDecisions().isEmpty()) {
			counter[1]++;
		} else {
			for (IRepairDecision child : node.getChildDecisions()) {
				getPathCountOfRepairTree(child, counter);
			}
		}
	}
	
	public static List<ValidationError> getValidations(History history) {
		List<ValidationError> validations = new ArrayList<>();
		
		for (Version version : history.getVersions()) {
			for (ValidationError validation : version.getValidationErrors()) {
				if ((validation.getIntroducedIn() != null) && (validation.getResolvedIn() != null)) {
					
					// Is new validation error?
					if (!contains(validations, validation)) {
						validations.add(validation);
					}
				}
			}
		}
		
		return validations;
	}
	
	public static Set<ValidationError> getSupportedValidations(
			List<ValidationError> inconsistenciesAll, Map<String, List<IConstraintLibrary>> libraries) {
		
		Set<ValidationError> inconsistenciesSupported = new HashSet<>();
		
		for (List<IConstraintLibrary> libraryByDocType: libraries.values()) {
			for (IConstraint constraint : ConstraintLibraryUtil.getConsistencyRules(libraryByDocType)) {
				for (ValidationError validation : inconsistenciesAll) {
					if (getValidationID(validation).equalsIgnoreCase(constraint.getName())) {
						inconsistenciesSupported.add(validation);
					}
				}
			}
		}
		
		return inconsistenciesSupported;
	}
	
	public static boolean contains(List<ValidationError> validations, ValidationError validation) {
		for (ValidationError containedValidation : validations) {
			if (equals(containedValidation, validation)) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean equals(Validation validationA, ValidationError validationB) {
		
		if (getValidationID(validationA.getRule()).equalsIgnoreCase(getValidationID(validationB))) {
			EObject invalidElementA = validationA.getContext();
			EObject invalidElementB = validationB.getInvalidElement().get(0);

			if (EcoreUtil.getURI(invalidElementA).fragment().equals(EcoreUtil.getURI(invalidElementB).fragment())) {
				return true;
			}
		}
			
		return false;
	}
	
	public static boolean equals(ValidationError validationA, ValidationError validationB) {
		
		if (validationA.getIntroducedIn() == validationB.getIntroducedIn()) {
			if (validationA.getResolvedIn() == validationB.getResolvedIn()) {
				if (getValidationID(validationA).equalsIgnoreCase(getValidationID(validationB))) {
					EObject invalidElementA = validationA.getInvalidElement().get(0);
					EObject invalidElementB = validationB.getInvalidElement().get(0);
					
					if (EcoreUtil.getURI(invalidElementA).fragment().equals(EcoreUtil.getURI(invalidElementB).fragment())) {
						return true;
					}
				}
			}
		}
		return false;
	}
	
	public static String getValidationID(String name) {
		return name.replaceAll("[^\\p{Alpha}]", "");
	}
	
	public static String getValidationID(IConstraint validation) {
		return getValidationID(validation.getName());
	}
	
	public static String getValidationID(ValidationError validation) {
		return getValidationID(validation.getName());
	}
	
	public static Version getPrecessorRevision(Version version) {
		History history = (History) version.eContainer();
		int index = history.getVersions().indexOf(version);

		if ((index - 1) >= 0) {
			return history.getVersions().get(index - 1);
		}
		
		return null;
	}

	public static Version getSuccessorRevision(Version version) {
		History history = (History) version.eContainer();
		int index = history.getVersions().indexOf(version);

		if ((index + 1) < history.getVersions().size()) {
			return history.getVersions().get(index + 1);
		}
		
		return null;
	}
}
