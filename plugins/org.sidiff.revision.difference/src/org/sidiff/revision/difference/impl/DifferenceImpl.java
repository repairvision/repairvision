/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.sidiff.revision.difference.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.sidiff.revision.difference.Change;
import org.sidiff.revision.difference.Correspondence;
import org.sidiff.revision.difference.Difference;
import org.sidiff.revision.difference.DifferencePackage;

/**
 * <!-- begin-user-doc --> 
 * An implementation of the model object '<em><b>Difference</b></em>'. 
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.revision.difference.impl.DifferenceImpl#getChanges <em>Changes</em>}</li>
 *   <li>{@link org.sidiff.revision.difference.impl.DifferenceImpl#getModelA <em>Model A</em>}</li>
 *   <li>{@link org.sidiff.revision.difference.impl.DifferenceImpl#getModelB <em>Model B</em>}</li>
 *   <li>{@link org.sidiff.revision.difference.impl.DifferenceImpl#getUriModelA <em>Uri Model A</em>}</li>
 *   <li>{@link org.sidiff.revision.difference.impl.DifferenceImpl#getUriModelB <em>Uri Model B</em>}</li>
 *   <li>{@link org.sidiff.revision.difference.impl.DifferenceImpl#getCorrespondences <em>Correspondences</em>}</li>
 *   <li>{@link org.sidiff.revision.difference.impl.DifferenceImpl#getUnmatchedA <em>Unmatched A</em>}</li>
 *   <li>{@link org.sidiff.revision.difference.impl.DifferenceImpl#getUnmatchedB <em>Unmatched B</em>}</li>
 *   <li>{@link org.sidiff.revision.difference.impl.DifferenceImpl#getEResourceA <em>EResource A</em>}</li>
 *   <li>{@link org.sidiff.revision.difference.impl.DifferenceImpl#getEResourceB <em>EResource B</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DifferenceImpl extends EObjectImpl implements Difference {

	/**
	 * Indexed access to correspondences: Model A -> Correspondence
	 * 
	 * @generated NOT
	 */
	private Map<EObject, Correspondence> correspondencesA;

	/**
	 * Indexed access to correspondences: Model B -> Correspondence
	 * 
	 * @generated NOT
	 */
	private Map<EObject, Correspondence> correspondencesB;

	/**
	 * The cached value of the '{@link #getChanges() <em>Changes</em>}' containment reference list.
	 * <!-- begin-user-doc --> 
	 * <!-- end-user-doc -->
	 * @see #getChanges()
	 * @generated
	 * @ordered
	 */
	protected EList<Change> changes;

	/**
	 * The default value of the '{@link #getModelA() <em>Model A</em>}' attribute.
	 * <!-- begin-user-doc --> 
	 * <!-- end-user-doc -->
	 * @see #getModelA()
	 * @generated
	 * @ordered
	 */
	protected static final Resource MODEL_A_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getModelB() <em>Model B</em>}' attribute.
	 * <!-- begin-user-doc --> 
	 * <!-- end-user-doc -->
	 * @see #getModelB()
	 * @generated
	 * @ordered
	 */
	protected static final Resource MODEL_B_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getUriModelA() <em>Uri Model A</em>}' attribute.
	 * <!-- begin-user-doc --> 
	 * <!-- end-user-doc -->
	 * @see #getUriModelA()
	 * @generated
	 * @ordered
	 */
	protected static final String URI_MODEL_A_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUriModelA() <em>Uri Model A</em>}' attribute.
	 * <!-- begin-user-doc --> 
	 * <!-- end-user-doc -->
	 * @see #getUriModelA()
	 * @generated
	 * @ordered
	 */
	protected String uriModelA = URI_MODEL_A_EDEFAULT;

	/**
	 * The default value of the '{@link #getUriModelB() <em>Uri Model B</em>}' attribute.
	 * <!-- begin-user-doc --> 
	 * <!-- end-user-doc -->
	 * @see #getUriModelB()
	 * @generated
	 * @ordered
	 */
	protected static final String URI_MODEL_B_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUriModelB() <em>Uri Model B</em>}' attribute.
	 * <!-- begin-user-doc --> 
	 * <!-- end-user-doc -->
	 * @see #getUriModelB()
	 * @generated
	 * @ordered
	 */
	protected String uriModelB = URI_MODEL_B_EDEFAULT;

	/**
	 * The cached value of the '{@link #getCorrespondences() <em>Correspondences</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCorrespondences()
	 * @generated
	 * @ordered
	 */
	protected EList<Correspondence> correspondences;

	/**
	 * The cached value of the '{@link #getUnmatchedA() <em>Unmatched A</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUnmatchedA()
	 * @generated
	 * @ordered
	 */
	protected EList<EObject> unmatchedA;

	/**
	 * The cached value of the '{@link #getUnmatchedB() <em>Unmatched B</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUnmatchedB()
	 * @generated
	 * @ordered
	 */
	protected EList<EObject> unmatchedB;

	/**
	 * The default value of the '{@link #getEResourceA() <em>EResource A</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEResourceA()
	 * @generated
	 * @ordered
	 */
	protected static final Resource ERESOURCE_A_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getEResourceA() <em>EResource A</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEResourceA()
	 * @generated
	 * @ordered
	 */
	protected Resource eResourceA = ERESOURCE_A_EDEFAULT;

	/**
	 * The default value of the '{@link #getEResourceB() <em>EResource B</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEResourceB()
	 * @generated
	 * @ordered
	 */
	protected static final Resource ERESOURCE_B_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getEResourceB() <em>EResource B</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEResourceB()
	 * @generated
	 * @ordered
	 */
	protected Resource eResourceB = ERESOURCE_B_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> 
	 * <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	protected DifferenceImpl() {
		super();

		initCorrespondenceIndex();
	}

	/**
	 * <!-- begin-user-doc --> 
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DifferencePackage.Literals.DIFFERENCE;
	}

	/**
	 * <!-- begin-user-doc --> 
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Change> getChanges() {
		if (changes == null) {
			changes = new EObjectContainmentEList<Change>(Change.class, this, DifferencePackage.DIFFERENCE__CHANGES);
		}
		return changes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public Resource getModelA() {
		return getEResourceA();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public Resource getModelB() {
		return getEResourceB();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getUriModelA() {
		return uriModelA;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setUriModelA(String newUriModelA) {
		String oldUriModelA = uriModelA;
		uriModelA = newUriModelA;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DifferencePackage.DIFFERENCE__URI_MODEL_A, oldUriModelA, uriModelA));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getUriModelB() {
		return uriModelB;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setUriModelB(String newUriModelB) {
		String oldUriModelB = uriModelB;
		uriModelB = newUriModelB;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DifferencePackage.DIFFERENCE__URI_MODEL_B, oldUriModelB, uriModelB));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Correspondence> getCorrespondences() {
		if (correspondences == null) {
			correspondences = new EObjectContainmentEList<Correspondence>(Correspondence.class, this, DifferencePackage.DIFFERENCE__CORRESPONDENCES);
		}
		return correspondences;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<EObject> getUnmatchedA() {
		if (unmatchedA == null) {
			unmatchedA = new EObjectResolvingEList<EObject>(EObject.class, this, DifferencePackage.DIFFERENCE__UNMATCHED_A);
		}
		return unmatchedA;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<EObject> getUnmatchedB() {
		if (unmatchedB == null) {
			unmatchedB = new EObjectResolvingEList<EObject>(EObject.class, this, DifferencePackage.DIFFERENCE__UNMATCHED_B);
		}
		return unmatchedB;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public Resource getEResourceA() {
		if (eResourceA == null) {

			if (!getCorrespondences().isEmpty()) {
				eResourceA = getCorrespondences().get(0).getMatchedA().eResource();
			} else if (!getUnmatchedA().isEmpty()) {
				eResourceA = getUnmatchedA().get(0).eResource();
			}

			if (eResourceA == null) {
				URI modelURI = URI.createURI(getUriModelA());
				if (modelURI.isRelative() && this.eResource() != null) {
					modelURI = this.eResource().getURI().trimSegments(1).appendSegment(getUriModelA());
				}
				ResourceSet resourceSet = null;
				if (this.eResource() == null) {
					resourceSet = new ResourceSetImpl();
				} else {
					resourceSet = this.eResource().getResourceSet();
				}
				eResourceA = resourceSet.getResource(modelURI, true);
			}
		}

		return eResourceA;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setEResourceA(Resource newEResourceA) {
		Resource oldEResourceA = eResourceA;
		eResourceA = newEResourceA;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DifferencePackage.DIFFERENCE__ERESOURCE_A, oldEResourceA, eResourceA));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public Resource getEResourceB() {
		if (eResourceB == null) {

			if (!getCorrespondences().isEmpty()) {
				eResourceB = getCorrespondences().get(0).getMatchedB().eResource();
			} else if (!getUnmatchedB().isEmpty()) {
				eResourceB = getUnmatchedB().get(0).eResource();
			}

			if (eResourceB == null) {
				URI modelURI = URI.createURI(getUriModelB());
				if (modelURI.isRelative() && this.eResource() != null) {
					modelURI = this.eResource().getURI().trimSegments(1).appendSegment(getUriModelB());
				}
				ResourceSet resourceSet = null;
				if (this.eResource() == null) {
					resourceSet = new ResourceSetImpl();
				} else {
					resourceSet = this.eResource().getResourceSet();
				}
				eResourceB = resourceSet.getResource(modelURI, true);
			}
		}

		return eResourceB;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setEResourceB(Resource newEResourceB) {
		Resource oldEResourceB = eResourceB;
		eResourceB = newEResourceB;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DifferencePackage.DIFFERENCE__ERESOURCE_B, oldEResourceB, eResourceB));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public EObject getCorrespondingObjectInA(EObject objectInB) {
		Correspondence correspondence = correspondencesB.get(objectInB);
		
		if (correspondence != null) {
			return correspondence.getMatchedA();
		} else {
			return null;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public EObject getCorrespondingObjectInB(EObject objectInA) {
		Correspondence correspondence = correspondencesA.get(objectInA);
		
		if (correspondence != null) {
			return correspondence.getMatchedB();
		} else {
			return null;
		}
	}

	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Correspondence getCorrespondenceOfModelA(EObject objectInA) {
		return correspondencesA.get(objectInA);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Correspondence getCorrespondenceOfModelB(EObject objectInB) {
		return correspondencesB.get(objectInB);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void addCorrespondence(Correspondence correspondence) {
		
		this.getCorrespondences().add(correspondence);
		this.correspondencesA.put(correspondence.getMatchedA(), correspondence);
		this.correspondencesB.put(correspondence.getMatchedB(), correspondence);

	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void removeCorrespondence(Correspondence correspondence) {
		
		this.getCorrespondences().remove(correspondence);
		this.correspondencesA.remove(correspondence.getMatchedA());
		this.correspondencesB.remove(correspondence.getMatchedB());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DifferencePackage.DIFFERENCE__CHANGES:
				return ((InternalEList<?>)getChanges()).basicRemove(otherEnd, msgs);
			case DifferencePackage.DIFFERENCE__CORRESPONDENCES:
				return ((InternalEList<?>)getCorrespondences()).basicRemove(otherEnd, msgs);
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
			case DifferencePackage.DIFFERENCE__CHANGES:
				return getChanges();
			case DifferencePackage.DIFFERENCE__MODEL_A:
				return getModelA();
			case DifferencePackage.DIFFERENCE__MODEL_B:
				return getModelB();
			case DifferencePackage.DIFFERENCE__URI_MODEL_A:
				return getUriModelA();
			case DifferencePackage.DIFFERENCE__URI_MODEL_B:
				return getUriModelB();
			case DifferencePackage.DIFFERENCE__CORRESPONDENCES:
				return getCorrespondences();
			case DifferencePackage.DIFFERENCE__UNMATCHED_A:
				return getUnmatchedA();
			case DifferencePackage.DIFFERENCE__UNMATCHED_B:
				return getUnmatchedB();
			case DifferencePackage.DIFFERENCE__ERESOURCE_A:
				return getEResourceA();
			case DifferencePackage.DIFFERENCE__ERESOURCE_B:
				return getEResourceB();
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
			case DifferencePackage.DIFFERENCE__CHANGES:
				getChanges().clear();
				getChanges().addAll((Collection<? extends Change>)newValue);
				return;
			case DifferencePackage.DIFFERENCE__URI_MODEL_A:
				setUriModelA((String)newValue);
				return;
			case DifferencePackage.DIFFERENCE__URI_MODEL_B:
				setUriModelB((String)newValue);
				return;
			case DifferencePackage.DIFFERENCE__CORRESPONDENCES:
				getCorrespondences().clear();
				getCorrespondences().addAll((Collection<? extends Correspondence>)newValue);
				return;
			case DifferencePackage.DIFFERENCE__UNMATCHED_A:
				getUnmatchedA().clear();
				getUnmatchedA().addAll((Collection<? extends EObject>)newValue);
				return;
			case DifferencePackage.DIFFERENCE__UNMATCHED_B:
				getUnmatchedB().clear();
				getUnmatchedB().addAll((Collection<? extends EObject>)newValue);
				return;
			case DifferencePackage.DIFFERENCE__ERESOURCE_A:
				setEResourceA((Resource)newValue);
				return;
			case DifferencePackage.DIFFERENCE__ERESOURCE_B:
				setEResourceB((Resource)newValue);
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
			case DifferencePackage.DIFFERENCE__CHANGES:
				getChanges().clear();
				return;
			case DifferencePackage.DIFFERENCE__URI_MODEL_A:
				setUriModelA(URI_MODEL_A_EDEFAULT);
				return;
			case DifferencePackage.DIFFERENCE__URI_MODEL_B:
				setUriModelB(URI_MODEL_B_EDEFAULT);
				return;
			case DifferencePackage.DIFFERENCE__CORRESPONDENCES:
				getCorrespondences().clear();
				return;
			case DifferencePackage.DIFFERENCE__UNMATCHED_A:
				getUnmatchedA().clear();
				return;
			case DifferencePackage.DIFFERENCE__UNMATCHED_B:
				getUnmatchedB().clear();
				return;
			case DifferencePackage.DIFFERENCE__ERESOURCE_A:
				setEResourceA(ERESOURCE_A_EDEFAULT);
				return;
			case DifferencePackage.DIFFERENCE__ERESOURCE_B:
				setEResourceB(ERESOURCE_B_EDEFAULT);
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
			case DifferencePackage.DIFFERENCE__CHANGES:
				return changes != null && !changes.isEmpty();
			case DifferencePackage.DIFFERENCE__MODEL_A:
				return MODEL_A_EDEFAULT == null ? getModelA() != null : !MODEL_A_EDEFAULT.equals(getModelA());
			case DifferencePackage.DIFFERENCE__MODEL_B:
				return MODEL_B_EDEFAULT == null ? getModelB() != null : !MODEL_B_EDEFAULT.equals(getModelB());
			case DifferencePackage.DIFFERENCE__URI_MODEL_A:
				return URI_MODEL_A_EDEFAULT == null ? uriModelA != null : !URI_MODEL_A_EDEFAULT.equals(uriModelA);
			case DifferencePackage.DIFFERENCE__URI_MODEL_B:
				return URI_MODEL_B_EDEFAULT == null ? uriModelB != null : !URI_MODEL_B_EDEFAULT.equals(uriModelB);
			case DifferencePackage.DIFFERENCE__CORRESPONDENCES:
				return correspondences != null && !correspondences.isEmpty();
			case DifferencePackage.DIFFERENCE__UNMATCHED_A:
				return unmatchedA != null && !unmatchedA.isEmpty();
			case DifferencePackage.DIFFERENCE__UNMATCHED_B:
				return unmatchedB != null && !unmatchedB.isEmpty();
			case DifferencePackage.DIFFERENCE__ERESOURCE_A:
				return ERESOURCE_A_EDEFAULT == null ? eResourceA != null : !ERESOURCE_A_EDEFAULT.equals(eResourceA);
			case DifferencePackage.DIFFERENCE__ERESOURCE_B:
				return ERESOURCE_B_EDEFAULT == null ? eResourceB != null : !ERESOURCE_B_EDEFAULT.equals(eResourceB);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (uriModelA: ");
		result.append(uriModelA);
		result.append(", uriModelB: ");
		result.append(uriModelB);
		result.append(", eResourceA: ");
		result.append(eResourceA);
		result.append(", eResourceB: ");
		result.append(eResourceB);
		result.append(')');
		return result.toString();
	}

	private void initCorrespondenceIndex() {
		correspondencesA = new HashMap<EObject, Correspondence>();
		correspondencesB = new HashMap<EObject, Correspondence>();
	}
	
} // DifferenceImpl