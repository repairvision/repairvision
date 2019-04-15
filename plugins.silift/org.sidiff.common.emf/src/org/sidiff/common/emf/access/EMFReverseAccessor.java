package org.sidiff.common.emf.access;

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

/**
 * Interface for accessors that realize the reverse navigation
 * on EReferences.
 *
 */
public interface EMFReverseAccessor {
	
	/**
	 * Computes all Objects that points to the given Object with the given reference
	 * 
	 * @param target Objekt von dem der reverse-lookup ausgeht.
	 * @param reference Referenz(-typ), der auf das �bergebene Objekt zeigt.
	 * 
	 * @return Menge der Objekte, die mit der �bergebenen Referenz auf das �bergebene
	 *  zielobjekt zeigt.
	 */
	public Collection<EObject> getRefers(EObject target,EReference reference);
}
