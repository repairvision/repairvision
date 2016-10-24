package org.sidiff.consistency.repair.api.peo.engine;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.sidiff.consistency.graphpattern.NodePattern;
import org.sidiff.consistency.graphpattern.matcher.IPatternMatchingEngineFactory;
import org.sidiff.consistency.repair.api.peo.util.RecognitionRuleUtil;

public abstract class LiftingEngineFactory implements IPatternMatchingEngineFactory {

	protected Collection<NodePattern> getChangeNodePatterns(List<NodePattern> graphPattern) {
		List <NodePattern> changeNodes = new ArrayList<>();
		
		for (NodePattern node : graphPattern) {
			if (RecognitionRuleUtil.isChangeNode(node)) {
				changeNodes.add(node);
			}
		}
		
		return changeNodes;
	}
}
