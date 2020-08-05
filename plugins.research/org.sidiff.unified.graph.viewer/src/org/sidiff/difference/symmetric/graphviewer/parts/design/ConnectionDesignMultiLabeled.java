package org.sidiff.difference.symmetric.graphviewer.parts.design;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.gef.fx.nodes.Connection;
import org.eclipse.gef.fx.nodes.GeometryNode;
import org.eclipse.gef.geometry.planar.ICurve;
import org.sidiff.difference.symmetric.graphviewer.content.MatchingEdge;
import org.sidiff.difference.symmetric.graphviewer.parts.design.util.ImmediateTooltip;
import org.sidiff.revision.common.emf.ItemProviderUtil;

import javafx.geometry.Bounds;
import javafx.geometry.Pos;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

/**
 * Connection with dynamically placed start and end labels. Each label can have multiple rows.
 * 
 * @author Manuel Ohrndorf
 */
public class ConnectionDesignMultiLabeled extends Connection {
	
	private static double STROKE_SIZE = 2.0;
	
	protected Tooltip tooltip;
	
	protected VBox endLabel;
	
	protected VBox startLabel;
	
	protected boolean labelsVisible = true;
	
	public ConnectionDesignMultiLabeled(MatchingEdge reference) {
		
		// Create (uninstalled) tooltip:
		tooltip = new Tooltip();
		{
			StringBuffer label = new StringBuffer();
			
			// Direction: Node A -> Node B
			label.append(ItemProviderUtil.getTextByObject(reference) + ":\n");
			
			// Reference types:
			for (EReference eReference : reference.getTypes()) {
				label.append(" - " + eReference.getName() + "\n");
			}
			label.replace(label.length() - 1, label.length(), "");
			
			if (reference.getOpposite() != null) {
				
				// Direction: Node A -> Node B
				label.append("\n");
				label.append(ItemProviderUtil.getTextByObject(reference.getOpposite()) + ":\n");
				
				// Reference types:
				for (EReference eReference : reference.getOpposite().getTypes()) {
					label.append(" - " + eReference.getName() + "\n");
				}
				label.replace(label.length() - 1, label.length(), "");
			}
			
			tooltip.setText(label.toString());
		}
		
		// VBox:
		endLabel = new VBox();
		{
			// Size:
			endLabel.setMinWidth(VBox.USE_PREF_SIZE);
			endLabel.setMinHeight(VBox.USE_PREF_SIZE);
			endLabel.setPrefHeight(VBox.USE_COMPUTED_SIZE);
			endLabel.setPrefWidth(VBox.USE_COMPUTED_SIZE);
			endLabel.setMaxWidth(VBox.USE_PREF_SIZE);
			endLabel.setMaxHeight(VBox.USE_PREF_SIZE);
			
			// Style:
			endLabel.setAlignment(Pos.CENTER);
		}
		getChildren().add(endLabel);
		
		// Reference label:
		for (EReference feature : reference.getTypes()) {
			Text text = new Text(feature.getName());
			{
				text.setTextAlignment(TextAlignment.CENTER);
				text.setFill(reference.getTextColor());
				text.setStyle("-fx-font-weight: bold;");
			}
			endLabel.getChildren().add(text);
		}

		// Opposite reference label:
		if (reference.getOpposite() != null) {
			
			// VBox:
			startLabel = new VBox();
			{
				// Size:
				startLabel.setMinWidth(VBox.USE_PREF_SIZE);
				startLabel.setMinHeight(VBox.USE_PREF_SIZE);
				startLabel.setPrefHeight(VBox.USE_COMPUTED_SIZE);
				startLabel.setPrefWidth(VBox.USE_COMPUTED_SIZE);
				startLabel.setMaxWidth(VBox.USE_PREF_SIZE);
				startLabel.setMaxHeight(VBox.USE_PREF_SIZE);
				
				// Style:
				startLabel.setAlignment(Pos.CENTER);
			}
			getChildren().add(startLabel);
			
			for (EReference feature : reference.getOpposite().getTypes()) {
				Text textOppsite = new Text(feature.getName());
				{
					textOppsite.setTextAlignment(TextAlignment.CENTER);
					textOppsite.setFill(reference.getTextColor());
					textOppsite.setStyle("-fx-font-weight: bold;");
				}
				startLabel.getChildren().add(textOppsite);
			}
		}
		
		// Set the line style:
		if (getCurve() instanceof GeometryNode) {
			GeometryNode<?> curveNode = (GeometryNode<?>) getCurve();
			curveNode.setFill(reference.getBackgroundColor());
			curveNode.setStroke(reference.getBorderColor());
			curveNode.setStrokeWidth(STROKE_SIZE);
		}
		
		// Set containment diamond:
		boolean isContainmentReference = false;
		for (EReference refType : reference.getTypes()) {
			if (refType.isContainment()) {
				isContainmentReference = true;
			}
		}
		
		if (isContainmentReference) {
			setStartDecoration(new Decorations.Diamond(reference));
		}
		
		// Set the arrow:
		setEndDecoration(new Decorations.ArrowHead(reference));
		
		// Set opposite arrow:
		if ((reference.getOpposite() != null) && (!isContainmentReference)) {
			setStartDecoration(new Decorations.ArrowHead(reference));
		}
	}

	@Override
	protected void refresh() {
		super.refresh();

		// Label visibility:
		if (!labelsVisible) {
			return;
		}
		
		if (getCurve() instanceof GeometryNode) {
			GeometryNode<?> geometryNode = (GeometryNode<?>) getCurve();

			if ((geometryNode.getGeometry() != null) && (geometryNode.getGeometry() instanceof ICurve)) {
				ICurve curve = (ICurve) geometryNode.getGeometry();

				double magnitude = magnitude(
						curve.getX2(), curve.getY2(),
						curve.getX1(), curve.getY1());

				// Y1 > Y2: End/Start label is over/under the edge.
				// Y1 < Y2: End/Start label is under/over the edge.
				double orientation = (curve.getY1() > curve.getY2()) ? -1 : 1;

				/* 
				 * Set end label position (by distance from end point):
				 */
				{
					Bounds endLabelBounds = endLabel.getBoundsInLocal();

					// Half label width + decorator width + deci-magnitude:
					double distance = (endLabelBounds.getWidth() / 2) 
							+ Decorations.DECORATION_SIZE_X + (magnitude / 10);

					double[] point = pointOnLine(
							curve.getX1(), curve.getY1(),
							curve.getX2(), curve.getY2(),
							(distance < (magnitude / 2)) ? distance : (magnitude / 2));

					endLabel.setTranslateX(point[0]);
					endLabel.setTranslateY(point[1] 
							+ orientation * (endLabelBounds.getHeight() / 2));
				}

				/*
				 *  Set start label position (by distance from start point):
				 */
				if (startLabel != null) {
					Bounds startLabelBounds = startLabel.getBoundsInLocal();

					// Half label width + decorator width + deci-magnitude:
					double distance = (startLabelBounds.getWidth() / 2) 
							+ Decorations.DECORATION_SIZE_X + (magnitude / 10);

					double[] point = pointOnLine(
							curve.getX2(), curve.getY2(),
							curve.getX1(), curve.getY1(),
							(distance < (magnitude / 2)) ? distance : (magnitude / 2));

					startLabel.setTranslateX(point[0]);
					startLabel.setTranslateY(point[1] 
							- orientation * (startLabelBounds.getHeight() / 2));
				}
			}
		}
		
		if (!getChildren().contains(endLabel)) {
			getChildren().add(endLabel);
		}
		
		if ((startLabel != null) && (!getChildren().contains(startLabel))) {
			getChildren().add(startLabel);
		}
	}
	
	/*
	 * Do the math here...
	 */
	
	private double magnitude(
			double x1, double y1, 
			double x2, double y2) {
		
		double vx = x2 - x1;
		double vy = y2 - y1;
		
		return Math.sqrt(vx*vx + vy*vy);
	}

	private double[] pointOnLine(
			double x1, double y1, 
			double x2, double y2, 
			double distance) {

		double dx = x2 - x1;
		double dy = y2 - y1;
		
		double magnitude = Math.sqrt(dx * dx + dy * dy);

		// Normalize the vector to unit length:
		dx /= magnitude;
		dy /= magnitude;
		
		double xi = x1 + dx * (magnitude - distance);
		double yi = y1 + dy * (magnitude - distance);
		
		return new double[] {xi, yi};
	}
	
	/**
	 * @param labelsVisible
	 *            The visibility of the labels. (Shows tooltip instead.)
	 */
	public void setLabelsVisible(boolean labelsVisible) {
		
		// Only if value has changed:
		if (this.labelsVisible != labelsVisible) {
			this.labelsVisible = labelsVisible;
			
			if (labelsVisible) {
				ImmediateTooltip.uninstall(this, tooltip);
				
				if (!getChildren().contains(endLabel)) {
					getChildren().add(endLabel);
				}
				
				if ((startLabel != null) && (!getChildren().contains(startLabel))) {
					getChildren().add(startLabel);
				}
			} else {
				getChildren().removeAll(startLabel, endLabel);
				ImmediateTooltip.install(this, tooltip);
			}	
		}
		
		refresh();
	}
	
	/**
	 * @return The visibility of the labels. (Shows tooltip instead.)
	 */
	public boolean isLabelsVisible() {
		return labelsVisible;
	}
}
