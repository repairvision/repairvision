/**
 */
package org.sidiff.graphpattern.profile.henshin_extension;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.henshin.model.HenshinPackage;
import org.sidiff.graphpattern.GraphpatternPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.sidiff.graphpattern.profile.henshin_extension.HenshinExtensionFactory
 * @model kind="package"
 * @generated
 */
public interface HenshinExtensionPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "henshin_extension";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/emf/2011/Henshin/Extension";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "henshin_extension";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	HenshinExtensionPackage eINSTANCE = org.sidiff.graphpattern.profile.henshin_extension.impl.HenshinExtensionPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.sidiff.graphpattern.profile.henshin_extension.impl.RuleExtensionImpl <em>Rule Extension</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.graphpattern.profile.henshin_extension.impl.RuleExtensionImpl
	 * @see org.sidiff.graphpattern.profile.henshin_extension.impl.HenshinExtensionPackageImpl#getRuleExtension()
	 * @generated
	 */
	int RULE_EXTENSION = 0;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_EXTENSION__ANNOTATIONS = HenshinPackage.RULE__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_EXTENSION__NAME = HenshinPackage.RULE__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_EXTENSION__DESCRIPTION = HenshinPackage.RULE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_EXTENSION__PARAMETERS = HenshinPackage.RULE__PARAMETERS;

	/**
	 * The feature id for the '<em><b>Parameter Mappings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_EXTENSION__PARAMETER_MAPPINGS = HenshinPackage.RULE__PARAMETER_MAPPINGS;

	/**
	 * The feature id for the '<em><b>Activated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_EXTENSION__ACTIVATED = HenshinPackage.RULE__ACTIVATED;

	/**
	 * The feature id for the '<em><b>Lhs</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_EXTENSION__LHS = HenshinPackage.RULE__LHS;

	/**
	 * The feature id for the '<em><b>Rhs</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_EXTENSION__RHS = HenshinPackage.RULE__RHS;

	/**
	 * The feature id for the '<em><b>Attribute Conditions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_EXTENSION__ATTRIBUTE_CONDITIONS = HenshinPackage.RULE__ATTRIBUTE_CONDITIONS;

	/**
	 * The feature id for the '<em><b>Mappings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_EXTENSION__MAPPINGS = HenshinPackage.RULE__MAPPINGS;

	/**
	 * The feature id for the '<em><b>Check Dangling</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_EXTENSION__CHECK_DANGLING = HenshinPackage.RULE__CHECK_DANGLING;

	/**
	 * The feature id for the '<em><b>Injective Matching</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_EXTENSION__INJECTIVE_MATCHING = HenshinPackage.RULE__INJECTIVE_MATCHING;

	/**
	 * The feature id for the '<em><b>Multi Rules</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_EXTENSION__MULTI_RULES = HenshinPackage.RULE__MULTI_RULES;

	/**
	 * The feature id for the '<em><b>Multi Mappings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_EXTENSION__MULTI_MAPPINGS = HenshinPackage.RULE__MULTI_MAPPINGS;

	/**
	 * The feature id for the '<em><b>Java Imports</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_EXTENSION__JAVA_IMPORTS = HenshinPackage.RULE__JAVA_IMPORTS;

	/**
	 * The feature id for the '<em><b>Subgraphs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_EXTENSION__SUBGRAPHS = HenshinPackage.RULE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Rule Extension</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_EXTENSION_FEATURE_COUNT = HenshinPackage.RULE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.sidiff.graphpattern.profile.henshin_extension.impl.SubGraphImpl <em>Sub Graph</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.graphpattern.profile.henshin_extension.impl.SubGraphImpl
	 * @see org.sidiff.graphpattern.profile.henshin_extension.impl.HenshinExtensionPackageImpl#getSubGraph()
	 * @generated
	 */
	int SUB_GRAPH = 1;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_GRAPH__STEREOTYPES = GraphpatternPackage.PATTERN_ELEMENT__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_GRAPH__NAME = GraphpatternPackage.PATTERN_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_GRAPH__DESCRIPTION = GraphpatternPackage.PATTERN_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Subgraphs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_GRAPH__SUBGRAPHS = GraphpatternPackage.PATTERN_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_GRAPH__ELEMENTS = GraphpatternPackage.PATTERN_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Sub Graph</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_GRAPH_FEATURE_COUNT = GraphpatternPackage.PATTERN_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.sidiff.graphpattern.profile.henshin_extension.GraphElementExtension <em>Graph Element Extension</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.graphpattern.profile.henshin_extension.GraphElementExtension
	 * @see org.sidiff.graphpattern.profile.henshin_extension.impl.HenshinExtensionPackageImpl#getGraphElementExtension()
	 * @generated
	 */
	int GRAPH_ELEMENT_EXTENSION = 2;

	/**
	 * The feature id for the '<em><b>Subgraphs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPH_ELEMENT_EXTENSION__SUBGRAPHS = 0;

	/**
	 * The number of structural features of the '<em>Graph Element Extension</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPH_ELEMENT_EXTENSION_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.sidiff.graphpattern.profile.henshin_extension.impl.NodeExtensionImpl <em>Node Extension</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.graphpattern.profile.henshin_extension.impl.NodeExtensionImpl
	 * @see org.sidiff.graphpattern.profile.henshin_extension.impl.HenshinExtensionPackageImpl#getNodeExtension()
	 * @generated
	 */
	int NODE_EXTENSION = 3;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_EXTENSION__ANNOTATIONS = HenshinPackage.NODE__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_EXTENSION__NAME = HenshinPackage.NODE__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_EXTENSION__DESCRIPTION = HenshinPackage.NODE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Action</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_EXTENSION__ACTION = HenshinPackage.NODE__ACTION;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_EXTENSION__TYPE = HenshinPackage.NODE__TYPE;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_EXTENSION__ATTRIBUTES = HenshinPackage.NODE__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Graph</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_EXTENSION__GRAPH = HenshinPackage.NODE__GRAPH;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_EXTENSION__INCOMING = HenshinPackage.NODE__INCOMING;

	/**
	 * The feature id for the '<em><b>Outgoing</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_EXTENSION__OUTGOING = HenshinPackage.NODE__OUTGOING;

	/**
	 * The feature id for the '<em><b>Subgraphs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_EXTENSION__SUBGRAPHS = HenshinPackage.NODE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Node Extension</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_EXTENSION_FEATURE_COUNT = HenshinPackage.NODE_FEATURE_COUNT + 1;


	/**
	 * The meta object id for the '{@link org.sidiff.graphpattern.profile.henshin_extension.impl.EdgeExtensionImpl <em>Edge Extension</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.graphpattern.profile.henshin_extension.impl.EdgeExtensionImpl
	 * @see org.sidiff.graphpattern.profile.henshin_extension.impl.HenshinExtensionPackageImpl#getEdgeExtension()
	 * @generated
	 */
	int EDGE_EXTENSION = 4;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_EXTENSION__ANNOTATIONS = HenshinPackage.EDGE__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Action</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_EXTENSION__ACTION = HenshinPackage.EDGE__ACTION;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_EXTENSION__SOURCE = HenshinPackage.EDGE__SOURCE;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_EXTENSION__TARGET = HenshinPackage.EDGE__TARGET;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_EXTENSION__TYPE = HenshinPackage.EDGE__TYPE;

	/**
	 * The feature id for the '<em><b>Graph</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_EXTENSION__GRAPH = HenshinPackage.EDGE__GRAPH;

	/**
	 * The feature id for the '<em><b>Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_EXTENSION__INDEX = HenshinPackage.EDGE__INDEX;

	/**
	 * The feature id for the '<em><b>Index Constant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_EXTENSION__INDEX_CONSTANT = HenshinPackage.EDGE__INDEX_CONSTANT;

	/**
	 * The feature id for the '<em><b>Subgraphs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_EXTENSION__SUBGRAPHS = HenshinPackage.EDGE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Edge Extension</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_EXTENSION_FEATURE_COUNT = HenshinPackage.EDGE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.sidiff.graphpattern.profile.henshin_extension.impl.AttributeExtensionImpl <em>Attribute Extension</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.graphpattern.profile.henshin_extension.impl.AttributeExtensionImpl
	 * @see org.sidiff.graphpattern.profile.henshin_extension.impl.HenshinExtensionPackageImpl#getAttributeExtension()
	 * @generated
	 */
	int ATTRIBUTE_EXTENSION = 5;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_EXTENSION__ANNOTATIONS = HenshinPackage.ATTRIBUTE__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Action</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_EXTENSION__ACTION = HenshinPackage.ATTRIBUTE__ACTION;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_EXTENSION__TYPE = HenshinPackage.ATTRIBUTE__TYPE;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_EXTENSION__VALUE = HenshinPackage.ATTRIBUTE__VALUE;

	/**
	 * The feature id for the '<em><b>Node</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_EXTENSION__NODE = HenshinPackage.ATTRIBUTE__NODE;

	/**
	 * The feature id for the '<em><b>Constant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_EXTENSION__CONSTANT = HenshinPackage.ATTRIBUTE__CONSTANT;

	/**
	 * The feature id for the '<em><b>Null</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_EXTENSION__NULL = HenshinPackage.ATTRIBUTE__NULL;

	/**
	 * The feature id for the '<em><b>Subgraphs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_EXTENSION__SUBGRAPHS = HenshinPackage.ATTRIBUTE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Attribute Extension</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_EXTENSION_FEATURE_COUNT = HenshinPackage.ATTRIBUTE_FEATURE_COUNT + 1;


	/**
	 * Returns the meta object for class '{@link org.sidiff.graphpattern.profile.henshin_extension.RuleExtension <em>Rule Extension</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Rule Extension</em>'.
	 * @see org.sidiff.graphpattern.profile.henshin_extension.RuleExtension
	 * @generated
	 */
	EClass getRuleExtension();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sidiff.graphpattern.profile.henshin_extension.RuleExtension#getSubgraphs <em>Subgraphs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Subgraphs</em>'.
	 * @see org.sidiff.graphpattern.profile.henshin_extension.RuleExtension#getSubgraphs()
	 * @see #getRuleExtension()
	 * @generated
	 */
	EReference getRuleExtension_Subgraphs();

	/**
	 * Returns the meta object for class '{@link org.sidiff.graphpattern.profile.henshin_extension.SubGraph <em>Sub Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sub Graph</em>'.
	 * @see org.sidiff.graphpattern.profile.henshin_extension.SubGraph
	 * @generated
	 */
	EClass getSubGraph();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sidiff.graphpattern.profile.henshin_extension.SubGraph#getSubgraphs <em>Subgraphs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Subgraphs</em>'.
	 * @see org.sidiff.graphpattern.profile.henshin_extension.SubGraph#getSubgraphs()
	 * @see #getSubGraph()
	 * @generated
	 */
	EReference getSubGraph_Subgraphs();

	/**
	 * Returns the meta object for the reference list '{@link org.sidiff.graphpattern.profile.henshin_extension.SubGraph#getElements <em>Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Elements</em>'.
	 * @see org.sidiff.graphpattern.profile.henshin_extension.SubGraph#getElements()
	 * @see #getSubGraph()
	 * @generated
	 */
	EReference getSubGraph_Elements();

	/**
	 * Returns the meta object for class '{@link org.sidiff.graphpattern.profile.henshin_extension.GraphElementExtension <em>Graph Element Extension</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Graph Element Extension</em>'.
	 * @see org.sidiff.graphpattern.profile.henshin_extension.GraphElementExtension
	 * @generated
	 */
	EClass getGraphElementExtension();

	/**
	 * Returns the meta object for the reference list '{@link org.sidiff.graphpattern.profile.henshin_extension.GraphElementExtension#getSubgraphs <em>Subgraphs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Subgraphs</em>'.
	 * @see org.sidiff.graphpattern.profile.henshin_extension.GraphElementExtension#getSubgraphs()
	 * @see #getGraphElementExtension()
	 * @generated
	 */
	EReference getGraphElementExtension_Subgraphs();

	/**
	 * Returns the meta object for class '{@link org.sidiff.graphpattern.profile.henshin_extension.NodeExtension <em>Node Extension</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Node Extension</em>'.
	 * @see org.sidiff.graphpattern.profile.henshin_extension.NodeExtension
	 * @generated
	 */
	EClass getNodeExtension();

	/**
	 * Returns the meta object for class '{@link org.sidiff.graphpattern.profile.henshin_extension.EdgeExtension <em>Edge Extension</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Edge Extension</em>'.
	 * @see org.sidiff.graphpattern.profile.henshin_extension.EdgeExtension
	 * @generated
	 */
	EClass getEdgeExtension();

	/**
	 * Returns the meta object for class '{@link org.sidiff.graphpattern.profile.henshin_extension.AttributeExtension <em>Attribute Extension</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Attribute Extension</em>'.
	 * @see org.sidiff.graphpattern.profile.henshin_extension.AttributeExtension
	 * @generated
	 */
	EClass getAttributeExtension();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	HenshinExtensionFactory getHenshinExtensionFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.sidiff.graphpattern.profile.henshin_extension.impl.RuleExtensionImpl <em>Rule Extension</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.graphpattern.profile.henshin_extension.impl.RuleExtensionImpl
		 * @see org.sidiff.graphpattern.profile.henshin_extension.impl.HenshinExtensionPackageImpl#getRuleExtension()
		 * @generated
		 */
		EClass RULE_EXTENSION = eINSTANCE.getRuleExtension();

		/**
		 * The meta object literal for the '<em><b>Subgraphs</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RULE_EXTENSION__SUBGRAPHS = eINSTANCE.getRuleExtension_Subgraphs();

		/**
		 * The meta object literal for the '{@link org.sidiff.graphpattern.profile.henshin_extension.impl.SubGraphImpl <em>Sub Graph</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.graphpattern.profile.henshin_extension.impl.SubGraphImpl
		 * @see org.sidiff.graphpattern.profile.henshin_extension.impl.HenshinExtensionPackageImpl#getSubGraph()
		 * @generated
		 */
		EClass SUB_GRAPH = eINSTANCE.getSubGraph();

		/**
		 * The meta object literal for the '<em><b>Subgraphs</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SUB_GRAPH__SUBGRAPHS = eINSTANCE.getSubGraph_Subgraphs();

		/**
		 * The meta object literal for the '<em><b>Elements</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SUB_GRAPH__ELEMENTS = eINSTANCE.getSubGraph_Elements();

		/**
		 * The meta object literal for the '{@link org.sidiff.graphpattern.profile.henshin_extension.GraphElementExtension <em>Graph Element Extension</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.graphpattern.profile.henshin_extension.GraphElementExtension
		 * @see org.sidiff.graphpattern.profile.henshin_extension.impl.HenshinExtensionPackageImpl#getGraphElementExtension()
		 * @generated
		 */
		EClass GRAPH_ELEMENT_EXTENSION = eINSTANCE.getGraphElementExtension();

		/**
		 * The meta object literal for the '<em><b>Subgraphs</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GRAPH_ELEMENT_EXTENSION__SUBGRAPHS = eINSTANCE.getGraphElementExtension_Subgraphs();

		/**
		 * The meta object literal for the '{@link org.sidiff.graphpattern.profile.henshin_extension.impl.NodeExtensionImpl <em>Node Extension</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.graphpattern.profile.henshin_extension.impl.NodeExtensionImpl
		 * @see org.sidiff.graphpattern.profile.henshin_extension.impl.HenshinExtensionPackageImpl#getNodeExtension()
		 * @generated
		 */
		EClass NODE_EXTENSION = eINSTANCE.getNodeExtension();

		/**
		 * The meta object literal for the '{@link org.sidiff.graphpattern.profile.henshin_extension.impl.EdgeExtensionImpl <em>Edge Extension</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.graphpattern.profile.henshin_extension.impl.EdgeExtensionImpl
		 * @see org.sidiff.graphpattern.profile.henshin_extension.impl.HenshinExtensionPackageImpl#getEdgeExtension()
		 * @generated
		 */
		EClass EDGE_EXTENSION = eINSTANCE.getEdgeExtension();

		/**
		 * The meta object literal for the '{@link org.sidiff.graphpattern.profile.henshin_extension.impl.AttributeExtensionImpl <em>Attribute Extension</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.graphpattern.profile.henshin_extension.impl.AttributeExtensionImpl
		 * @see org.sidiff.graphpattern.profile.henshin_extension.impl.HenshinExtensionPackageImpl#getAttributeExtension()
		 * @generated
		 */
		EClass ATTRIBUTE_EXTENSION = eINSTANCE.getAttributeExtension();

	}

} //HenshinExtensionPackage
