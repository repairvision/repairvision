/**
 */
package org.sidiff.consistency.graphpattern.impl;

import java.lang.reflect.InvocationTargetException;

import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.sidiff.consistency.graphpattern.GraphMatch;
import org.sidiff.consistency.graphpattern.GraphPattern;
import org.sidiff.consistency.graphpattern.GraphpatternPackage;
import org.sidiff.consistency.graphpattern.NodePattern;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Graph Match</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.consistency.graphpattern.impl.GraphMatchImpl#getGraphPattern <em>Graph Pattern</em>}</li>
 *   <li>{@link org.sidiff.consistency.graphpattern.impl.GraphMatchImpl#getMatching <em>Matching</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class GraphMatchImpl extends MinimalEObjectImpl.Container implements GraphMatch {
	/**
	 * The cached value of the '{@link #getGraphPattern() <em>Graph Pattern</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGraphPattern()
	 * @generated
	 * @ordered
	 */
	protected GraphPattern graphPattern;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GraphMatchImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GraphpatternPackage.Literals.GRAPH_MATCH;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GraphPattern getGraphPattern() {
		if (graphPattern != null && graphPattern.eIsProxy()) {
			InternalEObject oldGraphPattern = (InternalEObject)graphPattern;
			graphPattern = (GraphPattern)eResolveProxy(oldGraphPattern);
			if (graphPattern != oldGraphPattern) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GraphpatternPackage.GRAPH_MATCH__GRAPH_PATTERN, oldGraphPattern, graphPattern));
			}
		}
		return graphPattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GraphPattern basicGetGraphPattern() {
		return graphPattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGraphPattern(GraphPattern newGraphPattern) {
		GraphPattern oldGraphPattern = graphPattern;
		graphPattern = newGraphPattern;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphpatternPackage.GRAPH_MATCH__GRAPH_PATTERN, oldGraphPattern, graphPattern));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EObject> getMatching() {
		// TODO: implement this method to return the 'Matching' reference list
		// Ensure that you remove @generated or mark it @generated NOT
		// The list is expected to implement org.eclipse.emf.ecore.util.InternalEList and org.eclipse.emf.ecore.EStructuralFeature.Setting
		// so it's likely that an appropriate subclass of org.eclipse.emf.ecore.util.EcoreEList should be used.
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getMatch(NodePattern node) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GraphpatternPackage.GRAPH_MATCH__GRAPH_PATTERN:
				if (resolve) return getGraphPattern();
				return basicGetGraphPattern();
			case GraphpatternPackage.GRAPH_MATCH__MATCHING:
				return getMatching();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case GraphpatternPackage.GRAPH_MATCH__GRAPH_PATTERN:
				setGraphPattern((GraphPattern)newValue);
				return;
			case GraphpatternPackage.GRAPH_MATCH__MATCHING:
				getMatching().clear();
				getMatching().addAll((Collection<? extends EObject>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case GraphpatternPackage.GRAPH_MATCH__GRAPH_PATTERN:
				setGraphPattern((GraphPattern)null);
				return;
			case GraphpatternPackage.GRAPH_MATCH__MATCHING:
				getMatching().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case GraphpatternPackage.GRAPH_MATCH__GRAPH_PATTERN:
				return graphPattern != null;
			case GraphpatternPackage.GRAPH_MATCH__MATCHING:
				return !getMatching().isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case GraphpatternPackage.GRAPH_MATCH___GET_MATCH__NODEPATTERN:
				return getMatch((NodePattern)arguments.get(0));
		}
		return super.eInvoke(operationID, arguments);
	}

} //GraphMatchImpl
