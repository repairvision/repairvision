package org.sidiff.consistency.graphpattern.matcher.lifting.engine.exact;

import java.util.List;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.sidiff.consistency.graphpattern.NodePattern;
import org.sidiff.consistency.graphpattern.matcher.lifting.engine.LiftingEngine;
import org.sidiff.consistency.graphpattern.matcher.lifting.engine.LiftingMatchGeneratorFP;
import org.sidiff.consistency.graphpattern.matcher.lifting.util.LiftingGraphDomainMap;
import org.sidiff.consistency.graphpattern.matcher.lifting.util.LiftingGraphIndex;
import org.sidiff.consistency.graphpattern.matcher.matching.IMatchGenerator;
import org.sidiff.consistency.graphpattern.matcher.matching.IMatching;

public class ExactLiftingEngineFP extends LiftingEngine {

	protected ExactWorkingGraphConstructor workingGraphConstructor;
	
	public ExactLiftingEngineFP(List<NodePattern> graphPattern, ResourceSet targetModels, 
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
		return new LiftingMatchGeneratorFP();
	}
}
