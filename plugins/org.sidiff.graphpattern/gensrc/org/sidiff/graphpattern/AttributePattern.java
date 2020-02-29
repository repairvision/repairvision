/**
 */
package org.sidiff.graphpattern;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Attribute Pattern</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.graphpattern.AttributePattern#getValue <em>Value</em>}</li>
 *   <li>{@link org.sidiff.graphpattern.AttributePattern#getType <em>Type</em>}</li>
 *   <li>{@link org.sidiff.graphpattern.AttributePattern#getNode <em>Node</em>}</li>
 *   <li>{@link org.sidiff.graphpattern.AttributePattern#getConstant <em>Constant</em>}</li>
 *   <li>{@link org.sidiff.graphpattern.AttributePattern#getVariables <em>Variables</em>}</li>
 * </ul>
 *
 * @see org.sidiff.graphpattern.GraphpatternPackage#getAttributePattern()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='TheAttributeTypeAndTheContainingClassAreNotMetaModelConform TheNameOfTheAttributeVariableIsEqualToANameOfANode'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot TheAttributeTypeAndTheContainingClassAreNotMetaModelConform='((self.type &lt;&gt; null) and (self.node &lt;&gt; null) and (self.node.type &lt;&gt; null)) implies (self.node.type.eAllAttributes-&gt;includes(self.type))' TheNameOfTheAttributeVariableIsEqualToANameOfANode='not(self.isVariable() and self.graph.nodes-&gt;exists(n | (n.name &lt;&gt; null) and n.name = self.name))'"
 * @generated
 */
public interface AttributePattern extends GraphElement {
	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(String)
	 * @see org.sidiff.graphpattern.GraphpatternPackage#getAttributePattern_Value()
	 * @model
	 * @generated
	 */
	String getValue();

	/**
	 * Sets the value of the '{@link org.sidiff.graphpattern.AttributePattern#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(String value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' reference.
	 * @see #setType(EAttribute)
	 * @see org.sidiff.graphpattern.GraphpatternPackage#getAttributePattern_Type()
	 * @model required="true"
	 * @generated
	 */
	EAttribute getType();

	/**
	 * Sets the value of the '{@link org.sidiff.graphpattern.AttributePattern#getType <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(EAttribute value);

	/**
	 * Returns the value of the '<em><b>Node</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.sidiff.graphpattern.NodePattern#getAttributes <em>Attributes</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Node</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Node</em>' container reference.
	 * @see #setNode(NodePattern)
	 * @see org.sidiff.graphpattern.GraphpatternPackage#getAttributePattern_Node()
	 * @see org.sidiff.graphpattern.NodePattern#getAttributes
	 * @model opposite="attributes" transient="false"
	 * @generated
	 */
	NodePattern getNode();

	/**
	 * Sets the value of the '{@link org.sidiff.graphpattern.AttributePattern#getNode <em>Node</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Node</em>' container reference.
	 * @see #getNode()
	 * @generated
	 */
	void setNode(NodePattern value);

	/**
	 * Returns the value of the '<em><b>Constant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constant</em>' attribute.
	 * @see org.sidiff.graphpattern.GraphpatternPackage#getAttributePattern_Constant()
	 * @model transient="true" changeable="false" derived="true"
	 * @generated
	 */
	Object getConstant();

	/**
	 * Returns the value of the '<em><b>Variables</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variables</em>' attribute list.
	 * @see org.sidiff.graphpattern.GraphpatternPackage#getAttributePattern_Variables()
	 * @model transient="true" changeable="false" derived="true"
	 * @generated
	 */
	EList<String> getVariables();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 * @generated
	 */
	boolean isVariable();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 * @generated
	 */
	boolean isConstant();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 * @generated
	 */
	boolean isExpression();

} // AttributePattern
