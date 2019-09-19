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
	
	protected GraphPattern fromGraph;
	
	protected GraphPattern toGraph;
	
	public BasicEditRuleGenerator(GraphPattern fromGraph, GraphPattern toGraph, Map<NodePattern, NodePattern> match) {
		this.match = match;
		this.fromGraph = fromGraph;
		this.toGraph = toGraph;
	}
	
	protected boolean graphContains(GraphPattern graph, GraphElement element) {
		return element.getGraph() == graph;
	}
	
	public void generate(List<NodePattern> fromFragment, List<NodePattern> toFragment) {
		
		// << delete/forbid/modify/preserve/require >>:
		for (NodePattern fromNode : fromFragment) {
			NodePattern toNode = getNodeMatchInToGraph(fromNode);

			if (isConditionMatch(toNode, fromNode)) {

				// << forbid/require >> attribute:
				if (isRequire(fromNode)) {
					generateRequirePrecondition(fromNode);
				} else if (isNot(fromNode)) {
					generateForbidPrecondition(fromNode);
				}

				// << forbid/require >> edges:
				for (EdgePattern fromEdge : fromNode.getOutgoings()) {
					if (isRequire(fromEdge)) {
						generateRequirePrecondition(fromEdge);
					} else if (isNot(fromEdge)) {
						generateForbidPrecondition(fromEdge);
					}
				}

				// << forbid/require >> attributes:
				for (AttributePattern fromAttribute : fromNode.getAttributes()) {
					if (isRequire(fromAttribute)) {
						generateRequirePrecondition(fromAttribute);
					} else if (isNot(fromAttribute)) {
						generateForbidPrecondition(fromAttribute);
					}
				}
			} else if ((toNode != null) || isContext(fromNode)) {

				// << preserve >> node
				if (toNode != null) {
					generateContext(fromNode, toNode);
				} else {
					generatePreContext(fromNode);
				}

				for (EdgePattern fromEdge : fromNode.getOutgoings()) {
					EdgePattern toEdge = (toNode != null) ? getEdgeMatchInToGraph(fromEdge, toNode.getOutgoings()) : null;
					
					if (isUnmodifiable(fromEdge) || isConditionMatch(fromEdge, toEdge)) {

						// << forbid/require >> edge:
						if (isRequire(fromEdge)) {
							generateRequirePrecondition(fromEdge);
						} else if (isNot(fromEdge)) {
							generateForbidPrecondition(fromEdge);
						}
					} else {

						// << delete/preserve >> edge:
						if (toEdge == null) {
							generateDelete(fromEdge);
						} else {
							generateContext(fromEdge, toEdge);
						}
					}
				}

				for (AttributePattern fromAttribute : fromNode.getAttributes()) {
					AttributePattern toAttribute = (toNode != null) ? getAttributeMatch(fromAttribute, toNode.getAttributes(), false) : null;
					
					if (isUnmodifiable(fromAttribute) || isConditionMatch(fromAttribute, toAttribute)) {

						// << forbid/require >> attribute:
						if (isRequire(fromAttribute)) {
							generateRequirePrecondition(fromAttribute);
						} else if (isNot(fromAttribute)) {
							generateForbidPrecondition(fromAttribute);
						}
					} else {

						// << delete/preserve/modify >> attribute:
						if (toAttribute == null) {
							generateModify(fromAttribute, generateParameterName(fromAttribute));
						} else {
							if (fromAttribute.getValue().equals(toAttribute.getValue())) {
								generateContext(fromAttribute, toAttribute);
							} else {
								// NOTE: If the LHS requires some attribute value and the RHS not 
								//       then the RHS can be set to any value (x -> parameter).
								generateModify(fromAttribute, toAttribute.getValue());
							}
						}
					}
				}
			} else {

				// << delete >> node
				generateDelete(fromNode);

				for (EdgePattern fromEdge : fromNode.getOutgoings()) {
					if (isCondition(fromEdge) || isUnmodifiable(fromEdge)) {

						// << forbid/require >> edge:
						if (isRequire(fromEdge)) {
							generateRequirePrecondition(fromEdge);
						} else if (isNot(fromEdge)) {
							generateForbidPrecondition(fromEdge);
						}
					} else {

						// << delete >> edge:
						generateDelete(fromEdge);
					}
				}

				for (AttributePattern fromAttribute : fromNode.getAttributes()) {
					if (isCondition(fromAttribute) || isUnmodifiable(fromAttribute)) {

						// << forbid/require >> attribute:
						if (isRequire(fromAttribute)) {
							generateRequirePrecondition(fromAttribute);
						} else if (isNot(fromAttribute)) {
							generateForbidPrecondition(fromAttribute);
						}
					} else {

						// << delete >> attribute:
						generateDelete(fromAttribute);
					}
				}
			}
		}
		
		// << create/forbid/preserve(post)/require >>:
		for (NodePattern toNode : toFragment) {
			NodePattern fromNode = getNodeMatchInFromGraph(toNode);
			
			// The single node or the matched nodes are conditions?
			if (isConditionMatch(fromNode, toNode)) {
				
				// << forbid/require >> node:
				if (isRequire(toNode)) {
					generateRequirePostcondition(toNode);
				} else if (isNot(toNode)) {
					generateForbidPostcondition(toNode);
				}
				
				// << forbid/require >> edges:
				for (EdgePattern toEdge : toNode.getOutgoings()) {
					if (isRequire(toEdge)) {
						generateRequirePostcondition(toEdge);
					} else if (isNot(toEdge)) {
						generateForbidPostcondition(toEdge);
					}
				}
				
				// << forbid/require >> attributes:
				for (AttributePattern toAttribute : toNode.getAttributes()) {
					if (isRequire(toAttribute)) {
						generateRequirePostcondition(toAttribute);
					} else if (isNot(toAttribute)) {
						generateForbidPostcondition(toAttribute);
					}
				}
			} else if ((fromNode != null) || isContext(toNode)) {

				// << preserve (post) >> node
				if (fromNode == null) {
					generatePostContext(toNode);
				}

				for (EdgePattern toEdge : toNode.getOutgoings()) {
					EdgePattern fromEdge = (fromNode != null) ? getEdgeMatchInFromGraph(toEdge, fromNode.getOutgoings()) : null;
					
					// Mapping are already processed.
					if (fromEdge == null) {
						if (isUnmodifiable(toEdge) || isCondition(toEdge)) {
							
							// << forbid/require >> edge:
							if (isRequire(toEdge)) {
								generateRequirePostcondition(toEdge);
							} else if (isNot(toEdge)) {
								generateForbidPostcondition(toEdge);
							}
						} else {
							
							// << create >> edge:
							generateCreate(toEdge);
						}
					}
				}

				for (AttributePattern toAttribute : toNode.getAttributes()) {
					AttributePattern fromAttribute = (fromNode != null) ? getAttributeMatch(toAttribute, fromNode.getAttributes(), false) : null;
					
					// Mapping are already processed.
					if (fromAttribute == null) {
						if (isUnmodifiable(toAttribute) || isCondition(toAttribute)) {
							
							// << forbid/require >> attribute:
							if (isRequire(toAttribute)) {
								generateRequirePostcondition(toAttribute);
							} else if (isNot(toAttribute)) {
								generateForbidPostcondition(toAttribute);
							}
						} else {
							
							// << create >> attribute:
							generateCreate(toAttribute);
						}
					}
				}
			} else {

				// << create >> node
				generateCreate(toNode);

				for (EdgePattern toEdge : toNode.getOutgoings()) {
					if (isCondition(toEdge)) 
					{
						// << forbid/require >> edge:
						if (isRequire(toEdge)) {
							generateRequirePostcondition(toEdge);
						} else if (isNot(toEdge)) {
							generateForbidPostcondition(toEdge);
						}
					} else {

						// << create >> edge:
						generateCreate(toEdge);
					}
				}

				for (AttributePattern toAttribute : toNode.getAttributes()) {
					if (isCondition(toAttribute)) {

						// << forbid/require >> attribute:
						if (isRequire(toAttribute)) {
							generateRequirePostcondition(toAttribute);
						} else if (isNot(toAttribute)) {
							generateForbidPostcondition(toAttribute);
						}
					} else {

						// << create >> attribute:
						generateCreate(toAttribute);
					}
				}
			}
		}
	}
	
	protected String generateParameterName(AttributePattern attribute) {
		return attribute.getNode().getName() + "_" + attribute.getType().getName();
	}
	
	protected abstract void generateCreate(NodePattern toNode);
	
	protected abstract void generateCreate(EdgePattern toEdge);
	
	protected abstract void generateCreate(AttributePattern toAttribute);
	
	protected abstract void generateDelete(NodePattern fromNode);
	
	protected abstract void generateDelete(EdgePattern fromEdge);
	
	protected abstract void generateDelete(AttributePattern fromAttribute);
	
	protected abstract void generateModify(AttributePattern fromAttribute, String toAttributeValue);
	
	protected abstract void generateContext(NodePattern fromNode, NodePattern toNode);
	
	protected abstract void generatePreContext(NodePattern fromNode);
	
	protected abstract void generatePostContext(NodePattern toNode);
	
	protected abstract void generateContext(EdgePattern fromEdge, EdgePattern toEdge);
	
	protected abstract void generateContext(AttributePattern fromAttribute, AttributePattern toAttribute);
	
	protected abstract void generateForbidPrecondition(NodePattern fromNode);
	
	protected abstract void generateForbidPrecondition(EdgePattern fromEdge);
	
	protected abstract void generateForbidPrecondition(AttributePattern fromAttribute);
	
	protected abstract void generateRequirePrecondition(NodePattern fromNode);
	
	protected abstract void generateRequirePrecondition(EdgePattern fromEdge);
	
	protected abstract void generateRequirePrecondition(AttributePattern fromAttribute);
	
	protected abstract void generateForbidPostcondition(NodePattern toNode);
	
	protected abstract void generateForbidPostcondition(EdgePattern toEdge);
	
	protected abstract void generateForbidPostcondition(AttributePattern toAttribute);
	
	protected abstract void generateRequirePostcondition(NodePattern toNode);
	
	protected abstract void generateRequirePostcondition(EdgePattern toEdge);
	
	protected abstract void generateRequirePostcondition(AttributePattern toAttribute);
	
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

	protected EdgePattern getEdgeMatchInFromGraph(EdgePattern toEdge, EList<EdgePattern> fromEdges) {
		for (EdgePattern fromEdge : fromEdges) {
			if (fromEdge.getType() == toEdge.getType()) {
				if (fromEdge.getTarget().getType() == toEdge.getTarget().getType()) {
					if (getNodeMatchInToGraph(fromEdge.getTarget()) == toEdge.getTarget()) {
						return fromEdge;
					}
				}
			}
		}
		return null;
	}
	
	protected EdgePattern getEdgeMatchInToGraph(EdgePattern fromEdge, EList<EdgePattern> toEdges) {
		for (EdgePattern toEdge : toEdges) {
			if (toEdge.getType() == fromEdge.getType()) {
				if (toEdge.getTarget().getType() == fromEdge.getTarget().getType()) {
					if (getNodeMatchInFromGraph(toEdge.getTarget()) == fromEdge.getTarget()) {
						return toEdge;
					}
				}
			}
		}
		return null;
	}

	protected NodePattern getNodeMatchInToGraph(NodePattern fromNode) {
		return match.get(fromNode);
	}
	
	protected NodePattern getNodeMatchInFromGraph(NodePattern toNode) {
		for (Entry<NodePattern, NodePattern> entry : match.entrySet()) {
			if (entry.getValue() == toNode) {
				return entry.getKey();
			}
		}
		return null;
	}
	
	/**
	 * @param fromElement A graph element or <code>null</code>.
	 * @param toElement   A graph element or <code>null</code>.
	 * @return <code>true</code> if both given nodes are conditions;
	 *         <code>false</code> otherwise.
	 */
	protected boolean isConditionMatch(GraphElement fromElement, GraphElement toElement) {
		return ((fromElement == null) || isCondition(fromElement)) && ((toElement == null) || isCondition(toElement));
	}
}
