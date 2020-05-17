package org.sidiff.graphpattern.profile.henshin.converter;

import static org.sidiff.graphpattern.profile.constraints.util.ConstraintProfileUtil.isExists;
import static org.sidiff.graphpattern.profile.constraints.util.ConstraintProfileUtil.isNot;
import static org.sidiff.graphpattern.profile.henshin.HenshinStereotypes.create;
import static org.sidiff.graphpattern.profile.henshin.HenshinStereotypes.delete;
import static org.sidiff.graphpattern.profile.henshin.HenshinStereotypes.preserve;
import static org.sidiff.graphpattern.profile.henshin.util.HenshinProfileUtil.isCreate;
import static org.sidiff.graphpattern.profile.henshin.util.HenshinProfileUtil.isEditCondition;
import static org.sidiff.graphpattern.profile.henshin.util.HenshinProfileUtil.isForbid;
import static org.sidiff.graphpattern.profile.henshin.util.HenshinProfileUtil.isPost;
import static org.sidiff.graphpattern.profile.henshin.util.HenshinProfileUtil.isPre;
import static org.sidiff.graphpattern.profile.henshin.util.HenshinProfileUtil.isRequire;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.henshin.model.Annotation;
import org.eclipse.emf.henshin.model.Attribute;
import org.eclipse.emf.henshin.model.AttributeCondition;
import org.eclipse.emf.henshin.model.Edge;
import org.eclipse.emf.henshin.model.HenshinFactory;
import org.eclipse.emf.henshin.model.Module;
import org.eclipse.emf.henshin.model.MultiUnit;
import org.eclipse.emf.henshin.model.NestedCondition;
import org.eclipse.emf.henshin.model.Node;
import org.eclipse.emf.henshin.model.Parameter;
import org.eclipse.emf.henshin.model.ParameterKind;
import org.eclipse.emf.henshin.model.ParameterMapping;
import org.eclipse.emf.henshin.model.Rule;
import org.eclipse.emf.henshin.model.resource.HenshinResource;
import org.sidiff.graphpattern.AttributePattern;
import org.sidiff.graphpattern.EdgePattern;
import org.sidiff.graphpattern.GraphElement;
import org.sidiff.graphpattern.GraphPattern;
import org.sidiff.graphpattern.NodePattern;
import org.sidiff.graphpattern.Pattern;
import org.sidiff.graphpattern.Stereotype;
import org.sidiff.graphpattern.profile.constraints.ConstraintStereotypes;
import org.sidiff.graphpattern.profile.henshin.HenshinStereotypes;

/**
 * Converts a Graph-Pattern ({@link GraphPattern} with
 * {@link HenshinStereotypes} or {@link ConstraintStereotypes} stereotypes) into
 * a Henshin rule.
 * 
 * @author Manuel Ohrndorf
 */
public class GraphPatternToHenshinConverter {

	private static final String SELF_VARIABLE = "value";
	
	private Module module;
	
	private MultiUnit unit;
	
	private Map<GraphPattern, RuleTrace> ruleTraces = new HashMap<>();
	
	public class RuleTrace {
		
		private Rule rule;
		
		private Map<NodePattern, Node> lhsTrace = new HashMap<>();
		
		private Map<NodePattern, Node> rhsTrace = new HashMap<>();
		
		// PACs
		private ConditionTrace pacTrace;
		
		private ConditionTrace prePACTrace;
		
		private ConditionTrace postPACTrace;
		
		// NACs
		private ConditionTrace nacTrace;
		
		private ConditionTrace preNACTrace;
		
		private ConditionTrace postNACTrace;
		
		public RuleTrace(Rule rule) {
			this.rule = rule;
			
			this.pacTrace = new ConditionTrace(this, null, HenshinStereotypes.require);
			this.prePACTrace = new ConditionTrace(this, "pre", HenshinStereotypes.require);
			this. postPACTrace = new ConditionTrace(this, "post", HenshinStereotypes.require);
			
			this.nacTrace = new ConditionTrace(this, null, HenshinStereotypes.forbid);
			this.preNACTrace = new ConditionTrace(this,"pre", HenshinStereotypes.forbid);
			this.postNACTrace = new ConditionTrace(this, "post", HenshinStereotypes.forbid);
		}
		
		public Rule getRule() {
			return rule;
		}
		
		public Map<NodePattern, Node> getLhsTrace() {
			return lhsTrace;
		}
		
		public Map<NodePattern, Node> getRhsTrace() {
			return rhsTrace;
		}
		
		public ConditionTrace getACTrace(List<Stereotype> stereotypes) {
			if (stereotypes.contains(HenshinStereotypes.forbid) || stereotypes.contains(ConstraintStereotypes.not)) {
				if (stereotypes.contains(HenshinStereotypes.pre)) {
					return getPreNACTrace();
				} else if (stereotypes.contains(HenshinStereotypes.post)) {
					return getPostNACTrace();
				} else {
					return getNACTrace();
				}
			} else if (stereotypes.contains(HenshinStereotypes.require) || stereotypes.contains(ConstraintStereotypes.exists)) {
				if (stereotypes.contains(HenshinStereotypes.pre)) {
					return getPrePACTrace();
				} else if (stereotypes.contains(HenshinStereotypes.post)) {
					return getPostPACTrace();
				} else {
					return getPACTrace();
				}
			}
			
			return null;
		}
		
		public ConditionTrace getNACTrace() {
			return nacTrace;
		}
		
		public ConditionTrace getPreNACTrace() {
			return preNACTrace;
		}
		
		public ConditionTrace getPostNACTrace() {
			return postNACTrace;
		}
		
		public ConditionTrace getPACTrace() {
			return pacTrace;
		}
		
		public ConditionTrace getPrePACTrace() {
			return prePACTrace;
		}
		
		public ConditionTrace getPostPACTrace() {
			return postPACTrace;
		}
	}
	
	public class ConditionTrace {
		
		private Map<NodePattern, Node> acTrace = new HashMap<>();
		
		private RuleTrace ruleTrace;
		
		private String name;
		
		private Stereotype type;
		
		private NestedCondition condition;
		
		public ConditionTrace(RuleTrace ruleTrace, String name, Stereotype type) {
			this.ruleTrace = ruleTrace;
			this.name = name;
			this.type = type;
		}
		
		public Map<NodePattern, Node> getTrace() {
			return acTrace;
		}
		
		public RuleTrace getRuleTrace() {
			return ruleTrace;
		}
		
		public NestedCondition getCondition() {
			
			if (condition == null) {
				if ((type == HenshinStereotypes.forbid) || (type == ConstraintStereotypes.not)) {
					this.condition = ruleTrace.getRule().getLhs().createNAC(name);
				} else if ((type == HenshinStereotypes.require)  || (type == ConstraintStereotypes.exists)) {
					this.condition = ruleTrace.getRule().getLhs().createPAC(name);
				}
			}
			
			return condition;
		}
	}
	
	public GraphPatternToHenshinConverter(Pattern editOperation) {
		
//		if (editOperation.getName().equals("Transform: Multiplicity-Many Containment Reference - To - Multiplicity-Many Bidirectional Reference")) {
//			System.out.println(editOperation.getName());
//		}
		
		// create module:
		this.module = createModule();
		this.module.setName(editOperation.getName());
		this.module.setDescription((editOperation.getDescription() != null) ? editOperation.getDescription() : editOperation.getName());
		
		// create main unit:
		this.unit = createMainUnit();
		unit.setName(editOperation.getName());
		module.getUnits().add(unit);
		
		// Convert rules:
		for (GraphPattern editRule : editOperation.getGraphs()) {
			Rule rule = convert(editRule, getPostCondition(editRule));
			
			// Add rule:
			module.getUnits().add(rule);
			unit.getSubUnits().add(rule);
			
			for (Parameter ruleParameter : rule.getParameters()) {
				Parameter unitParameter = EcoreUtil.copy(ruleParameter);
				unit.getParameters().add(unitParameter);
				
				ParameterMapping mapping = HenshinFactory.eINSTANCE.createParameterMapping();
				mapping.setSource(unitParameter);
				mapping.setTarget(ruleParameter);
				unit.getParameterMappings().add(mapping);
			}
		}
	}
	
	protected Module createModule() {
		return HenshinFactory.eINSTANCE.createModule();
	}
	
	protected MultiUnit createMainUnit() {
		return HenshinFactory.eINSTANCE.createSequentialUnit();
	}
	
	protected Rule createRule() {
		return HenshinFactory.eINSTANCE.createRule();
	}
	
	protected Parameter createParameter() {
		return HenshinFactory.eINSTANCE.createParameter();
	}
	
	protected Node createNode() {
		return HenshinFactory.eINSTANCE.createNode();
	}
	
	protected Edge createEdge() {
		return HenshinFactory.eINSTANCE.createEdge();
	}
	
	protected Attribute createAttribute() {
		return HenshinFactory.eINSTANCE.createAttribute();
	}
	
	public MultiUnit getMainUnit() {
		return unit;
	}

	public Module getModule() {
		return module;
	}
	
	public Rule getRule(GraphPattern editRuleGraph) {
		return ruleTraces.get(editRuleGraph).getRule();
	}
	
	public RuleTrace getTrace(GraphPattern editRuleGraph) {
		return ruleTraces.get(editRuleGraph);
	}
	
	public org.eclipse.emf.henshin.model.GraphElement getTrace(GraphElement graphElement) {
		
		// NOTE: << preserve >> -> LHS
		
		RuleTrace ruleTrace = getTrace(graphElement.getGraph());
		List<Stereotype> stereotypes = graphElement.getStereotypes();
		
		if (graphElement instanceof NodePattern) {
			
			// Search LHS:
			Node henshinNode = ruleTrace.getLhsTrace().get(graphElement);
			
				// Search RHS:
				if (henshinNode == null) {
				henshinNode = ruleTrace.getRhsTrace().get(graphElement);
			}
			
			// Search AC:
			if (henshinNode == null) {
				henshinNode = ruleTrace.getACTrace(stereotypes).getTrace().get(graphElement);
			}
			
			return henshinNode;
		}
		
		else if (graphElement instanceof AttributePattern) {
			AttributePattern attribute = (AttributePattern) graphElement;
			NodePattern parentNode = attribute.getNode();
			
			Attribute henshinAttribut = null;
			Node henshinParentNode= ruleTrace.getLhsTrace().get(parentNode);
			
			// Search LHS:
			if (henshinParentNode != null) {
				henshinAttribut = henshinParentNode.getAttribute(attribute.getType());
			}
			
			// Search RHS:
			if (henshinAttribut == null) {
				henshinParentNode = ruleTrace.getRhsTrace().get(parentNode);
				
				if (henshinParentNode != null) {
					henshinAttribut = henshinParentNode.getAttribute(attribute.getType());
				}
			}
			
			// Search AC:
			if (henshinAttribut == null) {
				henshinParentNode = ruleTrace.getACTrace(stereotypes).getTrace().get(parentNode);
				
				if (henshinParentNode != null) {
					henshinAttribut = henshinParentNode.getAttribute(attribute.getType());
				}
			}
			
			return henshinAttribut;
		}
		
		else if (graphElement instanceof EdgePattern) {
			EdgePattern edge = (EdgePattern) graphElement;
			NodePattern sourceNode = edge.getSource();
			NodePattern targetNode = edge.getTarget();
			
			Edge henshinEdge = null;
			Node henshinSourceNode= ruleTrace.getLhsTrace().get(sourceNode);
			Node henshinTargetNode= ruleTrace.getLhsTrace().get(targetNode);
			
			// Search LHS:
			if ((henshinSourceNode != null) && (henshinTargetNode != null)) {
				henshinEdge = henshinSourceNode.getOutgoing(edge.getType(), henshinTargetNode);
			}
			
			// Search RHS:
			if (henshinEdge == null) {
				henshinSourceNode= ruleTrace.getRhsTrace().get(sourceNode);
				henshinTargetNode= ruleTrace.getRhsTrace().get(targetNode);
				
				if ((henshinSourceNode != null) && (henshinTargetNode != null)) {
					henshinEdge = henshinSourceNode.getOutgoing(edge.getType(), henshinTargetNode);
				}
			}
			
			// Search AC:
			if (henshinEdge == null) {
				henshinSourceNode= ruleTrace.getACTrace(stereotypes).getTrace().get(sourceNode);
				henshinTargetNode= ruleTrace.getACTrace(stereotypes).getTrace().get(targetNode);
				
				if ((henshinSourceNode != null) && (henshinTargetNode != null)) {
					henshinEdge = henshinSourceNode.getOutgoing(edge.getType(), henshinTargetNode);
				}
			}
			
			return henshinEdge;
		}
		
		return null;
	}
	
	private Rule convert(GraphPattern graph, Set<GraphElement> elementFilter) {
		Rule rule = createRule();
		rule.setName(graph.getName());
		
		RuleTrace ruleTrace = new RuleTrace(rule);
		ruleTraces.put(graph, ruleTrace);
		
		// Nodes:
		for (NodePattern pNode : graph.getNodes()) {
			if (!elementFilter.contains(pNode)) {
				if (isForbid(pNode) || isNot(pNode)) {
					if (isPre(pNode)) {
						convert(ruleTrace.getPreNACTrace(), pNode);
					} else if (isPost(pNode)) {
						convert(ruleTrace.getPostNACTrace(), pNode);
					} else {
						convert(ruleTrace.getNACTrace(), pNode);
					}
				} else if (isRequire(pNode) || isExists(pNode)) {
					if (isPre(pNode)) {
						convert(ruleTrace.getPrePACTrace(), pNode);
					} else if (isPost(pNode)) {
						convert(ruleTrace.getPostPACTrace(), pNode);
					} else {
						convert(ruleTrace.getPACTrace(), pNode);
					}
				} else {
					convert(ruleTrace, pNode);
				}
			}
		}
		
		// Attributes:
		for (NodePattern pNode : graph.getNodes()) {
			if (!elementFilter.contains(pNode)) {
				for (AttributePattern pAttribute : pNode.getAttributes()) {
					if (!elementFilter.contains(pAttribute)) {
						if (isForbid(pAttribute) || isNot(pAttribute)) {
							if (isPre(pAttribute)) {
								convert(ruleTrace.getPreNACTrace(), pAttribute);
							} else if (isPost(pAttribute)) {
								convert(ruleTrace.getPostNACTrace(), pAttribute);
							} else {
								convert(ruleTrace.getNACTrace(), pAttribute);
							}
						} else if (isRequire(pAttribute) || isExists(pAttribute)) {
							if (isPre(pAttribute)) {
								convert(ruleTrace.getPrePACTrace(), pAttribute);
							} else if (isPost(pAttribute)) {
								convert(ruleTrace.getPostPACTrace(), pAttribute);
							} else {
								convert(ruleTrace.getPACTrace(), pAttribute);
							}
						} else {
							convert(ruleTrace, pAttribute);
						}
					}
				}
			}
		}
		
		// Edges:
		for (NodePattern pNode : graph.getNodes()) {
			if (!elementFilter.contains(pNode)) {
				for (EdgePattern pEdge : pNode.getOutgoings()) {
					if (!elementFilter.contains(pEdge)) {
						if (isForbid(pEdge) || isNot(pEdge)) {
							if (isPre(pEdge)) {
								convert(ruleTrace.getPreNACTrace(), pEdge);
							} else if (isPost(pEdge)) {
								convert(ruleTrace.getPostNACTrace(), pEdge);
							} else {
								convert(ruleTrace.getNACTrace(), pEdge);
							}
						} else if (isRequire(pEdge) || isExists(pEdge)) {
							if (isPre(pEdge)) {
								convert(ruleTrace.getPrePACTrace(), pEdge);
							} else if (isPost(pEdge)) {
								convert(ruleTrace.getPostPACTrace(), pEdge);
							} else {
								convert(ruleTrace.getPACTrace(), pEdge);
							}
						} else {
							convert(ruleTrace, pEdge);
						}
					}
				}
			}
		}
		
		// Parameters:
		if (graph.getPattern() != null) {
			for (org.sidiff.graphpattern.Parameter pParameter : graph.getPattern().getParameters()) {
				convert(rule, pParameter);
			}
		}
		
		return rule;
	}
	
	public Resource getResource(URI uri) {
		Resource resource = new HenshinResource(uri);
		resource.getContents().add(getModule());
		
		return resource;
	}
	
	private void convert(RuleTrace ruleTrace, NodePattern pNode) {
		
		// NOTE: Empty stereotype (of constraint pattern) as preserve.
		
		// LHS:
		if (pNode.getStereotypes().contains(delete)  
				|| pNode.getStereotypes().contains(preserve)
				|| pNode.getStereotypes().isEmpty()) {
			Node node = createNode();
			node.setName(pNode.getName());
			node.setDescription(pNode.getDescription());
			node.setType(pNode.getType());

			ruleTrace.getRule().getLhs().getNodes().add(node);
			ruleTrace.getLhsTrace().put(pNode, node);
		}
		
		// RHS:
		if (pNode.getStereotypes().contains(create)  
				|| pNode.getStereotypes().contains(preserve)
				|| pNode.getStereotypes().isEmpty()) {
			Node node = createNode();
			node.setName(pNode.getName());
			node.setDescription(pNode.getDescription());
			node.setType(pNode.getType());

			ruleTrace.getRule().getRhs().getNodes().add(node);
			ruleTrace.getRhsTrace().put(pNode, node);
		}
		
		if (pNode.getStereotypes().contains(preserve) || pNode.getStereotypes().isEmpty()) {
			ruleTrace.getRule().getMappings().add(ruleTrace.getLhsTrace().get(pNode), ruleTrace.getRhsTrace().get(pNode));
		}
	}
	
	private void convert(RuleTrace ruleTrace, AttributePattern pAttribute) {
		
		// NOTE: Empty stereotype (of constraint pattern) as preserve.
		
		// attribute condition:
		if (!pAttribute.isConstant()) {
			List<String> variables = pAttribute.getVariables();

			if (variables.contains(SELF_VARIABLE)) {
				
				// create condition:
				Node contextNode = ruleTrace.getLhsTrace().containsKey(pAttribute.getNode()) 
						? ruleTrace.getLhsTrace().get(pAttribute.getNode()) 
						: ruleTrace.getRhsTrace().get(pAttribute.getNode());
				String selfVariable = SELF_VARIABLE + "_" + contextNode.getName() + "_" + pAttribute.getType().getName();
				String selfCondition = pAttribute.getValue().replace(SELF_VARIABLE, selfVariable); // FIXME: refactor in AST
				
				// create parameter:
				addParameter(ruleTrace.getRule(), selfVariable, "Attribute Condition: " + selfCondition);
				
				if ((pAttribute.getStereotypes().contains(delete) 
						|| pAttribute.getStereotypes().contains(preserve))
						|| pAttribute.getStereotypes().isEmpty()) {
					contextNode = ruleTrace.getLhsTrace().get(pAttribute.getNode());
					
					AttributeCondition attributeCondition = HenshinFactory.eINSTANCE.createAttributeCondition();
					attributeCondition.setRule(ruleTrace.getRule());
					attributeCondition.setName(selfVariable);
					attributeCondition.setConditionText(selfCondition);
					
					// create variable:
					Attribute attribute = createAttribute();
					attribute.setType(pAttribute.getType());
					attribute.setValue(selfVariable);
					contextNode.getAttributes().add(attribute);
					
					// (additional: store in annotation):
					Annotation attributeConditionAnnotation = HenshinFactory.eINSTANCE.createAnnotation();
					attributeConditionAnnotation.setKey("AttributeCondition");
					attributeConditionAnnotation.setValue(selfCondition);
					attribute.getAnnotations().add(attributeConditionAnnotation);
				} 
				
				if (pAttribute.getStereotypes().contains(create) 
						|| pAttribute.getStereotypes().contains(preserve)
						|| pAttribute.getStereotypes().isEmpty()) {
					contextNode = ruleTrace.getRhsTrace().get(pAttribute.getNode());

					// create variable:
					Attribute attribute = createAttribute();
					attribute.setType(pAttribute.getType());
					attribute.setValue(selfVariable);
					contextNode.getAttributes().add(attribute);
				}
				
				return;
			} 
		}

		// LHS:
		if (pAttribute.getStereotypes().contains(delete) 
				|| pAttribute.getStereotypes().contains(preserve)
				|| pAttribute.getStereotypes().isEmpty()) {
			Attribute attribute = createAttribute();
			attribute.setType(pAttribute.getType());
			attribute.setValue(pAttribute.getValue());

			Node lhsNode = ruleTrace.getLhsTrace().get(pAttribute.getNode());
			lhsNode.getAttributes().add(attribute);
		}

		// RHS:
		if (pAttribute.getStereotypes().contains(create) 
				|| pAttribute.getStereotypes().contains(preserve)
				|| pAttribute.getStereotypes().isEmpty()) {
			Attribute attribute = createAttribute();
			attribute.setType(pAttribute.getType());
			attribute.setValue(pAttribute.getValue());

			Node rhsNode = ruleTrace.getRhsTrace().get(pAttribute.getNode());
			rhsNode.getAttributes().add(attribute);
		}
	}
	
	private void convert(RuleTrace ruleTrace, EdgePattern pEdge) {
		
		// NOTE: Empty stereotype (of constraint pattern) as preserve.
		
		// LHS:
		if (pEdge.getStereotypes().contains(delete) 
				|| pEdge.getStereotypes().contains(preserve)
				|| pEdge.getStereotypes().isEmpty()) {
			Edge edge = createEdge();
			edge.setType(pEdge.getType());
			edge.setSource(ruleTrace.getLhsTrace().get(pEdge.getSource()));
			edge.setTarget(ruleTrace.getLhsTrace().get(pEdge.getTarget()));
			
			ruleTrace.getRule().getLhs().getEdges().add(edge);
		}
		
		// RHS:
		if (pEdge.getStereotypes().contains(create) 
				|| pEdge.getStereotypes().contains(preserve)
				|| pEdge.getStereotypes().isEmpty()) {
			Edge edge = createEdge();
			edge.setType(pEdge.getType());
			edge.setSource(ruleTrace.getRhsTrace().get(pEdge.getSource()));
			edge.setTarget(ruleTrace.getRhsTrace().get(pEdge.getTarget()));
			
			ruleTrace.getRule().getRhs().getEdges().add(edge);
		}
	}
	
	private void convert(ConditionTrace ac, NodePattern pNode) {
		Node node = createNode();
		node.setName(pNode.getName());
		node.setDescription(pNode.getDescription());
		node.setType(pNode.getType());
		
		ac.getCondition().getConclusion().getNodes().add(node);
		ac.getTrace().put(pNode, node);
	}
	
	private void convert(ConditionTrace ac, AttributePattern pAttribute) {
		
		// create attribute:
		Attribute attribute = createAttribute();
		attribute.setType(pAttribute.getType());
		attribute.setValue(pAttribute.getValue());
		
		Node node = ac.getTrace().get(pAttribute.getNode());
		
		if (node == null) {
			node = createApplicationConditionContextNode(ac, pAttribute.getNode());
		}
		
		node.getAttributes().add(attribute);
	}
	
	private void convert(ConditionTrace ac, EdgePattern pEdge) {
		Edge edge = createEdge();
		edge.setType(pEdge.getType());
		
		Node sourceNode = ac.getTrace().get(pEdge.getSource());
		
		if (sourceNode == null) {
			sourceNode = createApplicationConditionContextNode(ac, pEdge.getSource());
		}
		
		Node targetNode = ac.getTrace().get(pEdge.getTarget());
		
		if (targetNode == null) {
			targetNode = createApplicationConditionContextNode(ac, pEdge.getTarget());
		}
		
		edge.setSource(sourceNode);
		edge.setTarget(targetNode);
		
		ac.getCondition().getConclusion().getEdges().add(edge);
	}
	
	private Node createApplicationConditionContextNode(ConditionTrace ac, NodePattern pNode) {
		convert(ac, pNode);
		Node node = ac.getTrace().get(pNode);
		ac.getCondition().getMappings().add(ac.getRuleTrace().getLhsTrace().get(pNode), node);
		
		return node;
	}
	
	private void convert(Rule rule, org.sidiff.graphpattern.Parameter pParameter) {
		addParameter(rule, pParameter.getName(), pParameter.getDescription());
	}
	
	private void addParameter(Rule rule, String name, String description) {
		if (rule.getParameter(name) == null) {
			Parameter parameter = createParameter();
			parameter.setName(name);
			parameter.setDescription(description);
			parameter.setKind(ParameterKind.IN);
			
			rule.getParameters().add(parameter);
		}
	}
	
	private static Set<GraphElement> getPostCondition(GraphPattern editRule) {
		Set<GraphElement> postCondition = new HashSet<>();
		
		for (NodePattern node : editRule.getNodes()) {
			getPostCondition(node, postCondition);
		}
		
		return postCondition;
	}
	
	private static void getPostCondition(NodePattern node, Set<GraphElement> postCondition) {

		if (!postCondition.contains(node)) {
			
			// Find first incident edge of post condition, 
			// i.e., a forbid/require edge on a create node. 
			if (isCreate(node)) {
				
				// Search for outgoing conditions on create node:
				for (EdgePattern outgoingEdge : node.getOutgoings()) {
					if (isEditCondition(outgoingEdge)) {
						
						// Post condition found!
						postCondition.add(outgoingEdge);
						
						// Collect post condition sub-graph:
						NodePattern target = outgoingEdge.getTarget();
						
						if (isEditCondition(target)) {
							if (!postCondition.contains(target)) {
								postCondition.add(target);
								getPostCondition(target, postCondition);
							}
						}
					}
				}
				
				// Search for incoming conditions on create node:
				for (EdgePattern incomingEdge : node.getIncomings()) {
					if (isEditCondition(incomingEdge)) {
						
						// Post condition found!
						postCondition.add(incomingEdge);
						
						// Collect post condition sub-graph:
						NodePattern source = incomingEdge.getSource();
						
						if (isEditCondition(source)) {
							if (!postCondition.contains(source)) {
								postCondition.add(source);
								getPostCondition(source, postCondition);
							}
						}
					}
				}
				
				// Collect post condition attributes in create node:
				for (AttributePattern attribute : node.getAttributes()) {
					if (isEditCondition(attribute)) {
						postCondition.add(attribute);
					}
				}
			}
		} else {
			
			// Collect post condition sub-graph:
			for (EdgePattern outgoingEdge : node.getOutgoings()) {
				if (isEditCondition(outgoingEdge)) {
					NodePattern target = outgoingEdge.getTarget();
					
					if (isEditCondition(target)) {
						if (!postCondition.contains(target)) {
							postCondition.add(target);
							getPostCondition(target, postCondition);
						}
					}
				}
			}
			
			for (EdgePattern incomingEdge : node.getIncomings()) {
				if (isEditCondition(incomingEdge)) {
					NodePattern source = incomingEdge.getSource();
					
					if (isEditCondition(source)) {
						if (!postCondition.contains(source)) {
							postCondition.add(source);
							getPostCondition(source, postCondition);
						}
					}
				}
			}
			
			// Collect post condition attributes:
			for (AttributePattern attribute : node.getAttributes()) {
				if (isEditCondition(attribute)) {
					postCondition.add(attribute);
				}
			}
		}
	}
}
