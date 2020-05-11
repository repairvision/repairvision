/**
 */
package org.sidiff.revision.changes;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Node Change Context</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.revision.changes.NodeChangeContext#getNodes <em>Nodes</em>}</li>
 * </ul>
 *
 * @see org.sidiff.revision.changes.ChangesPackage#getNodeChangeContext()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface NodeChangeContext extends EObject {
	/**
	 * Returns the value of the '<em><b>Nodes</b></em>' containment reference list.
	 * The list contents are of type {@link org.sidiff.revision.changes.NodeChange}.
	 * It is bidirectional and its opposite is '{@link org.sidiff.revision.changes.NodeChange#getContext <em>Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nodes</em>' containment reference list.
	 * @see org.sidiff.revision.changes.ChangesPackage#getNodeChangeContext_Nodes()
	 * @see org.sidiff.revision.changes.NodeChange#getContext
	 * @model opposite="context" containment="true"
	 * @generated
	 */
	EList<NodeChange> getNodes();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	EObject getNode(NodeChange nodeChange);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	EList<EObject> getNodeDomains(NodeChange nodeChange);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	EClass getType(NodeChange nodeChange);

} // NodeChangeContext
