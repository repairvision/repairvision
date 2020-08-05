package org.sidiff.revision.common.utilities.string;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;

public class NameUtil {
	
	public static String beautifyName(String name) {

		// Remove underscore
		name = name.replace('_', ' ');

		// Remove camel-case
		name = removeCamelCase(name);

		// Make first letters upper-case
		name = capitalizeFirstLetter(name);

		return name;
	}
	
	public static String removeCamelCase(String name) {
		String regex = "([a-z \\)])([A-Z \\(]+)";
		String replacement = "$1 $2";
		return  name.replaceAll(regex, replacement);
	}

	private static String capitalizeFirstLetter(String input) {
		StringBuilder result = new StringBuilder(input.length());
		String[] words = input.split("\\s");

		for (int i = 0, l = words.length; i < l; ++i) {
			if (i > 0) {
				result.append(" ");
			}
			
			if (words[i].length() > 1) {
				result.append(Character.toUpperCase(words[i].charAt(0))).append(words[i].substring(1));
			}
		}
		return result.toString();
	}

	public static String getName(EObject eObject) {

		// Generic name search:
		String name = "[" + eObject.eClass().getName() + "]";

		// Check for attribute "name":
		EStructuralFeature attrName = eObject.eClass().getEStructuralFeature("name");
		
		if (attrName != null && attrName instanceof EAttribute) {
			Object nameAttrValue = eObject.eGet(attrName);

			if (nameAttrValue instanceof String) {
				name = (String) nameAttrValue;
			}
		}
		
		return name;
	}
	
	public static String getQualifiedArgumentName(EObject eObject){
		String label = "";
		EObject eContainer = eObject.eContainer();
		
		if (eObject instanceof EAnnotation) {

			EAnnotation eAnnotation = (EAnnotation) eObject;
			String path = "";
			while (eContainer != null) {
				for (EAttribute a : eContainer.eClass().getEAllAttributes()) {
					if (a.getName().equalsIgnoreCase("name")) {
						path = eContainer.eGet(a) + "." + path;
					}
				}

				eContainer = eContainer.eContainer();
			}
			label = String.format("%s%s (%s)", path, eAnnotation.getSource(),
					eAnnotation.eClass().getName());
			return label;
		}

		for (EAttribute attribute : eObject.eClass().getEAllAttributes()) {
			if (attribute.getName().equalsIgnoreCase("name")) {
				String path = "";
				while (eContainer != null) {
					for (EAttribute a : eContainer.eClass().getEAllAttributes()) {
						if (a.getName().equalsIgnoreCase("name")) {
							path = eContainer.eGet(a) + "." + path;
						}
					}

					eContainer = eContainer.eContainer();
				}

				label = String.format("%s%s (%s)", path, (String) eObject
						.eGet(attribute), eObject.eClass().getName());

				return label;
			}
		}

		for (EAttribute attribute : eObject.eClass().getEAllAttributes()) {
			if (attribute.getName().equalsIgnoreCase("id")) {
				String path = "";
				while (eContainer != null) {
					for (EAttribute a : eContainer.eClass().getEAllAttributes()) {
						if (a.getName().equalsIgnoreCase("id")) {
							path = eContainer.eGet(a) + "." + path;
						}
					}
					eContainer = eContainer.eContainer();
				}
				label = String.format("%s.%s", eObject.eClass().getName(),
						(String) eObject.eGet(attribute));
				return label;
			}
		}

		String[] fragments = EcoreUtil.getURI(eObject).toString().split("\\.");
		String indexFragment = fragments[fragments.length - 1];

		if (indexFragment.matches("\\d+")) {
			label = String.format("%s.%s (%s)", eObject.eContainingFeature()
					.getName(), fragments[fragments.length - 1], eObject
					.eClass().getName());
		} else {
			label = eObject.eClass().getName();
		}

		
		return label;
	}

}
