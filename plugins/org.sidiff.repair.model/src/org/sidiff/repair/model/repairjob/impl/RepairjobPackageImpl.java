/**
 */
package org.sidiff.repair.model.repairjob.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.emf.henshin.model.HenshinPackage;

import org.sidiff.difference.symmetric.SymmetricPackage;

import org.sidiff.repair.model.repairjob.Change;
import org.sidiff.repair.model.repairjob.ComplementRule;
import org.sidiff.repair.model.repairjob.EditRule;
import org.sidiff.repair.model.repairjob.Match;
import org.sidiff.repair.model.repairjob.PartialRule;
import org.sidiff.repair.model.repairjob.Repair;
import org.sidiff.repair.model.repairjob.RepairJob;
import org.sidiff.repair.model.repairjob.RepairMatch;
import org.sidiff.repair.model.repairjob.RepairOperation;
import org.sidiff.repair.model.repairjob.RepairParameter;
import org.sidiff.repair.model.repairjob.RepairjobFactory;
import org.sidiff.repair.model.repairjob.RepairjobPackage;
import org.sidiff.repair.model.repairjob.SubRule;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class RepairjobPackageImpl extends EPackageImpl implements RepairjobPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass repairJobEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass editRuleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass repairOperationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass partialRuleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass subRuleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass complementRuleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass repairEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass repairMatchEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass repairParameterEClass = null;

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
	private EClass matchEClass = null;

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
	 * @see org.sidiff.repair.model.repairjob.RepairjobPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private RepairjobPackageImpl() {
		super(eNS_URI, RepairjobFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link RepairjobPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static RepairjobPackage init() {
		if (isInited) return (RepairjobPackage)EPackage.Registry.INSTANCE.getEPackage(RepairjobPackage.eNS_URI);

		// Obtain or create and register package
		RepairjobPackageImpl theRepairjobPackage = (RepairjobPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof RepairjobPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new RepairjobPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		HenshinPackage.eINSTANCE.eClass();
		SymmetricPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theRepairjobPackage.createPackageContents();

		// Initialize created meta-data
		theRepairjobPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theRepairjobPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(RepairjobPackage.eNS_URI, theRepairjobPackage);
		return theRepairjobPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRepairJob() {
		return repairJobEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRepairJob_Difference() {
		return (EReference)repairJobEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRepairJob_EditRules() {
		return (EReference)repairJobEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEditRule() {
		return editRuleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEditRule_Rule() {
		return (EReference)editRuleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEditRule_RepairJob() {
		return (EReference)editRuleEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEditRule_RepairOperations() {
		return (EReference)editRuleEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getEditRule__GetRating() {
		return editRuleEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRepairOperation() {
		return repairOperationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRepairOperation_Context() {
		return (EReference)repairOperationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRepairOperation_EditRule() {
		return (EReference)repairOperationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRepairOperation_SubRule() {
		return (EReference)repairOperationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRepairOperation_ComplementRule() {
		return (EReference)repairOperationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRepairOperation_Repairs() {
		return (EReference)repairOperationEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getRepairOperation__GetRating() {
		return repairOperationEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPartialRule() {
		return partialRuleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPartialRule_Change() {
		return (EReference)partialRuleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSubRule() {
		return subRuleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSubRule_RepairOperation() {
		return (EReference)subRuleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSubRule_Match() {
		return (EReference)subRuleEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getComplementRule() {
		return complementRuleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComplementRule_RepairOperation() {
		return (EReference)complementRuleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRepair() {
		return repairEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRepair_RepairOperation() {
		return (EReference)repairEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRepairMatch() {
		return repairMatchEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRepairParameter() {
		return repairParameterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRepairParameter_Change() {
		return (EReference)repairParameterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRepairParameter_Domain() {
		return (EReference)repairParameterEClass.getEStructuralFeatures().get(1);
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
	public EReference getChange_Element() {
		return (EReference)changeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMatch() {
		return matchEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMatch_Change() {
		return (EReference)matchEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMatch_Elements() {
		return (EReference)matchEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RepairjobFactory getRepairjobFactory() {
		return (RepairjobFactory)getEFactoryInstance();
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
		repairJobEClass = createEClass(REPAIR_JOB);
		createEReference(repairJobEClass, REPAIR_JOB__DIFFERENCE);
		createEReference(repairJobEClass, REPAIR_JOB__EDIT_RULES);

		editRuleEClass = createEClass(EDIT_RULE);
		createEReference(editRuleEClass, EDIT_RULE__RULE);
		createEReference(editRuleEClass, EDIT_RULE__REPAIR_JOB);
		createEReference(editRuleEClass, EDIT_RULE__REPAIR_OPERATIONS);
		createEOperation(editRuleEClass, EDIT_RULE___GET_RATING);

		repairOperationEClass = createEClass(REPAIR_OPERATION);
		createEReference(repairOperationEClass, REPAIR_OPERATION__CONTEXT);
		createEReference(repairOperationEClass, REPAIR_OPERATION__EDIT_RULE);
		createEReference(repairOperationEClass, REPAIR_OPERATION__SUB_RULE);
		createEReference(repairOperationEClass, REPAIR_OPERATION__COMPLEMENT_RULE);
		createEReference(repairOperationEClass, REPAIR_OPERATION__REPAIRS);
		createEOperation(repairOperationEClass, REPAIR_OPERATION___GET_RATING);

		partialRuleEClass = createEClass(PARTIAL_RULE);
		createEReference(partialRuleEClass, PARTIAL_RULE__CHANGE);

		subRuleEClass = createEClass(SUB_RULE);
		createEReference(subRuleEClass, SUB_RULE__REPAIR_OPERATION);
		createEReference(subRuleEClass, SUB_RULE__MATCH);

		complementRuleEClass = createEClass(COMPLEMENT_RULE);
		createEReference(complementRuleEClass, COMPLEMENT_RULE__REPAIR_OPERATION);

		repairEClass = createEClass(REPAIR);
		createEReference(repairEClass, REPAIR__REPAIR_OPERATION);

		repairMatchEClass = createEClass(REPAIR_MATCH);

		repairParameterEClass = createEClass(REPAIR_PARAMETER);
		createEReference(repairParameterEClass, REPAIR_PARAMETER__CHANGE);
		createEReference(repairParameterEClass, REPAIR_PARAMETER__DOMAIN);

		changeEClass = createEClass(CHANGE);
		createEReference(changeEClass, CHANGE__ELEMENT);

		matchEClass = createEClass(MATCH);
		createEReference(matchEClass, MATCH__CHANGE);
		createEReference(matchEClass, MATCH__ELEMENTS);
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
		SymmetricPackage theSymmetricPackage = (SymmetricPackage)EPackage.Registry.INSTANCE.getEPackage(SymmetricPackage.eNS_URI);
		HenshinPackage theHenshinPackage = (HenshinPackage)EPackage.Registry.INSTANCE.getEPackage(HenshinPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		subRuleEClass.getESuperTypes().add(this.getPartialRule());
		complementRuleEClass.getESuperTypes().add(this.getPartialRule());
		repairMatchEClass.getESuperTypes().add(this.getRepair());
		repairMatchEClass.getESuperTypes().add(this.getMatch());
		repairParameterEClass.getESuperTypes().add(this.getRepair());

		// Initialize classes, features, and operations; add parameters
		initEClass(repairJobEClass, RepairJob.class, "RepairJob", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRepairJob_Difference(), theSymmetricPackage.getSymmetricDifference(), null, "difference", null, 0, 1, RepairJob.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRepairJob_EditRules(), this.getEditRule(), this.getEditRule_RepairJob(), "editRules", null, 0, -1, RepairJob.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(editRuleEClass, EditRule.class, "EditRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEditRule_Rule(), theHenshinPackage.getRule(), null, "rule", null, 0, 1, EditRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEditRule_RepairJob(), this.getRepairJob(), this.getRepairJob_EditRules(), "repairJob", null, 0, 1, EditRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEditRule_RepairOperations(), this.getRepairOperation(), this.getRepairOperation_EditRule(), "repairOperations", null, 0, -1, EditRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getEditRule__GetRating(), ecorePackage.getEDouble(), "getRating", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(repairOperationEClass, RepairOperation.class, "RepairOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRepairOperation_Context(), ecorePackage.getEObject(), null, "context", null, 0, 1, RepairOperation.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getRepairOperation_EditRule(), this.getEditRule(), this.getEditRule_RepairOperations(), "editRule", null, 0, 1, RepairOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRepairOperation_SubRule(), this.getSubRule(), this.getSubRule_RepairOperation(), "subRule", null, 0, 1, RepairOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRepairOperation_ComplementRule(), this.getComplementRule(), this.getComplementRule_RepairOperation(), "complementRule", null, 0, 1, RepairOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRepairOperation_Repairs(), this.getRepair(), this.getRepair_RepairOperation(), "repairs", null, 0, -1, RepairOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getRepairOperation__GetRating(), ecorePackage.getEDouble(), "getRating", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(partialRuleEClass, PartialRule.class, "PartialRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPartialRule_Change(), this.getChange(), null, "change", null, 0, -1, PartialRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(subRuleEClass, SubRule.class, "SubRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSubRule_RepairOperation(), this.getRepairOperation(), this.getRepairOperation_SubRule(), "repairOperation", null, 0, 1, SubRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSubRule_Match(), this.getMatch(), null, "match", null, 0, 1, SubRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(complementRuleEClass, ComplementRule.class, "ComplementRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getComplementRule_RepairOperation(), this.getRepairOperation(), this.getRepairOperation_ComplementRule(), "repairOperation", null, 0, 1, ComplementRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(repairEClass, Repair.class, "Repair", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRepair_RepairOperation(), this.getRepairOperation(), this.getRepairOperation_Repairs(), "repairOperation", null, 0, 1, Repair.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(repairMatchEClass, RepairMatch.class, "RepairMatch", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(repairParameterEClass, RepairParameter.class, "RepairParameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRepairParameter_Change(), this.getChange(), null, "change", null, 0, 1, RepairParameter.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getRepairParameter_Domain(), ecorePackage.getEObject(), null, "domain", null, 0, 1, RepairParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(changeEClass, Change.class, "Change", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getChange_Element(), theHenshinPackage.getGraphElement(), null, "element", null, 0, 1, Change.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(matchEClass, Match.class, "Match", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMatch_Change(), this.getChange(), null, "change", null, 0, -1, Match.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getMatch_Elements(), ecorePackage.getEObject(), null, "elements", null, 0, -1, Match.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //RepairjobPackageImpl
