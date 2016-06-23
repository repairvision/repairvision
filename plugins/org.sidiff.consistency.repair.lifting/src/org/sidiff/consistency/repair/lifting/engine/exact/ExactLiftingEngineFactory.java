package org.sidiff.consistency.repair.lifting.engine.exact;

import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.sidiff.consistency.graphpattern.GraphPattern;
import org.sidiff.consistency.graphpattern.NodePattern;
import org.sidiff.consistency.graphpattern.matcher.IPatternMatchingEngine;
import org.sidiff.consistency.graphpattern.matcher.IPatternMatchingEngineFactory;
import org.sidiff.consistency.repair.lifting.util.LiftingGraphDomainMap;
import org.sidiff.consistency.repair.lifting.util.LiftingGraphIndex;
import org.sidiff.consistency.repair.lifting.util.RecognitionRuleUtil;
import org.sidiff.difference.symmetric.SymmetricDifference;

public class ExactLiftingEngineFactory implements IPatternMatchingEngineFactory {

	@Override
	public IPatternMatchingEngine createPatternMatchingEngine(GraphPattern graphpattern, ResourceSet targetModels) {
		
		// Get target difference model:
		SymmetricDifference difference = RecognitionRuleUtil.getSymmetricDifference(targetModels);
		
		if (difference != null) {
			
			// Lifting graph optimizations:
			LiftingGraphDomainMap changeDomainMap = new LiftingGraphDomainMap(difference);
			LiftingGraphIndex changeIndex = new LiftingGraphIndex(difference);
			
			// Create the engine:
			ExactLiftingEngine engine = new ExactLiftingEngine(
					graphpattern, targetModels, changeIndex, changeDomainMap);
			Map<NodePattern, Collection<EObject>> anchors = engine.calculateAnchors(difference);
			engine.initialize(anchors);
			
			return engine;
		}
		
		return null;
	}
}
