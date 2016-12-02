/**
 */
package org.sidiff.graphpattern;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Dependency</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.graphpattern.Dependency#getSuccessor <em>Successor</em>}</li>
 *   <li>{@link org.sidiff.graphpattern.Dependency#getPredecessor <em>Predecessor</em>}</li>
 *   <li>{@link org.sidiff.graphpattern.Dependency#getGraph <em>Graph</em>}</li>
 * </ul>
 *
 * @see org.sidiff.graphpattern.GraphpatternPackage#getDependency()
 * @model abstract="true"
 * @generated
 */
public interface Dependency extends EObject {
	/**
	 * Returns the value of the '<em><b>Successor</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.sidiff.graphpattern.Dependency#getPredecessor <em>Predecessor</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Successor</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Successor</em>' reference.
	 * @see #setSuccessor(Dependency)
	 * @see org.sidiff.graphpattern.GraphpatternPackage#getDependency_Successor()
	 * @see org.sidiff.graphpattern.Dependency#getPredecessor
	 * @model opposite="predecessor"
	 * @generated
	 */
	Dependency getSuccessor();

	/**
	 * Sets the value of the '{@link org.sidiff.graphpattern.Dependency#getSuccessor <em>Successor</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Successor</em>' reference.
	 * @see #getSuccessor()
	 * @generated
	 */
	void setSuccessor(Dependency value);

	/**
	 * Returns the value of the '<em><b>Predecessor</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.sidiff.graphpattern.Dependency#getSuccessor <em>Successor</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Predecessor</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Predecessor</em>' reference.
	 * @see #setPredecessor(Dependency)
	 * @see org.sidiff.graphpattern.GraphpatternPackage#getDependency_Predecessor()
	 * @see org.sidiff.graphpattern.Dependency#getSuccessor
	 * @model opposite="successor"
	 * @generated
	 */
	Dependency getPredecessor();

	/**
	 * Sets the value of the '{@link org.sidiff.graphpattern.Dependency#getPredecessor <em>Predecessor</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Predecessor</em>' reference.
	 * @see #getPredecessor()
	 * @generated
	 */
	void setPredecessor(Dependency value);

	/**
	 * Returns the value of the '<em><b>Graph</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.sidiff.graphpattern.DependencyGraph#getNodes <em>Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Graph</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Graph</em>' container reference.
	 * @see #setGraph(DependencyGraph)
	 * @see org.sidiff.graphpattern.GraphpatternPackage#getDependency_Graph()
	 * @see org.sidiff.graphpattern.DependencyGraph#getNodes
	 * @model opposite="nodes" transient="false"
	 * @generated
	 */
	DependencyGraph getGraph();

	/**
	 * Sets the value of the '{@link org.sidiff.graphpattern.Dependency#getGraph <em>Graph</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Graph</em>' container reference.
	 * @see #getGraph()
	 * @generated
	 */
	void setGraph(DependencyGraph value);

} // Dependency
