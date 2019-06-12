/**
 */
package org.sidiff.completion.ui.codebricks;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Brick</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.completion.ui.codebricks.Brick#getCodebrick <em>Codebrick</em>}</li>
 * </ul>
 *
 * @see org.sidiff.completion.ui.codebricks.CodebricksPackage#getBrick()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface Brick extends EObject {
	/**
	 * Returns the value of the '<em><b>Codebrick</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.sidiff.completion.ui.codebricks.Codebrick#getBricks <em>Bricks</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Codebrick</em>' container reference.
	 * @see #setCodebrick(Codebrick)
	 * @see org.sidiff.completion.ui.codebricks.CodebricksPackage#getBrick_Codebrick()
	 * @see org.sidiff.completion.ui.codebricks.Codebrick#getBricks
	 * @model opposite="bricks" transient="false"
	 * @generated
	 */
	Codebrick getCodebrick();

	/**
	 * Sets the value of the '{@link org.sidiff.completion.ui.codebricks.Brick#getCodebrick <em>Codebrick</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Codebrick</em>' container reference.
	 * @see #getCodebrick()
	 * @generated
	 */
	void setCodebrick(Codebrick value);

} // Brick
