package org.sidiff.consistency.common.monitor;

public class StringAdapter {

	public String toString(Object obj) {
		if (obj != null) {
			return obj.toString();
		}
		return "null";
	}
}
