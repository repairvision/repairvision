/**
 */
package org.sidiff.revision.changes;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Change</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.sidiff.revision.changes.ChangesPackage#getChange()
 * @model abstract="true"
 * @generated
 */
public interface Change extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	ActionType getAction();

} // Change
