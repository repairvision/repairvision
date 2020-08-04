package org.sidiff.revision.repair.history.evaluation.report.logger;

import java.util.logging.Level;

import org.sidiff.revision.common.logging.table.LogTable;
import org.sidiff.revision.common.logging.util.LogTime;
import org.sidiff.revision.common.logging.util.LogUtil;
import org.sidiff.revision.editrules.complement.matching.configuration.ComplementFinderLogger;
import org.sidiff.revision.repair.history.evaluation.report.InconsistenciesLog;

public class ComplementFinderTableLogger extends ComplementFinderLogger {

	private static final boolean DEBUG = false;
	
	private LogTable repairLog;
	
	public ComplementFinderTableLogger(LogTable repairLog) {
		super();
		this.repairLog = repairLog;
		getLogger().setLevel(Level.ALL);
	}
	
	@Override
	public void logRecognitionTime(LogTime recognitionTimer) {
		if (DEBUG) super.logRecognitionTime(recognitionTimer);
		LogUtil.appendTime(repairLog, InconsistenciesLog.COL_TIME_RECOGNITION, recognitionTimer);
	}
}
