package org.sidiff.repair.history.generator;

import java.io.File;
import java.io.FileFilter;
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
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.sidiff.common.emf.EMFUtil;
import org.sidiff.common.emf.exceptions.InvalidModelException;
import org.sidiff.common.emf.exceptions.NoCorrespondencesException;
import org.sidiff.common.emf.modelstorage.EMFStorage;
import org.sidiff.consistency.common.storage.UUIDResource;
import org.sidiff.difference.symmetric.SymmetricDifference;
import org.sidiff.difference.technical.api.TechnicalDifferenceFacade;
import org.sidiff.ecore.testdata.history.eclipse.LocalHistoryRepository;
import org.sidiff.ecore.testdata.history.eclipse.ModelNamingUtil;
import org.sidiff.ecore.testdata.history.eclipse.RepairURIHandler;
import org.sidiff.matching.model.Correspondence;
import org.sidiff.repair.history.generator.settings.EvaluationSettings;
import org.sidiff.repair.historymodel.History;
import org.sidiff.repair.historymodel.HistoryModelFactory;
import org.sidiff.repair.historymodel.ModelStatus;
import org.sidiff.repair.historymodel.ValidationError;
import org.sidiff.repair.historymodel.Version;

public class HistoryModelGenerator {
	
	private boolean WRITE_DIFFERENCES = false;
	
	private boolean PRINT_IDS = false;
	
	private String VERSIONS_FOLDER = "versions";
	
	private String DIFF_FOLDER = "differences";
	
	private String PROJECT_NAME_PREFIX = "org.sidiff.ecore.testdata.history.eclipse.";
	
	private String HISTORY_FILE_EXTENSION = "history";
	
	private IProject project = null;
	
	private ResourceSet resourceSet;
	
	//----
	
	private LocalHistoryRepository repository;
	
	private RepairURIHandler uriHandler;
	
	//----

	public void generateHistoryProject(String folderpath, EvaluationSettings settings) {
		
		try {
			
			// Scan for model files within that folder:
			File modelFolder = new File(folderpath);
			List<File> files = searchModelFiles(modelFolder, settings);
			
			if (!files.isEmpty()) {
				
				// Get the root of the workspace:
				IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
				
				// Get the project the history shall be stored in:
				String name =  modelFolder.getName().toLowerCase().split("\\.")[0];
				project = root.getProject(PROJECT_NAME_PREFIX + name);
				
				project.create(null);
				project.open(null);
				
				IFolder versionFolder = project.getFolder(VERSIONS_FOLDER);
				versionFolder.create(false, true, null);
				
				// Create a history:
				URI versionFolderURI = URI.createPlatformResourceURI(project.getName() + "/" + VERSIONS_FOLDER, true);
				
				resourceSet = new ResourceSetImpl();
				
				repository = new LocalHistoryRepository("C:\\workspaces\\sidiff\\org.sidiff.ecore.testdata.history.eclipse\\github.com");
				uriHandler = new RepairURIHandler(resourceSet, versionFolderURI, repository);
				
				resourceSet.getLoadOptions().put(XMIResource.OPTION_SCHEMA_LOCATION, Boolean.TRUE);
				resourceSet.getLoadOptions().put(XMIResource.OPTION_URI_HANDLER, uriHandler);
				
				History history = generateHistory(files, settings);
				saveHistory(history);
				
				System.out.println(history.toString());
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void saveHistory(History history) throws CoreException {
		
		// Save versions:
		String versionFolder = project.getName() + "/" + VERSIONS_FOLDER + "/";
		
		for (Version version : history.getVersions()) {
			URI targetURI = URI.createPlatformResourceURI(versionFolder + getModelFileName(version), true);
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
		
		try {
			Resource historyResource = resourceSet.createResource(historyURI);
			historyResource.getContents().add(history);
			historyResource.save(Collections.EMPTY_MAP);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	protected String getModelFileName(Version version) {
		int revision = ((History) version.eContainer()).getVersions().indexOf(version);
		return String.format("%03d", revision) + "_" + repository.parseModelName(URI.createURI(version.getModelURI()));
		
//		URI original = version.getModel().getURI();
//		String fileName = original.trimFileExtension().lastSegment();
//		String fileExtension = original.fileExtension();
//		
//		String index = fileName.substring(0, fileName.indexOf("_"));
//		
//		if (index.isEmpty()) {
//			index = "" + ((History) version.eContainer()).getVersions().indexOf(version);
//		}
//		
//		return index + "." + fileExtension;
	}

	private static List<File> searchModelFiles(File root, EvaluationSettings settings) {
		List<File> files = new ArrayList<>();
		
		FileFilter filter = new FileFilter() {
			
			@Override
			public boolean accept(File pathname) {
				if (!pathname.isDirectory()) {
					for (String filter : settings.getFileFilters()) {
						if (pathname.getName().toLowerCase().endsWith(filter)) {
							return true;
						}
					}
				}
				return false;
			}
		};
		
		files.addAll(Arrays.asList(root.listFiles(filter)));
		Collections.sort(files);
		
		// scan for sub-directories recursively
		for (File file : root.listFiles()) {
			if (file.isDirectory()) {
				files.addAll(searchModelFiles(file, settings));
			}
		}
		return files;
	}
	
	private History generateHistory(List<File> files, EvaluationSettings settings) {
		
		History history = HistoryModelFactory.eINSTANCE.createHistory();
		history.setName(settings.getHistory_name());
		
		// Load history:
		System.out.println("############################## LOAD MODELS ##############################");
		int revision = 0;
		
		for (File modelFile : files) {
			++revision;
			
			URI uri = EMFStorage.fileToUri(modelFile);
			System.out.println(uri);
			Resource resource = new UUIDResource(uri, resourceSet);
			Version version = generateVersion(revision, resource, settings);
			
			if (version != null) {
				history.getVersions().add(version);
			}
			
			uriHandler.clear();
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
				SymmetricDifference diff = generateTechnicalDifference(versionA, versionB, settings);
				generateUUIDs(diff);
				history.getTechnicalDifferences().add(diff);
			} catch (InvalidModelException e) {
				e.printStackTrace();
			} catch (NoCorrespondencesException e) {
				e.printStackTrace();
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
	
	private void generateUUIDs(SymmetricDifference diff) {
		if (PRINT_IDS) System.out.println("HistoryModelGenerator.generateUUIDs()");
		
		for (Correspondence correspondence : diff.getMatching().getCorrespondences()) {
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
			}
		}
		
		Set<String> invalidElementBIDs = new HashSet<>();
		
		for (EObject invalidElementB : validationErrorB.getInvalidElement()) {
			String id = EMFUtil.getXmiId(invalidElementB);
			
			if (id != null) {
				invalidElementBIDs.add(id);
			}
		}
		return equalName && invalidElementAIDs.equals(invalidElementBIDs);
	}
}
