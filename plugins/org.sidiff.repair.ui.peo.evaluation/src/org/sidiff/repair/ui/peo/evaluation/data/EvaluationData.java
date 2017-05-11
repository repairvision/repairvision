package org.sidiff.repair.ui.peo.evaluation.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class EvaluationData implements Serializable {

	private static final long serialVersionUID = 1L;

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
		}
		
		Object dataList = data.get(key);

		if (dataList instanceof List<?>) {
			((List<Object>) dataList).add(value);
		} else {
			throw new RuntimeException(key + " is no data list!");
		}
	}
	
	@SuppressWarnings("unchecked")
	public void appendSet(String key, Object value) {
		if (!data.containsKey(key)) {
			data.put(key, new HashSet<>());
		}
		
		Object dataList = data.get(key);

		if (dataList instanceof Set<?>) {
			((Set<Object>) dataList).add(value);
		} else {
			throw new RuntimeException(key + " is no data set!");
		}
	}
	
	@SuppressWarnings("unchecked")
	public void appendToRow(String dataKey, String rowKey, Object value) {
		if (!data.containsKey(dataKey)) {
			data.put(dataKey, new HashMap<>());
		}
		
		Object dataTable = data.get(dataKey);

		if (dataTable instanceof Map<?, ?>) {
			HashMap<String, List<Object>> rows = (HashMap<String, List<Object>>) dataTable;

			if (!rows.containsKey(rowKey)) {
				rows.put(rowKey, new ArrayList<Object>());
			}
			
			List<Object> row = rows.get(rowKey);
			row.add(value);
		} else {
			throw new RuntimeException(dataKey + " is no data set!");
		}
	}
	
	public void dump() {
		System.out.println(toString());
	}
	
	@Override
	public String toString() {
		StringBuffer string = new StringBuffer();
		appendToString(string, "", data);
		return string.toString();
	}
	
	@SuppressWarnings("unchecked")
	private void appendToString(StringBuffer string, String indent, Object value) {
		
		if (value instanceof Map<?,?>) {
			for (String key : sortKeysBySize((Map<String, List<?>>) value)) { //((Map<String,?>)value).keySet()) {
				string.append(indent + KEY_PREFIX + key + KEY_POSTFIX + "\n");
				appendToString(string, indent + INDENT, ((Map<String,?>)value).get(key));
			}
		} else if (value instanceof Iterable) {
			for (Object item : (Iterable<?>) value) {
				appendToString(string, indent + INDENT, item);
			}
		} else {
			string.append(indent + VALUE_PREFIX + toStringAdapter(value) + VALUE_POSTFIX + "\n");
		}
	}
	
	private <T> List<T> sortKeysBySize(Map<T, List<?>> map) {
		List<T> sorted = new ArrayList<>(map.keySet());
		
		sorted.sort(new Comparator<Object>() {

			@Override
			public int compare(Object keyA, Object keyB) {
				return map.get(keyB).size() - map.get(keyA).size();
			}
		});
		
		return sorted;
	}
	
	public String toStringAdapter(Object object) {
		return object.toString();
	}
	
	public void clear() {
		data.clear();
	}
}
