package org.sidiff.revision.common.logging;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.osgi.framework.BundleContext;

public class LoggerFactory {
	
	public static Logger getLogger(BundleContext bundleContext) {
		Logger logger = Logger.getLogger(bundleContext.getBundle().getSymbolicName() 
				+ "_" + bundleContext.getBundle().getVersion());
		logger.setLevel(Level.OFF);
		return logger;
	}
	
}
