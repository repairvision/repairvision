package org.sidiff.consistency.repair.validation.fix;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

public class Repair implements IRepairDecision {

	public enum RepairType {
		DELETE, ADD, MODIFY
	}
	
	protected RepairType type;
	
	protected EObject context;
	
	protected EStructuralFeature feature;
	
	public Repair(RepairType type, EObject context, EStructuralFeature feature) {
		this.type = type;
		this.context = context;
		this.feature = feature;
	}

	@Override
	public List<IRepairDecision> getChildDecisions() {
		return Collections.emptyList();
	}

	@Override
	public void removeChildDecision(IRepairDecision repair) {
		throw new UnsupportedOperationException("This is a leaf repair decision!");
	}
	
	@Override
	public void appendChildDecisions(IRepairDecision... repairs) {
		throw new UnsupportedOperationException("This is a leaf repair decision!");
	}
	
	@Override
	public String toString() {
		EStructuralFeature nameFeature = context.eClass().getEStructuralFeature("name");
		String contextObjName = "";
		
		if (nameFeature != null) {
			Object nameFeatureValue = context.eGet(nameFeature);
			
			if (nameFeatureValue instanceof String) {
				contextObjName = (String) nameFeatureValue;
				contextObjName = "[" + contextObjName + "]";
			}
		}
		
		return "Repair@" + Integer.toHexString(hashCode()) 
		+ ": <" 
				+ type.toString().toLowerCase() 
				+ ", "  + context.eClass().getName() + contextObjName
				+ ", " + feature.getName() + ">";
	}
}
