package org.sidiff.editrule.tools.util;

public class EditRuleNaming {

	/**
	 * @param name
	 *            A new rule name:\n\n(format: words and whitespaces - e.g.:
	 *            Create new EClass
	 * @return The formated name.
	 */
	public static String formatFileName(String name) {
		String[] words = name.split(" ");
		StringBuffer fileName = new StringBuffer();
		
		for (String word : words) {
			fileName.append(word.toLowerCase() + "_");
		}
		
		return fileName.substring(0, fileName.length() - 1);
	}

	/**
	 * @param name
	 *            A new rule name:\n\n(format: words and whitespaces - e.g.:
	 *            Create new EClass
	 * @return The formated name.
	 */
	public static String formatModuleName(String name) {
		String[] words = name.split(" ");
		StringBuffer fileName = new StringBuffer();
		
		for (String word : words) {
			fileName.append(String.valueOf(word.charAt(0)).toUpperCase());
			fileName.append(word.substring(1, word.length()));
		}
		
		return fileName.toString();
	}

	/**
	 * @param name
	 *            A new rule name:\n\n(format: words and whitespaces - e.g.:
	 *            Create new EClass
	 * @return The formated name.
	 */
	public static String formatRuleName(String name) {
		String moduleName = formatModuleName(name);
		return String.valueOf(moduleName.charAt(0)).toLowerCase() + moduleName.substring(1, moduleName.length());
	}
	
	public static String removeCamelCase(String name) {
		String regex = "([a-z \\)])([A-Z \\(]+)";
		String replacement = "$1 $2";
		return  name.replaceAll(regex, replacement);
	}
}
