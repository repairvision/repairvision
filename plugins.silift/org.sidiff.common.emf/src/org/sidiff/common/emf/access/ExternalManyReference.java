package org.sidiff.common.emf.access;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

/**
 * Extension of an external reference in case where the reference type is
 * multi-valued (upperBound > 1). In this case, we additionally have to store
 * the position where the externally referenced target object is located. <br/>
 * Note that "reference" here is on the EMF instance level, not on the
 * meta-model level.
 * 
 * @author kehrer
 */
public class ExternalManyReference extends ExternalReference {

	/**
	 * The list index where the referenced eObject is located.
	 */
	private int position;

	/**
	 * Constructor.
	 * 
	 * @param sourceObject
	 *            Traeger-Objekt der externen Referenz.
	 * @param eReference
	 *            Typ der externen Referenz.
	 * @param targetObject
	 *            Ziel der externen Referenz.
	 */
	public ExternalManyReference(EObject sourceObject, EReference eReference, EObject targetObject, int position) {
		super(sourceObject, eReference, targetObject);

		this.position = position;
	}

	/**
	 * Simple "getter" method.
	 * 
	 * @return The list index where the referenced eObject is located.
	 */
	public int getPosition() {
		return position;
	}

}
