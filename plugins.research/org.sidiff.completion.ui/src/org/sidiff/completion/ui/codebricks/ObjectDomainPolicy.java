/**
 */
package org.sidiff.completion.ui.codebricks;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;
import org.sidiff.completion.ui.codebricks.impl.CodebricksFactoryImpl;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Object Domain Policy</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.sidiff.completion.ui.codebricks.CodebricksPackage#getObjectDomainPolicy()
 * @model
 * @generated
 */
public interface ObjectDomainPolicy extends EObject {
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	EList<EObject> getDomain(ObjectPlaceholderBrick brick);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void assignObject(ObjectPlaceholderBrick brick, EObject element);

	/**
	 * @generated NOT
	 */
	public static ObjectDomainPolicy eINSTANCE = CodebricksFactoryImpl.eINSTANCE.createObjectDomainPolicy();

} // ObjectDomainPolicy
