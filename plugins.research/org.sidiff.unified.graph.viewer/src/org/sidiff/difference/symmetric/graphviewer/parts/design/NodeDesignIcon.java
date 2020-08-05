package org.sidiff.difference.symmetric.graphviewer.parts.design;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.ui.provider.ExtendedImageRegistry;
import org.sidiff.difference.symmetric.graphviewer.content.MatchingNode;
import org.sidiff.difference.symmetric.graphviewer.parts.design.util.INodeSizeCalculator;
import org.sidiff.difference.symmetric.graphviewer.parts.design.util.ImmediateTooltip;
import org.sidiff.revision.common.emf.ItemProviderUtil;

import javafx.embed.swt.SWTFXUtils;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
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
public class NodeDesignIcon extends Region implements INodeSizeCalculator  {
	
	/**
	 * Stroke width of the frame.
	 */
	protected static double STROKE_WIDTH = 4.0;
	
	/**
	 * Size of the node.
	 */
	protected static double SIZE = 32.0;
	
	/**
	 * Creates a new {@link MatchingNode} visualization.
	 * 
	 * @param matchingElement
	 *            The {@link MatchingNode} to visualize.
	 */
	public NodeDesignIcon(MatchingNode matchingElement) {
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
		
		// Icon:
		ImageView icon = new ImageView();
		{
			icon.setFitHeight(SIZE / 2);
			icon.setFitWidth(SIZE / 2);
			
			// Set the icon:
			Object unknown_image_type = ItemProviderUtil.getImageByObject(representativeElement);
			org.eclipse.swt.graphics.Image swt_image = ExtendedImageRegistry.INSTANCE.getImage(unknown_image_type);

			// > EMF image:
			if (swt_image != null) {
				
				// Convert to JavaFX image:
	            WritableImage image = new WritableImage(swt_image.getBounds().width, swt_image.getBounds().height);
				SWTFXUtils.toFXImage(swt_image.getImageData(), image);
				icon.setImage(image);
			}
			
			// Parent layout:
			double iconSize = 16.0;
			double anchorPosition = (SIZE - iconSize) / 2; 
			
			AnchorPane.setLeftAnchor(icon, anchorPosition);
			AnchorPane.setRightAnchor(icon, anchorPosition);
			AnchorPane.setTopAnchor(icon, anchorPosition);
			AnchorPane.setBottomAnchor(icon, anchorPosition);
		}
		pane.getChildren().add(icon);
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
