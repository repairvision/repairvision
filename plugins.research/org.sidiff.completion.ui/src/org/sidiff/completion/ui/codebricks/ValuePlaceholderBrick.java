/**
 */
package org.sidiff.completion.ui.codebricks;

import org.eclipse.emf.ecore.EDataType;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Value Placeholder Brick</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.completion.ui.codebricks.ValuePlaceholderBrick#getType <em>Type</em>}</li>
 *   <li>{@link org.sidiff.completion.ui.codebricks.ValuePlaceholderBrick#getDomain <em>Domain</em>}</li>
 *   <li>{@link org.sidiff.completion.ui.codebricks.ValuePlaceholderBrick#getInstanceValue <em>Instance Value</em>}</li>
 *   <li>{@link org.sidiff.completion.ui.codebricks.ValuePlaceholderBrick#getLiteralValue <em>Literal Value</em>}</li>
 * </ul>
 *
 * @see org.sidiff.completion.ui.codebricks.CodebricksPackage#getValuePlaceholderBrick()
 * @model
 * @generated
 */
public interface ValuePlaceholderBrick extends PlaceholderBrick {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' reference.
	 * @see #setType(EDataType)
	 * @see org.sidiff.completion.ui.codebricks.CodebricksPackage#getValuePlaceholderBrick_Type()
	 * @model
	 * @generated
	 */
	EDataType getType();

	/**
	 * Sets the value of the '{@link org.sidiff.completion.ui.codebricks.ValuePlaceholderBrick#getType <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(EDataType value);

	/**
	 * Returns the value of the '<em><b>Domain</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Domain</em>' reference.
	 * @see #setDomain(ValueDomainPolicy)
	 * @see org.sidiff.completion.ui.codebricks.CodebricksPackage#getValuePlaceholderBrick_Domain()
	 * @model
	 * @generated
	 */
	ValueDomainPolicy getDomain();

	/**
	 * Sets the value of the '{@link org.sidiff.completion.ui.codebricks.ValuePlaceholderBrick#getDomain <em>Domain</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Domain</em>' reference.
	 * @see #getDomain()
	 * @generated
	 */
	void setDomain(ValueDomainPolicy value);

	/**
	 * Returns the value of the '<em><b>Instance Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Instance Value</em>' attribute.
	 * @see #setInstanceValue(Object)
	 * @see org.sidiff.completion.ui.codebricks.CodebricksPackage#getValuePlaceholderBrick_InstanceValue()
	 * @model
	 * @generated
	 */
	Object getInstanceValue();

	/**
	 * Sets the value of the '{@link org.sidiff.completion.ui.codebricks.ValuePlaceholderBrick#getInstanceValue <em>Instance Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Instance Value</em>' attribute.
	 * @see #getInstanceValue()
	 * @generated
	 */
	void setInstanceValue(Object value);

	/**
	 * Returns the value of the '<em><b>Literal Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Literal Value</em>' attribute.
	 * @see #setLiteralValue(String)
	 * @see org.sidiff.completion.ui.codebricks.CodebricksPackage#getValuePlaceholderBrick_LiteralValue()
	 * @model
	 * @generated
	 */
	String getLiteralValue();

	/**
	 * Sets the value of the '{@link org.sidiff.completion.ui.codebricks.ValuePlaceholderBrick#getLiteralValue <em>Literal Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Literal Value</em>' attribute.
	 * @see #getLiteralValue()
	 * @generated
	 */
	void setLiteralValue(String value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void setByLiteralValue(String literalValue);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void setByInstanceValue(Object instanceValue);

} // ValuePlaceholderBrick
