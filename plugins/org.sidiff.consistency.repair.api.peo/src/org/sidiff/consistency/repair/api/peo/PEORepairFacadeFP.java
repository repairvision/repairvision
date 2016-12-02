package org.sidiff.consistency.repair.api.peo;

import org.eclipse.emf.ecore.resource.Resource;
import org.sidiff.consistency.repair.complement.peo.finder.ComplementFinder;
import org.sidiff.consistency.repair.complement.peo.finder.ComplementFinderFP;
import org.sidiff.difference.symmetric.SymmetricDifference;

public class PEORepairFacadeFP extends PEORepairFacade {

	@Override
	protected ComplementFinder createComplementFinder(
			Resource modelAResource, Resource modelBResource, SymmetricDifference difference) {
		return new ComplementFinderFP(modelAResource, modelBResource, difference);
	}

}
