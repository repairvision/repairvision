/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.sidiff.difference.symmetric;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Attribute Value Change</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.difference.symmetric.AttributeValueChange#getObjA <em>Obj A</em>}</li>
 *   <li>{@link org.sidiff.difference.symmetric.AttributeValueChange#getObjB <em>Obj B</em>}</li>
 *   <li>{@link org.sidiff.difference.symmetric.AttributeValueChange#getType <em>Type</em>}</li>
 * </ul>
 *
 * @see org.sidiff.difference.symmetric.SymmetricPackage#getAttributeValueChange()
 * @model
 * @generated
 */
public interface AttributeValueChange extends Change {
	/**
	 * Returns the value of the '<em><b>Obj A</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Obj A</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Obj A</em>' reference.
	 * @see #setObjA(EObject)
	 * @see org.sidiff.difference.symmetric.SymmetricPackage#getAttributeValueChange_ObjA()
	 * @model
	 * @generated
	 */
	EObject getObjA();

	/**
	 * Sets the value of the '{@link org.sidiff.difference.symmetric.AttributeValueChange#getObjA <em>Obj A</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Obj A</em>' reference.
	 * @see #getObjA()
	 * @generated
	 */
	void setObjA(EObject value);

	/**
	 * Returns the value of the '<em><b>Obj B</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Obj B</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Obj B</em>' reference.
	 * @see #setObjB(EObject)
	 * @see org.sidiff.difference.symmetric.SymmetricPackage#getAttributeValueChange_ObjB()
	 * @model
	 * @generated
	 */
	EObject getObjB();

	/**
	 * Sets the value of the '{@link org.sidiff.difference.symmetric.AttributeValueChange#getObjB <em>Obj B</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Obj B</em>' reference.
	 * @see #getObjB()
	 * @generated
	 */
	void setObjB(EObject value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' reference.
	 * @see #setType(EAttribute)
	 * @see org.sidiff.difference.symmetric.SymmetricPackage#getAttributeValueChange_Type()
	 * @model
	 * @generated
	 */
	EAttribute getType();

	/**
	 * Sets the value of the '{@link org.sidiff.difference.symmetric.AttributeValueChange#getType <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(EAttribute value);

} // AttributeValueChange
