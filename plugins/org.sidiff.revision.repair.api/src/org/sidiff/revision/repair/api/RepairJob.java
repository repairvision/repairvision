package org.sidiff.revision.repair.api;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.henshin.interpreter.EGraph;
import org.sidiff.history.revision.IRevision;
import org.sidiff.revision.api.ComplementationJob;
import org.sidiff.revision.api.ComplementationPlan;
import org.sidiff.validation.constraint.api.util.RepairValidation;
import org.sidiff.validation.constraint.api.util.Validation;

public class RepairJob extends ComplementationJob<ComplementationPlan> {

	protected Collection<? extends Validation> validations;
	
	public RepairJob(List<? extends Validation> validations, 
			List<ComplementationPlan> repairs, IRevision revision, EGraph targetGraph) {
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
