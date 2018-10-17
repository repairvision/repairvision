package org.sidiff.repair.history.evaluation.report.generator;

import java.io.File;

import org.sidiff.consistency.common.monitor.LogTable;

public class EvaluationData {
	
	public File modelPath;
	
	public LogTable editRulesLog, historyLog, inconsistenciesLog, recognitionLog;
	
	public boolean isComplete() {
		return 
				modelPath != null && 
				editRulesLog != null && 
				historyLog != null && 
				inconsistenciesLog != null && 
				recognitionLog != null;
	}
}
