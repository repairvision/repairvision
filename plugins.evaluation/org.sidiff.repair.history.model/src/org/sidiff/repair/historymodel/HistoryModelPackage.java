/**
 */
package org.sidiff.repair.historymodel;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.sidiff.repair.historymodel.HistoryModelFactory
 * @model kind="package"
 * @generated
 */
public interface HistoryModelPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "historymodel";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.sidiff.org/repair/history/model";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "historymodel";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	HistoryModelPackage eINSTANCE = org.sidiff.repair.historymodel.impl.HistoryModelPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.sidiff.repair.historymodel.impl.HistoryImpl <em>History</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.repair.historymodel.impl.HistoryImpl
	 * @see org.sidiff.repair.historymodel.impl.HistoryModelPackageImpl#getHistory()
	 * @generated
	 */
	int HISTORY = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HISTORY__NAME = 0;

	/**
	 * The feature id for the '<em><b>Versions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HISTORY__VERSIONS = 1;

	/**
	 * The feature id for the '<em><b>Technical Differences</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HISTORY__TECHNICAL_DIFFERENCES = 2;

	/**
	 * The feature id for the '<em><b>All Validation Errors</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HISTORY__ALL_VALIDATION_ERRORS = 3;

	/**
	 * The number of structural features of the '<em>History</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HISTORY_FEATURE_COUNT = 4;

	/**
	 * The operation id for the '<em>Get Precessor Revisions</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HISTORY___GET_PRECESSOR_REVISIONS__VERSION = 0;

	/**
	 * The operation id for the '<em>Get Successor Revisions</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HISTORY___GET_SUCCESSOR_REVISIONS__VERSION = 1;

	/**
	 * The operation id for the '<em>Get Technical Difference</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HISTORY___GET_TECHNICAL_DIFFERENCE__VERSION_VERSION = 2;

	/**
	 * The operation id for the '<em>Get Validation Errors</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HISTORY___GET_VALIDATION_ERRORS__BOOLEAN_BOOLEAN = 3;

	/**
	 * The operation id for the '<em>Get Unique Validation Errors</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HISTORY___GET_UNIQUE_VALIDATION_ERRORS = 4;

	/**
	 * The number of operations of the '<em>History</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HISTORY_OPERATION_COUNT = 5;

	/**
	 * The meta object id for the '{@link org.sidiff.repair.historymodel.impl.VersionImpl <em>Version</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.repair.historymodel.impl.VersionImpl
	 * @see org.sidiff.repair.historymodel.impl.HistoryModelPackageImpl#getVersion()
	 * @generated
	 */
	int VERSION = 1;

	/**
	 * The feature id for the '<em><b>Validation Errors</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERSION__VALIDATION_ERRORS = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERSION__NAME = 1;

	/**
	 * The feature id for the '<em><b>Id2 Element</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERSION__ID2_ELEMENT = 2;

	/**
	 * The feature id for the '<em><b>Model URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERSION__MODEL_URI = 3;

	/**
	 * The feature id for the '<em><b>Model</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERSION__MODEL = 4;

	/**
	 * The feature id for the '<em><b>Status</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERSION__STATUS = 5;

	/**
	 * The number of structural features of the '<em>Version</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERSION_FEATURE_COUNT = 6;

	/**
	 * The operation id for the '<em>Get Element</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERSION___GET_ELEMENT__STRING = 0;

	/**
	 * The number of operations of the '<em>Version</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERSION_OPERATION_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.sidiff.repair.historymodel.impl.ValidationErrorImpl <em>Validation Error</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.repair.historymodel.impl.ValidationErrorImpl
	 * @see org.sidiff.repair.historymodel.impl.HistoryModelPackageImpl#getValidationError()
	 * @generated
	 */
	int VALIDATION_ERROR = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALIDATION_ERROR__NAME = 0;

	/**
	 * The feature id for the '<em><b>Introduced In</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALIDATION_ERROR__INTRODUCED_IN = 1;

	/**
	 * The feature id for the '<em><b>Resolved In</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALIDATION_ERROR__RESOLVED_IN = 2;

	/**
	 * The feature id for the '<em><b>Message</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALIDATION_ERROR__MESSAGE = 3;

	/**
	 * The feature id for the '<em><b>Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALIDATION_ERROR__SOURCE = 4;

	/**
	 * The feature id for the '<em><b>Severity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALIDATION_ERROR__SEVERITY = 5;

	/**
	 * The feature id for the '<em><b>Introduced</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALIDATION_ERROR__INTRODUCED = 6;

	/**
	 * The feature id for the '<em><b>Resolved</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALIDATION_ERROR__RESOLVED = 7;

	/**
	 * The feature id for the '<em><b>Prec</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALIDATION_ERROR__PREC = 8;

	/**
	 * The feature id for the '<em><b>Succ</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALIDATION_ERROR__SUCC = 9;

	/**
	 * The feature id for the '<em><b>Invalid Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALIDATION_ERROR__INVALID_ELEMENT = 10;

	/**
	 * The feature id for the '<em><b>Context</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALIDATION_ERROR__CONTEXT = 11;

	/**
	 * The number of structural features of the '<em>Validation Error</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALIDATION_ERROR_FEATURE_COUNT = 12;

	/**
	 * The number of operations of the '<em>Validation Error</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALIDATION_ERROR_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.sidiff.repair.historymodel.ValidationSeverity <em>Validation Severity</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.repair.historymodel.ValidationSeverity
	 * @see org.sidiff.repair.historymodel.impl.HistoryModelPackageImpl#getValidationSeverity()
	 * @generated
	 */
	int VALIDATION_SEVERITY = 3;

	/**
	 * The meta object id for the '{@link org.sidiff.repair.historymodel.ModelStatus <em>Model Status</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.repair.historymodel.ModelStatus
	 * @see org.sidiff.repair.historymodel.impl.HistoryModelPackageImpl#getModelStatus()
	 * @generated
	 */
	int MODEL_STATUS = 4;

	/**
	 * The meta object id for the '<em>Resource</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.resource.Resource
	 * @see org.sidiff.repair.historymodel.impl.HistoryModelPackageImpl#getResource()
	 * @generated
	 */
	int RESOURCE = 5;

	/**
	 * Returns the meta object for class '{@link org.sidiff.repair.historymodel.History <em>History</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>History</em>'.
	 * @see org.sidiff.repair.historymodel.History
	 * @generated
	 */
	EClass getHistory();

	/**
	 * Returns the meta object for the attribute '{@link org.sidiff.repair.historymodel.History#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.sidiff.repair.historymodel.History#getName()
	 * @see #getHistory()
	 * @generated
	 */
	EAttribute getHistory_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sidiff.repair.historymodel.History#getVersions <em>Versions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Versions</em>'.
	 * @see org.sidiff.repair.historymodel.History#getVersions()
	 * @see #getHistory()
	 * @generated
	 */
	EReference getHistory_Versions();

	/**
	 * Returns the meta object for the reference list '{@link org.sidiff.repair.historymodel.History#getTechnicalDifferences <em>Technical Differences</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Technical Differences</em>'.
	 * @see org.sidiff.repair.historymodel.History#getTechnicalDifferences()
	 * @see #getHistory()
	 * @generated
	 */
	EReference getHistory_TechnicalDifferences();

	/**
	 * Returns the meta object for the reference list '{@link org.sidiff.repair.historymodel.History#getAllValidationErrors <em>All Validation Errors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>All Validation Errors</em>'.
	 * @see org.sidiff.repair.historymodel.History#getAllValidationErrors()
	 * @see #getHistory()
	 * @generated
	 */
	EReference getHistory_AllValidationErrors();

	/**
	 * Returns the meta object for the '{@link org.sidiff.repair.historymodel.History#getPrecessorRevisions(org.sidiff.repair.historymodel.Version) <em>Get Precessor Revisions</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Precessor Revisions</em>' operation.
	 * @see org.sidiff.repair.historymodel.History#getPrecessorRevisions(org.sidiff.repair.historymodel.Version)
	 * @generated
	 */
	EOperation getHistory__GetPrecessorRevisions__Version();

	/**
	 * Returns the meta object for the '{@link org.sidiff.repair.historymodel.History#getSuccessorRevisions(org.sidiff.repair.historymodel.Version) <em>Get Successor Revisions</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Successor Revisions</em>' operation.
	 * @see org.sidiff.repair.historymodel.History#getSuccessorRevisions(org.sidiff.repair.historymodel.Version)
	 * @generated
	 */
	EOperation getHistory__GetSuccessorRevisions__Version();

	/**
	 * Returns the meta object for the '{@link org.sidiff.repair.historymodel.History#getTechnicalDifference(org.sidiff.repair.historymodel.Version, org.sidiff.repair.historymodel.Version) <em>Get Technical Difference</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Technical Difference</em>' operation.
	 * @see org.sidiff.repair.historymodel.History#getTechnicalDifference(org.sidiff.repair.historymodel.Version, org.sidiff.repair.historymodel.Version)
	 * @generated
	 */
	EOperation getHistory__GetTechnicalDifference__Version_Version();

	/**
	 * Returns the meta object for the '{@link org.sidiff.repair.historymodel.History#getValidationErrors(boolean, boolean) <em>Get Validation Errors</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Validation Errors</em>' operation.
	 * @see org.sidiff.repair.historymodel.History#getValidationErrors(boolean, boolean)
	 * @generated
	 */
	EOperation getHistory__GetValidationErrors__boolean_boolean();

	/**
	 * Returns the meta object for the '{@link org.sidiff.repair.historymodel.History#getUniqueValidationErrors() <em>Get Unique Validation Errors</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Unique Validation Errors</em>' operation.
	 * @see org.sidiff.repair.historymodel.History#getUniqueValidationErrors()
	 * @generated
	 */
	EOperation getHistory__GetUniqueValidationErrors();

	/**
	 * Returns the meta object for class '{@link org.sidiff.repair.historymodel.Version <em>Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Version</em>'.
	 * @see org.sidiff.repair.historymodel.Version
	 * @generated
	 */
	EClass getVersion();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sidiff.repair.historymodel.Version#getValidationErrors <em>Validation Errors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Validation Errors</em>'.
	 * @see org.sidiff.repair.historymodel.Version#getValidationErrors()
	 * @see #getVersion()
	 * @generated
	 */
	EReference getVersion_ValidationErrors();

	/**
	 * Returns the meta object for the attribute '{@link org.sidiff.repair.historymodel.Version#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.sidiff.repair.historymodel.Version#getName()
	 * @see #getVersion()
	 * @generated
	 */
	EAttribute getVersion_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.sidiff.repair.historymodel.Version#getId2Element <em>Id2 Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id2 Element</em>'.
	 * @see org.sidiff.repair.historymodel.Version#getId2Element()
	 * @see #getVersion()
	 * @generated
	 */
	EAttribute getVersion_Id2Element();

	/**
	 * Returns the meta object for the attribute '{@link org.sidiff.repair.historymodel.Version#getModelURI <em>Model URI</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Model URI</em>'.
	 * @see org.sidiff.repair.historymodel.Version#getModelURI()
	 * @see #getVersion()
	 * @generated
	 */
	EAttribute getVersion_ModelURI();

	/**
	 * Returns the meta object for the attribute '{@link org.sidiff.repair.historymodel.Version#getModel <em>Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Model</em>'.
	 * @see org.sidiff.repair.historymodel.Version#getModel()
	 * @see #getVersion()
	 * @generated
	 */
	EAttribute getVersion_Model();

	/**
	 * Returns the meta object for the attribute '{@link org.sidiff.repair.historymodel.Version#getStatus <em>Status</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Status</em>'.
	 * @see org.sidiff.repair.historymodel.Version#getStatus()
	 * @see #getVersion()
	 * @generated
	 */
	EAttribute getVersion_Status();

	/**
	 * Returns the meta object for the '{@link org.sidiff.repair.historymodel.Version#getElement(java.lang.String) <em>Get Element</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Element</em>' operation.
	 * @see org.sidiff.repair.historymodel.Version#getElement(java.lang.String)
	 * @generated
	 */
	EOperation getVersion__GetElement__String();

	/**
	 * Returns the meta object for class '{@link org.sidiff.repair.historymodel.ValidationError <em>Validation Error</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Validation Error</em>'.
	 * @see org.sidiff.repair.historymodel.ValidationError
	 * @generated
	 */
	EClass getValidationError();

	/**
	 * Returns the meta object for the attribute '{@link org.sidiff.repair.historymodel.ValidationError#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.sidiff.repair.historymodel.ValidationError#getName()
	 * @see #getValidationError()
	 * @generated
	 */
	EAttribute getValidationError_Name();

	/**
	 * Returns the meta object for the reference '{@link org.sidiff.repair.historymodel.ValidationError#getIntroducedIn <em>Introduced In</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Introduced In</em>'.
	 * @see org.sidiff.repair.historymodel.ValidationError#getIntroducedIn()
	 * @see #getValidationError()
	 * @generated
	 */
	EReference getValidationError_IntroducedIn();

	/**
	 * Returns the meta object for the reference '{@link org.sidiff.repair.historymodel.ValidationError#getResolvedIn <em>Resolved In</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Resolved In</em>'.
	 * @see org.sidiff.repair.historymodel.ValidationError#getResolvedIn()
	 * @see #getValidationError()
	 * @generated
	 */
	EReference getValidationError_ResolvedIn();

	/**
	 * Returns the meta object for the attribute '{@link org.sidiff.repair.historymodel.ValidationError#getMessage <em>Message</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Message</em>'.
	 * @see org.sidiff.repair.historymodel.ValidationError#getMessage()
	 * @see #getValidationError()
	 * @generated
	 */
	EAttribute getValidationError_Message();

	/**
	 * Returns the meta object for the attribute '{@link org.sidiff.repair.historymodel.ValidationError#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Source</em>'.
	 * @see org.sidiff.repair.historymodel.ValidationError#getSource()
	 * @see #getValidationError()
	 * @generated
	 */
	EAttribute getValidationError_Source();

	/**
	 * Returns the meta object for the attribute '{@link org.sidiff.repair.historymodel.ValidationError#getSeverity <em>Severity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Severity</em>'.
	 * @see org.sidiff.repair.historymodel.ValidationError#getSeverity()
	 * @see #getValidationError()
	 * @generated
	 */
	EAttribute getValidationError_Severity();

	/**
	 * Returns the meta object for the attribute '{@link org.sidiff.repair.historymodel.ValidationError#isIntroduced <em>Introduced</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Introduced</em>'.
	 * @see org.sidiff.repair.historymodel.ValidationError#isIntroduced()
	 * @see #getValidationError()
	 * @generated
	 */
	EAttribute getValidationError_Introduced();

	/**
	 * Returns the meta object for the attribute '{@link org.sidiff.repair.historymodel.ValidationError#isResolved <em>Resolved</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Resolved</em>'.
	 * @see org.sidiff.repair.historymodel.ValidationError#isResolved()
	 * @see #getValidationError()
	 * @generated
	 */
	EAttribute getValidationError_Resolved();

	/**
	 * Returns the meta object for the reference '{@link org.sidiff.repair.historymodel.ValidationError#getPrec <em>Prec</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Prec</em>'.
	 * @see org.sidiff.repair.historymodel.ValidationError#getPrec()
	 * @see #getValidationError()
	 * @generated
	 */
	EReference getValidationError_Prec();

	/**
	 * Returns the meta object for the reference '{@link org.sidiff.repair.historymodel.ValidationError#getSucc <em>Succ</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Succ</em>'.
	 * @see org.sidiff.repair.historymodel.ValidationError#getSucc()
	 * @see #getValidationError()
	 * @generated
	 */
	EReference getValidationError_Succ();

	/**
	 * Returns the meta object for the reference list '{@link org.sidiff.repair.historymodel.ValidationError#getInvalidElement <em>Invalid Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Invalid Element</em>'.
	 * @see org.sidiff.repair.historymodel.ValidationError#getInvalidElement()
	 * @see #getValidationError()
	 * @generated
	 */
	EReference getValidationError_InvalidElement();

	/**
	 * Returns the meta object for the reference '{@link org.sidiff.repair.historymodel.ValidationError#getContext <em>Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Context</em>'.
	 * @see org.sidiff.repair.historymodel.ValidationError#getContext()
	 * @see #getValidationError()
	 * @generated
	 */
	EReference getValidationError_Context();

	/**
	 * Returns the meta object for enum '{@link org.sidiff.repair.historymodel.ValidationSeverity <em>Validation Severity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Validation Severity</em>'.
	 * @see org.sidiff.repair.historymodel.ValidationSeverity
	 * @generated
	 */
	EEnum getValidationSeverity();

	/**
	 * Returns the meta object for enum '{@link org.sidiff.repair.historymodel.ModelStatus <em>Model Status</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Model Status</em>'.
	 * @see org.sidiff.repair.historymodel.ModelStatus
	 * @generated
	 */
	EEnum getModelStatus();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.emf.ecore.resource.Resource <em>Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Resource</em>'.
	 * @see org.eclipse.emf.ecore.resource.Resource
	 * @model instanceClass="org.eclipse.emf.ecore.resource.Resource"
	 * @generated
	 */
	EDataType getResource();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	HistoryModelFactory getHistoryModelFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.sidiff.repair.historymodel.impl.HistoryImpl <em>History</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.repair.historymodel.impl.HistoryImpl
		 * @see org.sidiff.repair.historymodel.impl.HistoryModelPackageImpl#getHistory()
		 * @generated
		 */
		EClass HISTORY = eINSTANCE.getHistory();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HISTORY__NAME = eINSTANCE.getHistory_Name();

		/**
		 * The meta object literal for the '<em><b>Versions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference HISTORY__VERSIONS = eINSTANCE.getHistory_Versions();

		/**
		 * The meta object literal for the '<em><b>Technical Differences</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference HISTORY__TECHNICAL_DIFFERENCES = eINSTANCE.getHistory_TechnicalDifferences();

		/**
		 * The meta object literal for the '<em><b>All Validation Errors</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference HISTORY__ALL_VALIDATION_ERRORS = eINSTANCE.getHistory_AllValidationErrors();

		/**
		 * The meta object literal for the '<em><b>Get Precessor Revisions</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation HISTORY___GET_PRECESSOR_REVISIONS__VERSION = eINSTANCE.getHistory__GetPrecessorRevisions__Version();

		/**
		 * The meta object literal for the '<em><b>Get Successor Revisions</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation HISTORY___GET_SUCCESSOR_REVISIONS__VERSION = eINSTANCE.getHistory__GetSuccessorRevisions__Version();

		/**
		 * The meta object literal for the '<em><b>Get Technical Difference</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation HISTORY___GET_TECHNICAL_DIFFERENCE__VERSION_VERSION = eINSTANCE.getHistory__GetTechnicalDifference__Version_Version();

		/**
		 * The meta object literal for the '<em><b>Get Validation Errors</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation HISTORY___GET_VALIDATION_ERRORS__BOOLEAN_BOOLEAN = eINSTANCE.getHistory__GetValidationErrors__boolean_boolean();

		/**
		 * The meta object literal for the '<em><b>Get Unique Validation Errors</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation HISTORY___GET_UNIQUE_VALIDATION_ERRORS = eINSTANCE.getHistory__GetUniqueValidationErrors();

		/**
		 * The meta object literal for the '{@link org.sidiff.repair.historymodel.impl.VersionImpl <em>Version</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.repair.historymodel.impl.VersionImpl
		 * @see org.sidiff.repair.historymodel.impl.HistoryModelPackageImpl#getVersion()
		 * @generated
		 */
		EClass VERSION = eINSTANCE.getVersion();

		/**
		 * The meta object literal for the '<em><b>Validation Errors</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VERSION__VALIDATION_ERRORS = eINSTANCE.getVersion_ValidationErrors();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VERSION__NAME = eINSTANCE.getVersion_Name();

		/**
		 * The meta object literal for the '<em><b>Id2 Element</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VERSION__ID2_ELEMENT = eINSTANCE.getVersion_Id2Element();

		/**
		 * The meta object literal for the '<em><b>Model URI</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VERSION__MODEL_URI = eINSTANCE.getVersion_ModelURI();

		/**
		 * The meta object literal for the '<em><b>Model</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VERSION__MODEL = eINSTANCE.getVersion_Model();

		/**
		 * The meta object literal for the '<em><b>Status</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VERSION__STATUS = eINSTANCE.getVersion_Status();

		/**
		 * The meta object literal for the '<em><b>Get Element</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation VERSION___GET_ELEMENT__STRING = eINSTANCE.getVersion__GetElement__String();

		/**
		 * The meta object literal for the '{@link org.sidiff.repair.historymodel.impl.ValidationErrorImpl <em>Validation Error</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.repair.historymodel.impl.ValidationErrorImpl
		 * @see org.sidiff.repair.historymodel.impl.HistoryModelPackageImpl#getValidationError()
		 * @generated
		 */
		EClass VALIDATION_ERROR = eINSTANCE.getValidationError();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VALIDATION_ERROR__NAME = eINSTANCE.getValidationError_Name();

		/**
		 * The meta object literal for the '<em><b>Introduced In</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VALIDATION_ERROR__INTRODUCED_IN = eINSTANCE.getValidationError_IntroducedIn();

		/**
		 * The meta object literal for the '<em><b>Resolved In</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VALIDATION_ERROR__RESOLVED_IN = eINSTANCE.getValidationError_ResolvedIn();

		/**
		 * The meta object literal for the '<em><b>Message</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VALIDATION_ERROR__MESSAGE = eINSTANCE.getValidationError_Message();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VALIDATION_ERROR__SOURCE = eINSTANCE.getValidationError_Source();

		/**
		 * The meta object literal for the '<em><b>Severity</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VALIDATION_ERROR__SEVERITY = eINSTANCE.getValidationError_Severity();

		/**
		 * The meta object literal for the '<em><b>Introduced</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VALIDATION_ERROR__INTRODUCED = eINSTANCE.getValidationError_Introduced();

		/**
		 * The meta object literal for the '<em><b>Resolved</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VALIDATION_ERROR__RESOLVED = eINSTANCE.getValidationError_Resolved();

		/**
		 * The meta object literal for the '<em><b>Prec</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VALIDATION_ERROR__PREC = eINSTANCE.getValidationError_Prec();

		/**
		 * The meta object literal for the '<em><b>Succ</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VALIDATION_ERROR__SUCC = eINSTANCE.getValidationError_Succ();

		/**
		 * The meta object literal for the '<em><b>Invalid Element</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VALIDATION_ERROR__INVALID_ELEMENT = eINSTANCE.getValidationError_InvalidElement();

		/**
		 * The meta object literal for the '<em><b>Context</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VALIDATION_ERROR__CONTEXT = eINSTANCE.getValidationError_Context();

		/**
		 * The meta object literal for the '{@link org.sidiff.repair.historymodel.ValidationSeverity <em>Validation Severity</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.repair.historymodel.ValidationSeverity
		 * @see org.sidiff.repair.historymodel.impl.HistoryModelPackageImpl#getValidationSeverity()
		 * @generated
		 */
		EEnum VALIDATION_SEVERITY = eINSTANCE.getValidationSeverity();

		/**
		 * The meta object literal for the '{@link org.sidiff.repair.historymodel.ModelStatus <em>Model Status</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.repair.historymodel.ModelStatus
		 * @see org.sidiff.repair.historymodel.impl.HistoryModelPackageImpl#getModelStatus()
		 * @generated
		 */
		EEnum MODEL_STATUS = eINSTANCE.getModelStatus();

		/**
		 * The meta object literal for the '<em>Resource</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.ecore.resource.Resource
		 * @see org.sidiff.repair.historymodel.impl.HistoryModelPackageImpl#getResource()
		 * @generated
		 */
		EDataType RESOURCE = eINSTANCE.getResource();

	}

} //HistoryModelPackage
