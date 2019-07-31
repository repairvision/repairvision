/**
 */
package org.sidiff.completion.ui.codebricks;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Reset Template Placeholder Brick</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.completion.ui.codebricks.ResetTemplatePlaceholderBrick#getPlaceholder <em>Placeholder</em>}</li>
 *   <li>{@link org.sidiff.completion.ui.codebricks.ResetTemplatePlaceholderBrick#getAttachedTo <em>Attached To</em>}</li>
 * </ul>
 *
 * @see org.sidiff.completion.ui.codebricks.CodebricksPackage#getResetTemplatePlaceholderBrick()
 * @model
 * @generated
 */
public interface ResetTemplatePlaceholderBrick extends StyledBrick {
	/**
	 * Returns the value of the '<em><b>Placeholder</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Placeholder</em>' reference.
	 * @see #setPlaceholder(TemplatePlaceholderBrick)
	 * @see org.sidiff.completion.ui.codebricks.CodebricksPackage#getResetTemplatePlaceholderBrick_Placeholder()
	 * @model required="true"
	 * @generated
	 */
	TemplatePlaceholderBrick getPlaceholder();

	/**
	 * Sets the value of the '{@link org.sidiff.completion.ui.codebricks.ResetTemplatePlaceholderBrick#getPlaceholder <em>Placeholder</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Placeholder</em>' reference.
	 * @see #getPlaceholder()
	 * @generated
	 */
	void setPlaceholder(TemplatePlaceholderBrick value);

	/**
	 * Returns the value of the '<em><b>Attached To</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attached To</em>' reference.
	 * @see #setAttachedTo(ViewableBrick)
	 * @see org.sidiff.completion.ui.codebricks.CodebricksPackage#getResetTemplatePlaceholderBrick_AttachedTo()
	 * @model required="true"
	 * @generated
	 */
	ViewableBrick getAttachedTo();

	/**
	 * Sets the value of the '{@link org.sidiff.completion.ui.codebricks.ResetTemplatePlaceholderBrick#getAttachedTo <em>Attached To</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Attached To</em>' reference.
	 * @see #getAttachedTo()
	 * @generated
	 */
	void setAttachedTo(ViewableBrick value);

} // ResetTemplatePlaceholderBrick
