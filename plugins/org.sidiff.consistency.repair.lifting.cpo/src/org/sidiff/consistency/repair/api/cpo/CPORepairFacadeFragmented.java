package org.sidiff.consistency.repair.api.cpo;

import org.sidiff.consistency.repair.api.cpo.lifting.FragmentedCPOLifting;

/**
 * API for the repair engine functions.
 * 
 * @author Manuel Ohrndorf
 */
public class CPORepairFacadeFragmented extends CPORepairFacade {

	public CPORepairFacadeFragmented() {
		super(new FragmentedCPOLifting());
	}
}
