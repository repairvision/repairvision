package org.sidiff.consistency.graphpattern.matcher.matching;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcoreFactory;
import org.sidiff.consistency.graphpattern.EObjectList;
import org.sidiff.consistency.graphpattern.Evaluation;
import org.sidiff.consistency.graphpattern.GraphpatternFactory;
import org.sidiff.consistency.graphpattern.NodePattern;
import org.sidiff.consistency.graphpattern.matcher.data.NavigableMatchesDS;
import org.sidiff.consistency.graphpattern.matcher.data.selection.MatchSelection;
import org.sidiff.consistency.graphpattern.matcher.matching.selection.IAtomicPatternFactory;
import org.sidiff.consistency.graphpattern.matcher.matching.selection.MatchSelector;

/**
 * Iterates through all possible (maximal) partial matches for a given graph.
 * 
 * @author Manuel Ohrndorf
 */
public class MatchGenerator {
	
	/**
	 * Represents all empty matches.
	 */
	public static final EObject EMPTY_MATCH = EcoreFactory.eINSTANCE.createEObject();

	/**
	 * Represents all empty linked lists.
	 */
	private static LinkedList<NodePattern> EMPTY_NODE_LIST = new LinkedList<NodePattern>();  
	
	/**
	 * All nodes which should be matched.
	 */
	protected List<NodePattern> graphPattern = new ArrayList<>();
	
	/**
	 * All variable nodes and their corresponding matchings.
	 */
	private Map<NodePattern, NodeMatching> matching = new LinkedHashMap<>();
	
	/**
	 * All nodes which are variables in the sense of the constraint solving problem of the graph.
	 */
	private LinkedList<NodePattern> variableNodes = new LinkedList<>();
	
	/**
	 * Calculates all matchable paths starting from an initial node. 
	 */
	private MatchSelector matchSelector;
	
	/**
	 * Extends the path based selection by the matching of atomic patterns.
	 */
	private IAtomicPatternFactory atomicPatternFactory;
	
	/**
	 * Validates or rejects the structurally constructed graph matches. 
	 */
	private IMatchValidation matchValidation;
	
	/**
	 * All model elements (per node) that were already assigned.
	 */
	private Map<NodePattern, Set<EObject>> assignments = new HashMap<>(); 
	
	/**
	 * All nodes which were not yet considered as initial nodes.
	 */
	private Set<NodePattern> remainingInitialNodes = new LinkedHashSet<>();
	
	/**
	 * Initializes a new {@link MatchGenerator}.
	 * 
	 * @param graph
	 *            A list a nodes which form a connected graph.
	 * @param variableNodes
	 *            All nodes which are variables in the sense of the 
	 *            constraint solving problem of the graph.
	 * @param matchValidation
	 *            Validates or rejects the structurally constructed 
	 *            graph matches.
	 */
	public MatchGenerator(Collection<NodePattern> graph, Collection<NodePattern> variableNodes, 
			IAtomicPatternFactory atomicPatternFactory, IMatchValidation matchValidation) {
		this.graphPattern.addAll(graph);
		this.variableNodes.addAll(variableNodes);
		this.atomicPatternFactory = atomicPatternFactory;
		this.matchValidation = matchValidation;
		
		// Initialize the data stores of all nodes:
		initializeDataStore();
		
		// Initialize variable node matching:
		initializeVariableNodes();
		initializeMatching();
	}
	
	private void initializeVariableNodes() {

		for (NodePattern variableNode : variableNodes) {
			NodeMatching match = new NodeMatching(variableNode);

			matching.put(variableNode, match);
			assignments.put(variableNode, new HashSet<EObject>());
			remainingInitialNodes.add(variableNode);
		}
	}
	
	private void initializeDataStore() {

		// Initialize data store of all nodes:
		for (NodePattern node : graphPattern) {
			NavigableMatchesDS dataStore = getNavigableDataStore(node.getEvaluation());
			dataStore.getMatchSelection().clearSelection();
		}
	}
	
	private void initializeMatching() {
		NodePattern firstNode = variableNodes.getFirst();
		NavigableMatchesDS firstNodeDS = getNavigableDataStore(firstNode.getEvaluation());

		setNextInitialNode(variableNodes.getFirst(), firstNodeDS.getMatchIterator());
	}
	
	private void setNextInitialNode(NodePattern initialNode, Iterator<EObject> matches) {
		
		if (variableNodes.getFirst() != initialNode) {
			variableNodes.remove(initialNode);
			variableNodes.addFirst(initialNode);
		}
		
		// Initialize matching of the next initial node:
		matching.get(initialNode).setMatchIterator(matches);
		remainingInitialNodes.remove(initialNode);
		assignments.remove(initialNode);
	}
	
	private void storeVariableAssignments() {
		for (NodePattern remainingInitialNode : remainingInitialNodes) {
			NodeMatching remainingInitialNodeMatch = matching.get(remainingInitialNode);
			
			if (remainingInitialNodeMatch.getMatch() != null) {
				assignments.get(remainingInitialNode).add(remainingInitialNodeMatch.getMatch());
			}
		}
	}
	
	/**
	 * @return <code>true</code> if a matching was found; <code>false</code>
	 *         otherwise. The matching can be read from {@link #getMatching()}.
	 */
	public boolean findNextMatch() {
		
		// Search for the next valid match:
		while (!findNextAssignemt()) {
			if (!nextAssignmentOrder()) {
				return false;
			}
		}
		
		return true;
	}
	
	private boolean findNextAssignemt() {
		
		// Search for the next valid match:
		while (true) {
			
			// Undo last matching (backtracking):
			LinkedList<NodePattern> nextNodes = getNextMatchableNodes();
			
			// Check if there are more matches possible?
			if (!nextNodes.isEmpty()) {
				// Get and remove initial node from the next matchable nodes:
				NodePattern initialNode = nextNodes.pollFirst();
				
				// Calculate next matching:
				if (initializeNextMatching(initialNode)) {
					restrictFreeNodes(nextNodes);
					
					// Check new matching
					if (matchValidation.isMatch(matching)) {
						storeVariableAssignments();
						return true;
					}
				}
			} else {
				// No more matches possible!
				break;
			}
		}
		
		return false;
	}
	
	private boolean nextAssignmentOrder() {
		Collection<EObject> nextInitialMatch = new ArrayList<>();
		
		for (NodePattern remainingInitialNode : remainingInitialNodes) {
			NavigableMatchesDS dataStore = getNavigableDataStore(remainingInitialNode.getEvaluation());
			Set<EObject> matches = assignments.get(remainingInitialNode);
			
			if (matches.size() != dataStore.getMatchSize()) {

				// Get all matches that were not yet assigned to a matching:
				dataStore.getMatchIterator().forEachRemaining(match -> {
					if (!matches.contains(match)) {
						nextInitialMatch.add(match);
					}
				});
				
				// New initial node:
				assert (!nextInitialMatch.isEmpty());
				setNextInitialNode(remainingInitialNode, nextInitialMatch.iterator());
				
				return true;
			}
		}
		
		return false;
	}
	
	private LinkedList<NodePattern> getNextMatchableNodes() {
		NodePattern nextNode = null;
		NodeMatching nextMatch = null;
		
		// Remove restriction of all nodes, in the >tail< of list, which have no more matches:
		LinkedList<NodePattern> nextNodes = new LinkedList<>();
		
		for (Iterator<NodePattern> iterator = variableNodes.descendingIterator(); iterator.hasNext();) {
			nextNode = iterator.next();
			nextMatch = matching.get(nextNode);
			nextNodes.addFirst(nextNode);
			
			// Undo restrictions of this node from the complete graph:
			for (NodePattern node : graphPattern) {
				NavigableMatchesDS nodeDS = getNavigableDataStore(node.getEvaluation());
				nodeDS.getMatchSelection().undoRestrictSelection(nextNode);
			}
			
			if (!nextMatch.hasNextMatch()) {
				// Reset the matching:
				nextMatch.resetMatching();
			} else {
				// Next initial node found!
				break;
			}
		}
		
		if (nextMatch.hasNextMatch()) {
			return nextNodes;
		} else {
			return EMPTY_NODE_LIST;
		}
	}

	private boolean initializeNextMatching(NodePattern initialNode) {
		NodeMatching initialMatch = matching.get(initialNode);
		
		// Check if there are more matches possible?
		if (initialMatch.hasNextMatch()) {
			
			// Set next match:
			initialMatch.setNextMatch();
		
			// Initial match restriction:
			if (initialNode == variableNodes.getFirst()) {
				matchSelector = new MatchSelector(
						atomicPatternFactory, graphPattern, initialNode, initialMatch.getMatch());
			} else {
				matchSelector.selectMatch(initialNode, initialMatch.getMatch());
			}
			
			// Check if match was valid (e.g. failed on atomic matching):
			NavigableMatchesDS initialNodeDS = getNavigableDataStore(initialNode.getEvaluation());
			
			if (initialNodeDS.getMatchSelection().isSelectedMatch(initialMatch.getMatch())) {
				return true;
			}
		}
		
		return false;
	}
	
	private void restrictFreeNodes(List<NodePattern> freeNodes) {
		
		// Initialize and restrict all free nodes:
		for (NodePattern freeNode : freeNodes) {
			NavigableMatchesDS freeNodeDS = getNavigableDataStore(freeNode.getEvaluation());
			NodeMatching freeMatching = matching.get(freeNode);
			
			//// Find next potential (partial) matching ////
			
			// Get (restricted) selection and set first match:
			freeMatching.setMatchIterator(freeNodeDS.getMatchSelection().getSelectedMatches());
			freeMatching.setNextMatch();
			
			// TODO: Potential match check.
//			do {
//				freeMatching.setNextMatch();
//			} while (!matchValidation.isPotentialMatch(freeMatching, matching) && freeMatching.hasNextMatch());
			
			//// Restrict the (full) matching to the first match in the selection list ////

			// Calculate restriction:
			EObject nextRestriction = freeMatching.getMatch();
			
			if (nextRestriction != null) {
				matchSelector.selectMatch(freeNode, nextRestriction);
			} else {
				freeMatching.resetMatching();
			}
		}
	}
	
	/**
	 * @return All nodes which should be matched.
	 */
	public List<NodePattern> getNodes() {
		return graphPattern;
	}
	
	/**
	 * @return The (unmodifiable) matching for each variable node. The matching
	 *         will be updated each time {@link #findNextMatch()} is called.
	 */
	public Map<NodePattern, NodeMatching> getVariableMatching() {
		return Collections.unmodifiableMap(matching);
	}
	
	/**
	 * @return A list matches for each node of the graph (index of {@link MatchGenerator#getNodes()}).
	 */
	public EObjectList getGraphPatternMatching() {
		EObjectList graphPatternMatching = GraphpatternFactory.eINSTANCE.createEObjectList();
		
		for (NodePattern node : graphPattern) {
			EObjectList nodeMatching = GraphpatternFactory.eINSTANCE.createEObjectList();
			MatchSelection matchSelection = getNavigableDataStore(node.getEvaluation()).getMatchSelection();
			
			matchSelection.getSelectedMatches().forEachRemaining(match -> {
				if (match != null) {
					nodeMatching.getContent().add(match);
				}
			});
			
			if (nodeMatching.getContent().size() == 1) {
				graphPatternMatching.getContent().add(nodeMatching.getContent().get(0));
			}
			
			else if (nodeMatching.getContent().isEmpty()) {
				graphPatternMatching.getContent().add(EMPTY_MATCH);
			}
			
			else {
				graphPatternMatching.getContent().add(nodeMatching);
			}
		}
		
		return graphPatternMatching;
	}
	
	private NavigableMatchesDS getNavigableDataStore(Evaluation evaluation) { // TODO: Adjust interface
		if (evaluation.getStore() instanceof NavigableMatchesDS) {
			return (NavigableMatchesDS) evaluation.getStore();
		} else {
			throw new RuntimeException("This algorithm needs a navigable data store!");
		}
	}
}
