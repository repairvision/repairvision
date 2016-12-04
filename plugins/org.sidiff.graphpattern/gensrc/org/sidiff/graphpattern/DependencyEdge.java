/**
 */
package org.sidiff.graphpattern;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Dependency Edge</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.graphpattern.DependencyEdge#getSource <em>Source</em>}</li>
 *   <li>{@link org.sidiff.graphpattern.DependencyEdge#getTarget <em>Target</em>}</li>
 * </ul>
 *
 * @see org.sidiff.graphpattern.GraphpatternPackage#getDependencyEdge()
 * @model
 * @generated
 */
public interface DependencyEdge extends EObject {
	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.sidiff.graphpattern.DependencyNode#getOutgoings <em>Outgoings</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(DependencyNode)
	 * @see org.sidiff.graphpattern.GraphpatternPackage#getDependencyEdge_Source()
	 * @see org.sidiff.graphpattern.DependencyNode#getOutgoings
	 * @model opposite="outgoings"
	 * @generated
	 */
	DependencyNode getSource();

	/**
	 * Sets the value of the '{@link org.sidiff.graphpattern.DependencyEdge#getSource <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(DependencyNode value);

	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.sidiff.graphpattern.DependencyNode#getIncomings <em>Incomings</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(DependencyNode)
	 * @see org.sidiff.graphpattern.GraphpatternPackage#getDependencyEdge_Target()
	 * @see org.sidiff.graphpattern.DependencyNode#getIncomings
	 * @model opposite="incomings"
	 * @generated
	 */
	DependencyNode getTarget();

	/**
	 * Sets the value of the '{@link org.sidiff.graphpattern.DependencyEdge#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(DependencyNode value);

} // DependencyEdge
