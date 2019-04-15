/**
 */
package org.sidiff.matching.model.impl;

import java.util.Collection;

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
import org.sidiff.common.stringresolver.util.LabelPrinter;
import org.sidiff.matching.model.Correspondence;
import org.sidiff.matching.model.Matching;
import org.sidiff.matching.model.MatchingModelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Matching</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.matching.model.impl.MatchingImpl#getCorrespondences <em>Correspondences</em>}</li>
 *   <li>{@link org.sidiff.matching.model.impl.MatchingImpl#getUnmatchedA <em>Unmatched A</em>}</li>
 *   <li>{@link org.sidiff.matching.model.impl.MatchingImpl#getUnmatchedB <em>Unmatched B</em>}</li>
 *   <li>{@link org.sidiff.matching.model.impl.MatchingImpl#getEResourceA <em>EResource A</em>}</li>
 *   <li>{@link org.sidiff.matching.model.impl.MatchingImpl#getEResourceB <em>EResource B</em>}</li>
 *   <li>{@link org.sidiff.matching.model.impl.MatchingImpl#getUriA <em>Uri A</em>}</li>
 *   <li>{@link org.sidiff.matching.model.impl.MatchingImpl#getUriB <em>Uri B</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MatchingImpl extends EObjectImpl implements Matching {
	
	/**
	 * Generates human readable strings for the changes 
	 * 
	 * @generated NOT
	 */
	private LabelPrinter labelPrinter;
	
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
	 * The default value of the '{@link #getUriA() <em>Uri A</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUriA()
	 * @generated
	 * @ordered
	 */
	protected static final String URI_A_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getUriA() <em>Uri A</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUriA()
	 * @generated
	 * @ordered
	 */
	protected String uriA = URI_A_EDEFAULT;

	/**
	 * The default value of the '{@link #getUriB() <em>Uri B</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUriB()
	 * @generated
	 * @ordered
	 */
	protected static final String URI_B_EDEFAULT = "";

	

	/**
	 * The cached value of the '{@link #getUriB() <em>Uri B</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUriB()
	 * @generated
	 * @ordered
	 */
	protected String uriB = URI_B_EDEFAULT;



	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MatchingImpl() {
		super();
	}



	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MatchingModelPackage.Literals.MATCHING;
	}

	

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Correspondence> getCorrespondences() {
		if (correspondences == null) {
			correspondences = new EObjectContainmentEList<Correspondence>(Correspondence.class, this, MatchingModelPackage.MATCHING__CORRESPONDENCES);
		}
		return correspondences;
	}



	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EObject> getUnmatchedA() {
		if (unmatchedA == null) {
			unmatchedA = new EObjectResolvingEList<EObject>(EObject.class, this, MatchingModelPackage.MATCHING__UNMATCHED_A);
		}
		return unmatchedA;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EObject> getUnmatchedB() {
		if (unmatchedB == null) {
			unmatchedB = new EObjectResolvingEList<EObject>(EObject.class, this, MatchingModelPackage.MATCHING__UNMATCHED_B);
		}
		return unmatchedB;
	}

	 /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    public Resource getEResourceA() {
        if (eResourceA == null) {

            if (!getCorrespondences().isEmpty()) {
                eResourceA = getCorrespondences().get(0).getMatchedA().eResource();
            }else if(!getUnmatchedA().isEmpty()) {
            	eResourceA = getUnmatchedA().get(0).eResource();
            }

            if (eResourceA == null) {
            	URI modelURI = URI.createURI(getUriA());
            	if(modelURI.isRelative() && this.eResource() != null) {
            		modelURI = this.eResource().getURI().trimSegments(1).appendSegment(getUriA());
            	}
            	ResourceSet resourceSet = null;
            	if(this.eResource() == null) {
            		resourceSet = new ResourceSetImpl();
            	}else {
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
	public void setEResourceA(Resource newEResourceA) {
		Resource oldEResourceA = eResourceA;
		eResourceA = newEResourceA;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MatchingModelPackage.MATCHING__ERESOURCE_A, oldEResourceA, eResourceA));
	}



	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    public Resource getEResourceB() {
        if (eResourceB == null) {

            if (!getCorrespondences().isEmpty()) {
                eResourceB = getCorrespondences().get(0).getMatchedB().eResource();
            } else if(!getUnmatchedB().isEmpty()) {
            	eResourceB = getUnmatchedB().get(0).eResource();
            }

            if (eResourceB == null) {
            	URI modelURI = URI.createURI(getUriB());
            	if(modelURI.isRelative() && this.eResource() != null) {
            		modelURI = this.eResource().getURI().trimSegments(1).appendSegment(getUriB());
            	}
            	ResourceSet resourceSet = null;
            	if(this.eResource() == null) {
            		resourceSet = new ResourceSetImpl();
            	}else {
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
	public void setEResourceB(Resource newEResourceB) {
		Resource oldEResourceB = eResourceB;
		eResourceB = newEResourceB;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MatchingModelPackage.MATCHING__ERESOURCE_B, oldEResourceB, eResourceB));
	}



	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUriA() {
		return uriA;
	}



	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUriA(String newUriA) {
		String oldUriA = uriA;
		uriA = newUriA;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MatchingModelPackage.MATCHING__URI_A, oldUriA, uriA));
	}



	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUriB() {
		return uriB;
	}



	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUriB(String newUriB) {
		String oldUriB = uriB;
		uriB = newUriB;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MatchingModelPackage.MATCHING__URI_B, oldUriB, uriB));
	}



	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MatchingModelPackage.MATCHING__CORRESPONDENCES:
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
			case MatchingModelPackage.MATCHING__CORRESPONDENCES:
				return getCorrespondences();
			case MatchingModelPackage.MATCHING__UNMATCHED_A:
				return getUnmatchedA();
			case MatchingModelPackage.MATCHING__UNMATCHED_B:
				return getUnmatchedB();
			case MatchingModelPackage.MATCHING__ERESOURCE_A:
				return getEResourceA();
			case MatchingModelPackage.MATCHING__ERESOURCE_B:
				return getEResourceB();
			case MatchingModelPackage.MATCHING__URI_A:
				return getUriA();
			case MatchingModelPackage.MATCHING__URI_B:
				return getUriB();
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
			case MatchingModelPackage.MATCHING__CORRESPONDENCES:
				getCorrespondences().clear();
				getCorrespondences().addAll((Collection<? extends Correspondence>)newValue);
				return;
			case MatchingModelPackage.MATCHING__UNMATCHED_A:
				getUnmatchedA().clear();
				getUnmatchedA().addAll((Collection<? extends EObject>)newValue);
				return;
			case MatchingModelPackage.MATCHING__UNMATCHED_B:
				getUnmatchedB().clear();
				getUnmatchedB().addAll((Collection<? extends EObject>)newValue);
				return;
			case MatchingModelPackage.MATCHING__ERESOURCE_A:
				setEResourceA((Resource)newValue);
				return;
			case MatchingModelPackage.MATCHING__ERESOURCE_B:
				setEResourceB((Resource)newValue);
				return;
			case MatchingModelPackage.MATCHING__URI_A:
				setUriA((String)newValue);
				return;
			case MatchingModelPackage.MATCHING__URI_B:
				setUriB((String)newValue);
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
			case MatchingModelPackage.MATCHING__CORRESPONDENCES:
				getCorrespondences().clear();
				return;
			case MatchingModelPackage.MATCHING__UNMATCHED_A:
				getUnmatchedA().clear();
				return;
			case MatchingModelPackage.MATCHING__UNMATCHED_B:
				getUnmatchedB().clear();
				return;
			case MatchingModelPackage.MATCHING__ERESOURCE_A:
				setEResourceA(ERESOURCE_A_EDEFAULT);
				return;
			case MatchingModelPackage.MATCHING__ERESOURCE_B:
				setEResourceB(ERESOURCE_B_EDEFAULT);
				return;
			case MatchingModelPackage.MATCHING__URI_A:
				setUriA(URI_A_EDEFAULT);
				return;
			case MatchingModelPackage.MATCHING__URI_B:
				setUriB(URI_B_EDEFAULT);
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
			case MatchingModelPackage.MATCHING__CORRESPONDENCES:
				return correspondences != null && !correspondences.isEmpty();
			case MatchingModelPackage.MATCHING__UNMATCHED_A:
				return unmatchedA != null && !unmatchedA.isEmpty();
			case MatchingModelPackage.MATCHING__UNMATCHED_B:
				return unmatchedB != null && !unmatchedB.isEmpty();
			case MatchingModelPackage.MATCHING__ERESOURCE_A:
				return ERESOURCE_A_EDEFAULT == null ? eResourceA != null : !ERESOURCE_A_EDEFAULT.equals(eResourceA);
			case MatchingModelPackage.MATCHING__ERESOURCE_B:
				return ERESOURCE_B_EDEFAULT == null ? eResourceB != null : !ERESOURCE_B_EDEFAULT.equals(eResourceB);
			case MatchingModelPackage.MATCHING__URI_A:
				return URI_A_EDEFAULT == null ? uriA != null : !URI_A_EDEFAULT.equals(uriA);
			case MatchingModelPackage.MATCHING__URI_B:
				return URI_B_EDEFAULT == null ? uriB != null : !URI_B_EDEFAULT.equals(uriB);
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

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (eResourceA: ");
		result.append(eResourceA);
		result.append(", eResourceB: ");
		result.append(eResourceB);
		result.append(", uriA: ");
		result.append(uriA);
		result.append(", uriB: ");
		result.append(uriB);
		result.append(')');
		return result.toString();
	}

	/**
	 * @return The label printer of this difference which generates human
	 *         readable strings for the changes.
	 *         
	 * @generated NOT
	 */
	public LabelPrinter getLabelPrinter() {

		if (labelPrinter == null) {
			labelPrinter = new LabelPrinter(getEResourceA());
		}

		return labelPrinter;
	}

} //MatchingImpl
