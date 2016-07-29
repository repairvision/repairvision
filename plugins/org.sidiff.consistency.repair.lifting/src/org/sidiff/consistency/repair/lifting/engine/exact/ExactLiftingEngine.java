package org.sidiff.consistency.repair.lifting.engine.exact;

import java.util.List;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.sidiff.consistency.graphpattern.NodePattern;
import org.sidiff.consistency.repair.lifting.engine.LiftingEngine;
import org.sidiff.consistency.repair.lifting.util.LiftingGraphDomainMap;
import org.sidiff.consistency.repair.lifting.util.LiftingGraphIndex;

public class ExactLiftingEngine extends LiftingEngine {

	protected ExactWorkingGraphConstructor workingGraphConstructor;
	
	public ExactLiftingEngine(List<NodePattern> graphPattern, ResourceSet targetModels, 
			LiftingGraphIndex changeIndex,LiftingGraphDomainMap changeDomainMap) {
		super(graphPattern, targetModels, changeIndex, changeDomainMap);
		
		this.workingGraphConstructor = new ExactWorkingGraphConstructor(targetModels, changeIndex, changeDomainMap);
	}

	@Override
	public ExactWorkingGraphConstructor getWorkingGraphConstructor() {
		return workingGraphConstructor;
	}
}
