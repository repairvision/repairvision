package org.sidiff.repair.history.evaluation.report.monitor;

import org.sidiff.consistency.common.monitor.LogTable;
import org.sidiff.consistency.common.monitor.LogTime;
import org.sidiff.editrule.recognition.configuration.RecognitionEngineMonitor;
import org.sidiff.repair.history.evaluation.report.RecognitionLog;

public class RecognitionEngineLogMonitor extends RecognitionEngineMonitor {

	private LogTable recognitionLog;
	
	public RecognitionEngineLogMonitor(LogTable recognitionLog) {
		this.recognitionLog = recognitionLog;
		setLogging(true);
	}
	
	@Override
	public void logChangeActionCount(int size) {
		super.logChangeActionCount(size);
		recognitionLog.append(RecognitionLog.COL_CHANGE_NODE_COUNT, size);
	}
	
	@Override
	public void logChangeCount(int domainSize) {
		super.logChangeCount(domainSize);
		recognitionLog.append(RecognitionLog.COL_CHANGE_COUNT_SUM, domainSize);
	}
	
	public void logMatchingTime(LogTime matchingTimer) {
		super.logMatchingTime(matchingTimer);
		recognitionLog.append(RecognitionLog.COL_TIME_MATCHING_TIME, matchingTimer);
	}
}
