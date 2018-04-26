package org.sidiff.graphpattern.edit.util;

import java.util.List;

import org.sidiff.graphpattern.AttributePattern;
import org.sidiff.graphpattern.EdgePattern;
import org.sidiff.graphpattern.NodePattern;
import org.sidiff.graphpattern.Stereotype;

public class LabelServices {

	public static String getLabel(NodePattern nodePattern) {
		if (nodePattern != null) {
			String name = "Node" + getStereotypesLabel(nodePattern.getStereotypes()) + ": " + getNodeName(nodePattern);
			
			if (nodePattern.getType() == null) {
				return name + " : " + "?";
			} else {
				return name + " : " + nodePattern.getType().getName();
			}
		} else {
			return "?";
		}
	}
	
	public static String getShortLabel(NodePattern nodePattern) {
		if (nodePattern != null) {
			String name = getNodeName(nodePattern);
			
			if (nodePattern.getType() == null) {
				return name + " : " + "?";
			} else {
				return name + " : " + nodePattern.getType().getName();
			}
		} else {
			return "?";
		}
	}
	
	private static String getNodeName(NodePattern nodePattern) {
		if ((nodePattern != null) && (nodePattern.getName() != null)) {
			return nodePattern.getName();
		} else {
			return "";
		}
	}
	
	public static String getLabel(AttributePattern attributePattern) {
		String name = "Attribute" + getStereotypesLabel(attributePattern.getStereotypes()) + ": ";
		
		if (attributePattern.getType() == null) {
			return name + "? = " + attributePattern.getValue();
		} else {
			return name + attributePattern.getType().getName() + " = " + attributePattern.getValue();
		}
	}
	
	public static String getLabel(EdgePattern edgePattern) {
		String name = "Edge" + getStereotypesLabel(edgePattern.getStereotypes()) + ": ";
		
		String beginNode = getShortLabel(edgePattern.getSource()); 
		String endNode = getShortLabel(edgePattern.getTarget());
		String type = (edgePattern.getType() != null) ? edgePattern.getType().getName() : "?";
		
		return name + "[" + beginNode + "] - " + type + " -> [" + endNode + "]";
	}
	
	public static String getStereotypesLabel(List<Stereotype> stereotypes) {
		
		if (!stereotypes.isEmpty()) {
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
		} else {
			return "";
		}
	}
}
