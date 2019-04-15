/**
 */
package org.sidiff.matching.model;

import org.eclipse.emf.common.util.EMap;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Extendable Object</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.matching.model.ExtendableObject#getExtensions <em>Extensions</em>}</li>
 * </ul>
 *
 * @see org.sidiff.matching.model.MatchingModelPackage#getExtendableObject()
 * @model abstract="true"
 * @generated
 */
public interface ExtendableObject extends EObject {
	/**
	 * Returns the value of the '<em><b>Extensions</b></em>' map.
	 * The key is of type {@link java.lang.String},
	 * and the value is of type {@link java.lang.String},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Extensions</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Extensions</em>' map.
	 * @see org.sidiff.matching.model.MatchingModelPackage#getExtendableObject_Extensions()
	 * @model mapType="org.sidiff.matching.model.EStringToEStringMap<org.eclipse.emf.ecore.EString, org.eclipse.emf.ecore.EString>" ordered="false"
	 * @generated
	 */
	EMap<String, String> getExtensions();

} // ExtendableObject
