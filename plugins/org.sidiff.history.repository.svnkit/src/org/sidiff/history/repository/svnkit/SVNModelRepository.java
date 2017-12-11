package org.sidiff.history.repository.svnkit;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Iterator;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.sidiff.history.repository.IModelRepository;
import org.sidiff.history.repository.IModelRepositoryConnector;
import org.sidiff.history.repository.IModelVersion;
import org.sidiff.history.repository.registry.ModelRepositoryRegistry;
import org.sidiff.history.repository.util.ModelRepositoryUtil;
import org.tmatesoft.svn.core.io.SVNRepository;
import org.tmatesoft.svn.core.io.SVNRepositoryFactory;

public class SVNModelRepository implements IModelRepository {

	@Override
	public Iterator<IModelVersion> getModelVersions(IModelVersion modelVersion) {
		return new SVNHistoryIterator((SVNModelVersion) modelVersion);
	}

	@Override
	public Resource loadModelVersion(ResourceSet resourceSet, IModelVersion modelVersion) {
		
		try {
			
			// Check out:
			SVNModelVersion svnModelVersion = (SVNModelVersion) modelVersion;
			SVNRepository repository = SVNRepositoryFactory.create(svnModelVersion.getSVNRepositoryLocation());
			
			File localFile = ModelRepositoryUtil.getModelFile(svnModelVersion.getWorkspaceLocation());
			localFile.getParentFile().mkdirs();
			
			FileOutputStream fos = new FileOutputStream(localFile);
			repository.getFile("", svnModelVersion.getSVNVersion().getNumber(), null, fos);
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
	public Iterator<IModelVersion> resolveModelVersion(IModelVersion contextModelVersion, URI modelURI) {
		IModelRepositoryConnector connector = ModelRepositoryRegistry.getConnector(this);
		IModelVersion modelVersion = connector.getModelVersion(modelURI);
		return getModelVersions(modelVersion);
	}
}
