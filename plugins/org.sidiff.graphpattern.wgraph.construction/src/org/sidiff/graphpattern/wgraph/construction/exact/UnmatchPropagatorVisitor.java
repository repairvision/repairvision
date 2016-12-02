package org.sidiff.graphpattern.wgraph.construction.exact;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.sidiff.consistency.graphpattern.EdgePattern;
import org.sidiff.consistency.graphpattern.Evaluation;
import org.sidiff.consistency.graphpattern.NavigableDataStore;
import org.sidiff.consistency.graphpattern.NodePattern;
import org.sidiff.consistency.graphpattern.impl.VisitorImpl;
import org.sidiff.graphpattern.wgraph.construction.tools.matching.MatchingHelper;

/**
 * @author Manuel Ohrndorf
 */
public class UnmatchPropagatorVisitor extends VisitorImpl {

	private Collection<? extends EObject> unmatchedLocals;

	public UnmatchPropagatorVisitor(Collection<? extends EObject> unmatchedLocals) {
		this.unmatchedLocals = unmatchedLocals;
	}
	
	@Override
	public void visit(Evaluation evaluation) {

		// This node has already matches and the unmatching leads to an empty match 
		// => terminate! => clear all (connected) matches:
		boolean terminated = evaluateTerminationCondition(evaluation);
		
		// Remove wrong matches from the search space:
		if (!terminated) {
			startUnmatching(evaluation);
		}
	}
	
	private void startUnmatching(Evaluation evaluation) {
		
		// Initialize:
		NodePattern node = evaluation.getNode();
		NavigableDataStore ownStore = getNavigableDataStore(evaluation);
		List<EdgePattern> incidents = MatchingHelper.getIncidents(node);
		
		// Remove wrong matches from the search space:
		for (EObject unmatchedLocal : unmatchedLocals) {
			
			// Check for already removed (remove-cycle) local matches:
			if (ownStore.containsMatch(unmatchedLocal)) {
				
				/* Unmachting-Algorithm:																			  *
				 * 																									  *
				 * (2)   Remove the (local) unmatched object U from this node										  *
				 * (1.1) and all remote references to U from all neighbor (local) matches P on edges P.E_i.			  *
				 * (1.2) In the case that P has now no more matches for edge P.E_i,									  *
				 * (3)   remove P from the neighbors (local) matches in the same way as U.							  *
				 *       This will potentially lead to an unmatching propagation to the neighbor nodes: U -> P -> ... */

				// (1) Remove the local unmatched object from all neighbor remote matches:
				List<Collection<? extends EObject>> allLocalNeigborUnmatches = new ArrayList<>(node.getOutgoings().size());

				for (EdgePattern edge : incidents) {
					NodePattern neighborNode = MatchingHelper.getAdjacent(node, edge);
					NavigableDataStore neighborDataStore = getNavigableDataStore(neighborNode.getEvaluation());

					List<EObject> localNeighborUnmatches = new ArrayList<EObject>(
							ownStore.getRemoteMatchSize(unmatchedLocal, edge));
					allLocalNeigborUnmatches.add(localNeighborUnmatches);

					// Iterate over all remote matches of the unmatched local object:
					// (local match -> remote match => remote match == neighbor match)
					ownStore.getRemoteMatchIterator(unmatchedLocal, edge).forEachRemaining(neighborMatch -> {

						// (1.1) Remove the local unmatched object from the neighbors remote matches: 
						boolean wasContained = neighborDataStore.removeRemoteMatch(neighborMatch, unmatchedLocal, edge);
						assert wasContained : "Missing remote match!";
						
						// (1.2) If the remote match of the neighbors local matched object (for this edge) is now empty, 
						// then mark this neighbor (local) match for unmatching and unmatching propagation:
						if (neighborDataStore.isEmptyRemoteMatch(neighborMatch, edge)) {
							localNeighborUnmatches.add(neighborMatch);
						}
					});
				}

				// (2) Remove from local matches:
				evaluation.getStore().removeMatch(unmatchedLocal);

				// (3) Send new unmatch visitor to neighbors:
				//     -> Unmatching and propagation of the partially empty (local neighbor) match. 
				for (int i = 0; i < allLocalNeigborUnmatches.size(); i++) {
					if (!allLocalNeigborUnmatches.get(i).isEmpty()) {
						UnmatchPropagatorVisitor unmatchPropagator = new UnmatchPropagatorVisitor(
								allLocalNeigborUnmatches.get(i));
						NodePattern neighborNode = node.getOutgoings().get(i).getTarget();
						neighborNode.getEvaluation().accept(unmatchPropagator);
					}	
				}
			}
		}
	}
	
	private boolean evaluateTerminationCondition(Evaluation evaluation) {
		
		/* Explanation: 																*
		 * 																				*
		 * The transitive matching of neighbors from an known origin implies that 		*
		 * if a node N was matched once the amount of matches can only decrease,		*
		 * since there is no other possible path V from node N to the origin node;		*
		 * where path V	is the path through which node N was previously matched.		*/
		
		// Initialize:
		NodePattern node = evaluation.getNode();
		NavigableDataStore ownStore = getNavigableDataStore(evaluation);
		
		// Evaluate termination condition:
		if (!unmatchedLocals.isEmpty() && !ownStore.isEmptyMatch()) {
			// This node has already matches and the unmatching leads to an empty match => terminate!
			if (unmatchedLocals.size() == ownStore.getMatchSize()) {
				
				// Check for already removed (remove-cycle) local matches:
				for (EObject unmatchedLocal : unmatchedLocals) {
					if (!ownStore.containsMatch(unmatchedLocal)) {
						return false;
					}
				}
				
				// Remove all matches from all nodes -> leads to matching termination:
				Collection<NodePattern> unmatchedNodes = MatchingHelper.getClosure(node);
				
				for (NodePattern unmatchedNode : unmatchedNodes) {
					unmatchedNode.getEvaluation().getStore().clearMatches();
				}
				
				return true;
			}
		}
		
		return false;
	}
	
	private NavigableDataStore getNavigableDataStore(Evaluation evaluation) {
		if (evaluation.getStore() instanceof NavigableDataStore) {
			return (NavigableDataStore) evaluation.getStore();
		} else {
			throw new RuntimeException("This algorithm needs a navigable data store!");
		}
	}
}
