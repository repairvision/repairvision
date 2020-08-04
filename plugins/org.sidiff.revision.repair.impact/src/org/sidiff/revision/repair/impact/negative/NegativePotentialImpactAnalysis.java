package org.sidiff.revision.repair.impact.negative;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.sidiff.revision.repair.impact.RepairActionImpactScope;
import org.sidiff.revision.repair.impact.positive.PositivePotentialImpactAnalysis;

public class NegativePotentialImpactAnalysis extends PositivePotentialImpactAnalysis {

	public NegativePotentialImpactAnalysis(RepairActionImpactScope repairActions) {
		super(repairActions);
	}
	
	@Override
	public boolean onCreateObject(EReference containingReference, EClass objectType, boolean strict) {
		return super.onDeleteObject(containingReference, objectType, strict);
	}
	
	@Override
	public boolean onDeleteObject(EReference containingReference, EClass objectType, boolean strict) {
		return super.onCreateObject(containingReference, objectType, strict);
	}

	@Override
	public boolean onCreateReference(EClass sourceContextType, EReference reference, boolean strict) {
		return super.onDeleteReference(sourceContextType, reference, strict);
	}

	@Override
	public boolean onDeleteReference(EClass sourceContextType, EReference reference, boolean strict) {
		return super.onCreateReference(sourceContextType, reference, strict);
	}

}
