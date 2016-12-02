package org.sidiff.consistency.graphpattern.matcher.lifting.engine.partial;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.sidiff.consistency.graphpattern.EdgePattern;
import org.sidiff.consistency.graphpattern.NodePattern;
import org.sidiff.consistency.graphpattern.Visitor;
import org.sidiff.consistency.graphpattern.matcher.lifting.engine.LiftingWorkingGraphConstructor;
import org.sidiff.consistency.graphpattern.matcher.lifting.util.LiftingGraphDomainMap;
import org.sidiff.consistency.graphpattern.matcher.lifting.util.LiftingGraphIndex;
import org.sidiff.consistency.graphpattern.matcher.tools.paths.IPathRestriction;
import org.sidiff.consistency.graphpattern.matcher.wgraph.IConstraintTester;
import org.sidiff.consistency.graphpattern.matcher.wgraph.partial.LocalEvaluationMatcher;
import org.sidiff.consistency.graphpattern.matcher.wgraph.partial.LocalEvaluationPathAnalyser;
import org.sidiff.difference.symmetric.SymmetricPackage;

public class PartialWorkingGraphConstructor extends LiftingWorkingGraphConstructor {

	private IPathRestriction pathRestriction;
	
	private LocalEvaluationPathAnalyser localEvaluation;
	
	private IConstraintTester constraintTester;
	
	public PartialWorkingGraphConstructor(ResourceSet targetModels, 
			LiftingGraphIndex changeIndex, LiftingGraphDomainMap changeDomainMap) {
		
		super(targetModels, changeIndex, changeDomainMap);
	}
	
	@Override
	public void initialize(List<NodePattern> graphPattern, List<NodePattern> variableNodes,
			Map<NodePattern, Collection<EObject>> variableNodeDomains) {
		
		super.initialize(graphPattern, variableNodes, variableNodeDomains);
		
		// Create path restrictions:
		pathRestriction = createPathRestriction();
		
		// Create constraint tester:
		constraintTester = new PartialLiftingConstraintTester(getMatchingHelper());
		
		// Calculate local evaluation:
		// TODO[LocalEvaluationPathAnalyser]: This should be done in more static way...
		long startTime = System.currentTimeMillis();
		
		localEvaluation =  new LocalEvaluationPathAnalyser(variableNodes, pathRestriction);
		
		System.out.println("Evaluation Graphs Construction Time: " 
				+ (System.currentTimeMillis() - startTime) / 1000.0 + "s");
	}
	
	private IPathRestriction createPathRestriction() {
		return new IPathRestriction() {
			
			@Override
			public boolean isRestrictedOutgoing(EdgePattern edge) {
				
				// Evaluate only local changes -> block paths at the type-node:
				if ((edge.getType() == SymmetricPackage.eINSTANCE.getRemoveReference_Type())
						|| (edge.getType() == SymmetricPackage.eINSTANCE.getAddReference_Type())
						|| (edge.getType() == SymmetricPackage.eINSTANCE.getAttributeValueChange())) {
					return true;
				}
				
				return false;
			}
			
			@Override
			public boolean isRestrictedIncoming(EdgePattern edge) {
				return false;
			}
		};
	}

	@Override
	public Visitor createVisitor() {
		return new LocalEvaluationMatcher(getMatchingHelper(), getConstraintTester(),
				localEvaluation.getLocalEvaluations(), pathRestriction);
//		return new PartialMatchNeighborsVisitor(matchingHelper);
	}
	
	@Override
	public IConstraintTester getConstraintTester() {
		return constraintTester;
	}
	
	public Map<NodePattern, Set<EdgePattern>> getLocalEvaluation() {
		return localEvaluation.getLocalEvaluations();
	}
}
