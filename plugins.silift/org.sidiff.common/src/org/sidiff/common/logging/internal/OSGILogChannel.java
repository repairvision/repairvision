package org.sidiff.common.logging.internal;

import java.text.SimpleDateFormat;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.service.log.LogService;
import org.sidiff.common.Activator;
import org.sidiff.common.logging.ILogChannel;
import org.sidiff.common.logging.LogEvent;

/**
 * LogChannels that forwards the log messages to the log service of the OSGi framework.
 */
public class OSGILogChannel implements ILogChannel {

	private BundleContext context = null;
	private ServiceReference logServiceRef = null;
	private boolean hasPrintedError = false;
	
	@Override
	public SimpleDateFormat createDateFormat() {
		return new SimpleDateFormat("EE dd.MM.yy hh:mm:ss ");
	}

	@Override
	public void log(String message, LogEvent event) {
		LogService logService = getLogService();
		if (logService != null) {
			logService.log(toOSGILogLevel(event), message);
		} else {
			System.out.println("OSGI-LOG "+event.name()+": "+message);
		}
	}
	
	private LogService getLogService() {
		
		if(context==null){
			if(Activator.isActivated()){
				this.context = Activator.getBundleContext();
			} else {
				System.err.println("ERROR - OSGI LogChannel cannot get OSGI Context!");
			}
		}
		
		if(logServiceRef==null){
			 ServiceReference serviceRef = context.getServiceReference(LogService.class.getName());
			 if(serviceRef!=null){
				 this.logServiceRef = serviceRef;
			 } else if (!hasPrintedError) {
				 System.err.println("ERROR - OSGI LogChannel cannot get OSGI Logservice!");
				 hasPrintedError = true;
			 }
		}

		try {
			return (LogService)this.context.getService(logServiceRef);
		} catch (Exception e) {
			return null;
		}
	}
	
	
	private int toOSGILogLevel(LogEvent event) {

		// Map LogUtil log level to the logservice loglevel
		switch (event) {
		case MESSAGE:
			return LogService.LOG_INFO;
		case ERROR:
			return LogService.LOG_ERROR;
		case WARNING:
			return LogService.LOG_WARNING;
		case NOTICE:
			return LogService.LOG_INFO;
		case EVENT:
			return LogService.LOG_DEBUG;
		case SIGNAL:
			return LogService.LOG_DEBUG;
		case DEBUG:
			return LogService.LOG_DEBUG;
		default:
			throw new IllegalArgumentException("Unknown Event:" + event);
		}
	}

	@Override
	public boolean doIndentation() {
		return false;
	}

	@Override
	public boolean includeLogEvent() {
		return false;
	}

	@Override
	public boolean includeTimeStamp() {
		return false;
	}

	@Override
	public String getKey() {
		return getClass().getSimpleName();
	}
}