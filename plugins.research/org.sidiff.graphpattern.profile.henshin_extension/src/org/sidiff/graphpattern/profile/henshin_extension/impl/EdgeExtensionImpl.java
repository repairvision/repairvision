/**
 */
package org.sidiff.graphpattern.profile.henshin_extension.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.emf.henshin.model.impl.EdgeImpl;
import org.sidiff.graphpattern.profile.henshin_extension.EdgeExtension;
import org.sidiff.graphpattern.profile.henshin_extension.GraphElementExtension;
import org.sidiff.graphpattern.profile.henshin_extension.HenshinExtensionPackage;
import org.sidiff.graphpattern.profile.henshin_extension.SubGraph;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Edge Extension</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.graphpattern.profile.henshin_extension.impl.EdgeExtensionImpl#getSubgraphs <em>Subgraphs</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EdgeExtensionImpl extends EdgeImpl implements EdgeExtension {
	/**
	 * The cached value of the '{@link #getSubgraphs() <em>Subgraphs</em>}' reference list.
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
	public EdgeExtensionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return HenshinExtensionPackage.Literals.EDGE_EXTENSION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<SubGraph> getSubgraphs() {
		if (subgraphs == null) {
			subgraphs = new EObjectWithInverseResolvingEList.ManyInverse<SubGraph>(SubGraph.class, this, HenshinExtensionPackage.EDGE_EXTENSION__SUBGRAPHS, HenshinExtensionPackage.SUB_GRAPH__ELEMENTS);
		}
		return subgraphs;
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
			case HenshinExtensionPackage.EDGE_EXTENSION__SUBGRAPHS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getSubgraphs()).basicAdd(otherEnd, msgs);
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
			case HenshinExtensionPackage.EDGE_EXTENSION__SUBGRAPHS:
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
			case HenshinExtensionPackage.EDGE_EXTENSION__SUBGRAPHS:
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
			case HenshinExtensionPackage.EDGE_EXTENSION__SUBGRAPHS:
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
			case HenshinExtensionPackage.EDGE_EXTENSION__SUBGRAPHS:
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
			case HenshinExtensionPackage.EDGE_EXTENSION__SUBGRAPHS:
				return subgraphs != null && !subgraphs.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == GraphElementExtension.class) {
			switch (derivedFeatureID) {
				case HenshinExtensionPackage.EDGE_EXTENSION__SUBGRAPHS: return HenshinExtensionPackage.GRAPH_ELEMENT_EXTENSION__SUBGRAPHS;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == GraphElementExtension.class) {
			switch (baseFeatureID) {
				case HenshinExtensionPackage.GRAPH_ELEMENT_EXTENSION__SUBGRAPHS: return HenshinExtensionPackage.EDGE_EXTENSION__SUBGRAPHS;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

} //EdgeExtensionImpl
