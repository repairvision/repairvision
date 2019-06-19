package org.sidiff.graphpattern.tools;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.sidiff.common.emf.modelstorage.EMFHandlerUtil;
import org.sidiff.graphpattern.AttributePattern;
import org.sidiff.graphpattern.Bundle;
import org.sidiff.graphpattern.EdgePattern;
import org.sidiff.graphpattern.GraphPattern;
import org.sidiff.graphpattern.GraphpatternFactory;
import org.sidiff.graphpattern.NodePattern;
import org.sidiff.graphpattern.Pattern;

public class ConvertModelToGraphPattern extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		Resource modelResource = EMFHandlerUtil.getSelection(event);
		
		if (modelResource != null) {
			Map<EObject, NodePattern> trace = new HashMap<>();
			String name = modelResource.getURI().lastSegment();
			
			Bundle bundle = GraphpatternFactory.eINSTANCE.createBundle();
			bundle.setName(name);
			Pattern pattern = GraphpatternFactory.eINSTANCE.createPattern();
			pattern.setName(name);
			GraphPattern graph = GraphpatternFactory.eINSTANCE.createGraphPattern();
			graph.setName(name);
			
			bundle.getPatterns().add(pattern);
			pattern.getGraphs().add(graph);

			// convert objects to nodes:
			modelResource.getAllContents().forEachRemaining(e -> {
				convertToNode(trace, graph, e);
			});
			
			// convert references to edges:
			modelResource.getAllContents().forEachRemaining(e -> {
				convertToEdges(trace, graph, e);
			});
			
			// save pattern:
			URI patternURI = modelResource.getURI().trimFileExtension().appendFileExtension("graphpattern");
			Resource patternResource = new ResourceSetImpl().createResource(patternURI);
			patternResource.getContents().add(bundle);
			
			try {
				patternResource.save(Collections.emptyMap());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return null;
	}
	
	protected static NodePattern convertToNode(Map<EObject, NodePattern> trace, GraphPattern graph, EObject object) {

		// create node pattern:
		NodePattern node = GraphpatternFactory.eINSTANCE.createNodePattern();
		node.setType(object.eClass());
		node.setName(getName(object, graph));
		
		graph.getNodes().add(node);
		trace.put(object, node);
		
		// create attribute patterns:
		convertToAttributes(object, node);
		
		return node;
	}

	protected static void convertToAttributes(EObject object, NodePattern node) {
		
		for (EAttribute attribute : object.eClass().getEAllAttributes()) {
			if (isConsideredAttribute(attribute)) {
				Object value = object.eGet(attribute);
				String stringValue = EcoreUtil.convertToString((EDataType) attribute.getEType(), value);

				AttributePattern attributePattern = GraphpatternFactory.eINSTANCE.createAttributePattern();
				attributePattern.setType(attribute);
				attributePattern.setValue("\"" + stringValue + "\"");

				node.getAttributes().add(attributePattern);
			}
		}
	}
	
	protected static boolean isConsideredAttribute(EAttribute attribute) {
		if (attribute.getEType() instanceof EDataType) {
			if (((EDataType) attribute.getEType()).isSerializable()) {
				if (!attribute.isDerived()) {
					if (!attribute.isMany()) {
						return true;
					}
				}
			}
		}
		return false;
	}
	
	protected static void convertToEdges(Map<EObject, NodePattern> trace, GraphPattern graph, EObject object) {
		
		for (EReference reference : object.eClass().getEAllReferences()) {
			if (isConsideredReference(reference)) {
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
	
	protected static boolean isConsideredReference(EReference reference) {
		if (!reference.isDerived()) {
			return true;
		}
		return false;
	}
	
	protected static void createEdge(
			Map<EObject, NodePattern> trace, GraphPattern graph, 
			EObject sourceObj, EObject targetObj, EReference type) {
		
		if ((sourceObj != null) && (targetObj != null)) {
			
			// get source and target node:
			NodePattern source = trace.get(sourceObj);
			NodePattern target = trace.get(targetObj);
			
			if (source == null) {
				source = convertToNode(trace, graph, sourceObj);
			}
			
			if (target == null) {
				target = convertToNode(trace, graph, targetObj);
			}
			
			// create edge:
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
	
	protected static String getName(EObject object, GraphPattern graph) {
		if (object.eClass().getEStructuralFeature("name") != null) {
			Object name = object.eGet(object.eClass().getEStructuralFeature("name"));
			
			if (name instanceof String) {
				return (String) name;
			}
		}
		
		return "#" + graph.getNodes().size();
	}
}
