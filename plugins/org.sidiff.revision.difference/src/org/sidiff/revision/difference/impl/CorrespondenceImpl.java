/**
 */
package org.sidiff.revision.difference.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.sidiff.revision.difference.Correspondence;
import org.sidiff.revision.difference.DifferencePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Correspondence</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.revision.difference.impl.CorrespondenceImpl#getMatchedA <em>Matched A</em>}</li>
 *   <li>{@link org.sidiff.revision.difference.impl.CorrespondenceImpl#getMatchedB <em>Matched B</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CorrespondenceImpl extends EObjectImpl implements Correspondence {
	/**
	 * The cached value of the '{@link #getMatchedA() <em>Matched A</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMatchedA()
	 * @generated
	 * @ordered
	 */
	protected EObject matchedA;

	/**
	 * The cached value of the '{@link #getMatchedB() <em>Matched B</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMatchedB()
	 * @generated
	 * @ordered
	 */
	protected EObject matchedB;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CorrespondenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DifferencePackage.Literals.CORRESPONDENCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject getMatchedA() {
		if (matchedA != null && matchedA.eIsProxy()) {
			InternalEObject oldMatchedA = (InternalEObject)matchedA;
			matchedA = eResolveProxy(oldMatchedA);
			if (matchedA != oldMatchedA) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DifferencePackage.CORRESPONDENCE__MATCHED_A, oldMatchedA, matchedA));
			}
		}
		return matchedA;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject basicGetMatchedA() {
		return matchedA;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMatchedA(EObject newMatchedA) {
		EObject oldMatchedA = matchedA;
		matchedA = newMatchedA;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DifferencePackage.CORRESPONDENCE__MATCHED_A, oldMatchedA, matchedA));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject getMatchedB() {
		if (matchedB != null && matchedB.eIsProxy()) {
			InternalEObject oldMatchedB = (InternalEObject)matchedB;
			matchedB = eResolveProxy(oldMatchedB);
			if (matchedB != oldMatchedB) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DifferencePackage.CORRESPONDENCE__MATCHED_B, oldMatchedB, matchedB));
			}
		}
		return matchedB;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject basicGetMatchedB() {
		return matchedB;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMatchedB(EObject newMatchedB) {
		EObject oldMatchedB = matchedB;
		matchedB = newMatchedB;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DifferencePackage.CORRESPONDENCE__MATCHED_B, oldMatchedB, matchedB));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DifferencePackage.CORRESPONDENCE__MATCHED_A:
				if (resolve) return getMatchedA();
				return basicGetMatchedA();
			case DifferencePackage.CORRESPONDENCE__MATCHED_B:
				if (resolve) return getMatchedB();
				return basicGetMatchedB();
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
			case DifferencePackage.CORRESPONDENCE__MATCHED_A:
				setMatchedA((EObject)newValue);
				return;
			case DifferencePackage.CORRESPONDENCE__MATCHED_B:
				setMatchedB((EObject)newValue);
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
			case DifferencePackage.CORRESPONDENCE__MATCHED_A:
				setMatchedA((EObject)null);
				return;
			case DifferencePackage.CORRESPONDENCE__MATCHED_B:
				setMatchedB((EObject)null);
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
			case DifferencePackage.CORRESPONDENCE__MATCHED_A:
				return matchedA != null;
			case DifferencePackage.CORRESPONDENCE__MATCHED_B:
				return matchedB != null;
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
		return "CorrespondenceImpl [matchedA=" + matchedA + ", matchedB=" + matchedB + "]";
	}

} //CorrespondenceImpl
