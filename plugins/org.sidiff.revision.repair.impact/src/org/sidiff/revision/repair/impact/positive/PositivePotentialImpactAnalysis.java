package org.sidiff.revision.repair.impact.positive;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.sidiff.revision.impact.analysis.PotentialImpactAnalysis;
import org.sidiff.revision.impact.changetree.change.actions.ChangeAction.RepairType;
import org.sidiff.revision.repair.impact.RepairActionImpactScope;

public class PositivePotentialImpactAnalysis implements PotentialImpactAnalysis {

	protected RepairActionImpactScope repairActions;
	
	public PositivePotentialImpactAnalysis(RepairActionImpactScope repairActions) {
		this.repairActions = repairActions;
	}
	
	@Override
	public boolean onCreateObject(EReference containingReference, EClass objectType, boolean strict) {
		return repairActions.isObjectRepair(RepairType.CREATE, containingReference, objectType, strict);
	}
	
	@Override
	public boolean onDeleteObject(EReference containingReference, EClass objectType, boolean strict) {
		return repairActions.isObjectRepair(RepairType.DELETE, containingReference, objectType, strict);
	}
	
	@Override
	public boolean onCreateReference(EClass sourceContextType, EReference reference, boolean strict) {
		return repairActions.isStructuralFeatureRepair(RepairType.CREATE, sourceContextType, reference, strict);
	}

	@Override
	public boolean onDeleteReference(EClass sourceContextType, EReference reference, boolean strict) {
		return repairActions.isStructuralFeatureRepair(RepairType.DELETE, sourceContextType, reference, strict);
	}

	@Override
	public boolean onModifyAttribute(EClass containerContextType, EAttribute attribute, boolean strict) {
		return repairActions.isStructuralFeatureRepair(RepairType.MODIFY, containerContextType, attribute, strict);
	}
}
