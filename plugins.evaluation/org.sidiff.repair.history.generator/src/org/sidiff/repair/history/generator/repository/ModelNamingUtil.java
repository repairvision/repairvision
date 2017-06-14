package org.sidiff.repair.history.generator.repository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

// yyyy-mm-dd_VERSION_NAME.EXTENSION

public class ModelNamingUtil {
	
	public static String TIME_FORMAT = "yyyy-MM-dd";

	public static Date parseDate(String date) {
		SimpleDateFormat parser = new SimpleDateFormat(TIME_FORMAT);
		
		try {
			return parser.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static String unparseDate(Date date) {
		SimpleDateFormat parser = new SimpleDateFormat(TIME_FORMAT);
		return parser.format(date);
	}
	
	public static String parseFileName(String date, String version, String name) {
		return date + "_" + version + "_" + name;
	}
	
    public static Date getDate(String fileName) {
    	String[] segments = fileName.split("_");
		
		if (segments.length > 0) {
			return parseDate(segments[0]);
		}
		
		return null;
    }
	
	public static String getVersion(String name){
		String[] segments = name.split("_");
		
		if (segments.length > 1) {
			return segments[1];
		}
		
		return null;
	}
	
	public static String getModelName(String uri) {
		return uri.toString().substring(
				uri.toString().lastIndexOf("_") + 1,
				uri.toString().length());
	}
}
