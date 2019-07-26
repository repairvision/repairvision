/**
 */
package org.sidiff.completion.ui.codebricks;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Collapsible Composed Brick</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.completion.ui.codebricks.CollapsibleComposedBrick#getCollapsible <em>Collapsible</em>}</li>
 * </ul>
 *
 * @see org.sidiff.completion.ui.codebricks.CodebricksPackage#getCollapsibleComposedBrick()
 * @model
 * @generated
 */
public interface CollapsibleComposedBrick extends ComposedBrick {
	/**
	 * Returns the value of the '<em><b>Collapsible</b></em>' reference list.
	 * The list contents are of type {@link org.sidiff.completion.ui.codebricks.ViewableBrick}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Collapsible</em>' reference list.
	 * @see org.sidiff.completion.ui.codebricks.CodebricksPackage#getCollapsibleComposedBrick_Collapsible()
	 * @model
	 * @generated
	 */
	EList<ViewableBrick> getCollapsible();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	String getCollapsedText();

} // CollapsibleComposedBrick
