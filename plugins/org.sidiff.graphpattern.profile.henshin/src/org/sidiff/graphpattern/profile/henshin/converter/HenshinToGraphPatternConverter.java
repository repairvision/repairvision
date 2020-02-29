package org.sidiff.graphpattern.profile.henshin.converter;

import static org.sidiff.graphpattern.profile.henshin.HenshinStereotypes.create;
import static org.sidiff.graphpattern.profile.henshin.HenshinStereotypes.delete;
import static org.sidiff.graphpattern.profile.henshin.HenshinStereotypes.forbid;
import static org.sidiff.graphpattern.profile.henshin.HenshinStereotypes.preserve;
import static org.sidiff.graphpattern.profile.henshin.HenshinStereotypes.require;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.henshin.model.Attribute;
import org.eclipse.emf.henshin.model.Edge;
import org.eclipse.emf.henshin.model.GraphElement;
import org.eclipse.emf.henshin.model.Mapping;
import org.eclipse.emf.henshin.model.NestedCondition;
import org.eclipse.emf.henshin.model.Node;
import org.eclipse.emf.henshin.model.Parameter;
import org.eclipse.emf.henshin.model.Rule;
import org.sidiff.graphpattern.AttributePattern;
import org.sidiff.graphpattern.Bundle;
import org.sidiff.graphpattern.EdgePattern;
import org.sidiff.graphpattern.GraphPattern;
import org.sidiff.graphpattern.GraphpatternFactory;
import org.sidiff.graphpattern.NodePattern;
import org.sidiff.graphpattern.Pattern;
import org.sidiff.graphpattern.profile.henshin.HenshinStereotypes;

/**
 * Converts a Henshin rule into a Graph-Pattern ({@link GraphPattern}).
 * 
 * @author Manuel Ohrndorf
 */
public class HenshinToGraphPatternConverter {

	private GraphpatternFactory GP_FACTORY = GraphpatternFactory.eINSTANCE;
	
	private Map<Node, NodePattern> trace;
	
	private Bundle bundle;
	
	private Pattern pattern;

	private GraphPattern graphPattern;
	
	public HenshinToGraphPatternConverter(Rule rule, boolean convertActions) {
		
		// Graph pattern:
		this.graphPattern = GP_FACTORY.createGraphPattern();
		graphPattern.setName(rule.getName());
		graphPattern.setDescription(rule.getDescription());
		
		if (convertActions) {
			graphPattern.getStereotypes().add(HenshinStereotypes.rule);
		}
		
		// Pattern:
		this.pattern = GP_FACTORY.createPattern();
		pattern.setName(rule.getName());
		pattern.setDescription(rule.getDescription());

		pattern.getGraphs().add(graphPattern);
		
		// Bundle:
		this.bundle = GP_FACTORY.createBundle();
		bundle.getPatterns().add(pattern);
		bundle.getDomains().addAll(rule.getModule().getImports());
		
		if (convertActions) {
			bundle.getProfiles().add(HenshinStereotypes.profile_model);
		}

		bundle.setName(rule.getModule().getName());
		bundle.setDescription(rule.getModule().getDescription());
		
		// Convert Rule:
		this.trace = new HashMap<>();
		convertRule(rule, convertActions);
	}

	private void convertNode(Node node, boolean convertActions) {
		NodePattern nodePattern = GP_FACTORY.createNodePattern();
		nodePattern.setName(node.getName());
		nodePattern.setType(node.getType());
		convertAction(node, nodePattern, convertActions);
		graphPattern.getNodes().add(nodePattern);
		
		trace.put(node, nodePattern);
	}
	
	private void convertAttribute(Attribute attribute, boolean convertActions) {
		NodePattern nodePattern = trace.get(attribute.getNode());
				
		AttributePattern attributePattern = GP_FACTORY.createAttributePattern();
		attributePattern.setType(attribute.getType());
		attributePattern.setValue(attribute.getValue());
		convertAction(attribute, attributePattern, convertActions);
		nodePattern.getAttributes().add(attributePattern);
	}
	
	private void convertEdge(Edge edgeOut, boolean convertActions) {
		EdgePattern edgePattern;
		EdgePattern oppositeEdgePattern = null;

		// Outgoing edge pattern:
		NodePattern sourceNodePattern = trace.get(edgeOut.getSource());
		NodePattern targetNodePattern = trace.get(edgeOut.getTarget());

		// Filter parallel existing edges (mapped, opposite):
		if (sourceNodePattern.getOutgoing(edgeOut.getType(), targetNodePattern) == null) {
			edgePattern = GP_FACTORY.createEdgePattern();
			edgePattern.setType(edgeOut.getType());
			edgePattern.setTarget(targetNodePattern);
			convertAction(edgeOut, edgePattern, convertActions);
			sourceNodePattern.getOutgoings().add(edgePattern);

			// Opposite edge pattern:
			EReference oppositeType = edgeOut.getType().getEOpposite();

			if (oppositeType != null) {

				// Create opposite edge pattern:
				oppositeEdgePattern = GP_FACTORY.createEdgePattern();
				oppositeEdgePattern.setType(oppositeType);
				oppositeEdgePattern.setTarget(sourceNodePattern);
				oppositeEdgePattern.getStereotypes().addAll(edgePattern.getStereotypes());
				targetNodePattern.getOutgoings().add(oppositeEdgePattern);
			}

			if (oppositeEdgePattern != null) {
				// Set Opposite of edges:
				edgePattern.setOpposite(oppositeEdgePattern);
				oppositeEdgePattern.setOpposite(edgePattern);
			}
		}
	}
	
	private void convertParameter(Parameter parameter) {
		if (pattern.getParameter(parameter.getName()) == null) {
			org.sidiff.graphpattern.Parameter patternParameter = GP_FACTORY.createParameter();
			patternParameter.setName(parameter.getName());
			pattern.getParameters().add(patternParameter);
		}
	}
	
	private void convertAction(GraphElement henshinElement, org.sidiff.graphpattern.GraphElement patternElement, boolean convertActions) {
		if (convertActions && (henshinElement.getAction() != null)) {
			switch (henshinElement.getAction().getType()) {
			case CREATE:
				patternElement.getStereotypes().add(create);
				break;
			case DELETE:
				patternElement.getStereotypes().add(delete);
				break;
			case FORBID:
				patternElement.getStereotypes().add(forbid);
				break;
			case PRESERVE:
				patternElement.getStereotypes().add(preserve);
				break;
			case REQUIRE:
				patternElement.getStereotypes().add(require);
				break;
			}
		}
	}

	private void convertRule(Rule rule, boolean convertActions) {
		
		// Convert <<delete/preserve>> nodes:
		for (Node node : rule.getLhs().getNodes()) {
			convertNode(node, convertActions);
			
			for (Attribute attribute : node.getAttributes()) {
				convertAttribute(attribute, convertActions);
			}
		}
		
		// Convert <<create>> nodes:
		
		// LHS/RHS mappings:
		for (Mapping mapping : rule.getMappings()) {
			if (trace.containsKey(mapping.getOrigin())) {
				trace.put(mapping.getImage(), trace.get(mapping.getOrigin()));
			}
		}
		
		for (Node node : rule.getRhs().getNodes()) {
			if (rule.getMappings().getOrigin(node) == null) {
				convertNode(node, convertActions);
			}
			for (Attribute attribute : node.getAttributes()) {
				if (rule.getMappings().getOrigin(attribute) == null) {
					convertAttribute(attribute, convertActions);
				}
			}
		}
		
		// Convert <<delete/preserve>> edges:
		for (Node node : rule.getLhs().getNodes()) {
			for (Edge edgeOut : node.getOutgoing()) {
				convertEdge(edgeOut, convertActions);
			}
		}
		
		// Convert <<create>> edges:
		for (Node node : rule.getRhs().getNodes()) {
			for (Edge edgeOut : node.getOutgoing()) {
				if (rule.getMappings().getOrigin(edgeOut) == null) {
					convertEdge(edgeOut, convertActions);
				}
			}
		}
		
		// Convert <<forbid>> graphs:
		for (NestedCondition condition : rule.getLhs().getNACs()) {
			convertCondition(convertActions, condition);
		}
		
		// Convert <<require>> graphs:
		for (NestedCondition condition : rule.getLhs().getPACs()) {
			convertCondition(convertActions, condition);
		}
		
		// Convert parameters:
		for (Parameter parameter : rule.getParameters()) {
			convertParameter(parameter);
		}
		
		// Convert multi-rules:
		for (Rule multiRule : rule.getMultiRules()) {
			
			// Multi-Mappings:
			for (Mapping mapping : multiRule.getMultiMappings()) {
				if (trace.containsKey(mapping.getOrigin())) {
					trace.put(mapping.getImage(), trace.get(mapping.getOrigin()));
				}
			}
			
			convertRule(multiRule, convertActions);
		}
	}

	private void convertCondition(boolean convertActions, NestedCondition condition) {
		
		// Nested graph mappings:
		for (Mapping mapping : condition.getMappings()) {
			if (trace.containsKey(mapping.getOrigin())) {
				trace.put(mapping.getImage(), trace.get(mapping.getOrigin()));
			}
		}
		
		// Convert nodes:
		for (Node node : condition.getConclusion().getNodes()) {
			if (condition.getMappings().getOrigin(node) == null) {
				convertNode(node, convertActions);
			}
			for (Attribute attribute : node.getAttributes()) {
				if (condition.getMappings().getOrigin(attribute) == null) {
					convertAttribute(attribute, convertActions);
				}
			}
		}
		
		// Convert edges:
		for (Node node : condition.getConclusion().getNodes()) {
			for (Edge edgeOut : node.getOutgoing()) {
				if (condition.getMappings().getOrigin(edgeOut) == null) {
					convertEdge(edgeOut, convertActions);
				}
			}
		}
	}

	public Bundle getBundle() {
		return bundle;
	}
	
	public Pattern getPattern() {
		return pattern;
	}
	
	public GraphPattern getGraphPattern() {
		return graphPattern;
	}

	public Map<Node, NodePattern> getTrace() {
		return trace;
	}
}
