package org.sidiff.difference.symmetric.graphviewer.parts.design;

import org.sidiff.difference.symmetric.graphviewer.parts.design.util.JavaFXUtil;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;
import javafx.scene.text.Text;

/**
 * @author Manuel Ohrndorf
 */
public class PrimitiveAttributeDesign {

	/**
	 * E.g. margins from the frame.
	 */
	private static final double TEXT_SPACE = 2.0;
	
	/**
	 * Prevents that the attribute type label is complete reduced to '...' 
	 * (when the value label gets to long).
	 */
	private static final double TYPE_LABEL_OVERRUN_MIN_WEIDTH = 50.0;
	
	public static Node create(String type, String value, int matchingCount, double width) {

		// Layout:
		HBox layout = new HBox();
		{
			// Size:
			layout.setMinWidth(HBox.USE_PREF_SIZE);
			layout.setMinHeight(HBox.USE_PREF_SIZE);
			layout.setPrefHeight(HBox.USE_COMPUTED_SIZE);
			layout.setPrefWidth(width);
			layout.setMaxWidth(HBox.USE_PREF_SIZE);
			layout.setMaxHeight(HBox.USE_PREF_SIZE);
			
			// Parent layout:
			GridPane.setHgrow(layout, Priority.NEVER);
			GridPane.setVgrow(layout, Priority.NEVER);
			GridPane.setValignment(layout, VPos.CENTER);
			GridPane.setHalignment(layout, HPos.LEFT);
		}
		
		// Type Label:
		Label typeLabel = new Label();
		{
			typeLabel.setText(type);
			
			// Size:
			double textWidth = JavaFXUtil.getTextWidth(typeLabel);
			
			typeLabel.setMinWidth((textWidth < TYPE_LABEL_OVERRUN_MIN_WEIDTH) 
					? textWidth : TYPE_LABEL_OVERRUN_MIN_WEIDTH);
			typeLabel.setMinHeight(HBox.USE_COMPUTED_SIZE);
			typeLabel.setPrefHeight(HBox.USE_COMPUTED_SIZE);
			typeLabel.setPrefWidth(HBox.USE_COMPUTED_SIZE);
			typeLabel.setMaxWidth(HBox.USE_COMPUTED_SIZE);
			typeLabel.setMaxHeight(HBox.USE_COMPUTED_SIZE);
			
			// Attribute icon:
			Rectangle attributeIcon = new Rectangle();
			{
				attributeIcon.setHeight(5.0);
				attributeIcon.setWidth(10.0);
				attributeIcon.setStroke(Color.BLACK);
				attributeIcon.setStrokeType(StrokeType.INSIDE);
				attributeIcon.setFill(Color.TRANSPARENT);
			}
			typeLabel.setGraphic(attributeIcon);
			
			// Parent layout:
			HBox.setHgrow(typeLabel, Priority.NEVER);
			HBox.setMargin(typeLabel, new Insets(0, 0, 0, TEXT_SPACE));
		}
		layout.getChildren().add(typeLabel);
		
		// Equal label:
		Label equalLabel = new Label();
		{
			equalLabel.setText("=");
			
			// Size:
			equalLabel.setMinWidth(HBox.USE_PREF_SIZE);
			equalLabel.setMinHeight(HBox.USE_PREF_SIZE);
			equalLabel.setPrefHeight(HBox.USE_COMPUTED_SIZE);
			equalLabel.setPrefWidth(HBox.USE_COMPUTED_SIZE);
			equalLabel.setMaxWidth(HBox.USE_PREF_SIZE);
			equalLabel.setMaxHeight(HBox.USE_PREF_SIZE);
			
			// Parent layout:
			HBox.setHgrow(equalLabel, Priority.NEVER);
		}
		layout.getChildren().add(equalLabel);
		
		// Value label:
		Label valueLabel = new Label();
		{
			valueLabel.setText(value);
			
			// Size:
			valueLabel.setMinWidth(HBox.USE_COMPUTED_SIZE);
			valueLabel.setMinHeight(HBox.USE_COMPUTED_SIZE);
			valueLabel.setPrefHeight(HBox.USE_COMPUTED_SIZE);
			valueLabel.setPrefWidth(HBox.USE_COMPUTED_SIZE);
			valueLabel.setMaxWidth(Double.MAX_VALUE);
			valueLabel.setMaxHeight(HBox.USE_COMPUTED_SIZE);
			
			// Parent layout:
			HBox.setHgrow(valueLabel, Priority.ALWAYS);
			HBox.setMargin(valueLabel, new Insets(0, TEXT_SPACE, 0, 0));
		}
		layout.getChildren().add(valueLabel);
		
		// Count of elements (in the correspondence) with the same attribute value:
		Text matchingCountLabel = new Text();
		{
			matchingCountLabel.setText("[" + matchingCount + "]");
			
			matchingCountLabel.setStrokeType(StrokeType.OUTSIDE);
			matchingCountLabel.setStrokeWidth(0.0);
			
			// Parent layout:
			HBox.setHgrow(matchingCountLabel, Priority.NEVER);
			HBox.setMargin(matchingCountLabel, new Insets(0, TEXT_SPACE, 0, 0));
		}
		layout.getChildren().add(matchingCountLabel);
		
		return layout;
	}
}
