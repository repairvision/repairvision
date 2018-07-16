/**
 */
package org.sidiff.graphpattern;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Graph Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.graphpattern.GraphElement#getSubgraph <em>Subgraph</em>}</li>
 *   <li>{@link org.sidiff.graphpattern.GraphElement#getGraph <em>Graph</em>}</li>
 * </ul>
 *
 * @see org.sidiff.graphpattern.GraphpatternPackage#getGraphElement()
 * @model abstract="true"
 * @generated
 */
public interface GraphElement extends PatternElement, Extendable {
	/**
	 * Returns the value of the '<em><b>Subgraph</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.sidiff.graphpattern.SubGraph#getElements <em>Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Subgraph</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Subgraph</em>' reference.
	 * @see #setSubgraph(SubGraph)
	 * @see org.sidiff.graphpattern.GraphpatternPackage#getGraphElement_Subgraph()
	 * @see org.sidiff.graphpattern.SubGraph#getElements
	 * @model opposite="elements"
	 * @generated
	 */
	SubGraph getSubgraph();

	/**
	 * Sets the value of the '{@link org.sidiff.graphpattern.GraphElement#getSubgraph <em>Subgraph</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Subgraph</em>' reference.
	 * @see #getSubgraph()
	 * @generated
	 */
	void setSubgraph(SubGraph value);

	/**
	 * Returns the value of the '<em><b>Graph</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Graph</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Graph</em>' reference.
	 * @see org.sidiff.graphpattern.GraphpatternPackage#getGraphElement_Graph()
	 * @model required="true" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	GraphPattern getGraph();

} // GraphElement
