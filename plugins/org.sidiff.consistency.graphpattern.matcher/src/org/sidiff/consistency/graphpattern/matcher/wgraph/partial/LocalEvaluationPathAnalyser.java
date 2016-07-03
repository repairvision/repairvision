package org.sidiff.consistency.graphpattern.matcher.wgraph.partial;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.sidiff.consistency.graphpattern.EdgePattern;
import org.sidiff.consistency.graphpattern.GraphpatternFactory;
import org.sidiff.consistency.graphpattern.NodePattern;
import org.sidiff.consistency.graphpattern.matcher.tools.MatchingHelper;
import org.sidiff.consistency.graphpattern.matcher.tools.paths.DFSSourceTargetPathIterator.DFSPath;
import org.sidiff.difference.symmetric.SymmetricPackage;

/**
 * Calculates the minimum of paths that spread from a variable node and have to
 * be evaluated to build the working graph, i.e. each path ends at a node which
 * is (forward) reachable from all other variable nodes. The algorithm creates
 * additional cross-reference edges if necessary.
 * 
 * @author Manuel Ohrndorf
 */
public abstract class LocalEvaluationPathAnalyser {
	
	/**
	 * Variable-Node -> local evaluation
	 */
	protected LinkedHashMap<NodePattern, Set<EdgePattern>> localEvaluations = new LinkedHashMap<>();
	
	/**
	 * All edges which need cross-references: existing edge -> opposite placeholder edge.
	 * 
	 * (NOTE: We can not create new edges during path iteration!)
	 */
	protected Map<EdgePattern, EdgePattern> newCrossReferences = new HashMap<>();
	
	/**
	 * @param variableNodes
	 *            All variable nodes which will be evaluated pairwise.
	 * @see LocalEvaluationPathAnalyser#getTargetPairs(NodePattern)
	 */
	public LocalEvaluationPathAnalyser(List<NodePattern> variableNodes) {
		
		// Initialize result storage:
		for (NodePattern variableNode : variableNodes) {
			this.localEvaluations.put(variableNode, new HashSet<>());
		}
		
		// Calculate necessary paths pairwise:
		for (int i = 0; i < variableNodes.size(); i++) {
			NodePattern variableNodeA = variableNodes.get(i);
			
			for (int j = i + 1; j < variableNodes.size(); j++) {
				NodePattern variableNodeB = variableNodes.get(j);
				
				calculateEvaluationPaths(variableNodeA, variableNodeB);
			}
		}
		
		// Create all additional cross-references:
		createAllNewCrossReferences();
		
		// TODO: TestUtil...!?
//		System.out.println(this);
//		assert validateEdges();
	}
	
	@SuppressWarnings("unused")
	private boolean validateEdges() {
		NodePattern firstVNode = localEvaluations.keySet().iterator().hasNext() 
				? localEvaluations.keySet().iterator().next() : null;
		
		if (firstVNode != null) {
			Set<NodePattern> nodes = MatchingHelper.getClosure(firstVNode);
			
			for (NodePattern node : nodes) {
				for (EdgePattern outgoing : node.getOutgoings()) {
					boolean edgeFound = false;
					
					// TODO: Lifting customization...
					if ((outgoing.getType() == SymmetricPackage.eINSTANCE.getAddReference_Type()) 
							|| (outgoing.getType() == SymmetricPackage.eINSTANCE.getRemoveReference_Type())) {
						return true;
					}
					
					for (Set<EdgePattern> evaluation : localEvaluations.values()) {
						if (evaluation.contains(outgoing)) {
							edgeFound = true;
							break;
						}
					}
					
					EdgePattern opposite = outgoing.getOpposite();
					
					if (!edgeFound && opposite != null) {
						for (Set<EdgePattern> evaluation : localEvaluations.values()) {
							if (evaluation.contains(opposite)) {
								edgeFound = true;
								break;
							}
						}
					}
					
					if (!edgeFound) {
						System.err.println("LocalEvaluationPathAnalyser.validateEdges()");
						System.err.println("Missing Edge: " + outgoing);
						System.err.println("Missing Edge: " + opposite);
						return false;
					}
				}
			}
		}
		
		return true;
	}

	private void calculateEvaluationPaths(NodePattern variableNodeA, NodePattern variableNodeB) {
		
		// Consider every path from node A to node B:
		getAllPaths(variableNodeA, variableNodeB).forEachRemaining(path -> {
			NodePattern lastPositionFromA = path.getNewPathStart();
			NodePattern lastPositionFromB = path.getPathTarget();
			
			// Find an outgoing and intersecting path from both nodes:
			if (path.getNewPathSize() > 1) {

				// Make a move from node A and node B (if possible):
				int edgeIndexFromA = 0;
				int edgeIndexFromB = path.getNewPathSize() - 1;
				
				EdgePattern nextEdgeFromA;
				EdgePattern nextEdgeFromB;

				NodePattern nextPositionFromA;
				NodePattern nextPositionFromB;

				// Until paths meet each other: while (nextPositionFromA != nextPositionFromB)
				do {
					nextEdgeFromA = path.getNewPathSegment(edgeIndexFromA);
					nextEdgeFromB = path.getNewPathSegment(edgeIndexFromB);

					nextPositionFromA = (nextEdgeFromA.getSource() == lastPositionFromA) 
							? nextEdgeFromA.getTarget()
							: lastPositionFromA;
					
					nextPositionFromB = (nextEdgeFromB.getSource() == lastPositionFromB) 
							? nextEdgeFromB.getTarget()
							: lastPositionFromB;

					// Check opposite edges if necessary:
					if (nextPositionFromA == lastPositionFromA) {
						EdgePattern opposite_nextEdgeFromA = getOpposite(nextEdgeFromA);
						
						if (opposite_nextEdgeFromA != null) {
							nextPositionFromA = opposite_nextEdgeFromA.getTarget();
							nextEdgeFromA = opposite_nextEdgeFromA;
						}
					}
					if (nextPositionFromB == lastPositionFromB) {
						EdgePattern opposite_nextEdgeFromB = getOpposite(nextEdgeFromB);
						
						if (opposite_nextEdgeFromB != null) {
							nextPositionFromB = opposite_nextEdgeFromB.getTarget();
							nextEdgeFromB = opposite_nextEdgeFromB;
						}
					}

					// Has taken a (1 or 2) step(s) or stuck?
					if ((nextPositionFromA == lastPositionFromA) && (nextPositionFromB == lastPositionFromB)) {
						
						// Reverse the edge which leads to the biggest move from node A or B:
						int moveA = getMaxMove(path, nextEdgeFromA.getSource(), edgeIndexFromA + 1, 1);
						int moveB = getMaxMove(path, nextEdgeFromB.getSource(), edgeIndexFromB - 1, -1);
						
						// Create the reversed edge and make the move:
						if (moveA > moveB) {
							// Reverse edge of node A:
							nextEdgeFromA = createCrossReferenceEdge(nextEdgeFromA);
							nextPositionFromA = nextEdgeFromA.getTarget();
						} else {
							// Reverse edge of node B:
							nextEdgeFromB = createCrossReferenceEdge(nextEdgeFromA);
							nextPositionFromB = nextEdgeFromB.getTarget();
						}
					} else {
						
						// Check if paths have crossed:
						if ((nextPositionFromA == lastPositionFromB) && (nextPositionFromB == lastPositionFromA)) {
							// Prefer normal edges over cross-references:
							if (!nextEdgeFromA.isCrossReference()) {
								// Revert path from B:
								nextPositionFromB = lastPositionFromB;
							} else {
								// Revert path from A
								nextPositionFromA = lastPositionFromA;
							}
						}
					}
					
					// Store results:
					if (nextPositionFromA != lastPositionFromA) {
						localEvaluations.get(variableNodeA).add(nextEdgeFromA);
					}
					if (nextPositionFromB != lastPositionFromB) {
						localEvaluations.get(variableNodeB).add(nextEdgeFromB);
					}

					// Prepare next move:
					if (nextPositionFromA != lastPositionFromA) {
						lastPositionFromA = nextPositionFromA;
						++edgeIndexFromA;
					}
					if (nextPositionFromB != lastPositionFromB) {
						lastPositionFromB = nextPositionFromB;
						--edgeIndexFromB;
					}

					
					// Check paths have meet:
				} while (nextPositionFromA != nextPositionFromB);

			} else {
				if (!path.isNewPathEmpty()) {
					
					// Only one edge:
					EdgePattern singleEdge = path.getNewPathSegment(0);
					
					if (singleEdge.getSource() == lastPositionFromA) {
						localEvaluations.get(variableNodeA).add(singleEdge);
					} else {
						assert (singleEdge.getSource() == lastPositionFromB);
						localEvaluations.get(variableNodeB).add(singleEdge);
					}
				}
			}
		});
	}
	
	private EdgePattern getOpposite(EdgePattern edge) {
		
		if (edge.getOpposite() != null) {
			return edge.getOpposite();
		}
		
		if (newCrossReferences.containsKey(edge)) {
			return newCrossReferences.get(edge);
		}
		
		return null;
	}
	
	private EdgePattern createCrossReferenceEdge(EdgePattern edge) {
		PlaceholderEdgePattern opposite = new PlaceholderEdgePattern(
				edge.getType(), edge.getTarget(), edge.getSource(),edge, true);
		newCrossReferences.put(edge, opposite);
		return opposite;
	}
	
	private void createAllNewCrossReferences() {
		if (newCrossReferences.isEmpty()) {
			return;
		}
		
		for (EdgePattern edge : newCrossReferences.keySet()) {
			createCrossReferenceEdgeInModel(edge);
		}
		
		for (Set<EdgePattern> localEvaluation : localEvaluations.values()) {
			for (EdgePattern placeholderEdge : newCrossReferences.values()) {
				if (localEvaluation.contains(placeholderEdge)) {
					
					// Remove placeholder from evaluation graph:
					localEvaluation.remove(placeholderEdge);
					
					// Placeholder -> Opposite -> Real Opposite -> Opposite -> Real Cross-Reference:
					EdgePattern crossReferenceInModel = placeholderEdge.getOpposite().getOpposite();
					localEvaluation.add(crossReferenceInModel);
				}
			}
		}
	}
	
	private void createCrossReferenceEdgeInModel(EdgePattern edge) {
		
		TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(edge);
		
		if (editingDomain == null) {
			internal_createCrossReferenceEdgeInModel(edge);
		} else {
			editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {

				@Override
				protected void doExecute() {
					internal_createCrossReferenceEdgeInModel(edge);
				}

				@Override
				public boolean canUndo() {
					return false;
				}

			});		
		}

	}
	
	private void internal_createCrossReferenceEdgeInModel(EdgePattern edge) {
		EdgePattern crossReference = GraphpatternFactory.eINSTANCE.createEdgePattern();
		
		edge.getTarget().getOutgoings().add(crossReference);
		edge.setOpposite(crossReference);
		
		crossReference.setSource(edge.getTarget());
		crossReference.setTarget(edge.getSource());
		crossReference.setCrossReference(true);
		crossReference.setType(edge.getType());
		crossReference.setName("^" + edge.getName());
		crossReference.setOpposite(edge);
	}
	
	protected int getMaxMove(DFSPath path, NodePattern position, int edgeIndex, int direction) {
		EdgePattern nextEdge;
		NodePattern nextNode;
		NodePattern lastNode = position;
		
		int maxMove = 0;
		
		while((edgeIndex >= 0) && (edgeIndex < path.getNewPathSize())) {
			nextEdge = path.getNewPathSegment(edgeIndex);
			nextNode = nextEdge.getTarget();
			
			if (nextNode != lastNode) {
				lastNode = nextNode;
				edgeIndex = edgeIndex + direction;
				++maxMove;
			} else {
				break;
			}
		}

		return maxMove;
	}

	/**
	 * @param nodeA
	 *            The start node.
	 * @param nodeB
	 *            The end node.
	 * @return An iteration through all paths from node A to node B.
	 */
	public abstract Iterator<DFSPath> getAllPaths(NodePattern nodeA, NodePattern nodeB);

	/**
	 * @return All paths between variable node which have to be analyzed to
	 *         build the working graph.
	 */
	public Map<NodePattern, Set<EdgePattern>> getLocalEvaluations() {
		return localEvaluations;
	}
	
	@Override
	public String toString() {
		StringBuffer print = new StringBuffer();
		
		print.append("Local Evaluation Graphs:\n");
		
		for (Entry<NodePattern, Set<EdgePattern>> localEvaluation : localEvaluations.entrySet()) {
			print.append("  Variable Node (size: " 
					+ localEvaluation.getValue().size() + "): " 
					+ localEvaluation.getKey() + "\n");
			
			for (EdgePattern edge : localEvaluation.getValue()) {
				print.append("    " + edge + "\n");
			}
		}
		
		return print.toString();
	}
}
