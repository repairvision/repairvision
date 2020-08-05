package org.sidiff.graphpattern.tools.model2graph;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.sidiff.graphpattern.GraphPattern;
import org.sidiff.graphpattern.NodePattern;
import org.sidiff.revision.common.utilities.java.StringUtil;

public class ModelToGraphPatternDefiniton {
	
	private File configFile;
	
	private List<String> filter;
	
	private List<String> parameterDefinitions;
	
	private List<String[]> attributeDefinitions;
	
	private List<String[]> nodeDefinitions;
	
	public ModelToGraphPatternDefiniton(File configFile) {
		this.configFile = configFile;
	}
	
	public String getNameBundle(Resource modelResource) {
		if ((modelResource.getURI() != null) && modelResource.getURI().segmentCount() >= 3) {
			return modelResource.getURI().trimFileExtension().segment(modelResource.getURI().segmentCount() - 2);
		} else {
			return getNamePattern(modelResource);
		}
	}
	
	public String getNamePattern(Resource modelResource) {
		if ((modelResource.getURI() != null) && modelResource.getURI().segmentCount() >= 2) {
			return modelResource.getURI().trimFileExtension().segment(modelResource.getURI().segmentCount() - 1);
		} else {
			return getNameGraph(modelResource);
		}
	}
	
	public String getNameGraph(Resource modelResource) {
		if ((modelResource.getURI() != null) && modelResource.getURI().segmentCount() >= 1) {
			return modelResource.getURI().trimFileExtension().lastSegment();
		} else {
			return modelResource.toString();
		}
	}
	
	public String getName(EObject object, GraphPattern graph) {
		String name = null;
		
		if (object.eClass().getEStructuralFeature("name") != null) {
			Object nameValue = object.eGet(object.eClass().getEStructuralFeature("name"));
			
			if (nameValue instanceof String) {
				if (!((String) nameValue).isEmpty()) {
					name = (String) nameValue;
				}
			}
		}
		
		if (name != null) {
			
			// [0] name in model
			// [1] type in model
			// [2] node name replacement in pattern
			
			// Check for node name mapping:
			for (String[] nodeDefinition : getNodeDefinitions()) {
				if (nodeDefinition[0].equals(name)) {
					if (nodeDefinition[1].equals(object.eClass().getName())) {
						name = nodeDefinition[2];
					}
				}
			}
			
			return name;
		} else {
			long typeCount = graph.getNodes().stream().filter(node -> node.getType().equals(object.eClass())).count();
			String postFix = typeCount > 0 ? "" + typeCount : ""; 
					
			return StringUtil.toLowerFirst(object.eClass().getName()) + postFix;
		}
	}
	
	public boolean isConsideredAttribute(EAttribute attribute) {
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
	
	public boolean isConsideredReference(EReference reference) {
		if (!reference.isDerived()) {
			return true;
		}
		return false;
	}
	
	public boolean filter(String signature) {
		for (String filter : getFilter()) {
			if (signature.matches(filter)) {
				return true;
			}
		}
		return false;
	}
	
	public String getAttributeDefintion(NodePattern node, EAttribute attribute) {
		for (String[] attributeDefinition : getAttributeDefinitions()) {
			
			if (node.getName().matches(attributeDefinition[0])
					&& node.getType().getName().matches(attributeDefinition[1])
					&& attribute.getName().matches(attributeDefinition[2])) {
				
				return attributeDefinition[3];
			}
		}
		
		return null;
	}

	public List<String> getFilter() {
		
		if (filter == null) {
			this.filter = this.readFilter(configFile);
		}
		
		return filter;
	}
	
	public List<String> getParameterDefinitions() {
		
		if (parameterDefinitions == null) {
			this.parameterDefinitions = readParameterDefinitions(configFile); 
		}
		
		return parameterDefinitions;
	}
	
	public List<String[]> getAttributeDefinitions() {
		
		if (attributeDefinitions == null) {
			this.attributeDefinitions = readAttributeDefinitions(configFile);
		}
		
		return attributeDefinitions;
	}
	
	public List<String[]> getNodeDefinitions() {
		
		if (nodeDefinitions == null) {
			this.nodeDefinitions = readNodeDefinitions(configFile);
		}
		
		return nodeDefinitions;
	}
	
	protected List<String> readConfiguration(File configFile, String key) {
		try {
			if (configFile.exists()) {
				List<String> allLines = Files.readAllLines(configFile.toPath());
				List<String> config = new ArrayList<>();
				
				for (String line : allLines) {
					if (line.startsWith(key)) {
						config.add(line.replaceFirst(key, ""));
					}
				}
				
				return config;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Collections.emptyList();
	}
	
	protected List<String[]> readConfiguration(File configFile, String key, String seperator) {
		List<String> configurationStrings = readConfiguration(configFile, key);
		List<String[]> configurations = new ArrayList<>();
		
		for (String definition : configurationStrings) {
				String[] parameterDefinition = definition.split(seperator);
				configurations.add(parameterDefinition);
		}
		
		return configurations;
	}
	
	protected List<String> readParameterDefinitions(File file) {
		
		// # DEFINE : Parameter : <parameter name>
		return readConfiguration(file, "DEFINE : Parameter : ");
	}

	protected List<String[]> readAttributeDefinitions(File file) {
		
		// # DEFINE : Attribute : <node name> : <node type> : <attribute name> : <attribte value>
		return readConfiguration(file, "DEFINE : Attribute : ", " : ");
	}
	
	protected List<String[]> readNodeDefinitions(File file) {
		
		// # DEFINE : Node : <node name> : <node type> : <node name replacement>
		return readConfiguration(file, "DEFINE : Node : ", " : ");
	}
	
	protected List<String> readFilter(File file) {
		
		// # FILTER : Node : <node name> : <node type>
		// # FILTER : Attribute : <node name> : <node type> : <attribute type>
		// # FILTER : Edge : <source node name> : <source node type> : <edge type> : <target node name> : <target node type>
		
		return readConfiguration(file, "FILTER : ");
	}

	public String getNodeFilterSignature(EObject object, String name) {
		return "Node : " + name + " : " + object.eClass().getName();
	}
	
	public String getEdgeFilterSignature(NodePattern source, NodePattern target, EReference type) {
		return "Edge : " 	+ 			source.getName() + " : " + source.getType().getName() 
							+ " : " + 	type.getName()
							+ " : " + 	target.getName() + " : " + target.getType().getName();
	}
	
	public String getOppositeEdgeFilterSignature(NodePattern source, NodePattern target, EReference type) {
		return "Edge : " 	+ 			target.getName() + " : " + target.getType().getName() 
							+ " : " + 	type.getEOpposite().getName()
							+ " : " + 	source.getName() + " : " + source.getType().getName();
	}
	
	public String getAttributeFilterSignature(NodePattern node, EObject object, EAttribute attribute) {
		return "Attribute : " + node.getName() + " : " + object.eClass().getName() + " : " + attribute.getName();
	}
	
	public boolean definitionFileExists() {
		return configFile.exists();
	}
	
	public void createDefinitionFile() throws IOException {
		configFile.createNewFile();
		FileWriter configFileWriter = null;
		
		try {
			configFileWriter = new FileWriter(configFile);
			
			configFileWriter.append("# Transformation Definition: (copy example line, replace patterns <...> with regular expression, remove #)");
			configFileWriter.append("\n");
			
			configFileWriter.append("# DEFINE : Parameter : <parameter name>");
			configFileWriter.append("\n");
			configFileWriter.append("# DEFINE : Attribute : <node name> : <node type> : <attribute name> : <attribte value>");
			configFileWriter.append("\n");
			configFileWriter.append("# DEFINE : Node : <node name> : <node type> : <node name replacement>");
			configFileWriter.append("\n");
			configFileWriter.append("\n");
			
			configFileWriter.append("# FILTER : Node : <node name> : <node type>");
			configFileWriter.append("\n");
			configFileWriter.append("# FILTER : Attribute : <node name> : <node type> : <attribute type>");
			configFileWriter.append("\n");
			configFileWriter.append("# FILTER : Edge : <source node name> : <source node type> : <edge type> : <target node name> : <target node type>");
			configFileWriter.append("\n");
		} finally {
			if (configFileWriter != null) {
				configFileWriter.close();
			}
		}
	}
}
