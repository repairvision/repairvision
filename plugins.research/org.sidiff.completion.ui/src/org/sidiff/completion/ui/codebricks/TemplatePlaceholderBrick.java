/**
 */
package org.sidiff.completion.ui.codebricks;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Template Placeholder Brick</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.completion.ui.codebricks.TemplatePlaceholderBrick#getChoices <em>Choices</em>}</li>
 *   <li>{@link org.sidiff.completion.ui.codebricks.TemplatePlaceholderBrick#getChoice <em>Choice</em>}</li>
 *   <li>{@link org.sidiff.completion.ui.codebricks.TemplatePlaceholderBrick#getRemainingChoices <em>Remaining Choices</em>}</li>
 *   <li>{@link org.sidiff.completion.ui.codebricks.TemplatePlaceholderBrick#isComposed <em>Composed</em>}</li>
 *   <li>{@link org.sidiff.completion.ui.codebricks.TemplatePlaceholderBrick#getAlternativeChoices <em>Alternative Choices</em>}</li>
 * </ul>
 *
 * @see org.sidiff.completion.ui.codebricks.CodebricksPackage#getTemplatePlaceholderBrick()
 * @model
 * @generated
 */
public interface TemplatePlaceholderBrick extends PlaceholderBrick {
	/**
	 * Returns the value of the '<em><b>Choices</b></em>' reference list.
	 * The list contents are of type {@link org.sidiff.completion.ui.codebricks.ViewableBrick}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Choices</em>' reference list.
	 * @see org.sidiff.completion.ui.codebricks.CodebricksPackage#getTemplatePlaceholderBrick_Choices()
	 * @model
	 * @generated
	 */
	EList<ViewableBrick> getChoices();

	/**
	 * Returns the value of the '<em><b>Choice</b></em>' reference list.
	 * The list contents are of type {@link org.sidiff.completion.ui.codebricks.ViewableBrick}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Choice</em>' reference list.
	 * @see org.sidiff.completion.ui.codebricks.CodebricksPackage#getTemplatePlaceholderBrick_Choice()
	 * @model
	 * @generated
	 */
	EList<ViewableBrick> getChoice();

	/**
	 * Returns the value of the '<em><b>Remaining Choices</b></em>' reference list.
	 * The list contents are of type {@link org.sidiff.completion.ui.codebricks.ViewableBrick}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Remaining Choices</em>' reference list.
	 * @see org.sidiff.completion.ui.codebricks.CodebricksPackage#getTemplatePlaceholderBrick_RemainingChoices()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	EList<ViewableBrick> getRemainingChoices();

	/**
	 * Returns the value of the '<em><b>Alternative Choices</b></em>' reference list.
	 * The list contents are of type {@link org.sidiff.completion.ui.codebricks.ViewableBrick}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Alternative Choices</em>' reference list.
	 * @see org.sidiff.completion.ui.codebricks.CodebricksPackage#getTemplatePlaceholderBrick_AlternativeChoices()
	 * @model transient="true" volatile="true" derived="true"
	 * @generated
	 */
	EList<ViewableBrick> getAlternativeChoices();

	/**
	 * Returns the value of the '<em><b>Composed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Composed</em>' attribute.
	 * @see org.sidiff.completion.ui.codebricks.CodebricksPackage#getTemplatePlaceholderBrick_Composed()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	boolean isComposed();

} // TemplatePlaceholderBrick
