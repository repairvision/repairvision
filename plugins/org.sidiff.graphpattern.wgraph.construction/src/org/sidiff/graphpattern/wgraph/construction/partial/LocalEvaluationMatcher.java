package org.sidiff.graphpattern.wgraph.construction.partial;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.sidiff.graphpattern.EdgePattern;
import org.sidiff.graphpattern.Evaluation;
import org.sidiff.graphpattern.NavigableDataStore;
import org.sidiff.graphpattern.NodePattern;
import org.sidiff.graphpattern.impl.VisitorImpl;
import org.sidiff.graphpattern.wgraph.construction.IConstraintTester;
import org.sidiff.graphpattern.wgraph.construction.tools.matching.MatchingHelper;
import org.sidiff.graphpattern.wgraph.construction.tools.paths.DFSOutgoingPathIterator;
import org.sidiff.graphpattern.wgraph.construction.tools.paths.DFSOutgoingPathIterator.DFSPath;
import org.sidiff.graphpattern.wgraph.construction.tools.paths.IPathRestriction;
import org.sidiff.graphpattern.wgraph.util.WGraph;

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
		getLocalEvaluation().forEachRemaining(this::matchPath);
	}
	
	private DFSOutgoingPathIterator getLocalEvaluation() {
		return new DFSOutgoingPathIterator(startVariableNode) {
			
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
		
		Collection<EObject> newMatches = new ArrayList<>();
		NavigableDataStore initialDS = WGraph.getDataStore(path.getNewPathSegment(0).getSource());
		initialDS.getMatchIterator().forEachRemaining(newMatches::add);
		
		// Walk through the path:
		for (int i = 0; i < path.getNewPathSize(); i++) {
			EdgePattern pathSegment = path.getNewPathSegment(i);
			
			NodePattern targetNode = pathSegment.getTarget();
			NavigableDataStore targetDS = WGraph.getDataStore(targetNode.getEvaluation());
			
			NodePattern sourceNode = pathSegment.getSource();
			NavigableDataStore sourceDS = WGraph.getDataStore(sourceNode.getEvaluation());
			
			// Process all new matches:
			if (!newMatches.isEmpty()) {
				Collection<EObject> targetMatches = new ArrayList<>();

				for (EObject sourceMatch : newMatches) {
					for (Iterator<? extends EObject> itTarget = matchEdge(sourceMatch, pathSegment); itTarget.hasNext();) {
						EObject targetMatch = itTarget.next();

						// NOTE: We need to add the match to the node even if
						// it is already present, due to the edge matchings.
						if (matchNode(pathSegment, 
								sourceNode, sourceDS, sourceMatch, 
								targetNode, targetDS, targetMatch)) {

							targetMatches.add(targetMatch);
						}
					}
				}
				newMatches = targetMatches;
			} else {
				break;
			}
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
