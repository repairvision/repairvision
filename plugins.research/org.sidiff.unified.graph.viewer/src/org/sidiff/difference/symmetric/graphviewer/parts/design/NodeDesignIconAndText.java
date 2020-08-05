package org.sidiff.difference.symmetric.graphviewer.parts.design;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.ui.provider.ExtendedImageRegistry;
import org.sidiff.difference.symmetric.graphviewer.content.MatchingNode;
import org.sidiff.difference.symmetric.graphviewer.parts.design.util.INodeSizeCalculator;
import org.sidiff.difference.symmetric.graphviewer.parts.design.util.JavaFXUtil;
import org.sidiff.revision.common.emf.ItemProviderUtil;

import javafx.embed.swt.SWTFXUtils;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;
import javafx.scene.text.Text;

/**
 * {@link MatchingNode} node design.
 *
 * @author Manuel Ohrndorf
 */
public class NodeDesignIconAndText extends Region implements INodeSizeCalculator  {
	
	/* Global design properties*/
	
	/**
	 * Minimum width of the resizeable node.
	 */
	protected static double MIN_WIDTH = 120;
	
	/**
	 * Minimum width of the resizeable node.
	 */
	protected static double MAX_WIDTH = Double.MAX_VALUE;
	
	/**
	 * Auto-layout bound of the nodes. 
	 */
	protected static double LAYOUT_MIN_WIDTH = 180;
	
	/**
	 * Auto-layout bound of the nodes. 
	 */
	protected static double LAYOUT_MAX_WIDTH = 250;
	
	/**
	 * The header shows the icon and the label of the {@link MatchingNode}.
	 */
	protected static double HEADER_HEIGHT = 30.0;
	
	/**
	 * Stroke width of the frame.
	 */
	protected static double STROKE_WIDTH = 4.0;
	
	/**
	 * The fixed height of this design
	 */
	protected static double  FIXED_HEIGHT = HEADER_HEIGHT + 2 * STROKE_WIDTH;
	
	/**
	 * Make the frame corners round.
	 */
	protected static double FRAME_CORNER_ARC = 10.0;
	
	/**
	 * E.g. margins from the frame.
	 */
	protected static final double TEXT_SPACE = 2.0;
	
	/* Local design properties */
	
	/**
	 * Actual width.
	 */
	protected double WIDTH = -1;
	
	/* JavaFX elements */
	
	/**
	 * The layout root pane.
	 */
	protected AnchorPane rootPane;
	
	/**
	 * Grid that contains the header and the scrollpane.
	 */
	protected GridPane mainGrid;
	
	/**
	 * The outer frame of the node.
	 */
	protected Rectangle frame;

	/**
	 * The header shows the icon and the label of the {@link MatchingNode}.
	 */
	protected HBox headerPane;
	
	/**
	 * Creates a new {@link MatchingNode} visualization.
	 * 
	 * @param matchingElement
	 *            The {@link MatchingNode} to visualize.
	 */
	public NodeDesignIconAndText(MatchingNode matchingElement) {
		EObject representativeElement = matchingElement.getRepresentativeElement();
		
		/*
		 * Design
		 */
		
		double columnSize = LAYOUT_MAX_WIDTH - (2 * STROKE_WIDTH);
		
 		/*
 		 * Frame:
 		 */
		
		// Main pane:
		rootPane = new AnchorPane();
		{
			// Size:
			rootPane.setMinWidth(AnchorPane.USE_PREF_SIZE);
			rootPane.setMinHeight(AnchorPane.USE_PREF_SIZE);
			rootPane.setPrefHeight(FIXED_HEIGHT);
			rootPane.setPrefWidth(LAYOUT_MAX_WIDTH);
			rootPane.setMaxWidth(AnchorPane.USE_PREF_SIZE);
			rootPane.setMaxHeight(AnchorPane.USE_PREF_SIZE);
		}
		getChildren().add(rootPane);
		
		// Frame:
		frame = new Rectangle();
		{
			// Corners:
			frame.setArcHeight(FRAME_CORNER_ARC);
			frame.setArcWidth(FRAME_CORNER_ARC);
			
			// Size:
			frame.setHeight(FIXED_HEIGHT);
			frame.setWidth(LAYOUT_MAX_WIDTH);
			
			// Design:
			Color colorBorder = matchingElement.getBorderColor();
			Color colorBackground = matchingElement.getBackgroundColor();
			
			frame.setStroke(colorBorder);
			frame.setFill(colorBackground);
			frame.setStrokeWidth(STROKE_WIDTH);
			frame.setStrokeType(StrokeType.INSIDE);
			
			// Parent layout:
			AnchorPane.setLeftAnchor(frame, 0.0);
			AnchorPane.setRightAnchor(frame, 0.0);
			AnchorPane.setTopAnchor(frame, 0.0);
			AnchorPane.setBottomAnchor(frame, 0.0);
		}
		rootPane.getChildren().add(frame);
		
		// Header + Attributes Grid:
		mainGrid = new GridPane();
		{
			// Columns:
			ColumnConstraints cc = new ColumnConstraints();
			{
				cc.setMinWidth(0.0); // Needs some value to fix the scrollpane layout calculation.
				cc.setPrefWidth(GridPane.USE_COMPUTED_SIZE);
				cc.setMaxWidth(GridPane.USE_COMPUTED_SIZE);
			}
			mainGrid.getColumnConstraints().add(cc);
			
			// Rows:
			RowConstraints rcHeader = new RowConstraints();
			{
				rcHeader.setMinHeight(GridPane.USE_PREF_SIZE);
				rcHeader.setPrefHeight(HEADER_HEIGHT);
				rcHeader.setMaxHeight(GridPane.USE_PREF_SIZE);
				rcHeader.setValignment(VPos.CENTER);
				rcHeader.setVgrow(Priority.NEVER);
			}
			mainGrid.getRowConstraints().add(rcHeader);
			
			RowConstraints rcLine = new RowConstraints();
			{
				rcLine.setMinHeight(GridPane.USE_PREF_SIZE);
				rcLine.setPrefHeight(GridPane.USE_COMPUTED_SIZE);
				rcLine.setMaxHeight(GridPane.USE_PREF_SIZE);
				rcLine.setValignment(VPos.CENTER);
				rcLine.setVgrow(Priority.NEVER);
			}
			mainGrid.getRowConstraints().add(rcLine);
			
			RowConstraints rcAttributes = new RowConstraints();
			{
				rcAttributes.setMinHeight(GridPane.USE_COMPUTED_SIZE);
				rcAttributes.setPrefHeight(GridPane.USE_COMPUTED_SIZE);
				rcAttributes.setMaxHeight(GridPane.USE_COMPUTED_SIZE);
				rcAttributes.setValignment(VPos.TOP);
				rcAttributes.setVgrow(Priority.ALWAYS);
			}
			mainGrid.getRowConstraints().add(rcAttributes);
			
			// Parent layout:
			AnchorPane.setLeftAnchor(mainGrid, STROKE_WIDTH);
			AnchorPane.setRightAnchor(mainGrid, STROKE_WIDTH);
			AnchorPane.setTopAnchor(mainGrid, STROKE_WIDTH);
			AnchorPane.setBottomAnchor(mainGrid, STROKE_WIDTH);
		}
		rootPane.getChildren().add(mainGrid);
		
		/*
		 * Header: 
		 */
		
		// Header pane:
		headerPane = new HBox();
		{
			// Size:
			headerPane.setMinWidth(HBox.USE_PREF_SIZE);
			headerPane.setMinHeight(HBox.USE_PREF_SIZE);
			headerPane.setPrefHeight(HBox.USE_COMPUTED_SIZE);
			headerPane.setPrefWidth(columnSize);
			headerPane.setMaxWidth(HBox.USE_PREF_SIZE);
			headerPane.setMaxHeight(HBox.USE_PREF_SIZE);
			
			// Parent layout:
			GridPane.setHgrow(headerPane, Priority.NEVER);
			GridPane.setVgrow(headerPane, Priority.NEVER);
			GridPane.setValignment(headerPane, VPos.CENTER);
			GridPane.setHalignment(headerPane, HPos.LEFT);
		}
		mainGrid.getChildren().add(headerPane);
		
		// > Value label:
		Label elementLabel = new Label();
		{
			// Label text:
			String itemText = ItemProviderUtil.getTextByObject(representativeElement);
			itemText = itemText.replaceFirst("\\[\\d\\]", ""); // FIXME: WORKAROUND: Remove leading matching count -> make a label configuration! 
			elementLabel.setText(itemText);
			
			// Size:
			elementLabel.setMinWidth(HBox.USE_COMPUTED_SIZE);
			elementLabel.setMinHeight(HBox.USE_COMPUTED_SIZE);
			elementLabel.setPrefHeight(HBox.USE_COMPUTED_SIZE);
			elementLabel.setPrefWidth(HBox.USE_COMPUTED_SIZE);
			elementLabel.setMaxWidth(Double.MAX_VALUE);
			elementLabel.setMaxHeight(HBox.USE_COMPUTED_SIZE);
			
			// Label layout:
			elementLabel.setAlignment(Pos.CENTER);
			
			// Parent layout:
			HBox.setHgrow(elementLabel, Priority.ALWAYS);
			HBox.setMargin(elementLabel, new Insets(0, TEXT_SPACE, 0, TEXT_SPACE));
		}
		headerPane.getChildren().add(elementLabel);
		
		// > Count of elements (in the correspondence) with the same attribute value:
		Text matchingCountLabel = new Text();
		{
			// Set the text:
			matchingCountLabel.setText("[" + matchingElement.getElementCount() + "]");
			
			// Set the icon:
			Object unknown_image_type = ItemProviderUtil.getImageByObject(representativeElement);
			org.eclipse.swt.graphics.Image swt_image = ExtendedImageRegistry.INSTANCE.getImage(unknown_image_type);

			// > EMF image:
			if (swt_image != null) {
				
				// Convert to JavaFX image:
	            WritableImage image = new WritableImage(swt_image.getBounds().width, swt_image.getBounds().height);
				SWTFXUtils.toFXImage(swt_image.getImageData(), image);
				ImageView imageView = new ImageView(image);
				elementLabel.setGraphic(imageView);
			}

			// > Image type unknown:
			else {
				elementLabel.setGraphic(null);
			}
			
			matchingCountLabel.setStrokeType(StrokeType.OUTSIDE);
			matchingCountLabel.setStrokeWidth(0.0);
			
			// Parent layout:
			HBox.setHgrow(matchingCountLabel, Priority.NEVER);
			HBox.setMargin(matchingCountLabel, new Insets(0, TEXT_SPACE, 0, 0));
		}
		headerPane.getChildren().add(matchingCountLabel);
	}

	@Override
	public double calculateLayoutHeight() {
		return FIXED_HEIGHT;
	}
	
	@Override
	public double calculateLayoutWidth() {
		// The image width: 16
		// Estimate the image to text space: 4
		double size = 16 + 4 + (2 * STROKE_WIDTH) + (3 * TEXT_SPACE); 
		size += 2; // safety zone
		
		for (Node child : headerPane.getChildren()) {
			if ((child instanceof Label) || (child instanceof Text)) {
				size += JavaFXUtil.getTextWidth(child);
			}
		}
		
		size = Math.max(size, LAYOUT_MIN_WIDTH);
		size = Math.min(size, LAYOUT_MAX_WIDTH);
		return size;
	}

	@Override
	public boolean isResizable() {
		return true;
	}

	@Override
	public void resize(double w, double h) {

		// Minimum size:
		w = Math.max(w, MIN_WIDTH);
		h = FIXED_HEIGHT;
		
		// Maximum size:
		w = Math.min(w, MAX_WIDTH);
		
		// Resize only if one dimension has changed:
		if (WIDTH == w) {
			return;
		} else {
			WIDTH = h;
		}
						
		// > Inner panes:
		double innerSize = w - (2 * STROKE_WIDTH);

		// Layout:
		
		// > Pane:
		rootPane.setPrefWidth(w);
		rootPane.setPrefHeight(h);
		
		// > Box:
		frame.setWidth(w);
		frame.setHeight(h);
		
		// > Header:
		headerPane.setPrefWidth(innerSize); 
	}
}
