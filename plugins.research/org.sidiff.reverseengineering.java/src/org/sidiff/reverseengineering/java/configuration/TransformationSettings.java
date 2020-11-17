package org.sidiff.reverseengineering.java.configuration;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;

public class TransformationSettings {
	
	private String name = "System";

	private URI baseURI;
	
	private String modelFileExtension = "xmi";

	private boolean includeMethodBodies = true;
	
	private XMLResource workspaceModel;
	
	private XMLResource libraryModel;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public URI getBaseURI() {
		return baseURI;
	}

	public void setBaseURI(URI baseURI) {
		this.baseURI = baseURI;
	}

	public String getModelFileExtension() {
		return modelFileExtension;
	}

	public void setModelFileExtension(String modelFileExtension) {
		this.modelFileExtension = modelFileExtension;
	}

	public boolean isIncludeMethodBodies() {
		return includeMethodBodies;
	}

	public void setIncludeMethodBodies(boolean includeMethodBodies) {
		this.includeMethodBodies = includeMethodBodies;
	}

	public XMLResource getWorkspaceModel() {
		
		if (workspaceModel == null) {
			ResourceSet resourcesSet = (libraryModel != null) ? libraryModel.getResourceSet() : new ResourceSetImpl();
			this.workspaceModel = (XMLResource) resourcesSet
					.createResource(baseURI.appendSegment(getName()).appendFileExtension(modelFileExtension));
		}

		return workspaceModel;
	}

	public void setWorkspaceModel(XMLResource workspaceModel) {
		this.workspaceModel = workspaceModel;
	}

	public XMLResource getLibraryModel() {
		
		if (libraryModel == null) {
			ResourceSet resourcesSet = (workspaceModel != null) ? workspaceModel.getResourceSet() : new ResourceSetImpl();
			this.libraryModel = (XMLResource) resourcesSet
					.createResource(baseURI.appendSegment("Library").appendFileExtension(modelFileExtension));
		}
		
		return libraryModel;
	}

	public void setLibraryModel(XMLResource libraryModel) {
		this.libraryModel = libraryModel;
	}
}
