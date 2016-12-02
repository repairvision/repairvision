package org.sidiff.repair.api.peo;

import java.util.Collection;

import org.sidiff.repair.api.IRepair;
import org.sidiff.repair.api.RepairJob;
import org.sidiff.repair.validation.util.Validation;

public class PEORepairJob extends RepairJob<IRepair> {

	protected Collection<Validation> validations;
	
	public Collection<Validation> getValidations() {
		return validations;
	}

	public void setValidations(Collection<Validation> validations) {
		this.validations = validations;
	}
}
