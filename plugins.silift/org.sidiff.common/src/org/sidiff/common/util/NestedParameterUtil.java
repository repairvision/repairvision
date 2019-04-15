package org.sidiff.common.util;

import java.util.ArrayList;

/**
 * Utility class for parsing nested parameter strings.
 * 
 * 
 * @author wenzel
 */
public class NestedParameterUtil {

	public static final String PARAM_SEPARATOR = ";";

	/**
	 * Bsp.: parameter:
	 * "ListLCSComparator[ElementSimilarComparator[true;0.8];true;0.7];true;0.6"
	 * return-Wert: 
	 * String array index 0: ListLCSComparator[ElementSimilarComparator[true;0.8];true;0.7] 
	 * index 1: true
	 * index 2: 0.6
	 * 
	 * @param parameter
	 * @return
	 */
	public static final String[] getParameterSegments(String parameter) {
		if (hasNestedParameter(parameter)) {
			char[] parameterArray = parameter.toCharArray();
			int countedBrackets = 0;
			ArrayList<int[]> relevantChar = new ArrayList<int[]>();
			int lastIndex = 0;
			for (int i = 0; i < parameterArray.length; i++) {
				if (parameterArray[i] == '[') {
					countedBrackets++;
				}
				if (parameterArray[i] == ']') {
					countedBrackets--;
				}
				if (countedBrackets == 0 && parameterArray[i] == ';') {
					relevantChar.add(new int[] { lastIndex, i });
					lastIndex = i + 1;
				}
			}
			relevantChar.add(new int[] { lastIndex, parameter.length() });

			String[] parameterSegments = new String[relevantChar.size()];
			for (int i = 0; i < relevantChar.size(); i++) {
				int[] sequenze = relevantChar.get(i);
				parameterSegments[i] = parameter.substring(sequenze[0], sequenze[1]);
			}
			return parameterSegments;
		} else
			return parameter.split(PARAM_SEPARATOR);
	}

	/**
	 * Bsp.: parameter:
	 * "ListLCSComparator[ElementSimilarComparator[true;0.8];true;0.7];true;0.6"
	 * return-Wert: "ListLCSComparator;true;0.6"
	 * 
	 * @param parameter
	 * @return
	 */
	public static final String getTopLevelParameterString(String parameter) {
		char[] parameterArray = parameter.toCharArray();
		int countedBrackets = 0;
		ArrayList<int[]> relevantChar = new ArrayList<int[]>();
		int lastIndex = 0;
		for (int i = 0; i < parameterArray.length; i++) {
			if (parameterArray[i] == '[') {
				if (countedBrackets == 0) {
					countedBrackets++;
					relevantChar.add(new int[] { lastIndex, i });
				} else
					countedBrackets++;
			}
			if (parameterArray[i] == ']') {
				if (countedBrackets == 1) {
					countedBrackets--;
					lastIndex = i + 1;
				} else
					countedBrackets--;
			}
		}
		relevantChar.add(new int[] { lastIndex, parameter.length() });

		String rParameter = "";
		for (int[] sequence : relevantChar)
			rParameter = rParameter + parameter.substring(sequence[0], sequence[1]);
		return rParameter;
	}

	/**
	 * Bsp.: 1) ListLCSComparator[ElementSimilarComparator[true;0.8];true;0.7]
	 * --> true 2) 0.8 --> false
	 * 
	 * @param parameter
	 * @return
	 */
	public static final boolean hasNestedParameter(String parameter) {
		// XXX Alternativ auf korrekte Anzahl Klammern testen
		return parameter.matches(".*\\[+.*\\]+.*");
	}

	/**
	 * Falls der übergebene String parameter gar kein complexer/composite
	 * parameter ist, so wird eine Exception geworfen. Ansonsten: Gibt immer ein
	 * String array mit 2 elementen zurück.
	 * 
	 * Bsp: 1) ListLCSComparator[ElementSimilarComparator[true;0.8];true;0.7]
	 * return-Wert: 
	 * String array index 0: ListLCSComparator 
	 * index 1: ElementSimilarComparator[true;0.8];true;0.7
	 * 
	 * 2) parameter: "true" --> throw an exception
	 * 
	 * @param parameter
	 * @return
	 */
	public static final String[] splitCompositeParamter(String parameter) {
		assert (hasNestedParameter(parameter) && parameter.endsWith("]")) : "Invalid parameter for split command: "
				+ parameter;

		int bracketIndex = parameter.indexOf("[");
		String[] compositeArray = new String[2];
		compositeArray[0] = parameter.substring(0, bracketIndex);
		compositeArray[1] = parameter.substring(bracketIndex + 1, parameter.length() - 1);

		return compositeArray;
	}

}
