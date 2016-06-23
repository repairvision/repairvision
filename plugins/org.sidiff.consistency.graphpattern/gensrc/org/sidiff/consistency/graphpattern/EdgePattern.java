/**
 */
package org.sidiff.consistency.graphpattern;

import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Edge Pattern</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.consistency.graphpattern.EdgePattern#getTarget <em>Target</em>}</li>
 *   <li>{@link org.sidiff.consistency.graphpattern.EdgePattern#getSource <em>Source</em>}</li>
 *   <li>{@link org.sidiff.consistency.graphpattern.EdgePattern#getOpposite <em>Opposite</em>}</li>
 *   <li>{@link org.sidiff.consistency.graphpattern.EdgePattern#getType <em>Type</em>}</li>
 *   <li>{@link org.sidiff.consistency.graphpattern.EdgePattern#isCrossReference <em>Cross Reference</em>}</li>
 * </ul>
 *
 * @see org.sidiff.consistency.graphpattern.GraphpatternPackage#getEdgePattern()
 * @model
 * @generated
 */
public interface EdgePattern extends GraphPredicate {
	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.sidiff.consistency.graphpattern.NodePattern#getIncomings <em>Incomings</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(NodePattern)
	 * @see org.sidiff.consistency.graphpattern.GraphpatternPackage#getEdgePattern_Target()
	 * @see org.sidiff.consistency.graphpattern.NodePattern#getIncomings
	 * @model opposite="incomings" required="true"
	 * @generated
	 */
	NodePattern getTarget();

	/**
	 * Sets the value of the '{@link org.sidiff.consistency.graphpattern.EdgePattern#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(NodePattern value);

	/**
	 * Returns the value of the '<em><b>Source</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.sidiff.consistency.graphpattern.NodePattern#getOutgoings <em>Outgoings</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' container reference.
	 * @see #setSource(NodePattern)
	 * @see org.sidiff.consistency.graphpattern.GraphpatternPackage#getEdgePattern_Source()
	 * @see org.sidiff.consistency.graphpattern.NodePattern#getOutgoings
	 * @model opposite="outgoings" required="true" transient="false"
	 * @generated
	 */
	NodePattern getSource();

	/**
	 * Sets the value of the '{@link org.sidiff.consistency.graphpattern.EdgePattern#getSource <em>Source</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' container reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(NodePattern value);

	/**
	 * Returns the value of the '<em><b>Opposite</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Opposite</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Opposite</em>' reference.
	 * @see #setOpposite(EdgePattern)
	 * @see org.sidiff.consistency.graphpattern.GraphpatternPackage#getEdgePattern_Opposite()
	 * @model
	 * @generated
	 */
	EdgePattern getOpposite();

	/**
	 * Sets the value of the '{@link org.sidiff.consistency.graphpattern.EdgePattern#getOpposite <em>Opposite</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Opposite</em>' reference.
	 * @see #getOpposite()
	 * @generated
	 */
	void setOpposite(EdgePattern value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' reference.
	 * @see #setType(EReference)
	 * @see org.sidiff.consistency.graphpattern.GraphpatternPackage#getEdgePattern_Type()
	 * @model required="true"
	 * @generated
	 */
	EReference getType();

	/**
	 * Sets the value of the '{@link org.sidiff.consistency.graphpattern.EdgePattern#getType <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(EReference value);

	/**
	 * Returns the value of the '<em><b>Cross Reference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cross Reference</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cross Reference</em>' attribute.
	 * @see #setCrossReference(boolean)
	 * @see org.sidiff.consistency.graphpattern.GraphpatternPackage#getEdgePattern_CrossReference()
	 * @model
	 * @generated
	 */
	boolean isCrossReference();

	/**
	 * Sets the value of the '{@link org.sidiff.consistency.graphpattern.EdgePattern#isCrossReference <em>Cross Reference</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cross Reference</em>' attribute.
	 * @see #isCrossReference()
	 * @generated
	 */
	void setCrossReference(boolean value);

} // EdgePattern
