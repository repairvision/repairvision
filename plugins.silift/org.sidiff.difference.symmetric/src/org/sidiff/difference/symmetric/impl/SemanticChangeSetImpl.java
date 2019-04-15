/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.sidiff.difference.symmetric.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.sidiff.difference.symmetric.Change;
import org.sidiff.difference.symmetric.EditRuleMatch;
import org.sidiff.difference.symmetric.FragmentJoin;
import org.sidiff.difference.symmetric.FragmentSplit;
import org.sidiff.difference.symmetric.SemanticChangeSet;
import org.sidiff.difference.symmetric.SymmetricPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Semantic Change Set</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.difference.symmetric.impl.SemanticChangeSetImpl#getChanges <em>Changes</em>}</li>
 *   <li>{@link org.sidiff.difference.symmetric.impl.SemanticChangeSetImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.sidiff.difference.symmetric.impl.SemanticChangeSetImpl#getPriority <em>Priority</em>}</li>
 *   <li>{@link org.sidiff.difference.symmetric.impl.SemanticChangeSetImpl#getRecognitionRName <em>Recognition RName</em>}</li>
 *   <li>{@link org.sidiff.difference.symmetric.impl.SemanticChangeSetImpl#getRefinementLevel <em>Refinement Level</em>}</li>
 *   <li>{@link org.sidiff.difference.symmetric.impl.SemanticChangeSetImpl#getEditRName <em>Edit RName</em>}</li>
 *   <li>{@link org.sidiff.difference.symmetric.impl.SemanticChangeSetImpl#getPartiallyOverlappings <em>Partially Overlappings</em>}</li>
 *   <li>{@link org.sidiff.difference.symmetric.impl.SemanticChangeSetImpl#getSubsets <em>Subsets</em>}</li>
 *   <li>{@link org.sidiff.difference.symmetric.impl.SemanticChangeSetImpl#getSupersets <em>Supersets</em>}</li>
 *   <li>{@link org.sidiff.difference.symmetric.impl.SemanticChangeSetImpl#getOverlayings <em>Overlayings</em>}</li>
 *   <li>{@link org.sidiff.difference.symmetric.impl.SemanticChangeSetImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.sidiff.difference.symmetric.impl.SemanticChangeSetImpl#getNumberOfACs <em>Number Of ACs</em>}</li>
 *   <li>{@link org.sidiff.difference.symmetric.impl.SemanticChangeSetImpl#getNumberOfParams <em>Number Of Params</em>}</li>
 *   <li>{@link org.sidiff.difference.symmetric.impl.SemanticChangeSetImpl#getEditRuleMatch <em>Edit Rule Match</em>}</li>
 *   <li>{@link org.sidiff.difference.symmetric.impl.SemanticChangeSetImpl#getJoins <em>Joins</em>}</li>
 *   <li>{@link org.sidiff.difference.symmetric.impl.SemanticChangeSetImpl#getSplits <em>Splits</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SemanticChangeSetImpl extends EObjectImpl implements SemanticChangeSet {
	/**
	 * The cached value of the '{@link #getChanges() <em>Changes</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChanges()
	 * @generated
	 * @ordered
	 */
	protected EList<Change> changes;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getPriority() <em>Priority</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPriority()
	 * @generated
	 * @ordered
	 */
	protected static final int PRIORITY_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getPriority() <em>Priority</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPriority()
	 * @generated
	 * @ordered
	 */
	protected int priority = PRIORITY_EDEFAULT;

	/**
	 * The default value of the '{@link #getRecognitionRName() <em>Recognition RName</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRecognitionRName()
	 * @generated
	 * @ordered
	 */
	protected static final String RECOGNITION_RNAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRecognitionRName() <em>Recognition RName</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRecognitionRName()
	 * @generated
	 * @ordered
	 */
	protected String recognitionRName = RECOGNITION_RNAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getRefinementLevel() <em>Refinement Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRefinementLevel()
	 * @generated
	 * @ordered
	 */
	protected static final int REFINEMENT_LEVEL_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getRefinementLevel() <em>Refinement Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRefinementLevel()
	 * @generated
	 * @ordered
	 */
	protected int refinementLevel = REFINEMENT_LEVEL_EDEFAULT;

	/**
	 * The default value of the '{@link #getEditRName() <em>Edit RName</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEditRName()
	 * @generated
	 * @ordered
	 */
	protected static final String EDIT_RNAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getEditRName() <em>Edit RName</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEditRName()
	 * @generated
	 * @ordered
	 */
	protected String editRName = EDIT_RNAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getPartiallyOverlappings() <em>Partially Overlappings</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPartiallyOverlappings()
	 * @generated
	 * @ordered
	 */
	protected EList<SemanticChangeSet> partiallyOverlappings;

	/**
	 * The cached value of the '{@link #getSubsets() <em>Subsets</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubsets()
	 * @generated
	 * @ordered
	 */
	protected EList<SemanticChangeSet> subsets;

	/**
	 * The cached value of the '{@link #getSupersets() <em>Supersets</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSupersets()
	 * @generated
	 * @ordered
	 */
	protected EList<SemanticChangeSet> supersets;

	/**
	 * The cached value of the '{@link #getOverlayings() <em>Overlayings</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOverlayings()
	 * @generated
	 * @ordered
	 */
	protected EList<SemanticChangeSet> overlayings;

	/**
	 * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected String description = DESCRIPTION_EDEFAULT;

	/**
	 * The default value of the '{@link #getNumberOfACs() <em>Number Of ACs</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumberOfACs()
	 * @generated
	 * @ordered
	 */
	protected static final int NUMBER_OF_ACS_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getNumberOfACs() <em>Number Of ACs</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumberOfACs()
	 * @generated
	 * @ordered
	 */
	protected int numberOfACs = NUMBER_OF_ACS_EDEFAULT;

	/**
	 * The default value of the '{@link #getNumberOfParams() <em>Number Of Params</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumberOfParams()
	 * @generated
	 * @ordered
	 */
	protected static final int NUMBER_OF_PARAMS_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getNumberOfParams() <em>Number Of Params</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumberOfParams()
	 * @generated
	 * @ordered
	 */
	protected int numberOfParams = NUMBER_OF_PARAMS_EDEFAULT;

	/**
	 * The cached value of the '{@link #getEditRuleMatch() <em>Edit Rule Match</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEditRuleMatch()
	 * @generated
	 * @ordered
	 */
	protected EditRuleMatch editRuleMatch;

	/**
	 * The cached value of the '{@link #getJoins() <em>Joins</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getJoins()
	 * @generated
	 * @ordered
	 */
	protected EList<FragmentJoin> joins;

	/**
	 * The cached value of the '{@link #getSplits() <em>Splits</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSplits()
	 * @generated
	 * @ordered
	 */
	protected EList<FragmentSplit> splits;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SemanticChangeSetImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SymmetricPackage.Literals.SEMANTIC_CHANGE_SET;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Change> getChanges() {
		if (changes == null) {
			changes = new EObjectResolvingEList<Change>(Change.class, this, SymmetricPackage.SEMANTIC_CHANGE_SET__CHANGES);
		}
		return changes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SymmetricPackage.SEMANTIC_CHANGE_SET__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getPriority() {
		return priority;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPriority(int newPriority) {
		int oldPriority = priority;
		priority = newPriority;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SymmetricPackage.SEMANTIC_CHANGE_SET__PRIORITY, oldPriority, priority));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getRefinementLevel() {
		return refinementLevel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRefinementLevel(int newRefinementLevel) {
		int oldRefinementLevel = refinementLevel;
		refinementLevel = newRefinementLevel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SymmetricPackage.SEMANTIC_CHANGE_SET__REFINEMENT_LEVEL, oldRefinementLevel, refinementLevel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getEditRName() {
		return editRName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEditRName(String newEditRName) {
		String oldEditRName = editRName;
		editRName = newEditRName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SymmetricPackage.SEMANTIC_CHANGE_SET__EDIT_RNAME, oldEditRName, editRName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SemanticChangeSet> getPartiallyOverlappings() {
		if (partiallyOverlappings == null) {
			partiallyOverlappings = new EObjectResolvingEList<SemanticChangeSet>(SemanticChangeSet.class, this, SymmetricPackage.SEMANTIC_CHANGE_SET__PARTIALLY_OVERLAPPINGS);
		}
		return partiallyOverlappings;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SemanticChangeSet> getSubsets() {
		if (subsets == null) {
			subsets = new EObjectWithInverseResolvingEList.ManyInverse<SemanticChangeSet>(SemanticChangeSet.class, this, SymmetricPackage.SEMANTIC_CHANGE_SET__SUBSETS, SymmetricPackage.SEMANTIC_CHANGE_SET__SUPERSETS);
		}
		return subsets;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SemanticChangeSet> getSupersets() {
		if (supersets == null) {
			supersets = new EObjectWithInverseResolvingEList.ManyInverse<SemanticChangeSet>(SemanticChangeSet.class, this, SymmetricPackage.SEMANTIC_CHANGE_SET__SUPERSETS, SymmetricPackage.SEMANTIC_CHANGE_SET__SUBSETS);
		}
		return supersets;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SemanticChangeSet> getOverlayings() {
		if (overlayings == null) {
			overlayings = new EObjectResolvingEList<SemanticChangeSet>(SemanticChangeSet.class, this, SymmetricPackage.SEMANTIC_CHANGE_SET__OVERLAYINGS);
		}
		return overlayings;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(String newDescription) {
		String oldDescription = description;
		description = newDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SymmetricPackage.SEMANTIC_CHANGE_SET__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getNumberOfACs() {
		return numberOfACs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNumberOfACs(int newNumberOfACs) {
		int oldNumberOfACs = numberOfACs;
		numberOfACs = newNumberOfACs;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SymmetricPackage.SEMANTIC_CHANGE_SET__NUMBER_OF_ACS, oldNumberOfACs, numberOfACs));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getNumberOfParams() {
		return numberOfParams;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNumberOfParams(int newNumberOfParams) {
		int oldNumberOfParams = numberOfParams;
		numberOfParams = newNumberOfParams;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SymmetricPackage.SEMANTIC_CHANGE_SET__NUMBER_OF_PARAMS, oldNumberOfParams, numberOfParams));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EditRuleMatch getEditRuleMatch() {
		return editRuleMatch;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetEditRuleMatch(EditRuleMatch newEditRuleMatch, NotificationChain msgs) {
		EditRuleMatch oldEditRuleMatch = editRuleMatch;
		editRuleMatch = newEditRuleMatch;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SymmetricPackage.SEMANTIC_CHANGE_SET__EDIT_RULE_MATCH, oldEditRuleMatch, newEditRuleMatch);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEditRuleMatch(EditRuleMatch newEditRuleMatch) {
		if (newEditRuleMatch != editRuleMatch) {
			NotificationChain msgs = null;
			if (editRuleMatch != null)
				msgs = ((InternalEObject)editRuleMatch).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SymmetricPackage.SEMANTIC_CHANGE_SET__EDIT_RULE_MATCH, null, msgs);
			if (newEditRuleMatch != null)
				msgs = ((InternalEObject)newEditRuleMatch).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SymmetricPackage.SEMANTIC_CHANGE_SET__EDIT_RULE_MATCH, null, msgs);
			msgs = basicSetEditRuleMatch(newEditRuleMatch, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SymmetricPackage.SEMANTIC_CHANGE_SET__EDIT_RULE_MATCH, newEditRuleMatch, newEditRuleMatch));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<FragmentJoin> getJoins() {
		if (joins == null) {
			joins = new EObjectContainmentWithInverseEList<FragmentJoin>(FragmentJoin.class, this, SymmetricPackage.SEMANTIC_CHANGE_SET__JOINS, SymmetricPackage.FRAGMENT_JOIN__SCS);
		}
		return joins;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<FragmentSplit> getSplits() {
		if (splits == null) {
			splits = new EObjectContainmentWithInverseEList<FragmentSplit>(FragmentSplit.class, this, SymmetricPackage.SEMANTIC_CHANGE_SET__SPLITS, SymmetricPackage.FRAGMENT_SPLIT__SCS);
		}
		return splits;
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
			case SymmetricPackage.SEMANTIC_CHANGE_SET__SUBSETS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getSubsets()).basicAdd(otherEnd, msgs);
			case SymmetricPackage.SEMANTIC_CHANGE_SET__SUPERSETS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getSupersets()).basicAdd(otherEnd, msgs);
			case SymmetricPackage.SEMANTIC_CHANGE_SET__JOINS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getJoins()).basicAdd(otherEnd, msgs);
			case SymmetricPackage.SEMANTIC_CHANGE_SET__SPLITS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getSplits()).basicAdd(otherEnd, msgs);
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
			case SymmetricPackage.SEMANTIC_CHANGE_SET__SUBSETS:
				return ((InternalEList<?>)getSubsets()).basicRemove(otherEnd, msgs);
			case SymmetricPackage.SEMANTIC_CHANGE_SET__SUPERSETS:
				return ((InternalEList<?>)getSupersets()).basicRemove(otherEnd, msgs);
			case SymmetricPackage.SEMANTIC_CHANGE_SET__EDIT_RULE_MATCH:
				return basicSetEditRuleMatch(null, msgs);
			case SymmetricPackage.SEMANTIC_CHANGE_SET__JOINS:
				return ((InternalEList<?>)getJoins()).basicRemove(otherEnd, msgs);
			case SymmetricPackage.SEMANTIC_CHANGE_SET__SPLITS:
				return ((InternalEList<?>)getSplits()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRecognitionRName() {
		return recognitionRName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRecognitionRName(String newRecognitionRName) {
		String oldRecognitionRName = recognitionRName;
		recognitionRName = newRecognitionRName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SymmetricPackage.SEMANTIC_CHANGE_SET__RECOGNITION_RNAME, oldRecognitionRName, recognitionRName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SymmetricPackage.SEMANTIC_CHANGE_SET__CHANGES:
				return getChanges();
			case SymmetricPackage.SEMANTIC_CHANGE_SET__NAME:
				return getName();
			case SymmetricPackage.SEMANTIC_CHANGE_SET__PRIORITY:
				return getPriority();
			case SymmetricPackage.SEMANTIC_CHANGE_SET__RECOGNITION_RNAME:
				return getRecognitionRName();
			case SymmetricPackage.SEMANTIC_CHANGE_SET__REFINEMENT_LEVEL:
				return getRefinementLevel();
			case SymmetricPackage.SEMANTIC_CHANGE_SET__EDIT_RNAME:
				return getEditRName();
			case SymmetricPackage.SEMANTIC_CHANGE_SET__PARTIALLY_OVERLAPPINGS:
				return getPartiallyOverlappings();
			case SymmetricPackage.SEMANTIC_CHANGE_SET__SUBSETS:
				return getSubsets();
			case SymmetricPackage.SEMANTIC_CHANGE_SET__SUPERSETS:
				return getSupersets();
			case SymmetricPackage.SEMANTIC_CHANGE_SET__OVERLAYINGS:
				return getOverlayings();
			case SymmetricPackage.SEMANTIC_CHANGE_SET__DESCRIPTION:
				return getDescription();
			case SymmetricPackage.SEMANTIC_CHANGE_SET__NUMBER_OF_ACS:
				return getNumberOfACs();
			case SymmetricPackage.SEMANTIC_CHANGE_SET__NUMBER_OF_PARAMS:
				return getNumberOfParams();
			case SymmetricPackage.SEMANTIC_CHANGE_SET__EDIT_RULE_MATCH:
				return getEditRuleMatch();
			case SymmetricPackage.SEMANTIC_CHANGE_SET__JOINS:
				return getJoins();
			case SymmetricPackage.SEMANTIC_CHANGE_SET__SPLITS:
				return getSplits();
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
			case SymmetricPackage.SEMANTIC_CHANGE_SET__CHANGES:
				getChanges().clear();
				getChanges().addAll((Collection<? extends Change>)newValue);
				return;
			case SymmetricPackage.SEMANTIC_CHANGE_SET__NAME:
				setName((String)newValue);
				return;
			case SymmetricPackage.SEMANTIC_CHANGE_SET__PRIORITY:
				setPriority((Integer)newValue);
				return;
			case SymmetricPackage.SEMANTIC_CHANGE_SET__RECOGNITION_RNAME:
				setRecognitionRName((String)newValue);
				return;
			case SymmetricPackage.SEMANTIC_CHANGE_SET__REFINEMENT_LEVEL:
				setRefinementLevel((Integer)newValue);
				return;
			case SymmetricPackage.SEMANTIC_CHANGE_SET__EDIT_RNAME:
				setEditRName((String)newValue);
				return;
			case SymmetricPackage.SEMANTIC_CHANGE_SET__PARTIALLY_OVERLAPPINGS:
				getPartiallyOverlappings().clear();
				getPartiallyOverlappings().addAll((Collection<? extends SemanticChangeSet>)newValue);
				return;
			case SymmetricPackage.SEMANTIC_CHANGE_SET__SUBSETS:
				getSubsets().clear();
				getSubsets().addAll((Collection<? extends SemanticChangeSet>)newValue);
				return;
			case SymmetricPackage.SEMANTIC_CHANGE_SET__SUPERSETS:
				getSupersets().clear();
				getSupersets().addAll((Collection<? extends SemanticChangeSet>)newValue);
				return;
			case SymmetricPackage.SEMANTIC_CHANGE_SET__OVERLAYINGS:
				getOverlayings().clear();
				getOverlayings().addAll((Collection<? extends SemanticChangeSet>)newValue);
				return;
			case SymmetricPackage.SEMANTIC_CHANGE_SET__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case SymmetricPackage.SEMANTIC_CHANGE_SET__NUMBER_OF_ACS:
				setNumberOfACs((Integer)newValue);
				return;
			case SymmetricPackage.SEMANTIC_CHANGE_SET__NUMBER_OF_PARAMS:
				setNumberOfParams((Integer)newValue);
				return;
			case SymmetricPackage.SEMANTIC_CHANGE_SET__EDIT_RULE_MATCH:
				setEditRuleMatch((EditRuleMatch)newValue);
				return;
			case SymmetricPackage.SEMANTIC_CHANGE_SET__JOINS:
				getJoins().clear();
				getJoins().addAll((Collection<? extends FragmentJoin>)newValue);
				return;
			case SymmetricPackage.SEMANTIC_CHANGE_SET__SPLITS:
				getSplits().clear();
				getSplits().addAll((Collection<? extends FragmentSplit>)newValue);
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
			case SymmetricPackage.SEMANTIC_CHANGE_SET__CHANGES:
				getChanges().clear();
				return;
			case SymmetricPackage.SEMANTIC_CHANGE_SET__NAME:
				setName(NAME_EDEFAULT);
				return;
			case SymmetricPackage.SEMANTIC_CHANGE_SET__PRIORITY:
				setPriority(PRIORITY_EDEFAULT);
				return;
			case SymmetricPackage.SEMANTIC_CHANGE_SET__RECOGNITION_RNAME:
				setRecognitionRName(RECOGNITION_RNAME_EDEFAULT);
				return;
			case SymmetricPackage.SEMANTIC_CHANGE_SET__REFINEMENT_LEVEL:
				setRefinementLevel(REFINEMENT_LEVEL_EDEFAULT);
				return;
			case SymmetricPackage.SEMANTIC_CHANGE_SET__EDIT_RNAME:
				setEditRName(EDIT_RNAME_EDEFAULT);
				return;
			case SymmetricPackage.SEMANTIC_CHANGE_SET__PARTIALLY_OVERLAPPINGS:
				getPartiallyOverlappings().clear();
				return;
			case SymmetricPackage.SEMANTIC_CHANGE_SET__SUBSETS:
				getSubsets().clear();
				return;
			case SymmetricPackage.SEMANTIC_CHANGE_SET__SUPERSETS:
				getSupersets().clear();
				return;
			case SymmetricPackage.SEMANTIC_CHANGE_SET__OVERLAYINGS:
				getOverlayings().clear();
				return;
			case SymmetricPackage.SEMANTIC_CHANGE_SET__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case SymmetricPackage.SEMANTIC_CHANGE_SET__NUMBER_OF_ACS:
				setNumberOfACs(NUMBER_OF_ACS_EDEFAULT);
				return;
			case SymmetricPackage.SEMANTIC_CHANGE_SET__NUMBER_OF_PARAMS:
				setNumberOfParams(NUMBER_OF_PARAMS_EDEFAULT);
				return;
			case SymmetricPackage.SEMANTIC_CHANGE_SET__EDIT_RULE_MATCH:
				setEditRuleMatch((EditRuleMatch)null);
				return;
			case SymmetricPackage.SEMANTIC_CHANGE_SET__JOINS:
				getJoins().clear();
				return;
			case SymmetricPackage.SEMANTIC_CHANGE_SET__SPLITS:
				getSplits().clear();
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
			case SymmetricPackage.SEMANTIC_CHANGE_SET__CHANGES:
				return changes != null && !changes.isEmpty();
			case SymmetricPackage.SEMANTIC_CHANGE_SET__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case SymmetricPackage.SEMANTIC_CHANGE_SET__PRIORITY:
				return priority != PRIORITY_EDEFAULT;
			case SymmetricPackage.SEMANTIC_CHANGE_SET__RECOGNITION_RNAME:
				return RECOGNITION_RNAME_EDEFAULT == null ? recognitionRName != null : !RECOGNITION_RNAME_EDEFAULT.equals(recognitionRName);
			case SymmetricPackage.SEMANTIC_CHANGE_SET__REFINEMENT_LEVEL:
				return refinementLevel != REFINEMENT_LEVEL_EDEFAULT;
			case SymmetricPackage.SEMANTIC_CHANGE_SET__EDIT_RNAME:
				return EDIT_RNAME_EDEFAULT == null ? editRName != null : !EDIT_RNAME_EDEFAULT.equals(editRName);
			case SymmetricPackage.SEMANTIC_CHANGE_SET__PARTIALLY_OVERLAPPINGS:
				return partiallyOverlappings != null && !partiallyOverlappings.isEmpty();
			case SymmetricPackage.SEMANTIC_CHANGE_SET__SUBSETS:
				return subsets != null && !subsets.isEmpty();
			case SymmetricPackage.SEMANTIC_CHANGE_SET__SUPERSETS:
				return supersets != null && !supersets.isEmpty();
			case SymmetricPackage.SEMANTIC_CHANGE_SET__OVERLAYINGS:
				return overlayings != null && !overlayings.isEmpty();
			case SymmetricPackage.SEMANTIC_CHANGE_SET__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case SymmetricPackage.SEMANTIC_CHANGE_SET__NUMBER_OF_ACS:
				return numberOfACs != NUMBER_OF_ACS_EDEFAULT;
			case SymmetricPackage.SEMANTIC_CHANGE_SET__NUMBER_OF_PARAMS:
				return numberOfParams != NUMBER_OF_PARAMS_EDEFAULT;
			case SymmetricPackage.SEMANTIC_CHANGE_SET__EDIT_RULE_MATCH:
				return editRuleMatch != null;
			case SymmetricPackage.SEMANTIC_CHANGE_SET__JOINS:
				return joins != null && !joins.isEmpty();
			case SymmetricPackage.SEMANTIC_CHANGE_SET__SPLITS:
				return splits != null && !splits.isEmpty();
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
		result.append(" (name: ");
		result.append(name);
		result.append(", priority: ");
		result.append(priority);
		result.append(", recognitionRName: ");
		result.append(recognitionRName);
		result.append(", refinementLevel: ");
		result.append(refinementLevel);
		result.append(", editRName: ");
		result.append(editRName);
		result.append(", description: ");
		result.append(description);
		result.append(", numberOfACs: ");
		result.append(numberOfACs);
		result.append(", numberOfParams: ");
		result.append(numberOfParams);
		result.append(')');
		return result.toString();
	}
} //SemanticChangeSetImpl
