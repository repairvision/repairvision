/**
 */
package org.sidiff.graphpattern;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Dependency Graph</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.graphpattern.DependencyGraph#getIndependent <em>Independent</em>}</li>
 *   <li>{@link org.sidiff.graphpattern.DependencyGraph#getGraph <em>Graph</em>}</li>
 *   <li>{@link org.sidiff.graphpattern.DependencyGraph#getNodes <em>Nodes</em>}</li>
 *   <li>{@link org.sidiff.graphpattern.DependencyGraph#getEdges <em>Edges</em>}</li>
 * </ul>
 *
 * @see org.sidiff.graphpattern.GraphpatternPackage#getDependencyGraph()
 * @model
 * @generated
 */
public interface DependencyGraph extends EObject {
	/**
	 * Returns the value of the '<em><b>Independent</b></em>' reference list.
	 * The list contents are of type {@link org.sidiff.graphpattern.DependencyNode}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Independent</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Independent</em>' reference list.
	 * @see org.sidiff.graphpattern.GraphpatternPackage#getDependencyGraph_Independent()
	 * @model
	 * @generated
	 */
	EList<DependencyNode> getIndependent();

	/**
	 * Returns the value of the '<em><b>Graph</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.sidiff.graphpattern.GraphPattern#getDependencyGraph <em>Dependency Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Graph</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Graph</em>' container reference.
	 * @see #setGraph(GraphPattern)
	 * @see org.sidiff.graphpattern.GraphpatternPackage#getDependencyGraph_Graph()
	 * @see org.sidiff.graphpattern.GraphPattern#getDependencyGraph
	 * @model opposite="dependencyGraph" transient="false"
	 * @generated
	 */
	GraphPattern getGraph();

	/**
	 * Sets the value of the '{@link org.sidiff.graphpattern.DependencyGraph#getGraph <em>Graph</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Graph</em>' container reference.
	 * @see #getGraph()
	 * @generated
	 */
	void setGraph(GraphPattern value);

	/**
	 * Returns the value of the '<em><b>Nodes</b></em>' containment reference list.
	 * The list contents are of type {@link org.sidiff.graphpattern.DependencyNode}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nodes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nodes</em>' containment reference list.
	 * @see org.sidiff.graphpattern.GraphpatternPackage#getDependencyGraph_Nodes()
	 * @model containment="true"
	 * @generated
	 */
	EList<DependencyNode> getNodes();

	/**
	 * Returns the value of the '<em><b>Edges</b></em>' containment reference list.
	 * The list contents are of type {@link org.sidiff.graphpattern.DependencyEdge}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Edges</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Edges</em>' containment reference list.
	 * @see org.sidiff.graphpattern.GraphpatternPackage#getDependencyGraph_Edges()
	 * @model containment="true"
	 * @generated
	 */
	EList<DependencyEdge> getEdges();

} // DependencyGraph
