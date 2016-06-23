package org.sidiff.consistency.graphpattern.matcher.wgraph.partial;

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
import org.sidiff.consistency.graphpattern.matcher.tools.paths.DFSSourceTargetPathIterator.DFSPath;

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
	 * Variable-Node -> local evaluation (opposites as placeholder for the new cross-references)
	 */
	protected LinkedHashMap<NodePattern, Set<EdgePattern>> localEvaluationsNewCR = new LinkedHashMap<>();
	
	/**
	 * All edges which need cross-references.
	 */
	protected Set<EdgePattern> newCrossReferences = new HashSet<>();
	
	/**
	 * @param variableNodes
	 *            All variable nodes which will be evaluated pairwise.
	 * @see LocalEvaluationPathAnalyser#getTargetPairs(NodePattern)
	 */
	public LocalEvaluationPathAnalyser(List<NodePattern> variableNodes) {
		
		// Initialize result storage:
		for (NodePattern variableNode : variableNodes) {
			this.localEvaluations.put(variableNode, new HashSet<>());
			this.localEvaluationsNewCR.put(variableNode, new HashSet<>());
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
		
//		System.out.println(this);
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
				NodePattern nextEdgeFromA_source;
				NodePattern nextEdgeFromA_target;
				
				EdgePattern nextEdgeFromB;
				NodePattern nextEdgeFromB_source;
				NodePattern nextEdgeFromB_target;

				NodePattern nextPositionFromA;
				NodePattern nextPositionFromB;

				// Until paths meet each other: while (nextPositionFromA != nextPositionFromB)
				do {
					nextEdgeFromA = path.getNewPathSegment(edgeIndexFromA);
					nextEdgeFromA_source = nextEdgeFromA.getSource();
					nextEdgeFromA_target = nextEdgeFromA.getTarget();
					
					nextEdgeFromB = path.getNewPathSegment(edgeIndexFromB);
					nextEdgeFromB_source = nextEdgeFromB.getSource();
					nextEdgeFromB_target = nextEdgeFromB.getTarget();

					nextPositionFromA = (nextEdgeFromA_source == lastPositionFromA) 
							? nextEdgeFromA_target
							: lastPositionFromA;
					
					nextPositionFromB = (nextEdgeFromB_source == lastPositionFromB) 
							? nextEdgeFromB_target
							: lastPositionFromB;

					// Check opposite edges if necessary:
					if (nextPositionFromA == lastPositionFromA) {
						NodePattern opposite_target = getOpposite(nextEdgeFromA);
						
						if (opposite_target != null) {
							nextPositionFromA = opposite_target;
						}
					}
					if (nextPositionFromB == lastPositionFromB) {
						NodePattern opposite_target = getOpposite(nextEdgeFromB);
						
						if (opposite_target != null) {
							nextPositionFromB = opposite_target;
						}
					}

					// Has taken a (1 or 2) step(s) or stuck?
					if ((nextPositionFromA == lastPositionFromA) && (nextPositionFromB == lastPositionFromB)) {
						
						// Reverse the edge which leads to the biggest move from node A or B:
						int moveA = getMaxMove(path, nextEdgeFromA_source, edgeIndexFromA + 1, 1);
						int moveB = getMaxMove(path, nextEdgeFromB_source, edgeIndexFromB - 1, -1);
						
						// Create the reversed edge and make the move:
						if (moveA > moveB) {
							// Reverse edge of node A:
							nextPositionFromA = createCrossReferenceEdge(nextEdgeFromA);
							
							// Store result (placeholder):
							localEvaluationsNewCR.get(variableNodeA).add(nextEdgeFromA);
						} else {
							// Reverse edge of node B:
							nextPositionFromB = createCrossReferenceEdge(nextEdgeFromA);
							
							// Store result (placeholder):
							localEvaluationsNewCR.get(variableNodeB).add(nextEdgeFromA);
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
						
						// Store results:
						if (nextPositionFromA != lastPositionFromA) {
							localEvaluations.get(variableNodeA).add(nextEdgeFromA);
						}
						if (nextPositionFromB != lastPositionFromB) {
							localEvaluations.get(variableNodeB).add(nextEdgeFromB);
						}
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
	
	private NodePattern getOpposite(EdgePattern edge) {
		
		if (edge.getOpposite() != null) {
			return edge.getOpposite().getTarget();
		}
		
		if (newCrossReferences.contains(edge)) {
			return edge.getSource();
		}
		
		return null;
	}
	
	private NodePattern createCrossReferenceEdge(EdgePattern edge) {
		newCrossReferences.add(edge);
		return edge.getSource();
	}
	
	private void createAllNewCrossReferences() {
		
		for (EdgePattern edge : newCrossReferences) {
			createCrossReferenceEdgeInModel(edge);
		}
		
		for (Entry<NodePattern, Set<EdgePattern>> evaluation : localEvaluationsNewCR.entrySet()) {
			for (EdgePattern edgePattern : evaluation.getValue()) {
				// Add new created cross-reference to local evaluation:
				assert ((edgePattern.getOpposite() != null) && (edgePattern.getOpposite().isCrossReference()));
				localEvaluations.get(evaluation.getKey()).add(edgePattern.getOpposite());
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
