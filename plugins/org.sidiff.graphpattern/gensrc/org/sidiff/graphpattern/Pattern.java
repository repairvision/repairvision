/**
 */
package org.sidiff.graphpattern;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Pattern</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.graphpattern.Pattern#getGraphs <em>Graphs</em>}</li>
 *   <li>{@link org.sidiff.graphpattern.Pattern#getParameters <em>Parameters</em>}</li>
 *   <li>{@link org.sidiff.graphpattern.Pattern#getAssignments <em>Assignments</em>}</li>
 *   <li>{@link org.sidiff.graphpattern.Pattern#getBundle <em>Bundle</em>}</li>
 * </ul>
 *
 * @see org.sidiff.graphpattern.GraphpatternPackage#getPattern()
 * @model
 * @generated
 */
public interface Pattern extends PatternElement {
	/**
	 * Returns the value of the '<em><b>Graphs</b></em>' containment reference list.
	 * The list contents are of type {@link org.sidiff.graphpattern.GraphPattern}.
	 * It is bidirectional and its opposite is '{@link org.sidiff.graphpattern.GraphPattern#getPattern <em>Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Graphs</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Graphs</em>' containment reference list.
	 * @see org.sidiff.graphpattern.GraphpatternPackage#getPattern_Graphs()
	 * @see org.sidiff.graphpattern.GraphPattern#getPattern
	 * @model opposite="pattern" containment="true"
	 * @generated
	 */
	EList<GraphPattern> getGraphs();

	/**
	 * Returns the value of the '<em><b>Parameters</b></em>' containment reference list.
	 * The list contents are of type {@link org.sidiff.graphpattern.Parameter}.
	 * It is bidirectional and its opposite is '{@link org.sidiff.graphpattern.Parameter#getPattern <em>Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameters</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameters</em>' containment reference list.
	 * @see org.sidiff.graphpattern.GraphpatternPackage#getPattern_Parameters()
	 * @see org.sidiff.graphpattern.Parameter#getPattern
	 * @model opposite="pattern" containment="true"
	 * @generated
	 */
	EList<Parameter> getParameters();

	/**
	 * Returns the value of the '<em><b>Assignments</b></em>' containment reference list.
	 * The list contents are of type {@link org.sidiff.graphpattern.Assignment}.
	 * It is bidirectional and its opposite is '{@link org.sidiff.graphpattern.Assignment#getPattern <em>Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Assignments</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Assignments</em>' containment reference list.
	 * @see org.sidiff.graphpattern.GraphpatternPackage#getPattern_Assignments()
	 * @see org.sidiff.graphpattern.Assignment#getPattern
	 * @model opposite="pattern" containment="true"
	 * @generated
	 */
	EList<Assignment> getAssignments();

	/**
	 * Returns the value of the '<em><b>Bundle</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.sidiff.graphpattern.Bundle#getPatterns <em>Patterns</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bundle</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bundle</em>' container reference.
	 * @see #setBundle(Bundle)
	 * @see org.sidiff.graphpattern.GraphpatternPackage#getPattern_Bundle()
	 * @see org.sidiff.graphpattern.Bundle#getPatterns
	 * @model opposite="patterns" transient="false"
	 * @generated
	 */
	Bundle getBundle();

	/**
	 * Sets the value of the '{@link org.sidiff.graphpattern.Pattern#getBundle <em>Bundle</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bundle</em>' container reference.
	 * @see #getBundle()
	 * @generated
	 */
	void setBundle(Bundle value);

} // Pattern
