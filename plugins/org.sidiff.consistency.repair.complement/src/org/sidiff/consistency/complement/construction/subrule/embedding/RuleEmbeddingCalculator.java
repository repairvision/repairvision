package org.sidiff.consistency.complement.construction.subrule.embedding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.henshin.interpreter.Engine;
import org.eclipse.emf.henshin.interpreter.Match;
import org.eclipse.emf.henshin.interpreter.impl.EngineImpl;
import org.eclipse.emf.henshin.interpreter.impl.MatchImpl;
import org.eclipse.emf.henshin.interpreter.util.HenshinEGraph;
import org.eclipse.emf.henshin.model.Edge;
import org.eclipse.emf.henshin.model.Graph;
import org.eclipse.emf.henshin.model.HenshinFactory;
import org.eclipse.emf.henshin.model.Mapping;
import org.eclipse.emf.henshin.model.Node;
import org.eclipse.emf.henshin.model.Rule;
import org.sidiff.consistency.complement.util.ComplementUtil;

/**
 * Calculates all possible embeddings of a sub-rule in a super-rule. 
 * 
 * @author Manuel Ohrndorf
 */
public class RuleEmbeddingCalculator {

	public static List<RuleEmbedding> calculateRuleEmbedding(Rule superRule, Rule subRule) {
		List<RuleEmbedding> embeddings = new ArrayList<>();
		
		// Calculate LHS-Embeddings:
		List<Map<Node, Node>> lhsEmbeddings = calculateGraphNodeEmbedding(superRule.getLhs(), subRule.getLhs());

		// Calculate RHS-Embeddings:
		for (Map<Node, Node> lhsEmbedding : lhsEmbeddings) {
			List<Map<Node, Node>> rhsEmbeddings = calculateGraphNodeEmbedding(
					superRule.getRhs(), subRule.getRhs(), lhsEmbedding);
			
			// Fork embedding of each LHS for each matched RHS: 
			for (Map<Node, Node> rhsEmbedding : rhsEmbeddings) {
				
				// Create rule-embedding:
				RuleEmbedding ruleEmbedding = new RuleEmbedding(superRule, subRule);
				embeddings.add(ruleEmbedding);
				
				ruleEmbedding.setLhsNodeEmbedding(lhsEmbedding);
				ruleEmbedding.setRhsNodeEmbedding(rhsEmbedding);
				
				// Calculate edge-embedding:
				ruleEmbedding.setLhsEdgeEmbedding(
						calculateGraphEdgeEmbedding(superRule.getLhs(), subRule.getLhs(), lhsEmbedding));
				ruleEmbedding.setRhsEdgeEmbedding(
						calculateGraphEdgeEmbedding(superRule.getRhs(), subRule.getRhs(), rhsEmbedding));
			}
		}
		
		return embeddings;
	}
	
	private static Map<Edge, Edge> calculateGraphEdgeEmbedding(
			Graph superGraph, Graph subGraph, Map<Node, Node> embedding) {
		
		Map<Edge, Edge> edgeEmbedings = new HashMap<>();
		
		for (Entry<Node, Node> nodeEmbedding : embedding.entrySet()) {
			Node subGraphSrcNode = nodeEmbedding.getKey();
			Node superGraphSrcNode = nodeEmbedding.getValue();
			
			for (Edge subGraphEdge : subGraphSrcNode.getOutgoing()) {
				Node subGraphTgtNode = subGraphEdge.getTarget();
				Node superGraphTgtNode = embedding.get(subGraphTgtNode);
				
				Edge superGraphEdge = superGraphSrcNode.getOutgoing(
						subGraphEdge.getType(), superGraphTgtNode);
				
				assert (superGraphEdge != null) : "Missing edge embedding: " + subGraphEdge;
				
				edgeEmbedings.put(subGraphEdge, superGraphEdge);
			}
		}
		
		return edgeEmbedings;
	}
	
	/**
	 * @param superGraph
	 *            The greater super-graph.
	 * @param subGraph
	 *            The smaller sub-graph which will be matched against the super-graph.
	 * @return Match: Sub-Graph -> Super-Graph
	 */
	public static List<Map<Node, Node>> calculateGraphNodeEmbedding(Graph superGraph, Graph subGraph) {
		return calculateGraphNodeEmbedding(superGraph, subGraph, Collections.emptyMap());
	}

	/**
	 * @param superGraph
	 *            The greater super-graph.
	 * @param subGraph
	 *            The smaller sub-graph which will be matched against the super-graph.
	 * @param preMatch
	 *            A pre-match: sub-graph -> super-graph
	 * @return Match: sub-graph -> super-graph
	 */
	public static List<Map<Node, Node>> calculateGraphNodeEmbedding(
			Graph superGraph, Graph subGraph, Map<Node, Node> preMatch) {
		
		// Match the sub-graph in the dummy working graph that is isomorph to the super-graph: 
		HenshinEGraph superObjectGraph = new HenshinEGraph(superGraph);
		
		// Interpret the sub-graph as << preserve >> only rule:
		Rule subMatchingRule = HenshinFactory.eINSTANCE.createRule();
		Map<EObject, EObject> rhsSubGraph = ComplementUtil.deepCopy(subGraph);
		
		for (Entry<EObject, EObject> copyTrace : rhsSubGraph.entrySet()) {
			if (copyTrace.getKey() instanceof Node) {
				Mapping lhsToRhs = HenshinFactory.eINSTANCE.createMapping();
				lhsToRhs.setOrigin((Node) copyTrace.getKey());
				lhsToRhs.setImage((Node) copyTrace.getValue());
				subMatchingRule.getMappings().add(lhsToRhs);
			}
		}
		
		// Calculate the pre-match:
		Match objectPreMatch = new MatchImpl(subMatchingRule); 
		
		for (Entry<Node, Node> nodeMatch : preMatch.entrySet()) {
			Node subGraphNode = nodeMatch.getKey();
			Node superGraphNode = nodeMatch.getValue();
			
			EObject superGraphNodeObject = superObjectGraph.getNode2ObjectMap().get(superGraphNode);
			objectPreMatch.setNodeTarget(subGraphNode, superGraphNodeObject);
		}
		
		// Setup matching engine:
		Engine engine = new EngineImpl();
		Iterator<Match> matchFinder = engine.findMatches(subMatchingRule, superObjectGraph, objectPreMatch).iterator();
		
		// Search for embeddings:
		List<Map<Node, Node>> graphEmbeddings = new ArrayList<>();
		
		while (matchFinder.hasNext()) {
			Match match = matchFinder.next();
			
			Map<Node, Node> graphEmbedding = new HashMap<>();
			graphEmbeddings.add(graphEmbedding);

			for (Node subGraphNode : subGraph.getNodes()) {
				EObject superGraphNodeDummy = match.getNodeTarget(subGraphNode);
				Node superGraphNode = superObjectGraph.getObject2NodeMap().get(superGraphNodeDummy);
				
				graphEmbedding.put(subGraphNode, superGraphNode);
			}
		}
		
		return graphEmbeddings;
	}
}
