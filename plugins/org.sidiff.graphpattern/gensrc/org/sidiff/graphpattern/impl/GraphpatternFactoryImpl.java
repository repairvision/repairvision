/**
 */
package org.sidiff.graphpattern.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.sidiff.graphpattern.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class GraphpatternFactoryImpl extends EFactoryImpl implements GraphpatternFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static GraphpatternFactory init() {
		try {
			GraphpatternFactory theGraphpatternFactory = (GraphpatternFactory)EPackage.Registry.INSTANCE.getEFactory(GraphpatternPackage.eNS_URI);
			if (theGraphpatternFactory != null) {
				return theGraphpatternFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new GraphpatternFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GraphpatternFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case GraphpatternPackage.GRAPH_PATTERN: return createGraphPattern();
			case GraphpatternPackage.NODE_PATTERN: return createNodePattern();
			case GraphpatternPackage.EDGE_PATTERN: return createEdgePattern();
			case GraphpatternPackage.ATTRIBUTE_PATTERN: return createAttributePattern();
			case GraphpatternPackage.EVALUATION: return createEvaluation();
			case GraphpatternPackage.RULE_BASE: return createRuleBase();
			case GraphpatternPackage.PATTERN: return createPattern();
			case GraphpatternPackage.PARAMETER: return createParameter();
			case GraphpatternPackage.EOBJECT_LIST: return createEObjectList();
			case GraphpatternPackage.NODE_PATTERN_DEPENDENCY: return createNodePatternDependency();
			case GraphpatternPackage.DEPENDENCY_GRAPH: return createDependencyGraph();
			case GraphpatternPackage.DEPENDENCY_EDGE: return createDependencyEdge();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GraphPattern createGraphPattern() {
		GraphPatternImpl graphPattern = new GraphPatternImpl();
		return graphPattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NodePattern createNodePattern() {
		NodePatternImpl nodePattern = new NodePatternImpl();
		return nodePattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EdgePattern createEdgePattern() {
		EdgePatternImpl edgePattern = new EdgePatternImpl();
		return edgePattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AttributePattern createAttributePattern() {
		AttributePatternImpl attributePattern = new AttributePatternImpl();
		return attributePattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Evaluation createEvaluation() {
		EvaluationImpl evaluation = new EvaluationImpl();
		return evaluation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RuleBase createRuleBase() {
		RuleBaseImpl ruleBase = new RuleBaseImpl();
		return ruleBase;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObjectList createEObjectList() {
		EObjectListImpl eObjectList = new EObjectListImpl();
		return eObjectList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NodePatternDependency createNodePatternDependency() {
		NodePatternDependencyImpl nodePatternDependency = new NodePatternDependencyImpl();
		return nodePatternDependency;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DependencyGraph createDependencyGraph() {
		DependencyGraphImpl dependencyGraph = new DependencyGraphImpl();
		return dependencyGraph;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DependencyEdge createDependencyEdge() {
		DependencyEdgeImpl dependencyEdge = new DependencyEdgeImpl();
		return dependencyEdge;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Pattern createPattern() {
		PatternImpl pattern = new PatternImpl();
		return pattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Parameter createParameter() {
		ParameterImpl parameter = new ParameterImpl();
		return parameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GraphpatternPackage getGraphpatternPackage() {
		return (GraphpatternPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static GraphpatternPackage getPackage() {
		return GraphpatternPackage.eINSTANCE;
	}

} //GraphpatternFactoryImpl
