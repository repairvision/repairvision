package org.sidiff.revision.repair.impact.positive;

import java.util.Iterator;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.sidiff.revision.impact.analysis.PotentialImpactScope;
import org.sidiff.revision.impact.changetree.change.actions.ChangeAction.RepairType;
import org.sidiff.revision.repair.impact.RepairActionImpactScope;

public class PositivePotentialImpactScope implements PotentialImpactScope {

	private RepairActionImpactScope impact;
	
	public PositivePotentialImpactScope(RepairActionImpactScope impact) {
		this.impact = impact;
	}

	@Override
	public Iterator<EObject> onCreateObject(EReference containingReference, EClass objectType, boolean strict) {
		return impact.getObjectRepairs(RepairType.CREATE, containingReference, objectType, strict);
	}

	@Override
	public Iterator<EObject> onDeleteObject(EReference containingReference, EClass objectType, boolean strict) {
		return impact.getObjectRepairs(RepairType.DELETE, containingReference, objectType, strict);
	}

	@Override
	public Iterator<EObject> onCreateReference(EClass contextType, EReference referenceType, boolean strict) {
		return impact.getStructuralFeatureRepairs(RepairType.CREATE, contextType, referenceType, strict);
	}

	@Override
	public Iterator<EObject> onDeleteReference(EClass contextType, EReference referenceType, boolean strict) {
		return impact.getStructuralFeatureRepairs(RepairType.DELETE, contextType, referenceType, strict);
	}

	@Override
	public Iterator<EObject> onModifyAttribute(EClass contextType, EAttribute attributeType, boolean strict) {
		return impact.getStructuralFeatureRepairs(RepairType.MODIFY, contextType, attributeType, strict);
	}

}
