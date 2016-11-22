package org.sidiff.consistency.repair.api.peo.engine.exact;

import java.util.List;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.sidiff.consistency.graphpattern.NodePattern;
import org.sidiff.consistency.repair.api.peo.engine.LiftingEngine;
import org.sidiff.consistency.repair.api.peo.util.LiftingGraphDomainMap;
import org.sidiff.consistency.repair.api.peo.util.LiftingGraphIndex;

public class ExactLiftingEngineFactoryMA extends ExactLiftingEngineFactory {

	@Override
	protected LiftingEngine createLiftingEngine(
			List<NodePattern> graphPattern, ResourceSet targetModels,
			LiftingGraphIndex changeIndex, LiftingGraphDomainMap changeDomainMap) {
		return new ExactLiftingEngineMA(graphPattern, targetModels, changeIndex, changeDomainMap);
	}
}
