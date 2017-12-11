package org.sidiff.history.repository.svnkit;

import org.eclipse.emf.common.util.URI;
import org.sidiff.history.repository.IModelRepositoryConnector;
import org.sidiff.history.repository.IModelVersion;
import org.sidiff.history.repository.util.ModelRepositoryUtil;
import org.tmatesoft.svn.core.SVNException;
import org.tmatesoft.svn.core.wc.SVNClientManager;
import org.tmatesoft.svn.core.wc.SVNInfo;
import org.tmatesoft.svn.core.wc.SVNRevision;
import org.tmatesoft.svn.core.wc.SVNStatusClient;
import org.tmatesoft.svn.core.wc.SVNWCClient;

public class SVNModelRepositoryConnector implements IModelRepositoryConnector {

	@Override
	public boolean canHandle(URI resource) {
		try {
			SVNStatusClient client = SVNClientManager.newInstance().getStatusClient();
			return client.doStatus(ModelRepositoryUtil.getModelFile(resource), false).isVersioned();
		} catch (SVNException e) {
		}
		return false;
	}
	
	@Override
	public IModelVersion getModelVersion(URI resource) {
		try {
			SVNWCClient client = SVNClientManager.newInstance().getWCClient(); 
			SVNInfo info = client.doInfo(ModelRepositoryUtil.getModelFile(resource), SVNRevision.WORKING);
			
			SVNModelVersion modelVersion = new SVNModelVersion(info);
			modelVersion.setWorkspaceLocation(resource);
			
			return modelVersion;
		} catch (SVNException e) {
			e.printStackTrace();
		}
		return null;
	}
}
