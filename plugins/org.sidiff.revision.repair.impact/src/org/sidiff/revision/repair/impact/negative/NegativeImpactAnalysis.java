package org.sidiff.revision.repair.impact.negative;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.sidiff.revision.repair.impact.RepairActionImpactScope;
import org.sidiff.revision.repair.impact.positive.PositiveImpactAnalysis;

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
