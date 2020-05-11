package org.sidiff.revision.editrules.recognition.configuration;

import org.sidiff.common.utilities.monitor.LogTime;

public class RecognitionEngineMonitor {

	private boolean logging = true;

	public boolean isLogging() {
		return logging;
	}

	public void setLogging(boolean logging) {
		this.logging = logging;
	}

	/**
	 * @param matchingTimer
	 *            [Time (ms)] Matching Time
	 */
	public void logMatchingTime(LogTime matchingTimer) {
	}

	/**
	 * @param domainSize
	 *            Change Count (Sum)
	 */
	public void logChangeCount(int domainSize) {
	}

	/**
	 * @param size
	 *            Change Node Count
	 */
	public void logChangeActionCount(int size) {
	}
}
