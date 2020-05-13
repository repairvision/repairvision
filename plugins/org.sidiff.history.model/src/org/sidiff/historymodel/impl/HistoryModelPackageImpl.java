/**
 */
package org.sidiff.historymodel.impl;

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
import org.sidiff.historymodel.Annotation;
import org.sidiff.historymodel.ChangeSet;
import org.sidiff.historymodel.History;
import org.sidiff.historymodel.HistoryModelFactory;
import org.sidiff.historymodel.HistoryModelPackage;
import org.sidiff.historymodel.ModelStatus;
import org.sidiff.historymodel.ModificationClassification;
import org.sidiff.historymodel.Problem;
import org.sidiff.historymodel.ProblemSeverity;
import org.sidiff.historymodel.Version;

import org.sidiff.revision.difference.DifferencePackage;

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
	private EClass problemEClass = null;

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
	private EClass annotationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum problemSeverityEEnum = null;

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
	private EEnum modificationClassificationEEnum = null;

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
	 * @see org.sidiff.historymodel.HistoryModelPackage#eNS_URI
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
		Object registeredHistoryModelPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		HistoryModelPackageImpl theHistoryModelPackage = registeredHistoryModelPackage instanceof HistoryModelPackageImpl ? (HistoryModelPackageImpl)registeredHistoryModelPackage : new HistoryModelPackageImpl();

		isInited = true;

		// Initialize simple dependencies
		DifferencePackage.eINSTANCE.eClass();
		EcorePackage.eINSTANCE.eClass();

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
	@Override
	public EClass getHistory() {
		return historyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getHistory_Name() {
		return (EAttribute)historyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getHistory_Versions() {
		return (EReference)historyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getHistory_AllProblems() {
		return (EReference)historyEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getHistory__GetPredecessorVersions__Version() {
		return historyEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getHistory__GetSuccessorVersions__Version() {
		return historyEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getHistory__GetProblems__boolean_boolean() {
		return historyEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getHistory__GetUniqueProblems() {
		return historyEClass.getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getVersion() {
		return versionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getVersion_Problems() {
		return (EReference)versionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getVersion_Name() {
		return (EAttribute)versionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getVersion_ModelURI() {
		return (EAttribute)versionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getVersion_Model() {
		return (EAttribute)versionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getVersion_Status() {
		return (EAttribute)versionEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getVersion_RepositoryVersion() {
		return (EAttribute)versionEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getVersion_History() {
		return (EReference)versionEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getVersion__GetElement__String() {
		return versionEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getVersion__GetPredecessor() {
		return versionEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getVersion__GetSuccessor() {
		return versionEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getVersion__GetIndex() {
		return versionEClass.getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getProblem() {
		return problemEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getProblem_Version() {
		return (EReference)problemEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getProblem_Name() {
		return (EAttribute)problemEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getProblem_IntroducedIn() {
		return (EReference)problemEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getProblem_Introduced() {
		return (EAttribute)problemEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getProblem_ResolvedIn() {
		return (EReference)problemEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getProblem_Resolved() {
		return (EAttribute)problemEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getProblem_Message() {
		return (EAttribute)problemEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getProblem_Severity() {
		return (EAttribute)problemEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getProblem_Predecessor() {
		return (EReference)problemEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getProblem_Successor() {
		return (EReference)problemEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getProblem_InvalidElements() {
		return (EReference)problemEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getProblem_ContextElement() {
		return (EReference)problemEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getProblem_Modifications() {
		return (EReference)problemEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getProblem_ModificationClassification() {
		return (EAttribute)problemEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getProblem_Annotations() {
		return (EReference)problemEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getChangeSet() {
		return changeSetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getChangeSet_Changes() {
		return (EReference)changeSetEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getChangeSet_Name() {
		return (EAttribute)changeSetEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getAnnotation() {
		return annotationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAnnotation_Key() {
		return (EAttribute)annotationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAnnotation_Value() {
		return (EAttribute)annotationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getProblemSeverity() {
		return problemSeverityEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getModelStatus() {
		return modelStatusEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getModificationClassification() {
		return modificationClassificationEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EDataType getResource() {
		return resourceEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
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
		createEReference(historyEClass, HISTORY__ALL_PROBLEMS);
		createEOperation(historyEClass, HISTORY___GET_PREDECESSOR_VERSIONS__VERSION);
		createEOperation(historyEClass, HISTORY___GET_SUCCESSOR_VERSIONS__VERSION);
		createEOperation(historyEClass, HISTORY___GET_PROBLEMS__BOOLEAN_BOOLEAN);
		createEOperation(historyEClass, HISTORY___GET_UNIQUE_PROBLEMS);

		versionEClass = createEClass(VERSION);
		createEReference(versionEClass, VERSION__PROBLEMS);
		createEAttribute(versionEClass, VERSION__NAME);
		createEAttribute(versionEClass, VERSION__MODEL_URI);
		createEAttribute(versionEClass, VERSION__MODEL);
		createEAttribute(versionEClass, VERSION__STATUS);
		createEAttribute(versionEClass, VERSION__REPOSITORY_VERSION);
		createEReference(versionEClass, VERSION__HISTORY);
		createEOperation(versionEClass, VERSION___GET_ELEMENT__STRING);
		createEOperation(versionEClass, VERSION___GET_PREDECESSOR);
		createEOperation(versionEClass, VERSION___GET_SUCCESSOR);
		createEOperation(versionEClass, VERSION___GET_INDEX);

		problemEClass = createEClass(PROBLEM);
		createEReference(problemEClass, PROBLEM__VERSION);
		createEAttribute(problemEClass, PROBLEM__NAME);
		createEReference(problemEClass, PROBLEM__INTRODUCED_IN);
		createEAttribute(problemEClass, PROBLEM__INTRODUCED);
		createEReference(problemEClass, PROBLEM__RESOLVED_IN);
		createEAttribute(problemEClass, PROBLEM__RESOLVED);
		createEAttribute(problemEClass, PROBLEM__MESSAGE);
		createEAttribute(problemEClass, PROBLEM__SEVERITY);
		createEReference(problemEClass, PROBLEM__PREDECESSOR);
		createEReference(problemEClass, PROBLEM__SUCCESSOR);
		createEReference(problemEClass, PROBLEM__INVALID_ELEMENTS);
		createEReference(problemEClass, PROBLEM__CONTEXT_ELEMENT);
		createEReference(problemEClass, PROBLEM__MODIFICATIONS);
		createEAttribute(problemEClass, PROBLEM__MODIFICATION_CLASSIFICATION);
		createEReference(problemEClass, PROBLEM__ANNOTATIONS);

		changeSetEClass = createEClass(CHANGE_SET);
		createEReference(changeSetEClass, CHANGE_SET__CHANGES);
		createEAttribute(changeSetEClass, CHANGE_SET__NAME);

		annotationEClass = createEClass(ANNOTATION);
		createEAttribute(annotationEClass, ANNOTATION__KEY);
		createEAttribute(annotationEClass, ANNOTATION__VALUE);

		// Create enums
		problemSeverityEEnum = createEEnum(PROBLEM_SEVERITY);
		modelStatusEEnum = createEEnum(MODEL_STATUS);
		modificationClassificationEEnum = createEEnum(MODIFICATION_CLASSIFICATION);

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
		EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);
		DifferencePackage theDifferencePackage = (DifferencePackage)EPackage.Registry.INSTANCE.getEPackage(DifferencePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes, features, and operations; add parameters
		initEClass(historyEClass, History.class, "History", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getHistory_Name(), ecorePackage.getEString(), "name", null, 0, 1, History.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getHistory_Versions(), this.getVersion(), this.getVersion_History(), "versions", null, 0, -1, History.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getHistory_AllProblems(), this.getProblem(), null, "allProblems", null, 0, -1, History.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		EOperation op = initEOperation(getHistory__GetPredecessorVersions__Version(), this.getVersion(), "getPredecessorVersions", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getVersion(), "version", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getHistory__GetSuccessorVersions__Version(), this.getVersion(), "getSuccessorVersions", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getVersion(), "version", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getHistory__GetProblems__boolean_boolean(), this.getProblem(), "getProblems", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEBoolean(), "introduced", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEBoolean(), "resolved", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getHistory__GetUniqueProblems(), this.getProblem(), "getUniqueProblems", 0, -1, IS_UNIQUE, IS_ORDERED);

		initEClass(versionEClass, Version.class, "Version", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getVersion_Problems(), this.getProblem(), this.getProblem_Version(), "problems", null, 0, -1, Version.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVersion_Name(), ecorePackage.getEString(), "name", null, 0, 1, Version.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVersion_ModelURI(), ecorePackage.getEString(), "modelURI", null, 0, 1, Version.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVersion_Model(), this.getResource(), "model", null, 0, 1, Version.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getVersion_Status(), this.getModelStatus(), "status", "UNKNOWN", 0, 1, Version.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVersion_RepositoryVersion(), theEcorePackage.getEString(), "repositoryVersion", null, 0, 1, Version.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getVersion_History(), this.getHistory(), this.getHistory_Versions(), "history", null, 0, 1, Version.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getVersion__GetElement__String(), ecorePackage.getEObject(), "getElement", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "id", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getVersion__GetPredecessor(), this.getVersion(), "getPredecessor", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getVersion__GetSuccessor(), this.getVersion(), "getSuccessor", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getVersion__GetIndex(), theEcorePackage.getEInt(), "getIndex", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(problemEClass, Problem.class, "Problem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getProblem_Version(), this.getVersion(), this.getVersion_Problems(), "version", null, 0, 1, Problem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProblem_Name(), ecorePackage.getEString(), "name", null, 0, 1, Problem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getProblem_IntroducedIn(), this.getVersion(), null, "introducedIn", null, 0, 1, Problem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProblem_Introduced(), ecorePackage.getEBoolean(), "introduced", null, 0, 1, Problem.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getProblem_ResolvedIn(), this.getVersion(), null, "resolvedIn", null, 0, 1, Problem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProblem_Resolved(), ecorePackage.getEBoolean(), "resolved", null, 0, 1, Problem.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getProblem_Message(), ecorePackage.getEString(), "message", null, 0, 1, Problem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProblem_Severity(), this.getProblemSeverity(), "severity", "UNKNOWN", 0, 1, Problem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getProblem_Predecessor(), this.getProblem(), this.getProblem_Successor(), "predecessor", null, 0, 1, Problem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getProblem_Successor(), this.getProblem(), this.getProblem_Predecessor(), "successor", null, 0, 1, Problem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getProblem_InvalidElements(), ecorePackage.getEObject(), null, "invalidElements", null, 0, -1, Problem.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getProblem_ContextElement(), ecorePackage.getEObject(), null, "contextElement", null, 0, 1, Problem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getProblem_Modifications(), this.getChangeSet(), null, "modifications", null, 0, -1, Problem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProblem_ModificationClassification(), this.getModificationClassification(), "modificationClassification", "UNKNOWN", 0, -1, Problem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getProblem_Annotations(), this.getAnnotation(), null, "annotations", null, 0, -1, Problem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(changeSetEClass, ChangeSet.class, "ChangeSet", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getChangeSet_Changes(), theDifferencePackage.getChange(), null, "changes", null, 0, -1, ChangeSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getChangeSet_Name(), theEcorePackage.getEString(), "name", null, 0, 1, ChangeSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(annotationEClass, Annotation.class, "Annotation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAnnotation_Key(), ecorePackage.getEString(), "key", null, 0, 1, Annotation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAnnotation_Value(), theEcorePackage.getEString(), "value", null, 0, 1, Annotation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(problemSeverityEEnum, ProblemSeverity.class, "ProblemSeverity");
		addEEnumLiteral(problemSeverityEEnum, ProblemSeverity.UNKNOWN);
		addEEnumLiteral(problemSeverityEEnum, ProblemSeverity.ERROR);
		addEEnumLiteral(problemSeverityEEnum, ProblemSeverity.WARNING);

		initEEnum(modelStatusEEnum, ModelStatus.class, "ModelStatus");
		addEEnumLiteral(modelStatusEEnum, ModelStatus.UNKNOWN);
		addEEnumLiteral(modelStatusEEnum, ModelStatus.VALID);
		addEEnumLiteral(modelStatusEEnum, ModelStatus.INVALID);
		addEEnumLiteral(modelStatusEEnum, ModelStatus.DEFECT);

		initEEnum(modificationClassificationEEnum, ModificationClassification.class, "ModificationClassification");
		addEEnumLiteral(modificationClassificationEEnum, ModificationClassification.UNKNOWN);
		addEEnumLiteral(modificationClassificationEEnum, ModificationClassification.UNDO);
		addEEnumLiteral(modificationClassificationEEnum, ModificationClassification.COMPLETION);
		addEEnumLiteral(modificationClassificationEEnum, ModificationClassification.CORRECTION);
		addEEnumLiteral(modificationClassificationEEnum, ModificationClassification.OVERWRITE);
		addEEnumLiteral(modificationClassificationEEnum, ModificationClassification.SET);
		addEEnumLiteral(modificationClassificationEEnum, ModificationClassification.UNSET);

		// Initialize data types
		initEDataType(resourceEDataType, Resource.class, "Resource", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //HistoryModelPackageImpl
