package org.sidiff.graphpattern.matcher.matching;

import java.util.List;

import org.sidiff.consistency.graphpattern.NodePattern;
import org.sidiff.graphpattern.common.algorithms.IIncrementalAlgorithm;
import org.sidiff.graphpattern.wgraph.construction.IWorkingGraphConstructor;

/**
 * The algorithm which calculates all matches for the given graph pattern based
 * on the calculated working graph ({@link IWorkingGraphConstructor}). A
 * {@link IMatchGenerator} iterates through all matches which can be found in
 * working graph by {@link IMatchGenerator#getResults()}. The lifecycle of the
 * matcher will be controlled by {@link IMatchGenerator#start()}
 * (initialization) and {@link IMatchGenerator#finish()} clean up.
 *
 * @param <R>
 *            The match type, i.e. some kind of matching container.
 * 
 * @author Manuel Ohrndorf
 */
public interface IMatchGenerator<R> extends IIncrementalAlgorithm<R> {

	/**
	 * @param graphPattern
	 *            All nodes of the graph pattern that should be matched.
	 * @param variableNodes
	 *            The nodes which correspond to the matching formula:
	 *            <code>match = v_1 x v_2 x ... x v_n</code>
	 */
	public void initialize(List<NodePattern> graphPattern, List<NodePattern> variableNodes);
	
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
