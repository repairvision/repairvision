/**
 */
package org.sidiff.completion.ui.codebricks;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Codebrick View</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.completion.ui.codebricks.CodebrickView#getModel <em>Model</em>}</li>
 * </ul>
 *
 * @see org.sidiff.completion.ui.codebricks.CodebricksPackage#getCodebrickView()
 * @model
 * @generated
 */
public interface CodebrickView extends Codebrick {
	/**
	 * Returns the value of the '<em><b>Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Model</em>' reference.
	 * @see #setModel(EObject)
	 * @see org.sidiff.completion.ui.codebricks.CodebricksPackage#getCodebrickView_Model()
	 * @model
	 * @generated
	 */
	EObject getModel();

	/**
	 * Sets the value of the '{@link org.sidiff.completion.ui.codebricks.CodebrickView#getModel <em>Model</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Model</em>' reference.
	 * @see #getModel()
	 * @generated
	 */
	void setModel(EObject value);

} // CodebrickView
