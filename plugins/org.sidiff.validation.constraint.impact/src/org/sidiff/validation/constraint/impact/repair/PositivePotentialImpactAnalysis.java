package org.sidiff.validation.constraint.impact.repair;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.sidiff.common.utilities.emf.MetaModelUtil;
import org.sidiff.validation.constraint.impact.PotentialImpactAnalysis;
import org.sidiff.validation.constraint.interpreter.repair.RepairAction;
import org.sidiff.validation.constraint.interpreter.repair.RepairAction.RepairType;

public class PositivePotentialImpactAnalysis implements PotentialImpactAnalysis {

	protected RepairActionIndex repairActions;
	
	public PositivePotentialImpactAnalysis(RepairActionIndex repairActions) {
		this.repairActions = repairActions;
	}
	
	@Override
	public boolean onCreate(EClass sourceContextType, EReference reference, boolean strict) {
		return isRepair(RepairType.CREATE, sourceContextType, reference, strict);
	}

	@Override
	public boolean onDelete(EClass sourceContextType, EReference reference, boolean strict) {
		return isRepair(RepairType.DELETE, sourceContextType, reference, strict);
	}

	@Override
	public boolean onModify(EClass containerContextType, EAttribute attribute, boolean strict) {
		return isRepair(RepairType.MODIFY, containerContextType, attribute, strict);
	}
	
	protected boolean isRepair(RepairType type, EClass contextType, EStructuralFeature feature, boolean strict) {
		Map<EObject, List<RepairAction>> repairsPerMetaClass = repairActions.getRepairActions(feature);

		if (repairsPerMetaClass != null) {
			for (List<RepairAction> repairsPerObject : repairsPerMetaClass.values()) {
				for (RepairAction repair : repairsPerObject) {
					if (repair.getType().equals(RepairType.MODIFY) || repair.getType().equals(type)) {
						if (repair.getFeature().equals(feature)) {
							EClass repairContextType = repair.getContext().eClass();
							
							if (!strict || contextType.equals(repairContextType)) {
								if (strict || MetaModelUtil.isAssignableTo(repairContextType, contextType)) {
									return true;
								}
							}
						}
					}
				}
			}
		}

		return false;
	}
}
