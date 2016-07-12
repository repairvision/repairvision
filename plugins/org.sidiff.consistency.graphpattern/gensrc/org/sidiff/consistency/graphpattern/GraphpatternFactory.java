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
	 * Returns a new object of class '<em>And</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>And</em>'.
	 * @generated
	 */
	And createAnd();

	/**
	 * Returns a new object of class '<em>Or</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Or</em>'.
	 * @generated
	 */
	Or createOr();

	/**
	 * Returns a new object of class '<em>Iff</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Iff</em>'.
	 * @generated
	 */
	Iff createIff();

	/**
	 * Returns a new object of class '<em>If</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>If</em>'.
	 * @generated
	 */
	If createIf();

	/**
	 * Returns a new object of class '<em>Not</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Not</em>'.
	 * @generated
	 */
	Not createNot();

	/**
	 * Returns a new object of class '<em>For All</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>For All</em>'.
	 * @generated
	 */
	ForAll createForAll();

	/**
	 * Returns a new object of class '<em>Exists</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Exists</em>'.
	 * @generated
	 */
	Exists createExists();

	/**
	 * Returns a new object of class '<em>Graph Formula</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Graph Formula</em>'.
	 * @generated
	 */
	GraphFormula createGraphFormula();

	/**
	 * Returns a new object of class '<em>EObject List</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>EObject List</em>'.
	 * @generated
	 */
	EObjectList createEObjectList();

	/**
	 * Returns a new object of class '<em>Xor</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Xor</em>'.
	 * @generated
	 */
	Xor createXor();

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
