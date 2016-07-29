package org.sidiff.consistency.repair.lifting.engine.partial;

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
import org.sidiff.consistency.repair.lifting.engine.LiftingEngineFactory;
import org.sidiff.consistency.repair.lifting.util.LiftingGraphDomainMap;
import org.sidiff.consistency.repair.lifting.util.LiftingGraphIndex;
import org.sidiff.consistency.repair.lifting.util.RecognitionRuleUtil;
import org.sidiff.difference.symmetric.SymmetricDifference;

public class PartialLiftingEngineFactory extends LiftingEngineFactory {

	@Override
	public PartialLiftingEngine createPatternMatchingEngine(GraphPattern graphPattern, ResourceSet targetModels) {
		
		// Get target difference model:
		SymmetricDifference difference = RecognitionRuleUtil.getSymmetricDifference(targetModels);
		
		if (difference != null) {
			
			// Lifting graph optimizations:
			LiftingGraphDomainMap changeDomainMap = new LiftingGraphDomainMap(difference);
			LiftingGraphIndex changeIndex = new LiftingGraphIndex(difference);
			
			// Create the engine:
			List<NodePattern> graphPatternNodes = new ArrayList<>(graphPattern.getNodes());
			
			PartialLiftingEngine engine = new PartialLiftingEngine(
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
}
