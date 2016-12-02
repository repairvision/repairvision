package org.sidiff.graphpattern.matcher.lifting.engine;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.sidiff.graphpattern.matcher.lifting.util.LiftingCrossReferencer;
import org.sidiff.graphpattern.matcher.lifting.util.LiftingGraphDomainMap;
import org.sidiff.graphpattern.matcher.lifting.util.LiftingGraphIndex;
import org.sidiff.graphpattern.wgraph.construction.AbstractWorkingGraphConstructor;
import org.sidiff.graphpattern.wgraph.construction.tools.matching.CrossReferencer;

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
