/**
 */
package org.sidiff.revision.changes;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;

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
	 * The meta object id for the '{@link org.sidiff.revision.changes.Change <em>Change</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.revision.changes.Change
	 * @see org.sidiff.revision.changes.impl.ChangesPackageImpl#getChange()
	 * @generated
	 */
	int CHANGE = 0;

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
	 * The meta object id for the '{@link org.sidiff.revision.changes.NodeChange <em>Node Change</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.revision.changes.NodeChange
	 * @see org.sidiff.revision.changes.impl.ChangesPackageImpl#getNodeChange()
	 * @generated
	 */
	int NODE_CHANGE = 1;

	/**
	 * The number of structural features of the '<em>Node Change</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_CHANGE_FEATURE_COUNT = CHANGE_FEATURE_COUNT + 0;

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
	 * The number of operations of the '<em>Node Change</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_CHANGE_OPERATION_COUNT = CHANGE_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.sidiff.revision.changes.ChangeInstantiation <em>Change Instantiation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.revision.changes.ChangeInstantiation
	 * @see org.sidiff.revision.changes.impl.ChangesPackageImpl#getChangeInstantiation()
	 * @generated
	 */
	int CHANGE_INSTANTIATION = 11;

	/**
	 * The number of structural features of the '<em>Change Instantiation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANGE_INSTANTIATION_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Change Instantiation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANGE_INSTANTIATION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.sidiff.revision.changes.NodeInstantiation <em>Node Instantiation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.revision.changes.NodeInstantiation
	 * @see org.sidiff.revision.changes.impl.ChangesPackageImpl#getNodeInstantiation()
	 * @generated
	 */
	int NODE_INSTANTIATION = 12;

	/**
	 * The number of structural features of the '<em>Node Instantiation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_INSTANTIATION_FEATURE_COUNT = CHANGE_INSTANTIATION_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Node Instantiation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_INSTANTIATION_OPERATION_COUNT = CHANGE_INSTANTIATION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sidiff.revision.changes.NodeDomain <em>Node Domain</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.revision.changes.NodeDomain
	 * @see org.sidiff.revision.changes.impl.ChangesPackageImpl#getNodeDomain()
	 * @generated
	 */
	int NODE_DOMAIN = 2;

	/**
	 * The number of structural features of the '<em>Node Domain</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_DOMAIN_FEATURE_COUNT = NODE_INSTANTIATION_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Node Domain</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_DOMAIN_OPERATION_COUNT = NODE_INSTANTIATION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sidiff.revision.changes.NodeBinding <em>Node Binding</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.revision.changes.NodeBinding
	 * @see org.sidiff.revision.changes.impl.ChangesPackageImpl#getNodeBinding()
	 * @generated
	 */
	int NODE_BINDING = 3;

	/**
	 * The number of structural features of the '<em>Node Binding</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_BINDING_FEATURE_COUNT = NODE_INSTANTIATION_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Node</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_BINDING___GET_NODE = NODE_INSTANTIATION_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Node Binding</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_BINDING_OPERATION_COUNT = NODE_INSTANTIATION_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.sidiff.revision.changes.AttributeInstantiation <em>Attribute Instantiation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.revision.changes.AttributeInstantiation
	 * @see org.sidiff.revision.changes.impl.ChangesPackageImpl#getAttributeInstantiation()
	 * @generated
	 */
	int ATTRIBUTE_INSTANTIATION = 10;

	/**
	 * The number of structural features of the '<em>Attribute Instantiation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_INSTANTIATION_FEATURE_COUNT = CHANGE_INSTANTIATION_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Attribute Instantiation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_INSTANTIATION_OPERATION_COUNT = CHANGE_INSTANTIATION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sidiff.revision.changes.AttributeDomain <em>Attribute Domain</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.revision.changes.AttributeDomain
	 * @see org.sidiff.revision.changes.impl.ChangesPackageImpl#getAttributeDomain()
	 * @generated
	 */
	int ATTRIBUTE_DOMAIN = 4;

	/**
	 * The number of structural features of the '<em>Attribute Domain</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_DOMAIN_FEATURE_COUNT = ATTRIBUTE_INSTANTIATION_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Attribute Domain</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_DOMAIN_OPERATION_COUNT = ATTRIBUTE_INSTANTIATION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sidiff.revision.changes.AttributeChange <em>Attribute Change</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.revision.changes.AttributeChange
	 * @see org.sidiff.revision.changes.impl.ChangesPackageImpl#getAttributeChange()
	 * @generated
	 */
	int ATTRIBUTE_CHANGE = 5;

	/**
	 * The number of structural features of the '<em>Attribute Change</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_CHANGE_FEATURE_COUNT = CHANGE_FEATURE_COUNT + 0;

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
	 * The operation id for the '<em>Get Value Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_CHANGE___GET_VALUE_TYPE = CHANGE_OPERATION_COUNT + 2;

	/**
	 * The number of operations of the '<em>Attribute Change</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_CHANGE_OPERATION_COUNT = CHANGE_OPERATION_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.sidiff.revision.changes.AttributeBinding <em>Attribute Binding</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.revision.changes.AttributeBinding
	 * @see org.sidiff.revision.changes.impl.ChangesPackageImpl#getAttributeBinding()
	 * @generated
	 */
	int ATTRIBUTE_BINDING = 6;

	/**
	 * The number of structural features of the '<em>Attribute Binding</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_BINDING_FEATURE_COUNT = ATTRIBUTE_INSTANTIATION_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Attribute Binding</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_BINDING_OPERATION_COUNT = ATTRIBUTE_INSTANTIATION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sidiff.revision.changes.EdgeChange <em>Edge Change</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.revision.changes.EdgeChange
	 * @see org.sidiff.revision.changes.impl.ChangesPackageImpl#getEdgeChange()
	 * @generated
	 */
	int EDGE_CHANGE = 7;

	/**
	 * The number of structural features of the '<em>Edge Change</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_CHANGE_FEATURE_COUNT = CHANGE_FEATURE_COUNT + 0;

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
	 * The operation id for the '<em>Get Target Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_CHANGE___GET_TARGET_TYPE = CHANGE_OPERATION_COUNT + 2;

	/**
	 * The number of operations of the '<em>Edge Change</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_CHANGE_OPERATION_COUNT = CHANGE_OPERATION_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.sidiff.revision.changes.EdgeInstantiation <em>Edge Instantiation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.revision.changes.EdgeInstantiation
	 * @see org.sidiff.revision.changes.impl.ChangesPackageImpl#getEdgeInstantiation()
	 * @generated
	 */
	int EDGE_INSTANTIATION = 13;

	/**
	 * The number of structural features of the '<em>Edge Instantiation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_INSTANTIATION_FEATURE_COUNT = CHANGE_INSTANTIATION_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Edge Instantiation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_INSTANTIATION_OPERATION_COUNT = CHANGE_INSTANTIATION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sidiff.revision.changes.EdgeDomain <em>Edge Domain</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.revision.changes.EdgeDomain
	 * @see org.sidiff.revision.changes.impl.ChangesPackageImpl#getEdgeDomain()
	 * @generated
	 */
	int EDGE_DOMAIN = 8;

	/**
	 * The number of structural features of the '<em>Edge Domain</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_DOMAIN_FEATURE_COUNT = EDGE_INSTANTIATION_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Edge Domain</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_DOMAIN_OPERATION_COUNT = EDGE_INSTANTIATION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sidiff.revision.changes.EdgeBinding <em>Edge Binding</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.revision.changes.EdgeBinding
	 * @see org.sidiff.revision.changes.impl.ChangesPackageImpl#getEdgeBinding()
	 * @generated
	 */
	int EDGE_BINDING = 9;

	/**
	 * The number of structural features of the '<em>Edge Binding</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_BINDING_FEATURE_COUNT = EDGE_INSTANTIATION_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Edge Binding</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_BINDING_OPERATION_COUNT = EDGE_INSTANTIATION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sidiff.revision.changes.AttributeNodeDomainDefinition <em>Attribute Node Domain Definition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.revision.changes.AttributeNodeDomainDefinition
	 * @see org.sidiff.revision.changes.impl.ChangesPackageImpl#getAttributeNodeDomainDefinition()
	 * @generated
	 */
	int ATTRIBUTE_NODE_DOMAIN_DEFINITION = 14;

	/**
	 * The number of structural features of the '<em>Attribute Node Domain Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_NODE_DOMAIN_DEFINITION_FEATURE_COUNT = ATTRIBUTE_DOMAIN_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Node Domain Contains</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_NODE_DOMAIN_DEFINITION___NODE_DOMAIN_CONTAINS__EOBJECT = ATTRIBUTE_DOMAIN_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Attribute Node Domain Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_NODE_DOMAIN_DEFINITION_OPERATION_COUNT = ATTRIBUTE_DOMAIN_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.sidiff.revision.changes.AttributeValueDomainDefinition <em>Attribute Value Domain Definition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.revision.changes.AttributeValueDomainDefinition
	 * @see org.sidiff.revision.changes.impl.ChangesPackageImpl#getAttributeValueDomainDefinition()
	 * @generated
	 */
	int ATTRIBUTE_VALUE_DOMAIN_DEFINITION = 15;

	/**
	 * The number of structural features of the '<em>Attribute Value Domain Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_VALUE_DOMAIN_DEFINITION_FEATURE_COUNT = ATTRIBUTE_DOMAIN_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Value Domain Contains</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_VALUE_DOMAIN_DEFINITION___VALUE_DOMAIN_CONTAINS__OBJECT = ATTRIBUTE_DOMAIN_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Attribute Value Domain Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_VALUE_DOMAIN_DEFINITION_OPERATION_COUNT = ATTRIBUTE_DOMAIN_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.sidiff.revision.changes.AttributeNodeDomain <em>Attribute Node Domain</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.revision.changes.AttributeNodeDomain
	 * @see org.sidiff.revision.changes.impl.ChangesPackageImpl#getAttributeNodeDomain()
	 * @generated
	 */
	int ATTRIBUTE_NODE_DOMAIN = 16;

	/**
	 * The number of structural features of the '<em>Attribute Node Domain</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_NODE_DOMAIN_FEATURE_COUNT = ATTRIBUTE_NODE_DOMAIN_DEFINITION_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Node Domain Contains</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_NODE_DOMAIN___NODE_DOMAIN_CONTAINS__EOBJECT = ATTRIBUTE_NODE_DOMAIN_DEFINITION___NODE_DOMAIN_CONTAINS__EOBJECT;

	/**
	 * The operation id for the '<em>Get Node Domain</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_NODE_DOMAIN___GET_NODE_DOMAIN = ATTRIBUTE_NODE_DOMAIN_DEFINITION_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Attribute Node Domain</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_NODE_DOMAIN_OPERATION_COUNT = ATTRIBUTE_NODE_DOMAIN_DEFINITION_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.sidiff.revision.changes.AttributeValueDomain <em>Attribute Value Domain</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.revision.changes.AttributeValueDomain
	 * @see org.sidiff.revision.changes.impl.ChangesPackageImpl#getAttributeValueDomain()
	 * @generated
	 */
	int ATTRIBUTE_VALUE_DOMAIN = 17;

	/**
	 * The number of structural features of the '<em>Attribute Value Domain</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_VALUE_DOMAIN_FEATURE_COUNT = ATTRIBUTE_VALUE_DOMAIN_DEFINITION_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Value Domain Contains</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_VALUE_DOMAIN___VALUE_DOMAIN_CONTAINS__OBJECT = ATTRIBUTE_VALUE_DOMAIN_DEFINITION___VALUE_DOMAIN_CONTAINS__OBJECT;

	/**
	 * The operation id for the '<em>Get Value Domain</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_VALUE_DOMAIN___GET_VALUE_DOMAIN = ATTRIBUTE_VALUE_DOMAIN_DEFINITION_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Attribute Value Domain</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_VALUE_DOMAIN_OPERATION_COUNT = ATTRIBUTE_VALUE_DOMAIN_DEFINITION_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.sidiff.revision.changes.AttributeNodeBinding <em>Attribute Node Binding</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.revision.changes.AttributeNodeBinding
	 * @see org.sidiff.revision.changes.impl.ChangesPackageImpl#getAttributeNodeBinding()
	 * @generated
	 */
	int ATTRIBUTE_NODE_BINDING = 18;

	/**
	 * The number of structural features of the '<em>Attribute Node Binding</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_NODE_BINDING_FEATURE_COUNT = ATTRIBUTE_BINDING_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Node</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_NODE_BINDING___GET_NODE = ATTRIBUTE_BINDING_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Attribute Node Binding</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_NODE_BINDING_OPERATION_COUNT = ATTRIBUTE_BINDING_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.sidiff.revision.changes.AttributeValueBinding <em>Attribute Value Binding</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.revision.changes.AttributeValueBinding
	 * @see org.sidiff.revision.changes.impl.ChangesPackageImpl#getAttributeValueBinding()
	 * @generated
	 */
	int ATTRIBUTE_VALUE_BINDING = 19;

	/**
	 * The number of structural features of the '<em>Attribute Value Binding</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_VALUE_BINDING_FEATURE_COUNT = ATTRIBUTE_BINDING_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_VALUE_BINDING___GET_VALUE = ATTRIBUTE_BINDING_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Attribute Value Binding</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_VALUE_BINDING_OPERATION_COUNT = ATTRIBUTE_BINDING_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.sidiff.revision.changes.EdgeSourceDomainDefinition <em>Edge Source Domain Definition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.revision.changes.EdgeSourceDomainDefinition
	 * @see org.sidiff.revision.changes.impl.ChangesPackageImpl#getEdgeSourceDomainDefinition()
	 * @generated
	 */
	int EDGE_SOURCE_DOMAIN_DEFINITION = 20;

	/**
	 * The number of structural features of the '<em>Edge Source Domain Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_SOURCE_DOMAIN_DEFINITION_FEATURE_COUNT = EDGE_DOMAIN_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Source Domain Contains</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_SOURCE_DOMAIN_DEFINITION___SOURCE_DOMAIN_CONTAINS__EOBJECT = EDGE_DOMAIN_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Edge Source Domain Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_SOURCE_DOMAIN_DEFINITION_OPERATION_COUNT = EDGE_DOMAIN_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.sidiff.revision.changes.EdgeTargetDomainDefinition <em>Edge Target Domain Definition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.revision.changes.EdgeTargetDomainDefinition
	 * @see org.sidiff.revision.changes.impl.ChangesPackageImpl#getEdgeTargetDomainDefinition()
	 * @generated
	 */
	int EDGE_TARGET_DOMAIN_DEFINITION = 21;

	/**
	 * The number of structural features of the '<em>Edge Target Domain Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_TARGET_DOMAIN_DEFINITION_FEATURE_COUNT = EDGE_DOMAIN_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Target Domain Contains</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_TARGET_DOMAIN_DEFINITION___TARGET_DOMAIN_CONTAINS__EOBJECT = EDGE_DOMAIN_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Edge Target Domain Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_TARGET_DOMAIN_DEFINITION_OPERATION_COUNT = EDGE_DOMAIN_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.sidiff.revision.changes.EdgeSourceDomain <em>Edge Source Domain</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.revision.changes.EdgeSourceDomain
	 * @see org.sidiff.revision.changes.impl.ChangesPackageImpl#getEdgeSourceDomain()
	 * @generated
	 */
	int EDGE_SOURCE_DOMAIN = 22;

	/**
	 * The number of structural features of the '<em>Edge Source Domain</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_SOURCE_DOMAIN_FEATURE_COUNT = EDGE_SOURCE_DOMAIN_DEFINITION_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Source Domain Contains</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_SOURCE_DOMAIN___SOURCE_DOMAIN_CONTAINS__EOBJECT = EDGE_SOURCE_DOMAIN_DEFINITION___SOURCE_DOMAIN_CONTAINS__EOBJECT;

	/**
	 * The operation id for the '<em>Get Source Domain</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_SOURCE_DOMAIN___GET_SOURCE_DOMAIN = EDGE_SOURCE_DOMAIN_DEFINITION_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Edge Source Domain</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_SOURCE_DOMAIN_OPERATION_COUNT = EDGE_SOURCE_DOMAIN_DEFINITION_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.sidiff.revision.changes.EdgeTargetDomain <em>Edge Target Domain</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.revision.changes.EdgeTargetDomain
	 * @see org.sidiff.revision.changes.impl.ChangesPackageImpl#getEdgeTargetDomain()
	 * @generated
	 */
	int EDGE_TARGET_DOMAIN = 23;

	/**
	 * The number of structural features of the '<em>Edge Target Domain</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_TARGET_DOMAIN_FEATURE_COUNT = EDGE_TARGET_DOMAIN_DEFINITION_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Target Domain Contains</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_TARGET_DOMAIN___TARGET_DOMAIN_CONTAINS__EOBJECT = EDGE_TARGET_DOMAIN_DEFINITION___TARGET_DOMAIN_CONTAINS__EOBJECT;

	/**
	 * The operation id for the '<em>Get Target Domain</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_TARGET_DOMAIN___GET_TARGET_DOMAIN = EDGE_TARGET_DOMAIN_DEFINITION_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Edge Target Domain</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_TARGET_DOMAIN_OPERATION_COUNT = EDGE_TARGET_DOMAIN_DEFINITION_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.sidiff.revision.changes.EdgeSourceBinding <em>Edge Source Binding</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.revision.changes.EdgeSourceBinding
	 * @see org.sidiff.revision.changes.impl.ChangesPackageImpl#getEdgeSourceBinding()
	 * @generated
	 */
	int EDGE_SOURCE_BINDING = 24;

	/**
	 * The number of structural features of the '<em>Edge Source Binding</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_SOURCE_BINDING_FEATURE_COUNT = EDGE_BINDING_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Source</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_SOURCE_BINDING___GET_SOURCE = EDGE_BINDING_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Edge Source Binding</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_SOURCE_BINDING_OPERATION_COUNT = EDGE_BINDING_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.sidiff.revision.changes.EdgeTargetBinding <em>Edge Target Binding</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.revision.changes.EdgeTargetBinding
	 * @see org.sidiff.revision.changes.impl.ChangesPackageImpl#getEdgeTargetBinding()
	 * @generated
	 */
	int EDGE_TARGET_BINDING = 25;

	/**
	 * The number of structural features of the '<em>Edge Target Binding</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_TARGET_BINDING_FEATURE_COUNT = EDGE_BINDING_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Target</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_TARGET_BINDING___GET_TARGET = EDGE_BINDING_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Edge Target Binding</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_TARGET_BINDING_OPERATION_COUNT = EDGE_BINDING_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.sidiff.revision.changes.NodeChangeDomainDefinition <em>Node Change Domain Definition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.revision.changes.NodeChangeDomainDefinition
	 * @see org.sidiff.revision.changes.impl.ChangesPackageImpl#getNodeChangeDomainDefinition()
	 * @generated
	 */
	int NODE_CHANGE_DOMAIN_DEFINITION = 26;

	/**
	 * The number of structural features of the '<em>Node Change Domain Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_CHANGE_DOMAIN_DEFINITION_FEATURE_COUNT = NODE_DOMAIN_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Node Domain Contains</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_CHANGE_DOMAIN_DEFINITION___NODE_DOMAIN_CONTAINS__EOBJECT = NODE_DOMAIN_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Node Change Domain Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_CHANGE_DOMAIN_DEFINITION_OPERATION_COUNT = NODE_DOMAIN_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.sidiff.revision.changes.NodeChangeDomain <em>Node Change Domain</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.revision.changes.NodeChangeDomain
	 * @see org.sidiff.revision.changes.impl.ChangesPackageImpl#getNodeChangeDomain()
	 * @generated
	 */
	int NODE_CHANGE_DOMAIN = 27;

	/**
	 * The number of structural features of the '<em>Node Change Domain</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_CHANGE_DOMAIN_FEATURE_COUNT = NODE_CHANGE_DOMAIN_DEFINITION_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Node Domain Contains</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_CHANGE_DOMAIN___NODE_DOMAIN_CONTAINS__EOBJECT = NODE_CHANGE_DOMAIN_DEFINITION___NODE_DOMAIN_CONTAINS__EOBJECT;

	/**
	 * The operation id for the '<em>Get Node Domains</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_CHANGE_DOMAIN___GET_NODE_DOMAINS = NODE_CHANGE_DOMAIN_DEFINITION_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Node Change Domain</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_CHANGE_DOMAIN_OPERATION_COUNT = NODE_CHANGE_DOMAIN_DEFINITION_OPERATION_COUNT + 1;

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
	 * Returns the meta object for the '{@link org.sidiff.revision.changes.NodeChange#getType() <em>Get Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Type</em>' operation.
	 * @see org.sidiff.revision.changes.NodeChange#getType()
	 * @generated
	 */
	EOperation getNodeChange__GetType();

	/**
	 * Returns the meta object for class '{@link org.sidiff.revision.changes.NodeDomain <em>Node Domain</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Node Domain</em>'.
	 * @see org.sidiff.revision.changes.NodeDomain
	 * @generated
	 */
	EClass getNodeDomain();

	/**
	 * Returns the meta object for class '{@link org.sidiff.revision.changes.NodeBinding <em>Node Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Node Binding</em>'.
	 * @see org.sidiff.revision.changes.NodeBinding
	 * @generated
	 */
	EClass getNodeBinding();

	/**
	 * Returns the meta object for the '{@link org.sidiff.revision.changes.NodeBinding#getNode() <em>Get Node</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Node</em>' operation.
	 * @see org.sidiff.revision.changes.NodeBinding#getNode()
	 * @generated
	 */
	EOperation getNodeBinding__GetNode();

	/**
	 * Returns the meta object for class '{@link org.sidiff.revision.changes.AttributeDomain <em>Attribute Domain</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Attribute Domain</em>'.
	 * @see org.sidiff.revision.changes.AttributeDomain
	 * @generated
	 */
	EClass getAttributeDomain();

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
	 * Returns the meta object for the '{@link org.sidiff.revision.changes.AttributeChange#getValueType() <em>Get Value Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Value Type</em>' operation.
	 * @see org.sidiff.revision.changes.AttributeChange#getValueType()
	 * @generated
	 */
	EOperation getAttributeChange__GetValueType();

	/**
	 * Returns the meta object for class '{@link org.sidiff.revision.changes.AttributeBinding <em>Attribute Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Attribute Binding</em>'.
	 * @see org.sidiff.revision.changes.AttributeBinding
	 * @generated
	 */
	EClass getAttributeBinding();

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
	 * Returns the meta object for the '{@link org.sidiff.revision.changes.EdgeChange#getTargetType() <em>Get Target Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Target Type</em>' operation.
	 * @see org.sidiff.revision.changes.EdgeChange#getTargetType()
	 * @generated
	 */
	EOperation getEdgeChange__GetTargetType();

	/**
	 * Returns the meta object for class '{@link org.sidiff.revision.changes.EdgeDomain <em>Edge Domain</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Edge Domain</em>'.
	 * @see org.sidiff.revision.changes.EdgeDomain
	 * @generated
	 */
	EClass getEdgeDomain();

	/**
	 * Returns the meta object for class '{@link org.sidiff.revision.changes.EdgeBinding <em>Edge Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Edge Binding</em>'.
	 * @see org.sidiff.revision.changes.EdgeBinding
	 * @generated
	 */
	EClass getEdgeBinding();

	/**
	 * Returns the meta object for class '{@link org.sidiff.revision.changes.AttributeInstantiation <em>Attribute Instantiation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Attribute Instantiation</em>'.
	 * @see org.sidiff.revision.changes.AttributeInstantiation
	 * @generated
	 */
	EClass getAttributeInstantiation();

	/**
	 * Returns the meta object for class '{@link org.sidiff.revision.changes.ChangeInstantiation <em>Change Instantiation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Change Instantiation</em>'.
	 * @see org.sidiff.revision.changes.ChangeInstantiation
	 * @generated
	 */
	EClass getChangeInstantiation();

	/**
	 * Returns the meta object for class '{@link org.sidiff.revision.changes.NodeInstantiation <em>Node Instantiation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Node Instantiation</em>'.
	 * @see org.sidiff.revision.changes.NodeInstantiation
	 * @generated
	 */
	EClass getNodeInstantiation();

	/**
	 * Returns the meta object for class '{@link org.sidiff.revision.changes.EdgeInstantiation <em>Edge Instantiation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Edge Instantiation</em>'.
	 * @see org.sidiff.revision.changes.EdgeInstantiation
	 * @generated
	 */
	EClass getEdgeInstantiation();

	/**
	 * Returns the meta object for class '{@link org.sidiff.revision.changes.AttributeNodeDomainDefinition <em>Attribute Node Domain Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Attribute Node Domain Definition</em>'.
	 * @see org.sidiff.revision.changes.AttributeNodeDomainDefinition
	 * @generated
	 */
	EClass getAttributeNodeDomainDefinition();

	/**
	 * Returns the meta object for the '{@link org.sidiff.revision.changes.AttributeNodeDomainDefinition#nodeDomainContains(org.eclipse.emf.ecore.EObject) <em>Node Domain Contains</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Node Domain Contains</em>' operation.
	 * @see org.sidiff.revision.changes.AttributeNodeDomainDefinition#nodeDomainContains(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	EOperation getAttributeNodeDomainDefinition__NodeDomainContains__EObject();

	/**
	 * Returns the meta object for class '{@link org.sidiff.revision.changes.AttributeValueDomainDefinition <em>Attribute Value Domain Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Attribute Value Domain Definition</em>'.
	 * @see org.sidiff.revision.changes.AttributeValueDomainDefinition
	 * @generated
	 */
	EClass getAttributeValueDomainDefinition();

	/**
	 * Returns the meta object for the '{@link org.sidiff.revision.changes.AttributeValueDomainDefinition#valueDomainContains(java.lang.Object) <em>Value Domain Contains</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Value Domain Contains</em>' operation.
	 * @see org.sidiff.revision.changes.AttributeValueDomainDefinition#valueDomainContains(java.lang.Object)
	 * @generated
	 */
	EOperation getAttributeValueDomainDefinition__ValueDomainContains__Object();

	/**
	 * Returns the meta object for class '{@link org.sidiff.revision.changes.AttributeNodeDomain <em>Attribute Node Domain</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Attribute Node Domain</em>'.
	 * @see org.sidiff.revision.changes.AttributeNodeDomain
	 * @generated
	 */
	EClass getAttributeNodeDomain();

	/**
	 * Returns the meta object for the '{@link org.sidiff.revision.changes.AttributeNodeDomain#getNodeDomain() <em>Get Node Domain</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Node Domain</em>' operation.
	 * @see org.sidiff.revision.changes.AttributeNodeDomain#getNodeDomain()
	 * @generated
	 */
	EOperation getAttributeNodeDomain__GetNodeDomain();

	/**
	 * Returns the meta object for class '{@link org.sidiff.revision.changes.AttributeValueDomain <em>Attribute Value Domain</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Attribute Value Domain</em>'.
	 * @see org.sidiff.revision.changes.AttributeValueDomain
	 * @generated
	 */
	EClass getAttributeValueDomain();

	/**
	 * Returns the meta object for the '{@link org.sidiff.revision.changes.AttributeValueDomain#getValueDomain() <em>Get Value Domain</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Value Domain</em>' operation.
	 * @see org.sidiff.revision.changes.AttributeValueDomain#getValueDomain()
	 * @generated
	 */
	EOperation getAttributeValueDomain__GetValueDomain();

	/**
	 * Returns the meta object for class '{@link org.sidiff.revision.changes.AttributeNodeBinding <em>Attribute Node Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Attribute Node Binding</em>'.
	 * @see org.sidiff.revision.changes.AttributeNodeBinding
	 * @generated
	 */
	EClass getAttributeNodeBinding();

	/**
	 * Returns the meta object for the '{@link org.sidiff.revision.changes.AttributeNodeBinding#getNode() <em>Get Node</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Node</em>' operation.
	 * @see org.sidiff.revision.changes.AttributeNodeBinding#getNode()
	 * @generated
	 */
	EOperation getAttributeNodeBinding__GetNode();

	/**
	 * Returns the meta object for class '{@link org.sidiff.revision.changes.AttributeValueBinding <em>Attribute Value Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Attribute Value Binding</em>'.
	 * @see org.sidiff.revision.changes.AttributeValueBinding
	 * @generated
	 */
	EClass getAttributeValueBinding();

	/**
	 * Returns the meta object for the '{@link org.sidiff.revision.changes.AttributeValueBinding#getValue() <em>Get Value</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Value</em>' operation.
	 * @see org.sidiff.revision.changes.AttributeValueBinding#getValue()
	 * @generated
	 */
	EOperation getAttributeValueBinding__GetValue();

	/**
	 * Returns the meta object for class '{@link org.sidiff.revision.changes.EdgeSourceDomainDefinition <em>Edge Source Domain Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Edge Source Domain Definition</em>'.
	 * @see org.sidiff.revision.changes.EdgeSourceDomainDefinition
	 * @generated
	 */
	EClass getEdgeSourceDomainDefinition();

	/**
	 * Returns the meta object for the '{@link org.sidiff.revision.changes.EdgeSourceDomainDefinition#sourceDomainContains(org.eclipse.emf.ecore.EObject) <em>Source Domain Contains</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Source Domain Contains</em>' operation.
	 * @see org.sidiff.revision.changes.EdgeSourceDomainDefinition#sourceDomainContains(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	EOperation getEdgeSourceDomainDefinition__SourceDomainContains__EObject();

	/**
	 * Returns the meta object for class '{@link org.sidiff.revision.changes.EdgeTargetDomainDefinition <em>Edge Target Domain Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Edge Target Domain Definition</em>'.
	 * @see org.sidiff.revision.changes.EdgeTargetDomainDefinition
	 * @generated
	 */
	EClass getEdgeTargetDomainDefinition();

	/**
	 * Returns the meta object for the '{@link org.sidiff.revision.changes.EdgeTargetDomainDefinition#targetDomainContains(org.eclipse.emf.ecore.EObject) <em>Target Domain Contains</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Target Domain Contains</em>' operation.
	 * @see org.sidiff.revision.changes.EdgeTargetDomainDefinition#targetDomainContains(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	EOperation getEdgeTargetDomainDefinition__TargetDomainContains__EObject();

	/**
	 * Returns the meta object for class '{@link org.sidiff.revision.changes.EdgeSourceDomain <em>Edge Source Domain</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Edge Source Domain</em>'.
	 * @see org.sidiff.revision.changes.EdgeSourceDomain
	 * @generated
	 */
	EClass getEdgeSourceDomain();

	/**
	 * Returns the meta object for the '{@link org.sidiff.revision.changes.EdgeSourceDomain#getSourceDomain() <em>Get Source Domain</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Source Domain</em>' operation.
	 * @see org.sidiff.revision.changes.EdgeSourceDomain#getSourceDomain()
	 * @generated
	 */
	EOperation getEdgeSourceDomain__GetSourceDomain();

	/**
	 * Returns the meta object for class '{@link org.sidiff.revision.changes.EdgeTargetDomain <em>Edge Target Domain</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Edge Target Domain</em>'.
	 * @see org.sidiff.revision.changes.EdgeTargetDomain
	 * @generated
	 */
	EClass getEdgeTargetDomain();

	/**
	 * Returns the meta object for the '{@link org.sidiff.revision.changes.EdgeTargetDomain#getTargetDomain() <em>Get Target Domain</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Target Domain</em>' operation.
	 * @see org.sidiff.revision.changes.EdgeTargetDomain#getTargetDomain()
	 * @generated
	 */
	EOperation getEdgeTargetDomain__GetTargetDomain();

	/**
	 * Returns the meta object for class '{@link org.sidiff.revision.changes.EdgeSourceBinding <em>Edge Source Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Edge Source Binding</em>'.
	 * @see org.sidiff.revision.changes.EdgeSourceBinding
	 * @generated
	 */
	EClass getEdgeSourceBinding();

	/**
	 * Returns the meta object for the '{@link org.sidiff.revision.changes.EdgeSourceBinding#getSource() <em>Get Source</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Source</em>' operation.
	 * @see org.sidiff.revision.changes.EdgeSourceBinding#getSource()
	 * @generated
	 */
	EOperation getEdgeSourceBinding__GetSource();

	/**
	 * Returns the meta object for class '{@link org.sidiff.revision.changes.EdgeTargetBinding <em>Edge Target Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Edge Target Binding</em>'.
	 * @see org.sidiff.revision.changes.EdgeTargetBinding
	 * @generated
	 */
	EClass getEdgeTargetBinding();

	/**
	 * Returns the meta object for the '{@link org.sidiff.revision.changes.EdgeTargetBinding#getTarget() <em>Get Target</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Target</em>' operation.
	 * @see org.sidiff.revision.changes.EdgeTargetBinding#getTarget()
	 * @generated
	 */
	EOperation getEdgeTargetBinding__GetTarget();

	/**
	 * Returns the meta object for class '{@link org.sidiff.revision.changes.NodeChangeDomainDefinition <em>Node Change Domain Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Node Change Domain Definition</em>'.
	 * @see org.sidiff.revision.changes.NodeChangeDomainDefinition
	 * @generated
	 */
	EClass getNodeChangeDomainDefinition();

	/**
	 * Returns the meta object for the '{@link org.sidiff.revision.changes.NodeChangeDomainDefinition#nodeDomainContains(org.eclipse.emf.ecore.EObject) <em>Node Domain Contains</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Node Domain Contains</em>' operation.
	 * @see org.sidiff.revision.changes.NodeChangeDomainDefinition#nodeDomainContains(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	EOperation getNodeChangeDomainDefinition__NodeDomainContains__EObject();

	/**
	 * Returns the meta object for class '{@link org.sidiff.revision.changes.NodeChangeDomain <em>Node Change Domain</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Node Change Domain</em>'.
	 * @see org.sidiff.revision.changes.NodeChangeDomain
	 * @generated
	 */
	EClass getNodeChangeDomain();

	/**
	 * Returns the meta object for the '{@link org.sidiff.revision.changes.NodeChangeDomain#getNodeDomains() <em>Get Node Domains</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Node Domains</em>' operation.
	 * @see org.sidiff.revision.changes.NodeChangeDomain#getNodeDomains()
	 * @generated
	 */
	EOperation getNodeChangeDomain__GetNodeDomains();

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
		 * The meta object literal for the '{@link org.sidiff.revision.changes.Change <em>Change</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.revision.changes.Change
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
		 * The meta object literal for the '{@link org.sidiff.revision.changes.NodeChange <em>Node Change</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.revision.changes.NodeChange
		 * @see org.sidiff.revision.changes.impl.ChangesPackageImpl#getNodeChange()
		 * @generated
		 */
		EClass NODE_CHANGE = eINSTANCE.getNodeChange();

		/**
		 * The meta object literal for the '<em><b>Get Type</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation NODE_CHANGE___GET_TYPE = eINSTANCE.getNodeChange__GetType();

		/**
		 * The meta object literal for the '{@link org.sidiff.revision.changes.NodeDomain <em>Node Domain</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.revision.changes.NodeDomain
		 * @see org.sidiff.revision.changes.impl.ChangesPackageImpl#getNodeDomain()
		 * @generated
		 */
		EClass NODE_DOMAIN = eINSTANCE.getNodeDomain();

		/**
		 * The meta object literal for the '{@link org.sidiff.revision.changes.NodeBinding <em>Node Binding</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.revision.changes.NodeBinding
		 * @see org.sidiff.revision.changes.impl.ChangesPackageImpl#getNodeBinding()
		 * @generated
		 */
		EClass NODE_BINDING = eINSTANCE.getNodeBinding();

		/**
		 * The meta object literal for the '<em><b>Get Node</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation NODE_BINDING___GET_NODE = eINSTANCE.getNodeBinding__GetNode();

		/**
		 * The meta object literal for the '{@link org.sidiff.revision.changes.AttributeDomain <em>Attribute Domain</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.revision.changes.AttributeDomain
		 * @see org.sidiff.revision.changes.impl.ChangesPackageImpl#getAttributeDomain()
		 * @generated
		 */
		EClass ATTRIBUTE_DOMAIN = eINSTANCE.getAttributeDomain();

		/**
		 * The meta object literal for the '{@link org.sidiff.revision.changes.AttributeChange <em>Attribute Change</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.revision.changes.AttributeChange
		 * @see org.sidiff.revision.changes.impl.ChangesPackageImpl#getAttributeChange()
		 * @generated
		 */
		EClass ATTRIBUTE_CHANGE = eINSTANCE.getAttributeChange();

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
		 * The meta object literal for the '<em><b>Get Value Type</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ATTRIBUTE_CHANGE___GET_VALUE_TYPE = eINSTANCE.getAttributeChange__GetValueType();

		/**
		 * The meta object literal for the '{@link org.sidiff.revision.changes.AttributeBinding <em>Attribute Binding</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.revision.changes.AttributeBinding
		 * @see org.sidiff.revision.changes.impl.ChangesPackageImpl#getAttributeBinding()
		 * @generated
		 */
		EClass ATTRIBUTE_BINDING = eINSTANCE.getAttributeBinding();

		/**
		 * The meta object literal for the '{@link org.sidiff.revision.changes.EdgeChange <em>Edge Change</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.revision.changes.EdgeChange
		 * @see org.sidiff.revision.changes.impl.ChangesPackageImpl#getEdgeChange()
		 * @generated
		 */
		EClass EDGE_CHANGE = eINSTANCE.getEdgeChange();

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
		 * The meta object literal for the '<em><b>Get Target Type</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation EDGE_CHANGE___GET_TARGET_TYPE = eINSTANCE.getEdgeChange__GetTargetType();

		/**
		 * The meta object literal for the '{@link org.sidiff.revision.changes.EdgeDomain <em>Edge Domain</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.revision.changes.EdgeDomain
		 * @see org.sidiff.revision.changes.impl.ChangesPackageImpl#getEdgeDomain()
		 * @generated
		 */
		EClass EDGE_DOMAIN = eINSTANCE.getEdgeDomain();

		/**
		 * The meta object literal for the '{@link org.sidiff.revision.changes.EdgeBinding <em>Edge Binding</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.revision.changes.EdgeBinding
		 * @see org.sidiff.revision.changes.impl.ChangesPackageImpl#getEdgeBinding()
		 * @generated
		 */
		EClass EDGE_BINDING = eINSTANCE.getEdgeBinding();

		/**
		 * The meta object literal for the '{@link org.sidiff.revision.changes.AttributeInstantiation <em>Attribute Instantiation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.revision.changes.AttributeInstantiation
		 * @see org.sidiff.revision.changes.impl.ChangesPackageImpl#getAttributeInstantiation()
		 * @generated
		 */
		EClass ATTRIBUTE_INSTANTIATION = eINSTANCE.getAttributeInstantiation();

		/**
		 * The meta object literal for the '{@link org.sidiff.revision.changes.ChangeInstantiation <em>Change Instantiation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.revision.changes.ChangeInstantiation
		 * @see org.sidiff.revision.changes.impl.ChangesPackageImpl#getChangeInstantiation()
		 * @generated
		 */
		EClass CHANGE_INSTANTIATION = eINSTANCE.getChangeInstantiation();

		/**
		 * The meta object literal for the '{@link org.sidiff.revision.changes.NodeInstantiation <em>Node Instantiation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.revision.changes.NodeInstantiation
		 * @see org.sidiff.revision.changes.impl.ChangesPackageImpl#getNodeInstantiation()
		 * @generated
		 */
		EClass NODE_INSTANTIATION = eINSTANCE.getNodeInstantiation();

		/**
		 * The meta object literal for the '{@link org.sidiff.revision.changes.EdgeInstantiation <em>Edge Instantiation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.revision.changes.EdgeInstantiation
		 * @see org.sidiff.revision.changes.impl.ChangesPackageImpl#getEdgeInstantiation()
		 * @generated
		 */
		EClass EDGE_INSTANTIATION = eINSTANCE.getEdgeInstantiation();

		/**
		 * The meta object literal for the '{@link org.sidiff.revision.changes.AttributeNodeDomainDefinition <em>Attribute Node Domain Definition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.revision.changes.AttributeNodeDomainDefinition
		 * @see org.sidiff.revision.changes.impl.ChangesPackageImpl#getAttributeNodeDomainDefinition()
		 * @generated
		 */
		EClass ATTRIBUTE_NODE_DOMAIN_DEFINITION = eINSTANCE.getAttributeNodeDomainDefinition();

		/**
		 * The meta object literal for the '<em><b>Node Domain Contains</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ATTRIBUTE_NODE_DOMAIN_DEFINITION___NODE_DOMAIN_CONTAINS__EOBJECT = eINSTANCE
				.getAttributeNodeDomainDefinition__NodeDomainContains__EObject();

		/**
		 * The meta object literal for the '{@link org.sidiff.revision.changes.AttributeValueDomainDefinition <em>Attribute Value Domain Definition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.revision.changes.AttributeValueDomainDefinition
		 * @see org.sidiff.revision.changes.impl.ChangesPackageImpl#getAttributeValueDomainDefinition()
		 * @generated
		 */
		EClass ATTRIBUTE_VALUE_DOMAIN_DEFINITION = eINSTANCE.getAttributeValueDomainDefinition();

		/**
		 * The meta object literal for the '<em><b>Value Domain Contains</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ATTRIBUTE_VALUE_DOMAIN_DEFINITION___VALUE_DOMAIN_CONTAINS__OBJECT = eINSTANCE
				.getAttributeValueDomainDefinition__ValueDomainContains__Object();

		/**
		 * The meta object literal for the '{@link org.sidiff.revision.changes.AttributeNodeDomain <em>Attribute Node Domain</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.revision.changes.AttributeNodeDomain
		 * @see org.sidiff.revision.changes.impl.ChangesPackageImpl#getAttributeNodeDomain()
		 * @generated
		 */
		EClass ATTRIBUTE_NODE_DOMAIN = eINSTANCE.getAttributeNodeDomain();

		/**
		 * The meta object literal for the '<em><b>Get Node Domain</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ATTRIBUTE_NODE_DOMAIN___GET_NODE_DOMAIN = eINSTANCE.getAttributeNodeDomain__GetNodeDomain();

		/**
		 * The meta object literal for the '{@link org.sidiff.revision.changes.AttributeValueDomain <em>Attribute Value Domain</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.revision.changes.AttributeValueDomain
		 * @see org.sidiff.revision.changes.impl.ChangesPackageImpl#getAttributeValueDomain()
		 * @generated
		 */
		EClass ATTRIBUTE_VALUE_DOMAIN = eINSTANCE.getAttributeValueDomain();

		/**
		 * The meta object literal for the '<em><b>Get Value Domain</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ATTRIBUTE_VALUE_DOMAIN___GET_VALUE_DOMAIN = eINSTANCE.getAttributeValueDomain__GetValueDomain();

		/**
		 * The meta object literal for the '{@link org.sidiff.revision.changes.AttributeNodeBinding <em>Attribute Node Binding</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.revision.changes.AttributeNodeBinding
		 * @see org.sidiff.revision.changes.impl.ChangesPackageImpl#getAttributeNodeBinding()
		 * @generated
		 */
		EClass ATTRIBUTE_NODE_BINDING = eINSTANCE.getAttributeNodeBinding();

		/**
		 * The meta object literal for the '<em><b>Get Node</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ATTRIBUTE_NODE_BINDING___GET_NODE = eINSTANCE.getAttributeNodeBinding__GetNode();

		/**
		 * The meta object literal for the '{@link org.sidiff.revision.changes.AttributeValueBinding <em>Attribute Value Binding</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.revision.changes.AttributeValueBinding
		 * @see org.sidiff.revision.changes.impl.ChangesPackageImpl#getAttributeValueBinding()
		 * @generated
		 */
		EClass ATTRIBUTE_VALUE_BINDING = eINSTANCE.getAttributeValueBinding();

		/**
		 * The meta object literal for the '<em><b>Get Value</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ATTRIBUTE_VALUE_BINDING___GET_VALUE = eINSTANCE.getAttributeValueBinding__GetValue();

		/**
		 * The meta object literal for the '{@link org.sidiff.revision.changes.EdgeSourceDomainDefinition <em>Edge Source Domain Definition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.revision.changes.EdgeSourceDomainDefinition
		 * @see org.sidiff.revision.changes.impl.ChangesPackageImpl#getEdgeSourceDomainDefinition()
		 * @generated
		 */
		EClass EDGE_SOURCE_DOMAIN_DEFINITION = eINSTANCE.getEdgeSourceDomainDefinition();

		/**
		 * The meta object literal for the '<em><b>Source Domain Contains</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation EDGE_SOURCE_DOMAIN_DEFINITION___SOURCE_DOMAIN_CONTAINS__EOBJECT = eINSTANCE
				.getEdgeSourceDomainDefinition__SourceDomainContains__EObject();

		/**
		 * The meta object literal for the '{@link org.sidiff.revision.changes.EdgeTargetDomainDefinition <em>Edge Target Domain Definition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.revision.changes.EdgeTargetDomainDefinition
		 * @see org.sidiff.revision.changes.impl.ChangesPackageImpl#getEdgeTargetDomainDefinition()
		 * @generated
		 */
		EClass EDGE_TARGET_DOMAIN_DEFINITION = eINSTANCE.getEdgeTargetDomainDefinition();

		/**
		 * The meta object literal for the '<em><b>Target Domain Contains</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation EDGE_TARGET_DOMAIN_DEFINITION___TARGET_DOMAIN_CONTAINS__EOBJECT = eINSTANCE
				.getEdgeTargetDomainDefinition__TargetDomainContains__EObject();

		/**
		 * The meta object literal for the '{@link org.sidiff.revision.changes.EdgeSourceDomain <em>Edge Source Domain</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.revision.changes.EdgeSourceDomain
		 * @see org.sidiff.revision.changes.impl.ChangesPackageImpl#getEdgeSourceDomain()
		 * @generated
		 */
		EClass EDGE_SOURCE_DOMAIN = eINSTANCE.getEdgeSourceDomain();

		/**
		 * The meta object literal for the '<em><b>Get Source Domain</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation EDGE_SOURCE_DOMAIN___GET_SOURCE_DOMAIN = eINSTANCE.getEdgeSourceDomain__GetSourceDomain();

		/**
		 * The meta object literal for the '{@link org.sidiff.revision.changes.EdgeTargetDomain <em>Edge Target Domain</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.revision.changes.EdgeTargetDomain
		 * @see org.sidiff.revision.changes.impl.ChangesPackageImpl#getEdgeTargetDomain()
		 * @generated
		 */
		EClass EDGE_TARGET_DOMAIN = eINSTANCE.getEdgeTargetDomain();

		/**
		 * The meta object literal for the '<em><b>Get Target Domain</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation EDGE_TARGET_DOMAIN___GET_TARGET_DOMAIN = eINSTANCE.getEdgeTargetDomain__GetTargetDomain();

		/**
		 * The meta object literal for the '{@link org.sidiff.revision.changes.EdgeSourceBinding <em>Edge Source Binding</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.revision.changes.EdgeSourceBinding
		 * @see org.sidiff.revision.changes.impl.ChangesPackageImpl#getEdgeSourceBinding()
		 * @generated
		 */
		EClass EDGE_SOURCE_BINDING = eINSTANCE.getEdgeSourceBinding();

		/**
		 * The meta object literal for the '<em><b>Get Source</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation EDGE_SOURCE_BINDING___GET_SOURCE = eINSTANCE.getEdgeSourceBinding__GetSource();

		/**
		 * The meta object literal for the '{@link org.sidiff.revision.changes.EdgeTargetBinding <em>Edge Target Binding</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.revision.changes.EdgeTargetBinding
		 * @see org.sidiff.revision.changes.impl.ChangesPackageImpl#getEdgeTargetBinding()
		 * @generated
		 */
		EClass EDGE_TARGET_BINDING = eINSTANCE.getEdgeTargetBinding();

		/**
		 * The meta object literal for the '<em><b>Get Target</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation EDGE_TARGET_BINDING___GET_TARGET = eINSTANCE.getEdgeTargetBinding__GetTarget();

		/**
		 * The meta object literal for the '{@link org.sidiff.revision.changes.NodeChangeDomainDefinition <em>Node Change Domain Definition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.revision.changes.NodeChangeDomainDefinition
		 * @see org.sidiff.revision.changes.impl.ChangesPackageImpl#getNodeChangeDomainDefinition()
		 * @generated
		 */
		EClass NODE_CHANGE_DOMAIN_DEFINITION = eINSTANCE.getNodeChangeDomainDefinition();

		/**
		 * The meta object literal for the '<em><b>Node Domain Contains</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation NODE_CHANGE_DOMAIN_DEFINITION___NODE_DOMAIN_CONTAINS__EOBJECT = eINSTANCE
				.getNodeChangeDomainDefinition__NodeDomainContains__EObject();

		/**
		 * The meta object literal for the '{@link org.sidiff.revision.changes.NodeChangeDomain <em>Node Change Domain</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.revision.changes.NodeChangeDomain
		 * @see org.sidiff.revision.changes.impl.ChangesPackageImpl#getNodeChangeDomain()
		 * @generated
		 */
		EClass NODE_CHANGE_DOMAIN = eINSTANCE.getNodeChangeDomain();

		/**
		 * The meta object literal for the '<em><b>Get Node Domains</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation NODE_CHANGE_DOMAIN___GET_NODE_DOMAINS = eINSTANCE.getNodeChangeDomain__GetNodeDomains();

	}

} //ChangesPackage
