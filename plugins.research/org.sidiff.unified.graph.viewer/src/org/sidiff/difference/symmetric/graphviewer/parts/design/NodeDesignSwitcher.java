package org.sidiff.difference.symmetric.graphviewer.parts.design;

import org.sidiff.difference.symmetric.graphviewer.content.MatchingNode;
import org.sidiff.difference.symmetric.graphviewer.parts.design.util.INodeSizeCalculator;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Region;

/**
 * @author Manuel Ohrndorf
 */
public class NodeDesignSwitcher extends Group  {

	/**
	 * The style variants.
	 */
	public enum Design {
		NODE, 
		NODE_WITH_ICON, 
		NODE_WITH_ICON_TEXT, 
		NODE_WITH_ICON_TEXT_ATTRIBUTES
	}

	/**
	 * The actual design.
	 */
	private Design actualDesign = Design.NODE_WITH_ICON;

	/**
	 * Expand/Collapse the node on double click.
	 */
	private Design expandOnClickDesign = Design.NODE_WITH_ICON_TEXT_ATTRIBUTES;
	
	/**
	 * Double click: First expand the design and than restores the design next time.
	 */
	Design restoreDesign = null;
	
	/**
	 * The actual design instance.
	 */
	private Region actualDesignNode;

	/**
	 * The corresponding model element
	 */
	private MatchingNode matchingElement;

	public NodeDesignSwitcher(MatchingNode matchingElement) {
		this.matchingElement = matchingElement;
		internalSetDesign(actualDesign);

		// Expand/Collapse the node on double click:
		this.onMouseClickedProperty().set(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent mouseEvent) {
				
				if ((mouseEvent.getButton().equals(MouseButton.PRIMARY)) && ((mouseEvent.getClickCount() == 2))) {
					if (restoreDesign == null) {
						restoreDesign = actualDesign;
						internalSetDesign(expandOnClickDesign);
					} else {
						internalSetDesign(restoreDesign);
						restoreDesign = null;
					}
				}
			}
		});
	}

	/**
	 * @return The actual design type.
	 */
	public Design getDesign() {
		return actualDesign;
	}
	
	private void internalSetDesign(Design design) {
		
		// Is design change necessary?
		if ((actualDesignNode != null) && (design == actualDesign)) {
			return;
		} else {
			this.actualDesign = design;
		}
		
		// Preserve old size:
		double actual_width = 0;
		double actual_height = 0;
		
		if (actualDesignNode != null) {
			actual_width = actualDesignNode.getBoundsInLocal().getWidth();
			actual_height = actualDesignNode.getBoundsInLocal().getHeight();
		}

		// Select the design:
		switch (design) {
		case NODE:
			actualDesignNode = new NodeDesign(matchingElement);
			break;
		case NODE_WITH_ICON:
			actualDesignNode = new NodeDesignIcon(matchingElement);
			break;
		case NODE_WITH_ICON_TEXT:
			actualDesignNode = new NodeDesignIconAndText(matchingElement);
			break;
		case NODE_WITH_ICON_TEXT_ATTRIBUTES:
			actualDesignNode = new NodeDesignIconAndTextAndAttributes(matchingElement);
			break;
		}
		
		double width = ((INodeSizeCalculator) actualDesignNode).calculateLayoutWidth();
		double height = ((INodeSizeCalculator) actualDesignNode).calculateLayoutHeight();
		
		if (actualDesignNode.isResizable()) {
			width = Math.max(actual_width, width);
			height = Math.max(actual_height, height);
		}

		resize(width, height);
		
		getChildren().clear();
		getChildren().add(actualDesignNode);
	}

	/**
	 * @param design
	 *            The actual design type.
	 */
	public void setDesign(Design design) {
		// Overwrite restorable design on external design event:
		this.restoreDesign = null;

		// Set new design:
		internalSetDesign(design);
	}

	@Override
	public boolean isResizable() {
		return actualDesignNode.isResizable();
	}

	@Override
	public void resize(double w, double h) {
//		actualDesignNode.resize(w, h);
		actualDesignNode.setPrefSize(w, h);
		actualDesignNode.autosize();
	}

	@Override
	protected void layoutChildren() {
		// we directly layout our children from within resize
	};

	@Override
	public double maxHeight(double width) {
		return actualDesignNode.maxHeight(width);
	}

	@Override
	public double maxWidth(double height) {
		return actualDesignNode.maxWidth(height);
	}

	@Override
	public double minHeight(double width) {
		return actualDesignNode.minHeight(width);
	}

	@Override
	public double minWidth(double height) {
		return actualDesignNode.minWidth(height);
	}

	@Override
	public double prefHeight(double width) {
		return actualDesignNode.prefHeight(width);
	}

	@Override
	public double prefWidth(double height) {
		return actualDesignNode.prefWidth(height);
	}
}
