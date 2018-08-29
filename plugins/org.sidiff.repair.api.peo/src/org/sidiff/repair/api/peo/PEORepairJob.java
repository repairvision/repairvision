package org.sidiff.repair.api.peo;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.henshin.interpreter.EGraph;
import org.sidiff.history.revision.IRevision;
import org.sidiff.repair.api.IRepairPlan;
import org.sidiff.repair.api.RepairJob;
import org.sidiff.validation.constraint.api.util.RepairValidation;

public class PEORepairJob extends RepairJob<IRepairPlan> {

	protected Collection<RepairValidation> validations;
	
	public PEORepairJob(Collection<RepairValidation> validations, 
			List<IRepairPlan> repairs, IRevision revision, EGraph targetGraph) {
		super(repairs, revision, targetGraph);
		this.validations = validations;
	}
	
	public Collection<RepairValidation> getValidations() {
		return validations;
	}

	public void setValidations(Collection<RepairValidation> validations) {
		this.validations = validations;
	}
}
