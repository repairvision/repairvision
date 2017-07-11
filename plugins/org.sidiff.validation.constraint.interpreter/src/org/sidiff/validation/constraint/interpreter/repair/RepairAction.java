package org.sidiff.validation.constraint.interpreter.repair;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.sidiff.validation.constraint.interpreter.decisiontree.IDecisionNode;

public class RepairAction implements IDecisionNode {

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

	@Override
	public List<IDecisionNode> getChildDecisions() {
		return Collections.emptyList();
	}

	@Override
	public void removeChildDecision(IDecisionNode repair) {
		throw new UnsupportedOperationException("This is a leaf repair decision!");
	}
	
	@Override
	public void appendChildDecisions(IDecisionNode... repairs) {
		throw new UnsupportedOperationException("This is a leaf repair decision!");
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
}
