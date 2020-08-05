package org.sidiff.history.analysis.tracing;

import java.util.Collection;
import java.util.Iterator;

import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.sidiff.generic.matcher.uuid.UUIDResource;
import org.sidiff.history.analysis.validation.IValidator;
import org.sidiff.history.repository.IModelHistory;
import org.sidiff.history.repository.IModelVersion;
import org.sidiff.historymodel.History;
import org.sidiff.historymodel.HistoryModelFactory;
import org.sidiff.historymodel.ModelStatus;
import org.sidiff.historymodel.Problem;
import org.sidiff.historymodel.Version;
import org.sidiff.revision.common.emf.EMFStorage;
import org.sidiff.revision.difference.Correspondence;
import org.sidiff.revision.difference.Difference;
import org.sidiff.revision.difference.api.DifferenceFacade;
import org.sidiff.revision.difference.api.settings.DifferenceSettings;

public class HistoryModelGenerator {
	
	public static History generateHistory(String historyName, 
			IModelHistory modelHistory, Iterator<IModelVersion> revisions, 
			IValidator validator, DifferenceSettings settings) {
		
		History history = HistoryModelFactory.eINSTANCE.createHistory();
		history.setName(historyName);
		
		//// Load history ////
		
		// Load model data:
		while(revisions.hasNext()) {
			IModelVersion revision = revisions.next();
			
			ResourceSet rss = new ResourceSetImpl();
			Resource resource = modelHistory.loadModelVersion(rss, revision);
			
			Version version = generateVersion(revision.getVersion(), resource, validator);
			
			if (version != null) {
				history.getVersions().add(version);
			}
		}
		
		ECollections.reverse(history.getVersions());
		
		//// Calculate matchings ////
		
		for (int i = 0; i < (history.getVersions().size() - 1); i++) {
			int j = i + 1;
			
			Version versionA = history.getVersions().get(i);
			Version versionB = history.getVersions().get(j);

			Difference matching = generateMatching(versionA, versionB, settings);
			generateUUIDs(matching);
		}
		
		generateIntroducedAndResolved(history, validator);
		
		return history;
	}
	
	public static Version appendVersion(History history, IModelHistory modelHistory, IModelVersion modelVersion, IValidator validator) {
		
		Resource model = modelHistory.loadModelVersion(new ResourceSetImpl(), modelVersion);
		Version historyVersion = HistoryModelGenerator.generateVersion(
				modelVersion.getVersion(), model, validator);
		history.getVersions().add(historyVersion);

		HistoryModelGenerator.generateIntroducedAndResolved(history, validator, 
				history.getVersions().size() - 2, history.getVersions().size() - 1);
		
		return historyVersion;
	}
	
	public static Version appendVersion(History history, Resource model, IValidator validator) {

		Version modelVersion = HistoryModelGenerator.generateVersion(
				"WORKING COPY", model, validator);
		history.getVersions().add(modelVersion);

		HistoryModelGenerator.generateIntroducedAndResolved(history, validator, 
				history.getVersions().size() - 2, history.getVersions().size() - 1);
		
		return modelVersion;
	}
	
	private static Version generateVersion(String repositoryVersion, Resource model, IValidator validator) {

		// Create version:
		Version version = HistoryModelFactory.eINSTANCE.createVersion();
		version.setModel(model);
		version.setRepositoryVersion(repositoryVersion);
		version.setName(printVersion(repositoryVersion) + " - " + model.getURI().lastSegment());
		
		// Validate version:
		validator.validate(version);
		Collection<Problem> problems = version.getProblems();
		
		ModelStatus modelStatus = problems.isEmpty() ? ModelStatus.VALID : ModelStatus.INVALID;
		version.setStatus(modelStatus);
		
		// Mark defect models
		for (Problem validationError : problems) {
			for (EObject element : validationError.getInvalidElements()) {
				if (element.eIsProxy()) {
					modelStatus = ModelStatus.DEFECT;
				}
			}
		}
		
		return version;
	}
	
	private static String printVersion(String repositoryVersion) {
		
		if (repositoryVersion != null) {
			try {
				int versionNumber = Integer.parseInt(repositoryVersion);
				return String.format("%04d", versionNumber);
			} catch (Exception e) {
			}
			
			return repositoryVersion;
		} else {
			return "n/a";
		}
	}
	
	private static Difference generateMatching(Version versionA, Version versionB, DifferenceSettings settings) {
		
		Resource resourceA = versionA.getModel();
		Resource resourceB = versionB.getModel();
		
		Difference matching = DifferenceFacade.match(resourceA, resourceB, settings);

		return matching;
	}
	
	private static void generateUUIDs(Difference matching) {
		for (Correspondence correspondence : matching.getCorrespondences()) {
			if (!UUIDResource.isDynamic(correspondence.getMatchedA()) && !UUIDResource.isDynamic(correspondence.getMatchedB())) {
				String uuid = EMFStorage.getXmiId(correspondence.getMatchedA());
				EMFStorage.setXmiId(correspondence.getMatchedB(), uuid);
			}
		}
	}
	
	private static void generateIntroducedAndResolved(History history, IValidator validator, int firstVersion, int lastVersion) {
		
		for (int i = firstVersion; i <= lastVersion; i++) {
			Version versionA = history.getVersions().get(i);
			
			if (!history.getSuccessorVersions(versionA).isEmpty()) {
				Version versionB = history.getSuccessorVersions(versionA).get(0);
				
				for (Problem errorB : versionB.getProblems()) {
					boolean hasCorresponding = false;
					
					for (Problem errorA : versionA.getProblems()) {
						if (validator.matchProblems(errorA, errorB)) {
							errorB.setPredecessor(errorA);
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
		
		for (int i = lastVersion; i >= firstVersion; i--) {
			Version versionB = history.getVersions().get(i);
			
			if (!history.getPredecessorVersions(versionB).isEmpty()) {
				Version versionA = history.getPredecessorVersions(versionB).get(0);
				
				for (Problem errorA : versionA.getProblems()) {
					boolean hasCorresponding = false;
					
					for (Problem errorB : versionB.getProblems()) {
						if (validator.matchProblems(errorA, errorB)) {
							errorA.setSuccessor(errorB);
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
