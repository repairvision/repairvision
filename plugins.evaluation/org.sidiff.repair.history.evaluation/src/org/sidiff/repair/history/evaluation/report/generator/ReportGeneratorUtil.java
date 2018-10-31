package org.sidiff.repair.history.evaluation.report.generator;

import java.util.LinkedHashMap;
import java.util.Map;

import org.sidiff.consistency.common.monitor.LogTable;
import org.sidiff.consistency.common.monitor.LogTable.Row;
import org.sidiff.repair.history.evaluation.report.InconsistenciesLog;

public class ReportGeneratorUtil {
	
	public static void printSupportedResolvedInconsistencies(LogTable... inconsistenciesLog) {
		Map<String, Integer> supported = new LinkedHashMap<>();
		Map<String, Integer> unsupported = new LinkedHashMap<>();
		
		for (LogTable log : inconsistenciesLog) {
			if (log.size() == 0) {
				System.err.println("Empty Log File: " + log.getFileName());
			}
			
			for (int i = 0; i < log.size(); i++) {
				Row inconsistency = log.getRow(i);
				String inconsistencyName = inconsistency.get(InconsistenciesLog.COL_INCONSISTENCY, String.class);
				
				if (inconsistency.get(InconsistenciesLog.COL_COUNT_OF_REPAIR_TREES, Integer.class) > 0) {
					if (supported.containsKey(inconsistencyName)) {
						supported.put(inconsistencyName, supported.get(inconsistencyName) + 1);
					} else {
						supported.put(inconsistencyName, 1);
					}
				} else {
					if (unsupported.containsKey(inconsistencyName)) {
						unsupported.put(inconsistencyName, unsupported.get(inconsistencyName) + 1);
					} else {
						unsupported.put(inconsistencyName, 1);
					}
				}
			}
		}
		
		System.out.println("Supported:");
		supported.forEach((key, value) ->  System.out.println(key + ": " + value));
		
		System.out.println("Unsupported:");
		unsupported.forEach((key, value) ->  System.out.println(key + ": " + value));
	}
}
