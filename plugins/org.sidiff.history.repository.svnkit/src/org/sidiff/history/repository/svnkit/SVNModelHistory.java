package org.sidiff.history.repository.svnkit;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.sidiff.history.repository.IModelHistory;
import org.sidiff.history.repository.IModelVersion;
import org.sidiff.history.repository.util.ModelRepositoryUtil;
import org.tmatesoft.svn.core.SVNException;
import org.tmatesoft.svn.core.io.SVNRepository;
import org.tmatesoft.svn.core.io.SVNRepositoryFactory;

public class SVNModelHistory implements IModelHistory {
	
	private SVNModelVersion latestModelVersion;
	
	private SVNRepository repository;
	
	public SVNModelHistory(SVNModelVersion modelVersion) {
		this.latestModelVersion = modelVersion;
		
		try {
			this.repository = SVNRepositoryFactory.create(modelVersion.getSVNRepositoryLocation());
		} catch (SVNException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Resource loadModelVersion(ResourceSet resourceSet, IModelVersion modelVersion) {
		
		try {
			
			// Check out:
			SVNModelVersion svnModelVersion = (SVNModelVersion) modelVersion;
			File localFile = ModelRepositoryUtil.getModelFile(svnModelVersion.getWorkspaceLocation());
			localFile.getParentFile().mkdirs();
			
			try (FileOutputStream fos = new FileOutputStream(localFile)) {
				repository.getFile("", svnModelVersion.getSVNVersion().getNumber(), null, fos);
				fos.flush();
			}
			
			// Load model:
			return resourceSet.getResource(svnModelVersion.getWorkspaceLocation(), true);
			
		}  catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public Iterator<IModelVersion> iterator() {
		return new SVNModelHistoryIterator(latestModelVersion);
	}

	@Override
	public void close() throws IOException {
		if (repository != null) {
			repository.closeSession();
		}
	}
}
