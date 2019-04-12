package org.sidiff.difference.symmetric.graphviewer.parts;

import java.util.Map;

import org.eclipse.gef.graph.Edge;
import org.eclipse.gef.mvc.fx.parts.IContentPart;
import org.eclipse.gef.zest.fx.parts.ZestFxContentPartFactory;

import com.google.inject.Inject;
import com.google.inject.Injector;

import javafx.scene.Node;

/**
 * (Compare to {@link org.eclipse.gef.zest.fx.parts.ZestFxContentPartFactory})
 * 
 * <p>Creates a content part (controller) for each given model element.</p>
 * 
 * @author Manuel Ohrndorf
 */
public class MatchingContentPartFactory extends ZestFxContentPartFactory {

	@Inject
	private Injector injector;

	@Override
	public IContentPart<? extends Node> createContentPart(Object content, Map<Object, Object> contextMap) {
		IContentPart<? extends Node> part = null;
		
		// Node:
		if (content instanceof org.eclipse.gef.graph.Node) {
			part = new MatchingNodeContentPart();
		} 
		
		// Edge:
		else if (content instanceof Edge) {
			part = new MatchingEdgeContentPart();
		} 
		
		// Zest:
		else {
			return super.createContentPart(content, contextMap);
		}
		
		// Inject members into the new content part:
		if (part != null) {
			injector.injectMembers(part);
		}
		
		return part;
	}
}
