package org.sidiff.graphpattern.design.service;

import org.eclipse.emf.ecore.EObject;
import org.sidiff.graphpattern.EdgePattern;
import org.sidiff.graphpattern.GraphElement;
import org.sidiff.graphpattern.NodePattern;
import org.sidiff.graphpattern.Profile;
import org.sidiff.graphpattern.Stereotype;
import org.sidiff.graphpattern.profile.IGraphPatternProfile;
import org.sidiff.graphpattern.profile.IGraphPatternVisualization;
import org.sidiff.graphpattern.profile.IGraphPatternVisualization.Gradient;
import org.sidiff.graphpattern.profile.extensions.GraphPatternProfileEntry;
import org.sidiff.graphpattern.profile.extensions.GraphPatternProfileLibrary;

public class ColorServices {
	
	/**
	 * Default node background color (first gradient color): white
	 */
	protected int[] DEFAULT_NODE_BACKGROUND_FROM = {255, 255, 255};
	
	/**
	 * Default node background color (second gradient color): light orange
	 */
	protected int[] DEFAULT_NODE_BACKGROUND_TO = {253, 211, 149};
	
	/**
	 * Unmatched node background color (first gradient color): white
	 */
	protected int[] UNMATCHED_NODE_BACKGROUND_FROM = {255, 255, 255};
	
	/**
	 * Unmatched node background color (second gradient color): white
	 */
	protected int[] UNMATCHED_NODE_BACKGROUND_TO = {255, 255, 255};
	
	/**
	 * Default node frame color: black
	 */
	protected int[] DEFAULT_NODE_FRAME = {0, 0, 0};
	
	/**
	 * Default node label color: black
	 */
	protected int[] DEFAULT_NODE_LABEL = {0, 0, 0};

	/**
	 * Default edge line color: black
	 */
	protected int[] DEFAULT_EDGE_LINE = {0, 0, 0};
	
	/**
	 * Default edge label color: black
	 */
	protected int[] DEFAULT_EDGE_LABEL = {0, 0, 0};
	
	public int getNodeBackgroundToColorR(EObject element) {
		return getNodeBackgroundColor(element, Gradient.TO)[0];
	}
	
	public int getNodeBackgroundFromColorR(EObject element) {
		return getNodeBackgroundColor(element, Gradient.FROM)[0];
	}
	
	public int getNodeBackgroundToColorG(EObject element) {
		return getNodeBackgroundColor(element, Gradient.TO)[1];
	}
	
	public int getNodeBackgroundFromColorG(EObject element) {
		return getNodeBackgroundColor(element, Gradient.FROM)[1];
	}
	
	public int getNodeBackgroundToColorB(EObject element) {
		return getNodeBackgroundColor(element, Gradient.TO)[2];
	}
	
	public int getNodeBackgroundFromColorB(EObject element) {
		return getNodeBackgroundColor(element, Gradient.FROM)[2];
	}
	
	protected int[] getNodeBackgroundColor(EObject element, Gradient gradient) {
		
		if (element instanceof NodePattern) {
			NodePattern node = (NodePattern) element;
			
			if (node.getMatching() != null) {
				if (node.getMatching().size() == 0) {
					switch (gradient) {
					case FROM:
						return UNMATCHED_NODE_BACKGROUND_FROM;
					case TO:
						return UNMATCHED_NODE_BACKGROUND_TO;
					}
				}
			}
			
			if (!node.getStereotypes().isEmpty()) {
				IGraphPatternVisualization visualization = getProfileVisualization(node);
				
				if (visualization != null) {
					return visualization.getNodeBackgroundColor(node, gradient);
				}
			}
		}
		
		switch (gradient) {
		case FROM:
			return DEFAULT_NODE_BACKGROUND_FROM;
		case TO:
			return DEFAULT_NODE_BACKGROUND_TO;
		default:
			return new int[] {255, 255, 255};
		}
	}
	
	public int getNodeFrameColorR(EObject element) {
		return getNodeFrameColor(element)[0];
	}
	
	public int getNodeFrameColorG(EObject element) {
		return getNodeFrameColor(element)[1];
	}
	
	public int getNodeFrameColorB(EObject element) {
		return getNodeFrameColor(element)[2];
	}
	
	protected int[] getNodeFrameColor(EObject element) {
		
		if (element instanceof NodePattern) {
			NodePattern node = (NodePattern) element;

			if (!node.getStereotypes().isEmpty()) {
				IGraphPatternVisualization visualization = getProfileVisualization(node);
				
				if (visualization != null) {
					return visualization.getNodeFrameColor((NodePattern) element);
				}
			}
		}
		
		return DEFAULT_NODE_FRAME;
	}
	
	public int getNodeLabelColorR(EObject element) {
		return getNodeLabelColor(element)[0];
	}
	
	public int getNodeLabelColorG(EObject element) {
		return getNodeLabelColor(element)[1];
	}
	
	public int getNodeLabelColorB(EObject element) {
		return getNodeLabelColor(element)[2];
	}
	
	protected int[] getNodeLabelColor(EObject element) {
		
		if (element instanceof NodePattern) {
			NodePattern node = (NodePattern) element;

			if (!node.getStereotypes().isEmpty()) {
				IGraphPatternVisualization visualization = getProfileVisualization(node);
				
				if (visualization != null) {
					return visualization.getNodeLabelColor((NodePattern) element);
				}
			}
		}
		
		return DEFAULT_NODE_LABEL;
	}
	
	public int getEdgeLineColorR(EObject element) {
		return getEdgeLineColor(element)[0];
	}
	
	public int getEdgeLineColorG(EObject element) {
		return getEdgeLineColor(element)[1];
	}
	
	public int getEdgeLineColorB(EObject element) {
		return getEdgeLineColor(element)[2];
	}
	
	protected int[] getEdgeLineColor(EObject element) {
		
		if (element instanceof EdgePattern) {
			EdgePattern edge = (EdgePattern) element;

			if (!edge.getStereotypes().isEmpty()) {
				IGraphPatternVisualization visualization = getProfileVisualization(edge);
				
				if (visualization != null) {
					return visualization.getEdgeLineColor((EdgePattern) element);
				}
			}
		}
		
		return DEFAULT_EDGE_LINE;
	}
	
	public int getEdgeLabelColorR(EObject element) {
		return getEdgeLabelColor(element)[0];
	}
	
	public int getEdgeLabelColorG(EObject element) {
		return getEdgeLabelColor(element)[1];
	}
	
	public int getEdgeLabelColorB(EObject element) {
		return getEdgeLabelColor(element)[2];
	}
	
	protected int[] getEdgeLabelColor(EObject element) {
		
		if (element instanceof EdgePattern) {
			EdgePattern edge = (EdgePattern) element;

			if (!edge.getStereotypes().isEmpty()) {
				IGraphPatternVisualization visualization = getProfileVisualization(edge);
				
				if (visualization != null) {
					return visualization.getEdgeLabelColor((EdgePattern) element);
				}
			}
		}
		
		return DEFAULT_EDGE_LABEL;
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
