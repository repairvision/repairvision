/**
 */
package org.sidiff.repair.model.repairjob.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.sidiff.repair.model.repairjob.Match;
import org.sidiff.repair.model.repairjob.RepairOperation;
import org.sidiff.repair.model.repairjob.RepairjobPackage;
import org.sidiff.repair.model.repairjob.SubRule;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sub Rule</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.repair.model.repairjob.impl.SubRuleImpl#getRepairOperation <em>Repair Operation</em>}</li>
 *   <li>{@link org.sidiff.repair.model.repairjob.impl.SubRuleImpl#getMatch <em>Match</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SubRuleImpl extends PartialRuleImpl implements SubRule {
	/**
	 * The cached value of the '{@link #getMatch() <em>Match</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMatch()
	 * @generated
	 * @ordered
	 */
	protected Match match;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SubRuleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RepairjobPackage.Literals.SUB_RULE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RepairOperation getRepairOperation() {
		if (eContainerFeatureID() != RepairjobPackage.SUB_RULE__REPAIR_OPERATION) return null;
		return (RepairOperation)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRepairOperation(RepairOperation newRepairOperation, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newRepairOperation, RepairjobPackage.SUB_RULE__REPAIR_OPERATION, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRepairOperation(RepairOperation newRepairOperation) {
		if (newRepairOperation != eInternalContainer() || (eContainerFeatureID() != RepairjobPackage.SUB_RULE__REPAIR_OPERATION && newRepairOperation != null)) {
			if (EcoreUtil.isAncestor(this, newRepairOperation))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newRepairOperation != null)
				msgs = ((InternalEObject)newRepairOperation).eInverseAdd(this, RepairjobPackage.REPAIR_OPERATION__SUB_RULE, RepairOperation.class, msgs);
			msgs = basicSetRepairOperation(newRepairOperation, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RepairjobPackage.SUB_RULE__REPAIR_OPERATION, newRepairOperation, newRepairOperation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Match getMatch() {
		return match;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMatch(Match newMatch, NotificationChain msgs) {
		Match oldMatch = match;
		match = newMatch;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RepairjobPackage.SUB_RULE__MATCH, oldMatch, newMatch);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMatch(Match newMatch) {
		if (newMatch != match) {
			NotificationChain msgs = null;
			if (match != null)
				msgs = ((InternalEObject)match).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - RepairjobPackage.SUB_RULE__MATCH, null, msgs);
			if (newMatch != null)
				msgs = ((InternalEObject)newMatch).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - RepairjobPackage.SUB_RULE__MATCH, null, msgs);
			msgs = basicSetMatch(newMatch, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RepairjobPackage.SUB_RULE__MATCH, newMatch, newMatch));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case RepairjobPackage.SUB_RULE__REPAIR_OPERATION:
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
			case RepairjobPackage.SUB_RULE__REPAIR_OPERATION:
				return basicSetRepairOperation(null, msgs);
			case RepairjobPackage.SUB_RULE__MATCH:
				return basicSetMatch(null, msgs);
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
			case RepairjobPackage.SUB_RULE__REPAIR_OPERATION:
				return eInternalContainer().eInverseRemove(this, RepairjobPackage.REPAIR_OPERATION__SUB_RULE, RepairOperation.class, msgs);
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
			case RepairjobPackage.SUB_RULE__REPAIR_OPERATION:
				return getRepairOperation();
			case RepairjobPackage.SUB_RULE__MATCH:
				return getMatch();
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
			case RepairjobPackage.SUB_RULE__REPAIR_OPERATION:
				setRepairOperation((RepairOperation)newValue);
				return;
			case RepairjobPackage.SUB_RULE__MATCH:
				setMatch((Match)newValue);
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
			case RepairjobPackage.SUB_RULE__REPAIR_OPERATION:
				setRepairOperation((RepairOperation)null);
				return;
			case RepairjobPackage.SUB_RULE__MATCH:
				setMatch((Match)null);
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
			case RepairjobPackage.SUB_RULE__REPAIR_OPERATION:
				return getRepairOperation() != null;
			case RepairjobPackage.SUB_RULE__MATCH:
				return match != null;
		}
		return super.eIsSet(featureID);
	}

} //SubRuleImpl
