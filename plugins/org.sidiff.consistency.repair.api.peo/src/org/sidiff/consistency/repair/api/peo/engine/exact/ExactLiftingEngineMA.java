package org.sidiff.consistency.repair.api.peo.engine.exact;

import java.util.List;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.sidiff.consistency.graphpattern.NodePattern;
import org.sidiff.consistency.graphpattern.matcher.matching.IMatchGenerator;
import org.sidiff.consistency.graphpattern.matcher.matching.IMatching;
import org.sidiff.consistency.repair.api.peo.engine.LiftingEngine;
import org.sidiff.consistency.repair.api.peo.engine.LiftingMatchGeneratorMA;
import org.sidiff.consistency.repair.api.peo.util.LiftingGraphDomainMap;
import org.sidiff.consistency.repair.api.peo.util.LiftingGraphIndex;

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
