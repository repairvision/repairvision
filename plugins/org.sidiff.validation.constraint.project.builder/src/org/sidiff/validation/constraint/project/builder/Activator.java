package org.sidiff.validation.constraint.project.builder;

import java.net.URL;

import org.eclipse.core.runtime.Status;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin {

	public static final String PLUGIN_ID = "org.sidiff.validation.constraint.project.builder"; //$NON-NLS-1$

	private static Activator plugin;

	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}
	
	public static Activator getDefault() {
		return plugin;
	}

	public static String getPluginId() {
		return getDefault().getBundle().getSymbolicName();
	}
	
	public URL getInstallURL() {
		return getDefault().getBundle().getEntry("/"); //$NON-NLS-1$
	}

	public static void log(int severity, String message, Throwable throwable) {
		getDefault().getLog().log(new Status(severity, PLUGIN_ID, message, throwable));
	}

	public static void logError(String message, Throwable throwable) {
		log(Status.ERROR, message, throwable);
	}
	
	public static void logWarning(String message, Throwable throwable) {
		log(Status.WARNING, message, throwable);
	}
	
	public static void logWarning(String message) {
		logWarning(message, null);
	}

}
