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
 *   <li>{@link org.sidiff.graphpattern.Pattern#getPatterns <em>Patterns</em>}</li>
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
	 * Returns the value of the '<em><b>Bundle</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bundle</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bundle</em>' reference.
	 * @see org.sidiff.graphpattern.GraphpatternPackage#getPattern_Bundle()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	Bundle getBundle();

	/**
	 * Returns the value of the '<em><b>Patterns</b></em>' containment reference list.
	 * The list contents are of type {@link org.sidiff.graphpattern.Pattern}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Patterns</em>' containment reference list.
	 * @see org.sidiff.graphpattern.GraphpatternPackage#getPattern_Patterns()
	 * @model containment="true"
	 * @generated
	 */
	EList<Pattern> getPatterns();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	Pattern getPattern(String name);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	EList<GraphPattern> getAllGraphPatterns();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	GraphPattern getGraph(String name);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	Parameter getParameter(String name);

} // Pattern
