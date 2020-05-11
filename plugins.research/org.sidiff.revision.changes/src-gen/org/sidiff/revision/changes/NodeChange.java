/**
 */
package org.sidiff.revision.changes;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Node Change</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.revision.changes.NodeChange#getContext <em>Context</em>}</li>
 * </ul>
 *
 * @see org.sidiff.revision.changes.ChangesPackage#getNodeChange()
 * @model abstract="true"
 * @generated
 */
public interface NodeChange extends Change {
	/**
	 * Returns the value of the '<em><b>Context</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.sidiff.revision.changes.NodeChangeContext#getNodes <em>Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Context</em>' container reference.
	 * @see #setContext(NodeChangeContext)
	 * @see org.sidiff.revision.changes.ChangesPackage#getNodeChange_Context()
	 * @see org.sidiff.revision.changes.NodeChangeContext#getNodes
	 * @model opposite="nodes" required="true" transient="false"
	 * @generated
	 */
	NodeChangeContext getContext();

	/**
	 * Sets the value of the '{@link org.sidiff.revision.changes.NodeChange#getContext <em>Context</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Context</em>' container reference.
	 * @see #getContext()
	 * @generated
	 */
	void setContext(NodeChangeContext value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	EClass getType();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	EList<EObject> getNodeDomains();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	EObject getNode();

} // NodeChange
