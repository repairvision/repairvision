package org.sidiff.consistency.common.monitor;

import java.util.List;

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
	
	public static Object division(int a, int b) {
		if (b != 0) {
			return a / b;
		}
		return StringAdapter.NA;
	}
}
