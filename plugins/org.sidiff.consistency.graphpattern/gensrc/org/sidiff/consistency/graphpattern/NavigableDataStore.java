/**
 */
package org.sidiff.consistency.graphpattern;

import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Navigable Data Store</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.sidiff.consistency.graphpattern.GraphpatternPackage#getNavigableDataStore()
 * @model abstract="true"
 * @generated
 */
public interface NavigableDataStore extends DataStore {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model dataType="org.sidiff.consistency.graphpattern.EIterator"
	 * @generated
	 */
	Iterator<EObject> getRemoteMatchIterator(EObject localMatch, EdgePattern edge);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	int getRemoteMatchSize(EObject localMatch, EdgePattern edge);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	boolean isEmptyRemoteMatch(EObject localMatch, EdgePattern edge);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void addRemoteMatch(EObject localMatch, EObject remoteMatch, EdgePattern edge);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	boolean removeRemoteMatch(EObject localMatch, EObject remoteMatch, EdgePattern edge);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	boolean containsRemoteMatch(EObject localMatch, EObject remoteMatch, EdgePattern edge);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void cleanRemoteMatches(EObject localMatch, EdgePattern edge);

} // NavigableDataStore
