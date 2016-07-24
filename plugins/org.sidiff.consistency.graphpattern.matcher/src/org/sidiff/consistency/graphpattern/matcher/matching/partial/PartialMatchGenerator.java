package org.sidiff.consistency.graphpattern.matcher.matching.partial;

import static org.sidiff.consistency.graphpattern.matcher.tools.MatchingHelper.getDataStore;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.sidiff.consistency.common.debug.DebugUtil;
import org.sidiff.consistency.graphpattern.NodePattern;
import org.sidiff.consistency.graphpattern.matcher.data.NavigableMatchesDS;
import org.sidiff.consistency.graphpattern.matcher.data.selection.MatchSelection;
import org.sidiff.consistency.graphpattern.matcher.data.selection.SelectionMatching;
import org.sidiff.consistency.graphpattern.matcher.matching.AbstractMatchGenerator;
import org.sidiff.consistency.graphpattern.matcher.matching.IMatchGenerator;
import org.sidiff.consistency.graphpattern.matcher.matching.selection.MatchSelector;

/**
 * Concrete implementation of {@link IMatchGenerator}. Iterates through all
 * possible (maximal) partial matches for a given graph.
 * 
 * @author Manuel Ohrndorf
 */
public abstract class PartialMatchGenerator extends AbstractMatchGenerator<SelectionMatching> {

	/**
	 * Represents all empty linked lists.
	 */
	private static LinkedList<NodePattern> EMPTY_NODE_LIST = new LinkedList<NodePattern>();  
	
	/**
	 * All nodes which are variables in the sense of the constraint solving problem of the graph.
	 * 
	 * (NOTE: Order will be modified.)
	 */
	private LinkedList<NodePattern> variableNodeOrder = new LinkedList<>();
	
	/**
	 * <code>true</code> only injective matchings (w.r.t. to variable nodes); <code>false</code> otherwise.
	 */
	protected boolean injectiveVariableNodes = true;
	
	/**
	 * Calculates all matchable paths starting from an initial node. 
	 */
	private MatchSelector matchSelector;
	
	/**
	 * All model elements (per node) that were already assigned (in previous matchings).
	 */
	private Map<NodePattern, Set<EObject>> assignments = new HashMap<>(); 
	
	/**
	 * All nodes which were not yet considered as initial nodes.
	 */
	private Set<NodePattern> remainingInitialNodes = new LinkedHashSet<>();
	
	/**
	 * The unique match iterator of this match generator.
	 */
	private Iterator<SelectionMatching> matchIterator;
	
	/**
	 * Initializes a new {@link PartialMatchGenerator}.
	 */
	public PartialMatchGenerator() {
	}
	
	@Override
	public void initialize(List<NodePattern> graphPattern, List<NodePattern> variableNodes) {
		super.initialize(graphPattern, variableNodes);
		this.variableNodeOrder.addAll(variableNodes); // (NOTE: Order will be modified.)
	}
	
	@Override
	public void start() {
		
		// Initialize the data stores of all nodes:
		initializeDataStore();
		
		// Initialize variable node matching:
		initializeVariableNodes();
		initializeMatching();
	}

	@Override
	public  Iterator<SelectionMatching> getResults() {
		
		if (matchIterator == null) {
			matchIterator = new Iterator<SelectionMatching>() {

				private SelectionMatching matching;
				
				private Boolean hasNext = null;
				
				@Override
				public boolean hasNext() {
					
					if (hasNext == null) {
						// Mark the last matching as deprecated:
						if (matching != null) {
							matching.setSelectionModified(true); 
						}
						
						// Find next match:
						matching = new SelectionMatching();
						hasNext = findNextMatch();
					}
					
					return hasNext;
				}

				@Override
				public SelectionMatching next() {
					if (hasNext()) {
						// Tell hasNext() that we need a new matching next time:
						hasNext = null;
						
						// Return the actual matching:
						return matching;
					} else {
						throw new NoSuchElementException();
					}
				}
			};
		}
		
		return matchIterator;
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

		for (NodePattern variableNode : variableNodeOrder) {
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
		NodePattern firstNode = variableNodeOrder.getFirst();
		NavigableMatchesDS firstNodeDS = getDataStore(firstNode.getEvaluation());

		setNextInitialNode(variableNodeOrder.getFirst(), firstNodeDS.getMatchIterator());
	}
	
	private void setNextInitialNode(NodePattern initialNode, Iterator<EObject> matches) {
		
		if (variableNodeOrder.getFirst() != initialNode) {
			variableNodeOrder.remove(initialNode);
			variableNodeOrder.addFirst(initialNode);
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
 		long startTime = System.currentTimeMillis();

		// Search for the next valid match:
		while (!findNextAssignemt()) {
			if (!nextAssignmentOrder()) {
				return false;
			}
		}
		
		System.out.println("Matching Time: " + (System.currentTimeMillis() - startTime) / 1000.0 + "s");
		
		return true;
	}
	
	private boolean findNextAssignemt() {
		
		// Search for the next valid match:
		while (true) {
			
			// Undo last matching (backtracking):
			LinkedList<NodePattern> nextNodes = getNextMatchableNodes();
			unambiguousMatches.clear();
			
			// Check if there are more matches possible?
			if (!nextNodes.isEmpty()) {
				
				// Get and remove initial node from the next matchable nodes:
				NodePattern initialNode = nextNodes.pollFirst();
				
				// Calculate next matching:
				if (initializeNextMatching(initialNode)) {

					// Select a specific assignment:
					restrictFreeNodes(nextNodes);
					
					// Check new matching
//					if (!isEmptyMatch()) {
						if (getMatchValidation().isMatch(matching)) {

							// Validate match:
							// FIXME: Check for example M0008
							DebugUtil.check(this::validateMatch, this);

							storeVariableAssignments();
							return true;
						}
//					}
				}
			} else {
				// No more matches possible!
				break;
			}
		}
		
		return false;
	}
	
//	private boolean isEmptyMatch() {
//		
//		for (NodePattern node : graphPattern) {
//			MatchSelection matchSelection = getDataStore(node.getEvaluation()).getMatchSelection();
//			
//			for (Iterator<EObject> iterator = matchSelection.getSelectedMatches(); iterator.hasNext();) {
//				return false;
//			}
//		}
//		
//		return true;
//	}

	/**
	 * Checks if there is any node that has objects which were not already
	 * assigned to some matching.
	 * 
	 * @return <code>true</code> if there are more matches possible;
	 *         <code>false</code> otherwise.
	 */
	private boolean nextAssignmentOrder() {
		Collection<EObject> nextInitialMatch = new ArrayList<>();

		for (NodePattern remainingInitialNode : remainingInitialNodes) {
			NavigableMatchesDS dataStore = getDataStore(remainingInitialNode.getEvaluation());
			Set<EObject> matches = assignments.get(remainingInitialNode);

			if (matches.size() != dataStore.getMatchSize()) {

				// Get all objects that were not yet assigned to a matching:
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
		
		for (Iterator<NodePattern> iterator = variableNodeOrder.descendingIterator(); iterator.hasNext();) {
			nextNode = iterator.next();
			nextMatch = matching.get(nextNode);
			nextNodes.addFirst(nextNode);
			
			// Undo restrictions of this node from the complete graph:
			// TODO: Store restriction sources...!?
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
			if (initialNode == variableNodeOrder.getFirst()) {
				matchSelector = new MatchSelector(
						getAtomicPatternFactory(), graphPattern, initialNode, initialMatch.getMatch());
				ensureInjectivity(initialMatch); // (After initial selection was build)
			} else {
				ensureInjectivity(initialMatch);
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
			
			// Search next assignment:
			boolean assignmentFound = false;
			
			while (freeMatching.hasNextMatch()) {
				
				//// Restrict the (full) matching to the first match in the selection list ////

				freeMatching.setNextMatch();
				EObject nextRestriction = freeMatching.getMatch();
				
				// TODO: Potential match check.
//				while(!matchValidation.isPotentialMatch(freeMatching, matching)) {
//					if (freeMatching.hasNextMatch()) {
//						freeMatching.setNextMatch();
//					} else {
//						freeMatching.resetMatching();
//					}
//				}
//				
//				if (freeMatching.getMatch() != null) {

				ensureInjectivity(freeMatching);
				
				if (!isUnambiguousMatch()) {
					matchSelector.selectMatch(freeNode, nextRestriction);
				}
				
				// Check if match was valid (e.g. failed on atomic matching):
				if (freeNodeDS.getMatchSelection().isSelectedMatch(nextRestriction)) {
					assignmentFound = true;
					break;
				}
			} 
			
			// No match found?
			if (!assignmentFound) {
				freeMatching.resetMatching();
			}
		}
	}
	
	private void ensureInjectivity(NodeMatching nodeMatching) {
		NodePattern assignedVariableNode = nodeMatching.getNode();
		
		// Variable node injectivity:
		if (injectiveVariableNodes) {
			for (NodePattern variableNode : variableNodes) {
				// TODO: Filter by node type - assignable!?
				if (variableNode != assignedVariableNode) {
					NavigableMatchesDS dataStore = getDataStore(variableNode.getEvaluation());
					MatchSelection matchSelection = dataStore.getMatchSelection();
					matchSelection.restrictSelection(nodeMatching.getNode(), nodeMatching.getMatch());
				}
			}
		}
	}
	
	// TODO: Move this functionality to DataStore!
	private Set<NodePattern> unambiguousMatches = new HashSet<>();
	
	private boolean isUnambiguousMatch() {
		
		if (graphPattern.size() == unambiguousMatches.size()) {
			return true;
		}
		
		for (NodePattern node : graphPattern) {
			if (!unambiguousMatches.contains(node)) {
				MatchSelection matchSelection = getDataStore(node.getEvaluation()).getMatchSelection();
				int count = 0;
				
				// TODO: Store size of selection:
				for (Iterator<EObject> iterator = matchSelection.getSelectedMatches(); iterator.hasNext();) {
					iterator.next();
					++count;
					
					if (count > 1) {
						return false;
					}
				}
				
				unambiguousMatches.add(node);
			}
		}
		
		return true;
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
	
	/**
	 * <ul>
	 * <li>Checks if the match is consistent with the {@link NodeMatching}s.</li>
	 * <li>Checks if the match is injective (if required).</li>
	 * </ul>
	 * 
	 * @return <code>true</code> if the match is valid; 
	 *         <code>false</code> otherwise.
	 */
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
							System.err.println("(Node-)Matching is not injective!");
							return false;
						}
					}
				}
			}
		}
		
		return true;
	}
}
