package org.sidiff.graphpattern.tools;

import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
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
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;
import org.sidiff.common.emf.modelstorage.EMFHandlerUtil;
import org.sidiff.common.emf.modelstorage.EMFStorage;
import org.sidiff.consistency.common.ui.util.WorkbenchUtil;
import org.sidiff.graphpattern.AttributePattern;
import org.sidiff.graphpattern.Bundle;
import org.sidiff.graphpattern.EdgePattern;
import org.sidiff.graphpattern.GraphPattern;
import org.sidiff.graphpattern.GraphpatternFactory;
import org.sidiff.graphpattern.NodePattern;
import org.sidiff.graphpattern.Parameter;
import org.sidiff.graphpattern.Pattern;
import org.sidiff.graphpattern.tools.editrules.generator.util.GraphPatternGeneratorUtil;

public class ConvertModelToGraphPattern extends AbstractHandler {
	
	// TODO: Method to determine <<constraint>> marker, e.g., folder name convention...

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		ISelection selection = HandlerUtil.getCurrentSelection(event);
		
		if ((!selection.isEmpty()) && (selection instanceof IStructuredSelection)) {
			Object selected = ((IStructuredSelection) selection).getFirstElement();
			
			if ((selected != null) && (selected instanceof IResource)) {
				Bundle bundle = null;
				
				if (selected instanceof IFolder) {
					String fileExtension = WorkbenchUtil.askForValue("File Extension:", "", (input) -> {
						if (input.isEmpty()) {
							return "Enter a file extension!";
						} else {
							return null;
						}
					});
					bundle = convertToBundle((IFolder) selected, fileExtension);
				} else if (selected instanceof IFile) {
					bundle = convertToBundle((IFile) selected);
				}
				
				// save pattern:
				if (bundle != null) {
					URI patternURI = EMFHandlerUtil.getURI((IResource) selected).appendFileExtension("graphpattern");
					String path = WorkbenchUtil.askForValue("Save As:", patternURI.toString(), (input) -> null);
					
					if ((path != null) && (!path.equals(patternURI.toString()))) {
						patternURI = URI.createURI(path);
					}
					
					GraphPatternGeneratorUtil.saveBundle(patternURI, bundle);
				}
			}
		} else {
			WorkbenchUtil.showError("Nothing Selected!");
		}
		
		return null;
	}
	
	protected static Bundle convertToBundle(IFolder folder, String fileExtension) {
		Bundle bundle = GraphpatternFactory.eINSTANCE.createBundle();
		bundle.setName(folder.getName() + "Bundle");
		
		// Process folder content:
		Pattern pattern = convertToPatternTree(folder, fileExtension);
		bundle.getPatterns().add(pattern);
		
		return bundle;
	}
	
	protected static Bundle convertToBundle(IFile file) {
		Bundle bundle = GraphpatternFactory.eINSTANCE.createBundle();
		Pattern pattern = GraphpatternFactory.eINSTANCE.createPattern();
		
		GraphPattern graphPattern = convertToParameterizedGraph(pattern, file);
		
		bundle.getPatterns().add(pattern);
		pattern.getGraphs().add(graphPattern);
		
		bundle.setName(graphPattern.getName());
		pattern.setName(graphPattern.getName());
		
		return bundle;
	}
	
	protected static Pattern convertToPatternTree(IFolder folder, String fileExtension) {
		Pattern pattern = GraphpatternFactory.eINSTANCE.createPattern();
		pattern.setName(folder.getName());
		
		// Process folder content:
        try {
			for (IResource member : folder.members()) {
			    if (member instanceof IFolder) {
			    	
			    	// Convert folder to pattern:
			    	IFolder childFolder = (IFolder) member;
			        Pattern subPattern = convertToPatternTree(childFolder, fileExtension);
			        pattern.getSubpatterns().add(subPattern);
			        
			    } else if (member instanceof IFile) {
			    	
			    	// Convert file to graph:
			    	if (member.getFileExtension().equalsIgnoreCase(fileExtension)) {
						convertToParameterizedGraph(pattern, member);
			    	}
			    }
			}
		} catch (CoreException e) {
			e.printStackTrace();
		}
		
		return pattern;
	}

	protected static GraphPattern convertToParameterizedGraph(Pattern pattern, IResource member) {
		GraphPattern graphPattern = convertToGraph((IFile) member);
		pattern.getGraphs().add(graphPattern);
		
		// Convert parameters:
		convertToParameter(pattern, graphPattern, getParameterDefinitions((IFile) member));
		
		return graphPattern;
	}
	
	protected static GraphPattern convertToGraph(IFile file) {
		ResourceSet rss = new ResourceSetImpl();
		URI uri = EMFHandlerUtil.getURI((IResource) file);
		Resource modelResource = rss.getResource(uri, true);
		
		if (modelResource != null) {
			return convertToGraph(modelResource, getFilter(file));
		}
		
		return null;
	}
	
	protected static GraphPattern convertToGraph(Resource modelResource, List<String> filters) {
		Map<EObject, NodePattern> trace = new HashMap<>();
		String name = modelResource.getURI().trimFileExtension().lastSegment();

		GraphPattern graph = GraphpatternFactory.eINSTANCE.createGraphPattern();
		graph.setName(name);
		
		// convert objects to nodes:
		modelResource.getAllContents().forEachRemaining(e -> {
			convertToNode(trace, graph, e, filters);
		});
		
		// convert references to edges:
		modelResource.getAllContents().forEachRemaining(e -> {
			convertToEdges(trace, graph, e, filters);
		});
		
		return graph;
	}
	
	protected static void convertToParameter(Pattern pattern, GraphPattern graphPattern, List<String[]> parameterDefinitions) {
		Set<String[]> occurences = new HashSet<>();
		
		// [0] name in model
		// [1] parameter name in pattern
		// [2] name replacement in pattern
		
		for (NodePattern node : graphPattern.getNodes()) {
			for (String[] parameterDefinition : parameterDefinitions) {
				
				// Clean up node name:
				node.setName(node.getName().replace(parameterDefinition[0], parameterDefinition[2]));
				
				for (AttributePattern attribute : node.getAttributes()) {
					
					// Just the parameter:
					if (attribute.getValue().equals("\"" + parameterDefinition[0] + "\"")) {
						attribute.setValue(parameterDefinition[1]);
					}
					
					// Begins with parameter:
					if (attribute.getValue().startsWith("\"" + parameterDefinition[0])) {
						attribute.setValue(attribute.getValue().replace("\"" + parameterDefinition[0], parameterDefinition[1] + " + \""));
						occurences.add(parameterDefinition);
					}
					
					// Ends with parameter:
					if (attribute.getValue().endsWith(parameterDefinition[0] + "\"")) {
						attribute.setValue(attribute.getValue().replace(parameterDefinition[0] + "\"", " \" + " + parameterDefinition[1]));
						occurences.add(parameterDefinition);
					}
					
					// Contains parameter:
					if (attribute.getValue().contains(parameterDefinition[0])) {
						attribute.setValue(attribute.getValue().replace(parameterDefinition[0], "\" + " + parameterDefinition[1] + " + \""));
						occurences.add(parameterDefinition);
					}
				}
			}
		}
		
		for (String[] parameterDefinition : occurences) {
			Parameter parameter = GraphpatternFactory.eINSTANCE.createParameter();
			parameter.setName(parameterDefinition[1]);
			pattern.getParameters().add(parameter);
		}
	}

	protected static NodePattern convertToNode(Map<EObject, NodePattern> trace, GraphPattern graph, EObject object, List<String> filters) {
		String name = getName(object, graph);
		
		// create node pattern:
		if (!filter(getNodeFilterSignature(object, name), filters)) {
			NodePattern node = GraphpatternFactory.eINSTANCE.createNodePattern();
			node.setType(object.eClass());
			node.setName(name);
			
			graph.getNodes().add(node);
			trace.put(object, node);
			
			// create attribute patterns:
			convertToAttributes(object, node, filters);
			
			return node;
		} else {
			return null;
		}
	}

	protected static void convertToAttributes(EObject object, NodePattern node, List<String> filters) {
		
		for (EAttribute attribute : object.eClass().getEAllAttributes()) {
			if (isConsideredAttribute(attribute)) {
				if (!filter(getAttributeFilterSignature(node, object, attribute), filters)) {
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
	
	protected static void convertToEdges(Map<EObject, NodePattern> trace, GraphPattern graph, EObject object, List<String> filters) {
		
		for (EReference reference : object.eClass().getEAllReferences()) {
			if (isConsideredReference(reference)) {
				if (reference.isMany()) {
					for (Object target : (Collection<?>) object.eGet(reference)) {
						if (target instanceof EObject) {
							createEdge(trace, graph, object, (EObject) target, reference, filters);
						}
					}
				} else {
					Object target = object.eGet(reference);
					
					if (target instanceof EObject) {
						createEdge(trace, graph, object, (EObject) target, reference, filters);
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
			EObject sourceObj, EObject targetObj, EReference type, 
			List<String> filters) {
		
		if ((sourceObj != null) && (targetObj != null)) {
			
			// get source and target node:
			NodePattern source = trace.get(sourceObj);
			NodePattern target = trace.get(targetObj);
			
			if (source == null) {
				source = convertToNode(trace, graph, sourceObj, filters);
			}
			
			if (target == null) {
				target = convertToNode(trace, graph, targetObj, filters);
			}
			
			// create edge:
			if ((source != null) && (target != null)) {
				boolean edgeFiltered = filter(getEdgeFilterSignature(source, target, type), filters);
				boolean oppositeEdgeFiltered = (type.getEOpposite() != null) && filter(getOppositeEdgeFilterSignature(source, target, type), filters);
				
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
	
	protected static String getName(EObject object, GraphPattern graph) {
		if (object.eClass().getEStructuralFeature("name") != null) {
			Object name = object.eGet(object.eClass().getEStructuralFeature("name"));
			
			if (name instanceof String) {
				return (String) name;
			}
		}
		
		return "#" + graph.getNodes().size();
	}
	
	protected static boolean filter(String signature, List<String> filters) {
		for (String filter : filters) {
			if (signature.matches(filter)) {
				return true;
			}
		}
		return false;
	}
	
	protected static String getNodeFilterSignature(EObject object, String name) {
		return "Node : " + name + " : " + object.eClass().getName();
	}
	
	protected static String getEdgeFilterSignature(NodePattern source, NodePattern target, EReference type) {
		return "Edge : " 	+ 			source.getName() + " : " + source.getType().getName() 
							+ " : " + 	type.getName()
							+ " : " + 	target.getName() + " : " + target.getType().getName();
	}
	
	protected static String getOppositeEdgeFilterSignature(NodePattern source, NodePattern target, EReference type) {
		return "Edge : " 	+ 			target.getName() + " : " + target.getType().getName() 
							+ " : " + 	type.getEOpposite().getName()
							+ " : " + 	source.getName() + " : " + source.getType().getName();
	}
	
	protected static String getAttributeFilterSignature(NodePattern node, EObject object, EAttribute attribute) {
		return "Attribute : " + node.getName() + " : " + object.eClass().getName() + " : " + attribute.getName();
	}
	
	protected static List<String> getFilter(IFile file) {
		try {
			File filterFile = EMFStorage.uriToFile(EMFHandlerUtil.getURI(file).trimFileExtension().appendFileExtension("model2graph"));
			
			if (filterFile.exists()) {
				List<String> allLines = Files.readAllLines(filterFile.toPath());
				List<String> filter = new ArrayList<>();
				
				for (String line : allLines) {
					if (line.startsWith("FILTER : ")) {
						filter.add(line.replaceFirst("FILTER : ", ""));
					}
				}
				
				return filter;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Collections.emptyList();
	}
	
	protected static List<String[]> getParameterDefinitions(IFile file) {
		try {
			File filterFile = EMFStorage.uriToFile(EMFHandlerUtil.getURI(file).trimFileExtension().appendFileExtension("model2graph"));
			
			if (filterFile.exists()) {
				List<String> allLines = Files.readAllLines(filterFile.toPath());
				List<String[]> parameterDefinitions = new ArrayList<>();
				
				for (String line : allLines) {
					if (line.startsWith("DEFINE : Parameter : ")) {
						String parameterDefinitionString = line.replaceFirst("DEFINE : Parameter : ", "");
						String[] parameterDefinition = parameterDefinitionString.split(" : ");
						parameterDefinitions.add(parameterDefinition);
					}
				}
				
				return parameterDefinitions;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Collections.emptyList();
	}
}
