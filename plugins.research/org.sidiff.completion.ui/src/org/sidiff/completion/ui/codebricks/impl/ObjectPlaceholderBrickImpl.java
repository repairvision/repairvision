/**
 */
package org.sidiff.completion.ui.codebricks.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.sidiff.completion.ui.codebricks.CodebricksPackage;
import org.sidiff.completion.ui.codebricks.ObjectDomainPolicy;
import org.sidiff.completion.ui.codebricks.ObjectPlaceholderBrick;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Object Placeholder Brick</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.completion.ui.codebricks.impl.ObjectPlaceholderBrickImpl#getElement <em>Element</em>}</li>
 *   <li>{@link org.sidiff.completion.ui.codebricks.impl.ObjectPlaceholderBrickImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.sidiff.completion.ui.codebricks.impl.ObjectPlaceholderBrickImpl#getDomain <em>Domain</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ObjectPlaceholderBrickImpl extends PlaceholderBrickImpl implements ObjectPlaceholderBrick {
	/**
	 * The cached value of the '{@link #getElement() <em>Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElement()
	 * @generated
	 * @ordered
	 */
	protected EObject element;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected EClass type;

	/**
	 * The cached value of the '{@link #getDomain() <em>Domain</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDomain()
	 * @generated
	 * @ordered
	 */
	protected ObjectDomainPolicy domain;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ObjectPlaceholderBrickImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CodebricksPackage.Literals.OBJECT_PLACEHOLDER_BRICK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject getElement() {
		if (element != null && element.eIsProxy()) {
			InternalEObject oldElement = (InternalEObject)element;
			element = eResolveProxy(oldElement);
			if (element != oldElement) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CodebricksPackage.OBJECT_PLACEHOLDER_BRICK__ELEMENT, oldElement, element));
			}
		}
		return element;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject basicGetElement() {
		return element;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setElement(EObject newElement) {
		EObject oldElement = element;
		element = newElement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CodebricksPackage.OBJECT_PLACEHOLDER_BRICK__ELEMENT, oldElement, element));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getType() {
		if (type != null && type.eIsProxy()) {
			InternalEObject oldType = (InternalEObject)type;
			type = (EClass)eResolveProxy(oldType);
			if (type != oldType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CodebricksPackage.OBJECT_PLACEHOLDER_BRICK__TYPE, oldType, type));
			}
		}
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass basicGetType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setType(EClass newType) {
		EClass oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CodebricksPackage.OBJECT_PLACEHOLDER_BRICK__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ObjectDomainPolicy getDomain() {
		if (domain != null && domain.eIsProxy()) {
			InternalEObject oldDomain = (InternalEObject)domain;
			domain = (ObjectDomainPolicy)eResolveProxy(oldDomain);
			if (domain != oldDomain) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CodebricksPackage.OBJECT_PLACEHOLDER_BRICK__DOMAIN, oldDomain, domain));
			}
		}
		return domain;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ObjectDomainPolicy basicGetDomain() {
		return domain;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDomain(ObjectDomainPolicy newDomain) {
		ObjectDomainPolicy oldDomain = domain;
		domain = newDomain;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CodebricksPackage.OBJECT_PLACEHOLDER_BRICK__DOMAIN, oldDomain, domain));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CodebricksPackage.OBJECT_PLACEHOLDER_BRICK__ELEMENT:
				if (resolve) return getElement();
				return basicGetElement();
			case CodebricksPackage.OBJECT_PLACEHOLDER_BRICK__TYPE:
				if (resolve) return getType();
				return basicGetType();
			case CodebricksPackage.OBJECT_PLACEHOLDER_BRICK__DOMAIN:
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
			case CodebricksPackage.OBJECT_PLACEHOLDER_BRICK__ELEMENT:
				setElement((EObject)newValue);
				return;
			case CodebricksPackage.OBJECT_PLACEHOLDER_BRICK__TYPE:
				setType((EClass)newValue);
				return;
			case CodebricksPackage.OBJECT_PLACEHOLDER_BRICK__DOMAIN:
				setDomain((ObjectDomainPolicy)newValue);
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
			case CodebricksPackage.OBJECT_PLACEHOLDER_BRICK__ELEMENT:
				setElement((EObject)null);
				return;
			case CodebricksPackage.OBJECT_PLACEHOLDER_BRICK__TYPE:
				setType((EClass)null);
				return;
			case CodebricksPackage.OBJECT_PLACEHOLDER_BRICK__DOMAIN:
				setDomain((ObjectDomainPolicy)null);
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
			case CodebricksPackage.OBJECT_PLACEHOLDER_BRICK__ELEMENT:
				return element != null;
			case CodebricksPackage.OBJECT_PLACEHOLDER_BRICK__TYPE:
				return type != null;
			case CodebricksPackage.OBJECT_PLACEHOLDER_BRICK__DOMAIN:
				return domain != null;
		}
		return super.eIsSet(featureID);
	}

} //ObjectPlaceholderBrickImpl
