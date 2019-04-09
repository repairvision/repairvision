package org.sidiff.repair.api.peo.configuration;

import org.sidiff.consistency.common.monitor.LogTime;

public class PEORepairMonitor {

	private boolean logging = true;

	public boolean isLogging() {
		return logging;
	}

	public void setLogging(boolean logging) {
		this.logging = logging;
	}

	/**
	 * @param diffTimer
	 *            [Time (ms)] Load/Calculate Revision
	 */
	public void logDifferenceTime(LogTime diffTimer) {
		if (isLogging()) {
			System.out.println("Re.Vision[Load/Calculate Revision Time]: " + diffTimer + "ms");
		}
	}

	/**
	 * @param size
	 *            Change Count (Historical->Actual)
	 */
	public void logChangeCount(int size) {
	}

	/**
	 * @param valiationTimer
	 *            [Time (ms)] Validation
	 */
	public void logValidationTime(LogTime valiationTimer) {
		if (isLogging()) {
			System.out.println("Re.Vision[Validation Time]: " + valiationTimer + "ms");
		}
	}

	/**
	 * @param size
	 *            Inconsistency Count
	 */
	public void logInconsistencyCount(int size) {
		if (isLogging()) {
			System.out.println("Re.Vision[Inconsistencies]: " + size);
		}
	}

	/**
	 * @param size
	 *            CPEO Count
	 */
	public void logEditRuleCount(int size) {
		if (isLogging()) {
			System.out.println("Re.Vision[CPEOs]: " + size);
		}
	}

	/**
	 * @param complementMatchingTimer
	 *            [Time (ms)] Complement Matching
	 */
	public void logComplementMatchingTime(LogTime complementMatchingTimer) {
	}

	/**
	 * @param potentialEditRules
	 *            Potential Edit Rules
	 */
	public void logPotentialEditRuleCount(int potentialEditRules) {
		if (isLogging()) {
			System.out.println("Re.Vision[Potential CPEOs]: " + potentialEditRules);
		}
	}

	/**
	 * @param complementingEditRules
	 *            Complements (Repairs)
	 */
	public void logComplementOperationCount(int complementingEditRules) {
	}

	/**
	 * @param repairCount
	 *            Complement Matchings
	 */
	public void logComplementMatchingCount(int repairCount) {
		if (isLogging()) {
			System.out.println("Re.Vision[Repair Count]: " + repairCount);
		}
	}
}
