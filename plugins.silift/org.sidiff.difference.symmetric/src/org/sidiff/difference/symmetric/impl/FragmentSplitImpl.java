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
import org.sidiff.difference.symmetric.FragmentSplit;
import org.sidiff.difference.symmetric.SemanticChangeSet;
import org.sidiff.difference.symmetric.SymmetricPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Fragment Split</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.difference.symmetric.impl.FragmentSplitImpl#getScs <em>Scs</em>}</li>
 *   <li>{@link org.sidiff.difference.symmetric.impl.FragmentSplitImpl#getSplitFrom <em>Split From</em>}</li>
 *   <li>{@link org.sidiff.difference.symmetric.impl.FragmentSplitImpl#getSplitInto <em>Split Into</em>}</li>
 * </ul>
 *
 * @generated
 */
public class FragmentSplitImpl extends EObjectImpl implements FragmentSplit {
	/**
	 * The cached value of the '{@link #getSplitFrom() <em>Split From</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSplitFrom()
	 * @generated
	 * @ordered
	 */
	protected EList<EObject> splitFrom;

	/**
	 * The cached value of the '{@link #getSplitInto() <em>Split Into</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSplitInto()
	 * @generated
	 * @ordered
	 */
	protected EList<EObject> splitInto;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FragmentSplitImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SymmetricPackage.Literals.FRAGMENT_SPLIT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SemanticChangeSet getScs() {
		if (eContainerFeatureID() != SymmetricPackage.FRAGMENT_SPLIT__SCS) return null;
		return (SemanticChangeSet)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetScs(SemanticChangeSet newScs, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newScs, SymmetricPackage.FRAGMENT_SPLIT__SCS, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setScs(SemanticChangeSet newScs) {
		if (newScs != eInternalContainer() || (eContainerFeatureID() != SymmetricPackage.FRAGMENT_SPLIT__SCS && newScs != null)) {
			if (EcoreUtil.isAncestor(this, newScs))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newScs != null)
				msgs = ((InternalEObject)newScs).eInverseAdd(this, SymmetricPackage.SEMANTIC_CHANGE_SET__SPLITS, SemanticChangeSet.class, msgs);
			msgs = basicSetScs(newScs, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SymmetricPackage.FRAGMENT_SPLIT__SCS, newScs, newScs));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EObject> getSplitFrom() {
		if (splitFrom == null) {
			splitFrom = new EObjectResolvingEList<EObject>(EObject.class, this, SymmetricPackage.FRAGMENT_SPLIT__SPLIT_FROM);
		}
		return splitFrom;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EObject> getSplitInto() {
		if (splitInto == null) {
			splitInto = new EObjectResolvingEList<EObject>(EObject.class, this, SymmetricPackage.FRAGMENT_SPLIT__SPLIT_INTO);
		}
		return splitInto;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SymmetricPackage.FRAGMENT_SPLIT__SCS:
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
			case SymmetricPackage.FRAGMENT_SPLIT__SCS:
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
			case SymmetricPackage.FRAGMENT_SPLIT__SCS:
				return eInternalContainer().eInverseRemove(this, SymmetricPackage.SEMANTIC_CHANGE_SET__SPLITS, SemanticChangeSet.class, msgs);
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
			case SymmetricPackage.FRAGMENT_SPLIT__SCS:
				return getScs();
			case SymmetricPackage.FRAGMENT_SPLIT__SPLIT_FROM:
				return getSplitFrom();
			case SymmetricPackage.FRAGMENT_SPLIT__SPLIT_INTO:
				return getSplitInto();
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
			case SymmetricPackage.FRAGMENT_SPLIT__SCS:
				setScs((SemanticChangeSet)newValue);
				return;
			case SymmetricPackage.FRAGMENT_SPLIT__SPLIT_FROM:
				getSplitFrom().clear();
				getSplitFrom().addAll((Collection<? extends EObject>)newValue);
				return;
			case SymmetricPackage.FRAGMENT_SPLIT__SPLIT_INTO:
				getSplitInto().clear();
				getSplitInto().addAll((Collection<? extends EObject>)newValue);
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
			case SymmetricPackage.FRAGMENT_SPLIT__SCS:
				setScs((SemanticChangeSet)null);
				return;
			case SymmetricPackage.FRAGMENT_SPLIT__SPLIT_FROM:
				getSplitFrom().clear();
				return;
			case SymmetricPackage.FRAGMENT_SPLIT__SPLIT_INTO:
				getSplitInto().clear();
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
			case SymmetricPackage.FRAGMENT_SPLIT__SCS:
				return getScs() != null;
			case SymmetricPackage.FRAGMENT_SPLIT__SPLIT_FROM:
				return splitFrom != null && !splitFrom.isEmpty();
			case SymmetricPackage.FRAGMENT_SPLIT__SPLIT_INTO:
				return splitInto != null && !splitInto.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //FragmentSplitImpl
