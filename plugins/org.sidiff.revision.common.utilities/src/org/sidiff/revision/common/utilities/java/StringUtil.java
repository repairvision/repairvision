package org.sidiff.revision.common.utilities.java;

public class StringUtil {

	/**
	 * Convert first character of given string to lower case.
	 * 
	 * @param source_p
	 * @return new String with first character converted.
	 */
	public static String toLowerFirst(String source_p) {
		StringBuffer result = new StringBuffer(source_p);
		String firstCharacter = source_p.substring(0, 1).toLowerCase();
		result.setCharAt(0, firstCharacter.charAt(0));
		return result.toString();
	}

	/**
	 * Convert first character of given string to upper case.
	 * 
	 * @param source_p
	 * @return new String with first character converted.
	 */
	public static String toUpperFirst(String source_p) {
		StringBuffer result = new StringBuffer(source_p);
		String firstCharacter = source_p.substring(0, 1).toUpperCase();
		result.setCharAt(0, firstCharacter.charAt(0));
		return result.toString();
	}
}
