/**
 */
package org.sidiff.revision.difference;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Add Object</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.revision.difference.AddObject#getObj <em>Obj</em>}</li>
 * </ul>
 *
 * @see org.sidiff.revision.difference.DifferencePackage#getAddObject()
 * @model
 * @generated
 */
public interface AddObject extends Change {
	/**
	 * Returns the value of the '<em><b>Obj</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Obj</em>' reference.
	 * @see #setObj(EObject)
	 * @see org.sidiff.revision.difference.DifferencePackage#getAddObject_Obj()
	 * @model
	 * @generated
	 */
	EObject getObj();

	/**
	 * Sets the value of the '{@link org.sidiff.revision.difference.AddObject#getObj <em>Obj</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Obj</em>' reference.
	 * @see #getObj()
	 * @generated
	 */
	void setObj(EObject value);

} // AddObject
