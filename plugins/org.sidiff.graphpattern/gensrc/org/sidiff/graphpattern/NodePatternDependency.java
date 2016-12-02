/**
 */
package org.sidiff.graphpattern;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Node Pattern Dependency</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.graphpattern.NodePatternDependency#getNode <em>Node</em>}</li>
 * </ul>
 *
 * @see org.sidiff.graphpattern.GraphpatternPackage#getNodePatternDependency()
 * @model
 * @generated
 */
public interface NodePatternDependency extends Dependency {
	/**
	 * Returns the value of the '<em><b>Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Node</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Node</em>' reference.
	 * @see #setNode(NodePattern)
	 * @see org.sidiff.graphpattern.GraphpatternPackage#getNodePatternDependency_Node()
	 * @model
	 * @generated
	 */
	NodePattern getNode();

	/**
	 * Sets the value of the '{@link org.sidiff.graphpattern.NodePatternDependency#getNode <em>Node</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Node</em>' reference.
	 * @see #getNode()
	 * @generated
	 */
	void setNode(NodePattern value);

} // NodePatternDependency
