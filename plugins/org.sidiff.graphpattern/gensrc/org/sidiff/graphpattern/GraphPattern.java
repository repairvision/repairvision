/**
 */
package org.sidiff.graphpattern;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Graph Pattern</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.graphpattern.GraphPattern#getNodes <em>Nodes</em>}</li>
 *   <li>{@link org.sidiff.graphpattern.GraphPattern#getPattern <em>Pattern</em>}</li>
 *   <li>{@link org.sidiff.graphpattern.GraphPattern#isMulti <em>Multi</em>}</li>
 *   <li>{@link org.sidiff.graphpattern.GraphPattern#getDependencyGraph <em>Dependency Graph</em>}</li>
 * </ul>
 *
 * @see org.sidiff.graphpattern.GraphpatternPackage#getGraphPattern()
 * @model
 * @generated
 */
public interface GraphPattern extends GraphPatternElement {
	/**
	 * Returns the value of the '<em><b>Nodes</b></em>' containment reference list.
	 * The list contents are of type {@link org.sidiff.graphpattern.NodePattern}.
	 * It is bidirectional and its opposite is '{@link org.sidiff.graphpattern.NodePattern#getGraph <em>Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nodes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nodes</em>' containment reference list.
	 * @see org.sidiff.graphpattern.GraphpatternPackage#getGraphPattern_Nodes()
	 * @see org.sidiff.graphpattern.NodePattern#getGraph
	 * @model opposite="graph" containment="true"
	 * @generated
	 */
	EList<NodePattern> getNodes();

	/**
	 * Returns the value of the '<em><b>Pattern</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.sidiff.graphpattern.Pattern#getGraphs <em>Graphs</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pattern</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pattern</em>' container reference.
	 * @see #setPattern(Pattern)
	 * @see org.sidiff.graphpattern.GraphpatternPackage#getGraphPattern_Pattern()
	 * @see org.sidiff.graphpattern.Pattern#getGraphs
	 * @model opposite="graphs" required="true" transient="false"
	 * @generated
	 */
	Pattern getPattern();

	/**
	 * Sets the value of the '{@link org.sidiff.graphpattern.GraphPattern#getPattern <em>Pattern</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pattern</em>' container reference.
	 * @see #getPattern()
	 * @generated
	 */
	void setPattern(Pattern value);

	/**
	 * Returns the value of the '<em><b>Multi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Multi</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Multi</em>' attribute.
	 * @see #setMulti(boolean)
	 * @see org.sidiff.graphpattern.GraphpatternPackage#getGraphPattern_Multi()
	 * @model
	 * @generated
	 */
	boolean isMulti();

	/**
	 * Sets the value of the '{@link org.sidiff.graphpattern.GraphPattern#isMulti <em>Multi</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Multi</em>' attribute.
	 * @see #isMulti()
	 * @generated
	 */
	void setMulti(boolean value);

	/**
	 * Returns the value of the '<em><b>Dependency Graph</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link org.sidiff.graphpattern.DependencyGraph#getGraph <em>Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dependency Graph</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dependency Graph</em>' containment reference.
	 * @see #setDependencyGraph(DependencyGraph)
	 * @see org.sidiff.graphpattern.GraphpatternPackage#getGraphPattern_DependencyGraph()
	 * @see org.sidiff.graphpattern.DependencyGraph#getGraph
	 * @model opposite="graph" containment="true"
	 * @generated
	 */
	DependencyGraph getDependencyGraph();

	/**
	 * Sets the value of the '{@link org.sidiff.graphpattern.GraphPattern#getDependencyGraph <em>Dependency Graph</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dependency Graph</em>' containment reference.
	 * @see #getDependencyGraph()
	 * @generated
	 */
	void setDependencyGraph(DependencyGraph value);

} // GraphPattern
