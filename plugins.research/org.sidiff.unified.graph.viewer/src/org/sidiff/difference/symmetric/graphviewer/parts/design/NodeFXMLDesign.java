package org.sidiff.difference.symmetric.graphviewer.parts.design;

import java.io.IOException;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.emf.edit.ui.provider.ExtendedImageRegistry;
import org.sidiff.difference.symmetric.graphviewer.Activator;
import org.sidiff.difference.symmetric.graphviewer.content.MatchingNode;

import javafx.embed.swt.SWTFXUtils;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

/**
 * FXML design for testing purposes (to slow in practice).
 *
 * @author Manuel Ohrndorf
 */
public class NodeFXMLDesign {

	private static int STROKE_WIDTH = 4;
	
	private static ComposedAdapterFactory adapterFactory;
	
	static {
		adapterFactory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
		adapterFactory.addAdapterFactory(new ResourceItemProviderAdapterFactory());
	}
	
	@FXML
	private AnchorPane mainPane;
	
	@FXML
	private Rectangle frame;
	
	@FXML
	private Line frameLine;
	
	@FXML
	private HBox headerPane;
	
	@FXML
	private Label elementLabel;
	
	@FXML
	private Text elementCount;

	@FXML
	private GridPane attributes;
	
	@FXML
	private ScrollPane scrollpane;
	
	@FXML
	private AnchorPane scrollpaneContent;
	
	public static Group create(MatchingNode matchingElement) {
		NodeFXMLDesign design = new NodeFXMLDesign();
		Group element = design.loadFXMLDesign(matchingElement);
		
		return element;
	}
	
	public Group loadFXMLDesign(MatchingNode matchingElement) {
		
 		/*
 		 *  Container set-up:
 		 */
		final Group group = new Group() {
			
			private double width = -1;
			private double height = -1;
			
			@Override
			public boolean isResizable() {
				return true;
			}

			@Override
			public void resize(double w, double h) {

				// Minimum size:
				w = Math.max(w, 120);
				h = Math.max(h, 80);
				
				// Resize only if one dimension has changed:
				if ((width == w) && (height == h)) {
					return;
				} else {
					width = h;
					height = w;
				}
								
				// Calculate layout:
				final double SCROLLPANE_BORDER = 2;
				final double FONT_SIZE = 12;
				
				// > Inner panes:
				double innerSize = w - (2 * STROKE_WIDTH);
				double innerScrollPane = (innerSize - SCROLLPANE_BORDER);

				// > Subtract vertical scrollbar:
				if (attributes.getHeight() > (scrollpane.getHeight() - SCROLLPANE_BORDER)) {
					// The scrollbar size is equal to the front size:
					innerScrollPane -= FONT_SIZE + 2;
				}
				
				// Layout:
				
				// > Pane:
				mainPane.setPrefWidth(w);
				mainPane.setPrefHeight(h);
				
				// > Box:
				frame.setWidth(w);
				frame.setHeight(h);
				frameLine.setEndX(innerSize);
				
				// > Header:
				headerPane.setPrefWidth(innerScrollPane); 
				
				// > Attributes:
				for (Node attributeRow : attributes.getChildren()) {
					if (attributeRow instanceof Region) {
						((Region) attributeRow).setPrefWidth(innerScrollPane);
					}
				}
			}
		};

		/*
		 *  Load FXML design:
		 */
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setClassLoader(ClassLoader.getSystemClassLoader());
			loader.setLocation(Activator.getDefault().getBundle().getResource("design/NodeDesignPart.fxml"));
			loader.setController(this);
			Node part = loader.load();

			group.getChildren().addAll(part);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		/*
		 *  Fill the design:
		 */
		IItemLabelProvider itemLabelProvider = (IItemLabelProvider) adapterFactory.adapt(
				matchingElement, IItemLabelProvider.class);
		
		// Set the label:
		elementLabel.setText(itemLabelProvider.getText(matchingElement));

		// Set the icon:
		Object unknown_image_type = itemLabelProvider.getImage(matchingElement);

		// > EMF composed image:
		if (unknown_image_type instanceof org.eclipse.emf.edit.provider.ComposedImage) {
			
			// Convert to JavaFX image:
			org.eclipse.swt.graphics.Image swt_image = ExtendedImageRegistry.INSTANCE.getImage(unknown_image_type);
            WritableImage image = new WritableImage(swt_image.getBounds().width, swt_image.getBounds().height);
			SWTFXUtils.toFXImage(swt_image.getImageData(), image);
			ImageView imageView = new ImageView(image);
			elementLabel.setGraphic(imageView);
		}

		// > Image type unknown:
		else {
			elementLabel.setGraphic(null);
		}
		
		// Set element count:
		elementCount.setText("[" + matchingElement.getElements().size() + "]");
		
		// Set frame color by element count:
		Color colorBorder = matchingElement.getBorderColor();
		Color colorBackground = matchingElement.getBackgroundColor();
		
		frame.setStroke(colorBorder);
		frame.setFill(colorBackground);
		frameLine.setStroke(colorBorder);
		
		// Clear attributes in design file:
		attributes.getChildren().clear();
		
		for (EAttribute attribute : matchingElement.getType().getEAllAttributes()) {
			String typeString = attribute.getName();
			
			// Multi-valued attribute:
			if (attribute.isMany()) {
				
			}
			
			// Single attribute value:
			else {
				EObject representativeElement = matchingElement.getElements().get(0);
				Object value = representativeElement.eGet(attribute);

				// Printable (e.g. primitive, literal) attribute value:
				if (isPrintableAttributeType(attribute)) {
					String valueString = "null";
					
					if (value != null) {
						valueString = value.toString();
					}
					
					Node attributeNode = PrimitiveAttributeDesign.create(typeString, valueString, -1, 190.0);
					attributes.getChildren().add(attributeNode);
					GridPane.setRowIndex(attributeNode, attributes.getChildren().size() - 1);
				} 
				
				// Complex attribute value (e.g. JavaObject):
				else {
					
				}
			}
		}
		
		return group;
	}
	
	private boolean isPrintableAttributeType(EAttribute attribute) {
		return true;
	}
}
