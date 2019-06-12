/**
 */
package org.sidiff.completion.ui.codebricks;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Codebricks</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.completion.ui.codebricks.Codebricks#getTemplate <em>Template</em>}</li>
 *   <li>{@link org.sidiff.completion.ui.codebricks.Codebricks#getAlternatives <em>Alternatives</em>}</li>
 * </ul>
 *
 * @see org.sidiff.completion.ui.codebricks.CodebricksPackage#getCodebricks()
 * @model
 * @generated
 */
public interface Codebricks extends EObject {
	/**
	 * Returns the value of the '<em><b>Alternatives</b></em>' containment reference list.
	 * The list contents are of type {@link org.sidiff.completion.ui.codebricks.Codebrick}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Alternatives</em>' containment reference list.
	 * @see org.sidiff.completion.ui.codebricks.CodebricksPackage#getCodebricks_Alternatives()
	 * @model containment="true"
	 * @generated
	 */
	EList<Codebrick> getAlternatives();

	/**
	 * Returns the value of the '<em><b>Template</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Template</em>' containment reference.
	 * @see #setTemplate(Codebrick)
	 * @see org.sidiff.completion.ui.codebricks.CodebricksPackage#getCodebricks_Template()
	 * @model containment="true"
	 * @generated
	 */
	Codebrick getTemplate();

	/**
	 * Sets the value of the '{@link org.sidiff.completion.ui.codebricks.Codebricks#getTemplate <em>Template</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Template</em>' containment reference.
	 * @see #getTemplate()
	 * @generated
	 */
	void setTemplate(Codebrick value);

} // Codebricks
