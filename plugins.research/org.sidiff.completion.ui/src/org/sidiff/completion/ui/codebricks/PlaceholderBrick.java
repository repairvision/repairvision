/**
 */
package org.sidiff.completion.ui.codebricks;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Placeholder Brick</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.completion.ui.codebricks.PlaceholderBrick#getChoices <em>Choices</em>}</li>
 *   <li>{@link org.sidiff.completion.ui.codebricks.PlaceholderBrick#isMandatory <em>Mandatory</em>}</li>
 *   <li>{@link org.sidiff.completion.ui.codebricks.PlaceholderBrick#getChoice <em>Choice</em>}</li>
 *   <li>{@link org.sidiff.completion.ui.codebricks.PlaceholderBrick#getRemainingChoices <em>Remaining Choices</em>}</li>
 * </ul>
 *
 * @see org.sidiff.completion.ui.codebricks.CodebricksPackage#getPlaceholderBrick()
 * @model
 * @generated
 */
public interface PlaceholderBrick extends ViewableBrick {
	/**
	 * Returns the value of the '<em><b>Choices</b></em>' reference list.
	 * The list contents are of type {@link org.sidiff.completion.ui.codebricks.ViewableBrick}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Choices</em>' reference list.
	 * @see org.sidiff.completion.ui.codebricks.CodebricksPackage#getPlaceholderBrick_Choices()
	 * @model
	 * @generated
	 */
	EList<ViewableBrick> getChoices();

	/**
	 * Returns the value of the '<em><b>Mandatory</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mandatory</em>' attribute.
	 * @see #setMandatory(boolean)
	 * @see org.sidiff.completion.ui.codebricks.CodebricksPackage#getPlaceholderBrick_Mandatory()
	 * @model
	 * @generated
	 */
	boolean isMandatory();

	/**
	 * Sets the value of the '{@link org.sidiff.completion.ui.codebricks.PlaceholderBrick#isMandatory <em>Mandatory</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mandatory</em>' attribute.
	 * @see #isMandatory()
	 * @generated
	 */
	void setMandatory(boolean value);

	/**
	 * Returns the value of the '<em><b>Choice</b></em>' reference list.
	 * The list contents are of type {@link org.sidiff.completion.ui.codebricks.ViewableBrick}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Choice</em>' reference list.
	 * @see org.sidiff.completion.ui.codebricks.CodebricksPackage#getPlaceholderBrick_Choice()
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
	 * @see org.sidiff.completion.ui.codebricks.CodebricksPackage#getPlaceholderBrick_RemainingChoices()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	EList<ViewableBrick> getRemainingChoices();

} // PlaceholderBrick
