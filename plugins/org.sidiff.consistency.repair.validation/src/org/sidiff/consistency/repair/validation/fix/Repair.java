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
}
