package org.sidiff.consistency.common.monitor;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class LogUtil {

	public static void appendTime(LogTable log, String name, LogTime timer) {
		List<Object> matchingTimerSumAll = log.getColumn(name);
		
		if (matchingTimerSumAll.size() <= log.getLastIndex()) {
			log.append(name, timer);
		} else {
			LogTime matchingTimerSum = (LogTime) matchingTimerSumAll.get(log.getLastIndex());
			matchingTimerSum.append(timer);
		}
	}
	
	public static <T> List<T> merge(String column, Class<? extends T> type, LogTable... tables) {
		List<T> mergedColumn = new ArrayList<>();
		
		for (LogTable table : tables) {
			mergedColumn.addAll(table.getColumn(column, type));
		}
		
		return mergedColumn;
	}
	
	public static String convertToLatex(LogTable log) {
		StringBuilder table = new StringBuilder();
		List<String> header = new ArrayList<>(log.getColumns());
		
		// calculate layout:
		int[] minColumnSize = new int[header.size()];
		
		for (int i = 0; i < header.size(); i++) {
			String column = header.get(i);
			
			if (column.length() > minColumnSize[i]) {
				minColumnSize[i] = column.length();
			}
			
			for (Object value : log.getColumn(column)) {
				String stringValue = log.valueToString(value);
				
				if (stringValue.length() > minColumnSize[i]) {
					minColumnSize[i] = stringValue.length();
				}
			}
		}
		
		// print table:
		for (int i = 0; i < header.size(); i++) {
			String column = header.get(i);
			
			table.append(column);
			table.append(StringUtils.repeat(" ", minColumnSize[i] - column.length()));
			
			if (i < (header.size() - 1)) {
				table.append(" & ");
			}
		}
		table.append(" \\\\\n");
		
		for (int i = 0; i < log.getLastIndex(); i++) {
			for (int j = 0; j < header.size(); j++) {
				String column = header.get(j);
				String value = log.valueToString(log.getColumn(column).get(i));
				
				table.append(value);
				table.append(StringUtils.repeat(" ", minColumnSize[j] - value.length()));
				
				if (j < (header.size() - 1)) {
					table.append(" & ");
				}
			}
			table.append(" \\\\\n");
		}
		
		return table.toString();
	}
	
	public static Object division(int a, int b) {
		if (b != 0) {
			return a / b;
		}
		return StringAdapter.NA;
	}
}
