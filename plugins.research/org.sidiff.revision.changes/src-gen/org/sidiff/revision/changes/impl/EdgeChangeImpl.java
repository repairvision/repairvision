/**
 */
package org.sidiff.revision.changes.impl;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.sidiff.revision.changes.ChangesPackage;
import org.sidiff.revision.changes.EdgeChange;
import org.sidiff.revision.changes.EdgeChangeContext;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Edge Change</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.revision.changes.impl.EdgeChangeImpl#getContext <em>Context</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class EdgeChangeImpl extends ChangeImpl implements EdgeChange {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EdgeChangeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ChangesPackage.Literals.EDGE_CHANGE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EdgeChangeContext getContext() {
		if (eContainerFeatureID() != ChangesPackage.EDGE_CHANGE__CONTEXT)
			return null;
		return (EdgeChangeContext) eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetContext(EdgeChangeContext newContext, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject) newContext, ChangesPackage.EDGE_CHANGE__CONTEXT, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setContext(EdgeChangeContext newContext) {
		if (newContext != eInternalContainer()
				|| (eContainerFeatureID() != ChangesPackage.EDGE_CHANGE__CONTEXT && newContext != null)) {
			if (EcoreUtil.isAncestor(this, newContext))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newContext != null)
				msgs = ((InternalEObject) newContext).eInverseAdd(this, ChangesPackage.EDGE_CHANGE_CONTEXT__EDGES,
						EdgeChangeContext.class, msgs);
			msgs = basicSetContext(newContext, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ChangesPackage.EDGE_CHANGE__CONTEXT, newContext,
					newContext));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public EReference getType() {
		return getContext().getType(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public EClass geSourceType() {
		return getContext().getSourceType(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public EList<EObject> getSourceDomain() {
		return getContext().getSourceDomain(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public EObject getSource() {
		return getContext().getSource(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public EClass getTargetType() {
		return getContext().getTargetType(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public EList<EObject> getTargetDomain() {
		return getContext().getTargetDomain(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public EObject getTarget() {
		return getContext().getTarget(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case ChangesPackage.EDGE_CHANGE__CONTEXT:
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			return basicSetContext((EdgeChangeContext) otherEnd, msgs);
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
		case ChangesPackage.EDGE_CHANGE__CONTEXT:
			return basicSetContext(null, msgs);
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
		case ChangesPackage.EDGE_CHANGE__CONTEXT:
			return eInternalContainer().eInverseRemove(this, ChangesPackage.EDGE_CHANGE_CONTEXT__EDGES,
					EdgeChangeContext.class, msgs);
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
		case ChangesPackage.EDGE_CHANGE__CONTEXT:
			return getContext();
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
		case ChangesPackage.EDGE_CHANGE__CONTEXT:
			setContext((EdgeChangeContext) newValue);
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
		case ChangesPackage.EDGE_CHANGE__CONTEXT:
			setContext((EdgeChangeContext) null);
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
		case ChangesPackage.EDGE_CHANGE__CONTEXT:
			return getContext() != null;
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
		case ChangesPackage.EDGE_CHANGE___GET_TYPE:
			return getType();
		case ChangesPackage.EDGE_CHANGE___GE_SOURCE_TYPE:
			return geSourceType();
		case ChangesPackage.EDGE_CHANGE___GET_SOURCE_DOMAIN:
			return getSourceDomain();
		case ChangesPackage.EDGE_CHANGE___GET_SOURCE:
			return getSource();
		case ChangesPackage.EDGE_CHANGE___GET_TARGET_TYPE:
			return getTargetType();
		case ChangesPackage.EDGE_CHANGE___GET_TARGET_DOMAIN:
			return getTargetDomain();
		case ChangesPackage.EDGE_CHANGE___GET_TARGET:
			return getTarget();
		}
		return super.eInvoke(operationID, arguments);
	}

} //EdgeChangeImpl
