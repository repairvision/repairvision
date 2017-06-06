package org.sidiff.validation.constraint.api.util;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.sidiff.repair.validation.IConstraint;
import org.sidiff.repair.validation.IScopeRecorder;
import org.sidiff.repair.validation.fix.IRepairDecision;

public class Validation {
	
	private IConstraint rule;
	private boolean result;
	private EClass contextType;
	private EObject context;
	private IRepairDecision repair;
	private IScopeRecorder scope;
	
	public Validation(
			IConstraint rule, boolean result, 
			EClass contextType, EObject context, 
			IRepairDecision repair) {
		
		this.rule = rule;
		this.result = result;
		this.contextType = contextType;
		this.context = context;
		this.repair = repair;
	}
	
	public Validation(
			IConstraint rule, boolean result, 
			EClass contextType, EObject context, 
			IRepairDecision repair,
			IScopeRecorder scope) {
		
		this.rule = rule;
		this.result = result;
		this.contextType = contextType;
		this.context = context;
		this.repair = repair;
		this.scope = scope;
	}
	
	public IConstraint getRule() {
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
	
	public void setScope(IScopeRecorder scope) {
		this.scope = scope;
	}
	
	public IScopeRecorder getScope() {
		return scope;
	}
}
