package org.sidiff.graphpattern.tools.editrules.generator;

import static org.sidiff.graphpattern.tools.editrules.generator.util.GraphPatternGeneratorUtil.*;
import static org.sidiff.graphpattern.tools.editrules.generator.util.GraphPatternGeneratorUtil.isNot;
import static org.sidiff.graphpattern.tools.editrules.generator.util.GraphPatternGeneratorUtil.isRequire;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.emf.common.util.EList;
import org.sidiff.graphpattern.AttributePattern;
import org.sidiff.graphpattern.EdgePattern;
import org.sidiff.graphpattern.GraphElement;
import org.sidiff.graphpattern.GraphPattern;
import org.sidiff.graphpattern.NodePattern;

public abstract class BasicEditRuleGenerator {
	
	protected Map<NodePattern, NodePattern> match;
	
	protected GraphPattern preGraph;
	
	protected GraphPattern postGraph;
	
	public BasicEditRuleGenerator(GraphPattern preGraph, GraphPattern postGraph, Map<NodePattern, NodePattern> match) {
		this.match = match;
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

			if (isConditionMatch(postNode, preNode)) {

				// << forbid/require >> attribute:
				if (isRequire(preNode)) {
					generateRequirePrecondition(preNode);
				} else if (isNot(preNode)) {
					generateForbidPrecondition(preNode);
				}

				// << forbid/require >> edges:
				for (EdgePattern preEdge : preNode.getOutgoings()) {
					if (isRequire(preEdge)) {
						generateRequirePrecondition(preEdge);
					} else if (isNot(preEdge)) {
						generateForbidPrecondition(preEdge);
					}
				}

				// << forbid/require >> attributes:
				for (AttributePattern preAttribute : preNode.getAttributes()) {
					if (isRequire(preAttribute)) {
						generateRequirePrecondition(preAttribute);
					} else if (isNot(preAttribute)) {
						generateForbidPrecondition(preAttribute);
					}
				}
			} else if ((postNode != null) || isContext(preNode)) {

				// << preserve >> node
				if (postNode != null) {
					generateContext(preNode, postNode);
				} else {
					generatePreContext(preNode);
				}

				for (EdgePattern preEdge : preNode.getOutgoings()) {
					EdgePattern postEdge = (postNode != null) ? getEdgeMatchInToGraph(preEdge, postNode.getOutgoings()) : null;
					
					if (isUnmodifiable(preEdge) || isConditionMatch(preEdge, postEdge)) {

						// << forbid/require >> edge:
						if (isRequire(preEdge)) {
							generateRequirePrecondition(preEdge);
						} else if (isNot(preEdge)) {
							generateForbidPrecondition(preEdge);
						}
					} else {

						// << delete/preserve >> edge:
						if (postEdge == null) {
							generateDelete(preEdge);
						} else {
							generateContext(preEdge, postEdge);
						}
					}
				}

				for (AttributePattern preAttribute : preNode.getAttributes()) {
					AttributePattern postAttribute = (postNode != null) ? getAttributeMatch(preAttribute, postNode.getAttributes(), false) : null;
					
					if (isUnmodifiable(preAttribute) || isConditionMatch(preAttribute, postAttribute)) {

						// << forbid/require >> attribute:
						if (isRequire(preAttribute)) {
							generateRequirePrecondition(preAttribute);
						} else if (isNot(preAttribute)) {
							generateForbidPrecondition(preAttribute);
						}
					} else {

						// << delete/preserve/modify >> attribute:
						if (postAttribute == null) {
							generateModify(preAttribute, generateParameterName(preAttribute));
						} else {
							if (preAttribute.getValue().equals(postAttribute.getValue())) {
								generateContext(preAttribute, postAttribute);
							} else {
								// NOTE: If the LHS requires some attribute value and the RHS not 
								//       then the RHS can be set to any value (x -> parameter).
								generateModify(preAttribute, postAttribute.getValue());
							}
						}
					}
				}
			} else {

				// << delete >> node
				generateDelete(preNode);

				for (EdgePattern preEdge : preNode.getOutgoings()) {
					if (isCondition(preEdge) || isUnmodifiable(preEdge)) {

						// << forbid/require >> edge:
						if (isRequire(preEdge)) {
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
						if (isRequire(preAttribute)) {
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
		}
		
		// << create/forbid/preserve(post)/require >>:
		for (NodePattern postNode : postFragment) {
			NodePattern preNode = getNodeMatchInFromGraph(postNode);
			
			// The single node or the matched nodes are conditions?
			if (isConditionMatch(preNode, postNode)) {
				
				// << forbid/require >> node:
				if (isRequire(postNode)) {
					generateRequirePostcondition(postNode);
				} else if (isNot(postNode)) {
					generateForbidPostcondition(postNode);
				}
				
				// << forbid/require >> edges:
				for (EdgePattern postEdge : postNode.getOutgoings()) {
					if (isRequire(postEdge)) {
						generateRequirePostcondition(postEdge);
					} else if (isNot(postEdge)) {
						generateForbidPostcondition(postEdge);
					}
				}
				
				// << forbid/require >> attributes:
				for (AttributePattern postAttribute : postNode.getAttributes()) {
					if (isRequire(postAttribute)) {
						generateRequirePostcondition(postAttribute);
					} else if (isNot(postAttribute)) {
						generateForbidPostcondition(postAttribute);
					}
				}
			} else if ((preNode != null) || isContext(postNode)) {

				// << preserve (post) >> node
				if (preNode == null) {
					generatePostContext(postNode);
				}

				for (EdgePattern postEdge : postNode.getOutgoings()) {
					EdgePattern preEdge = (preNode != null) ? getEdgeMatchInFromGraph(postEdge, preNode.getOutgoings()) : null;
					
					// Mapping are already processed.
					if (preEdge == null) {
						if (isUnmodifiable(postEdge) || isCondition(postEdge)) {
							
							// << forbid/require >> edge:
							if (isRequire(postEdge)) {
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

				for (AttributePattern postAttribute : postNode.getAttributes()) {
					AttributePattern preAttribute = (preNode != null) ? getAttributeMatch(postAttribute, preNode.getAttributes(), false) : null;
					
					// Mapping are already processed.
					if (preAttribute == null) {
						if (isUnmodifiable(postAttribute) || isCondition(postAttribute)) {
							
							// << forbid/require >> attribute:
							if (isRequire(postAttribute)) {
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
			} else {

				// << create >> node
				generateCreate(postNode);

				for (EdgePattern postEdge : postNode.getOutgoings()) {
					if (isCondition(postEdge)) 
					{
						// << forbid/require >> edge:
						if (isRequire(postEdge)) {
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
						if (isRequire(postAttribute)) {
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
	
	protected AttributePattern getAttributeMatch(AttributePattern attribute, EList<AttributePattern> otherAttributes, boolean checkValue) {
		for (AttributePattern otherAttribute : otherAttributes) {
			if (otherAttribute.getType() == attribute.getType()) {
				if (!checkValue || otherAttribute.getValue().equals(attribute.getValue())) {
					return otherAttribute;
				}
			}
		}
		return null;
	}

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
		return match.get(preNode);
	}
	
	protected NodePattern getNodeMatchInFromGraph(NodePattern postNode) {
		for (Entry<NodePattern, NodePattern> entry : match.entrySet()) {
			if (entry.getValue() == postNode) {
				return entry.getKey();
			}
		}
		return null;
	}
	
	/**
	 * @param preElement  A graph element or <code>null</code>.
	 * @param postElement A graph element or <code>null</code>.
	 * @return <code>true</code> if both given nodes are conditions;
	 *         <code>false</code> otherwise.
	 */
	protected boolean isConditionMatch(GraphElement preElement, GraphElement postElement) {
		return ((preElement == null) || isCondition(preElement)) && ((postElement == null) || isCondition(postElement));
	}
}
