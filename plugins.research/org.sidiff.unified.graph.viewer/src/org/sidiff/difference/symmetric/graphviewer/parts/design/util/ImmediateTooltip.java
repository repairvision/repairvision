package org.sidiff.difference.symmetric.graphviewer.parts.design.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import javafx.scene.Node;
import javafx.scene.control.Tooltip;
import javafx.util.Duration;

/**
 * Show tooltip: In: 0sec, duration: 10sec, out: 2sec 
 * 
 * @author Manuel Ohrndorf
 */
public class ImmediateTooltip {

	/**
	 * Class.forName("javafx.scene.control.Tooltip$TooltipBehavior")
	 */
	private static final Object TOOLTIP_BEHAVIOR = createTooltipBehavior(
			new Duration(0), new Duration(10000), new Duration(2000), false);
	
	/**
	 * @param node
	 *            The target node of the tooltip.
	 * @param tooltip
	 *            The tootip to install.
	 */
	public static void install(Node node, Tooltip tooltip) {
		
		if (TOOLTIP_BEHAVIOR != null) {
			try {
		        // Install tooltip behavior:
		        Method install = TOOLTIP_BEHAVIOR.getClass().getDeclaredMethod("install", Node.class, Tooltip.class);
		        install.setAccessible(true);
		        install.invoke(TOOLTIP_BEHAVIOR, node, tooltip);
		        
		        return;
			} catch (Exception e) {
				System.err.println("Tooltip install faild");
			}
		}
		
		Tooltip.install(node, tooltip);
	}
	
	/**
	 * @param node
	 *            The target node of the tooltip.
	 * @param tooltip
	 *            The tootip to uninstall.
	 */
	public static void uninstall(Node node, Tooltip tooltip) {
		
//		if (TOOLTIP_BEHAVIOR != null) {
//			try {
//		        // Uninstall tooltip behavior:
//		        Method install = TOOLTIP_BEHAVIOR.getClass().getDeclaredMethod("uninstall", Node.class);
//		        install.setAccessible(true);
//		        install.invoke(TOOLTIP_BEHAVIOR, node);
//		        
//		        return;
//			} catch (Exception e) {
//				System.err.println("Tooltip uninstall faild");
//			}
//		}
		
		Tooltip.uninstall(node, tooltip);
	}
	
	/**
	 * Creates a new (hacked ;) tooltip behavior:
	 * 
	 * @param openDelay
	 *            Default: new Duration(1000)
	 * @param visibleDuration
	 *            Default: new Duration(5000)
	 * @param closeDelay
	 *            Default: new Duration(200)
	 * @param hideOnExit
	 *            Default: false
	 */
	private static Object createTooltipBehavior(
			Duration openDelay, Duration visibleDuration, 
			Duration closeDelay, final boolean hideOnExit)  {

		try {
	    	// Create TooltipBehavior:
	    	Class<?> tooltipBehaviorClass = Class.forName("javafx.scene.control.Tooltip$TooltipBehavior");
	        Constructor<?> constructor = tooltipBehaviorClass.getDeclaredConstructors()[0];
	        constructor.setAccessible(true);
	        Object tooltipBehavior = constructor.newInstance(openDelay, visibleDuration, closeDelay, hideOnExit);
	        
	        return tooltipBehavior;
		} catch (Exception e) {
			System.err.println("Can't create tooltip behavior - Use default instead");
			return null;
		}
    }
}
