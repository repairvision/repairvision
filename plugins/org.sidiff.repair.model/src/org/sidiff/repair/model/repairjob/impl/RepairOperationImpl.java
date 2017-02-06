/**
 */
package org.sidiff.repair.model.repairjob.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.sidiff.repair.model.repairjob.ComplementRule;
import org.sidiff.repair.model.repairjob.EditRule;
import org.sidiff.repair.model.repairjob.Repair;
import org.sidiff.repair.model.repairjob.RepairOperation;
import org.sidiff.repair.model.repairjob.RepairjobPackage;
import org.sidiff.repair.model.repairjob.SubRule;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Repair Operation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.repair.model.repairjob.impl.RepairOperationImpl#getContext <em>Context</em>}</li>
 *   <li>{@link org.sidiff.repair.model.repairjob.impl.RepairOperationImpl#getEditRule <em>Edit Rule</em>}</li>
 *   <li>{@link org.sidiff.repair.model.repairjob.impl.RepairOperationImpl#getSubRule <em>Sub Rule</em>}</li>
 *   <li>{@link org.sidiff.repair.model.repairjob.impl.RepairOperationImpl#getComplementRule <em>Complement Rule</em>}</li>
 *   <li>{@link org.sidiff.repair.model.repairjob.impl.RepairOperationImpl#getRepairs <em>Repairs</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RepairOperationImpl extends MinimalEObjectImpl.Container implements RepairOperation {
	/**
	 * The cached value of the '{@link #getContext() <em>Context</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContext()
	 * @generated
	 * @ordered
	 */
	protected EObject context;

	/**
	 * The cached value of the '{@link #getSubRule() <em>Sub Rule</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubRule()
	 * @generated
	 * @ordered
	 */
	protected SubRule subRule;

	/**
	 * The cached value of the '{@link #getComplementRule() <em>Complement Rule</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComplementRule()
	 * @generated
	 * @ordered
	 */
	protected ComplementRule complementRule;

	/**
	 * The cached value of the '{@link #getRepairs() <em>Repairs</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRepairs()
	 * @generated
	 * @ordered
	 */
	protected EList<Repair> repairs;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RepairOperationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RepairjobPackage.Literals.REPAIR_OPERATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getContext() {
		if (context != null && context.eIsProxy()) {
			InternalEObject oldContext = (InternalEObject)context;
			context = eResolveProxy(oldContext);
			if (context != oldContext) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RepairjobPackage.REPAIR_OPERATION__CONTEXT, oldContext, context));
			}
		}
		return context;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject basicGetContext() {
		return context;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContext(EObject newContext) {
		EObject oldContext = context;
		context = newContext;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RepairjobPackage.REPAIR_OPERATION__CONTEXT, oldContext, context));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EditRule getEditRule() {
		if (eContainerFeatureID() != RepairjobPackage.REPAIR_OPERATION__EDIT_RULE) return null;
		return (EditRule)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetEditRule(EditRule newEditRule, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newEditRule, RepairjobPackage.REPAIR_OPERATION__EDIT_RULE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEditRule(EditRule newEditRule) {
		if (newEditRule != eInternalContainer() || (eContainerFeatureID() != RepairjobPackage.REPAIR_OPERATION__EDIT_RULE && newEditRule != null)) {
			if (EcoreUtil.isAncestor(this, newEditRule))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newEditRule != null)
				msgs = ((InternalEObject)newEditRule).eInverseAdd(this, RepairjobPackage.EDIT_RULE__REPAIR_OPERATIONS, EditRule.class, msgs);
			msgs = basicSetEditRule(newEditRule, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RepairjobPackage.REPAIR_OPERATION__EDIT_RULE, newEditRule, newEditRule));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SubRule getSubRule() {
		return subRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSubRule(SubRule newSubRule, NotificationChain msgs) {
		SubRule oldSubRule = subRule;
		subRule = newSubRule;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RepairjobPackage.REPAIR_OPERATION__SUB_RULE, oldSubRule, newSubRule);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSubRule(SubRule newSubRule) {
		if (newSubRule != subRule) {
			NotificationChain msgs = null;
			if (subRule != null)
				msgs = ((InternalEObject)subRule).eInverseRemove(this, RepairjobPackage.SUB_RULE__REPAIR_OPERATION, SubRule.class, msgs);
			if (newSubRule != null)
				msgs = ((InternalEObject)newSubRule).eInverseAdd(this, RepairjobPackage.SUB_RULE__REPAIR_OPERATION, SubRule.class, msgs);
			msgs = basicSetSubRule(newSubRule, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RepairjobPackage.REPAIR_OPERATION__SUB_RULE, newSubRule, newSubRule));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComplementRule getComplementRule() {
		return complementRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetComplementRule(ComplementRule newComplementRule, NotificationChain msgs) {
		ComplementRule oldComplementRule = complementRule;
		complementRule = newComplementRule;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RepairjobPackage.REPAIR_OPERATION__COMPLEMENT_RULE, oldComplementRule, newComplementRule);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setComplementRule(ComplementRule newComplementRule) {
		if (newComplementRule != complementRule) {
			NotificationChain msgs = null;
			if (complementRule != null)
				msgs = ((InternalEObject)complementRule).eInverseRemove(this, RepairjobPackage.COMPLEMENT_RULE__REPAIR_OPERATION, ComplementRule.class, msgs);
			if (newComplementRule != null)
				msgs = ((InternalEObject)newComplementRule).eInverseAdd(this, RepairjobPackage.COMPLEMENT_RULE__REPAIR_OPERATION, ComplementRule.class, msgs);
			msgs = basicSetComplementRule(newComplementRule, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RepairjobPackage.REPAIR_OPERATION__COMPLEMENT_RULE, newComplementRule, newComplementRule));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Repair> getRepairs() {
		if (repairs == null) {
			repairs = new EObjectContainmentWithInverseEList<Repair>(Repair.class, this, RepairjobPackage.REPAIR_OPERATION__REPAIRS, RepairjobPackage.REPAIR__REPAIR_OPERATION);
		}
		return repairs;
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
			case RepairjobPackage.REPAIR_OPERATION__EDIT_RULE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetEditRule((EditRule)otherEnd, msgs);
			case RepairjobPackage.REPAIR_OPERATION__SUB_RULE:
				if (subRule != null)
					msgs = ((InternalEObject)subRule).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - RepairjobPackage.REPAIR_OPERATION__SUB_RULE, null, msgs);
				return basicSetSubRule((SubRule)otherEnd, msgs);
			case RepairjobPackage.REPAIR_OPERATION__COMPLEMENT_RULE:
				if (complementRule != null)
					msgs = ((InternalEObject)complementRule).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - RepairjobPackage.REPAIR_OPERATION__COMPLEMENT_RULE, null, msgs);
				return basicSetComplementRule((ComplementRule)otherEnd, msgs);
			case RepairjobPackage.REPAIR_OPERATION__REPAIRS:
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
			case RepairjobPackage.REPAIR_OPERATION__EDIT_RULE:
				return basicSetEditRule(null, msgs);
			case RepairjobPackage.REPAIR_OPERATION__SUB_RULE:
				return basicSetSubRule(null, msgs);
			case RepairjobPackage.REPAIR_OPERATION__COMPLEMENT_RULE:
				return basicSetComplementRule(null, msgs);
			case RepairjobPackage.REPAIR_OPERATION__REPAIRS:
				return ((InternalEList<?>)getRepairs()).basicRemove(otherEnd, msgs);
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
			case RepairjobPackage.REPAIR_OPERATION__EDIT_RULE:
				return eInternalContainer().eInverseRemove(this, RepairjobPackage.EDIT_RULE__REPAIR_OPERATIONS, EditRule.class, msgs);
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
			case RepairjobPackage.REPAIR_OPERATION__CONTEXT:
				if (resolve) return getContext();
				return basicGetContext();
			case RepairjobPackage.REPAIR_OPERATION__EDIT_RULE:
				return getEditRule();
			case RepairjobPackage.REPAIR_OPERATION__SUB_RULE:
				return getSubRule();
			case RepairjobPackage.REPAIR_OPERATION__COMPLEMENT_RULE:
				return getComplementRule();
			case RepairjobPackage.REPAIR_OPERATION__REPAIRS:
				return getRepairs();
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
			case RepairjobPackage.REPAIR_OPERATION__CONTEXT:
				setContext((EObject)newValue);
				return;
			case RepairjobPackage.REPAIR_OPERATION__EDIT_RULE:
				setEditRule((EditRule)newValue);
				return;
			case RepairjobPackage.REPAIR_OPERATION__SUB_RULE:
				setSubRule((SubRule)newValue);
				return;
			case RepairjobPackage.REPAIR_OPERATION__COMPLEMENT_RULE:
				setComplementRule((ComplementRule)newValue);
				return;
			case RepairjobPackage.REPAIR_OPERATION__REPAIRS:
				getRepairs().clear();
				getRepairs().addAll((Collection<? extends Repair>)newValue);
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
			case RepairjobPackage.REPAIR_OPERATION__CONTEXT:
				setContext((EObject)null);
				return;
			case RepairjobPackage.REPAIR_OPERATION__EDIT_RULE:
				setEditRule((EditRule)null);
				return;
			case RepairjobPackage.REPAIR_OPERATION__SUB_RULE:
				setSubRule((SubRule)null);
				return;
			case RepairjobPackage.REPAIR_OPERATION__COMPLEMENT_RULE:
				setComplementRule((ComplementRule)null);
				return;
			case RepairjobPackage.REPAIR_OPERATION__REPAIRS:
				getRepairs().clear();
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
			case RepairjobPackage.REPAIR_OPERATION__CONTEXT:
				return context != null;
			case RepairjobPackage.REPAIR_OPERATION__EDIT_RULE:
				return getEditRule() != null;
			case RepairjobPackage.REPAIR_OPERATION__SUB_RULE:
				return subRule != null;
			case RepairjobPackage.REPAIR_OPERATION__COMPLEMENT_RULE:
				return complementRule != null;
			case RepairjobPackage.REPAIR_OPERATION__REPAIRS:
				return repairs != null && !repairs.isEmpty();
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
			case RepairjobPackage.REPAIR_OPERATION___GET_RATING:
				return getRating();
		}
		return super.eInvoke(operationID, arguments);
	}

} //RepairOperationImpl
