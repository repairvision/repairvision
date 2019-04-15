/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.sidiff.difference.symmetric.impl;

import java.util.Map;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.sidiff.difference.symmetric.AddObject;
import org.sidiff.difference.symmetric.AddReference;
import org.sidiff.difference.symmetric.AttributeValueChange;
import org.sidiff.difference.symmetric.Change;
import org.sidiff.difference.symmetric.EObjectSet;
import org.sidiff.difference.symmetric.EditRuleMatch;
import org.sidiff.difference.symmetric.FragmentJoin;
import org.sidiff.difference.symmetric.FragmentSplit;
import org.sidiff.difference.symmetric.RemoveObject;
import org.sidiff.difference.symmetric.RemoveReference;
import org.sidiff.difference.symmetric.SemanticChangeSet;
import org.sidiff.difference.symmetric.SymmetricDifference;
import org.sidiff.difference.symmetric.SymmetricFactory;
import org.sidiff.difference.symmetric.SymmetricPackage;
import org.sidiff.matching.model.MatchingModelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SymmetricPackageImpl extends EPackageImpl implements SymmetricPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass symmetricDifferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass addObjectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass removeObjectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass addReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass removeReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass changeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass semanticChangeSetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass attributeValueChangeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eString2EObjectSetMapEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass editRuleMatchEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eObjectSetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fragmentJoinEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fragmentSplitEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.sidiff.difference.symmetric.SymmetricPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private SymmetricPackageImpl() {
		super(eNS_URI, SymmetricFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link SymmetricPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static SymmetricPackage init() {
		if (isInited) return (SymmetricPackage)EPackage.Registry.INSTANCE.getEPackage(SymmetricPackage.eNS_URI);

		// Obtain or create and register package
		SymmetricPackageImpl theSymmetricPackage = (SymmetricPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof SymmetricPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new SymmetricPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		MatchingModelPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theSymmetricPackage.createPackageContents();

		// Initialize created meta-data
		theSymmetricPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theSymmetricPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(SymmetricPackage.eNS_URI, theSymmetricPackage);
		return theSymmetricPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSymmetricDifference() {
		return symmetricDifferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSymmetricDifference_Changes() {
		return (EReference)symmetricDifferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSymmetricDifference_ChangeSets() {
		return (EReference)symmetricDifferenceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSymmetricDifference_ModelA() {
		return (EAttribute)symmetricDifferenceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSymmetricDifference_ModelB() {
		return (EAttribute)symmetricDifferenceEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSymmetricDifference_UriModelA() {
		return (EAttribute)symmetricDifferenceEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSymmetricDifference_UriModelB() {
		return (EAttribute)symmetricDifferenceEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSymmetricDifference_NotOverlappings() {
		return (EReference)symmetricDifferenceEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSymmetricDifference_UnusedChangeSets() {
		return (EReference)symmetricDifferenceEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSymmetricDifference_Matching() {
		return (EReference)symmetricDifferenceEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAddObject() {
		return addObjectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAddObject_Obj() {
		return (EReference)addObjectEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRemoveObject() {
		return removeObjectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRemoveObject_Obj() {
		return (EReference)removeObjectEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAddReference() {
		return addReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAddReference_Src() {
		return (EReference)addReferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAddReference_Tgt() {
		return (EReference)addReferenceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAddReference_Type() {
		return (EReference)addReferenceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRemoveReference() {
		return removeReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRemoveReference_Src() {
		return (EReference)removeReferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRemoveReference_Tgt() {
		return (EReference)removeReferenceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRemoveReference_Type() {
		return (EReference)removeReferenceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getChange() {
		return changeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSemanticChangeSet() {
		return semanticChangeSetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSemanticChangeSet_Changes() {
		return (EReference)semanticChangeSetEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSemanticChangeSet_Name() {
		return (EAttribute)semanticChangeSetEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSemanticChangeSet_Priority() {
		return (EAttribute)semanticChangeSetEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSemanticChangeSet_RefinementLevel() {
		return (EAttribute)semanticChangeSetEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSemanticChangeSet_EditRName() {
		return (EAttribute)semanticChangeSetEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSemanticChangeSet_PartiallyOverlappings() {
		return (EReference)semanticChangeSetEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSemanticChangeSet_Subsets() {
		return (EReference)semanticChangeSetEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSemanticChangeSet_Supersets() {
		return (EReference)semanticChangeSetEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSemanticChangeSet_Overlayings() {
		return (EReference)semanticChangeSetEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSemanticChangeSet_Description() {
		return (EAttribute)semanticChangeSetEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSemanticChangeSet_NumberOfACs() {
		return (EAttribute)semanticChangeSetEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSemanticChangeSet_NumberOfParams() {
		return (EAttribute)semanticChangeSetEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSemanticChangeSet_EditRuleMatch() {
		return (EReference)semanticChangeSetEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSemanticChangeSet_Joins() {
		return (EReference)semanticChangeSetEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSemanticChangeSet_Splits() {
		return (EReference)semanticChangeSetEClass.getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSemanticChangeSet_RecognitionRName() {
		return (EAttribute)semanticChangeSetEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAttributeValueChange() {
		return attributeValueChangeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAttributeValueChange_ObjA() {
		return (EReference)attributeValueChangeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAttributeValueChange_ObjB() {
		return (EReference)attributeValueChangeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAttributeValueChange_Type() {
		return (EReference)attributeValueChangeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEString2EObjectSetMap() {
		return eString2EObjectSetMapEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEString2EObjectSetMap_Key() {
		return (EAttribute)eString2EObjectSetMapEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEString2EObjectSetMap_Value() {
		return (EReference)eString2EObjectSetMapEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEditRuleMatch() {
		return editRuleMatchEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEditRuleMatch_NodeOccurrencesA() {
		return (EReference)editRuleMatchEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEditRuleMatch_NodeOccurrencesB() {
		return (EReference)editRuleMatchEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEObjectSet() {
		return eObjectSetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEObjectSet_Elements() {
		return (EReference)eObjectSetEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFragmentJoin() {
		return fragmentJoinEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFragmentJoin_Scs() {
		return (EReference)fragmentJoinEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFragmentJoin_JoinFrom() {
		return (EReference)fragmentJoinEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFragmentJoin_JoinInto() {
		return (EReference)fragmentJoinEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFragmentSplit() {
		return fragmentSplitEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFragmentSplit_Scs() {
		return (EReference)fragmentSplitEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFragmentSplit_SplitFrom() {
		return (EReference)fragmentSplitEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFragmentSplit_SplitInto() {
		return (EReference)fragmentSplitEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SymmetricFactory getSymmetricFactory() {
		return (SymmetricFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		symmetricDifferenceEClass = createEClass(SYMMETRIC_DIFFERENCE);
		createEReference(symmetricDifferenceEClass, SYMMETRIC_DIFFERENCE__CHANGES);
		createEReference(symmetricDifferenceEClass, SYMMETRIC_DIFFERENCE__CHANGE_SETS);
		createEAttribute(symmetricDifferenceEClass, SYMMETRIC_DIFFERENCE__MODEL_A);
		createEAttribute(symmetricDifferenceEClass, SYMMETRIC_DIFFERENCE__MODEL_B);
		createEAttribute(symmetricDifferenceEClass, SYMMETRIC_DIFFERENCE__URI_MODEL_A);
		createEAttribute(symmetricDifferenceEClass, SYMMETRIC_DIFFERENCE__URI_MODEL_B);
		createEReference(symmetricDifferenceEClass, SYMMETRIC_DIFFERENCE__NOT_OVERLAPPINGS);
		createEReference(symmetricDifferenceEClass, SYMMETRIC_DIFFERENCE__UNUSED_CHANGE_SETS);
		createEReference(symmetricDifferenceEClass, SYMMETRIC_DIFFERENCE__MATCHING);

		addObjectEClass = createEClass(ADD_OBJECT);
		createEReference(addObjectEClass, ADD_OBJECT__OBJ);

		removeObjectEClass = createEClass(REMOVE_OBJECT);
		createEReference(removeObjectEClass, REMOVE_OBJECT__OBJ);

		addReferenceEClass = createEClass(ADD_REFERENCE);
		createEReference(addReferenceEClass, ADD_REFERENCE__SRC);
		createEReference(addReferenceEClass, ADD_REFERENCE__TGT);
		createEReference(addReferenceEClass, ADD_REFERENCE__TYPE);

		removeReferenceEClass = createEClass(REMOVE_REFERENCE);
		createEReference(removeReferenceEClass, REMOVE_REFERENCE__SRC);
		createEReference(removeReferenceEClass, REMOVE_REFERENCE__TGT);
		createEReference(removeReferenceEClass, REMOVE_REFERENCE__TYPE);

		changeEClass = createEClass(CHANGE);

		semanticChangeSetEClass = createEClass(SEMANTIC_CHANGE_SET);
		createEReference(semanticChangeSetEClass, SEMANTIC_CHANGE_SET__CHANGES);
		createEAttribute(semanticChangeSetEClass, SEMANTIC_CHANGE_SET__NAME);
		createEAttribute(semanticChangeSetEClass, SEMANTIC_CHANGE_SET__PRIORITY);
		createEAttribute(semanticChangeSetEClass, SEMANTIC_CHANGE_SET__RECOGNITION_RNAME);
		createEAttribute(semanticChangeSetEClass, SEMANTIC_CHANGE_SET__REFINEMENT_LEVEL);
		createEAttribute(semanticChangeSetEClass, SEMANTIC_CHANGE_SET__EDIT_RNAME);
		createEReference(semanticChangeSetEClass, SEMANTIC_CHANGE_SET__PARTIALLY_OVERLAPPINGS);
		createEReference(semanticChangeSetEClass, SEMANTIC_CHANGE_SET__SUBSETS);
		createEReference(semanticChangeSetEClass, SEMANTIC_CHANGE_SET__SUPERSETS);
		createEReference(semanticChangeSetEClass, SEMANTIC_CHANGE_SET__OVERLAYINGS);
		createEAttribute(semanticChangeSetEClass, SEMANTIC_CHANGE_SET__DESCRIPTION);
		createEAttribute(semanticChangeSetEClass, SEMANTIC_CHANGE_SET__NUMBER_OF_ACS);
		createEAttribute(semanticChangeSetEClass, SEMANTIC_CHANGE_SET__NUMBER_OF_PARAMS);
		createEReference(semanticChangeSetEClass, SEMANTIC_CHANGE_SET__EDIT_RULE_MATCH);
		createEReference(semanticChangeSetEClass, SEMANTIC_CHANGE_SET__JOINS);
		createEReference(semanticChangeSetEClass, SEMANTIC_CHANGE_SET__SPLITS);

		attributeValueChangeEClass = createEClass(ATTRIBUTE_VALUE_CHANGE);
		createEReference(attributeValueChangeEClass, ATTRIBUTE_VALUE_CHANGE__OBJ_A);
		createEReference(attributeValueChangeEClass, ATTRIBUTE_VALUE_CHANGE__OBJ_B);
		createEReference(attributeValueChangeEClass, ATTRIBUTE_VALUE_CHANGE__TYPE);

		eString2EObjectSetMapEClass = createEClass(ESTRING2_EOBJECT_SET_MAP);
		createEReference(eString2EObjectSetMapEClass, ESTRING2_EOBJECT_SET_MAP__VALUE);
		createEAttribute(eString2EObjectSetMapEClass, ESTRING2_EOBJECT_SET_MAP__KEY);

		editRuleMatchEClass = createEClass(EDIT_RULE_MATCH);
		createEReference(editRuleMatchEClass, EDIT_RULE_MATCH__NODE_OCCURRENCES_A);
		createEReference(editRuleMatchEClass, EDIT_RULE_MATCH__NODE_OCCURRENCES_B);

		eObjectSetEClass = createEClass(EOBJECT_SET);
		createEReference(eObjectSetEClass, EOBJECT_SET__ELEMENTS);

		fragmentJoinEClass = createEClass(FRAGMENT_JOIN);
		createEReference(fragmentJoinEClass, FRAGMENT_JOIN__SCS);
		createEReference(fragmentJoinEClass, FRAGMENT_JOIN__JOIN_FROM);
		createEReference(fragmentJoinEClass, FRAGMENT_JOIN__JOIN_INTO);

		fragmentSplitEClass = createEClass(FRAGMENT_SPLIT);
		createEReference(fragmentSplitEClass, FRAGMENT_SPLIT__SCS);
		createEReference(fragmentSplitEClass, FRAGMENT_SPLIT__SPLIT_FROM);
		createEReference(fragmentSplitEClass, FRAGMENT_SPLIT__SPLIT_INTO);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		MatchingModelPackage theMatchingModelPackage = (MatchingModelPackage)EPackage.Registry.INSTANCE.getEPackage(MatchingModelPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		addObjectEClass.getESuperTypes().add(this.getChange());
		removeObjectEClass.getESuperTypes().add(this.getChange());
		addReferenceEClass.getESuperTypes().add(this.getChange());
		removeReferenceEClass.getESuperTypes().add(this.getChange());
		attributeValueChangeEClass.getESuperTypes().add(this.getChange());

		// Initialize classes and features; add operations and parameters
		initEClass(symmetricDifferenceEClass, SymmetricDifference.class, "SymmetricDifference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSymmetricDifference_Changes(), this.getChange(), null, "changes", null, 0, -1, SymmetricDifference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSymmetricDifference_ChangeSets(), this.getSemanticChangeSet(), null, "changeSets", null, 0, -1, SymmetricDifference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSymmetricDifference_ModelA(), ecorePackage.getEResource(), "modelA", null, 0, 1, SymmetricDifference.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getSymmetricDifference_ModelB(), ecorePackage.getEResource(), "modelB", null, 0, 1, SymmetricDifference.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getSymmetricDifference_UriModelA(), ecorePackage.getEString(), "uriModelA", null, 0, 1, SymmetricDifference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSymmetricDifference_UriModelB(), ecorePackage.getEString(), "uriModelB", null, 0, 1, SymmetricDifference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSymmetricDifference_NotOverlappings(), this.getSemanticChangeSet(), null, "notOverlappings", null, 0, -1, SymmetricDifference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSymmetricDifference_UnusedChangeSets(), this.getSemanticChangeSet(), null, "unusedChangeSets", null, 0, -1, SymmetricDifference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSymmetricDifference_Matching(), theMatchingModelPackage.getMatching(), null, "matching", null, 1, 1, SymmetricDifference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		EOperation op = addEOperation(symmetricDifferenceEClass, ecorePackage.getEObject(), "getCorrespondingObjectInA", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEObject(), "objectInB", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(symmetricDifferenceEClass, ecorePackage.getEObject(), "getCorrespondingObjectInB", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEObject(), "objectInA", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(symmetricDifferenceEClass, theMatchingModelPackage.getCorrespondence(), "getCorrespondenceOfModelA", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEObject(), "objectInA", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(symmetricDifferenceEClass, theMatchingModelPackage.getCorrespondence(), "getCorrespondenceOfModelB", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEObject(), "objectInB", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(symmetricDifferenceEClass, null, "addCorrespondence", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theMatchingModelPackage.getCorrespondence(), "correspondence", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(symmetricDifferenceEClass, null, "removeCorrespondence", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theMatchingModelPackage.getCorrespondence(), "correspondence", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(addObjectEClass, AddObject.class, "AddObject", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAddObject_Obj(), ecorePackage.getEObject(), null, "obj", null, 0, 1, AddObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(removeObjectEClass, RemoveObject.class, "RemoveObject", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRemoveObject_Obj(), ecorePackage.getEObject(), null, "obj", null, 0, 1, RemoveObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(addReferenceEClass, AddReference.class, "AddReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAddReference_Src(), ecorePackage.getEObject(), null, "src", null, 0, 1, AddReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAddReference_Tgt(), ecorePackage.getEObject(), null, "tgt", null, 0, 1, AddReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAddReference_Type(), ecorePackage.getEReference(), null, "type", null, 0, 1, AddReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(removeReferenceEClass, RemoveReference.class, "RemoveReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRemoveReference_Src(), ecorePackage.getEObject(), null, "src", null, 0, 1, RemoveReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRemoveReference_Tgt(), ecorePackage.getEObject(), null, "tgt", null, 0, 1, RemoveReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRemoveReference_Type(), ecorePackage.getEReference(), null, "type", null, 0, 1, RemoveReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(changeEClass, Change.class, "Change", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(semanticChangeSetEClass, SemanticChangeSet.class, "SemanticChangeSet", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSemanticChangeSet_Changes(), this.getChange(), null, "changes", null, 0, -1, SemanticChangeSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSemanticChangeSet_Name(), ecorePackage.getEString(), "name", null, 0, 1, SemanticChangeSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSemanticChangeSet_Priority(), ecorePackage.getEInt(), "priority", "0", 0, 1, SemanticChangeSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSemanticChangeSet_RecognitionRName(), ecorePackage.getEString(), "recognitionRName", null, 0, 1, SemanticChangeSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSemanticChangeSet_RefinementLevel(), ecorePackage.getEInt(), "refinementLevel", "0", 0, 1, SemanticChangeSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSemanticChangeSet_EditRName(), ecorePackage.getEString(), "editRName", null, 0, 1, SemanticChangeSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSemanticChangeSet_PartiallyOverlappings(), this.getSemanticChangeSet(), null, "partiallyOverlappings", null, 0, -1, SemanticChangeSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSemanticChangeSet_Subsets(), this.getSemanticChangeSet(), this.getSemanticChangeSet_Supersets(), "subsets", null, 0, -1, SemanticChangeSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSemanticChangeSet_Supersets(), this.getSemanticChangeSet(), this.getSemanticChangeSet_Subsets(), "supersets", null, 0, -1, SemanticChangeSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSemanticChangeSet_Overlayings(), this.getSemanticChangeSet(), null, "overlayings", null, 0, -1, SemanticChangeSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSemanticChangeSet_Description(), ecorePackage.getEString(), "description", null, 0, 1, SemanticChangeSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSemanticChangeSet_NumberOfACs(), ecorePackage.getEInt(), "numberOfACs", null, 0, 1, SemanticChangeSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSemanticChangeSet_NumberOfParams(), ecorePackage.getEInt(), "numberOfParams", null, 0, 1, SemanticChangeSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSemanticChangeSet_EditRuleMatch(), this.getEditRuleMatch(), null, "editRuleMatch", null, 0, 1, SemanticChangeSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSemanticChangeSet_Joins(), this.getFragmentJoin(), this.getFragmentJoin_Scs(), "joins", null, 0, -1, SemanticChangeSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSemanticChangeSet_Splits(), this.getFragmentSplit(), this.getFragmentSplit_Scs(), "splits", null, 0, -1, SemanticChangeSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(attributeValueChangeEClass, AttributeValueChange.class, "AttributeValueChange", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAttributeValueChange_ObjA(), ecorePackage.getEObject(), null, "objA", null, 0, 1, AttributeValueChange.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAttributeValueChange_ObjB(), ecorePackage.getEObject(), null, "objB", null, 0, 1, AttributeValueChange.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAttributeValueChange_Type(), ecorePackage.getEAttribute(), null, "type", null, 0, 1, AttributeValueChange.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eString2EObjectSetMapEClass, Map.Entry.class, "EString2EObjectSetMap", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEString2EObjectSetMap_Value(), this.getEObjectSet(), null, "value", null, 0, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEString2EObjectSetMap_Key(), ecorePackage.getEString(), "key", null, 0, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(editRuleMatchEClass, EditRuleMatch.class, "EditRuleMatch", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEditRuleMatch_NodeOccurrencesA(), this.getEString2EObjectSetMap(), null, "nodeOccurrencesA", null, 0, -1, EditRuleMatch.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEditRuleMatch_NodeOccurrencesB(), this.getEString2EObjectSetMap(), null, "nodeOccurrencesB", null, 0, -1, EditRuleMatch.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eObjectSetEClass, EObjectSet.class, "EObjectSet", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEObjectSet_Elements(), ecorePackage.getEObject(), null, "elements", null, 0, -1, EObjectSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(fragmentJoinEClass, FragmentJoin.class, "FragmentJoin", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFragmentJoin_Scs(), this.getSemanticChangeSet(), this.getSemanticChangeSet_Joins(), "scs", null, 1, 1, FragmentJoin.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFragmentJoin_JoinFrom(), ecorePackage.getEObject(), null, "joinFrom", null, 2, -1, FragmentJoin.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFragmentJoin_JoinInto(), ecorePackage.getEObject(), null, "joinInto", null, 1, -1, FragmentJoin.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(fragmentSplitEClass, FragmentSplit.class, "FragmentSplit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFragmentSplit_Scs(), this.getSemanticChangeSet(), this.getSemanticChangeSet_Splits(), "scs", null, 1, 1, FragmentSplit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFragmentSplit_SplitFrom(), ecorePackage.getEObject(), null, "splitFrom", null, 1, -1, FragmentSplit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFragmentSplit_SplitInto(), ecorePackage.getEObject(), null, "splitInto", null, 2, -1, FragmentSplit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //SymmetricPackageImpl
