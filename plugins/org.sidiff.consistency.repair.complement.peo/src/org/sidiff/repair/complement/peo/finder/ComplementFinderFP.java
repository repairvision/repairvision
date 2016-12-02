package org.sidiff.repair.complement.peo.finder;

import org.eclipse.emf.ecore.resource.Resource;
import org.sidiff.difference.symmetric.SymmetricDifference;
import org.sidiff.graphpattern.matcher.IPatternMatchingEngineFactory;
import org.sidiff.graphpattern.matcher.lifting.engine.partial.PartialLiftingEngineFactoryFP;
import org.sidiff.graphpattern.matching.IMatching;

public class ComplementFinderFP extends ComplementFinder {

	public ComplementFinderFP(Resource modelAResource, Resource modelBResource, SymmetricDifference difference) {
		super(modelAResource, modelBResource, difference);
	}

	@Override
	protected IPatternMatchingEngineFactory<IMatching> getEngineFactory() {
		return new PartialLiftingEngineFactoryFP();
	}

}
