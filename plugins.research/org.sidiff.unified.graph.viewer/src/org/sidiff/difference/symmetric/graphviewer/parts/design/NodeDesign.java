package org.sidiff.difference.symmetric.graphviewer.parts.design;

import org.eclipse.emf.ecore.EObject;
import org.sidiff.difference.symmetric.graphviewer.content.MatchingNode;
import org.sidiff.difference.symmetric.graphviewer.parts.design.util.INodeSizeCalculator;
import org.sidiff.difference.symmetric.graphviewer.parts.design.util.ImmediateTooltip;
import org.sidiff.revision.common.emf.ItemProviderUtil;

import javafx.scene.control.Tooltip;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.StrokeType;

/**
 * {@link MatchingNode} node design.
 *
 * @author Manuel Ohrndorf
 */
public class NodeDesign extends Region implements INodeSizeCalculator {
	
	/**
	 * Stroke width of the frame.
	 */
	protected static double STROKE_WIDTH = 4.0;
	
	/**
	 * Size of the node.
	 */
	protected static double SIZE = 16.0;
	
	/**
	 * Creates a new {@link MatchingNode} visualization.
	 * 
	 * @param matchingElement
	 *            The {@link MatchingNode} to visualize.
	 */
	public NodeDesign(MatchingNode matchingElement) {
		EObject representativeElement = matchingElement.getRepresentativeElement();
		
		// Tooltip:
		Tooltip labelTooltip = new Tooltip();
		{
			String label = ItemProviderUtil.getTextByObject(representativeElement);
			labelTooltip.setText(label);
			
			ImmediateTooltip.install(this, new Tooltip(label));
		}
		
		// Main pane:
		AnchorPane pane = new AnchorPane();
		{
			pane.setPrefHeight(SIZE);
			pane.setPrefWidth(SIZE);
		}
		getChildren().addAll(pane);
		
		// Circle:
		Circle node = new Circle(SIZE / 2);
		{
			Color colorBorder = matchingElement.getBorderColor();
			Color colorBackground = matchingElement.getBackgroundColor();
			
			node.setStroke(colorBorder);
			node.setStrokeWidth(STROKE_WIDTH);
			node.setStrokeType(StrokeType.INSIDE);
			node.setFill(colorBackground);
			
			// Parent layout:
			AnchorPane.setLeftAnchor(node, 0.0);
			AnchorPane.setRightAnchor(node, 0.0);
			AnchorPane.setTopAnchor(node, 0.0);
			AnchorPane.setBottomAnchor(node, 0.0);
		}
		pane.getChildren().add(node);
	}
	
	@Override
	public boolean isResizable() {
		return false;
	}

	@Override
	public double calculateLayoutWidth() {
		return -1;
	}

	@Override
	public double calculateLayoutHeight() {
		return -1;
	}
}
