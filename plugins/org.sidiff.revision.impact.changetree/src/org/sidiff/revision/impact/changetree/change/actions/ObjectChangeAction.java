package org.sidiff.revision.impact.changetree.change.actions;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.sidiff.revision.common.emf.MetaModelUtil;
import org.sidiff.revision.common.utilities.string.NameUtil;
import org.sidiff.revision.impact.changetree.IDecisionLeaf;
import org.sidiff.revision.impact.changetree.IDecisionNode;

public class ObjectChangeAction extends ChangeAction {

	protected EReference containingReference;
	
	protected EClass objectType;
	
	protected EObject object;
	
	public ObjectChangeAction(RepairType type, EReference containingReference, EClass objectType) {
		super(type);
		this.containingReference = containingReference;
		this.objectType = objectType;
	}
	
	public ObjectChangeAction(RepairType type, EReference containingReference, EClass objectType, EObject object) {
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
		if (leaf instanceof ObjectChangeAction) {
			ObjectChangeAction otherRepair = (ObjectChangeAction) leaf;
			
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
		return new ObjectChangeAction(type, containingReference, objectType, object);
	}

	@Override
	public String toString() {
		return "ObjectRepairAction [" + getRepairLabel() + "]";
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
