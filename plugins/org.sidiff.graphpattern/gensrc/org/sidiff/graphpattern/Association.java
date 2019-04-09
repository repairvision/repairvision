/**
 */
package org.sidiff.graphpattern;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Association</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.graphpattern.Association#getSource <em>Source</em>}</li>
 *   <li>{@link org.sidiff.graphpattern.Association#getTarget <em>Target</em>}</li>
 * </ul>
 *
 * @see org.sidiff.graphpattern.GraphpatternPackage#getAssociation()
 * @model
 * @generated
 */
public interface Association extends PatternElement {
	/**
	 * Returns the value of the '<em><b>Source</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.sidiff.graphpattern.NodePattern#getAssociations <em>Associations</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' container reference.
	 * @see #setSource(NodePattern)
	 * @see org.sidiff.graphpattern.GraphpatternPackage#getAssociation_Source()
	 * @see org.sidiff.graphpattern.NodePattern#getAssociations
	 * @model opposite="associations" required="true" transient="false"
	 * @generated
	 */
	NodePattern getSource();

	/**
	 * Sets the value of the '{@link org.sidiff.graphpattern.Association#getSource <em>Source</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' container reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(NodePattern value);

	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(GraphElement)
	 * @see org.sidiff.graphpattern.GraphpatternPackage#getAssociation_Target()
	 * @model required="true"
	 * @generated
	 */
	GraphElement getTarget();

	/**
	 * Sets the value of the '{@link org.sidiff.graphpattern.Association#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(GraphElement value);

} // Association
