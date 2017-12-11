package org.sidiff.history.analysis.tracing;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.sidiff.common.emf.modelstorage.EMFStorage;
import org.sidiff.consistency.common.ui.util.WorkbenchUtil;
import org.sidiff.difference.technical.api.settings.DifferenceSettings;
import org.sidiff.history.analysis.validation.IValidator;
import org.sidiff.history.repository.IModelRepository;
import org.sidiff.history.repository.IModelRepositoryConnector;
import org.sidiff.history.repository.IModelVersion;
import org.sidiff.history.repository.registry.ModelRepositoryRegistry;
import org.sidiff.repair.historymodel.History;
import org.sidiff.repair.historymodel.ValidationError;
import org.sidiff.repair.historymodel.Version;
import org.sidiff.validation.constraint.api.util.Validation;
import org.sidiff.validation.constraint.interpreter.IConstraint;

public class HistoryModelDatabase {
	
	public static Resource getHistoricConsistentModel(Resource inconsistentModel, 
			IValidator validator, Validation inconsistency, DifferenceSettings settings) {
		
		URI historyDatabaseURI = inconsistentModel.getURI().appendFileExtension("history");
		File historyDatabaseFile = EMFStorage.uriToFile(historyDatabaseURI);
		History history = null;
		
		IModelRepository repository = ModelRepositoryRegistry.getRepository(inconsistentModel);
		IModelRepositoryConnector repositoryConnector = ModelRepositoryRegistry.getConnector(repository);
		IModelVersion inconsistentModelVersion = repositoryConnector.getModelVersion(inconsistentModel.getURI());
		
		// Update history database:
		if (historyDatabaseFile.exists()) {
			
			// Load history model:
			ResourceSet rss = new ResourceSetImpl();
			Resource historyResource = rss.getResource(historyDatabaseURI, true);
			history = (History) historyResource.getContents().get(0);
			
			// Search current model version in history:
			Version inconsistentHistoryVersion = getHistoryVersion(repository, inconsistentModelVersion, history);
			
			// Detached history: 
			if (inconsistentHistoryVersion != null) {
				while (inconsistentHistoryVersion != history.getVersions().get(history.getVersions().size() - 1)) {
					history.getVersions().remove(history.getVersions().size() - 1);
				}
			}
			
			// Append new versions from repository:
			if ((inconsistentHistoryVersion == null) && WorkbenchUtil.showQuestion("Update history log?")) {
				Iterator<IModelVersion> revisions = repository.getModelVersions(inconsistentModelVersion);
				int latestHistoryVersionIndex = history.getVersions().size() - 1;
				Version latestHistoryVersion = history.getVersions().get(latestHistoryVersionIndex);

				// Read new version:
				List<IModelVersion> newVersions = new ArrayList<>();

				while (revisions.hasNext()) {
					IModelVersion revision = revisions.next();

					if (!latestHistoryVersion.getRepositoryVersion().equals(revision.getVersion())) {
						newVersions.add(revision);
					}
				}

				// Append new version:
				Collections.reverse(newVersions);

				for (IModelVersion newVersion : newVersions) {
					HistoryModelGenerator.appendVersion(history, repository, newVersion, validator);
				}

				try {
					history.eResource().save(Collections.EMPTY_MAP);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} 
		
		// Create new history database:
		else {
			
			// Check out revisions:
			Iterator<IModelVersion> revisions = repository.getModelVersions(inconsistentModelVersion);
			
			// Search inconsistency traces:
			history = HistoryModelGenerator.generateHistory(
					inconsistentModel.getURI().toString(), 
					repository, revisions, 
					validator, settings);
			
			try {
				ResourceSet rss = new ResourceSetImpl();
				Resource historyResource = rss.createResource(inconsistentModel.getURI().appendFileExtension("history"));
				historyResource.getContents().add(history);
				
				historyResource.save(Collections.emptyMap());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		// Add current version:
		HistoryModelGenerator.appendVersion(history, inconsistentModel, validator);
		
		// Find last consistent version:
		if (history != null) {
			Version versionModelB = history.getVersions().get(history.getVersions().size() - 1);
			ValidationError validationError = getValidationError(inconsistency, versionModelB);
			Version lastConsistentVersion = getPrecessorRevision(validationError.getIntroducedIn());
			
			if (lastConsistentVersion != null) {
				return lastConsistentVersion.getModel();
			}
		}
			
		return null;
	}
	
	public static Version getHistoryVersion(IModelRepository repository, IModelVersion modelVersion, History history) {
		
		for (Version version : history.getVersions()) {
			String lastRepositoryVersion = version.getRepositoryVersion();
		
			if (lastRepositoryVersion.equals(modelVersion.getVersion())) {
				return version;
			}
		}
		
		return null;
	}
	
	public static Version getPrecessorRevision(Version version) {
		History history = (History) version.eContainer();
		int index = history.getVersions().indexOf(version);

		if ((index - 1) >= 0) {
			return history.getVersions().get(index - 1);
		}
		
		return null;
	}
	
	public static ValidationError getValidationError(Validation validation, Version model) {
		
		for(ValidationError nextValidationError : model.getValidationErrors()) {
			if (equalsValidation(validation, nextValidationError)) {
				return nextValidationError;
			}
		}
		
		return null;
	}
	
	public static boolean equalsValidation(Validation validationA, ValidationError validationB) {
		
		if (getValidationID(validationA.getRule()).equalsIgnoreCase(getValidationID(validationB))) {
			EObject invalidElementA = validationA.getContext();
			EObject invalidElementB = validationB.getContext();

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
	
	public static String getValidationID(ValidationError validation) {
		return getValidationID(validation.getName());
	}
}
