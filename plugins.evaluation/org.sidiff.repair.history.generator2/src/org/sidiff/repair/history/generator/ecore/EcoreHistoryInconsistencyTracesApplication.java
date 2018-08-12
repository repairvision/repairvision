package org.sidiff.repair.history.generator.ecore;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;
import org.sidiff.common.emf.EMFUtil;
import org.sidiff.common.emf.exceptions.InvalidModelException;
import org.sidiff.common.emf.exceptions.NoCorrespondencesException;
import org.sidiff.consistency.common.storage.UUIDResource;
import org.sidiff.consistency.common.storage.UUIDResourceFactory;
import org.sidiff.historymodel.History;
import org.sidiff.historymodel.HistoryModelFactory;
import org.sidiff.historymodel.ModelStatus;
import org.sidiff.historymodel.ValidationError;
import org.sidiff.historymodel.Version;
import org.sidiff.matching.api.MatchingFacade;
import org.sidiff.matching.model.Correspondence;
import org.sidiff.matching.model.Matching;
import org.sidiff.repair.history.generator.metadata.HistoryMetadata;
import org.sidiff.repair.history.generator.metadata.VersionMetadata;
import org.sidiff.repair.history.generator.metadata.coevolution.CoevolutionDataSetMetadata;
import org.sidiff.repair.history.generator.util.HistoryUtil;

public class EcoreHistoryInconsistencyTracesApplication implements IApplication {

	private static String HISTORY_FILE_EXTENSION = "history";
	
	private boolean PRINT_IDS = false;
	
	private File sourceDataSet = new File("C:\\evaluation_resolved\\");
	
	private String sourceDataSetURI = URI.createFileURI(sourceDataSet.getAbsolutePath()).toString();
	
	private File targetDataSet = new File("C:\\evaluation_matched\\"); 
	
	private String targetDataSetURI = URI.createFileURI(targetDataSet.getAbsolutePath()).toString();
	
	@Override
	public Object start(IApplicationContext context) throws Exception {
		CoevolutionDataSetMetadata dataset = new CoevolutionDataSetMetadata(sourceDataSet.getAbsolutePath(), true);

		for (HistoryMetadata history : dataset.getHistories()) {
			if (!EcoreHistoryValidationApplication.modelHistoryFilter.contains(EcoreHistoryValidationApplication.getFilter(history))) {
				
				// Collect model versions:
				List<URI> modelVersions = new ArrayList<>();

				for (VersionMetadata version : history.getVersions()) {
					URI modelVersionURI = URI.createFileURI(history.getDatafile().getParent() + "/" + version.getLocalFilePath());
					modelVersions.add(modelVersionURI);
				}

				// Generate history:
				String historyName = EcoreHistorySettings.getInstance().generateHistoryName(history.getLatestRemoteFilePath());
				URI historyURI = URI.createFileURI(history.getDatafile().getParent())
						.appendSegment(historyName).appendFileExtension(HISTORY_FILE_EXTENSION);
				historyURI = toTargetURI(historyURI);
				
				Resource validationHistory = generateHistory(historyName, historyURI, modelVersions, EcoreHistorySettings.getInstance());

				// Save history:
				validationHistory.save(Collections.EMPTY_MAP);
			}
		}
		
		return IApplication.EXIT_OK;
	}
	
	private URI toTargetURI(URI sourceURI) {
		URI targetURI =  URI.createURI(sourceURI.toString().replace(sourceDataSetURI.toString(), targetDataSetURI.toString()));
		new File(targetURI.devicePath()).getParentFile().mkdirs();
		return targetURI;
	}

	@Override
	public void stop() {
	}
	
	protected Resource generateHistory(String historyName, URI historyURI, List<URI> modelVersions, EcoreHistorySettings settings) {
		
		History history = HistoryModelFactory.eINSTANCE.createHistory();
		history.setName(historyName);
		
		Resource historyResource = createResourceSet().createResource(historyURI);
		historyResource.getContents().add(history);
		
		URI baseURI = historyURI.trimSegments(1);
		
		try {
			historyResource.save(Collections.EMPTY_MAP);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		if (modelVersions.isEmpty()) {
			return historyResource;
		}
		
		// Calculate matchings:
		Resource resourceB = loadResourceSet(modelVersions.get(0));
		Version versionB = generateVersion(1, resourceB, settings);
		
		history.getVersions().add(versionB);
		saveResourceSetToTarget(resourceB.getResourceSet(), baseURI);
		
		for (int i = 1; i < modelVersions.size(); i++) {
			Version versionA = versionB;
			
			// Load model:
			resourceB = loadResourceSet(modelVersions.get(i));
			versionB = generateVersion(i + 1, resourceB, settings);
			
			System.out.println("Versions: " + versionA.getName() + " -> " + versionB.getName());

			// Calculate model element  matching:
			appendMatchedVersion(history, versionA, versionB, settings);
			saveResourceSetToTarget(resourceB.getResourceSet(), baseURI);
			
			// Calculate inconsistency traces:
			generateInconsistencyTraces(versionA, versionB, settings);
			
			// Unload history model (references to inconsistent models) to save memory:
			historyResource.unload();
		}
		
		return historyResource;
	}
	
	protected Resource loadResourceSet(URI uri) {
		ResourceSet resourceSetVersion = createResourceSet();
		Resource resource = resourceSetVersion.getResource(uri, true);
		EcoreUtil.resolveAll(resourceSetVersion);
		return resource;
	}
	
	protected ResourceSet createResourceSet() {
		ResourceSet resourceSet = HistoryUtil.setupResourceSet(new ResourceSetImpl());
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("ecore", new UUIDResourceFactory());
		return resourceSet;
	}
	
	protected void saveResourceSetToTarget(ResourceSet resourceSet, URI baseURI) {
		
		for (Resource versionSetResource : resourceSet.getResources()) {
			URI targetURI = toTargetURI(versionSetResource.getURI());
			versionSetResource.setURI(targetURI);
		}
		
		for (Resource versionSetResource : resourceSet.getResources()) {
			try {
				versionSetResource.save(Collections.emptyMap());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	protected void appendMatchedVersion(History history, Version versionA, Version versionB, EcoreHistorySettings settings) {
		history.getVersions().add(versionB);
		
		try {
			Matching matching = generateMatching(versionA, versionB, settings);
			generateUUIDs(matching);
		} catch (InvalidModelException e) {
			e.printStackTrace();
		} catch (NoCorrespondencesException e) {
			System.err.println("No correspondences found: " + versionA.getName() + " -> " + versionB.getName() );
		}
	}
	
	protected Version generateVersion(int revision, Resource model, EcoreHistorySettings settings) {
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
		version.setName(String.format("%03d", revision) + " - " + model.getURI().lastSegment());
		
		return version;
	}
	
	protected Matching generateMatching(Version versionA, Version versionB, EcoreHistorySettings settings) 
			throws InvalidModelException, NoCorrespondencesException {
		
		Resource resourceA = versionA.getModel();
		Resource resourceB = versionB.getModel();
		
		Matching matching = MatchingFacade.match(
				Arrays.asList(resourceA, resourceB), settings.getDifferenceSettings());

		return matching;
	}
	
	protected void generateUUIDs(Matching matching) {
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
	
	protected void generateInconsistencyTraces(Version versionA, Version versionB, EcoreHistorySettings settings) {

		for (ValidationError inconsistencyA : versionA.getValidationErrors()) {
			ValidationError inconsistencyB = getInconsistencyMatch(inconsistencyA, versionB, settings);
			
			if (inconsistencyB != null) {
				inconsistencyA.setSucc(inconsistencyB);
				inconsistencyB.setPrec(inconsistencyA);
				inconsistencyB.setIntroducedIn(inconsistencyA.getIntroducedIn());
			} else {
				inconsistencyA.setResolvedIn(versionA);
			}
			
			if (inconsistencyA.getPrec() == null) {
				inconsistencyA.setIntroducedIn(versionA);
			}
		}
	}
	
	protected ValidationError getInconsistencyMatch(
			ValidationError inconsistencyA, Version versionB, EcoreHistorySettings settings) {
		
		for (ValidationError inconsistencyB : versionB.getValidationErrors()) {
			if (settings.getValidator().matchValidationError(inconsistencyA, inconsistencyB)) {
				return inconsistencyB;
			}
		}
		
		return null;
	}
	
}
