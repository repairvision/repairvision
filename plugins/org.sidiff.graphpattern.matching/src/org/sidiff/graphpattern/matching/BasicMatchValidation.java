package org.sidiff.graphpattern.matching;

import java.util.Map;

import org.sidiff.graphpattern.NodePattern;
import org.sidiff.graphpattern.matching.algorithms.NodeMatching;

/**
 * An unrestricted implementation of {@link IMatchValidation}.
 * 
 * @author Manuel Ohrndorf
 */
public class BasicMatchValidation implements IMatchValidation {

	@Override
	public boolean isMatch(Map<NodePattern, ? extends INodeMatching> matching) {
		return true;
	}

	@Override
	public boolean isPotentialMatch(NodeMatching newNodeMatching, Map<NodePattern, ? extends INodeMatching> matching) {
		return true;
	}
}
