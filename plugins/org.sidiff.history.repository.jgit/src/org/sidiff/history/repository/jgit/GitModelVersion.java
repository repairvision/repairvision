package org.sidiff.history.repository.jgit;

import org.eclipse.emf.common.util.URI;
import org.eclipse.jgit.lib.ObjectId;
import org.sidiff.history.repository.IModelVersion;
import org.sidiff.history.repository.util.ModelRepositoryUtil;

public class GitModelVersion implements IModelVersion {

	private ObjectId objectID;
	
	private String repository;
	
	private String repositoryLocation;
	
	private URI workspaceLocation;
	
	public GitModelVersion(ObjectId objectID, String repository, String repositoryLocation) {
		this.objectID = objectID;
		this.repositoryLocation = repositoryLocation;
		this.repository = repository;
	}
	
	public ObjectId getObjectID() {
		return objectID;
	}
	
	@Override
	public String getVersion() {
		return objectID.getName();
	}
	
	public String getRepository() {
		return repository;
	}

	@Override
	public String getRepositoryLocation() {
		return repositoryLocation;
	}
	
	@Override
	public URI getWorkspaceLocation() {
		return workspaceLocation;
	}
	
	public void setWorkspaceLocation(URI workspaceLocation) {
		this.workspaceLocation = workspaceLocation;
	}
	
	public void setWorkspaceLocation(URI workingCopy, String revision) {
		this.workspaceLocation = ModelRepositoryUtil.generateWorkspaceLocation(workingCopy, revision);
	}

}
