package org.sidiff.consistency.graphpattern.matcher.matching;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.sidiff.consistency.graphpattern.NodePattern;
import org.sidiff.consistency.graphpattern.matcher.matching.partial.NodeMatching;
import org.sidiff.consistency.graphpattern.matcher.matching.selection.AtomicPattern;
import org.sidiff.consistency.graphpattern.matcher.matching.selection.IAtomicPatternFactory;

/**
 * Basic implementation of a {@link IMatchGenerator}.
 *
 * @param <R>
 *            The match type, i.e. some kind of matching container.
 *            
 * @author Manuel Ohrndorf
 */
public abstract class AbstractMatchGenerator<R> implements IMatchGenerator<R> {

	/**
	 * All nodes which should be matched.
	 */
	protected List<NodePattern> graphPattern;

	/**
	 * The nodes which correspond to the matching formula:
	 * <code>match = v_1 x v_2 x ... x v_n</code>
	 */
	protected List<NodePattern> variableNodes;
	
	/**
	 * All variable nodes and their corresponding matchings.
	 */
	protected Map<NodePattern, NodeMatching> matching = new LinkedHashMap<>();
	
	@Override
	public void initialize(List<NodePattern> graphPattern, List<NodePattern> variableNodes) {
		this.graphPattern = graphPattern;
		this.variableNodes = variableNodes;
	}
	
	@Override
	public void start() {
	}

	@Override
	public void finish() {
	}
	
	@Override
	public List<NodePattern> getGraphPattern() {
		return graphPattern;
	}
	
	@Override
	public List<NodePattern> getVariableNodes() {
		return variableNodes;
	}
	
	/**
	 * @return The (unmodifiable) matching for each variable node. The matching
	 *         will be updated each time {@link #findNextMatch()} is called.
	 */
	public Map<NodePattern, NodeMatching> getVariableMatching() {
		return Collections.unmodifiableMap(matching);
	}
	
	/**
	 * @return The match validation is used to filter/restrict the matching results.
	 */
	public abstract IMatchValidation getMatchValidation();
	
	/**
	 * @return The factory which creates the {@link AtomicPattern}s of the graph pattern.
	 */
	public abstract IAtomicPatternFactory getAtomicPatternFactory();
}
