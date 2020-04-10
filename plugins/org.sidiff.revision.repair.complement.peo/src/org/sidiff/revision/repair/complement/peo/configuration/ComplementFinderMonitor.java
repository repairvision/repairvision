package org.sidiff.revision.repair.complement.peo.configuration;

import org.sidiff.consistency.common.monitor.LogTime;

public class ComplementFinderMonitor {

	private boolean logging = true;

	public boolean isLogging() {
		return logging;
	}

	public void setLogging(boolean logging) {
		this.logging = logging;
	}

	/**
	 * @param recognitionTimer
	 *            [Time (ms)] Recognition Time
	 */
	public void logRecognitionTime(LogTime recognitionTimer) {
		// LogUtil.appendTime((LogMonitor) monitor, "[Time (ms)] Recognition Time", recognitionTimer);
	}
}
