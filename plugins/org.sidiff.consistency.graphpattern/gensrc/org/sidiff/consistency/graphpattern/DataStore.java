/**
 */
package org.sidiff.consistency.graphpattern;

import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Data Store</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.consistency.graphpattern.DataStore#getEvaluation <em>Evaluation</em>}</li>
 * </ul>
 *
 * @see org.sidiff.consistency.graphpattern.GraphpatternPackage#getDataStore()
 * @model abstract="true"
 * @generated
 */
public interface DataStore extends EObject {
	/**
	 * Returns the value of the '<em><b>Evaluation</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.sidiff.consistency.graphpattern.Evaluation#getStore <em>Store</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Evaluation</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Evaluation</em>' reference.
	 * @see #setEvaluation(Evaluation)
	 * @see org.sidiff.consistency.graphpattern.GraphpatternPackage#getDataStore_Evaluation()
	 * @see org.sidiff.consistency.graphpattern.Evaluation#getStore
	 * @model opposite="store" required="true"
	 * @generated
	 */
	Evaluation getEvaluation();

	/**
	 * Sets the value of the '{@link org.sidiff.consistency.graphpattern.DataStore#getEvaluation <em>Evaluation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Evaluation</em>' reference.
	 * @see #getEvaluation()
	 * @generated
	 */
	void setEvaluation(Evaluation value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void initialize();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" dataType="org.sidiff.consistency.graphpattern.EIterator"
	 * @generated
	 */
	Iterator<EObject> getMatchIterator();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	int getMatchSize();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	boolean isEmptyMatch();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void addMatch(EObject localMatch);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	boolean removeMatch(EObject localMatch);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	boolean containsMatch(EObject localMatch);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void clearMatches();

} // DataStore
