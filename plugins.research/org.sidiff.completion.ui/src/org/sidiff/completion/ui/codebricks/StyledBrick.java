/**
 */
package org.sidiff.completion.ui.codebricks;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Styled Brick</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.completion.ui.codebricks.StyledBrick#isHighlight <em>Highlight</em>}</li>
 *   <li>{@link org.sidiff.completion.ui.codebricks.StyledBrick#getColor <em>Color</em>}</li>
 * </ul>
 *
 * @see org.sidiff.completion.ui.codebricks.CodebricksPackage#getStyledBrick()
 * @model abstract="true"
 * @generated
 */
public interface StyledBrick extends ViewableBrick {
	/**
	 * Returns the value of the '<em><b>Highlight</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Highlight</em>' attribute.
	 * @see #setHighlight(boolean)
	 * @see org.sidiff.completion.ui.codebricks.CodebricksPackage#getStyledBrick_Highlight()
	 * @model
	 * @generated
	 */
	boolean isHighlight();

	/**
	 * Sets the value of the '{@link org.sidiff.completion.ui.codebricks.StyledBrick#isHighlight <em>Highlight</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Highlight</em>' attribute.
	 * @see #isHighlight()
	 * @generated
	 */
	void setHighlight(boolean value);

	/**
	 * Returns the value of the '<em><b>Color</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Color</em>' attribute.
	 * @see #setColor(int)
	 * @see org.sidiff.completion.ui.codebricks.CodebricksPackage#getStyledBrick_Color()
	 * @model default="0"
	 * @generated
	 */
	int getColor();

	/**
	 * Sets the value of the '{@link org.sidiff.completion.ui.codebricks.StyledBrick#getColor <em>Color</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Color</em>' attribute.
	 * @see #getColor()
	 * @generated
	 */
	void setColor(int value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void setColor(int red, int green, int blue);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	int getColor(RGB rgb);

} // StyledBrick
