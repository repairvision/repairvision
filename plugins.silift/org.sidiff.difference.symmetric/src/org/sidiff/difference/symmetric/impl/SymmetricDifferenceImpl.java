/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.sidiff.difference.symmetric.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.sidiff.common.stringresolver.util.LabelPrinter;
import org.sidiff.difference.symmetric.Change;
import org.sidiff.difference.symmetric.SemanticChangeSet;
import org.sidiff.difference.symmetric.SymmetricDifference;
import org.sidiff.difference.symmetric.SymmetricPackage;
import org.sidiff.matching.model.Correspondence;
import org.sidiff.matching.model.Matching;

/**
 * <!-- begin-user-doc --> 
 * An implementation of the model object '<em><b>Difference</b></em>'. 
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.difference.symmetric.impl.SymmetricDifferenceImpl#getChanges <em>Changes</em>}</li>
 *   <li>{@link org.sidiff.difference.symmetric.impl.SymmetricDifferenceImpl#getChangeSets <em>Change Sets</em>}</li>
 *   <li>{@link org.sidiff.difference.symmetric.impl.SymmetricDifferenceImpl#getModelA <em>Model A</em>}</li>
 *   <li>{@link org.sidiff.difference.symmetric.impl.SymmetricDifferenceImpl#getModelB <em>Model B</em>}</li>
 *   <li>{@link org.sidiff.difference.symmetric.impl.SymmetricDifferenceImpl#getUriModelA <em>Uri Model A</em>}</li>
 *   <li>{@link org.sidiff.difference.symmetric.impl.SymmetricDifferenceImpl#getUriModelB <em>Uri Model B</em>}</li>
 *   <li>{@link org.sidiff.difference.symmetric.impl.SymmetricDifferenceImpl#getNotOverlappings <em>Not Overlappings</em>}</li>
 *   <li>{@link org.sidiff.difference.symmetric.impl.SymmetricDifferenceImpl#getUnusedChangeSets <em>Unused Change Sets</em>}</li>
 *   <li>{@link org.sidiff.difference.symmetric.impl.SymmetricDifferenceImpl#getMatching <em>Matching</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SymmetricDifferenceImpl extends EObjectImpl implements SymmetricDifference {

	/**
	 * Generates human readable strings for the changes 
	 * 
	 * @generated NOT
	 */
	private LabelPrinter labelPrinter;
	
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
	 * The cached value of the '{@link #getChangeSets() <em>Change Sets</em>}' containment reference list.
	 * <!-- begin-user-doc --> 
	 * <!-- end-user-doc -->
	 * @see #getChangeSets()
	 * @generated
	 * @ordered
	 */
	protected EList<SemanticChangeSet> changeSets;

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
	 * The cached value of the '{@link #getNotOverlappings() <em>Not Overlappings</em>}' reference list.
	 * <!-- begin-user-doc --> 
	 * <!-- end-user-doc -->
	 * @see #getNotOverlappings()
	 * @generated
	 * @ordered
	 */
	protected EList<SemanticChangeSet> notOverlappings;

	/**
	 * The cached value of the '{@link #getUnusedChangeSets() <em>Unused Change Sets</em>}' containment reference list.
	 * <!-- begin-user-doc --> 
	 * <!-- end-user-doc -->
	 * @see #getUnusedChangeSets()
	 * @generated
	 * @ordered
	 */
	protected EList<SemanticChangeSet> unusedChangeSets;

	/**
	 * The cached value of the '{@link #getMatching() <em>Matching</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMatching()
	 * @generated
	 * @ordered
	 */
	protected Matching matching;

	/**
	 * <!-- begin-user-doc --> 
	 * <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	protected SymmetricDifferenceImpl() {
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
		return SymmetricPackage.Literals.SYMMETRIC_DIFFERENCE;
	}

	/**
	 * <!-- begin-user-doc --> 
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Change> getChanges() {
		if (changes == null) {
			changes = new EObjectContainmentEList<Change>(Change.class, this, SymmetricPackage.SYMMETRIC_DIFFERENCE__CHANGES);
		}
		return changes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SemanticChangeSet> getChangeSets() {
		if (changeSets == null) {
			changeSets = new EObjectContainmentEList<SemanticChangeSet>(SemanticChangeSet.class, this, SymmetricPackage.SYMMETRIC_DIFFERENCE__CHANGE_SETS);
		}
		return changeSets;
	}


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public Resource getModelA() {
		return getMatching().getEResourceA();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public Resource getModelB() {
		return getMatching().getEResourceB();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUriModelA() {
		return uriModelA;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUriModelA(String newUriModelA) {
		String oldUriModelA = uriModelA;
		uriModelA = newUriModelA;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SymmetricPackage.SYMMETRIC_DIFFERENCE__URI_MODEL_A, oldUriModelA, uriModelA));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUriModelB() {
		return uriModelB;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUriModelB(String newUriModelB) {
		String oldUriModelB = uriModelB;
		uriModelB = newUriModelB;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SymmetricPackage.SYMMETRIC_DIFFERENCE__URI_MODEL_B, oldUriModelB, uriModelB));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SemanticChangeSet> getNotOverlappings() {
		if (notOverlappings == null) {
			notOverlappings = new EObjectResolvingEList<SemanticChangeSet>(SemanticChangeSet.class, this, SymmetricPackage.SYMMETRIC_DIFFERENCE__NOT_OVERLAPPINGS);
		}
		return notOverlappings;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SemanticChangeSet> getUnusedChangeSets() {
		if (unusedChangeSets == null) {
			unusedChangeSets = new EObjectContainmentEList<SemanticChangeSet>(SemanticChangeSet.class, this, SymmetricPackage.SYMMETRIC_DIFFERENCE__UNUSED_CHANGE_SETS);
		}
		return unusedChangeSets;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Matching getMatching() {
		return matching;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMatching(Matching newMatching, NotificationChain msgs) {
		Matching oldMatching = matching;
		matching = newMatching;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SymmetricPackage.SYMMETRIC_DIFFERENCE__MATCHING, oldMatching, newMatching);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setMatching(Matching newMatching) {
		if (newMatching != matching) {
			NotificationChain msgs = null;
			if (matching != null)
				msgs = ((InternalEObject)matching).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SymmetricPackage.SYMMETRIC_DIFFERENCE__MATCHING, null, msgs);
			if (newMatching != null)
				msgs = ((InternalEObject)newMatching).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SymmetricPackage.SYMMETRIC_DIFFERENCE__MATCHING, null, msgs);
			msgs = basicSetMatching(newMatching, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SymmetricPackage.SYMMETRIC_DIFFERENCE__MATCHING, newMatching, newMatching));

		this.setUriModelA(matching.getUriA());
		this.setUriModelB(matching.getUriB());

		//Init indexed correspondences
		for(Correspondence c : matching.getCorrespondences()){
			this.correspondencesA.put(c.getMatchedA(), c);
			this.correspondencesB.put(c.getMatchedB(), c);
		}
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
		
		this.getMatching().getCorrespondences().add(correspondence);
		this.correspondencesA.put(correspondence.getMatchedA(), correspondence);
		this.correspondencesB.put(correspondence.getMatchedB(), correspondence);

	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void removeCorrespondence(Correspondence correspondence) {
		
		this.getMatching().getCorrespondences().remove(correspondence);
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
			case SymmetricPackage.SYMMETRIC_DIFFERENCE__CHANGES:
				return ((InternalEList<?>)getChanges()).basicRemove(otherEnd, msgs);
			case SymmetricPackage.SYMMETRIC_DIFFERENCE__CHANGE_SETS:
				return ((InternalEList<?>)getChangeSets()).basicRemove(otherEnd, msgs);
			case SymmetricPackage.SYMMETRIC_DIFFERENCE__UNUSED_CHANGE_SETS:
				return ((InternalEList<?>)getUnusedChangeSets()).basicRemove(otherEnd, msgs);
			case SymmetricPackage.SYMMETRIC_DIFFERENCE__MATCHING:
				return basicSetMatching(null, msgs);
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
			case SymmetricPackage.SYMMETRIC_DIFFERENCE__CHANGES:
				return getChanges();
			case SymmetricPackage.SYMMETRIC_DIFFERENCE__CHANGE_SETS:
				return getChangeSets();
			case SymmetricPackage.SYMMETRIC_DIFFERENCE__MODEL_A:
				return getModelA();
			case SymmetricPackage.SYMMETRIC_DIFFERENCE__MODEL_B:
				return getModelB();
			case SymmetricPackage.SYMMETRIC_DIFFERENCE__URI_MODEL_A:
				return getUriModelA();
			case SymmetricPackage.SYMMETRIC_DIFFERENCE__URI_MODEL_B:
				return getUriModelB();
			case SymmetricPackage.SYMMETRIC_DIFFERENCE__NOT_OVERLAPPINGS:
				return getNotOverlappings();
			case SymmetricPackage.SYMMETRIC_DIFFERENCE__UNUSED_CHANGE_SETS:
				return getUnusedChangeSets();
			case SymmetricPackage.SYMMETRIC_DIFFERENCE__MATCHING:
				return getMatching();
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
			case SymmetricPackage.SYMMETRIC_DIFFERENCE__CHANGES:
				getChanges().clear();
				getChanges().addAll((Collection<? extends Change>)newValue);
				return;
			case SymmetricPackage.SYMMETRIC_DIFFERENCE__CHANGE_SETS:
				getChangeSets().clear();
				getChangeSets().addAll((Collection<? extends SemanticChangeSet>)newValue);
				return;
			case SymmetricPackage.SYMMETRIC_DIFFERENCE__URI_MODEL_A:
				setUriModelA((String)newValue);
				return;
			case SymmetricPackage.SYMMETRIC_DIFFERENCE__URI_MODEL_B:
				setUriModelB((String)newValue);
				return;
			case SymmetricPackage.SYMMETRIC_DIFFERENCE__NOT_OVERLAPPINGS:
				getNotOverlappings().clear();
				getNotOverlappings().addAll((Collection<? extends SemanticChangeSet>)newValue);
				return;
			case SymmetricPackage.SYMMETRIC_DIFFERENCE__UNUSED_CHANGE_SETS:
				getUnusedChangeSets().clear();
				getUnusedChangeSets().addAll((Collection<? extends SemanticChangeSet>)newValue);
				return;
			case SymmetricPackage.SYMMETRIC_DIFFERENCE__MATCHING:
				setMatching((Matching)newValue);
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
			case SymmetricPackage.SYMMETRIC_DIFFERENCE__CHANGES:
				getChanges().clear();
				return;
			case SymmetricPackage.SYMMETRIC_DIFFERENCE__CHANGE_SETS:
				getChangeSets().clear();
				return;
			case SymmetricPackage.SYMMETRIC_DIFFERENCE__URI_MODEL_A:
				setUriModelA(URI_MODEL_A_EDEFAULT);
				return;
			case SymmetricPackage.SYMMETRIC_DIFFERENCE__URI_MODEL_B:
				setUriModelB(URI_MODEL_B_EDEFAULT);
				return;
			case SymmetricPackage.SYMMETRIC_DIFFERENCE__NOT_OVERLAPPINGS:
				getNotOverlappings().clear();
				return;
			case SymmetricPackage.SYMMETRIC_DIFFERENCE__UNUSED_CHANGE_SETS:
				getUnusedChangeSets().clear();
				return;
			case SymmetricPackage.SYMMETRIC_DIFFERENCE__MATCHING:
				setMatching((Matching)null);
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
			case SymmetricPackage.SYMMETRIC_DIFFERENCE__CHANGES:
				return changes != null && !changes.isEmpty();
			case SymmetricPackage.SYMMETRIC_DIFFERENCE__CHANGE_SETS:
				return changeSets != null && !changeSets.isEmpty();
			case SymmetricPackage.SYMMETRIC_DIFFERENCE__MODEL_A:
				return MODEL_A_EDEFAULT == null ? getModelA() != null : !MODEL_A_EDEFAULT.equals(getModelA());
			case SymmetricPackage.SYMMETRIC_DIFFERENCE__MODEL_B:
				return MODEL_B_EDEFAULT == null ? getModelB() != null : !MODEL_B_EDEFAULT.equals(getModelB());
			case SymmetricPackage.SYMMETRIC_DIFFERENCE__URI_MODEL_A:
				return URI_MODEL_A_EDEFAULT == null ? uriModelA != null : !URI_MODEL_A_EDEFAULT.equals(uriModelA);
			case SymmetricPackage.SYMMETRIC_DIFFERENCE__URI_MODEL_B:
				return URI_MODEL_B_EDEFAULT == null ? uriModelB != null : !URI_MODEL_B_EDEFAULT.equals(uriModelB);
			case SymmetricPackage.SYMMETRIC_DIFFERENCE__NOT_OVERLAPPINGS:
				return notOverlappings != null && !notOverlappings.isEmpty();
			case SymmetricPackage.SYMMETRIC_DIFFERENCE__UNUSED_CHANGE_SETS:
				return unusedChangeSets != null && !unusedChangeSets.isEmpty();
			case SymmetricPackage.SYMMETRIC_DIFFERENCE__MATCHING:
				return matching != null;
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
		result.append(" (uriModelA: ");
		result.append(uriModelA);
		result.append(", uriModelB: ");
		result.append(uriModelB);
		result.append(')');
		return result.toString();
	}

	// init correspondence index
	private void initCorrespondenceIndex() {
		correspondencesA = new HashMap<EObject, Correspondence>();
		correspondencesB = new HashMap<EObject, Correspondence>();
	}
	
	/**
	 * @return The label printer of this difference which generates human
	 *         readable strings for the changes.
	 *         
	 * @generated NOT
	 */
	public LabelPrinter getLabelPrinter() {

		if (labelPrinter == null) {
			labelPrinter = new LabelPrinter(getModelA());
		}

		return labelPrinter;
	}

} // SymmetricDifferenceImpl
