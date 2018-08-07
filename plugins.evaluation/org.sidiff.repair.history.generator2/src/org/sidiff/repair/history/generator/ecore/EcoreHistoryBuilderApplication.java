package org.sidiff.repair.history.generator.ecore;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
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
import org.sidiff.repair.history.generator.metadata.DataSetMetadata;
import org.sidiff.repair.history.generator.util.HistoryUtil;

public class EcoreHistoryBuilderApplication implements IApplication {

	//----
	
	public boolean PRINT_IDS = false;
	
	//----
	
	@Override
	public Object start(IApplicationContext context) throws Exception {
		DataSetMetadata dataset = new DataSetMetadata("C:\\evaluation\\", true);
		
		
		
		return IApplication.EXIT_OK;
	}

	@Override
	public void stop() {
	}
	
	protected History generateHistory(String historyName, List<URI> modelVersions, EcoreHistorySettings settings) {
		
		History history = HistoryModelFactory.eINSTANCE.createHistory();
		history.setName(historyName);
		
		// Load history:
		System.out.println("############################## LOAD MODELS ##############################");
		
		// Load model data:
		for (int i = 0; i < modelVersions.size(); i++) {
			Resource resource = HistoryUtil.load(new ResourceSetImpl(), modelVersions.get(i));
			Version version = generateVersion(i + 1, resource, settings);

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
				if (versionA.getStatus().equals(ModelStatus.DEFECT) || versionB.getStatus().equals(ModelStatus.DEFECT)) {
					continue;
				}

				Matching matching = generateMatching(versionA, versionB, settings);
				generateUUIDs(matching);
			} catch (InvalidModelException e) {
				e.printStackTrace();
			} catch (NoCorrespondencesException e) {
				System.err.println("No correspondences found: " + versionA.getName() + " -> " + versionB.getName() );
			}
		}
		
		generateIntroducedAndResolved(history, settings);
		
		return history;
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
	
	private void generateIntroducedAndResolved(History history, EcoreHistorySettings settings) {
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
