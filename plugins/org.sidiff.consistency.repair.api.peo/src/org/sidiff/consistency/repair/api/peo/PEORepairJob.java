package org.sidiff.consistency.repair.api.peo;

import java.util.Collection;

import org.sidiff.consistency.repair.api.IRepair;
import org.sidiff.consistency.repair.api.RepairJob;
import org.sidiff.consistency.repair.validation.util.Validation;

public class PEORepairJob extends RepairJob<IRepair> {

	protected Collection<Validation> validations;
	
	public Collection<Validation> getValidations() {
		return validations;
	}

	public void setValidations(Collection<Validation> validations) {
		this.validations = validations;
	}
}
