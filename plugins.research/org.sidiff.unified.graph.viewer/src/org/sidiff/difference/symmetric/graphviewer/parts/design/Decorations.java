package org.sidiff.difference.symmetric.graphviewer.parts.design;

import org.sidiff.difference.symmetric.graphviewer.content.MatchingEdge;

import javafx.scene.shape.Polyline;

/**
 * Based on  {@link org.eclipse.gef.zest.fx.parts.EdgePart}
 */
public class Decorations {

	public static double DECORATION_SIZE_X = 10.0;
	
	public static double DECORATION_SIZE_Y = 3.0;
	
	public static class ArrowHead extends Polyline {
		public ArrowHead(MatchingEdge edge) {
			super(
					DECORATION_SIZE_X, 	0.0,
					DECORATION_SIZE_X, 	DECORATION_SIZE_Y,
					0.0, 				0.0,
					DECORATION_SIZE_X, 	-DECORATION_SIZE_Y,
					DECORATION_SIZE_X, 	0.0);
			
			setFill(edge.getDecorationColor());
			setStroke(edge.getDecorationColor());
		}
	}
	
	public static class Diamond extends Polyline {
		public Diamond(MatchingEdge edge) {
			super(
					DECORATION_SIZE_X, 		0.0,
					DECORATION_SIZE_X / 2, 	DECORATION_SIZE_Y,
					0.0, 					0.0,
					DECORATION_SIZE_X / 2, 	-DECORATION_SIZE_Y,
					DECORATION_SIZE_X, 		0.0);
			
			setFill(edge.getDecorationColor());
			setStroke(edge.getDecorationColor());
		}
	}
}
