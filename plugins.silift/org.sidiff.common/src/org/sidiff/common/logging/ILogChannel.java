package org.sidiff.common.logging;

import java.text.SimpleDateFormat;

/**
 * Interface for classes that can write log messages to a particular channel.
 */
public interface ILogChannel {
	
	/**
	 * Prints the log message.
	 * @param message
	 * @param event
	 */
	public void log(String message,LogEvent event);
	
	/**
	 * Creates a format for time stamps.
	 * @return
	 */
	public SimpleDateFormat createDateFormat();
	
	/**
	 * Says if the messages sent to the LogChannel require to include the time stamp. 
	 * @return
	 */
	public boolean includeTimeStamp();

	/**
	 * Says if the messages sent to the LogChannel require to include the event type. 
	 * @return
	 */
	public boolean includeLogEvent();
	
	
	/**
	 * Says if the messages sent to the LogChannel require to include indentation. 
	 * @return
	 */
	public boolean doIndentation();
	
	public String getKey();
	
}
