package org.sidiff.revision.repair.history.evaluation.report.logger;

import java.util.logging.Level;

import org.eclipse.emf.henshin.model.Rule;
import org.sidiff.revision.common.logging.table.LogTable;
import org.sidiff.revision.common.logging.util.LogTime;
import org.sidiff.revision.editrules.recognition.configuration.RecognitionLogger;
import org.sidiff.revision.repair.history.evaluation.report.RecognitionLog;

public class RecognitionTableLogger extends RecognitionLogger {

	private static final boolean DEBUG = false;
	
	private LogTable recognitionLog;
	
	public RecognitionTableLogger(LogTable recognitionLog) {
		super();
		this.recognitionLog = recognitionLog;
		getLogger().setLevel(Level.FINER); // Do not log stepwise during evaluation!
	}
	
	@Override
	public void logChangeActionCount(int size) {
		if (DEBUG) super.logChangeActionCount(size);
		recognitionLog.append(RecognitionLog.COL_CHANGE_NODE_COUNT, size);
	}
	
	@Override
	public void logChangeCount(int domainSize) {
		if (DEBUG) super.logChangeCount(domainSize);
		recognitionLog.append(RecognitionLog.COL_CHANGE_COUNT_SUM, domainSize);
	}
	
	public void logMatchingTime(LogTime matchingTimer) {
		if (DEBUG) super.logMatchingTime(matchingTimer);
		recognitionLog.append(RecognitionLog.COL_TIME_MATCHING_TIME, matchingTimer);
	}
	
	public void logEditRule(Rule editRule) {
		if (DEBUG) super.logEditRule(editRule);
	}

	public void logRecognitionTime(LogTime matchingTime) {
		if (DEBUG) super.logRecognitionTime(matchingTime);
	}

	public void logFalsePositives(int falsePositives) {
		if (DEBUG) logFalsePositives(falsePositives);
	}

	public void logFoundMatchings(int matchings) {
		if (DEBUG) logFoundMatchings(matchings);
	}
}
