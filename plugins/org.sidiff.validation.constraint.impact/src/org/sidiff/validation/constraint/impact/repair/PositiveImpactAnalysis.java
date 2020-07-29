package org.sidiff.validation.constraint.impact.repair;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.sidiff.validation.constraint.impact.ImpactAnalysis;
import org.sidiff.validation.constraint.interpreter.decisiontree.repair.actions.ObjectRepairAction;
import org.sidiff.validation.constraint.interpreter.decisiontree.repair.actions.RepairAction;
import org.sidiff.validation.constraint.interpreter.decisiontree.repair.actions.RepairAction.RepairType;
import org.sidiff.validation.constraint.interpreter.decisiontree.repair.actions.StructuralFeatureRepairAction;

public class PositiveImpactAnalysis implements ImpactAnalysis {

	protected RepairActionIndex repairActions;
	
	public PositiveImpactAnalysis(RepairActionIndex repairActions) {
		this.repairActions = repairActions;
	}
	
	@Override
	public boolean onCreate(EObject object) {
		return isObjectRepair(RepairType.CREATE, object);
	}
	
	@Override
	public boolean onDelete(EObject object) {
		return isObjectRepair(RepairType.DELETE, object);
	}
	
	@Override
	public boolean onCreate(EObject sourceContext, EReference reference) {
		return isStructuralFeatureRepair(RepairType.CREATE, sourceContext, reference);
	}

	@Override
	public boolean onDelete(EObject sourceContext, EReference reference) {
		return isStructuralFeatureRepair(RepairType.DELETE, sourceContext, reference);
	}

	@Override
	public boolean onModify(EObject containerContext, EAttribute attribute) {
		return isStructuralFeatureRepair(RepairType.MODIFY, containerContext, attribute);
	}
	
	@Override
	public Set<EObject> getScope() {
		return repairActions.getScope();
	}
	
	protected boolean isObjectRepair(RepairType type, EObject object) {
		Map<EObject, List<RepairAction>> repairsPerMetaClass = repairActions.getRepairActions(object.eContainmentFeature());

		if (repairsPerMetaClass != null) {
			List<RepairAction> repairsPerObject = repairsPerMetaClass.get(object);
			
			if (repairsPerObject != null) {
				for (RepairAction repair : repairsPerObject) {
					if (repair instanceof ObjectRepairAction) {
						return ((ObjectRepairAction) repair).match(type, object);
					}
				}
			}
		}
		
		return false;
	}
	
	protected boolean isStructuralFeatureRepair(RepairType type, EObject context, EStructuralFeature feature) {
		Map<EObject, List<RepairAction>> repairsPerMetaClass = repairActions.getRepairActions(feature);

		if (repairsPerMetaClass != null) {
			List<RepairAction> repairsPerObject = repairsPerMetaClass.get(context);
			
			if (repairsPerObject != null) {
				for (RepairAction repair : repairsPerObject) {
					if (repair instanceof StructuralFeatureRepairAction) {
						return ((StructuralFeatureRepairAction) repair).match(type, context, feature);
					}
				}
			}
		}

		return false;
	}
}
