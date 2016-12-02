package org.sidiff.graphpattern.wgraph.construction.exact;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.sidiff.consistency.graphpattern.DataStore;
import org.sidiff.consistency.graphpattern.EdgePattern;
import org.sidiff.consistency.graphpattern.Evaluation;
import org.sidiff.consistency.graphpattern.NavigableDataStore;
import org.sidiff.consistency.graphpattern.NodePattern;
import org.sidiff.consistency.graphpattern.impl.VisitorImpl;
import org.sidiff.graphpattern.wgraph.construction.IConstraintTester;
import org.sidiff.graphpattern.wgraph.construction.tools.matching.MatchingHelper;
import org.sidiff.graphpattern.wgraph.util.WGraph;

/**
 * @author Manuel Ohrndorf
 */
public class ExactMatchNeighborsVisitor extends VisitorImpl {

	/**
	 * Already traversed nodes (timely sorted).
	 */
	private LinkedHashSet<NodePattern> visitTrace = new LinkedHashSet<>();

	/**
	 * Already traversed edges (timely sorted).
	 */
	private LinkedHashSet<EdgePattern> traverseTrace = new LinkedHashSet<>();

	/**
	 * Calculated the targets of edges (including cross-references).
	 */
	private MatchingHelper matchingHelper;
	
	/**
	 * Check types and other constraints.
	 */
	private IConstraintTester constraintTester;

	/**
	 * Initializes a new visitor.
	 * 
	 * @param engine
	 *            The corresponding matching engine.
	 */
	public ExactMatchNeighborsVisitor(MatchingHelper matchingHelper, IConstraintTester constraintTester) {
		this.matchingHelper = matchingHelper;
		this.constraintTester = constraintTester;
	}

	@Override
	public void visit(Evaluation evaluation) {
		
		// Check if there are matches to process:
		if (!evaluation.getStore().isEmptyMatch()) {
			NodePattern actualNode = evaluation.getNode();
			
			// Process all local matches related to the neighbor matches:
			List<EdgePattern> edges = getNextEdges(actualNode);
			Collection<? extends EObject> unmatchedLocal = startMatching(evaluation, edges);

			// Remove wrong matches from the search space -> propagate unmatched:
			unmatchLocalNodes(evaluation, unmatchedLocal);
			unmatchNeighborNodes(actualNode, edges);

			// Visit all neighbors:
			processNextNodes(actualNode, edges);
		}
	}
	
	/**
	 * @param node
	 *            The actual node.
	 * @return All unprocessed outgoing edges (including cross-references)
	 */
	private List<EdgePattern> getNextEdges(NodePattern node) {
		List<EdgePattern> edges = new ArrayList<>(node.getOutgoings().size() + node.getIncomings().size());
		
		// Outgoings: Add all unprocessed outgoing edges (including cross-references):
		for (EdgePattern outgoingEdge : node.getOutgoings()) {
			// Filter already processed edges:
			if (!traverseTrace.contains(outgoingEdge)) {
				edges.add(outgoingEdge);
			}
		}

		// Incomings: Check if we have indices for incoming edges 
		// (which are not explicitly indexed cross-references):
		for (EdgePattern incomingEdge : node.getIncomings()) {
			// Filter edges which are statically marked as cross-references:
			if (!incomingEdge.isCrossReference()) {
				// Filter already processed edges:
				if (!traverseTrace.contains(incomingEdge)) {
					if (matchingHelper.isInverseIndexed(incomingEdge) && !edges.contains(incomingEdge)) {
						edges.add(incomingEdge);
					}
				}
			}
		}
		
		return edges;
	}
	
	private Collection<? extends EObject> startMatching(Evaluation evaluation, List<EdgePattern> edges) {
		
		// Check if there is any edge structure that would change the search space:
		if (!edges.isEmpty()) {
			
			// Initialize:
			NodePattern actualNode = evaluation.getNode();
			NavigableDataStore ownStore = WGraph.getDataStore(evaluation);

			// Matches that will be removed from the search space:
			List<EObject> unmatchedLocal = new ArrayList<>(evaluation.getStore().getMatchSize());

			// Actual matching state of the neighbor nodes:
			Set<NodePattern> unprocessedNodes = getUnprocessedNodes(actualNode, edges);
			
			// Process every local matches:
			for (Iterator<EObject> iterator = evaluation.getStore().getMatchIterator(); iterator.hasNext();) {
				EObject localMatch = (EObject) iterator.next();

				// Get matches of the neighbor nodes:
				List<List<EObject>> allRemoteMatches = getAllRemoteMatches(
						localMatch, unprocessedNodes, actualNode, edges);

				// Check if there are matches available for all edges:
				if (allRemoteMatches.size() == edges.size()) {

					for (int i = 0; i < edges.size(); i++) {
						EdgePattern edge = edges.get(i);
						NodePattern neighborNode = MatchingHelper.getAdjacent(evaluation.getNode(), edge);
						NavigableDataStore neighborStore = WGraph.getDataStore(neighborNode.getEvaluation());
						List<EObject> remoteMatches = allRemoteMatches.get(i);

						// Add the matches to the neighbor node:
						for (EObject remoteMatch : remoteMatches) {

							// Update own store:
							ownStore.addRemoteMatch(localMatch, remoteMatch, edge);

							// Update remote store:
							neighborStore.addRemoteMatch(remoteMatch, localMatch, edge);
						}
					}
				} else {
					// Matches that will be removed from the solution:
					unmatchedLocal.add(localMatch);
				}
			}
			
			return unmatchedLocal;
		} else {
			return Collections.emptyList();
		}
	}
	
	private Set<NodePattern> getUnprocessedNodes(NodePattern sourceNode, Collection<EdgePattern> edges) {
		Set<NodePattern> unprocessedNodes = new HashSet<>();
		
		for (EdgePattern edge : edges) {
			NodePattern neigboreNode = MatchingHelper.getAdjacent(sourceNode, edge);
			DataStore neighborStore = neigboreNode.getEvaluation().getStore();
			
			if (neighborStore.isEmptyMatch()) {
				unprocessedNodes.add(neigboreNode);
			}
		}
		
		return unprocessedNodes;
	}
	
	private List<List<EObject>> getAllRemoteMatches(
			EObject localMatch, Set<NodePattern> unprocessedNodes,
			NodePattern sourceNode, Collection<EdgePattern> edges) {
		
		// Get matches of the neighbor nodes:
		List<List<EObject>> allRemoteMatches = new ArrayList<>(edges.size());

		for (EdgePattern edge : edges) {
			NodePattern neigboreNode = MatchingHelper.getAdjacent(sourceNode, edge);
			DataStore neighborStore = neigboreNode.getEvaluation().getStore();

			/* Explanation: 																*
			 * 																				*
			 * The transitive matching of neighbors from an known origin implies that 		*
			 * if a node N was matched once the amount of matches can only decrease,		*
			 * since there is no other possible path V from node N to the origin node;		*
			 * where path V	is the path through which node N was previously matched.		*/
			List<EObject> remoteMatches;  
			
			// Compare edge targets with existing neighbor matches
			// and retain only the target objects that were already matched:
			if (!unprocessedNodes.contains(neigboreNode)) {
				remoteMatches = new ArrayList<>();        

				// Semantically equal to:
				// List<EObject> remoteMatches = matchingHelper.getTargets(edge, localMatch);
				// remoteMatches.retainAll(neighborNode.getEvaluation().getMatches());
				matchingHelper.getTargets(localMatch, sourceNode, edge).forEachRemaining(targetObject -> {
					if (neighborStore.containsMatch(targetObject)) {
						remoteMatches.add(targetObject);
					}
				});
			} else {
				// Neighbor node wasn't matched yet:
				remoteMatches = new ArrayList<>();  
				
				matchingHelper.getTargets(localMatch, sourceNode, edge).forEachRemaining(targetObject -> {
					if (constraintTester.check(neigboreNode, targetObject)) {
						remoteMatches.add(targetObject);
					}
				});
			}
			
			if (!remoteMatches.isEmpty()) {
				allRemoteMatches.add(remoteMatches);
			}  else {
				// Not all edges could be matched 
				// => this local match can be removed from the search space!
				break; 
				// => allRemoteMatches.size() != edges.size()
			}
		}
		
		return allRemoteMatches;
	}
	
	/**
	 * This will remove wrong matches form the given evaluation context (i.e.
	 * its corresponding node). The "unmatched" objects will be propagated to all
	 * neighbor nodes... and so on.
	 * 
	 * @param evaluation
	 *            The local evaluation context.
	 * @param unmatchedLocal
	 *            The locally unmatched objects.
	 */
	private void unmatchLocalNodes(Evaluation evaluation, Collection<? extends EObject> unmatchedLocal) {
		
		// Local unmatch: 
		if (!unmatchedLocal.isEmpty()) {
			UnmatchPropagatorVisitor unmatchPropagator = new UnmatchPropagatorVisitor(unmatchedLocal);
			evaluation.accept(unmatchPropagator);
		}
	}
	
	/**
	 * Updates the matching of the neighbor nodes. All matched objects on the
	 * neighbor nodes should now have matches for the actually processed edges.
	 * Otherwise we can remove those matches from the neighbor nodes. This is
	 * necessary because the opposites of the processed edge are not checked
	 * again. The "unmachted" neighbor objects will be propagated to their
	 * neighbor nodes... and so on.
	 * 
	 * @param sourceNode
	 *            The source node of the given incident edges.
	 * @param edges
	 *            The processed edges.
	 */
	private void unmatchNeighborNodes(NodePattern sourceNode, List<EdgePattern> edges) {
		
		// Remote unmatch:
		for (EdgePattern edge : edges) {
			NodePattern neighborNode = MatchingHelper.getAdjacent(sourceNode, edge);
			NavigableDataStore neighborStore = WGraph.getDataStore(neighborNode.getEvaluation());
			
			List<EObject> unmatchedRemote = new ArrayList<>(neighborStore.getMatchSize());
			
			// Check the processed edge on the remote node!
			// -> Remote nodes with no matches on the opposite edge can be removed from the search space:
			// -> Every edge and its opposite edge will only be processed once!
			neighborStore.getMatchIterator().forEachRemaining(neighborMatch -> {
				// Check incident edge:
				if (neighborStore.isEmptyRemoteMatch(neighborMatch, edge)) {
					unmatchedRemote.add(neighborMatch);
				}
			});
			
			if (!unmatchedRemote.isEmpty()) {
				UnmatchPropagatorVisitor unmatchPropagator = new UnmatchPropagatorVisitor(unmatchedRemote);
				neighborNode.getEvaluation().accept(unmatchPropagator);	
			}
		}
	}

	/**
	 * Visits all processed neighbor nodes.
	 * 
	 * @param sourceNode
	 *            The source node of the given incident edges.
	 * @param edges
	 *            The processed edges.
	 */
	private void processNextNodes(NodePattern sourceNode, List<EdgePattern> edges) {

		// Do not traverse the opposite of an edge that were already matched:
		for (EdgePattern edge : edges) {
			traverseTrace.add(edge);
			traverseTrace.add(edge.getOpposite());
		}

		// Visit all neighbors recursively:
		// TODO: Always proceed with the neighbor with the smallest match size!
		for (EdgePattern edge : edges) {
			NodePattern neighborNode = MatchingHelper.getAdjacent(sourceNode, edge);

			// Check if there are neighbor matches to process:
			// (After each evaluation step the neighbor nodes might have changed!)
			if (!neighborNode.getEvaluation().getStore().isEmptyMatch()) {
				// Only visit each neighbor once:
				if (!visitTrace.contains(neighborNode)) {
					visitTrace.add(neighborNode);
					neighborNode.getEvaluation().accept(this);
				}
			}
		}
	}
	
	/**
	 * @return Already visited nodes. 
	 */
	public LinkedHashSet<NodePattern> getVisitTrace() {
		return visitTrace;
	}
	
	/**
	 * @return Already visited edges. 
	 */
	public LinkedHashSet<EdgePattern> getTraverseTrace() {
		return traverseTrace;
	}
}
