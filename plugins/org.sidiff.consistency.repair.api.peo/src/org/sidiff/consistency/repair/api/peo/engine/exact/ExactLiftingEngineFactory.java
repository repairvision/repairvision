package org.sidiff.consistency.repair.api.peo.engine.exact;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.sidiff.consistency.graphpattern.GraphPattern;
import org.sidiff.consistency.graphpattern.NodePattern;
import org.sidiff.consistency.repair.api.peo.engine.LiftingEngine;
import org.sidiff.consistency.repair.api.peo.engine.LiftingEngineFactory;
import org.sidiff.consistency.repair.api.peo.util.LiftingGraphDomainMap;
import org.sidiff.consistency.repair.api.peo.util.LiftingGraphIndex;
import org.sidiff.consistency.repair.api.peo.util.RecognitionRuleUtil;
import org.sidiff.difference.symmetric.SymmetricDifference;

public abstract class ExactLiftingEngineFactory extends LiftingEngineFactory {

	@Override
	public LiftingEngine createPatternMatchingEngine(GraphPattern graphPattern, ResourceSet targetModels) {
		
		// Get target difference model:
		SymmetricDifference difference = RecognitionRuleUtil.getSymmetricDifference(targetModels);
		
		if (difference != null) {
			
			// Lifting graph optimizations:
			LiftingGraphDomainMap changeDomainMap = new LiftingGraphDomainMap(difference);
			LiftingGraphIndex changeIndex = new LiftingGraphIndex(difference);
			
			// Create the engine:
			List<NodePattern> graphPatternNodes = new ArrayList<>(graphPattern.getNodes());
			
			LiftingEngine engine = createLiftingEngine(
					graphPatternNodes, targetModels, changeIndex, changeDomainMap);
			Map<NodePattern, Collection<EObject>> changeNodeDomains = calculateChangeNodeDomains(
					graphPatternNodes, changeDomainMap);
			engine.initialize(
					graphPatternNodes, 
					new ArrayList<>(getChangeNodePatterns(graphPatternNodes)), 
					changeNodeDomains);
			
			return engine;
		}
		
		return null;
	}
	
	public Map<NodePattern, Collection<EObject>> calculateChangeNodeDomains(
			List<NodePattern> graphPattern, LiftingGraphDomainMap changeDomainMap) {
		
		// Calculate the initial node:
		NodePattern initialNode = null;
		int initialNodeDomainSize = -1;

		for (NodePattern nodePattern : getChangeNodePatterns(graphPattern)) {
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
	
	protected abstract LiftingEngine createLiftingEngine(
			List<NodePattern> graphPattern, ResourceSet targetModels, 
			LiftingGraphIndex changeIndex,LiftingGraphDomainMap changeDomainMap);
}
