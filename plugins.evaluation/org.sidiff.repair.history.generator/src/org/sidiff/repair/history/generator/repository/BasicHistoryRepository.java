package org.sidiff.repair.history.generator.repository;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.sidiff.consistency.common.storage.UUIDResource;

public class BasicHistoryRepository implements IHistoryRepository {

	protected ResourceSet resourceSet;
	
	protected RepairURIHandler uriHandler;
	
	public BasicHistoryRepository(URI versionsTargetFolder) {
		resourceSet = new ResourceSetImpl();
		
		uriHandler = new RepairURIHandler(resourceSet, versionsTargetFolder, this);
		
		resourceSet.getLoadOptions().put(XMIResource.OPTION_SCHEMA_LOCATION, Boolean.TRUE);
		resourceSet.getLoadOptions().put(XMIResource.OPTION_URI_HANDLER, uriHandler);
	}
	
	@Override
	public String formatModelFileName(URI modelURI) {
		return modelURI.lastSegment();
	}

	@Override
	public String formatModelName(int revision, URI modelURI) {
		String fileExtension = modelURI.fileExtension();
		return String.format("%03d", revision) + "." + fileExtension;
	}

	@Override
	public Resource loadModel(URI modelURI) {
		Resource resource = null;
		
		// -> references model versions changed...
		do {
			uriHandler.setNeedsReload(false);
			resource = new UUIDResource(modelURI, resourceSet);
		} while(uriHandler.isNeedsReload());
		
		uriHandler.clear();
		return resource;
	}
	
	@Override
	public URI resolveModel(URI source, URI target) {
		return target;
	}
	
	@Override
	public URI getNextModelVersion(URI modelURI) {
		return null;
	}
	
	@Override
	public ResourceSet getResourceSet() {
		return resourceSet;
	}
}
