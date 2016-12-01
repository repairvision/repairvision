/**
 */
package org.sidiff.consistency.graphpattern.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.sidiff.consistency.graphpattern.EdgePattern;
import org.sidiff.consistency.graphpattern.GraphpatternPackage;
import org.sidiff.consistency.graphpattern.NavigableDataStore;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Navigable Data Store</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public abstract class NavigableDataStoreImpl extends DataStoreImpl implements NavigableDataStore {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NavigableDataStoreImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GraphpatternPackage.Literals.NAVIGABLE_DATA_STORE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Iterator<EObject> getRemoteMatchIterator(EObject localMatch, EdgePattern edge) {
		// TODO: Clients will overwrite this method...
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public int getRemoteMatchSize(EObject localMatch, EdgePattern edge) {
		// TODO: Clients will overwrite this method...
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean isEmptyRemoteMatch(EObject localMatch, EdgePattern edge) {
		// TODO: Clients will overwrite this method...
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void addRemoteMatch(EObject localMatch, EObject remoteMatch, EdgePattern edge) {
		// TODO: Clients will overwrite this method...
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean removeRemoteMatch(EObject localMatch, EObject remoteMatch, EdgePattern edge) {
		// TODO: Clients will overwrite this method...
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean containsRemoteMatch(EObject localMatch, EObject remoteMatch, EdgePattern edge) {
		// TODO: Clients will overwrite this method...
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void cleanRemoteMatches(EObject localMatch, EdgePattern edge) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void clearRemoteMatches(EObject localMatch, EdgePattern edge) {
		// TODO: Clients will overwrite this method...
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case GraphpatternPackage.NAVIGABLE_DATA_STORE___GET_REMOTE_MATCH_ITERATOR__EOBJECT_EDGEPATTERN:
				return getRemoteMatchIterator((EObject)arguments.get(0), (EdgePattern)arguments.get(1));
			case GraphpatternPackage.NAVIGABLE_DATA_STORE___GET_REMOTE_MATCH_SIZE__EOBJECT_EDGEPATTERN:
				return getRemoteMatchSize((EObject)arguments.get(0), (EdgePattern)arguments.get(1));
			case GraphpatternPackage.NAVIGABLE_DATA_STORE___IS_EMPTY_REMOTE_MATCH__EOBJECT_EDGEPATTERN:
				return isEmptyRemoteMatch((EObject)arguments.get(0), (EdgePattern)arguments.get(1));
			case GraphpatternPackage.NAVIGABLE_DATA_STORE___ADD_REMOTE_MATCH__EOBJECT_EOBJECT_EDGEPATTERN:
				addRemoteMatch((EObject)arguments.get(0), (EObject)arguments.get(1), (EdgePattern)arguments.get(2));
				return null;
			case GraphpatternPackage.NAVIGABLE_DATA_STORE___REMOVE_REMOTE_MATCH__EOBJECT_EOBJECT_EDGEPATTERN:
				return removeRemoteMatch((EObject)arguments.get(0), (EObject)arguments.get(1), (EdgePattern)arguments.get(2));
			case GraphpatternPackage.NAVIGABLE_DATA_STORE___CONTAINS_REMOTE_MATCH__EOBJECT_EOBJECT_EDGEPATTERN:
				return containsRemoteMatch((EObject)arguments.get(0), (EObject)arguments.get(1), (EdgePattern)arguments.get(2));
			case GraphpatternPackage.NAVIGABLE_DATA_STORE___CLEAN_REMOTE_MATCHES__EOBJECT_EDGEPATTERN:
				cleanRemoteMatches((EObject)arguments.get(0), (EdgePattern)arguments.get(1));
				return null;
		}
		return super.eInvoke(operationID, arguments);
	}

} //NavigableDataStoreImpl
