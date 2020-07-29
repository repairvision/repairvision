package org.sidiff.validation.constraint.interpreter.decisiontree.repair.actions;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.sidiff.common.utilities.emf.MetaModelUtil;
import org.sidiff.common.utilities.java.NameUtil;
import org.sidiff.validation.constraint.interpreter.decisiontree.IDecisionLeaf;
import org.sidiff.validation.constraint.interpreter.decisiontree.IDecisionNode;

public class ObjectRepairAction extends RepairAction {

	protected EReference containingReference;
	
	protected EClass objectType;
	
	protected EObject object;
	
	public ObjectRepairAction(RepairType type, EReference containingReference, EClass objectType) {
		super(type);
		this.containingReference = containingReference;
		this.objectType = objectType;
	}
	
	public ObjectRepairAction(RepairType type, EReference containingReference, EClass objectType, EObject object) {
		super(type);
		this.containingReference = containingReference;
		this.objectType = objectType;
		this.object = object;
	}
	
	public EReference getContainingReference() {
		return containingReference;
	}
	
	public EClass getObjectType() {
		return objectType;
	}
	
	public EObject getObject() {
		return object;
	}
	
	@Override
	public boolean isAbstract() {
		return object == null;
	}
	
	public boolean match(RepairType type, EObject object) {
		if (isAbstract()) {
			return match(type, object.eContainmentFeature(), object.eClass(), true);
		} else {
			return this.object.equals(object) && match(type, object.eContainmentFeature(), object.eClass(), true);
		}
	}
	
	public boolean match(RepairType type, EReference containingReference, EClass objectType, boolean strict) {
		if (this.type.equals(RepairType.MODIFY) || this.type.equals(type)) {
			if (this.containingReference == containingReference) { // allows null for root elements
				if (!strict || this.objectType.equals(objectType)) {
					if (strict || MetaModelUtil.isAssignableTo(this.objectType, objectType)) {
						return true;
					}
				}
			}
		}
		return false;
	}
	
	@Override
	public int compareTo(IDecisionLeaf leaf) {
		if (leaf instanceof ObjectRepairAction) {
			ObjectRepairAction otherRepair = (ObjectRepairAction) leaf;
			
			if (this.getType().equals(otherRepair.getType())) {
				if (this.getObjectType().equals(otherRepair.getObjectType())) {
					return 0;
				}
			}
		}
		
		return this.toString().compareTo(leaf.toString());
	}

	@Override
	public IDecisionNode deepCopy() {
		return new ObjectRepairAction(type, containingReference, objectType, object);
	}

	@Override
	public String toString() {
		return "ObjectRepairAction [type=" + type + ", containingReference=" + containingReference + ", objectType=" + objectType + "]";
	}
	
	@Override
	public String getRepairLabel() {
		if (isAbstract()) {
			return type + ", " + containingReference.getName() + ", " + objectType.getName();
		} else {
			return type + ", " + containingReference.getName() + ", " + objectType.getName() + ", " + NameUtil.getName(object);
		}
	}
}
