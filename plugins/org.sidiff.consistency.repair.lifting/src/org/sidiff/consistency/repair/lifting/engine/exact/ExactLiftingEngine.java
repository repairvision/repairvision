package org.sidiff.consistency.repair.lifting.engine.exact;

import java.util.List;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.sidiff.consistency.graphpattern.NodePattern;
import org.sidiff.consistency.graphpattern.Visitor;
import org.sidiff.consistency.graphpattern.matcher.wgraph.BasicConstraintTester;
import org.sidiff.consistency.graphpattern.matcher.wgraph.IConstraintTester;
import org.sidiff.consistency.graphpattern.matcher.wgraph.IWorkingGraphConstructor;
import org.sidiff.consistency.graphpattern.matcher.wgraph.exact.ExactMatchNeighborsVisitor;
import org.sidiff.consistency.repair.lifting.engine.LiftingEngine;
import org.sidiff.consistency.repair.lifting.engine.LiftingWorkingGraphConstructor;
import org.sidiff.consistency.repair.lifting.util.LiftingGraphDomainMap;
import org.sidiff.consistency.repair.lifting.util.LiftingGraphIndex;

public class ExactLiftingEngine extends LiftingEngine {

	public ExactLiftingEngine(List<NodePattern> graphPattern, ResourceSet targetModels, 
			LiftingGraphIndex changeIndex,LiftingGraphDomainMap changeDomainMap) {
		super(graphPattern, targetModels, changeIndex, changeDomainMap);
	}

	@Override
	public IWorkingGraphConstructor getWorkingGraphConstructor() {
		return new LiftingWorkingGraphConstructor(targetModels, changeIndex, changeDomainMap) {
			
			private IConstraintTester constraintTester;
			
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
		};
	}
}
