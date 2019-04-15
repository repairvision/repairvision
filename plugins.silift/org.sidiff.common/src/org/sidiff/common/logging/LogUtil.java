package org.sidiff.common.logging;

import java.text.SimpleDateFormat;
import java.util.*;

import org.sidiff.common.Activator;
import org.sidiff.common.util.ReflectionUtil;
import org.sidiff.common.util.StringUtil;

// -DLOGEVENTS="MESSAGE,ERROR,WARNING,NOTICE,EVENT,SIGNAL,DEBUG"
// -DLOGMODULES=""

/**
 * Class for generating log messages.
 * 
 * <b>-DLOGEVENTS=x</b> Defines Log-EVENTs, default: message,error,warning.
 * <b>-DLOGMODULES=x</b> Defines Log-Modules, default: all
 * <b>-DLOGCHANNEL=x</b> Defines the outputchannel to use.
 * 
 * @author Maik Schmidt
 */
public class LogUtil {

	private static boolean IS_RELEASE = true;
	
	private static boolean LOGGING_ENABLED = true;

	// ***** External Constants *****
	private static final String PROPERTY_NAME_LOGCHANNEL= "LOGCHANNEL";
	private static final String PROPERTY_NAME_MODULES   = "LOGMODULES";
	private static final String PROPERTY_NAME_EVENTS    = "LOGEVENTS";
	
	private static final String OPTION_SEPARATOR = ",";
	private static final String WILDCARD = "*";
	
	//***** Internal Constants ****** 
	private static final int MODULE_INDEX = 3;
	//private static final int MODULE_DEPTH = 1;

	private final static String CHANNEL_PREFIX = "org.sidiff.common.logging.internal.";
	private final static String DEFAULT_OUTPUT_CHANNEL = "ConsoleLogChannel";
	private final static String DEFAULT_OUTPUT_CHANNEL_OSGI = "OSGILogChannel";
	
	private final static String DEFAULTLOGEVENTS = "MESSAGE,WARNING,ERROR,NOTICE";

	// Attributes
	private static ILogChannel channel = null;
	private static SimpleDateFormat sdf = null;
	
	private static EnumSet<LogEvent> logevents = null; // null means do not log any event
	private static Set<String> logmodules = null;

	// Static Initializer 
	static {
		// Disable release-flag -> Additional information will be provided
		assert(disableRelease());
		
		// Initialize Events to LogUtil
		String logeventsstr = System.getProperty(PROPERTY_NAME_EVENTS);
		if(logeventsstr!=null&&!logeventsstr.equals("")){
			LogUtil.setLogEvents(logeventsstr);
		} else {
			LogUtil.setLogEvents(DEFAULTLOGEVENTS);
		}

		// Initialize modules to Log
		String logmodulesstr = System.getProperty(PROPERTY_NAME_MODULES);
		if(logmodulesstr!=null&&!logmodulesstr.equals("")){
			LogUtil.setLogModules(logmodulesstr);
		} // If no Modules has been set, all Modules will be logged

		// Set output Channel
		String logchannelstr = System.getProperty(PROPERTY_NAME_LOGCHANNEL);
		if(logchannelstr!=null&&!logchannelstr.equals("")){
			LogUtil.setLogChannel(logchannelstr);
		} else {
			// Default output Channel
			if(Activator.isActivated()){
				LogUtil.setLogChannel(DEFAULT_OUTPUT_CHANNEL_OSGI);
			} else {
				LogUtil.setLogChannel(DEFAULT_OUTPUT_CHANNEL);
			}
		}
		
		if(!IS_RELEASE){
			String intro = 	"----------------------------------------------------------\n" +
							"LogUtil configured\n" +
							"Waiting for " + logevents + "\n" +
							"Listening on " + ((logmodules == null) ? "All Modules" : StringUtil.resolve(logmodules.toArray()))+"\n"+
							"----------------------------------------------------------";
		
			log(LogEvent.NOTICE, intro);
		}

	}

	public static String getLogEvents() {
		return LogUtil.logevents.toString().replace("[", "").replace("]", "").replace(" ", "");
	}
	
	public static void setLogEvents(String logeventsstr) {

		if (logeventsstr==null) {
			throw new IllegalArgumentException("null is not a valid LogEvent");
		}
		if (logeventsstr.equals("")) {
			LogUtil.logevents = null;
			return;
		}
			
		String[] logeventcmds = logeventsstr.split(OPTION_SEPARATOR);

		if (logeventcmds.length == 1 && logeventcmds[0].equalsIgnoreCase(WILDCARD)) {
				LogUtil.logevents = EnumSet.allOf(LogEvent.class);
		} else {
			Set<LogEvent> logevents = new HashSet<LogEvent>();
			for (String cmd : logeventcmds) {
				boolean match = false;
				for (LogEvent event : LogEvent.values()) {
					if (event.toString().trim().equalsIgnoreCase(cmd)) {
						logevents.add(event);
						match = true;
						break;
					}
				}
				if (!match) {
					System.out.println("Unknown Event:" + cmd);
					System.exit(1);
				}
			}
			LogUtil.logevents = EnumSet.copyOf(logevents);
		}
	}

	private static void setLogModules(String logmodulesstr) {

		assert(logmodulesstr!=null) : "Illegal Null Argument!" ;
		//assert(logmodulesstr.equals("")) : "Empty module String?"; 
		
		// We have event specific args
		String[] logmodulecmds = logmodulesstr.split(OPTION_SEPARATOR);
		
		if (logmodulecmds.length == 1 && logmodulecmds[0].equals(WILDCARD)) {
			LogUtil.logmodules = null; // Null dedicates all Modules have to be logged
		} else {
			Set<String> logmodules = new HashSet<String>();
			for(String cmd : logmodulecmds){
			if(!cmd.equals(WILDCARD)){
				logmodules.add(cmd);
			} else {
				System.out.println("Illegal wildcat usage:" + cmd);
				System.exit(1);
			}
		}
			LogUtil.logmodules = logmodules;
		}
	}

	@SuppressWarnings("unchecked")
	public static void setLogChannel(String channelName) {

		try {
			if (channelName.indexOf(".")==-1)
				channelName = CHANNEL_PREFIX + channelName;
			Class channelClass = ReflectionUtil.loadClass(channelName);
			LogUtil.channel = (ILogChannel)channelClass.getConstructor().newInstance();
		} catch (Exception e) {
			System.out.println("Cannot get output Channel:" + channelName);
			e.printStackTrace();
			System.exit(1);
		}
		
		LogUtil.sdf= channel.createDateFormat();
	}

	private static boolean doLogModule(String module) {
		
		if (module == null){
			// module name not determined, do not log
			return false;
		} else if (logmodules == null||logmodules.contains(module)){
			// module name specified, do log
			return true;
		} else {
			// Look for matching module name pattern
			for (String mod : logmodules) {
				if (module.matches(mod)) return true;
			}
			// Do not log at all
			return false;
		}
	}

	private static boolean doLogEvent(LogEvent event){
		return (logevents!=null && logevents.contains(event));
	}
	
	private static String getModuleName(String callerNSTokens[]){
		// Compute module name
		if (callerNSTokens.length > MODULE_INDEX) {
			return callerNSTokens[MODULE_INDEX];
		} else {
			return "DEFAULT";
		}
	}
	
	private static String getCallerName(String callerNSTokens[]){
		// Compute caller name 
		return callerNSTokens[callerNSTokens.length-1];
	}
	
	private static void printInternal(String fqCallerClassName, LogEvent event, Object... message) {

			
			String callerNSTokens[] = fqCallerClassName.split("\\.");		
			if(doLogModule(getModuleName(callerNSTokens))){
				// We have to log - Create message
				StringBuffer logentry = new StringBuffer();
				
				// Include timestamp into message 
				if(!IS_RELEASE&&channel.includeTimeStamp()){
					logentry.append(sdf.format(Calendar.getInstance().getTime()));
				}
				
				// Include event into message
				if(!IS_RELEASE&&channel.includeLogEvent()){
					logentry.append(event);
					logentry.append(" ");
				}
				
				if(!IS_RELEASE){
					// Include Module name into message
					logentry.append("[");
					logentry.append(getModuleName(callerNSTokens));
					logentry.append("] ");
					
					// Include Caller Classname into message
					logentry.append("<");
					logentry.append(getCallerName(callerNSTokens));
					// Include invocation-thread 
					if (!(Thread.currentThread().getName().equals("") || Thread.currentThread().getName().equals("main"))) {
						logentry.append("~");
						logentry.append(Thread.currentThread().getName());
					}
					logentry.append("> ");
				}
				String messageStr = StringUtil.resolve(message);
				if(channel.doIndentation()){
					// Create tab to format output
					StringBuffer tab = new StringBuffer();
					for (int i = 0; i < logentry.length(); i++) {
						tab.append(" ");
					}
					
					// Format output
					messageStr = messageStr.replaceAll("\n", "\n" + tab);
				}

				logentry.append(messageStr);
				channel.log(logentry.toString(), event);
			}
	}
	
	/**
	 * Push out a log message. 
	 * 
	 * @param event Classification of the delivered Message.
	 * @param message Sequence of Objects/Messages
	 * @return always true for use with asserts
	 */
	@SuppressWarnings("all")
	public static boolean log(LogEvent event, Object... message) {
		if(LOGGING_ENABLED && doLogEvent(event)){
			StackTraceElement source = Thread.currentThread().getStackTrace()[2];
			if(IS_RELEASE){
				printInternal(source.getClassName(), event, message);
			} else {
				printInternal(source.getClassName()+":"+source.getLineNumber(), event, message);
			}
		}
		return true;
	}

	private static boolean disableRelease() {
		LogUtil.IS_RELEASE=false;
		return true;
	}

	public static void toggleLogging() {
		LOGGING_ENABLED = !LOGGING_ENABLED;
	}

	public static void disableLogging() {
		LOGGING_ENABLED = false;
	}
	public static void enableLogging() {
		LOGGING_ENABLED = true;
	}
}
