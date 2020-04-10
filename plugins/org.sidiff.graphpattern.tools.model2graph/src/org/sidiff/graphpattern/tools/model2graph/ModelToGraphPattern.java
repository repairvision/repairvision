package org.sidiff.graphpattern.tools.model2graph;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.sidiff.common.emf.modelstorage.EMFHandlerUtil;
import org.sidiff.graphpattern.AttributePattern;
import org.sidiff.graphpattern.Bundle;
import org.sidiff.graphpattern.EdgePattern;
import org.sidiff.graphpattern.GraphPattern;
import org.sidiff.graphpattern.GraphpatternFactory;
import org.sidiff.graphpattern.NodePattern;
import org.sidiff.graphpattern.Parameter;
import org.sidiff.graphpattern.Pattern;

public class ModelToGraphPattern {
	
	// TODO: Method to determine <<constraint>> marker, e.g., folder name convention...

	public Bundle convertToBundle(IFolder folder, String fileExtension, ModelToGraphPatternDefinitonFactory definitionFactory) {
		Bundle bundle = GraphpatternFactory.eINSTANCE.createBundle();
		bundle.setName(folder.getName() + "Bundle");
		
		// Process folder content:
		Pattern pattern = convertToPatternTree(folder, fileExtension, definitionFactory);
		bundle.getPatterns().add(pattern);
		
		return bundle;
	}
	
	public Bundle convertToBundle(IFile file, ModelToGraphPatternDefinitonFactory definitionFactory) {
		Bundle bundle = GraphpatternFactory.eINSTANCE.createBundle();
		Pattern pattern = GraphpatternFactory.eINSTANCE.createPattern();
		
		GraphPattern graphPattern = convertToParameterizedGraph(pattern, file, definitionFactory);
		
		bundle.getPatterns().add(pattern);
		pattern.getGraphs().add(graphPattern);
		
		bundle.setName(graphPattern.getName());
		pattern.setName(graphPattern.getName());
		
		return bundle;
	}
	
	protected Pattern convertToPatternTree(IFolder folder, String fileExtension, ModelToGraphPatternDefinitonFactory definitionFactory) {
		Pattern pattern = GraphpatternFactory.eINSTANCE.createPattern();
		pattern.setName(folder.getName());
		
		// Process folder content:
        try {
			for (IResource member : folder.members()) {
			    if (member instanceof IFolder) {
			    	
			    	// Convert folder to pattern:
			    	IFolder childFolder = (IFolder) member;
			        Pattern subPattern = convertToPatternTree(childFolder, fileExtension, definitionFactory);
			        pattern.getSubpatterns().add(subPattern);
			        
			    } else if (member instanceof IFile) {
			    	
			    	// Convert file to graph:
			    	if (member.getFileExtension().equalsIgnoreCase(fileExtension)) {
						convertToParameterizedGraph(pattern, member, definitionFactory);
			    	}
			    }
			}
		} catch (CoreException e) {
			e.printStackTrace();
		}
		
		return pattern;
	}

	protected GraphPattern convertToParameterizedGraph(Pattern pattern, IResource member, ModelToGraphPatternDefinitonFactory definitionFactory) {
		
		// Load model:
		ResourceSet rss = new ResourceSetImpl();
		URI uri = EMFHandlerUtil.getURI(member);
		Resource modelResource = rss.getResource(uri, true);
		
		// Create model2graph definition:
		ModelToGraphPatternDefiniton definition = definitionFactory.createDefintion(modelResource);
		
		// Convert to graph:
		GraphPattern graphPattern = convertToGraph(modelResource, definition);
		pattern.getGraphs().add(graphPattern);
		
		// Convert parameters:
		convertToParameter(pattern, graphPattern, definition);
		
		return graphPattern;
	}

	public GraphPattern convertToGraph(Resource modelResource, ModelToGraphPatternDefiniton definition) {
		
		Map<EObject, NodePattern> trace = new HashMap<>();
		String name = modelResource.getURI().trimFileExtension().lastSegment();

		GraphPattern graph = GraphpatternFactory.eINSTANCE.createGraphPattern();
		graph.setName(name);
		
		// convert objects to nodes:
		modelResource.getAllContents().forEachRemaining(e -> {
			convertToNode(trace, graph, e, definition);
		});
		
		// convert references to edges:
		modelResource.getAllContents().forEachRemaining(e -> {
			convertToEdges(trace, graph, e, definition);
		});
		
		return graph;
	}
	
	protected NodePattern convertToNode(Map<EObject, NodePattern> trace, GraphPattern graph, EObject object, ModelToGraphPatternDefiniton definition) {
		
		String name = definition.getName(object, graph);
		
		// create node pattern:
		if (!definition.filter(definition.getNodeFilterSignature(object, name))) {
			NodePattern node = GraphpatternFactory.eINSTANCE.createNodePattern();
			node.setType(object.eClass());
			node.setName(name);
			
			graph.getNodes().add(node);
			trace.put(object, node);
			
			// create attribute patterns:
			convertToAttributes(object, node, definition);
			
			return node;
		} else {
			return null;
		}
	}

	protected void convertToAttributes(EObject object, NodePattern node, ModelToGraphPatternDefiniton definition) {
		
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

	protected void convertToEdges(Map<EObject, NodePattern> trace, GraphPattern graph, EObject object, ModelToGraphPatternDefiniton definition) {
		
		for (EReference reference : object.eClass().getEAllReferences()) {
			if (definition.isConsideredReference(reference)) {
				if (reference.isMany()) {
					for (Object target : (Collection<?>) object.eGet(reference)) {
						if (target instanceof EObject) {
							createEdge(trace, graph, object, (EObject) target, reference, definition);
						}
					}
				} else {
					Object target = object.eGet(reference);
					
					if (target instanceof EObject) {
						createEdge(trace, graph, object, (EObject) target, reference, definition);
					}
				}
			}
		}
	}
	
	protected void createEdge(
			Map<EObject, NodePattern> trace, GraphPattern graph, 
			EObject sourceObj, EObject targetObj, EReference type, 
			ModelToGraphPatternDefiniton definition) {
		
		if ((sourceObj != null) && (targetObj != null)) {
			
			// get source and target node:
			NodePattern source = trace.get(sourceObj);
			NodePattern target = trace.get(targetObj);
			
			if (source == null) {
				source = convertToNode(trace, graph, sourceObj, definition);
			}
			
			if (target == null) {
				target = convertToNode(trace, graph, targetObj, definition);
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
	
	protected void convertToParameter(Pattern pattern, GraphPattern graphPattern, ModelToGraphPatternDefiniton definition) {
		for (String parameterDefinition : definition.getParameterDefinitions()) {
			Parameter parameter = GraphpatternFactory.eINSTANCE.createParameter();
			parameter.setName(parameterDefinition);
			pattern.getParameters().add(parameter);
		}
	}
}
