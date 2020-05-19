package org.sidiff.revision.editrules.generation.difference;

import java.util.logging.Logger;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.sidiff.common.utilities.logging.LoggingUtil;

public class Activator implements BundleActivator {
	
	private static BundleContext context;

	private static Logger log;
	
	public static BundleContext getContext() {
		return context;
	}
	
	public static Logger getLog() {
		return log;
	}

	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
		Activator.log = LoggingUtil.getLogger(bundleContext);
	}

	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
		Activator.log = null;
	}

}
