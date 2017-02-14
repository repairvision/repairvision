/**
 */
package org.sidiff.repair.model.repairjob;

import org.eclipse.emf.ecore.EClass;
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
 * @see org.sidiff.repair.model.repairjob.RepairjobFactory
 * @model kind="package"
 * @generated
 */
public interface RepairjobPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "repairjob";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.sidiff.org/repairjob/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "repairjob";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	RepairjobPackage eINSTANCE = org.sidiff.repair.model.repairjob.impl.RepairjobPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.sidiff.repair.model.repairjob.impl.RepairJobImpl <em>Repair Job</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.repair.model.repairjob.impl.RepairJobImpl
	 * @see org.sidiff.repair.model.repairjob.impl.RepairjobPackageImpl#getRepairJob()
	 * @generated
	 */
	int REPAIR_JOB = 0;

	/**
	 * The feature id for the '<em><b>Difference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPAIR_JOB__DIFFERENCE = 0;

	/**
	 * The feature id for the '<em><b>Repairs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPAIR_JOB__REPAIRS = 1;

	/**
	 * The feature id for the '<em><b>Inconsistencies</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPAIR_JOB__INCONSISTENCIES = 2;

	/**
	 * The number of structural features of the '<em>Repair Job</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPAIR_JOB_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Repair Job</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPAIR_JOB_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.sidiff.repair.model.repairjob.impl.EditRuleImpl <em>Edit Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.repair.model.repairjob.impl.EditRuleImpl
	 * @see org.sidiff.repair.model.repairjob.impl.RepairjobPackageImpl#getEditRule()
	 * @generated
	 */
	int EDIT_RULE = 1;

	/**
	 * The feature id for the '<em><b>Rule</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDIT_RULE__RULE = 0;

	/**
	 * The feature id for the '<em><b>Repair Operations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDIT_RULE__REPAIR_OPERATIONS = 1;

	/**
	 * The feature id for the '<em><b>Repair Job</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDIT_RULE__REPAIR_JOB = 2;

	/**
	 * The number of structural features of the '<em>Edit Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDIT_RULE_FEATURE_COUNT = 3;

	/**
	 * The operation id for the '<em>Get Rating</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDIT_RULE___GET_RATING = 0;

	/**
	 * The number of operations of the '<em>Edit Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDIT_RULE_OPERATION_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.sidiff.repair.model.repairjob.impl.RepairOperationImpl <em>Repair Operation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.repair.model.repairjob.impl.RepairOperationImpl
	 * @see org.sidiff.repair.model.repairjob.impl.RepairjobPackageImpl#getRepairOperation()
	 * @generated
	 */
	int REPAIR_OPERATION = 2;

	/**
	 * The feature id for the '<em><b>Context</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPAIR_OPERATION__CONTEXT = 0;

	/**
	 * The feature id for the '<em><b>Edit Rule</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPAIR_OPERATION__EDIT_RULE = 1;

	/**
	 * The feature id for the '<em><b>Sub Rule</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPAIR_OPERATION__SUB_RULE = 2;

	/**
	 * The feature id for the '<em><b>Complement Rule</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPAIR_OPERATION__COMPLEMENT_RULE = 3;

	/**
	 * The feature id for the '<em><b>Repairs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPAIR_OPERATION__REPAIRS = 4;

	/**
	 * The number of structural features of the '<em>Repair Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPAIR_OPERATION_FEATURE_COUNT = 5;

	/**
	 * The operation id for the '<em>Get Rating</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPAIR_OPERATION___GET_RATING = 0;

	/**
	 * The number of operations of the '<em>Repair Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPAIR_OPERATION_OPERATION_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.sidiff.repair.model.repairjob.impl.PartialRuleImpl <em>Partial Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.repair.model.repairjob.impl.PartialRuleImpl
	 * @see org.sidiff.repair.model.repairjob.impl.RepairjobPackageImpl#getPartialRule()
	 * @generated
	 */
	int PARTIAL_RULE = 3;

	/**
	 * The feature id for the '<em><b>Change</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTIAL_RULE__CHANGE = 0;

	/**
	 * The number of structural features of the '<em>Partial Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTIAL_RULE_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Partial Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTIAL_RULE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.sidiff.repair.model.repairjob.impl.SubRuleImpl <em>Sub Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.repair.model.repairjob.impl.SubRuleImpl
	 * @see org.sidiff.repair.model.repairjob.impl.RepairjobPackageImpl#getSubRule()
	 * @generated
	 */
	int SUB_RULE = 4;

	/**
	 * The feature id for the '<em><b>Change</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_RULE__CHANGE = PARTIAL_RULE__CHANGE;

	/**
	 * The feature id for the '<em><b>Repair Operation</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_RULE__REPAIR_OPERATION = PARTIAL_RULE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Match</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_RULE__MATCH = PARTIAL_RULE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Sub Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_RULE_FEATURE_COUNT = PARTIAL_RULE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Sub Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_RULE_OPERATION_COUNT = PARTIAL_RULE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sidiff.repair.model.repairjob.impl.ComplementRuleImpl <em>Complement Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.repair.model.repairjob.impl.ComplementRuleImpl
	 * @see org.sidiff.repair.model.repairjob.impl.RepairjobPackageImpl#getComplementRule()
	 * @generated
	 */
	int COMPLEMENT_RULE = 5;

	/**
	 * The feature id for the '<em><b>Change</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEMENT_RULE__CHANGE = PARTIAL_RULE__CHANGE;

	/**
	 * The feature id for the '<em><b>Repair Operation</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEMENT_RULE__REPAIR_OPERATION = PARTIAL_RULE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Complement Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEMENT_RULE_FEATURE_COUNT = PARTIAL_RULE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Complement Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEMENT_RULE_OPERATION_COUNT = PARTIAL_RULE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sidiff.repair.model.repairjob.IRepair <em>IRepair</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.repair.model.repairjob.IRepair
	 * @see org.sidiff.repair.model.repairjob.impl.RepairjobPackageImpl#getIRepair()
	 * @generated
	 */
	int IREPAIR = 6;

	/**
	 * The feature id for the '<em><b>Repair Operation</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IREPAIR__REPAIR_OPERATION = 0;

	/**
	 * The number of structural features of the '<em>IRepair</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IREPAIR_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>IRepair</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IREPAIR_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.sidiff.repair.model.repairjob.impl.RepairMatchImpl <em>Repair Match</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.repair.model.repairjob.impl.RepairMatchImpl
	 * @see org.sidiff.repair.model.repairjob.impl.RepairjobPackageImpl#getRepairMatch()
	 * @generated
	 */
	int REPAIR_MATCH = 7;

	/**
	 * The feature id for the '<em><b>Repair Operation</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPAIR_MATCH__REPAIR_OPERATION = IREPAIR__REPAIR_OPERATION;

	/**
	 * The feature id for the '<em><b>Change</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPAIR_MATCH__CHANGE = IREPAIR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPAIR_MATCH__ELEMENTS = IREPAIR_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Repair Match</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPAIR_MATCH_FEATURE_COUNT = IREPAIR_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Repair Match</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPAIR_MATCH_OPERATION_COUNT = IREPAIR_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sidiff.repair.model.repairjob.impl.RepairParameterImpl <em>Repair Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.repair.model.repairjob.impl.RepairParameterImpl
	 * @see org.sidiff.repair.model.repairjob.impl.RepairjobPackageImpl#getRepairParameter()
	 * @generated
	 */
	int REPAIR_PARAMETER = 8;

	/**
	 * The feature id for the '<em><b>Repair Operation</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPAIR_PARAMETER__REPAIR_OPERATION = IREPAIR__REPAIR_OPERATION;

	/**
	 * The feature id for the '<em><b>Change</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPAIR_PARAMETER__CHANGE = IREPAIR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Domain</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPAIR_PARAMETER__DOMAIN = IREPAIR_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Repair Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPAIR_PARAMETER_FEATURE_COUNT = IREPAIR_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Repair Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPAIR_PARAMETER_OPERATION_COUNT = IREPAIR_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sidiff.repair.model.repairjob.impl.ChangeImpl <em>Change</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.repair.model.repairjob.impl.ChangeImpl
	 * @see org.sidiff.repair.model.repairjob.impl.RepairjobPackageImpl#getChange()
	 * @generated
	 */
	int CHANGE = 9;

	/**
	 * The feature id for the '<em><b>Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANGE__ELEMENT = 0;

	/**
	 * The number of structural features of the '<em>Change</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANGE_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Change</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANGE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.sidiff.repair.model.repairjob.impl.MatchImpl <em>Match</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.repair.model.repairjob.impl.MatchImpl
	 * @see org.sidiff.repair.model.repairjob.impl.RepairjobPackageImpl#getMatch()
	 * @generated
	 */
	int MATCH = 10;

	/**
	 * The feature id for the '<em><b>Change</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATCH__CHANGE = 0;

	/**
	 * The feature id for the '<em><b>Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATCH__ELEMENTS = 1;

	/**
	 * The number of structural features of the '<em>Match</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATCH_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Match</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATCH_OPERATION_COUNT = 0;


	/**
	 * The meta object id for the '{@link org.sidiff.repair.model.repairjob.Inconsistency <em>Inconsistency</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.repair.model.repairjob.Inconsistency
	 * @see org.sidiff.repair.model.repairjob.impl.RepairjobPackageImpl#getInconsistency()
	 * @generated
	 */
	int INCONSISTENCY = 11;

	/**
	 * The feature id for the '<em><b>Repairs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCONSISTENCY__REPAIRS = 0;

	/**
	 * The number of structural features of the '<em>Inconsistency</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCONSISTENCY_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Inconsistency</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCONSISTENCY_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link org.sidiff.repair.model.repairjob.RepairJob <em>Repair Job</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Repair Job</em>'.
	 * @see org.sidiff.repair.model.repairjob.RepairJob
	 * @generated
	 */
	EClass getRepairJob();

	/**
	 * Returns the meta object for the reference '{@link org.sidiff.repair.model.repairjob.RepairJob#getDifference <em>Difference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Difference</em>'.
	 * @see org.sidiff.repair.model.repairjob.RepairJob#getDifference()
	 * @see #getRepairJob()
	 * @generated
	 */
	EReference getRepairJob_Difference();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sidiff.repair.model.repairjob.RepairJob#getRepairs <em>Repairs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Repairs</em>'.
	 * @see org.sidiff.repair.model.repairjob.RepairJob#getRepairs()
	 * @see #getRepairJob()
	 * @generated
	 */
	EReference getRepairJob_Repairs();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sidiff.repair.model.repairjob.RepairJob#getInconsistencies <em>Inconsistencies</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Inconsistencies</em>'.
	 * @see org.sidiff.repair.model.repairjob.RepairJob#getInconsistencies()
	 * @see #getRepairJob()
	 * @generated
	 */
	EReference getRepairJob_Inconsistencies();

	/**
	 * Returns the meta object for class '{@link org.sidiff.repair.model.repairjob.EditRule <em>Edit Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Edit Rule</em>'.
	 * @see org.sidiff.repair.model.repairjob.EditRule
	 * @generated
	 */
	EClass getEditRule();

	/**
	 * Returns the meta object for the reference '{@link org.sidiff.repair.model.repairjob.EditRule#getRule <em>Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Rule</em>'.
	 * @see org.sidiff.repair.model.repairjob.EditRule#getRule()
	 * @see #getEditRule()
	 * @generated
	 */
	EReference getEditRule_Rule();

	/**
	 * Returns the meta object for the container reference '{@link org.sidiff.repair.model.repairjob.EditRule#getRepairJob <em>Repair Job</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Repair Job</em>'.
	 * @see org.sidiff.repair.model.repairjob.EditRule#getRepairJob()
	 * @see #getEditRule()
	 * @generated
	 */
	EReference getEditRule_RepairJob();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sidiff.repair.model.repairjob.EditRule#getRepairOperations <em>Repair Operations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Repair Operations</em>'.
	 * @see org.sidiff.repair.model.repairjob.EditRule#getRepairOperations()
	 * @see #getEditRule()
	 * @generated
	 */
	EReference getEditRule_RepairOperations();

	/**
	 * Returns the meta object for the '{@link org.sidiff.repair.model.repairjob.EditRule#getRating() <em>Get Rating</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Rating</em>' operation.
	 * @see org.sidiff.repair.model.repairjob.EditRule#getRating()
	 * @generated
	 */
	EOperation getEditRule__GetRating();

	/**
	 * Returns the meta object for class '{@link org.sidiff.repair.model.repairjob.RepairOperation <em>Repair Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Repair Operation</em>'.
	 * @see org.sidiff.repair.model.repairjob.RepairOperation
	 * @generated
	 */
	EClass getRepairOperation();

	/**
	 * Returns the meta object for the reference '{@link org.sidiff.repair.model.repairjob.RepairOperation#getContext <em>Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Context</em>'.
	 * @see org.sidiff.repair.model.repairjob.RepairOperation#getContext()
	 * @see #getRepairOperation()
	 * @generated
	 */
	EReference getRepairOperation_Context();

	/**
	 * Returns the meta object for the container reference '{@link org.sidiff.repair.model.repairjob.RepairOperation#getEditRule <em>Edit Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Edit Rule</em>'.
	 * @see org.sidiff.repair.model.repairjob.RepairOperation#getEditRule()
	 * @see #getRepairOperation()
	 * @generated
	 */
	EReference getRepairOperation_EditRule();

	/**
	 * Returns the meta object for the containment reference '{@link org.sidiff.repair.model.repairjob.RepairOperation#getSubRule <em>Sub Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Sub Rule</em>'.
	 * @see org.sidiff.repair.model.repairjob.RepairOperation#getSubRule()
	 * @see #getRepairOperation()
	 * @generated
	 */
	EReference getRepairOperation_SubRule();

	/**
	 * Returns the meta object for the containment reference '{@link org.sidiff.repair.model.repairjob.RepairOperation#getComplementRule <em>Complement Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Complement Rule</em>'.
	 * @see org.sidiff.repair.model.repairjob.RepairOperation#getComplementRule()
	 * @see #getRepairOperation()
	 * @generated
	 */
	EReference getRepairOperation_ComplementRule();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sidiff.repair.model.repairjob.RepairOperation#getRepairs <em>Repairs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Repairs</em>'.
	 * @see org.sidiff.repair.model.repairjob.RepairOperation#getRepairs()
	 * @see #getRepairOperation()
	 * @generated
	 */
	EReference getRepairOperation_Repairs();

	/**
	 * Returns the meta object for the '{@link org.sidiff.repair.model.repairjob.RepairOperation#getRating() <em>Get Rating</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Rating</em>' operation.
	 * @see org.sidiff.repair.model.repairjob.RepairOperation#getRating()
	 * @generated
	 */
	EOperation getRepairOperation__GetRating();

	/**
	 * Returns the meta object for class '{@link org.sidiff.repair.model.repairjob.PartialRule <em>Partial Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Partial Rule</em>'.
	 * @see org.sidiff.repair.model.repairjob.PartialRule
	 * @generated
	 */
	EClass getPartialRule();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sidiff.repair.model.repairjob.PartialRule#getChange <em>Change</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Change</em>'.
	 * @see org.sidiff.repair.model.repairjob.PartialRule#getChange()
	 * @see #getPartialRule()
	 * @generated
	 */
	EReference getPartialRule_Change();

	/**
	 * Returns the meta object for class '{@link org.sidiff.repair.model.repairjob.SubRule <em>Sub Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sub Rule</em>'.
	 * @see org.sidiff.repair.model.repairjob.SubRule
	 * @generated
	 */
	EClass getSubRule();

	/**
	 * Returns the meta object for the container reference '{@link org.sidiff.repair.model.repairjob.SubRule#getRepairOperation <em>Repair Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Repair Operation</em>'.
	 * @see org.sidiff.repair.model.repairjob.SubRule#getRepairOperation()
	 * @see #getSubRule()
	 * @generated
	 */
	EReference getSubRule_RepairOperation();

	/**
	 * Returns the meta object for the containment reference '{@link org.sidiff.repair.model.repairjob.SubRule#getMatch <em>Match</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Match</em>'.
	 * @see org.sidiff.repair.model.repairjob.SubRule#getMatch()
	 * @see #getSubRule()
	 * @generated
	 */
	EReference getSubRule_Match();

	/**
	 * Returns the meta object for class '{@link org.sidiff.repair.model.repairjob.ComplementRule <em>Complement Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Complement Rule</em>'.
	 * @see org.sidiff.repair.model.repairjob.ComplementRule
	 * @generated
	 */
	EClass getComplementRule();

	/**
	 * Returns the meta object for the container reference '{@link org.sidiff.repair.model.repairjob.ComplementRule#getRepairOperation <em>Repair Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Repair Operation</em>'.
	 * @see org.sidiff.repair.model.repairjob.ComplementRule#getRepairOperation()
	 * @see #getComplementRule()
	 * @generated
	 */
	EReference getComplementRule_RepairOperation();

	/**
	 * Returns the meta object for class '{@link org.sidiff.repair.model.repairjob.IRepair <em>IRepair</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IRepair</em>'.
	 * @see org.sidiff.repair.model.repairjob.IRepair
	 * @generated
	 */
	EClass getIRepair();

	/**
	 * Returns the meta object for the container reference '{@link org.sidiff.repair.model.repairjob.IRepair#getRepairOperation <em>Repair Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Repair Operation</em>'.
	 * @see org.sidiff.repair.model.repairjob.IRepair#getRepairOperation()
	 * @see #getIRepair()
	 * @generated
	 */
	EReference getIRepair_RepairOperation();

	/**
	 * Returns the meta object for class '{@link org.sidiff.repair.model.repairjob.RepairMatch <em>Repair Match</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Repair Match</em>'.
	 * @see org.sidiff.repair.model.repairjob.RepairMatch
	 * @generated
	 */
	EClass getRepairMatch();

	/**
	 * Returns the meta object for class '{@link org.sidiff.repair.model.repairjob.RepairParameter <em>Repair Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Repair Parameter</em>'.
	 * @see org.sidiff.repair.model.repairjob.RepairParameter
	 * @generated
	 */
	EClass getRepairParameter();

	/**
	 * Returns the meta object for the reference '{@link org.sidiff.repair.model.repairjob.RepairParameter#getChange <em>Change</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Change</em>'.
	 * @see org.sidiff.repair.model.repairjob.RepairParameter#getChange()
	 * @see #getRepairParameter()
	 * @generated
	 */
	EReference getRepairParameter_Change();

	/**
	 * Returns the meta object for the reference '{@link org.sidiff.repair.model.repairjob.RepairParameter#getDomain <em>Domain</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Domain</em>'.
	 * @see org.sidiff.repair.model.repairjob.RepairParameter#getDomain()
	 * @see #getRepairParameter()
	 * @generated
	 */
	EReference getRepairParameter_Domain();

	/**
	 * Returns the meta object for class '{@link org.sidiff.repair.model.repairjob.Change <em>Change</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Change</em>'.
	 * @see org.sidiff.repair.model.repairjob.Change
	 * @generated
	 */
	EClass getChange();

	/**
	 * Returns the meta object for the reference '{@link org.sidiff.repair.model.repairjob.Change#getElement <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Element</em>'.
	 * @see org.sidiff.repair.model.repairjob.Change#getElement()
	 * @see #getChange()
	 * @generated
	 */
	EReference getChange_Element();

	/**
	 * Returns the meta object for class '{@link org.sidiff.repair.model.repairjob.Match <em>Match</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Match</em>'.
	 * @see org.sidiff.repair.model.repairjob.Match
	 * @generated
	 */
	EClass getMatch();

	/**
	 * Returns the meta object for the reference list '{@link org.sidiff.repair.model.repairjob.Match#getChange <em>Change</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Change</em>'.
	 * @see org.sidiff.repair.model.repairjob.Match#getChange()
	 * @see #getMatch()
	 * @generated
	 */
	EReference getMatch_Change();

	/**
	 * Returns the meta object for the reference list '{@link org.sidiff.repair.model.repairjob.Match#getElements <em>Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Elements</em>'.
	 * @see org.sidiff.repair.model.repairjob.Match#getElements()
	 * @see #getMatch()
	 * @generated
	 */
	EReference getMatch_Elements();

	/**
	 * Returns the meta object for class '{@link org.sidiff.repair.model.repairjob.Inconsistency <em>Inconsistency</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Inconsistency</em>'.
	 * @see org.sidiff.repair.model.repairjob.Inconsistency
	 * @generated
	 */
	EClass getInconsistency();

	/**
	 * Returns the meta object for the reference list '{@link org.sidiff.repair.model.repairjob.Inconsistency#getRepairs <em>Repairs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Repairs</em>'.
	 * @see org.sidiff.repair.model.repairjob.Inconsistency#getRepairs()
	 * @see #getInconsistency()
	 * @generated
	 */
	EReference getInconsistency_Repairs();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	RepairjobFactory getRepairjobFactory();

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
		 * The meta object literal for the '{@link org.sidiff.repair.model.repairjob.impl.RepairJobImpl <em>Repair Job</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.repair.model.repairjob.impl.RepairJobImpl
		 * @see org.sidiff.repair.model.repairjob.impl.RepairjobPackageImpl#getRepairJob()
		 * @generated
		 */
		EClass REPAIR_JOB = eINSTANCE.getRepairJob();

		/**
		 * The meta object literal for the '<em><b>Difference</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REPAIR_JOB__DIFFERENCE = eINSTANCE.getRepairJob_Difference();

		/**
		 * The meta object literal for the '<em><b>Repairs</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REPAIR_JOB__REPAIRS = eINSTANCE.getRepairJob_Repairs();

		/**
		 * The meta object literal for the '<em><b>Inconsistencies</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REPAIR_JOB__INCONSISTENCIES = eINSTANCE.getRepairJob_Inconsistencies();

		/**
		 * The meta object literal for the '{@link org.sidiff.repair.model.repairjob.impl.EditRuleImpl <em>Edit Rule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.repair.model.repairjob.impl.EditRuleImpl
		 * @see org.sidiff.repair.model.repairjob.impl.RepairjobPackageImpl#getEditRule()
		 * @generated
		 */
		EClass EDIT_RULE = eINSTANCE.getEditRule();

		/**
		 * The meta object literal for the '<em><b>Rule</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EDIT_RULE__RULE = eINSTANCE.getEditRule_Rule();

		/**
		 * The meta object literal for the '<em><b>Repair Job</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EDIT_RULE__REPAIR_JOB = eINSTANCE.getEditRule_RepairJob();

		/**
		 * The meta object literal for the '<em><b>Repair Operations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EDIT_RULE__REPAIR_OPERATIONS = eINSTANCE.getEditRule_RepairOperations();

		/**
		 * The meta object literal for the '<em><b>Get Rating</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation EDIT_RULE___GET_RATING = eINSTANCE.getEditRule__GetRating();

		/**
		 * The meta object literal for the '{@link org.sidiff.repair.model.repairjob.impl.RepairOperationImpl <em>Repair Operation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.repair.model.repairjob.impl.RepairOperationImpl
		 * @see org.sidiff.repair.model.repairjob.impl.RepairjobPackageImpl#getRepairOperation()
		 * @generated
		 */
		EClass REPAIR_OPERATION = eINSTANCE.getRepairOperation();

		/**
		 * The meta object literal for the '<em><b>Context</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REPAIR_OPERATION__CONTEXT = eINSTANCE.getRepairOperation_Context();

		/**
		 * The meta object literal for the '<em><b>Edit Rule</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REPAIR_OPERATION__EDIT_RULE = eINSTANCE.getRepairOperation_EditRule();

		/**
		 * The meta object literal for the '<em><b>Sub Rule</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REPAIR_OPERATION__SUB_RULE = eINSTANCE.getRepairOperation_SubRule();

		/**
		 * The meta object literal for the '<em><b>Complement Rule</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REPAIR_OPERATION__COMPLEMENT_RULE = eINSTANCE.getRepairOperation_ComplementRule();

		/**
		 * The meta object literal for the '<em><b>Repairs</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REPAIR_OPERATION__REPAIRS = eINSTANCE.getRepairOperation_Repairs();

		/**
		 * The meta object literal for the '<em><b>Get Rating</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation REPAIR_OPERATION___GET_RATING = eINSTANCE.getRepairOperation__GetRating();

		/**
		 * The meta object literal for the '{@link org.sidiff.repair.model.repairjob.impl.PartialRuleImpl <em>Partial Rule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.repair.model.repairjob.impl.PartialRuleImpl
		 * @see org.sidiff.repair.model.repairjob.impl.RepairjobPackageImpl#getPartialRule()
		 * @generated
		 */
		EClass PARTIAL_RULE = eINSTANCE.getPartialRule();

		/**
		 * The meta object literal for the '<em><b>Change</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARTIAL_RULE__CHANGE = eINSTANCE.getPartialRule_Change();

		/**
		 * The meta object literal for the '{@link org.sidiff.repair.model.repairjob.impl.SubRuleImpl <em>Sub Rule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.repair.model.repairjob.impl.SubRuleImpl
		 * @see org.sidiff.repair.model.repairjob.impl.RepairjobPackageImpl#getSubRule()
		 * @generated
		 */
		EClass SUB_RULE = eINSTANCE.getSubRule();

		/**
		 * The meta object literal for the '<em><b>Repair Operation</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SUB_RULE__REPAIR_OPERATION = eINSTANCE.getSubRule_RepairOperation();

		/**
		 * The meta object literal for the '<em><b>Match</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SUB_RULE__MATCH = eINSTANCE.getSubRule_Match();

		/**
		 * The meta object literal for the '{@link org.sidiff.repair.model.repairjob.impl.ComplementRuleImpl <em>Complement Rule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.repair.model.repairjob.impl.ComplementRuleImpl
		 * @see org.sidiff.repair.model.repairjob.impl.RepairjobPackageImpl#getComplementRule()
		 * @generated
		 */
		EClass COMPLEMENT_RULE = eINSTANCE.getComplementRule();

		/**
		 * The meta object literal for the '<em><b>Repair Operation</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPLEMENT_RULE__REPAIR_OPERATION = eINSTANCE.getComplementRule_RepairOperation();

		/**
		 * The meta object literal for the '{@link org.sidiff.repair.model.repairjob.IRepair <em>IRepair</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.repair.model.repairjob.IRepair
		 * @see org.sidiff.repair.model.repairjob.impl.RepairjobPackageImpl#getIRepair()
		 * @generated
		 */
		EClass IREPAIR = eINSTANCE.getIRepair();

		/**
		 * The meta object literal for the '<em><b>Repair Operation</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IREPAIR__REPAIR_OPERATION = eINSTANCE.getIRepair_RepairOperation();

		/**
		 * The meta object literal for the '{@link org.sidiff.repair.model.repairjob.impl.RepairMatchImpl <em>Repair Match</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.repair.model.repairjob.impl.RepairMatchImpl
		 * @see org.sidiff.repair.model.repairjob.impl.RepairjobPackageImpl#getRepairMatch()
		 * @generated
		 */
		EClass REPAIR_MATCH = eINSTANCE.getRepairMatch();

		/**
		 * The meta object literal for the '{@link org.sidiff.repair.model.repairjob.impl.RepairParameterImpl <em>Repair Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.repair.model.repairjob.impl.RepairParameterImpl
		 * @see org.sidiff.repair.model.repairjob.impl.RepairjobPackageImpl#getRepairParameter()
		 * @generated
		 */
		EClass REPAIR_PARAMETER = eINSTANCE.getRepairParameter();

		/**
		 * The meta object literal for the '<em><b>Change</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REPAIR_PARAMETER__CHANGE = eINSTANCE.getRepairParameter_Change();

		/**
		 * The meta object literal for the '<em><b>Domain</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REPAIR_PARAMETER__DOMAIN = eINSTANCE.getRepairParameter_Domain();

		/**
		 * The meta object literal for the '{@link org.sidiff.repair.model.repairjob.impl.ChangeImpl <em>Change</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.repair.model.repairjob.impl.ChangeImpl
		 * @see org.sidiff.repair.model.repairjob.impl.RepairjobPackageImpl#getChange()
		 * @generated
		 */
		EClass CHANGE = eINSTANCE.getChange();

		/**
		 * The meta object literal for the '<em><b>Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CHANGE__ELEMENT = eINSTANCE.getChange_Element();

		/**
		 * The meta object literal for the '{@link org.sidiff.repair.model.repairjob.impl.MatchImpl <em>Match</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.repair.model.repairjob.impl.MatchImpl
		 * @see org.sidiff.repair.model.repairjob.impl.RepairjobPackageImpl#getMatch()
		 * @generated
		 */
		EClass MATCH = eINSTANCE.getMatch();

		/**
		 * The meta object literal for the '<em><b>Change</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MATCH__CHANGE = eINSTANCE.getMatch_Change();

		/**
		 * The meta object literal for the '<em><b>Elements</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MATCH__ELEMENTS = eINSTANCE.getMatch_Elements();

		/**
		 * The meta object literal for the '{@link org.sidiff.repair.model.repairjob.Inconsistency <em>Inconsistency</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.repair.model.repairjob.Inconsistency
		 * @see org.sidiff.repair.model.repairjob.impl.RepairjobPackageImpl#getInconsistency()
		 * @generated
		 */
		EClass INCONSISTENCY = eINSTANCE.getInconsistency();

		/**
		 * The meta object literal for the '<em><b>Repairs</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INCONSISTENCY__REPAIRS = eINSTANCE.getInconsistency_Repairs();

	}

} //RepairjobPackage
