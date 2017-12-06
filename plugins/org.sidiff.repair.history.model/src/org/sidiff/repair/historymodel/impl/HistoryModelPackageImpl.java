/**
 */
package org.sidiff.repair.historymodel.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.emf.ecore.resource.Resource;
import org.sidiff.difference.symmetric.SymmetricPackage;

import org.sidiff.matching.model.MatchingModelPackage;
import org.sidiff.repair.historymodel.ChangeSet;
import org.sidiff.repair.historymodel.History;
import org.sidiff.repair.historymodel.HistoryModelFactory;
import org.sidiff.repair.historymodel.HistoryModelPackage;
import org.sidiff.repair.historymodel.ModelStatus;
import org.sidiff.repair.historymodel.ValidationError;
import org.sidiff.repair.historymodel.ValidationSeverity;
import org.sidiff.repair.historymodel.Version;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class HistoryModelPackageImpl extends EPackageImpl implements HistoryModelPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass historyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass versionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass validationErrorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass changeSetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum validationSeverityEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum modelStatusEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType resourceEDataType = null;

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
	 * @see org.sidiff.repair.historymodel.HistoryModelPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private HistoryModelPackageImpl() {
		super(eNS_URI, HistoryModelFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link HistoryModelPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static HistoryModelPackage init() {
		if (isInited) return (HistoryModelPackage)EPackage.Registry.INSTANCE.getEPackage(HistoryModelPackage.eNS_URI);

		// Obtain or create and register package
		HistoryModelPackageImpl theHistoryModelPackage = (HistoryModelPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof HistoryModelPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new HistoryModelPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		EcorePackage.eINSTANCE.eClass();
		MatchingModelPackage.eINSTANCE.eClass();
		SymmetricPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theHistoryModelPackage.createPackageContents();

		// Initialize created meta-data
		theHistoryModelPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theHistoryModelPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(HistoryModelPackage.eNS_URI, theHistoryModelPackage);
		return theHistoryModelPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getHistory() {
		return historyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getHistory_Name() {
		return (EAttribute)historyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getHistory_Versions() {
		return (EReference)historyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getHistory_AllValidationErrors() {
		return (EReference)historyEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getHistory__GetPrecessorRevisions__Version() {
		return historyEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getHistory__GetSuccessorRevisions__Version() {
		return historyEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getHistory__GetValidationErrors__boolean_boolean() {
		return historyEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getHistory__GetUniqueValidationErrors() {
		return historyEClass.getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVersion() {
		return versionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVersion_ValidationErrors() {
		return (EReference)versionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVersion_Name() {
		return (EAttribute)versionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVersion_ModelURI() {
		return (EAttribute)versionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVersion_Model() {
		return (EAttribute)versionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVersion_Status() {
		return (EAttribute)versionEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getVersion__GetElement__String() {
		return versionEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getValidationError() {
		return validationErrorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getValidationError_Name() {
		return (EAttribute)validationErrorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getValidationError_IntroducedIn() {
		return (EReference)validationErrorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getValidationError_ResolvedIn() {
		return (EReference)validationErrorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getValidationError_Message() {
		return (EAttribute)validationErrorEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getValidationError_Source() {
		return (EAttribute)validationErrorEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getValidationError_Severity() {
		return (EAttribute)validationErrorEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getValidationError_Introduced() {
		return (EAttribute)validationErrorEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getValidationError_Resolved() {
		return (EAttribute)validationErrorEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getValidationError_Prec() {
		return (EReference)validationErrorEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getValidationError_Succ() {
		return (EReference)validationErrorEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getValidationError_InvalidElement() {
		return (EReference)validationErrorEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getValidationError_Context() {
		return (EReference)validationErrorEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getValidationError_ResolvedByUndo() {
		return (EAttribute)validationErrorEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getValidationError_ChangeSets() {
		return (EReference)validationErrorEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getChangeSet() {
		return changeSetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getChangeSet_Changes() {
		return (EReference)changeSetEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getChangeSet_Name() {
		return (EAttribute)changeSetEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getValidationSeverity() {
		return validationSeverityEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getModelStatus() {
		return modelStatusEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getResource() {
		return resourceEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HistoryModelFactory getHistoryModelFactory() {
		return (HistoryModelFactory)getEFactoryInstance();
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
		historyEClass = createEClass(HISTORY);
		createEAttribute(historyEClass, HISTORY__NAME);
		createEReference(historyEClass, HISTORY__VERSIONS);
		createEReference(historyEClass, HISTORY__ALL_VALIDATION_ERRORS);
		createEOperation(historyEClass, HISTORY___GET_PRECESSOR_REVISIONS__VERSION);
		createEOperation(historyEClass, HISTORY___GET_SUCCESSOR_REVISIONS__VERSION);
		createEOperation(historyEClass, HISTORY___GET_VALIDATION_ERRORS__BOOLEAN_BOOLEAN);
		createEOperation(historyEClass, HISTORY___GET_UNIQUE_VALIDATION_ERRORS);

		versionEClass = createEClass(VERSION);
		createEReference(versionEClass, VERSION__VALIDATION_ERRORS);
		createEAttribute(versionEClass, VERSION__NAME);
		createEAttribute(versionEClass, VERSION__MODEL_URI);
		createEAttribute(versionEClass, VERSION__MODEL);
		createEAttribute(versionEClass, VERSION__STATUS);
		createEOperation(versionEClass, VERSION___GET_ELEMENT__STRING);

		validationErrorEClass = createEClass(VALIDATION_ERROR);
		createEAttribute(validationErrorEClass, VALIDATION_ERROR__NAME);
		createEReference(validationErrorEClass, VALIDATION_ERROR__INTRODUCED_IN);
		createEReference(validationErrorEClass, VALIDATION_ERROR__RESOLVED_IN);
		createEAttribute(validationErrorEClass, VALIDATION_ERROR__MESSAGE);
		createEAttribute(validationErrorEClass, VALIDATION_ERROR__SOURCE);
		createEAttribute(validationErrorEClass, VALIDATION_ERROR__SEVERITY);
		createEAttribute(validationErrorEClass, VALIDATION_ERROR__INTRODUCED);
		createEAttribute(validationErrorEClass, VALIDATION_ERROR__RESOLVED);
		createEReference(validationErrorEClass, VALIDATION_ERROR__PREC);
		createEReference(validationErrorEClass, VALIDATION_ERROR__SUCC);
		createEReference(validationErrorEClass, VALIDATION_ERROR__INVALID_ELEMENT);
		createEReference(validationErrorEClass, VALIDATION_ERROR__CONTEXT);
		createEAttribute(validationErrorEClass, VALIDATION_ERROR__RESOLVED_BY_UNDO);
		createEReference(validationErrorEClass, VALIDATION_ERROR__CHANGE_SETS);

		changeSetEClass = createEClass(CHANGE_SET);
		createEReference(changeSetEClass, CHANGE_SET__CHANGES);
		createEAttribute(changeSetEClass, CHANGE_SET__NAME);

		// Create enums
		validationSeverityEEnum = createEEnum(VALIDATION_SEVERITY);
		modelStatusEEnum = createEEnum(MODEL_STATUS);

		// Create data types
		resourceEDataType = createEDataType(RESOURCE);
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
		EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes, features, and operations; add parameters
		initEClass(historyEClass, History.class, "History", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getHistory_Name(), ecorePackage.getEString(), "name", null, 0, 1, History.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getHistory_Versions(), this.getVersion(), null, "versions", null, 0, -1, History.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getHistory_AllValidationErrors(), this.getValidationError(), null, "allValidationErrors", null, 0, -1, History.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		EOperation op = initEOperation(getHistory__GetPrecessorRevisions__Version(), this.getVersion(), "getPrecessorRevisions", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getVersion(), "version", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getHistory__GetSuccessorRevisions__Version(), this.getVersion(), "getSuccessorRevisions", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getVersion(), "version", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getHistory__GetValidationErrors__boolean_boolean(), this.getValidationError(), "getValidationErrors", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEBoolean(), "introduced", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEBoolean(), "resolved", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getHistory__GetUniqueValidationErrors(), this.getValidationError(), "getUniqueValidationErrors", 0, -1, IS_UNIQUE, IS_ORDERED);

		initEClass(versionEClass, Version.class, "Version", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getVersion_ValidationErrors(), this.getValidationError(), null, "validationErrors", null, 0, -1, Version.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVersion_Name(), ecorePackage.getEString(), "name", null, 0, 1, Version.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVersion_ModelURI(), ecorePackage.getEString(), "modelURI", null, 0, 1, Version.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVersion_Model(), this.getResource(), "model", null, 0, 1, Version.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getVersion_Status(), this.getModelStatus(), "status", "UNKNOWN", 0, 1, Version.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getVersion__GetElement__String(), ecorePackage.getEObject(), "getElement", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "id", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(validationErrorEClass, ValidationError.class, "ValidationError", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getValidationError_Name(), ecorePackage.getEString(), "name", null, 0, 1, ValidationError.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getValidationError_IntroducedIn(), this.getVersion(), null, "introducedIn", null, 0, 1, ValidationError.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getValidationError_ResolvedIn(), this.getVersion(), null, "resolvedIn", null, 0, 1, ValidationError.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getValidationError_Message(), ecorePackage.getEString(), "message", null, 0, 1, ValidationError.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getValidationError_Source(), ecorePackage.getEString(), "source", null, 0, 1, ValidationError.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getValidationError_Severity(), this.getValidationSeverity(), "severity", "UNKNOWN", 0, 1, ValidationError.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getValidationError_Introduced(), ecorePackage.getEBoolean(), "introduced", null, 0, 1, ValidationError.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getValidationError_Resolved(), ecorePackage.getEBoolean(), "resolved", null, 0, 1, ValidationError.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getValidationError_Prec(), this.getValidationError(), this.getValidationError_Succ(), "prec", null, 0, 1, ValidationError.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getValidationError_Succ(), this.getValidationError(), this.getValidationError_Prec(), "succ", null, 0, 1, ValidationError.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getValidationError_InvalidElement(), ecorePackage.getEObject(), null, "invalidElement", null, 0, -1, ValidationError.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getValidationError_Context(), ecorePackage.getEObject(), null, "context", null, 0, 1, ValidationError.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getValidationError_ResolvedByUndo(), ecorePackage.getEBoolean(), "resolvedByUndo", null, 0, 1, ValidationError.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getValidationError_ChangeSets(), this.getChangeSet(), null, "changeSets", null, 0, -1, ValidationError.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(changeSetEClass, ChangeSet.class, "ChangeSet", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getChangeSet_Changes(), theSymmetricPackage.getChange(), null, "changes", null, 0, -1, ChangeSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getChangeSet_Name(), theEcorePackage.getEString(), "name", null, 0, 1, ChangeSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(validationSeverityEEnum, ValidationSeverity.class, "ValidationSeverity");
		addEEnumLiteral(validationSeverityEEnum, ValidationSeverity.ERROR);
		addEEnumLiteral(validationSeverityEEnum, ValidationSeverity.WARNING);
		addEEnumLiteral(validationSeverityEEnum, ValidationSeverity.UNKNOWN);

		initEEnum(modelStatusEEnum, ModelStatus.class, "ModelStatus");
		addEEnumLiteral(modelStatusEEnum, ModelStatus.VALID);
		addEEnumLiteral(modelStatusEEnum, ModelStatus.INVALID);
		addEEnumLiteral(modelStatusEEnum, ModelStatus.DEFECT);
		addEEnumLiteral(modelStatusEEnum, ModelStatus.UNKNOWN);

		// Initialize data types
		initEDataType(resourceEDataType, Resource.class, "Resource", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //HistoryModelPackageImpl
