package org.sidiff.common.henshin.view;

import static org.sidiff.common.henshin.HenshinConditionAnalysis.getEmbeddedAttributes;
import static org.sidiff.common.henshin.HenshinConditionAnalysis.getEmbeddedEdges;
import static org.sidiff.common.henshin.HenshinConditionAnalysis.getEmbeddedNodes;
import static org.sidiff.common.henshin.HenshinMultiRuleAnalysis.getEmbeddedAttributes;
import static org.sidiff.common.henshin.HenshinMultiRuleAnalysis.getEmbeddedEdges;
import static org.sidiff.common.henshin.HenshinMultiRuleAnalysis.getEmbeddedNodes;
import static org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx.getLHSMinusRHSEdges;
import static org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx.getLHSMinusRHSNodes;
import static org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx.getLHStoRHSChangingAttributes;
import static org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx.getPreservedAttributes;
import static org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx.getPreservedEdges;
import static org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx.getPreservedNodes;
import static org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx.getRHSChangingAttributes;
import static org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx.getRHSMinusLHSEdges;
import static org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx.getRHSMinusLHSNodes;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.henshin.model.Attribute;
import org.eclipse.emf.henshin.model.Edge;
import org.eclipse.emf.henshin.model.NestedCondition;
import org.eclipse.emf.henshin.model.Node;
import org.eclipse.emf.henshin.model.Rule;
import org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx;

/**
 * Views a graph transformation rule like the Henshin diagram editor (cached).
 *
 * @author Manuel Ohrndorf
 */
public class ActionGraph {
	
	// TODO: Add nested multi-rules as nested action graphs.

	/**
	 * The corresponding Henshin rule.
	 */
	private Rule rule;
	
	/**
	 *  Filter all embedded << create / delete / preserve  >> multi-nodes / -edges / -attributes
	 *  and all embedded << forbid / require >> nodes / edges / attributes.
	 */
	private boolean filterEmbeddedNodes = false;
	
	/**
	 * All << preserve >> nodes.
	 */
	private List<NodePair> preserveNodes;
	
	/**
	 * All << preserve >> edges.
	 */
	private List<EdgePair> preserveEdges;
	
	/**
	 * All << delete >> edges.
	 */
	private List<Node> deleteNodes;
	
	/**
	 * All << delete >> edges.
	 */
	private List<Edge> deleteEdges;
	
	/**
	 * All << create >> nodes.
	 */
	private List<Node> createNodes;

	/**
	 * All << create >> edges.
	 */
	private List<Edge> createEdges;
	
	/**
	 * All << forbid >> nodes. 
	 */
	private List<Node> forbidNodes;
	
	/**
	 * All << forbid >> edges.
	 */
	private List<Edge> forbidEdges;

	/**
	 * All << require >> nodes.
	 */
	private List<Node> requireNodes;
	
	/**
	 * All << require >> edges.
	 */
	private List<Edge> requireEdges;
	
	/**
	 * All << preserve / delete >> attributes.
	 */
	private List<Attribute> preserveAttributes;
	
	/**
	 * All valueX -> valueY attributes.
	 */
	private List<AttributePair> changeAttributes;
	
	/**
	 * All << create >> attributes.
	 */
	private List<Attribute> setAttributes;
	
	/**
	 * All << forbid >> attributes.
	 */
	private List<Attribute> forbidAttributes;
	
	/**
	 * All << require >> attributes.
	 */
	private List<Attribute> requireAttributes;
	
	/*
	 * Embedded nodes / edges / attributes
	 */
	
	/**
	 * All << create / delete / preserve >> embedded multi-nodes
	 * (including boundary nodes). The set is used as a filter.
	 */
	private Set<Node> embeddedMultiNode;
	
	/**
	 * All << forbid / require >> embedded nested nodes of all nested conditions.
	 * (including boundary nodes). The set is used as a filter.
	 */
	private Set<Node> embeddedNestedNodes;
	
	/**
	 * All << create / delete / preserve >> embedded multi-edges. 
	 * The set is used as a filter.
	 */
	private Set<Edge> embeddedMultiEdges;
	
	/**
	 * All << forbid / require >> embedded nested edges of all nested conditions. 
	 * The set is used as a filter.
	 */
	private Set<Edge> embeddedNestedEdges;
	
	/**
	 * All << create / delete / preserve  >> embedded multi-attributes. 
	 * The set is used as a filter.
	 */
	private Set<Attribute> embeddedMultiAttributes;
	
	/**
	 * All << forbid / require >> embedded nested attributes of all nested conditions.
	 * The set is used as a filter.
	 */
	private Set<Attribute> embeddedNestedAttributes;
	
	// TODO: Support for multi-nodes
	
	/**
	 * Initializes a new 'action graph' that views the rule like the Henshin diagram editor (cached).
	 * 
	 * @param rule
	 *            The corresponding henshin rule.
	 * @param filterEmbeddedNodes
	 *            Filter all embedded << create / delete / preserve  >> multi-nodes / -edges / -attributes
	 *            and all embedded << forbid / require >> nodes / edges / attributes.
	 */
	public ActionGraph(Rule rule, boolean filterEmbeddedNodes) {
		this.rule = rule;
		this.filterEmbeddedNodes = filterEmbeddedNodes;
	}

	/**
	 * @return The corresponding henshin rule.
	 */
	public Rule getRule() {
		return rule;
	}

	/**
	 * @return All << preserve >> nodes.
	 */
	public List<NodePair> getPreserveNodes() {
		
		if (preserveNodes == null) {
			preserveNodes = getPreservedNodes(rule);
			
			if (filterEmbeddedNodes) {
				NodePair.removeAll(preserveNodes, getEmbeddedMultiNodes());
			}
		}
		
		return preserveNodes;
	}

	/**
	 * @return All << preserve >> edges.
	 */
	public List<EdgePair> getPreserveEdges() {
		
		if (preserveEdges == null) {
			preserveEdges = getPreservedEdges(rule);
			
			if (filterEmbeddedNodes) {
				EdgePair.removeAll(preserveEdges, getEmbeddedMultiEdges());
			}
		}
		
		return preserveEdges;
	}

	/**
	 * @return All << delete >> nodes.
	 */
	public List<Node> getDeleteNodes() {
		
		if (deleteNodes == null) {
			deleteNodes = getLHSMinusRHSNodes(rule);
			
			if (filterEmbeddedNodes) {
				deleteNodes.removeAll(getEmbeddedMultiNodes());
			}
		}
		
		return deleteNodes;
	}

	/**
	 * @return All << delete >> edges.
	 */
	public List<Edge> getDeleteEdges() {
		
		if (deleteEdges == null) {
			deleteEdges = getLHSMinusRHSEdges(rule);
			
			if (filterEmbeddedNodes) {
				deleteEdges.removeAll(getEmbeddedMultiEdges());
			}
		}
		
		return deleteEdges;
	}

	/**
	 * @return All << create >> nodes.
	 */
	public List<Node> getCreateNodes() {
		
		 if (createNodes == null) {
			 createNodes = getRHSMinusLHSNodes(rule);
			 
				if (filterEmbeddedNodes) {
					createNodes.removeAll(getEmbeddedMultiNodes());
				}
		 }
		
		return createNodes;
	}

	/**
	 * @return All << create >> edges.
	 */
	public List<Edge> getCreateEdges() {
		
		if (createEdges == null) {
			createEdges = getRHSMinusLHSEdges(rule);
			
			if (filterEmbeddedNodes) {
				createEdges.removeAll(getEmbeddedMultiEdges());
			}
		}
		
		return createEdges;
	}

	/**
	 * @return All << forbid >> nodes.
	 */
	public List<Node> getForbidNodes() {
		
		if (forbidNodes == null) {
			forbidNodes  = HenshinRuleAnalysisUtilEx.getForbidNodes(rule);
			
			if (filterEmbeddedNodes) {
				forbidNodes.removeAll(getEmbeddedNestedNodes());
			}
		}
		
		return forbidNodes;
	}

	/**
	 * @return All << forbid >> edges.
	 */
	public List<Edge> getForbidEdges() {
		
		if (forbidEdges == null) {
			forbidEdges  = HenshinRuleAnalysisUtilEx.getForbidEdges(rule);
			
			if (filterEmbeddedNodes) {
				forbidEdges.removeAll(getEmbeddedNestedEdges());
			}
		}
		
		return forbidEdges;
	}

	/**
	 * @return All << require >> nodes.
	 */
	public List<Node> getRequireNodes() {
		
		if (requireNodes == null) {
			requireNodes = HenshinRuleAnalysisUtilEx.getRequireNodes(rule);
			
			if (filterEmbeddedNodes) {
				requireNodes.removeAll(getEmbeddedNestedNodes());
			}
		}
		
		return requireNodes;
	}

	/**
	 * @return All << require >> edges.
	 */
	public List<Edge> getRequireEdges() {
		
		if (requireEdges == null) {
			requireEdges = HenshinRuleAnalysisUtilEx.getRequireEdges(rule);
			
			if (filterEmbeddedNodes) {
				requireEdges.removeAll(getEmbeddedNestedEdges());
			}
		}
		
		return requireEdges;
	}

	/**
	 * @return All << preserve / delete >> attributes.
	 */
	public List<Attribute> getPreserveAttributes() {
		
		if (preserveAttributes == null) {
			preserveAttributes = getPreservedAttributes(rule);
			
			if (filterEmbeddedNodes) {
				preserveAttributes.removeAll(getEmbeddedMultiAttributes());
			}
		}
		
		return preserveAttributes;
	}

	/**
	 * @return All valueX -> valueY attributes (=> << change >>).
	 */
	public List<AttributePair> getChangeAttributes() {
		
		if (changeAttributes == null) {
			changeAttributes = getLHStoRHSChangingAttributes(rule);
			
			if (filterEmbeddedNodes) {
				AttributePair.removeAll(changeAttributes, getEmbeddedMultiAttributes());
			}
		}
		
		return changeAttributes;
	}

	/**
	 * @return All << create >> attributes (=> << set >>).
	 */
	public List<Attribute> getSetAttributes() {
		
		if (setAttributes == null) {
			setAttributes = getRHSChangingAttributes(rule);
			
			if (filterEmbeddedNodes) {
				setAttributes.removeAll(getEmbeddedMultiAttributes());
			}
		}
		
		return setAttributes;
	}

	/**
	 * @return All << forbid >> attributes.
	 */
	public List<Attribute> getForbidAttributes() {
		
		if (forbidAttributes == null) {
			forbidAttributes = HenshinRuleAnalysisUtilEx.getForbidAttributes(rule);
			
			if (filterEmbeddedNodes) {
				forbidAttributes.removeAll(getEmbeddedNestedAttributes());
			}
		}
		
		return forbidAttributes;
	}

	/**
	 * @return All << require >> attributes.
	 */
	public List<Attribute> getRequireAttributes() {
		
		if (requireAttributes == null) {
			requireAttributes = HenshinRuleAnalysisUtilEx.getRequireAttributes(rule);
			
			if (filterEmbeddedNodes) {
				requireAttributes.removeAll(getEmbeddedNestedAttributes());
			}
		}
		
		return requireAttributes;
	}
	
	/**
	 * Searches for all embedded multi-nodes (including boundary nodes). This
	 * nodes are invisible in the Henshin diagram editor.
	 * 
	 * @return All << create / delete / preserve >> embedded multi-nodes.
	 */
	public Set<Node> getEmbeddedMultiNodes() {
		
		// Search embedded multi-nodes:
		if (embeddedMultiNode == null) {
			embeddedMultiNode = Collections.emptySet();

			if (rule.isMultiRule()) {
				embeddedMultiNode = getEmbeddedNodes(rule);
			}
		}
		
		return embeddedMultiNode;
	}
	
	/**
	 * Searches for all embedded nested nodes (including boundary nodes) of all
	 * nested conditions. This nodes are invisible in the Henshin diagram editor.
	 * 
	 * @return All << forbid / require >> embedded nested nodes.
	 */
	public Set<Node> getEmbeddedNestedNodes() {
		
		// Search embedded multi-nodes:
		if (embeddedNestedNodes == null) {
			embeddedNestedNodes = Collections.emptySet();
			
			for (NestedCondition nestedCond : rule.getLhs().getNestedConditions()) {
				embeddedNestedNodes = getEmbeddedNodes(nestedCond);
			}
		}
		
		return embeddedNestedNodes;
	}

	/**
	 * Searches for all embedded multi-edges. This edges are invisible in the
	 * Henshin diagram editor.
	 * 
	 * @return All << create / delete / preserve >> embedded multi-edges.
	 */
	public Set<Edge> getEmbeddedMultiEdges() {
		
		// Search embedded multi-nodes:
		if (embeddedMultiEdges == null) {
			embeddedMultiEdges = Collections.emptySet();

			if (rule.isMultiRule()) {
				embeddedMultiEdges = getEmbeddedEdges(rule, getEmbeddedMultiNodes());
			}
		}
		
		return embeddedMultiEdges;
	}
	
	/**
	 * Searches for all embedded nested edges of all nested conditions. This
	 * edges are invisible in the Henshin diagram editor.
	 * 
	 * @return All << forbid / require >> embedded nested edges.
	 */
	public Set<Edge> getEmbeddedNestedEdges() {
		
		// Search embedded multi-nodes:
		if (embeddedNestedEdges == null) {
			embeddedNestedEdges = Collections.emptySet();
			
			for (NestedCondition nestedCond : rule.getLhs().getNestedConditions()) {
				embeddedNestedEdges = getEmbeddedEdges(nestedCond, getEmbeddedNestedNodes());
			}
		}
		
		return embeddedNestedEdges;
	}
	
	/**
	 * Searches for all embedded multi-attributes. This attributes are invisible
	 * in the Henshin diagram editor.
	 * 
	 * @return All << create / delete / preserve >> embedded multi-attributes.
	 */
	public Set<Attribute> getEmbeddedMultiAttributes() {
		
		// Search embedded multi-nodes:
		if (embeddedMultiAttributes == null) {
			embeddedMultiAttributes = Collections.emptySet();

			if (rule.isMultiRule()) {
				embeddedMultiAttributes = getEmbeddedAttributes(rule, getEmbeddedMultiNodes());
			}
		}
		
		return embeddedMultiAttributes;
	}
	
	/**
	 * Searches for all embedded nested attributes of all nested conditions. This
	 * attributes are invisible in the Henshin diagram editor.
	 * 
	 * @return All << forbid / require >> embedded nested attributes.
	 */
	public Set<Attribute> getEmbeddedNestedAttributes() {
		
		// Search embedded multi-nodes:
		if (embeddedNestedAttributes == null) {
			embeddedNestedAttributes = Collections.emptySet();
			
			for (NestedCondition nestedCond : rule.getLhs().getNestedConditions()) {
				embeddedNestedAttributes = getEmbeddedAttributes(nestedCond, getEmbeddedNestedNodes());
			}
		}
		
		return embeddedNestedAttributes;
	}
}
