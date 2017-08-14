package org.sidiff.repair.history.generator;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.sidiff.common.emf.EMFUtil;
import org.sidiff.common.emf.exceptions.InvalidModelException;
import org.sidiff.common.emf.exceptions.NoCorrespondencesException;
import org.sidiff.common.emf.modelstorage.EMFStorage;
import org.sidiff.consistency.common.storage.UUIDResource;
import org.sidiff.consistency.common.ui.util.WorkbenchUtil;
import org.sidiff.difference.symmetric.SymmetricDifference;
import org.sidiff.difference.technical.api.TechnicalDifferenceFacade;
import org.sidiff.matching.api.MatchingFacade;
import org.sidiff.matching.model.Correspondence;
import org.sidiff.matching.model.Matching;
import org.sidiff.repair.history.generator.repository.IHistoryRepository;
import org.sidiff.repair.history.generator.repository.ModelNamingUtil;
import org.sidiff.repair.history.generator.settings.EvaluationSettings;
import org.sidiff.repair.historymodel.History;
import org.sidiff.repair.historymodel.HistoryModelFactory;
import org.sidiff.repair.historymodel.ModelStatus;
import org.sidiff.repair.historymodel.ValidationError;
import org.sidiff.repair.historymodel.Version;

public class HistoryModelGenerator {
	
	//----
	
	public boolean WRITE_DIFFERENCES = false;
	
	public boolean PRINT_IDS = false;
	
	//----
	
	public static String PROJECT_NAME_PREFIX = "org.sidiff.ecore.testdata.history";
	
	public static String VERSIONS_FOLDER = "versions";
	
	public static String DIFF_FOLDER = "differences";
	
	public static String HISTORY_FILE_EXTENSION = "history";
	
	//----
	
	protected EvaluationSettings settings;
	
	//----
	
	public void generateHistoryProject(String inputPath, String outputProject, EvaluationSettings settings) {
		this.settings = settings;
		
		try {
			IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
			IProject project = root.getProject(outputProject);
			
			if (!project.exists()) {
				
				// Scan for model files within that folder:
				File modelFolder = new File(inputPath);
				List<File> files = IHistoryRepository.searchModelFiles(modelFolder, settings.getFileFilters());
				
				// Create a history:
				if (!files.isEmpty()) {
					History history = generateHistory(files, settings);
					saveHistory(history, outputProject);
					
					System.out.println(history.toString());
				}
			} else {
				WorkbenchUtil.showError("The project '" + project.getName() + "' already exists!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static String getProjectName(String projectPrefix, String inputPath) {
		File modelFolder = new File(inputPath);
		String name = modelFolder.getName().toLowerCase().split("\\.")[0];
		return projectPrefix + "." + name;
	}
	
	private void saveHistory(History history, String outputProject) throws CoreException, IOException {
		IHistoryRepository repository = settings.getRepository();
		
		// Get the project the history shall be stored in:
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		IProject project = root.getProject(outputProject);
		project.create(new NullProgressMonitor());
		project.open(new NullProgressMonitor());
		
		IFolder versionFolder = project.getFolder(VERSIONS_FOLDER);
		versionFolder.create(false, true, new NullProgressMonitor());
		
		URI versionFolderURI = URI.createPlatformResourceURI(
				project.getName() + "/" + VERSIONS_FOLDER, true);
		
		// Save referenced models:
		for (String uriString : repository.getReferencedModels()) {
			URI resolvedURI = URI.createURI(uriString);
			
			URI subModelCopy = versionFolderURI
					.appendSegment(ModelNamingUtil.getModelName(resolvedURI.lastSegment()))
					.appendSegment(repository.formatModelFileName(resolvedURI));
			
			Resource referencedModel = repository.getResourceSet().getResource(resolvedURI, true);
			referencedModel.setURI(subModelCopy);
			referencedModel.save(Collections.EMPTY_MAP);
		}
		
		// Save versions:
		for (Version version : history.getVersions()) {
			URI targetURI = versionFolderURI.appendSegment(getModelFileName(version));
			version.getModel().setURI(targetURI);
			version.setModelURI(targetURI.toString());
			
			try {
				version.getModel().save(Collections.EMPTY_MAP);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		// Save Differences:
		if (WRITE_DIFFERENCES) {
			IFolder diffFolder = project.getFolder(DIFF_FOLDER);
			diffFolder.create(false, true, null);
			
			for (SymmetricDifference diff : history.getTechnicalDifferences()) {
				TechnicalDifferenceFacade.serializeTechnicalDifference(diff,
						project.getLocation().toOSString() + File.separator + DIFF_FOLDER,
						diff.getModelA().getURI().lastSegment() + "_x_" + diff.getModelB().getURI().lastSegment());
			}
		} else {
			history.getTechnicalDifferences().clear();
		}
		
		// Save history:
		URI historyURI = EMFStorage.pathToUri(project.getLocation().toOSString() 
				+ File.separator + history.getName() + "." + HISTORY_FILE_EXTENSION);

		Resource historyResource = repository.getResourceSet().createResource(historyURI);
		historyResource.getContents().add(history);
		historyResource.save(Collections.EMPTY_MAP);

	}
	
	private String getModelFileName(Version version) {
		int revision = ((History) version.eContainer()).getVersions().indexOf(version) + 1;
		return String.format("%03d", revision) + "_" + settings.getRepository().formatModelFileName(URI.createURI(version.getModelURI()));
	}
	
	private History generateHistory(List<File> files, EvaluationSettings settings) {
		
		History history = HistoryModelFactory.eINSTANCE.createHistory();
		history.setName(settings.getHistoryName());
		
		// Load history:
		System.out.println("############################## LOAD MODELS ##############################");
		
		// Convert files to URIs:
		List<URI> modelURIs = new ArrayList<>();
		
		for (File modelFile : files) {
			System.out.println(modelFile);
			
			URI modelURI = EMFStorage.fileToUri(modelFile);
			modelURIs.add(modelURI);
		}
		
		// Sort history:
		settings.getRepository().sortHistory(modelURIs);
		
		// Load model data:
		for (int i = 0; i < modelURIs.size(); i++) {
			Resource resource = settings.getRepository().loadModel(modelURIs.get(i));
			Version version = generateVersion(i+1, resource, settings);
			
			if (version != null) {
				history.getVersions().add(version);
			}
		}
		
		// Calculate matchings:
		System.out.println("############################## Calcualte Traces ##############################");
		
		for (int i = 0; i < (history.getVersions().size() - 1); i++) {
			int j = i + 1;
			
			Version versionA = history.getVersions().get(i);
			Version versionB = history.getVersions().get(j);
			
			System.out.println("Versions: " + versionA.getName() + " -> " + versionB.getName());
			
			while (versionB.getStatus().equals(ModelStatus.DEFECT) && (j < (history.getVersions().size() - 1))) {
				versionB = history.getVersions().get(++j);
			}
			try {
				if (versionA.getStatus().equals(ModelStatus.DEFECT)
						|| versionB.getStatus().equals(ModelStatus.DEFECT)) {
					continue;
				}
				
				if (WRITE_DIFFERENCES) {
					SymmetricDifference diff = generateTechnicalDifference(versionA, versionB, settings);
					generateUUIDs(diff.getMatching());
					history.getTechnicalDifferences().add(diff);
				} else {
					Matching matching = generateMatching(versionA, versionB, settings);
					generateUUIDs(matching);
				}
			} catch (InvalidModelException e) {
				e.printStackTrace();
			} catch (NoCorrespondencesException e) {
				System.err.println("  No correspondences found: " + versionA.getName() + " -> " + versionB.getName() );
			}
		}
		
		generateIntroducedAndResolved(history);
		
		return history;
	}
	
	private Version generateVersion(int revision, Resource model, EvaluationSettings settings) {
		EcoreUtil.resolveAll(model);
		Collection<ValidationError> validationErrors = settings.getValidator().validate(model);
		
		ModelStatus modelStatus = validationErrors.isEmpty() ? ModelStatus.VALID : ModelStatus.INVALID;
		
		// Mark defect models
		for (ValidationError validationError : validationErrors) {
			for (EObject element : validationError.getInvalidElement()) {
				if (element.eIsProxy()) {
					modelStatus = ModelStatus.DEFECT;
				}
			}
		}
		
		Version version = HistoryModelFactory.eINSTANCE.createVersion();
		version.setModel(model);
		version.getValidationErrors().addAll(validationErrors);
		version.setStatus(modelStatus);
		version.setName(String.format("%03d", revision) + " - " + ModelNamingUtil.getModelName(model.getURI().toString()));
		
		return version;
	}
	
	private SymmetricDifference generateTechnicalDifference(Version versionA, Version versionB,
			EvaluationSettings settings) throws InvalidModelException, NoCorrespondencesException {
		
		Resource resourceA = versionA.getModel();
		Resource resourceB = versionB.getModel();
		
		SymmetricDifference diff = TechnicalDifferenceFacade.deriveTechnicalDifference(
				resourceA, resourceB, settings.getDifferenceSettings());

		return diff;
	}
	
	private Matching generateMatching(Version versionA, Version versionB,
			EvaluationSettings settings) throws InvalidModelException, NoCorrespondencesException {
		
		Resource resourceA = versionA.getModel();
		Resource resourceB = versionB.getModel();
		
		Matching matching = MatchingFacade.match(
				Arrays.asList(resourceA, resourceB), settings.getDifferenceSettings());

		return matching;
	}
	
	private void generateUUIDs(Matching matching) {
		if (PRINT_IDS) System.out.println("HistoryModelGenerator.generateUUIDs()");
		
		for (Correspondence correspondence : matching.getCorrespondences()) {
			if (!UUIDResource.isDynamic(correspondence.getMatchedA()) && !UUIDResource.isDynamic(correspondence.getMatchedB())) {
				String uuid = EMFUtil.getXmiId(correspondence.getMatchedA());
				assert uuid != null : "UUID for element" + correspondence.getMatchedA() + "not set!";
				EMFUtil.setXmiId(correspondence.getMatchedB(), uuid);
				
				if (PRINT_IDS) System.out.println("Corresponding: " + uuid + " :: " + correspondence.getMatchedB());
			}
		}
	}
	
	private void generateIntroducedAndResolved(History history) {
		for (Version versionA : history.getVersions()) {
			if (!history.getSuccessorRevisions(versionA).isEmpty()) {
				Version versionB = history.getSuccessorRevisions(versionA).get(0);
				
				for (ValidationError errorB : versionB.getValidationErrors()) {
					boolean hasCorresponding = false;
					
					for (ValidationError errorA : versionA.getValidationErrors()) {
						if (isEqualValidationError(errorA, errorB)) {
							errorB.setPrec(errorA);
							hasCorresponding = true;
							errorB.setIntroducedIn(errorA.getIntroducedIn());
							break;
						}
					}
					if (!hasCorresponding) {
						errorB.setIntroducedIn(versionB);
					}
				}
			}
		}
		List<Version> reverseOrder = new ArrayList<>();
		reverseOrder.addAll(history.getVersions());
		Collections.reverse(reverseOrder);
		
		for (Version versionB : reverseOrder) {
			if (!history.getPrecessorRevisions(versionB).isEmpty()) {
				Version versionA = history.getPrecessorRevisions(versionB).get(0);
				
				for (ValidationError errorA : versionA.getValidationErrors()) {
					boolean hasCorresponding = false;
					
					for (ValidationError errorB : versionB.getValidationErrors()) {
						if (isEqualValidationError(errorA, errorB)) {
							errorA.setSucc(errorB);
							hasCorresponding = true;
							errorA.setResolvedIn(errorB.getResolvedIn());
							break;
						}
					}
					if (!hasCorresponding) {
						errorA.setResolvedIn(versionB);
					}
				}
			}
		}
	}
	
	private boolean isEqualValidationError(ValidationError validationErrorA, ValidationError validationErrorB) {
		
		// replace all object runtime representation in the message
		boolean equalName = validationErrorA.getName().equals(validationErrorB.getName());
		Set<String> invalidElementAIDs = new HashSet<>();
		
		for (EObject invalidElementA : validationErrorA.getInvalidElement()) {
			String id = EMFUtil.getXmiId(invalidElementA);
			
			if (id != null) {
				invalidElementAIDs.add(id);
			} else {
				invalidElementAIDs.add(EcoreUtil.getURI(invalidElementA).fragment().toString());
			}
		}
		
		Set<String> invalidElementBIDs = new HashSet<>();
		
		for (EObject invalidElementB : validationErrorB.getInvalidElement()) {
			String id = EMFUtil.getXmiId(invalidElementB);

			if (id != null) {
				invalidElementBIDs.add(id);
			} else {
				invalidElementBIDs.add(EcoreUtil.getURI(invalidElementB).fragment().toString());
			}
		}
		
		return equalName && invalidElementAIDs.equals(invalidElementBIDs);
	}
}
