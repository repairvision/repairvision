package org.sidiff.difference.symmetric.graphviewer.parts;

import java.util.Collections;
import java.util.List;

import org.eclipse.gef.zest.fx.parts.EdgePart;
import org.sidiff.difference.symmetric.graphviewer.content.MatchingEdge;
import org.sidiff.difference.symmetric.graphviewer.content.MatchingGraphElement;
import org.sidiff.difference.symmetric.graphviewer.parts.design.ConnectionDesignMultiLabeled;

/**
 * (Compare to  {@link org.eclipse.gef.zest.fx.parts.EdgePart})
 * 
 * @author Manuel Ohrndorf
 */
public class MatchingEdgeContentPart extends EdgePart {
	
	@Override
	protected List<? extends Object> doGetContentChildren() {
		return Collections.emptyList();
	}
	
	@Override
	protected ConnectionDesignMultiLabeled doCreateVisual() {
		MatchingEdge matchingElement = (MatchingEdge) getContent().getAttributes().get(MatchingGraphElement.ATTRIBUTE_CONTENT);
		ConnectionDesignMultiLabeled visual = new ConnectionDesignMultiLabeled(matchingElement);
		return visual;
	}
	
	@Override
	public ConnectionDesignMultiLabeled getVisual() {
		return (ConnectionDesignMultiLabeled) super.getVisual();
	}

	/**
	 * @param labelsVisible
	 *            The visibility of the labels. (Shows tooltip instead.)
	 */
	public void setLabelsVisible(boolean labelsVisible) {
		getVisual().setLabelsVisible(labelsVisible);
	}
	
	/**
	 * @return The visibility of the labels. (Shows tooltip instead.)
	 */
	public boolean isLabelsVisible() {
		return getVisual().isLabelsVisible();
	}
}

