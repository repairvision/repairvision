package org.sidiff.history.revision.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.sidiff.history.revision.IRevision;
import org.sidiff.history.revision.IVersion;
import org.sidiff.history.revision.difference.IRevisionDifference;
import org.sidiff.history.revision.difference.impl.RevisionDifference;
import org.sidiff.history.revision.metamodel.IMetaModel;
import org.sidiff.history.revision.metamodel.impl.MetaModel;
import org.sidiff.revision.difference.Change;
import org.sidiff.revision.difference.Difference;
import org.sidiff.revision.difference.api.settings.DifferenceSettings;

public class Revision implements IRevision {

	private MetaModel metamodel;
	
	private Version versionA;
	
	private Version versionB;
	
	private RevisionDifference revisionDifference;
	
	public Revision(Resource modelA, Resource modelB, DifferenceSettings differenceSettings) {
		this.versionA = new Version(modelA);
		this.versionB = new Version(modelB);
		
		initMetaModel(modelA, modelB);
		initVersions(modelA, modelB);
		initDifference(versionA, versionB, differenceSettings);
	}
	
	public Revision(Difference difference) {
		Resource modelA = difference.getModelA();
		Resource modelB = difference.getModelB();
		
		this.versionA = new Version(modelA);
		this.versionB = new Version(modelB);
		
		initMetaModel(modelA, modelB);
		initVersions(modelA, modelB);
		initDifference(difference);
	}
	
	protected void initMetaModel(Resource modelA, Resource modelB) {
		this.metamodel = new MetaModel();
	}
	
	protected void initVersions(Resource modelA, Resource modelB) {
		
		// resolve resource set of model A:
		Set<Resource> resourceSetA = resolve(modelA);
		resourceSetA.forEach(versionA::addResource);
		
		// resolve resource set of model B:
		Set<Resource> resourceSetB = resolve(modelB);
		resourceSetB.forEach(versionB::addResource);
	}
	
	@SuppressWarnings("unchecked")
	protected Set<Resource> resolve(Resource model) {
		Set<Resource> resolved = new HashSet<>();
		Set<Resource> newResolved = new HashSet<>();
		newResolved.add(model);
		
		while (!newResolved.isEmpty()) {
			List<Resource> lastResolved = new ArrayList<>(newResolved);
			resolved.addAll(newResolved);
			newResolved.clear();
			
			for (Resource resource : lastResolved) {
				resource.getAllContents().forEachRemaining(element -> {
					for (EReference reference : element.eClass().getEAllReferences()) {
						
						// search for cross-resource references:
						if (!reference.isContainment() || !reference.isContainer() 
								|| !reference.isTransient() || !reference.isVolatile()) {
							if (reference.isMany()) {
								for (EObject referencedElement : (Collection<EObject>) element.eGet(reference)) {
									Resource referencedResource = referencedElement.eResource();
									
									if (!resolved.contains(referencedResource)) {
										if (referencedResource != null) {
											newResolved.add(referencedResource);
										}
									}
								}
							} else {
								Object referencedElement = element.eGet(reference);
								
								if (referencedElement instanceof EObject) {
									Resource referencedResource = ((EObject) referencedElement).eResource();
									
									if (!resolved.contains(referencedResource)) {
										if (referencedResource != null) {
											newResolved.add(referencedResource);
										}
									}
								}
							}
						}
					}
				});
			}
		}
		
		return resolved;
	}
	
	protected void initDifference(IVersion versionA, IVersion versionB, DifferenceSettings differenceSettings) {
		this.revisionDifference = new RevisionDifference(versionA, versionB, differenceSettings);
	}
	
	protected void initDifference(Difference revisionDifference) {
		this.revisionDifference = new RevisionDifference(revisionDifference);
	}
	
	@Override
	public IVersion getVersionA() {
		return versionA;
	}

	@Override
	public IVersion getVersionB() {
		return versionB;
	}
	
	@Override
	public IRevisionDifference getDifference() {
		return revisionDifference;
	}

	@Override
	public IMetaModel getMetaModel() {
		return metamodel;
	}
	
	public static Resource createEmptyModel(Resource successorVersion) {
		URI emptyModelVersionURI = successorVersion.getURI();
		emptyModelVersionURI = emptyModelVersionURI.trimSegments(1).appendSegment("empty");
		emptyModelVersionURI = emptyModelVersionURI.appendSegment(successorVersion.getURI().lastSegment());
		
		Resource emptyModel = new ResourceImpl(emptyModelVersionURI);
		new ResourceSetImpl().getResources().add(emptyModel);
		return emptyModel;
	}
	
	@Override
	public String toString() {
		StringBuilder string = new StringBuilder();
		
		for (Change change : getDifference().getSymmetricDifference().getChanges()) {
			string.append(change);
			string.append("\n");
		}
		
		return string.toString();
	}
}
