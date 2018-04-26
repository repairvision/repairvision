package org.sidiff.graphpattern.design.service;

import java.util.List;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.sidiff.graphpattern.AttributePattern;
import org.sidiff.graphpattern.EdgePattern;
import org.sidiff.graphpattern.GraphElement;
import org.sidiff.graphpattern.NodePattern;
import org.sidiff.graphpattern.Profile;
import org.sidiff.graphpattern.Stereotype;

public class LabelServices {

	public String getLabel(NodePattern nodePattern) {
		StringBuffer label = new StringBuffer();
		
		EClass type = nodePattern.getType();
		String name = (nodePattern.getName() != null) 
				? nodePattern.getName() : "";
		
		if (!nodePattern.getStereotypes().isEmpty()) {
			label.append(unparseStereotypesLabel(nodePattern.getStereotypes()));
			label.append("\n");
		}
		
		if (type == null) {
			label.append(name + " : " + "?");
		} else {
			label.append(name + " : " + type.getName());
		}
		
		if (nodePattern.getMatching() != null) {
			label.append(" [" + nodePattern.getMatching().size() + "]");
		}
		
		return label.toString();
	}
	
	public String getLabel(AttributePattern attributePattern) {
		StringBuffer label = new StringBuffer();
		EAttribute type = attributePattern.getType();
		
		if (!attributePattern.getStereotypes().isEmpty()) {
			label.append(unparseStereotypesLabel(attributePattern.getStereotypes()));
			label.append(" ");
		}
		
		if (type == null) {
			label.append("? = " + attributePattern.getValue());
		} else {
			label.append(type.getName() + " = " + attributePattern.getValue());
		}
		
		return label.toString();
	}
	
	public String getEdgeEndLabel(EdgePattern edgePattern) {
		StringBuffer label = new StringBuffer();
		
		// meta-type:
		EReference type = edgePattern.getType();
		
		if (type == null) {
			label.append("?");
		} else {
			label.append(type.getName());
		}
		
		return label.toString();
	}
	
	public String getEdgeBeginLabel(EdgePattern edgePattern) {
		EdgePattern opposite = edgePattern.getOpposite();
		
		if (opposite != null) {
			return getEdgeEndLabel(opposite);	
		} else {
			return "";
		}
	}
	
	public String getEdgeCenterLabel(EdgePattern edgePattern) {
		StringBuffer label = new StringBuffer();
		
		// stereotype:
		if (!edgePattern.getStereotypes().isEmpty()) {
			label.append(unparseStereotypesLabel(edgePattern.getStereotypes()));
			label.append(" ");
			
			return label.toString();
		}
		return "";
	}
	
	public static String getMultiplicity(EdgePattern edgePattern) {
		EReference type = edgePattern.getType();
		
		if (type == null) {
			return "";
		} else {
			String lowerBound = type.getLowerBound() + "";
			lowerBound = lowerBound.replace("-1", "*");
			
			String upperBound = type.getUpperBound() + "";
			upperBound = upperBound.replace("-1", "*");
			
			return "[" + lowerBound + ".." + upperBound + "]";
		}
	}
	
	public void parseNodeLabel(NodePattern node, String label) {
		
		// parse stereotypes:
		node.getStereotypes().clear();
		label = parseStereotypesLabel(node, label);
		
		// parse name:
		if (label.contains(":")) {
			String[] nameAndLabel = label.split(":");
			label = nameAndLabel[1];
			
			String name = nameAndLabel[0].trim();
			node.setName(name);
		} else {
			node.setName(label.trim());
		}
		
		// parse type:
		if (!label.isEmpty()) {
			String typeName = label.trim();
			
			if ((node.getType() == null) || !node.getType().getName().equals(typeName)) {
				node.eResource().getResourceSet().getResources().forEach(r -> {
					if (r != node.eResource()) {
						r.getAllContents().forEachRemaining(e -> {
							if (e instanceof EClass) {
								if (((EClass) e).getName().equals(typeName)) {
									node.setType((EClass) e);
								}
							}
						});
					}
				});
			}
		}
	}
	
	public void parseEdgeLabel(EdgePattern edge, String label) {
		
		// parse stereotypes:
		edge.getStereotypes().clear();
		label = parseStereotypesLabel(edge, label);
		
		// synchronize with opposite:
		if (edge.getOpposite() != null) {
			edge.getOpposite().getStereotypes().clear();
			edge.getOpposite().getStereotypes().addAll(edge.getStereotypes());
		}
	}
	
	public void parseAttributeLabel(AttributePattern attribute, String label) {
		
		// parse stereotypes:
		attribute.getStereotypes().clear();
		label = parseStereotypesLabel(attribute, label);
		
		// parse name:
		if (label.contains("=")) {
			String[] typeAndLabel = label.split("=");
			label = typeAndLabel[1];
			
			String typeName = typeAndLabel[0].trim();
			
			if ((attribute.getType() == null) || !attribute.getType().getName().equals(typeName)) {
				if (attribute.getNode().getType() != null) {
					for (EAttribute attributeTypes : attribute.getNode().getType().getEAllAttributes()) {
						if (attributeTypes.getName().equals(typeName)) {
							attribute.setType(attributeTypes);
						}
					}
				}
			}
		}
		
		// parse type:
		String value = label.trim();
			
		if (!value.isEmpty()) {
			if (value.equals("null")) {
				attribute.setValue(null);
			} else {
				attribute.setValue(value);
			}
		}
	}
	
	protected static String parseStereotypesLabel(GraphElement element, String label) {
		
		// parse stereotypes:
		if (label.contains("<<") && label.contains(">>")) {
			String[] stereotypesAndLabel = label.split(">>");
			label = stereotypesAndLabel[1];

			String stereotypes = stereotypesAndLabel[0];
			stereotypes = stereotypes.replace("<<", "");

			element.getStereotypes().clear();

			if ((element.getGraph() != null) && (element.getGraph().getPattern() != null) && (element.getGraph().getPattern().getBundle() != null)) {
				for (String stereotypeString : stereotypes.split(",")) {
					for (Profile profile : element.getGraph().getPattern().getBundle().getProfiles()) {
						for (Stereotype stereotype : profile.getStereotypes()) {
							if (stereotype.getName().equalsIgnoreCase(stereotypeString.trim())) {
								element.getStereotypes().add(stereotype);
							}
						}
					}
				}
			}
		}
		
		return label;
	}
	
	protected static String unparseStereotypesLabel(List<Stereotype> stereotypes) {
		StringBuffer label = new StringBuffer();
		label.append("<<");
		
		for (Stereotype stereotype : stereotypes) {
			if (stereotype == stereotypes.get(0)) {
				label.append(stereotype.getName());
			} else {
				label.append(", ");
				label.append(stereotype.getName());
			}
		}
		
		label.append(">>");
		return label.toString();
	}
}
