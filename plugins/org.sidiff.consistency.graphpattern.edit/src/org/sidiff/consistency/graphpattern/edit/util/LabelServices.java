package org.sidiff.consistency.graphpattern.edit.util;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EReference;
import org.sidiff.consistency.graphpattern.AttributePattern;
import org.sidiff.consistency.graphpattern.EdgePattern;
import org.sidiff.consistency.graphpattern.NodePattern;

public class LabelServices {

	public static String getLabel(NodePattern nodePattern) {
		if ((nodePattern == null) || (nodePattern.getType() == null)) {
			return getNodeName(nodePattern) + ": " + "?";
		} else {
			return getNodeName(nodePattern) + ": " + nodePattern.getType().getName();
		}
	}
	
	private static String getNodeName(NodePattern nodePattern) {
		if ((nodePattern != null) && (nodePattern.getName() != null)) {
			return nodePattern.getName() + " ";
		} else {
			return "";
		}
	}
	
	public static String getLabel(AttributePattern attributePattern) {
		EAttribute type = attributePattern.getType();
		
		if (type == null) {
			return "Attribute: " + "? = " + attributePattern.getValue();
		} else {
			return "Attribute: " + type.getName() + " = " + attributePattern.getValue();
		}
	}
	
	public static String getLabel(EdgePattern edgePattern) {
		String beginNode = getLabel(edgePattern.getSource()); 
		String beginLabel = getEdgeBeginLabel(edgePattern);
		String endNode = getLabel(edgePattern.getTarget());
		String endLabel = getEdgeEndLabel(edgePattern);
		
		if (edgePattern.isCrossReference()) {
			return "Edge: [" + beginNode + "." +  "^" + beginLabel + "]";
		}
		
		else if (!endLabel.equals("")) {
			return "Edge: [" + beginNode + "." + beginLabel + "] -> [" + endNode + "." + endLabel + "]";
		} 
		
		else {
			return "Edge: [" + beginNode + "." +  beginLabel + "]";
		}
	}
	
	public static String getEdgeBeginLabel(EdgePattern edgePattern) {
		EReference type = edgePattern.getType();
		
		if (type == null) {
			return "?";
		} else {
			return type.getName();
		}
	}
	
	public static String getEdgeEndLabel(EdgePattern edgePattern) {
		EdgePattern opposite = edgePattern.getOpposite();
		
		if ((opposite != null) && (!opposite.isCrossReference())) {
			EReference type = edgePattern.getOpposite().getType();
			
			if (type == null) {
				return "?";
			} else {
				return type.getName();
			}	
		}
		return "";
	}
}
