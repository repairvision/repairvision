/**
 */
package org.sidiff.matching.model.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.sidiff.matching.model.Correspondence;
import org.sidiff.matching.model.MatchingModelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Correspondence</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.matching.model.impl.CorrespondenceImpl#getMatchedA <em>Matched A</em>}</li>
 *   <li>{@link org.sidiff.matching.model.impl.CorrespondenceImpl#getMatchedB <em>Matched B</em>}</li>
 *   <li>{@link org.sidiff.matching.model.impl.CorrespondenceImpl#getContainerCorrespondence <em>Container Correspondence</em>}</li>
 *   <li>{@link org.sidiff.matching.model.impl.CorrespondenceImpl#getContainmentCorrespondences <em>Containment Correspondences</em>}</li>
 *   <li>{@link org.sidiff.matching.model.impl.CorrespondenceImpl#getEClass <em>EClass</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CorrespondenceImpl extends ExtendableObjectImpl implements Correspondence {
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
	 * The cached value of the '{@link #getContainerCorrespondence() <em>Container Correspondence</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContainerCorrespondence()
	 * @generated
	 * @ordered
	 */
	protected Correspondence containerCorrespondence;

	/**
	 * The cached value of the '{@link #getContainmentCorrespondences() <em>Containment Correspondences</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContainmentCorrespondences()
	 * @generated
	 * @ordered
	 */
	protected EList<Correspondence> containmentCorrespondences;

	/**
	 * The cached value of the '{@link #getEClass() <em>EClass</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEClass()
	 * @generated
	 * @ordered
	 */
	protected EClass eClass;

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
		return MatchingModelPackage.Literals.CORRESPONDENCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getMatchedA() {
		if (matchedA != null && matchedA.eIsProxy()) {
			InternalEObject oldMatchedA = (InternalEObject)matchedA;
			matchedA = eResolveProxy(oldMatchedA);
			if (matchedA != oldMatchedA) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MatchingModelPackage.CORRESPONDENCE__MATCHED_A, oldMatchedA, matchedA));
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
	public void setMatchedA(EObject newMatchedA) {
		EObject oldMatchedA = matchedA;
		matchedA = newMatchedA;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MatchingModelPackage.CORRESPONDENCE__MATCHED_A, oldMatchedA, matchedA));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getMatchedB() {
		if (matchedB != null && matchedB.eIsProxy()) {
			InternalEObject oldMatchedB = (InternalEObject)matchedB;
			matchedB = eResolveProxy(oldMatchedB);
			if (matchedB != oldMatchedB) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MatchingModelPackage.CORRESPONDENCE__MATCHED_B, oldMatchedB, matchedB));
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
	public void setMatchedB(EObject newMatchedB) {
		EObject oldMatchedB = matchedB;
		matchedB = newMatchedB;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MatchingModelPackage.CORRESPONDENCE__MATCHED_B, oldMatchedB, matchedB));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Correspondence getContainerCorrespondence() {
		if (containerCorrespondence != null && containerCorrespondence.eIsProxy()) {
			InternalEObject oldContainerCorrespondence = (InternalEObject)containerCorrespondence;
			containerCorrespondence = (Correspondence)eResolveProxy(oldContainerCorrespondence);
			if (containerCorrespondence != oldContainerCorrespondence) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MatchingModelPackage.CORRESPONDENCE__CONTAINER_CORRESPONDENCE, oldContainerCorrespondence, containerCorrespondence));
			}
		}
		return containerCorrespondence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Correspondence basicGetContainerCorrespondence() {
		return containerCorrespondence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetContainerCorrespondence(Correspondence newContainerCorrespondence, NotificationChain msgs) {
		Correspondence oldContainerCorrespondence = containerCorrespondence;
		containerCorrespondence = newContainerCorrespondence;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MatchingModelPackage.CORRESPONDENCE__CONTAINER_CORRESPONDENCE, oldContainerCorrespondence, newContainerCorrespondence);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContainerCorrespondence(Correspondence newContainerCorrespondence) {
		if (newContainerCorrespondence != containerCorrespondence) {
			NotificationChain msgs = null;
			if (containerCorrespondence != null)
				msgs = ((InternalEObject)containerCorrespondence).eInverseRemove(this, MatchingModelPackage.CORRESPONDENCE__CONTAINMENT_CORRESPONDENCES, Correspondence.class, msgs);
			if (newContainerCorrespondence != null)
				msgs = ((InternalEObject)newContainerCorrespondence).eInverseAdd(this, MatchingModelPackage.CORRESPONDENCE__CONTAINMENT_CORRESPONDENCES, Correspondence.class, msgs);
			msgs = basicSetContainerCorrespondence(newContainerCorrespondence, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MatchingModelPackage.CORRESPONDENCE__CONTAINER_CORRESPONDENCE, newContainerCorrespondence, newContainerCorrespondence));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Correspondence> getContainmentCorrespondences() {
		if (containmentCorrespondences == null) {
			containmentCorrespondences = new EObjectWithInverseResolvingEList<Correspondence>(Correspondence.class, this, MatchingModelPackage.CORRESPONDENCE__CONTAINMENT_CORRESPONDENCES, MatchingModelPackage.CORRESPONDENCE__CONTAINER_CORRESPONDENCE);
		}
		return containmentCorrespondences;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EClass getEClass() {
		//At this point we assume that both types are equal so we can return either one.
		return getMatchedA().eClass();
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
			case MatchingModelPackage.CORRESPONDENCE__CONTAINER_CORRESPONDENCE:
				if (containerCorrespondence != null)
					msgs = ((InternalEObject)containerCorrespondence).eInverseRemove(this, MatchingModelPackage.CORRESPONDENCE__CONTAINMENT_CORRESPONDENCES, Correspondence.class, msgs);
				return basicSetContainerCorrespondence((Correspondence)otherEnd, msgs);
			case MatchingModelPackage.CORRESPONDENCE__CONTAINMENT_CORRESPONDENCES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getContainmentCorrespondences()).basicAdd(otherEnd, msgs);
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
			case MatchingModelPackage.CORRESPONDENCE__CONTAINER_CORRESPONDENCE:
				return basicSetContainerCorrespondence(null, msgs);
			case MatchingModelPackage.CORRESPONDENCE__CONTAINMENT_CORRESPONDENCES:
				return ((InternalEList<?>)getContainmentCorrespondences()).basicRemove(otherEnd, msgs);
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
			case MatchingModelPackage.CORRESPONDENCE__MATCHED_A:
				if (resolve) return getMatchedA();
				return basicGetMatchedA();
			case MatchingModelPackage.CORRESPONDENCE__MATCHED_B:
				if (resolve) return getMatchedB();
				return basicGetMatchedB();
			case MatchingModelPackage.CORRESPONDENCE__CONTAINER_CORRESPONDENCE:
				if (resolve) return getContainerCorrespondence();
				return basicGetContainerCorrespondence();
			case MatchingModelPackage.CORRESPONDENCE__CONTAINMENT_CORRESPONDENCES:
				return getContainmentCorrespondences();
			case MatchingModelPackage.CORRESPONDENCE__ECLASS:
				return getEClass();
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
			case MatchingModelPackage.CORRESPONDENCE__MATCHED_A:
				setMatchedA((EObject)newValue);
				return;
			case MatchingModelPackage.CORRESPONDENCE__MATCHED_B:
				setMatchedB((EObject)newValue);
				return;
			case MatchingModelPackage.CORRESPONDENCE__CONTAINER_CORRESPONDENCE:
				setContainerCorrespondence((Correspondence)newValue);
				return;
			case MatchingModelPackage.CORRESPONDENCE__CONTAINMENT_CORRESPONDENCES:
				getContainmentCorrespondences().clear();
				getContainmentCorrespondences().addAll((Collection<? extends Correspondence>)newValue);
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
			case MatchingModelPackage.CORRESPONDENCE__MATCHED_A:
				setMatchedA((EObject)null);
				return;
			case MatchingModelPackage.CORRESPONDENCE__MATCHED_B:
				setMatchedB((EObject)null);
				return;
			case MatchingModelPackage.CORRESPONDENCE__CONTAINER_CORRESPONDENCE:
				setContainerCorrespondence((Correspondence)null);
				return;
			case MatchingModelPackage.CORRESPONDENCE__CONTAINMENT_CORRESPONDENCES:
				getContainmentCorrespondences().clear();
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
			case MatchingModelPackage.CORRESPONDENCE__MATCHED_A:
				return matchedA != null;
			case MatchingModelPackage.CORRESPONDENCE__MATCHED_B:
				return matchedB != null;
			case MatchingModelPackage.CORRESPONDENCE__CONTAINER_CORRESPONDENCE:
				return containerCorrespondence != null;
			case MatchingModelPackage.CORRESPONDENCE__CONTAINMENT_CORRESPONDENCES:
				return containmentCorrespondences != null && !containmentCorrespondences.isEmpty();
			case MatchingModelPackage.CORRESPONDENCE__ECLASS:
				return eClass != null;
		}
		return super.eIsSet(featureID);
	}

} //CorrespondenceImpl
