package org.sidiff.consistency.repair.lifting.api;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.henshin.model.Rule;
import org.sidiff.consistency.repair.validation.util.BatchValidationIterator.Validation;

public class RepairJob {

	protected Map<Rule, List<Repair>> repairs;
	
	protected Collection<Validation> validations;
	
	protected Resource modelA;
	
	protected Resource modelB;
	
	protected Resource difference;
	
	public RepairJob() {
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
