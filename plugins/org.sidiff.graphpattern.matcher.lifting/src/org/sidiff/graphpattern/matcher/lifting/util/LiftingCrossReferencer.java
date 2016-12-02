package org.sidiff.graphpattern.matcher.lifting.util;

import java.util.Collections;
import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.sidiff.difference.symmetric.Change;
import org.sidiff.graphpattern.wgraph.construction.tools.matching.CrossReferencer;
import org.sidiff.matching.model.MatchingModelPackage;

public class LiftingCrossReferencer extends CrossReferencer {

	private LiftingGraphIndex changeIndex;
	
	private LiftingGraphDomainMap changeDomainMap;
	
	public LiftingCrossReferencer(ResourceSet resourceSet, 
			LiftingGraphIndex changeIndex,
			LiftingGraphDomainMap changeDomainMap) {
		
		super(resourceSet);
		this.changeIndex = changeIndex;
		this.changeDomainMap = changeDomainMap;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Iterator<? extends EObject> getInverse(EObject target, EReference inverse) {
		
		
		if (target.eClass() == MatchingModelPackage.eINSTANCE.getCorrespondence()) {
			// Model-Element (target) <- Correspondence
			return Collections.singletonList(changeIndex.getCorrespondence(target, inverse)).iterator();
		}
		
		else if (RecognitionRuleUtil.isChangeTypeReference(inverse)) {
			// Type (target) <- Change 
			return changeDomainMap.getChangeDomain(inverse.getEContainingClass(), target).iterator();
		}
		
		else if (RecognitionRuleUtil.isChangeReference(inverse)) {
			// Model-Element (target) <- Change 
			Class<? extends Change> changeType = (Class<? extends Change>) inverse.getEContainingClass().getInstanceClass();
			return changeIndex.getLocalChanges(target, inverse, changeType);
		}
		
		else {
			// Generic (EMF) cross-references:
			return super.getInverse(target, inverse);
		}
	}
}
