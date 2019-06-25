/**
 */
package org.sidiff.graphpattern.profile.henshin_extension.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.sidiff.graphpattern.impl.PatternElementImpl;
import org.sidiff.graphpattern.profile.henshin_extension.GraphElementExtension;
import org.sidiff.graphpattern.profile.henshin_extension.HenshinExtensionPackage;
import org.sidiff.graphpattern.profile.henshin_extension.SubGraph;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sub Graph</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.graphpattern.profile.henshin_extension.impl.SubGraphImpl#getSubgraphs <em>Subgraphs</em>}</li>
 *   <li>{@link org.sidiff.graphpattern.profile.henshin_extension.impl.SubGraphImpl#getElements <em>Elements</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SubGraphImpl extends PatternElementImpl implements SubGraph {
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
	 * The cached value of the '{@link #getElements() <em>Elements</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElements()
	 * @generated
	 * @ordered
	 */
	protected EList<GraphElementExtension> elements;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SubGraphImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return HenshinExtensionPackage.Literals.SUB_GRAPH;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<SubGraph> getSubgraphs() {
		if (subgraphs == null) {
			subgraphs = new EObjectContainmentEList.Resolving<SubGraph>(SubGraph.class, this, HenshinExtensionPackage.SUB_GRAPH__SUBGRAPHS);
		}
		return subgraphs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<GraphElementExtension> getElements() {
		if (elements == null) {
			elements = new EObjectWithInverseResolvingEList.ManyInverse<GraphElementExtension>(GraphElementExtension.class, this, HenshinExtensionPackage.SUB_GRAPH__ELEMENTS, HenshinExtensionPackage.GRAPH_ELEMENT_EXTENSION__SUBGRAPHS);
		}
		return elements;
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
			case HenshinExtensionPackage.SUB_GRAPH__ELEMENTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getElements()).basicAdd(otherEnd, msgs);
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
			case HenshinExtensionPackage.SUB_GRAPH__SUBGRAPHS:
				return ((InternalEList<?>)getSubgraphs()).basicRemove(otherEnd, msgs);
			case HenshinExtensionPackage.SUB_GRAPH__ELEMENTS:
				return ((InternalEList<?>)getElements()).basicRemove(otherEnd, msgs);
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
			case HenshinExtensionPackage.SUB_GRAPH__SUBGRAPHS:
				return getSubgraphs();
			case HenshinExtensionPackage.SUB_GRAPH__ELEMENTS:
				return getElements();
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
			case HenshinExtensionPackage.SUB_GRAPH__SUBGRAPHS:
				getSubgraphs().clear();
				getSubgraphs().addAll((Collection<? extends SubGraph>)newValue);
				return;
			case HenshinExtensionPackage.SUB_GRAPH__ELEMENTS:
				getElements().clear();
				getElements().addAll((Collection<? extends GraphElementExtension>)newValue);
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
			case HenshinExtensionPackage.SUB_GRAPH__SUBGRAPHS:
				getSubgraphs().clear();
				return;
			case HenshinExtensionPackage.SUB_GRAPH__ELEMENTS:
				getElements().clear();
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
			case HenshinExtensionPackage.SUB_GRAPH__SUBGRAPHS:
				return subgraphs != null && !subgraphs.isEmpty();
			case HenshinExtensionPackage.SUB_GRAPH__ELEMENTS:
				return elements != null && !elements.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //SubGraphImpl
