package org.sidiff.revision.editrules.complement.matching.finder.henshin;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.henshin.model.Edge;
import org.eclipse.emf.henshin.model.Node;

/**
 * Constraints the sorting of nodes in a graph pattern.
 * 
 * @author Manuel Ohrndorf
 */
// TODO: Consider domain as secondary constraint!
// TODO: Consider containment/container references!
// TODO: Consider opposites which are missing in the graph pattern!
// TODO: Missing-Constraint!?:  j -> z <- i
// TODO: Option/Test to prefer forward connections over backward connections!
//			j -> i
//			j -> z -> i
//			j <- i
//			j -> z <- i
// TODO: Option/Test to prefer edges with lower multiplicities.
public class SortingConstraint {

	/**
	 * Checks if the node has incident edges.
	 * 
	 * @param i
	 *            The node which will be checked.
	 * @param nodes
	 *            A list of nodes.
	 * @return <code>true</code> if the node has incident edges;
	 *         <code>false</code> otherwise.
	 */
	public static boolean hasIncidentEdges(int i, List<Node> nodes) {
		return (nodes.get(i).getOutgoing().size() != 0) || (nodes.get(i).getIncoming().size() != 0);
	}
	
	/**
	 * Checks following constraints (j < i):
	 * <ul>
	 * <li>Forward connection: [j] -> [i]</li>
	 * <li>OR - Forward connection: [j] -> [z] -> [i]</li>
	 * <li>OR - Backward connection: [j] <- [i]</li>
	 * <li>OR - No incident edges
	 * </ul>
	 * 
	 * @param i
	 *            The node which will be checked.
	 * @param nodes
	 *            The list of (pre)sorted nodes.
	 * @return <code>true</code> if the constraint is satisfied;
	 *         <code>false</code> otherwise
	 */
	public static boolean checkSortingConstraint(int i, List<Node> nodes) {
		return !hasIncidentEdges(i, nodes) || checkForwardConnection(i, nodes) || checkBackwardConnection(i, nodes);
	}

	/**
	 * Checks Forward connection constraint (j < i):
	 * <ul>
	 * <li>[j] -> [i]</li>
	 * <li>OR - [j] -> [z] -> [i]</li>
	 * </ul>
	 * 
	 * @param i
	 *            The node which will be checked.
	 * @param nodes
	 *            The list of (pre)sorted nodes.
	 * @return <code>true</code> if the constraint is satisfied;
	 *         <code>false</code> otherwise
	 */
	public static boolean checkForwardConnection(int i, List<Node> nodes) {
		Node nodeI = nodes.get(i);

		for (int j = i - 1; j >= 0; --j) {
			Node nodeJ = nodes.get(j);

			for (Edge outgoingJ : nodeJ.getOutgoing()) {
				Node nodeZ = outgoingJ.getTarget();

				// Ignore cycles:
				if (nodeZ != nodeJ) {
					// Node_j and Node_i are adjacent: [j] -> [z/i]
					if (nodeZ == nodeI) {
						return true;
					} else {
						for (Edge outgoingZ : nodeZ.getOutgoing()) {
							if (outgoingZ.getTarget() == nodeI) {
								return true;
							}
						}
					}
				}
			}
		}

		return false;
	}

	/**
	 * Checks Backward connection constraint (j < i): [j] <- [i]
	 * 
	 * @param i
	 *            The node which will be checked.
	 * @param nodes
	 *            The list of (pre)sorted nodes.
	 * @return <code>true</code> if the constraint is satisfied;
	 *         <code>false</code> otherwise
	 */
	public static boolean checkBackwardConnection(int i, List<Node> nodes) {
		Node nodeI = nodes.get(i);

		for (int j = i - 1; j >= 0; --j) {
			Node nodeJ = nodes.get(j);

			for (Edge incomingJ : nodeJ.getIncoming()) {
				if (incomingJ.getSource() == nodeI) {
					return true;
				}
			}
		}

		return false;
	}

	/**
	 * Return the next node which satisfies the sorting constraint.
	 * 
	 * @param i
	 *            The index of the considered node.
	 * @param offset
	 *            Search from i + offset.
	 * @param nodes
	 *            The list of nodes to search.
	 * @return The index if the next valid node starting from the given index.
	 */
	public static int getNextValidNode(int i, int offset, List<Node> nodes) {
		Node nodeI = nodes.get(i);
		
		for (int j = i + 1 + offset; j < nodes.size(); ++j) {
			Node nodeJ = nodes.get(j);
			
			List<Node> test = new ArrayList<Node>(2);
			test.add(nodeJ);
			test.add(nodeI);
			
			if (checkSortingConstraint(1, test)) {
				return j;
			}
		}

		return -1;
	}

	/**
	 * Sorts the nodes according to the sorting constraints (j < i):
	 * <ul>
	 * <li>Forward connection: [j] -> [i]</li>
	 * <li>OR - Forward connection: [j] -> [z] -> [i]</li>
	 * <li>OR - Backward connection: [j] <- [i]</li>
	 * </ul>
	 * 
	 * @param startIndex
	 *            The first node which will be processed. All "start nodes" should be placed before this index.
	 * @param nodes
	 *            The list of nodes to sort.
	 */
	public static void structuredSorting(int startIndex, EList<Node> nodes) {
//		printNodes(nodes);

		for (int i = startIndex; i < nodes.size(); ++i) {
//			printNodes(nodes);
			i += optimizeSorting(i, 0, nodes);
//			printNodes(nodes);
		}

//		printNodes(nodes);
	}
	
	@SuppressWarnings("unused")
	private static void printNodes(List<Node> nodes) {
		System.out.println("--------------------------------------------------------------------------------");
		for (int i = 0; i < nodes.size(); ++i) {
			Node node = nodes.get(i);
			System.out.println("[" + i + "] " + node + " [" + Integer.toHexString(node.hashCode()) + "]");
		}
		System.out.println("--------------------------------------------------------------------------------");
	}
	
	/**
	 * Repairs a node sorting according to the sorting constraints (j < i):
	 * <ul>
	 * <li>Forward connection: [j] -> [i]</li>
	 * <li>OR - Forward connection: [j] -> [z] -> [i]</li>
	 * <li>OR - Backward connection: [j] <- [i]</li>
	 * </ul>
	 * The algorithm ({@link #structuredSorting(int, List)}) iterates through
	 * all nodes. If a node (i) doesn't fulfills the sorting constraint the
	 * algorithm ({@link #optimizeSorting(int, Integer, List)}) searches for the
	 * next node (j) in the list which would fix the actual node (i). The node
	 * (j) is now relocated directly before node (i). Subsequently the algorithm
	 * ({@link #optimizeSorting(int, Integer, List)}) checks the sorting
	 * constraint for node (j). If the validation of node (j) fails then we
	 * search the next valid node (k) in the list - starting after node (i)
	 * (offset). This restriction ensures the termination of the algorithm. If
	 * node (k) doesn't fulfill the sorting constraint, then node(k) has to be
	 * treated recursively in the same way as node (j). We search for a valid
	 * node - starting after node (i) ... and so on until the recursion
	 * terminates. Then we process the node (i+1) (
	 * {@link #structuredSorting(int, List)}).
	 * 
	 * @param startIndex
	 *            The first considered node (s).
	 * @param offset
	 *            The offset of nodes from node (s) which will be ignored during
	 *            the search of the next valid node.
	 * @param nodes
	 *            The list of nodes to repair.
	 * @return The count of nodes which were relocated before the given index (i) (offset).
	 */
	private static int optimizeSorting(int i, int offset, EList<Node> nodes) {

		if (!checkSortingConstraint(i, nodes)) {
			int j = getNextValidNode(i, offset, nodes);

			if (j > 0) {
				nodes.move(i, j);
				offset = optimizeSorting(i, offset + 1, nodes);
			}
		}
		
		return offset;
	}
}
