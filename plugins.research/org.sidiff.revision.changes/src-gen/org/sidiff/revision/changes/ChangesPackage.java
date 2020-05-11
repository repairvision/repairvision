/**
 */
package org.sidiff.revision.changes;

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
 * @see org.sidiff.revision.changes.ChangesFactory
 * @model kind="package"
 * @generated
 */
public interface ChangesPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "changes";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.sidiff.org/changes/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "changes";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ChangesPackage eINSTANCE = org.sidiff.revision.changes.impl.ChangesPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.sidiff.revision.changes.NodeChangeContext <em>Node Change Context</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.revision.changes.NodeChangeContext
	 * @see org.sidiff.revision.changes.impl.ChangesPackageImpl#getNodeChangeContext()
	 * @generated
	 */
	int NODE_CHANGE_CONTEXT = 1;

	/**
	 * The feature id for the '<em><b>Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_CHANGE_CONTEXT__NODES = 0;

	/**
	 * The number of structural features of the '<em>Node Change Context</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_CHANGE_CONTEXT_FEATURE_COUNT = 1;

	/**
	 * The operation id for the '<em>Get Node</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_CHANGE_CONTEXT___GET_NODE__NODECHANGE = 0;

	/**
	 * The operation id for the '<em>Get Node Domains</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_CHANGE_CONTEXT___GET_NODE_DOMAINS__NODECHANGE = 1;

	/**
	 * The operation id for the '<em>Get Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_CHANGE_CONTEXT___GET_TYPE__NODECHANGE = 2;

	/**
	 * The number of operations of the '<em>Node Change Context</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_CHANGE_CONTEXT_OPERATION_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.sidiff.revision.changes.ChangeContext <em>Change Context</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.revision.changes.ChangeContext
	 * @see org.sidiff.revision.changes.impl.ChangesPackageImpl#getChangeContext()
	 * @generated
	 */
	int CHANGE_CONTEXT = 8;

	/**
	 * The feature id for the '<em><b>Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANGE_CONTEXT__NODES = NODE_CHANGE_CONTEXT__NODES;

	/**
	 * The feature id for the '<em><b>Edges</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANGE_CONTEXT__EDGES = NODE_CHANGE_CONTEXT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANGE_CONTEXT__ATTRIBUTES = NODE_CHANGE_CONTEXT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Change Context</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANGE_CONTEXT_FEATURE_COUNT = NODE_CHANGE_CONTEXT_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Get Node</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANGE_CONTEXT___GET_NODE__NODECHANGE = NODE_CHANGE_CONTEXT___GET_NODE__NODECHANGE;

	/**
	 * The operation id for the '<em>Get Node Domains</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANGE_CONTEXT___GET_NODE_DOMAINS__NODECHANGE = NODE_CHANGE_CONTEXT___GET_NODE_DOMAINS__NODECHANGE;

	/**
	 * The operation id for the '<em>Get Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANGE_CONTEXT___GET_TYPE__NODECHANGE = NODE_CHANGE_CONTEXT___GET_TYPE__NODECHANGE;

	/**
	 * The operation id for the '<em>Get Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANGE_CONTEXT___GET_TYPE__EDGECHANGE = NODE_CHANGE_CONTEXT_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Source Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANGE_CONTEXT___GET_SOURCE_TYPE__EDGECHANGE = NODE_CHANGE_CONTEXT_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Source Domain</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANGE_CONTEXT___GET_SOURCE_DOMAIN__EDGECHANGE = NODE_CHANGE_CONTEXT_OPERATION_COUNT + 2;

	/**
	 * The operation id for the '<em>Get Source</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANGE_CONTEXT___GET_SOURCE__EDGECHANGE = NODE_CHANGE_CONTEXT_OPERATION_COUNT + 3;

	/**
	 * The operation id for the '<em>Get Target Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANGE_CONTEXT___GET_TARGET_TYPE__EDGECHANGE = NODE_CHANGE_CONTEXT_OPERATION_COUNT + 4;

	/**
	 * The operation id for the '<em>Get Target Domain</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANGE_CONTEXT___GET_TARGET_DOMAIN__EDGECHANGE = NODE_CHANGE_CONTEXT_OPERATION_COUNT + 5;

	/**
	 * The operation id for the '<em>Get Target</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANGE_CONTEXT___GET_TARGET__EDGECHANGE = NODE_CHANGE_CONTEXT_OPERATION_COUNT + 6;

	/**
	 * The operation id for the '<em>Get Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANGE_CONTEXT___GET_TYPE__ATTRIBUTECHANGE = NODE_CHANGE_CONTEXT_OPERATION_COUNT + 7;

	/**
	 * The operation id for the '<em>Get Node</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANGE_CONTEXT___GET_NODE__ATTRIBUTECHANGE = NODE_CHANGE_CONTEXT_OPERATION_COUNT + 8;

	/**
	 * The operation id for the '<em>Get Node Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANGE_CONTEXT___GET_NODE_TYPE__ATTRIBUTECHANGE = NODE_CHANGE_CONTEXT_OPERATION_COUNT + 9;

	/**
	 * The operation id for the '<em>Get Node Domain</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANGE_CONTEXT___GET_NODE_DOMAIN__ATTRIBUTECHANGE = NODE_CHANGE_CONTEXT_OPERATION_COUNT + 10;

	/**
	 * The operation id for the '<em>Get Value Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANGE_CONTEXT___GET_VALUE_TYPE__ATTRIBUTECHANGE = NODE_CHANGE_CONTEXT_OPERATION_COUNT + 11;

	/**
	 * The operation id for the '<em>Get Value Domain</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANGE_CONTEXT___GET_VALUE_DOMAIN__ATTRIBUTECHANGE = NODE_CHANGE_CONTEXT_OPERATION_COUNT + 12;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANGE_CONTEXT___GET_VALUE__ATTRIBUTECHANGE = NODE_CHANGE_CONTEXT_OPERATION_COUNT + 13;

	/**
	 * The operation id for the '<em>Get Action</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANGE_CONTEXT___GET_ACTION__CHANGE = NODE_CHANGE_CONTEXT_OPERATION_COUNT + 14;

	/**
	 * The number of operations of the '<em>Change Context</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANGE_CONTEXT_OPERATION_COUNT = NODE_CHANGE_CONTEXT_OPERATION_COUNT + 15;

	/**
	 * The meta object id for the '{@link org.sidiff.revision.changes.impl.ChangeSetImpl <em>Change Set</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.revision.changes.impl.ChangeSetImpl
	 * @see org.sidiff.revision.changes.impl.ChangesPackageImpl#getChangeSet()
	 * @generated
	 */
	int CHANGE_SET = 0;

	/**
	 * The feature id for the '<em><b>Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANGE_SET__NODES = CHANGE_CONTEXT__NODES;

	/**
	 * The feature id for the '<em><b>Edges</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANGE_SET__EDGES = CHANGE_CONTEXT__EDGES;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANGE_SET__ATTRIBUTES = CHANGE_CONTEXT__ATTRIBUTES;

	/**
	 * The number of structural features of the '<em>Change Set</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANGE_SET_FEATURE_COUNT = CHANGE_CONTEXT_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Node</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANGE_SET___GET_NODE__NODECHANGE = CHANGE_CONTEXT___GET_NODE__NODECHANGE;

	/**
	 * The operation id for the '<em>Get Node Domains</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANGE_SET___GET_NODE_DOMAINS__NODECHANGE = CHANGE_CONTEXT___GET_NODE_DOMAINS__NODECHANGE;

	/**
	 * The operation id for the '<em>Get Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANGE_SET___GET_TYPE__NODECHANGE = CHANGE_CONTEXT___GET_TYPE__NODECHANGE;

	/**
	 * The operation id for the '<em>Get Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANGE_SET___GET_TYPE__EDGECHANGE = CHANGE_CONTEXT___GET_TYPE__EDGECHANGE;

	/**
	 * The operation id for the '<em>Get Source Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANGE_SET___GET_SOURCE_TYPE__EDGECHANGE = CHANGE_CONTEXT___GET_SOURCE_TYPE__EDGECHANGE;

	/**
	 * The operation id for the '<em>Get Source Domain</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANGE_SET___GET_SOURCE_DOMAIN__EDGECHANGE = CHANGE_CONTEXT___GET_SOURCE_DOMAIN__EDGECHANGE;

	/**
	 * The operation id for the '<em>Get Source</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANGE_SET___GET_SOURCE__EDGECHANGE = CHANGE_CONTEXT___GET_SOURCE__EDGECHANGE;

	/**
	 * The operation id for the '<em>Get Target Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANGE_SET___GET_TARGET_TYPE__EDGECHANGE = CHANGE_CONTEXT___GET_TARGET_TYPE__EDGECHANGE;

	/**
	 * The operation id for the '<em>Get Target Domain</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANGE_SET___GET_TARGET_DOMAIN__EDGECHANGE = CHANGE_CONTEXT___GET_TARGET_DOMAIN__EDGECHANGE;

	/**
	 * The operation id for the '<em>Get Target</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANGE_SET___GET_TARGET__EDGECHANGE = CHANGE_CONTEXT___GET_TARGET__EDGECHANGE;

	/**
	 * The operation id for the '<em>Get Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANGE_SET___GET_TYPE__ATTRIBUTECHANGE = CHANGE_CONTEXT___GET_TYPE__ATTRIBUTECHANGE;

	/**
	 * The operation id for the '<em>Get Node</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANGE_SET___GET_NODE__ATTRIBUTECHANGE = CHANGE_CONTEXT___GET_NODE__ATTRIBUTECHANGE;

	/**
	 * The operation id for the '<em>Get Node Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANGE_SET___GET_NODE_TYPE__ATTRIBUTECHANGE = CHANGE_CONTEXT___GET_NODE_TYPE__ATTRIBUTECHANGE;

	/**
	 * The operation id for the '<em>Get Node Domain</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANGE_SET___GET_NODE_DOMAIN__ATTRIBUTECHANGE = CHANGE_CONTEXT___GET_NODE_DOMAIN__ATTRIBUTECHANGE;

	/**
	 * The operation id for the '<em>Get Value Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANGE_SET___GET_VALUE_TYPE__ATTRIBUTECHANGE = CHANGE_CONTEXT___GET_VALUE_TYPE__ATTRIBUTECHANGE;

	/**
	 * The operation id for the '<em>Get Value Domain</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANGE_SET___GET_VALUE_DOMAIN__ATTRIBUTECHANGE = CHANGE_CONTEXT___GET_VALUE_DOMAIN__ATTRIBUTECHANGE;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANGE_SET___GET_VALUE__ATTRIBUTECHANGE = CHANGE_CONTEXT___GET_VALUE__ATTRIBUTECHANGE;

	/**
	 * The operation id for the '<em>Get Action</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANGE_SET___GET_ACTION__CHANGE = CHANGE_CONTEXT___GET_ACTION__CHANGE;

	/**
	 * The operation id for the '<em>Get Changes</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANGE_SET___GET_CHANGES = CHANGE_CONTEXT_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Change Set</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANGE_SET_OPERATION_COUNT = CHANGE_CONTEXT_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.sidiff.revision.changes.AttributeChangeContext <em>Attribute Change Context</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.revision.changes.AttributeChangeContext
	 * @see org.sidiff.revision.changes.impl.ChangesPackageImpl#getAttributeChangeContext()
	 * @generated
	 */
	int ATTRIBUTE_CHANGE_CONTEXT = 2;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_CHANGE_CONTEXT__ATTRIBUTES = 0;

	/**
	 * The number of structural features of the '<em>Attribute Change Context</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_CHANGE_CONTEXT_FEATURE_COUNT = 1;

	/**
	 * The operation id for the '<em>Get Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_CHANGE_CONTEXT___GET_TYPE__ATTRIBUTECHANGE = 0;

	/**
	 * The operation id for the '<em>Get Node</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_CHANGE_CONTEXT___GET_NODE__ATTRIBUTECHANGE = 1;

	/**
	 * The operation id for the '<em>Get Node Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_CHANGE_CONTEXT___GET_NODE_TYPE__ATTRIBUTECHANGE = 2;

	/**
	 * The operation id for the '<em>Get Node Domain</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_CHANGE_CONTEXT___GET_NODE_DOMAIN__ATTRIBUTECHANGE = 3;

	/**
	 * The operation id for the '<em>Get Value Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_CHANGE_CONTEXT___GET_VALUE_TYPE__ATTRIBUTECHANGE = 4;

	/**
	 * The operation id for the '<em>Get Value Domain</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_CHANGE_CONTEXT___GET_VALUE_DOMAIN__ATTRIBUTECHANGE = 5;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_CHANGE_CONTEXT___GET_VALUE__ATTRIBUTECHANGE = 6;

	/**
	 * The number of operations of the '<em>Attribute Change Context</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_CHANGE_CONTEXT_OPERATION_COUNT = 7;

	/**
	 * The meta object id for the '{@link org.sidiff.revision.changes.EdgeChangeContext <em>Edge Change Context</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.revision.changes.EdgeChangeContext
	 * @see org.sidiff.revision.changes.impl.ChangesPackageImpl#getEdgeChangeContext()
	 * @generated
	 */
	int EDGE_CHANGE_CONTEXT = 3;

	/**
	 * The feature id for the '<em><b>Edges</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_CHANGE_CONTEXT__EDGES = 0;

	/**
	 * The number of structural features of the '<em>Edge Change Context</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_CHANGE_CONTEXT_FEATURE_COUNT = 1;

	/**
	 * The operation id for the '<em>Get Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_CHANGE_CONTEXT___GET_TYPE__EDGECHANGE = 0;

	/**
	 * The operation id for the '<em>Get Source Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_CHANGE_CONTEXT___GET_SOURCE_TYPE__EDGECHANGE = 1;

	/**
	 * The operation id for the '<em>Get Source Domain</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_CHANGE_CONTEXT___GET_SOURCE_DOMAIN__EDGECHANGE = 2;

	/**
	 * The operation id for the '<em>Get Source</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_CHANGE_CONTEXT___GET_SOURCE__EDGECHANGE = 3;

	/**
	 * The operation id for the '<em>Get Target Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_CHANGE_CONTEXT___GET_TARGET_TYPE__EDGECHANGE = 4;

	/**
	 * The operation id for the '<em>Get Target Domain</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_CHANGE_CONTEXT___GET_TARGET_DOMAIN__EDGECHANGE = 5;

	/**
	 * The operation id for the '<em>Get Target</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_CHANGE_CONTEXT___GET_TARGET__EDGECHANGE = 6;

	/**
	 * The number of operations of the '<em>Edge Change Context</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_CHANGE_CONTEXT_OPERATION_COUNT = 7;

	/**
	 * The meta object id for the '{@link org.sidiff.revision.changes.impl.ChangeImpl <em>Change</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.revision.changes.impl.ChangeImpl
	 * @see org.sidiff.revision.changes.impl.ChangesPackageImpl#getChange()
	 * @generated
	 */
	int CHANGE = 4;

	/**
	 * The number of structural features of the '<em>Change</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANGE_FEATURE_COUNT = 0;

	/**
	 * The operation id for the '<em>Get Action</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANGE___GET_ACTION = 0;

	/**
	 * The number of operations of the '<em>Change</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANGE_OPERATION_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.sidiff.revision.changes.impl.NodeChangeImpl <em>Node Change</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.revision.changes.impl.NodeChangeImpl
	 * @see org.sidiff.revision.changes.impl.ChangesPackageImpl#getNodeChange()
	 * @generated
	 */
	int NODE_CHANGE = 5;

	/**
	 * The feature id for the '<em><b>Context</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_CHANGE__CONTEXT = CHANGE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Node Change</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_CHANGE_FEATURE_COUNT = CHANGE_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Action</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_CHANGE___GET_ACTION = CHANGE___GET_ACTION;

	/**
	 * The operation id for the '<em>Get Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_CHANGE___GET_TYPE = CHANGE_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Node Domains</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_CHANGE___GET_NODE_DOMAINS = CHANGE_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Node</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_CHANGE___GET_NODE = CHANGE_OPERATION_COUNT + 2;

	/**
	 * The number of operations of the '<em>Node Change</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_CHANGE_OPERATION_COUNT = CHANGE_OPERATION_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.sidiff.revision.changes.impl.AttributeChangeImpl <em>Attribute Change</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.revision.changes.impl.AttributeChangeImpl
	 * @see org.sidiff.revision.changes.impl.ChangesPackageImpl#getAttributeChange()
	 * @generated
	 */
	int ATTRIBUTE_CHANGE = 6;

	/**
	 * The feature id for the '<em><b>Context</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_CHANGE__CONTEXT = CHANGE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Attribute Change</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_CHANGE_FEATURE_COUNT = CHANGE_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Action</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_CHANGE___GET_ACTION = CHANGE___GET_ACTION;

	/**
	 * The operation id for the '<em>Get Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_CHANGE___GET_TYPE = CHANGE_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Node Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_CHANGE___GET_NODE_TYPE = CHANGE_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Node Domain</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_CHANGE___GET_NODE_DOMAIN = CHANGE_OPERATION_COUNT + 2;

	/**
	 * The operation id for the '<em>Get Node</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_CHANGE___GET_NODE = CHANGE_OPERATION_COUNT + 3;

	/**
	 * The operation id for the '<em>Get Value Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_CHANGE___GET_VALUE_TYPE = CHANGE_OPERATION_COUNT + 4;

	/**
	 * The operation id for the '<em>Get Value Domain</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_CHANGE___GET_VALUE_DOMAIN = CHANGE_OPERATION_COUNT + 5;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_CHANGE___GET_VALUE = CHANGE_OPERATION_COUNT + 6;

	/**
	 * The number of operations of the '<em>Attribute Change</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_CHANGE_OPERATION_COUNT = CHANGE_OPERATION_COUNT + 7;

	/**
	 * The meta object id for the '{@link org.sidiff.revision.changes.impl.EdgeChangeImpl <em>Edge Change</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.revision.changes.impl.EdgeChangeImpl
	 * @see org.sidiff.revision.changes.impl.ChangesPackageImpl#getEdgeChange()
	 * @generated
	 */
	int EDGE_CHANGE = 7;

	/**
	 * The feature id for the '<em><b>Context</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_CHANGE__CONTEXT = CHANGE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Edge Change</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_CHANGE_FEATURE_COUNT = CHANGE_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Action</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_CHANGE___GET_ACTION = CHANGE___GET_ACTION;

	/**
	 * The operation id for the '<em>Get Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_CHANGE___GET_TYPE = CHANGE_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Ge Source Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_CHANGE___GE_SOURCE_TYPE = CHANGE_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Source Domain</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_CHANGE___GET_SOURCE_DOMAIN = CHANGE_OPERATION_COUNT + 2;

	/**
	 * The operation id for the '<em>Get Source</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_CHANGE___GET_SOURCE = CHANGE_OPERATION_COUNT + 3;

	/**
	 * The operation id for the '<em>Get Target Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_CHANGE___GET_TARGET_TYPE = CHANGE_OPERATION_COUNT + 4;

	/**
	 * The operation id for the '<em>Get Target Domain</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_CHANGE___GET_TARGET_DOMAIN = CHANGE_OPERATION_COUNT + 5;

	/**
	 * The operation id for the '<em>Get Target</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_CHANGE___GET_TARGET = CHANGE_OPERATION_COUNT + 6;

	/**
	 * The number of operations of the '<em>Edge Change</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_CHANGE_OPERATION_COUNT = CHANGE_OPERATION_COUNT + 7;

	/**
	 * The meta object id for the '{@link org.sidiff.revision.changes.ActionType <em>Action Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.revision.changes.ActionType
	 * @see org.sidiff.revision.changes.impl.ChangesPackageImpl#getActionType()
	 * @generated
	 */
	int ACTION_TYPE = 9;

	/**
	 * The meta object id for the '<em>Change Iterator</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.util.Iterator
	 * @see org.sidiff.revision.changes.impl.ChangesPackageImpl#getChangeIterator()
	 * @generated
	 */
	int CHANGE_ITERATOR = 10;

	/**
	 * Returns the meta object for class '{@link org.sidiff.revision.changes.ChangeSet <em>Change Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Change Set</em>'.
	 * @see org.sidiff.revision.changes.ChangeSet
	 * @generated
	 */
	EClass getChangeSet();

	/**
	 * Returns the meta object for the '{@link org.sidiff.revision.changes.ChangeSet#getChanges() <em>Get Changes</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Changes</em>' operation.
	 * @see org.sidiff.revision.changes.ChangeSet#getChanges()
	 * @generated
	 */
	EOperation getChangeSet__GetChanges();

	/**
	 * Returns the meta object for class '{@link org.sidiff.revision.changes.NodeChangeContext <em>Node Change Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Node Change Context</em>'.
	 * @see org.sidiff.revision.changes.NodeChangeContext
	 * @generated
	 */
	EClass getNodeChangeContext();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sidiff.revision.changes.NodeChangeContext#getNodes <em>Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Nodes</em>'.
	 * @see org.sidiff.revision.changes.NodeChangeContext#getNodes()
	 * @see #getNodeChangeContext()
	 * @generated
	 */
	EReference getNodeChangeContext_Nodes();

	/**
	 * Returns the meta object for the '{@link org.sidiff.revision.changes.NodeChangeContext#getNode(org.sidiff.revision.changes.NodeChange) <em>Get Node</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Node</em>' operation.
	 * @see org.sidiff.revision.changes.NodeChangeContext#getNode(org.sidiff.revision.changes.NodeChange)
	 * @generated
	 */
	EOperation getNodeChangeContext__GetNode__NodeChange();

	/**
	 * Returns the meta object for the '{@link org.sidiff.revision.changes.NodeChangeContext#getNodeDomains(org.sidiff.revision.changes.NodeChange) <em>Get Node Domains</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Node Domains</em>' operation.
	 * @see org.sidiff.revision.changes.NodeChangeContext#getNodeDomains(org.sidiff.revision.changes.NodeChange)
	 * @generated
	 */
	EOperation getNodeChangeContext__GetNodeDomains__NodeChange();

	/**
	 * Returns the meta object for the '{@link org.sidiff.revision.changes.NodeChangeContext#getType(org.sidiff.revision.changes.NodeChange) <em>Get Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Type</em>' operation.
	 * @see org.sidiff.revision.changes.NodeChangeContext#getType(org.sidiff.revision.changes.NodeChange)
	 * @generated
	 */
	EOperation getNodeChangeContext__GetType__NodeChange();

	/**
	 * Returns the meta object for class '{@link org.sidiff.revision.changes.AttributeChangeContext <em>Attribute Change Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Attribute Change Context</em>'.
	 * @see org.sidiff.revision.changes.AttributeChangeContext
	 * @generated
	 */
	EClass getAttributeChangeContext();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sidiff.revision.changes.AttributeChangeContext#getAttributes <em>Attributes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Attributes</em>'.
	 * @see org.sidiff.revision.changes.AttributeChangeContext#getAttributes()
	 * @see #getAttributeChangeContext()
	 * @generated
	 */
	EReference getAttributeChangeContext_Attributes();

	/**
	 * Returns the meta object for the '{@link org.sidiff.revision.changes.AttributeChangeContext#getType(org.sidiff.revision.changes.AttributeChange) <em>Get Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Type</em>' operation.
	 * @see org.sidiff.revision.changes.AttributeChangeContext#getType(org.sidiff.revision.changes.AttributeChange)
	 * @generated
	 */
	EOperation getAttributeChangeContext__GetType__AttributeChange();

	/**
	 * Returns the meta object for the '{@link org.sidiff.revision.changes.AttributeChangeContext#getNode(org.sidiff.revision.changes.AttributeChange) <em>Get Node</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Node</em>' operation.
	 * @see org.sidiff.revision.changes.AttributeChangeContext#getNode(org.sidiff.revision.changes.AttributeChange)
	 * @generated
	 */
	EOperation getAttributeChangeContext__GetNode__AttributeChange();

	/**
	 * Returns the meta object for the '{@link org.sidiff.revision.changes.AttributeChangeContext#getNodeType(org.sidiff.revision.changes.AttributeChange) <em>Get Node Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Node Type</em>' operation.
	 * @see org.sidiff.revision.changes.AttributeChangeContext#getNodeType(org.sidiff.revision.changes.AttributeChange)
	 * @generated
	 */
	EOperation getAttributeChangeContext__GetNodeType__AttributeChange();

	/**
	 * Returns the meta object for the '{@link org.sidiff.revision.changes.AttributeChangeContext#getNodeDomain(org.sidiff.revision.changes.AttributeChange) <em>Get Node Domain</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Node Domain</em>' operation.
	 * @see org.sidiff.revision.changes.AttributeChangeContext#getNodeDomain(org.sidiff.revision.changes.AttributeChange)
	 * @generated
	 */
	EOperation getAttributeChangeContext__GetNodeDomain__AttributeChange();

	/**
	 * Returns the meta object for the '{@link org.sidiff.revision.changes.AttributeChangeContext#getValueType(org.sidiff.revision.changes.AttributeChange) <em>Get Value Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Value Type</em>' operation.
	 * @see org.sidiff.revision.changes.AttributeChangeContext#getValueType(org.sidiff.revision.changes.AttributeChange)
	 * @generated
	 */
	EOperation getAttributeChangeContext__GetValueType__AttributeChange();

	/**
	 * Returns the meta object for the '{@link org.sidiff.revision.changes.AttributeChangeContext#getValueDomain(org.sidiff.revision.changes.AttributeChange) <em>Get Value Domain</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Value Domain</em>' operation.
	 * @see org.sidiff.revision.changes.AttributeChangeContext#getValueDomain(org.sidiff.revision.changes.AttributeChange)
	 * @generated
	 */
	EOperation getAttributeChangeContext__GetValueDomain__AttributeChange();

	/**
	 * Returns the meta object for the '{@link org.sidiff.revision.changes.AttributeChangeContext#getValue(org.sidiff.revision.changes.AttributeChange) <em>Get Value</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Value</em>' operation.
	 * @see org.sidiff.revision.changes.AttributeChangeContext#getValue(org.sidiff.revision.changes.AttributeChange)
	 * @generated
	 */
	EOperation getAttributeChangeContext__GetValue__AttributeChange();

	/**
	 * Returns the meta object for class '{@link org.sidiff.revision.changes.EdgeChangeContext <em>Edge Change Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Edge Change Context</em>'.
	 * @see org.sidiff.revision.changes.EdgeChangeContext
	 * @generated
	 */
	EClass getEdgeChangeContext();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sidiff.revision.changes.EdgeChangeContext#getEdges <em>Edges</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Edges</em>'.
	 * @see org.sidiff.revision.changes.EdgeChangeContext#getEdges()
	 * @see #getEdgeChangeContext()
	 * @generated
	 */
	EReference getEdgeChangeContext_Edges();

	/**
	 * Returns the meta object for the '{@link org.sidiff.revision.changes.EdgeChangeContext#getTargetType(org.sidiff.revision.changes.EdgeChange) <em>Get Target Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Target Type</em>' operation.
	 * @see org.sidiff.revision.changes.EdgeChangeContext#getTargetType(org.sidiff.revision.changes.EdgeChange)
	 * @generated
	 */
	EOperation getEdgeChangeContext__GetTargetType__EdgeChange();

	/**
	 * Returns the meta object for the '{@link org.sidiff.revision.changes.EdgeChangeContext#getType(org.sidiff.revision.changes.EdgeChange) <em>Get Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Type</em>' operation.
	 * @see org.sidiff.revision.changes.EdgeChangeContext#getType(org.sidiff.revision.changes.EdgeChange)
	 * @generated
	 */
	EOperation getEdgeChangeContext__GetType__EdgeChange();

	/**
	 * Returns the meta object for the '{@link org.sidiff.revision.changes.EdgeChangeContext#getSourceType(org.sidiff.revision.changes.EdgeChange) <em>Get Source Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Source Type</em>' operation.
	 * @see org.sidiff.revision.changes.EdgeChangeContext#getSourceType(org.sidiff.revision.changes.EdgeChange)
	 * @generated
	 */
	EOperation getEdgeChangeContext__GetSourceType__EdgeChange();

	/**
	 * Returns the meta object for the '{@link org.sidiff.revision.changes.EdgeChangeContext#getSource(org.sidiff.revision.changes.EdgeChange) <em>Get Source</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Source</em>' operation.
	 * @see org.sidiff.revision.changes.EdgeChangeContext#getSource(org.sidiff.revision.changes.EdgeChange)
	 * @generated
	 */
	EOperation getEdgeChangeContext__GetSource__EdgeChange();

	/**
	 * Returns the meta object for the '{@link org.sidiff.revision.changes.EdgeChangeContext#getSourceDomain(org.sidiff.revision.changes.EdgeChange) <em>Get Source Domain</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Source Domain</em>' operation.
	 * @see org.sidiff.revision.changes.EdgeChangeContext#getSourceDomain(org.sidiff.revision.changes.EdgeChange)
	 * @generated
	 */
	EOperation getEdgeChangeContext__GetSourceDomain__EdgeChange();

	/**
	 * Returns the meta object for the '{@link org.sidiff.revision.changes.EdgeChangeContext#getTarget(org.sidiff.revision.changes.EdgeChange) <em>Get Target</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Target</em>' operation.
	 * @see org.sidiff.revision.changes.EdgeChangeContext#getTarget(org.sidiff.revision.changes.EdgeChange)
	 * @generated
	 */
	EOperation getEdgeChangeContext__GetTarget__EdgeChange();

	/**
	 * Returns the meta object for the '{@link org.sidiff.revision.changes.EdgeChangeContext#getTargetDomain(org.sidiff.revision.changes.EdgeChange) <em>Get Target Domain</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Target Domain</em>' operation.
	 * @see org.sidiff.revision.changes.EdgeChangeContext#getTargetDomain(org.sidiff.revision.changes.EdgeChange)
	 * @generated
	 */
	EOperation getEdgeChangeContext__GetTargetDomain__EdgeChange();

	/**
	 * Returns the meta object for class '{@link org.sidiff.revision.changes.Change <em>Change</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Change</em>'.
	 * @see org.sidiff.revision.changes.Change
	 * @generated
	 */
	EClass getChange();

	/**
	 * Returns the meta object for the '{@link org.sidiff.revision.changes.Change#getAction() <em>Get Action</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Action</em>' operation.
	 * @see org.sidiff.revision.changes.Change#getAction()
	 * @generated
	 */
	EOperation getChange__GetAction();

	/**
	 * Returns the meta object for class '{@link org.sidiff.revision.changes.NodeChange <em>Node Change</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Node Change</em>'.
	 * @see org.sidiff.revision.changes.NodeChange
	 * @generated
	 */
	EClass getNodeChange();

	/**
	 * Returns the meta object for the container reference '{@link org.sidiff.revision.changes.NodeChange#getContext <em>Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Context</em>'.
	 * @see org.sidiff.revision.changes.NodeChange#getContext()
	 * @see #getNodeChange()
	 * @generated
	 */
	EReference getNodeChange_Context();

	/**
	 * Returns the meta object for the '{@link org.sidiff.revision.changes.NodeChange#getType() <em>Get Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Type</em>' operation.
	 * @see org.sidiff.revision.changes.NodeChange#getType()
	 * @generated
	 */
	EOperation getNodeChange__GetType();

	/**
	 * Returns the meta object for the '{@link org.sidiff.revision.changes.NodeChange#getNodeDomains() <em>Get Node Domains</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Node Domains</em>' operation.
	 * @see org.sidiff.revision.changes.NodeChange#getNodeDomains()
	 * @generated
	 */
	EOperation getNodeChange__GetNodeDomains();

	/**
	 * Returns the meta object for the '{@link org.sidiff.revision.changes.NodeChange#getNode() <em>Get Node</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Node</em>' operation.
	 * @see org.sidiff.revision.changes.NodeChange#getNode()
	 * @generated
	 */
	EOperation getNodeChange__GetNode();

	/**
	 * Returns the meta object for class '{@link org.sidiff.revision.changes.AttributeChange <em>Attribute Change</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Attribute Change</em>'.
	 * @see org.sidiff.revision.changes.AttributeChange
	 * @generated
	 */
	EClass getAttributeChange();

	/**
	 * Returns the meta object for the container reference '{@link org.sidiff.revision.changes.AttributeChange#getContext <em>Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Context</em>'.
	 * @see org.sidiff.revision.changes.AttributeChange#getContext()
	 * @see #getAttributeChange()
	 * @generated
	 */
	EReference getAttributeChange_Context();

	/**
	 * Returns the meta object for the '{@link org.sidiff.revision.changes.AttributeChange#getType() <em>Get Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Type</em>' operation.
	 * @see org.sidiff.revision.changes.AttributeChange#getType()
	 * @generated
	 */
	EOperation getAttributeChange__GetType();

	/**
	 * Returns the meta object for the '{@link org.sidiff.revision.changes.AttributeChange#getNodeType() <em>Get Node Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Node Type</em>' operation.
	 * @see org.sidiff.revision.changes.AttributeChange#getNodeType()
	 * @generated
	 */
	EOperation getAttributeChange__GetNodeType();

	/**
	 * Returns the meta object for the '{@link org.sidiff.revision.changes.AttributeChange#getNodeDomain() <em>Get Node Domain</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Node Domain</em>' operation.
	 * @see org.sidiff.revision.changes.AttributeChange#getNodeDomain()
	 * @generated
	 */
	EOperation getAttributeChange__GetNodeDomain();

	/**
	 * Returns the meta object for the '{@link org.sidiff.revision.changes.AttributeChange#getNode() <em>Get Node</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Node</em>' operation.
	 * @see org.sidiff.revision.changes.AttributeChange#getNode()
	 * @generated
	 */
	EOperation getAttributeChange__GetNode();

	/**
	 * Returns the meta object for the '{@link org.sidiff.revision.changes.AttributeChange#getValueType() <em>Get Value Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Value Type</em>' operation.
	 * @see org.sidiff.revision.changes.AttributeChange#getValueType()
	 * @generated
	 */
	EOperation getAttributeChange__GetValueType();

	/**
	 * Returns the meta object for the '{@link org.sidiff.revision.changes.AttributeChange#getValueDomain() <em>Get Value Domain</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Value Domain</em>' operation.
	 * @see org.sidiff.revision.changes.AttributeChange#getValueDomain()
	 * @generated
	 */
	EOperation getAttributeChange__GetValueDomain();

	/**
	 * Returns the meta object for the '{@link org.sidiff.revision.changes.AttributeChange#getValue() <em>Get Value</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Value</em>' operation.
	 * @see org.sidiff.revision.changes.AttributeChange#getValue()
	 * @generated
	 */
	EOperation getAttributeChange__GetValue();

	/**
	 * Returns the meta object for class '{@link org.sidiff.revision.changes.EdgeChange <em>Edge Change</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Edge Change</em>'.
	 * @see org.sidiff.revision.changes.EdgeChange
	 * @generated
	 */
	EClass getEdgeChange();

	/**
	 * Returns the meta object for the container reference '{@link org.sidiff.revision.changes.EdgeChange#getContext <em>Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Context</em>'.
	 * @see org.sidiff.revision.changes.EdgeChange#getContext()
	 * @see #getEdgeChange()
	 * @generated
	 */
	EReference getEdgeChange_Context();

	/**
	 * Returns the meta object for the '{@link org.sidiff.revision.changes.EdgeChange#getType() <em>Get Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Type</em>' operation.
	 * @see org.sidiff.revision.changes.EdgeChange#getType()
	 * @generated
	 */
	EOperation getEdgeChange__GetType();

	/**
	 * Returns the meta object for the '{@link org.sidiff.revision.changes.EdgeChange#geSourceType() <em>Ge Source Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Ge Source Type</em>' operation.
	 * @see org.sidiff.revision.changes.EdgeChange#geSourceType()
	 * @generated
	 */
	EOperation getEdgeChange__GeSourceType();

	/**
	 * Returns the meta object for the '{@link org.sidiff.revision.changes.EdgeChange#getSourceDomain() <em>Get Source Domain</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Source Domain</em>' operation.
	 * @see org.sidiff.revision.changes.EdgeChange#getSourceDomain()
	 * @generated
	 */
	EOperation getEdgeChange__GetSourceDomain();

	/**
	 * Returns the meta object for the '{@link org.sidiff.revision.changes.EdgeChange#getSource() <em>Get Source</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Source</em>' operation.
	 * @see org.sidiff.revision.changes.EdgeChange#getSource()
	 * @generated
	 */
	EOperation getEdgeChange__GetSource();

	/**
	 * Returns the meta object for the '{@link org.sidiff.revision.changes.EdgeChange#getTargetType() <em>Get Target Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Target Type</em>' operation.
	 * @see org.sidiff.revision.changes.EdgeChange#getTargetType()
	 * @generated
	 */
	EOperation getEdgeChange__GetTargetType();

	/**
	 * Returns the meta object for the '{@link org.sidiff.revision.changes.EdgeChange#getTargetDomain() <em>Get Target Domain</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Target Domain</em>' operation.
	 * @see org.sidiff.revision.changes.EdgeChange#getTargetDomain()
	 * @generated
	 */
	EOperation getEdgeChange__GetTargetDomain();

	/**
	 * Returns the meta object for the '{@link org.sidiff.revision.changes.EdgeChange#getTarget() <em>Get Target</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Target</em>' operation.
	 * @see org.sidiff.revision.changes.EdgeChange#getTarget()
	 * @generated
	 */
	EOperation getEdgeChange__GetTarget();

	/**
	 * Returns the meta object for class '{@link org.sidiff.revision.changes.ChangeContext <em>Change Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Change Context</em>'.
	 * @see org.sidiff.revision.changes.ChangeContext
	 * @generated
	 */
	EClass getChangeContext();

	/**
	 * Returns the meta object for the '{@link org.sidiff.revision.changes.ChangeContext#getAction(org.sidiff.revision.changes.Change) <em>Get Action</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Action</em>' operation.
	 * @see org.sidiff.revision.changes.ChangeContext#getAction(org.sidiff.revision.changes.Change)
	 * @generated
	 */
	EOperation getChangeContext__GetAction__Change();

	/**
	 * Returns the meta object for enum '{@link org.sidiff.revision.changes.ActionType <em>Action Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Action Type</em>'.
	 * @see org.sidiff.revision.changes.ActionType
	 * @generated
	 */
	EEnum getActionType();

	/**
	 * Returns the meta object for data type '{@link java.util.Iterator <em>Change Iterator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Change Iterator</em>'.
	 * @see java.util.Iterator
	 * @model instanceClass="java.util.Iterator&lt;org.sidiff.revision.changes.Change&gt;" serializeable="false"
	 * @generated
	 */
	EDataType getChangeIterator();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ChangesFactory getChangesFactory();

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
		 * The meta object literal for the '{@link org.sidiff.revision.changes.impl.ChangeSetImpl <em>Change Set</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.revision.changes.impl.ChangeSetImpl
		 * @see org.sidiff.revision.changes.impl.ChangesPackageImpl#getChangeSet()
		 * @generated
		 */
		EClass CHANGE_SET = eINSTANCE.getChangeSet();

		/**
		 * The meta object literal for the '<em><b>Get Changes</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CHANGE_SET___GET_CHANGES = eINSTANCE.getChangeSet__GetChanges();

		/**
		 * The meta object literal for the '{@link org.sidiff.revision.changes.NodeChangeContext <em>Node Change Context</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.revision.changes.NodeChangeContext
		 * @see org.sidiff.revision.changes.impl.ChangesPackageImpl#getNodeChangeContext()
		 * @generated
		 */
		EClass NODE_CHANGE_CONTEXT = eINSTANCE.getNodeChangeContext();

		/**
		 * The meta object literal for the '<em><b>Nodes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE_CHANGE_CONTEXT__NODES = eINSTANCE.getNodeChangeContext_Nodes();

		/**
		 * The meta object literal for the '<em><b>Get Node</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation NODE_CHANGE_CONTEXT___GET_NODE__NODECHANGE = eINSTANCE.getNodeChangeContext__GetNode__NodeChange();

		/**
		 * The meta object literal for the '<em><b>Get Node Domains</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation NODE_CHANGE_CONTEXT___GET_NODE_DOMAINS__NODECHANGE = eINSTANCE
				.getNodeChangeContext__GetNodeDomains__NodeChange();

		/**
		 * The meta object literal for the '<em><b>Get Type</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation NODE_CHANGE_CONTEXT___GET_TYPE__NODECHANGE = eINSTANCE.getNodeChangeContext__GetType__NodeChange();

		/**
		 * The meta object literal for the '{@link org.sidiff.revision.changes.AttributeChangeContext <em>Attribute Change Context</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.revision.changes.AttributeChangeContext
		 * @see org.sidiff.revision.changes.impl.ChangesPackageImpl#getAttributeChangeContext()
		 * @generated
		 */
		EClass ATTRIBUTE_CHANGE_CONTEXT = eINSTANCE.getAttributeChangeContext();

		/**
		 * The meta object literal for the '<em><b>Attributes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ATTRIBUTE_CHANGE_CONTEXT__ATTRIBUTES = eINSTANCE.getAttributeChangeContext_Attributes();

		/**
		 * The meta object literal for the '<em><b>Get Type</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ATTRIBUTE_CHANGE_CONTEXT___GET_TYPE__ATTRIBUTECHANGE = eINSTANCE
				.getAttributeChangeContext__GetType__AttributeChange();

		/**
		 * The meta object literal for the '<em><b>Get Node</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ATTRIBUTE_CHANGE_CONTEXT___GET_NODE__ATTRIBUTECHANGE = eINSTANCE
				.getAttributeChangeContext__GetNode__AttributeChange();

		/**
		 * The meta object literal for the '<em><b>Get Node Type</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ATTRIBUTE_CHANGE_CONTEXT___GET_NODE_TYPE__ATTRIBUTECHANGE = eINSTANCE
				.getAttributeChangeContext__GetNodeType__AttributeChange();

		/**
		 * The meta object literal for the '<em><b>Get Node Domain</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ATTRIBUTE_CHANGE_CONTEXT___GET_NODE_DOMAIN__ATTRIBUTECHANGE = eINSTANCE
				.getAttributeChangeContext__GetNodeDomain__AttributeChange();

		/**
		 * The meta object literal for the '<em><b>Get Value Type</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ATTRIBUTE_CHANGE_CONTEXT___GET_VALUE_TYPE__ATTRIBUTECHANGE = eINSTANCE
				.getAttributeChangeContext__GetValueType__AttributeChange();

		/**
		 * The meta object literal for the '<em><b>Get Value Domain</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ATTRIBUTE_CHANGE_CONTEXT___GET_VALUE_DOMAIN__ATTRIBUTECHANGE = eINSTANCE
				.getAttributeChangeContext__GetValueDomain__AttributeChange();

		/**
		 * The meta object literal for the '<em><b>Get Value</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ATTRIBUTE_CHANGE_CONTEXT___GET_VALUE__ATTRIBUTECHANGE = eINSTANCE
				.getAttributeChangeContext__GetValue__AttributeChange();

		/**
		 * The meta object literal for the '{@link org.sidiff.revision.changes.EdgeChangeContext <em>Edge Change Context</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.revision.changes.EdgeChangeContext
		 * @see org.sidiff.revision.changes.impl.ChangesPackageImpl#getEdgeChangeContext()
		 * @generated
		 */
		EClass EDGE_CHANGE_CONTEXT = eINSTANCE.getEdgeChangeContext();

		/**
		 * The meta object literal for the '<em><b>Edges</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EDGE_CHANGE_CONTEXT__EDGES = eINSTANCE.getEdgeChangeContext_Edges();

		/**
		 * The meta object literal for the '<em><b>Get Target Type</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation EDGE_CHANGE_CONTEXT___GET_TARGET_TYPE__EDGECHANGE = eINSTANCE
				.getEdgeChangeContext__GetTargetType__EdgeChange();

		/**
		 * The meta object literal for the '<em><b>Get Type</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation EDGE_CHANGE_CONTEXT___GET_TYPE__EDGECHANGE = eINSTANCE.getEdgeChangeContext__GetType__EdgeChange();

		/**
		 * The meta object literal for the '<em><b>Get Source Type</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation EDGE_CHANGE_CONTEXT___GET_SOURCE_TYPE__EDGECHANGE = eINSTANCE
				.getEdgeChangeContext__GetSourceType__EdgeChange();

		/**
		 * The meta object literal for the '<em><b>Get Source</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation EDGE_CHANGE_CONTEXT___GET_SOURCE__EDGECHANGE = eINSTANCE
				.getEdgeChangeContext__GetSource__EdgeChange();

		/**
		 * The meta object literal for the '<em><b>Get Source Domain</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation EDGE_CHANGE_CONTEXT___GET_SOURCE_DOMAIN__EDGECHANGE = eINSTANCE
				.getEdgeChangeContext__GetSourceDomain__EdgeChange();

		/**
		 * The meta object literal for the '<em><b>Get Target</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation EDGE_CHANGE_CONTEXT___GET_TARGET__EDGECHANGE = eINSTANCE
				.getEdgeChangeContext__GetTarget__EdgeChange();

		/**
		 * The meta object literal for the '<em><b>Get Target Domain</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation EDGE_CHANGE_CONTEXT___GET_TARGET_DOMAIN__EDGECHANGE = eINSTANCE
				.getEdgeChangeContext__GetTargetDomain__EdgeChange();

		/**
		 * The meta object literal for the '{@link org.sidiff.revision.changes.impl.ChangeImpl <em>Change</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.revision.changes.impl.ChangeImpl
		 * @see org.sidiff.revision.changes.impl.ChangesPackageImpl#getChange()
		 * @generated
		 */
		EClass CHANGE = eINSTANCE.getChange();

		/**
		 * The meta object literal for the '<em><b>Get Action</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CHANGE___GET_ACTION = eINSTANCE.getChange__GetAction();

		/**
		 * The meta object literal for the '{@link org.sidiff.revision.changes.impl.NodeChangeImpl <em>Node Change</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.revision.changes.impl.NodeChangeImpl
		 * @see org.sidiff.revision.changes.impl.ChangesPackageImpl#getNodeChange()
		 * @generated
		 */
		EClass NODE_CHANGE = eINSTANCE.getNodeChange();

		/**
		 * The meta object literal for the '<em><b>Context</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE_CHANGE__CONTEXT = eINSTANCE.getNodeChange_Context();

		/**
		 * The meta object literal for the '<em><b>Get Type</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation NODE_CHANGE___GET_TYPE = eINSTANCE.getNodeChange__GetType();

		/**
		 * The meta object literal for the '<em><b>Get Node Domains</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation NODE_CHANGE___GET_NODE_DOMAINS = eINSTANCE.getNodeChange__GetNodeDomains();

		/**
		 * The meta object literal for the '<em><b>Get Node</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation NODE_CHANGE___GET_NODE = eINSTANCE.getNodeChange__GetNode();

		/**
		 * The meta object literal for the '{@link org.sidiff.revision.changes.impl.AttributeChangeImpl <em>Attribute Change</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.revision.changes.impl.AttributeChangeImpl
		 * @see org.sidiff.revision.changes.impl.ChangesPackageImpl#getAttributeChange()
		 * @generated
		 */
		EClass ATTRIBUTE_CHANGE = eINSTANCE.getAttributeChange();

		/**
		 * The meta object literal for the '<em><b>Context</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ATTRIBUTE_CHANGE__CONTEXT = eINSTANCE.getAttributeChange_Context();

		/**
		 * The meta object literal for the '<em><b>Get Type</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ATTRIBUTE_CHANGE___GET_TYPE = eINSTANCE.getAttributeChange__GetType();

		/**
		 * The meta object literal for the '<em><b>Get Node Type</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ATTRIBUTE_CHANGE___GET_NODE_TYPE = eINSTANCE.getAttributeChange__GetNodeType();

		/**
		 * The meta object literal for the '<em><b>Get Node Domain</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ATTRIBUTE_CHANGE___GET_NODE_DOMAIN = eINSTANCE.getAttributeChange__GetNodeDomain();

		/**
		 * The meta object literal for the '<em><b>Get Node</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ATTRIBUTE_CHANGE___GET_NODE = eINSTANCE.getAttributeChange__GetNode();

		/**
		 * The meta object literal for the '<em><b>Get Value Type</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ATTRIBUTE_CHANGE___GET_VALUE_TYPE = eINSTANCE.getAttributeChange__GetValueType();

		/**
		 * The meta object literal for the '<em><b>Get Value Domain</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ATTRIBUTE_CHANGE___GET_VALUE_DOMAIN = eINSTANCE.getAttributeChange__GetValueDomain();

		/**
		 * The meta object literal for the '<em><b>Get Value</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ATTRIBUTE_CHANGE___GET_VALUE = eINSTANCE.getAttributeChange__GetValue();

		/**
		 * The meta object literal for the '{@link org.sidiff.revision.changes.impl.EdgeChangeImpl <em>Edge Change</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.revision.changes.impl.EdgeChangeImpl
		 * @see org.sidiff.revision.changes.impl.ChangesPackageImpl#getEdgeChange()
		 * @generated
		 */
		EClass EDGE_CHANGE = eINSTANCE.getEdgeChange();

		/**
		 * The meta object literal for the '<em><b>Context</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EDGE_CHANGE__CONTEXT = eINSTANCE.getEdgeChange_Context();

		/**
		 * The meta object literal for the '<em><b>Get Type</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation EDGE_CHANGE___GET_TYPE = eINSTANCE.getEdgeChange__GetType();

		/**
		 * The meta object literal for the '<em><b>Ge Source Type</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation EDGE_CHANGE___GE_SOURCE_TYPE = eINSTANCE.getEdgeChange__GeSourceType();

		/**
		 * The meta object literal for the '<em><b>Get Source Domain</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation EDGE_CHANGE___GET_SOURCE_DOMAIN = eINSTANCE.getEdgeChange__GetSourceDomain();

		/**
		 * The meta object literal for the '<em><b>Get Source</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation EDGE_CHANGE___GET_SOURCE = eINSTANCE.getEdgeChange__GetSource();

		/**
		 * The meta object literal for the '<em><b>Get Target Type</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation EDGE_CHANGE___GET_TARGET_TYPE = eINSTANCE.getEdgeChange__GetTargetType();

		/**
		 * The meta object literal for the '<em><b>Get Target Domain</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation EDGE_CHANGE___GET_TARGET_DOMAIN = eINSTANCE.getEdgeChange__GetTargetDomain();

		/**
		 * The meta object literal for the '<em><b>Get Target</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation EDGE_CHANGE___GET_TARGET = eINSTANCE.getEdgeChange__GetTarget();

		/**
		 * The meta object literal for the '{@link org.sidiff.revision.changes.ChangeContext <em>Change Context</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.revision.changes.ChangeContext
		 * @see org.sidiff.revision.changes.impl.ChangesPackageImpl#getChangeContext()
		 * @generated
		 */
		EClass CHANGE_CONTEXT = eINSTANCE.getChangeContext();

		/**
		 * The meta object literal for the '<em><b>Get Action</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CHANGE_CONTEXT___GET_ACTION__CHANGE = eINSTANCE.getChangeContext__GetAction__Change();

		/**
		 * The meta object literal for the '{@link org.sidiff.revision.changes.ActionType <em>Action Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.revision.changes.ActionType
		 * @see org.sidiff.revision.changes.impl.ChangesPackageImpl#getActionType()
		 * @generated
		 */
		EEnum ACTION_TYPE = eINSTANCE.getActionType();

		/**
		 * The meta object literal for the '<em>Change Iterator</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.util.Iterator
		 * @see org.sidiff.revision.changes.impl.ChangesPackageImpl#getChangeIterator()
		 * @generated
		 */
		EDataType CHANGE_ITERATOR = eINSTANCE.getChangeIterator();

	}

} //ChangesPackage
