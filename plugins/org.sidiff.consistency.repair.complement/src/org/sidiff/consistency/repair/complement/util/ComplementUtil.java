package org.sidiff.consistency.repair.complement.util;

import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil.Copier;

public class ComplementUtil {

	/**
	 * Creates a deep copy (i.e. full tree content) of the given object.
	 * 
	 * @param original
	 *            The root object which will be copied.
	 * @return The copy trace: Original -> Copy
	 */
	public static Map<EObject, EObject> deepCopy(EObject original) {
		
		// Copier = Map: Original -> Copy
		Copier copier = new Copier();
		
		// Root:
		copier.copy(original);
		
		// Content:
		original.eAllContents().forEachRemaining(content -> copier.copy(content));
	    
		// References:
		copier.copyReferences();
	    
	    return copier;
		
	}
}
