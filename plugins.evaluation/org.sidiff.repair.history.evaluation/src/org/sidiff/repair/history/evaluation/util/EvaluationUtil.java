package org.sidiff.repair.history.evaluation.util;

import java.io.File;
import java.text.ParseException;
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
import org.sidiff.historymodel.History;
import org.sidiff.historymodel.HistoryModelFactory;
import org.sidiff.historymodel.Problem;
import org.sidiff.historymodel.Version;
import org.sidiff.repair.history.evaluation.driver.data.HistoryInfo;
import org.sidiff.validation.constraint.api.util.Validation;
import org.sidiff.validation.constraint.interpreter.IConstraint;

public class EvaluationUtil {
	
	private static SimpleDateFormat TIME_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH-mm-ss");
	
	public static void saveLog(HistoryInfo history, LogTable log, String timestamp, String name) {
		String projectPath = EMFStorage.uriToPath(history.getHistory().eResource().getURI().trimSegments(1));
		
		// generate file name:
		String fileName = history.getHistory().getName() + "_" + timestamp + "_" + name + ".csv";

		// create folder:
		projectPath = projectPath + File.separator + timestamp;
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
	
	public static Date getTimestamp(String timeStamp) {
		try {
			return TIME_FORMAT.parse(timeStamp);
		} catch (ParseException e) {
		}
		return null;
	}
	
	public static String getTimestamp() {
		return TIME_FORMAT.format(new Date(System.currentTimeMillis()));
	}
	
	public static EObjectList toEObjectList(List<? extends EObject> list, String label) {
		EObjectList eObjectList = GraphpatternFactory.eINSTANCE.createEObjectList();
		eObjectList.setLabel(label);
		eObjectList.getContent().addAll(list);
		return eObjectList;
	}
	
	public static Problem getCorrespondingProblem(Problem validationError, Version model) {
		
		for(Problem nextProblem : model.getProblems()) {
			if (equalsValidation(validationError, nextProblem)) {
				return nextProblem;
			}
		}
		
		return null;
	}
	
	public static IConstraint getConsistencyRule(
			Problem validationError, List<IConstraint> consistencyRules) {
		
		for (IConstraint consistencyRule : consistencyRules) {
			if (getValidationID(consistencyRule).equalsIgnoreCase(getValidationID(validationError))) {
				return consistencyRule;
			}
		}
		
		return null;
	}
	
	public static <V extends Validation> V getValidation(Collection<V> validations, Problem inconsistency) {
		for (V validation : validations) {
			if (equalsValidation(validation, inconsistency)) {
				return validation;
			}
		}
		return null;
	}
	
	public static List<Problem> getAllUniqueValidations(History history) {
		List<Problem> validations = new ArrayList<>();
		
		for (Version version : history.getVersions()) {
			for (Problem validation : version.getProblems()) {
				
				// Is new validation error?
				if (!containsValidation(validations, validation)) {
					validations.add(validation);
				}
			}
		}
		
		return validations;
	}
	
	public static List<Problem> getIntroducedAndResolvedUniqueValidations(History history) {
		List<Problem> validations = new ArrayList<>();
		
		for (Version version : history.getVersions()) {
			for (Problem validation : version.getProblems()) {
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
	
	public static Set<Problem> getSupportedValidations(
			List<Problem> inconsistenciesAll, List<IConstraint> consistencyRules) {
		
		Set<Problem> inconsistenciesSupported = new HashSet<>();
		
		for (IConstraint constraint : consistencyRules) {
			for (Problem validation : inconsistenciesAll) {
				if (getValidationID(validation).equalsIgnoreCase(constraint.getName())) {
					inconsistenciesSupported.add(validation);
				}
			}
		}
		
		return inconsistenciesSupported;
	}
	
	public static Problem getEqualValidation(List<Problem> validations, Problem validation) {
		for (Problem containedValidation : validations) {
			if (equalsValidation(containedValidation, validation)) {
				return containedValidation;
			}
		}
		return null;
	}
	
	public static boolean containsValidation(List<Problem> validations, Problem validation) {
		for (Problem containedValidation : validations) {
			if (equalsValidation(containedValidation, validation)) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean equalsValidation(Problem validationA, Problem validationB) {
		
		if ((validationA != null) && (validationB != null)) {
			if (validationA.getIntroducedIn() == validationB.getIntroducedIn()) {
				if (validationA.getResolvedIn() == validationB.getResolvedIn()) {
					if (getValidationID(validationA).equalsIgnoreCase(getValidationID(validationB))) {
						EObject invalidElementA = validationA.getContextElement();
						EObject invalidElementB = validationB.getContextElement();
						
						if (EcoreUtil.getURI(invalidElementA).fragment().equals(EcoreUtil.getURI(invalidElementB).fragment())) {
							return true;
						}
					}
				}
			}
		}
		return false;
	}
	
	public static boolean equalsValidation(Validation validationA, Problem validationB) {
		
		if (getValidationID(validationA.getRule()).equalsIgnoreCase(getValidationID(validationB))) {
			EObject invalidElementA = validationA.getContext();
			EObject invalidElementB = validationB.getContextElement();

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
	
	public static String getValidationID(Problem validation) {
		return getValidationID(validation.getName());
	}
	
	public static Version getPredecessorRevision(Version version) {
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
	
	public static Version createEmptyModelVersion(History history) {
		Version initialVersion = history.getVersions().get(0);
		
//		Resource emptyModel = Revision.createEmptyModel(initialVersion.getModel());
		
		Version emptyModelVersion = HistoryModelFactory.eINSTANCE.createVersion();
		emptyModelVersion.setName("The Empty Model");
//		emptyModelVersion.setModelURI(emptyModel.getURI().toString()); // FIXME
		emptyModelVersion.setModelURI(initialVersion.getModelURI());
		emptyModelVersion.setRepositoryVersion("-1");
		emptyModelVersion.setStatus(initialVersion.getStatus());
//		emptyModelVersion.setModel(emptyModel);
		
		history.getVersions().add(0, emptyModelVersion);
		return emptyModelVersion;
	}

}
