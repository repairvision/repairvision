package org.sidiff.graphpattern.common.algorithms;

import java.util.Iterator;

/**
 * Manages the lifecycle of an algorithm/calculation: start (initialization),
 * result iteration, finish (clean up)
 *
 * @param <R>
 *            The result type.
 * 
 * @author Manuel Ohrndorf
 */
public interface IIncrementalAlgorithm<R> extends IAlgorithm {

	/**
	 * @return A result iterator.
	 */
	public Iterator<R> getResults();
}
