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
 *   <li>{@link org.sidiff.graphpattern.DependencyGraph#getFirst <em>First</em>}</li>
 *   <li>{@link org.sidiff.graphpattern.DependencyGraph#getLast <em>Last</em>}</li>
 *   <li>{@link org.sidiff.graphpattern.DependencyGraph#getGraph <em>Graph</em>}</li>
 *   <li>{@link org.sidiff.graphpattern.DependencyGraph#getNodes <em>Nodes</em>}</li>
 * </ul>
 *
 * @see org.sidiff.graphpattern.GraphpatternPackage#getDependencyGraph()
 * @model
 * @generated
 */
public interface DependencyGraph extends EObject {
	/**
	 * Returns the value of the '<em><b>First</b></em>' reference list.
	 * The list contents are of type {@link org.sidiff.graphpattern.Dependency}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>First</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>First</em>' reference list.
	 * @see org.sidiff.graphpattern.GraphpatternPackage#getDependencyGraph_First()
	 * @model
	 * @generated
	 */
	EList<Dependency> getFirst();

	/**
	 * Returns the value of the '<em><b>Last</b></em>' reference list.
	 * The list contents are of type {@link org.sidiff.graphpattern.Dependency}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Last</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Last</em>' reference list.
	 * @see org.sidiff.graphpattern.GraphpatternPackage#getDependencyGraph_Last()
	 * @model
	 * @generated
	 */
	EList<Dependency> getLast();

	/**
	 * Returns the value of the '<em><b>Graph</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.sidiff.graphpattern.GraphPattern#getDependencies <em>Dependencies</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Graph</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Graph</em>' container reference.
	 * @see #setGraph(GraphPattern)
	 * @see org.sidiff.graphpattern.GraphpatternPackage#getDependencyGraph_Graph()
	 * @see org.sidiff.graphpattern.GraphPattern#getDependencies
	 * @model opposite="dependencies" transient="false"
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
	 * The list contents are of type {@link org.sidiff.graphpattern.Dependency}.
	 * It is bidirectional and its opposite is '{@link org.sidiff.graphpattern.Dependency#getGraph <em>Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nodes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nodes</em>' containment reference list.
	 * @see org.sidiff.graphpattern.GraphpatternPackage#getDependencyGraph_Nodes()
	 * @see org.sidiff.graphpattern.Dependency#getGraph
	 * @model opposite="graph" containment="true"
	 * @generated
	 */
	EList<Dependency> getNodes();

} // DependencyGraph
