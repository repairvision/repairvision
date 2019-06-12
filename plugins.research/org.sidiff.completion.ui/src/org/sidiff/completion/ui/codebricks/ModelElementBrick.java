/**
 */
package org.sidiff.completion.ui.codebricks;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model Element Brick</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.completion.ui.codebricks.ModelElementBrick#getElement <em>Element</em>}</li>
 * </ul>
 *
 * @see org.sidiff.completion.ui.codebricks.CodebricksPackage#getModelElementBrick()
 * @model
 * @generated
 */
public interface ModelElementBrick extends ViewableBrick {
	/**
	 * Returns the value of the '<em><b>Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Element</em>' reference.
	 * @see #setElement(EObject)
	 * @see org.sidiff.completion.ui.codebricks.CodebricksPackage#getModelElementBrick_Element()
	 * @model
	 * @generated
	 */
	EObject getElement();

	/**
	 * Sets the value of the '{@link org.sidiff.completion.ui.codebricks.ModelElementBrick#getElement <em>Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Element</em>' reference.
	 * @see #getElement()
	 * @generated
	 */
	void setElement(EObject value);

} // ModelElementBrick
