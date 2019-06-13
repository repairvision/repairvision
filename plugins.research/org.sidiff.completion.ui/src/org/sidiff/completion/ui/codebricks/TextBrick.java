/**
 */
package org.sidiff.completion.ui.codebricks;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Text Brick</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.completion.ui.codebricks.TextBrick#getText <em>Text</em>}</li>
 *   <li>{@link org.sidiff.completion.ui.codebricks.TextBrick#isSelectable <em>Selectable</em>}</li>
 * </ul>
 *
 * @see org.sidiff.completion.ui.codebricks.CodebricksPackage#getTextBrick()
 * @model
 * @generated
 */
public interface TextBrick extends StyledBrick {
	/**
	 * Returns the value of the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Text</em>' attribute.
	 * @see #setText(String)
	 * @see org.sidiff.completion.ui.codebricks.CodebricksPackage#getTextBrick_Text()
	 * @model
	 * @generated
	 */
	String getText();

	/**
	 * Sets the value of the '{@link org.sidiff.completion.ui.codebricks.TextBrick#getText <em>Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Text</em>' attribute.
	 * @see #getText()
	 * @generated
	 */
	void setText(String value);

	/**
	 * Returns the value of the '<em><b>Selectable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Selectable</em>' attribute.
	 * @see #setSelectable(boolean)
	 * @see org.sidiff.completion.ui.codebricks.CodebricksPackage#getTextBrick_Selectable()
	 * @model
	 * @generated
	 */
	boolean isSelectable();

	/**
	 * Sets the value of the '{@link org.sidiff.completion.ui.codebricks.TextBrick#isSelectable <em>Selectable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Selectable</em>' attribute.
	 * @see #isSelectable()
	 * @generated
	 */
	void setSelectable(boolean value);

} // TextBrick
