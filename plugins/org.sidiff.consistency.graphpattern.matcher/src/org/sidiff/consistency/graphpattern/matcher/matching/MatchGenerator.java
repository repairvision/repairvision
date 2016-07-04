package org.sidiff.consistency.graphpattern.matcher.matching;

import static org.sidiff.consistency.graphpattern.matcher.tools.MatchingHelper.getDataStore;

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
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.sidiff.consistency.graphpattern.EObjectList;
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
	public static final EObject EMPTY_MATCH = new EObjectImpl() {
		
		public String toString() {
			return "empty match";
		}
		
	};

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
	 * <code>true</code> only injective matchings (w.r.t. to variable nodes); <code>false</code> otherwise.
	 */
	protected boolean injectiveVariableNodes = true;
	
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
	 * All model elements (per node) that were already assigned (in previous matchings).
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

	/**
	 * @return <code>true</code> only injective matchings (w.r.t. to variable
	 *         nodes); <code>false</code> otherwise.
	 */
	public boolean isInjectiveVariableNodes() {
		return injectiveVariableNodes;
	}

	/**
	 * @param injectiveVariableNodes
	 *            <code>true</code> only injective matchings (w.r.t. to variable
	 *            nodes); <code>false</code> otherwise.
	 */
	public void setInjectiveVariableNodes(boolean injectiveVariableNodes) {
		this.injectiveVariableNodes = injectiveVariableNodes;
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
			NavigableMatchesDS dataStore = getDataStore(node.getEvaluation());
			dataStore.getMatchSelection().clearSelection();
		}
	}
	
	private void initializeMatching() {
		NodePattern firstNode = variableNodes.getFirst();
		NavigableMatchesDS firstNodeDS = getDataStore(firstNode.getEvaluation());

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
						
						// FIXME: DebugUtil!
//						assert validateMatch();
						
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
			NavigableMatchesDS dataStore = getDataStore(remainingInitialNode.getEvaluation());
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
			
			// TODO: Store if a matching is restricted or not!?
			// Undo restrictions of this node from the complete graph:
			for (NodePattern node : graphPattern) {
				NavigableMatchesDS nodeDS = getDataStore(node.getEvaluation());
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
				additionalRestrictions(initialMatch); // (After initial selection was build)
			} else {
				additionalRestrictions(initialMatch);
				matchSelector.selectMatch(initialNode, initialMatch.getMatch());
			}
			
			// Check if match was valid (e.g. failed on atomic matching):
			NavigableMatchesDS initialNodeDS = getDataStore(initialNode.getEvaluation());
			
			if (initialNodeDS.getMatchSelection().isSelectedMatch(initialMatch.getMatch())) {
				return true;
			}
		}
		
		return false;
	}
	
	private void restrictFreeNodes(List<NodePattern> freeNodes) {
		
		// Initialize and restrict all free nodes:
		for (NodePattern freeNode : freeNodes) {
			NavigableMatchesDS freeNodeDS = getDataStore(freeNode.getEvaluation());
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
				additionalRestrictions(freeMatching);
				matchSelector.selectMatch(freeNode, nextRestriction);
			} else {
				freeMatching.resetMatching();
			}
		}
	}
	
	private void additionalRestrictions(NodeMatching nodeMatching) {
		
		// Variable node injectivity:
		if (injectiveVariableNodes) {
			for (NodeMatching otherNodeMatching : matching.values()) {
				if (otherNodeMatching != nodeMatching) {
					NavigableMatchesDS dataStore = getDataStore(otherNodeMatching.getNode().getEvaluation());
					MatchSelection matchSelection = dataStore.getMatchSelection();
					matchSelection.restrictSelection(nodeMatching.getNode(), nodeMatching.getMatch());
				}
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
			MatchSelection matchSelection = getDataStore(node.getEvaluation()).getMatchSelection();
			
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
	
	@Override
	public String toString() {
		StringBuffer print = new StringBuffer();
		
		for (NodePattern node : graphPattern) {
			MatchSelection matchSelection = getDataStore(node.getEvaluation()).getMatchSelection();
			print.append("  " + node + ": \n");
			
			matchSelection.getSelectedMatches().forEachRemaining(match -> {
				if (match != null) {
					print.append("    " + match + "\n");
				}
			});
		}
		
		return super.toString() + ": \n\n" + print.toString();
	}
	
	@SuppressWarnings("unused")
	private boolean validateMatch() {
		
		// Check V-Node and Selection consistency:
		for (NodeMatching match : matching.values()) {
			MatchSelection matchSelection = getDataStore(match.getNode().getEvaluation()).getMatchSelection();
			int count = 0;
			
			for (Iterator<EObject> iterator = 	matchSelection.getSelectedMatches(); iterator.hasNext();) {
				EObject selection = iterator.next();
				++count;
				
				if (match.getMatch() != selection) {
					System.err.println("Inconsistent node-matching and selection!");
					return false;
				}
			}
			
			if ((count == 0) && (match.getMatch() != null)) {
				System.err.println("Inconsistent node-matching and selection!");
				return false;
			}
			
			if (count > 1) {
				System.err.println("Ambiguous matching!");
				return false;
			}
		}
		
		// Check V-Node injectivity:
		if (injectiveVariableNodes) {
			for (NodeMatching matchA : matching.values()) {
				for (NodeMatching matchB : matching.values()) {
					if (matchA != matchB) {
						if ((matchA.getMatch() == matchB.getMatch()) 
								&& (matchA.getMatch() != null) && (matchB.getMatch() != null)) {
							System.err.println("Matching is not injective!");
							return false;
						}
					}
				}
			}
		}
		
		return true;
	}
}
