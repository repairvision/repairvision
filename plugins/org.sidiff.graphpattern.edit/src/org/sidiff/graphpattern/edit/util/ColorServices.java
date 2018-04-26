package org.sidiff.graphpattern.edit.util;

import org.sidiff.graphpattern.AttributePattern;
import org.sidiff.graphpattern.EdgePattern;
import org.sidiff.graphpattern.GraphElement;
import org.sidiff.graphpattern.NodePattern;
import org.sidiff.graphpattern.Profile;
import org.sidiff.graphpattern.Stereotype;
import org.sidiff.graphpattern.profile.IGraphPatternProfile;
import org.sidiff.graphpattern.profile.IGraphPatternVisualization;
import org.sidiff.graphpattern.profile.extensions.GraphPatternProfileEntry;
import org.sidiff.graphpattern.profile.extensions.GraphPatternProfileLibrary;

public class ColorServices {
	
	public static int[] getNodeLabelColor(Object element) {
		
		if (element instanceof NodePattern) {
			NodePattern node = (NodePattern) element;

			if (!node.getStereotypes().isEmpty()) {
				IGraphPatternVisualization visualization = getProfileVisualization(node);
				
				if (visualization != null) {
					return visualization.getNodeLabelColor((NodePattern) element);
				}
			}
		}
		
		return null;
	}
	
	public static int[] getEdgeLabelColor(Object element) {
		
		if (element instanceof EdgePattern) {
			EdgePattern edge = (EdgePattern) element;

			if (!edge.getStereotypes().isEmpty()) {
				IGraphPatternVisualization visualization = getProfileVisualization(edge);
				
				if (visualization != null) {
					return visualization.getEdgeLabelColor((EdgePattern) element);
				}
			}
		}
		
		return null;
	}
	
	public static int[] getAttributeLabelColor(Object element) {
		
		if (element instanceof AttributePattern) {
			AttributePattern attribute = (AttributePattern) element;

			if (!attribute.getStereotypes().isEmpty()) {
				IGraphPatternVisualization visualization = getProfileVisualization(attribute);
				
				if (visualization != null) {
					return visualization.getAttributeLabelColor((AttributePattern) element);
				}
			}
		}
		
		return null;
	}
	
	protected static IGraphPatternVisualization getProfileVisualization(GraphElement element) {
		if (!element.getStereotypes().isEmpty()) {
			Stereotype stereotype = element.getStereotypes().get(0);
			
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
