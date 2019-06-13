/**
 */
package org.sidiff.completion.ui.codebricks;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Composed Brick</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.completion.ui.codebricks.ComposedBrick#getBricks <em>Bricks</em>}</li>
 * </ul>
 *
 * @see org.sidiff.completion.ui.codebricks.CodebricksPackage#getComposedBrick()
 * @model
 * @generated
 */
public interface ComposedBrick extends ViewableBrick {
	/**
	 * Returns the value of the '<em><b>Bricks</b></em>' containment reference list.
	 * The list contents are of type {@link org.sidiff.completion.ui.codebricks.ViewableBrick}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bricks</em>' containment reference list.
	 * @see org.sidiff.completion.ui.codebricks.CodebricksPackage#getComposedBrick_Bricks()
	 * @model containment="true"
	 * @generated
	 */
	EList<ViewableBrick> getBricks();

} // ComposedBrick
