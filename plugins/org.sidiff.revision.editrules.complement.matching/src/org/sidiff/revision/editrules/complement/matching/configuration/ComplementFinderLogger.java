package org.sidiff.revision.editrules.complement.matching.configuration;

import java.util.logging.Level;

import org.sidiff.revision.common.logging.ReVisionLogger;
import org.sidiff.revision.common.logging.util.LogTime;
import org.sidiff.revision.common.logging.util.LogUtil;

public class ComplementFinderLogger extends ReVisionLogger {

	/**
	 * @param recognitionTimer
	 *            [Time (ms)] Recognition Time
	 */
	public void logRecognitionTime(LogTime recognitionTimer) {
		if (logger.isLoggable(Level.FINER)) {
			logger.log(Level.FINER, "[Recognition Time]", LogUtil.getTime(recognitionTimer));
		}
	}
}
