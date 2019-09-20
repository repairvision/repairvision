package org.sidiff.graphpattern.tools.editrules.generator;

import static org.sidiff.graphpattern.profile.henshin.HenshinStereotypes.create;
import static org.sidiff.graphpattern.profile.henshin.HenshinStereotypes.delete;
import static org.sidiff.graphpattern.profile.henshin.HenshinStereotypes.forbid;
import static org.sidiff.graphpattern.profile.henshin.HenshinStereotypes.post;
import static org.sidiff.graphpattern.profile.henshin.HenshinStereotypes.pre;
import static org.sidiff.graphpattern.profile.henshin.HenshinStereotypes.preserve;
import static org.sidiff.graphpattern.profile.henshin.HenshinStereotypes.require;
import static org.sidiff.graphpattern.profile.henshin.HenshinStereotypes.rule;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil.Copier;
import org.sidiff.graphpattern.AttributePattern;
import org.sidiff.graphpattern.EdgePattern;
import org.sidiff.graphpattern.GraphElement;
import org.sidiff.graphpattern.GraphPattern;
import org.sidiff.graphpattern.GraphpatternFactory;
import org.sidiff.graphpattern.NodePattern;
import org.sidiff.graphpattern.Pattern;
import org.sidiff.graphpattern.Stereotype;
import org.sidiff.graphpattern.tools.editrules.generator.util.GraphPatternGeneratorUtil;

public class GraphPatternEditRuleGenerator extends BasicEditRuleGenerator {

	// NOTE: We need to separate the copier since 'pre' and 'post' might be the same graph.
	
	protected enum GraphType {
		PRE, POST
	}
	
	protected Copier preFragmentCopier = createCopier();
	
	protected Copier postFragmentCopier = createCopier();
	
	protected Pattern editOperation;
	
	protected GraphPattern editRule;
	
	public GraphPatternEditRuleGenerator(GraphPattern preGraph, GraphPattern postGraph, Map<NodePattern, NodePattern> match) {
		super(preGraph, postGraph, match);
		
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
	
	@SuppressWarnings("unchecked")
	public Map<NodePattern, NodePattern> getTracePreGraph2EditGraph() {
		Map<?, ?> copy = preFragmentCopier;
		return (Map<NodePattern, NodePattern>) copy;
	}
	
	@SuppressWarnings("unchecked")
	public Map<NodePattern, NodePattern> getTracePostGraph2EditGraph() {
		Map<?, ?> copy = postFragmentCopier;
		return (Map<NodePattern, NodePattern>) copy;
	}
	
	@Override
	public void generate(List<NodePattern> preFragment, List<NodePattern> postFragment) {
		super.generate(preFragment, postFragment);
		
		// Set edge targets:
		for (EObject constraintGraphElement : preFragmentCopier.keySet()) {
			if (constraintGraphElement instanceof EdgePattern) {
				generateEdgeTarget((EdgePattern) constraintGraphElement, GraphType.PRE);
			}
		}
		for (EObject constraintGraphElement : postFragmentCopier.keySet()) {
			if (constraintGraphElement instanceof EdgePattern) {
				generateEdgeTarget((EdgePattern) constraintGraphElement, GraphType.POST);
			}
		}
		
		// Set opposite edges:
		for (EObject constraintGraphElement : preFragmentCopier.keySet()) {
			if (constraintGraphElement instanceof EdgePattern) {
				generateEdgeOpposite((EdgePattern) constraintGraphElement, GraphType.PRE);
			}
		}
		for (EObject constraintGraphElement : postFragmentCopier.keySet()) {
			if (constraintGraphElement instanceof EdgePattern) {
				generateEdgeOpposite((EdgePattern) constraintGraphElement, GraphType.POST);
			}
		}
		
		// Generate parameters:
		GraphPatternGeneratorUtil.generateINParameters(editOperation);
	}
	
	private void generateEdgeOpposite(EdgePattern constraintEdge, GraphType graphType) {
		EdgePattern constraintOpposite = constraintEdge.getOpposite();
		
		if (constraintOpposite != null) {
			EdgePattern editRuleOpposite = getEditRuleEdge(constraintOpposite, graphType);
			
			EdgePattern editRuleEdge = (EdgePattern) getCopier(graphType).get(constraintEdge);
			editRuleEdge.setOpposite(editRuleOpposite);
		}
	}
	
	protected EdgePattern getEditRuleEdge(EdgePattern constraintEdge, GraphType graphType) {
		EdgePattern editRuleEdge = null;
		
		if (getCopier(graphType).containsKey(constraintEdge)) {
			editRuleEdge = (EdgePattern) getCopier(graphType).get(constraintEdge);
		} else {
			NodePattern sourceNodeMatch = getNodeMatch(constraintEdge.getSource(), graphType);
			
			if (sourceNodeMatch != null) {
				editRuleEdge = (EdgePattern) getCopier(graphType).get(getEdgeMatch(constraintEdge, sourceNodeMatch.getOutgoings(), graphType));
			}
		}
		
		if (editRuleEdge == null) {
			if (getCoCopier(graphType).containsKey(constraintEdge)) {
				editRuleEdge = (EdgePattern) getCoCopier(graphType).get(constraintEdge);
			} else {
				NodePattern sourceNodeMatch = getNodeMatch(constraintEdge.getSource(), graphType);
				
				if (sourceNodeMatch != null) {
					editRuleEdge = (EdgePattern) getCoCopier(graphType).get(getEdgeMatch(constraintEdge, sourceNodeMatch.getOutgoings(), graphType));
				}
			}
		}
		
		return editRuleEdge;
	}

	protected void generateEdgeTarget(EdgePattern constraintEdge, GraphType graphType) {
		NodePattern constraintTargetNode = constraintEdge.getTarget();
		NodePattern editRuleTargetNode = getEditRuleNode(constraintTargetNode, graphType);
		
		EdgePattern editRuleEdge = (EdgePattern) getCopier(graphType).get(constraintEdge);
		editRuleEdge.setTarget(editRuleTargetNode);
		
		if (editRuleTargetNode == null) {
			System.err.println("Missing Edge Target: " + editRuleEdge);
		}
	}
	
	protected NodePattern getEditRuleNode(NodePattern constraintNode, GraphType graphType) {
		NodePattern editRuleNode = null;
		
		if (getCopier(graphType).containsKey(constraintNode)) {
			editRuleNode = (NodePattern) getCopier(graphType).get(constraintNode);
		} else {
 			editRuleNode = (NodePattern) getCopier(graphType).get(getNodeMatch(constraintNode, graphType));
		}
		
		if (editRuleNode == null) {
			if (getCoCopier(graphType).containsKey(constraintNode)) {
				editRuleNode = (NodePattern) getCoCopier(graphType).get(constraintNode);
			} else {
				editRuleNode = (NodePattern) getCoCopier(graphType).get(getNodeMatch(constraintNode, graphType));
			}
		}
		
		return editRuleNode;
	}
	
	protected Copier getCopier(GraphType graphType) {
		return (graphType.equals(GraphType.PRE)) ? preFragmentCopier : postFragmentCopier;
	}
	
	protected Copier getCoCopier(GraphType graphType) {
		return (graphType.equals(GraphType.PRE)) ? postFragmentCopier : preFragmentCopier;
	}
	
	protected EdgePattern getEdgeMatch(EdgePattern constraintEdge, EList<EdgePattern> outgoings, GraphType graphType) {
		return (graphType.equals(GraphType.PRE)) 
				? getEdgeMatchInToGraph(constraintEdge, outgoings) 
				: getEdgeMatchInFromGraph(constraintEdge, outgoings);
	}

	protected NodePattern getNodeMatch(NodePattern source, GraphType graphType) {
		return (graphType.equals(GraphType.PRE)) 
				? getNodeMatchInToGraph(source) 
				: getNodeMatchInFromGraph(source);
	}
	
	protected NodePattern generateNode(NodePattern node, Stereotype action, Copier copier) {
		NodePattern eoNode = copyNode(node, copier);
		eoNode.getStereotypes().add(action);
		editRule.getNodes().add(eoNode);
		
		return eoNode;
	}
	
	protected EdgePattern generateEdge(EdgePattern edge, Stereotype action, Copier copier) {
		NodePattern eoSourceNode = (NodePattern) copier.get(edge.getSource());
		
		EdgePattern eoEdge = copyEdge(edge, copier);
		eoEdge.getStereotypes().add(action);
		eoSourceNode.getOutgoings().add(eoEdge);
		
		return eoEdge;
	}
	
	protected AttributePattern generateAttribute(AttributePattern attribute, Stereotype action, Copier copier) {
		NodePattern eoNode = (NodePattern) copier.get(attribute.getNode());
		
		AttributePattern eoAttribute = copyAttribute(attribute, copier);
		eoAttribute.getStereotypes().add(action);
		eoNode.getAttributes().add(eoAttribute);
		
		return eoAttribute;
	}
	
	@Override
	protected void generateCreate(NodePattern toNode) {
		generateNode(toNode, create, postFragmentCopier);
	}
	
	@Override
	protected void generateCreate(EdgePattern toEdge) {
		generateEdge(toEdge, create, postFragmentCopier);
	}
	
	@Override
	protected void generateCreate(AttributePattern toAttribute) {
		generateAttribute(toAttribute, create, postFragmentCopier);
	}
	
	@Override
	protected void generateDelete(NodePattern fromNode) {
		generateNode(fromNode, delete, preFragmentCopier);
	}
	
	@Override
	protected void generateDelete(EdgePattern fromEdge) {
		generateEdge(fromEdge, delete, preFragmentCopier);
	}
	
	@Override
	protected void generateDelete(AttributePattern fromAttribute) {
		generateAttribute(fromAttribute, delete, preFragmentCopier);
	}
	
	@Override
	protected void generateContext(NodePattern fromNode, NodePattern toNode) {
		NodePattern eoNode = generateNode(toNode, preserve, postFragmentCopier);
		preFragmentCopier.put(fromNode, eoNode);
	}
	
	@Override
	protected void generatePreContext(NodePattern fromNode) {
		generateNode(fromNode, preserve, preFragmentCopier);
	}

	@Override
	protected void generatePostContext(NodePattern toNode) {
		generateNode(toNode, preserve, postFragmentCopier);
	}
	
	@Override
	protected void generateModify(AttributePattern fromAttribute, String toAttributeValue) {
		
		// From:
		generateAttribute(fromAttribute, delete, preFragmentCopier);
		
		// To:
		AttributePattern rhsAttribute = generateAttribute(fromAttribute, create, preFragmentCopier);
		rhsAttribute.setValue(toAttributeValue);
	}
	
	@Override
	protected void generateContext(EdgePattern fromEdge, EdgePattern toEdge) {
		generateEdge(toEdge, preserve, postFragmentCopier);
	}
	
	@Override
	protected void generateContext(AttributePattern fromAttribute, AttributePattern toAttribute) {
		generateAttribute(fromAttribute, preserve, preFragmentCopier);
	}
	
	@Override
	protected void generateForbidPrecondition(NodePattern fromNode) {
		GraphElement eoElement = generateNode(fromNode, forbid, preFragmentCopier);
		eoElement.getStereotypes().add(pre);
	}

	@Override
	protected void generateForbidPrecondition(EdgePattern fromEdge) {
		GraphElement eoElement = generateEdge(fromEdge, forbid, preFragmentCopier);
		eoElement.getStereotypes().add(pre);
	}

	@Override
	protected void generateForbidPrecondition(AttributePattern fromAttribute) {
		GraphElement eoElement = generateAttribute(fromAttribute, forbid, preFragmentCopier);
		eoElement.getStereotypes().add(pre);
	}

	@Override
	protected void generateRequirePrecondition(NodePattern fromNode) {
		GraphElement eoElement = generateNode(fromNode, require, preFragmentCopier);
		eoElement.getStereotypes().add(pre);
	}

	@Override
	protected void generateRequirePrecondition(EdgePattern fromEdge) {
		GraphElement eoElement = generateEdge(fromEdge, require, preFragmentCopier);
		eoElement.getStereotypes().add(pre);
	}

	@Override
	protected void generateRequirePrecondition(AttributePattern fromAttribute) {
		GraphElement eoElement = generateAttribute(fromAttribute, require, preFragmentCopier);
		eoElement.getStereotypes().add(pre);
	}

	@Override
	protected void generateForbidPostcondition(NodePattern toNode) {
		GraphElement eoElement = generateNode(toNode, forbid, postFragmentCopier);
		eoElement.getStereotypes().add(post);
	}

	@Override
	protected void generateForbidPostcondition(EdgePattern toEdge) {
		GraphElement eoElement = generateEdge(toEdge, forbid, postFragmentCopier);
		eoElement.getStereotypes().add(post);
	}

	@Override
	protected void generateForbidPostcondition(AttributePattern toAttribute) {
		GraphElement eoElement = generateAttribute(toAttribute, forbid, postFragmentCopier);
		eoElement.getStereotypes().add(post);
	}

	@Override
	protected void generateRequirePostcondition(NodePattern toNode) {
		GraphElement eoElement = generateNode(toNode, require, postFragmentCopier);
		eoElement.getStereotypes().add(post);
	}

	@Override
	protected void generateRequirePostcondition(EdgePattern toEdge) {
		GraphElement eoElement = generateEdge(toEdge, require, postFragmentCopier);
		eoElement.getStereotypes().add(post);
	}

	@Override
	protected void generateRequirePostcondition(AttributePattern toAttribute) {
		GraphElement eoElement = generateAttribute(toAttribute, require, postFragmentCopier);
		eoElement.getStereotypes().add(post);
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
		return copy;
	}
	
	protected EdgePattern copyEdge(EdgePattern edge, Copier copier) {
		assert !copier.containsKey(edge);
		
		EdgePattern copy = (EdgePattern) copier.copy(edge);
		copy.setType(edge.getType());
		return copy;
	}
	
	protected AttributePattern copyAttribute(AttributePattern attribute, Copier copier) {
		assert !copier.containsKey(attribute);
		
		AttributePattern copy = (AttributePattern) copier.copy(attribute);
		copy.setType(attribute.getType());
		return copy;
	}
}
