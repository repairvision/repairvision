package org.sidiff.revision.repair.history.evaluation.report.generator;

import static org.sidiff.revision.common.logging.util.LogUtil.NA;

import java.util.LinkedHashMap;
import java.util.Map;

import org.sidiff.revision.common.logging.table.LogTable;
import org.sidiff.revision.common.logging.table.LogTable.Row;
import org.sidiff.revision.repair.history.evaluation.report.InconsistenciesLog;

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
	
	public static String formatSum(Object... values) {
		if (isNotAvailable(values)) {
			return NA.toString();
		} else {
			StringBuilder text = new StringBuilder();
			
			for (int i = 0; i < values.length; i++) {
				text.append(values[i]);
				
				if (i < values.length - 1) {
					text.append(" + ");
				}
			}
			
			return text.toString();
		}
	}
	
	public static String formatFraction(Object... values) {
		if (isNotAvailable(values)) {
			return NA.toString();
		} else {
			StringBuilder text = new StringBuilder();
			
			for (int i = 0; i < values.length; i++) {
				text.append(values[i]);
				
				if (i < values.length - 1) {
					text.append("/");
				}
			}
			
			return text.toString();
		}
	}
	
	public static String formatFilter(Object... values) {
		if (isNotAvailable(values)) {
			return NA.toString();
		} else {
			StringBuilder text = new StringBuilder();
			
			for (int i = 0; i < values.length; i++) {
				text.append(values[i]);
				
				if (i < values.length - 1) {
					text.append(" $\\geq$ ");
				}
			}
			
			return text.toString();
		}
	}
	
	public static String formatResults(Object... values) {
		if (isNotAvailable(values)) {
			return NA.toString();
		} else {
			StringBuilder text = new StringBuilder();
			
			for (int i = 0; i < values.length; i++) {
				text.append(values[i]);
				
				if (i < values.length - 1) {
					text.append("; ");
				}
			}
			
			return text.toString();
		}
	}
	
	public static boolean isNotAvailable(Object... values) {
		for (Object value : values) {
			if (value != NA) {
				return false;
			}
		}
		return true;
	}
}
