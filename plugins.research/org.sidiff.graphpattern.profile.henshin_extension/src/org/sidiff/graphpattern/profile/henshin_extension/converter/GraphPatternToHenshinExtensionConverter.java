package org.sidiff.graphpattern.profile.henshin_extension.converter;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.henshin.model.Attribute;
import org.eclipse.emf.henshin.model.Edge;
import org.eclipse.emf.henshin.model.Node;
import org.eclipse.emf.henshin.model.Rule;
import org.sidiff.graphpattern.AttributePattern;
import org.sidiff.graphpattern.EdgePattern;
import org.sidiff.graphpattern.GraphElement;
import org.sidiff.graphpattern.GraphPattern;
import org.sidiff.graphpattern.NodePattern;
import org.sidiff.graphpattern.Pattern;
import org.sidiff.graphpattern.SubGraph;
import org.sidiff.graphpattern.profile.henshin.converter.GraphPatternToHenshinConverter;
import org.sidiff.graphpattern.profile.henshin_extension.GraphElementExtension;
import org.sidiff.graphpattern.profile.henshin_extension.HenshinExtensionFactory;
import org.sidiff.graphpattern.profile.henshin_extension.RuleExtension;

public class GraphPatternToHenshinExtensionConverter extends GraphPatternToHenshinConverter {

	private class HenshinSubGraph extends org.sidiff.graphpattern.profile.henshin_extension.impl.SubGraphImpl {}
	
	private Map<SubGraph, HenshinSubGraph> subGraphTrace = new HashMap<>();
	
	public GraphPatternToHenshinExtensionConverter(Pattern editOperation) {
		super(editOperation);
		convertSubGraphs(editOperation);
	}
	
	@Override
	public RuleExtension getRule() {
		return (RuleExtension) super.getRule();
	}

	private void convertSubGraphs(Pattern editOperation) {
		for (GraphPattern graph : editOperation.getGraphs()) {
			for (SubGraph subGraph : graph.getSubgraphs()) {
				convertSubGraphs(graph, subGraph);
			}
		}
	}
	
	private void convertSubGraphs(GraphPattern parent, SubGraph subGraph) {
		HenshinSubGraph convertedSubGraph = convertSubGraph(subGraph);
		getRule().getSubgraphs().add(convertedSubGraph);
		
		for (SubGraph nestedSubGraph : subGraph.getSubgraphs()) {
			convertSubGraphs(subGraph, nestedSubGraph);
		}
	}
	
	private void convertSubGraphs(SubGraph parent, SubGraph subGraph) {
		HenshinSubGraph convertedSubGraph = convertSubGraph(subGraph);
		
		HenshinSubGraph convertedParent = subGraphTrace.get(parent);
		convertedParent.getSubgraphs().add(convertedSubGraph);
	}
	
	private HenshinSubGraph convertSubGraph(SubGraph subGraph) {
		HenshinSubGraph convertedSubGraph = new HenshinSubGraph();
		convertedSubGraph.setName(subGraph.getName());
		convertedSubGraph.setDescription(subGraph.getDescription());
		convertedSubGraph.getStereotypes().addAll(subGraph.getStereotypes());
		
		for (GraphElement element : subGraph.getElements()) {
			GraphElementExtension graphElementExtension = getTrace(element);
			convertedSubGraph.getElements().add(graphElementExtension);
		}
		
		subGraphTrace.put(subGraph, convertedSubGraph);
		return convertedSubGraph;
	}
	
	@Override
	protected Rule createRule() {
		return HenshinExtensionFactory.eINSTANCE.createRuleExtension();
	}
	
	@Override
	protected Node createNode() {
		return HenshinExtensionFactory.eINSTANCE.createNodeExtension();
	}
	
	@Override
	protected Edge createEdge() {
		return HenshinExtensionFactory.eINSTANCE.createEdgeExtension();
	}
	
	@Override
	protected Attribute createAttribute() {
		return HenshinExtensionFactory.eINSTANCE.createAttributeExtension();
	}
	
	protected GraphElementExtension getTrace(GraphElement graphElement) {
		// NOTE: << preserve >> -> LHS
		
		if (graphElement instanceof NodePattern) {
			
			// Search LHS:
			Node henshinNode = getLhsTrace().get(graphElement);
			
				// Search RHS:
				if (henshinNode == null) {
				henshinNode = getRhsTrace().get(graphElement);
			}
			
			// Search AC:
			if (henshinNode == null) {
				henshinNode = getAcTrace().get(graphElement);
			}
			
			return (GraphElementExtension) henshinNode;
		}
		
		else if (graphElement instanceof AttributePattern) {
			AttributePattern attribute = (AttributePattern) graphElement;
			NodePattern parentNode = attribute.getNode();
			
			Attribute henshinAttribut = null;
			Node henshinParentNode= getLhsTrace().get(parentNode);
			
			// Search LHS:
			if (henshinParentNode != null) {
				henshinAttribut = henshinParentNode.getAttribute(attribute.getType());
			}
			
			// Search RHS:
			if (henshinAttribut == null) {
				henshinParentNode = getRhsTrace().get(parentNode);
				
				if (henshinParentNode != null) {
					henshinAttribut = henshinParentNode.getAttribute(attribute.getType());
				}
			}
			
			// Search AC:
			if (henshinAttribut == null) {
				henshinParentNode = getAcTrace().get(parentNode);
				
				if (henshinParentNode != null) {
					henshinAttribut = henshinParentNode.getAttribute(attribute.getType());
				}
			}
			
			return (GraphElementExtension) henshinAttribut;
		}
		
		else if (graphElement instanceof EdgePattern) {
			EdgePattern edge = (EdgePattern) graphElement;
			NodePattern sourceNode = edge.getSource();
			NodePattern targetNode = edge.getTarget();
			
			Edge henshinEdge = null;
			Node henshinSourceNode= getLhsTrace().get(sourceNode);
			Node henshinTargetNode= getLhsTrace().get(targetNode);
			
			// Search LHS:
			if ((henshinSourceNode != null) && (henshinTargetNode != null)) {
				henshinEdge = henshinSourceNode.getOutgoing(edge.getType(), henshinTargetNode);
			}
			
			// Search RHS:
			if (henshinEdge == null) {
				henshinSourceNode= getRhsTrace().get(sourceNode);
				henshinTargetNode= getRhsTrace().get(targetNode);
				
				if ((henshinSourceNode != null) && (henshinTargetNode != null)) {
					henshinEdge = henshinSourceNode.getOutgoing(edge.getType(), henshinTargetNode);
				}
			}
			
			// Search AC:
			if (henshinEdge == null) {
				henshinSourceNode= getAcTrace().get(sourceNode);
				henshinTargetNode= getAcTrace().get(targetNode);
				
				if ((henshinSourceNode != null) && (henshinTargetNode != null)) {
					henshinEdge = henshinSourceNode.getOutgoing(edge.getType(), henshinTargetNode);
				}
			}
			
			return (GraphElementExtension) henshinEdge;
		}
		
		return null;
	}
}
