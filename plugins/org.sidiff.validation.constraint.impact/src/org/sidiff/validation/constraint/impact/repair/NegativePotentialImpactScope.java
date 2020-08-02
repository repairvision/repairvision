package org.sidiff.validation.constraint.impact.repair;

import java.util.Iterator;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

public class NegativePotentialImpactScope extends PositivePotentialImpactScope {

	public NegativePotentialImpactScope(RepairActionImpactScope impact) {
		super(impact);
	}

	@Override
	public Iterator<EObject> onCreateObject(EReference containingReference, EClass objectType, boolean strict) {
		return super.onDeleteObject(containingReference, objectType, strict);
	}

	@Override
	public Iterator<EObject> onDeleteObject(EReference containingReference, EClass objectType, boolean strict) {
		return super.onCreateObject(containingReference, objectType, strict);
	}

	@Override
	public Iterator<EObject> onCreateReference(EClass contextType, EReference referenceType, boolean strict) {
		return super.onDeleteReference(contextType, referenceType, strict);
	}

	@Override
	public Iterator<EObject> onDeleteReference(EClass contextType, EReference referenceType, boolean strict) {
		return super.onCreateReference(contextType, referenceType, strict);
	}

}
