/**
 */
package org.sidiff.graphpattern;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sub Graph</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.graphpattern.SubGraph#getElements <em>Elements</em>}</li>
 *   <li>{@link org.sidiff.graphpattern.SubGraph#getSubgraphs <em>Subgraphs</em>}</li>
 * </ul>
 *
 * @see org.sidiff.graphpattern.GraphpatternPackage#getSubGraph()
 * @model
 * @generated
 */
public interface SubGraph extends PatternElement {
	/**
	 * Returns the value of the '<em><b>Elements</b></em>' reference list.
	 * The list contents are of type {@link org.sidiff.graphpattern.GraphElement}.
	 * It is bidirectional and its opposite is '{@link org.sidiff.graphpattern.GraphElement#getSubgraphs <em>Subgraphs</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Elements</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Elements</em>' reference list.
	 * @see org.sidiff.graphpattern.GraphpatternPackage#getSubGraph_Elements()
	 * @see org.sidiff.graphpattern.GraphElement#getSubgraphs
	 * @model opposite="subgraphs"
	 * @generated
	 */
	EList<GraphElement> getElements();

	/**
	 * Returns the value of the '<em><b>Subgraphs</b></em>' containment reference list.
	 * The list contents are of type {@link org.sidiff.graphpattern.SubGraph}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Subgraphs</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Subgraphs</em>' containment reference list.
	 * @see org.sidiff.graphpattern.GraphpatternPackage#getSubGraph_Subgraphs()
	 * @model containment="true"
	 * @generated
	 */
	EList<SubGraph> getSubgraphs();

} // SubGraph
