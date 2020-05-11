/**
 */
package org.sidiff.revision.changes.impl;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

import org.sidiff.revision.changes.AttributeChange;
import org.sidiff.revision.changes.AttributeChangeContext;
import org.sidiff.revision.changes.ChangesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Attribute Change</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.revision.changes.impl.AttributeChangeImpl#getContext <em>Context</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class AttributeChangeImpl extends ChangeImpl implements AttributeChange {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AttributeChangeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ChangesPackage.Literals.ATTRIBUTE_CHANGE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AttributeChangeContext getContext() {
		if (eContainerFeatureID() != ChangesPackage.ATTRIBUTE_CHANGE__CONTEXT)
			return null;
		return (AttributeChangeContext) eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetContext(AttributeChangeContext newContext, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject) newContext, ChangesPackage.ATTRIBUTE_CHANGE__CONTEXT, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setContext(AttributeChangeContext newContext) {
		if (newContext != eInternalContainer()
				|| (eContainerFeatureID() != ChangesPackage.ATTRIBUTE_CHANGE__CONTEXT && newContext != null)) {
			if (EcoreUtil.isAncestor(this, newContext))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newContext != null)
				msgs = ((InternalEObject) newContext).eInverseAdd(this,
						ChangesPackage.ATTRIBUTE_CHANGE_CONTEXT__ATTRIBUTES, AttributeChangeContext.class, msgs);
			msgs = basicSetContext(newContext, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ChangesPackage.ATTRIBUTE_CHANGE__CONTEXT, newContext,
					newContext));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public EAttribute getType() {
		return getContext().getType(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getNodeType() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public EList<EObject> getNodeDomain() {
		return getContext().getNodeDomain(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public EObject getNode() {
		return getContext().getNode(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public EDataType getValueType() {
		return getContext().getValueType(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public EList<Object> getValueDomain() {
		return getContext().getValueDomain(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public Object getValue() {
		return getContext().getValue(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case ChangesPackage.ATTRIBUTE_CHANGE__CONTEXT:
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			return basicSetContext((AttributeChangeContext) otherEnd, msgs);
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
		case ChangesPackage.ATTRIBUTE_CHANGE__CONTEXT:
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
		case ChangesPackage.ATTRIBUTE_CHANGE__CONTEXT:
			return eInternalContainer().eInverseRemove(this, ChangesPackage.ATTRIBUTE_CHANGE_CONTEXT__ATTRIBUTES,
					AttributeChangeContext.class, msgs);
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
		case ChangesPackage.ATTRIBUTE_CHANGE__CONTEXT:
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
		case ChangesPackage.ATTRIBUTE_CHANGE__CONTEXT:
			setContext((AttributeChangeContext) newValue);
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
		case ChangesPackage.ATTRIBUTE_CHANGE__CONTEXT:
			setContext((AttributeChangeContext) null);
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
		case ChangesPackage.ATTRIBUTE_CHANGE__CONTEXT:
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
		case ChangesPackage.ATTRIBUTE_CHANGE___GET_TYPE:
			return getType();
		case ChangesPackage.ATTRIBUTE_CHANGE___GET_NODE_TYPE:
			return getNodeType();
		case ChangesPackage.ATTRIBUTE_CHANGE___GET_NODE_DOMAIN:
			return getNodeDomain();
		case ChangesPackage.ATTRIBUTE_CHANGE___GET_NODE:
			return getNode();
		case ChangesPackage.ATTRIBUTE_CHANGE___GET_VALUE_TYPE:
			return getValueType();
		case ChangesPackage.ATTRIBUTE_CHANGE___GET_VALUE_DOMAIN:
			return getValueDomain();
		case ChangesPackage.ATTRIBUTE_CHANGE___GET_VALUE:
			return getValue();
		}
		return super.eInvoke(operationID, arguments);
	}

} //AttributeChangeImpl
