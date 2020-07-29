package org.sidiff.validation.constraint.impact.repair;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.sidiff.validation.constraint.impact.PotentialImpactAnalysis;
import org.sidiff.validation.constraint.interpreter.decisiontree.repair.actions.ObjectRepairAction;
import org.sidiff.validation.constraint.interpreter.decisiontree.repair.actions.RepairAction;
import org.sidiff.validation.constraint.interpreter.decisiontree.repair.actions.RepairAction.RepairType;
import org.sidiff.validation.constraint.interpreter.decisiontree.repair.actions.StructuralFeatureRepairAction;

public class PositivePotentialImpactAnalysis implements PotentialImpactAnalysis {

	protected RepairActionIndex repairActions;
	
	public PositivePotentialImpactAnalysis(RepairActionIndex repairActions) {
		this.repairActions = repairActions;
	}
	
	@Override
	public boolean onCreate(EReference containingReference, EClass objectType, boolean strict) {
		return isObjectRepair(RepairType.CREATE, containingReference, objectType, strict);
	}
	
	@Override
	public boolean onDelete(EReference containingReference, EClass objectType, boolean strict) {
		return isObjectRepair(RepairType.DELETE, containingReference, objectType, strict);
	}
	
	@Override
	public boolean onCreate(EClass sourceContextType, EReference reference, boolean strict) {
		return isStructuralFeatureRepair(RepairType.CREATE, sourceContextType, reference, strict);
	}

	@Override
	public boolean onDelete(EClass sourceContextType, EReference reference, boolean strict) {
		return isStructuralFeatureRepair(RepairType.DELETE, sourceContextType, reference, strict);
	}

	@Override
	public boolean onModify(EClass containerContextType, EAttribute attribute, boolean strict) {
		return isStructuralFeatureRepair(RepairType.MODIFY, containerContextType, attribute, strict);
	}
	
	protected boolean isObjectRepair(RepairType type, EReference containingReference, EClass objectType, boolean strict) {
		Map<EObject, List<RepairAction>> repairsPerMetaClass = repairActions.getRepairActions(containingReference);
		
		if (repairsPerMetaClass != null) {
			for (List<RepairAction> repairsPerObject : repairsPerMetaClass.values()) {
				for (RepairAction repair : repairsPerObject) {
					if (repair instanceof ObjectRepairAction) {
						return ((ObjectRepairAction) repair).match(type, containingReference, objectType, strict);
					}
				}
			}
		}

		return false;
	}
	
	protected boolean isStructuralFeatureRepair(RepairType type, EClass contextType, EStructuralFeature feature, boolean strict) {
		Map<EObject, List<RepairAction>> repairsPerMetaClass = repairActions.getRepairActions(feature);

		if (repairsPerMetaClass != null) {
			for (List<RepairAction> repairsPerObject : repairsPerMetaClass.values()) {
				for (RepairAction repair : repairsPerObject) {
					if (repair instanceof StructuralFeatureRepairAction) {
						return ((StructuralFeatureRepairAction) repair).match(type, contextType, feature, strict);
					}
				}
			}
		}

		return false;
	}
}
