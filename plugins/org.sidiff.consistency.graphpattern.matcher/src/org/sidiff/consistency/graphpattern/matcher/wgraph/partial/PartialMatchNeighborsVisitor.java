package org.sidiff.consistency.graphpattern.matcher.wgraph.partial;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.emf.ecore.EObject;
import org.sidiff.consistency.graphpattern.EdgePattern;
import org.sidiff.consistency.graphpattern.Evaluation;
import org.sidiff.consistency.graphpattern.NavigableDataStore;
import org.sidiff.consistency.graphpattern.NodePattern;
import org.sidiff.consistency.graphpattern.impl.VisitorImpl;
import org.sidiff.consistency.graphpattern.matcher.tools.MatchingHelper;

public class PartialMatchNeighborsVisitor extends VisitorImpl {

	private MatchingHelper matchingHelper;
	
	private ConstraintTester constraintTester;

	private EdgePattern originEdge;
	
	private List<EObject> matches;
	
	public PartialMatchNeighborsVisitor(MatchingHelper matchingHelper) {
		this.matchingHelper = matchingHelper;
	}
	
	public PartialMatchNeighborsVisitor(MatchingHelper matchingHelper, EdgePattern originEdge, List<EObject> matches) {
		this.matchingHelper = matchingHelper;
		this.originEdge = originEdge;
		this.matches = matches;
		
		this.constraintTester = new ConstraintTester(matchingHelper);
	}

	@Override
	public void visit(Evaluation evaluation) {
		
		// Process all (new) local matches related to the neighbor matches:
		Map<EdgePattern, List<EObject>> allNeighborMatches = startMatching(evaluation);
		
		// Visit all neighbors recursively:
		processNextNodes(allNeighborMatches);
	}
	
	private Map<EdgePattern, List<EObject>> startMatching(Evaluation evaluation) {
		List<EdgePattern> edges = new ArrayList<>(evaluation.getNode().getOutgoings());
		
		if (originEdge != null) {
			edges.remove(originEdge.getOpposite());
		}

		// Check if there is any edge structure that would expand the search space:
		Map<EdgePattern, List<EObject>> allNeighborMatches = new HashMap<>();
		
		if (!edges.isEmpty()) {
			
			// Initialize:
			NavigableDataStore ownStore = getNavigableDataStore(evaluation);
				
			for (EdgePattern edge : edges) {
				List<EObject> neighborMatches = allNeighborMatches.containsKey(edge) 
						? allNeighborMatches.get(edge) : new ArrayList<>();
				allNeighborMatches.put(edge, neighborMatches);
				
				// Process all (new) local matches:
				Iterator<EObject> localMatchIterator = matches != null 
						? matches.iterator() : evaluation.getStore().getMatchIterator();
				
				localMatchIterator.forEachRemaining(localMatch -> {
					NodePattern neighborNode = edge.getTarget();
					NavigableDataStore neighborStore = getNavigableDataStore(neighborNode.getEvaluation());

					matchingHelper.getTargets(localMatch, evaluation.getNode(), edge).forEachRemaining(targetObject -> {
						
						// Check node constraints!
						if (constraintTester.check(neighborNode, targetObject)) {
							
							// Propagate only new matches:
							if (!neighborStore.containsMatch(targetObject)) {
								neighborMatches.add(targetObject);
							}
							
							// Update own store:
							ownStore.addRemoteMatch(localMatch, targetObject, edge);

							// Update remote store:
							neighborStore.addRemoteMatch(targetObject, localMatch, edge);
						}
					}); // forEachRemaining: target objects
				}); // forEachRemaining: local match
			}
			
			return allNeighborMatches;
		} else {
			return Collections.emptyMap();
		}
	}
	
	private void processNextNodes(Map<EdgePattern, List<EObject>> allNeighborMatches) {
		
		// Visit all neighbors with the new matches:
		for (Entry<EdgePattern, List<EObject>> neighborMatch : allNeighborMatches.entrySet()) {
			
			if (!neighborMatch.getValue().isEmpty()) {
				PartialMatchNeighborsVisitor newMatcher = new PartialMatchNeighborsVisitor(
						matchingHelper, neighborMatch.getKey(), neighborMatch.getValue());
				
				NodePattern neighborNode = neighborMatch.getKey().getTarget();
				neighborNode.getEvaluation().accept(newMatcher);	
			}
		}
	}

	// TODO: DS
	private NavigableDataStore getNavigableDataStore(Evaluation evaluation) {
		if (evaluation.getStore() instanceof NavigableDataStore) {
			return (NavigableDataStore) evaluation.getStore();
		} else {
			throw new RuntimeException("This algorithm needs a navigable data store!");
		}
	}
}
