package org.sidiff.graphpattern.matcher.matching;

import java.util.Map;

import org.sidiff.consistency.graphpattern.NodePattern;
import org.sidiff.graphpattern.matcher.matching.partial.NodeMatching;

/**
 * The match validation is used to filter/restrict the matching results.
 * 
 * @author Manuel Ohrndorf
 */
public interface IMatchValidation {

	/**
	 * Tests a complete matching for the formula:
	 * <code>match = v_1 x v_2 x ... x v_n</code>
	 * 
	 * @param matching
	 *            The matching of all variable nodes.
	 * @return <code>true</code> if the match will be accepted;
	 *         <code>false</code> otherwise.
	 */
	public boolean isMatch(Map<NodePattern, ? extends INodeMatching> matching);

	/**
	 * Tests a new assignment for a variable of the formula:
	 * <code>match = v_1 x v_2 x ... x v_n</code>
	 * 
	 * @param variableNode
	 *            The next assigned variable node.
	 * @param matching
	 *            The partial (i.e. not yet completed) matching of all variable
	 *            nodes.
	 * @return <code>true</code> if the match will be accepted;
	 *         <code>false</code> otherwise.
	 */
	public boolean isPotentialMatch(NodeMatching variableNode, Map<NodePattern, ? extends INodeMatching> matching);
}
