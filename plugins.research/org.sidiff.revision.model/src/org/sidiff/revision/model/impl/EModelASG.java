package org.sidiff.revision.model.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.sidiff.revision.model.ModelASG;
import org.sidiff.revision.model.ModelSet;

public class EModelASG extends EModelAST implements ModelASG {

	public EModelASG(ModelSet modelSet, Resource model) {
		super(modelSet, model);
	}

	@Override
	public EClass eClass(Object element) {
		
		if (element instanceof EObject) {
			return ((EObject) element).eClass();
		}
		
		return null; // TODO: EClass for resources!?
	}

	@Override
	public Object eGet(Object element, EStructuralFeature feature) {
		
		if (element instanceof EObject) {
			return ((EObject) element).eGet(feature, true);
		}
		
		return null; // TODO: EClass for resources!?
	}

}
