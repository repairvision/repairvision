/**
 */
package org.sidiff.historymodel;

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
 * @see org.sidiff.historymodel.HistoryModelFactory
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
	String eNS_URI = "http://www.sidiff.org/history/model";

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
	HistoryModelPackage eINSTANCE = org.sidiff.historymodel.impl.HistoryModelPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.sidiff.historymodel.impl.HistoryImpl <em>History</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.historymodel.impl.HistoryImpl
	 * @see org.sidiff.historymodel.impl.HistoryModelPackageImpl#getHistory()
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
	 * The feature id for the '<em><b>All Problems</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HISTORY__ALL_PROBLEMS = 2;

	/**
	 * The number of structural features of the '<em>History</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HISTORY_FEATURE_COUNT = 3;

	/**
	 * The operation id for the '<em>Get Predecessor Versions</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HISTORY___GET_PREDECESSOR_VERSIONS__VERSION = 0;

	/**
	 * The operation id for the '<em>Get Successor Versions</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HISTORY___GET_SUCCESSOR_VERSIONS__VERSION = 1;

	/**
	 * The operation id for the '<em>Get Problems</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HISTORY___GET_PROBLEMS__BOOLEAN_BOOLEAN = 2;

	/**
	 * The operation id for the '<em>Get Unique Problems</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HISTORY___GET_UNIQUE_PROBLEMS = 3;

	/**
	 * The number of operations of the '<em>History</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HISTORY_OPERATION_COUNT = 4;

	/**
	 * The meta object id for the '{@link org.sidiff.historymodel.impl.VersionImpl <em>Version</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.historymodel.impl.VersionImpl
	 * @see org.sidiff.historymodel.impl.HistoryModelPackageImpl#getVersion()
	 * @generated
	 */
	int VERSION = 1;

	/**
	 * The feature id for the '<em><b>Problems</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERSION__PROBLEMS = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERSION__NAME = 1;

	/**
	 * The feature id for the '<em><b>Model URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERSION__MODEL_URI = 2;

	/**
	 * The feature id for the '<em><b>Model</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERSION__MODEL = 3;

	/**
	 * The feature id for the '<em><b>Status</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERSION__STATUS = 4;

	/**
	 * The feature id for the '<em><b>Repository Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERSION__REPOSITORY_VERSION = 5;

	/**
	 * The feature id for the '<em><b>History</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERSION__HISTORY = 6;

	/**
	 * The number of structural features of the '<em>Version</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERSION_FEATURE_COUNT = 7;

	/**
	 * The operation id for the '<em>Get Element</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERSION___GET_ELEMENT__STRING = 0;

	/**
	 * The operation id for the '<em>Get Predecessor</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERSION___GET_PREDECESSOR = 1;

	/**
	 * The operation id for the '<em>Get Successor</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERSION___GET_SUCCESSOR = 2;

	/**
	 * The number of operations of the '<em>Version</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERSION_OPERATION_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.sidiff.historymodel.impl.ProblemImpl <em>Problem</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.historymodel.impl.ProblemImpl
	 * @see org.sidiff.historymodel.impl.HistoryModelPackageImpl#getProblem()
	 * @generated
	 */
	int PROBLEM = 2;

	/**
	 * The feature id for the '<em><b>Version</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROBLEM__VERSION = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROBLEM__NAME = 1;

	/**
	 * The feature id for the '<em><b>Introduced In</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROBLEM__INTRODUCED_IN = 2;

	/**
	 * The feature id for the '<em><b>Introduced</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROBLEM__INTRODUCED = 3;

	/**
	 * The feature id for the '<em><b>Resolved In</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROBLEM__RESOLVED_IN = 4;

	/**
	 * The feature id for the '<em><b>Resolved</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROBLEM__RESOLVED = 5;

	/**
	 * The feature id for the '<em><b>Message</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROBLEM__MESSAGE = 6;

	/**
	 * The feature id for the '<em><b>Severity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROBLEM__SEVERITY = 7;

	/**
	 * The feature id for the '<em><b>Predecessor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROBLEM__PREDECESSOR = 8;

	/**
	 * The feature id for the '<em><b>Successor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROBLEM__SUCCESSOR = 9;

	/**
	 * The feature id for the '<em><b>Invalid Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROBLEM__INVALID_ELEMENTS = 10;

	/**
	 * The feature id for the '<em><b>Context Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROBLEM__CONTEXT_ELEMENT = 11;

	/**
	 * The feature id for the '<em><b>Modifications</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROBLEM__MODIFICATIONS = 12;

	/**
	 * The feature id for the '<em><b>Modification Classification</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROBLEM__MODIFICATION_CLASSIFICATION = 13;

	/**
	 * The number of structural features of the '<em>Problem</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROBLEM_FEATURE_COUNT = 14;

	/**
	 * The number of operations of the '<em>Problem</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROBLEM_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.sidiff.historymodel.impl.ChangeSetImpl <em>Change Set</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.historymodel.impl.ChangeSetImpl
	 * @see org.sidiff.historymodel.impl.HistoryModelPackageImpl#getChangeSet()
	 * @generated
	 */
	int CHANGE_SET = 3;

	/**
	 * The feature id for the '<em><b>Changes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANGE_SET__CHANGES = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANGE_SET__NAME = 1;

	/**
	 * The number of structural features of the '<em>Change Set</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANGE_SET_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Change Set</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANGE_SET_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.sidiff.historymodel.ProblemSeverity <em>Problem Severity</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.historymodel.ProblemSeverity
	 * @see org.sidiff.historymodel.impl.HistoryModelPackageImpl#getProblemSeverity()
	 * @generated
	 */
	int PROBLEM_SEVERITY = 4;

	/**
	 * The meta object id for the '{@link org.sidiff.historymodel.ModelStatus <em>Model Status</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.historymodel.ModelStatus
	 * @see org.sidiff.historymodel.impl.HistoryModelPackageImpl#getModelStatus()
	 * @generated
	 */
	int MODEL_STATUS = 5;

	/**
	 * The meta object id for the '{@link org.sidiff.historymodel.ModificationClassification <em>Modification Classification</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.historymodel.ModificationClassification
	 * @see org.sidiff.historymodel.impl.HistoryModelPackageImpl#getModificationClassification()
	 * @generated
	 */
	int MODIFICATION_CLASSIFICATION = 6;

	/**
	 * The meta object id for the '<em>Resource</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.resource.Resource
	 * @see org.sidiff.historymodel.impl.HistoryModelPackageImpl#getResource()
	 * @generated
	 */
	int RESOURCE = 7;

	/**
	 * Returns the meta object for class '{@link org.sidiff.historymodel.History <em>History</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>History</em>'.
	 * @see org.sidiff.historymodel.History
	 * @generated
	 */
	EClass getHistory();

	/**
	 * Returns the meta object for the attribute '{@link org.sidiff.historymodel.History#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.sidiff.historymodel.History#getName()
	 * @see #getHistory()
	 * @generated
	 */
	EAttribute getHistory_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sidiff.historymodel.History#getVersions <em>Versions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Versions</em>'.
	 * @see org.sidiff.historymodel.History#getVersions()
	 * @see #getHistory()
	 * @generated
	 */
	EReference getHistory_Versions();

	/**
	 * Returns the meta object for the reference list '{@link org.sidiff.historymodel.History#getAllProblems <em>All Problems</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>All Problems</em>'.
	 * @see org.sidiff.historymodel.History#getAllProblems()
	 * @see #getHistory()
	 * @generated
	 */
	EReference getHistory_AllProblems();

	/**
	 * Returns the meta object for the '{@link org.sidiff.historymodel.History#getPredecessorVersions(org.sidiff.historymodel.Version) <em>Get Predecessor Versions</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Predecessor Versions</em>' operation.
	 * @see org.sidiff.historymodel.History#getPredecessorVersions(org.sidiff.historymodel.Version)
	 * @generated
	 */
	EOperation getHistory__GetPredecessorVersions__Version();

	/**
	 * Returns the meta object for the '{@link org.sidiff.historymodel.History#getSuccessorVersions(org.sidiff.historymodel.Version) <em>Get Successor Versions</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Successor Versions</em>' operation.
	 * @see org.sidiff.historymodel.History#getSuccessorVersions(org.sidiff.historymodel.Version)
	 * @generated
	 */
	EOperation getHistory__GetSuccessorVersions__Version();

	/**
	 * Returns the meta object for the '{@link org.sidiff.historymodel.History#getProblems(boolean, boolean) <em>Get Problems</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Problems</em>' operation.
	 * @see org.sidiff.historymodel.History#getProblems(boolean, boolean)
	 * @generated
	 */
	EOperation getHistory__GetProblems__boolean_boolean();

	/**
	 * Returns the meta object for the '{@link org.sidiff.historymodel.History#getUniqueProblems() <em>Get Unique Problems</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Unique Problems</em>' operation.
	 * @see org.sidiff.historymodel.History#getUniqueProblems()
	 * @generated
	 */
	EOperation getHistory__GetUniqueProblems();

	/**
	 * Returns the meta object for class '{@link org.sidiff.historymodel.Version <em>Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Version</em>'.
	 * @see org.sidiff.historymodel.Version
	 * @generated
	 */
	EClass getVersion();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sidiff.historymodel.Version#getProblems <em>Problems</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Problems</em>'.
	 * @see org.sidiff.historymodel.Version#getProblems()
	 * @see #getVersion()
	 * @generated
	 */
	EReference getVersion_Problems();

	/**
	 * Returns the meta object for the attribute '{@link org.sidiff.historymodel.Version#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.sidiff.historymodel.Version#getName()
	 * @see #getVersion()
	 * @generated
	 */
	EAttribute getVersion_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.sidiff.historymodel.Version#getModelURI <em>Model URI</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Model URI</em>'.
	 * @see org.sidiff.historymodel.Version#getModelURI()
	 * @see #getVersion()
	 * @generated
	 */
	EAttribute getVersion_ModelURI();

	/**
	 * Returns the meta object for the attribute '{@link org.sidiff.historymodel.Version#getModel <em>Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Model</em>'.
	 * @see org.sidiff.historymodel.Version#getModel()
	 * @see #getVersion()
	 * @generated
	 */
	EAttribute getVersion_Model();

	/**
	 * Returns the meta object for the attribute '{@link org.sidiff.historymodel.Version#getStatus <em>Status</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Status</em>'.
	 * @see org.sidiff.historymodel.Version#getStatus()
	 * @see #getVersion()
	 * @generated
	 */
	EAttribute getVersion_Status();

	/**
	 * Returns the meta object for the attribute '{@link org.sidiff.historymodel.Version#getRepositoryVersion <em>Repository Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Repository Version</em>'.
	 * @see org.sidiff.historymodel.Version#getRepositoryVersion()
	 * @see #getVersion()
	 * @generated
	 */
	EAttribute getVersion_RepositoryVersion();

	/**
	 * Returns the meta object for the container reference '{@link org.sidiff.historymodel.Version#getHistory <em>History</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>History</em>'.
	 * @see org.sidiff.historymodel.Version#getHistory()
	 * @see #getVersion()
	 * @generated
	 */
	EReference getVersion_History();

	/**
	 * Returns the meta object for the '{@link org.sidiff.historymodel.Version#getElement(java.lang.String) <em>Get Element</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Element</em>' operation.
	 * @see org.sidiff.historymodel.Version#getElement(java.lang.String)
	 * @generated
	 */
	EOperation getVersion__GetElement__String();

	/**
	 * Returns the meta object for the '{@link org.sidiff.historymodel.Version#getPredecessor() <em>Get Predecessor</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Predecessor</em>' operation.
	 * @see org.sidiff.historymodel.Version#getPredecessor()
	 * @generated
	 */
	EOperation getVersion__GetPredecessor();

	/**
	 * Returns the meta object for the '{@link org.sidiff.historymodel.Version#getSuccessor() <em>Get Successor</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Successor</em>' operation.
	 * @see org.sidiff.historymodel.Version#getSuccessor()
	 * @generated
	 */
	EOperation getVersion__GetSuccessor();

	/**
	 * Returns the meta object for class '{@link org.sidiff.historymodel.Problem <em>Problem</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Problem</em>'.
	 * @see org.sidiff.historymodel.Problem
	 * @generated
	 */
	EClass getProblem();

	/**
	 * Returns the meta object for the container reference '{@link org.sidiff.historymodel.Problem#getVersion <em>Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Version</em>'.
	 * @see org.sidiff.historymodel.Problem#getVersion()
	 * @see #getProblem()
	 * @generated
	 */
	EReference getProblem_Version();

	/**
	 * Returns the meta object for the attribute '{@link org.sidiff.historymodel.Problem#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.sidiff.historymodel.Problem#getName()
	 * @see #getProblem()
	 * @generated
	 */
	EAttribute getProblem_Name();

	/**
	 * Returns the meta object for the reference '{@link org.sidiff.historymodel.Problem#getIntroducedIn <em>Introduced In</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Introduced In</em>'.
	 * @see org.sidiff.historymodel.Problem#getIntroducedIn()
	 * @see #getProblem()
	 * @generated
	 */
	EReference getProblem_IntroducedIn();

	/**
	 * Returns the meta object for the attribute '{@link org.sidiff.historymodel.Problem#isIntroduced <em>Introduced</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Introduced</em>'.
	 * @see org.sidiff.historymodel.Problem#isIntroduced()
	 * @see #getProblem()
	 * @generated
	 */
	EAttribute getProblem_Introduced();

	/**
	 * Returns the meta object for the reference '{@link org.sidiff.historymodel.Problem#getResolvedIn <em>Resolved In</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Resolved In</em>'.
	 * @see org.sidiff.historymodel.Problem#getResolvedIn()
	 * @see #getProblem()
	 * @generated
	 */
	EReference getProblem_ResolvedIn();

	/**
	 * Returns the meta object for the attribute '{@link org.sidiff.historymodel.Problem#isResolved <em>Resolved</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Resolved</em>'.
	 * @see org.sidiff.historymodel.Problem#isResolved()
	 * @see #getProblem()
	 * @generated
	 */
	EAttribute getProblem_Resolved();

	/**
	 * Returns the meta object for the attribute '{@link org.sidiff.historymodel.Problem#getMessage <em>Message</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Message</em>'.
	 * @see org.sidiff.historymodel.Problem#getMessage()
	 * @see #getProblem()
	 * @generated
	 */
	EAttribute getProblem_Message();

	/**
	 * Returns the meta object for the attribute '{@link org.sidiff.historymodel.Problem#getSeverity <em>Severity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Severity</em>'.
	 * @see org.sidiff.historymodel.Problem#getSeverity()
	 * @see #getProblem()
	 * @generated
	 */
	EAttribute getProblem_Severity();

	/**
	 * Returns the meta object for the reference '{@link org.sidiff.historymodel.Problem#getPredecessor <em>Predecessor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Predecessor</em>'.
	 * @see org.sidiff.historymodel.Problem#getPredecessor()
	 * @see #getProblem()
	 * @generated
	 */
	EReference getProblem_Predecessor();

	/**
	 * Returns the meta object for the reference '{@link org.sidiff.historymodel.Problem#getSuccessor <em>Successor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Successor</em>'.
	 * @see org.sidiff.historymodel.Problem#getSuccessor()
	 * @see #getProblem()
	 * @generated
	 */
	EReference getProblem_Successor();

	/**
	 * Returns the meta object for the reference list '{@link org.sidiff.historymodel.Problem#getInvalidElements <em>Invalid Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Invalid Elements</em>'.
	 * @see org.sidiff.historymodel.Problem#getInvalidElements()
	 * @see #getProblem()
	 * @generated
	 */
	EReference getProblem_InvalidElements();

	/**
	 * Returns the meta object for the reference '{@link org.sidiff.historymodel.Problem#getContextElement <em>Context Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Context Element</em>'.
	 * @see org.sidiff.historymodel.Problem#getContextElement()
	 * @see #getProblem()
	 * @generated
	 */
	EReference getProblem_ContextElement();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sidiff.historymodel.Problem#getModifications <em>Modifications</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Modifications</em>'.
	 * @see org.sidiff.historymodel.Problem#getModifications()
	 * @see #getProblem()
	 * @generated
	 */
	EReference getProblem_Modifications();

	/**
	 * Returns the meta object for the attribute list '{@link org.sidiff.historymodel.Problem#getModificationClassification <em>Modification Classification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Modification Classification</em>'.
	 * @see org.sidiff.historymodel.Problem#getModificationClassification()
	 * @see #getProblem()
	 * @generated
	 */
	EAttribute getProblem_ModificationClassification();

	/**
	 * Returns the meta object for class '{@link org.sidiff.historymodel.ChangeSet <em>Change Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Change Set</em>'.
	 * @see org.sidiff.historymodel.ChangeSet
	 * @generated
	 */
	EClass getChangeSet();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sidiff.historymodel.ChangeSet#getChanges <em>Changes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Changes</em>'.
	 * @see org.sidiff.historymodel.ChangeSet#getChanges()
	 * @see #getChangeSet()
	 * @generated
	 */
	EReference getChangeSet_Changes();

	/**
	 * Returns the meta object for the attribute '{@link org.sidiff.historymodel.ChangeSet#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.sidiff.historymodel.ChangeSet#getName()
	 * @see #getChangeSet()
	 * @generated
	 */
	EAttribute getChangeSet_Name();

	/**
	 * Returns the meta object for enum '{@link org.sidiff.historymodel.ProblemSeverity <em>Problem Severity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Problem Severity</em>'.
	 * @see org.sidiff.historymodel.ProblemSeverity
	 * @generated
	 */
	EEnum getProblemSeverity();

	/**
	 * Returns the meta object for enum '{@link org.sidiff.historymodel.ModelStatus <em>Model Status</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Model Status</em>'.
	 * @see org.sidiff.historymodel.ModelStatus
	 * @generated
	 */
	EEnum getModelStatus();

	/**
	 * Returns the meta object for enum '{@link org.sidiff.historymodel.ModificationClassification <em>Modification Classification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Modification Classification</em>'.
	 * @see org.sidiff.historymodel.ModificationClassification
	 * @generated
	 */
	EEnum getModificationClassification();

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
		 * The meta object literal for the '{@link org.sidiff.historymodel.impl.HistoryImpl <em>History</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.historymodel.impl.HistoryImpl
		 * @see org.sidiff.historymodel.impl.HistoryModelPackageImpl#getHistory()
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
		 * The meta object literal for the '<em><b>All Problems</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference HISTORY__ALL_PROBLEMS = eINSTANCE.getHistory_AllProblems();

		/**
		 * The meta object literal for the '<em><b>Get Predecessor Versions</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation HISTORY___GET_PREDECESSOR_VERSIONS__VERSION = eINSTANCE.getHistory__GetPredecessorVersions__Version();

		/**
		 * The meta object literal for the '<em><b>Get Successor Versions</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation HISTORY___GET_SUCCESSOR_VERSIONS__VERSION = eINSTANCE.getHistory__GetSuccessorVersions__Version();

		/**
		 * The meta object literal for the '<em><b>Get Problems</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation HISTORY___GET_PROBLEMS__BOOLEAN_BOOLEAN = eINSTANCE.getHistory__GetProblems__boolean_boolean();

		/**
		 * The meta object literal for the '<em><b>Get Unique Problems</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation HISTORY___GET_UNIQUE_PROBLEMS = eINSTANCE.getHistory__GetUniqueProblems();

		/**
		 * The meta object literal for the '{@link org.sidiff.historymodel.impl.VersionImpl <em>Version</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.historymodel.impl.VersionImpl
		 * @see org.sidiff.historymodel.impl.HistoryModelPackageImpl#getVersion()
		 * @generated
		 */
		EClass VERSION = eINSTANCE.getVersion();

		/**
		 * The meta object literal for the '<em><b>Problems</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VERSION__PROBLEMS = eINSTANCE.getVersion_Problems();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VERSION__NAME = eINSTANCE.getVersion_Name();

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
		 * The meta object literal for the '<em><b>Repository Version</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VERSION__REPOSITORY_VERSION = eINSTANCE.getVersion_RepositoryVersion();

		/**
		 * The meta object literal for the '<em><b>History</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VERSION__HISTORY = eINSTANCE.getVersion_History();

		/**
		 * The meta object literal for the '<em><b>Get Element</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation VERSION___GET_ELEMENT__STRING = eINSTANCE.getVersion__GetElement__String();

		/**
		 * The meta object literal for the '<em><b>Get Predecessor</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation VERSION___GET_PREDECESSOR = eINSTANCE.getVersion__GetPredecessor();

		/**
		 * The meta object literal for the '<em><b>Get Successor</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation VERSION___GET_SUCCESSOR = eINSTANCE.getVersion__GetSuccessor();

		/**
		 * The meta object literal for the '{@link org.sidiff.historymodel.impl.ProblemImpl <em>Problem</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.historymodel.impl.ProblemImpl
		 * @see org.sidiff.historymodel.impl.HistoryModelPackageImpl#getProblem()
		 * @generated
		 */
		EClass PROBLEM = eINSTANCE.getProblem();

		/**
		 * The meta object literal for the '<em><b>Version</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROBLEM__VERSION = eINSTANCE.getProblem_Version();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROBLEM__NAME = eINSTANCE.getProblem_Name();

		/**
		 * The meta object literal for the '<em><b>Introduced In</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROBLEM__INTRODUCED_IN = eINSTANCE.getProblem_IntroducedIn();

		/**
		 * The meta object literal for the '<em><b>Introduced</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROBLEM__INTRODUCED = eINSTANCE.getProblem_Introduced();

		/**
		 * The meta object literal for the '<em><b>Resolved In</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROBLEM__RESOLVED_IN = eINSTANCE.getProblem_ResolvedIn();

		/**
		 * The meta object literal for the '<em><b>Resolved</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROBLEM__RESOLVED = eINSTANCE.getProblem_Resolved();

		/**
		 * The meta object literal for the '<em><b>Message</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROBLEM__MESSAGE = eINSTANCE.getProblem_Message();

		/**
		 * The meta object literal for the '<em><b>Severity</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROBLEM__SEVERITY = eINSTANCE.getProblem_Severity();

		/**
		 * The meta object literal for the '<em><b>Predecessor</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROBLEM__PREDECESSOR = eINSTANCE.getProblem_Predecessor();

		/**
		 * The meta object literal for the '<em><b>Successor</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROBLEM__SUCCESSOR = eINSTANCE.getProblem_Successor();

		/**
		 * The meta object literal for the '<em><b>Invalid Elements</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROBLEM__INVALID_ELEMENTS = eINSTANCE.getProblem_InvalidElements();

		/**
		 * The meta object literal for the '<em><b>Context Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROBLEM__CONTEXT_ELEMENT = eINSTANCE.getProblem_ContextElement();

		/**
		 * The meta object literal for the '<em><b>Modifications</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROBLEM__MODIFICATIONS = eINSTANCE.getProblem_Modifications();

		/**
		 * The meta object literal for the '<em><b>Modification Classification</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROBLEM__MODIFICATION_CLASSIFICATION = eINSTANCE.getProblem_ModificationClassification();

		/**
		 * The meta object literal for the '{@link org.sidiff.historymodel.impl.ChangeSetImpl <em>Change Set</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.historymodel.impl.ChangeSetImpl
		 * @see org.sidiff.historymodel.impl.HistoryModelPackageImpl#getChangeSet()
		 * @generated
		 */
		EClass CHANGE_SET = eINSTANCE.getChangeSet();

		/**
		 * The meta object literal for the '<em><b>Changes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CHANGE_SET__CHANGES = eINSTANCE.getChangeSet_Changes();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CHANGE_SET__NAME = eINSTANCE.getChangeSet_Name();

		/**
		 * The meta object literal for the '{@link org.sidiff.historymodel.ProblemSeverity <em>Problem Severity</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.historymodel.ProblemSeverity
		 * @see org.sidiff.historymodel.impl.HistoryModelPackageImpl#getProblemSeverity()
		 * @generated
		 */
		EEnum PROBLEM_SEVERITY = eINSTANCE.getProblemSeverity();

		/**
		 * The meta object literal for the '{@link org.sidiff.historymodel.ModelStatus <em>Model Status</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.historymodel.ModelStatus
		 * @see org.sidiff.historymodel.impl.HistoryModelPackageImpl#getModelStatus()
		 * @generated
		 */
		EEnum MODEL_STATUS = eINSTANCE.getModelStatus();

		/**
		 * The meta object literal for the '{@link org.sidiff.historymodel.ModificationClassification <em>Modification Classification</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.historymodel.ModificationClassification
		 * @see org.sidiff.historymodel.impl.HistoryModelPackageImpl#getModificationClassification()
		 * @generated
		 */
		EEnum MODIFICATION_CLASSIFICATION = eINSTANCE.getModificationClassification();

		/**
		 * The meta object literal for the '<em>Resource</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.ecore.resource.Resource
		 * @see org.sidiff.historymodel.impl.HistoryModelPackageImpl#getResource()
		 * @generated
		 */
		EDataType RESOURCE = eINSTANCE.getResource();

	}

} //HistoryModelPackage
