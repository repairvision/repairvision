package org.sidiff.history.revision.metamodel.impl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.sidiff.history.revision.metamodel.IMetaModel;

public class MetaModel implements IMetaModel {
	
	private Map<EPackage, SubTypeIndex> subTypeIndex = new HashMap<>();
	
	private Map<EPackage, IncomingReferenceIndex> incomingReferenceIndex = new HashMap<>();

	@Override
	public Set<EClass> getAllSuperTypes(EClass eClass) {
		return new HashSet<>(eClass.getEAllSuperTypes());
	}
	
	@Override
	public Set<EClass> getAllSubTypes(EClass eClass) {
		EPackage ePackage = eClass.getEPackage(); 
		
		if (!(subTypeIndex.containsKey(ePackage))) {
			subTypeIndex.put(ePackage, new SubTypeIndex(ePackage));
		}
		
		return subTypeIndex.get(ePackage).getSubTypes(eClass);
	}


	@Override
	public Set<EReference> getAllOutgoingReferences(EClass eClass) {
		return new HashSet<>(eClass.getEAllReferences());
	}

	@Override
	public Set<EReference> getAllIncomingReferences(EClass eClass) {
		EPackage ePackage = eClass.getEPackage(); 
		
		if (!(incomingReferenceIndex.containsKey(ePackage))) {
			incomingReferenceIndex.put(ePackage, new IncomingReferenceIndex(ePackage));
		}
		
		return incomingReferenceIndex.get(ePackage).getAllIcoming(eClass);
	}

}
