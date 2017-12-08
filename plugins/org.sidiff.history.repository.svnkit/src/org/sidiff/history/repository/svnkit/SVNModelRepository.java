package org.sidiff.history.repository.svnkit;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.sidiff.history.repository.IModelRepository;
import org.sidiff.history.repository.IModelVersion;
import org.sidiff.history.repository.util.ModelRepositoryUtil;
import org.tmatesoft.svn.core.SVNLogEntry;
import org.tmatesoft.svn.core.SVNURL;
import org.tmatesoft.svn.core.io.SVNRepository;
import org.tmatesoft.svn.core.io.SVNRepositoryFactory;

public class SVNModelRepository implements IModelRepository {

	private boolean changePath = false;
	
	@Override
	public List<IModelVersion> getModelVersions(IModelVersion modelVersion) {
		List<IModelVersion> history = new ArrayList<>();
		
		try {
			SVNModelVersion svnModelVersion = (SVNModelVersion) modelVersion;
			SVNURL location = svnModelVersion.getRepositoryLocation();
			
			SVNRepository repository = SVNRepositoryFactory.create(location);
			Collection<?> logEntries = repository.log(new String[] { location.getPath() }, 
					(Collection<?>) null, svnModelVersion.getVersion().getNumber(), 0, changePath, false);
			
			for (Iterator<?> logs = logEntries.iterator(); logs.hasNext();) {
				SVNLogEntry logEntry = (SVNLogEntry) logs.next();
				SVNModelVersion historicVersion = new SVNModelVersion(logEntry.getRevision(), location);
				historicVersion.setWorkspaceLocation(svnModelVersion.getWorkspaceLocation(), logEntry.getRevision());
				history.add(historicVersion);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return history;
	}

	@Override
	public Resource loadModelVersion(ResourceSet resourceSet, IModelVersion modelVersion) {
		
		try {
			
			// Check out:
			SVNModelVersion svnModelVersion = (SVNModelVersion) modelVersion;
			SVNRepository repository = SVNRepositoryFactory.create(svnModelVersion.getRepositoryLocation());
			
			File localFile = ModelRepositoryUtil.getModelFile(svnModelVersion.getWorkspaceLocation());
			localFile.getParentFile().mkdirs();
			
			FileOutputStream fos = new FileOutputStream(localFile);
			repository.getFile("", svnModelVersion.getVersion().getNumber(), null, fos);
			fos.flush();
			fos.close();
			
			// Load model:
			return resourceSet.getResource(svnModelVersion.getWorkspaceLocation(), true);
			
		}  catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public IModelVersion resolveModelVersion(IModelVersion contextModelVersion, URI modelURI) {
		throw new UnsupportedOperationException();
	}
}
