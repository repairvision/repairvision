package org.sidiff.graphpattern.wgraph.construction;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.sidiff.consistency.graphpattern.NodePattern;
import org.sidiff.consistency.graphpattern.Visitor;
import org.sidiff.graphpattern.wgraph.construction.tools.matching.CrossReferencer;
import org.sidiff.graphpattern.wgraph.construction.tools.matching.MatchingHelper;

/**
 * Basic implementation of a {@link IWorkingGraphConstructor}.
 * 
 * @author Manuel Ohrndorf
 */
public abstract class AbstractWorkingGraphConstructor implements IWorkingGraphConstructor {

	protected List<NodePattern> graphPattern;

	protected List<NodePattern> variableNodes;
	
	protected Map<NodePattern, Collection<EObject>> variableNodeDomains;
	
	protected MatchingHelper matchingHelper;
	
	@Override
	public void initialize(List<NodePattern> graphPattern, List<NodePattern> variableNodes, 
			Map<NodePattern, Collection<EObject>> variableNodeDomains) {
		
		this.graphPattern = graphPattern;
		this.variableNodes = variableNodes;
		this.variableNodeDomains = variableNodeDomains;
		
		this.matchingHelper = new MatchingHelper(getCrossReferencer());
	}
	
	public abstract CrossReferencer getCrossReferencer();
	
	@Override
	public void start() {
				
		// Start visiting at the variable nodes:
		variableNodes.forEach(node -> {
			node.getEvaluation().accept(createVisitor());
		});
	}
	
	@Override
	public void finish() {
	}
	
	public abstract Visitor createVisitor();
	
	public abstract IConstraintTester getConstraintTester();
	
	public MatchingHelper getMatchingHelper() {
		return matchingHelper;
	}
	
	@Override
	public List<NodePattern> getGraphPattern() {
		return graphPattern;
	}
	
	@Override
	public List<NodePattern> getVariableNodes() {
		return variableNodes;
	}
}
