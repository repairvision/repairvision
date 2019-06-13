/**
 */
package org.sidiff.completion.ui.codebricks;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Composed Template Placeholder Brick</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.completion.ui.codebricks.ComposedTemplatePlaceholderBrick#getContainerBrick <em>Container Brick</em>}</li>
 * </ul>
 *
 * @see org.sidiff.completion.ui.codebricks.CodebricksPackage#getComposedTemplatePlaceholderBrick()
 * @model
 * @generated
 */
public interface ComposedTemplatePlaceholderBrick extends TemplatePlaceholderBrick {
	/**
	 * Returns the value of the '<em><b>Container Brick</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Container Brick</em>' reference.
	 * @see #setContainerBrick(ComposedBrick)
	 * @see org.sidiff.completion.ui.codebricks.CodebricksPackage#getComposedTemplatePlaceholderBrick_ContainerBrick()
	 * @model required="true"
	 * @generated
	 */
	ComposedBrick getContainerBrick();

	/**
	 * Sets the value of the '{@link org.sidiff.completion.ui.codebricks.ComposedTemplatePlaceholderBrick#getContainerBrick <em>Container Brick</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Container Brick</em>' reference.
	 * @see #getContainerBrick()
	 * @generated
	 */
	void setContainerBrick(ComposedBrick value);

} // ComposedTemplatePlaceholderBrick
