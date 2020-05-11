package org.sidiff.revision.repair.api.peo;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.henshin.interpreter.EGraph;
import org.sidiff.history.revision.IRevision;
import org.sidiff.revision.repair.api.IRepairPlan;
import org.sidiff.revision.repair.api.RepairJob;
import org.sidiff.validation.constraint.api.util.RepairValidation;
import org.sidiff.validation.constraint.api.util.Validation;

public class PEORepairJob extends RepairJob<IRepairPlan> {

	protected Collection<? extends Validation> validations;
	
	public PEORepairJob(List<? extends Validation> validations, 
			List<IRepairPlan> repairs, IRevision revision, EGraph targetGraph) {
		super(repairs, revision, targetGraph);
		this.validations = validations;
	}
	
	public Collection<? extends Validation> getValidations() {
		return validations;
	}

	@SuppressWarnings("unchecked")
	public Collection<RepairValidation> getRepairTrees() {
		return (Collection<RepairValidation>) validations;
	}
}
