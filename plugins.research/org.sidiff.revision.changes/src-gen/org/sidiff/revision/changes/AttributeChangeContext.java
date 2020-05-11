/**
 */
package org.sidiff.revision.changes;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Attribute Change Context</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.revision.changes.AttributeChangeContext#getAttributes <em>Attributes</em>}</li>
 * </ul>
 *
 * @see org.sidiff.revision.changes.ChangesPackage#getAttributeChangeContext()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface AttributeChangeContext extends EObject {
	/**
	 * Returns the value of the '<em><b>Attributes</b></em>' containment reference list.
	 * The list contents are of type {@link org.sidiff.revision.changes.AttributeChange}.
	 * It is bidirectional and its opposite is '{@link org.sidiff.revision.changes.AttributeChange#getContext <em>Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attributes</em>' containment reference list.
	 * @see org.sidiff.revision.changes.ChangesPackage#getAttributeChangeContext_Attributes()
	 * @see org.sidiff.revision.changes.AttributeChange#getContext
	 * @model opposite="context" containment="true"
	 * @generated
	 */
	EList<AttributeChange> getAttributes();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	EAttribute getType(AttributeChange attributeChange);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	EObject getNode(AttributeChange attributeChange);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	EClass getNodeType(AttributeChange attributeChange);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model ordered="false"
	 * @generated
	 */
	EList<EObject> getNodeDomain(AttributeChange attributeChange);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	EDataType getValueType(AttributeChange attributeChange);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model ordered="false"
	 * @generated
	 */
	EList<Object> getValueDomain(AttributeChange attributeChange);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	Object getValue(AttributeChange attributeChange);

} // AttributeChangeContext
