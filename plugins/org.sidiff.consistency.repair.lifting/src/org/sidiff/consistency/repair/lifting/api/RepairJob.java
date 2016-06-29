package org.sidiff.consistency.repair.lifting.api;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.henshin.model.Rule;

public class RepairJob {

	protected Map<Rule, List<Repair>> repairs;
	
	protected Resource modelA;
	
	protected Resource modelB;
	
	protected Resource difference;

	public RepairJob(Map<Rule, List<Repair>> repairs, Resource modelA, Resource modelB, Resource difference) {
		super();
		this.repairs = repairs;
		this.modelA = modelA;
		this.modelB = modelB;
		this.difference = difference;
	}
	
	public RepairJob() {
	}

	public Map<Rule, List<Repair>> getRepairs() {
		return repairs;
	}

	public void setRepairs(Map<Rule, List<Repair>> repairs) {
		this.repairs = repairs;
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
