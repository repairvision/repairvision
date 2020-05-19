/**
 */
package org.sidiff.graphpattern;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.sidiff.graphpattern.GraphpatternPackage
 * @generated
 */
public interface GraphpatternFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	GraphpatternFactory eINSTANCE = org.sidiff.graphpattern.impl.GraphpatternFactoryImpl.init();

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
	 * Returns a new object of class '<em>Node Pattern</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Node Pattern</em>'.
	 * @generated NOT
	 */
	NodePattern createNodePattern(GraphPattern graph, String name, EClass type, Stereotype... stereotypes);

	/**
	 * Returns a new object of class '<em>Edge Pattern</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Edge Pattern</em>'.
	 * @generated
	 */
	EdgePattern createEdgePattern();
	
	/**
	 * Returns a new object of class '<em>Edge Pattern</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Edge Pattern</em>'.
	 * @generated NOT
	 */
	EdgePattern createEdgePattern(NodePattern source, EReference type, NodePattern target, Stereotype... stereotypes);

	/**
	 * Returns a new object of class '<em>Attribute Pattern</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Attribute Pattern</em>'.
	 * @generated
	 */
	AttributePattern createAttributePattern();
	
	/**
	 * Returns a new object of class '<em>Attribute Pattern</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Attribute Pattern</em>'.
	 * @generated NOT
	 */
	AttributePattern createAttributePattern(NodePattern node, EAttribute type, String value, Stereotype... stereotypes);

	/**
	 * Returns a new object of class '<em>Bundle</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Bundle</em>'.
	 * @generated
	 */
	Bundle createBundle();

	/**
	 * Returns a new object of class '<em>EObject List</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>EObject List</em>'.
	 * @generated
	 */
	EObjectList createEObjectList();

	/**
	 * Returns a new object of class '<em>Dependency Graph</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Dependency Graph</em>'.
	 * @generated
	 */
	DependencyGraph createDependencyGraph();

	/**
	 * Returns a new object of class '<em>Dependency Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Dependency Node</em>'.
	 * @generated
	 */
	DependencyNode createDependencyNode();

	/**
	 * Returns a new object of class '<em>Dependency Edge</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Dependency Edge</em>'.
	 * @generated
	 */
	DependencyEdge createDependencyEdge();

	/**
	 * Returns a new object of class '<em>Association</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Association</em>'.
	 * @generated
	 */
	Association createAssociation();

	/**
	 * Returns a new object of class '<em>Stereotype</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Stereotype</em>'.
	 * @generated
	 */
	Stereotype createStereotype();

	/**
	 * Returns a new object of class '<em>Assignment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Assignment</em>'.
	 * @generated
	 */
	Assignment createAssignment();

	/**
	 * Returns a new object of class '<em>Object Binding</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Object Binding</em>'.
	 * @generated
	 */
	ObjectBinding createObjectBinding();

	/**
	 * Returns a new object of class '<em>Value Binding</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Value Binding</em>'.
	 * @generated
	 */
	ValueBinding createValueBinding();

	/**
	 * Returns a new object of class '<em>Sub Graph</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sub Graph</em>'.
	 * @generated
	 */
	SubGraph createSubGraph();

	/**
	 * Returns a new object of class '<em>Profile</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Profile</em>'.
	 * @generated
	 */
	Profile createProfile();

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
