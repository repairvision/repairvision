package org.sidiff.graphpattern.matcher.lifting.engine.partial;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.sidiff.difference.symmetric.SymmetricPackage;
import org.sidiff.graphpattern.EdgePattern;
import org.sidiff.graphpattern.NodePattern;
import org.sidiff.graphpattern.Visitor;
import org.sidiff.graphpattern.matcher.lifting.engine.LiftingWorkingGraphConstructor;
import org.sidiff.graphpattern.matcher.lifting.util.LiftingGraphDomainMap;
import org.sidiff.graphpattern.matcher.lifting.util.LiftingGraphIndex;
import org.sidiff.graphpattern.wgraph.construction.IConstraintTester;
import org.sidiff.graphpattern.wgraph.construction.partial.LocalEvaluationMatcher;
import org.sidiff.graphpattern.wgraph.construction.partial.LocalEvaluationPathAnalyser;
import org.sidiff.graphpattern.wgraph.construction.tools.paths.IPathRestriction;

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
