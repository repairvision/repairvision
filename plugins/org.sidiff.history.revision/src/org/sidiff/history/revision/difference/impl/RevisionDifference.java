package org.sidiff.history.revision.difference.impl;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.sidiff.history.revision.IVersion;
import org.sidiff.history.revision.difference.IRevisionDifference;
import org.sidiff.history.revision.util.SymmetricDifferenceUtil;
import org.sidiff.revision.difference.AttributeValueChange;
import org.sidiff.revision.difference.Change;
import org.sidiff.revision.difference.Correspondence;
import org.sidiff.revision.difference.Difference;
import org.sidiff.revision.difference.api.DifferenceFacade;
import org.sidiff.revision.difference.api.settings.DifferenceSettings;

public class RevisionDifference implements IRevisionDifference {

	private Difference difference;

	private LiftingGraphDomainMap domainMap;

	private LiftingGraphIndex index;

	public RevisionDifference(IVersion versionA, IVersion versionB, DifferenceSettings settings) {
		Resource resourceA = versionA.getTargetResource();
		Resource resourceB = versionB.getTargetResource();

		// Calculate difference:
		Difference difference = DifferenceFacade.difference(resourceA, resourceB, settings);

		// TODO: Test/Fix this...
//		TechnicalDifferenceBuilder techDiffBuilder = new TechnicalDifferenceBuilder();
//		RevisionDifference difference = techDiffBuilder.deriveTechDiff(
//				techDiffBuilder.getModel(versionA, settings.getScope()),
//				techDiffBuilder.getModel(versionB, settings.getScope()),
//				new ArrayList<>(matching.getCorrespondences()).iterator());

		// Create difference resource:
		ResourceSet differenceRSS = new ResourceSetImpl();
		Resource differenceResource = differenceRSS
				.createResource(getDifferenceURI(resourceA.getURI(), resourceB.getURI()));
		differenceResource.getContents().add(difference);

		// Create difference indices:
		init(difference);
	}

	protected URI getDifferenceURI(URI modelA, URI modelB) {
		return SymmetricDifferenceUtil.getDifferenceURI(modelA, modelB);
	}

	public RevisionDifference(Difference revisionDifference) {
		init(revisionDifference);
	}

	public void init(Difference revisionDifference) {
		this.difference = revisionDifference;
		this.domainMap = new LiftingGraphDomainMap(revisionDifference);
		this.index = new LiftingGraphIndex(revisionDifference);
		this.index.initialize();
	}

	@Override
	public List<EObject> getChangeDomain(EClass changeType, EObject changeDomainType) {
		return domainMap.getChangeDomain(changeType, changeDomainType);
	}

	@Override
	public int getChangeDomainSize(EClass changeType, EObject changeDomainType) {
		return domainMap.getChangeDomainSize(changeType, changeDomainType);
	}

	@Override
	public List<EObject> getAddObjectDomain(EClass type) {
		return domainMap.getAddObjectDomain(type);
	}

	@Override
	public int getAddObjectDomainSize(EClass type) {
		return domainMap.getAddObjectDomainSize(type);
	}

	@Override
	public List<EObject> getRemoveObjectDomain(EClass type) {
		return domainMap.getRemoveObjectDomain(type);
	}

	@Override
	public int getRemoveObjectDomainSize(EClass type) {
		return domainMap.getRemoveObjectDomainSize(type);
	}

	@Override
	public List<EObject> getAddReferenceDomain(EReference type) {
		return domainMap.getAddReferenceDomain(type);
	}

	@Override
	public int getAddReferenceDomainSize(EReference type) {
		return domainMap.getAddReferenceDomainSize(type);
	}

	@Override
	public List<EObject> getRemoveReferenceDomain(EReference type) {
		return domainMap.getRemoveReferenceDomain(type);
	}

	@Override
	public int getRemoveReferenceDomainSize(EReference type) {
		return domainMap.getRemoveReferenceDomainSize(type);
	}

	@Override
	public List<EObject> getAttributeValueChangeDomain(EAttribute type) {
		return domainMap.getAttributeValueChangeDomain(type);
	}

	@Override
	public int getAttributeValueChangeDomainSize(EAttribute type) {
		return domainMap.getAttributeValueChangeDomainSize(type);
	}

	@Override
	public Set<EStructuralFeature> getTypeNodes() {
		return domainMap.getTypeNodes();
	}

	@Override
	public Collection<Change> getLocalChanges(EObject element) {
		return index.getLocalChanges(element);
	}

	@Override
	public Change getOppositeChange(Change change) {
		return index.getOppositeChange(change);
	}

	@Override
	public <C extends Change> Iterator<C> getLocalChanges(EObject element, EReference reference, Class<C> changeType) {
		return index.getLocalChanges(element, reference, changeType);
	}

	@Override
	public Change getObjectChange(EObject element) {
		return index.getObjectChange(element);
	}

	@Override
	public AttributeValueChange getAttributeChange(EObject element, EAttribute attributeType) {
		return index.getAttributeChange(element, attributeType);
	}

	@Override
	public <C extends Change> Iterator<C> getReferenceChanges(EObject element, EReference referenceType) {
		return index.getReferenceChanges(element, referenceType);
	}

	@Override
	public Correspondence getCorrespondence(EObject modelElement, EReference correspondenceReference) {
		return index.getCorrespondence(modelElement, correspondenceReference);
	}

	@Override
	public Correspondence getCorrespondenceA(EObject modelElement) {
		return index.getCorrespondenceA(modelElement);
	}

	@Override
	public EObject getCorrespondingObjectInA(EObject objectInB) {
		return difference.getCorrespondingObjectInA(objectInB);
	}

	@Override
	public Correspondence getCorrespondenceB(EObject modelElement) {
		return index.getCorrespondenceB(modelElement);
	}

	@Override
	public EObject getCorrespondingObjectInB(EObject objectInA) {
		return difference.getCorrespondingObjectInB(objectInA);
	}

	@Override
	public Difference getSymmetricDifference() {
		return difference;
	}

	@Override
	public List<Change> getChanges() {
		return difference.getChanges();
	}

}
