package org.sidiff.history.revision.metamodel.impl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

public class IncomingReferenceIndex {

	private Map<EClass, Set<EReference>> incoming = new HashMap<>();
	
	public IncomingReferenceIndex(EPackage ePackage) {
		addToIndex(ePackage);
	}
	
	private void addToIndex(EPackage ePackage) {
		for (EClassifier eClassifier : ePackage.getEClassifiers()) {
			if (eClassifier instanceof EClass) {
				addToIndex((EClass) eClassifier); 
			}
		}
		
		for (EPackage subEPackage : ePackage.getESubpackages()) {
			addToIndex(subEPackage);
		}
	}
	
	private void addToIndex(EClass eClass) {
		for (EReference eReference : eClass.getEAllReferences()) {
			if (eReference.getEType() instanceof EClass) {
				EClass target = (EClass) eReference.getEType();
				Set<EReference> classIncoming;
				
				if (!incoming.containsKey(target)) {
					classIncoming = new HashSet<>();
					incoming.put(target, classIncoming);
				} else {
					classIncoming = incoming.get(target);
				}
				
				classIncoming.add(eReference);
			}
		}
	}
	
	public Set<EReference> getAllIcoming(EClass eClass) {
		return incoming.get(eClass);
	}
}
