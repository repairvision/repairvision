package org.sidiff.repair.history.generator.repository;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMIResource;

public class BasicHistoryRepository implements IHistoryRepository {

	protected ResourceSet resourceSet;
	
	protected RepairURIHandler uriHandler;
	
	public BasicHistoryRepository() {
		resourceSet = new ResourceSetImpl();
		
		uriHandler = new RepairURIHandler(this);
		
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
		return uriHandler.loadModel(modelURI);
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
	public Set<String> getReferencedModels() {
		return uriHandler.getReferencedModels();
	}
	
	@Override
	public void sortHistory(List<URI> files) {
		files.sort(new Comparator<URI>() {

			@Override
			public int compare(URI uriA, URI uriB) {
				return uriA.toString().compareTo(uriB.toString());
			}
		});
	}
	
	@Override
	public ResourceSet getResourceSet() {
		return resourceSet;
	}
}
