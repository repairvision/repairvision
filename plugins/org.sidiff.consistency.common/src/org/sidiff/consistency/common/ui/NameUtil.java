package org.sidiff.consistency.common.ui;

import java.util.HashMap;
import java.util.Map;

public class NameUtil {

	private static final Map<String, String> dict;

	static {
		dict = new HashMap<String, String>();
		dict.put("SET", "Set");
		dict.put("UNSET", "Unset");
		dict.put("ADD", "Add");
		dict.put("CREATE", "Create");
		dict.put("DELETE", "Delete");
		dict.put("MOVE", "Move");
		dict.put("REMOVE", "Remove");
		dict.put("CHANGE", "Change");
		dict.put("NOT", "Not");
		dict.put("REFERENCE", "Reference");
		dict.put("MOVEs", "Moves");
		dict.put("CHANGEs", "Changes");
		dict.put("FROM", "From");
		dict.put("TO", "To");
		dict.put("IN", "In");
		dict.put("ATTRIBUTE", "Attribute");
		dict.put("Id", "ID");
		dict.put("TGT", "Target");
		dict.put("SRC", "Source");
	}

	private static String dictionary(String input) {
		// Translate:
		String output = dict.get(input);

		if (output == null) {
			return input;
		} else {
			return output;
		}
	}
	
	public static String beautifyName(String name) {

		// Remove underscore
		name = name.replace('_', ' ');

		// Remove camel-case
		String regex = "([a-z])([A-Z]+)";
		String replacement = "$1 $2";
		name = name.replaceAll(regex, replacement);

		// Make first letters upper-case
		name = capitalizeFirstLetter(name);

		// Translate special words:
		name = translate(name);

		return name;
	}

	private static String capitalizeFirstLetter(String input) {
		StringBuilder result = new StringBuilder(input.length());
		String[] words = input.split("\\s");

		for (int i = 0, l = words.length; i < l; ++i) {
			if (i > 0) {
				result.append(" ");
			}
			result.append(Character.toUpperCase(words[i].charAt(0))).append(words[i].substring(1));

		}
		return result.toString();
	}

	private static String translate(String input) {
		StringBuilder result = new StringBuilder(input.length());
		String[] words = input.split("\\s");

		for (int i = 0, l = words.length; i < l; ++i) {
			if (i > 0) {
				result.append(" ");
			}
			result.append(dictionary(words[i]));

		}
		return result.toString();
	}
}
