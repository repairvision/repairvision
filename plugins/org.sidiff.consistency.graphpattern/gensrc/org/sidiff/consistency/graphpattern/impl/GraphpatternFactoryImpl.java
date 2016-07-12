/**
 */
package org.sidiff.consistency.graphpattern.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.sidiff.consistency.graphpattern.*;

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
			case GraphpatternPackage.AND: return createAnd();
			case GraphpatternPackage.OR: return createOr();
			case GraphpatternPackage.IFF: return createIff();
			case GraphpatternPackage.IF: return createIf();
			case GraphpatternPackage.NOT: return createNot();
			case GraphpatternPackage.XOR: return createXor();
			case GraphpatternPackage.PATTERN: return createPattern();
			case GraphpatternPackage.PARAMETER: return createParameter();
			case GraphpatternPackage.FOR_ALL: return createForAll();
			case GraphpatternPackage.EXISTS: return createExists();
			case GraphpatternPackage.GRAPH_FORMULA: return createGraphFormula();
			case GraphpatternPackage.EOBJECT_LIST: return createEObjectList();
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
	public And createAnd() {
		AndImpl and = new AndImpl();
		return and;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Or createOr() {
		OrImpl or = new OrImpl();
		return or;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Iff createIff() {
		IffImpl iff = new IffImpl();
		return iff;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public If createIf() {
		IfImpl if_ = new IfImpl();
		return if_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Not createNot() {
		NotImpl not = new NotImpl();
		return not;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ForAll createForAll() {
		ForAllImpl forAll = new ForAllImpl();
		return forAll;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Exists createExists() {
		ExistsImpl exists = new ExistsImpl();
		return exists;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GraphFormula createGraphFormula() {
		GraphFormulaImpl graphFormula = new GraphFormulaImpl();
		return graphFormula;
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
	public Xor createXor() {
		XorImpl xor = new XorImpl();
		return xor;
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
