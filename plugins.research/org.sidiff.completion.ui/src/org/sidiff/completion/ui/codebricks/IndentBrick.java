/**
 */
package org.sidiff.completion.ui.codebricks;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Indent Brick</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.completion.ui.codebricks.IndentBrick#getBricks <em>Bricks</em>}</li>
 * </ul>
 *
 * @see org.sidiff.completion.ui.codebricks.CodebricksPackage#getIndentBrick()
 * @model
 * @generated
 */
public interface IndentBrick extends Brick {
	/**
	 * Returns the value of the '<em><b>Bricks</b></em>' attribute.
	 * The default value is <code>"1"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bricks</em>' attribute.
	 * @see #setBricks(int)
	 * @see org.sidiff.completion.ui.codebricks.CodebricksPackage#getIndentBrick_Bricks()
	 * @model default="1"
	 * @generated
	 */
	int getBricks();

	/**
	 * Sets the value of the '{@link org.sidiff.completion.ui.codebricks.IndentBrick#getBricks <em>Bricks</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bricks</em>' attribute.
	 * @see #getBricks()
	 * @generated
	 */
	void setBricks(int value);

} // IndentBrick
