package org.sidiff.revision.common.logging.table;

public class StringAdapter {

	public static final Object NA = new Object() {
		
		private static final String na = "n.a.";
		
		@Override
		public String toString() {
			return na;
		}
	};
	
	public String toString(Object obj) {
		if (obj != null) {
			return obj.toString();
		}
		return "null";
	}
	
	public Object toValue(String value) {
		
		// Parse N/A:
		if (value.equals(NA.toString())) {
			return NA;
		}
		
		// Parse null:
		if (value.equals("null")) {
			return null;
		}
		
		// Parse integer:
		try {
			return Integer.valueOf(value);
		} catch (Exception e) {
		}
		
		// Parse floating point:
		try {
			return Double.valueOf(value);
		} catch (Exception e) {
		}
		
		// Parse boolean:
		try {
			if (value.equalsIgnoreCase("true")) {
				return true;
			}
			if (value.equalsIgnoreCase("false")) {
				return false;
			}
		} catch (Exception e) {
		}
		
		// Return string:
		return value;
	}
	
	public Class<?> getType() {
		return Object.class;
	}
}
