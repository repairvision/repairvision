package org.sidiff.history.repository.svnkit;

import org.eclipse.emf.common.util.URI;
import org.sidiff.history.repository.IModelVersion;
import org.sidiff.history.repository.util.ModelRepositoryUtil;
import org.tmatesoft.svn.core.SVNURL;
import org.tmatesoft.svn.core.wc.SVNInfo;
import org.tmatesoft.svn.core.wc.SVNRevision;

public class SVNModelVersion implements IModelVersion {

	private SVNRevision version;
	
	private SVNURL repositoryLocation;
	
	private URI workspaceLocation;
	
	public SVNModelVersion(SVNInfo info) {
		this.version = info.getRevision();
		this.repositoryLocation = info.getURL();
	}
	
	public SVNModelVersion(SVNRevision revision, SVNURL repositoryLocation) {
		this.version = revision;
		this.repositoryLocation = repositoryLocation;
	}
	
	public SVNModelVersion(long revisionNumber, SVNURL repositoryLocation) {
		this.version = SVNRevision.create(revisionNumber);
		this.repositoryLocation = repositoryLocation;
	}
	
	@Override
	public String getVersion() {
		return version.getNumber() + "";
	}

	public SVNRevision getSVNVersion() {
		return version;
	}
	

	@Override
	public String getRepositoryLocation() {
		return repositoryLocation.getPath();
	}

	public SVNURL getSVNRepositoryLocation() {
		return repositoryLocation;
	}

	@Override
	public URI getWorkspaceLocation() {
		return workspaceLocation;
	}
	
	public void setWorkspaceLocation(URI workspaceLocation) {
		this.workspaceLocation = workspaceLocation;
	}
	
	public void setWorkspaceLocation(URI workingCopy, long revision) {
		this.workspaceLocation = ModelRepositoryUtil.generateWorkspaceLocation(workingCopy, revision + "");
	}
}
