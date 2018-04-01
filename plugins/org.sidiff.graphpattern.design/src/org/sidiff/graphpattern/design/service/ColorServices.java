package org.sidiff.graphpattern.design.service;

import org.eclipse.emf.ecore.EObject;
import org.sidiff.graphpattern.NodePattern;
import org.sidiff.graphpattern.Profile;
import org.sidiff.graphpattern.Stereotype;
import org.sidiff.graphpattern.profile.IGraphPatternProfile;
import org.sidiff.graphpattern.profile.IGraphPatternVisualization;
import org.sidiff.graphpattern.profile.extensions.GraphPatternProfileEntry;
import org.sidiff.graphpattern.profile.extensions.GraphPatternProfileLibrary;

public class ColorServices {

	public int getNodeColorR(EObject element) {
		
		if (element instanceof NodePattern) {
			NodePattern node = (NodePattern) element;
			
			if (node.getMatching() != null) {
				if (node.getMatching().size() == 0) {
					return 255;
				}
			}
			
			if (!node.getStereotypes().isEmpty()) {
				IGraphPatternVisualization visualization = getProfileVisualization(node);
				
				if (visualization != null) {
					return visualization.getBackgroundColor(node)[0];
				}
			}
		}
		
		return 253;
	}
	
	public int getNodeColorG(EObject element) {
		
		if (element instanceof NodePattern) {
			NodePattern node = (NodePattern) element;
			
			if (node.getMatching() != null) {
				if (node.getMatching().size() == 0) {
					return 255;
				}
			}
			
			if (!node.getStereotypes().isEmpty()) {
				IGraphPatternVisualization visualization = getProfileVisualization(node);
				
				if (visualization != null) {
					return visualization.getBackgroundColor(node)[1];
				}
			}
		}
		
		return 211;
	}
	
	public int getNodeColorB(EObject element) {
		
		if (element instanceof NodePattern) {
			NodePattern node = (NodePattern) element;
			
			if (node.getMatching() != null) {
				if (node.getMatching().size() == 0) {
					return 255;
				}
			}
			
			if (!node.getStereotypes().isEmpty()) {
				IGraphPatternVisualization visualization = getProfileVisualization(node);
				
				if (visualization != null) {
					return visualization.getBackgroundColor(node)[2];
				}
			}
		}
		
		return 149;
	}
	
	protected static IGraphPatternVisualization getProfileVisualization(NodePattern node) {
		if (!node.getStereotypes().isEmpty()) {
			Stereotype stereotype = node.getStereotypes().get(0);
			
			if (stereotype.eContainer() instanceof Profile) {
				Profile profile = (Profile) stereotype.eContainer();
				GraphPatternProfileEntry extension = GraphPatternProfileLibrary.getEntry(profile.getId());
				
				if (extension != null) {
					IGraphPatternProfile profileExtension = extension.getProfile();
					
					if (profileExtension != null) {
						return profileExtension.getVisualization();
					}
				}
			}
		}
		return null;
	}
}
