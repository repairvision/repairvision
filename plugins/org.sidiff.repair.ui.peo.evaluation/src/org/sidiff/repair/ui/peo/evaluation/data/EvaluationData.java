package org.sidiff.repair.ui.peo.evaluation.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class EvaluationData implements Serializable {

	private static final long serialVersionUID = 5853124323952086752L;

	public static EvaluationData INSTANCE = new EvaluationData();
	
	private Map<String, Object> data = new HashMap<>();
	
	public String INDENT = "  ";
	
	public String KEY_PREFIX = "- ";
	
	public String KEY_POSTFIX = ":";
	
	public String VALUE_PREFIX = "- ";
	
	public String VALUE_POSTFIX = "";
	
	public void add(String key, Object value) {
		if (!data.containsKey(key)) {
			data.put(key, value);
		} else {
			throw new RuntimeException("Value (" + key + " : " + value + ") already exists!");
		}
	}
	
	public void delete(String key) {
		data.remove(key);
	}
	
	public void overwrite(String key, Object value) {
		data.put(key, value);
	}
	
	@SuppressWarnings("unchecked")
	public void appendList(String key, Object value) {
		if (!data.containsKey(key)) {
			data.put(key, new ArrayList<>());
		} else {
			Object dataList = data.get(key);
			
			if (dataList instanceof List<?>) {
				((List<Object>) dataList).add(value);
			} else {
				throw new RuntimeException(key + " is no data list!");
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	public void appendSet(String key, Object value) {
		if (!data.containsKey(key)) {
			data.put(key, new HashSet<>());
		} else {
			Object dataList = data.get(key);
			
			if (dataList instanceof Set<?>) {
				((Set<Object>) dataList).add(value);
			} else {
				throw new RuntimeException(key + " is no data set!");
			}
		}
	}
	
	public void dump() {
		System.out.println(toString());
	}
	
	@Override
	public String toString() {
		StringBuffer string = new StringBuffer();
		
		for (String key : data.keySet()) {
			string.append(KEY_PREFIX + key + KEY_POSTFIX + "\n");
			appendToString(string, "", data.get(key));
		}
		
		return string.toString();
	}
	
	private void appendToString(StringBuffer string, String indent, Object value) {
		if (value instanceof Iterable) {
			for (Object item : (Iterable<?>) value) {
				appendToString(string, indent + INDENT, item);
			}
		} else {
			string.append(indent + VALUE_PREFIX + value + VALUE_POSTFIX + "\n");
		}
	}
	
	public void clear() {
		data.clear();
	}
}
