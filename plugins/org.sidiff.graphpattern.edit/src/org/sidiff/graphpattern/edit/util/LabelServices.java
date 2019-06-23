package org.sidiff.graphpattern.edit.util;

import java.util.List;

import org.sidiff.graphpattern.AttributePattern;
import org.sidiff.graphpattern.EdgePattern;
import org.sidiff.graphpattern.GraphPattern;
import org.sidiff.graphpattern.NodePattern;
import org.sidiff.graphpattern.Pattern;
import org.sidiff.graphpattern.PatternElement;
import org.sidiff.graphpattern.Stereotype;
import org.sidiff.graphpattern.SubGraph;

public class LabelServices {

	public static String getLabel(NodePattern nodePattern) {
		if (nodePattern != null) {
			String name = getStereotypedPatternElementName(nodePattern) + " : ";
			
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
			String name = getPatternElementName(nodePattern) + " : ";
			
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
		String name = getStereotypedPatternElementName(attributePattern);
		name = (attributePattern.getName() != null) ?  name  + " : " : name;
		
		if (attributePattern.getType() == null) {
			return name + "? = " + attributePattern.getValue();
		} else {
			return name + attributePattern.getType().getName() + " = " + attributePattern.getValue();
		}
	}
	
	public static String getLabel(EdgePattern edgePattern) {
		String name = getStereotypedPatternElementName(edgePattern);
		name = (edgePattern.getName() != null) ?  name  + " : " : name;
		
		String beginNode = getShortLabel(edgePattern.getSource()); 
		String endNode = getShortLabel(edgePattern.getTarget());
		String type = (edgePattern.getType() != null) ? edgePattern.getType().getName() : "?";
		
		return name + "[" + beginNode + "] - " + type + " -> [" + endNode + "]";
	}
	
	public static String getLabel(GraphPattern graphPattern) {
		return getStereotypedPatternElementName(graphPattern);
	}
	
	public static String getLabel(Pattern pattern) {
		return getStereotypedPatternElementName(pattern);
	}
	
	public static String getLabel(SubGraph subGraph) {
		return getStereotypedPatternElementName(subGraph);
	}
	
	public static String getLabel(PatternElement patternElement) {
		return getStereotypedPatternElementName(patternElement);
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
	
	private static String getStereotypedPatternElementName(PatternElement graphElement) {
		return graphElement.getStereotypes().isEmpty() ?
				getPatternElementName(graphElement)
				: getStereotypesLabel(graphElement.getStereotypes()) + " " + getPatternElementName(graphElement);
	}
	
	private static String getPatternElementName(PatternElement graphElement) {
		if ((graphElement != null) && (graphElement.getName() != null) && (graphElement.getName() != "")) {
			return graphElement.getName();
		} else {
			return "";
		}
	}
}
