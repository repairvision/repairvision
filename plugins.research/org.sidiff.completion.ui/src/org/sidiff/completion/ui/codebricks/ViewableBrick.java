/**
 */
package org.sidiff.completion.ui.codebricks;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Viewable Brick</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.completion.ui.codebricks.ViewableBrick#isEditable <em>Editable</em>}</li>
 *   <li>{@link org.sidiff.completion.ui.codebricks.ViewableBrick#isHighlight <em>Highlight</em>}</li>
 * </ul>
 *
 * @see org.sidiff.completion.ui.codebricks.CodebricksPackage#getViewableBrick()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface ViewableBrick extends Brick {
	/**
	 * Returns the value of the '<em><b>Editable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Editable</em>' attribute.
	 * @see #setEditable(boolean)
	 * @see org.sidiff.completion.ui.codebricks.CodebricksPackage#getViewableBrick_Editable()
	 * @model
	 * @generated
	 */
	boolean isEditable();

	/**
	 * Sets the value of the '{@link org.sidiff.completion.ui.codebricks.ViewableBrick#isEditable <em>Editable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Editable</em>' attribute.
	 * @see #isEditable()
	 * @generated
	 */
	void setEditable(boolean value);

	/**
	 * Returns the value of the '<em><b>Highlight</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Highlight</em>' attribute.
	 * @see #setHighlight(boolean)
	 * @see org.sidiff.completion.ui.codebricks.CodebricksPackage#getViewableBrick_Highlight()
	 * @model
	 * @generated
	 */
	boolean isHighlight();

	/**
	 * Sets the value of the '{@link org.sidiff.completion.ui.codebricks.ViewableBrick#isHighlight <em>Highlight</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Highlight</em>' attribute.
	 * @see #isHighlight()
	 * @generated
	 */
	void setHighlight(boolean value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	String getText();

} // ViewableBrick
