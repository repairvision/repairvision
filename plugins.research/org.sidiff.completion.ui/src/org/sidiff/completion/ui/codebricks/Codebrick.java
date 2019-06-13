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
 *   <li>{@link org.sidiff.completion.ui.codebricks.Codebrick#getAllBricks <em>All Bricks</em>}</li>
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bricks</em>' containment reference list.
	 * @see org.sidiff.completion.ui.codebricks.CodebricksPackage#getCodebrick_Bricks()
	 * @model containment="true"
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
	 * Returns the value of the '<em><b>All Bricks</b></em>' reference list.
	 * The list contents are of type {@link org.sidiff.completion.ui.codebricks.Brick}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>All Bricks</em>' reference list.
	 * @see org.sidiff.completion.ui.codebricks.CodebricksPackage#getCodebrick_AllBricks()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	EList<Brick> getAllBricks();

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
