package org.sidiff.revision.common.henshin.pairs;

import java.util.Collection;
import java.util.Iterator;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.henshin.model.Node;

/**
 * Contains a LHS and its corresponding RHS Henshin node.
 */
public class NodePair {
	
	/**
	 * The LHS node of the node pair.
	 */
	private Node lhsNode;
	
	/**
	 * The RHS node of the node pair.
	 */
	private Node rhsNode;

	/**
	 * Constructs a new empty node pair.
	 */
	public NodePair() {
	}
	
	/**
	 * Constructs a new node pair.
	 * 
	 * @param lhsNode
	 *            the LHS node.
	 * @param rhsNode
	 *            the RHS node.
	 */
	public NodePair(Node lhsNode, Node rhsNode) {
		super();
		this.lhsNode = lhsNode;
		this.rhsNode = rhsNode;
	}
	
	/**
	 * @param node
	 *            The node to test.
	 * @return <code>true</code> if the node is the LHS or RHS node of the node pair; 
	 *         <code>false</code> otherwise.
	 */
	public boolean contains(Node node) {
		return ((lhsNode != null) && lhsNode.equals(node)) 
				|| ((rhsNode != null) && rhsNode.equals(node));
	}
	
	/**
	 * @return the LHS node.
	 */
	public Node getLhsNode() {
		return lhsNode;
	}

	/**
	 * @param lhsNode the new LHS node.
	 */
	public void setLhsNode(Node lhsNode) {
		this.lhsNode = lhsNode;
	}
	
	/**
	 * @return the RHS node.
	 */
	public Node getRhsNode() {
		return rhsNode;
	}
	
	/**
	 * @param rhsNode the new RHS node.
	 */
	public void setRhsNode(Node rhsNode) {
		this.rhsNode = rhsNode;
	}

	/**
	 * @return the node type.
	 */
	public EClass getType() {
		return lhsNode.getType();
	}
	
	/**
	 * @param nodePairs
	 *            A collection of node pairs.
	 * @param nodes
	 *            Collection (preferably a set) containing nodes to be removed from the given collection.
	 */
	public static void removeAll(Collection<NodePair> nodePairs, Collection<Node> nodes) {
		
		for (Iterator<NodePair> iterator = nodePairs.iterator(); iterator.hasNext();) {
			NodePair nodePair = (NodePair) iterator.next();
			
			 if ((nodePair.getLhsNode() != null) && nodes.contains(nodePair.getLhsNode())) {
				 iterator.remove();
			 }
			 
			 else if ((nodePair.getRhsNode() != null) && nodes.contains(nodePair.getRhsNode())) {
				 iterator.remove();
			 }
		}
	}
}
