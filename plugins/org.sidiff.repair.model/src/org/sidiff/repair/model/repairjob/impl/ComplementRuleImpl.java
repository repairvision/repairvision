/**
 */
package org.sidiff.repair.model.repairjob.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.sidiff.repair.model.repairjob.ComplementRule;
import org.sidiff.repair.model.repairjob.RepairOperation;
import org.sidiff.repair.model.repairjob.RepairjobPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Complement Rule</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.repair.model.repairjob.impl.ComplementRuleImpl#getRepairOperation <em>Repair Operation</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ComplementRuleImpl extends PartialRuleImpl implements ComplementRule {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComplementRuleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RepairjobPackage.Literals.COMPLEMENT_RULE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RepairOperation getRepairOperation() {
		if (eContainerFeatureID() != RepairjobPackage.COMPLEMENT_RULE__REPAIR_OPERATION) return null;
		return (RepairOperation)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRepairOperation(RepairOperation newRepairOperation, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newRepairOperation, RepairjobPackage.COMPLEMENT_RULE__REPAIR_OPERATION, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRepairOperation(RepairOperation newRepairOperation) {
		if (newRepairOperation != eInternalContainer() || (eContainerFeatureID() != RepairjobPackage.COMPLEMENT_RULE__REPAIR_OPERATION && newRepairOperation != null)) {
			if (EcoreUtil.isAncestor(this, newRepairOperation))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newRepairOperation != null)
				msgs = ((InternalEObject)newRepairOperation).eInverseAdd(this, RepairjobPackage.REPAIR_OPERATION__COMPLEMENT_RULE, RepairOperation.class, msgs);
			msgs = basicSetRepairOperation(newRepairOperation, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RepairjobPackage.COMPLEMENT_RULE__REPAIR_OPERATION, newRepairOperation, newRepairOperation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case RepairjobPackage.COMPLEMENT_RULE__REPAIR_OPERATION:
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
			case RepairjobPackage.COMPLEMENT_RULE__REPAIR_OPERATION:
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
			case RepairjobPackage.COMPLEMENT_RULE__REPAIR_OPERATION:
				return eInternalContainer().eInverseRemove(this, RepairjobPackage.REPAIR_OPERATION__COMPLEMENT_RULE, RepairOperation.class, msgs);
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
			case RepairjobPackage.COMPLEMENT_RULE__REPAIR_OPERATION:
				return getRepairOperation();
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
			case RepairjobPackage.COMPLEMENT_RULE__REPAIR_OPERATION:
				setRepairOperation((RepairOperation)newValue);
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
			case RepairjobPackage.COMPLEMENT_RULE__REPAIR_OPERATION:
				setRepairOperation((RepairOperation)null);
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
			case RepairjobPackage.COMPLEMENT_RULE__REPAIR_OPERATION:
				return getRepairOperation() != null;
		}
		return super.eIsSet(featureID);
	}

} //ComplementRuleImpl
