package org.sidiff.consistency.graphpattern.design.service;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.sidiff.consistency.graphpattern.AttributePattern;
import org.sidiff.consistency.graphpattern.EdgePattern;
import org.sidiff.consistency.graphpattern.NodePattern;

public class LabelServices {

	public String getLabel(NodePattern nodePattern) {
		EClass type = nodePattern.getType();
		StringBuffer label = new StringBuffer();
		String name = nodePattern.getName() != null 
				? nodePattern.getName() : "";
		
		if (type == null) {
			label.append(name + " : " + "?");
		} else {
			label.append(name + " : " + type.getName());
		}
		
		if (nodePattern.getEvaluation() != null) {
			label.append(" [" + nodePattern.getEvaluation().getStore().getMatchSize() + "]");
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
}
