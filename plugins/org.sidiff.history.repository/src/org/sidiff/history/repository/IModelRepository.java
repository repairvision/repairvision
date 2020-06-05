package org.sidiff.history.repository;

public interface IModelRepository {
	
	/**
	 * @param location
	 *            The repository location and version of the model.
	 * @return The model history, starting with the most recent model version.
	 */
	IModelHistory getModelVersions(IModelVersion modelVersion);
	
}
