package org.sidiff.validation.constraint.interpreter.decisiontree.repair.actions;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.sidiff.common.utilities.java.NameUtil;
import org.sidiff.validation.constraint.interpreter.decisiontree.IDecisionNode;

public class AttributeRepairAction extends StructuralFeatureRepairAction {

	protected static final Object UNBOUND = new Object();
	
	protected Object value;
	
	public AttributeRepairAction(RepairType type, EObject context, EAttribute attribute) {
		super(type, context, attribute);
	}
	
	public AttributeRepairAction(RepairType type, EObject context, EAttribute attribute, Object value) {
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
		return new AttributeRepairAction(type, context, getAttribute(), value);
	}

	@Override
	public String toString() {
		return "AttributeRepairAction [type=" + type + ", context=" + context + ", feature=" + feature + ", value=" + value + "]";
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
