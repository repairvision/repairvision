package org.sidiff.consistency.common.monitor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;

import org.apache.commons.lang3.StringUtils;

public class LogUtil {
	
	/**
	 * Symbolic value N/A.
	 */
	public static final Object NA = StringAdapter.NA; 
	
	/**
	 * Symbolic value TODO.
	 */
	public static final Object TODO = new Object() {
		
		private static final String todo = "TODO";
		
		@Override
		public String toString() {
			return todo;
		}
	};
	
	/**
	 * Symbolic value FIXME.
	 */
	public static final Object FIXME = new Object() {
		
		private static final String fixme = "FIXME";
		
		@Override
		public String toString() {
			return fixme;
		}
	};

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
	
	public static LogTable merge(LogTable... tables) {
		LogTable merged = new LogTable();
		Set<String> headers = new HashSet<>();
		
		for (LogTable table : tables) {
			for (String header : table.getColumns()) {
				if (!headers.contains(header)) {
					merged.createColumn(header, merge(header, Object.class, tables));
					headers.add(header);
				}
			}
		}
		
		return merged;
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
		return NA;
	}
	
	public static <T> Object count(List<T> list, T valueToCount) {
		int count = 0;
		
		for (T value : list) {
			if (value.equals(valueToCount)) {
				++count;
			}
		}
		
		return count;
	}
	
	public static <T> int test(List<T> list, Predicate<T> test) {
		int count = 0;
		
		for (T value : list) {
			if (test.test(value)) {
				++count;
			}
		}
		
		return count;
	}

	public static Object sum(List<Integer> list) {
		if (list.size() > 0) {
			int sum = 0;
			
			for (int value : list) {
				sum += value;
			}
			
			return sum;
		} else {
			return NA;
		}
	}
	
	public static Object min(List<Integer> list) {
		if (list.size() > 0) {
			int min = Integer.MAX_VALUE;
			
			for (Integer value : list) {
				if (value < min) {
					min = value;
				}
			}
			
			return min;
		} else {
			return NA;
		}
	}
	
	public static Object max(List<Integer> list) {
		if (list.size() > 0) {
			int max = Integer.MIN_VALUE;
			
			for (Integer value : list) {
				if (value > max) {
					max = value;
				}
			}
			
			return max;
		} else {
			return NA;
		}
	}
	
	public static Object avg(List<Integer> list) {
		if (list.size() > 0) {
			double sum = 0.0;
			double count = 0.0;
			
			for (int value : list) {
				sum += value;
				++count;
			}
			
			return (((double) ((int) ((sum / count) * 100))) / 100);
		} else {
			return NA;
		}
	}
	
	public static Object median(List<Integer> list) {
		Collections.sort(list);
		
		if (list.size() > 0) {
			if ((list.size() % 2) == 0) {
				return list.get(list.size() / 2) + list.get(list.size() / 2 - 1) / 2;
			} else {
				return list.get(list.size() / 2);
			}
		} else {
			return NA;
		}
	}
	
	public static Object round(Object value) {
		if (value instanceof Double) {
			return Math.round((double) value);
		} else {
			return value;
		}
	}
	
	public static Object assertPositive(Object value) {
		if (value instanceof Number) {
			Number number = (Number) value;
			
			if (number.doubleValue() < 0) {
				return FIXME;
			}
		}
		return value;
	}
}
