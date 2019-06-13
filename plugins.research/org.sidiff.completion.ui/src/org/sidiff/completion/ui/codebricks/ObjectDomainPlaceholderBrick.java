/**
 */
package org.sidiff.completion.ui.codebricks;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Object Domain Placeholder Brick</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.completion.ui.codebricks.ObjectDomainPlaceholderBrick#getDomain <em>Domain</em>}</li>
 * </ul>
 *
 * @see org.sidiff.completion.ui.codebricks.CodebricksPackage#getObjectDomainPlaceholderBrick()
 * @model
 * @generated
 */
public interface ObjectDomainPlaceholderBrick extends ObjectPlaceholderBrick {
	/**
	 * Returns the value of the '<em><b>Domain</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.EObject}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Domain</em>' reference list.
	 * @see org.sidiff.completion.ui.codebricks.CodebricksPackage#getObjectDomainPlaceholderBrick_Domain()
	 * @model
	 * @generated
	 */
	EList<EObject> getDomain();

} // ObjectDomainPlaceholderBrick
