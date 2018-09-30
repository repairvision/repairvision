package org.sidiff.repair.history.evaluation.report.monitor;

import org.sidiff.consistency.common.monitor.LogTable;
import org.sidiff.consistency.common.monitor.LogTime;
import org.sidiff.consistency.common.monitor.LogUtil;
import org.sidiff.repair.complement.peo.configuration.ComplementFinderMonitor;
import org.sidiff.repair.history.evaluation.report.InconsistenciesLog;

public class ComplementFinderLogMonitor extends ComplementFinderMonitor {

	private LogTable repairLog;
	
	public ComplementFinderLogMonitor(LogTable repairLog) {
		this.repairLog = repairLog;
		setLogging(true);
	}
	
	@Override
	public void logRecognitionTime(LogTime recognitionTimer) {
		super.logRecognitionTime(recognitionTimer);
		LogUtil.appendTime(repairLog, InconsistenciesLog.COL_TIME_RECOGNITION, recognitionTimer);
	}
}
