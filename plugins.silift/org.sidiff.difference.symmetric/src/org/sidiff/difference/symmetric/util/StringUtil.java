package org.sidiff.difference.symmetric.util;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;

public class StringUtil {

	public static String eTypeToString(EObject obj) {
		
		if (obj != null) {
			return obj.eClass().getName();
		}
		
		return "null";
	}
	
	public static String eReferenceToString(EReference ref) {
		
		if (ref != null) {
			return ref.getName();
		}
		
		return "null";
	}
	
	public static String eClassToString(EClass c) {
		
		if (c != null) {
			return c.getName();
		}
		
		return "null";
	}
	
	public static String eAttributeToString(EAttribute attr) {
		
		if (attr != null) {
			return attr.getName();
		}
		
		return "null";
	}
	
	public static String eObjectToString(EObject obj) {
		
		if (obj != null) {
			EStructuralFeature nameFeature = obj.eClass().getEStructuralFeature("name");
			
			if (nameFeature != null) {
				Object name = obj.eGet(nameFeature);
				
				if (name instanceof String) {
					return (String) name;
				}
			}
			
			return obj.toString();
		}
		
		return "null";
	}
}
