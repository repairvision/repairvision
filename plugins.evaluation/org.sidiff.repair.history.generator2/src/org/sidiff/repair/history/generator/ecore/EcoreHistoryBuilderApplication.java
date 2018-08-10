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

public class EcoreHistoryBuilderApplication implements IApplication {

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
					URI modelVersionURI = URI.createFileURI(history.getDatafile().getParent()).appendSegment(version.getLocalFilePath());
					modelVersions.add(modelVersionURI);
				}

				// Generate history:
				String historyName = EcoreHistorySettings.getInstance().generateHistoryName(history.getLatestRemoteFilePath());
				History validationHistory = generateHistory(historyName, modelVersions, EcoreHistorySettings.getInstance());

				// Save history:
				URI historyURI = URI.createFileURI(history.getDatafile().getParent())
						.appendSegment(historyName).appendFileExtension(HISTORY_FILE_EXTENSION);
				historyURI = toTargetURI(historyURI);
				validationHistory.eResource().setURI(historyURI);
				validationHistory.eResource().save(Collections.EMPTY_MAP);
			}
		}
		
		return IApplication.EXIT_OK;
	}
	
	private URI toTargetURI(URI sourceURI) {
		return URI.createFileURI(sourceURI.toString().replace(sourceDataSetURI, targetDataSetURI));
	}

	@Override
	public void stop() {
	}
	
	protected History generateHistory(String historyName, List<URI> modelVersions, EcoreHistorySettings settings) {
		
		History history = HistoryModelFactory.eINSTANCE.createHistory();
		history.setName(historyName);
		
		if (modelVersions.isEmpty()) {
			return history;
		}
		
		// Calculate matchings:
		ResourceSet resourceSetVersionB = HistoryUtil.setupResourceSet(new ResourceSetImpl());
		Resource resourceB = new UUIDResource(modelVersions.get(0), resourceSetVersionB);
		Version versionB = generateVersion(1, resourceB, settings);
		
		history.getVersions().add(versionB);
		saveResourceSetToTarget(resourceSetVersionB);
		
		for (int i = 1; i < modelVersions.size(); i++) {
			Version versionA = versionB;
			
			resourceSetVersionB = HistoryUtil.setupResourceSet(new ResourceSetImpl());
			resourceB = new UUIDResource(modelVersions.get(i), resourceSetVersionB);
			versionB = generateVersion(i + 1, resourceB, settings);

			System.out.println("Versions: " + versionA.getName() + " -> " + versionB.getName());
			appendVersion(history, versionA, versionB, settings);
			saveResourceSetToTarget(resourceSetVersionB);
		}
		
		// Calculate inconsistency traces:
		generateInconsistencyTraces(history, settings);
		
		return history;
	}
	
	protected void saveResourceSetToTarget(ResourceSet resourceSet) {
		for (Resource versionSetResource : resourceSet.getResources()) {
			try {
				versionSetResource.setURI(toTargetURI(versionSetResource.getURI()));
				versionSetResource.save(Collections.EMPTY_MAP);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	protected void appendVersion(History history, Version versionA, Version versionB, EcoreHistorySettings settings) {
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
	
	protected void generateInconsistencyTraces(History history, EcoreHistorySettings settings) {
		for (Version versionA : history.getVersions()) {
			if (!history.getSuccessorRevisions(versionA).isEmpty()) {
				Version versionB = history.getSuccessorRevisions(versionA).get(0);
				
				for (ValidationError errorB : versionB.getValidationErrors()) {
					boolean hasCorresponding = false;
					
					for (ValidationError errorA : versionA.getValidationErrors()) {
						if (settings.getValidator().matchValidationError(errorA, errorB)) {
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
						if (settings.getValidator().matchValidationError(errorA, errorB)) {
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
}
