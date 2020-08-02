package org.sidiff.validation.constraint.impact.repair;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

public class NegativeImpactAnalysis extends PositiveImpactAnalysis {
	
	public NegativeImpactAnalysis(RepairActionImpactScope repairActions) {
		super(repairActions);
	}
	
	@Override
	public boolean onCreateObject(EReference containingReference, EObject object) {
		return super.onDeleteObject(containingReference, object);
	}
	
	@Override
	public boolean onDeleteObject(EReference containingReference, EObject object) {
		return super.onCreateObject(containingReference, object);
	}

	@Override
	public boolean onCreateReference(EObject sourceContext, EReference reference) {
		return super.onDeleteReference(sourceContext, reference);
	}

	@Override
	public boolean onDeleteReference(EObject sourceContext, EReference reference) {
		return super.onCreateReference(sourceContext, reference);
	}

}
