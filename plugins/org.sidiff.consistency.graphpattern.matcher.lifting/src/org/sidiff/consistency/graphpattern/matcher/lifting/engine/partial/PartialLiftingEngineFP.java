package org.sidiff.consistency.graphpattern.matcher.lifting.engine.partial;

import java.util.List;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.sidiff.consistency.graphpattern.NodePattern;
import org.sidiff.consistency.graphpattern.matcher.lifting.engine.LiftingMatchGeneratorFP;
import org.sidiff.consistency.graphpattern.matcher.lifting.util.LiftingGraphDomainMap;
import org.sidiff.consistency.graphpattern.matcher.lifting.util.LiftingGraphIndex;
import org.sidiff.consistency.graphpattern.matcher.matching.IMatchGenerator;
import org.sidiff.consistency.graphpattern.matcher.matching.IMatching;

public class PartialLiftingEngineFP extends PartialLiftingEngine {

	public PartialLiftingEngineFP(
			List<NodePattern> graphPattern, ResourceSet targetModels,
			LiftingGraphIndex changeIndex, LiftingGraphDomainMap changeDomainMap) {
		super(graphPattern, targetModels, changeIndex, changeDomainMap);
	}

	@Override
	protected IMatchGenerator<IMatching> createMatchGenerator() {
		return new LiftingMatchGeneratorFP(); 
	}
}
