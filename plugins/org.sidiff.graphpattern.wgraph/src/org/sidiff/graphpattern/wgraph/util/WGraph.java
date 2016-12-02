package org.sidiff.graphpattern.wgraph.util;

import org.sidiff.graphpattern.DataStore;
import org.sidiff.graphpattern.Evaluation;
import org.sidiff.graphpattern.NodePattern;
import org.sidiff.graphpattern.wgraph.store.NavigableMatchesDS;

public class WGraph {

	/**
	 * @param evaluation
	 *            An node evaluation adapter.
	 * @return The underlying navigable data store.
	 */
	// TODO: Only one interface!?
	public static NavigableMatchesDS getDataStore(Evaluation evaluation) {
		if (evaluation.getStore() instanceof NavigableMatchesDS) {
			return (NavigableMatchesDS) evaluation.getStore();
		} else {
			throw new RuntimeException("This algorithm needs a navigable data store!");
		}
	}

	/**
	 * @param node
	 *            An node pattern.
	 * @return The underlying navigable data store.
	 */
	// TODO: Only one interface!?
	public static NavigableMatchesDS getDataStore(NodePattern node) {
		DataStore ds = (node.getEvaluation() != null) ? node.getEvaluation().getStore() : null;
		
		if (ds instanceof NavigableMatchesDS) {
			return (NavigableMatchesDS) ds;
		} else {
			throw new RuntimeException("This algorithm needs a navigable data store!");
		}
	}

}
