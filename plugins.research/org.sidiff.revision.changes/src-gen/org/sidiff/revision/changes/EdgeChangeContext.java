/**
 */
package org.sidiff.revision.changes;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Edge Change Context</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.revision.changes.EdgeChangeContext#getEdges <em>Edges</em>}</li>
 * </ul>
 *
 * @see org.sidiff.revision.changes.ChangesPackage#getEdgeChangeContext()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface EdgeChangeContext extends EObject {
	/**
	 * Returns the value of the '<em><b>Edges</b></em>' containment reference list.
	 * The list contents are of type {@link org.sidiff.revision.changes.EdgeChange}.
	 * It is bidirectional and its opposite is '{@link org.sidiff.revision.changes.EdgeChange#getContext <em>Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Edges</em>' containment reference list.
	 * @see org.sidiff.revision.changes.ChangesPackage#getEdgeChangeContext_Edges()
	 * @see org.sidiff.revision.changes.EdgeChange#getContext
	 * @model opposite="context" containment="true"
	 * @generated
	 */
	EList<EdgeChange> getEdges();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	EClass getTargetType(EdgeChange edgeChange);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	EReference getType(EdgeChange edgeChange);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	EClass getSourceType(EdgeChange edgeChange);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	EObject getSource(EdgeChange edgeChange);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model ordered="false"
	 * @generated
	 */
	EList<EObject> getSourceDomain(EdgeChange edgeChange);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	EObject getTarget(EdgeChange edgeChange);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model ordered="false"
	 * @generated
	 */
	EList<EObject> getTargetDomain(EdgeChange edgeChange);

} // EdgeChangeContext
