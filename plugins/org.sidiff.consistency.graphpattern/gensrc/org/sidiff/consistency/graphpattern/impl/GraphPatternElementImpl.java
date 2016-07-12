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
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.sidiff.consistency.graphpattern.GraphFormula;
import org.sidiff.consistency.graphpattern.GraphPatternElement;
import org.sidiff.consistency.graphpattern.GraphpatternPackage;
import org.sidiff.consistency.graphpattern.Quantifier;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Graph Pattern Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.consistency.graphpattern.impl.GraphPatternElementImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.sidiff.consistency.graphpattern.impl.GraphPatternElementImpl#getFormulas <em>Formulas</em>}</li>
 *   <li>{@link org.sidiff.consistency.graphpattern.impl.GraphPatternElementImpl#getQuantifier <em>Quantifier</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class GraphPatternElementImpl extends MinimalEObjectImpl.Container implements GraphPatternElement {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getFormulas() <em>Formulas</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFormulas()
	 * @generated
	 * @ordered
	 */
	protected EList<GraphFormula> formulas;

	/**
	 * The cached value of the '{@link #getQuantifier() <em>Quantifier</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQuantifier()
	 * @generated
	 * @ordered
	 */
	protected Quantifier quantifier;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GraphPatternElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GraphpatternPackage.Literals.GRAPH_PATTERN_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphpatternPackage.GRAPH_PATTERN_ELEMENT__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<GraphFormula> getFormulas() {
		if (formulas == null) {
			formulas = new EObjectWithInverseResolvingEList.ManyInverse<GraphFormula>(GraphFormula.class, this, GraphpatternPackage.GRAPH_PATTERN_ELEMENT__FORMULAS, GraphpatternPackage.GRAPH_FORMULA__PREDICATES);
		}
		return formulas;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Quantifier getQuantifier() {
		if (quantifier != null && quantifier.eIsProxy()) {
			InternalEObject oldQuantifier = (InternalEObject)quantifier;
			quantifier = (Quantifier)eResolveProxy(oldQuantifier);
			if (quantifier != oldQuantifier) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GraphpatternPackage.GRAPH_PATTERN_ELEMENT__QUANTIFIER, oldQuantifier, quantifier));
			}
		}
		return quantifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Quantifier basicGetQuantifier() {
		return quantifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setQuantifier(Quantifier newQuantifier) {
		Quantifier oldQuantifier = quantifier;
		quantifier = newQuantifier;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphpatternPackage.GRAPH_PATTERN_ELEMENT__QUANTIFIER, oldQuantifier, quantifier));
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
			case GraphpatternPackage.GRAPH_PATTERN_ELEMENT__FORMULAS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getFormulas()).basicAdd(otherEnd, msgs);
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
			case GraphpatternPackage.GRAPH_PATTERN_ELEMENT__FORMULAS:
				return ((InternalEList<?>)getFormulas()).basicRemove(otherEnd, msgs);
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
			case GraphpatternPackage.GRAPH_PATTERN_ELEMENT__NAME:
				return getName();
			case GraphpatternPackage.GRAPH_PATTERN_ELEMENT__FORMULAS:
				return getFormulas();
			case GraphpatternPackage.GRAPH_PATTERN_ELEMENT__QUANTIFIER:
				if (resolve) return getQuantifier();
				return basicGetQuantifier();
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
			case GraphpatternPackage.GRAPH_PATTERN_ELEMENT__NAME:
				setName((String)newValue);
				return;
			case GraphpatternPackage.GRAPH_PATTERN_ELEMENT__FORMULAS:
				getFormulas().clear();
				getFormulas().addAll((Collection<? extends GraphFormula>)newValue);
				return;
			case GraphpatternPackage.GRAPH_PATTERN_ELEMENT__QUANTIFIER:
				setQuantifier((Quantifier)newValue);
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
			case GraphpatternPackage.GRAPH_PATTERN_ELEMENT__NAME:
				setName(NAME_EDEFAULT);
				return;
			case GraphpatternPackage.GRAPH_PATTERN_ELEMENT__FORMULAS:
				getFormulas().clear();
				return;
			case GraphpatternPackage.GRAPH_PATTERN_ELEMENT__QUANTIFIER:
				setQuantifier((Quantifier)null);
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
			case GraphpatternPackage.GRAPH_PATTERN_ELEMENT__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case GraphpatternPackage.GRAPH_PATTERN_ELEMENT__FORMULAS:
				return formulas != null && !formulas.isEmpty();
			case GraphpatternPackage.GRAPH_PATTERN_ELEMENT__QUANTIFIER:
				return quantifier != null;
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
		result.append(" (name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //GraphPatternElementImpl
