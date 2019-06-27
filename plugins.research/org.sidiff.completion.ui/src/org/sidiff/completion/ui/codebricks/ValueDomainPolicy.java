/**
 */
package org.sidiff.completion.ui.codebricks;

import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.sidiff.completion.ui.codebricks.impl.CodebricksFactoryImpl;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Value Domain Policy</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.sidiff.completion.ui.codebricks.CodebricksPackage#getValueDomainPolicy()
 * @model
 * @generated
 */
public interface ValueDomainPolicy extends EObject {
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	boolean isValid(ValuePlaceholderBrick brick, String literalValue, EDataType eDataType);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	Object createFromString(ValuePlaceholderBrick brick, String literalValue, EDataType eDataType);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	Object convertToString(ValuePlaceholderBrick brick, Object instanceValue, EDataType eDataType);

	/**
	 * @generated NOT
	 */
	public static final String NULL = "null";
	
	/**
	 * @generated NOT
	 */
	public static ValueDomainPolicy eINSTANCE = CodebricksFactoryImpl.eINSTANCE.createValueDomainPolicy();

} // ValueDomainPolicy
