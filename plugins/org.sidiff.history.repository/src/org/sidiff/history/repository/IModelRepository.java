package org.sidiff.history.repository;

import java.util.Iterator;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;

public interface IModelRepository {
	
	/**
	 * @param location
	 *            The repository location and version of the model.
	 * @return The model history, starting with the most recent model version.
	 */
	Iterator<IModelVersion> getModelVersions(IModelVersion modelVersion);
	
	/**
	 * @param resourceSet
	 *            The resource set for loading the model.
	 * @param modelVersion
	 *            The model version to be loaded.
	 * @return The loaded model resource.
	 */
	Resource loadModelVersion(ResourceSet resourceSet, IModelVersion modelVersion);

	/**
	 * @param modelVersion
	 *            The model version version which contains the model URI.
	 * @param modelURI
	 *            The model URI to be resolved.
	 * @return The resolved model history w.r.t. the given model version.
	 */
	Iterator<IModelVersion> resolveModelVersion(IModelVersion contextModelVersion, URI modelURI);
}
