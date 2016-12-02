package org.sidiff.consistency.repair.complement.peo.finder;

import org.eclipse.emf.ecore.resource.Resource;
import org.sidiff.difference.symmetric.SymmetricDifference;
import org.sidiff.graphpattern.matcher.IPatternMatchingEngineFactory;
import org.sidiff.graphpattern.matcher.lifting.engine.partial.PartialLiftingEngineFactoryMA;
import org.sidiff.graphpattern.matching.IMatching;

public class ComplementFinderMA extends ComplementFinder {

	public ComplementFinderMA(Resource modelAResource, Resource modelBResource, SymmetricDifference difference) {
		super(modelAResource, modelBResource, difference);
	}

	@Override
	protected IPatternMatchingEngineFactory<IMatching> getEngineFactory() {
		return new PartialLiftingEngineFactoryMA();
	}

}
