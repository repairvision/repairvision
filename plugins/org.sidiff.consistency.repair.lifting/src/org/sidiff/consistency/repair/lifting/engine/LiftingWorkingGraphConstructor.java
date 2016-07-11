package org.sidiff.consistency.repair.lifting.engine;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.sidiff.consistency.graphpattern.matcher.tools.CrossReferencer;
import org.sidiff.consistency.graphpattern.matcher.wgraph.AbstractWorkingGraphConstructor;
import org.sidiff.consistency.repair.lifting.matching.LiftingCrossReferencer;
import org.sidiff.consistency.repair.lifting.util.LiftingGraphDomainMap;
import org.sidiff.consistency.repair.lifting.util.LiftingGraphIndex;

public abstract class LiftingWorkingGraphConstructor extends AbstractWorkingGraphConstructor {

	protected CrossReferencer crossReferencer;
	
	public LiftingWorkingGraphConstructor(ResourceSet targetModels,
			LiftingGraphIndex changeIndex, LiftingGraphDomainMap changeDomainMap) {
		crossReferencer = new LiftingCrossReferencer(targetModels, changeIndex, changeDomainMap);
	}
	
	@Override
	public CrossReferencer getCrossReferencer() {
		return crossReferencer;
	}
}
