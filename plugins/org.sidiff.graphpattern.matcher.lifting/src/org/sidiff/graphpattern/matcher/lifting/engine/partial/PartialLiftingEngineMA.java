package org.sidiff.graphpattern.matcher.lifting.engine.partial;

import java.util.List;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.sidiff.consistency.graphpattern.NodePattern;
import org.sidiff.graphpattern.matcher.lifting.engine.LiftingMatchGeneratorMA;
import org.sidiff.graphpattern.matcher.lifting.util.LiftingGraphDomainMap;
import org.sidiff.graphpattern.matcher.lifting.util.LiftingGraphIndex;
import org.sidiff.graphpattern.matching.IMatchGenerator;
import org.sidiff.graphpattern.matching.IMatching;

public class PartialLiftingEngineMA extends PartialLiftingEngine {

	public PartialLiftingEngineMA(
			List<NodePattern> graphPattern, ResourceSet targetModels,
			LiftingGraphIndex changeIndex, LiftingGraphDomainMap changeDomainMap) {
		super(graphPattern, targetModels, changeIndex, changeDomainMap);
	}

	@Override
	protected IMatchGenerator<IMatching> createMatchGenerator() {
		return new LiftingMatchGeneratorMA(); 
	}
}
