package org.sidiff.difference.symmetric.graphviewer.parts.design.util;

import com.sun.javafx.tk.Toolkit;

import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 * @author Manuel Ohrndorf
 */
@SuppressWarnings("restriction")
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
			return Toolkit.getToolkit().getFontLoader().computeStringWidth(
					((Label) text).getText(), ((Label) text).getFont());
		} else if (text instanceof Text) {
			return Toolkit.getToolkit().getFontLoader().computeStringWidth(
					((Text) text).getText(), ((Text) text).getFont());
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
