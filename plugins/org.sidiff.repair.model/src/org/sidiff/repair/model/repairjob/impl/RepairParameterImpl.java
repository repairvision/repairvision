/**
 */
package org.sidiff.repair.model.repairjob.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.sidiff.repair.model.repairjob.Change;
import org.sidiff.repair.model.repairjob.RepairOperation;
import org.sidiff.repair.model.repairjob.RepairParameter;
import org.sidiff.repair.model.repairjob.RepairjobPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Repair Parameter</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.repair.model.repairjob.impl.RepairParameterImpl#getRepairOperation <em>Repair Operation</em>}</li>
 *   <li>{@link org.sidiff.repair.model.repairjob.impl.RepairParameterImpl#getChange <em>Change</em>}</li>
 *   <li>{@link org.sidiff.repair.model.repairjob.impl.RepairParameterImpl#getDomain <em>Domain</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RepairParameterImpl extends MinimalEObjectImpl.Container implements RepairParameter {
	/**
	 * The cached value of the '{@link #getDomain() <em>Domain</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDomain()
	 * @generated
	 * @ordered
	 */
	protected EObject domain;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RepairParameterImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RepairjobPackage.Literals.REPAIR_PARAMETER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RepairOperation getRepairOperation() {
		if (eContainerFeatureID() != RepairjobPackage.REPAIR_PARAMETER__REPAIR_OPERATION) return null;
		return (RepairOperation)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRepairOperation(RepairOperation newRepairOperation, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newRepairOperation, RepairjobPackage.REPAIR_PARAMETER__REPAIR_OPERATION, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRepairOperation(RepairOperation newRepairOperation) {
		if (newRepairOperation != eInternalContainer() || (eContainerFeatureID() != RepairjobPackage.REPAIR_PARAMETER__REPAIR_OPERATION && newRepairOperation != null)) {
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
			eNotify(new ENotificationImpl(this, Notification.SET, RepairjobPackage.REPAIR_PARAMETER__REPAIR_OPERATION, newRepairOperation, newRepairOperation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Change getChange() {
		Change change = basicGetChange();
		return change != null && change.eIsProxy() ? (Change)eResolveProxy((InternalEObject)change) : change;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Change basicGetChange() {
		// TODO: implement this method to return the 'Change' reference
		// -> do not perform proxy resolution
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setChange(Change newChange) {
		// TODO: implement this method to set the 'Change' reference
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getDomain() {
		if (domain != null && domain.eIsProxy()) {
			InternalEObject oldDomain = (InternalEObject)domain;
			domain = eResolveProxy(oldDomain);
			if (domain != oldDomain) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RepairjobPackage.REPAIR_PARAMETER__DOMAIN, oldDomain, domain));
			}
		}
		return domain;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject basicGetDomain() {
		return domain;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDomain(EObject newDomain) {
		EObject oldDomain = domain;
		domain = newDomain;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RepairjobPackage.REPAIR_PARAMETER__DOMAIN, oldDomain, domain));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case RepairjobPackage.REPAIR_PARAMETER__REPAIR_OPERATION:
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
			case RepairjobPackage.REPAIR_PARAMETER__REPAIR_OPERATION:
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
			case RepairjobPackage.REPAIR_PARAMETER__REPAIR_OPERATION:
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
			case RepairjobPackage.REPAIR_PARAMETER__REPAIR_OPERATION:
				return getRepairOperation();
			case RepairjobPackage.REPAIR_PARAMETER__CHANGE:
				if (resolve) return getChange();
				return basicGetChange();
			case RepairjobPackage.REPAIR_PARAMETER__DOMAIN:
				if (resolve) return getDomain();
				return basicGetDomain();
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
			case RepairjobPackage.REPAIR_PARAMETER__REPAIR_OPERATION:
				setRepairOperation((RepairOperation)newValue);
				return;
			case RepairjobPackage.REPAIR_PARAMETER__CHANGE:
				setChange((Change)newValue);
				return;
			case RepairjobPackage.REPAIR_PARAMETER__DOMAIN:
				setDomain((EObject)newValue);
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
			case RepairjobPackage.REPAIR_PARAMETER__REPAIR_OPERATION:
				setRepairOperation((RepairOperation)null);
				return;
			case RepairjobPackage.REPAIR_PARAMETER__CHANGE:
				setChange((Change)null);
				return;
			case RepairjobPackage.REPAIR_PARAMETER__DOMAIN:
				setDomain((EObject)null);
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
			case RepairjobPackage.REPAIR_PARAMETER__REPAIR_OPERATION:
				return getRepairOperation() != null;
			case RepairjobPackage.REPAIR_PARAMETER__CHANGE:
				return basicGetChange() != null;
			case RepairjobPackage.REPAIR_PARAMETER__DOMAIN:
				return domain != null;
		}
		return super.eIsSet(featureID);
	}

} //RepairParameterImpl
