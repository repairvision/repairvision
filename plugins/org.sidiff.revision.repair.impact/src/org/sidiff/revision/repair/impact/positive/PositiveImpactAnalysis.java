package org.sidiff.revision.repair.impact.positive;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.sidiff.revision.impact.analysis.ImpactAnalysis;
import org.sidiff.revision.impact.changetree.change.actions.ChangeAction;
import org.sidiff.revision.impact.changetree.change.actions.ObjectChangeAction;
import org.sidiff.revision.impact.changetree.change.actions.StructuralFeatureChangeAction;
import org.sidiff.revision.impact.changetree.change.actions.ChangeAction.RepairType;
import org.sidiff.revision.repair.impact.RepairActionImpactScope;

public class PositiveImpactAnalysis implements ImpactAnalysis {

	protected RepairActionImpactScope repairActions;
	
	public PositiveImpactAnalysis(RepairActionImpactScope repairActions) {
		this.repairActions = repairActions;
	}
	
	@Override
	public boolean onCreateObject(EReference containingReference, EObject object) {
		return isObjectRepair(RepairType.CREATE, containingReference, object);
	}
	
	@Override
	public boolean onDeleteObject(EReference containingReference, EObject object) {
		return isObjectRepair(RepairType.DELETE, containingReference, object);
	}
	
	@Override
	public boolean onCreateReference(EObject sourceContext, EReference reference) {
		return isStructuralFeatureRepair(RepairType.CREATE, sourceContext, reference);
	}

	@Override
	public boolean onDeleteReference(EObject sourceContext, EReference reference) {
		return isStructuralFeatureRepair(RepairType.DELETE, sourceContext, reference);
	}

	@Override
	public boolean onModifyAttribute(EObject containerContext, EAttribute attribute) {
		return isStructuralFeatureRepair(RepairType.MODIFY, containerContext, attribute);
	}
	
	protected boolean isObjectRepair(RepairType type, EReference containingReference, EObject object) {
		Map<EObject, List<ChangeAction>> repairsPerMetaClass = repairActions.getRepairActions(containingReference);

		if (repairsPerMetaClass != null) {
			List<ChangeAction> repairsPerObject = repairsPerMetaClass.get(object);
			
			if (repairsPerObject != null) {
				for (ChangeAction repair : repairsPerObject) {
					if (repair instanceof ObjectChangeAction) {
						return ((ObjectChangeAction) repair).match(type, object);
					}
				}
			}
		}
		
		return false;
	}
	
	protected boolean isStructuralFeatureRepair(RepairType type, EObject context, EStructuralFeature feature) {
		Map<EObject, List<ChangeAction>> repairsPerMetaClass = repairActions.getRepairActions(feature);

		if (repairsPerMetaClass != null) {
			List<ChangeAction> repairsPerObject = repairsPerMetaClass.get(context);
			
			if (repairsPerObject != null) {
				for (ChangeAction repair : repairsPerObject) {
					if (repair instanceof StructuralFeatureChangeAction) {
						return ((StructuralFeatureChangeAction) repair).match(type, context, feature);
					}
				}
			}
		}

		return false;
	}
}
