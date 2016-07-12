/**
 */
package org.sidiff.consistency.graphpattern;

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
 * @see org.sidiff.consistency.graphpattern.GraphpatternFactory
 * @model kind="package"
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
	String eNS_URI = "http://www.sidiff.org/consistency/graphpattern/1.0";

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
	GraphpatternPackage eINSTANCE = org.sidiff.consistency.graphpattern.impl.GraphpatternPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.sidiff.consistency.graphpattern.impl.GraphPatternElementImpl <em>Graph Pattern Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.consistency.graphpattern.impl.GraphPatternElementImpl
	 * @see org.sidiff.consistency.graphpattern.impl.GraphpatternPackageImpl#getGraphPatternElement()
	 * @generated
	 */
	int GRAPH_PATTERN_ELEMENT = 20;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPH_PATTERN_ELEMENT__NAME = 0;

	/**
	 * The feature id for the '<em><b>Formulas</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPH_PATTERN_ELEMENT__FORMULAS = 1;

	/**
	 * The feature id for the '<em><b>Quantifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPH_PATTERN_ELEMENT__QUANTIFIER = 2;

	/**
	 * The number of structural features of the '<em>Graph Pattern Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPH_PATTERN_ELEMENT_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Graph Pattern Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPH_PATTERN_ELEMENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.sidiff.consistency.graphpattern.impl.GraphPatternImpl <em>Graph Pattern</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.consistency.graphpattern.impl.GraphPatternImpl
	 * @see org.sidiff.consistency.graphpattern.impl.GraphpatternPackageImpl#getGraphPattern()
	 * @generated
	 */
	int GRAPH_PATTERN = 0;

	/**
	 * The meta object id for the '{@link org.sidiff.consistency.graphpattern.impl.NodePatternImpl <em>Node Pattern</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.consistency.graphpattern.impl.NodePatternImpl
	 * @see org.sidiff.consistency.graphpattern.impl.GraphpatternPackageImpl#getNodePattern()
	 * @generated
	 */
	int NODE_PATTERN = 1;

	/**
	 * The meta object id for the '{@link org.sidiff.consistency.graphpattern.impl.EdgePatternImpl <em>Edge Pattern</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.consistency.graphpattern.impl.EdgePatternImpl
	 * @see org.sidiff.consistency.graphpattern.impl.GraphpatternPackageImpl#getEdgePattern()
	 * @generated
	 */
	int EDGE_PATTERN = 2;

	/**
	 * The meta object id for the '{@link org.sidiff.consistency.graphpattern.impl.AttributePatternImpl <em>Attribute Pattern</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.consistency.graphpattern.impl.AttributePatternImpl
	 * @see org.sidiff.consistency.graphpattern.impl.GraphpatternPackageImpl#getAttributePattern()
	 * @generated
	 */
	int ATTRIBUTE_PATTERN = 3;

	/**
	 * The meta object id for the '{@link org.sidiff.consistency.graphpattern.impl.EvaluationImpl <em>Evaluation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.consistency.graphpattern.impl.EvaluationImpl
	 * @see org.sidiff.consistency.graphpattern.impl.GraphpatternPackageImpl#getEvaluation()
	 * @generated
	 */
	int EVALUATION = 4;

	/**
	 * The meta object id for the '{@link org.sidiff.consistency.graphpattern.impl.VisitorImpl <em>Visitor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.consistency.graphpattern.impl.VisitorImpl
	 * @see org.sidiff.consistency.graphpattern.impl.GraphpatternPackageImpl#getVisitor()
	 * @generated
	 */
	int VISITOR = 5;

	/**
	 * The meta object id for the '{@link org.sidiff.consistency.graphpattern.impl.DataStoreImpl <em>Data Store</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.consistency.graphpattern.impl.DataStoreImpl
	 * @see org.sidiff.consistency.graphpattern.impl.GraphpatternPackageImpl#getDataStore()
	 * @generated
	 */
	int DATA_STORE = 6;

	/**
	 * The meta object id for the '{@link org.sidiff.consistency.graphpattern.impl.NavigableDataStoreImpl <em>Navigable Data Store</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.consistency.graphpattern.impl.NavigableDataStoreImpl
	 * @see org.sidiff.consistency.graphpattern.impl.GraphpatternPackageImpl#getNavigableDataStore()
	 * @generated
	 */
	int NAVIGABLE_DATA_STORE = 7;

	/**
	 * The meta object id for the '{@link org.sidiff.consistency.graphpattern.Formula <em>Formula</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.consistency.graphpattern.Formula
	 * @see org.sidiff.consistency.graphpattern.impl.GraphpatternPackageImpl#getFormula()
	 * @generated
	 */
	int FORMULA = 10;

	/**
	 * The meta object id for the '{@link org.sidiff.consistency.graphpattern.impl.UnaryFormulaImpl <em>Unary Formula</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.consistency.graphpattern.impl.UnaryFormulaImpl
	 * @see org.sidiff.consistency.graphpattern.impl.GraphpatternPackageImpl#getUnaryFormula()
	 * @generated
	 */
	int UNARY_FORMULA = 8;

	/**
	 * The meta object id for the '{@link org.sidiff.consistency.graphpattern.impl.RuleBaseImpl <em>Rule Base</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.consistency.graphpattern.impl.RuleBaseImpl
	 * @see org.sidiff.consistency.graphpattern.impl.GraphpatternPackageImpl#getRuleBase()
	 * @generated
	 */
	int RULE_BASE = 9;

	/**
	 * The meta object id for the '{@link org.sidiff.consistency.graphpattern.impl.BinaryFormulaImpl <em>Binary Formula</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.consistency.graphpattern.impl.BinaryFormulaImpl
	 * @see org.sidiff.consistency.graphpattern.impl.GraphpatternPackageImpl#getBinaryFormula()
	 * @generated
	 */
	int BINARY_FORMULA = 11;

	/**
	 * The meta object id for the '{@link org.sidiff.consistency.graphpattern.impl.AndImpl <em>And</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.consistency.graphpattern.impl.AndImpl
	 * @see org.sidiff.consistency.graphpattern.impl.GraphpatternPackageImpl#getAnd()
	 * @generated
	 */
	int AND = 12;

	/**
	 * The meta object id for the '{@link org.sidiff.consistency.graphpattern.impl.OrImpl <em>Or</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.consistency.graphpattern.impl.OrImpl
	 * @see org.sidiff.consistency.graphpattern.impl.GraphpatternPackageImpl#getOr()
	 * @generated
	 */
	int OR = 13;

	/**
	 * The meta object id for the '{@link org.sidiff.consistency.graphpattern.impl.IffImpl <em>Iff</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.consistency.graphpattern.impl.IffImpl
	 * @see org.sidiff.consistency.graphpattern.impl.GraphpatternPackageImpl#getIff()
	 * @generated
	 */
	int IFF = 14;

	/**
	 * The meta object id for the '{@link org.sidiff.consistency.graphpattern.impl.IfImpl <em>If</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.consistency.graphpattern.impl.IfImpl
	 * @see org.sidiff.consistency.graphpattern.impl.GraphpatternPackageImpl#getIf()
	 * @generated
	 */
	int IF = 15;

	/**
	 * The meta object id for the '{@link org.sidiff.consistency.graphpattern.impl.NotImpl <em>Not</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.consistency.graphpattern.impl.NotImpl
	 * @see org.sidiff.consistency.graphpattern.impl.GraphpatternPackageImpl#getNot()
	 * @generated
	 */
	int NOT = 16;

	/**
	 * The meta object id for the '{@link org.sidiff.consistency.graphpattern.Quantifier <em>Quantifier</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.consistency.graphpattern.Quantifier
	 * @see org.sidiff.consistency.graphpattern.impl.GraphpatternPackageImpl#getQuantifier()
	 * @generated
	 */
	int QUANTIFIER = 17;

	/**
	 * The meta object id for the '{@link org.sidiff.consistency.graphpattern.impl.ForAllImpl <em>For All</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.consistency.graphpattern.impl.ForAllImpl
	 * @see org.sidiff.consistency.graphpattern.impl.GraphpatternPackageImpl#getForAll()
	 * @generated
	 */
	int FOR_ALL = 22;

	/**
	 * The meta object id for the '{@link org.sidiff.consistency.graphpattern.impl.ExistsImpl <em>Exists</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.consistency.graphpattern.impl.ExistsImpl
	 * @see org.sidiff.consistency.graphpattern.impl.GraphpatternPackageImpl#getExists()
	 * @generated
	 */
	int EXISTS = 23;

	/**
	 * The meta object id for the '{@link org.sidiff.consistency.graphpattern.impl.XorImpl <em>Xor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.consistency.graphpattern.impl.XorImpl
	 * @see org.sidiff.consistency.graphpattern.impl.GraphpatternPackageImpl#getXor()
	 * @generated
	 */
	int XOR = 18;

	/**
	 * The meta object id for the '{@link org.sidiff.consistency.graphpattern.impl.PatternImpl <em>Pattern</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.consistency.graphpattern.impl.PatternImpl
	 * @see org.sidiff.consistency.graphpattern.impl.GraphpatternPackageImpl#getPattern()
	 * @generated
	 */
	int PATTERN = 19;

	/**
	 * The meta object id for the '{@link org.sidiff.consistency.graphpattern.impl.ParameterImpl <em>Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.consistency.graphpattern.impl.ParameterImpl
	 * @see org.sidiff.consistency.graphpattern.impl.GraphpatternPackageImpl#getParameter()
	 * @generated
	 */
	int PARAMETER = 21;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPH_PATTERN__NAME = GRAPH_PATTERN_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Formulas</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPH_PATTERN__FORMULAS = GRAPH_PATTERN_ELEMENT__FORMULAS;

	/**
	 * The feature id for the '<em><b>Quantifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPH_PATTERN__QUANTIFIER = GRAPH_PATTERN_ELEMENT__QUANTIFIER;

	/**
	 * The feature id for the '<em><b>Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPH_PATTERN__NODES = GRAPH_PATTERN_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Pattern</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPH_PATTERN__PATTERN = GRAPH_PATTERN_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Multi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPH_PATTERN__MULTI = GRAPH_PATTERN_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Graph Pattern</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPH_PATTERN_FEATURE_COUNT = GRAPH_PATTERN_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Graph Pattern</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPH_PATTERN_OPERATION_COUNT = GRAPH_PATTERN_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_PATTERN__NAME = GRAPH_PATTERN_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Formulas</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_PATTERN__FORMULAS = GRAPH_PATTERN_ELEMENT__FORMULAS;

	/**
	 * The feature id for the '<em><b>Quantifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_PATTERN__QUANTIFIER = GRAPH_PATTERN_ELEMENT__QUANTIFIER;

	/**
	 * The feature id for the '<em><b>Outgoings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_PATTERN__OUTGOINGS = GRAPH_PATTERN_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_PATTERN__TYPE = GRAPH_PATTERN_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_PATTERN__ATTRIBUTES = GRAPH_PATTERN_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Evaluation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_PATTERN__EVALUATION = GRAPH_PATTERN_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Graph</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_PATTERN__GRAPH = GRAPH_PATTERN_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Incomings</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_PATTERN__INCOMINGS = GRAPH_PATTERN_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Node Pattern</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_PATTERN_FEATURE_COUNT = GRAPH_PATTERN_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The operation id for the '<em>Get Attribute</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_PATTERN___GET_ATTRIBUTE__EATTRIBUTE = GRAPH_PATTERN_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Outgoing</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_PATTERN___GET_OUTGOING__EREFERENCE = GRAPH_PATTERN_ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Outgoings</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_PATTERN___GET_OUTGOINGS__EREFERENCE = GRAPH_PATTERN_ELEMENT_OPERATION_COUNT + 2;

	/**
	 * The operation id for the '<em>Get Incoming</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_PATTERN___GET_INCOMING__EREFERENCE = GRAPH_PATTERN_ELEMENT_OPERATION_COUNT + 3;

	/**
	 * The operation id for the '<em>Get Incomings</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_PATTERN___GET_INCOMINGS__EREFERENCE = GRAPH_PATTERN_ELEMENT_OPERATION_COUNT + 4;

	/**
	 * The number of operations of the '<em>Node Pattern</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_PATTERN_OPERATION_COUNT = GRAPH_PATTERN_ELEMENT_OPERATION_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_PATTERN__NAME = GRAPH_PATTERN_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Formulas</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_PATTERN__FORMULAS = GRAPH_PATTERN_ELEMENT__FORMULAS;

	/**
	 * The feature id for the '<em><b>Quantifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_PATTERN__QUANTIFIER = GRAPH_PATTERN_ELEMENT__QUANTIFIER;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_PATTERN__TARGET = GRAPH_PATTERN_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Source</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_PATTERN__SOURCE = GRAPH_PATTERN_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Opposite</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_PATTERN__OPPOSITE = GRAPH_PATTERN_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_PATTERN__TYPE = GRAPH_PATTERN_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Cross Reference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_PATTERN__CROSS_REFERENCE = GRAPH_PATTERN_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Edge Pattern</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_PATTERN_FEATURE_COUNT = GRAPH_PATTERN_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The number of operations of the '<em>Edge Pattern</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_PATTERN_OPERATION_COUNT = GRAPH_PATTERN_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_PATTERN__VALUE = 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_PATTERN__TYPE = 1;

	/**
	 * The feature id for the '<em><b>Node</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_PATTERN__NODE = 2;

	/**
	 * The number of structural features of the '<em>Attribute Pattern</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_PATTERN_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Attribute Pattern</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_PATTERN_OPERATION_COUNT = 0;

	/**
	 * The feature id for the '<em><b>Node</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVALUATION__NODE = 0;

	/**
	 * The feature id for the '<em><b>Matches</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVALUATION__MATCHES = 1;

	/**
	 * The feature id for the '<em><b>Store</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVALUATION__STORE = 2;

	/**
	 * The number of structural features of the '<em>Evaluation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVALUATION_FEATURE_COUNT = 3;

	/**
	 * The operation id for the '<em>Initialize</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVALUATION___INITIALIZE = 0;

	/**
	 * The operation id for the '<em>Accept</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVALUATION___ACCEPT__VISITOR = 1;

	/**
	 * The number of operations of the '<em>Evaluation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVALUATION_OPERATION_COUNT = 2;

	/**
	 * The number of structural features of the '<em>Visitor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VISITOR_FEATURE_COUNT = 0;

	/**
	 * The operation id for the '<em>Visit</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VISITOR___VISIT__EVALUATION = 0;

	/**
	 * The number of operations of the '<em>Visitor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VISITOR_OPERATION_COUNT = 1;

	/**
	 * The feature id for the '<em><b>Evaluation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_STORE__EVALUATION = 0;

	/**
	 * The number of structural features of the '<em>Data Store</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_STORE_FEATURE_COUNT = 1;

	/**
	 * The operation id for the '<em>Initialize</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_STORE___INITIALIZE = 0;

	/**
	 * The operation id for the '<em>Get Match Iterator</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_STORE___GET_MATCH_ITERATOR = 1;

	/**
	 * The operation id for the '<em>Get Match Size</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_STORE___GET_MATCH_SIZE = 2;

	/**
	 * The operation id for the '<em>Is Empty Match</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_STORE___IS_EMPTY_MATCH = 3;

	/**
	 * The operation id for the '<em>Add Match</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_STORE___ADD_MATCH__EOBJECT = 4;

	/**
	 * The operation id for the '<em>Remove Match</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_STORE___REMOVE_MATCH__EOBJECT = 5;

	/**
	 * The operation id for the '<em>Contains Match</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_STORE___CONTAINS_MATCH__EOBJECT = 6;

	/**
	 * The operation id for the '<em>Clear Matches</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_STORE___CLEAR_MATCHES = 7;

	/**
	 * The number of operations of the '<em>Data Store</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_STORE_OPERATION_COUNT = 8;

	/**
	 * The feature id for the '<em><b>Evaluation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGABLE_DATA_STORE__EVALUATION = DATA_STORE__EVALUATION;

	/**
	 * The number of structural features of the '<em>Navigable Data Store</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGABLE_DATA_STORE_FEATURE_COUNT = DATA_STORE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Initialize</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGABLE_DATA_STORE___INITIALIZE = DATA_STORE___INITIALIZE;

	/**
	 * The operation id for the '<em>Get Match Iterator</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGABLE_DATA_STORE___GET_MATCH_ITERATOR = DATA_STORE___GET_MATCH_ITERATOR;

	/**
	 * The operation id for the '<em>Get Match Size</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGABLE_DATA_STORE___GET_MATCH_SIZE = DATA_STORE___GET_MATCH_SIZE;

	/**
	 * The operation id for the '<em>Is Empty Match</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGABLE_DATA_STORE___IS_EMPTY_MATCH = DATA_STORE___IS_EMPTY_MATCH;

	/**
	 * The operation id for the '<em>Add Match</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGABLE_DATA_STORE___ADD_MATCH__EOBJECT = DATA_STORE___ADD_MATCH__EOBJECT;

	/**
	 * The operation id for the '<em>Remove Match</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGABLE_DATA_STORE___REMOVE_MATCH__EOBJECT = DATA_STORE___REMOVE_MATCH__EOBJECT;

	/**
	 * The operation id for the '<em>Contains Match</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGABLE_DATA_STORE___CONTAINS_MATCH__EOBJECT = DATA_STORE___CONTAINS_MATCH__EOBJECT;

	/**
	 * The operation id for the '<em>Clear Matches</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGABLE_DATA_STORE___CLEAR_MATCHES = DATA_STORE___CLEAR_MATCHES;

	/**
	 * The operation id for the '<em>Get Remote Match Iterator</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGABLE_DATA_STORE___GET_REMOTE_MATCH_ITERATOR__EOBJECT_EDGEPATTERN = DATA_STORE_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Remote Match Size</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGABLE_DATA_STORE___GET_REMOTE_MATCH_SIZE__EOBJECT_EDGEPATTERN = DATA_STORE_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Is Empty Remote Match</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGABLE_DATA_STORE___IS_EMPTY_REMOTE_MATCH__EOBJECT_EDGEPATTERN = DATA_STORE_OPERATION_COUNT + 2;

	/**
	 * The operation id for the '<em>Add Remote Match</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGABLE_DATA_STORE___ADD_REMOTE_MATCH__EOBJECT_EOBJECT_EDGEPATTERN = DATA_STORE_OPERATION_COUNT + 3;

	/**
	 * The operation id for the '<em>Remove Remote Match</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGABLE_DATA_STORE___REMOVE_REMOTE_MATCH__EOBJECT_EOBJECT_EDGEPATTERN = DATA_STORE_OPERATION_COUNT + 4;

	/**
	 * The operation id for the '<em>Contains Remote Match</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGABLE_DATA_STORE___CONTAINS_REMOTE_MATCH__EOBJECT_EOBJECT_EDGEPATTERN = DATA_STORE_OPERATION_COUNT + 5;

	/**
	 * The operation id for the '<em>Clean Remote Matches</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGABLE_DATA_STORE___CLEAN_REMOTE_MATCHES__EOBJECT_EDGEPATTERN = DATA_STORE_OPERATION_COUNT + 6;

	/**
	 * The number of operations of the '<em>Navigable Data Store</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGABLE_DATA_STORE_OPERATION_COUNT = DATA_STORE_OPERATION_COUNT + 7;

	/**
	 * The number of structural features of the '<em>Formula</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORMULA_FEATURE_COUNT = 0;

	/**
	 * The operation id for the '<em>Get Result</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORMULA___GET_RESULT = 0;

	/**
	 * The operation id for the '<em>Get Embedding</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORMULA___GET_EMBEDDING = 1;

	/**
	 * The number of operations of the '<em>Formula</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORMULA_OPERATION_COUNT = 2;

	/**
	 * The feature id for the '<em><b>Child</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY_FORMULA__CHILD = FORMULA_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Unary Formula</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY_FORMULA_FEATURE_COUNT = FORMULA_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Result</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY_FORMULA___GET_RESULT = FORMULA___GET_RESULT;

	/**
	 * The operation id for the '<em>Get Embedding</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY_FORMULA___GET_EMBEDDING = FORMULA___GET_EMBEDDING;

	/**
	 * The number of operations of the '<em>Unary Formula</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY_FORMULA_OPERATION_COUNT = FORMULA_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Patterns</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_BASE__PATTERNS = 0;

	/**
	 * The number of structural features of the '<em>Rule Base</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_BASE_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Rule Base</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_BASE_OPERATION_COUNT = 0;

	/**
	 * The feature id for the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_FORMULA__LEFT = FORMULA_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_FORMULA__RIGHT = FORMULA_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Binary Formula</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_FORMULA_FEATURE_COUNT = FORMULA_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Get Result</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_FORMULA___GET_RESULT = FORMULA___GET_RESULT;

	/**
	 * The operation id for the '<em>Get Embedding</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_FORMULA___GET_EMBEDDING = FORMULA___GET_EMBEDDING;

	/**
	 * The number of operations of the '<em>Binary Formula</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_FORMULA_OPERATION_COUNT = FORMULA_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND__LEFT = BINARY_FORMULA__LEFT;

	/**
	 * The feature id for the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND__RIGHT = BINARY_FORMULA__RIGHT;

	/**
	 * The number of structural features of the '<em>And</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND_FEATURE_COUNT = BINARY_FORMULA_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Result</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND___GET_RESULT = BINARY_FORMULA___GET_RESULT;

	/**
	 * The operation id for the '<em>Get Embedding</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND___GET_EMBEDDING = BINARY_FORMULA___GET_EMBEDDING;

	/**
	 * The number of operations of the '<em>And</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND_OPERATION_COUNT = BINARY_FORMULA_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR__LEFT = BINARY_FORMULA__LEFT;

	/**
	 * The feature id for the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR__RIGHT = BINARY_FORMULA__RIGHT;

	/**
	 * The number of structural features of the '<em>Or</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR_FEATURE_COUNT = BINARY_FORMULA_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Result</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR___GET_RESULT = BINARY_FORMULA___GET_RESULT;

	/**
	 * The operation id for the '<em>Get Embedding</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR___GET_EMBEDDING = BINARY_FORMULA___GET_EMBEDDING;

	/**
	 * The number of operations of the '<em>Or</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR_OPERATION_COUNT = BINARY_FORMULA_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IFF__LEFT = BINARY_FORMULA__LEFT;

	/**
	 * The feature id for the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IFF__RIGHT = BINARY_FORMULA__RIGHT;

	/**
	 * The number of structural features of the '<em>Iff</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IFF_FEATURE_COUNT = BINARY_FORMULA_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Result</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IFF___GET_RESULT = BINARY_FORMULA___GET_RESULT;

	/**
	 * The operation id for the '<em>Get Embedding</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IFF___GET_EMBEDDING = BINARY_FORMULA___GET_EMBEDDING;

	/**
	 * The number of operations of the '<em>Iff</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IFF_OPERATION_COUNT = BINARY_FORMULA_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF__LEFT = BINARY_FORMULA__LEFT;

	/**
	 * The feature id for the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF__RIGHT = BINARY_FORMULA__RIGHT;

	/**
	 * The number of structural features of the '<em>If</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_FEATURE_COUNT = BINARY_FORMULA_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Result</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF___GET_RESULT = BINARY_FORMULA___GET_RESULT;

	/**
	 * The operation id for the '<em>Get Embedding</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF___GET_EMBEDDING = BINARY_FORMULA___GET_EMBEDDING;

	/**
	 * The number of operations of the '<em>If</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_OPERATION_COUNT = BINARY_FORMULA_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Child</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT__CHILD = UNARY_FORMULA__CHILD;

	/**
	 * The number of structural features of the '<em>Not</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_FEATURE_COUNT = UNARY_FORMULA_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Result</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT___GET_RESULT = UNARY_FORMULA___GET_RESULT;

	/**
	 * The operation id for the '<em>Get Embedding</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT___GET_EMBEDDING = UNARY_FORMULA___GET_EMBEDDING;

	/**
	 * The number of operations of the '<em>Not</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_OPERATION_COUNT = UNARY_FORMULA_OPERATION_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Quantifier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUANTIFIER_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Quantifier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUANTIFIER_OPERATION_COUNT = 0;

	/**
	 * The feature id for the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XOR__LEFT = BINARY_FORMULA__LEFT;

	/**
	 * The feature id for the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XOR__RIGHT = BINARY_FORMULA__RIGHT;

	/**
	 * The number of structural features of the '<em>Xor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XOR_FEATURE_COUNT = BINARY_FORMULA_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Result</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XOR___GET_RESULT = BINARY_FORMULA___GET_RESULT;

	/**
	 * The operation id for the '<em>Get Embedding</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XOR___GET_EMBEDDING = BINARY_FORMULA___GET_EMBEDDING;

	/**
	 * The number of operations of the '<em>Xor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XOR_OPERATION_COUNT = BINARY_FORMULA_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Formula</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN__FORMULA = 0;

	/**
	 * The feature id for the '<em><b>Graphs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN__GRAPHS = 1;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN__PARAMETERS = 2;

	/**
	 * The number of structural features of the '<em>Pattern</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Pattern</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_OPERATION_COUNT = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__NAME = 0;

	/**
	 * The number of structural features of the '<em>Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_OPERATION_COUNT = 0;

	/**
	 * The number of structural features of the '<em>For All</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_ALL_FEATURE_COUNT = QUANTIFIER_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>For All</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_ALL_OPERATION_COUNT = QUANTIFIER_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Lower Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXISTS__LOWER_BOUND = QUANTIFIER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Upper Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXISTS__UPPER_BOUND = QUANTIFIER_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Exists</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXISTS_FEATURE_COUNT = QUANTIFIER_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Exists</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXISTS_OPERATION_COUNT = QUANTIFIER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sidiff.consistency.graphpattern.impl.GraphFormulaImpl <em>Graph Formula</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.consistency.graphpattern.impl.GraphFormulaImpl
	 * @see org.sidiff.consistency.graphpattern.impl.GraphpatternPackageImpl#getGraphFormula()
	 * @generated
	 */
	int GRAPH_FORMULA = 24;

	/**
	 * The feature id for the '<em><b>Predicates</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPH_FORMULA__PREDICATES = FORMULA_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Graph Formula</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPH_FORMULA_FEATURE_COUNT = FORMULA_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Result</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPH_FORMULA___GET_RESULT = FORMULA___GET_RESULT;

	/**
	 * The operation id for the '<em>Get Embedding</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPH_FORMULA___GET_EMBEDDING = FORMULA___GET_EMBEDDING;

	/**
	 * The number of operations of the '<em>Graph Formula</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPH_FORMULA_OPERATION_COUNT = FORMULA_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sidiff.consistency.graphpattern.impl.EObjectListImpl <em>EObject List</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.consistency.graphpattern.impl.EObjectListImpl
	 * @see org.sidiff.consistency.graphpattern.impl.GraphpatternPackageImpl#getEObjectList()
	 * @generated
	 */
	int EOBJECT_LIST = 25;

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
	 * The meta object id for the '<em>ECollection</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.util.Collection
	 * @see org.sidiff.consistency.graphpattern.impl.GraphpatternPackageImpl#getECollection()
	 * @generated
	 */
	int ECOLLECTION = 26;

	/**
	 * The meta object id for the '<em>EIterator</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.util.Iterator
	 * @see org.sidiff.consistency.graphpattern.impl.GraphpatternPackageImpl#getEIterator()
	 * @generated
	 */
	int EITERATOR = 27;

	/**
	 * Returns the meta object for class '{@link org.sidiff.consistency.graphpattern.GraphPattern <em>Graph Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Graph Pattern</em>'.
	 * @see org.sidiff.consistency.graphpattern.GraphPattern
	 * @generated
	 */
	EClass getGraphPattern();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sidiff.consistency.graphpattern.GraphPattern#getNodes <em>Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Nodes</em>'.
	 * @see org.sidiff.consistency.graphpattern.GraphPattern#getNodes()
	 * @see #getGraphPattern()
	 * @generated
	 */
	EReference getGraphPattern_Nodes();

	/**
	 * Returns the meta object for the container reference '{@link org.sidiff.consistency.graphpattern.GraphPattern#getPattern <em>Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Pattern</em>'.
	 * @see org.sidiff.consistency.graphpattern.GraphPattern#getPattern()
	 * @see #getGraphPattern()
	 * @generated
	 */
	EReference getGraphPattern_Pattern();

	/**
	 * Returns the meta object for the attribute '{@link org.sidiff.consistency.graphpattern.GraphPattern#isMulti <em>Multi</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Multi</em>'.
	 * @see org.sidiff.consistency.graphpattern.GraphPattern#isMulti()
	 * @see #getGraphPattern()
	 * @generated
	 */
	EAttribute getGraphPattern_Multi();

	/**
	 * Returns the meta object for class '{@link org.sidiff.consistency.graphpattern.NodePattern <em>Node Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Node Pattern</em>'.
	 * @see org.sidiff.consistency.graphpattern.NodePattern
	 * @generated
	 */
	EClass getNodePattern();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sidiff.consistency.graphpattern.NodePattern#getOutgoings <em>Outgoings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Outgoings</em>'.
	 * @see org.sidiff.consistency.graphpattern.NodePattern#getOutgoings()
	 * @see #getNodePattern()
	 * @generated
	 */
	EReference getNodePattern_Outgoings();

	/**
	 * Returns the meta object for the reference '{@link org.sidiff.consistency.graphpattern.NodePattern#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see org.sidiff.consistency.graphpattern.NodePattern#getType()
	 * @see #getNodePattern()
	 * @generated
	 */
	EReference getNodePattern_Type();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sidiff.consistency.graphpattern.NodePattern#getAttributes <em>Attributes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Attributes</em>'.
	 * @see org.sidiff.consistency.graphpattern.NodePattern#getAttributes()
	 * @see #getNodePattern()
	 * @generated
	 */
	EReference getNodePattern_Attributes();

	/**
	 * Returns the meta object for the containment reference '{@link org.sidiff.consistency.graphpattern.NodePattern#getEvaluation <em>Evaluation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Evaluation</em>'.
	 * @see org.sidiff.consistency.graphpattern.NodePattern#getEvaluation()
	 * @see #getNodePattern()
	 * @generated
	 */
	EReference getNodePattern_Evaluation();

	/**
	 * Returns the meta object for the container reference '{@link org.sidiff.consistency.graphpattern.NodePattern#getGraph <em>Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Graph</em>'.
	 * @see org.sidiff.consistency.graphpattern.NodePattern#getGraph()
	 * @see #getNodePattern()
	 * @generated
	 */
	EReference getNodePattern_Graph();

	/**
	 * Returns the meta object for the reference list '{@link org.sidiff.consistency.graphpattern.NodePattern#getIncomings <em>Incomings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Incomings</em>'.
	 * @see org.sidiff.consistency.graphpattern.NodePattern#getIncomings()
	 * @see #getNodePattern()
	 * @generated
	 */
	EReference getNodePattern_Incomings();

	/**
	 * Returns the meta object for the '{@link org.sidiff.consistency.graphpattern.NodePattern#getAttribute(org.eclipse.emf.ecore.EAttribute) <em>Get Attribute</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Attribute</em>' operation.
	 * @see org.sidiff.consistency.graphpattern.NodePattern#getAttribute(org.eclipse.emf.ecore.EAttribute)
	 * @generated
	 */
	EOperation getNodePattern__GetAttribute__EAttribute();

	/**
	 * Returns the meta object for the '{@link org.sidiff.consistency.graphpattern.NodePattern#getOutgoing(org.eclipse.emf.ecore.EReference) <em>Get Outgoing</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Outgoing</em>' operation.
	 * @see org.sidiff.consistency.graphpattern.NodePattern#getOutgoing(org.eclipse.emf.ecore.EReference)
	 * @generated
	 */
	EOperation getNodePattern__GetOutgoing__EReference();

	/**
	 * Returns the meta object for the '{@link org.sidiff.consistency.graphpattern.NodePattern#getOutgoings(org.eclipse.emf.ecore.EReference) <em>Get Outgoings</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Outgoings</em>' operation.
	 * @see org.sidiff.consistency.graphpattern.NodePattern#getOutgoings(org.eclipse.emf.ecore.EReference)
	 * @generated
	 */
	EOperation getNodePattern__GetOutgoings__EReference();

	/**
	 * Returns the meta object for the '{@link org.sidiff.consistency.graphpattern.NodePattern#getIncoming(org.eclipse.emf.ecore.EReference) <em>Get Incoming</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Incoming</em>' operation.
	 * @see org.sidiff.consistency.graphpattern.NodePattern#getIncoming(org.eclipse.emf.ecore.EReference)
	 * @generated
	 */
	EOperation getNodePattern__GetIncoming__EReference();

	/**
	 * Returns the meta object for the '{@link org.sidiff.consistency.graphpattern.NodePattern#getIncomings(org.eclipse.emf.ecore.EReference) <em>Get Incomings</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Incomings</em>' operation.
	 * @see org.sidiff.consistency.graphpattern.NodePattern#getIncomings(org.eclipse.emf.ecore.EReference)
	 * @generated
	 */
	EOperation getNodePattern__GetIncomings__EReference();

	/**
	 * Returns the meta object for class '{@link org.sidiff.consistency.graphpattern.EdgePattern <em>Edge Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Edge Pattern</em>'.
	 * @see org.sidiff.consistency.graphpattern.EdgePattern
	 * @generated
	 */
	EClass getEdgePattern();

	/**
	 * Returns the meta object for the reference '{@link org.sidiff.consistency.graphpattern.EdgePattern#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see org.sidiff.consistency.graphpattern.EdgePattern#getTarget()
	 * @see #getEdgePattern()
	 * @generated
	 */
	EReference getEdgePattern_Target();

	/**
	 * Returns the meta object for the container reference '{@link org.sidiff.consistency.graphpattern.EdgePattern#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Source</em>'.
	 * @see org.sidiff.consistency.graphpattern.EdgePattern#getSource()
	 * @see #getEdgePattern()
	 * @generated
	 */
	EReference getEdgePattern_Source();

	/**
	 * Returns the meta object for the reference '{@link org.sidiff.consistency.graphpattern.EdgePattern#getOpposite <em>Opposite</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Opposite</em>'.
	 * @see org.sidiff.consistency.graphpattern.EdgePattern#getOpposite()
	 * @see #getEdgePattern()
	 * @generated
	 */
	EReference getEdgePattern_Opposite();

	/**
	 * Returns the meta object for the reference '{@link org.sidiff.consistency.graphpattern.EdgePattern#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see org.sidiff.consistency.graphpattern.EdgePattern#getType()
	 * @see #getEdgePattern()
	 * @generated
	 */
	EReference getEdgePattern_Type();

	/**
	 * Returns the meta object for the attribute '{@link org.sidiff.consistency.graphpattern.EdgePattern#isCrossReference <em>Cross Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Cross Reference</em>'.
	 * @see org.sidiff.consistency.graphpattern.EdgePattern#isCrossReference()
	 * @see #getEdgePattern()
	 * @generated
	 */
	EAttribute getEdgePattern_CrossReference();

	/**
	 * Returns the meta object for class '{@link org.sidiff.consistency.graphpattern.AttributePattern <em>Attribute Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Attribute Pattern</em>'.
	 * @see org.sidiff.consistency.graphpattern.AttributePattern
	 * @generated
	 */
	EClass getAttributePattern();

	/**
	 * Returns the meta object for the attribute '{@link org.sidiff.consistency.graphpattern.AttributePattern#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.sidiff.consistency.graphpattern.AttributePattern#getValue()
	 * @see #getAttributePattern()
	 * @generated
	 */
	EAttribute getAttributePattern_Value();

	/**
	 * Returns the meta object for the reference '{@link org.sidiff.consistency.graphpattern.AttributePattern#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see org.sidiff.consistency.graphpattern.AttributePattern#getType()
	 * @see #getAttributePattern()
	 * @generated
	 */
	EReference getAttributePattern_Type();

	/**
	 * Returns the meta object for the container reference '{@link org.sidiff.consistency.graphpattern.AttributePattern#getNode <em>Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Node</em>'.
	 * @see org.sidiff.consistency.graphpattern.AttributePattern#getNode()
	 * @see #getAttributePattern()
	 * @generated
	 */
	EReference getAttributePattern_Node();

	/**
	 * Returns the meta object for class '{@link org.sidiff.consistency.graphpattern.Evaluation <em>Evaluation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Evaluation</em>'.
	 * @see org.sidiff.consistency.graphpattern.Evaluation
	 * @generated
	 */
	EClass getEvaluation();

	/**
	 * Returns the meta object for the container reference '{@link org.sidiff.consistency.graphpattern.Evaluation#getNode <em>Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Node</em>'.
	 * @see org.sidiff.consistency.graphpattern.Evaluation#getNode()
	 * @see #getEvaluation()
	 * @generated
	 */
	EReference getEvaluation_Node();

	/**
	 * Returns the meta object for the reference list '{@link org.sidiff.consistency.graphpattern.Evaluation#getMatches <em>Matches</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Matches</em>'.
	 * @see org.sidiff.consistency.graphpattern.Evaluation#getMatches()
	 * @see #getEvaluation()
	 * @generated
	 */
	EReference getEvaluation_Matches();

	/**
	 * Returns the meta object for the reference '{@link org.sidiff.consistency.graphpattern.Evaluation#getStore <em>Store</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Store</em>'.
	 * @see org.sidiff.consistency.graphpattern.Evaluation#getStore()
	 * @see #getEvaluation()
	 * @generated
	 */
	EReference getEvaluation_Store();

	/**
	 * Returns the meta object for the '{@link org.sidiff.consistency.graphpattern.Evaluation#initialize() <em>Initialize</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Initialize</em>' operation.
	 * @see org.sidiff.consistency.graphpattern.Evaluation#initialize()
	 * @generated
	 */
	EOperation getEvaluation__Initialize();

	/**
	 * Returns the meta object for the '{@link org.sidiff.consistency.graphpattern.Evaluation#accept(org.sidiff.consistency.graphpattern.Visitor) <em>Accept</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Accept</em>' operation.
	 * @see org.sidiff.consistency.graphpattern.Evaluation#accept(org.sidiff.consistency.graphpattern.Visitor)
	 * @generated
	 */
	EOperation getEvaluation__Accept__Visitor();

	/**
	 * Returns the meta object for class '{@link org.sidiff.consistency.graphpattern.Visitor <em>Visitor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Visitor</em>'.
	 * @see org.sidiff.consistency.graphpattern.Visitor
	 * @generated
	 */
	EClass getVisitor();

	/**
	 * Returns the meta object for the '{@link org.sidiff.consistency.graphpattern.Visitor#visit(org.sidiff.consistency.graphpattern.Evaluation) <em>Visit</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Visit</em>' operation.
	 * @see org.sidiff.consistency.graphpattern.Visitor#visit(org.sidiff.consistency.graphpattern.Evaluation)
	 * @generated
	 */
	EOperation getVisitor__Visit__Evaluation();

	/**
	 * Returns the meta object for class '{@link org.sidiff.consistency.graphpattern.DataStore <em>Data Store</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Store</em>'.
	 * @see org.sidiff.consistency.graphpattern.DataStore
	 * @generated
	 */
	EClass getDataStore();

	/**
	 * Returns the meta object for the reference '{@link org.sidiff.consistency.graphpattern.DataStore#getEvaluation <em>Evaluation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Evaluation</em>'.
	 * @see org.sidiff.consistency.graphpattern.DataStore#getEvaluation()
	 * @see #getDataStore()
	 * @generated
	 */
	EReference getDataStore_Evaluation();

	/**
	 * Returns the meta object for the '{@link org.sidiff.consistency.graphpattern.DataStore#initialize() <em>Initialize</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Initialize</em>' operation.
	 * @see org.sidiff.consistency.graphpattern.DataStore#initialize()
	 * @generated
	 */
	EOperation getDataStore__Initialize();

	/**
	 * Returns the meta object for the '{@link org.sidiff.consistency.graphpattern.DataStore#getMatchIterator() <em>Get Match Iterator</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Match Iterator</em>' operation.
	 * @see org.sidiff.consistency.graphpattern.DataStore#getMatchIterator()
	 * @generated
	 */
	EOperation getDataStore__GetMatchIterator();

	/**
	 * Returns the meta object for the '{@link org.sidiff.consistency.graphpattern.DataStore#getMatchSize() <em>Get Match Size</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Match Size</em>' operation.
	 * @see org.sidiff.consistency.graphpattern.DataStore#getMatchSize()
	 * @generated
	 */
	EOperation getDataStore__GetMatchSize();

	/**
	 * Returns the meta object for the '{@link org.sidiff.consistency.graphpattern.DataStore#isEmptyMatch() <em>Is Empty Match</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Empty Match</em>' operation.
	 * @see org.sidiff.consistency.graphpattern.DataStore#isEmptyMatch()
	 * @generated
	 */
	EOperation getDataStore__IsEmptyMatch();

	/**
	 * Returns the meta object for the '{@link org.sidiff.consistency.graphpattern.DataStore#addMatch(org.eclipse.emf.ecore.EObject) <em>Add Match</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Add Match</em>' operation.
	 * @see org.sidiff.consistency.graphpattern.DataStore#addMatch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	EOperation getDataStore__AddMatch__EObject();

	/**
	 * Returns the meta object for the '{@link org.sidiff.consistency.graphpattern.DataStore#removeMatch(org.eclipse.emf.ecore.EObject) <em>Remove Match</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Remove Match</em>' operation.
	 * @see org.sidiff.consistency.graphpattern.DataStore#removeMatch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	EOperation getDataStore__RemoveMatch__EObject();

	/**
	 * Returns the meta object for the '{@link org.sidiff.consistency.graphpattern.DataStore#containsMatch(org.eclipse.emf.ecore.EObject) <em>Contains Match</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Contains Match</em>' operation.
	 * @see org.sidiff.consistency.graphpattern.DataStore#containsMatch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	EOperation getDataStore__ContainsMatch__EObject();

	/**
	 * Returns the meta object for the '{@link org.sidiff.consistency.graphpattern.DataStore#clearMatches() <em>Clear Matches</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Clear Matches</em>' operation.
	 * @see org.sidiff.consistency.graphpattern.DataStore#clearMatches()
	 * @generated
	 */
	EOperation getDataStore__ClearMatches();

	/**
	 * Returns the meta object for class '{@link org.sidiff.consistency.graphpattern.NavigableDataStore <em>Navigable Data Store</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Navigable Data Store</em>'.
	 * @see org.sidiff.consistency.graphpattern.NavigableDataStore
	 * @generated
	 */
	EClass getNavigableDataStore();

	/**
	 * Returns the meta object for the '{@link org.sidiff.consistency.graphpattern.NavigableDataStore#getRemoteMatchIterator(org.eclipse.emf.ecore.EObject, org.sidiff.consistency.graphpattern.EdgePattern) <em>Get Remote Match Iterator</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Remote Match Iterator</em>' operation.
	 * @see org.sidiff.consistency.graphpattern.NavigableDataStore#getRemoteMatchIterator(org.eclipse.emf.ecore.EObject, org.sidiff.consistency.graphpattern.EdgePattern)
	 * @generated
	 */
	EOperation getNavigableDataStore__GetRemoteMatchIterator__EObject_EdgePattern();

	/**
	 * Returns the meta object for the '{@link org.sidiff.consistency.graphpattern.NavigableDataStore#getRemoteMatchSize(org.eclipse.emf.ecore.EObject, org.sidiff.consistency.graphpattern.EdgePattern) <em>Get Remote Match Size</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Remote Match Size</em>' operation.
	 * @see org.sidiff.consistency.graphpattern.NavigableDataStore#getRemoteMatchSize(org.eclipse.emf.ecore.EObject, org.sidiff.consistency.graphpattern.EdgePattern)
	 * @generated
	 */
	EOperation getNavigableDataStore__GetRemoteMatchSize__EObject_EdgePattern();

	/**
	 * Returns the meta object for the '{@link org.sidiff.consistency.graphpattern.NavigableDataStore#isEmptyRemoteMatch(org.eclipse.emf.ecore.EObject, org.sidiff.consistency.graphpattern.EdgePattern) <em>Is Empty Remote Match</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Empty Remote Match</em>' operation.
	 * @see org.sidiff.consistency.graphpattern.NavigableDataStore#isEmptyRemoteMatch(org.eclipse.emf.ecore.EObject, org.sidiff.consistency.graphpattern.EdgePattern)
	 * @generated
	 */
	EOperation getNavigableDataStore__IsEmptyRemoteMatch__EObject_EdgePattern();

	/**
	 * Returns the meta object for the '{@link org.sidiff.consistency.graphpattern.NavigableDataStore#addRemoteMatch(org.eclipse.emf.ecore.EObject, org.eclipse.emf.ecore.EObject, org.sidiff.consistency.graphpattern.EdgePattern) <em>Add Remote Match</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Add Remote Match</em>' operation.
	 * @see org.sidiff.consistency.graphpattern.NavigableDataStore#addRemoteMatch(org.eclipse.emf.ecore.EObject, org.eclipse.emf.ecore.EObject, org.sidiff.consistency.graphpattern.EdgePattern)
	 * @generated
	 */
	EOperation getNavigableDataStore__AddRemoteMatch__EObject_EObject_EdgePattern();

	/**
	 * Returns the meta object for the '{@link org.sidiff.consistency.graphpattern.NavigableDataStore#removeRemoteMatch(org.eclipse.emf.ecore.EObject, org.eclipse.emf.ecore.EObject, org.sidiff.consistency.graphpattern.EdgePattern) <em>Remove Remote Match</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Remove Remote Match</em>' operation.
	 * @see org.sidiff.consistency.graphpattern.NavigableDataStore#removeRemoteMatch(org.eclipse.emf.ecore.EObject, org.eclipse.emf.ecore.EObject, org.sidiff.consistency.graphpattern.EdgePattern)
	 * @generated
	 */
	EOperation getNavigableDataStore__RemoveRemoteMatch__EObject_EObject_EdgePattern();

	/**
	 * Returns the meta object for the '{@link org.sidiff.consistency.graphpattern.NavigableDataStore#containsRemoteMatch(org.eclipse.emf.ecore.EObject, org.eclipse.emf.ecore.EObject, org.sidiff.consistency.graphpattern.EdgePattern) <em>Contains Remote Match</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Contains Remote Match</em>' operation.
	 * @see org.sidiff.consistency.graphpattern.NavigableDataStore#containsRemoteMatch(org.eclipse.emf.ecore.EObject, org.eclipse.emf.ecore.EObject, org.sidiff.consistency.graphpattern.EdgePattern)
	 * @generated
	 */
	EOperation getNavigableDataStore__ContainsRemoteMatch__EObject_EObject_EdgePattern();

	/**
	 * Returns the meta object for the '{@link org.sidiff.consistency.graphpattern.NavigableDataStore#cleanRemoteMatches(org.eclipse.emf.ecore.EObject, org.sidiff.consistency.graphpattern.EdgePattern) <em>Clean Remote Matches</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Clean Remote Matches</em>' operation.
	 * @see org.sidiff.consistency.graphpattern.NavigableDataStore#cleanRemoteMatches(org.eclipse.emf.ecore.EObject, org.sidiff.consistency.graphpattern.EdgePattern)
	 * @generated
	 */
	EOperation getNavigableDataStore__CleanRemoteMatches__EObject_EdgePattern();

	/**
	 * Returns the meta object for class '{@link org.sidiff.consistency.graphpattern.UnaryFormula <em>Unary Formula</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unary Formula</em>'.
	 * @see org.sidiff.consistency.graphpattern.UnaryFormula
	 * @generated
	 */
	EClass getUnaryFormula();

	/**
	 * Returns the meta object for the containment reference '{@link org.sidiff.consistency.graphpattern.UnaryFormula#getChild <em>Child</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Child</em>'.
	 * @see org.sidiff.consistency.graphpattern.UnaryFormula#getChild()
	 * @see #getUnaryFormula()
	 * @generated
	 */
	EReference getUnaryFormula_Child();

	/**
	 * Returns the meta object for class '{@link org.sidiff.consistency.graphpattern.RuleBase <em>Rule Base</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Rule Base</em>'.
	 * @see org.sidiff.consistency.graphpattern.RuleBase
	 * @generated
	 */
	EClass getRuleBase();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sidiff.consistency.graphpattern.RuleBase#getPatterns <em>Patterns</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Patterns</em>'.
	 * @see org.sidiff.consistency.graphpattern.RuleBase#getPatterns()
	 * @see #getRuleBase()
	 * @generated
	 */
	EReference getRuleBase_Patterns();

	/**
	 * Returns the meta object for class '{@link org.sidiff.consistency.graphpattern.Formula <em>Formula</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Formula</em>'.
	 * @see org.sidiff.consistency.graphpattern.Formula
	 * @generated
	 */
	EClass getFormula();

	/**
	 * Returns the meta object for the '{@link org.sidiff.consistency.graphpattern.Formula#getResult() <em>Get Result</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Result</em>' operation.
	 * @see org.sidiff.consistency.graphpattern.Formula#getResult()
	 * @generated
	 */
	EOperation getFormula__GetResult();

	/**
	 * Returns the meta object for the '{@link org.sidiff.consistency.graphpattern.Formula#getEmbedding() <em>Get Embedding</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Embedding</em>' operation.
	 * @see org.sidiff.consistency.graphpattern.Formula#getEmbedding()
	 * @generated
	 */
	EOperation getFormula__GetEmbedding();

	/**
	 * Returns the meta object for class '{@link org.sidiff.consistency.graphpattern.BinaryFormula <em>Binary Formula</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Binary Formula</em>'.
	 * @see org.sidiff.consistency.graphpattern.BinaryFormula
	 * @generated
	 */
	EClass getBinaryFormula();

	/**
	 * Returns the meta object for the containment reference '{@link org.sidiff.consistency.graphpattern.BinaryFormula#getLeft <em>Left</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Left</em>'.
	 * @see org.sidiff.consistency.graphpattern.BinaryFormula#getLeft()
	 * @see #getBinaryFormula()
	 * @generated
	 */
	EReference getBinaryFormula_Left();

	/**
	 * Returns the meta object for the containment reference '{@link org.sidiff.consistency.graphpattern.BinaryFormula#getRight <em>Right</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Right</em>'.
	 * @see org.sidiff.consistency.graphpattern.BinaryFormula#getRight()
	 * @see #getBinaryFormula()
	 * @generated
	 */
	EReference getBinaryFormula_Right();

	/**
	 * Returns the meta object for class '{@link org.sidiff.consistency.graphpattern.And <em>And</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>And</em>'.
	 * @see org.sidiff.consistency.graphpattern.And
	 * @generated
	 */
	EClass getAnd();

	/**
	 * Returns the meta object for class '{@link org.sidiff.consistency.graphpattern.Or <em>Or</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Or</em>'.
	 * @see org.sidiff.consistency.graphpattern.Or
	 * @generated
	 */
	EClass getOr();

	/**
	 * Returns the meta object for class '{@link org.sidiff.consistency.graphpattern.Iff <em>Iff</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Iff</em>'.
	 * @see org.sidiff.consistency.graphpattern.Iff
	 * @generated
	 */
	EClass getIff();

	/**
	 * Returns the meta object for class '{@link org.sidiff.consistency.graphpattern.If <em>If</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>If</em>'.
	 * @see org.sidiff.consistency.graphpattern.If
	 * @generated
	 */
	EClass getIf();

	/**
	 * Returns the meta object for class '{@link org.sidiff.consistency.graphpattern.Not <em>Not</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Not</em>'.
	 * @see org.sidiff.consistency.graphpattern.Not
	 * @generated
	 */
	EClass getNot();

	/**
	 * Returns the meta object for class '{@link org.sidiff.consistency.graphpattern.Quantifier <em>Quantifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Quantifier</em>'.
	 * @see org.sidiff.consistency.graphpattern.Quantifier
	 * @generated
	 */
	EClass getQuantifier();

	/**
	 * Returns the meta object for class '{@link org.sidiff.consistency.graphpattern.ForAll <em>For All</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>For All</em>'.
	 * @see org.sidiff.consistency.graphpattern.ForAll
	 * @generated
	 */
	EClass getForAll();

	/**
	 * Returns the meta object for class '{@link org.sidiff.consistency.graphpattern.Exists <em>Exists</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Exists</em>'.
	 * @see org.sidiff.consistency.graphpattern.Exists
	 * @generated
	 */
	EClass getExists();

	/**
	 * Returns the meta object for the attribute '{@link org.sidiff.consistency.graphpattern.Exists#getLowerBound <em>Lower Bound</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Lower Bound</em>'.
	 * @see org.sidiff.consistency.graphpattern.Exists#getLowerBound()
	 * @see #getExists()
	 * @generated
	 */
	EAttribute getExists_LowerBound();

	/**
	 * Returns the meta object for the attribute '{@link org.sidiff.consistency.graphpattern.Exists#getUpperBound <em>Upper Bound</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Upper Bound</em>'.
	 * @see org.sidiff.consistency.graphpattern.Exists#getUpperBound()
	 * @see #getExists()
	 * @generated
	 */
	EAttribute getExists_UpperBound();

	/**
	 * Returns the meta object for class '{@link org.sidiff.consistency.graphpattern.GraphFormula <em>Graph Formula</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Graph Formula</em>'.
	 * @see org.sidiff.consistency.graphpattern.GraphFormula
	 * @generated
	 */
	EClass getGraphFormula();

	/**
	 * Returns the meta object for the reference list '{@link org.sidiff.consistency.graphpattern.GraphFormula#getPredicates <em>Predicates</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Predicates</em>'.
	 * @see org.sidiff.consistency.graphpattern.GraphFormula#getPredicates()
	 * @see #getGraphFormula()
	 * @generated
	 */
	EReference getGraphFormula_Predicates();

	/**
	 * Returns the meta object for class '{@link org.sidiff.consistency.graphpattern.EObjectList <em>EObject List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EObject List</em>'.
	 * @see org.sidiff.consistency.graphpattern.EObjectList
	 * @generated
	 */
	EClass getEObjectList();

	/**
	 * Returns the meta object for the reference list '{@link org.sidiff.consistency.graphpattern.EObjectList#getContent <em>Content</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Content</em>'.
	 * @see org.sidiff.consistency.graphpattern.EObjectList#getContent()
	 * @see #getEObjectList()
	 * @generated
	 */
	EReference getEObjectList_Content();

	/**
	 * Returns the meta object for the attribute '{@link org.sidiff.consistency.graphpattern.EObjectList#getLabel <em>Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Label</em>'.
	 * @see org.sidiff.consistency.graphpattern.EObjectList#getLabel()
	 * @see #getEObjectList()
	 * @generated
	 */
	EAttribute getEObjectList_Label();

	/**
	 * Returns the meta object for class '{@link org.sidiff.consistency.graphpattern.Xor <em>Xor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Xor</em>'.
	 * @see org.sidiff.consistency.graphpattern.Xor
	 * @generated
	 */
	EClass getXor();

	/**
	 * Returns the meta object for class '{@link org.sidiff.consistency.graphpattern.Pattern <em>Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Pattern</em>'.
	 * @see org.sidiff.consistency.graphpattern.Pattern
	 * @generated
	 */
	EClass getPattern();

	/**
	 * Returns the meta object for the containment reference '{@link org.sidiff.consistency.graphpattern.Pattern#getFormula <em>Formula</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Formula</em>'.
	 * @see org.sidiff.consistency.graphpattern.Pattern#getFormula()
	 * @see #getPattern()
	 * @generated
	 */
	EReference getPattern_Formula();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sidiff.consistency.graphpattern.Pattern#getGraphs <em>Graphs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Graphs</em>'.
	 * @see org.sidiff.consistency.graphpattern.Pattern#getGraphs()
	 * @see #getPattern()
	 * @generated
	 */
	EReference getPattern_Graphs();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sidiff.consistency.graphpattern.Pattern#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameters</em>'.
	 * @see org.sidiff.consistency.graphpattern.Pattern#getParameters()
	 * @see #getPattern()
	 * @generated
	 */
	EReference getPattern_Parameters();

	/**
	 * Returns the meta object for class '{@link org.sidiff.consistency.graphpattern.GraphPatternElement <em>Graph Pattern Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Graph Pattern Element</em>'.
	 * @see org.sidiff.consistency.graphpattern.GraphPatternElement
	 * @generated
	 */
	EClass getGraphPatternElement();

	/**
	 * Returns the meta object for the attribute '{@link org.sidiff.consistency.graphpattern.GraphPatternElement#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.sidiff.consistency.graphpattern.GraphPatternElement#getName()
	 * @see #getGraphPatternElement()
	 * @generated
	 */
	EAttribute getGraphPatternElement_Name();

	/**
	 * Returns the meta object for the reference list '{@link org.sidiff.consistency.graphpattern.GraphPatternElement#getFormulas <em>Formulas</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Formulas</em>'.
	 * @see org.sidiff.consistency.graphpattern.GraphPatternElement#getFormulas()
	 * @see #getGraphPatternElement()
	 * @generated
	 */
	EReference getGraphPatternElement_Formulas();

	/**
	 * Returns the meta object for the reference '{@link org.sidiff.consistency.graphpattern.GraphPatternElement#getQuantifier <em>Quantifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Quantifier</em>'.
	 * @see org.sidiff.consistency.graphpattern.GraphPatternElement#getQuantifier()
	 * @see #getGraphPatternElement()
	 * @generated
	 */
	EReference getGraphPatternElement_Quantifier();

	/**
	 * Returns the meta object for class '{@link org.sidiff.consistency.graphpattern.Parameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parameter</em>'.
	 * @see org.sidiff.consistency.graphpattern.Parameter
	 * @generated
	 */
	EClass getParameter();

	/**
	 * Returns the meta object for the attribute '{@link org.sidiff.consistency.graphpattern.Parameter#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.sidiff.consistency.graphpattern.Parameter#getName()
	 * @see #getParameter()
	 * @generated
	 */
	EAttribute getParameter_Name();

	/**
	 * Returns the meta object for data type '{@link java.util.Collection <em>ECollection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>ECollection</em>'.
	 * @see java.util.Collection
	 * @model instanceClass="java.util.Collection<? extends org.eclipse.emf.ecore.EObject>" serializeable="false"
	 * @generated
	 */
	EDataType getECollection();

	/**
	 * Returns the meta object for data type '{@link java.util.Iterator <em>EIterator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>EIterator</em>'.
	 * @see java.util.Iterator
	 * @model instanceClass="java.util.Iterator<org.eclipse.emf.ecore.EObject>" serializeable="false"
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
		 * The meta object literal for the '{@link org.sidiff.consistency.graphpattern.impl.GraphPatternImpl <em>Graph Pattern</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.consistency.graphpattern.impl.GraphPatternImpl
		 * @see org.sidiff.consistency.graphpattern.impl.GraphpatternPackageImpl#getGraphPattern()
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
		 * The meta object literal for the '<em><b>Multi</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GRAPH_PATTERN__MULTI = eINSTANCE.getGraphPattern_Multi();

		/**
		 * The meta object literal for the '{@link org.sidiff.consistency.graphpattern.impl.NodePatternImpl <em>Node Pattern</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.consistency.graphpattern.impl.NodePatternImpl
		 * @see org.sidiff.consistency.graphpattern.impl.GraphpatternPackageImpl#getNodePattern()
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
		 * The meta object literal for the '<em><b>Evaluation</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE_PATTERN__EVALUATION = eINSTANCE.getNodePattern_Evaluation();

		/**
		 * The meta object literal for the '<em><b>Graph</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE_PATTERN__GRAPH = eINSTANCE.getNodePattern_Graph();

		/**
		 * The meta object literal for the '<em><b>Incomings</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE_PATTERN__INCOMINGS = eINSTANCE.getNodePattern_Incomings();

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
		 * The meta object literal for the '{@link org.sidiff.consistency.graphpattern.impl.EdgePatternImpl <em>Edge Pattern</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.consistency.graphpattern.impl.EdgePatternImpl
		 * @see org.sidiff.consistency.graphpattern.impl.GraphpatternPackageImpl#getEdgePattern()
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
		 * The meta object literal for the '<em><b>Cross Reference</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EDGE_PATTERN__CROSS_REFERENCE = eINSTANCE.getEdgePattern_CrossReference();

		/**
		 * The meta object literal for the '{@link org.sidiff.consistency.graphpattern.impl.AttributePatternImpl <em>Attribute Pattern</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.consistency.graphpattern.impl.AttributePatternImpl
		 * @see org.sidiff.consistency.graphpattern.impl.GraphpatternPackageImpl#getAttributePattern()
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
		 * The meta object literal for the '{@link org.sidiff.consistency.graphpattern.impl.EvaluationImpl <em>Evaluation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.consistency.graphpattern.impl.EvaluationImpl
		 * @see org.sidiff.consistency.graphpattern.impl.GraphpatternPackageImpl#getEvaluation()
		 * @generated
		 */
		EClass EVALUATION = eINSTANCE.getEvaluation();

		/**
		 * The meta object literal for the '<em><b>Node</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EVALUATION__NODE = eINSTANCE.getEvaluation_Node();

		/**
		 * The meta object literal for the '<em><b>Matches</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EVALUATION__MATCHES = eINSTANCE.getEvaluation_Matches();

		/**
		 * The meta object literal for the '<em><b>Store</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EVALUATION__STORE = eINSTANCE.getEvaluation_Store();

		/**
		 * The meta object literal for the '<em><b>Initialize</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation EVALUATION___INITIALIZE = eINSTANCE.getEvaluation__Initialize();

		/**
		 * The meta object literal for the '<em><b>Accept</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation EVALUATION___ACCEPT__VISITOR = eINSTANCE.getEvaluation__Accept__Visitor();

		/**
		 * The meta object literal for the '{@link org.sidiff.consistency.graphpattern.impl.VisitorImpl <em>Visitor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.consistency.graphpattern.impl.VisitorImpl
		 * @see org.sidiff.consistency.graphpattern.impl.GraphpatternPackageImpl#getVisitor()
		 * @generated
		 */
		EClass VISITOR = eINSTANCE.getVisitor();

		/**
		 * The meta object literal for the '<em><b>Visit</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation VISITOR___VISIT__EVALUATION = eINSTANCE.getVisitor__Visit__Evaluation();

		/**
		 * The meta object literal for the '{@link org.sidiff.consistency.graphpattern.impl.DataStoreImpl <em>Data Store</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.consistency.graphpattern.impl.DataStoreImpl
		 * @see org.sidiff.consistency.graphpattern.impl.GraphpatternPackageImpl#getDataStore()
		 * @generated
		 */
		EClass DATA_STORE = eINSTANCE.getDataStore();

		/**
		 * The meta object literal for the '<em><b>Evaluation</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_STORE__EVALUATION = eINSTANCE.getDataStore_Evaluation();

		/**
		 * The meta object literal for the '<em><b>Initialize</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation DATA_STORE___INITIALIZE = eINSTANCE.getDataStore__Initialize();

		/**
		 * The meta object literal for the '<em><b>Get Match Iterator</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation DATA_STORE___GET_MATCH_ITERATOR = eINSTANCE.getDataStore__GetMatchIterator();

		/**
		 * The meta object literal for the '<em><b>Get Match Size</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation DATA_STORE___GET_MATCH_SIZE = eINSTANCE.getDataStore__GetMatchSize();

		/**
		 * The meta object literal for the '<em><b>Is Empty Match</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation DATA_STORE___IS_EMPTY_MATCH = eINSTANCE.getDataStore__IsEmptyMatch();

		/**
		 * The meta object literal for the '<em><b>Add Match</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation DATA_STORE___ADD_MATCH__EOBJECT = eINSTANCE.getDataStore__AddMatch__EObject();

		/**
		 * The meta object literal for the '<em><b>Remove Match</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation DATA_STORE___REMOVE_MATCH__EOBJECT = eINSTANCE.getDataStore__RemoveMatch__EObject();

		/**
		 * The meta object literal for the '<em><b>Contains Match</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation DATA_STORE___CONTAINS_MATCH__EOBJECT = eINSTANCE.getDataStore__ContainsMatch__EObject();

		/**
		 * The meta object literal for the '<em><b>Clear Matches</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation DATA_STORE___CLEAR_MATCHES = eINSTANCE.getDataStore__ClearMatches();

		/**
		 * The meta object literal for the '{@link org.sidiff.consistency.graphpattern.impl.NavigableDataStoreImpl <em>Navigable Data Store</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.consistency.graphpattern.impl.NavigableDataStoreImpl
		 * @see org.sidiff.consistency.graphpattern.impl.GraphpatternPackageImpl#getNavigableDataStore()
		 * @generated
		 */
		EClass NAVIGABLE_DATA_STORE = eINSTANCE.getNavigableDataStore();

		/**
		 * The meta object literal for the '<em><b>Get Remote Match Iterator</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation NAVIGABLE_DATA_STORE___GET_REMOTE_MATCH_ITERATOR__EOBJECT_EDGEPATTERN = eINSTANCE.getNavigableDataStore__GetRemoteMatchIterator__EObject_EdgePattern();

		/**
		 * The meta object literal for the '<em><b>Get Remote Match Size</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation NAVIGABLE_DATA_STORE___GET_REMOTE_MATCH_SIZE__EOBJECT_EDGEPATTERN = eINSTANCE.getNavigableDataStore__GetRemoteMatchSize__EObject_EdgePattern();

		/**
		 * The meta object literal for the '<em><b>Is Empty Remote Match</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation NAVIGABLE_DATA_STORE___IS_EMPTY_REMOTE_MATCH__EOBJECT_EDGEPATTERN = eINSTANCE.getNavigableDataStore__IsEmptyRemoteMatch__EObject_EdgePattern();

		/**
		 * The meta object literal for the '<em><b>Add Remote Match</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation NAVIGABLE_DATA_STORE___ADD_REMOTE_MATCH__EOBJECT_EOBJECT_EDGEPATTERN = eINSTANCE.getNavigableDataStore__AddRemoteMatch__EObject_EObject_EdgePattern();

		/**
		 * The meta object literal for the '<em><b>Remove Remote Match</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation NAVIGABLE_DATA_STORE___REMOVE_REMOTE_MATCH__EOBJECT_EOBJECT_EDGEPATTERN = eINSTANCE.getNavigableDataStore__RemoveRemoteMatch__EObject_EObject_EdgePattern();

		/**
		 * The meta object literal for the '<em><b>Contains Remote Match</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation NAVIGABLE_DATA_STORE___CONTAINS_REMOTE_MATCH__EOBJECT_EOBJECT_EDGEPATTERN = eINSTANCE.getNavigableDataStore__ContainsRemoteMatch__EObject_EObject_EdgePattern();

		/**
		 * The meta object literal for the '<em><b>Clean Remote Matches</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation NAVIGABLE_DATA_STORE___CLEAN_REMOTE_MATCHES__EOBJECT_EDGEPATTERN = eINSTANCE.getNavigableDataStore__CleanRemoteMatches__EObject_EdgePattern();

		/**
		 * The meta object literal for the '{@link org.sidiff.consistency.graphpattern.impl.UnaryFormulaImpl <em>Unary Formula</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.consistency.graphpattern.impl.UnaryFormulaImpl
		 * @see org.sidiff.consistency.graphpattern.impl.GraphpatternPackageImpl#getUnaryFormula()
		 * @generated
		 */
		EClass UNARY_FORMULA = eINSTANCE.getUnaryFormula();

		/**
		 * The meta object literal for the '<em><b>Child</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UNARY_FORMULA__CHILD = eINSTANCE.getUnaryFormula_Child();

		/**
		 * The meta object literal for the '{@link org.sidiff.consistency.graphpattern.impl.RuleBaseImpl <em>Rule Base</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.consistency.graphpattern.impl.RuleBaseImpl
		 * @see org.sidiff.consistency.graphpattern.impl.GraphpatternPackageImpl#getRuleBase()
		 * @generated
		 */
		EClass RULE_BASE = eINSTANCE.getRuleBase();

		/**
		 * The meta object literal for the '<em><b>Patterns</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RULE_BASE__PATTERNS = eINSTANCE.getRuleBase_Patterns();

		/**
		 * The meta object literal for the '{@link org.sidiff.consistency.graphpattern.Formula <em>Formula</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.consistency.graphpattern.Formula
		 * @see org.sidiff.consistency.graphpattern.impl.GraphpatternPackageImpl#getFormula()
		 * @generated
		 */
		EClass FORMULA = eINSTANCE.getFormula();

		/**
		 * The meta object literal for the '<em><b>Get Result</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation FORMULA___GET_RESULT = eINSTANCE.getFormula__GetResult();

		/**
		 * The meta object literal for the '<em><b>Get Embedding</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation FORMULA___GET_EMBEDDING = eINSTANCE.getFormula__GetEmbedding();

		/**
		 * The meta object literal for the '{@link org.sidiff.consistency.graphpattern.impl.BinaryFormulaImpl <em>Binary Formula</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.consistency.graphpattern.impl.BinaryFormulaImpl
		 * @see org.sidiff.consistency.graphpattern.impl.GraphpatternPackageImpl#getBinaryFormula()
		 * @generated
		 */
		EClass BINARY_FORMULA = eINSTANCE.getBinaryFormula();

		/**
		 * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BINARY_FORMULA__LEFT = eINSTANCE.getBinaryFormula_Left();

		/**
		 * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BINARY_FORMULA__RIGHT = eINSTANCE.getBinaryFormula_Right();

		/**
		 * The meta object literal for the '{@link org.sidiff.consistency.graphpattern.impl.AndImpl <em>And</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.consistency.graphpattern.impl.AndImpl
		 * @see org.sidiff.consistency.graphpattern.impl.GraphpatternPackageImpl#getAnd()
		 * @generated
		 */
		EClass AND = eINSTANCE.getAnd();

		/**
		 * The meta object literal for the '{@link org.sidiff.consistency.graphpattern.impl.OrImpl <em>Or</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.consistency.graphpattern.impl.OrImpl
		 * @see org.sidiff.consistency.graphpattern.impl.GraphpatternPackageImpl#getOr()
		 * @generated
		 */
		EClass OR = eINSTANCE.getOr();

		/**
		 * The meta object literal for the '{@link org.sidiff.consistency.graphpattern.impl.IffImpl <em>Iff</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.consistency.graphpattern.impl.IffImpl
		 * @see org.sidiff.consistency.graphpattern.impl.GraphpatternPackageImpl#getIff()
		 * @generated
		 */
		EClass IFF = eINSTANCE.getIff();

		/**
		 * The meta object literal for the '{@link org.sidiff.consistency.graphpattern.impl.IfImpl <em>If</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.consistency.graphpattern.impl.IfImpl
		 * @see org.sidiff.consistency.graphpattern.impl.GraphpatternPackageImpl#getIf()
		 * @generated
		 */
		EClass IF = eINSTANCE.getIf();

		/**
		 * The meta object literal for the '{@link org.sidiff.consistency.graphpattern.impl.NotImpl <em>Not</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.consistency.graphpattern.impl.NotImpl
		 * @see org.sidiff.consistency.graphpattern.impl.GraphpatternPackageImpl#getNot()
		 * @generated
		 */
		EClass NOT = eINSTANCE.getNot();

		/**
		 * The meta object literal for the '{@link org.sidiff.consistency.graphpattern.Quantifier <em>Quantifier</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.consistency.graphpattern.Quantifier
		 * @see org.sidiff.consistency.graphpattern.impl.GraphpatternPackageImpl#getQuantifier()
		 * @generated
		 */
		EClass QUANTIFIER = eINSTANCE.getQuantifier();

		/**
		 * The meta object literal for the '{@link org.sidiff.consistency.graphpattern.impl.ForAllImpl <em>For All</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.consistency.graphpattern.impl.ForAllImpl
		 * @see org.sidiff.consistency.graphpattern.impl.GraphpatternPackageImpl#getForAll()
		 * @generated
		 */
		EClass FOR_ALL = eINSTANCE.getForAll();

		/**
		 * The meta object literal for the '{@link org.sidiff.consistency.graphpattern.impl.ExistsImpl <em>Exists</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.consistency.graphpattern.impl.ExistsImpl
		 * @see org.sidiff.consistency.graphpattern.impl.GraphpatternPackageImpl#getExists()
		 * @generated
		 */
		EClass EXISTS = eINSTANCE.getExists();

		/**
		 * The meta object literal for the '<em><b>Lower Bound</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXISTS__LOWER_BOUND = eINSTANCE.getExists_LowerBound();

		/**
		 * The meta object literal for the '<em><b>Upper Bound</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXISTS__UPPER_BOUND = eINSTANCE.getExists_UpperBound();

		/**
		 * The meta object literal for the '{@link org.sidiff.consistency.graphpattern.impl.GraphFormulaImpl <em>Graph Formula</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.consistency.graphpattern.impl.GraphFormulaImpl
		 * @see org.sidiff.consistency.graphpattern.impl.GraphpatternPackageImpl#getGraphFormula()
		 * @generated
		 */
		EClass GRAPH_FORMULA = eINSTANCE.getGraphFormula();

		/**
		 * The meta object literal for the '<em><b>Predicates</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GRAPH_FORMULA__PREDICATES = eINSTANCE.getGraphFormula_Predicates();

		/**
		 * The meta object literal for the '{@link org.sidiff.consistency.graphpattern.impl.EObjectListImpl <em>EObject List</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.consistency.graphpattern.impl.EObjectListImpl
		 * @see org.sidiff.consistency.graphpattern.impl.GraphpatternPackageImpl#getEObjectList()
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
		 * The meta object literal for the '{@link org.sidiff.consistency.graphpattern.impl.XorImpl <em>Xor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.consistency.graphpattern.impl.XorImpl
		 * @see org.sidiff.consistency.graphpattern.impl.GraphpatternPackageImpl#getXor()
		 * @generated
		 */
		EClass XOR = eINSTANCE.getXor();

		/**
		 * The meta object literal for the '{@link org.sidiff.consistency.graphpattern.impl.PatternImpl <em>Pattern</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.consistency.graphpattern.impl.PatternImpl
		 * @see org.sidiff.consistency.graphpattern.impl.GraphpatternPackageImpl#getPattern()
		 * @generated
		 */
		EClass PATTERN = eINSTANCE.getPattern();

		/**
		 * The meta object literal for the '<em><b>Formula</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PATTERN__FORMULA = eINSTANCE.getPattern_Formula();

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
		 * The meta object literal for the '{@link org.sidiff.consistency.graphpattern.impl.GraphPatternElementImpl <em>Graph Pattern Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.consistency.graphpattern.impl.GraphPatternElementImpl
		 * @see org.sidiff.consistency.graphpattern.impl.GraphpatternPackageImpl#getGraphPatternElement()
		 * @generated
		 */
		EClass GRAPH_PATTERN_ELEMENT = eINSTANCE.getGraphPatternElement();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GRAPH_PATTERN_ELEMENT__NAME = eINSTANCE.getGraphPatternElement_Name();

		/**
		 * The meta object literal for the '<em><b>Formulas</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GRAPH_PATTERN_ELEMENT__FORMULAS = eINSTANCE.getGraphPatternElement_Formulas();

		/**
		 * The meta object literal for the '<em><b>Quantifier</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GRAPH_PATTERN_ELEMENT__QUANTIFIER = eINSTANCE.getGraphPatternElement_Quantifier();

		/**
		 * The meta object literal for the '{@link org.sidiff.consistency.graphpattern.impl.ParameterImpl <em>Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.consistency.graphpattern.impl.ParameterImpl
		 * @see org.sidiff.consistency.graphpattern.impl.GraphpatternPackageImpl#getParameter()
		 * @generated
		 */
		EClass PARAMETER = eINSTANCE.getParameter();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARAMETER__NAME = eINSTANCE.getParameter_Name();

		/**
		 * The meta object literal for the '<em>ECollection</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.util.Collection
		 * @see org.sidiff.consistency.graphpattern.impl.GraphpatternPackageImpl#getECollection()
		 * @generated
		 */
		EDataType ECOLLECTION = eINSTANCE.getECollection();

		/**
		 * The meta object literal for the '<em>EIterator</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.util.Iterator
		 * @see org.sidiff.consistency.graphpattern.impl.GraphpatternPackageImpl#getEIterator()
		 * @generated
		 */
		EDataType EITERATOR = eINSTANCE.getEIterator();

	}

} //GraphpatternPackage
