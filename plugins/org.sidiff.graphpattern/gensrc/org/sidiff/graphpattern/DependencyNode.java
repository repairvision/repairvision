/**
 */
package org.sidiff.graphpattern;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Dependency Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.graphpattern.DependencyNode#getOutgoings <em>Outgoings</em>}</li>
 *   <li>{@link org.sidiff.graphpattern.DependencyNode#getIncomings <em>Incomings</em>}</li>
 *   <li>{@link org.sidiff.graphpattern.DependencyNode#getNodes <em>Nodes</em>}</li>
 * </ul>
 *
 * @see org.sidiff.graphpattern.GraphpatternPackage#getDependencyNode()
 * @model
 * @generated
 */
public interface DependencyNode extends EObject {
	/**
	 * Returns the value of the '<em><b>Outgoings</b></em>' reference list.
	 * The list contents are of type {@link org.sidiff.graphpattern.DependencyEdge}.
	 * It is bidirectional and its opposite is '{@link org.sidiff.graphpattern.DependencyEdge#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Outgoings</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Outgoings</em>' reference list.
	 * @see org.sidiff.graphpattern.GraphpatternPackage#getDependencyNode_Outgoings()
	 * @see org.sidiff.graphpattern.DependencyEdge#getSource
	 * @model opposite="source"
	 * @generated
	 */
	EList<DependencyEdge> getOutgoings();

	/**
	 * Returns the value of the '<em><b>Incomings</b></em>' reference list.
	 * The list contents are of type {@link org.sidiff.graphpattern.DependencyEdge}.
	 * It is bidirectional and its opposite is '{@link org.sidiff.graphpattern.DependencyEdge#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Incomings</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Incomings</em>' reference list.
	 * @see org.sidiff.graphpattern.GraphpatternPackage#getDependencyNode_Incomings()
	 * @see org.sidiff.graphpattern.DependencyEdge#getTarget
	 * @model opposite="target"
	 * @generated
	 */
	EList<DependencyEdge> getIncomings();

	/**
	 * Returns the value of the '<em><b>Nodes</b></em>' reference list.
	 * The list contents are of type {@link org.sidiff.graphpattern.NodePattern}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nodes</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nodes</em>' reference list.
	 * @see org.sidiff.graphpattern.GraphpatternPackage#getDependencyNode_Nodes()
	 * @model
	 * @generated
	 */
	EList<NodePattern> getNodes();

} // DependencyNode
