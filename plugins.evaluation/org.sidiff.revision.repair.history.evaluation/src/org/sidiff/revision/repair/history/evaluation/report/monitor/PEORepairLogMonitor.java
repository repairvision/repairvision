package org.sidiff.revision.repair.history.evaluation.report.monitor;

import org.sidiff.consistency.common.monitor.LogTable;
import org.sidiff.consistency.common.monitor.LogTime;
import org.sidiff.revision.repair.api.peo.configuration.PEORepairMonitor;
import org.sidiff.revision.repair.history.evaluation.report.InconsistenciesLog;

public class PEORepairLogMonitor extends PEORepairMonitor {

	private LogTable repairLog;
	
	public PEORepairLogMonitor(LogTable repairLog) {
		this.repairLog = repairLog;
		setLogging(true);
	}

	@Override
	public void logChangeCount(int size) {
		super.logChangeCount(size);
		repairLog.append(InconsistenciesLog.COL_CHANGE_COUNT, size);
	}
	
	@Override
	public void logComplementMatchingCount(int repairCount) {
		super.logComplementMatchingCount(repairCount);
		repairLog.append(InconsistenciesLog.COL_COMPLEMENT_MATCHINGS, repairCount);
	}
	
	@Override
	public void logComplementMatchingTime(LogTime complementMatchingTimer) {
		super.logComplementMatchingTime(complementMatchingTimer);
		repairLog.append(InconsistenciesLog.COL_TIME_COMPLEMENT_MATCHING, complementMatchingTimer);
	}
	
	@Override
	public void logComplementOperationCount(int complementingEditRules) {
		super.logComplementOperationCount(complementingEditRules);
		repairLog.append(InconsistenciesLog.COL_COMPLEMENTS, complementingEditRules);
	}
	
	@Override
	public void logDifferenceTime(LogTime diffTimer) {
		super.logDifferenceTime(diffTimer);
		repairLog.append(InconsistenciesLog.COL_TIME_LOAD_CALCULATE_REVISION, diffTimer);
	}
	
	@Override
	public void logEditRuleCount(int size) {
		super.logEditRuleCount(size);
	}
	
	@Override
	public void logInconsistencyCount(int size) {
		super.logInconsistencyCount(size);
		repairLog.append(InconsistenciesLog.COL_INCONSISTENCIES, size);
	}
	
	@Override
	public void logPotentialEditRuleCount(int potentialEditRules) {
		super.logPotentialEditRuleCount(potentialEditRules);
		repairLog.append(InconsistenciesLog.COL_POTENTIAL_EDIT_RULES, potentialEditRules);
	}
	
	@Override
	public void logValidationTime(LogTime valiationTimer) {
		super.logValidationTime(valiationTimer);
	}
}
