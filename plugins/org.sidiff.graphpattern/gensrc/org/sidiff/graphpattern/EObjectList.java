/**
 */
package org.sidiff.graphpattern;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>EObject List</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.graphpattern.EObjectList#getContent <em>Content</em>}</li>
 *   <li>{@link org.sidiff.graphpattern.EObjectList#getLabel <em>Label</em>}</li>
 * </ul>
 *
 * @see org.sidiff.graphpattern.GraphpatternPackage#getEObjectList()
 * @model
 * @generated
 */
public interface EObjectList extends EObject {
	/**
	 * Returns the value of the '<em><b>Content</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.EObject}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Content</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Content</em>' reference list.
	 * @see org.sidiff.graphpattern.GraphpatternPackage#getEObjectList_Content()
	 * @model
	 * @generated
	 */
	EList<EObject> getContent();

	/**
	 * Returns the value of the '<em><b>Label</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Label</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Label</em>' attribute.
	 * @see #setLabel(String)
	 * @see org.sidiff.graphpattern.GraphpatternPackage#getEObjectList_Label()
	 * @model default=""
	 * @generated
	 */
	String getLabel();

	/**
	 * Sets the value of the '{@link org.sidiff.graphpattern.EObjectList#getLabel <em>Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Label</em>' attribute.
	 * @see #getLabel()
	 * @generated
	 */
	void setLabel(String value);

} // EObjectList
