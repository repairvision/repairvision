package org.sidiff.consistency.repair.complement.construction.context;

import static org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx.copyEdge;
import static org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx.copyParameter;
import static org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx.copyPreserveNodes;
import static org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx.getLHS;
import static org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx.getPreservedEdges;
import static org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx.getPreservedNodes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.henshin.interpreter.EGraph;
import org.eclipse.emf.henshin.interpreter.Match;
import org.eclipse.emf.henshin.interpreter.impl.EngineImpl;
import org.eclipse.emf.henshin.interpreter.impl.MatchImpl;
import org.eclipse.emf.henshin.interpreter.impl.RestrictedEGraphImpl;
import org.eclipse.emf.henshin.model.Action.Type;
import org.eclipse.emf.henshin.model.Graph;
import org.eclipse.emf.henshin.model.HenshinFactory;
import org.eclipse.emf.henshin.model.Node;
import org.eclipse.emf.henshin.model.Parameter;
import org.eclipse.emf.henshin.model.Rule;
import org.sidiff.common.henshin.view.EdgePair;
import org.sidiff.common.henshin.view.NodePair;
import org.sidiff.consistency.repair.complement.construction.ComplementRule;
import org.sidiff.consistency.repair.complement.construction.match.ComplementMatch;
import org.sidiff.consistency.repair.complement.construction.match.EditRuleEdgeMatch;
import org.sidiff.consistency.repair.complement.construction.match.EditRuleMatch;
import org.sidiff.consistency.repair.complement.construction.match.EditRuleNodeMatch;
import org.sidiff.consistency.repair.complement.construction.match.EditRuleNodeMultiMatch;
import org.sidiff.consistency.repair.complement.construction.match.EditRuleNodeSingleMatch;

/**
 * Constructs the complement-rule = source-rule (-) partial-edit-rule-match.
 * Requires that the context of the complement-rule can be completely matched.
 * 
 * @author Manuel Ohrndorf
 */
public class ContextComplementRule extends ComplementRule {

	public ContextComplementRule(Rule sourceRule, Rule complementRule, EngineImpl engine, EGraph graph) {
		super(sourceRule, complementRule);
		initialize(engine, graph);
	}

	protected List<ComplementMatch> createComplementPrematches(List<EditRuleMatch> partialSourceMatch) {
		
		// Create complement pre-match by partial source-rule match:
		Match complementPreMatche = new MatchImpl(complementRule);

		// Get change context as pre-match:
		for (EditRuleMatch sourceRuleMatch : partialSourceMatch) {

			if (sourceRuleMatch instanceof EditRuleEdgeMatch) {
				if (sourceRuleMatch.getAction().equals(Type.DELETE) 
						|| sourceRuleMatch.getAction().equals(Type.CREATE)) {

					addPreMatch(complementPreMatche,
							((EditRuleEdgeMatch) sourceRuleMatch).getEdge().getSource(),
							((EditRuleEdgeMatch) sourceRuleMatch).getSrcModelElement());
					addPreMatch(complementPreMatche,
							((EditRuleEdgeMatch) sourceRuleMatch).getEdge().getTarget(),
							((EditRuleEdgeMatch) sourceRuleMatch).getTgtModelElement());
				}
			}

			else if (sourceRuleMatch instanceof EditRuleNodeSingleMatch) {
				if (sourceRuleMatch.getAction().equals(Type.DELETE) 
						|| sourceRuleMatch.getAction().equals(Type.CREATE)) {

					addPreMatch(complementPreMatche,
							((EditRuleNodeSingleMatch) sourceRuleMatch).getNode(),
							((EditRuleNodeSingleMatch) sourceRuleMatch).getModelElement());
				}
			}

			// Ignore EditRuleNodeMulitMatches...
		}
		
		// Check context rule (with restricted working graph):
		ArrayList<ComplementMatch> complementPreMatches = new ArrayList<>();
		Iterator<Match> matchFinder = getEngine().findMatches(complementRule, getGraph(), complementPreMatche).iterator();
		
		while (matchFinder.hasNext()) {
			Match nextMatch = matchFinder.next();
			
			// Create complement pre-match:
			ComplementMatch nextComplementMatch = new ComplementMatch(new HashMap<>());
			complementPreMatches.add(nextComplementMatch);
			
			for (Node complementNode : complementRule.getLhs().getNodes()) {
				nextComplementMatch.getNodeMatches().put(complementNode, nextMatch.getNodeTarget(complementNode));
			}
		}
		
		complementPreMatches.trimToSize();
		return complementPreMatches;
	}
	
	private void addPreMatch(Match complementPreMatches, Node sourceNode, EObject match) {
		Node complementNode = getLHS(getTrace(sourceNode));
		
		if (complementNode != null) {
			complementPreMatches.setNodeTarget(complementNode, match);
		}
	}
	
	// TODO: Remove this...!?
	protected List<ComplementMatch> deprecated_createComplementPrematches(List<EditRuleMatch> partialSourceMatch) {
		
		// Create rule which only contains the context nodes:
		Rule contextRule = HenshinFactory.eINSTANCE.createRule();
		Graph contextLHS = HenshinFactory.eINSTANCE.createGraph();
		Graph contextRHS = HenshinFactory.eINSTANCE.createGraph();
		contextRule.setLhs(contextLHS);
		contextRule.setRhs(contextRHS);
		
		Map<Node, Node> traceContextToComplement = new HashMap<>();
		Map<Node, Node> traceComplementToContext = new HashMap<>();
		
		for (NodePair preserveNodeComplement : getPreservedNodes(complementRule)) {
			NodePair preserveNodeContext = copyPreserveNodes(contextRule, preserveNodeComplement, true);
			
			traceComplementToContext.put(preserveNodeComplement.getLhsNode(), preserveNodeContext.getLhsNode());
			traceComplementToContext.put( preserveNodeComplement.getRhsNode(), preserveNodeContext.getRhsNode());
			
			traceContextToComplement.put(preserveNodeContext.getLhsNode(), preserveNodeComplement.getLhsNode());
			traceContextToComplement.put(preserveNodeContext.getRhsNode(), preserveNodeComplement.getRhsNode());
		}
		
		for (EdgePair preserveEdgeComplement : getPreservedEdges(complementRule)) {
			copyEdge(
					preserveEdgeComplement.getLhsEdge(), 
					traceComplementToContext.get(preserveEdgeComplement.getLhsEdge().getSource()),
					traceComplementToContext.get(preserveEdgeComplement.getLhsEdge().getTarget()));
			
			copyEdge(
					preserveEdgeComplement.getRhsEdge(), 
					traceComplementToContext.get(preserveEdgeComplement.getRhsEdge().getSource()),
					traceComplementToContext.get(preserveEdgeComplement.getRhsEdge().getTarget()));
		}
		
		for (Parameter parameter : complementRule.getParameters()) {
			copyParameter(contextRule, parameter);
		}
		
		// Create restricted graph:
		RestrictedEGraphImpl restrictedGraph = new RestrictedEGraphImpl(getGraph(), getEngine(), contextRule);
		
		for (EditRuleMatch sourceRuleMatch : partialSourceMatch) {
			if (sourceRuleMatch instanceof EditRuleNodeMatch) {
				Node sourceNode = ((EditRuleNodeMatch) sourceRuleMatch).getNode();
				Node complementNode = getLHS(getTrace(sourceNode));
				EditRuleNodeMatch preMatch = (EditRuleNodeMatch) sourceRuleMatch;

				if (complementNode != null) {
					if (preMatch instanceof EditRuleNodeSingleMatch) {
						EditRuleNodeSingleMatch singlePreMatch = (EditRuleNodeSingleMatch) preMatch;
						restrictedGraph.setDomainRestriction(
								traceComplementToContext.get(complementNode),
								singlePreMatch.getModelElement());
					}
					
					else if (preMatch instanceof EditRuleNodeMultiMatch) {
						EditRuleNodeMultiMatch multiPreMatch = (EditRuleNodeMultiMatch) preMatch;
						restrictedGraph.setDomainRestriction(
								traceComplementToContext.get(complementNode),
								multiPreMatch.getModelElements());
					}
				}
			}
		}
		
		// Check context rule (with restricted working graph):
		ArrayList<ComplementMatch> complementPreMatches = new ArrayList<>();
		Iterator<Match> matchFinder = getEngine().findMatches(contextRule, restrictedGraph, null).iterator();
		
		while (matchFinder.hasNext()) {
			Match nextMatch = matchFinder.next();
			
			// Create complement pre-match:
			ComplementMatch nextComplementMatch = new ComplementMatch(new HashMap<>());
			complementPreMatches.add(nextComplementMatch);
			
			for (Node contextNode : contextLHS.getNodes()) {
				nextComplementMatch.getNodeMatches().put(traceContextToComplement.get(contextNode), nextMatch.getNodeTarget(contextNode));
			}
		}
		
		complementPreMatches.trimToSize();
		return complementPreMatches;
	}
}
