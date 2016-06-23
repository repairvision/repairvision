/**
 */
package org.sidiff.consistency.graphpattern;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mediator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.consistency.graphpattern.Mediator#getVisitors <em>Visitors</em>}</li>
 * </ul>
 *
 * @see org.sidiff.consistency.graphpattern.GraphpatternPackage#getMediator()
 * @model abstract="true"
 * @generated
 */
public interface Mediator extends EObject {
	/**
	 * Returns the value of the '<em><b>Visitors</b></em>' reference list.
	 * The list contents are of type {@link org.sidiff.consistency.graphpattern.Visitor}.
	 * It is bidirectional and its opposite is '{@link org.sidiff.consistency.graphpattern.Visitor#getMediator <em>Mediator</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Visitors</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Visitors</em>' reference list.
	 * @see org.sidiff.consistency.graphpattern.GraphpatternPackage#getMediator_Visitors()
	 * @see org.sidiff.consistency.graphpattern.Visitor#getMediator
	 * @model opposite="mediator"
	 * @generated
	 */
	EList<Visitor> getVisitors();

} // Mediator
