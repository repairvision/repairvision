package org.sidiff.common.logging.internal;

import java.io.*;
import java.text.SimpleDateFormat;

import org.sidiff.common.logging.ILogChannel;
import org.sidiff.common.logging.LogEvent;

/**
 * LogChannel that writes the log messages into a file.
 */
public class FileLogChannel implements ILogChannel {

	private static final String PROPERTY_NAME_LOGFILE = "LOGFILE";

	private PrintWriter log = null;
	
	public FileLogChannel(){
		
		String fileName = System.getProperty(PROPERTY_NAME_LOGFILE);
		if (fileName != null&&!fileName.equals("")) {
			try {
				this.log = new PrintWriter(new FileWriter(fileName, true));
			} catch (IOException e) {
				log = new PrintWriter(System.out);
				System.err.print("Cannot access logfile:" + fileName+"\n"+e.getLocalizedMessage());
				e.printStackTrace();
				System.exit(1);
			}
		} else {
			 System.err.print("ERROR - Missing filename Property! try -D"+PROPERTY_NAME_LOGFILE);
		}
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
