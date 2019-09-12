package org.sidiff.graphpattern.tools.editrules.generator;

import static org.sidiff.graphpattern.profile.henshin.HenshinStereotypes.create;
import static org.sidiff.graphpattern.profile.henshin.HenshinStereotypes.delete;
import static org.sidiff.graphpattern.profile.henshin.HenshinStereotypes.forbid;
import static org.sidiff.graphpattern.profile.henshin.HenshinStereotypes.preserve;
import static org.sidiff.graphpattern.profile.henshin.HenshinStereotypes.rule;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil.Copier;
import org.sidiff.graphpattern.AttributePattern;
import org.sidiff.graphpattern.EdgePattern;
import org.sidiff.graphpattern.GraphPattern;
import org.sidiff.graphpattern.GraphpatternFactory;
import org.sidiff.graphpattern.NodePattern;
import org.sidiff.graphpattern.Pattern;
import org.sidiff.graphpattern.Stereotype;
import org.sidiff.graphpattern.tools.editrules.generator.util.GraphPatternGeneratorUtil;

public class GraphPatternEditRuleGenerator extends BasicEditRuleGenerator {

	// NOTE: We need to separate the copier since 'from' and 'to' might be the same graph.
	
	protected Copier fromFragmentCopier = createCopier();
	
	protected Copier toFragmentCopier = createCopier();
	
	protected Map<NodePattern, NodePattern> contextTrace = new HashMap<>();
	
	protected Pattern editOperation;
	
	protected GraphPattern editRule;
	
	public GraphPatternEditRuleGenerator(GraphPattern fromGraph, GraphPattern toGraph, Map<NodePattern, NodePattern> match) {
		super(fromGraph, toGraph, match);
		
		this.editRule = GraphpatternFactory.eINSTANCE.createGraphPattern();
		this.editRule.getStereotypes().add(rule);
		
		this.editOperation = GraphpatternFactory.eINSTANCE.createPattern();
		this.editOperation.getGraphs().add(editRule);
	}
	
	public void setName(String name) {
		editOperation.setName(name);
		editRule.setName(name);
	}
	
	public Pattern getEditOperation() {
		return editOperation;
	}
	
	public GraphPattern getEditRule() {
		return editRule;
	}
	
	@Override
	public void generate(List<NodePattern> fromFragment, List<NodePattern> toFragment) {
		super.generate(fromFragment, toFragment);
		
		// Set edge targets:
		for (EObject constraintGraphElement : fromFragmentCopier.keySet()) {
			if (constraintGraphElement instanceof EdgePattern) {
				generateEdgeTarget((EdgePattern) constraintGraphElement, fromFragmentCopier, toFragmentCopier);
			}
		}
		for (EObject constraintGraphElement : toFragmentCopier.keySet()) {
			if (constraintGraphElement instanceof EdgePattern) {
				generateEdgeTarget((EdgePattern) constraintGraphElement, toFragmentCopier, fromFragmentCopier);
			}
		}
		
		// Set opposite edges:
		for (EObject constraintGraphElement : fromFragmentCopier.keySet()) {
			if (constraintGraphElement instanceof EdgePattern) {
				generateEdgeOpposite((EdgePattern) constraintGraphElement, fromFragmentCopier, toFragmentCopier);
			}
		}
		for (EObject constraintGraphElement : toFragmentCopier.keySet()) {
			if (constraintGraphElement instanceof EdgePattern) {
				generateEdgeOpposite((EdgePattern) constraintGraphElement, toFragmentCopier, fromFragmentCopier);
			}
		}
		
		// Generate parameters:
		GraphPatternGeneratorUtil.generateINParameters(editOperation);
	}
	
	private void generateEdgeOpposite(EdgePattern constraintEdge, Copier copier, Copier coCopier) {
		EdgePattern constraintOpposite = constraintEdge.getOpposite();
		
		if (constraintOpposite != null) {
			EdgePattern editRuleOpposite = getEditRuleEdge(constraintOpposite, copier, coCopier);
			
			EdgePattern editRuleEdge = (EdgePattern) copier.get(constraintEdge);
			editRuleEdge.setOpposite(editRuleOpposite);
		}
	}
	
	protected EdgePattern getEditRuleEdge(EdgePattern constraintEdge, Copier copier, Copier coCopier) {
		EdgePattern editRuleEdge = null;
		
		if (copier.containsKey(constraintEdge)) {
			editRuleEdge = (EdgePattern) copier.get(constraintEdge);
		} else {
			NodePattern sourceNodeMatch = getNodeMatch(constraintEdge.getSource());
			editRuleEdge = (EdgePattern) copier.get(getEdgeMatch(constraintEdge, sourceNodeMatch.getOutgoings()));
		}
		
		if (editRuleEdge == null) {
			if (coCopier.containsKey(constraintEdge)) {
				editRuleEdge = (EdgePattern) coCopier.get(constraintEdge);
			} else {
				NodePattern sourceNodeMatch = getNodeMatch(constraintEdge.getSource());
				editRuleEdge = (EdgePattern) coCopier.get(getEdgeMatch(constraintEdge, sourceNodeMatch.getOutgoings()));
			}
		}
		
		return editRuleEdge;
	}

	protected void generateEdgeTarget(EdgePattern constraintEdge, Copier copier, Copier coCopier) {
		NodePattern constraintTargetNode = constraintEdge.getTarget();
		NodePattern editRuleTargetNode = getEditRuleNode(constraintTargetNode, copier, coCopier);
		
		EdgePattern editRuleEdge = (EdgePattern) copier.get(constraintEdge);
		editRuleEdge.setTarget(editRuleTargetNode);
	}
	
	protected NodePattern getEditRuleNode(NodePattern constraintNode, Copier copier, Copier coCopier) {
		NodePattern editRuleNode = null;
		
		if (copier.containsKey(constraintNode)) {
			editRuleNode = (NodePattern) copier.get(constraintNode);
		} else {
			editRuleNode = (NodePattern) copier.get(getNodeMatch(constraintNode));
		}
		
		if (editRuleNode == null) {
			if (coCopier.containsKey(constraintNode)) {
				editRuleNode = (NodePattern) coCopier.get(constraintNode);
			} else {
				editRuleNode = (NodePattern) coCopier.get(getNodeMatch(constraintNode));
			}
		}
		
		return editRuleNode;
	}
	
	protected NodePattern generateNode(NodePattern node, Stereotype action, Copier copier) {
		NodePattern eoNode = copyNode(node, copier);
		eoNode.getStereotypes().add(action);
		editRule.getNodes().add(eoNode);
		
		return eoNode;
	}
	
	protected EdgePattern generateEdge(EdgePattern edge, Stereotype action, Copier copier) {
		NodePattern eoSourceNode = (NodePattern) copier.get(edge.getSource());
		
		if (eoSourceNode == null) {
			eoSourceNode = contextTrace.get(edge.getSource());
		}
		
		EdgePattern eoEdge = copyEdge(edge, copier);
		eoEdge.getStereotypes().add(action);
		eoSourceNode.getOutgoings().add(eoEdge);
		
		return edge;
	}
	
	protected AttributePattern generateAttribute(AttributePattern attribute, Stereotype action, Copier copier) {
		NodePattern eoNode = (NodePattern) copier.get(attribute.getNode());
		
		if (eoNode == null) {
			eoNode = contextTrace.get(attribute.getNode());
		}
		
		AttributePattern eoAttribute = copyAttribute(attribute, copier);
		eoAttribute.getStereotypes().add(action);
		eoNode.getAttributes().add(eoAttribute);
		
		return eoAttribute;
	}
	
	@Override
	protected void generateCreate(NodePattern toNode) {
		generateNode(toNode, create, toFragmentCopier);
	}
	
	@Override
	protected void generateCreate(EdgePattern toEdge) {
		generateEdge(toEdge, create, toFragmentCopier);
	}
	
	@Override
	protected void generateCreate(AttributePattern toAttribute) {
		generateAttribute(toAttribute, create, toFragmentCopier);
	}
	
	@Override
	protected void generateDelete(NodePattern fromNode) {
		generateNode(fromNode, delete, fromFragmentCopier);
	}
	
	@Override
	protected void generateDelete(EdgePattern fromEdge) {
		generateEdge(fromEdge, delete, fromFragmentCopier);
	}
	
	@Override
	protected void generateDelete(AttributePattern fromAttribute) {
		generateAttribute(fromAttribute, delete, fromFragmentCopier);
	}
	
	@Override
	protected void generateContext(NodePattern fromNode, NodePattern toNode) {
		NodePattern eoNode = generateNode(toNode, preserve, toFragmentCopier);
		
		contextTrace.put(fromNode, eoNode);
		contextTrace.put(toNode, eoNode);
	}
	
	@Override
	protected void generateModify(AttributePattern fromAttribute, String toAttributeValue) {
		
		// From:
		generateAttribute(fromAttribute, delete, fromFragmentCopier);
		
		// To:
		AttributePattern rhsAttribute = generateAttribute(fromAttribute, create, fromFragmentCopier);
		rhsAttribute.setValue(toAttributeValue);
	}
	
	@Override
	protected void generateContext(EdgePattern fromEdge, EdgePattern toEdge) {
		generateEdge(toEdge, preserve, toFragmentCopier);
	}
	
	@Override
	protected void generateContext(AttributePattern fromAttribute, AttributePattern toAttribute) {
		generateAttribute(fromAttribute, preserve, fromFragmentCopier);
	}
	
	@Override
	protected void generateForbid(NodePattern toNode) {
		generateNode(toNode, forbid, toFragmentCopier);
	}
	
	@Override
	protected void generateForbid(EdgePattern toEdge) {
		generateEdge(toEdge, forbid, toFragmentCopier);
	}
	
	@Override
	protected void generateForbid(AttributePattern toAttribute) {
		generateAttribute(toAttribute, forbid, toFragmentCopier);
	}
	
	@SuppressWarnings("serial")
	protected Copier createCopier() {
		return new Copier() {
			@Override
			protected void copyContainment(EReference eReference, EObject eObject, EObject copyEObject) {
			}
		};
	}
	
	protected NodePattern copyNode(NodePattern node, Copier copier) {
		assert !copier.containsKey(node);
		
		NodePattern copy = (NodePattern) copier.copy(node);
		copy.setType(node.getType());
//		copy.getStereotypes().addAll(node.getStereotypes());
		return copy;
	}
	
	protected EdgePattern copyEdge(EdgePattern edge, Copier copier) {
		assert !copier.containsKey(edge);
		
		EdgePattern copy = (EdgePattern) copier.copy(edge);
		copy.setType(edge.getType());
//		copy.getStereotypes().addAll(edge.getStereotypes());
		return copy;
	}
	
	protected AttributePattern copyAttribute(AttributePattern attribute, Copier copier) {
		assert !copier.containsKey(attribute);
		
		AttributePattern copy = (AttributePattern) copier.copy(attribute);
		copy.setType(attribute.getType());
//		copy.getStereotypes().addAll(attribute.getStereotypes());
		return copy;
	}
}
