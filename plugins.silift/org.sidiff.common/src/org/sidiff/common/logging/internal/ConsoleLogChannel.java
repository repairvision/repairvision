package org.sidiff.common.logging.internal;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;

import org.sidiff.common.logging.ILogChannel;
import org.sidiff.common.logging.LogEvent;


/**
 * A LogChannel that writes the log messages to the console.
 */
public class ConsoleLogChannel implements ILogChannel {

	private PrintWriter log = null;
	
	public ConsoleLogChannel(){
		this.log = new PrintWriter(System.out);
	}
	
	@Override
	public SimpleDateFormat createDateFormat() {
		return new SimpleDateFormat("EE dd.MM.yy hh:mm:ss ");
	}

	@Override
	public void log(String message, LogEvent event) {
		this.log.print(message + "\n");
		this.log.flush();
	}

	@Override
	public boolean doIndentation() {
		return true;
	}

	@Override
	public boolean includeLogEvent() {
		return true;
	}

	@Override
	public boolean includeTimeStamp() {
		return true;
	}

	@Override
	public String getKey() {
		return getClass().getSimpleName();
	}

}
