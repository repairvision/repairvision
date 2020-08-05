package org.sidiff.revision.common.henshin.pairs;

import java.util.Collection;
import java.util.Iterator;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.henshin.model.Edge;

public class EdgePair {

	/**
	 * The LHS edge of the edge pair.
	 */
	private Edge lhsEdge;
	
	/**
	 * The RHS edge of the edge pair.
	 */
	private Edge rhsEdge;
	
	/**
	 * Constructs a new empty edge pair.
	 */
	public EdgePair() {
		super();
	}
	
	/**
	 * Constructs a new edge pair.
	 * 
	 * @param lhsEdge
	 *            the LHS edge.
	 * @param rhsEdge
	 *            the RHS edge.
	 */
	public EdgePair(Edge lhsEdge, Edge rhsEdge) {
		super();
		this.lhsEdge = lhsEdge;
		this.rhsEdge = rhsEdge;
	}
	
	/**
	 * @param edge
	 *            The edge to test.
	 * @return <code>true</code> if the edge is the LHS or RHS edge of the edge pair; 
	 *         <code>false</code> otherwise.
	 */
	public boolean contains(Edge edge) {
		return ((lhsEdge != null) && lhsEdge.equals(edge)) 
				|| ((rhsEdge != null) && rhsEdge.equals(edge));
	}

	/**
	 * @return the LHS edge.
	 */
	public Edge getLhsEdge() {
		return lhsEdge;
	}

	/**
	 * @param lhsEdge the new LHS edge.
	 */
	public void setLhsEdge(Edge lhsEdge) {
		this.lhsEdge = lhsEdge;
	}

	/**
	 * @return the RHS edge.
	 */
	public Edge getRhsEdge() {
		return rhsEdge;
	}

	/**
	 * @param rhsEdge the new RHS edge.
	 */
	public void setRhsEdge(Edge rhsEdge) {
		this.rhsEdge = rhsEdge;
	}
	
	/**
	 * @return the edge type.
	 */
	public EReference getType() {
		return this.lhsEdge.getType();
	}
	
	/**
	 * @param edgePairs
	 *            A collection of edge pairs.
	 * @param edges
	 *            Collection (preferably a set) containing edges to be removed from the given collection.
	 */
	public static void removeAll(Collection<EdgePair> edgePairs, Collection<Edge> edges) {
		
		for (Iterator<EdgePair> iterator = edgePairs.iterator(); iterator.hasNext();) {
			EdgePair edgePair = (EdgePair) iterator.next();
			
			 if ((edgePair.getLhsEdge() != null) && edges.contains(edgePair.getLhsEdge())) {
				 iterator.remove();
			 }
			 
			 else if ((edgePair.getRhsEdge() != null) && edges.contains(edgePair.getRhsEdge())) {
				 iterator.remove();
			 }
		}
	}
}
