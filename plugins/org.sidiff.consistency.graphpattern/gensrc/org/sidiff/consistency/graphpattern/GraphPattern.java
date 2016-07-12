/**
 */
package org.sidiff.consistency.graphpattern;

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
 *   <li>{@link org.sidiff.consistency.graphpattern.GraphPattern#getNodes <em>Nodes</em>}</li>
 *   <li>{@link org.sidiff.consistency.graphpattern.GraphPattern#getPattern <em>Pattern</em>}</li>
 *   <li>{@link org.sidiff.consistency.graphpattern.GraphPattern#isMulti <em>Multi</em>}</li>
 * </ul>
 *
 * @see org.sidiff.consistency.graphpattern.GraphpatternPackage#getGraphPattern()
 * @model
 * @generated
 */
public interface GraphPattern extends GraphPatternElement {
	/**
	 * Returns the value of the '<em><b>Nodes</b></em>' containment reference list.
	 * The list contents are of type {@link org.sidiff.consistency.graphpattern.NodePattern}.
	 * It is bidirectional and its opposite is '{@link org.sidiff.consistency.graphpattern.NodePattern#getGraph <em>Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nodes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nodes</em>' containment reference list.
	 * @see org.sidiff.consistency.graphpattern.GraphpatternPackage#getGraphPattern_Nodes()
	 * @see org.sidiff.consistency.graphpattern.NodePattern#getGraph
	 * @model opposite="graph" containment="true"
	 * @generated
	 */
	EList<NodePattern> getNodes();

	/**
	 * Returns the value of the '<em><b>Pattern</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.sidiff.consistency.graphpattern.Pattern#getGraphs <em>Graphs</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pattern</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pattern</em>' container reference.
	 * @see #setPattern(Pattern)
	 * @see org.sidiff.consistency.graphpattern.GraphpatternPackage#getGraphPattern_Pattern()
	 * @see org.sidiff.consistency.graphpattern.Pattern#getGraphs
	 * @model opposite="graphs" required="true" transient="false"
	 * @generated
	 */
	Pattern getPattern();

	/**
	 * Sets the value of the '{@link org.sidiff.consistency.graphpattern.GraphPattern#getPattern <em>Pattern</em>}' container reference.
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
	 * @see org.sidiff.consistency.graphpattern.GraphpatternPackage#getGraphPattern_Multi()
	 * @model
	 * @generated
	 */
	boolean isMulti();

	/**
	 * Sets the value of the '{@link org.sidiff.consistency.graphpattern.GraphPattern#isMulti <em>Multi</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Multi</em>' attribute.
	 * @see #isMulti()
	 * @generated
	 */
	void setMulti(boolean value);

} // GraphPattern
