/**
 */
package org.sidiff.graphpattern;

import org.eclipse.emf.common.util.EList;
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
 *   <li>{@link org.sidiff.graphpattern.EdgePattern#getTarget <em>Target</em>}</li>
 *   <li>{@link org.sidiff.graphpattern.EdgePattern#getSource <em>Source</em>}</li>
 *   <li>{@link org.sidiff.graphpattern.EdgePattern#getOpposite <em>Opposite</em>}</li>
 *   <li>{@link org.sidiff.graphpattern.EdgePattern#getType <em>Type</em>}</li>
 *   <li>{@link org.sidiff.graphpattern.EdgePattern#isCrossReference <em>Cross Reference</em>}</li>
 *   <li>{@link org.sidiff.graphpattern.EdgePattern#getAssociations <em>Associations</em>}</li>
 * </ul>
 *
 * @see org.sidiff.graphpattern.GraphpatternPackage#getEdgePattern()
 * @model
 * @generated
 */
public interface EdgePattern extends GraphPatternElement {
	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.sidiff.graphpattern.NodePattern#getIncomings <em>Incomings</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(NodePattern)
	 * @see org.sidiff.graphpattern.GraphpatternPackage#getEdgePattern_Target()
	 * @see org.sidiff.graphpattern.NodePattern#getIncomings
	 * @model opposite="incomings" required="true"
	 * @generated
	 */
	NodePattern getTarget();

	/**
	 * Sets the value of the '{@link org.sidiff.graphpattern.EdgePattern#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(NodePattern value);

	/**
	 * Returns the value of the '<em><b>Source</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.sidiff.graphpattern.NodePattern#getOutgoings <em>Outgoings</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' container reference.
	 * @see #setSource(NodePattern)
	 * @see org.sidiff.graphpattern.GraphpatternPackage#getEdgePattern_Source()
	 * @see org.sidiff.graphpattern.NodePattern#getOutgoings
	 * @model opposite="outgoings" required="true" transient="false"
	 * @generated
	 */
	NodePattern getSource();

	/**
	 * Sets the value of the '{@link org.sidiff.graphpattern.EdgePattern#getSource <em>Source</em>}' container reference.
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
	 * @see org.sidiff.graphpattern.GraphpatternPackage#getEdgePattern_Opposite()
	 * @model
	 * @generated
	 */
	EdgePattern getOpposite();

	/**
	 * Sets the value of the '{@link org.sidiff.graphpattern.EdgePattern#getOpposite <em>Opposite</em>}' reference.
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
	 * @see org.sidiff.graphpattern.GraphpatternPackage#getEdgePattern_Type()
	 * @model required="true"
	 * @generated
	 */
	EReference getType();

	/**
	 * Sets the value of the '{@link org.sidiff.graphpattern.EdgePattern#getType <em>Type</em>}' reference.
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
	 * @see org.sidiff.graphpattern.GraphpatternPackage#getEdgePattern_CrossReference()
	 * @model
	 * @generated
	 */
	boolean isCrossReference();

	/**
	 * Sets the value of the '{@link org.sidiff.graphpattern.EdgePattern#isCrossReference <em>Cross Reference</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cross Reference</em>' attribute.
	 * @see #isCrossReference()
	 * @generated
	 */
	void setCrossReference(boolean value);

	/**
	 * Returns the value of the '<em><b>Associations</b></em>' reference list.
	 * The list contents are of type {@link org.sidiff.graphpattern.Association}.
	 * It is bidirectional and its opposite is '{@link org.sidiff.graphpattern.Association#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Associations</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Associations</em>' reference list.
	 * @see org.sidiff.graphpattern.GraphpatternPackage#getEdgePattern_Associations()
	 * @see org.sidiff.graphpattern.Association#getTarget
	 * @model opposite="target"
	 * @generated
	 */
	EList<Association> getAssociations();

} // EdgePattern
