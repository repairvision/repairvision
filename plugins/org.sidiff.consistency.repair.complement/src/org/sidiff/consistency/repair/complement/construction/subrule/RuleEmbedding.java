package org.sidiff.consistency.repair.complement.construction.subrule;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.henshin.model.Edge;
import org.eclipse.emf.henshin.model.Node;
import org.eclipse.emf.henshin.model.Rule;

public class RuleEmbedding {

	private Rule superRule;
	
	private Rule subRule;
	
	/**
	 * LHS-Nodes: Sub-Rule -> Super-Rule
	 */
	private Map<Node, Node> lhsNodeEmbedding = new HashMap<>();
	
	/**
	 * LHS-Edges: Sub-Rule -> Super-Rule
	 */
	private Map<Edge, Edge> lhsEdgeEmbedding = new HashMap<>();
	
	/**
	 * RHS-Nodes: Sub-Rule -> Super-Rule
	 */
	private Map<Node, Node> rhsNodeEmbedding = new HashMap<>();
	
	/**
	 * RHS-Nodes: Sub-Rule -> Super-Rule
	 */
	private Map<Edge, Edge> rhsEdgeEmbedding = new HashMap<>();

	public RuleEmbedding(Rule superRule, Rule subRule) {
		super();
		this.superRule = superRule;
		this.subRule = subRule;
	}

	public Rule getSuperRule() {
		return superRule;
	}

	public void setSuperRule(Rule superRule) {
		this.superRule = superRule;
	}

	public Rule getSubRule() {
		return subRule;
	}

	public void setSubRule(Rule subRule) {
		this.subRule = subRule;
	}

	public Map<Node, Node> getLhsNodeEmbedding() {
		return lhsNodeEmbedding;
	}

	public void setLhsNodeEmbedding(Map<Node, Node> lhsNodeEmbedding) {
		this.lhsNodeEmbedding = lhsNodeEmbedding;
	}

	public Map<Edge, Edge> getLhsEdgeEmbedding() {
		return lhsEdgeEmbedding;
	}

	public void setLhsEdgeEmbedding(Map<Edge, Edge> lhsEdgeEmbedding) {
		this.lhsEdgeEmbedding = lhsEdgeEmbedding;
	}

	public Map<Node, Node> getRhsNodeEmbedding() {
		return rhsNodeEmbedding;
	}

	public void setRhsNodeEmbedding(Map<Node, Node> rhsNodeEmbedding) {
		this.rhsNodeEmbedding = rhsNodeEmbedding;
	}

	public Map<Edge, Edge> getRhsEdgeEmbedding() {
		return rhsEdgeEmbedding;
	}

	public void setRhsEdgeEmbedding(Map<Edge, Edge> rhsEdgeEmbedding) {
		this.rhsEdgeEmbedding = rhsEdgeEmbedding;
	}

	public Node getSuperRuleNode(Node subRuleNode) {
		Node superRuleNode = lhsNodeEmbedding.get(subRuleNode);
		
		if (superRuleNode == null) {
			superRuleNode =  rhsNodeEmbedding.get(subRuleNode);
		}
		
		return superRuleNode;
	}

	public Edge getSuperRuleEdge(Edge subRuleEdge) {
		Edge superRuleEdge = lhsEdgeEmbedding.get(subRuleEdge);
		
		if (superRuleEdge == null) {
			superRuleEdge =  rhsEdgeEmbedding.get(subRuleEdge);
		}
		
		return superRuleEdge;
	}
}
