/**
 */
package org.sidiff.consistency.graphpattern;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.sidiff.consistency.graphpattern.GraphpatternPackage
 * @generated
 */
public interface GraphpatternFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	GraphpatternFactory eINSTANCE = org.sidiff.consistency.graphpattern.impl.GraphpatternFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Graph Pattern</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Graph Pattern</em>'.
	 * @generated
	 */
	GraphPattern createGraphPattern();

	/**
	 * Returns a new object of class '<em>Node Pattern</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Node Pattern</em>'.
	 * @generated
	 */
	NodePattern createNodePattern();

	/**
	 * Returns a new object of class '<em>Edge Pattern</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Edge Pattern</em>'.
	 * @generated
	 */
	EdgePattern createEdgePattern();

	/**
	 * Returns a new object of class '<em>Attribute Pattern</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Attribute Pattern</em>'.
	 * @generated
	 */
	AttributePattern createAttributePattern();

	/**
	 * Returns a new object of class '<em>Evaluation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Evaluation</em>'.
	 * @generated
	 */
	Evaluation createEvaluation();

	/**
	 * Returns a new object of class '<em>Rule Base</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Rule Base</em>'.
	 * @generated
	 */
	RuleBase createRuleBase();

	/**
	 * Returns a new object of class '<em>EObject List</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>EObject List</em>'.
	 * @generated
	 */
	EObjectList createEObjectList();

	/**
	 * Returns a new object of class '<em>Node Pattern Dependency</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Node Pattern Dependency</em>'.
	 * @generated
	 */
	NodePatternDependency createNodePatternDependency();

	/**
	 * Returns a new object of class '<em>Dependency Conjunction</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Dependency Conjunction</em>'.
	 * @generated
	 */
	DependencyConjunction createDependencyConjunction();

	/**
	 * Returns a new object of class '<em>Dependency Graph</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Dependency Graph</em>'.
	 * @generated
	 */
	DependencyGraph createDependencyGraph();

	/**
	 * Returns a new object of class '<em>Pattern</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Pattern</em>'.
	 * @generated
	 */
	Pattern createPattern();

	/**
	 * Returns a new object of class '<em>Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Parameter</em>'.
	 * @generated
	 */
	Parameter createParameter();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	GraphpatternPackage getGraphpatternPackage();

} //GraphpatternFactory
