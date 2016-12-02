package org.sidiff.consistency.graphpattern.matcher.lifting.engine;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.sidiff.consistency.graphpattern.NodePattern;
import org.sidiff.consistency.graphpattern.matcher.IPatternMatchingEngineFactory;
import org.sidiff.consistency.graphpattern.matcher.lifting.util.RecognitionRuleUtil;
import org.sidiff.consistency.graphpattern.matcher.matching.IMatching;

public abstract class LiftingEngineFactory implements IPatternMatchingEngineFactory<IMatching> {

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
