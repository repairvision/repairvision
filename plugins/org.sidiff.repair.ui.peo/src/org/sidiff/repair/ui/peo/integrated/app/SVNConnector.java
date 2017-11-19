package org.sidiff.repair.ui.peo.integrated.app;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.resource.Resource;
import org.sidiff.common.emf.modelstorage.EMFStorage;
import org.tmatesoft.svn.core.SVNException;
import org.tmatesoft.svn.core.SVNLogEntry;
import org.tmatesoft.svn.core.SVNURL;
import org.tmatesoft.svn.core.io.SVNRepository;
import org.tmatesoft.svn.core.io.SVNRepositoryFactory;
import org.tmatesoft.svn.core.wc.SVNClientManager;
import org.tmatesoft.svn.core.wc.SVNInfo;
import org.tmatesoft.svn.core.wc.SVNRevision;
import org.tmatesoft.svn.core.wc.SVNWCClient;

public class SVNConnector {
		
	private Resource resource;
	
	private SVNURL svnURL;

    public SVNConnector(Resource resource) {
    	this.resource = resource;
    	
		try {
			SVNWCClient client = SVNClientManager.newInstance().getWCClient(); 
			SVNInfo info = client.doInfo(EMFStorage.uriToFile(resource.getURI()), SVNRevision.WORKING);
			this.svnURL = info.getURL();
		} catch (SVNException e) {
			e.printStackTrace();
		} 
	}
    
	public List<File> getRevisions() {
		List<File> revisions = new ArrayList<>();
		
		try {
			SVNRepository repos = SVNRepositoryFactory.create(svnURL);
			
			long revision = repos.getLatestRevision();
			boolean changePath = false; 
			Collection<?> logEntries = repos.log(new String[] { svnURL.getPath() }, 
					(Collection<?>) null, revision, 0, changePath, false);
			
			for (Iterator<?> logs = logEntries.iterator(); logs.hasNext();) {
				SVNLogEntry logEntry = (SVNLogEntry) logs.next();
				
				String localPath = getLocalFilePath(logEntry);
				File localFile = new File(localPath);
				localFile.getParentFile().mkdirs();
				
				revisions.add(localFile);
				
				FileOutputStream fos = new FileOutputStream(localFile);
				repos.getFile("", logEntry.getRevision(), null, fos);
				fos.flush();
				fos.close();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return revisions;
	}
	
	protected String getLocalFilePath(SVNLogEntry logEntry) {
		File file = EMFStorage.uriToFile(resource.getURI());
    	return file.getParent().toString() + "/" + file.getName() + ".history.versions/" + logEntry.getRevision() + "/" + file.getName();
    }
}