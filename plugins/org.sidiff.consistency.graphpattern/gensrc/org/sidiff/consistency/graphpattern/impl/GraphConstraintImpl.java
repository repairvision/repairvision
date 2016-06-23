/**
 */
package org.sidiff.consistency.graphpattern.impl;

import java.lang.reflect.InvocationTargetException;

import java.util.Collection;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.sidiff.consistency.graphpattern.Formula;
import org.sidiff.consistency.graphpattern.GraphConstraint;
import org.sidiff.consistency.graphpattern.GraphPredicate;
import org.sidiff.consistency.graphpattern.GraphpatternPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Graph Constraint</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.consistency.graphpattern.impl.GraphConstraintImpl#getGraphPredicates <em>Graph Predicates</em>}</li>
 * </ul>
 *
 * @generated
 */
public class GraphConstraintImpl extends MinimalEObjectImpl.Container implements GraphConstraint {
	/**
	 * The cached value of the '{@link #getGraphPredicates() <em>Graph Predicates</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGraphPredicates()
	 * @generated
	 * @ordered
	 */
	protected EList<GraphPredicate> graphPredicates;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GraphConstraintImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GraphpatternPackage.Literals.GRAPH_CONSTRAINT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<GraphPredicate> getGraphPredicates() {
		if (graphPredicates == null) {
			graphPredicates = new EObjectWithInverseResolvingEList.ManyInverse<GraphPredicate>(GraphPredicate.class, this, GraphpatternPackage.GRAPH_CONSTRAINT__GRAPH_PREDICATES, GraphpatternPackage.GRAPH_PREDICATE__CONSTRAINTS);
		}
		return graphPredicates;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean getResult() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Formula getEmbedding() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GraphpatternPackage.GRAPH_CONSTRAINT__GRAPH_PREDICATES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getGraphPredicates()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GraphpatternPackage.GRAPH_CONSTRAINT__GRAPH_PREDICATES:
				return ((InternalEList<?>)getGraphPredicates()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GraphpatternPackage.GRAPH_CONSTRAINT__GRAPH_PREDICATES:
				return getGraphPredicates();
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
			case GraphpatternPackage.GRAPH_CONSTRAINT__GRAPH_PREDICATES:
				getGraphPredicates().clear();
				getGraphPredicates().addAll((Collection<? extends GraphPredicate>)newValue);
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
			case GraphpatternPackage.GRAPH_CONSTRAINT__GRAPH_PREDICATES:
				getGraphPredicates().clear();
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
			case GraphpatternPackage.GRAPH_CONSTRAINT__GRAPH_PREDICATES:
				return graphPredicates != null && !graphPredicates.isEmpty();
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
			case GraphpatternPackage.GRAPH_CONSTRAINT___GET_RESULT:
				return getResult();
			case GraphpatternPackage.GRAPH_CONSTRAINT___GET_EMBEDDING:
				return getEmbedding();
		}
		return super.eInvoke(operationID, arguments);
	}

} //GraphConstraintImpl
