package org.sidiff.graphpattern.tools.model2graph;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.sidiff.graphpattern.AttributePattern;
import org.sidiff.graphpattern.Bundle;
import org.sidiff.graphpattern.EdgePattern;
import org.sidiff.graphpattern.GraphPattern;
import org.sidiff.graphpattern.GraphpatternFactory;
import org.sidiff.graphpattern.NodePattern;
import org.sidiff.graphpattern.Parameter;
import org.sidiff.graphpattern.Pattern;

public class ModelToGraphPatternTransformation {
	
	private ModelToGraphPatternDefiniton definition;
	
	public ModelToGraphPatternTransformation(ModelToGraphPatternDefiniton definition) {
		this.definition = definition;
	}

	public Bundle toBundle(Resource modelResource) {
		Bundle bundle = GraphpatternFactory.eINSTANCE.createBundle();
		Pattern pattern = toParameterizedGraph(modelResource);
		
		bundle.getPatterns().add(pattern);
		bundle.setName(definition.getNameBundle(modelResource));
		
		return bundle;
	}
	
	public Pattern toParameterizedGraph(Resource modelResource) {
		Pattern pattern = GraphpatternFactory.eINSTANCE.createPattern();
		
		// Convert to graph:
		GraphPattern graphPattern = toGraph(modelResource);
		pattern.getGraphs().add(graphPattern);
		pattern.setName(definition.getNamePattern(modelResource));
		
		// Convert parameters:
		toParameter(pattern, graphPattern);
		
		return pattern;
	}

	public GraphPattern toGraph(Resource modelResource) {
		Map<EObject, NodePattern> trace = new HashMap<>();

		GraphPattern graph = GraphpatternFactory.eINSTANCE.createGraphPattern();
		graph.setName(definition.getNameGraph(modelResource));
		
		// convert objects to nodes:
		modelResource.getAllContents().forEachRemaining(e -> {
			toNode(trace, graph, e);
		});
		
		// convert references to edges:
		modelResource.getAllContents().forEachRemaining(e -> {
			toEdges(trace, graph, e);
		});
		
		return graph;
	}
	
	protected NodePattern toNode(Map<EObject, NodePattern> trace, GraphPattern graph, EObject object) {
		
		String name = definition.getName(object, graph);
		
		// create node pattern:
		if (!definition.filter(definition.getNodeFilterSignature(object, name))) {
			NodePattern node = GraphpatternFactory.eINSTANCE.createNodePattern();
			node.setType(object.eClass());
			node.setName(name);
			
			graph.getNodes().add(node);
			trace.put(object, node);
			
			// create attribute patterns:
			toAttributes(object, node);
			
			return node;
		} else {
			return null;
		}
	}

	protected void toAttributes(EObject object, NodePattern node) {
		
		for (EAttribute attribute : object.eClass().getEAllAttributes()) {
			String attributeValue = definition.getAttributeDefintion(node, attribute);
			
			if (attributeValue != null) {
				AttributePattern attributePattern = GraphpatternFactory.eINSTANCE.createAttributePattern();
				attributePattern.setType(attribute);
				attributePattern.setValue(attributeValue);
				
				node.getAttributes().add(attributePattern);
				
			} else {
				if (definition.isConsideredAttribute(attribute)) {
					if (!definition.filter(definition.getAttributeFilterSignature(node, object, attribute))) {
						Object value = object.eGet(attribute);
						String stringValue = EcoreUtil.convertToString((EDataType) attribute.getEType(), value);
						
						AttributePattern attributePattern = GraphpatternFactory.eINSTANCE.createAttributePattern();
						attributePattern.setType(attribute);
						attributePattern.setValue("\"" + stringValue + "\"");
						
						node.getAttributes().add(attributePattern);
					}
				}
			}
		}
	}

	protected void toEdges(Map<EObject, NodePattern> trace, GraphPattern graph, EObject object) {
		
		for (EReference reference : object.eClass().getEAllReferences()) {
			if (definition.isConsideredReference(reference)) {
				if (reference.isMany()) {
					for (Object target : (Collection<?>) object.eGet(reference)) {
						if (target instanceof EObject) {
							createEdge(trace, graph, object, (EObject) target, reference);
						}
					}
				} else {
					Object target = object.eGet(reference);
					
					if (target instanceof EObject) {
						createEdge(trace, graph, object, (EObject) target, reference);
					}
				}
			}
		}
	}
	
	protected void createEdge(
			Map<EObject, NodePattern> trace, GraphPattern graph, 
			EObject sourceObj, EObject targetObj, EReference type) {
		
		if ((sourceObj != null) && (targetObj != null)) {
			
			// get source and target node:
			NodePattern source = trace.get(sourceObj);
			NodePattern target = trace.get(targetObj);
			
			if (source == null) {
				source = toNode(trace, graph, sourceObj);
			}
			
			if (target == null) {
				target = toNode(trace, graph, targetObj);
			}
			
			// create edge:
			if ((source != null) && (target != null)) {
				boolean edgeFiltered = definition.filter(definition.getEdgeFilterSignature(source, target, type));
				boolean oppositeEdgeFiltered = (type.getEOpposite() != null) && definition.filter(definition.getOppositeEdgeFilterSignature(source, target, type));
				
				if (!edgeFiltered && !oppositeEdgeFiltered) {
					EdgePattern edge = GraphpatternFactory.eINSTANCE.createEdgePattern();
					edge.setType(type);
					edge.setSource(source);
					edge.setTarget(target);
					
					// set opposite (if already exists):
					if (type.getEOpposite() != null) {
						for (EdgePattern opposite : target.getOutgoings(type.getEOpposite())) {
							if (opposite.getTarget() == source) {
								edge.setOpposite(opposite);
								opposite.setOpposite(edge);
								break;
							}
						}
					}
				}
			}
		}
	}
	
	protected void toParameter(Pattern pattern, GraphPattern graphPattern) {
		for (String parameterDefinition : definition.getParameterDefinitions()) {
			Parameter parameter = GraphpatternFactory.eINSTANCE.createParameter();
			parameter.setName(parameterDefinition);
			pattern.getParameters().add(parameter);
		}
	}

}
