/**
 */
package org.sidiff.consistency.graphpattern.impl;

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
import org.sidiff.consistency.graphpattern.GraphPattern;
import org.sidiff.consistency.graphpattern.GraphpatternPackage;
import org.sidiff.consistency.graphpattern.NodePattern;
import org.sidiff.consistency.graphpattern.Pattern;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Graph Pattern</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.consistency.graphpattern.impl.GraphPatternImpl#getNodes <em>Nodes</em>}</li>
 *   <li>{@link org.sidiff.consistency.graphpattern.impl.GraphPatternImpl#getPattern <em>Pattern</em>}</li>
 *   <li>{@link org.sidiff.consistency.graphpattern.impl.GraphPatternImpl#isMulti <em>Multi</em>}</li>
 * </ul>
 *
 * @generated
 */
public class GraphPatternImpl extends GraphPatternElementImpl implements GraphPattern {
	/**
	 * The cached value of the '{@link #getNodes() <em>Nodes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNodes()
	 * @generated
	 * @ordered
	 */
	protected EList<NodePattern> nodes;

	/**
	 * The default value of the '{@link #isMulti() <em>Multi</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isMulti()
	 * @generated
	 * @ordered
	 */
	protected static final boolean MULTI_EDEFAULT = false;
	/**
	 * The cached value of the '{@link #isMulti() <em>Multi</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isMulti()
	 * @generated
	 * @ordered
	 */
	protected boolean multi = MULTI_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GraphPatternImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GraphpatternPackage.Literals.GRAPH_PATTERN;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NodePattern> getNodes() {
		if (nodes == null) {
			nodes = new EObjectContainmentWithInverseEList<NodePattern>(NodePattern.class, this, GraphpatternPackage.GRAPH_PATTERN__NODES, GraphpatternPackage.NODE_PATTERN__GRAPH);
		}
		return nodes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Pattern getPattern() {
		if (eContainerFeatureID() != GraphpatternPackage.GRAPH_PATTERN__PATTERN) return null;
		return (Pattern)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPattern(Pattern newPattern, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newPattern, GraphpatternPackage.GRAPH_PATTERN__PATTERN, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPattern(Pattern newPattern) {
		if (newPattern != eInternalContainer() || (eContainerFeatureID() != GraphpatternPackage.GRAPH_PATTERN__PATTERN && newPattern != null)) {
			if (EcoreUtil.isAncestor(this, newPattern))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newPattern != null)
				msgs = ((InternalEObject)newPattern).eInverseAdd(this, GraphpatternPackage.PATTERN__GRAPHS, Pattern.class, msgs);
			msgs = basicSetPattern(newPattern, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphpatternPackage.GRAPH_PATTERN__PATTERN, newPattern, newPattern));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isMulti() {
		return multi;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMulti(boolean newMulti) {
		boolean oldMulti = multi;
		multi = newMulti;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphpatternPackage.GRAPH_PATTERN__MULTI, oldMulti, multi));
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
			case GraphpatternPackage.GRAPH_PATTERN__NODES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getNodes()).basicAdd(otherEnd, msgs);
			case GraphpatternPackage.GRAPH_PATTERN__PATTERN:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetPattern((Pattern)otherEnd, msgs);
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
			case GraphpatternPackage.GRAPH_PATTERN__NODES:
				return ((InternalEList<?>)getNodes()).basicRemove(otherEnd, msgs);
			case GraphpatternPackage.GRAPH_PATTERN__PATTERN:
				return basicSetPattern(null, msgs);
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
			case GraphpatternPackage.GRAPH_PATTERN__PATTERN:
				return eInternalContainer().eInverseRemove(this, GraphpatternPackage.PATTERN__GRAPHS, Pattern.class, msgs);
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
			case GraphpatternPackage.GRAPH_PATTERN__NODES:
				return getNodes();
			case GraphpatternPackage.GRAPH_PATTERN__PATTERN:
				return getPattern();
			case GraphpatternPackage.GRAPH_PATTERN__MULTI:
				return isMulti();
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
			case GraphpatternPackage.GRAPH_PATTERN__NODES:
				getNodes().clear();
				getNodes().addAll((Collection<? extends NodePattern>)newValue);
				return;
			case GraphpatternPackage.GRAPH_PATTERN__PATTERN:
				setPattern((Pattern)newValue);
				return;
			case GraphpatternPackage.GRAPH_PATTERN__MULTI:
				setMulti((Boolean)newValue);
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
			case GraphpatternPackage.GRAPH_PATTERN__NODES:
				getNodes().clear();
				return;
			case GraphpatternPackage.GRAPH_PATTERN__PATTERN:
				setPattern((Pattern)null);
				return;
			case GraphpatternPackage.GRAPH_PATTERN__MULTI:
				setMulti(MULTI_EDEFAULT);
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
			case GraphpatternPackage.GRAPH_PATTERN__NODES:
				return nodes != null && !nodes.isEmpty();
			case GraphpatternPackage.GRAPH_PATTERN__PATTERN:
				return getPattern() != null;
			case GraphpatternPackage.GRAPH_PATTERN__MULTI:
				return multi != MULTI_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (multi: ");
		result.append(multi);
		result.append(')');
		return result.toString();
	}

} //GraphPatternImpl
