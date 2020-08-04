package org.sidiff.revision.repair.api.configuration;

import java.util.logging.Level;

import org.sidiff.revision.common.logging.ReVisionLogger;
import org.sidiff.revision.common.logging.util.LogTime;
import org.sidiff.revision.common.logging.util.LogUtil;
import org.sidiff.revision.difference.Change;

public class RepairLogger extends ReVisionLogger {

	/**
	 * @param diffTimer [Time (ms)] Load/Calculate Revision
	 */
	public void logDifferenceTime(LogTime diffTimer) {
		if (logger.isLoggable(DEBUGGING_LEVEL)) {
			logger.log(DEBUGGING_LEVEL, "[Load/Calculate Revision Time]: " + LogUtil.getTime(diffTimer));
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
			logger.log(DEBUGGING_LEVEL, "[Validation Time]: " + LogUtil.getTime(valiationTimer));
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
			logger.log(DEBUGGING_LEVEL, "[Complement Matching Time]: " + LogUtil.getTime(complementMatchingTimer));
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
	
}
