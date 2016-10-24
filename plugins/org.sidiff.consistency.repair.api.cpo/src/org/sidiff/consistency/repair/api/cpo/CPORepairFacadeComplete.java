package org.sidiff.consistency.repair.api.cpo;

import org.sidiff.consistency.repair.api.cpo.lifting.FragmentedCPOLifting;

/**
 * API for the repair engine functions.
 * 
 * @author Manuel Ohrndorf
 */
public class CPORepairFacadeComplete extends CPORepairFacade  {

	public CPORepairFacadeComplete() {
		super(new FragmentedCPOLifting());
	}
}
