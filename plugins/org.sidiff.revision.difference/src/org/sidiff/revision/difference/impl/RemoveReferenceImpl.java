/**
 */
package org.sidiff.revision.difference.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.sidiff.revision.difference.DifferencePackage;
import org.sidiff.revision.difference.RemoveReference;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Remove Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.revision.difference.impl.RemoveReferenceImpl#getSrc <em>Src</em>}</li>
 *   <li>{@link org.sidiff.revision.difference.impl.RemoveReferenceImpl#getTgt <em>Tgt</em>}</li>
 *   <li>{@link org.sidiff.revision.difference.impl.RemoveReferenceImpl#getType <em>Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RemoveReferenceImpl extends ChangeImpl implements RemoveReference {
	/**
	 * The cached value of the '{@link #getSrc() <em>Src</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSrc()
	 * @generated
	 * @ordered
	 */
	protected EObject src;

	/**
	 * The cached value of the '{@link #getTgt() <em>Tgt</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTgt()
	 * @generated
	 * @ordered
	 */
	protected EObject tgt;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected EReference type;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RemoveReferenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DifferencePackage.Literals.REMOVE_REFERENCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject getSrc() {
		if (src != null && src.eIsProxy()) {
			InternalEObject oldSrc = (InternalEObject)src;
			src = eResolveProxy(oldSrc);
			if (src != oldSrc) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DifferencePackage.REMOVE_REFERENCE__SRC, oldSrc, src));
			}
		}
		return src;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject basicGetSrc() {
		return src;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSrc(EObject newSrc) {
		EObject oldSrc = src;
		src = newSrc;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DifferencePackage.REMOVE_REFERENCE__SRC, oldSrc, src));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject getTgt() {
		if (tgt != null && tgt.eIsProxy()) {
			InternalEObject oldTgt = (InternalEObject)tgt;
			tgt = eResolveProxy(oldTgt);
			if (tgt != oldTgt) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DifferencePackage.REMOVE_REFERENCE__TGT, oldTgt, tgt));
			}
		}
		return tgt;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject basicGetTgt() {
		return tgt;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTgt(EObject newTgt) {
		EObject oldTgt = tgt;
		tgt = newTgt;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DifferencePackage.REMOVE_REFERENCE__TGT, oldTgt, tgt));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getType() {
		if (type != null && type.eIsProxy()) {
			InternalEObject oldType = (InternalEObject)type;
			type = (EReference)eResolveProxy(oldType);
			if (type != oldType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DifferencePackage.REMOVE_REFERENCE__TYPE, oldType, type));
			}
		}
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference basicGetType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setType(EReference newType) {
		EReference oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DifferencePackage.REMOVE_REFERENCE__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DifferencePackage.REMOVE_REFERENCE__SRC:
				if (resolve) return getSrc();
				return basicGetSrc();
			case DifferencePackage.REMOVE_REFERENCE__TGT:
				if (resolve) return getTgt();
				return basicGetTgt();
			case DifferencePackage.REMOVE_REFERENCE__TYPE:
				if (resolve) return getType();
				return basicGetType();
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
			case DifferencePackage.REMOVE_REFERENCE__SRC:
				setSrc((EObject)newValue);
				return;
			case DifferencePackage.REMOVE_REFERENCE__TGT:
				setTgt((EObject)newValue);
				return;
			case DifferencePackage.REMOVE_REFERENCE__TYPE:
				setType((EReference)newValue);
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
			case DifferencePackage.REMOVE_REFERENCE__SRC:
				setSrc((EObject)null);
				return;
			case DifferencePackage.REMOVE_REFERENCE__TGT:
				setTgt((EObject)null);
				return;
			case DifferencePackage.REMOVE_REFERENCE__TYPE:
				setType((EReference)null);
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
			case DifferencePackage.REMOVE_REFERENCE__SRC:
				return src != null;
			case DifferencePackage.REMOVE_REFERENCE__TGT:
				return tgt != null;
			case DifferencePackage.REMOVE_REFERENCE__TYPE:
				return type != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String toString() {
		return "RemoveReferenceImpl [src=" + src + ", tgt=" + tgt + ", type=" + type + "]";
	}

} //RemoveReferenceImpl
