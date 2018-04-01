/**
 */
package org.sidiff.graphpattern.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.sidiff.graphpattern.Assignment;
import org.sidiff.graphpattern.Bundle;
import org.sidiff.graphpattern.GraphPattern;
import org.sidiff.graphpattern.GraphpatternPackage;
import org.sidiff.graphpattern.Parameter;
import org.sidiff.graphpattern.Pattern;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Pattern</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.graphpattern.impl.PatternImpl#getGraphs <em>Graphs</em>}</li>
 *   <li>{@link org.sidiff.graphpattern.impl.PatternImpl#getParameters <em>Parameters</em>}</li>
 *   <li>{@link org.sidiff.graphpattern.impl.PatternImpl#getAssignments <em>Assignments</em>}</li>
 *   <li>{@link org.sidiff.graphpattern.impl.PatternImpl#getBundle <em>Bundle</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PatternImpl extends PatternElementImpl implements Pattern {
	/**
	 * The cached value of the '{@link #getGraphs() <em>Graphs</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGraphs()
	 * @generated
	 * @ordered
	 */
	protected EList<GraphPattern> graphs;

	/**
	 * The cached value of the '{@link #getParameters() <em>Parameters</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameters()
	 * @generated
	 * @ordered
	 */
	protected EList<Parameter> parameters;

	/**
	 * The cached value of the '{@link #getAssignments() <em>Assignments</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAssignments()
	 * @generated
	 * @ordered
	 */
	protected EList<Assignment> assignments;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PatternImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GraphpatternPackage.Literals.PATTERN;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<GraphPattern> getGraphs() {
		if (graphs == null) {
			graphs = new EObjectContainmentWithInverseEList<GraphPattern>(GraphPattern.class, this, GraphpatternPackage.PATTERN__GRAPHS, GraphpatternPackage.GRAPH_PATTERN__PATTERN);
		}
		return graphs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Parameter> getParameters() {
		if (parameters == null) {
			parameters = new EObjectContainmentWithInverseEList<Parameter>(Parameter.class, this, GraphpatternPackage.PATTERN__PARAMETERS, GraphpatternPackage.PARAMETER__PATTERN);
		}
		return parameters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Assignment> getAssignments() {
		if (assignments == null) {
			assignments = new EObjectContainmentWithInverseEList<Assignment>(Assignment.class, this, GraphpatternPackage.PATTERN__ASSIGNMENTS, GraphpatternPackage.ASSIGNMENT__PATTERN);
		}
		return assignments;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Bundle getBundle() {
		if (eContainerFeatureID() != GraphpatternPackage.PATTERN__BUNDLE) return null;
		return (Bundle)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBundle(Bundle newBundle, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newBundle, GraphpatternPackage.PATTERN__BUNDLE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBundle(Bundle newBundle) {
		if (newBundle != eInternalContainer() || (eContainerFeatureID() != GraphpatternPackage.PATTERN__BUNDLE && newBundle != null)) {
			if (EcoreUtil.isAncestor(this, newBundle))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newBundle != null)
				msgs = ((InternalEObject)newBundle).eInverseAdd(this, GraphpatternPackage.BUNDLE__PATTERNS, Bundle.class, msgs);
			msgs = basicSetBundle(newBundle, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphpatternPackage.PATTERN__BUNDLE, newBundle, newBundle));
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
			case GraphpatternPackage.PATTERN__GRAPHS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getGraphs()).basicAdd(otherEnd, msgs);
			case GraphpatternPackage.PATTERN__PARAMETERS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getParameters()).basicAdd(otherEnd, msgs);
			case GraphpatternPackage.PATTERN__ASSIGNMENTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getAssignments()).basicAdd(otherEnd, msgs);
			case GraphpatternPackage.PATTERN__BUNDLE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetBundle((Bundle)otherEnd, msgs);
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
			case GraphpatternPackage.PATTERN__GRAPHS:
				return ((InternalEList<?>)getGraphs()).basicRemove(otherEnd, msgs);
			case GraphpatternPackage.PATTERN__PARAMETERS:
				return ((InternalEList<?>)getParameters()).basicRemove(otherEnd, msgs);
			case GraphpatternPackage.PATTERN__ASSIGNMENTS:
				return ((InternalEList<?>)getAssignments()).basicRemove(otherEnd, msgs);
			case GraphpatternPackage.PATTERN__BUNDLE:
				return basicSetBundle(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case GraphpatternPackage.PATTERN__BUNDLE:
				return eInternalContainer().eInverseRemove(this, GraphpatternPackage.BUNDLE__PATTERNS, Bundle.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GraphpatternPackage.PATTERN__GRAPHS:
				return getGraphs();
			case GraphpatternPackage.PATTERN__PARAMETERS:
				return getParameters();
			case GraphpatternPackage.PATTERN__ASSIGNMENTS:
				return getAssignments();
			case GraphpatternPackage.PATTERN__BUNDLE:
				return getBundle();
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
			case GraphpatternPackage.PATTERN__GRAPHS:
				getGraphs().clear();
				getGraphs().addAll((Collection<? extends GraphPattern>)newValue);
				return;
			case GraphpatternPackage.PATTERN__PARAMETERS:
				getParameters().clear();
				getParameters().addAll((Collection<? extends Parameter>)newValue);
				return;
			case GraphpatternPackage.PATTERN__ASSIGNMENTS:
				getAssignments().clear();
				getAssignments().addAll((Collection<? extends Assignment>)newValue);
				return;
			case GraphpatternPackage.PATTERN__BUNDLE:
				setBundle((Bundle)newValue);
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
			case GraphpatternPackage.PATTERN__GRAPHS:
				getGraphs().clear();
				return;
			case GraphpatternPackage.PATTERN__PARAMETERS:
				getParameters().clear();
				return;
			case GraphpatternPackage.PATTERN__ASSIGNMENTS:
				getAssignments().clear();
				return;
			case GraphpatternPackage.PATTERN__BUNDLE:
				setBundle((Bundle)null);
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
			case GraphpatternPackage.PATTERN__GRAPHS:
				return graphs != null && !graphs.isEmpty();
			case GraphpatternPackage.PATTERN__PARAMETERS:
				return parameters != null && !parameters.isEmpty();
			case GraphpatternPackage.PATTERN__ASSIGNMENTS:
				return assignments != null && !assignments.isEmpty();
			case GraphpatternPackage.PATTERN__BUNDLE:
				return getBundle() != null;
		}
		return super.eIsSet(featureID);
	}

} //PatternImpl
