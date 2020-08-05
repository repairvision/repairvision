package org.sidiff.revision.repair.history.retrieval.ecore;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;
import org.sidiff.generic.matcher.uuid.UUIDResource;
import org.sidiff.generic.matcher.uuid.UUIDResourceFactory;
import org.sidiff.historymodel.History;
import org.sidiff.historymodel.HistoryModelFactory;
import org.sidiff.historymodel.ModelStatus;
import org.sidiff.historymodel.Problem;
import org.sidiff.historymodel.Version;
import org.sidiff.revision.common.emf.EMFStorage;
import org.sidiff.revision.difference.Correspondence;
import org.sidiff.revision.difference.Difference;
import org.sidiff.revision.difference.api.DifferenceFacade;
import org.sidiff.revision.repair.history.retrieval.metadata.HistoryMetadata;
import org.sidiff.revision.repair.history.retrieval.metadata.VersionMetadata;
import org.sidiff.revision.repair.history.retrieval.metadata.coevolution.CoevolutionDataSetMetadata;
import org.sidiff.revision.repair.history.retrieval.metadata.coevolution.CoevolutionVersionMetadata;
import org.sidiff.revision.repair.history.retrieval.util.HistoryUtil;

/**
 * Resolved (Finding co-evolving versions) -> Matched (Calculate model element
 * matching between resource sets of successive versions.)
 * 
 * @author Manuel Ohrndorf
 */
public class EcoreHistoryInconsistencyTracesApplication implements IApplication {

	private static String HISTORY_FILE_EXTENSION = "history";
	
	private boolean PRINT_IDS = false;
	
	private File sourceDataSet = new File("C:\\evaluations\\org.eclipse.git_2018-08-22\\org.eclipse.git.resolved\\");
	
	private String sourceDataSetURI = URI.createFileURI(sourceDataSet.getAbsolutePath()).toString();
	
	private File targetDataSet = new File("C:\\evaluations\\org.eclipse.git_2018-11-02\\org.eclipse.git.matched\\"); 
	
	private String targetDataSetURI = URI.createFileURI(targetDataSet.getAbsolutePath()).toString();
	
	private Set<String> projectFilter = new HashSet<>();
	{
//		projectFilter.add("birt");
//		projectFilter.add("eclipse.e4");
//		projectFilter.add("modeling.eef");
//		projectFilter.add("modeling.emf.emf");
//		projectFilter.add("modeling.emft.edapt");
//		projectFilter.add("modeling.emft.emf-client");
//		projectFilter.add("modeling.gmp.gmf-tooling");
//		projectFilter.add("modeling.m2t.acceleo");
//		projectFilter.add("modeling.mdt.bpmn2");
//		projectFilter.add("modeling.mdt.ocl");
//		projectFilter.add("modeling.mdt.papyrus");
//		projectFilter.add("modeling.mdt.uml2");
//		projectFilter.add("modeling.mmt.atl");
//		projectFilter.add("modeling.mmt.qvt-oml");
//		projectFilter.add("modeling.mmt.qvtd");
//		projectFilter.add("modeling.pmf");
//		projectFilter.add("modeling.sirius");
//		projectFilter.add("science.eavp");
//		projectFilter.add("technology.cbi");
//		projectFilter.add("technology.stem");
//		projectFilter.add("tools.buckminster");
	}
	
	@Override
	public Object start(IApplicationContext context) throws Exception {
		CoevolutionDataSetMetadata dataset = new CoevolutionDataSetMetadata(sourceDataSet.getAbsolutePath(), true);
		
		for (HistoryMetadata history : dataset.getHistories()) {
			if (!EcoreHistoryValidationApplication.modelHistoryFilter.contains(EcoreHistoryValidationApplication.getFilter(history))) {
				if (!projectFilter.contains(history.getProjectName())) {
					
					// Collect model versions:
					List<URI> modelVersions = new ArrayList<>();
					Map<URI, String> versionInfo = new HashMap<>();
					
					for (VersionMetadata version : history.getVersions()) {
						CoevolutionVersionMetadata coevolutionVersion = (CoevolutionVersionMetadata) version;
						
						URI modelVersionURI = URI.createFileURI(history.getDatafile().getParent() + version.getLocalFilePath());
						modelVersions.add(modelVersionURI);
						
						versionInfo.put(modelVersionURI, 
								EcoreHistorySettings.DATE_ISO8601.format(coevolutionVersion.getWorkspaceDate()) 
								+ " " + coevolutionVersion.getCommit());
					}
					
					Collections.reverse(modelVersions);
					
					// Generate history:
					String datasetName = history.getDatafile().getName();
					String historyName = datasetName.substring(0, datasetName.lastIndexOf("."));
					URI historyURI = URI.createFileURI(history.getDatafile().getParent())
							.appendSegment(historyName).appendFileExtension(HISTORY_FILE_EXTENSION);
					historyURI = toTargetURI(historyURI, true);
					
					Resource validationHistory = generateHistory(
							historyName, historyURI, modelVersions, versionInfo, 
							EcoreHistorySettings.getInstance());
					
					// Save history:
					validationHistory.save(Collections.EMPTY_MAP);
				}
			}
		}
		
		return IApplication.EXIT_OK;
	}
	
	protected URI toTargetURI(URI sourceURI, boolean mkdirs) {
		URI targetURI =  URI.createURI(sourceURI.toString().replace(sourceDataSetURI.toString(), targetDataSetURI.toString()));
		
		if (mkdirs) {
			new File(targetURI.devicePath()).getParentFile().mkdirs();
		}
		
		return targetURI;
	}

	@Override
	public void stop() {
	}
	
	protected Resource generateHistory(String historyName, URI historyURI, 
			List<URI> modelVersions, Map<URI, String> versionInfo, EcoreHistorySettings settings) {
		
		History history = HistoryModelFactory.eINSTANCE.createHistory();
		history.setName(historyName);
		
		Resource historyResource = createResourceSet().createResource(historyURI);
		historyResource.getContents().add(history);

		if (modelVersions.isEmpty()) {
			return historyResource;
		}
		
		// Calculate matchings:
		URI uriB = modelVersions.get(0);
		String repositoryVersion = uriB.segment(uriB.segmentCount() - 2);
		Resource resourceB = loadResourceSet(uriB);
		Version versionB = generateVersion(1, resourceB, repositoryVersion, versionInfo.get(uriB), settings);
		
		history.getVersions().add(versionB);
		saveResourceSetToTarget(resourceB.getResourceSet(), 1);
		versionB.setModelURI(getRelativeModelURI(historyResource, resourceB));
		
		for (int i = 1; i < modelVersions.size(); i++) {
			Resource resourceA = resourceB;
			Version versionA = versionB;
			
			// Load model:
			uriB = modelVersions.get(i);
			repositoryVersion = uriB.segment(uriB.segmentCount() - 2);
			resourceB = loadResourceSet(uriB);
			versionB = generateVersion(i + 1, resourceB, repositoryVersion, versionInfo.get(uriB), settings);
			
			System.out.println("Versions: " + versionA.getName() + " -> " + versionB.getName());

			// Calculate model element  matching:
			matchVersions(history, resourceA, resourceB, settings);
			saveResourceSetToTarget(resourceB.getResourceSet(), i + 1);
			
			history.getVersions().add(versionB);
			versionB.setModelURI(getRelativeModelURI(historyResource, resourceB));
			
			// Calculate inconsistency traces:
			generateInconsistencyTraces(versionA, versionB, settings);
		}
		
		return historyResource;
	}
	
	protected String getRelativeModelURI(Resource history, Resource model) {
		String baseURI = history.getURI().trimSegments(1).toString();
		String modelURI = model.getURI().toString();
		return modelURI.replace(baseURI, "");
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
	
	protected void saveResourceSetToTarget(ResourceSet resourceSet, int version) {
		
		for (Resource versionSetResource : resourceSet.getResources()) {
			URI sourceURI = versionSetResource.getURI();
			URI targetURI = sourceURI.trimSegments(2)
					.appendSegment(
							EcoreHistorySettings.VERSION_NUMBER_FORMAT.format(version) 
							+ "_" + sourceURI.segment(sourceURI.segmentCount() - 2))
					.appendSegment(sourceURI.lastSegment());
			targetURI = toTargetURI(targetURI, true);
			
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

	protected void matchVersions(History history, Resource resourceA, Resource resourceB, EcoreHistorySettings settings) {
		Difference matching = generateMatching(resourceA, resourceB, settings);
		generateUUIDs(matching);
	}
	
	protected Version generateVersion(
			int revision, Resource model, String repositoryVersion,
			String versionInfo, EcoreHistorySettings settings) {
		
		// Create version:
		Version version = HistoryModelFactory.eINSTANCE.createVersion();
		version.setModel(model);
		version.setRepositoryVersion(repositoryVersion);
		version.setName(String.format("%03d", revision) + " - " + model.getURI().lastSegment());
		version.setRepositoryVersion(versionInfo);
		
		// Validate version:
		settings.getValidator().validate(version);
		
		ModelStatus modelStatus = version.getProblems().isEmpty() ? ModelStatus.VALID : ModelStatus.INVALID;
		version.setStatus(modelStatus);
		
		// Mark defect versions:
		for (Problem validationError : version.getProblems()) {
			for (EObject element : validationError.getInvalidElements()) {
				if (element.eIsProxy()) {
					modelStatus = ModelStatus.DEFECT;
				}
			}
		}
		
		return version;
	}
	
	protected Difference generateMatching(Resource resourceA, Resource resourceB, EcoreHistorySettings settings) {
		return DifferenceFacade.match(resourceA, resourceB, settings.getDifferenceSettings());
	}
	
	protected void generateUUIDs(Difference matching) {
		if (PRINT_IDS) System.out.println("HistoryModelGenerator.generateUUIDs()");
		
		for (Correspondence correspondence : matching.getCorrespondences()) {
			if (!UUIDResource.isDynamic(correspondence.getMatchedA()) && !UUIDResource.isDynamic(correspondence.getMatchedB())) {
				String uuid = EMFStorage.getXmiId(correspondence.getMatchedA());
				assert uuid != null : "UUID for element" + correspondence.getMatchedA() + "not set!";
				EMFStorage.setXmiId(correspondence.getMatchedB(), uuid);
				
				if (PRINT_IDS) System.out.println("Corresponding: " + uuid + " :: " + correspondence.getMatchedB());
			}
		}
	}
	
	protected void generateInconsistencyTraces(Version versionA, Version versionB, EcoreHistorySettings settings) {

		for (Problem inconsistencyA : versionA.getProblems()) {
			Problem inconsistencyB = getInconsistencyMatch(inconsistencyA, versionB, settings);
			
			if (inconsistencyB != null) {
				inconsistencyA.setSuccessor(inconsistencyB);
				inconsistencyB.setPredecessor(inconsistencyA);
				inconsistencyB.setIntroducedIn(inconsistencyA.getIntroducedIn());
			} else {
				inconsistencyA.setResolvedIn(versionB);
			}
			
			if (inconsistencyA.getPredecessor() == null) {
				inconsistencyA.setIntroducedIn(versionA);
			}
		}
	}
	
	protected Problem getInconsistencyMatch(
			Problem inconsistencyA, Version versionB, EcoreHistorySettings settings) {
		
		for (Problem inconsistencyB : versionB.getProblems()) {
			if (settings.getValidator().matchProblems(inconsistencyA, inconsistencyB)) {
				return inconsistencyB;
			}
		}
		
		return null;
	}
	
}
