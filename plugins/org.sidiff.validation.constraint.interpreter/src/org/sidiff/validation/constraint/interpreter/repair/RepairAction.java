package org.sidiff.validation.constraint.interpreter.repair;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.sidiff.validation.constraint.interpreter.decisiontree.IDecisionLeaf;

public class RepairAction implements IDecisionLeaf {

	public enum RepairType {
		DELETE, CREATE, MODIFY
	}
	
	protected RepairType type;
	
	protected EObject context;
	
	protected EStructuralFeature feature;
	
	public RepairAction(RepairType type, EObject context, EStructuralFeature feature) {
		this.type = type;
		this.context = context;
		this.feature = feature;
	}
	
	public RepairType getType() {
		return type;
	}

	public EObject getContext() {
		return context;
	}

	public EStructuralFeature getFeature() {
		return feature;
	}
	
	public String getRepairTripleLabel() {
		
		EClass eClass = (context != null) ? context.eClass() : null;
		EStructuralFeature nameFeature = (eClass != null) ? eClass.getEStructuralFeature("name") : null;
		
		String contextObjName = "";
		String className = (eClass != null) ? eClass.getName() : "null";
		
		if (nameFeature != null) {
			Object nameFeatureValue = context.eGet(nameFeature);
			
			if (nameFeatureValue instanceof String) {
				contextObjName = (String) nameFeatureValue;
				contextObjName = "[" + contextObjName + "]";
			}
		}
		
		return  type.toString().toLowerCase() 
				+ ", "  + className + contextObjName
				+ ", " + feature.getName();
	}
	
	@Override
	public String toString() {
		return "Repair@" + Integer.toHexString(hashCode()) + ": <" + getRepairTripleLabel() + ">";
	}

	@Override
	public int compareTo(IDecisionLeaf leaf) {
		
		if (leaf instanceof RepairAction) {
			RepairAction otherRepair = (RepairAction) leaf;
			
			if (this.getType().equals(otherRepair.getType())) {
				if (this.getFeature().equals(otherRepair.getFeature())) {
					if (this.getContext().equals(otherRepair.getContext())) {
						return 0;
					}
				}
			}
		}
		
		return this.toString().compareTo(leaf.toString());
	}
}
