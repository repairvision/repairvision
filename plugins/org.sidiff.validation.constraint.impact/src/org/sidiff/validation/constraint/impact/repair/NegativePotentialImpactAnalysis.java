package org.sidiff.validation.constraint.impact.repair;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;

public class NegativePotentialImpactAnalysis extends PositivePotentialImpactAnalysis {

	public NegativePotentialImpactAnalysis(RepairActionIndex repairActions) {
		super(repairActions);
	}
	
	@Override
	public boolean onCreate(EReference containingReference, EClass objectType, boolean strict) {
		return super.onDelete(containingReference, objectType, strict);
	}
	
	@Override
	public boolean onDelete(EReference containingReference, EClass objectType, boolean strict) {
		return super.onCreate(containingReference, objectType, strict);
	}

	@Override
	public boolean onCreate(EClass sourceContextType, EReference reference, boolean strict) {
		return super.onDelete(sourceContextType, reference, strict);
	}

	@Override
	public boolean onDelete(EClass sourceContextType, EReference reference, boolean strict) {
		return super.onCreate(sourceContextType, reference, strict);
	}

}
