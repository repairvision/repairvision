package org.sidiff.validation.constraint.impact.repair;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.sidiff.validation.constraint.impact.ImpactAnalysis;
import org.sidiff.validation.constraint.interpreter.decisiontree.repair.RepairAction;
import org.sidiff.validation.constraint.interpreter.decisiontree.repair.RepairAction.RepairType;

public class PositiveImpactAnalysis implements ImpactAnalysis {

	protected RepairActionIndex repairActions;
	
	public PositiveImpactAnalysis(RepairActionIndex repairActions) {
		this.repairActions = repairActions;
	}
	
	@Override
	public boolean onCreate(EObject sourceContext, EReference reference) {
		return isRepair(RepairType.CREATE, sourceContext, reference);
	}

	@Override
	public boolean onDelete(EObject sourceContext, EReference reference) {
		return isRepair(RepairType.DELETE, sourceContext, reference);
	}

	@Override
	public boolean onModify(EObject containerContext, EAttribute attribute) {
		return isRepair(RepairType.MODIFY, containerContext, attribute);
	}
	
	@Override
	public Set<EObject> getScope() {
		return repairActions.getScope();
	}
	
	protected boolean isRepair(RepairType type, EObject context, EStructuralFeature feature) {
		Map<EObject, List<RepairAction>> repairsPerMetaClass = repairActions.getRepairActions(feature);

		if (repairsPerMetaClass != null) {
			List<RepairAction> repairsPerObject = repairsPerMetaClass.get(context);
			
			if (repairsPerObject != null) {
				for (RepairAction repair : repairsPerObject) {
					if (repair.getType().equals(RepairType.MODIFY) || repair.getType().equals(type)) {
						if (repair.getFeature().equals(feature)) {
							return true;
						}
					}
				}
			}
		}

		return false;
	}
}
