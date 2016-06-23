package org.sidiff.consistency.graphpattern.matcher.matching;

import java.util.Map;

import org.sidiff.consistency.graphpattern.NodePattern;

public interface IMatchValidation {

	public boolean isMatch(Map<NodePattern, NodeMatching> matching);
	
	public boolean isPotentialMatch(NodeMatching newNodeMatching, Map<NodePattern, NodeMatching> matching);
}
