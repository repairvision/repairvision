/**
 */
package org.sidiff.consistency.graphpattern.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.sidiff.consistency.graphpattern.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.sidiff.consistency.graphpattern.GraphpatternPackage
 * @generated
 */
public class GraphpatternAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static GraphpatternPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GraphpatternAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = GraphpatternPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GraphpatternSwitch<Adapter> modelSwitch =
		new GraphpatternSwitch<Adapter>() {
			@Override
			public Adapter caseGraphPattern(GraphPattern object) {
				return createGraphPatternAdapter();
			}
			@Override
			public Adapter caseNodePattern(NodePattern object) {
				return createNodePatternAdapter();
			}
			@Override
			public Adapter caseEdgePattern(EdgePattern object) {
				return createEdgePatternAdapter();
			}
			@Override
			public Adapter caseAttributePattern(AttributePattern object) {
				return createAttributePatternAdapter();
			}
			@Override
			public Adapter caseEvaluation(Evaluation object) {
				return createEvaluationAdapter();
			}
			@Override
			public Adapter caseVisitor(Visitor object) {
				return createVisitorAdapter();
			}
			@Override
			public Adapter caseDataStore(DataStore object) {
				return createDataStoreAdapter();
			}
			@Override
			public Adapter caseNavigableDataStore(NavigableDataStore object) {
				return createNavigableDataStoreAdapter();
			}
			@Override
			public Adapter caseUnaryFormula(UnaryFormula object) {
				return createUnaryFormulaAdapter();
			}
			@Override
			public Adapter caseRuleBase(RuleBase object) {
				return createRuleBaseAdapter();
			}
			@Override
			public Adapter caseFormula(Formula object) {
				return createFormulaAdapter();
			}
			@Override
			public Adapter caseBinaryFormula(BinaryFormula object) {
				return createBinaryFormulaAdapter();
			}
			@Override
			public Adapter caseAnd(And object) {
				return createAndAdapter();
			}
			@Override
			public Adapter caseOr(Or object) {
				return createOrAdapter();
			}
			@Override
			public Adapter caseIff(Iff object) {
				return createIffAdapter();
			}
			@Override
			public Adapter caseIf(If object) {
				return createIfAdapter();
			}
			@Override
			public Adapter caseNot(Not object) {
				return createNotAdapter();
			}
			@Override
			public Adapter caseQuantifier(Quantifier object) {
				return createQuantifierAdapter();
			}
			@Override
			public Adapter caseXor(Xor object) {
				return createXorAdapter();
			}
			@Override
			public Adapter casePattern(Pattern object) {
				return createPatternAdapter();
			}
			@Override
			public Adapter caseGraphPatternElement(GraphPatternElement object) {
				return createGraphPatternElementAdapter();
			}
			@Override
			public Adapter caseParameter(Parameter object) {
				return createParameterAdapter();
			}
			@Override
			public Adapter caseForAll(ForAll object) {
				return createForAllAdapter();
			}
			@Override
			public Adapter caseExists(Exists object) {
				return createExistsAdapter();
			}
			@Override
			public Adapter caseGraphFormula(GraphFormula object) {
				return createGraphFormulaAdapter();
			}
			@Override
			public Adapter caseEObjectList(EObjectList object) {
				return createEObjectListAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link org.sidiff.consistency.graphpattern.GraphPattern <em>Graph Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sidiff.consistency.graphpattern.GraphPattern
	 * @generated
	 */
	public Adapter createGraphPatternAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sidiff.consistency.graphpattern.NodePattern <em>Node Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sidiff.consistency.graphpattern.NodePattern
	 * @generated
	 */
	public Adapter createNodePatternAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sidiff.consistency.graphpattern.EdgePattern <em>Edge Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sidiff.consistency.graphpattern.EdgePattern
	 * @generated
	 */
	public Adapter createEdgePatternAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sidiff.consistency.graphpattern.AttributePattern <em>Attribute Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sidiff.consistency.graphpattern.AttributePattern
	 * @generated
	 */
	public Adapter createAttributePatternAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sidiff.consistency.graphpattern.Evaluation <em>Evaluation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sidiff.consistency.graphpattern.Evaluation
	 * @generated
	 */
	public Adapter createEvaluationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sidiff.consistency.graphpattern.Visitor <em>Visitor</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sidiff.consistency.graphpattern.Visitor
	 * @generated
	 */
	public Adapter createVisitorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sidiff.consistency.graphpattern.DataStore <em>Data Store</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sidiff.consistency.graphpattern.DataStore
	 * @generated
	 */
	public Adapter createDataStoreAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sidiff.consistency.graphpattern.NavigableDataStore <em>Navigable Data Store</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sidiff.consistency.graphpattern.NavigableDataStore
	 * @generated
	 */
	public Adapter createNavigableDataStoreAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sidiff.consistency.graphpattern.UnaryFormula <em>Unary Formula</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sidiff.consistency.graphpattern.UnaryFormula
	 * @generated
	 */
	public Adapter createUnaryFormulaAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sidiff.consistency.graphpattern.RuleBase <em>Rule Base</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sidiff.consistency.graphpattern.RuleBase
	 * @generated
	 */
	public Adapter createRuleBaseAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sidiff.consistency.graphpattern.Formula <em>Formula</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sidiff.consistency.graphpattern.Formula
	 * @generated
	 */
	public Adapter createFormulaAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sidiff.consistency.graphpattern.BinaryFormula <em>Binary Formula</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sidiff.consistency.graphpattern.BinaryFormula
	 * @generated
	 */
	public Adapter createBinaryFormulaAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sidiff.consistency.graphpattern.And <em>And</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sidiff.consistency.graphpattern.And
	 * @generated
	 */
	public Adapter createAndAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sidiff.consistency.graphpattern.Or <em>Or</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sidiff.consistency.graphpattern.Or
	 * @generated
	 */
	public Adapter createOrAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sidiff.consistency.graphpattern.Iff <em>Iff</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sidiff.consistency.graphpattern.Iff
	 * @generated
	 */
	public Adapter createIffAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sidiff.consistency.graphpattern.If <em>If</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sidiff.consistency.graphpattern.If
	 * @generated
	 */
	public Adapter createIfAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sidiff.consistency.graphpattern.Not <em>Not</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sidiff.consistency.graphpattern.Not
	 * @generated
	 */
	public Adapter createNotAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sidiff.consistency.graphpattern.Quantifier <em>Quantifier</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sidiff.consistency.graphpattern.Quantifier
	 * @generated
	 */
	public Adapter createQuantifierAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sidiff.consistency.graphpattern.ForAll <em>For All</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sidiff.consistency.graphpattern.ForAll
	 * @generated
	 */
	public Adapter createForAllAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sidiff.consistency.graphpattern.Exists <em>Exists</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sidiff.consistency.graphpattern.Exists
	 * @generated
	 */
	public Adapter createExistsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sidiff.consistency.graphpattern.GraphFormula <em>Graph Formula</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sidiff.consistency.graphpattern.GraphFormula
	 * @generated
	 */
	public Adapter createGraphFormulaAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sidiff.consistency.graphpattern.EObjectList <em>EObject List</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sidiff.consistency.graphpattern.EObjectList
	 * @generated
	 */
	public Adapter createEObjectListAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sidiff.consistency.graphpattern.Xor <em>Xor</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sidiff.consistency.graphpattern.Xor
	 * @generated
	 */
	public Adapter createXorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sidiff.consistency.graphpattern.Pattern <em>Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sidiff.consistency.graphpattern.Pattern
	 * @generated
	 */
	public Adapter createPatternAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sidiff.consistency.graphpattern.GraphPatternElement <em>Graph Pattern Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sidiff.consistency.graphpattern.GraphPatternElement
	 * @generated
	 */
	public Adapter createGraphPatternElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sidiff.consistency.graphpattern.Parameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sidiff.consistency.graphpattern.Parameter
	 * @generated
	 */
	public Adapter createParameterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //GraphpatternAdapterFactory
