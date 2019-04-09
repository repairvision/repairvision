package org.sidiff.history.repository;

import org.eclipse.emf.common.util.URI;

public interface IModelVersion {

	/**
	 * @return The history version of the model.
	 */
	String getVersion();
	
	/**
	 * @return The repository location of the model.
	 */
	String getRepositoryLocation();
	
	/**
	 * @return The workspace location of the model.
	 */
	URI getWorkspaceLocation();
}
