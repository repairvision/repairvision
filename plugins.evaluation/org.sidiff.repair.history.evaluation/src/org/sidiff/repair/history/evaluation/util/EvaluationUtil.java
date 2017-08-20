package org.sidiff.repair.history.evaluation.util;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.sidiff.common.emf.modelstorage.EMFStorage;
import org.sidiff.consistency.common.monitor.LogTable;
import org.sidiff.graphpattern.EObjectList;
import org.sidiff.graphpattern.GraphpatternFactory;
import org.sidiff.repair.history.evaluation.driver.data.HistoryInfo;
import org.sidiff.repair.historymodel.History;
import org.sidiff.repair.historymodel.ValidationError;
import org.sidiff.repair.historymodel.Version;
import org.sidiff.validation.constraint.api.util.Validation;
import org.sidiff.validation.constraint.interpreter.IConstraint;

public class EvaluationUtil {
	
	public static void saveLog(HistoryInfo history, LogTable log, String timestamp, String name) {
		String projectPath = EMFStorage.uriToPath(history.getHistory().eResource().getURI().trimSegments(1));
		
		// generate file name:
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH-mm-ss");
		String timeStamp = df.format(new Date(System.currentTimeMillis()));
		String fileName = history.getHistory().getName() + "_" + timestamp + "_" + name + ".csv";

		// create folder:
		projectPath = projectPath + File.separator + timeStamp;
		File folder = new File(projectPath);

		if (!folder.exists()) {
			folder.mkdir();
		}

		// save CSV:
		log.toCSV(folder.getAbsolutePath() + File.separator + fileName);
	}
	
	public static void updateProject(HistoryInfo history) {
		try {
			String projectName = history.getHistory().eResource().getURI().trimSegments(1).lastSegment();
			IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
			IProject project = root.getProject(projectName);
			project.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static String getTimestamp() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH-mm-ss");
		String timestamp = df.format(new Date(System.currentTimeMillis()));
		return timestamp;
	}
	
	public static EObjectList toEObjectList(List<? extends EObject> list, String label) {
		EObjectList eObjectList = GraphpatternFactory.eINSTANCE.createEObjectList();
		eObjectList.setLabel(label);
		eObjectList.getContent().addAll(list);
		return eObjectList;
	}
	
	public static ValidationError getCorrespondingValidationError(ValidationError validationError, Version model) {
		
		for(ValidationError nextValidationError : model.getValidationErrors()) {
			if (equalsValidation(validationError, nextValidationError)) {
				return nextValidationError;
			}
		}
		
		return null;
	}
	
	public static IConstraint getConsistencyRule(
			ValidationError validationError, List<IConstraint> consistencyRules) {
		
		for (IConstraint consistencyRule : consistencyRules) {
			if (getValidationID(consistencyRule).equalsIgnoreCase(getValidationID(validationError))) {
				return consistencyRule;
			}
		}
		
		return null;
	}
	
	public static <V extends Validation> V getValidation(Collection<V> validations, ValidationError inconsistency) {
		for (V validation : validations) {
			if (equalsValidation(validation, inconsistency)) {
				return validation;
			}
		}
		return null;
	}
	
	public static List<ValidationError> getAllUniqueValidations(History history) {
		List<ValidationError> validations = new ArrayList<>();
		
		for (Version version : history.getVersions()) {
			for (ValidationError validation : version.getValidationErrors()) {
				
				// Is new validation error?
				if (!containsValidation(validations, validation)) {
					validations.add(validation);
				}
			}
		}
		
		return validations;
	}
	
	public static List<ValidationError> getIntroducedAndResolvedUniqueValidations(History history) {
		List<ValidationError> validations = new ArrayList<>();
		
		for (Version version : history.getVersions()) {
			for (ValidationError validation : version.getValidationErrors()) {
				if ((validation.getIntroducedIn() != null) && (validation.getResolvedIn() != null)) {
					
					// Is new validation error?
					if (!containsValidation(validations, validation)) {
						validations.add(validation);
					}
				}
			}
		}
		
		return validations;
	}
	
	public static Set<ValidationError> getSupportedValidations(
			List<ValidationError> inconsistenciesAll, List<IConstraint> consistencyRules) {
		
		Set<ValidationError> inconsistenciesSupported = new HashSet<>();
		
		for (IConstraint constraint : consistencyRules) {
			for (ValidationError validation : inconsistenciesAll) {
				if (getValidationID(validation).equalsIgnoreCase(constraint.getName())) {
					inconsistenciesSupported.add(validation);
				}
			}
		}
		
		return inconsistenciesSupported;
	}
	
	public static boolean containsValidation(List<ValidationError> validations, ValidationError validation) {
		for (ValidationError containedValidation : validations) {
			if (equalsValidation(containedValidation, validation)) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean equalsValidation(ValidationError validationA, ValidationError validationB) {
		
		if (validationA.getIntroducedIn() == validationB.getIntroducedIn()) {
			if (validationA.getResolvedIn() == validationB.getResolvedIn()) {
				if (getValidationID(validationA).equalsIgnoreCase(getValidationID(validationB))) {
					EObject invalidElementA = validationA.getContext();
					EObject invalidElementB = validationB.getContext();
					
					if (EcoreUtil.getURI(invalidElementA).fragment().equals(EcoreUtil.getURI(invalidElementB).fragment())) {
						return true;
					}
				}
			}
		}
		return false;
	}
	
	public static boolean equalsValidation(Validation validationA, ValidationError validationB) {
		
		if (getValidationID(validationA.getRule()).equalsIgnoreCase(getValidationID(validationB))) {
			EObject invalidElementA = validationA.getContext();
			EObject invalidElementB = validationB.getContext();

			if (EcoreUtil.getURI(invalidElementA).fragment().equals(EcoreUtil.getURI(invalidElementB).fragment())) {
				return true;
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
