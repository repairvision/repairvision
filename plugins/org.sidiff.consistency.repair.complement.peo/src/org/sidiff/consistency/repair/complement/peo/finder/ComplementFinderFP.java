package org.sidiff.consistency.repair.complement.peo.finder;

import org.eclipse.emf.ecore.resource.Resource;
import org.sidiff.consistency.graphpattern.matcher.IPatternMatchingEngineFactory;
import org.sidiff.consistency.graphpattern.matcher.lifting.engine.partial.PartialLiftingEngineFactoryFP;
import org.sidiff.consistency.graphpattern.matcher.matching.IMatching;
import org.sidiff.difference.symmetric.SymmetricDifference;

public class ComplementFinderFP extends ComplementFinder {

	public ComplementFinderFP(Resource modelAResource, Resource modelBResource, SymmetricDifference difference) {
		super(modelAResource, modelBResource, difference);
	}

	@Override
	protected IPatternMatchingEngineFactory<IMatching> getEngineFactory() {
		return new PartialLiftingEngineFactoryFP();
	}

}
