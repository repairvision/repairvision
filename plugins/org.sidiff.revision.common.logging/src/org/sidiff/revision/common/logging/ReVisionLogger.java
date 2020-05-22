package org.sidiff.revision.common.logging;

import java.util.logging.ConsoleHandler;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

public class ReVisionLogger {

	// TODO: Level.OFF for production code
	protected static final Level LOGGING_LEVEL = Level.FINER;
	
	protected static final Level DEBUGGING_LEVEL = Level.FINE;
	
	protected Logger logger;

	public static class ReVisionFormatter extends Formatter {

	    @Override
	    public String format(LogRecord record) {
			return "Re.Vision" + record.getMessage() + "\n";
	    }
	}
	
	public static class ReVisionHandler extends ConsoleHandler {

	    public ReVisionHandler() {
			super();
			setOutputStream(System.out);
			setFormatter(new ReVisionFormatter());
			setLevel(Level.ALL);
		}
	}
	
	/**
	 * @param logger The logger for this repair calculation.
	 */
	public ReVisionLogger(Logger logger) {
		this.logger = logger;
	}
	
	/**
	 * Simple console logging.
	 */
	public ReVisionLogger() {
		this.logger = Logger.getLogger(this.getClass().getName());
		logger.setLevel(LOGGING_LEVEL);
		
		for (Handler handler : this.logger.getHandlers()) {
			logger.removeHandler(handler);
		}
		
		logger.addHandler(new ReVisionHandler());
	}
	
	/**
	 * @param level   One of the message level identifiers, e.g., SEVERE.
	 * @param message A message to be logged.
	 */
	public void log(Level level, String message) {
		logger.log(level, message);
	}
	
	/**
	 * @param level   One of the message level identifiers, e.g., SEVERE.
	 * @param message A message to be logged.
	 * @param exception A exception to be logged.
	 */
	public void log(Level level, String message, Throwable exception) {
		logger.log(level, message, exception);
	}

	/**
	 * @return <code>true</code> if logging basic information (errors and warnings)
	 *         about the repair calculation is enabled; <code>false</code>
	 *         otherwise.
	 */
	public boolean isLogging() {
		return !logger.getLevel().equals(Level.OFF);
	}
	
	/**
	 * @return <code>true</code> if logging detailed information (e.g. debugging,
	 *         runtimes and so on) about the repair calculation is enabled;
	 *         <code>false</code> otherwise.
	 */
	public boolean isDebugging() {
		return logger.isLoggable(DEBUGGING_LEVEL);
	}
	
	/**
	 * @return The lowest level off Debugging.
	 */
	public Level getDebuggingLevel() {
		return DEBUGGING_LEVEL;
	}

	/**
	 * @return The logger for this repair calculation.
	 */
	public Logger getLogger() {
		return logger;
	}
	
	/**
	 * @param logger The logger for this repair calculation.
	 */
	public void setLogger(Logger logger) {
		this.logger = logger;
	}
}
