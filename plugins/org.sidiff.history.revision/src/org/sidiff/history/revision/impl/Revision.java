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
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.sidiff.difference.symmetric.SymmetricDifference;
import org.sidiff.difference.technical.api.settings.DifferenceSettings;
import org.sidiff.history.revision.IRevision;
import org.sidiff.history.revision.IVersion;
import org.sidiff.history.revision.difference.IDifference;
import org.sidiff.history.revision.difference.impl.Difference;
import org.sidiff.history.revision.metamodel.IMetaModel;
import org.sidiff.history.revision.metamodel.impl.MetaModel;

public class Revision implements IRevision {

	private MetaModel metamodel;
	
	private Version versionA;
	
	private Version versionB;
	
	private Difference difference;
	
	public Revision(URI uriModelA, URI uriModelB, DifferenceSettings differenceSettings) {
		Resource modelA = new ResourceSetImpl().getResource(uriModelA, true);
		Resource modelB = new ResourceSetImpl().getResource(uriModelB, true);
		
		initMetaModel(modelA, modelB);
		initVersions(modelA, modelB);
		initDifference(modelA, modelB, differenceSettings);
	}
	
	public Revision(Resource modelA, Resource modelB, DifferenceSettings differenceSettings) {
		this.versionA = new Version(modelA);
		this.versionB = new Version(modelB);
		
		initMetaModel(modelA, modelB);
		initVersions(modelA, modelB);
		initDifference(modelA, modelB, differenceSettings);
	}
	
	public Revision(SymmetricDifference symmetricDifference) {
		Resource modelA = symmetricDifference.getModelA();
		Resource modelB = symmetricDifference.getModelB();
		
		this.versionA = new Version(modelA);
		this.versionB = new Version(modelB);
		
		initMetaModel(modelA, modelB);
		initVersions(modelA, modelB);
		initDifference(symmetricDifference);
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
										newResolved.add(referencedResource);
									}
								}
							} else {
								Object referencedElement = element.eGet(reference);
								
								if (referencedElement instanceof EObject) {
									Resource referencedResource = ((EObject) referencedElement).eResource();
									
									if (!resolved.contains(referencedResource)) {
										newResolved.add(referencedResource);
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
	
	protected void initDifference(Resource modelA, Resource modelB, DifferenceSettings differenceSettings) {
		this.difference = new Difference(modelA, modelB, differenceSettings);
	}
	
	protected void initDifference(SymmetricDifference symmetricDifference) {
		this.difference = new Difference(symmetricDifference);
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
	public IDifference getDifference() {
		return difference;
	}

	@Override
	public IMetaModel getMetaModel() {
		return metamodel;
	}
}
