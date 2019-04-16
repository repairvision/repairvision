package org.sidiff.graphpattern.tools.editrules.generator;

import static org.sidiff.graphpattern.profile.constraints.ConstraintStereotypes.not;

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
		
		// << delete/preserve/modify >>:
		for (NodePattern fromNode : fromFragment) {
			if (!fromNode.getStereotypes().contains(not)) {
				NodePattern toNode = getNodeMatch(fromNode);
				
				if (toNode != null) {
					
					// << preserve >> node
					generateContext(fromNode, toNode);
					
					for (EdgePattern fromEdge : fromNode.getOutgoings()) {
						if (!fromEdge.getStereotypes().contains(not)) {
							EdgePattern toEdge = getEdgeMatch(fromEdge, toNode.getOutgoings());
							
							if (toEdge == null) {
								generateDelete(fromEdge);
							} else {
								generateContext(fromEdge, toEdge);
							}
						}
					}
					
					for (AttributePattern fromAttribute : fromNode.getAttributes()) {
						if (!fromAttribute.getStereotypes().contains(not)) {
							AttributePattern toAttribute = getAttributeMatch(fromAttribute, toNode.getAttributes(), true);
									
							if (toAttribute == null) {
								toAttribute = getAttributeMatch(fromAttribute, toNode.getAttributes(), false);
								
								// NOTE: If the LHS requires some attribute value and the RHS not 
								//       then the RHS can be set to any value (x -> parameter).
								if (toAttribute == null) {
									generateModify(fromAttribute, generateParameterName(fromAttribute));
								} else {
									generateModify(fromAttribute, toAttribute.getValue());
								}
							} else {
								generateContext(fromAttribute, toAttribute);
							}
						}
					}
				} else {
					
					// << delete >> node
					generateDelete(fromNode);
					
					for (EdgePattern fromEdge : fromNode.getOutgoings()) {
						if (!fromEdge.getStereotypes().contains(not)) {
							generateDelete(fromEdge);
						}
					}
					
					for (AttributePattern fromAttribute : fromNode.getAttributes()) {
						if (!fromAttribute.getStereotypes().contains(not)) {
							generateDelete(fromAttribute);
						}
					}
				}
			}
		}
		
		// << create >>:
		boolean isPostCondition = false;
		
		for (NodePattern toNode : toFragment) {
			if (!toNode.getStereotypes().contains(not)) {
				NodePattern fromNode = getNodeMatch(toNode);
				
				if (fromNode != null) {
					
					// << preserve >> node
					for (EdgePattern toEdge : toNode.getOutgoings()) {
						if (!toEdge.getStereotypes().contains(not)) {
							EdgePattern fromEdge = getEdgeMatch(toEdge, fromNode.getOutgoings());
							
							if (fromEdge == null) {
								generateCreate(toEdge);
							}
						}
					}
					
					for (AttributePattern toAttribute : toNode.getAttributes()) {
						if (!toAttribute.getStereotypes().contains(not)) {
							
							// if attribute is not preserved...
							AttributePattern fromAttribute = getAttributeMatch(toAttribute, fromNode.getAttributes(), true);
							
							if (fromAttribute == null) {
								
								// and if attribute is not modify...
								fromAttribute = getAttributeMatch(toAttribute, fromNode.getAttributes(), false);
								
								if (fromAttribute == null) {
									generateCreate(toAttribute);
								}
							}
						}
					}
				} else {
					
					// << create >> node
					generateCreate(toNode);
					
					for (EdgePattern toEdge : toNode.getOutgoings()) {
						if (!toEdge.getStereotypes().contains(not)) {
							generateCreate(toEdge);
						} else {
							isPostCondition = true;
						}
					}
					
					for (AttributePattern toAttribute : toNode.getAttributes()) {
						if (!toAttribute.getStereotypes().contains(not)) {
							generateCreate(toAttribute);
						} else {
							isPostCondition = true;
						}
					}
				}
			}
		}
		
		// << forbid >>:
		// NOTE: Only << preserve >> nodes should be context of (pre-)conditions.
		if (!isPostCondition) {
			for (NodePattern toNode : toFragment) {
				if (toNode.getStereotypes().contains(not)) {
					
					// << forbid >> node:
					generateForbid(toNode);
					
					for (EdgePattern toEdge : toNode.getOutgoings()) {
						generateForbid(toEdge);
					}
					
					for (AttributePattern toAttribute : toNode.getAttributes()) {
						generateForbid(toAttribute);
					}
				} else {
					NodePattern fromNode = getNodeMatch(toNode);
					
					if (fromNode != null) {
						
						// << preserve >> node
						for (EdgePattern toEdge : toNode.getOutgoings()) {
							if (toEdge.getStereotypes().contains(not)) {
								generateForbid(toEdge);
							}
						}
						
						for (AttributePattern toAttribute : toNode.getAttributes()) {
							if (toAttribute.getStereotypes().contains(not)) {
								generateForbid(toAttribute);
							}
						}
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
	
	protected abstract void generateContext(EdgePattern fromEdge, EdgePattern toEdge);
	
	protected abstract void generateContext(AttributePattern fromAttribute, AttributePattern toAttribute);
	
	protected abstract void generateForbid(NodePattern toNode);
	
	protected abstract void generateForbid(EdgePattern toEdge);
	
	protected abstract void generateForbid(AttributePattern toAttribute);
	
	
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

	protected EdgePattern getEdgeMatch(EdgePattern edge, EList<EdgePattern> otherEdges) {
		for (EdgePattern otherEdge : otherEdges) {
			if (otherEdge.getType() == edge.getType()) {
				if (otherEdge.getTarget().getType() == edge.getTarget().getType()) {
					if (getNodeMatch(otherEdge.getTarget()) == edge.getTarget()) {
						return otherEdge;
					}
				}
			}
		}
		return null;
	}

	protected NodePattern getNodeMatch(NodePattern node) {
		if (graphContains(fromGraph, node)) {
			return match.get(node);
		} else {
			for (Entry<NodePattern, NodePattern> entry : match.entrySet()) {
				if (entry.getValue() == node) {
					return entry.getKey();
				}
			}
		}
		
		return null;
	}
}
