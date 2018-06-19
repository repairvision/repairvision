package org.sidiff.graphpattern.edit.util;

import java.util.List;

import org.sidiff.graphpattern.AttributePattern;
import org.sidiff.graphpattern.EdgePattern;
import org.sidiff.graphpattern.GraphElement;
import org.sidiff.graphpattern.NodePattern;
import org.sidiff.graphpattern.Stereotype;

public class LabelServices {

	public static String getLabel(NodePattern nodePattern) {
		if (nodePattern != null) {
			String name = getStereotypedGraphElementName(nodePattern);
			
			if (nodePattern.getType() == null) {
				return name + "?";
			} else {
				return name + nodePattern.getType().getName();
			}
		} else {
			return "?";
		}
	}
	
	public static String getShortLabel(NodePattern nodePattern) {
		if (nodePattern != null) {
			String name = getGraphElementName(nodePattern);
			
			if (nodePattern.getType() == null) {
				return name + "?";
			} else {
				return name + nodePattern.getType().getName();
			}
		} else {
			return "?";
		}
	}
	
	public static String getLabel(AttributePattern attributePattern) {
		String name = getStereotypedGraphElementName(attributePattern);
		
		if (attributePattern.getType() == null) {
			return name + "? = " + attributePattern.getValue();
		} else {
			return name + attributePattern.getType().getName() + " = " + attributePattern.getValue();
		}
	}
	
	public static String getLabel(EdgePattern edgePattern) {
		String name = getStereotypedGraphElementName(edgePattern);
		
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
			return label.toString() + " ";
		} else {
			return "";
		}
	}
	
	private static String getStereotypedGraphElementName(GraphElement graphElement) {
		return graphElement.getStereotypes().isEmpty() ?
				getGraphElementName(graphElement)
				: getStereotypesLabel(graphElement.getStereotypes()) + " " + getGraphElementName(graphElement);
	}
	
	private static String getGraphElementName(GraphElement graphElement) {
		if ((graphElement != null) && (graphElement.getName() != null) && (graphElement.getName() != "")) {
			return graphElement.getName() + " : ";
		} else {
			return "";
		}
	}
}
