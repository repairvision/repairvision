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
			
			Bundle bundle = GraphpatternFactory.eINSTANCE.createBundle();
			Pattern pattern = GraphpatternFactory.eINSTANCE.createPattern();
			GraphPattern graph = GraphpatternFactory.eINSTANCE.createGraphPattern(); 
			
			bundle.getPatterns().add(pattern);
			pattern.getGraphs().add(graph);
			
			// convert objects to nodes:
			modelResource.getAllContents().forEachRemaining(e -> {
				convertToNode(trace, graph, e);
			});
			
			// convert references (per object) to edges: 
			modelResource.getAllContents().forEachRemaining(e -> {
				convertToEdges(trace, e);
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
	
	protected static void convertToNode(Map<EObject, NodePattern> trace, GraphPattern graph, EObject object) {

		// create node pattern:
		NodePattern node = GraphpatternFactory.eINSTANCE.createNodePattern();
		node.setType(object.eClass());
		node.setName(getName(object, graph));
		
		graph.getNodes().add(node);
		trace.put(object, node);
		
		// create attribute pattern:
		for (EAttribute attribute : object.eClass().getEAllAttributes()) {
			if (attribute.getEType() instanceof EDataType) {
				if (((EDataType) attribute.getEType()).isSerializable()) {
					if (!attribute.isDerived() && !attribute.isTransient() && !attribute.isVolatile()) {
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
	
	protected static void convertToEdges(Map<EObject, NodePattern> trace, EObject object) {
		
		for (EReference reference : object.eClass().getEAllReferences()) {
			if (reference.isMany()) {
				for (Object target : (Collection<?>) object.eGet(reference)) {
					createEdge(trace.get(object), trace.get(target), reference);
				}
			} else {
				NodePattern target = trace.get(object.eGet(reference));
				createEdge(trace.get(object), target, reference);
			}
		}
	}
	
	protected static void createEdge(NodePattern source, NodePattern target, EReference type) {
		if ((source != null) && (target != null)) {
			
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
