package org.sidiff.revision.repair.history.evaluation.report.logger;

import java.util.logging.Level;

import org.sidiff.revision.common.logging.table.LogTable;
import org.sidiff.revision.common.logging.util.LogTime;
import org.sidiff.revision.repair.api.configuration.RepairLogger;
import org.sidiff.revision.repair.history.evaluation.report.InconsistenciesLog;

public class PEORepairTableLogger extends RepairLogger {

	private static final boolean DEBUG = false;
	
	private LogTable repairLog;
	
	public PEORepairTableLogger(LogTable repairLog) {
		super();
		this.repairLog = repairLog;
		getLogger().setLevel(Level.ALL);
	}

	@Override
	public void logChangeCount(int size) {
		if (DEBUG) super.logChangeCount(size);
		repairLog.append(InconsistenciesLog.COL_CHANGE_COUNT, size);
	}
	
	@Override
	public void logComplementMatchingCount(int repairCount) {
		if (DEBUG) super.logComplementMatchingCount(repairCount);
		repairLog.append(InconsistenciesLog.COL_COMPLEMENT_MATCHINGS, repairCount);
	}
	
	@Override
	public void logComplementMatchingTime(LogTime complementMatchingTimer) {
		if (DEBUG) super.logComplementMatchingTime(complementMatchingTimer);
		repairLog.append(InconsistenciesLog.COL_TIME_COMPLEMENT_MATCHING, complementMatchingTimer);
	}
	
	@Override
	public void logComplementOperationCount(int complementingEditRules) {
		if (DEBUG) super.logComplementOperationCount(complementingEditRules);
		repairLog.append(InconsistenciesLog.COL_COMPLEMENTS, complementingEditRules);
	}
	
	@Override
	public void logDifferenceTime(LogTime diffTimer) {
		if (DEBUG) super.logDifferenceTime(diffTimer);
		repairLog.append(InconsistenciesLog.COL_TIME_LOAD_CALCULATE_REVISION, diffTimer);
	}
	
	@Override
	public void logEditRuleCount(int size) {
		if (DEBUG) super.logEditRuleCount(size);
	}
	
	@Override
	public void logInconsistencyCount(int size) {
		if (DEBUG) super.logInconsistencyCount(size);
		repairLog.append(InconsistenciesLog.COL_INCONSISTENCIES, size);
	}
	
	@Override
	public void logPotentialEditRuleCount(int potentialEditRules) {
		if (DEBUG) super.logPotentialEditRuleCount(potentialEditRules);
		repairLog.append(InconsistenciesLog.COL_POTENTIAL_EDIT_RULES, potentialEditRules);
	}
	
	@Override
	public void logValidationTime(LogTime valiationTimer) {
		if (DEBUG) super.logValidationTime(valiationTimer);
	}
}
