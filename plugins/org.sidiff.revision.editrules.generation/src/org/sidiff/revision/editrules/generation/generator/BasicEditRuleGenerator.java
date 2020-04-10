package org.sidiff.revision.editrules.generation.generator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.emf.common.util.EList;
import org.sidiff.graphpattern.AttributePattern;
import org.sidiff.graphpattern.EdgePattern;
import org.sidiff.graphpattern.GraphElement;
import org.sidiff.graphpattern.GraphPattern;
import org.sidiff.graphpattern.NodePattern;
import org.sidiff.graphpattern.profile.constraints.util.ConstraintProfileUtil;
import org.sidiff.revision.editrules.generation.generator.util.GraphPatternGeneratorUtil;

/**
 * Generates edit rules by a given pre- and post-graph-pattern. The graphs
 * formulate pre-state that should be transformed into a post-state. Therefore,
 * a partial mapping between the graph can be given.
 * 
 * @author Manuel Ohrndorf
 */
public abstract class BasicEditRuleGenerator {

	protected Map<NodePattern, NodePattern> matchPreToPost;

	protected Map<NodePattern, NodePattern> matchPostToPre;

	protected GraphPattern preGraph;

	protected GraphPattern postGraph;

	public BasicEditRuleGenerator(GraphPattern preGraph, GraphPattern postGraph, Map<NodePattern, NodePattern> match) {
		this.matchPreToPost = match;
		this.matchPostToPre = new HashMap<>();

		for (Entry<NodePattern, NodePattern> preToPost : match.entrySet()) {
			matchPostToPre.put(preToPost.getValue(), preToPost.getKey());
		}

		this.preGraph = preGraph;
		this.postGraph = postGraph;
	}

	protected boolean graphContains(GraphPattern graph, GraphElement element) {
		return element.getGraph() == graph;
	}

	public void generate(List<NodePattern> preFragment, List<NodePattern> postFragment) {

		// << delete/forbid/modify/preserve/require >>:
		for (NodePattern preNode : preFragment) {
			NodePattern postNode = getNodeMatchInToGraph(preNode);

			if (isContext(preNode, postNode)) {
				transformToPreContext(preNode, postNode);
			} else if (isCondition(preNode)) {
				transformToPrecondition(preNode);
			} else {
				transformToDelete(preNode);
			}
		}

		// << create/forbid/preserve(post)/require >>:
		for (NodePattern postNode : postFragment) {
			NodePattern preNode = getNodeMatchInFromGraph(postNode);

			if (isContext(preNode, postNode)) {
				transformToPostContext(preNode, postNode);
			} else if (isCondition(postNode)) {
				transformToPostcondition(postNode);
			} else {
				transformToCreate(postNode);
			}
		}
	}

	private void transformToPreContext(NodePattern preNode, NodePattern postNode) {

		// << preserve >> node
		if (postNode != null) {
			generateContext(preNode, postNode);
		} else {
			generatePreContext(preNode);
		}

		// Pre edges << forbid/require/delete/preserve >>:
		for (EdgePattern preEdge : preNode.getOutgoings()) {
			EdgePattern postEdge = (postNode != null) ? getEdgeMatchInToGraph(preEdge, postNode.getOutgoings()) : null;

			if (isContext(preEdge, postEdge)) {
				generateContext(preEdge, postEdge);
			} else if (isCondition(preEdge) || isUnmodifiable(preEdge)) {

				// NOTE: Consider unmodifiable without stereotyps as 'exists'.
				if (isExists(preEdge) || preEdge.getStereotypes().isEmpty()) {
					generateRequirePrecondition(preEdge);
				} else if (isNot(preEdge)) {
					generateForbidPrecondition(preEdge);
				}
			} else {
				generateDelete(preEdge);
			}
		}

		// Pre attributes << forbid/require/modify/preserve >>:
		for (AttributePattern preAttribute : preNode.getAttributes()) {
			AttributePattern postAttribute = (postNode != null)
					? getAttributeMatch(preAttribute, postNode.getAttributes(), false)
					: null;
					
			if (isContext(preAttribute, postAttribute)) {			// mapped attribute
				generateContext(preAttribute, postAttribute);
			} else if (isModify(preAttribute, postAttribute)) {		// mapped attribute or no post-attribute
				if (postAttribute == null) {
					// NOTE: The pre-value can be set to any post-value.
					generateModify(preAttribute, generateParameterName(preAttribute));
				} else {
					// NOTE: If the LHS requires some attribute value and the RHS not
					// then the RHS can be set to any value (x -> parameter).
					generateModify(preAttribute, postAttribute.getValue());
				}
			} else if (isCondition(preAttribute) || isUnmodifiable(preAttribute)) {

				// NOTE: Consider unmodifiable without stereotyps as 'exists'.
				if (isExists(preAttribute) || preAttribute.getStereotypes().isEmpty()) {
					generateRequirePrecondition(preAttribute);
				} else if (isNot(preAttribute)) {
					generateForbidPrecondition(preAttribute);
				}
			}
		}
	}

	private void transformToPostContext(NodePattern preNode, NodePattern postNode) {

		// << preserve (post) >> node
		if (preNode == null) {
			generatePostContext(postNode);
		}

		// Post edges << forbid/require/create >>
		for (EdgePattern postEdge : postNode.getOutgoings()) {
			EdgePattern preEdge = (preNode != null) ? getEdgeMatchInFromGraph(postEdge, preNode.getOutgoings()) : null;

			// Mapping are already processed.
			if (preEdge == null) {
				if (isUnmodifiable(postEdge) || isCondition(postEdge)) {

					// << forbid/require >> edge:
					// NOTE: Consider unmodifiable without stereotyps as 'exists'.
					if (isExists(postEdge) || postEdge.getStereotypes().isEmpty()) {
						generateRequirePostcondition(postEdge);
					} else if (isNot(postEdge)) {
						generateForbidPostcondition(postEdge);
					}
				} else {

					// << create >> edge:
					generateCreate(postEdge);
				}
			}
		}

		// Post edges << forbid/require/create >>:
		for (AttributePattern postAttribute : postNode.getAttributes()) {
			AttributePattern preAttribute = (preNode != null)
					? getAttributeMatch(postAttribute, preNode.getAttributes(), false)
					: null;

			// Mapping are already processed.
			if (preAttribute == null) {
				if (isUnmodifiable(postAttribute) || isCondition(postAttribute)) {

					// << forbid/require >> attribute:
					// NOTE: Consider unmodifiable without stereotyps as 'exists'.
					if (isExists(postAttribute) || postAttribute.getStereotypes().isEmpty()) {
						generateRequirePostcondition(postAttribute);
					} else if (isNot(postAttribute)) {
						generateForbidPostcondition(postAttribute);
					}
				} else {

					// << create >> attribute:
					generateCreate(postAttribute);
				}
			}
		}
	}

	private void transformToDelete(NodePattern preNode) {

		// << delete >> node
		generateDelete(preNode);

		for (EdgePattern preEdge : preNode.getOutgoings()) {
			if (isCondition(preEdge) || isUnmodifiable(preEdge)) {

				// << forbid/require >> edge:
				// NOTE: Consider unmodifiable without stereotyps as 'exists'.
				if (isExists(preEdge) || preEdge.getStereotypes().isEmpty()) {
					generateRequirePrecondition(preEdge);
				} else if (isNot(preEdge)) {
					generateForbidPrecondition(preEdge);
				}
			} else {

				// << delete >> edge:
				generateDelete(preEdge);
			}
		}

		for (AttributePattern preAttribute : preNode.getAttributes()) {
			if (isCondition(preAttribute) || isUnmodifiable(preAttribute)) {

				// << forbid/require >> attribute:
				// NOTE: Consider unmodifiable without stereotyps as 'exists'.
				if (isExists(preAttribute) || preAttribute.getStereotypes().isEmpty()) {
					generateRequirePrecondition(preAttribute);
				} else if (isNot(preAttribute)) {
					generateForbidPrecondition(preAttribute);
				}
			} else {

				// << delete >> attribute:
				generateDelete(preAttribute);
			}
		}
	}

	private void transformToCreate(NodePattern postNode) {

		// << create >> node
		generateCreate(postNode);

		for (EdgePattern postEdge : postNode.getOutgoings()) {
			if (isCondition(postEdge)) {
				// << forbid/require >> edge:
				if (isExists(postEdge)) {
					generateRequirePostcondition(postEdge);
				} else if (isNot(postEdge)) {
					generateForbidPostcondition(postEdge);
				}
			} else {

				// << create >> edge:
				generateCreate(postEdge);
			}
		}

		for (AttributePattern postAttribute : postNode.getAttributes()) {
			if (isCondition(postAttribute)) {

				// << forbid/require >> attribute:
				if (isExists(postAttribute)) {
					generateRequirePostcondition(postAttribute);
				} else if (isNot(postAttribute)) {
					generateForbidPostcondition(postAttribute);
				}
			} else {

				// << create >> attribute:
				generateCreate(postAttribute);
			}
		}
	}

	private void transformToPrecondition(NodePattern preNode) {

		// << forbid/require >> attribute:
		if (isExists(preNode)) {
			generateRequirePrecondition(preNode);
		} else if (isNot(preNode)) {
			generateForbidPrecondition(preNode);
		}

		// << forbid/require >> edges:
		for (EdgePattern preEdge : preNode.getOutgoings()) {
			if (isExists(preEdge)) {
				generateRequirePrecondition(preEdge);
			} else if (isNot(preEdge)) {
				generateForbidPrecondition(preEdge);
			}
		}

		// << forbid/require >> attributes:
		for (AttributePattern preAttribute : preNode.getAttributes()) {
			if (isExists(preAttribute)) {
				generateRequirePrecondition(preAttribute);
			} else if (isNot(preAttribute)) {
				generateForbidPrecondition(preAttribute);
			}
		}
	}

	private void transformToPostcondition(NodePattern postNode) {

		// << forbid/require >> node:
		if (isExists(postNode)) {
			generateRequirePostcondition(postNode);
		} else if (isNot(postNode)) {
			generateForbidPostcondition(postNode);
		}

		// << forbid/require >> edges:
		for (EdgePattern postEdge : postNode.getOutgoings()) {
			if (isExists(postEdge)) {
				generateRequirePostcondition(postEdge);
			} else if (isNot(postEdge)) {
				generateForbidPostcondition(postEdge);
			}
		}

		// << forbid/require >> attributes:
		for (AttributePattern postAttribute : postNode.getAttributes()) {
			if (isExists(postAttribute)) {
				generateRequirePostcondition(postAttribute);
			} else if (isNot(postAttribute)) {
				generateForbidPostcondition(postAttribute);
			}
		}
	}

	protected String generateParameterName(AttributePattern attribute) {
		return attribute.getNode().getName() + "_" + attribute.getType().getName();
	}

	protected abstract void generateCreate(NodePattern postNode);

	protected abstract void generateCreate(EdgePattern postEdge);

	protected abstract void generateCreate(AttributePattern postAttribute);

	protected abstract void generateDelete(NodePattern preNode);

	protected abstract void generateDelete(EdgePattern preEdge);

	protected abstract void generateDelete(AttributePattern preAttribute);

	protected abstract void generateModify(AttributePattern preAttribute, String postAttributeValue);

	protected abstract void generateContext(NodePattern preNode, NodePattern postNode);

	protected abstract void generatePreContext(NodePattern preNode);

	protected abstract void generatePostContext(NodePattern postNode);

	protected abstract void generateContext(EdgePattern preEdge, EdgePattern postEdge);

	protected abstract void generateContext(AttributePattern preAttribute, AttributePattern postAttribute);

	protected abstract void generateForbidPrecondition(NodePattern preNode);

	protected abstract void generateForbidPrecondition(EdgePattern preEdge);

	protected abstract void generateForbidPrecondition(AttributePattern preAttribute);

	protected abstract void generateRequirePrecondition(NodePattern preNode);

	protected abstract void generateRequirePrecondition(EdgePattern preEdge);

	protected abstract void generateRequirePrecondition(AttributePattern preAttribute);

	protected abstract void generateForbidPostcondition(NodePattern postNode);

	protected abstract void generateForbidPostcondition(EdgePattern postEdge);

	protected abstract void generateForbidPostcondition(AttributePattern postAttribute);

	protected abstract void generateRequirePostcondition(NodePattern postNode);

	protected abstract void generateRequirePostcondition(EdgePattern postEdge);

	protected abstract void generateRequirePostcondition(AttributePattern postAttribute);

	protected AttributePattern getAttributeMatch(AttributePattern attribute, EList<AttributePattern> otherAttributes,
			boolean checkValue) {
		for (AttributePattern otherAttribute : otherAttributes) {
			if (otherAttribute.getType() == attribute.getType()) {
				if (!checkValue || otherAttribute.getValue().equals(attribute.getValue())) {
					return otherAttribute;
				}
			}
		}
		return null;
	}

	/**
	 * Asserts that the source nodes are mapped!
	 */
	protected EdgePattern getEdgeMatchInFromGraph(EdgePattern postEdge, EList<EdgePattern> preEdges) {
		for (EdgePattern preEdge : preEdges) {
			if (preEdge.getType() == postEdge.getType()) {
				if (preEdge.getTarget().getType() == postEdge.getTarget().getType()) {
					if (getNodeMatchInToGraph(preEdge.getTarget()) == postEdge.getTarget()) {
						return preEdge;
					}
				}
			}
		}
		return null;
	}

	/**
	 * Asserts that the source nodes are mapped!
	 */
	protected EdgePattern getEdgeMatchInToGraph(EdgePattern preEdge, EList<EdgePattern> postEdges) {
		for (EdgePattern postEdge : postEdges) {
			if (postEdge.getType() == preEdge.getType()) {
				if (postEdge.getTarget().getType() == preEdge.getTarget().getType()) {
					if (getNodeMatchInFromGraph(postEdge.getTarget()) == preEdge.getTarget()) {
						return postEdge;
					}
				}
			}
		}
		return null;
	}

	protected NodePattern getNodeMatchInToGraph(NodePattern preNode) {
		return matchPreToPost.get(preNode);
	}

	protected NodePattern getNodeMatchInFromGraph(NodePattern postNode) {
		return matchPostToPre.get(postNode);
	}

	protected boolean isContext(NodePattern preNode, NodePattern postNode) {

		if (!isNegativeCondition(preNode) && !isNegativeCondition(postNode)) {

			// is mapped node?
			if ((preNode != null) && (postNode != null)) {
				return true;
			} else if (isContext(preNode) || isContext(postNode)) {
				return true;
			}
		}

		return false;
	}
	
	protected boolean isContext(NodePattern node) {
		if (!isNegativeCondition(node)) {
			return (node != null) && GraphPatternGeneratorUtil.isContext(node);
		}
		return false;		
	}
	
	protected boolean isContext(EdgePattern preEdge, EdgePattern postEdge) {

		if (!isNegativeCondition(preEdge) && !isNegativeCondition(postEdge)) {
			if (!isUnmodifiable(preEdge) && !isUnmodifiable(postEdge)) {	// interpret as condition
				
				// is mapped edge?
				if ((preEdge != null) && (postEdge != null)) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	protected boolean isContext(AttributePattern preAttribute, AttributePattern postAttribute) {

		if (!isNegativeCondition(preAttribute) && !isNegativeCondition(postAttribute)) {
			if (!isUnmodifiable(preAttribute) && !isUnmodifiable(postAttribute)) {	// interpret as condition
				
				// is mapped attribute?
				if ((preAttribute != null) && (postAttribute != null)) {
					if (preAttribute.getValue().equals(postAttribute.getValue())) {
						return true;
					}
				}
			}
		}
		
		return false;
	}
	
	protected boolean isModify(AttributePattern preAttribute, AttributePattern postAttribute) {

		if (!isNegativeCondition(preAttribute) && !isNegativeCondition(postAttribute)) {
			
			if (preAttribute != null) {
				
				// NOTE: no post-attribute allows any post-value => introduce parameter.
				if ((postAttribute == null) || !preAttribute.getValue().equals(postAttribute.getValue())) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	protected boolean isCondition(GraphElement graphElement) {
		return (graphElement != null) && ConstraintProfileUtil.isCondition(graphElement);
	}
	
	protected boolean isNot(GraphElement graphElement) {
		return (graphElement != null) && ConstraintProfileUtil.isNot(graphElement);
	}

	protected boolean isExists(GraphElement graphElement) {
		return (graphElement != null) && ConstraintProfileUtil.isExists(graphElement);
	}
	
	protected boolean isNegativeCondition(GraphElement graphElement) {
		return (graphElement != null) && ConstraintProfileUtil.isNegativeCondition(graphElement);
	}

	protected boolean isUnmodifiable(EdgePattern edge) {
		return (edge != null) && GraphPatternGeneratorUtil.isUnmodifiable(edge);
	}
	
	protected boolean isUnmodifiable(AttributePattern attribute) {
		return (attribute != null) && GraphPatternGeneratorUtil.isUnmodifiable(attribute);
	}

}
