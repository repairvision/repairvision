package org.sidiff.graphpattern.design.service;

import org.eclipse.emf.ecore.EObject;
import org.sidiff.graphpattern.NodePattern;

public class ColorServices {

	// ***************** light_orange ***************** 
	
	public int getNodeColorR(EObject element) {
		
		if (element instanceof NodePattern) {
			NodePattern node = (NodePattern) element;
			
			if (node.getEvaluation() != null) {
				if (node.getEvaluation().getStore().getMatchSize() == 0) {
					return 255;
				}
			}
		}
		
		return 253;
	}
	
	public int getNodeColorG(EObject element) {
		
		if (element instanceof NodePattern) {
			NodePattern node = (NodePattern) element;
			
			if (node.getEvaluation() != null) {
				if (node.getEvaluation().getStore().getMatchSize() == 0) {
					return 255;
				}
			}
		}
		
		return 211;
	}
	
	public int getNodeColorB(EObject element) {
		
		if (element instanceof NodePattern) {
			NodePattern node = (NodePattern) element;
			
			if (node.getEvaluation() != null) {
				if (node.getEvaluation().getStore().getMatchSize() == 0) {
					return 255;
				}
			}
		}
		
		return 149;
	}
}
