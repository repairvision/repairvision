package org.sidiff.consistency.repair.lifting.matching;

import java.util.Map;

import org.sidiff.consistency.graphpattern.NodePattern;
import org.sidiff.consistency.graphpattern.matcher.matching.BasicMatchValidation;
import org.sidiff.consistency.graphpattern.matcher.matching.NodeMatching;

public class LiftingMatchValidation extends BasicMatchValidation {
	
	@Override
	public boolean isPotentialMatch(NodeMatching newNodeMatching, Map<NodePattern, NodeMatching> matching) {
		return super.isPotentialMatch(newNodeMatching, matching);
	}
	
	@Override
	public boolean isMatch(Map<NodePattern, NodeMatching> matching) {
		return super.isMatch(matching);
	}
}
