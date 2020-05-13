/**
 */
package org.sidiff.revision.difference;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Remove Object</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.revision.difference.RemoveObject#getObj <em>Obj</em>}</li>
 * </ul>
 *
 * @see org.sidiff.revision.difference.DifferencePackage#getRemoveObject()
 * @model
 * @generated
 */
public interface RemoveObject extends Change {
	/**
	 * Returns the value of the '<em><b>Obj</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Obj</em>' reference.
	 * @see #setObj(EObject)
	 * @see org.sidiff.revision.difference.DifferencePackage#getRemoveObject_Obj()
	 * @model
	 * @generated
	 */
	EObject getObj();

	/**
	 * Sets the value of the '{@link org.sidiff.revision.difference.RemoveObject#getObj <em>Obj</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Obj</em>' reference.
	 * @see #getObj()
	 * @generated
	 */
	void setObj(EObject value);

} // RemoveObject
