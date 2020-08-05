package org.sidiff.revision.impact.changetree.change.actions;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.sidiff.revision.common.utilities.string.NameUtil;
import org.sidiff.revision.impact.changetree.IDecisionNode;

public class AttributeChangeAction extends StructuralFeatureChangeAction {

	protected static final Object UNBOUND = new Object();
	
	protected Object value;
	
	public AttributeChangeAction(RepairType type, EObject context, EAttribute attribute) {
		super(type, context, attribute);
	}
	
	public AttributeChangeAction(RepairType type, EObject context, EAttribute attribute, Object value) {
		super(type, context, attribute);
		this.value = value;
	}
	
	public EAttribute getAttribute() {
		return (EAttribute) feature;
	}
	
	public Object getValue() {
		return value;
	}
	
	@Override
	public boolean isAbstract() {
		return value == UNBOUND;
	}
	
	public boolean match(RepairType type, EObject context, EStructuralFeature feature, Object value) {
		if (isAbstract()) {
			return match(type, context, feature);
		} else {
			return this.value.equals(value) && match(type, context, feature);
		}
	}

	@Override
	public IDecisionNode deepCopy() {
		return new AttributeChangeAction(type, context, getAttribute(), value);
	}

	@Override
	public String toString() {
		return "AttributeRepairAction [" + getRepairLabel() + "]";
	}
	
	@Override
	public String getRepairLabel() {
		if (isAbstract()) {
			return type + ", " + NameUtil.getName(context) + ", " + feature.getName();
		} else {
			return type + ", " + context + ", =" + feature.getName() + ", " + value.toString();
		}
	}
}
