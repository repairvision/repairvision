package org.sidiff.common.util;

import java.io.*;
import java.util.*;

/**
 * Utility class for counting things or measuring times.
 * 
 * @author wenzel / reuling
 */
public class StatisticsUtil implements Serializable {

	/**
	 * Column separator.
	 */
	private static final String COL = ";";

	/**
	 * Row separator.
	 */
	private static final String ROW = System.getProperty("line.separator");

	/**
	 * 
	 */
	private static final long serialVersionUID = -6455875097937890547L;

	private static final String LINE_SEPERATOR = System.getProperty("line.separator");

	public enum StatisticType {
		Time, Size, Count, Other;
	}

	private static final String STAT_KEY_STARTTIME = "@@STARTOF@@";

	private Map<String, Object> timeStatistic;
	private Map<String, Object> sizeStatistic;
	private Map<String, Object> countStatistic;
	private Map<String, Object> otherStatistic;

	private static StatisticsUtil instance;
	private static boolean enabled = true;

	private StatisticsUtil() {
		this.timeStatistic = new HashMap<String, Object>();
		this.sizeStatistic = new HashMap<String, Object>();
		this.countStatistic = new HashMap<String, Object>();
		this.otherStatistic = new HashMap<String, Object>();
	}

	private StatisticsUtil(Map<String, Object> timeStatistic, Map<String, Object> sizeStatistic,
			Map<String, Object> countStatistic, Map<String, Object> otherStatistic) {
		this.timeStatistic = new HashMap<String, Object>(timeStatistic);
		this.sizeStatistic = new HashMap<String, Object>(sizeStatistic);
		this.countStatistic = new HashMap<String, Object>(countStatistic);
		this.otherStatistic = new HashMap<String, Object>(otherStatistic);
	}

	/**
	 * @return {@link StatisticsUtil} singleton.
	 */
	public static StatisticsUtil getInstance() {
		if (instance == null)
			instance = new StatisticsUtil();
		return instance;
	}
	
	public static void setInstance(StatisticsUtil util) {
		instance = util;
	}
	
	/**
	 * {@link StatisticsUtil} factory.
	 * 
	 * @return A new {@link StatisticsUtil}.
	 */
	public static StatisticsUtil createStatisticsUtil() {
		return new StatisticsUtil();
	}
	

	/**
	 * Copy constructor, using a static method.
	 */
	public static StatisticsUtil copiedInstance(StatisticsUtil statisticsUtil) {
		return new StatisticsUtil(statisticsUtil.getTimeStatistic(), statisticsUtil.getSizeStatistic(),
				statisticsUtil.getCountStatistic(), statisticsUtil.getOtherStatistic());
	}

	/**
	 * Disables the StatisticsUtil, used for performance reason
	 */
	public static void disable() {
		enabled = false;
	}

	/**
	 * Reenables the StatisticsUtil
	 */
	public static void reenable() {
		enabled = true;
	}

	public Map<String, Object> getTimeStatistic() {
		return timeStatistic;
	}

	public Map<String, Object> getSizeStatistic() {
		return sizeStatistic;
	}

	public Map<String, Object> getCountStatistic() {
		return countStatistic;
	}

	public Map<String, Object> getOtherStatistic() {
		return otherStatistic;
	}

	public Map<String, Object> getStatistic(StatisticType type) {
		switch(type) {
			case Time: return timeStatistic;
			case Size: return sizeStatistic;
			case Count: return countStatistic;
			case Other: return otherStatistic;
			default: return null;			
		}
	}

	/**
	 * Resets the StatisticsUtil. All data will be removed.
	 */
	public void reset() {
			this.timeStatistic.clear();
			this.sizeStatistic.clear();
			this.countStatistic.clear();
			this.otherStatistic.clear();
	}

	/**
	 * Resets all counters whose keys start with the given prefix.
	 * 
	 * @param keyPrefix
	 */
	public void resetCounters(String keyPrefix) {
		if (enabled) {
			reset(keyPrefix, countStatistic);
		}
	}

	/**
	 * Resets all sizes (integer values) whose keys start with the given prefix.
	 * 
	 * @param keyPrefix
	 */
	public void resetSizes(String keyPrefix) {
		if (enabled) {
			reset(keyPrefix, sizeStatistic);
		}
	}

	/**
	 * Resets all times whose keys start with the given prefix.
	 * 
	 * @param keyPrefix
	 */
	public void resetTimes(String keyPrefix) {
		if (enabled) {
			reset(keyPrefix, timeStatistic);
		}
	}

	/**
	 * Resets other statistics whose keys start with the given prefix.
	 * 
	 * @param keyPrefix
	 */
	public void resetOthers(String keyPrefix) {
		if (enabled) {
			reset(keyPrefix, otherStatistic);
		}
	}

	/**
	 * Resets all stored values whose keys start with the given prefix.
	 * 
	 * @param keyPrefix
	 */
	public void reset(String keyPrefix) {
		if (enabled) {
			resetCounter(keyPrefix);
			resetSizes(keyPrefix);
			resetTime(keyPrefix);
			resetOthers(keyPrefix);
		}
	}

	/**
	 * Resets all statistics whose keys start with the given prefix.
	 * 
	 * @param keyPrefix
	 * @param statistic
	 */
	private void reset(String keyPrefix, Map<String, Object> statistic) {
		if (enabled) {
			Set<String> keys = new HashSet<String>();

			for (String key : statistic.keySet()) {
				if (key.startsWith(keyPrefix)) {
					keys.add(key);
				}
			}

			for (String key : keys) {
				statistic.remove(key);
			}
		}
	}

	/**
	 * Starts the measurement of time for a given key.
	 * 
	 * @param key
	 */
	public void start(String key) {
		if (enabled) {
			Object o = timeStatistic.get(key);
			Long time = null;
			if(o instanceof Long)
			time = (Long) o;
			else if (o instanceof Float)
				time = ((Float)o).longValue();
			if (time == null)
				time = 0l;
			timeStatistic.put(STAT_KEY_STARTTIME + key, new Long(System.currentTimeMillis() - time));
		}
	}

	/**
	 * Stop the measurement of time for a given key. The time difference between the start time and the stop time will be stored.
	 * 
	 * @param key
	 * @return
	 */
	public float stop(String key) {
		if (enabled) {
			long stop = System.currentTimeMillis();
			Long startO = (Long) timeStatistic.get(STAT_KEY_STARTTIME + key);
			long start = startO == null ? 0 : startO.longValue();
			long time = (stop - start);
			timeStatistic.remove(STAT_KEY_STARTTIME + key);
			timeStatistic.put(key, time);
			return time / 1000f;
		}
		return 0;
	}

	/**
	 * Removes the measurement of time for a given key.
	 * 
	 * @param key
	 */
	public void resetTime(String key) {
		if (enabled) {
			timeStatistic.remove(STAT_KEY_STARTTIME + key);
		}
	}

	/**
	 * Returns the time that has been measured for the given key.
	 * 
	 * @param key
	 * @return
	 */
	public Long getTime(String key) {
		if (enabled) {
			try {
				return (long) (((Long) timeStatistic.get(key)) / 1000l);
			} catch (Exception e) {
				return 0l;
			}
		}
		return 0l;
	}

	/**
	 * Returns the data that is stored for the given key.
	 * 
	 * @param key
	 * @return
	 */
	public Object getObject(String key) {
		if (enabled) {
			return otherStatistic.get(key);
		}
		return null;
	}

	/**
	 * Returns the string data that is stored for the given key.
	 * 
	 * @param key
	 * @return
	 */
	public String getString(String key) {
		if (enabled) {
			return (String) otherStatistic.get(key);
		}
		return null;
	}

	/**
	 * Returns the integer data that is stored for the given key.
	 * 
	 * @param key
	 * @return
	 */
	public int getInt(String key) {
		if (enabled) {
			Integer i = ((Integer) otherStatistic.get(key));
			return (i == null) ? 0 : i.intValue();
		}
		return 0;
	}

	/**
	 * Stores an arbitrary data value for the given key.
	 * 
	 * @param key
	 * @param value
	 */
	public void put(String key, Object value) {
		if (enabled) {
			otherStatistic.put(key, value);
		}
	}
	
	/**
	 * Stores an time  value for the given key.
	 * 
	 * @param key
	 * @param value
	 */
	public void putTime(String key, float value) {
		if (enabled) {
			timeStatistic.put(key, value);
		}
	}

	/**
	 * Stores an integer value for the given key.
	 * 
	 * @param key
	 * @param value
	 */
	public void put(String key, int value) {
		if (enabled) {
			otherStatistic.put(key, new Integer(value));
		}
	}

	/**
	 * Stores a size (integer value) of a given key.
	 * 
	 * @param key
	 * @param value
	 */
	public void putSize(String key, int value) {
		if (enabled) {
			sizeStatistic.put(key, value);
		}
	}

	/**
	 * Returns the size (integer value) of a given key.
	 * 
	 * @param key
	 * @return
	 */
	public int getSize(String key) {
		if (enabled) {
			return (Integer) sizeStatistic.get(key);
		}
		return 0;
	}

	/**
	 * Returns the counter of the given key.
	 * 
	 * @param key
	 * @return
	 */
	public int getCounter(String key) {
		if (enabled) {
			if(countStatistic.get(key) != null)
				return (Integer) countStatistic.get(key);
		}
		return 0;
	}

	/**
	 * Resets the counter of the given key.
	 * 
	 * @param key
	 */
	public void resetCounter(String key) {
		if (enabled) {
			countStatistic.put(key, new Integer(0));
		}
	}

	/**
	 * Increases the counter for the given key.
	 * 
	 * @param key
	 */
	public void count(String key) {
		if (enabled) {
			int i = 0;
			if(countStatistic.get(key) != null)
				i = (Integer) countStatistic.get(key);
			countStatistic.put(key, ++i);
		}
	}

	/**
	 * Fügt data.value(data.key) an pos in map.value(data.key) ein.
	 * Fehlende Elemente in der Liste werden mit null aufgefüllt
	 * @param map
	 * @param data
	 * @param pos
	 */
	private void addToMap(Map<String, List<Object>> map, Map<String, Object> data, int pos) {
		for (Map.Entry<String, Object> e : data.entrySet()) {
			List<Object> d = map.get(e.getKey());
			if (d == null) {
				d = new ArrayList<Object>();
				map.put(e.getKey(), d);
			}
			while (d.size() <= pos) {
				d.add(null);
			}
			d.set(pos, e.getValue());
		}
	}

	/**
	 * Füllt alle map.value mit null auf, bis size erreicht ist
	 * @param map
	 * @param size
	 */
	private void fillMap(Map<String, List<Object>> map, int size) {
		for (List<Object> d : map.values()) {
			while (d.size() < size) {
				d.add(null);
			}
		}
	}

	/**
	 * Setzt alle null-Werte in allen map.value an pos mit einem Default-Wert
	 * @param map
	 * @param value Default-Wert
	 * @param pos
	 */
	private void setDefaultToMap(Map<String, List<Object>> map, Object value, int pos) {
		for (List<Object> d : map.values()) {
			Object v = d.get(pos);
			if (v == null) {
				d.set(pos, value);
			}
		}
	}

	/**
	 * Schreibt alles in eine CSV.
	 * Jeder Key wird eine Zeile. Time, Size, Count und Other wird je eine Spalte.
	 * Sind keine Daten vorhanden bleibt eine Zelle leer (Zum Ändern: setDefaultToMap-Aufrufe anpassen)
	 * @param file
	 * @throws IOException
	 */
	public void writeToCsv(String file) throws IOException {
		File csvFile = new File(file);
		BufferedWriter writer = null;
		Map<String, List<Object>> map = new HashMap<String, List<Object>>();
		addToMap(map, timeStatistic, 0);
		addToMap(map, sizeStatistic, 1);
		addToMap(map, countStatistic, 2);
		addToMap(map, otherStatistic, 3);
		fillMap(map, 4);
		setDefaultToMap(map, "", 0);
		setDefaultToMap(map, "", 1);
		setDefaultToMap(map, "", 2);
		setDefaultToMap(map, "", 3);
		try {
			writer = new BufferedWriter(new FileWriter(csvFile, true));
			StringBuffer sb = new StringBuffer();
			sb.append("Name" + COL + "Time" + COL + "Size" + COL + "Count" + COL + "Other" + ROW);
			sb.append("String" + COL + "Decimal" + COL + "Integer" + COL + "Integer" + COL + "String" + ROW);
			for (Map.Entry<String, List<Object>> e : map.entrySet()) {
				sb.append(e.getKey());
				for (Object o : e.getValue()) {
					sb.append(COL + o.toString());
				}
				sb.append(ROW);
			}
			writer.write(sb.toString());
		} catch (IOException e) {
			throw e;
		} finally {
			if (writer != null) {
				try {
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * Fügt die verschiedenen *Statistic-Maps in einer Map zusammen.
	 * Die Keys werden mit " :: Name", wobei Name der Name der Statistik ist, erweitert.
	 * @return
	 */
	public Map<String, Object> getUnifiedStatistics() {
		List<Map<String, Object>> maps = new ArrayList<Map<String, Object>>();
		maps.add(timeStatistic);
		maps.add(sizeStatistic);
		maps.add(countStatistic);
		maps.add(otherStatistic);
		List<String> extras = Arrays.asList(new String[] { "(ms)", "", "", "" });
		Map<String, Object> result = new HashMap<String, Object>();
		for (int i = 0; i < maps.size(); i++) {
			Map<String, Object> map = maps.get(i);
			String extra = extras.get(i);
			for (Map.Entry<String, Object> e : map.entrySet()) {
				result.put(e.getKey() + " " + extra , e.getValue());
			}
		}
		return result;
	}

	/**
	 * Erstellt den String, der in die von writeCSV2 erstellte Datei gespeichert wird
	 * @param maps
	 * @param extras
	 * @return
	 */
	private String getCsv2Data(List<Map<String, Object>> maps, List<String> extras) {
		StringBuilder sb1 = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		StringBuilder sb3 = new StringBuilder();
		for (int i = 0; i < maps.size(); i++) {
			Map<String, Object> map = maps.get(i);
			String extra = extras.get(i);
			for (Map.Entry<String, Object> e : map.entrySet()) {
				sb1.append(e.getKey() + (extra != null ? " :: " + extra : "") + COL);
				String name = e.getValue().getClass().getSimpleName();
				if ("Long".equals(name) || "Integer".equals(name)) {
					name = "Integer";
				} else if ("Float".equals(name) || "Double".equals(name)) {
					name = "Decimal";
				} else if ("Boolean".equals(name)) {
					name = "Boolean";
				} else {
					name = "String";
				}
				sb2.append(name + COL);
				sb3.append(e.getValue().toString() + COL);
			}
		}
		return sb1.substring(0, sb1.length() - 1) + LINE_SEPERATOR + sb2.substring(0, sb2.length() - 1) + LINE_SEPERATOR + sb3.substring(0, sb3.length() - 1);
	}

	/**
	 * Schreibt die Statistik in eine CSV-Datei.
	 * Jeder Key wird eine Spalte. Die Maps werden zusammengefasst, die Keys erhalten eine Erweiterung um zu unterscheiden,
	 * aus welcher *Statistics-Map sie stammen.
	 * @param file
	 * @throws IOException
	 */
	public void writeToCsv2(String file) throws IOException {
		File csvFile = new File(file);
		BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new FileWriter(csvFile, true));
			List<Map<String, Object>> maps = new ArrayList<Map<String, Object>>();
			maps.add(timeStatistic);
			maps.add(sizeStatistic);
			maps.add(countStatistic);
			maps.add(otherStatistic);
			List<String> extras = Arrays.asList(new String[] { "Time", "Size", "Count", "String" });
			writer.write(getCsv2Data(maps, extras));
		} catch (IOException e) {
			throw e;
		} finally {
			if (writer != null) {
				try {
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * Returns a textual dump of the stored information.
	 * 
	 * @return
	 */
	public String dump() {
		if (enabled) {
			String string = new String("*********************" + "Statistics" + "*********************" + LINE_SEPERATOR);
			string += "Time statistics (in ms):" + LINE_SEPERATOR;
			ArrayList<String> keys = new ArrayList<String>(timeStatistic.keySet());
			Collections.sort(keys);
			for (String key : keys)
				string += key + " = " + timeStatistic.get(key) + LINE_SEPERATOR;
			string += LINE_SEPERATOR;
			string += "Count statistics:" + LINE_SEPERATOR;
			ArrayList<String> keys2 = new ArrayList<String>(countStatistic.keySet());
			Collections.sort(keys2);
			for (String key : keys2)
				string += key + " = " + countStatistic.get(key) + LINE_SEPERATOR;
			string += LINE_SEPERATOR;
			string += "Size statistics:" + LINE_SEPERATOR;
			ArrayList<String> keys3 = new ArrayList<String>(sizeStatistic.keySet());
			Collections.sort(keys3);
			for (String key : keys3)
				string += key + " = " + sizeStatistic.get(key) + LINE_SEPERATOR;
			string += LINE_SEPERATOR;
			string += "Other statistics:" + LINE_SEPERATOR;
			ArrayList<String> keys4 = new ArrayList<String>(otherStatistic.keySet());
			Collections.sort(keys4);
			for (String key : keys4)
				string += key + " = " + otherStatistic.get(key) + LINE_SEPERATOR;
			return string + "**************************************************************";
		}
		return "";
	}

}
