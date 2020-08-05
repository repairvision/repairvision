package org.sidiff.revision.impact.changetree.change.actions;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.sidiff.revision.common.utilities.string.NameUtil;
import org.sidiff.revision.impact.changetree.IDecisionNode;

public class ReferenceChangeAction extends StructuralFeatureChangeAction {
	
	protected EObject target;

	public ReferenceChangeAction(RepairType type, EObject context, EReference reference) {
		super(type, context, reference);
	}
	
	public ReferenceChangeAction(RepairType type, EObject context, EReference reference, EObject target) {
		super(type, context, reference);
	}
	
	public EReference getReference() {
		return (EReference) feature;
	}
	
	public EObject getTarget() {
		return target;
	}
	
	@Override
	public boolean isAbstract() {
		return (target == null);
	}
	
	public boolean match(RepairType type, EObject context, EStructuralFeature feature, EObject target) {
		if (isAbstract()) {
			return match(type, context, feature);
		} else {
			return this.target.equals(target) && match(type, context, feature);
		}
	}

	@Override
	public IDecisionNode deepCopy() {
		return new ReferenceChangeAction(type, context, getReference(), target);
	}

	@Override
	public String toString() {
		return "ReferenceRepairAction [" + getRepairLabel() + "]";
	}
	
	@Override
	public String getRepairLabel() {
		if (isAbstract()) {
			return type + ", " + NameUtil.getName(context) + ", " + feature.getName();
		} else {
			return type + ", " + context + ", =" + feature.getName() + ", " + target;
		}
	}
}
