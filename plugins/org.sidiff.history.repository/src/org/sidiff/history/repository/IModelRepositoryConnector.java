package org.sidiff.history.repository;

import org.eclipse.emf.ecore.resource.Resource;

public interface IModelRepositoryConnector {

	/**
	 * @param resource
	 *            A model resource.
	 * @return <code>true</code> if the resource is connected to the repository;
	 *         <code>false</code> otherwise.
	 */
	boolean canHandle(Resource resource);
	
	/**
	 * @param resource
	 *            A model resource.
	 * @return The associated repository version.
	 */
	IModelVersion getModelVersion(Resource resource);
}
