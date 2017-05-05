package org.sidiff.graphpattern.matcher;

import java.util.List;

import org.sidiff.graphpattern.NodePattern;
import org.sidiff.graphpattern.common.algorithms.IIncrementalAlgorithm;

/**
 * Basic interface of all pattern matching engines. This interface is used to
 * control the lifecycle of the engine: Initialization, evaluation/data-store
 * setup, working-graph construction, match generation and shutdown.
 * 
 * @param <R>
 *            The match type, i.e. some kind of matching container ({@link IMatching}).
 *            
 * @author Manuel Ohrndorf
 */
public interface IPatternMatchingEngine<R extends IMatching> extends IIncrementalAlgorithm<R> {

	/**
	 * @return All nodes of the graph pattern that should be matched.
	 */
	public List<NodePattern> getGraphPattern();

	/**
	 * @return The nodes which correspond to the matching formula:
	 *         <code>match = v_1 x v_2 x ... x v_n</code>
	 */
	public List<NodePattern> getVariableNodes();
}
