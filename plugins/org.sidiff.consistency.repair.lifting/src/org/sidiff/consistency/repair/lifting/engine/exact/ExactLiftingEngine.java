package org.sidiff.consistency.repair.lifting.engine.exact;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.sidiff.consistency.graphpattern.NodePattern;
import org.sidiff.consistency.graphpattern.Visitor;
import org.sidiff.consistency.graphpattern.matcher.wgraph.exact.ExactMatchNeighborsVisitor;
import org.sidiff.consistency.repair.lifting.engine.LiftingEngine;
import org.sidiff.consistency.repair.lifting.util.LiftingGraphDomainMap;
import org.sidiff.consistency.repair.lifting.util.LiftingGraphIndex;
import org.sidiff.consistency.repair.lifting.util.RecognitionRuleUtil;
import org.sidiff.difference.symmetric.SymmetricDifference;

public class ExactLiftingEngine extends LiftingEngine {

	public ExactLiftingEngine(List<NodePattern> graphPattern, ResourceSet targetModels, 
			LiftingGraphIndex changeIndex,LiftingGraphDomainMap changeDomainMap) {
		super(graphPattern, targetModels, changeIndex, changeDomainMap);
	}

	public Map<NodePattern, Collection<EObject>> calculateChangeNodes(SymmetricDifference difference) {
		
		// Calculate the initial node:
		NodePattern initialNode = null;
		int initialNodeDomainSize = -1;

		for (NodePattern nodePattern : getChangeNodePatterns()) {
			EClass changeType = nodePattern.getType();
			EObject changeDomainType = RecognitionRuleUtil.getChangeType(nodePattern);
			int changeDomainSize = changeDomainMap.getChangeDomainSize(changeType, changeDomainType);

			if ((initialNode == null) || ((changeDomainSize < initialNodeDomainSize) && (changeDomainSize > 0))) {
				initialNode = nodePattern;
				initialNodeDomainSize = changeDomainSize;
			}
		}

		EClass changeType = initialNode.getType();
		EObject changeDomainType = RecognitionRuleUtil.getChangeType(initialNode);
		
		Map<NodePattern, Collection<EObject>> variableNodes = new LinkedHashMap<>();
		variableNodes.put(initialNode, changeDomainMap.getChangeDomain(changeType, changeDomainType));
		
		return variableNodes;
	}

	@Override
	public Visitor createVisitor() {
		return new ExactMatchNeighborsVisitor(this);
	}
}
