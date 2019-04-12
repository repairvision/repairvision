package org.sidiff.difference.symmetric.graphviewer.content;

import javafx.scene.paint.Color;

public abstract class MatchingGraphElement {

	public static final String ATTRIBUTE_CONTENT = "CONTENT";
	
	public Color getBorderColor() {
		return Color.BLACK;
	}
	
	public Color getBackgroundColor() {
		return Color.GREY;
	}
	
	public Color getTextColor() {
		return Color.BLACK;
	}
}
