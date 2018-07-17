package org.sidiff.graphpattern.tools.editrules.generator;

import static org.sidiff.graphpattern.profile.constraints.ConstraintStereotypes.not;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.sidiff.graphpattern.AttributePattern;
import org.sidiff.graphpattern.EdgePattern;
import org.sidiff.graphpattern.GraphElement;
import org.sidiff.graphpattern.GraphPattern;
import org.sidiff.graphpattern.NodePattern;

public class BasicEditRuleGenerator {
	
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
		boolean postCondition = false;
		List<GraphElement> nac = new ArrayList<>();
		
		// << create/preserve/forbid >>:
		for (NodePattern toNode : toFragment) {
			if (toNode.getStereotypes().contains(not)) {
				generateForbid(toNode);
				nac.add(toNode);
				
				for (EdgePattern toEdge : toNode.getOutgoings()) {
					generateForbid(toEdge);
					nac.add(toEdge);
				}
				
				for (AttributePattern toAttribute : toNode.getAttributes()) {
					generateForbid(toAttribute);
					nac.add(toAttribute);
				}
			} else {
				NodePattern fromNode = getNodeMatch(toNode);
				
				if (fromNode != null) {
					generateContext(fromNode, toNode);
					
					for (EdgePattern toEdge : toNode.getOutgoings()) {
						if (toEdge.getStereotypes().contains(not)) {
							generateForbid(toEdge);
							nac.add(toEdge);
						} else {
							EdgePattern fromEdge = getEdgeMatch(toEdge, fromNode.getOutgoings());
							
							if (fromEdge != null) {
								generateContext(fromEdge, toEdge);
							} else {
								generateCreate(toEdge);
							}
						}
					}
					
					for (AttributePattern toAttribute : toNode.getAttributes()) {
						if (toAttribute.getStereotypes().contains(not)) {
							generateForbid(toAttribute);
							nac.add(toAttribute);
						} else {
							AttributePattern fromAttribute = getAttributeMatch(toAttribute, fromNode.getAttributes());
							
							if (fromAttribute != null) {
								generateContext(fromAttribute, toAttribute);
							} else {
								generateCreate(toAttribute);
							}
						}
					}
				} else {
					generateCreate(toNode);
					
					for (EdgePattern toEdge : toNode.getOutgoings()) {
						if (toEdge.getStereotypes().contains(not)) {
							postCondition = true;
						} else {
							generateCreate(toEdge);
						}
					}
					
					for (AttributePattern toAttribute : toNode.getAttributes()) {
						if (toAttribute.getStereotypes().contains(not)) {
							postCondition = true;
						} else {
							generateCreate(toAttribute);
						}
					}
				}
			}
		}
		
		// remove post condition:
		if (postCondition) {
			for (GraphElement nacGraphElement : nac) {
				EcoreUtil.remove(nacGraphElement);
			}
		}
		
		// << delete >>:
		for (NodePattern fromNode : fromFragment) {
			if (!fromNode.getStereotypes().contains(not)) {
				NodePattern toNode = getNodeMatch(fromNode);
				
				if (toNode != null) {
					for (EdgePattern fromEdge : fromNode.getOutgoings()) {
						if (!fromEdge.getStereotypes().contains(not)) {
							if (getEdgeMatch(fromEdge, toNode.getOutgoings()) == null) {
								generateDelete(fromEdge);
							}
						}
					}
					
					for (AttributePattern fromAttribute : fromNode.getAttributes()) {
						if (!fromAttribute.getStereotypes().contains(not)) {
							if (getAttributeMatch(fromAttribute, toNode.getAttributes()) == null) {
								generateDelete(fromAttribute);
							}
						}
					}
				} else {
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
	}
	
	protected void generateCreate(NodePattern toNode) {
		
	}
	
	protected void generateCreate(EdgePattern toEdge) {
		
	}
	
	protected void generateCreate(AttributePattern toAttribute) {
		
	}
	
	protected void generateDelete(NodePattern fromNode) {
		
	}
	
	protected void generateDelete(EdgePattern fromEdge) {
		
	}
	
	protected void generateDelete(AttributePattern fromAttribute) {
		
	}
	
	protected void generateContext(NodePattern fromNode, NodePattern toNode) {
		
	}
	
	protected void generateContext(EdgePattern fromEdge, EdgePattern toEdge) {
		
	}
	
	protected void generateContext(AttributePattern fromAttribute, AttributePattern toAttribute) {
		
	}
	
	protected void generateForbid(NodePattern toNode) {
		
	}
	
	protected void generateForbid(EdgePattern toEdge) {
		
	}
	
	protected void generateForbid(AttributePattern toAttribute) {
		
	}
	
	protected AttributePattern getAttributeMatch(AttributePattern attribute, EList<AttributePattern> otherAttributes) {
		for (AttributePattern otherAttribute : otherAttributes) {
			if (otherAttribute.getType() == attribute.getType()) {
				if (otherAttribute.getValue().equals(attribute.getValue())) {
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
