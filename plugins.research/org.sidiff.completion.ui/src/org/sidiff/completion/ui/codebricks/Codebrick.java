/**
 */
package org.sidiff.completion.ui.codebricks;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Codebrick</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.completion.ui.codebricks.Codebrick#getBricks <em>Bricks</em>}</li>
 *   <li>{@link org.sidiff.completion.ui.codebricks.Codebrick#getCodebricks <em>Codebricks</em>}</li>
 * </ul>
 *
 * @see org.sidiff.completion.ui.codebricks.CodebricksPackage#getCodebrick()
 * @model
 * @generated
 */
public interface Codebrick extends EObject {
	/**
	 * Returns the value of the '<em><b>Bricks</b></em>' containment reference list.
	 * The list contents are of type {@link org.sidiff.completion.ui.codebricks.Brick}.
	 * It is bidirectional and its opposite is '{@link org.sidiff.completion.ui.codebricks.Brick#getCodebrick <em>Codebrick</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bricks</em>' containment reference list.
	 * @see org.sidiff.completion.ui.codebricks.CodebricksPackage#getCodebrick_Bricks()
	 * @see org.sidiff.completion.ui.codebricks.Brick#getCodebrick
	 * @model opposite="codebrick" containment="true"
	 * @generated
	 */
	EList<Brick> getBricks();

	/**
	 * Returns the value of the '<em><b>Codebricks</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Codebricks</em>' reference.
	 * @see org.sidiff.completion.ui.codebricks.CodebricksPackage#getCodebrick_Codebricks()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	Codebricks getCodebricks();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	int calculateRows();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	int caluclateColumns();

} // Codebrick
