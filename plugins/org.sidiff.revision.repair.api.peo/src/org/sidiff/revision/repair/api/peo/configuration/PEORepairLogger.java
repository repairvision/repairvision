package org.sidiff.revision.repair.api.peo.configuration;

import java.util.logging.ConsoleHandler;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

import org.sidiff.common.utilities.monitor.LogTime;
import org.sidiff.revision.difference.Change;

public class PEORepairLogger {

	private static final Level DEBUGGING_LEVEL = Level.FINE;
	
	private Logger logger;

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
	 * Simple console logging.
	 */
	public PEORepairLogger() {
		this.logger = Logger.getLogger(this.getClass().getName());
		logger.setLevel(Level.ALL);
		
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
		return !logger.isLoggable(Level.OFF);
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
	 * @param logger The logger for this repair calculation.
	 */
	public PEORepairLogger(Logger logger) {
		this.logger = logger;
	}

	/**
	 * @return The logger for this repair calculation.
	 */
	public Logger getLogger() {
		return logger;
	}

	/**
	 * @param diffTimer [Time (ms)] Load/Calculate Revision
	 */
	public void logDifferenceTime(LogTime diffTimer) {
		if (logger.isLoggable(DEBUGGING_LEVEL)) {
			logger.log(DEBUGGING_LEVEL, "[Load/Calculate Revision Time]: " + getTime(diffTimer));
		}
	}

	/**
	 * @param size Change Count (Historical->Actual)
	 */
	public void logChangeCount(int size) {
		if (logger.isLoggable(DEBUGGING_LEVEL)) {
			logger.log(DEBUGGING_LEVEL, "[Change Count]: " + size);
		}
	}

	/**
	 * @param valiationTimer [Time (ms)] Validation
	 */
	public void logValidationTime(LogTime valiationTimer) {
		if (logger.isLoggable(DEBUGGING_LEVEL)) {
			logger.log(DEBUGGING_LEVEL, "[Validation Time]: " + getTime(valiationTimer));
		}
	}

	/**
	 * @param size Inconsistency Count
	 */
	public void logInconsistencyCount(int size) {
		if (logger.isLoggable(DEBUGGING_LEVEL)) {
			logger.log(DEBUGGING_LEVEL, "[Inconsistencies]: " + size);
		}
	}

	/**
	 * @param size CPEO Count
	 */
	public void logEditRuleCount(int size) {
		if (logger.isLoggable(DEBUGGING_LEVEL)) {
			logger.log(DEBUGGING_LEVEL, "[CPEOs]: " + size);
		}
	}

	/**
	 * @param complementMatchingTimer [Time (ms)] Complement Matching
	 */
	public void logComplementMatchingTime(LogTime complementMatchingTimer) {
		if (logger.isLoggable(DEBUGGING_LEVEL)) {
			logger.log(DEBUGGING_LEVEL, "[Complement Matching Time]: " + getTime(complementMatchingTimer));
		}
	}

	/**
	 * @param potentialEditRules Potential Edit Rules
	 */
	public void logPotentialEditRuleCount(int potentialEditRules) {
		if (logger.isLoggable(DEBUGGING_LEVEL)) {
			logger.log(DEBUGGING_LEVEL, "[Potential CPEOs]: " + potentialEditRules);
		}
	}

	/**
	 * @param complementingOperationCount Complements (Repairs)
	 */
	public void logComplementOperationCount(int complementingOperationCount) {
		if (logger.isLoggable(DEBUGGING_LEVEL)) {
			logger.log(DEBUGGING_LEVEL, "[Count of Complement Operations]: " + complementingOperationCount);
		}
	}

	/**
	 * @param repairCount Complement Matchings
	 */
	public void logComplementMatchingCount(int repairCount) {
		if (logger.isLoggable(DEBUGGING_LEVEL)) {
			logger.log(DEBUGGING_LEVEL, "[Repair Count]: " + repairCount);
		}
	}

	/**
	 * @param change            The invalid change.
	 * @param validationMessage The reason for an invalid message
	 */
	public void logChangeValidation(Change change, String validationMessage) {
		if (logger.isLoggable(Level.WARNING)) {
			logger.log(Level.WARNING, "[Change Validation]: " + validationMessage);
		}
	}
	
	private String getTime(LogTime time) {
		if (time.getTime() > -1) {
			return time.getTime() + "ms";
		} else {
			return "n.a.";
		}
	}
}
