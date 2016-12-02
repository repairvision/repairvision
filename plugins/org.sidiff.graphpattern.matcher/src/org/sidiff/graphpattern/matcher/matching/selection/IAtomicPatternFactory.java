package org.sidiff.graphpattern.matcher.matching.selection;

import org.sidiff.consistency.graphpattern.NodePattern;

/**
 * The factory which creates the {@link AtomicPattern}s of the graph pattern.
 * 
 * @author Manuel Ohrndorf
 */
public interface IAtomicPatternFactory {

	/**
	 * Extends the path based selection by the matching of atomic patterns.
	 * 
	 * @param path
	 *            The actual path.
	 * @param node
	 *            The next node that should be matched.
	 * @return The {@link AtomicPattern}.
	 */
	public AtomicPattern getAtomicPattern(PathSelector path, NodePattern node);
}
