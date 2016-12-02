package org.sidiff.graphpattern.matcher.lifting.engine.exact;

import java.util.List;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.sidiff.consistency.graphpattern.NodePattern;
import org.sidiff.graphpattern.matcher.lifting.engine.LiftingEngine;
import org.sidiff.graphpattern.matcher.lifting.engine.LiftingMatchGeneratorMA;
import org.sidiff.graphpattern.matcher.lifting.util.LiftingGraphDomainMap;
import org.sidiff.graphpattern.matcher.lifting.util.LiftingGraphIndex;
import org.sidiff.graphpattern.matching.IMatchGenerator;
import org.sidiff.graphpattern.matching.IMatching;

public class ExactLiftingEngineMA extends LiftingEngine {

	protected ExactWorkingGraphConstructor workingGraphConstructor;
	
	public ExactLiftingEngineMA(List<NodePattern> graphPattern, ResourceSet targetModels, 
			LiftingGraphIndex changeIndex,LiftingGraphDomainMap changeDomainMap) {
		super(graphPattern, targetModels, changeIndex, changeDomainMap);
		
		this.workingGraphConstructor = new ExactWorkingGraphConstructor(targetModels, changeIndex, changeDomainMap);
	}

	@Override
	public ExactWorkingGraphConstructor getWorkingGraphConstructor() {
		return workingGraphConstructor;
	}

	@Override
	protected IMatchGenerator<IMatching> createMatchGenerator() {
		return new LiftingMatchGeneratorMA();
	}
}
