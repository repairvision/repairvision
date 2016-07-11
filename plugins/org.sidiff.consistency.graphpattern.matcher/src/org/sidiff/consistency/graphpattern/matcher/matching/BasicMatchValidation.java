package org.sidiff.consistency.graphpattern.matcher.matching;

import java.util.Map;

import org.sidiff.consistency.graphpattern.NodePattern;
import org.sidiff.consistency.graphpattern.matcher.matching.partial.NodeMatching;

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
