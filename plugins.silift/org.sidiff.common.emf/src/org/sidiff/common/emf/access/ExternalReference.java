package org.sidiff.common.emf.access;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;

/**
 * External reference. Note that "reference" here is on the EMF instance level,
 * not on the meta-model level.
 * 
 * @author kehrer
 */
public class ExternalReference {

	/**
	 * Traeger-Objekt der externen Referenz.
	 */
	private EObject sourceObject;

	/**
	 * Ziel der externen Referenz.
	 */
	private EObject targetObject;

	/**
	 * Typ der externen Referenz.
	 */
	private EReference eReference;

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
	public ExternalReference(EObject sourceObject, EReference eReference, EObject targetObject) {
		super();
		this.sourceObject = sourceObject;
		this.eReference = eReference;
		this.targetObject = targetObject;
	}

	/**
	 * Get the Resource of the external EClassifier
	 * 
	 * @return
	 */
	public Resource getExternalResource() {
		return targetObject.eResource();
	}

	/**
	 * Simple "getter" method.
	 * 
	 * @return Traeger-Objekt der externen Referenz.
	 */
	public EObject getSourceObject() {
		return sourceObject;
	}

	/**
	 * Simple "getter" method.
	 * 
	 * @return Ziel der externen Referenz.
	 */
	public EObject getTargetObject() {
		return targetObject;
	}

	/**
	 * Simple "getter" method.
	 * 
	 * @return Typ der externen Referenz.
	 */
	public EReference getEReference() {
		return eReference;
	}

}
