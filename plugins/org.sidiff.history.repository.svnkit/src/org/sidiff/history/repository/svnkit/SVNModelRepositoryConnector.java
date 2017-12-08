package org.sidiff.history.repository.svnkit;

import org.eclipse.emf.ecore.resource.Resource;
import org.sidiff.history.repository.IModelRepositoryConnector;
import org.sidiff.history.repository.IModelVersion;
import org.sidiff.history.repository.util.ModelRepositoryUtil;
import org.tmatesoft.svn.core.SVNException;
import org.tmatesoft.svn.core.wc.SVNClientManager;
import org.tmatesoft.svn.core.wc.SVNInfo;
import org.tmatesoft.svn.core.wc.SVNRevision;
import org.tmatesoft.svn.core.wc.SVNWCClient;

public class SVNModelRepositoryConnector implements IModelRepositoryConnector {

	@Override
	public boolean canHandle(Resource resource) {
		try {
			SVNWCClient client = SVNClientManager.newInstance().getWCClient(); 
			client.doInfo(ModelRepositoryUtil.getModelFile(resource), SVNRevision.HEAD);
			
			return true;
		} catch (SVNException e) {
		}
		return false;
	}
	
	@Override
	public IModelVersion getModelVersion(Resource resource) {
		try {
			SVNWCClient client = SVNClientManager.newInstance().getWCClient(); 
			SVNInfo info = client.doInfo(ModelRepositoryUtil.getModelFile(resource), SVNRevision.WORKING);
			
			SVNModelVersion modelVersion = new SVNModelVersion(info);
			modelVersion.setWorkspaceLocation(resource.getURI());
			
			return modelVersion;
		} catch (SVNException e) {
			e.printStackTrace();
		}
		return null;
	}
}
