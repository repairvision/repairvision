/**
 */
package org.sidiff.difference.symmetric.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.sidiff.difference.symmetric.FragmentJoin;
import org.sidiff.difference.symmetric.SemanticChangeSet;
import org.sidiff.difference.symmetric.SymmetricPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Fragment Join</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.difference.symmetric.impl.FragmentJoinImpl#getScs <em>Scs</em>}</li>
 *   <li>{@link org.sidiff.difference.symmetric.impl.FragmentJoinImpl#getJoinFrom <em>Join From</em>}</li>
 *   <li>{@link org.sidiff.difference.symmetric.impl.FragmentJoinImpl#getJoinInto <em>Join Into</em>}</li>
 * </ul>
 *
 * @generated
 */
public class FragmentJoinImpl extends EObjectImpl implements FragmentJoin {
	/**
	 * The cached value of the '{@link #getJoinFrom() <em>Join From</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getJoinFrom()
	 * @generated
	 * @ordered
	 */
	protected EList<EObject> joinFrom;

	/**
	 * The cached value of the '{@link #getJoinInto() <em>Join Into</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getJoinInto()
	 * @generated
	 * @ordered
	 */
	protected EList<EObject> joinInto;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FragmentJoinImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SymmetricPackage.Literals.FRAGMENT_JOIN;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SemanticChangeSet getScs() {
		if (eContainerFeatureID() != SymmetricPackage.FRAGMENT_JOIN__SCS) return null;
		return (SemanticChangeSet)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetScs(SemanticChangeSet newScs, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newScs, SymmetricPackage.FRAGMENT_JOIN__SCS, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setScs(SemanticChangeSet newScs) {
		if (newScs != eInternalContainer() || (eContainerFeatureID() != SymmetricPackage.FRAGMENT_JOIN__SCS && newScs != null)) {
			if (EcoreUtil.isAncestor(this, newScs))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newScs != null)
				msgs = ((InternalEObject)newScs).eInverseAdd(this, SymmetricPackage.SEMANTIC_CHANGE_SET__JOINS, SemanticChangeSet.class, msgs);
			msgs = basicSetScs(newScs, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SymmetricPackage.FRAGMENT_JOIN__SCS, newScs, newScs));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EObject> getJoinFrom() {
		if (joinFrom == null) {
			joinFrom = new EObjectResolvingEList<EObject>(EObject.class, this, SymmetricPackage.FRAGMENT_JOIN__JOIN_FROM);
		}
		return joinFrom;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EObject> getJoinInto() {
		if (joinInto == null) {
			joinInto = new EObjectResolvingEList<EObject>(EObject.class, this, SymmetricPackage.FRAGMENT_JOIN__JOIN_INTO);
		}
		return joinInto;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SymmetricPackage.FRAGMENT_JOIN__SCS:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetScs((SemanticChangeSet)otherEnd, msgs);
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
			case SymmetricPackage.FRAGMENT_JOIN__SCS:
				return basicSetScs(null, msgs);
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
			case SymmetricPackage.FRAGMENT_JOIN__SCS:
				return eInternalContainer().eInverseRemove(this, SymmetricPackage.SEMANTIC_CHANGE_SET__JOINS, SemanticChangeSet.class, msgs);
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
			case SymmetricPackage.FRAGMENT_JOIN__SCS:
				return getScs();
			case SymmetricPackage.FRAGMENT_JOIN__JOIN_FROM:
				return getJoinFrom();
			case SymmetricPackage.FRAGMENT_JOIN__JOIN_INTO:
				return getJoinInto();
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
			case SymmetricPackage.FRAGMENT_JOIN__SCS:
				setScs((SemanticChangeSet)newValue);
				return;
			case SymmetricPackage.FRAGMENT_JOIN__JOIN_FROM:
				getJoinFrom().clear();
				getJoinFrom().addAll((Collection<? extends EObject>)newValue);
				return;
			case SymmetricPackage.FRAGMENT_JOIN__JOIN_INTO:
				getJoinInto().clear();
				getJoinInto().addAll((Collection<? extends EObject>)newValue);
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
			case SymmetricPackage.FRAGMENT_JOIN__SCS:
				setScs((SemanticChangeSet)null);
				return;
			case SymmetricPackage.FRAGMENT_JOIN__JOIN_FROM:
				getJoinFrom().clear();
				return;
			case SymmetricPackage.FRAGMENT_JOIN__JOIN_INTO:
				getJoinInto().clear();
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
			case SymmetricPackage.FRAGMENT_JOIN__SCS:
				return getScs() != null;
			case SymmetricPackage.FRAGMENT_JOIN__JOIN_FROM:
				return joinFrom != null && !joinFrom.isEmpty();
			case SymmetricPackage.FRAGMENT_JOIN__JOIN_INTO:
				return joinInto != null && !joinInto.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //FragmentJoinImpl
