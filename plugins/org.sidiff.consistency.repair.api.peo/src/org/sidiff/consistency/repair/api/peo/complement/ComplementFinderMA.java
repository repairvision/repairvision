package org.sidiff.consistency.repair.api.peo.complement;

import org.eclipse.emf.ecore.resource.Resource;
import org.sidiff.consistency.graphpattern.matcher.IPatternMatchingEngineFactory;
import org.sidiff.consistency.graphpattern.matcher.matching.IMatching;
import org.sidiff.consistency.repair.api.peo.engine.partial.PartialLiftingEngineFactoryMA;
import org.sidiff.difference.symmetric.SymmetricDifference;

public class ComplementFinderMA extends ComplementFinder {

	public ComplementFinderMA(Resource modelAResource, Resource modelBResource, SymmetricDifference difference) {
		super(modelAResource, modelBResource, difference);
	}

	@Override
	protected IPatternMatchingEngineFactory<IMatching> getEngineFactory() {
		return new PartialLiftingEngineFactoryMA();
	}

}
