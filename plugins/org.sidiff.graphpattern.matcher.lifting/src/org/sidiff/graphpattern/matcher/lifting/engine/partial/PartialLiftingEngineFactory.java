package org.sidiff.graphpattern.matcher.lifting.engine.partial;

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
import org.sidiff.difference.symmetric.SymmetricDifference;
import org.sidiff.graphpattern.matcher.lifting.engine.LiftingEngine;
import org.sidiff.graphpattern.matcher.lifting.engine.LiftingEngineFactory;
import org.sidiff.graphpattern.matcher.lifting.util.LiftingGraphDomainMap;
import org.sidiff.graphpattern.matcher.lifting.util.LiftingGraphIndex;
import org.sidiff.graphpattern.matcher.lifting.util.RecognitionRuleUtil;

public abstract class PartialLiftingEngineFactory extends LiftingEngineFactory {

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
			engine.initialize(graphPatternNodes, new ArrayList<>(changeNodeDomains.keySet()), changeNodeDomains);
			
			return engine;
		}
		
		return null;
	}
	
	protected Map<NodePattern, Collection<EObject>> calculateChangeNodeDomains(
			List<NodePattern> graphPattern, LiftingGraphDomainMap changeDomainMap) {
		
		Map<NodePattern, Collection<EObject>> changeDomains = new LinkedHashMap<>();
		
		// Collect the matchings of the change nodes:
		for (NodePattern changeNode : getChangeNodePatterns(graphPattern)) {
			EClass changeType = changeNode.getType();
			EObject changeDomainType = RecognitionRuleUtil.getChangeType(changeNode);
			
			changeDomains.put(changeNode, changeDomainMap.getChangeDomain(changeType, changeDomainType));
		}

		return changeDomains;
	}
	
	protected abstract LiftingEngine createLiftingEngine(
			List<NodePattern> graphPattern, ResourceSet targetModels, 
			LiftingGraphIndex changeIndex,LiftingGraphDomainMap changeDomainMap);
}
