package org.sidiff.consistency.graphpattern.matcher.lifting.engine.exact;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.sidiff.consistency.graphpattern.Visitor;
import org.sidiff.consistency.graphpattern.matcher.lifting.engine.LiftingWorkingGraphConstructor;
import org.sidiff.consistency.graphpattern.matcher.lifting.util.LiftingGraphDomainMap;
import org.sidiff.consistency.graphpattern.matcher.lifting.util.LiftingGraphIndex;
import org.sidiff.consistency.graphpattern.matcher.wgraph.BasicConstraintTester;
import org.sidiff.consistency.graphpattern.matcher.wgraph.IConstraintTester;
import org.sidiff.consistency.graphpattern.matcher.wgraph.exact.ExactMatchNeighborsVisitor;

public class ExactWorkingGraphConstructor extends LiftingWorkingGraphConstructor {

	private IConstraintTester constraintTester;
	
	public ExactWorkingGraphConstructor(ResourceSet targetModels, 
			LiftingGraphIndex changeIndex, LiftingGraphDomainMap changeDomainMap) {
		super(targetModels, changeIndex, changeDomainMap);
	}
	
	@Override
	public Visitor createVisitor() {
		return new ExactMatchNeighborsVisitor(getMatchingHelper(), getConstraintTester());
	}

	@Override
	public IConstraintTester getConstraintTester() {
		
		if (constraintTester == null) {
			constraintTester = new BasicConstraintTester(getMatchingHelper());
		}
		
		return constraintTester;
	}
}
