package org.sidiff.consistency.common.monitor;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.sidiff.consistency.common.java.StringPrinter;

public class LogTable {

	public static final Object NA = new Object() {
		
		@Override
		public String toString() {
			return "N/A";
		}
	};
	
	protected Map<String, List<Object>> table = new LinkedHashMap<>();
	
	protected List<Object> maxColumn = Collections.emptyList();
	
	protected Map<Class<?>, StringAdapter> toStringAdapters = new HashMap<>();
	
	public boolean createColumn(String name) {
		return (table.putIfAbsent(name, new ArrayList<>()) == null);
	}
	
	public boolean removeColumn(String name) {
		return (table.remove(name) != null);
	}
	
	public boolean containsColumn(String name) {
		return table.containsKey(name);
	}
	
	public List<Object> getColumn(String name) {
		
		// create column if absent:
		if (!containsColumn(name)) {
			createColumn(name);
		}
		
		// get column by name key:
		return Collections.unmodifiableList(table.get(name));
	}
	
	public Set<String> getColumns() {
		return Collections.unmodifiableSet(table.keySet());
	}
	
	public boolean append(String name, Object value) {
		return append(name, value, true, false);
	}
	
	public boolean append(String name, Object value, boolean lastRow, boolean unique) {
		
		// create column if absent:
		if (!containsColumn(name)) {
			createColumn(name);
		}
		
		// get column by name key:
		List<Object> column = table.get(name);
		
		// check if value is unique in this column:
		if (unique && column.contains(value)) {
			return false;
		}
		
		// fill column until last row:
		if (lastRow) {
			for (int i = 0; i < (maxColumn.size() - 1); i++) {
				column.add(NA);
			}
		}
		
		// add new value to column:
		column.add(value);
		
		// check for new row:
		if (column.size() > maxColumn.size()) {
			maxColumn = column;
		}
		
		return true;
	}
	
	public StringAdapter setToStringAdapter(Class<?> type, StringAdapter toStringAdapter) {
		return toStringAdapters.put(type, toStringAdapter);
	}
	
	public StringAdapter removeToStringAdapter(Class<?> type) {
		return toStringAdapters.remove(type);
	}
	
	public void dump() {
		System.out.println(toString());
	}
	
	@Override
	public String toString() {
		StringPrinter toString = new StringPrinter();
		
		for (Entry<String, List<Object>> tableEntry : table.entrySet()) {
			toString.println(tableEntry.getKey());
			
			for (Object value : tableEntry.getValue()) {
				StringAdapter stringAdapter = toStringAdapters.get(value.getClass());
				
				if (stringAdapter != null) {
					toString.println(2, stringAdapter.toString(value));
				} else {
					toString.println(2, value);
				}
			}
		}
		
		return toString.toString();
	}
	
	public void toCSV(String fileName) {
		CSVPrinter csvFilePrinter = null;
		FileWriter fileWriter = null;
		
		try {
			CSVFormat csvFileFormat = CSVFormat.DEFAULT.withRecordSeparator("\n");
			csvFileFormat = csvFileFormat.withDelimiter(';');
			
			// print header:
			csvFileFormat = csvFileFormat.withHeader(table.keySet().toArray(new String[0]));
			
			fileWriter = new FileWriter(fileName);
			csvFilePrinter = new CSVPrinter(fileWriter, csvFileFormat);
			
			// print record:
			for (int i = 0; i < maxColumn.size(); i++) {
				for (List<Object> column : table.values()) {
					if (column.size() > i) {
						Object value = column.get(i);
						
						if (value != null) {
							StringAdapter stringAdapter = toStringAdapters.get(value.getClass());
							
							if (stringAdapter != null) {
								csvFilePrinter.print(stringAdapter.toString(value));
							} else {
								csvFilePrinter.print(value);
							}
						} else {
							csvFilePrinter.print("null");
						}
					} else {
						csvFilePrinter.print(NA);
					}
				}
			}
			csvFilePrinter.println();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (csvFilePrinter != null) {
				try {
					csvFilePrinter.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (fileWriter != null) {
				try {
					fileWriter.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public void clearLog() {
		table.clear();
	}
}
