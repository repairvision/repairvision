package org.sidiff.history.analysis.tracing;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.sidiff.common.emf.EMFUtil;
import org.sidiff.common.emf.exceptions.InvalidModelException;
import org.sidiff.common.emf.exceptions.NoCorrespondencesException;
import org.sidiff.consistency.common.storage.UUIDResource;
import org.sidiff.difference.technical.api.settings.DifferenceSettings;
import org.sidiff.history.analysis.validation.IValidator;
import org.sidiff.history.repository.IModelRepository;
import org.sidiff.history.repository.IModelVersion;
import org.sidiff.matching.api.MatchingFacade;
import org.sidiff.matching.model.Correspondence;
import org.sidiff.matching.model.Matching;
import org.sidiff.repair.historymodel.History;
import org.sidiff.repair.historymodel.HistoryModelFactory;
import org.sidiff.repair.historymodel.ModelStatus;
import org.sidiff.repair.historymodel.ValidationError;
import org.sidiff.repair.historymodel.Version;

public class HistoryModelGenerator {
	
	public static History generateHistory(String historyName, 
			IModelRepository repository, List<IModelVersion> revisions, 
			IValidator validator, DifferenceSettings settings) {
		
		History history = HistoryModelFactory.eINSTANCE.createHistory();
		history.setName(historyName);
		
		//// Load history ////
		
		// Load model data:
		for (int i = 0; i < revisions.size(); i++) {
			ResourceSet rss = new ResourceSetImpl();
			Resource resource = repository.loadModelVersion(rss, revisions.get(i));
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
			
			// TODO: Do we need this workaround!?
//			while (versionB.getStatus().equals(ModelStatus.DEFECT) && (j < (history.getVersions().size() - 1))) {
//				versionB = history.getVersions().get(++j);
//			}
			
			try {
//				if (versionA.getStatus().equals(ModelStatus.DEFECT)
//						|| versionB.getStatus().equals(ModelStatus.DEFECT)) {
//					continue;
//				}

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
	
	public static Version appendVersion(History history, Resource model, IValidator validator) {
		Version modelVersion = HistoryModelGenerator.generateVersion(
				history.getVersions().size(), model, validator);

		history.getVersions().add(modelVersion);

		HistoryModelGenerator.generateIntroducedAndResolved(history, validator, 
				history.getVersions().size() - 2, history.getVersions().size() - 1);
		
		return modelVersion;
	}
	
	private static Version generateVersion(int revision, Resource model, IValidator validator) {

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
	
	private static void generateIntroducedAndResolved(History history, IValidator validator, int firstVersion, int lastVersion) {
		
		
//		for (Version versionA : history.getVersions()) {
		for (int i = firstVersion; i <= lastVersion; i++) {
			Version versionA = history.getVersions().get(i);
			
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
		
//		List<Version> reverseOrder = new ArrayList<>();
//		reverseOrder.addAll(history.getVersions());
//		Collections.reverse(reverseOrder);
		
//		for (Version versionB : reverseOrder) {
		for (int i = lastVersion; i >= firstVersion; i--) {
			Version versionB = history.getVersions().get(i);
			
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
	
	private static void generateIntroducedAndResolved(History history, IValidator validator) {
		generateIntroducedAndResolved(history, validator, 0, history.getVersions().size() - 1);
	}
}
