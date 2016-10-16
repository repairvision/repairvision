package org.sidiff.consistency.common.debug;

import java.util.concurrent.Callable;

import org.eclipse.core.runtime.Platform;

/**
 * To activate the embedded validations add "-enableDebugUtil" to the program
 * arguments and "-ea" to the VM arguments of the run configuration. ('ea'
 * activates the debugging and plausibility tests, 'enableDebugUtil' also
 * enables console output)
 * 
 * @author Manuel Ohrndorf
 */
public class DebugUtil {

	/**
	 * This flag determines whether the debugging mode should be activated.
	 */
	private static final String PROPERTY_ENABLE_DEBUG_UTIL = "enableDebugUtil";

	/**
	 * Indicates whether the debugging mode is active.
	 */
	public static boolean isActive = false;
	
	// TODO: config flag
	public static boolean statistic = true;

	static {
		String[] args = Platform.getCommandLineArgs();
		String validationArg = "-" + PROPERTY_ENABLE_DEBUG_UTIL;
		
		for (String arg : args) {
			if (arg.equals(validationArg)) {
				isActive = true;
			}
		}
	}

	/**
	 * @param validation
	 *            The function that performs the test.
	 */
	public static void check(Callable<Boolean> validation) {
		if (isActive) {
			try {
				assert validation.call();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * @param validation
	 *            The function that performs the test.
	 * @param message
	 *            A message if the validation fails.
	 */
	public static void check(Callable<Boolean> validation, Object message) {
		if (isActive) {
			try {
				assert validation.call() : message;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
