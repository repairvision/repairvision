package org.sidiff.consistency.graphpattern.matcher.wgraph.partial;

import static org.sidiff.consistency.graphpattern.matcher.tools.MatchingHelper.getDataStore;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.sidiff.consistency.graphpattern.EdgePattern;
import org.sidiff.consistency.graphpattern.Evaluation;
import org.sidiff.consistency.graphpattern.NavigableDataStore;
import org.sidiff.consistency.graphpattern.NodePattern;
import org.sidiff.consistency.graphpattern.impl.VisitorImpl;
import org.sidiff.consistency.graphpattern.matcher.tools.MatchingHelper;
import org.sidiff.consistency.graphpattern.matcher.tools.paths.DFSOutgoingPathIterator;
import org.sidiff.consistency.graphpattern.matcher.tools.paths.DFSOutgoingPathIterator.DFSPath;
import org.sidiff.consistency.graphpattern.matcher.tools.paths.IPathRestriction;
import org.sidiff.consistency.graphpattern.matcher.wgraph.IConstraintTester;

/**
 * Approximates the local working graph for a given graph pattern.
 * 
 * @author Manuel Ohrndorf
 */
public class LocalEvaluationMatcher extends VisitorImpl  {
	
	//// Global ////
	
	protected MatchingHelper matchingHelper;
	
	protected IConstraintTester constraintTester;
	
	protected Map<NodePattern, Set<EdgePattern>> localEvaluations;
	
	//// Specific ////
	
	protected NodePattern startVariableNode;
	
	protected Set<EdgePattern> localEvaluation;
	
	protected IPathRestriction pathRestriction;
	
	protected Set<EdgePattern> matched = new HashSet<>();
	
	public LocalEvaluationMatcher(
			MatchingHelper matchingHelper, IConstraintTester constraintTester,  
			Map<NodePattern, Set<EdgePattern>> localEvaluations, IPathRestriction pathRestriction) {
		
		init(matchingHelper, constraintTester, localEvaluations);
		this.pathRestriction = pathRestriction;
	}
	
	public LocalEvaluationMatcher(
			MatchingHelper matchingHelper, IConstraintTester constraintTester, 
			Map<NodePattern, Set<EdgePattern>> localEvaluations) {
		
		init(matchingHelper, constraintTester, localEvaluations);
	}
	
	private void init(
			MatchingHelper matchingHelper, IConstraintTester constraintTester, 
			Map<NodePattern, Set<EdgePattern>> localEvaluations) {
		
		this.matchingHelper = matchingHelper;
		this.constraintTester = constraintTester;
		this.localEvaluations = localEvaluations;
	}

	@Override
	public void visit(Evaluation evaluation) {
		this.startVariableNode = evaluation.getNode();
		this.localEvaluation = localEvaluations.get(startVariableNode);
		
		// TODO: BFS with propagation of new matches and upper path length limit!?
		
		// Match every path of the local evaluation:
		// (Should be more efficient than the pairwise paths between variable nodes!)
		getLocalEvaluation().forEachRemaining(this::matchPath);
	}
	
	private DFSOutgoingPathIterator getLocalEvaluation() {
		return new DFSOutgoingPathIterator(startVariableNode) {
			
			//// Terminate if local evaluation graph == matched graph ////
			
			@Override
			public boolean hasNext() {
				
				// Only edges of the local evaluation can be matched:
				assert ((localEvaluation.size() == matched.size()) == (localEvaluation.equals(matched)));

				return super.hasNext() && (localEvaluation.size() != matched.size());
			}
			
			//// Stay in the local evaluation graph ////
			
			@Override
			protected boolean isValidIncomingEdge(EdgePattern incoming) {
				
				if (pathRestriction.isRestrictedIncoming(incoming))  {
					return false;
				}
				
				return localEvaluation.contains(incoming);
			}
			
			@Override
			protected boolean isValidOutgoingEdge(EdgePattern outgoing) {
				
				if (pathRestriction.isRestrictedOutgoing(outgoing))  {
					return false;
				}
				
				return localEvaluation.contains(outgoing);
			}
		};
	}
	
	private void matchPath(DFSPath path) {
		if (path.isNewPathEmpty()) return;
		
		// Optimization: Lookahead to next edge matching: 
		//   matched -> match only new matches -> store new matches
		//   not matched -> match all -> do not store new matches
		// (Filter already matched path segments -> path approximation)
		boolean isActualSegmentMatched = false; // Initialization dont't care
		boolean isNextSegmentMatched = matched.contains(path.getNewPathSegment(0));
		
		Collection<EObject> newMatches = new ArrayList<>();
		
		// Walk through the path:
		for (int i = 0; i < path.getNewPathSize(); i++) {
			EdgePattern pathSegment = path.getNewPathSegment(i);
			
			NodePattern targetNode = pathSegment.getTarget();
			NavigableDataStore targetDS = getDataStore(targetNode.getEvaluation());
			
			NodePattern sourceNode = pathSegment.getSource();
			NavigableDataStore sourceDS = getDataStore(sourceNode.getEvaluation());
			
			isActualSegmentMatched = isNextSegmentMatched;
			isNextSegmentMatched = (path.getNewPathSize() > i + 1) 
					? matched.contains(path.getNewPathSegment(i + 1)) : false;
			
			// Process all or only new matches?
			if (!isActualSegmentMatched) {
				
				//// New complete matching ////
				
				// Constraint by lookahead optimization...
				// (Would need newMatches.clear(); otherwise)
				assert (newMatches.isEmpty());

				// Match the given path segment:
				boolean isEmptyPath = true;
				
				for (Iterator<EObject> itSource = sourceDS.getMatchIterator(); itSource.hasNext();) {
					EObject sourceMatch = itSource.next();
					
					for (Iterator<? extends EObject> itTarget = matchEdge(sourceMatch, pathSegment); itTarget.hasNext();) {
						EObject targetMatch = itTarget.next();
						boolean isNewTargetMatch = !targetDS.containsMatch(targetMatch);
						
						if (matchNode(pathSegment, 
								sourceNode, sourceDS, sourceMatch, 
								targetNode, targetDS, targetMatch)) {
							
							isEmptyPath = false;

							// Store new matches (if next path segment was already visited):
							if (isNextSegmentMatched && isNewTargetMatch) {
								newMatches.add(targetMatch);
							}
						}	
					}
				}
		
				// Stop on empty path:
				if (isEmptyPath) {
					break;
				}
			} else {
				
				//// Propagate (only) new matches through the full path ////
				
				if (!newMatches.isEmpty()) {
					Collection<EObject> targetMatches = new ArrayList<>();
					
					for (EObject sourceMatch : newMatches) {
						for (Iterator<? extends EObject> itTarget = matchEdge(sourceMatch, pathSegment); itTarget.hasNext();) {
							EObject targetMatch = itTarget.next();

							if (matchNode(pathSegment, 
									sourceNode, sourceDS, sourceMatch, 
									targetNode, targetDS, targetMatch)) {

								// Store new matches (if next path segment was already visited):
								if (isNextSegmentMatched && targetDS.containsMatch(targetMatch)) {
									targetMatches.add(targetMatch);
								}
							}
						}
					}
					newMatches = targetMatches;
				}
			}
			
			// Mark edge as visited:
			matched.add(pathSegment);
		}
	}
	
	private Iterator<? extends EObject> matchEdge(EObject sourceMatch, EdgePattern edge) {
		return matchingHelper.getTargets(sourceMatch, edge.getSource(), edge);
	}
	
	private boolean matchNode(EdgePattern edge,
			NodePattern sourceNode, NavigableDataStore sourceDataStore, EObject sourceMatch,
			NodePattern targetNode, NavigableDataStore targetDataStore, EObject targetMatch) {
		
		if (constraintTester.check(targetNode, targetMatch)) {
			targetDataStore.addMatch(targetMatch);
			targetDataStore.addRemoteMatch(targetMatch, sourceMatch, edge);
			sourceDataStore.addRemoteMatch(sourceMatch, targetMatch, edge);
			return true;
		} else {
			return false;
		}
	}
}
