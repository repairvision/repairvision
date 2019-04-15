package org.sidiff.graphpattern.converter.henshin;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.henshin.model.Attribute;
import org.eclipse.emf.henshin.model.Edge;
import org.eclipse.emf.henshin.model.Mapping;
import org.eclipse.emf.henshin.model.Node;
import org.eclipse.emf.henshin.model.Rule;
import org.sidiff.graphpattern.AttributePattern;
import org.sidiff.graphpattern.EdgePattern;
import org.sidiff.graphpattern.GraphPattern;
import org.sidiff.graphpattern.GraphpatternFactory;
import org.sidiff.graphpattern.NodePattern;

/**
 * Converts a Henshin rule into a Graph-Pattern ({@link GraphPattern}).
 * 
 * @author Manuel Ohrndorf
 */
public class HenshinConverter {

	private GraphpatternFactory GP_FACTORY = GraphpatternFactory.eINSTANCE;
	
	private Map<Node, NodePattern> trace;

	private GraphPattern graphPattern;
	
	private Set<EReference> crossReferencedTypes = Collections.emptySet();

	public HenshinConverter(Rule rule) {
		this.graphPattern = GP_FACTORY.createGraphPattern();
		this.trace = new HashMap<>();
		
		convertRule(rule);
	}
	
	public HenshinConverter(Rule rule, Set<EReference> crossReferencedTypes) {
		this.crossReferencedTypes = crossReferencedTypes;
		this.graphPattern = GP_FACTORY.createGraphPattern();
		this.graphPattern.setName(rule.getName());
		this.trace = new HashMap<>();
		
		convertRule(rule);
	}

	private void convertNode(Node node) {
		NodePattern nodePattern = GP_FACTORY.createNodePattern();
		nodePattern.setName(node.getName());
		nodePattern.setType(node.getType());
		graphPattern.getNodes().add(nodePattern);
		
		trace.put(node, nodePattern);
	}
	
	private void convertAttributes(Node node) {
		NodePattern nodePattern = trace.get(node);
				
		for (Attribute attribute : node.getAttributes()) {
			AttributePattern attributePattern = GP_FACTORY.createAttributePattern();
			attributePattern.setType(attribute.getType());
			attributePattern.setValue(attribute.getValue());
			nodePattern.getAttributes().add(attributePattern);
		}
	}
	
	private void convertEdges(Node node, Map<Node, Node> imageToOrgin, Set<Edge> convertedOpposites) {
		
		for (Edge edgeOut : node.getOutgoing()) {
			if (convertedOpposites.contains(edgeOut)) {
				continue;
			}

			EdgePattern edgePattern;
			EdgePattern oppositeEdgePattern = null;

			// Outgoing edge pattern:
			NodePattern sourceNodePattern = trace.get(edgeOut.getSource());
			sourceNodePattern = (sourceNodePattern == null) ? 
					trace.get(imageToOrgin.get(edgeOut.getSource())) : sourceNodePattern;
					
			NodePattern targetNodePattern = trace.get(edgeOut.getTarget());
			targetNodePattern = (targetNodePattern == null) ? 
					trace.get(imageToOrgin.get(edgeOut.getTarget())) : targetNodePattern;

			edgePattern = GP_FACTORY.createEdgePattern();
			edgePattern.setType(edgeOut.getType());
			edgePattern.setTarget(targetNodePattern);
			sourceNodePattern.getOutgoings().add(edgePattern);

			// Opposite edge pattern:
			EReference oppositeType = edgeOut.getType().getEOpposite();

			if (oppositeType != null) {
				
				// Create opposite edge pattern:
				oppositeEdgePattern = GP_FACTORY.createEdgePattern();
				oppositeEdgePattern.setType(oppositeType);
				
				oppositeEdgePattern.setTarget(sourceNodePattern);
				targetNodePattern.getOutgoings().add(oppositeEdgePattern);

				// Remember this edge so we do not process it again as outgoing edge:
				Edge oppositeEdge = getOpposite(edgeOut, node.getIncoming());
				convertedOpposites.add(oppositeEdge);
			} else {
				
				if (crossReferencedTypes.contains(edgeOut.getType())) {
					
					// Create opposite cross-reference edge pattern:
					oppositeEdgePattern = GP_FACTORY.createEdgePattern();
					oppositeEdgePattern.setType(edgeOut.getType());

					oppositeEdgePattern.setTarget(sourceNodePattern);
					targetNodePattern.getOutgoings().add(oppositeEdgePattern);
				}
			}
			
			if (oppositeEdgePattern != null) {
				// Set Opposite of edges:
				edgePattern.setOpposite(oppositeEdgePattern);
				oppositeEdgePattern.setOpposite(edgePattern);
			}
		}
	}

	private void convertRule(Rule rule) {
		
		Map<Node, Node> imageToOrgin = new HashMap<>();
		
		for (Mapping mapping : rule.getMultiMappings()) {
			imageToOrgin.put(mapping.getImage(), mapping.getOrigin());
		}
		
		// Convert nodes:
		for (Node node : rule.getLhs().getNodes()) {
			if (!imageToOrgin.containsKey(node)) {
				// Multi-node:
				convertNode(node);
				convertAttributes(node);
			}
		}
		
		// Convert edges:
		Set<Edge> convertedOpposites = new HashSet<>();
		
		for (Node node : rule.getLhs().getNodes()) {
			if (!imageToOrgin.containsKey(node)) {
				// Multi-node:
				convertEdges(node, imageToOrgin, convertedOpposites);
			}
		}
		
		// Convert multi-rules:
		for (Rule multiRule : rule.getMultiRules()) {
			convertRule(multiRule);
		}
	}

	public GraphPattern getGraphPattern() {
		return graphPattern;
	}

	public void setGraphPattern(GraphPattern graphPattern) {
		this.graphPattern = graphPattern;
	}

	public Map<Node, NodePattern> getTrace() {
		return trace;
	}

	public void setTrace(Map<Node, NodePattern> trace) {
		this.trace = trace;
	}

	private static Edge getOpposite(Edge edgeOut, Collection<Edge> incoming) {
		for (Edge edgeIn : incoming) {
			if (edgeOut.getType().getEOpposite() == edgeIn.getType()) {
				if ((edgeIn.getSource() == edgeOut.getTarget())
						&& (edgeIn.getTarget() == edgeOut.getSource())) {
					return edgeIn;
				}
			}
		}

		return null;
	}
}
