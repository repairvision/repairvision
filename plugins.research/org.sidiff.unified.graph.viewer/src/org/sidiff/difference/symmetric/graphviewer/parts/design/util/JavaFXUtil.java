package org.sidiff.difference.symmetric.graphviewer.parts.design.util;

import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 * @author Manuel Ohrndorf
 */
public class JavaFXUtil {

	/**
	 * @return The system default font size.
	 */
	public static double getDefaultFontSize() {
		return Font.getDefault().getSize();
	}
	
	/**
	 * @param text
	 *            A {@link Label} or a {@link Text}.
	 * @return The text width in pixels.
	 */
	public static double getTextWidth(Object text) {
		if (text instanceof Label) {
			return new FontMetrics(((Label) text).getFont()).computeStringWidth(((Label) text).getText());
		} else if (text instanceof Text) {
			return new FontMetrics(((Text) text).getFont()).computeStringWidth(((Text) text).getText());
		}
		
		return -1;
	}

//	/* Edits global tooltip behavoir -> Use ImmediateTooltip instead... */
//	/**
//	 * @param tooltip
//	 *            The tooltip.
//	 * @param millis
//	 *            The delay in ms.
//	 */
//	public static void setTooltipDelay(Tooltip tooltip, double millis) {
//	    try {
//	        Field fieldBehavior = tooltip.getClass().getDeclaredField("BEHAVIOR");
//	        fieldBehavior.setAccessible(true);
//	        Object objBehavior = fieldBehavior.get(tooltip);
//
//	        Field fieldTimer = objBehavior.getClass().getDeclaredField("activationTimer");
//	        fieldTimer.setAccessible(true);
//	        Timeline objTimer = (Timeline) fieldTimer.get(objBehavior);
//
//	        objTimer.getKeyFrames().clear();
//	        objTimer.getKeyFrames().add(new KeyFrame(new Duration(millis)));
//	    } catch (Exception e) {
//	        e.printStackTrace();
//	    }
//	}
}
