package org.sidiff.history.revision.difference.impl;

import static org.sidiff.difference.technical.api.TechnicalDifferenceFacade.deriveTechnicalDifference;

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
import org.sidiff.common.emf.exceptions.InvalidModelException;
import org.sidiff.common.emf.exceptions.NoCorrespondencesException;
import org.sidiff.difference.symmetric.AddObject;
import org.sidiff.difference.symmetric.AttributeValueChange;
import org.sidiff.difference.symmetric.Change;
import org.sidiff.difference.symmetric.SymmetricDifference;
import org.sidiff.difference.symmetric.SymmetricFactory;
import org.sidiff.difference.technical.api.settings.DifferenceSettings;
import org.sidiff.history.revision.difference.IDifference;
import org.sidiff.history.revision.util.SymmetricDifferenceUtil;
import org.sidiff.matching.model.Correspondence;

public class Difference implements IDifference {

	private SymmetricDifference symmetricDifference;
	
	private LiftingGraphDomainMap domainMap;
	
	private LiftingGraphIndex index;
	
	public Difference(Resource resourceA, Resource resourceB, DifferenceSettings differenceSettings) {
		
		// Disable merge imports:
		// FIXME: setMergeImports(true) -> Wrong technical difference for EGenericTypes!
		differenceSettings.setMergeImports(false);
//		settings.getDifferenceSettings().setScope(Scope.RESOURCE);
		
		// Calculate difference:
		try {
			symmetricDifference = deriveTechnicalDifference(resourceA, resourceB, differenceSettings);
		} catch (InvalidModelException | NoCorrespondencesException e) {
			e.printStackTrace();
		}
		
		// Create difference resource:
		ResourceSet differenceRSS = new ResourceSetImpl(); 
		Resource differenceResource = differenceRSS.createResource(
				getDifferenceURI(resourceA.getURI(), resourceB.getURI()));
		differenceResource.getContents().add(symmetricDifference);
		
		// Create difference indices:
		init(symmetricDifference);
	}
	
	protected URI getDifferenceURI(URI modelA, URI modelB) {
		return SymmetricDifferenceUtil.getDifferenceURI(modelA, modelB);
	}
	
	public Difference(SymmetricDifference symmetricDifference) {
		init(symmetricDifference);
	}
	
	public void init(SymmetricDifference symmetricDifference) {
		
		// TODO/FIXME[Workaround]: Handle "real" empty historic models, i.e. without root element!
		if (symmetricDifference.getChanges().isEmpty()) {
			if (symmetricDifference.getModelA().getContents().size() == 1) {
				AddObject addRoot = SymmetricFactory.eINSTANCE.createAddObject();
				addRoot.setObj(symmetricDifference.getModelB().getContents().get(0));
				symmetricDifference.getChanges().add(addRoot);
			}
		}
		
		this.symmetricDifference = symmetricDifference;
		this.domainMap = new LiftingGraphDomainMap(symmetricDifference);
		this.index = new LiftingGraphIndex(symmetricDifference);
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
		return symmetricDifference.getCorrespondingObjectInA(objectInB);
	}

	@Override
	public Correspondence getCorrespondenceB(EObject modelElement) {
		return index.getCorrespondenceB(modelElement);
	}

	@Override
	public EObject getCorrespondingObjectInB(EObject objectInA) {
		return symmetricDifference.getCorrespondingObjectInB(objectInA);
	}
	
	@Override
	public SymmetricDifference getSymmetricDifference() {
		return symmetricDifference;
	}

	@Override
	public List<Change> getChanges() {
		return symmetricDifference.getChanges();
	}

}
