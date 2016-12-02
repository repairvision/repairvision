package org.sidiff.consistency.graphpattern.matcher.lifting.engine.exact;

import java.util.List;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.sidiff.consistency.graphpattern.NodePattern;
import org.sidiff.consistency.graphpattern.matcher.lifting.engine.LiftingEngine;
import org.sidiff.consistency.graphpattern.matcher.lifting.util.LiftingGraphDomainMap;
import org.sidiff.consistency.graphpattern.matcher.lifting.util.LiftingGraphIndex;

public class ExactLiftingEngineFactoryMA extends ExactLiftingEngineFactory {

	@Override
	protected LiftingEngine createLiftingEngine(
			List<NodePattern> graphPattern, ResourceSet targetModels,
			LiftingGraphIndex changeIndex, LiftingGraphDomainMap changeDomainMap) {
		return new ExactLiftingEngineMA(graphPattern, targetModels, changeIndex, changeDomainMap);
	}
}
