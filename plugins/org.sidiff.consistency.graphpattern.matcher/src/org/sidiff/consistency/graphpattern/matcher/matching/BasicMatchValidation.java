package org.sidiff.consistency.graphpattern.matcher.matching;

import java.util.Map;

import org.sidiff.consistency.graphpattern.NodePattern;

public class BasicMatchValidation implements IMatchValidation {

	@Override
	public boolean isMatch(Map<NodePattern, NodeMatching> matching) {
		return true;
	}

	@Override
	public boolean isPotentialMatch(NodeMatching newNodeMatching, Map<NodePattern, NodeMatching> matching) {
		return true;
	}
}
