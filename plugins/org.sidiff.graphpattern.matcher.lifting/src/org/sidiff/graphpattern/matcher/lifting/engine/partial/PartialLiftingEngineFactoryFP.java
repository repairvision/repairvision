package org.sidiff.graphpattern.matcher.lifting.engine.partial;

import java.util.List;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.sidiff.graphpattern.NodePattern;
import org.sidiff.graphpattern.matcher.lifting.engine.LiftingEngine;
import org.sidiff.graphpattern.matcher.lifting.util.LiftingGraphDomainMap;
import org.sidiff.graphpattern.matcher.lifting.util.LiftingGraphIndex;

public class PartialLiftingEngineFactoryFP extends PartialLiftingEngineFactory {

	@Override
	protected LiftingEngine createLiftingEngine(
			List<NodePattern> graphPattern, ResourceSet targetModels,
			LiftingGraphIndex changeIndex, LiftingGraphDomainMap changeDomainMap) {
		return new PartialLiftingEngineFP(graphPattern, targetModels, changeIndex, changeDomainMap);
	}
}
