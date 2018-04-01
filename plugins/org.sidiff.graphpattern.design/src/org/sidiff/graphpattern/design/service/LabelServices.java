package org.sidiff.graphpattern.design.service;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.sidiff.graphpattern.AttributePattern;
import org.sidiff.graphpattern.EdgePattern;
import org.sidiff.graphpattern.NodePattern;
import org.sidiff.graphpattern.Profile;
import org.sidiff.graphpattern.Stereotype;

public class LabelServices {

	public String getLabel(NodePattern nodePattern) {
		EClass type = nodePattern.getType();
		StringBuffer label = new StringBuffer();
		String name = (nodePattern.getName() != null) 
				? nodePattern.getName() : "";
		
		if (!nodePattern.getStereotypes().isEmpty()) {
			label.append("<<");
			
			for (Stereotype stereotype : nodePattern.getStereotypes()) {
				if (stereotype == nodePattern.getStereotypes().get(0)) {
					label.append(stereotype.getName());
				} else {
					label.append(", ");
					label.append(stereotype.getName());
				}
			}
			
			label.append(">>");
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
		EAttribute type = attributePattern.getType();
		
		if (type == null) {
			return "? = " + attributePattern.getValue();
		} else {
			return type.getName() + " = " + attributePattern.getValue();
		}
	}
	
	public String getEdgeEndLabel(EdgePattern edgePattern) {
		EReference type = edgePattern.getType();
		
		if (type == null) {
			return "?";
		} else {
			return type.getName();
		}
	}
	
	public String getEdgeBeginLabel(EdgePattern edgePattern) {
		EdgePattern opposite = edgePattern.getOpposite();
		
		if (opposite != null) {
			EReference type = edgePattern.getOpposite().getType();
			
			if (type == null) {
				return "?";
			} else {
				return type.getName();
			}	
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
		if (label.contains("<<") && label.contains(">>")) {
			String[] stereotypesAndLabel = label.split(">>");
			label = stereotypesAndLabel[1];
			
			String stereotypes = stereotypesAndLabel[0];
			stereotypes = stereotypes.replace("<<", "");
			
			node.getStereotypes().clear();
			
			if ((node.getGraph() != null) && (node.getGraph().getPattern() != null) && (node.getGraph().getPattern().getBundle() != null)) {
				for (String stereotypeString : stereotypes.split(",")) {
					for (Profile profile : node.getGraph().getPattern().getBundle().getProfiles()) {
						for (Stereotype stereotype : profile.getStereotypes()) {
							if (stereotype.getName().equalsIgnoreCase(stereotypeString.trim())) {
								node.getStereotypes().add(stereotype);
							}
						}
					}
				}
			}
		}
		
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
