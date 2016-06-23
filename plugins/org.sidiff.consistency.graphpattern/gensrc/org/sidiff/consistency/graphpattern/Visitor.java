/**
 */
package org.sidiff.consistency.graphpattern;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Visitor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.consistency.graphpattern.Visitor#getCovisitors <em>Covisitors</em>}</li>
 *   <li>{@link org.sidiff.consistency.graphpattern.Visitor#getConstraints <em>Constraints</em>}</li>
 *   <li>{@link org.sidiff.consistency.graphpattern.Visitor#getMediator <em>Mediator</em>}</li>
 * </ul>
 *
 * @see org.sidiff.consistency.graphpattern.GraphpatternPackage#getVisitor()
 * @model abstract="true"
 * @generated
 */
public interface Visitor extends EObject {
	/**
	 * Returns the value of the '<em><b>Covisitors</b></em>' reference list.
	 * The list contents are of type {@link org.sidiff.consistency.graphpattern.Visitor}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Covisitors</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Covisitors</em>' reference list.
	 * @see org.sidiff.consistency.graphpattern.GraphpatternPackage#getVisitor_Covisitors()
	 * @model
	 * @generated
	 */
	EList<Visitor> getCovisitors();

	/**
	 * Returns the value of the '<em><b>Constraints</b></em>' reference list.
	 * The list contents are of type {@link org.sidiff.consistency.graphpattern.Constraint}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constraints</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constraints</em>' reference list.
	 * @see org.sidiff.consistency.graphpattern.GraphpatternPackage#getVisitor_Constraints()
	 * @model
	 * @generated
	 */
	EList<Constraint> getConstraints();

	/**
	 * Returns the value of the '<em><b>Mediator</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.sidiff.consistency.graphpattern.Mediator#getVisitors <em>Visitors</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mediator</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mediator</em>' reference.
	 * @see #setMediator(Mediator)
	 * @see org.sidiff.consistency.graphpattern.GraphpatternPackage#getVisitor_Mediator()
	 * @see org.sidiff.consistency.graphpattern.Mediator#getVisitors
	 * @model opposite="visitors" required="true"
	 * @generated
	 */
	Mediator getMediator();

	/**
	 * Sets the value of the '{@link org.sidiff.consistency.graphpattern.Visitor#getMediator <em>Mediator</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mediator</em>' reference.
	 * @see #getMediator()
	 * @generated
	 */
	void setMediator(Mediator value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void visit(Evaluation evaluation);

} // Visitor
