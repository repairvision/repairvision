package org.sidiff.consistency.common.debug;

import java.util.concurrent.Callable;

import org.eclipse.core.runtime.Platform;

/**
 * To activate the embedded validations add "-performValidations" to the program
 * arguments and "-ea" to the VM arguments of the run configuration.
 * 
 * @author Manuel Ohrndorf
 */
public class DebugUtil {

	private static final String PROPERTY_PERFORM_VALIDATIONS = "performValidations";

	private static Boolean isActive = false;

	static {
		String[] args = Platform.getCommandLineArgs();
		String validationArg = "-" + PROPERTY_PERFORM_VALIDATIONS;
		
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
