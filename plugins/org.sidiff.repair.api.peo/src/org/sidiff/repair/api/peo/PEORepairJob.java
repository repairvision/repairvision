package org.sidiff.repair.api.peo;

import java.util.Collection;

import org.sidiff.repair.api.IRepairPlan;
import org.sidiff.repair.api.RepairJob;
import org.sidiff.validation.constraint.api.util.RepairValidation;

public class PEORepairJob extends RepairJob<IRepairPlan> {

	protected Collection<RepairValidation> validations;
	
	public Collection<RepairValidation> getValidations() {
		return validations;
	}

	public void setValidations(Collection<RepairValidation> validations) {
		this.validations = validations;
	}
}
