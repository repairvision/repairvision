package org.sidiff.consistency.repair.complement.cpo.embedding;

import static org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx.getLHS;
import static org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx.getRHS;
import static org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx.getRHSMinusLHSEdges;
import static org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx.getRHSMinusLHSNodes;
import static org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx.isDeletionNode;
import static org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx.isPreservedNode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.henshin.interpreter.Engine;
import org.eclipse.emf.henshin.interpreter.Match;
import org.eclipse.emf.henshin.interpreter.impl.EngineImpl;
import org.eclipse.emf.henshin.interpreter.impl.MatchImpl;
import org.eclipse.emf.henshin.interpreter.util.HenshinEGraph;
import org.eclipse.emf.henshin.model.Edge;
import org.eclipse.emf.henshin.model.Graph;
import org.eclipse.emf.henshin.model.GraphElement;
import org.eclipse.emf.henshin.model.HenshinFactory;
import org.eclipse.emf.henshin.model.Mapping;
import org.eclipse.emf.henshin.model.Node;
import org.eclipse.emf.henshin.model.Rule;
import org.sidiff.consistency.common.debug.DebugUtil;
import org.sidiff.consistency.repair.complement.util.ComplementUtil;

/**
 * Calculates all possible embeddings of a sub-rule in a super-rule. 
 * 
 * @author Manuel Ohrndorf
 */
public class RuleEmbeddingCalculator {
	
	private enum Side {
		LHS, RHS
	}

	public static List<RuleEmbedding> calculateRuleEmbedding(Rule superRule, Rule subRule) {
		List<RuleEmbedding> embeddings = new ArrayList<>();
		
//		for (Iterator<EObject> iterator = superRule.eAllContents(); iterator.hasNext();) {
//			EObject element = iterator.next();
//
//			// FIXME: Support abstract node types in sub-rules!
//			if (element instanceof Node) {
//				if (((Node) element).getType().isAbstract()) {
//					MultiStatus info = new MultiStatus(Activator.PLUGIN_ID, 1,
//							"Edit-Rules with abstract node types are not suppored yet!", null);
//
//					info.add(new Status(IStatus.ERROR, Activator.PLUGIN_ID, 1, 
//							"Edit-Rule:\n\n" 
//									+ element + "\n\n"
//									+ EcoreUtil.getURI(element),
//									null));
//
//					Display.getDefault().asyncExec(() -> {
//						ErrorDialog.openError(
//								Display.getDefault().getActiveShell(), 
//								PlatformUI.getWorkbench().getActiveWorkbenchWindow().
//								getActivePage().getActivePart().getTitle(), 
//								null, info);
//					});
//
//					return Collections.emptyList();
//				}
//			}
//		}
		
		long embeddingTime = System.currentTimeMillis();
		
		// Calculate LHS-Embeddings:
		List<Map<Node, Node>> lhsEmbeddings = calculateGraphNodeEmbedding(superRule, subRule, Side.LHS);

		// Calculate RHS-Embeddings:
		for (Map<Node, Node> lhsEmbedding : lhsEmbeddings) {
			
			if (!filterLHSEmbedding(lhsEmbedding)) {
				
				// FIXME: What if RHS falls apart into sub-graphs?
				// Could result in duplicates if the RHS parts are identical!?
				Set<GraphElement> rhsMinimalSubGraph = getRHSMinimalSubGraph(subRule);
				
				if (!rhsMinimalSubGraph.isEmpty()) {
					
					// Calculate RHS embedding:
					List<Map<Node, Node>> rhsEmbeddings = calculateGraphNodeEmbedding(
							superRule, subRule, Side.RHS, lhsEmbedding, rhsMinimalSubGraph);
					
					// Fork embedding of each LHS for each matched RHS:
					for (Map<Node, Node> rhsEmbedding : rhsEmbeddings) {
						
						// Create rule-embedding:
						RuleEmbedding ruleEmbedding = new RuleEmbedding(superRule, subRule);
						embeddings.add(ruleEmbedding);
						
						// Node-embedding:
						ruleEmbedding.setLhsNodeEmbedding(lhsEmbedding);
						ruleEmbedding.setRhsNodeEmbedding(rhsEmbedding);
						
						// Calculate edge-embedding:
						ruleEmbedding.setLhsEdgeEmbedding(
								calculateGraphEdgeEmbedding(superRule.getLhs(), subRule.getLhs(), lhsEmbedding, null));
						ruleEmbedding.setRhsEdgeEmbedding(
								calculateGraphEdgeEmbedding(superRule.getRhs(), subRule.getRhs(), rhsEmbedding, rhsMinimalSubGraph));
					}
				} else {
					
					// Create single rule-embedding:
					RuleEmbedding ruleEmbedding = new RuleEmbedding(superRule, subRule);
					embeddings.add(ruleEmbedding);
					
					// Node-embedding:
					ruleEmbedding.setLhsNodeEmbedding(lhsEmbedding);
					
					// Calculate edge-embedding:
					ruleEmbedding.setLhsEdgeEmbedding(
							calculateGraphEdgeEmbedding(superRule.getLhs(), subRule.getLhs(), lhsEmbedding, null));
				}
			}
		}
		
		if (DebugUtil.statistic) {
			System.out.println("Embedding: " + (System.currentTimeMillis() - embeddingTime) + "ms");
//			System.out.println("  - CPO: " + superRule.getName());
//			System.out.println("  - Sub-EO: " + subRule.getName());
		}
		
		return embeddings;
	}
	
	/**
	 * @param subRule
	 *            The sub-rule.
	 * @return All graph elements of the RHS which are << create >> parts and
	 *         the minimal necessary << preserve >> context.
	 */
	private static Set<GraphElement> getRHSMinimalSubGraph(Rule subRule) {
		Set<GraphElement> rhsSubGraph = new HashSet<>();
		
		// Create nodes:
		rhsSubGraph.addAll(getRHSMinusLHSNodes(subRule));
		
		// Create edges:
		List<Edge> createEdges = getRHSMinusLHSEdges(subRule);
		rhsSubGraph.addAll(createEdges);
		
		// Context nodes:
		for (Edge createEdge : createEdges) {
			if (!rhsSubGraph.contains(createEdge.getSource())) {
				rhsSubGraph.add(createEdge.getSource());
			}
			if (!rhsSubGraph.contains(createEdge.getTarget())) {
				rhsSubGraph.add(createEdge.getTarget());
			}
		}
		
		return rhsSubGraph;
	}
	
	/**
	 * @param lhsEmbedding
	 *            The LHS embedding sub-rule -> source-rule.
	 * @return <code>true</code> if the rule should be filtered;
	 *         <code>false</code> otherwise.
	 */
	private static boolean filterLHSEmbedding(Map<Node, Node> lhsEmbedding) {

		for (Node subNode : lhsEmbedding.keySet()) {
			
			// Filter <<delete>> Sub-Rule -> << preserve >> Source-Rule:
			if (isDeletionNode(subNode)) {
				if (isPreservedNode(lhsEmbedding.get(subNode))) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	private static Map<Edge, Edge> calculateGraphEdgeEmbedding(
			Graph superGraph, Graph subGraph, 
			Map<Node, Node> embedding, Set<GraphElement> elementsToMatch) {
		
		Map<Edge, Edge> edgeEmbedings = new HashMap<>();
		
		for (Entry<Node, Node> nodeEmbedding : embedding.entrySet()) {
			Node subGraphSrcNode = nodeEmbedding.getKey();
			Node superGraphSrcNode = nodeEmbedding.getValue();
			
			for (Edge subGraphEdge : subGraphSrcNode.getOutgoing()) {
				
				// Filter edges:
				if ((elementsToMatch == null) || elementsToMatch.contains(subGraphEdge)) {
					Node subGraphTgtNode = subGraphEdge.getTarget();
					Node superGraphTgtNode = embedding.get(subGraphTgtNode);
					
					Edge superGraphEdge = superGraphSrcNode.getOutgoing(
							subGraphEdge.getType(), superGraphTgtNode);
					
					assert (superGraphEdge != null) : "Missing edge embedding: " + subGraphEdge;
					
					edgeEmbedings.put(subGraphEdge, superGraphEdge);
				}
			}
		}
		
		return edgeEmbedings;
	}
	
	/**
	 * @param side 
	 * @param superGraph
	 *            The greater super-graph.
	 * @param subGraph
	 *            The smaller sub-graph which will be matched against the super-graph.
	 * @return Match: Sub-Graph -> Super-Graph
	 */
	public static List<Map<Node, Node>> calculateGraphNodeEmbedding(Rule superRule, Rule subRule, Side side) {
		return calculateGraphNodeEmbedding(superRule, subRule, side, Collections.emptyMap(), null);
	}

	/**
	 * @param superRule
	 *            The greater super-rule.
	 * @param subRule
	 *            The smaller sub-rule which will be matched against the
	 *            super-rule.
	 * @param side
	 *            The considered site of the rules to match.
	 * @param preMatch
	 *            A pre-match: sub-graph -> super-graph
	 * @param elementsToMatch
	 *            A sub-graph of the considered graph side or <code>null</code>.
	 * @return Match: sub-graph -> super-graph
	 */
	public static List<Map<Node, Node>> calculateGraphNodeEmbedding(
			Rule superRule, Rule subRule, Side side, 
			Map<Node, Node> preMatch, Set<GraphElement> elementsToMatch) {
		
		// Match the sub-graph in the dummy working graph that is isomorph to the super-graph: 
		HenshinEGraph superObjectGraph = null;
		
		if (side.equals(Side.LHS)) {
			superObjectGraph = new HenshinEGraph(superRule.getLhs());
		} else {
			superObjectGraph = new HenshinEGraph(superRule.getRhs());
		}
		
		// Interpret the sub-graph as << preserve >> only rule:
		Map<EObject, EObject> subMatchingRuleCopy = ComplementUtil.deepCopy(subRule);
		Map<EObject, EObject> subGraphCopy = null;
		
		Rule subMatchingRule = (Rule) subMatchingRuleCopy.get(subRule);
		subMatchingRule.setName(subMatchingRule.getName() + "_copy");
		
		Graph subMatchingGraph = subMatchingRule.getLhs();
		Graph subGraph = subRule.getLhs();
		
		if (side.equals(Side.RHS)) {
			subMatchingGraph = subMatchingRule.getRhs();
			subGraph = subRule.getRhs();
		} 
		
		// Filter sub-graph for relevant elements:
		if (elementsToMatch != null) {
			for (Edge subEdge : subGraph.getEdges()) {
				if (!elementsToMatch.contains(subEdge)) {
					Edge subMatchingEdge = (Edge) subMatchingRuleCopy.get(subEdge);
					assert (subMatchingEdge != null);
					ComplementUtil.deleteEdge(subMatchingEdge);
				}
			}
			
			for (Node subNode : subGraph.getNodes()) {
				if (!elementsToMatch.contains(subNode)) {
					Node subMatchingNode = (Node) subMatchingRuleCopy.get(subNode);
					assert (subNode != null);
					ComplementUtil.deleteNode(subMatchingNode);
				}
			}
		}
		
		// Copy graph to make the graph sides equal:
		subGraphCopy = ComplementUtil.deepCopy(subMatchingGraph);
		
		if (side.equals(Side.LHS)) {
			subMatchingRule.setRhs((Graph) subGraphCopy.get(subMatchingGraph));
		} else {
			subMatchingRule.setLhs((Graph) subGraphCopy.get(subMatchingGraph));
		}
		
		// Calculate mappings:
		subMatchingRule.getMappings().clear();
		
		for (Entry<EObject, EObject> copyTrace : subGraphCopy.entrySet()) {
			if (copyTrace.getKey() instanceof Node) {
				Mapping lhsToRhs = HenshinFactory.eINSTANCE.createMapping();
				
				if (side.equals(Side.LHS)) {
					lhsToRhs.setOrigin((Node) copyTrace.getKey());
					lhsToRhs.setImage((Node) copyTrace.getValue());
				} else {
					lhsToRhs.setOrigin((Node) copyTrace.getValue());
					lhsToRhs.setImage((Node) copyTrace.getKey());
				}

				subMatchingRule.getMappings().add(lhsToRhs);
			}
		}
		
		// Calculate the pre-match:
		Match objectPreMatch = new MatchImpl(subMatchingRule); 
	
		for (Entry<Node, Node> nodeMatch : preMatch.entrySet()) {
			Node subGraphNode = nodeMatch.getKey();
			Node superGraphNode = nodeMatch.getValue();
			
			// Get the copied node:
			if (side.equals(Side.LHS)) {
				if (subGraphNode.getGraph().isRhs()) {
					subGraphNode = getLHS(subGraphNode);
				}
				if (superGraphNode.getGraph().isRhs()) {
					superGraphNode = getLHS(superGraphNode);
				}
				
				subGraphNode = (Node) subMatchingRuleCopy.get(subGraphNode);
			} else {
				if (subGraphNode.getGraph().isLhs()) {
					subGraphNode = getRHS(subGraphNode);
				}
				if (superGraphNode.getGraph().isLhs()) {
					superGraphNode = getRHS(superGraphNode);
				}
				
				subGraphNode = (Node) subGraphCopy.get(subMatchingRuleCopy.get(subGraphNode));
			}
			
			// Translate to object pre-match:
			if ((subGraphNode != null) && (superGraphNode != null)) {
				EObject superGraphNodeObject = superObjectGraph.getNode2ObjectMap().get(superGraphNode);
				objectPreMatch.setNodeTarget(subGraphNode, superGraphNodeObject);
			}
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
			
			// Embedding for LHS or RHS:
			Collection<Node> searchedNodes = null;
			
			if (side.equals(Side.LHS)) {
				searchedNodes = subRule.getLhs().getNodes();
			} else {
				searchedNodes = subRule.getRhs().getNodes();
			}
			
			// Create embedding:
			for (Node subGraphNode : searchedNodes) {
				if ((elementsToMatch == null) || (elementsToMatch.contains(subGraphNode))) {
					
					// Get the copied node:
					Node subMatchingNode = null; 
					
					if (side.equals(Side.LHS)) {
						subMatchingNode = (Node) subMatchingRuleCopy.get(subGraphNode);
					} else {
						subMatchingNode = (Node) subGraphCopy.get(subMatchingRuleCopy.get(subGraphNode));
					}
					
					assert (subMatchingNode != null);
					
					EObject superGraphNodeDummy = match.getNodeTarget(subMatchingNode);
					Node superGraphNode = superObjectGraph.getObject2NodeMap().get(superGraphNodeDummy);
					graphEmbedding.put(subGraphNode, superGraphNode);
				}
			}
		}
		
		return graphEmbeddings;
	}
}
