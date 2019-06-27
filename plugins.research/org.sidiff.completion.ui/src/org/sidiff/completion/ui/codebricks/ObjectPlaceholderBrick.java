/**
 */
package org.sidiff.completion.ui.codebricks;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Object Placeholder Brick</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.completion.ui.codebricks.ObjectPlaceholderBrick#getElement <em>Element</em>}</li>
 *   <li>{@link org.sidiff.completion.ui.codebricks.ObjectPlaceholderBrick#getType <em>Type</em>}</li>
 *   <li>{@link org.sidiff.completion.ui.codebricks.ObjectPlaceholderBrick#getDomain <em>Domain</em>}</li>
 * </ul>
 *
 * @see org.sidiff.completion.ui.codebricks.CodebricksPackage#getObjectPlaceholderBrick()
 * @model
 * @generated
 */
public interface ObjectPlaceholderBrick extends PlaceholderBrick {
	/**
	 * Returns the value of the '<em><b>Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Element</em>' reference.
	 * @see #setElement(EObject)
	 * @see org.sidiff.completion.ui.codebricks.CodebricksPackage#getObjectPlaceholderBrick_Element()
	 * @model
	 * @generated
	 */
	EObject getElement();

	/**
	 * Sets the value of the '{@link org.sidiff.completion.ui.codebricks.ObjectPlaceholderBrick#getElement <em>Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Element</em>' reference.
	 * @see #getElement()
	 * @generated
	 */
	void setElement(EObject value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' reference.
	 * @see #setType(EClass)
	 * @see org.sidiff.completion.ui.codebricks.CodebricksPackage#getObjectPlaceholderBrick_Type()
	 * @model
	 * @generated
	 */
	EClass getType();

	/**
	 * Sets the value of the '{@link org.sidiff.completion.ui.codebricks.ObjectPlaceholderBrick#getType <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(EClass value);

	/**
	 * Returns the value of the '<em><b>Domain</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Domain</em>' reference.
	 * @see #setDomain(ObjectDomainPolicy)
	 * @see org.sidiff.completion.ui.codebricks.CodebricksPackage#getObjectPlaceholderBrick_Domain()
	 * @model
	 * @generated
	 */
	ObjectDomainPolicy getDomain();

	/**
	 * Sets the value of the '{@link org.sidiff.completion.ui.codebricks.ObjectPlaceholderBrick#getDomain <em>Domain</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Domain</em>' reference.
	 * @see #getDomain()
	 * @generated
	 */
	void setDomain(ObjectDomainPolicy value);

} // ObjectPlaceholderBrick
