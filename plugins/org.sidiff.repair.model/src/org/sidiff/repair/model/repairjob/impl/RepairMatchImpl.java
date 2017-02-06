/**
 */
package org.sidiff.repair.model.repairjob.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;

import org.sidiff.repair.model.repairjob.Change;
import org.sidiff.repair.model.repairjob.Match;
import org.sidiff.repair.model.repairjob.RepairMatch;
import org.sidiff.repair.model.repairjob.RepairOperation;
import org.sidiff.repair.model.repairjob.RepairjobPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Repair Match</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.repair.model.repairjob.impl.RepairMatchImpl#getRepairOperation <em>Repair Operation</em>}</li>
 *   <li>{@link org.sidiff.repair.model.repairjob.impl.RepairMatchImpl#getChange <em>Change</em>}</li>
 *   <li>{@link org.sidiff.repair.model.repairjob.impl.RepairMatchImpl#getElements <em>Elements</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RepairMatchImpl extends MinimalEObjectImpl.Container implements RepairMatch {
	/**
	 * The cached value of the '{@link #getElements() <em>Elements</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElements()
	 * @generated
	 * @ordered
	 */
	protected EList<EObject> elements;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RepairMatchImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RepairjobPackage.Literals.REPAIR_MATCH;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RepairOperation getRepairOperation() {
		if (eContainerFeatureID() != RepairjobPackage.REPAIR_MATCH__REPAIR_OPERATION) return null;
		return (RepairOperation)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRepairOperation(RepairOperation newRepairOperation, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newRepairOperation, RepairjobPackage.REPAIR_MATCH__REPAIR_OPERATION, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRepairOperation(RepairOperation newRepairOperation) {
		if (newRepairOperation != eInternalContainer() || (eContainerFeatureID() != RepairjobPackage.REPAIR_MATCH__REPAIR_OPERATION && newRepairOperation != null)) {
			if (EcoreUtil.isAncestor(this, newRepairOperation))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newRepairOperation != null)
				msgs = ((InternalEObject)newRepairOperation).eInverseAdd(this, RepairjobPackage.REPAIR_OPERATION__REPAIRS, RepairOperation.class, msgs);
			msgs = basicSetRepairOperation(newRepairOperation, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RepairjobPackage.REPAIR_MATCH__REPAIR_OPERATION, newRepairOperation, newRepairOperation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Change> getChange() {
		// TODO: implement this method to return the 'Change' reference list
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
	public EList<EObject> getElements() {
		if (elements == null) {
			elements = new EObjectResolvingEList<EObject>(EObject.class, this, RepairjobPackage.REPAIR_MATCH__ELEMENTS);
		}
		return elements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case RepairjobPackage.REPAIR_MATCH__REPAIR_OPERATION:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetRepairOperation((RepairOperation)otherEnd, msgs);
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
			case RepairjobPackage.REPAIR_MATCH__REPAIR_OPERATION:
				return basicSetRepairOperation(null, msgs);
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
			case RepairjobPackage.REPAIR_MATCH__REPAIR_OPERATION:
				return eInternalContainer().eInverseRemove(this, RepairjobPackage.REPAIR_OPERATION__REPAIRS, RepairOperation.class, msgs);
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
			case RepairjobPackage.REPAIR_MATCH__REPAIR_OPERATION:
				return getRepairOperation();
			case RepairjobPackage.REPAIR_MATCH__CHANGE:
				return getChange();
			case RepairjobPackage.REPAIR_MATCH__ELEMENTS:
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
			case RepairjobPackage.REPAIR_MATCH__REPAIR_OPERATION:
				setRepairOperation((RepairOperation)newValue);
				return;
			case RepairjobPackage.REPAIR_MATCH__CHANGE:
				getChange().clear();
				getChange().addAll((Collection<? extends Change>)newValue);
				return;
			case RepairjobPackage.REPAIR_MATCH__ELEMENTS:
				getElements().clear();
				getElements().addAll((Collection<? extends EObject>)newValue);
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
			case RepairjobPackage.REPAIR_MATCH__REPAIR_OPERATION:
				setRepairOperation((RepairOperation)null);
				return;
			case RepairjobPackage.REPAIR_MATCH__CHANGE:
				getChange().clear();
				return;
			case RepairjobPackage.REPAIR_MATCH__ELEMENTS:
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
			case RepairjobPackage.REPAIR_MATCH__REPAIR_OPERATION:
				return getRepairOperation() != null;
			case RepairjobPackage.REPAIR_MATCH__CHANGE:
				return !getChange().isEmpty();
			case RepairjobPackage.REPAIR_MATCH__ELEMENTS:
				return elements != null && !elements.isEmpty();
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
		if (baseClass == Match.class) {
			switch (derivedFeatureID) {
				case RepairjobPackage.REPAIR_MATCH__CHANGE: return RepairjobPackage.MATCH__CHANGE;
				case RepairjobPackage.REPAIR_MATCH__ELEMENTS: return RepairjobPackage.MATCH__ELEMENTS;
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
		if (baseClass == Match.class) {
			switch (baseFeatureID) {
				case RepairjobPackage.MATCH__CHANGE: return RepairjobPackage.REPAIR_MATCH__CHANGE;
				case RepairjobPackage.MATCH__ELEMENTS: return RepairjobPackage.REPAIR_MATCH__ELEMENTS;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

} //RepairMatchImpl
