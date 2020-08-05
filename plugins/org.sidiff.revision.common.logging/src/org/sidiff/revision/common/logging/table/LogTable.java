package org.sidiff.revision.common.logging.table;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Predicate;
import java.util.Set;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import org.sidiff.revision.common.utilities.string.StringPrinter;

public class LogTable {

	public static final Object NA = StringAdapter.NA;
	
	public static final StringAdapter DEFAULT_STRING_ADAPTER = new StringAdapter();
	
	private String fileName;
	
	private LogTypeDefinition typeDefinition = new LogTypeDefinition();
	
	private Map<String, List<Object>> table = new LinkedHashMap<>();

	private List<Object> maxColumn = Collections.emptyList();
	
	private Map<Class<?>, StringAdapter> toStringAdapters = new HashMap<>();

	public class Row {
		
		private LogTable table;
		
		private int index;
		
		public Row(LogTable table, int index) {
			this.table = table;
			this.index = index;
		}
		
		public <T> T get(String column, Class<T> type) {
			return table.getColumn(column, type).get(index);
		}
	}
	
	public int size() {
		return maxColumn.size();
	}
	
	public Row getRow(int index) {
		return new Row(this, index);
	}
	
	public void filterRows(Predicate<Row> filter) {
		List<Integer> filtered = new ArrayList<>();
		int offset = 0;
		
		for (int i = 0; i < maxColumn.size(); i++) {
			if (filter.test(getRow(i))) {
				filtered.add(i);
			}
		}
		
		for (Integer row : filtered) {
			for (List<Object> column : table.values()) {
				int index = (row - offset);
				
				if (column.size() > index) {
					column.remove(index);
				}
			}
			++offset;
		}
	}
	
	public boolean createColumn(String name) {
		return (table.putIfAbsent(name, new ArrayList<>()) == null);
	}
	
	@SuppressWarnings("unchecked")
	public boolean createColumn(String name, List<?> values) {
		
		if (maxColumn.size() < values.size()) {
			this.maxColumn = (List<Object>) values;
		}
		
		return (table.putIfAbsent(name, (List<Object>) values) == null);
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
	
	@SuppressWarnings("unchecked")
	public <T> List<T> getColumn(String name, Class<? extends T> type) {
		List<T> values = new ArrayList<>();
		
		for(Object objectValue : getColumn(name)) {
			if (type.isInstance(objectValue)) {
				values.add((T) objectValue);
			}
		}
		
		return values;
	}
	
	public Set<String> getColumns() {
		return Collections.unmodifiableSet(table.keySet());
	}
	
	public Object set(String name, int index, Object value) {
		return table.get(name).set(index, value);
	}
	
	public void append(String name, Object value) {
		append(name, value, true, false);
	}
	
	public void append(String name, List<?> values) {
		for (Object value : values) {
			append(name, value);
		}
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
			for (int i = column.size(); i < (maxColumn.size() - 1); i++) {
				column.add(StringAdapter.NA);
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
	
	public String valueToString(Object value) {
		StringAdapter stringAdapter = toStringAdapters.get(value.getClass());

		if (stringAdapter != null) {
			return stringAdapter.toString(value);
		} else {
			return DEFAULT_STRING_ADAPTER.toString(value);
		}
	}
	
	@SuppressWarnings("unchecked")
	public <T> T stringToValue(Class<? extends T> type, String value) {
		StringAdapter stringAdapter = toStringAdapters.get(type);
		
		if (stringAdapter != null) {
			return (T) stringAdapter.toValue(value);
		} else {
			return (T) DEFAULT_STRING_ADAPTER.toValue(value);
		}
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
				toString.println(2, valueToString(value));
			}
		}
		
		return toString.toString();
	}
	
	public void toCSV(String fileName) {
		this.fileName = fileName;
		
		CSVPrinter csvFilePrinter = null;
		FileWriter fileWriter = null;
		
		try {
			CSVFormat csvFileFormat = CSVFormat.DEFAULT.withRecordSeparator("\n");
			csvFileFormat = csvFileFormat.withDelimiter(';');
			
			// print header:
			csvFileFormat = csvFileFormat.withHeader(table.keySet().toArray(new String[0]));
			
			new File(fileName).getParentFile().mkdirs();
			fileWriter = new FileWriter(fileName);
			csvFilePrinter = new CSVPrinter(fileWriter, csvFileFormat);
			
			// print record:
			for (int i = 0; i < maxColumn.size(); i++) {
				for (List<Object> column : table.values()) {
					if (column.size() > i) {
						csvFilePrinter.print(valueToString(column.get(i)));
					} else {
						csvFilePrinter.print(StringAdapter.NA);
					}
				}
				csvFilePrinter.println();
			}
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
	
	public void loadCSV(String fileName) {
		loadCSV(fileName, false);
	}
	
	public void loadCSV(String fileName, boolean trim) {
		this.fileName = fileName;
		
		CSVParser csvFileParser = null;
		FileReader fileReader = null;
		
		try {
			CSVFormat csvFileFormat = CSVFormat.DEFAULT.withRecordSeparator("\n");
			csvFileFormat = csvFileFormat.withDelimiter(';');
			csvFileFormat = csvFileFormat.withFirstRecordAsHeader();
			
			fileReader = new FileReader(fileName);
			csvFileParser = new CSVParser(fileReader, csvFileFormat);
			
			String[] header = csvFileParser.getHeaderMap().keySet().toArray(new String[0]);
			
			for (String columnName : header) {
				table.put(getEntry(columnName, trim), new ArrayList<>());
			}
			
			for (CSVRecord record : csvFileParser.getRecords()) {
				for (int i = 0; i < record.size(); i++) {
					String stringValue = getEntry(record.get(i), trim);
					String columnName = getEntry(header[i], trim);
					
					Object value = stringToValue(typeDefinition.getType(columnName), stringValue);
					table.get(columnName).add(value);
				}
			}
			
			if (header.length > 0) {
				this.maxColumn = table.get(getEntry(header[0], trim));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (csvFileParser != null) {
				try {
					csvFileParser.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (fileReader != null) {
				try {
					fileReader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	private String getEntry(String value, boolean trim) {
		return trim ? value.trim() : value;
	}
	
	public String getFileName() {
		return fileName;
	}
	
	public LogTypeDefinition getTypeDefinition() {
		return typeDefinition;
	}
	
	public void setTypeDefinition(LogTypeDefinition typeDefinition) {
		this.typeDefinition = typeDefinition;
	}
	
	public void clearLog() {
		table.clear();
	}
}
