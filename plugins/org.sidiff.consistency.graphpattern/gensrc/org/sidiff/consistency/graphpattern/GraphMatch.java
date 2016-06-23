/**
 */
package org.sidiff.consistency.graphpattern;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Graph Match</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.consistency.graphpattern.GraphMatch#getGraphPattern <em>Graph Pattern</em>}</li>
 *   <li>{@link org.sidiff.consistency.graphpattern.GraphMatch#getMatching <em>Matching</em>}</li>
 * </ul>
 *
 * @see org.sidiff.consistency.graphpattern.GraphpatternPackage#getGraphMatch()
 * @model abstract="true"
 * @generated
 */
public interface GraphMatch extends EObject {
	/**
	 * Returns the value of the '<em><b>Graph Pattern</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Graph Pattern</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Graph Pattern</em>' reference.
	 * @see #setGraphPattern(GraphPattern)
	 * @see org.sidiff.consistency.graphpattern.GraphpatternPackage#getGraphMatch_GraphPattern()
	 * @model required="true"
	 * @generated
	 */
	GraphPattern getGraphPattern();

	/**
	 * Sets the value of the '{@link org.sidiff.consistency.graphpattern.GraphMatch#getGraphPattern <em>Graph Pattern</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Graph Pattern</em>' reference.
	 * @see #getGraphPattern()
	 * @generated
	 */
	void setGraphPattern(GraphPattern value);

	/**
	 * Returns the value of the '<em><b>Matching</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.EObject}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Matching</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Matching</em>' reference list.
	 * @see org.sidiff.consistency.graphpattern.GraphpatternPackage#getGraphMatch_Matching()
	 * @model transient="true" volatile="true" derived="true"
	 * @generated
	 */
	EList<EObject> getMatching();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	EObject getMatch(NodePattern node);

} // GraphMatch
