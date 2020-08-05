package org.sidiff.revision.editrules.generation.difference;

import java.util.logging.Logger;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.sidiff.revision.common.logging.LoggerFactory;

public class Activator implements BundleActivator {
	
	private static BundleContext context;

	private static Logger log;
	
	static BundleContext getContext() {
		return context;
	}
	
	public static Logger getLog() {
		return log;
	}

	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
		Activator.log = LoggerFactory.getLogger(bundleContext);
	}

	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
		Activator.log = null;
	}

}
