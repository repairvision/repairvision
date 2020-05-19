/**
 */
package org.sidiff.graphpattern;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
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
 * @see org.sidiff.graphpattern.GraphpatternFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/OCL/Import ecore='http://www.eclipse.org/emf/2002/Ecore'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore invocationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot' settingDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot' validationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot'"
 * @generated
 */
public interface GraphpatternPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "graphpattern";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.sidiff.org/graphpattern/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "graphpattern";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	GraphpatternPackage eINSTANCE = org.sidiff.graphpattern.impl.GraphpatternPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.sidiff.graphpattern.impl.PatternElementImpl <em>Pattern Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.graphpattern.impl.PatternElementImpl
	 * @see org.sidiff.graphpattern.impl.GraphpatternPackageImpl#getPatternElement()
	 * @generated
	 */
	int PATTERN_ELEMENT = 7;

	/**
	 * The meta object id for the '{@link org.sidiff.graphpattern.impl.GraphPatternImpl <em>Graph Pattern</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.graphpattern.impl.GraphPatternImpl
	 * @see org.sidiff.graphpattern.impl.GraphpatternPackageImpl#getGraphPattern()
	 * @generated
	 */
	int GRAPH_PATTERN = 0;

	/**
	 * The meta object id for the '{@link org.sidiff.graphpattern.impl.NodePatternImpl <em>Node Pattern</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.graphpattern.impl.NodePatternImpl
	 * @see org.sidiff.graphpattern.impl.GraphpatternPackageImpl#getNodePattern()
	 * @generated
	 */
	int NODE_PATTERN = 1;

	/**
	 * The meta object id for the '{@link org.sidiff.graphpattern.impl.EdgePatternImpl <em>Edge Pattern</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.graphpattern.impl.EdgePatternImpl
	 * @see org.sidiff.graphpattern.impl.GraphpatternPackageImpl#getEdgePattern()
	 * @generated
	 */
	int EDGE_PATTERN = 2;

	/**
	 * The meta object id for the '{@link org.sidiff.graphpattern.impl.AttributePatternImpl <em>Attribute Pattern</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.graphpattern.impl.AttributePatternImpl
	 * @see org.sidiff.graphpattern.impl.GraphpatternPackageImpl#getAttributePattern()
	 * @generated
	 */
	int ATTRIBUTE_PATTERN = 3;

	/**
	 * The meta object id for the '{@link org.sidiff.graphpattern.impl.PatternImpl <em>Pattern</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.graphpattern.impl.PatternImpl
	 * @see org.sidiff.graphpattern.impl.GraphpatternPackageImpl#getPattern()
	 * @generated
	 */
	int PATTERN = 6;

	/**
	 * The meta object id for the '{@link org.sidiff.graphpattern.impl.ParameterImpl <em>Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.graphpattern.impl.ParameterImpl
	 * @see org.sidiff.graphpattern.impl.GraphpatternPackageImpl#getParameter()
	 * @generated
	 */
	int PARAMETER = 8;

	/**
	 * The meta object id for the '{@link org.sidiff.graphpattern.impl.GraphElementImpl <em>Graph Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.graphpattern.impl.GraphElementImpl
	 * @see org.sidiff.graphpattern.impl.GraphpatternPackageImpl#getGraphElement()
	 * @generated
	 */
	int GRAPH_ELEMENT = 20;

	/**
	 * The meta object id for the '{@link org.sidiff.graphpattern.impl.MatchingImpl <em>Matching</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.graphpattern.impl.MatchingImpl
	 * @see org.sidiff.graphpattern.impl.GraphpatternPackageImpl#getMatching()
	 * @generated
	 */
	int MATCHING = 4;

	/**
	 * The meta object id for the '{@link org.sidiff.graphpattern.impl.BundleImpl <em>Bundle</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.graphpattern.impl.BundleImpl
	 * @see org.sidiff.graphpattern.impl.GraphpatternPackageImpl#getBundle()
	 * @generated
	 */
	int BUNDLE = 5;

	/**
	 * The meta object id for the '{@link org.sidiff.graphpattern.impl.EObjectListImpl <em>EObject List</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.graphpattern.impl.EObjectListImpl
	 * @see org.sidiff.graphpattern.impl.GraphpatternPackageImpl#getEObjectList()
	 * @generated
	 */
	int EOBJECT_LIST = 9;

	/**
	 * The meta object id for the '{@link org.sidiff.graphpattern.impl.DependencyNodeImpl <em>Dependency Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.graphpattern.impl.DependencyNodeImpl
	 * @see org.sidiff.graphpattern.impl.GraphpatternPackageImpl#getDependencyNode()
	 * @generated
	 */
	int DEPENDENCY_NODE = 11;

	/**
	 * The meta object id for the '{@link org.sidiff.graphpattern.impl.DependencyGraphImpl <em>Dependency Graph</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.graphpattern.impl.DependencyGraphImpl
	 * @see org.sidiff.graphpattern.impl.GraphpatternPackageImpl#getDependencyGraph()
	 * @generated
	 */
	int DEPENDENCY_GRAPH = 10;

	/**
	 * The meta object id for the '{@link org.sidiff.graphpattern.impl.DependencyEdgeImpl <em>Dependency Edge</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.graphpattern.impl.DependencyEdgeImpl
	 * @see org.sidiff.graphpattern.impl.GraphpatternPackageImpl#getDependencyEdge()
	 * @generated
	 */
	int DEPENDENCY_EDGE = 12;

	/**
	 * The meta object id for the '{@link org.sidiff.graphpattern.impl.AssociationImpl <em>Association</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.graphpattern.impl.AssociationImpl
	 * @see org.sidiff.graphpattern.impl.GraphpatternPackageImpl#getAssociation()
	 * @generated
	 */
	int ASSOCIATION = 13;

	/**
	 * The meta object id for the '{@link org.sidiff.graphpattern.impl.StereotypeImpl <em>Stereotype</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.graphpattern.impl.StereotypeImpl
	 * @see org.sidiff.graphpattern.impl.GraphpatternPackageImpl#getStereotype()
	 * @generated
	 */
	int STEREOTYPE = 14;

	/**
	 * The meta object id for the '{@link org.sidiff.graphpattern.impl.ParameterBindingImpl <em>Parameter Binding</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.graphpattern.impl.ParameterBindingImpl
	 * @see org.sidiff.graphpattern.impl.GraphpatternPackageImpl#getParameterBinding()
	 * @generated
	 */
	int PARAMETER_BINDING = 15;

	/**
	 * The meta object id for the '{@link org.sidiff.graphpattern.impl.AssignmentImpl <em>Assignment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.graphpattern.impl.AssignmentImpl
	 * @see org.sidiff.graphpattern.impl.GraphpatternPackageImpl#getAssignment()
	 * @generated
	 */
	int ASSIGNMENT = 16;

	/**
	 * The meta object id for the '{@link org.sidiff.graphpattern.impl.ObjectBindingImpl <em>Object Binding</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.graphpattern.impl.ObjectBindingImpl
	 * @see org.sidiff.graphpattern.impl.GraphpatternPackageImpl#getObjectBinding()
	 * @generated
	 */
	int OBJECT_BINDING = 17;

	/**
	 * The meta object id for the '{@link org.sidiff.graphpattern.impl.ValueBindingImpl <em>Value Binding</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.graphpattern.impl.ValueBindingImpl
	 * @see org.sidiff.graphpattern.impl.GraphpatternPackageImpl#getValueBinding()
	 * @generated
	 */
	int VALUE_BINDING = 18;

	/**
	 * The meta object id for the '{@link org.sidiff.graphpattern.Extendable <em>Extendable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.graphpattern.Extendable
	 * @see org.sidiff.graphpattern.impl.GraphpatternPackageImpl#getExtendable()
	 * @generated
	 */
	int EXTENDABLE = 23;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDABLE__STEREOTYPES = 0;

	/**
	 * The number of structural features of the '<em>Extendable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDABLE_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Extendable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDABLE_OPERATION_COUNT = 0;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_ELEMENT__STEREOTYPES = EXTENDABLE__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_ELEMENT__NAME = EXTENDABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_ELEMENT__DESCRIPTION = EXTENDABLE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Pattern Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_ELEMENT_FEATURE_COUNT = EXTENDABLE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Pattern Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_ELEMENT_OPERATION_COUNT = EXTENDABLE_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPH_PATTERN__STEREOTYPES = PATTERN_ELEMENT__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPH_PATTERN__NAME = PATTERN_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPH_PATTERN__DESCRIPTION = PATTERN_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPH_PATTERN__NODES = PATTERN_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Pattern</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPH_PATTERN__PATTERN = PATTERN_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Dependency Graph</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPH_PATTERN__DEPENDENCY_GRAPH = PATTERN_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Subgraphs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPH_PATTERN__SUBGRAPHS = PATTERN_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Graph Pattern</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPH_PATTERN_FEATURE_COUNT = PATTERN_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The operation id for the '<em>Get Node</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPH_PATTERN___GET_NODE__STRING = PATTERN_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Graph Pattern</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPH_PATTERN_OPERATION_COUNT = PATTERN_ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPH_ELEMENT__STEREOTYPES = PATTERN_ELEMENT__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPH_ELEMENT__NAME = PATTERN_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPH_ELEMENT__DESCRIPTION = PATTERN_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Subgraphs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPH_ELEMENT__SUBGRAPHS = PATTERN_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Graph</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPH_ELEMENT__GRAPH = PATTERN_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Graph Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPH_ELEMENT_FEATURE_COUNT = PATTERN_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Graph Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPH_ELEMENT_OPERATION_COUNT = PATTERN_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_PATTERN__STEREOTYPES = GRAPH_ELEMENT__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_PATTERN__NAME = GRAPH_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_PATTERN__DESCRIPTION = GRAPH_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Subgraphs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_PATTERN__SUBGRAPHS = GRAPH_ELEMENT__SUBGRAPHS;

	/**
	 * The feature id for the '<em><b>Graph</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_PATTERN__GRAPH = GRAPH_ELEMENT__GRAPH;

	/**
	 * The feature id for the '<em><b>Outgoings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_PATTERN__OUTGOINGS = GRAPH_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_PATTERN__TYPE = GRAPH_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_PATTERN__ATTRIBUTES = GRAPH_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Matching</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_PATTERN__MATCHING = GRAPH_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Incomings</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_PATTERN__INCOMINGS = GRAPH_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Associations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_PATTERN__ASSOCIATIONS = GRAPH_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Node Pattern</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_PATTERN_FEATURE_COUNT = GRAPH_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The operation id for the '<em>Get Attribute</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_PATTERN___GET_ATTRIBUTE__EATTRIBUTE = GRAPH_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Outgoings</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_PATTERN___GET_OUTGOINGS__EREFERENCE = GRAPH_ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Outgoing</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_PATTERN___GET_OUTGOING__EREFERENCE = GRAPH_ELEMENT_OPERATION_COUNT + 2;

	/**
	 * The operation id for the '<em>Get Outgoing</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_PATTERN___GET_OUTGOING__EREFERENCE_NODEPATTERN = GRAPH_ELEMENT_OPERATION_COUNT + 3;

	/**
	 * The operation id for the '<em>Get Outgoing</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_PATTERN___GET_OUTGOING__EREFERENCE_NODEPATTERN_STEREOTYPE = GRAPH_ELEMENT_OPERATION_COUNT + 4;

	/**
	 * The operation id for the '<em>Get Incoming</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_PATTERN___GET_INCOMING__EREFERENCE = GRAPH_ELEMENT_OPERATION_COUNT + 5;

	/**
	 * The operation id for the '<em>Get Incomings</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_PATTERN___GET_INCOMINGS__EREFERENCE = GRAPH_ELEMENT_OPERATION_COUNT + 6;

	/**
	 * The operation id for the '<em>Get Incident</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_PATTERN___GET_INCIDENT = GRAPH_ELEMENT_OPERATION_COUNT + 7;

	/**
	 * The operation id for the '<em>Get Incident</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_PATTERN___GET_INCIDENT__NODEPATTERN = GRAPH_ELEMENT_OPERATION_COUNT + 8;

	/**
	 * The operation id for the '<em>Remove Incident</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_PATTERN___REMOVE_INCIDENT = GRAPH_ELEMENT_OPERATION_COUNT + 9;

	/**
	 * The operation id for the '<em>Remove Incident</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_PATTERN___REMOVE_INCIDENT__NODEPATTERN = GRAPH_ELEMENT_OPERATION_COUNT + 10;

	/**
	 * The operation id for the '<em>Get Adjacent</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_PATTERN___GET_ADJACENT = GRAPH_ELEMENT_OPERATION_COUNT + 11;

	/**
	 * The number of operations of the '<em>Node Pattern</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_PATTERN_OPERATION_COUNT = GRAPH_ELEMENT_OPERATION_COUNT + 12;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_PATTERN__STEREOTYPES = GRAPH_ELEMENT__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_PATTERN__NAME = GRAPH_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_PATTERN__DESCRIPTION = GRAPH_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Subgraphs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_PATTERN__SUBGRAPHS = GRAPH_ELEMENT__SUBGRAPHS;

	/**
	 * The feature id for the '<em><b>Graph</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_PATTERN__GRAPH = GRAPH_ELEMENT__GRAPH;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_PATTERN__TARGET = GRAPH_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Source</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_PATTERN__SOURCE = GRAPH_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Opposite</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_PATTERN__OPPOSITE = GRAPH_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_PATTERN__TYPE = GRAPH_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Edge Pattern</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_PATTERN_FEATURE_COUNT = GRAPH_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Edge Pattern</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_PATTERN_OPERATION_COUNT = GRAPH_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_PATTERN__STEREOTYPES = GRAPH_ELEMENT__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_PATTERN__NAME = GRAPH_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_PATTERN__DESCRIPTION = GRAPH_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Subgraphs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_PATTERN__SUBGRAPHS = GRAPH_ELEMENT__SUBGRAPHS;

	/**
	 * The feature id for the '<em><b>Graph</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_PATTERN__GRAPH = GRAPH_ELEMENT__GRAPH;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_PATTERN__VALUE = GRAPH_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_PATTERN__TYPE = GRAPH_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Node</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_PATTERN__NODE = GRAPH_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Constant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_PATTERN__CONSTANT = GRAPH_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Variables</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_PATTERN__VARIABLES = GRAPH_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Attribute Pattern</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_PATTERN_FEATURE_COUNT = GRAPH_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The operation id for the '<em>Is Constant</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_PATTERN___IS_CONSTANT = GRAPH_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Is Variable</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_PATTERN___IS_VARIABLE = GRAPH_ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Is Expression</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_PATTERN___IS_EXPRESSION = GRAPH_ELEMENT_OPERATION_COUNT + 2;

	/**
	 * The number of operations of the '<em>Attribute Pattern</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_PATTERN_OPERATION_COUNT = GRAPH_ELEMENT_OPERATION_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Matches</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATCHING__MATCHES = 0;

	/**
	 * The feature id for the '<em><b>Node</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATCHING__NODE = 1;

	/**
	 * The number of structural features of the '<em>Matching</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATCHING_FEATURE_COUNT = 2;

	/**
	 * The operation id for the '<em>Iterator</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATCHING___ITERATOR = 0;

	/**
	 * The operation id for the '<em>Size</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATCHING___SIZE = 1;

	/**
	 * The operation id for the '<em>Is Empty</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATCHING___IS_EMPTY = 2;

	/**
	 * The operation id for the '<em>Add</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATCHING___ADD__EOBJECT = 3;

	/**
	 * The operation id for the '<em>Remove</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATCHING___REMOVE__EOBJECT = 4;

	/**
	 * The operation id for the '<em>Contains</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATCHING___CONTAINS__EOBJECT = 5;

	/**
	 * The operation id for the '<em>Clear</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATCHING___CLEAR = 6;

	/**
	 * The number of operations of the '<em>Matching</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATCHING_OPERATION_COUNT = 7;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN__STEREOTYPES = PATTERN_ELEMENT__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN__NAME = PATTERN_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN__DESCRIPTION = PATTERN_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Graphs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN__GRAPHS = PATTERN_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN__PARAMETERS = PATTERN_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Assignments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN__ASSIGNMENTS = PATTERN_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Bundle</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN__BUNDLE = PATTERN_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Patterns</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN__PATTERNS = PATTERN_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Pattern</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_FEATURE_COUNT = PATTERN_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The operation id for the '<em>Get Pattern</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN___GET_PATTERN__STRING = PATTERN_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Parameter</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN___GET_PARAMETER__STRING = PATTERN_ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Graph</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN___GET_GRAPH__STRING = PATTERN_ELEMENT_OPERATION_COUNT + 2;

	/**
	 * The operation id for the '<em>Get All Graph Patterns</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN___GET_ALL_GRAPH_PATTERNS = PATTERN_ELEMENT_OPERATION_COUNT + 3;

	/**
	 * The number of operations of the '<em>Pattern</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_OPERATION_COUNT = PATTERN_ELEMENT_OPERATION_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLE__STEREOTYPES = PATTERN__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLE__NAME = PATTERN__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLE__DESCRIPTION = PATTERN__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Graphs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLE__GRAPHS = PATTERN__GRAPHS;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLE__PARAMETERS = PATTERN__PARAMETERS;

	/**
	 * The feature id for the '<em><b>Assignments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLE__ASSIGNMENTS = PATTERN__ASSIGNMENTS;

	/**
	 * The feature id for the '<em><b>Bundle</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLE__BUNDLE = PATTERN__BUNDLE;

	/**
	 * The feature id for the '<em><b>Patterns</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLE__PATTERNS = PATTERN__PATTERNS;

	/**
	 * The feature id for the '<em><b>Profiles</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLE__PROFILES = PATTERN_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Domains</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLE__DOMAINS = PATTERN_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Bundle</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLE_FEATURE_COUNT = PATTERN_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Get Pattern</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLE___GET_PATTERN__STRING = PATTERN___GET_PATTERN__STRING;

	/**
	 * The operation id for the '<em>Get Parameter</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLE___GET_PARAMETER__STRING = PATTERN___GET_PARAMETER__STRING;

	/**
	 * The operation id for the '<em>Get Graph</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLE___GET_GRAPH__STRING = PATTERN___GET_GRAPH__STRING;

	/**
	 * The operation id for the '<em>Get All Graph Patterns</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLE___GET_ALL_GRAPH_PATTERNS = PATTERN___GET_ALL_GRAPH_PATTERNS;

	/**
	 * The number of operations of the '<em>Bundle</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLE_OPERATION_COUNT = PATTERN_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__STEREOTYPES = PATTERN_ELEMENT__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__NAME = PATTERN_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__DESCRIPTION = PATTERN_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Pattern</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__PATTERN = PATTERN_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_FEATURE_COUNT = PATTERN_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_OPERATION_COUNT = PATTERN_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Content</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EOBJECT_LIST__CONTENT = 0;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EOBJECT_LIST__LABEL = 1;

	/**
	 * The number of structural features of the '<em>EObject List</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EOBJECT_LIST_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>EObject List</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EOBJECT_LIST_OPERATION_COUNT = 0;

	/**
	 * The feature id for the '<em><b>Independent</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY_GRAPH__INDEPENDENT = 0;

	/**
	 * The feature id for the '<em><b>Graph</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY_GRAPH__GRAPH = 1;

	/**
	 * The feature id for the '<em><b>Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY_GRAPH__NODES = 2;

	/**
	 * The feature id for the '<em><b>Edges</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY_GRAPH__EDGES = 3;

	/**
	 * The number of structural features of the '<em>Dependency Graph</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY_GRAPH_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Dependency Graph</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY_GRAPH_OPERATION_COUNT = 0;

	/**
	 * The feature id for the '<em><b>Outgoings</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY_NODE__OUTGOINGS = 0;

	/**
	 * The feature id for the '<em><b>Incomings</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY_NODE__INCOMINGS = 1;

	/**
	 * The feature id for the '<em><b>Nodes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY_NODE__NODES = 2;

	/**
	 * The number of structural features of the '<em>Dependency Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY_NODE_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Dependency Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY_NODE_OPERATION_COUNT = 0;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY_EDGE__SOURCE = 0;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY_EDGE__TARGET = 1;

	/**
	 * The number of structural features of the '<em>Dependency Edge</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY_EDGE_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Dependency Edge</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY_EDGE_OPERATION_COUNT = 0;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION__STEREOTYPES = PATTERN_ELEMENT__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION__NAME = PATTERN_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION__DESCRIPTION = PATTERN_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Source</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION__SOURCE = PATTERN_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION__TARGET = PATTERN_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Association</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_FEATURE_COUNT = PATTERN_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Association</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_OPERATION_COUNT = PATTERN_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE__NAME = 0;

	/**
	 * The feature id for the '<em><b>Profile</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE__PROFILE = 1;

	/**
	 * The number of structural features of the '<em>Stereotype</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Stereotype</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_OPERATION_COUNT = 0;

	/**
	 * The feature id for the '<em><b>Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_BINDING__PARAMETER = 0;

	/**
	 * The number of structural features of the '<em>Parameter Binding</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_BINDING_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Parameter Binding</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_BINDING_OPERATION_COUNT = 0;

	/**
	 * The feature id for the '<em><b>Assignment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT__ASSIGNMENT = 0;

	/**
	 * The feature id for the '<em><b>Pattern</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT__PATTERN = 1;

	/**
	 * The number of structural features of the '<em>Assignment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Assignment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT_OPERATION_COUNT = 0;

	/**
	 * The feature id for the '<em><b>Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_BINDING__PARAMETER = PARAMETER_BINDING__PARAMETER;

	/**
	 * The feature id for the '<em><b>Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_BINDING__VALUE = PARAMETER_BINDING_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Object Binding</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_BINDING_FEATURE_COUNT = PARAMETER_BINDING_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Object Binding</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_BINDING_OPERATION_COUNT = PARAMETER_BINDING_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_BINDING__PARAMETER = PARAMETER_BINDING__PARAMETER;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_BINDING__VALUE = PARAMETER_BINDING_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Value Binding</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_BINDING_FEATURE_COUNT = PARAMETER_BINDING_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Value Binding</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_BINDING_OPERATION_COUNT = PARAMETER_BINDING_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sidiff.graphpattern.impl.SubGraphImpl <em>Sub Graph</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.graphpattern.impl.SubGraphImpl
	 * @see org.sidiff.graphpattern.impl.GraphpatternPackageImpl#getSubGraph()
	 * @generated
	 */
	int SUB_GRAPH = 19;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_GRAPH__STEREOTYPES = PATTERN_ELEMENT__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_GRAPH__NAME = PATTERN_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_GRAPH__DESCRIPTION = PATTERN_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_GRAPH__ELEMENTS = PATTERN_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Subgraphs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_GRAPH__SUBGRAPHS = PATTERN_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Sub Graph</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_GRAPH_FEATURE_COUNT = PATTERN_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Sub Graph</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_GRAPH_OPERATION_COUNT = PATTERN_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sidiff.graphpattern.impl.ProfileImpl <em>Profile</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.graphpattern.impl.ProfileImpl
	 * @see org.sidiff.graphpattern.impl.GraphpatternPackageImpl#getProfile()
	 * @generated
	 */
	int PROFILE = 21;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILE__STEREOTYPES = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILE__NAME = 1;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILE__DESCRIPTION = 2;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILE__ID = 3;

	/**
	 * The number of structural features of the '<em>Profile</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILE_FEATURE_COUNT = 4;

	/**
	 * The operation id for the '<em>Get Stereotype</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILE___GET_STEREOTYPE__STRING = 0;

	/**
	 * The number of operations of the '<em>Profile</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILE_OPERATION_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.sidiff.graphpattern.Resource <em>Resource</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.graphpattern.Resource
	 * @see org.sidiff.graphpattern.impl.GraphpatternPackageImpl#getResource()
	 * @generated
	 */
	int RESOURCE = 22;

	/**
	 * The feature id for the '<em><b>Contents</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE__CONTENTS = 0;

	/**
	 * The number of structural features of the '<em>Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '<em>EIterator</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.util.Iterator
	 * @see org.sidiff.graphpattern.impl.GraphpatternPackageImpl#getEIterator()
	 * @generated
	 */
	int EITERATOR = 24;

	/**
	 * Returns the meta object for class '{@link org.sidiff.graphpattern.GraphPattern <em>Graph Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Graph Pattern</em>'.
	 * @see org.sidiff.graphpattern.GraphPattern
	 * @generated
	 */
	EClass getGraphPattern();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sidiff.graphpattern.GraphPattern#getNodes <em>Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Nodes</em>'.
	 * @see org.sidiff.graphpattern.GraphPattern#getNodes()
	 * @see #getGraphPattern()
	 * @generated
	 */
	EReference getGraphPattern_Nodes();

	/**
	 * Returns the meta object for the container reference '{@link org.sidiff.graphpattern.GraphPattern#getPattern <em>Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Pattern</em>'.
	 * @see org.sidiff.graphpattern.GraphPattern#getPattern()
	 * @see #getGraphPattern()
	 * @generated
	 */
	EReference getGraphPattern_Pattern();

	/**
	 * Returns the meta object for the containment reference '{@link org.sidiff.graphpattern.GraphPattern#getDependencyGraph <em>Dependency Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Dependency Graph</em>'.
	 * @see org.sidiff.graphpattern.GraphPattern#getDependencyGraph()
	 * @see #getGraphPattern()
	 * @generated
	 */
	EReference getGraphPattern_DependencyGraph();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sidiff.graphpattern.GraphPattern#getSubgraphs <em>Subgraphs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Subgraphs</em>'.
	 * @see org.sidiff.graphpattern.GraphPattern#getSubgraphs()
	 * @see #getGraphPattern()
	 * @generated
	 */
	EReference getGraphPattern_Subgraphs();

	/**
	 * Returns the meta object for the '{@link org.sidiff.graphpattern.GraphPattern#getNode(java.lang.String) <em>Get Node</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Node</em>' operation.
	 * @see org.sidiff.graphpattern.GraphPattern#getNode(java.lang.String)
	 * @generated
	 */
	EOperation getGraphPattern__GetNode__String();

	/**
	 * Returns the meta object for class '{@link org.sidiff.graphpattern.NodePattern <em>Node Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Node Pattern</em>'.
	 * @see org.sidiff.graphpattern.NodePattern
	 * @generated
	 */
	EClass getNodePattern();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sidiff.graphpattern.NodePattern#getOutgoings <em>Outgoings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Outgoings</em>'.
	 * @see org.sidiff.graphpattern.NodePattern#getOutgoings()
	 * @see #getNodePattern()
	 * @generated
	 */
	EReference getNodePattern_Outgoings();

	/**
	 * Returns the meta object for the reference '{@link org.sidiff.graphpattern.NodePattern#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see org.sidiff.graphpattern.NodePattern#getType()
	 * @see #getNodePattern()
	 * @generated
	 */
	EReference getNodePattern_Type();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sidiff.graphpattern.NodePattern#getAttributes <em>Attributes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Attributes</em>'.
	 * @see org.sidiff.graphpattern.NodePattern#getAttributes()
	 * @see #getNodePattern()
	 * @generated
	 */
	EReference getNodePattern_Attributes();

	/**
	 * Returns the meta object for the containment reference '{@link org.sidiff.graphpattern.NodePattern#getMatching <em>Matching</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Matching</em>'.
	 * @see org.sidiff.graphpattern.NodePattern#getMatching()
	 * @see #getNodePattern()
	 * @generated
	 */
	EReference getNodePattern_Matching();

	/**
	 * Returns the meta object for the reference list '{@link org.sidiff.graphpattern.NodePattern#getIncomings <em>Incomings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Incomings</em>'.
	 * @see org.sidiff.graphpattern.NodePattern#getIncomings()
	 * @see #getNodePattern()
	 * @generated
	 */
	EReference getNodePattern_Incomings();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sidiff.graphpattern.NodePattern#getAssociations <em>Associations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Associations</em>'.
	 * @see org.sidiff.graphpattern.NodePattern#getAssociations()
	 * @see #getNodePattern()
	 * @generated
	 */
	EReference getNodePattern_Associations();

	/**
	 * Returns the meta object for the '{@link org.sidiff.graphpattern.NodePattern#getAttribute(org.eclipse.emf.ecore.EAttribute) <em>Get Attribute</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Attribute</em>' operation.
	 * @see org.sidiff.graphpattern.NodePattern#getAttribute(org.eclipse.emf.ecore.EAttribute)
	 * @generated
	 */
	EOperation getNodePattern__GetAttribute__EAttribute();

	/**
	 * Returns the meta object for the '{@link org.sidiff.graphpattern.NodePattern#getOutgoing(org.eclipse.emf.ecore.EReference) <em>Get Outgoing</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Outgoing</em>' operation.
	 * @see org.sidiff.graphpattern.NodePattern#getOutgoing(org.eclipse.emf.ecore.EReference)
	 * @generated
	 */
	EOperation getNodePattern__GetOutgoing__EReference();

	/**
	 * Returns the meta object for the '{@link org.sidiff.graphpattern.NodePattern#getOutgoing(org.eclipse.emf.ecore.EReference, org.sidiff.graphpattern.NodePattern) <em>Get Outgoing</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Outgoing</em>' operation.
	 * @see org.sidiff.graphpattern.NodePattern#getOutgoing(org.eclipse.emf.ecore.EReference, org.sidiff.graphpattern.NodePattern)
	 * @generated
	 */
	EOperation getNodePattern__GetOutgoing__EReference_NodePattern();

	/**
	 * Returns the meta object for the '{@link org.sidiff.graphpattern.NodePattern#getOutgoing(org.eclipse.emf.ecore.EReference, org.sidiff.graphpattern.NodePattern, org.sidiff.graphpattern.Stereotype) <em>Get Outgoing</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Outgoing</em>' operation.
	 * @see org.sidiff.graphpattern.NodePattern#getOutgoing(org.eclipse.emf.ecore.EReference, org.sidiff.graphpattern.NodePattern, org.sidiff.graphpattern.Stereotype)
	 * @generated
	 */
	EOperation getNodePattern__GetOutgoing__EReference_NodePattern_Stereotype();

	/**
	 * Returns the meta object for the '{@link org.sidiff.graphpattern.NodePattern#getOutgoings(org.eclipse.emf.ecore.EReference) <em>Get Outgoings</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Outgoings</em>' operation.
	 * @see org.sidiff.graphpattern.NodePattern#getOutgoings(org.eclipse.emf.ecore.EReference)
	 * @generated
	 */
	EOperation getNodePattern__GetOutgoings__EReference();

	/**
	 * Returns the meta object for the '{@link org.sidiff.graphpattern.NodePattern#getIncoming(org.eclipse.emf.ecore.EReference) <em>Get Incoming</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Incoming</em>' operation.
	 * @see org.sidiff.graphpattern.NodePattern#getIncoming(org.eclipse.emf.ecore.EReference)
	 * @generated
	 */
	EOperation getNodePattern__GetIncoming__EReference();

	/**
	 * Returns the meta object for the '{@link org.sidiff.graphpattern.NodePattern#getIncomings(org.eclipse.emf.ecore.EReference) <em>Get Incomings</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Incomings</em>' operation.
	 * @see org.sidiff.graphpattern.NodePattern#getIncomings(org.eclipse.emf.ecore.EReference)
	 * @generated
	 */
	EOperation getNodePattern__GetIncomings__EReference();

	/**
	 * Returns the meta object for the '{@link org.sidiff.graphpattern.NodePattern#getIncident() <em>Get Incident</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Incident</em>' operation.
	 * @see org.sidiff.graphpattern.NodePattern#getIncident()
	 * @generated
	 */
	EOperation getNodePattern__GetIncident();

	/**
	 * Returns the meta object for the '{@link org.sidiff.graphpattern.NodePattern#getIncident(org.sidiff.graphpattern.NodePattern) <em>Get Incident</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Incident</em>' operation.
	 * @see org.sidiff.graphpattern.NodePattern#getIncident(org.sidiff.graphpattern.NodePattern)
	 * @generated
	 */
	EOperation getNodePattern__GetIncident__NodePattern();

	/**
	 * Returns the meta object for the '{@link org.sidiff.graphpattern.NodePattern#removeIncident() <em>Remove Incident</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Remove Incident</em>' operation.
	 * @see org.sidiff.graphpattern.NodePattern#removeIncident()
	 * @generated
	 */
	EOperation getNodePattern__RemoveIncident();

	/**
	 * Returns the meta object for the '{@link org.sidiff.graphpattern.NodePattern#removeIncident(org.sidiff.graphpattern.NodePattern) <em>Remove Incident</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Remove Incident</em>' operation.
	 * @see org.sidiff.graphpattern.NodePattern#removeIncident(org.sidiff.graphpattern.NodePattern)
	 * @generated
	 */
	EOperation getNodePattern__RemoveIncident__NodePattern();

	/**
	 * Returns the meta object for the '{@link org.sidiff.graphpattern.NodePattern#getAdjacent() <em>Get Adjacent</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Adjacent</em>' operation.
	 * @see org.sidiff.graphpattern.NodePattern#getAdjacent()
	 * @generated
	 */
	EOperation getNodePattern__GetAdjacent();

	/**
	 * Returns the meta object for class '{@link org.sidiff.graphpattern.EdgePattern <em>Edge Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Edge Pattern</em>'.
	 * @see org.sidiff.graphpattern.EdgePattern
	 * @generated
	 */
	EClass getEdgePattern();

	/**
	 * Returns the meta object for the reference '{@link org.sidiff.graphpattern.EdgePattern#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see org.sidiff.graphpattern.EdgePattern#getTarget()
	 * @see #getEdgePattern()
	 * @generated
	 */
	EReference getEdgePattern_Target();

	/**
	 * Returns the meta object for the container reference '{@link org.sidiff.graphpattern.EdgePattern#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Source</em>'.
	 * @see org.sidiff.graphpattern.EdgePattern#getSource()
	 * @see #getEdgePattern()
	 * @generated
	 */
	EReference getEdgePattern_Source();

	/**
	 * Returns the meta object for the reference '{@link org.sidiff.graphpattern.EdgePattern#getOpposite <em>Opposite</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Opposite</em>'.
	 * @see org.sidiff.graphpattern.EdgePattern#getOpposite()
	 * @see #getEdgePattern()
	 * @generated
	 */
	EReference getEdgePattern_Opposite();

	/**
	 * Returns the meta object for the reference '{@link org.sidiff.graphpattern.EdgePattern#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see org.sidiff.graphpattern.EdgePattern#getType()
	 * @see #getEdgePattern()
	 * @generated
	 */
	EReference getEdgePattern_Type();

	/**
	 * Returns the meta object for class '{@link org.sidiff.graphpattern.AttributePattern <em>Attribute Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Attribute Pattern</em>'.
	 * @see org.sidiff.graphpattern.AttributePattern
	 * @generated
	 */
	EClass getAttributePattern();

	/**
	 * Returns the meta object for the attribute '{@link org.sidiff.graphpattern.AttributePattern#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.sidiff.graphpattern.AttributePattern#getValue()
	 * @see #getAttributePattern()
	 * @generated
	 */
	EAttribute getAttributePattern_Value();

	/**
	 * Returns the meta object for the reference '{@link org.sidiff.graphpattern.AttributePattern#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see org.sidiff.graphpattern.AttributePattern#getType()
	 * @see #getAttributePattern()
	 * @generated
	 */
	EReference getAttributePattern_Type();

	/**
	 * Returns the meta object for the container reference '{@link org.sidiff.graphpattern.AttributePattern#getNode <em>Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Node</em>'.
	 * @see org.sidiff.graphpattern.AttributePattern#getNode()
	 * @see #getAttributePattern()
	 * @generated
	 */
	EReference getAttributePattern_Node();

	/**
	 * Returns the meta object for the attribute '{@link org.sidiff.graphpattern.AttributePattern#getConstant <em>Constant</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Constant</em>'.
	 * @see org.sidiff.graphpattern.AttributePattern#getConstant()
	 * @see #getAttributePattern()
	 * @generated
	 */
	EAttribute getAttributePattern_Constant();

	/**
	 * Returns the meta object for the attribute list '{@link org.sidiff.graphpattern.AttributePattern#getVariables <em>Variables</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Variables</em>'.
	 * @see org.sidiff.graphpattern.AttributePattern#getVariables()
	 * @see #getAttributePattern()
	 * @generated
	 */
	EAttribute getAttributePattern_Variables();

	/**
	 * Returns the meta object for the '{@link org.sidiff.graphpattern.AttributePattern#isVariable() <em>Is Variable</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Variable</em>' operation.
	 * @see org.sidiff.graphpattern.AttributePattern#isVariable()
	 * @generated
	 */
	EOperation getAttributePattern__IsVariable();

	/**
	 * Returns the meta object for the '{@link org.sidiff.graphpattern.AttributePattern#isConstant() <em>Is Constant</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Constant</em>' operation.
	 * @see org.sidiff.graphpattern.AttributePattern#isConstant()
	 * @generated
	 */
	EOperation getAttributePattern__IsConstant();

	/**
	 * Returns the meta object for the '{@link org.sidiff.graphpattern.AttributePattern#isExpression() <em>Is Expression</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Expression</em>' operation.
	 * @see org.sidiff.graphpattern.AttributePattern#isExpression()
	 * @generated
	 */
	EOperation getAttributePattern__IsExpression();

	/**
	 * Returns the meta object for class '{@link org.sidiff.graphpattern.Matching <em>Matching</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Matching</em>'.
	 * @see org.sidiff.graphpattern.Matching
	 * @generated
	 */
	EClass getMatching();

	/**
	 * Returns the meta object for the reference list '{@link org.sidiff.graphpattern.Matching#getMatches <em>Matches</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Matches</em>'.
	 * @see org.sidiff.graphpattern.Matching#getMatches()
	 * @see #getMatching()
	 * @generated
	 */
	EReference getMatching_Matches();

	/**
	 * Returns the meta object for the container reference '{@link org.sidiff.graphpattern.Matching#getNode <em>Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Node</em>'.
	 * @see org.sidiff.graphpattern.Matching#getNode()
	 * @see #getMatching()
	 * @generated
	 */
	EReference getMatching_Node();

	/**
	 * Returns the meta object for the '{@link org.sidiff.graphpattern.Matching#iterator() <em>Iterator</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Iterator</em>' operation.
	 * @see org.sidiff.graphpattern.Matching#iterator()
	 * @generated
	 */
	EOperation getMatching__Iterator();

	/**
	 * Returns the meta object for the '{@link org.sidiff.graphpattern.Matching#size() <em>Size</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Size</em>' operation.
	 * @see org.sidiff.graphpattern.Matching#size()
	 * @generated
	 */
	EOperation getMatching__Size();

	/**
	 * Returns the meta object for the '{@link org.sidiff.graphpattern.Matching#isEmpty() <em>Is Empty</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Empty</em>' operation.
	 * @see org.sidiff.graphpattern.Matching#isEmpty()
	 * @generated
	 */
	EOperation getMatching__IsEmpty();

	/**
	 * Returns the meta object for the '{@link org.sidiff.graphpattern.Matching#add(org.eclipse.emf.ecore.EObject) <em>Add</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Add</em>' operation.
	 * @see org.sidiff.graphpattern.Matching#add(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	EOperation getMatching__Add__EObject();

	/**
	 * Returns the meta object for the '{@link org.sidiff.graphpattern.Matching#remove(org.eclipse.emf.ecore.EObject) <em>Remove</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Remove</em>' operation.
	 * @see org.sidiff.graphpattern.Matching#remove(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	EOperation getMatching__Remove__EObject();

	/**
	 * Returns the meta object for the '{@link org.sidiff.graphpattern.Matching#contains(org.eclipse.emf.ecore.EObject) <em>Contains</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Contains</em>' operation.
	 * @see org.sidiff.graphpattern.Matching#contains(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	EOperation getMatching__Contains__EObject();

	/**
	 * Returns the meta object for the '{@link org.sidiff.graphpattern.Matching#clear() <em>Clear</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Clear</em>' operation.
	 * @see org.sidiff.graphpattern.Matching#clear()
	 * @generated
	 */
	EOperation getMatching__Clear();

	/**
	 * Returns the meta object for class '{@link org.sidiff.graphpattern.Bundle <em>Bundle</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Bundle</em>'.
	 * @see org.sidiff.graphpattern.Bundle
	 * @generated
	 */
	EClass getBundle();

	/**
	 * Returns the meta object for the reference list '{@link org.sidiff.graphpattern.Bundle#getProfiles <em>Profiles</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Profiles</em>'.
	 * @see org.sidiff.graphpattern.Bundle#getProfiles()
	 * @see #getBundle()
	 * @generated
	 */
	EReference getBundle_Profiles();

	/**
	 * Returns the meta object for the reference list '{@link org.sidiff.graphpattern.Bundle#getDomains <em>Domains</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Domains</em>'.
	 * @see org.sidiff.graphpattern.Bundle#getDomains()
	 * @see #getBundle()
	 * @generated
	 */
	EReference getBundle_Domains();

	/**
	 * Returns the meta object for class '{@link org.sidiff.graphpattern.EObjectList <em>EObject List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EObject List</em>'.
	 * @see org.sidiff.graphpattern.EObjectList
	 * @generated
	 */
	EClass getEObjectList();

	/**
	 * Returns the meta object for the reference list '{@link org.sidiff.graphpattern.EObjectList#getContent <em>Content</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Content</em>'.
	 * @see org.sidiff.graphpattern.EObjectList#getContent()
	 * @see #getEObjectList()
	 * @generated
	 */
	EReference getEObjectList_Content();

	/**
	 * Returns the meta object for the attribute '{@link org.sidiff.graphpattern.EObjectList#getLabel <em>Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Label</em>'.
	 * @see org.sidiff.graphpattern.EObjectList#getLabel()
	 * @see #getEObjectList()
	 * @generated
	 */
	EAttribute getEObjectList_Label();

	/**
	 * Returns the meta object for class '{@link org.sidiff.graphpattern.DependencyGraph <em>Dependency Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dependency Graph</em>'.
	 * @see org.sidiff.graphpattern.DependencyGraph
	 * @generated
	 */
	EClass getDependencyGraph();

	/**
	 * Returns the meta object for the reference list '{@link org.sidiff.graphpattern.DependencyGraph#getIndependent <em>Independent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Independent</em>'.
	 * @see org.sidiff.graphpattern.DependencyGraph#getIndependent()
	 * @see #getDependencyGraph()
	 * @generated
	 */
	EReference getDependencyGraph_Independent();

	/**
	 * Returns the meta object for the container reference '{@link org.sidiff.graphpattern.DependencyGraph#getGraph <em>Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Graph</em>'.
	 * @see org.sidiff.graphpattern.DependencyGraph#getGraph()
	 * @see #getDependencyGraph()
	 * @generated
	 */
	EReference getDependencyGraph_Graph();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sidiff.graphpattern.DependencyGraph#getNodes <em>Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Nodes</em>'.
	 * @see org.sidiff.graphpattern.DependencyGraph#getNodes()
	 * @see #getDependencyGraph()
	 * @generated
	 */
	EReference getDependencyGraph_Nodes();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sidiff.graphpattern.DependencyGraph#getEdges <em>Edges</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Edges</em>'.
	 * @see org.sidiff.graphpattern.DependencyGraph#getEdges()
	 * @see #getDependencyGraph()
	 * @generated
	 */
	EReference getDependencyGraph_Edges();

	/**
	 * Returns the meta object for class '{@link org.sidiff.graphpattern.DependencyNode <em>Dependency Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dependency Node</em>'.
	 * @see org.sidiff.graphpattern.DependencyNode
	 * @generated
	 */
	EClass getDependencyNode();

	/**
	 * Returns the meta object for the reference list '{@link org.sidiff.graphpattern.DependencyNode#getOutgoings <em>Outgoings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Outgoings</em>'.
	 * @see org.sidiff.graphpattern.DependencyNode#getOutgoings()
	 * @see #getDependencyNode()
	 * @generated
	 */
	EReference getDependencyNode_Outgoings();

	/**
	 * Returns the meta object for the reference list '{@link org.sidiff.graphpattern.DependencyNode#getIncomings <em>Incomings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Incomings</em>'.
	 * @see org.sidiff.graphpattern.DependencyNode#getIncomings()
	 * @see #getDependencyNode()
	 * @generated
	 */
	EReference getDependencyNode_Incomings();

	/**
	 * Returns the meta object for the reference list '{@link org.sidiff.graphpattern.DependencyNode#getNodes <em>Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Nodes</em>'.
	 * @see org.sidiff.graphpattern.DependencyNode#getNodes()
	 * @see #getDependencyNode()
	 * @generated
	 */
	EReference getDependencyNode_Nodes();

	/**
	 * Returns the meta object for class '{@link org.sidiff.graphpattern.DependencyEdge <em>Dependency Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dependency Edge</em>'.
	 * @see org.sidiff.graphpattern.DependencyEdge
	 * @generated
	 */
	EClass getDependencyEdge();

	/**
	 * Returns the meta object for the reference '{@link org.sidiff.graphpattern.DependencyEdge#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see org.sidiff.graphpattern.DependencyEdge#getSource()
	 * @see #getDependencyEdge()
	 * @generated
	 */
	EReference getDependencyEdge_Source();

	/**
	 * Returns the meta object for the reference '{@link org.sidiff.graphpattern.DependencyEdge#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see org.sidiff.graphpattern.DependencyEdge#getTarget()
	 * @see #getDependencyEdge()
	 * @generated
	 */
	EReference getDependencyEdge_Target();

	/**
	 * Returns the meta object for class '{@link org.sidiff.graphpattern.Association <em>Association</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Association</em>'.
	 * @see org.sidiff.graphpattern.Association
	 * @generated
	 */
	EClass getAssociation();

	/**
	 * Returns the meta object for the container reference '{@link org.sidiff.graphpattern.Association#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Source</em>'.
	 * @see org.sidiff.graphpattern.Association#getSource()
	 * @see #getAssociation()
	 * @generated
	 */
	EReference getAssociation_Source();

	/**
	 * Returns the meta object for the reference '{@link org.sidiff.graphpattern.Association#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see org.sidiff.graphpattern.Association#getTarget()
	 * @see #getAssociation()
	 * @generated
	 */
	EReference getAssociation_Target();

	/**
	 * Returns the meta object for class '{@link org.sidiff.graphpattern.Stereotype <em>Stereotype</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Stereotype</em>'.
	 * @see org.sidiff.graphpattern.Stereotype
	 * @generated
	 */
	EClass getStereotype();

	/**
	 * Returns the meta object for the attribute '{@link org.sidiff.graphpattern.Stereotype#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.sidiff.graphpattern.Stereotype#getName()
	 * @see #getStereotype()
	 * @generated
	 */
	EAttribute getStereotype_Name();

	/**
	 * Returns the meta object for the container reference '{@link org.sidiff.graphpattern.Stereotype#getProfile <em>Profile</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Profile</em>'.
	 * @see org.sidiff.graphpattern.Stereotype#getProfile()
	 * @see #getStereotype()
	 * @generated
	 */
	EReference getStereotype_Profile();

	/**
	 * Returns the meta object for class '{@link org.sidiff.graphpattern.ParameterBinding <em>Parameter Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parameter Binding</em>'.
	 * @see org.sidiff.graphpattern.ParameterBinding
	 * @generated
	 */
	EClass getParameterBinding();

	/**
	 * Returns the meta object for the reference '{@link org.sidiff.graphpattern.ParameterBinding#getParameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Parameter</em>'.
	 * @see org.sidiff.graphpattern.ParameterBinding#getParameter()
	 * @see #getParameterBinding()
	 * @generated
	 */
	EReference getParameterBinding_Parameter();

	/**
	 * Returns the meta object for class '{@link org.sidiff.graphpattern.Assignment <em>Assignment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Assignment</em>'.
	 * @see org.sidiff.graphpattern.Assignment
	 * @generated
	 */
	EClass getAssignment();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sidiff.graphpattern.Assignment#getAssignment <em>Assignment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Assignment</em>'.
	 * @see org.sidiff.graphpattern.Assignment#getAssignment()
	 * @see #getAssignment()
	 * @generated
	 */
	EReference getAssignment_Assignment();

	/**
	 * Returns the meta object for the container reference '{@link org.sidiff.graphpattern.Assignment#getPattern <em>Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Pattern</em>'.
	 * @see org.sidiff.graphpattern.Assignment#getPattern()
	 * @see #getAssignment()
	 * @generated
	 */
	EReference getAssignment_Pattern();

	/**
	 * Returns the meta object for class '{@link org.sidiff.graphpattern.ObjectBinding <em>Object Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Object Binding</em>'.
	 * @see org.sidiff.graphpattern.ObjectBinding
	 * @generated
	 */
	EClass getObjectBinding();

	/**
	 * Returns the meta object for the reference '{@link org.sidiff.graphpattern.ObjectBinding#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Value</em>'.
	 * @see org.sidiff.graphpattern.ObjectBinding#getValue()
	 * @see #getObjectBinding()
	 * @generated
	 */
	EReference getObjectBinding_Value();

	/**
	 * Returns the meta object for class '{@link org.sidiff.graphpattern.ValueBinding <em>Value Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Value Binding</em>'.
	 * @see org.sidiff.graphpattern.ValueBinding
	 * @generated
	 */
	EClass getValueBinding();

	/**
	 * Returns the meta object for the attribute '{@link org.sidiff.graphpattern.ValueBinding#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.sidiff.graphpattern.ValueBinding#getValue()
	 * @see #getValueBinding()
	 * @generated
	 */
	EAttribute getValueBinding_Value();

	/**
	 * Returns the meta object for class '{@link org.sidiff.graphpattern.SubGraph <em>Sub Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sub Graph</em>'.
	 * @see org.sidiff.graphpattern.SubGraph
	 * @generated
	 */
	EClass getSubGraph();

	/**
	 * Returns the meta object for the reference list '{@link org.sidiff.graphpattern.SubGraph#getElements <em>Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Elements</em>'.
	 * @see org.sidiff.graphpattern.SubGraph#getElements()
	 * @see #getSubGraph()
	 * @generated
	 */
	EReference getSubGraph_Elements();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sidiff.graphpattern.SubGraph#getSubgraphs <em>Subgraphs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Subgraphs</em>'.
	 * @see org.sidiff.graphpattern.SubGraph#getSubgraphs()
	 * @see #getSubGraph()
	 * @generated
	 */
	EReference getSubGraph_Subgraphs();

	/**
	 * Returns the meta object for class '{@link org.sidiff.graphpattern.GraphElement <em>Graph Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Graph Element</em>'.
	 * @see org.sidiff.graphpattern.GraphElement
	 * @generated
	 */
	EClass getGraphElement();

	/**
	 * Returns the meta object for the reference list '{@link org.sidiff.graphpattern.GraphElement#getSubgraphs <em>Subgraphs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Subgraphs</em>'.
	 * @see org.sidiff.graphpattern.GraphElement#getSubgraphs()
	 * @see #getGraphElement()
	 * @generated
	 */
	EReference getGraphElement_Subgraphs();

	/**
	 * Returns the meta object for the reference '{@link org.sidiff.graphpattern.GraphElement#getGraph <em>Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Graph</em>'.
	 * @see org.sidiff.graphpattern.GraphElement#getGraph()
	 * @see #getGraphElement()
	 * @generated
	 */
	EReference getGraphElement_Graph();

	/**
	 * Returns the meta object for class '{@link org.sidiff.graphpattern.Profile <em>Profile</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Profile</em>'.
	 * @see org.sidiff.graphpattern.Profile
	 * @generated
	 */
	EClass getProfile();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sidiff.graphpattern.Profile#getStereotypes <em>Stereotypes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Stereotypes</em>'.
	 * @see org.sidiff.graphpattern.Profile#getStereotypes()
	 * @see #getProfile()
	 * @generated
	 */
	EReference getProfile_Stereotypes();

	/**
	 * Returns the meta object for the attribute '{@link org.sidiff.graphpattern.Profile#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.sidiff.graphpattern.Profile#getName()
	 * @see #getProfile()
	 * @generated
	 */
	EAttribute getProfile_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.sidiff.graphpattern.Profile#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.sidiff.graphpattern.Profile#getDescription()
	 * @see #getProfile()
	 * @generated
	 */
	EAttribute getProfile_Description();

	/**
	 * Returns the meta object for the attribute '{@link org.sidiff.graphpattern.Profile#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see org.sidiff.graphpattern.Profile#getId()
	 * @see #getProfile()
	 * @generated
	 */
	EAttribute getProfile_Id();

	/**
	 * Returns the meta object for the '{@link org.sidiff.graphpattern.Profile#getStereotype(java.lang.String) <em>Get Stereotype</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Stereotype</em>' operation.
	 * @see org.sidiff.graphpattern.Profile#getStereotype(java.lang.String)
	 * @generated
	 */
	EOperation getProfile__GetStereotype__String();

	/**
	 * Returns the meta object for class '{@link org.sidiff.graphpattern.Resource <em>Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Resource</em>'.
	 * @see org.sidiff.graphpattern.Resource
	 * @generated
	 */
	EClass getResource();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sidiff.graphpattern.Resource#getContents <em>Contents</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Contents</em>'.
	 * @see org.sidiff.graphpattern.Resource#getContents()
	 * @see #getResource()
	 * @generated
	 */
	EReference getResource_Contents();

	/**
	 * Returns the meta object for class '{@link org.sidiff.graphpattern.Extendable <em>Extendable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Extendable</em>'.
	 * @see org.sidiff.graphpattern.Extendable
	 * @generated
	 */
	EClass getExtendable();

	/**
	 * Returns the meta object for the reference list '{@link org.sidiff.graphpattern.Extendable#getStereotypes <em>Stereotypes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Stereotypes</em>'.
	 * @see org.sidiff.graphpattern.Extendable#getStereotypes()
	 * @see #getExtendable()
	 * @generated
	 */
	EReference getExtendable_Stereotypes();

	/**
	 * Returns the meta object for class '{@link org.sidiff.graphpattern.Pattern <em>Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Pattern</em>'.
	 * @see org.sidiff.graphpattern.Pattern
	 * @generated
	 */
	EClass getPattern();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sidiff.graphpattern.Pattern#getGraphs <em>Graphs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Graphs</em>'.
	 * @see org.sidiff.graphpattern.Pattern#getGraphs()
	 * @see #getPattern()
	 * @generated
	 */
	EReference getPattern_Graphs();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sidiff.graphpattern.Pattern#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameters</em>'.
	 * @see org.sidiff.graphpattern.Pattern#getParameters()
	 * @see #getPattern()
	 * @generated
	 */
	EReference getPattern_Parameters();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sidiff.graphpattern.Pattern#getAssignments <em>Assignments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Assignments</em>'.
	 * @see org.sidiff.graphpattern.Pattern#getAssignments()
	 * @see #getPattern()
	 * @generated
	 */
	EReference getPattern_Assignments();

	/**
	 * Returns the meta object for the reference '{@link org.sidiff.graphpattern.Pattern#getBundle <em>Bundle</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Bundle</em>'.
	 * @see org.sidiff.graphpattern.Pattern#getBundle()
	 * @see #getPattern()
	 * @generated
	 */
	EReference getPattern_Bundle();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sidiff.graphpattern.Pattern#getPatterns <em>Patterns</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Patterns</em>'.
	 * @see org.sidiff.graphpattern.Pattern#getPatterns()
	 * @see #getPattern()
	 * @generated
	 */
	EReference getPattern_Patterns();

	/**
	 * Returns the meta object for the '{@link org.sidiff.graphpattern.Pattern#getPattern(java.lang.String) <em>Get Pattern</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Pattern</em>' operation.
	 * @see org.sidiff.graphpattern.Pattern#getPattern(java.lang.String)
	 * @generated
	 */
	EOperation getPattern__GetPattern__String();

	/**
	 * Returns the meta object for the '{@link org.sidiff.graphpattern.Pattern#getAllGraphPatterns() <em>Get All Graph Patterns</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get All Graph Patterns</em>' operation.
	 * @see org.sidiff.graphpattern.Pattern#getAllGraphPatterns()
	 * @generated
	 */
	EOperation getPattern__GetAllGraphPatterns();

	/**
	 * Returns the meta object for the '{@link org.sidiff.graphpattern.Pattern#getGraph(java.lang.String) <em>Get Graph</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Graph</em>' operation.
	 * @see org.sidiff.graphpattern.Pattern#getGraph(java.lang.String)
	 * @generated
	 */
	EOperation getPattern__GetGraph__String();

	/**
	 * Returns the meta object for the '{@link org.sidiff.graphpattern.Pattern#getParameter(java.lang.String) <em>Get Parameter</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Parameter</em>' operation.
	 * @see org.sidiff.graphpattern.Pattern#getParameter(java.lang.String)
	 * @generated
	 */
	EOperation getPattern__GetParameter__String();

	/**
	 * Returns the meta object for class '{@link org.sidiff.graphpattern.PatternElement <em>Pattern Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Pattern Element</em>'.
	 * @see org.sidiff.graphpattern.PatternElement
	 * @generated
	 */
	EClass getPatternElement();

	/**
	 * Returns the meta object for the attribute '{@link org.sidiff.graphpattern.PatternElement#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.sidiff.graphpattern.PatternElement#getName()
	 * @see #getPatternElement()
	 * @generated
	 */
	EAttribute getPatternElement_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.sidiff.graphpattern.PatternElement#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.sidiff.graphpattern.PatternElement#getDescription()
	 * @see #getPatternElement()
	 * @generated
	 */
	EAttribute getPatternElement_Description();

	/**
	 * Returns the meta object for class '{@link org.sidiff.graphpattern.Parameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parameter</em>'.
	 * @see org.sidiff.graphpattern.Parameter
	 * @generated
	 */
	EClass getParameter();

	/**
	 * Returns the meta object for the container reference '{@link org.sidiff.graphpattern.Parameter#getPattern <em>Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Pattern</em>'.
	 * @see org.sidiff.graphpattern.Parameter#getPattern()
	 * @see #getParameter()
	 * @generated
	 */
	EReference getParameter_Pattern();

	/**
	 * Returns the meta object for data type '{@link java.util.Iterator <em>EIterator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>EIterator</em>'.
	 * @see java.util.Iterator
	 * @model instanceClass="java.util.Iterator&lt;org.eclipse.emf.ecore.EObject&gt;" serializeable="false"
	 * @generated
	 */
	EDataType getEIterator();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	GraphpatternFactory getGraphpatternFactory();

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
		 * The meta object literal for the '{@link org.sidiff.graphpattern.impl.GraphPatternImpl <em>Graph Pattern</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.graphpattern.impl.GraphPatternImpl
		 * @see org.sidiff.graphpattern.impl.GraphpatternPackageImpl#getGraphPattern()
		 * @generated
		 */
		EClass GRAPH_PATTERN = eINSTANCE.getGraphPattern();

		/**
		 * The meta object literal for the '<em><b>Nodes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GRAPH_PATTERN__NODES = eINSTANCE.getGraphPattern_Nodes();

		/**
		 * The meta object literal for the '<em><b>Pattern</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GRAPH_PATTERN__PATTERN = eINSTANCE.getGraphPattern_Pattern();

		/**
		 * The meta object literal for the '<em><b>Dependency Graph</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GRAPH_PATTERN__DEPENDENCY_GRAPH = eINSTANCE.getGraphPattern_DependencyGraph();

		/**
		 * The meta object literal for the '<em><b>Subgraphs</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GRAPH_PATTERN__SUBGRAPHS = eINSTANCE.getGraphPattern_Subgraphs();

		/**
		 * The meta object literal for the '<em><b>Get Node</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation GRAPH_PATTERN___GET_NODE__STRING = eINSTANCE.getGraphPattern__GetNode__String();

		/**
		 * The meta object literal for the '{@link org.sidiff.graphpattern.impl.NodePatternImpl <em>Node Pattern</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.graphpattern.impl.NodePatternImpl
		 * @see org.sidiff.graphpattern.impl.GraphpatternPackageImpl#getNodePattern()
		 * @generated
		 */
		EClass NODE_PATTERN = eINSTANCE.getNodePattern();

		/**
		 * The meta object literal for the '<em><b>Outgoings</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE_PATTERN__OUTGOINGS = eINSTANCE.getNodePattern_Outgoings();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE_PATTERN__TYPE = eINSTANCE.getNodePattern_Type();

		/**
		 * The meta object literal for the '<em><b>Attributes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE_PATTERN__ATTRIBUTES = eINSTANCE.getNodePattern_Attributes();

		/**
		 * The meta object literal for the '<em><b>Matching</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE_PATTERN__MATCHING = eINSTANCE.getNodePattern_Matching();

		/**
		 * The meta object literal for the '<em><b>Incomings</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE_PATTERN__INCOMINGS = eINSTANCE.getNodePattern_Incomings();

		/**
		 * The meta object literal for the '<em><b>Associations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE_PATTERN__ASSOCIATIONS = eINSTANCE.getNodePattern_Associations();

		/**
		 * The meta object literal for the '<em><b>Get Attribute</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation NODE_PATTERN___GET_ATTRIBUTE__EATTRIBUTE = eINSTANCE.getNodePattern__GetAttribute__EAttribute();

		/**
		 * The meta object literal for the '<em><b>Get Outgoing</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation NODE_PATTERN___GET_OUTGOING__EREFERENCE = eINSTANCE.getNodePattern__GetOutgoing__EReference();

		/**
		 * The meta object literal for the '<em><b>Get Outgoing</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation NODE_PATTERN___GET_OUTGOING__EREFERENCE_NODEPATTERN = eINSTANCE.getNodePattern__GetOutgoing__EReference_NodePattern();

		/**
		 * The meta object literal for the '<em><b>Get Outgoing</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation NODE_PATTERN___GET_OUTGOING__EREFERENCE_NODEPATTERN_STEREOTYPE = eINSTANCE.getNodePattern__GetOutgoing__EReference_NodePattern_Stereotype();

		/**
		 * The meta object literal for the '<em><b>Get Outgoings</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation NODE_PATTERN___GET_OUTGOINGS__EREFERENCE = eINSTANCE.getNodePattern__GetOutgoings__EReference();

		/**
		 * The meta object literal for the '<em><b>Get Incoming</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation NODE_PATTERN___GET_INCOMING__EREFERENCE = eINSTANCE.getNodePattern__GetIncoming__EReference();

		/**
		 * The meta object literal for the '<em><b>Get Incomings</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation NODE_PATTERN___GET_INCOMINGS__EREFERENCE = eINSTANCE.getNodePattern__GetIncomings__EReference();

		/**
		 * The meta object literal for the '<em><b>Get Incident</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation NODE_PATTERN___GET_INCIDENT = eINSTANCE.getNodePattern__GetIncident();

		/**
		 * The meta object literal for the '<em><b>Get Incident</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation NODE_PATTERN___GET_INCIDENT__NODEPATTERN = eINSTANCE.getNodePattern__GetIncident__NodePattern();

		/**
		 * The meta object literal for the '<em><b>Remove Incident</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation NODE_PATTERN___REMOVE_INCIDENT = eINSTANCE.getNodePattern__RemoveIncident();

		/**
		 * The meta object literal for the '<em><b>Remove Incident</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation NODE_PATTERN___REMOVE_INCIDENT__NODEPATTERN = eINSTANCE.getNodePattern__RemoveIncident__NodePattern();

		/**
		 * The meta object literal for the '<em><b>Get Adjacent</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation NODE_PATTERN___GET_ADJACENT = eINSTANCE.getNodePattern__GetAdjacent();

		/**
		 * The meta object literal for the '{@link org.sidiff.graphpattern.impl.EdgePatternImpl <em>Edge Pattern</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.graphpattern.impl.EdgePatternImpl
		 * @see org.sidiff.graphpattern.impl.GraphpatternPackageImpl#getEdgePattern()
		 * @generated
		 */
		EClass EDGE_PATTERN = eINSTANCE.getEdgePattern();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EDGE_PATTERN__TARGET = eINSTANCE.getEdgePattern_Target();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EDGE_PATTERN__SOURCE = eINSTANCE.getEdgePattern_Source();

		/**
		 * The meta object literal for the '<em><b>Opposite</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EDGE_PATTERN__OPPOSITE = eINSTANCE.getEdgePattern_Opposite();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EDGE_PATTERN__TYPE = eINSTANCE.getEdgePattern_Type();

		/**
		 * The meta object literal for the '{@link org.sidiff.graphpattern.impl.AttributePatternImpl <em>Attribute Pattern</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.graphpattern.impl.AttributePatternImpl
		 * @see org.sidiff.graphpattern.impl.GraphpatternPackageImpl#getAttributePattern()
		 * @generated
		 */
		EClass ATTRIBUTE_PATTERN = eINSTANCE.getAttributePattern();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTRIBUTE_PATTERN__VALUE = eINSTANCE.getAttributePattern_Value();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ATTRIBUTE_PATTERN__TYPE = eINSTANCE.getAttributePattern_Type();

		/**
		 * The meta object literal for the '<em><b>Node</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ATTRIBUTE_PATTERN__NODE = eINSTANCE.getAttributePattern_Node();

		/**
		 * The meta object literal for the '<em><b>Constant</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTRIBUTE_PATTERN__CONSTANT = eINSTANCE.getAttributePattern_Constant();

		/**
		 * The meta object literal for the '<em><b>Variables</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTRIBUTE_PATTERN__VARIABLES = eINSTANCE.getAttributePattern_Variables();

		/**
		 * The meta object literal for the '<em><b>Is Variable</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ATTRIBUTE_PATTERN___IS_VARIABLE = eINSTANCE.getAttributePattern__IsVariable();

		/**
		 * The meta object literal for the '<em><b>Is Constant</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ATTRIBUTE_PATTERN___IS_CONSTANT = eINSTANCE.getAttributePattern__IsConstant();

		/**
		 * The meta object literal for the '<em><b>Is Expression</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ATTRIBUTE_PATTERN___IS_EXPRESSION = eINSTANCE.getAttributePattern__IsExpression();

		/**
		 * The meta object literal for the '{@link org.sidiff.graphpattern.impl.MatchingImpl <em>Matching</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.graphpattern.impl.MatchingImpl
		 * @see org.sidiff.graphpattern.impl.GraphpatternPackageImpl#getMatching()
		 * @generated
		 */
		EClass MATCHING = eINSTANCE.getMatching();

		/**
		 * The meta object literal for the '<em><b>Matches</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MATCHING__MATCHES = eINSTANCE.getMatching_Matches();

		/**
		 * The meta object literal for the '<em><b>Node</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MATCHING__NODE = eINSTANCE.getMatching_Node();

		/**
		 * The meta object literal for the '<em><b>Iterator</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MATCHING___ITERATOR = eINSTANCE.getMatching__Iterator();

		/**
		 * The meta object literal for the '<em><b>Size</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MATCHING___SIZE = eINSTANCE.getMatching__Size();

		/**
		 * The meta object literal for the '<em><b>Is Empty</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MATCHING___IS_EMPTY = eINSTANCE.getMatching__IsEmpty();

		/**
		 * The meta object literal for the '<em><b>Add</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MATCHING___ADD__EOBJECT = eINSTANCE.getMatching__Add__EObject();

		/**
		 * The meta object literal for the '<em><b>Remove</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MATCHING___REMOVE__EOBJECT = eINSTANCE.getMatching__Remove__EObject();

		/**
		 * The meta object literal for the '<em><b>Contains</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MATCHING___CONTAINS__EOBJECT = eINSTANCE.getMatching__Contains__EObject();

		/**
		 * The meta object literal for the '<em><b>Clear</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MATCHING___CLEAR = eINSTANCE.getMatching__Clear();

		/**
		 * The meta object literal for the '{@link org.sidiff.graphpattern.impl.BundleImpl <em>Bundle</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.graphpattern.impl.BundleImpl
		 * @see org.sidiff.graphpattern.impl.GraphpatternPackageImpl#getBundle()
		 * @generated
		 */
		EClass BUNDLE = eINSTANCE.getBundle();

		/**
		 * The meta object literal for the '<em><b>Profiles</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BUNDLE__PROFILES = eINSTANCE.getBundle_Profiles();

		/**
		 * The meta object literal for the '<em><b>Domains</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BUNDLE__DOMAINS = eINSTANCE.getBundle_Domains();

		/**
		 * The meta object literal for the '{@link org.sidiff.graphpattern.impl.EObjectListImpl <em>EObject List</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.graphpattern.impl.EObjectListImpl
		 * @see org.sidiff.graphpattern.impl.GraphpatternPackageImpl#getEObjectList()
		 * @generated
		 */
		EClass EOBJECT_LIST = eINSTANCE.getEObjectList();

		/**
		 * The meta object literal for the '<em><b>Content</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EOBJECT_LIST__CONTENT = eINSTANCE.getEObjectList_Content();

		/**
		 * The meta object literal for the '<em><b>Label</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EOBJECT_LIST__LABEL = eINSTANCE.getEObjectList_Label();

		/**
		 * The meta object literal for the '{@link org.sidiff.graphpattern.impl.DependencyGraphImpl <em>Dependency Graph</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.graphpattern.impl.DependencyGraphImpl
		 * @see org.sidiff.graphpattern.impl.GraphpatternPackageImpl#getDependencyGraph()
		 * @generated
		 */
		EClass DEPENDENCY_GRAPH = eINSTANCE.getDependencyGraph();

		/**
		 * The meta object literal for the '<em><b>Independent</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEPENDENCY_GRAPH__INDEPENDENT = eINSTANCE.getDependencyGraph_Independent();

		/**
		 * The meta object literal for the '<em><b>Graph</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEPENDENCY_GRAPH__GRAPH = eINSTANCE.getDependencyGraph_Graph();

		/**
		 * The meta object literal for the '<em><b>Nodes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEPENDENCY_GRAPH__NODES = eINSTANCE.getDependencyGraph_Nodes();

		/**
		 * The meta object literal for the '<em><b>Edges</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEPENDENCY_GRAPH__EDGES = eINSTANCE.getDependencyGraph_Edges();

		/**
		 * The meta object literal for the '{@link org.sidiff.graphpattern.impl.DependencyNodeImpl <em>Dependency Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.graphpattern.impl.DependencyNodeImpl
		 * @see org.sidiff.graphpattern.impl.GraphpatternPackageImpl#getDependencyNode()
		 * @generated
		 */
		EClass DEPENDENCY_NODE = eINSTANCE.getDependencyNode();

		/**
		 * The meta object literal for the '<em><b>Outgoings</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEPENDENCY_NODE__OUTGOINGS = eINSTANCE.getDependencyNode_Outgoings();

		/**
		 * The meta object literal for the '<em><b>Incomings</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEPENDENCY_NODE__INCOMINGS = eINSTANCE.getDependencyNode_Incomings();

		/**
		 * The meta object literal for the '<em><b>Nodes</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEPENDENCY_NODE__NODES = eINSTANCE.getDependencyNode_Nodes();

		/**
		 * The meta object literal for the '{@link org.sidiff.graphpattern.impl.DependencyEdgeImpl <em>Dependency Edge</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.graphpattern.impl.DependencyEdgeImpl
		 * @see org.sidiff.graphpattern.impl.GraphpatternPackageImpl#getDependencyEdge()
		 * @generated
		 */
		EClass DEPENDENCY_EDGE = eINSTANCE.getDependencyEdge();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEPENDENCY_EDGE__SOURCE = eINSTANCE.getDependencyEdge_Source();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEPENDENCY_EDGE__TARGET = eINSTANCE.getDependencyEdge_Target();

		/**
		 * The meta object literal for the '{@link org.sidiff.graphpattern.impl.AssociationImpl <em>Association</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.graphpattern.impl.AssociationImpl
		 * @see org.sidiff.graphpattern.impl.GraphpatternPackageImpl#getAssociation()
		 * @generated
		 */
		EClass ASSOCIATION = eINSTANCE.getAssociation();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSOCIATION__SOURCE = eINSTANCE.getAssociation_Source();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSOCIATION__TARGET = eINSTANCE.getAssociation_Target();

		/**
		 * The meta object literal for the '{@link org.sidiff.graphpattern.impl.StereotypeImpl <em>Stereotype</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.graphpattern.impl.StereotypeImpl
		 * @see org.sidiff.graphpattern.impl.GraphpatternPackageImpl#getStereotype()
		 * @generated
		 */
		EClass STEREOTYPE = eINSTANCE.getStereotype();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STEREOTYPE__NAME = eINSTANCE.getStereotype_Name();

		/**
		 * The meta object literal for the '<em><b>Profile</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STEREOTYPE__PROFILE = eINSTANCE.getStereotype_Profile();

		/**
		 * The meta object literal for the '{@link org.sidiff.graphpattern.impl.ParameterBindingImpl <em>Parameter Binding</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.graphpattern.impl.ParameterBindingImpl
		 * @see org.sidiff.graphpattern.impl.GraphpatternPackageImpl#getParameterBinding()
		 * @generated
		 */
		EClass PARAMETER_BINDING = eINSTANCE.getParameterBinding();

		/**
		 * The meta object literal for the '<em><b>Parameter</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARAMETER_BINDING__PARAMETER = eINSTANCE.getParameterBinding_Parameter();

		/**
		 * The meta object literal for the '{@link org.sidiff.graphpattern.impl.AssignmentImpl <em>Assignment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.graphpattern.impl.AssignmentImpl
		 * @see org.sidiff.graphpattern.impl.GraphpatternPackageImpl#getAssignment()
		 * @generated
		 */
		EClass ASSIGNMENT = eINSTANCE.getAssignment();

		/**
		 * The meta object literal for the '<em><b>Assignment</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSIGNMENT__ASSIGNMENT = eINSTANCE.getAssignment_Assignment();

		/**
		 * The meta object literal for the '<em><b>Pattern</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSIGNMENT__PATTERN = eINSTANCE.getAssignment_Pattern();

		/**
		 * The meta object literal for the '{@link org.sidiff.graphpattern.impl.ObjectBindingImpl <em>Object Binding</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.graphpattern.impl.ObjectBindingImpl
		 * @see org.sidiff.graphpattern.impl.GraphpatternPackageImpl#getObjectBinding()
		 * @generated
		 */
		EClass OBJECT_BINDING = eINSTANCE.getObjectBinding();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OBJECT_BINDING__VALUE = eINSTANCE.getObjectBinding_Value();

		/**
		 * The meta object literal for the '{@link org.sidiff.graphpattern.impl.ValueBindingImpl <em>Value Binding</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.graphpattern.impl.ValueBindingImpl
		 * @see org.sidiff.graphpattern.impl.GraphpatternPackageImpl#getValueBinding()
		 * @generated
		 */
		EClass VALUE_BINDING = eINSTANCE.getValueBinding();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VALUE_BINDING__VALUE = eINSTANCE.getValueBinding_Value();

		/**
		 * The meta object literal for the '{@link org.sidiff.graphpattern.impl.SubGraphImpl <em>Sub Graph</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.graphpattern.impl.SubGraphImpl
		 * @see org.sidiff.graphpattern.impl.GraphpatternPackageImpl#getSubGraph()
		 * @generated
		 */
		EClass SUB_GRAPH = eINSTANCE.getSubGraph();

		/**
		 * The meta object literal for the '<em><b>Elements</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SUB_GRAPH__ELEMENTS = eINSTANCE.getSubGraph_Elements();

		/**
		 * The meta object literal for the '<em><b>Subgraphs</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SUB_GRAPH__SUBGRAPHS = eINSTANCE.getSubGraph_Subgraphs();

		/**
		 * The meta object literal for the '{@link org.sidiff.graphpattern.impl.GraphElementImpl <em>Graph Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.graphpattern.impl.GraphElementImpl
		 * @see org.sidiff.graphpattern.impl.GraphpatternPackageImpl#getGraphElement()
		 * @generated
		 */
		EClass GRAPH_ELEMENT = eINSTANCE.getGraphElement();

		/**
		 * The meta object literal for the '<em><b>Subgraphs</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GRAPH_ELEMENT__SUBGRAPHS = eINSTANCE.getGraphElement_Subgraphs();

		/**
		 * The meta object literal for the '<em><b>Graph</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GRAPH_ELEMENT__GRAPH = eINSTANCE.getGraphElement_Graph();

		/**
		 * The meta object literal for the '{@link org.sidiff.graphpattern.impl.ProfileImpl <em>Profile</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.graphpattern.impl.ProfileImpl
		 * @see org.sidiff.graphpattern.impl.GraphpatternPackageImpl#getProfile()
		 * @generated
		 */
		EClass PROFILE = eINSTANCE.getProfile();

		/**
		 * The meta object literal for the '<em><b>Stereotypes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROFILE__STEREOTYPES = eINSTANCE.getProfile_Stereotypes();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROFILE__NAME = eINSTANCE.getProfile_Name();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROFILE__DESCRIPTION = eINSTANCE.getProfile_Description();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROFILE__ID = eINSTANCE.getProfile_Id();

		/**
		 * The meta object literal for the '<em><b>Get Stereotype</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation PROFILE___GET_STEREOTYPE__STRING = eINSTANCE.getProfile__GetStereotype__String();

		/**
		 * The meta object literal for the '{@link org.sidiff.graphpattern.Resource <em>Resource</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.graphpattern.Resource
		 * @see org.sidiff.graphpattern.impl.GraphpatternPackageImpl#getResource()
		 * @generated
		 */
		EClass RESOURCE = eINSTANCE.getResource();

		/**
		 * The meta object literal for the '<em><b>Contents</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESOURCE__CONTENTS = eINSTANCE.getResource_Contents();

		/**
		 * The meta object literal for the '{@link org.sidiff.graphpattern.Extendable <em>Extendable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.graphpattern.Extendable
		 * @see org.sidiff.graphpattern.impl.GraphpatternPackageImpl#getExtendable()
		 * @generated
		 */
		EClass EXTENDABLE = eINSTANCE.getExtendable();

		/**
		 * The meta object literal for the '<em><b>Stereotypes</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXTENDABLE__STEREOTYPES = eINSTANCE.getExtendable_Stereotypes();

		/**
		 * The meta object literal for the '{@link org.sidiff.graphpattern.impl.PatternImpl <em>Pattern</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.graphpattern.impl.PatternImpl
		 * @see org.sidiff.graphpattern.impl.GraphpatternPackageImpl#getPattern()
		 * @generated
		 */
		EClass PATTERN = eINSTANCE.getPattern();

		/**
		 * The meta object literal for the '<em><b>Graphs</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PATTERN__GRAPHS = eINSTANCE.getPattern_Graphs();

		/**
		 * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PATTERN__PARAMETERS = eINSTANCE.getPattern_Parameters();

		/**
		 * The meta object literal for the '<em><b>Assignments</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PATTERN__ASSIGNMENTS = eINSTANCE.getPattern_Assignments();

		/**
		 * The meta object literal for the '<em><b>Bundle</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PATTERN__BUNDLE = eINSTANCE.getPattern_Bundle();

		/**
		 * The meta object literal for the '<em><b>Patterns</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PATTERN__PATTERNS = eINSTANCE.getPattern_Patterns();

		/**
		 * The meta object literal for the '<em><b>Get Pattern</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation PATTERN___GET_PATTERN__STRING = eINSTANCE.getPattern__GetPattern__String();

		/**
		 * The meta object literal for the '<em><b>Get All Graph Patterns</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation PATTERN___GET_ALL_GRAPH_PATTERNS = eINSTANCE.getPattern__GetAllGraphPatterns();

		/**
		 * The meta object literal for the '<em><b>Get Graph</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation PATTERN___GET_GRAPH__STRING = eINSTANCE.getPattern__GetGraph__String();

		/**
		 * The meta object literal for the '<em><b>Get Parameter</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation PATTERN___GET_PARAMETER__STRING = eINSTANCE.getPattern__GetParameter__String();

		/**
		 * The meta object literal for the '{@link org.sidiff.graphpattern.impl.PatternElementImpl <em>Pattern Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.graphpattern.impl.PatternElementImpl
		 * @see org.sidiff.graphpattern.impl.GraphpatternPackageImpl#getPatternElement()
		 * @generated
		 */
		EClass PATTERN_ELEMENT = eINSTANCE.getPatternElement();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PATTERN_ELEMENT__NAME = eINSTANCE.getPatternElement_Name();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PATTERN_ELEMENT__DESCRIPTION = eINSTANCE.getPatternElement_Description();

		/**
		 * The meta object literal for the '{@link org.sidiff.graphpattern.impl.ParameterImpl <em>Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.graphpattern.impl.ParameterImpl
		 * @see org.sidiff.graphpattern.impl.GraphpatternPackageImpl#getParameter()
		 * @generated
		 */
		EClass PARAMETER = eINSTANCE.getParameter();

		/**
		 * The meta object literal for the '<em><b>Pattern</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARAMETER__PATTERN = eINSTANCE.getParameter_Pattern();

		/**
		 * The meta object literal for the '<em>EIterator</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.util.Iterator
		 * @see org.sidiff.graphpattern.impl.GraphpatternPackageImpl#getEIterator()
		 * @generated
		 */
		EDataType EITERATOR = eINSTANCE.getEIterator();

	}

} //GraphpatternPackage
