/**
 */
package org.sidiff.graphpattern;

import java.util.function.Predicate;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Graph Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.graphpattern.GraphElement#getSubgraphs <em>Subgraphs</em>}</li>
 *   <li>{@link org.sidiff.graphpattern.GraphElement#getGraph <em>Graph</em>}</li>
 * </ul>
 *
 * @see org.sidiff.graphpattern.GraphpatternPackage#getGraphElement()
 * @model abstract="true"
 * @generated
 */
public interface GraphElement extends PatternElement {
	/**
	 * Returns the value of the '<em><b>Subgraphs</b></em>' reference list.
	 * The list contents are of type {@link org.sidiff.graphpattern.SubGraph}.
	 * It is bidirectional and its opposite is '{@link org.sidiff.graphpattern.SubGraph#getElements <em>Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Subgraphs</em>' reference list.
	 * @see org.sidiff.graphpattern.GraphpatternPackage#getGraphElement_Subgraphs()
	 * @see org.sidiff.graphpattern.SubGraph#getElements
	 * @model opposite="elements"
	 * @generated
	 */
	EList<SubGraph> getSubgraphs();

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

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated not
	 */
	Iterable<GraphElement> getClosure(Predicate<GraphElement> condition);
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated not
	 */
	Iterable<? extends GraphElement> getConnected();

} // GraphElement
