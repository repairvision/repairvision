/**
 */
package org.sidiff.difference.symmetric.impl;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.InternalEList;
import org.sidiff.difference.symmetric.EObjectSet;
import org.sidiff.difference.symmetric.EditRuleMatch;
import org.sidiff.difference.symmetric.SymmetricPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Edit Rule Match</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.difference.symmetric.impl.EditRuleMatchImpl#getNodeOccurrencesA <em>Node Occurrences A</em>}</li>
 *   <li>{@link org.sidiff.difference.symmetric.impl.EditRuleMatchImpl#getNodeOccurrencesB <em>Node Occurrences B</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EditRuleMatchImpl extends EObjectImpl implements EditRuleMatch {
	/**
	 * The cached value of the '{@link #getNodeOccurrencesA() <em>Node Occurrences A</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNodeOccurrencesA()
	 * @generated
	 * @ordered
	 */
	protected EMap<String, EObjectSet> nodeOccurrencesA;

	/**
	 * The cached value of the '{@link #getNodeOccurrencesB() <em>Node Occurrences B</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNodeOccurrencesB()
	 * @generated
	 * @ordered
	 */
	protected EMap<String, EObjectSet> nodeOccurrencesB;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EditRuleMatchImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SymmetricPackage.Literals.EDIT_RULE_MATCH;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EMap<String, EObjectSet> getNodeOccurrencesA() {
		if (nodeOccurrencesA == null) {
			nodeOccurrencesA = new EcoreEMap<String,EObjectSet>(SymmetricPackage.Literals.ESTRING2_EOBJECT_SET_MAP, EString2EObjectSetMapImpl.class, this, SymmetricPackage.EDIT_RULE_MATCH__NODE_OCCURRENCES_A);
		}
		return nodeOccurrencesA;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EMap<String, EObjectSet> getNodeOccurrencesB() {
		if (nodeOccurrencesB == null) {
			nodeOccurrencesB = new EcoreEMap<String,EObjectSet>(SymmetricPackage.Literals.ESTRING2_EOBJECT_SET_MAP, EString2EObjectSetMapImpl.class, this, SymmetricPackage.EDIT_RULE_MATCH__NODE_OCCURRENCES_B);
		}
		return nodeOccurrencesB;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SymmetricPackage.EDIT_RULE_MATCH__NODE_OCCURRENCES_A:
				return ((InternalEList<?>)getNodeOccurrencesA()).basicRemove(otherEnd, msgs);
			case SymmetricPackage.EDIT_RULE_MATCH__NODE_OCCURRENCES_B:
				return ((InternalEList<?>)getNodeOccurrencesB()).basicRemove(otherEnd, msgs);
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
			case SymmetricPackage.EDIT_RULE_MATCH__NODE_OCCURRENCES_A:
				if (coreType) return getNodeOccurrencesA();
				else return getNodeOccurrencesA().map();
			case SymmetricPackage.EDIT_RULE_MATCH__NODE_OCCURRENCES_B:
				if (coreType) return getNodeOccurrencesB();
				else return getNodeOccurrencesB().map();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case SymmetricPackage.EDIT_RULE_MATCH__NODE_OCCURRENCES_A:
				((EStructuralFeature.Setting)getNodeOccurrencesA()).set(newValue);
				return;
			case SymmetricPackage.EDIT_RULE_MATCH__NODE_OCCURRENCES_B:
				((EStructuralFeature.Setting)getNodeOccurrencesB()).set(newValue);
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
			case SymmetricPackage.EDIT_RULE_MATCH__NODE_OCCURRENCES_A:
				getNodeOccurrencesA().clear();
				return;
			case SymmetricPackage.EDIT_RULE_MATCH__NODE_OCCURRENCES_B:
				getNodeOccurrencesB().clear();
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
			case SymmetricPackage.EDIT_RULE_MATCH__NODE_OCCURRENCES_A:
				return nodeOccurrencesA != null && !nodeOccurrencesA.isEmpty();
			case SymmetricPackage.EDIT_RULE_MATCH__NODE_OCCURRENCES_B:
				return nodeOccurrencesB != null && !nodeOccurrencesB.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //EditRuleMatchImpl
