package org.sidiff.consistency.repair.lifting.engine.exact;

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
import org.sidiff.consistency.graphpattern.matcher.IPatternMatchingEngine;
import org.sidiff.consistency.graphpattern.matcher.data.selection.SelectionMatching;
import org.sidiff.consistency.repair.lifting.engine.LiftingEngineFactory;
import org.sidiff.consistency.repair.lifting.util.LiftingGraphDomainMap;
import org.sidiff.consistency.repair.lifting.util.LiftingGraphIndex;
import org.sidiff.consistency.repair.lifting.util.RecognitionRuleUtil;
import org.sidiff.difference.symmetric.SymmetricDifference;

public class ExactLiftingEngineFactory extends LiftingEngineFactory {

	@Override
	public IPatternMatchingEngine<SelectionMatching> createPatternMatchingEngine(
			GraphPattern graphPattern, ResourceSet targetModels) {
		
		// Get target difference model:
		SymmetricDifference difference = RecognitionRuleUtil.getSymmetricDifference(targetModels);
		
		if (difference != null) {
			
			// Lifting graph optimizations:
			LiftingGraphDomainMap changeDomainMap = new LiftingGraphDomainMap(difference);
			LiftingGraphIndex changeIndex = new LiftingGraphIndex(difference);
			
			// Create the engine:
			List<NodePattern> graphPatternNodes = new ArrayList<>(graphPattern.getNodes());
			
			ExactLiftingEngine engine = new ExactLiftingEngine(
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
}
