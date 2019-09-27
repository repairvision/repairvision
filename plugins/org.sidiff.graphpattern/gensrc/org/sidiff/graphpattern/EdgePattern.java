/**
 */
package org.sidiff.graphpattern;

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
 * </ul>
 *
 * @see org.sidiff.graphpattern.GraphpatternPackage#getEdgePattern()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='TheOppositeOfTheOppositeMayNotBeAReferenceDifferentFromThisOne TheOppositeMayNotBeItsOwnOpposite TheOppositeTypesAreNotMetaModelConform EdgeSourceAndTypeAreNotMetaModelConform EdgeTargetAndTypeAreNotMetaModelConform'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot TheOppositeOfTheOppositeMayNotBeAReferenceDifferentFromThisOne='(self.opposite &lt;&gt; null) implies (self.opposite.opposite = self)' TheOppositeMayNotBeItsOwnOpposite='self.opposite &lt;&gt; self' TheOppositeTypesAreNotMetaModelConform='((self.opposite &lt;&gt; null) and (self.type.eOpposite &lt;&gt; null)) implies (self.opposite.type = self.type.eOpposite)' EdgeSourceAndTypeAreNotMetaModelConform='((self.type &lt;&gt; null) and (self.source &lt;&gt; null) and (self.source.type &lt;&gt; null)) implies self.source.type.eAllReferences-&gt;includes(self.type)' EdgeTargetAndTypeAreNotMetaModelConform='((self.type &lt;&gt; null) and (self.target &lt;&gt; null) and (self.target.type &lt;&gt; null)) implies ((self.type.eType = self.target.type) or (self.target.type.eAllSuperTypes-&gt;includes(self.type.eType) or (self.type.eType.instanceTypeName = \'org.eclipse.emf.ecore.EObject\')))'"
 * @generated
 */
public interface EdgePattern extends GraphElement {
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

} // EdgePattern
