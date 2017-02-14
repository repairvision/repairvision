/**
 */
package org.sidiff.repair.model.repairjob.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.sidiff.difference.symmetric.SymmetricDifference;
import org.sidiff.repair.model.repairjob.EditRule;
import org.sidiff.repair.model.repairjob.Inconsistency;
import org.sidiff.repair.model.repairjob.RepairJob;
import org.sidiff.repair.model.repairjob.RepairjobPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Repair Job</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.repair.model.repairjob.impl.RepairJobImpl#getDifference <em>Difference</em>}</li>
 *   <li>{@link org.sidiff.repair.model.repairjob.impl.RepairJobImpl#getRepairs <em>Repairs</em>}</li>
 *   <li>{@link org.sidiff.repair.model.repairjob.impl.RepairJobImpl#getInconsistencies <em>Inconsistencies</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RepairJobImpl extends MinimalEObjectImpl.Container implements RepairJob {
	/**
	 * The cached value of the '{@link #getDifference() <em>Difference</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDifference()
	 * @generated
	 * @ordered
	 */
	protected SymmetricDifference difference;

	/**
	 * The cached value of the '{@link #getRepairs() <em>Repairs</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRepairs()
	 * @generated
	 * @ordered
	 */
	protected EList<EditRule> repairs;

	/**
	 * The cached value of the '{@link #getInconsistencies() <em>Inconsistencies</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInconsistencies()
	 * @generated
	 * @ordered
	 */
	protected EList<Inconsistency> inconsistencies;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RepairJobImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RepairjobPackage.Literals.REPAIR_JOB;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SymmetricDifference getDifference() {
		if (difference != null && difference.eIsProxy()) {
			InternalEObject oldDifference = (InternalEObject)difference;
			difference = (SymmetricDifference)eResolveProxy(oldDifference);
			if (difference != oldDifference) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RepairjobPackage.REPAIR_JOB__DIFFERENCE, oldDifference, difference));
			}
		}
		return difference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SymmetricDifference basicGetDifference() {
		return difference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDifference(SymmetricDifference newDifference) {
		SymmetricDifference oldDifference = difference;
		difference = newDifference;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RepairjobPackage.REPAIR_JOB__DIFFERENCE, oldDifference, difference));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EditRule> getRepairs() {
		if (repairs == null) {
			repairs = new EObjectContainmentWithInverseEList<EditRule>(EditRule.class, this, RepairjobPackage.REPAIR_JOB__REPAIRS, RepairjobPackage.EDIT_RULE__REPAIR_JOB);
		}
		return repairs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Inconsistency> getInconsistencies() {
		if (inconsistencies == null) {
			inconsistencies = new EObjectContainmentEList<Inconsistency>(Inconsistency.class, this, RepairjobPackage.REPAIR_JOB__INCONSISTENCIES);
		}
		return inconsistencies;
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
			case RepairjobPackage.REPAIR_JOB__REPAIRS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getRepairs()).basicAdd(otherEnd, msgs);
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
			case RepairjobPackage.REPAIR_JOB__REPAIRS:
				return ((InternalEList<?>)getRepairs()).basicRemove(otherEnd, msgs);
			case RepairjobPackage.REPAIR_JOB__INCONSISTENCIES:
				return ((InternalEList<?>)getInconsistencies()).basicRemove(otherEnd, msgs);
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
			case RepairjobPackage.REPAIR_JOB__DIFFERENCE:
				if (resolve) return getDifference();
				return basicGetDifference();
			case RepairjobPackage.REPAIR_JOB__REPAIRS:
				return getRepairs();
			case RepairjobPackage.REPAIR_JOB__INCONSISTENCIES:
				return getInconsistencies();
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
			case RepairjobPackage.REPAIR_JOB__DIFFERENCE:
				setDifference((SymmetricDifference)newValue);
				return;
			case RepairjobPackage.REPAIR_JOB__REPAIRS:
				getRepairs().clear();
				getRepairs().addAll((Collection<? extends EditRule>)newValue);
				return;
			case RepairjobPackage.REPAIR_JOB__INCONSISTENCIES:
				getInconsistencies().clear();
				getInconsistencies().addAll((Collection<? extends Inconsistency>)newValue);
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
			case RepairjobPackage.REPAIR_JOB__DIFFERENCE:
				setDifference((SymmetricDifference)null);
				return;
			case RepairjobPackage.REPAIR_JOB__REPAIRS:
				getRepairs().clear();
				return;
			case RepairjobPackage.REPAIR_JOB__INCONSISTENCIES:
				getInconsistencies().clear();
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
			case RepairjobPackage.REPAIR_JOB__DIFFERENCE:
				return difference != null;
			case RepairjobPackage.REPAIR_JOB__REPAIRS:
				return repairs != null && !repairs.isEmpty();
			case RepairjobPackage.REPAIR_JOB__INCONSISTENCIES:
				return inconsistencies != null && !inconsistencies.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //RepairJobImpl
