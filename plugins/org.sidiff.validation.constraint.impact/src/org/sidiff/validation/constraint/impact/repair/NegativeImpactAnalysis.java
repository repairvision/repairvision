package org.sidiff.validation.constraint.impact.repair;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

public class NegativeImpactAnalysis extends PositiveImpactAnalysis {
	
	public NegativeImpactAnalysis(RepairActionIndex repairActions) {
		super(repairActions);
	}
	
	@Override
	public boolean onCreate(EObject object) {
		return super.onDelete(object);
	}
	
	@Override
	public boolean onDelete(EObject object) {
		return super.onCreate(object);
	}

	@Override
	public boolean onCreate(EObject sourceContext, EReference reference) {
		return super.onDelete(sourceContext, reference);
	}

	@Override
	public boolean onDelete(EObject sourceContext, EReference reference) {
		return super.onCreate(sourceContext, reference);
	}

}
