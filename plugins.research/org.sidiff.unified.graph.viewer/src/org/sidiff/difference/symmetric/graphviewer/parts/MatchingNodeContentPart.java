package org.sidiff.difference.symmetric.graphviewer.parts;

import org.eclipse.gef.zest.fx.parts.NodePart;
import org.sidiff.difference.symmetric.graphviewer.content.MatchingGraphElement;
import org.sidiff.difference.symmetric.graphviewer.content.MatchingNode;
import org.sidiff.difference.symmetric.graphviewer.parts.design.NodeDesignSwitcher;
import org.sidiff.difference.symmetric.graphviewer.parts.design.NodeDesignSwitcher.Design;

/**
 * (Compare to {@link org.eclipse.gef.zest.fx.parts.NodePart})
 * 
 * @author Manuel Ohrndorf
 */
public class MatchingNodeContentPart extends NodePart {
	
	@Override
	protected NodeDesignSwitcher doCreateVisual() {
		MatchingNode matchingElement = (MatchingNode) getContent().getAttributes().get(MatchingGraphElement.ATTRIBUTE_CONTENT);
		return new NodeDesignSwitcher(matchingElement);
	}
	
	@Override
	public NodeDesignSwitcher getVisual() {
		return (NodeDesignSwitcher) super.getVisual();
	}
	
	/**
	 * @param design
	 *            The actual design type.
	 */
	public void setDesign(Design design) {
		getVisual().setDesign(design);
	}
	
	/**
	 * @param design
	 *            The actual design type.
	 */
	public Design getDesign() {
		return getVisual().getDesign();
	}
}
