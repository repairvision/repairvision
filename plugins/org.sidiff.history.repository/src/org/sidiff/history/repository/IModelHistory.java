package org.sidiff.history.repository;

import java.io.Closeable;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;

public interface IModelHistory extends Iterable<IModelVersion>, Closeable {

	/**
	 * @param resourceSet
	 *            The resource set for loading the model.
	 * @param modelVersion
	 *            The model version to be loaded.
	 * @return The loaded model resource.
	 */
	Resource loadModelVersion(ResourceSet resourceSet, IModelVersion modelVersion);
}
