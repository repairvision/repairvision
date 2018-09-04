package org.sidiff.validation.constraint.impact;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.sidiff.validation.constraint.impact.index.RepairActionIndex;

public class NegativeImpactAnalysis extends PositiveImpactAnalysis {
	
	public NegativeImpactAnalysis(RepairActionIndex repairActions) {
		super(repairActions);
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
