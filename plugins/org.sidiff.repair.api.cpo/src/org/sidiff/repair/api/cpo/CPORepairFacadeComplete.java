package org.sidiff.repair.api.cpo;

import org.sidiff.repair.api.cpo.lifting.CompleteCPOLifting;

/**
 * API for the repair engine functions.
 * 
 * @author Manuel Ohrndorf
 */
public class CPORepairFacadeComplete extends CPORepairFacade  {

	public CPORepairFacadeComplete() {
		super(new CompleteCPOLifting());
	}
}
