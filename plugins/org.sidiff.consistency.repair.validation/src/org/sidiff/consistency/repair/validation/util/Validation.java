package org.sidiff.consistency.repair.validation.util;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.sidiff.consistency.repair.validation.ConsistencyRule;
import org.sidiff.consistency.repair.validation.fix.IRepairDecision;

public class Validation {
	
	private ConsistencyRule rule;
	private boolean result;
	private EClass contextType;
	private EObject context;
	private IRepairDecision repair;
	
	public Validation(
			ConsistencyRule rule, boolean result, 
			EClass contextType, EObject context, 
			IRepairDecision repair) {
		
		this.rule = rule;
		this.result = result;
		this.contextType = contextType;
		this.context = context;
		this.repair = repair;
	}
	
	public ConsistencyRule getRule() {
		return rule;
	}

	public boolean getResult() {
		return result;
	}
	
	public EClass getContextType() {
		return contextType;
	}
	
	public EObject getContext() {
		return context;
	}
	
	public IRepairDecision getRepair() {
		return repair;
	}
	
	public void cleanUpRepairTree() {
		repair = ValidationUtil.cleanup(repair);
	}
}
