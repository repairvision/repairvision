package org.sidiff.repair.ui.peo.integrated.app;

import java.io.File;
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
import org.sidiff.common.emf.EMFUtil;
import org.sidiff.common.emf.exceptions.InvalidModelException;
import org.sidiff.common.emf.exceptions.NoCorrespondencesException;
import org.sidiff.common.emf.modelstorage.EMFStorage;
import org.sidiff.consistency.common.storage.UUIDResource;
import org.sidiff.difference.technical.api.settings.DifferenceSettings;
import org.sidiff.matching.api.MatchingFacade;
import org.sidiff.matching.model.Correspondence;
import org.sidiff.matching.model.Matching;
import org.sidiff.repair.historymodel.History;
import org.sidiff.repair.historymodel.HistoryModelFactory;
import org.sidiff.repair.historymodel.ModelStatus;
import org.sidiff.repair.historymodel.ValidationError;
import org.sidiff.repair.historymodel.Version;

public class HistoryModelGenerator {
	
	public static History generateHistory(String historyName, List<File> files, 
			IValidator validator, DifferenceSettings settings) {
		
		History history = HistoryModelFactory.eINSTANCE.createHistory();
		history.setName(historyName);
		
		//// Load history ////
		
		// Convert files to URIs:
		List<URI> modelURIs = new ArrayList<>();
		
		for (File modelFile : files) {
			System.out.println(modelFile);
			
			URI modelURI = EMFStorage.fileToUri(modelFile);
			modelURIs.add(modelURI);
		}
		
		// Load model data:
		for (int i = 0; i < modelURIs.size(); i++) {
			ResourceSet rss = new ResourceSetImpl();
			Resource resource = rss.getResource(modelURIs.get(i), true);
			Version version = generateVersion(i + 1, resource, validator);

			if (version != null) {
				history.getVersions().add(version);
			}
		}
		
		//// Calculate matchings ////
		
		for (int i = 0; i < (history.getVersions().size() - 1); i++) {
			int j = i + 1;
			
			Version versionA = history.getVersions().get(i);
			Version versionB = history.getVersions().get(j);
			
			while (versionB.getStatus().equals(ModelStatus.DEFECT) && (j < (history.getVersions().size() - 1))) {
				versionB = history.getVersions().get(++j);
			}
			
			try {
				if (versionA.getStatus().equals(ModelStatus.DEFECT)
						|| versionB.getStatus().equals(ModelStatus.DEFECT)) {
					continue;
				}

				Matching matching = generateMatching(versionA, versionB, settings);
				generateUUIDs(matching);
			} catch (InvalidModelException e) {
				e.printStackTrace();
			} catch (NoCorrespondencesException e) {
				System.err.println(" No correspondences found: " + versionA.getName() + " -> " + versionB.getName());
			}
		}
		
		generateIntroducedAndResolved(history, validator);
		
		return history;
	}
	
	public static Version generateVersion(int revision, Resource model, IValidator validator) {

		Collection<ValidationError> validationErrors = validator.validate(model);
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
	
	private static Matching generateMatching(Version versionA, Version versionB, DifferenceSettings settings) 
			throws InvalidModelException, NoCorrespondencesException {
		
		Resource resourceA = versionA.getModel();
		Resource resourceB = versionB.getModel();
		
		Matching matching = MatchingFacade.match(Arrays.asList(resourceA, resourceB), settings);

		return matching;
	}
	
	private static void generateUUIDs(Matching matching) {
		for (Correspondence correspondence : matching.getCorrespondences()) {
			if (!UUIDResource.isDynamic(correspondence.getMatchedA()) && !UUIDResource.isDynamic(correspondence.getMatchedB())) {
				String uuid = EMFUtil.getXmiId(correspondence.getMatchedA());
				EMFUtil.setXmiId(correspondence.getMatchedB(), uuid);
			}
		}
	}
	
	public static void generateIntroducedAndResolved(History history, IValidator validator) {
		
		for (Version versionA : history.getVersions()) {
			if (!history.getSuccessorRevisions(versionA).isEmpty()) {
				Version versionB = history.getSuccessorRevisions(versionA).get(0);
				
				for (ValidationError errorB : versionB.getValidationErrors()) {
					boolean hasCorresponding = false;
					
					for (ValidationError errorA : versionA.getValidationErrors()) {
						if (validator.matchValidationError(errorA, errorB)) {
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
						if (validator.matchValidationError(errorA, errorB)) {
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
