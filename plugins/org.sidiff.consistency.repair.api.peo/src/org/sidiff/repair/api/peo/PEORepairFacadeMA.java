package org.sidiff.repair.api.peo;

import org.eclipse.emf.ecore.resource.Resource;
import org.sidiff.repair.complement.peo.finder.ComplementFinder;
import org.sidiff.repair.complement.peo.finder.ComplementFinderMA;
import org.sidiff.difference.symmetric.SymmetricDifference;

public class PEORepairFacadeMA extends PEORepairFacade {

	@Override
	protected ComplementFinder createComplementFinder(
			Resource modelAResource, Resource modelBResource, SymmetricDifference difference) {
		return new ComplementFinderMA(modelAResource, modelBResource, difference);
	}

}
