/**
 */
package org.sidiff.graphpattern.profile.henshin_extension.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.emf.henshin.model.impl.RuleImpl;
import org.sidiff.graphpattern.profile.henshin_extension.HenshinExtensionPackage;
import org.sidiff.graphpattern.profile.henshin_extension.RuleExtension;
import org.sidiff.graphpattern.profile.henshin_extension.SubGraph;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Rule Extension</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.graphpattern.profile.henshin_extension.impl.RuleExtensionImpl#getSubgraphs <em>Subgraphs</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RuleExtensionImpl extends RuleImpl implements RuleExtension {
	/**
	 * The cached value of the '{@link #getSubgraphs() <em>Subgraphs</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubgraphs()
	 * @generated
	 * @ordered
	 */
	protected EList<SubGraph> subgraphs;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RuleExtensionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return HenshinExtensionPackage.Literals.RULE_EXTENSION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<SubGraph> getSubgraphs() {
		if (subgraphs == null) {
			subgraphs = new EObjectContainmentEList.Resolving<SubGraph>(SubGraph.class, this, HenshinExtensionPackage.RULE_EXTENSION__SUBGRAPHS);
		}
		return subgraphs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case HenshinExtensionPackage.RULE_EXTENSION__SUBGRAPHS:
				return ((InternalEList<?>)getSubgraphs()).basicRemove(otherEnd, msgs);
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
			case HenshinExtensionPackage.RULE_EXTENSION__SUBGRAPHS:
				return getSubgraphs();
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
			case HenshinExtensionPackage.RULE_EXTENSION__SUBGRAPHS:
				getSubgraphs().clear();
				getSubgraphs().addAll((Collection<? extends SubGraph>)newValue);
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
			case HenshinExtensionPackage.RULE_EXTENSION__SUBGRAPHS:
				getSubgraphs().clear();
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
			case HenshinExtensionPackage.RULE_EXTENSION__SUBGRAPHS:
				return subgraphs != null && !subgraphs.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //RuleExtensionImpl
