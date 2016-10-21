package org.sidiff.consistency.repair.lifting.api;

import java.io.IOException;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.henshin.interpreter.RuleApplication;
import org.eclipse.emf.henshin.model.Rule;
import org.sidiff.consistency.repair.validation.util.BatchValidationIterator.Validation;

public class RepairJob {
	
	protected Stack<List<RuleApplication>> repairStack = new Stack<>();

	protected Map<Rule, List<Repair>> repairs;
	
	protected Collection<Validation> validations;
	
	protected Resource modelA;
	
	protected Resource modelB;
	
	protected Resource difference;
	
	public RepairJob() {
	}
	
	public void copyHistory(RepairJob repairJob) {
		this.repairStack = repairJob.repairStack;
	}
	
	public List<RuleApplication> applyRepairs(List<Repair> repairs) {
		List<RuleApplication> appliedRepairs = new LinkedList<>();
		
		// Apply repair:
		for (Repair repair : repairs) {
			RuleApplication repairApplication = repair.apply();
			appliedRepairs.add(repairApplication);
			
			// Save model
			if (repairApplication != null) {
				try {
					getModelB().save(null);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		if (!appliedRepairs.isEmpty()) {
			repairStack.push(appliedRepairs);
			return appliedRepairs;
		} else {
			return null;
		}
	}
	
	public List<RuleApplication> undoLastRepairs() {
		
		// Undo repair:
		if (!repairStack.isEmpty()) {
			List<RuleApplication> lastRepairs = repairStack.pop();
			
			// Save model
			for (RuleApplication ruleApplication : lastRepairs) {
				if (ruleApplication.undo(null)) {
					try {
						getModelB().save(null);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
			
			return lastRepairs;
		} else {
			return null;
		}
	}

	public Map<Rule, List<Repair>> getRepairs() {
		return repairs;
	}

	public void setRepairs(Map<Rule, List<Repair>> repairs) {
		this.repairs = repairs;
	}
	
	public Collection<Validation> getValidations() {
		return validations;
	}

	public void setValidations(Collection<Validation> validations) {
		this.validations = validations;
	}

	public Resource getModelA() {
		return modelA;
	}

	public void setModelA(Resource modelA) {
		this.modelA = modelA;
	}

	public Resource getModelB() {
		return modelB;
	}

	public void setModelB(Resource modelB) {
		this.modelB = modelB;
	}

	public Resource getDifference() {
		return difference;
	}

	public void setDifference(Resource difference) {
		this.difference = difference;
	}
}
