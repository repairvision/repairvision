package org.sidiff.consistency.graphpattern.matcher;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.sidiff.consistency.graphpattern.DataStore;
import org.sidiff.consistency.graphpattern.NodePattern;
import org.sidiff.consistency.graphpattern.matcher.algorithms.IIncrementalAlgorithm;
import org.sidiff.consistency.graphpattern.matcher.matching.IMatchGenerator;
import org.sidiff.consistency.graphpattern.matcher.matching.IMatching;
import org.sidiff.consistency.graphpattern.matcher.wgraph.IWorkingGraphConstructor;

/**
 * Basic interface of all pattern matching engines. This interface is used to
 * control the lifecycle of the engine: Initialization, evaluation/data-store
 * setup, working-graph construction, match generation and shutdown.
 * 
 * @param <R>
 *            The match type, i.e. some kind of matching container.
 *            
 * @author Manuel Ohrndorf
 * @param <O>
 */
public interface IPatternMatchingEngine<R extends IMatching> extends IIncrementalAlgorithm<R> {

	/**
	 * @param graphPattern
	 *            All nodes of the graph pattern that should be matched.
	 * @param variableNodes
	 *            The nodes which correspond to the matching formula:
	 *            <code>match = v_1 x v_2 x ... x v_n</code>
	 * @param variableNodeDomains
	 *            The variable node domains.
	 */
	public void initialize(List<NodePattern> graphPattern, List<NodePattern> variableNodes,
			Map<NodePattern, Collection<EObject>> variableNodeDomains);

	/**
	 * @return All nodes of the graph pattern that should be matched.
	 */
	public List<NodePattern> getGraphPattern();

	/**
	 * @return The nodes which correspond to the matching formula:
	 *         <code>match = v_1 x v_2 x ... x v_n</code>
	 */
	public List<NodePattern> getVariableNodes();

	/**
	 * @return The storage for one node of the working graph.
	 */
	public DataStore createDataStore();

	/**
	 * @return The algorithm ({@link IWorkingGraphConstructor}) that constructs
	 *         the working graph.
	 */
	public IWorkingGraphConstructor getWorkingGraphConstructor();

	/**
	 * @return The algorithm which calculates all matches for the given graph
	 *         pattern based on the calculated working graph.
	 */
	public IMatchGenerator<R> getMatchGenerator();
}
