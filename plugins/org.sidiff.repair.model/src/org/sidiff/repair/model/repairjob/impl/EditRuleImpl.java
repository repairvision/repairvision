/**
 */
package org.sidiff.repair.model.repairjob.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.emf.henshin.model.Rule;
import org.sidiff.repair.model.repairjob.EditRule;
import org.sidiff.repair.model.repairjob.RepairJob;
import org.sidiff.repair.model.repairjob.RepairOperation;
import org.sidiff.repair.model.repairjob.RepairjobPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Edit Rule</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.repair.model.repairjob.impl.EditRuleImpl#getRule <em>Rule</em>}</li>
 *   <li>{@link org.sidiff.repair.model.repairjob.impl.EditRuleImpl#getRepairOperations <em>Repair Operations</em>}</li>
 *   <li>{@link org.sidiff.repair.model.repairjob.impl.EditRuleImpl#getRepairJob <em>Repair Job</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EditRuleImpl extends MinimalEObjectImpl.Container implements EditRule {
	/**
	 * The cached value of the '{@link #getRule() <em>Rule</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRule()
	 * @generated
	 * @ordered
	 */
	protected Rule rule;

	/**
	 * The cached value of the '{@link #getRepairOperations() <em>Repair Operations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRepairOperations()
	 * @generated
	 * @ordered
	 */
	protected EList<RepairOperation> repairOperations;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EditRuleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RepairjobPackage.Literals.EDIT_RULE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Rule getRule() {
		if (rule != null && rule.eIsProxy()) {
			InternalEObject oldRule = (InternalEObject)rule;
			rule = (Rule)eResolveProxy(oldRule);
			if (rule != oldRule) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RepairjobPackage.EDIT_RULE__RULE, oldRule, rule));
			}
		}
		return rule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Rule basicGetRule() {
		return rule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRule(Rule newRule) {
		Rule oldRule = rule;
		rule = newRule;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RepairjobPackage.EDIT_RULE__RULE, oldRule, rule));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RepairJob getRepairJob() {
		if (eContainerFeatureID() != RepairjobPackage.EDIT_RULE__REPAIR_JOB) return null;
		return (RepairJob)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRepairJob(RepairJob newRepairJob, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newRepairJob, RepairjobPackage.EDIT_RULE__REPAIR_JOB, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRepairJob(RepairJob newRepairJob) {
		if (newRepairJob != eInternalContainer() || (eContainerFeatureID() != RepairjobPackage.EDIT_RULE__REPAIR_JOB && newRepairJob != null)) {
			if (EcoreUtil.isAncestor(this, newRepairJob))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newRepairJob != null)
				msgs = ((InternalEObject)newRepairJob).eInverseAdd(this, RepairjobPackage.REPAIR_JOB__REPAIRS, RepairJob.class, msgs);
			msgs = basicSetRepairJob(newRepairJob, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RepairjobPackage.EDIT_RULE__REPAIR_JOB, newRepairJob, newRepairJob));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<RepairOperation> getRepairOperations() {
		if (repairOperations == null) {
			repairOperations = new EObjectContainmentWithInverseEList<RepairOperation>(RepairOperation.class, this, RepairjobPackage.EDIT_RULE__REPAIR_OPERATIONS, RepairjobPackage.REPAIR_OPERATION__EDIT_RULE);
		}
		return repairOperations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getRating() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
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
			case RepairjobPackage.EDIT_RULE__REPAIR_OPERATIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getRepairOperations()).basicAdd(otherEnd, msgs);
			case RepairjobPackage.EDIT_RULE__REPAIR_JOB:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetRepairJob((RepairJob)otherEnd, msgs);
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
			case RepairjobPackage.EDIT_RULE__REPAIR_OPERATIONS:
				return ((InternalEList<?>)getRepairOperations()).basicRemove(otherEnd, msgs);
			case RepairjobPackage.EDIT_RULE__REPAIR_JOB:
				return basicSetRepairJob(null, msgs);
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
			case RepairjobPackage.EDIT_RULE__REPAIR_JOB:
				return eInternalContainer().eInverseRemove(this, RepairjobPackage.REPAIR_JOB__REPAIRS, RepairJob.class, msgs);
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
			case RepairjobPackage.EDIT_RULE__RULE:
				if (resolve) return getRule();
				return basicGetRule();
			case RepairjobPackage.EDIT_RULE__REPAIR_OPERATIONS:
				return getRepairOperations();
			case RepairjobPackage.EDIT_RULE__REPAIR_JOB:
				return getRepairJob();
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
			case RepairjobPackage.EDIT_RULE__RULE:
				setRule((Rule)newValue);
				return;
			case RepairjobPackage.EDIT_RULE__REPAIR_OPERATIONS:
				getRepairOperations().clear();
				getRepairOperations().addAll((Collection<? extends RepairOperation>)newValue);
				return;
			case RepairjobPackage.EDIT_RULE__REPAIR_JOB:
				setRepairJob((RepairJob)newValue);
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
			case RepairjobPackage.EDIT_RULE__RULE:
				setRule((Rule)null);
				return;
			case RepairjobPackage.EDIT_RULE__REPAIR_OPERATIONS:
				getRepairOperations().clear();
				return;
			case RepairjobPackage.EDIT_RULE__REPAIR_JOB:
				setRepairJob((RepairJob)null);
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
			case RepairjobPackage.EDIT_RULE__RULE:
				return rule != null;
			case RepairjobPackage.EDIT_RULE__REPAIR_OPERATIONS:
				return repairOperations != null && !repairOperations.isEmpty();
			case RepairjobPackage.EDIT_RULE__REPAIR_JOB:
				return getRepairJob() != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case RepairjobPackage.EDIT_RULE___GET_RATING:
				return getRating();
		}
		return super.eInvoke(operationID, arguments);
	}

} //EditRuleImpl
